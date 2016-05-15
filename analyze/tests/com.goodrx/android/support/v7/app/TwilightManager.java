package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.TwilightCalculator;
import android.util.Log;
import java.util.Calendar;

class TwilightManager {
   private static final int SUNRISE = 6;
   private static final int SUNSET = 22;
   private static final String TAG = "TwilightManager";
   private static final TwilightManager.TwilightState sTwilightState = new TwilightManager.TwilightState();
   private final Context mContext;
   private final LocationManager mLocationManager;

   TwilightManager(Context var1) {
      this.mContext = var1;
      this.mLocationManager = (LocationManager)var1.getSystemService("location");
   }

   private Location getLastKnownLocation() {
      int var1 = PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION");
      Location var2 = null;
      if(var1 == 0) {
         var2 = this.getLastKnownLocationForProvider("network");
      }

      int var3 = PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION");
      Location var4 = null;
      if(var3 == 0) {
         var4 = this.getLastKnownLocationForProvider("gps");
      }

      if(var4 != null && var2 != null) {
         if(var4.getTime() <= var2.getTime()) {
            return var2;
         }
      } else if(var4 == null) {
         return var2;
      }

      return var4;
   }

   private Location getLastKnownLocationForProvider(String var1) {
      if(this.mLocationManager != null) {
         try {
            if(this.mLocationManager.isProviderEnabled(var1)) {
               Location var4 = this.mLocationManager.getLastKnownLocation(var1);
               return var4;
            }
         } catch (Exception var5) {
            Log.d("TwilightManager", "Failed to get last known location", var5);
         }
      }

      return null;
   }

   private boolean isStateValid(TwilightManager.TwilightState var1) {
      return var1 != null && var1.nextUpdate > System.currentTimeMillis();
   }

   private void updateState(@NonNull Location var1) {
      TwilightManager.TwilightState var2 = sTwilightState;
      long var3 = System.currentTimeMillis();
      TwilightCalculator var5 = TwilightCalculator.getInstance();
      var5.calculateTwilight(var3 - 86400000L, var1.getLatitude(), var1.getLongitude());
      long var6 = var5.sunset;
      var5.calculateTwilight(var3, var1.getLatitude(), var1.getLongitude());
      boolean var8;
      if(var5.state == 1) {
         var8 = true;
      } else {
         var8 = false;
      }

      long var9 = var5.sunrise;
      long var11 = var5.sunset;
      var5.calculateTwilight(86400000L + var3, var1.getLatitude(), var1.getLongitude());
      long var13 = var5.sunrise;
      long var15;
      if(var9 != -1L && var11 != -1L) {
         long var17;
         if(var3 > var11) {
            var17 = 0L + var13;
         } else if(var3 > var9) {
            var17 = 0L + var11;
         } else {
            var17 = 0L + var9;
         }

         var15 = var17 + 60000L;
      } else {
         var15 = var3 + 43200000L;
      }

      var2.isNight = var8;
      var2.yesterdaySunset = var6;
      var2.todaySunrise = var9;
      var2.todaySunset = var11;
      var2.tomorrowSunrise = var13;
      var2.nextUpdate = var15;
   }

   boolean isNight() {
      TwilightManager.TwilightState var1 = sTwilightState;
      if(this.isStateValid(var1)) {
         return var1.isNight;
      } else {
         Location var2 = this.getLastKnownLocation();
         if(var2 != null) {
            this.updateState(var2);
            return var1.isNight;
         } else {
            Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
            int var4 = Calendar.getInstance().get(11);
            return var4 < 6 || var4 >= 22;
         }
      }
   }

   private static class TwilightState {
      boolean isNight;
      long nextUpdate;
      long todaySunrise;
      long todaySunset;
      long tomorrowSunrise;
      long yesterdaySunset;

      private TwilightState() {
      }

      // $FF: synthetic method
      TwilightState(Object var1) {
         this();
      }
   }
}
