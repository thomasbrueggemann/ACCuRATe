package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_243;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

// $FF: renamed from: com.google.android.gms.internal.jc
public class class_317 implements FusedLocationProviderApi {
   public Location getLastLocation(GoogleApiClient var1) {
      class_243 var2 = LocationServices.method_2991(var1);

      try {
         Location var4 = var2.getLastLocation();
         return var4;
      } catch (Exception var5) {
         return null;
      }
   }

   public PendingResult<Status> removeLocationUpdates(GoogleApiClient var1, final PendingIntent var2) {
      return var1.method_773(new class_317.class_1250(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.jh) void
         protected void method_992(class_243 var1) throws RemoteException {
            var1.removeLocationUpdates(var2);
            this.b(Status.field_3880);
         }
      });
   }

   public PendingResult<Status> removeLocationUpdates(GoogleApiClient var1, final LocationListener var2) {
      return var1.method_773(new class_317.class_1250(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.jh) void
         protected void method_995(class_243 var1) throws RemoteException {
            var1.removeLocationUpdates(var2);
            this.b(Status.field_3880);
         }
      });
   }

   public PendingResult<Status> requestLocationUpdates(GoogleApiClient var1, final LocationRequest var2, final PendingIntent var3) {
      return var1.method_773(new class_317.class_1250(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.jh) void
         protected void method_994(class_243 var1) throws RemoteException {
            var1.requestLocationUpdates(var2, var3);
            this.b(Status.field_3880);
         }
      });
   }

   public PendingResult<Status> requestLocationUpdates(GoogleApiClient var1, final LocationRequest var2, final LocationListener var3) {
      return var1.method_773(new class_317.class_1250(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.jh) void
         protected void method_998(class_243 var1) throws RemoteException {
            var1.requestLocationUpdates(var2, var3);
            this.b(Status.field_3880);
         }
      });
   }

   public PendingResult<Status> requestLocationUpdates(GoogleApiClient var1, final LocationRequest var2, final LocationListener var3, final Looper var4) {
      return var1.method_773(new class_317.class_1250(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.jh) void
         protected void method_997(class_243 var1) throws RemoteException {
            var1.requestLocationUpdates(var2, var3, var4);
            this.b(Status.field_3880);
         }
      });
   }

   public PendingResult<Status> setMockLocation(GoogleApiClient var1, final Location var2) {
      return var1.method_773(new class_317.class_1250(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.jh) void
         protected void method_996(class_243 var1) throws RemoteException {
            var1.setMockLocation(var2);
            this.b(Status.field_3880);
         }
      });
   }

   public PendingResult<Status> setMockMode(GoogleApiClient var1, final boolean var2) {
      return var1.method_773(new class_317.class_1250(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.jh) void
         protected void method_993(class_243 var1) throws RemoteException {
            var1.setMockMode(var2);
            this.b(Status.field_3880);
         }
      });
   }

   private abstract static class class_1250 extends LocationServices.class_1002<Status> {
      private class_1250() {
      }

      // $FF: synthetic method
      class_1250(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_991(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_991(Status var1) {
         return var1;
      }
   }
}
