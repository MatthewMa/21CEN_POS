package com.kvprasad.zbarbarcodescanner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.matthew.customviews.SingleTitleView;
import com.matthew.model.Product;
import com.matthew.model.Supplier;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SupplierFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SupplierFragment extends Fragment {

    private static final String ARG_SUPPLIER = "CURRENT_SUPPLIER";
    private Supplier currentSupplier;
    private OnFragmentInteractionListener mListener;
    private LinearLayout ll;
    private TextView basicInfoTextView;

    public SupplierFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @param supplier current supplier
     * @return A new instance of fragment SupplierFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SupplierFragment newInstance(Supplier supplier) {
        SupplierFragment fragment = new SupplierFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_SUPPLIER, supplier);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentSupplier = (Supplier) getArguments().getSerializable(ARG_SUPPLIER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View supplierFragment = inflater.inflate(R.layout.fragment_supplier, container, false);
        ll = (LinearLayout) supplierFragment.findViewById(R.id.ll);
        basicInfoTextView = (TextView) supplierFragment.findViewById(R.id.basic_info_textview);
        if(Constants.role.equals("employee")){
            basicInfoTextView.setText("No Permission to read Supplier");
        }
        if(currentSupplier != null && Constants.role.equals("super")) {
            // Add table view
            // Account Number
            addSingleTitleView("Account Number", currentSupplier.getACCOUNTNUMBER(),"");
            // Supplier Name
            addSingleTitleView("Supplier Name", currentSupplier.getSUPPLIERNAME(),"");
            // Address
            addSingleTitleView("Address", currentSupplier.getADDRESS(),"");
            // Adress 2
            addSingleTitleView("Address 2",currentSupplier.getADDRESS2(),"");
            // City
            addSingleTitleView("City", currentSupplier.getCITY(),"");
            // Postcode
            addSingleTitleView("Post Code",currentSupplier.getPOSTCODE(),"");
            // Email
            addSingleTitleView("Email", currentSupplier.getEMAIL(),"");
            // Phone
            addSingleTitleView("Phone", currentSupplier.getPHONE(),"");
            // Credit Limit
            addSingleTitleView("Credit Limit", currentSupplier.getCREDITLIMIT()+"","");
            // Notes
            addSingleTitleView("Notes", currentSupplier.getNOTES(),"");
        }
        return supplierFragment;
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

    private void addSingleTitleView(String title, String content, String unit) {
        SingleTitleView barCodeSingleTitleView = new SingleTitleView(getActivity());
        barCodeSingleTitleView.setitem_title(title);
        barCodeSingleTitleView.setitem_content(content);
        if(!unit.isEmpty()) {
            barCodeSingleTitleView.setDanwei(unit);
        }
        ll.addView(barCodeSingleTitleView);
    }
}
