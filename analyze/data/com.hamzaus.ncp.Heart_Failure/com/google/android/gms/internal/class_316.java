package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_243;
import com.google.android.gms.internal.class_314;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.jd
public class class_316 implements GeofencingApi {
   public PendingResult<Status> addGeofences(GoogleApiClient var1, List<Geofence> var2, final PendingIntent var3) {
      final ArrayList var6;
      if(var2 != null) {
         ArrayList var4 = new ArrayList(var2.size());
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            Geofence var7 = (Geofence)var5.next();
            class_347.method_2168(var7 instanceof class_314, "Geofence must be created using Geofence.Builder.");
            var4.add((class_314)var7);
         }

         var6 = var4;
      } else {
         var6 = null;
      }

      return var1.method_773(new class_316.class_1249(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.jh) void
         protected void method_1000(class_243 var1) throws RemoteException {
            LocationClient.OnAddGeofencesResultListener var2 = new LocationClient.OnAddGeofencesResultListener() {
               public void onAddGeofencesResult(int var1, String[] var2) {
                  b(LocationStatusCodes.method_2025(var1));
               }
            };
            var1.addGeofences(var6, var3, var2);
         }
      });
   }

   public PendingResult<Status> removeGeofences(GoogleApiClient var1, final PendingIntent var2) {
      return var1.method_773(new class_316.class_1249(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.jh) void
         protected void method_1002(class_243 var1) throws RemoteException {
            LocationClient.OnRemoveGeofencesResultListener var2x = new LocationClient.OnRemoveGeofencesResultListener() {
               public void onRemoveGeofencesByPendingIntentResult(int var1, PendingIntent var2x) {
                  b(LocationStatusCodes.method_2025(var1));
               }

               public void onRemoveGeofencesByRequestIdsResult(int var1, String[] var2x) {
                  Log.wtf("GeofencingImpl", "Request ID callback shouldn\'t have been called");
               }
            };
            var1.removeGeofences(var2, var2x);
         }
      });
   }

   public PendingResult<Status> removeGeofences(GoogleApiClient var1, final List<String> var2) {
      return var1.method_773(new class_316.class_1249(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.jh) void
         protected void method_1001(class_243 var1) throws RemoteException {
            LocationClient.OnRemoveGeofencesResultListener var2x = new LocationClient.OnRemoveGeofencesResultListener() {
               public void onRemoveGeofencesByPendingIntentResult(int var1, PendingIntent var2x) {
                  Log.wtf("GeofencingImpl", "PendingIntent callback shouldn\'t have been called");
               }

               public void onRemoveGeofencesByRequestIdsResult(int var1, String[] var2x) {
                  b(LocationStatusCodes.method_2025(var1));
               }
            };
            var1.removeGeofences(var2, var2x);
         }
      });
   }

   private abstract static class class_1249 extends LocationServices.class_1002<Status> {
      private class_1249() {
      }

      // $FF: synthetic method
      class_1249(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_999(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_999(Status var1) {
         return var1;
      }
   }
}
