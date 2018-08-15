package com.kvprasad.zbarbarcodescanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.matthew.customviews.SingleTitleView;
import com.matthew.model.Product;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BasicInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BasicInfoFragment extends Fragment {

    private Product currentProduct;
    private String currentSupplierName;
    private OnFragmentInteractionListener mListener;
    private static final String ARG_PRODUCT = "product";
    private static final String ARG_SUPPLIERNAME = "suppliername";
    private LinearLayout ll;

    public BasicInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentProduct = (Product) getArguments().getSerializable(ARG_PRODUCT);
            currentSupplierName = getArguments().getString(ARG_SUPPLIERNAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View basicInfoView = inflater.inflate(R.layout.fragment_basic_info, container, false);
        ll = (LinearLayout) basicInfoView.findViewById(R.id.ll);
        // Add table view
        // Bar Code
        addSingleTitleView("Bar Code", currentProduct.getCODE(),"");
        // Chinese description
        addSingleTitleView("Chinese Name", currentProduct.getALIAS(),"");
        // English description
        addSingleTitleView("English Name", currentProduct.getTEXTTIP(),"");
        // Inventory
        addSingleTitleView("Inventory", currentProduct.getAMOUNT()+"","");
        // Sold
        addSingleTitleView("Sold",currentProduct.getSOLD()+"","");
        // Total In
        addSingleTitleView("Total In", currentProduct.getTOTALAMOUNT()+"","");
        // Buy price
        addSingleTitleView("Buy Price", currentProduct.getPRICEBUY()+"","");
        // Sell price
        addSingleTitleView("Sell Price", currentProduct.getPRICESELL()+"","");
        // Expire date
        addSingleTitleView("Expire Date", currentProduct.getEXPIRY(),"");
        // Supplier
        addSingleTitleView("Supplier Name", currentSupplierName,"");
        return basicInfoView;
    }

    private void addSingleTitleView(String title, String content, String unit) {
        SingleTitleView barCodeSingleTitleView = new SingleTitleView(getActivity());
        barCodeSingleTitleView.setitem_title(title);
        barCodeSingleTitleView.setitem_content(content);
        if(!unit.isEmpty()) {
            barCodeSingleTitleView.setDanwei(unit);
        }
        ll.addView(barCodeSingleTitleView);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public static Fragment newInstance(Product currentProduct, String currentSupplierName) {
        BasicInfoFragment basicInfoFragment = new BasicInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PRODUCT, currentProduct);
        args.putString(ARG_SUPPLIERNAME, currentSupplierName);
        basicInfoFragment.setArguments(args);
        return basicInfoFragment;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
