package com.kvprasad.zbarbarcodescanner;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.matthew.model.Product;

import java.util.ArrayList;

import comulez.github.droplibrary.DropIndicator;
import comulez.github.droplibrary.DropViewPager;

public class InfoActivity extends AppCompatActivity implements TaxInfoFragment
        .OnFragmentInteractionListener, BasicInfoFragment.OnFragmentInteractionListener, PromotionInfoFragment.OnFragmentInteractionListener {

    private DropViewPager mViewPager;
    private DropIndicator circleIndicator;
    private FragmentPagerAdapter mAdapter;
    private ArrayList<Fragment> mTabContents = new ArrayList<>();
    private Product currentProduct;
    private String currentSupplierName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        mViewPager = (DropViewPager) findViewById(R.id.mViewPager);
        circleIndicator = (DropIndicator) findViewById(R.id.circleIndicator);
        // Get intent data
        currentProduct = (Product) getIntent().getExtras().getSerializable(MainActivity
                .PRODUCT_NAME);
        currentSupplierName = getIntent().getStringExtra(MainActivity.SUPPLIER_NAME);
        // Add back button
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mTabContents.add(BasicInfoFragment.newInstance(currentProduct, currentSupplierName));
        mTabContents.add(TaxInfoFragment.newInstance());
        mTabContents.add(PromotionInfoFragment.newInstance());

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
