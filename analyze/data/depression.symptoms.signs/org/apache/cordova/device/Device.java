package org.apache.cordova.device;

import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import java.util.TimeZone;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Device extends CordovaPlugin {
   private static final String AMAZON_DEVICE = "Amazon";
   private static final String AMAZON_PLATFORM = "amazon-fireos";
   private static final String ANDROID_PLATFORM = "Android";
   public static final String TAG = "Device";
   public static String cordovaVersion = "dev";
   public static String platform;
   public static String uuid;

   public boolean execute(String var1, JSONArray var2, CallbackContext var3) throws JSONException {
      if(var1.equals("getDeviceInfo")) {
         JSONObject var4 = new JSONObject();
         var4.put("uuid", uuid);
         var4.put("version", this.getOSVersion());
         var4.put("platform", this.getPlatform());
         var4.put("cordova", cordovaVersion);
         var4.put("model", this.getModel());
         var3.success(var4);
         return true;
      } else {
         return false;
      }
   }

   public String getCordovaVersion() {
      return cordovaVersion;
   }

   public String getModel() {
      return Build.MODEL;
   }

   public String getOSVersion() {
      return VERSION.RELEASE;
   }

   public String getPlatform() {
      return this.isAmazonDevice()?"amazon-fireos":"Android";
   }

   public String getProductName() {
      return Build.PRODUCT;
   }

   public String getSDKVersion() {
      return VERSION.SDK;
   }

   public String getTimeZoneID() {
      return TimeZone.getDefault().getID();
   }

   public String getUuid() {
      return Secure.getString(this.cordova.getActivity().getContentResolver(), "android_id");
   }

   public void initialize(CordovaInterface var1, CordovaWebView var2) {
      super.initialize(var1, var2);
      uuid = this.getUuid();
   }

   public boolean isAmazonDevice() {
      return Build.MANUFACTURER.equals("Amazon");
   }
}
