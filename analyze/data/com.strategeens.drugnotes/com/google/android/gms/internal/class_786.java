package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.class_502;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.class_140;
import com.google.android.gms.internal.class_91;

// $FF: renamed from: com.google.android.gms.internal.mj
public class class_786 implements HistoryApi {
   public PendingResult<Status> deleteData(final GoogleApiClient var1, final DataDeleteRequest var2) {
      return var1.method_942(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1283(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_741(var2, var2x, var3);
         }
      });
   }

   public PendingResult<Status> insertData(final GoogleApiClient var1, final DataSet var2) {
      return var1.method_942(new class_91.class_1349(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1282(class_91 var1) throws RemoteException {
            class_91.class_1348 var2x = new class_91.class_1348(this);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_754((new class_502.class_1289()).method_3264(var2).method_3265(), var2x, var3);
         }
      });
   }

   public PendingResult<DataReadResult> readData(final GoogleApiClient var1, final DataReadRequest var2) {
      return var1.method_942(new class_91.class_1347(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.lu) void
         protected void method_1267(class_91 var1) throws RemoteException {
            class_786.class_1376 var2x = new class_786.class_1376(this, null);
            String var3 = var1.getContext().getPackageName();
            var1.method_441().method_742(var2, var2x, var3);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1268(var1);
         }

         // $FF: renamed from: x (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.DataReadResult
         protected DataReadResult method_1268(Status var1) {
            return DataReadResult.method_3977(var1, var2);
         }
      });
   }

   private static class class_1376 extends class_140.class_1105 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<DataReadResult> field_901;
      // $FF: renamed from: Vi int
      private int field_902;
      // $FF: renamed from: Vj com.google.android.gms.fitness.result.DataReadResult
      private DataReadResult field_903;

      private class_1376(BaseImplementation.class_1058<DataReadResult> var1) {
         this.field_902 = 0;
         this.field_903 = null;
         this.field_901 = var1;
      }

      // $FF: synthetic method
      class_1376(BaseImplementation.class_1058 var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.result.DataReadResult) void
      public void method_765(DataReadResult param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
