package com.goodrx.utils.locations;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.goodrx.model.LocationEntity;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.tracker.Trackers;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class LocationUtils {
   private static final String LAST_LOCATION_UPDATE_TIME = "last_update_time";
   private static final String LOCATION_ENTITY = "location_entity";
   private static final String LOCATION_OPTION = "location_option";

   public static void clear(Context var0) {
      Editor var1 = var0.getSharedPreferences("goodrx", 0).edit();
      var1.putLong("last_update_time", 0L);
      var1.putString("location_option", (String)null);
      var1.putString("location_entity", (String)null);
      var1.apply();
   }

   public static long getLastUpdateTime(Context var0) {
      return var0.getSharedPreferences("goodrx", 0).getLong("last_update_time", 0L);
   }

   public static LocationEntity getLocationEntity(Context var0) {
      String var1 = var0.getSharedPreferences("goodrx", 0).getString("location_entity", (String)null);
      if(var1 == null) {
         return null;
      } else {
         Gson var2 = new Gson();
         Object var3;
         if(!(var2 instanceof Gson)) {
            var3 = var2.fromJson(var1, LocationEntity.class);
         } else {
            var3 = GsonInstrumentation.fromJson((Gson)var2, var1, LocationEntity.class);
         }

         return (LocationEntity)var3;
      }
   }

   public static LocationUtils.LocationOption getLocationOption(Context var0) {
      String var1 = var0.getSharedPreferences("goodrx", 0).getString("location_option", (String)null);
      if(var1 != null && var1.length() != 0 && !var1.equals("null")) {
         Gson var2 = new Gson();
         Object var3;
         if(!(var2 instanceof Gson)) {
            var3 = var2.fromJson(var1, LocationUtils.LocationOption.class);
         } else {
            var3 = GsonInstrumentation.fromJson((Gson)var2, var1, LocationUtils.LocationOption.class);
         }

         return (LocationUtils.LocationOption)var3;
      } else {
         return LocationUtils.LocationOption.CURRENT_LOCATION;
      }
   }

   public static void saveLocationOptionToDisk(Context var0, LocationUtils.LocationOption var1, LocationEntity var2) {
      Editor var3 = var0.getSharedPreferences("goodrx", 0).edit();
      Gson var4 = new Gson();
      String var5;
      if(!(var4 instanceof Gson)) {
         var5 = var4.toJson((Object)var1);
      } else {
         var5 = GsonInstrumentation.toJson((Gson)var4, (Object)var1);
      }

      var3.putString("location_option", var5);
      String var7;
      if(!(var4 instanceof Gson)) {
         var7 = var4.toJson((Object)var2);
      } else {
         var7 = GsonInstrumentation.toJson((Gson)var4, (Object)var2);
      }

      var3.putString("location_entity", var7);
      var3.apply();
      boolean var9 = MyRxUtils.isPriceAlertEnabled(var0);
      boolean var10 = MyRxUtils.isSavingsAlertEnabled(var0);
      Trackers.setParseInstallationData(var0, var9, var10, var10);
   }

   public static void setLastUpdateTime(Context var0) {
      setLastUpdateTime(var0, (new DateTime(DateTimeZone.getDefault())).getMillis());
   }

   public static void setLastUpdateTime(Context var0, long var1) {
      Editor var3 = var0.getSharedPreferences("goodrx", 0).edit();
      var3.putLong("last_update_time", var1);
      var3.apply();
   }

   public static enum LocationOption {
      CURRENT_LOCATION,
      CUSTOM,
      NONE;

      static {
         LocationUtils.LocationOption[] var0 = new LocationUtils.LocationOption[]{CURRENT_LOCATION, CUSTOM, NONE};
      }
   }
}
