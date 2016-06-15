package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_291;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.class_651;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.ng
public class class_765 implements GeofencingApi {
   public PendingResult<Status> addGeofences(final GoogleApiClient var1, final GeofencingRequest var2, final PendingIntent var3) {
      return var1.method_944(new class_765.class_1710(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.nk) void
         protected void method_1209(class_291 var1) throws RemoteException {
            class_651.class_1259 var2x = new class_651.class_1259() {
               // $FF: renamed from: a (int, java.lang.String[]) void
               public void method_283(int var1, String[] var2x) {
                  b(LocationStatusCodes.method_2355(var1));
               }
            };
            var1.method_1856(var2, var3, var2x);
         }
      });
   }

   @Deprecated
   public PendingResult<Status> addGeofences(GoogleApiClient var1, List<Geofence> var2, PendingIntent var3) {
      GeofencingRequest.Builder var4 = new GeofencingRequest.Builder();
      var4.addGeofences(var2);
      var4.setInitialTrigger(5);
      return this.addGeofences(var1, var4.build(), var3);
   }

   public PendingResult<Status> removeGeofences(final GoogleApiClient var1, final PendingIntent var2) {
      return var1.method_944(new class_765.class_1710(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.nk) void
         protected void method_1210(class_291 var1) throws RemoteException {
            class_651.class_1261 var2x = new class_651.class_1261() {
               // $FF: renamed from: a (int, android.app.PendingIntent) void
               public void method_284(int var1, PendingIntent var2x) {
                  b(LocationStatusCodes.method_2355(var1));
               }

               // $FF: renamed from: b (int, java.lang.String[]) void
               public void method_285(int var1, String[] var2x) {
                  Log.wtf("GeofencingImpl", "Request ID callback shouldn\'t have been called");
               }
            };
            var1.method_1855(var2, var2x);
         }
      });
   }

   public PendingResult<Status> removeGeofences(final GoogleApiClient var1, final List<String> var2) {
      return var1.method_944(new class_765.class_1710(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.nk) void
         protected void method_1208(class_291 var1) throws RemoteException {
            class_651.class_1261 var2x = new class_651.class_1261() {
               // $FF: renamed from: a (int, android.app.PendingIntent) void
               public void method_284(int var1, PendingIntent var2x) {
                  Log.wtf("GeofencingImpl", "PendingIntent callback shouldn\'t have been called");
               }

               // $FF: renamed from: b (int, java.lang.String[]) void
               public void method_285(int var1, String[] var2x) {
                  b(LocationStatusCodes.method_2355(var1));
               }
            };
            var1.method_1859(var2, var2x);
         }
      });
   }

   private abstract static class class_1710 extends LocationServices.class_1331<Status> {
      public class_1710(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1207(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1207(var1);
      }
   }
}
