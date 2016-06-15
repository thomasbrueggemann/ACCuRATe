package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.drive.internal.r;

// $FF: renamed from: com.google.android.gms.drive.internal.q
abstract class class_205<R extends Result> extends BaseImplementation.class_1057<R, r> {
   public class_205(GoogleApiClient var1) {
      super(Drive.field_2928, var1);
   }

   abstract static class class_1096 extends q<Status> {
      class_1096(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      protected Status method_1303(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      protected Result method_1109(Status var1) {
         return this.method_1303(var1);
      }
   }
}
