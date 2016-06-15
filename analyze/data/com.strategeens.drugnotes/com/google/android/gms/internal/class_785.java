package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.class_500;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.class_137;
import com.google.android.gms.internal.class_91;

// $FF: renamed from: com.google.android.gms.internal.mi
public class class_785 implements ConfigApi {
   public PendingResult<DataTypeResult> createCustomDataType(final GoogleApiClient var1, final DataTypeCreateRequest var2) {
      return var1.method_944(new class_91.class_1347(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1269(class_91 var1) throws RemoteException {
            class_785.class_1335 var2x = new class_785.class_1335(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_744(var2, var2x, var3);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1270(var1);
         }

         // $FF: renamed from: w (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.DataTypeResult
         protected DataTypeResult method_1270(Status var1) {
            return DataTypeResult.method_5391(var1);
         }
      });
   }

   public PendingResult<Status> disableFit(final GoogleApiClient var1) {
      return var1.method_944(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1284(class_91 var1) throws RemoteException {
            class_91.class_1348 var2 = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_762(var2, var3);
         }
      });
   }

   public PendingResult<DataTypeResult> readDataType(final GoogleApiClient var1, String var2) {
      return var1.method_942(new class_91.class_1347(var1) {
         // $FF: renamed from: Vd com.google.android.gms.fitness.request.j
         // $FF: synthetic field
         final class_500 field_172;

         {
            this.field_172 = var3;
         }

         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1271(class_91 var1) throws RemoteException {
            class_785.class_1335 var2 = new class_785.class_1335(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_755(this.field_172, var2, var3);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1272(var1);
         }

         // $FF: renamed from: w (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.DataTypeResult
         protected DataTypeResult method_1272(Status var1) {
            return DataTypeResult.method_5391(var1);
         }
      });
   }

   private static class class_1335 extends class_137.class_1316 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<DataTypeResult> field_2605;

      private class_1335(BaseImplementation.class_1058<DataTypeResult> var1) {
         this.field_2605 = var1;
      }

      // $FF: synthetic method
      class_1335(BaseImplementation.class_1058 var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.result.DataTypeResult) void
      public void method_739(DataTypeResult var1) {
         this.field_2605.method_110(var1);
      }
   }
}
