package com.kvprasad.zbarbarcodescanner;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.matthew.model.Product;
import com.matthew.model.Supplier;
import com.matthew.tools.DialogTools;
import com.matthew.tools.GsonUtil;
import com.matthew.tools.HttpCallbackListener;
import com.matthew.tools.HttpUtil;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.util.Calendar;

import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UpdateInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class UpdateInfoFragment extends Fragment {

    private static final String ARG_PRODUCT = "CURRENT_PRODUCT" ;
    private OnFragmentInteractionListener mListener;
    private Product currentProduct;
    private MaterialEditText met_inventory;
    private MaterialEditText met_expiredate;
    private Button updateButton;
    public static boolean dateDialogHasShown = false;

    public UpdateInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currentProduct = (Product) getArguments().getSerializable(ARG_PRODUCT);
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @param product current product
     * @return A new instance of fragment UpdateInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateInfoFragment newInstance(Product product) {
        UpdateInfoFragment fragment = new UpdateInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PRODUCT, product);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View updateInfoFragment = inflater.inflate(R.layout.fragment_update_info, container,
                false);
        met_inventory = (MaterialEditText) updateInfoFragment.findViewById(R.id.met_inventory);
        met_expiredate = (MaterialEditText) updateInfoFragment.findViewById(R.id.met_expire);
        met_expiredate.setInputType(InputType.TYPE_NULL);
        updateButton = (Button) updateInfoFragment.findViewById(R.id.updateButton);
        if(currentProduct != null) {
            met_inventory.setText(currentProduct.getAMOUNT()+"");
            met_expiredate.setText(currentProduct.getEXPIRY());
        }
        // Set click listener for date picker
        met_expiredate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dateDialogHasShown) {
                    DialogTools.showDatePickerDialog(getActivity(), DatePickerDialog
                            .THEME_HOLO_LIGHT, met_expiredate, currentProduct.getEXPIRY(),
                            Calendar.getInstance());
                    dateDialogHasShown = true;
                }
            }
        });
        // Set Update button click
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productPutUrl = Constants.PRODUCTS_URL + currentProduct.getID();
                double inventory = 0;
                try {
                    inventory = Double.parseDouble(met_inventory.getText().toString());
                } catch(NumberFormatException e) {
                    // Not a number
                    DialogTools.showSweetDialog(getActivity(), SweetAlertDialog.ERROR_TYPE,"Not " +
                            "A Number", "Inventory must be a number!");
                    return;
                }
                // Show progress bar
                final SweetAlertDialog pDialog = DialogTools.showProgressAlertDialog(getActivity());
                currentProduct.setAMOUNT(inventory);
                currentProduct.setTOTALAMOUNT(inventory + currentProduct.getSOLD());
                currentProduct.setEXPIRY(met_expiredate.getText().toString());
                String bodyContent = GsonUtil.GsonString(currentProduct);
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), bodyContent);
                HttpUtil.getInstance().put(productPutUrl, requestBody, new HttpCallbackListener() {
                    @Override
                    public void onFinish(String response) {
                        if(response.contains("OK")) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    DialogTools.showSweetDialog(getActivity(),SweetAlertDialog.SUCCESS_TYPE,
                                            "Update Success", "Update Successfully!");
                                    pDialog.dismiss();
                                }
                            });
                        } else{
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    DialogTools.showSweetDialog(getActivity(),SweetAlertDialog.ERROR_TYPE,
                                            "Update Fail", "Update fail, please try again " +
                                                    "later!");
                                    pDialog.dismiss();
                                }
                            });
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                        super.onError(e);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                DialogTools.showSweetDialog(getActivity(),SweetAlertDialog.ERROR_TYPE,
                                        "Network Error", "Network error, please try again later!");
                                pDialog.dismiss();
                            }
                        });
                    }
                });
            }
        });
        return updateInfoFragment;
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
}
