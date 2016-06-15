package com.google.android.gms.internal;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_745;
import com.google.android.gms.internal.kf;
import com.google.android.gms.internal.kg;

// $FF: renamed from: com.google.android.gms.internal.kf
abstract class class_204<R extends Result> extends BaseImplementation.class_1057<R, kg> {
   public class_204(GoogleApiClient var1) {
      super(class_745.field_3405, var1);
   }

   abstract static class class_1201 extends kf<Status> {
      public class_1201(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1205(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1205(var1);
      }
   }
}
