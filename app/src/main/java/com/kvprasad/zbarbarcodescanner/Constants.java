package com.kvprasad.zbarbarcodescanner;

import android.util.Log;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Constants {
    // TODO: need to change this ip address
    public static final String BASE_URL = "http://192.168.1.232:8080/v1";
    public static final String PRODUCT_URL = BASE_URL + "/product/";
    public static final String CATEGORY_URL = BASE_URL + "/categories/";
    public static final String PROMOTION_URL = BASE_URL + "/promotions/";
    public static final String SUPPLIER_URL = BASE_URL + "/suppliers/";
    public static final String TAXCATEGORY_URL = BASE_URL + "/taxcategories/";

    /**
     * Get inner IP ADDRESS
     * @return
     */
    public static String getHostIP() {

        String hostIp = null;
        try {
            Enumeration nis = NetworkInterface.getNetworkInterfaces();
            InetAddress ia = null;
            while (nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {
                    ia = ias.nextElement();
                    if (ia instanceof Inet6Address) {
                        continue;// skip ipv6
                    }
                    String ip = ia.getHostAddress();
                    if (!"127.0.0.1".equals(ip)) {
                        hostIp = ia.getHostAddress();
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            Log.i("yao", "SocketException");
            e.printStackTrace();
        }
        return hostIp;

    }
}


