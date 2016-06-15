package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.internal.class_135;
import com.google.android.gms.internal.class_139;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.lu;

// $FF: renamed from: com.google.android.gms.internal.lu
public interface class_91 extends Api.class_1390 {
   Context getContext();

   // $FF: renamed from: jM () com.google.android.gms.internal.lz
   class_139 method_441() throws DeadObjectException;

   public abstract static class class_1347<R extends Result> extends BaseImplementation.class_1057<R, lu> {
      public class_1347(GoogleApiClient var1) {
         super(Fitness.field_3856, var1);
      }
   }

   public static class class_1348 extends class_135.class_1365 {
      // $FF: renamed from: Ea com.google.android.gms.common.api.BaseImplementation$b
      private final BaseImplementation.class_1058<Status> field_2939;

      public class_1348(BaseImplementation.class_1058<Status> var1) {
         this.field_2939 = var1;
      }

      // $FF: renamed from: j (com.google.android.gms.common.api.Status) void
      public void method_737(Status var1) {
         this.field_2939.method_110(var1);
      }
   }

   public abstract static class class_1349 extends class_91.class_1347<Status> {
      class_1349(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      protected Status method_1275(Status var1) {
         boolean var2;
         if(!var1.isSuccess()) {
            var2 = true;
         } else {
            var2 = false;
         }

         class_335.method_2301(var2);
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      protected Result method_1109(Status var1) {
         return this.method_1275(var1);
      }
   }
}
