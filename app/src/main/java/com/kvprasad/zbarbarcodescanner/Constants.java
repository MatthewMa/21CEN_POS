package com.kvprasad.zbarbarcodescanner;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.matthew.model.User;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

public class Constants {
    // TODO: need to change this ip address
    public static String wifiAddress = "";
    public static final String BASE_URL = "http://08e5d23e.ngrok.io/v1";
    public static final String PRODUCT_URL = BASE_URL + "/product/";
    public static final String PRODUCTS_URL = BASE_URL + "/products/";
    public static final String CATEGORY_URL = BASE_URL + "/categories/";
    public static final String PROMOTION_URL = BASE_URL + "/promotions/";
    public static final String SUPPLIER_URL = BASE_URL + "/suppliers/";
    public static final String TAXCATEGORY_URL = BASE_URL + "/taxcategories/";
    public static String role;
    public static final User superUser = new User("admin","admin");
    public static final User employeeUser = new User("employee","employee");
}


