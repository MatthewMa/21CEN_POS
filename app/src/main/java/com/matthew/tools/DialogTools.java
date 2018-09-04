package com.matthew.tools;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.widget.DatePicker;
import android.widget.TextView;

import com.kvprasad.zbarbarcodescanner.MainActivity;
import com.kvprasad.zbarbarcodescanner.UpdateInfoFragment;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Calendar;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class DialogTools {
    /**
     * Show Sweet Dialog
     * @param context
     * @param successType
     * @param textInfo
     * @param contentInfo
     */
    public static void showSweetDialog(Context context, int successType, String textInfo, String
            contentInfo) {
        new SweetAlertDialog(context, successType)
                .setTitleText(textInfo)
                .setContentText(contentInfo)
                .show();
    }

    /**
     * Show Sweet Cancel Dialog
     * @param context
     * @param successType
     * @param textInfo
     * @param contentInfo
     */
    public static void showSweetCancelDialog(Context context, int successType, String textInfo,
                                            String
            contentInfo) {
        new SweetAlertDialog(context, successType)
                .setTitleText(textInfo)
                .setContentText(contentInfo)
                .setCancelText("Cancel")
                .setConfirmText("Confirm")
                .showCancelButton(true)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {

                    }
                })
                .show();
    }

    /**
     * Date Picker Selector
     * @param activity
     * @param themeResId
     * @param met
     * @param calendar
     */
    public static void showDatePickerDialog(Activity activity, int themeResId, final
    MaterialEditText met,
                                            String date, Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        if(!date.isEmpty()) {
            String[] result = date.split("/");
            year = Integer.parseInt(result[0]);
            month = Integer.parseInt(result[1]) - 1;
            day = Integer.parseInt(result[2]);
        }
        // Create a new Date picker and show
        DatePickerDialog datePickerDialog = new DatePickerDialog(activity , themeResId,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Here getting the date
                String dateSelected = year + "/" + (monthOfYear+1)+ "/" + dayOfMonth;
                met.setText(dateSelected);

            }
        }
                // Set initial date
                , year
                ,month
                ,day);
        datePickerDialog.show();
        datePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                UpdateInfoFragment.dateDialogHasShown = false;
            }
        });
    }

    public static SweetAlertDialog showProgressAlertDialog(Context context) {
        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog
                .PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Loading");
        pDialog.setCancelable(false);
        pDialog.show();
        return pDialog;
    }
}
