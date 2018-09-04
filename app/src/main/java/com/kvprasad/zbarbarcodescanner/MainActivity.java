package com.kvprasad.zbarbarcodescanner;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.matthew.model.Product;
import com.matthew.model.Supplier;
import com.matthew.tools.DialogTools;
import com.matthew.tools.GsonUtil;
import com.matthew.tools.HttpCallbackListener;
import com.matthew.tools.HttpUtil;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class MainActivity extends AppCompatActivity {
    private Button scannerButton;
    private Button submitButton;
    private EditText barCodeEditText;
    private String barCodeMessage = "";
    private static final int BAR_SCANNING_ACTIVITY = 2;
    private String supplierName = "";
    public static final String PRODUCT_NAME = "PRODUCT_NAME";
    public static final String SUPPLIER_NAME = "SUPPLIER_NAME";
    public static final String SUPPLIER = "SUPPLIER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scannerButton = (Button) findViewById(R.id.scannerButton);
        submitButton = (Button) findViewById(R.id.submitButton);
        barCodeEditText = (EditText) findViewById(R.id.barCodeEditText);
        scannerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), BarcodeScanner.class);
                startActivityForResult(intent,BAR_SCANNING_ACTIVITY);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String barCodeText = barCodeEditText.getText().toString().trim().toLowerCase();
                if(barCodeText.isEmpty()) {
                    // Show error dialog
                    DialogTools.showSweetDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE,
                            "Empty" +
                            " Bar Code", "Bar " +
                            "code" +
                            " cannot be empty!");
                    return;
                }
                // Show progress bar
                final SweetAlertDialog pDialog = DialogTools.showProgressAlertDialog(MainActivity
                        .this);

                String barCodeUrl = Constants.PRODUCT_URL + barCodeText;
                HttpUtil.getInstance().get(barCodeUrl, new HttpCallbackListener() {
                    @Override
                    public void onFinish(String response) {
                        if(response.contains("no row found")) {
                            // Show error dialog in UIThread
                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    DialogTools.showSweetDialog(MainActivity
                                                    .this, SweetAlertDialog
                                                    .ERROR_TYPE,
                                            "No Product", "Product is empty, please check " +
                                                    "bar code!");
                                    pDialog.dismiss();
                                }
                            });
                            return;
                        }
                        final Product product = GsonUtil.GsonToBean(response, Product.class);
                        String supplierId = product.getSUPPLIER();
                        if(supplierId.isEmpty()) {
                            Intent infoIntent = new Intent(MainActivity.this, InfoActivity
                                    .class);
                            Bundle infoBundle = new Bundle();
                            infoBundle.putSerializable(PRODUCT_NAME, product);
                            infoIntent.putExtras(infoBundle);
                            infoIntent.putExtra(SUPPLIER_NAME, "");
                            startActivity(infoIntent);
                            pDialog.dismiss();
                        } else {
                            String supplierUrl = Constants.SUPPLIER_URL + supplierId;
                            HttpUtil.getInstance().get(supplierUrl, new HttpCallbackListener() {
                                @Override
                                public void onFinish(String response) {
                                    Supplier supplier = GsonUtil.GsonToBean(response, Supplier
                                            .class);
                                    if (supplier != null) {
                                        supplierName = supplier.getSUPPLIERNAME();
                                    }
                                    Intent infoIntent = new Intent(MainActivity.this, InfoActivity
                                            .class);
                                    Bundle infoBundle = new Bundle();
                                    infoBundle.putSerializable(PRODUCT_NAME, product);
                                    infoBundle.putSerializable(SUPPLIER, supplier);
                                    infoIntent.putExtras(infoBundle);
                                    infoIntent.putExtra(SUPPLIER_NAME, supplierName);
                                    startActivity(infoIntent);
                                    pDialog.dismiss();
                                }

                                @Override
                                public void onError(Exception e) {
                                    super.onError(e);
                                    // Show error dialog in UIThread
                                    MainActivity.this.runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            DialogTools.showSweetDialog(MainActivity
                                                            .this, SweetAlertDialog
                                                            .ERROR_TYPE,
                                                    "Network error", "Network error, please try again later!");
                                            pDialog.dismiss();
                                        }
                                    });
                                }
                            });
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                        super.onError(e);
                        // Show error dialog in UIThread
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                DialogTools.showSweetDialog(MainActivity.this, SweetAlertDialog
                                                .ERROR_TYPE,
                                        "Network error",
                                        "Network error, please try again later!");
                                pDialog.dismiss();
                            }
                        });
                    }
                });

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if(id == R.id.action_logout) {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Log out")
                    .setContentText("Are you sure to log out?")
                    .setCancelText("Cancel")
                    .setConfirmText("Confirm")
                    .showCancelButton(true)
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            finish();
                        }
                    })
                    .show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == BAR_SCANNING_ACTIVITY) {
            if(resultCode == RESULT_OK) {
                barCodeMessage = data.getStringExtra(BarcodeScanner.EXTRA_BARCODE);
                barCodeEditText.setText(barCodeMessage);
            }
        }
    }
}
