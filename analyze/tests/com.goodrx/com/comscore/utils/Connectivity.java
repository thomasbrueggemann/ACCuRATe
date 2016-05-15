package com.comscore.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.comscore.utils.CSLog;
import com.comscore.utils.Permissions;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;

@SuppressLint({"NewApi"})
public class Connectivity {
   // $FF: renamed from: a org.apache.http.client.HttpClient
   private static HttpClient field_247 = null;

   // $FF: renamed from: a () org.apache.http.client.HttpClient
   private static HttpClient method_184() {
      try {
         SSLSocketFactory var1 = SSLSocketFactory.getSocketFactory();
         var1.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
         BasicHttpParams var2 = new BasicHttpParams();
         var2.setBooleanParameter("http.protocol.expect-continue", false);
         SchemeRegistry var4 = new SchemeRegistry();
         var4.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
         var4.register(new Scheme("https", var1, 443));
         DefaultHttpClient var7 = new DefaultHttpClient(new ThreadSafeClientConnManager(var2, var4), var2);
         return var7;
      } catch (Exception var8) {
         CSLog.method_374("comScore", var8.getMessage());
         return new DefaultHttpClient();
      }
   }

   public static String getCurrentSSID(Context var0) {
      if(Permissions.check(var0, "android.permission.ACCESS_WIFI_STATE").booleanValue() && ((ConnectivityManager)var0.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
         WifiInfo var1 = ((WifiManager)var0.getSystemService("wifi")).getConnectionInfo();
         if(var1 != null) {
            return var1.getSSID();
         }
      }

      return null;
   }

   public static HttpClient getHttpClient() {
      if(field_247 == null) {
         field_247 = method_184();
      }

      return field_247;
   }

   public static boolean isConnectBluetooth(Context var0) {
      if(Permissions.check(var0, "android.permission.ACCESS_NETWORK_STATE").booleanValue() && VERSION.SDK_INT >= 13) {
         NetworkInfo var1 = ((ConnectivityManager)var0.getSystemService("connectivity")).getNetworkInfo(7);
         return var1 != null && var1.isConnected();
      } else {
         return false;
      }
   }

   public static boolean isConnectEthernet(Context var0) {
      if(Permissions.check(var0, "android.permission.ACCESS_NETWORK_STATE").booleanValue() && VERSION.SDK_INT >= 13) {
         NetworkInfo var1 = ((ConnectivityManager)var0.getSystemService("connectivity")).getNetworkInfo(9);
         return var1 != null && var1.isConnected();
      } else {
         return false;
      }
   }

   public static boolean isConnectedMobile(Context var0) {
      if(Permissions.check(var0, "android.permission.ACCESS_NETWORK_STATE").booleanValue()) {
         NetworkInfo var1 = ((ConnectivityManager)var0.getSystemService("connectivity")).getNetworkInfo(0);
         return var1 != null && var1.isConnected();
      } else {
         return false;
      }
   }

   public static boolean isConnectedWiFi(Context var0) {
      if(Permissions.check(var0, "android.permission.ACCESS_NETWORK_STATE").booleanValue()) {
         NetworkInfo var1 = ((ConnectivityManager)var0.getSystemService("connectivity")).getNetworkInfo(1);
         return var1 != null && var1.isConnected();
      } else {
         return false;
      }
   }

   public static boolean isDataConnected(Context var0) {
      if(Permissions.check(var0, "android.permission.READ_PHONE_STATE").booleanValue()) {
         TelephonyManager var1 = (TelephonyManager)var0.getSystemService("phone");
         return var1.getDataActivity() == 3 || var1.getDataActivity() == 1 || var1.getDataActivity() == 2;
      } else {
         return false;
      }
   }

   public static boolean isEmulator() {
      return "sdk".equals(Build.PRODUCT);
   }
}
