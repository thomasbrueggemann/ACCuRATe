package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_243;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionApi;

// $FF: renamed from: com.google.android.gms.internal.jb
public class class_318 implements ActivityRecognitionApi {
   public PendingResult<Status> removeActivityUpdates(GoogleApiClient var1, final PendingIntent var2) {
      return var1.method_773(new class_318.class_1251(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.jh) void
         protected void method_923(class_243 var1) throws RemoteException {
            var1.removeActivityUpdates(var2);
            this.b(Status.field_3880);
         }
      });
   }

   public PendingResult<Status> requestActivityUpdates(GoogleApiClient var1, final long var2, final PendingIntent var4) {
      return var1.method_773(new class_318.class_1251(null) {
         // $FF: renamed from: a (com.google.android.gms.internal.jh) void
         protected void method_924(class_243 var1) throws RemoteException {
            var1.requestActivityUpdates(var2, var4);
            this.b(Status.field_3880);
         }
      });
   }

   private abstract static class class_1251 extends ActivityRecognition.class_1290<Status> {
      private class_1251() {
      }

      // $FF: synthetic method
      class_1251(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_922(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_922(Status var1) {
         return var1;
      }
   }
}
