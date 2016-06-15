package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_291;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

// $FF: renamed from: com.google.android.gms.internal.nf
public class class_764 implements FusedLocationProviderApi {
   public Location getLastLocation(GoogleApiClient var1) {
      class_291 var2 = LocationServices.method_3570(var1);

      try {
         Location var4 = var2.method_1863();
         return var4;
      } catch (Exception var5) {
         return null;
      }
   }

   public PendingResult<Status> removeLocationUpdates(final GoogleApiClient var1, final PendingIntent var2) {
      return var1.method_944(new class_764.class_1645(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.nk) void
         protected void method_1216(class_291 var1) throws RemoteException {
            var1.method_1862(var2);
            this.b(Status.field_3960);
         }
      });
   }

   public PendingResult<Status> removeLocationUpdates(final GoogleApiClient var1, final LocationListener var2) {
      return var1.method_944(new class_764.class_1645(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.nk) void
         protected void method_1217(class_291 var1) throws RemoteException {
            var1.method_1857(var2);
            this.b(Status.field_3960);
         }
      });
   }

   public PendingResult<Status> requestLocationUpdates(final GoogleApiClient var1, final LocationRequest var2, final PendingIntent var3) {
      return var1.method_944(new class_764.class_1645(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.nk) void
         protected void method_1218(class_291 var1) throws RemoteException {
            var1.method_1861(var2, var3);
            this.b(Status.field_3960);
         }
      });
   }

   public PendingResult<Status> requestLocationUpdates(final GoogleApiClient var1, final LocationRequest var2, final LocationListener var3) {
      return var1.method_944(new class_764.class_1645(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.nk) void
         protected void method_1214(class_291 var1) throws RemoteException {
            var1.method_1858(var2, var3, (Looper)null);
            this.b(Status.field_3960);
         }
      });
   }

   public PendingResult<Status> requestLocationUpdates(final GoogleApiClient var1, final LocationRequest var2, final LocationListener var3, final Looper var4) {
      return var1.method_944(new class_764.class_1645(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.nk) void
         protected void method_1213(class_291 var1) throws RemoteException {
            var1.method_1858(var2, var3, var4);
            this.b(Status.field_3960);
         }
      });
   }

   public PendingResult<Status> setMockLocation(final GoogleApiClient var1, final Location var2) {
      return var1.method_944(new class_764.class_1645(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.nk) void
         protected void method_1212(class_291 var1) throws RemoteException {
            var1.method_1860(var2);
            this.b(Status.field_3960);
         }
      });
   }

   public PendingResult<Status> setMockMode(final GoogleApiClient var1, final boolean var2) {
      return var1.method_944(new class_764.class_1645(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.nk) void
         protected void method_1215(class_291 var1) throws RemoteException {
            var1.method_1852(var2);
            this.b(Status.field_3960);
         }
      });
   }

   private abstract static class class_1645 extends LocationServices.class_1331<Status> {
      public class_1645(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1211(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1211(var1);
      }
   }
}
