package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.class_486;
import com.google.android.gms.fitness.request.class_490;
import com.google.android.gms.fitness.request.class_506;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.class_153;
import com.google.android.gms.internal.class_91;

// $FF: renamed from: com.google.android.gms.internal.mh
public class class_781 implements BleApi {
   public PendingResult<Status> claimBleDevice(final GoogleApiClient var1, final BleDevice var2) {
      return var1.method_944(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1285(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_753(new class_506(var2), var2x, var3);
         }
      });
   }

   public PendingResult<Status> claimBleDevice(final GoogleApiClient var1, final String var2) {
      return var1.method_944(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1286(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_753(new class_506(var2), var2x, var3);
         }
      });
   }

   public PendingResult<BleDevicesResult> listClaimedBleDevices(final GoogleApiClient var1) {
      return var1.method_942(new class_91.class_1347(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1273(class_91 var1) throws RemoteException {
            class_781.class_1126 var2 = new class_781.class_1126(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_763(var2, var3);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1274(var1);
         }

         // $FF: renamed from: v (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.BleDevicesResult
         protected BleDevicesResult method_1274(Status var1) {
            return BleDevicesResult.method_3530(var1);
         }
      });
   }

   public PendingResult<Status> startBleScan(final GoogleApiClient var1, final StartBleScanRequest var2) {
      return var1.method_942(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1288(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_747(var2, var2x, var3);
         }
      });
   }

   public PendingResult<Status> stopBleScan(final GoogleApiClient var1, final BleScanCallback var2) {
      return var1.method_942(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1287(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            class_490 var4 = new class_490(var2);
            var1.method_441().method_749(var4, var2x, var3);
         }
      });
   }

   public PendingResult<Status> unclaimBleDevice(GoogleApiClient var1, BleDevice var2) {
      return this.unclaimBleDevice(var1, var2.getAddress());
   }

   public PendingResult<Status> unclaimBleDevice(final GoogleApiClient var1, final String var2) {
      return var1.method_944(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1289(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_751(new class_486(var2), var2x, var3);
         }
      });
   }

   private static class class_1126 extends class_153.class_1451 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<BleDevicesResult> field_1269;

      private class_1126(BaseImplementation.class_1058<BleDevicesResult> var1) {
         this.field_1269 = var1;
      }

      // $FF: synthetic method
      class_1126(BaseImplementation.class_1058 var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.result.BleDevicesResult) void
      public void method_816(BleDevicesResult var1) {
         this.field_1269.method_110(var1);
      }
   }
}
