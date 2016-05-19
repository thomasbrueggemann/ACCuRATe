package com.criteo.events;

import com.criteo.events.AppLaunchEvent;
import com.criteo.events.CRTOLog;
import com.criteo.events.DeviceInfo;
import com.criteo.events.Event;
import com.criteo.events.EventService;
import com.criteo.events.ExtraData;
import com.criteo.events.HomeViewEvent;
import com.criteo.events.ProductViewEvent;
import com.criteo.events.TransactionConfirmationEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JSONEventSerializer {
   private static JSONObject addExtraData(Event var0, JSONObject var1) throws JSONException {
      Iterator var2 = var0.getExtraDataMap().entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         JSONObject var4 = new JSONObject();
         if(((ExtraData)var3.getValue()).getType() == ExtraData.ExtraDataType.Date) {
            var4.put("value", getFormattedDate((GregorianCalendar)((ExtraData)var3.getValue()).getValue()));
         } else {
            var4.put("value", ((ExtraData)var3.getValue()).getValue());
         }

         int var6 = null.$SwitchMap$com$criteo$events$ExtraData$ExtraDataType[((ExtraData)var3.getValue()).getType().ordinal()];
         String var7 = null;
         switch(var6) {
         case 1:
            var7 = "float";
            break;
         case 2:
            var7 = "integer";
            break;
         case 3:
            var7 = "string";
            break;
         case 4:
            var7 = "date";
         }

         var4.put("type", var7);
         var1.put((String)var3.getKey(), var4);
      }

      return var1;
   }

   static JSONObject commonPayload(EventService var0) throws JSONException {
      JSONObject var1 = new JSONObject();
      JSONObject var2 = new JSONObject();
      var2.put("an", DeviceInfo.getBundleName());
      var2.put("country_code", var0.getCountry());
      var2.put("language_code", var0.getLanguage());
      JSONObject var6 = new JSONObject();
      var6.put("gaid", DeviceInfo.getAdvertisingId());
      var6.put("limit_ad_tracking", DeviceInfo.getLimitAdTrackingEnabled());
      JSONObject var9 = new JSONObject();
      var9.put("app_id", DeviceInfo.getBundleName());
      var9.put("app_name", DeviceInfo.getBundleName());
      var9.put("app_version", DeviceInfo.getAppVersion());
      var9.put("sdk_version", DeviceInfo.getSDKVersion());
      var9.put("app_language", DeviceInfo.getLanguage());
      var9.put("app_country", DeviceInfo.getCountry());
      JSONObject var16 = new JSONObject();
      var16.put("platform", "android");
      var16.put("os_name", "android");
      var16.put("os_version", DeviceInfo.getAndroidVersion());
      var16.put("device_model", DeviceInfo.getModel());
      var16.put("device_manufacturer", DeviceInfo.getManufacturer());
      JSONArray var22 = new JSONArray();
      if(var0.getEmail() != null) {
         JSONObject var23 = new JSONObject();
         var23.put("value", var0.getEmail());
         var23.put("type", "email");
         var23.put("hash_method", "none");
         var22.put(var23);
      }

      var1.put("account", var2);
      var1.put("id", var6);
      var1.put("device_info", var16);
      var1.put("app_info", var9);
      var1.put("alternate_ids", var22);
      if(var0.getCustomerId() != null) {
         var1.put("customer_id", var0.getCustomerId());
      }

      return var1;
   }

   private static String getFormattedDate(Date var0) {
      TimeZone var1 = TimeZone.getTimeZone("UTC");
      SimpleDateFormat var2 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'", Locale.ENGLISH);
      var2.setTimeZone(var1);
      return var2.format(var0);
   }

   private static String getFormattedDate(GregorianCalendar var0) {
      Object[] var1 = new Object[]{Integer.valueOf(var0.get(1))};
      String var2 = String.format("%04d", var1);
      Object[] var3 = new Object[]{Integer.valueOf(1 + var0.get(2))};
      String var4 = String.format("%02d", var3);
      Object[] var5 = new Object[]{Integer.valueOf(var0.get(5))};
      return String.format("%s-%s-%sT00:00:00Z", new Object[]{var2, var4, String.format("%02d", var5)});
   }

   static JSONObject serializeToJSON(AppLaunchEvent var0) {
      try {
         JSONObject var1 = new JSONObject();
         var1.put("event", "appLaunch");
         if(var0.getGoogleReferrer() != null) {
            var1.put("referrer", var0.getGoogleReferrer());
         }

         var1.put("first_launch", var0.getFirstLaunch());
         var1.put("timestamp", getFormattedDate(var0.getTimestamp()));
         JSONObject var6 = addExtraData(var0, var1);
         return var6;
      } catch (JSONException var7) {
         CRTOLog.method_474("Error in JSON serialisation", var7);
         return null;
      }
   }

   static JSONObject serializeToJSON(HomeViewEvent var0) {
      try {
         JSONObject var1 = new JSONObject();
         var1.put("event", "viewHome");
         var1.put("timestamp", getFormattedDate(var0.getTimestamp()));
         JSONObject var5 = addExtraData(var0, var1);
         return var5;
      } catch (JSONException var6) {
         CRTOLog.method_474("Error in JSON serialisation", var6);
         return null;
      }
   }

   static JSONObject serializeToJSON(ProductViewEvent var0) {
      try {
         JSONObject var1 = new JSONObject();
         var1.put("event", "viewProduct");
         if(var0.getCurrency() != null) {
            var1.put("currency", var0.getCurrency().getCurrencyCode());
         }

         if(var0.getProduct() != null) {
            JSONObject var4 = new JSONObject();
            var4.put("id", var0.getProduct().getProductId());
            var4.put("price", var0.getProduct().getPrice());
            var1.put("product", var4);
         }

         var1.put("timestamp", getFormattedDate(var0.getTimestamp()));
         JSONObject var9 = addExtraData(var0, var1);
         return var9;
      } catch (JSONException var10) {
         CRTOLog.method_474("Error in JSON serialisation", var10);
         return null;
      }
   }

   static JSONObject serializeToJSON(TransactionConfirmationEvent param0) {
      // $FF: Couldn't be decompiled
   }
}
