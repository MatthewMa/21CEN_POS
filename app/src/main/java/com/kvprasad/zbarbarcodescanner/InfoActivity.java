package com.kvprasad.zbarbarcodescanner;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.matthew.model.Product;
import com.matthew.model.Supplier;
import com.matthew.tools.DialogTools;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;
import comulez.github.droplibrary.DropIndicator;
import comulez.github.droplibrary.DropViewPager;

public class InfoActivity extends AppCompatActivity implements SupplierFragment
        .OnFragmentInteractionListener, BasicInfoFragment.OnFragmentInteractionListener, UpdateInfoFragment.OnFragmentInteractionListener {

    private DropViewPager mViewPager;
    private DropIndicator circleIndicator;
    private FragmentPagerAdapter mAdapter;
    private ArrayList<Fragment> mTabContents = new ArrayList<>();
    private Product currentProduct;
    private String currentSupplierName;
    private Supplier currentSupplier;
    private ImageView iv_tax;
    private ImageView iv_promotion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        mViewPager = (DropViewPager) findViewById(R.id.mViewPager);
        circleIndicator = (DropIndicator) findViewById(R.id.circleIndicator);
        iv_tax = (ImageView) findViewById(R.id.iv_tax);
        iv_promotion = (ImageView) findViewById(R.id.iv_promotion);
        // Get intent data
        currentProduct = (Product) getIntent().getExtras().getSerializable(MainActivity
                .PRODUCT_NAME);
        currentSupplier = (Supplier) getIntent().getExtras().getSerializable(MainActivity.SUPPLIER);
        currentSupplierName = getIntent().getStringExtra(MainActivity.SUPPLIER_NAME);
        if(currentSupplierName.isEmpty()) {
            DialogTools.showSweetDialog(InfoActivity.this, SweetAlertDialog
                            .WARNING_TYPE,
                    "Empty Supplier",
                    "Supplier is empty!");
        }
        // Add back button
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mTabContents.add(BasicInfoFragment.newInstance(currentProduct, currentSupplierName));
        mTabContents.add(SupplierFragment.newInstance(currentSupplier));
        mTabContents.add(UpdateInfoFragment.newInstance(currentProduct));
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mTabContents.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mTabContents.get(position);
            }
        };

        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mAdapter);
        circleIndicator.setViewPager(mViewPager);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        // TODO:
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
