package com.mobileapptracker;

import android.content.Context;
import com.mobileapptracker.MATDeeplinkListener;
import com.mobileapptracker.MATUrlRequester;

class MATDeferredDplinkr {
   private static volatile MATDeferredDplinkr dplinkr;
   private String advertiserId = null;
   private String androidId = null;
   private String conversionKey = null;
   private boolean enabled;
   private String googleAdvertisingId = null;
   private int isLATEnabled = 0;
   private MATDeeplinkListener listener = null;
   private String packageName = null;
   private String userAgent = null;

   public static MATDeferredDplinkr initialize(String var0, String var1, String var2) {
      synchronized(MATDeferredDplinkr.class){}

      MATDeferredDplinkr var4;
      try {
         dplinkr = new MATDeferredDplinkr();
         dplinkr.advertiserId = var0;
         dplinkr.conversionKey = var1;
         dplinkr.packageName = var2;
         var4 = dplinkr;
      } finally {
         ;
      }

      return var4;
   }

   public void checkForDeferredDeeplink(Context var1, final MATUrlRequester var2) {
      (new Thread(new Runnable() {
         public void run() {
            if((MATDeferredDplinkr.dplinkr.advertiserId == null || MATDeferredDplinkr.dplinkr.conversionKey == null || MATDeferredDplinkr.dplinkr.packageName == null) && MATDeferredDplinkr.this.listener != null) {
               MATDeferredDplinkr.this.listener.didFailDeeplink("Advertiser ID, conversion key, or package name not set");
            }

            if(MATDeferredDplinkr.dplinkr.googleAdvertisingId == null && MATDeferredDplinkr.dplinkr.androidId == null && MATDeferredDplinkr.this.listener != null) {
               MATDeferredDplinkr.this.listener.didFailDeeplink("No device identifiers collected");
            }

            var2.requestDeeplink(MATDeferredDplinkr.dplinkr);
         }
      })).start();
   }

   public void enable(boolean var1) {
      this.enabled = var1;
   }

   public String getAdvertiserId() {
      return dplinkr.advertiserId;
   }

   public String getAndroidId() {
      return dplinkr.androidId;
   }

   public String getConversionKey() {
      return dplinkr.conversionKey;
   }

   public int getGoogleAdTrackingLimited() {
      return dplinkr.isLATEnabled;
   }

   public String getGoogleAdvertisingId() {
      return dplinkr.googleAdvertisingId;
   }

   public MATDeeplinkListener getListener() {
      return dplinkr.listener;
   }

   public String getPackageName() {
      return dplinkr.packageName;
   }

   public String getUserAgent() {
      return dplinkr.userAgent;
   }

   public boolean isEnabled() {
      return this.enabled;
   }

   public void setAndroidId(String var1) {
      dplinkr.androidId = var1;
   }

   public void setGoogleAdvertisingId(String var1, int var2) {
      dplinkr.googleAdvertisingId = var1;
      dplinkr.isLATEnabled = var2;
   }

   public void setListener(MATDeeplinkListener var1) {
      dplinkr.listener = var1;
   }

   public void setPackageName(String var1) {
      dplinkr.packageName = var1;
   }

   public void setUserAgent(String var1) {
      dplinkr.userAgent = var1;
   }
}
