package com.parse;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import bolts.Capture;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.parse.ParseException;
import com.parse.ParseExecutors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class LocationNotifier {
   private static Location fakeLocation = null;

   static Task<Location> getCurrentLocationAsync(Context var0, long var1, Criteria var3) {
      final TaskCompletionSource var4 = new TaskCompletionSource();
      final Capture var5 = new Capture();
      final LocationManager var6 = (LocationManager)var0.getSystemService("location");
      final LocationListener var7 = new LocationListener() {
         public void onLocationChanged(Location var1) {
            if(var1 != null) {
               ((ScheduledFuture)var5.get()).cancel(true);
               var4.trySetResult(var1);
               var6.removeUpdates(this);
            }
         }

         public void onProviderDisabled(String var1) {
         }

         public void onProviderEnabled(String var1) {
         }

         public void onStatusChanged(String var1, int var2, Bundle var3) {
         }
      };
      var5.set(ParseExecutors.scheduled().schedule(new Runnable() {
         public void run() {
            var4.trySetError(new ParseException(124, "Location fetch timed out."));
            var6.removeUpdates(var7);
         }
      }, var1, TimeUnit.MILLISECONDS));
      String var8 = var6.getBestProvider(var3, true);
      if(var8 != null) {
         var6.requestLocationUpdates(var8, 0L, 0.0F, var7);
      }

      if(fakeLocation != null) {
         var7.onLocationChanged(fakeLocation);
      }

      return var4.getTask();
   }

   static void setFakeLocation(Location var0) {
      fakeLocation = var0;
   }
}
