package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_291;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionApi;

// $FF: renamed from: com.google.android.gms.internal.nb
public class class_771 implements ActivityRecognitionApi {
   public PendingResult<Status> removeActivityUpdates(final GoogleApiClient var1, final PendingIntent var2) {
      return var1.method_944(new class_771.class_1090(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.nk) void
         protected void method_1292(class_291 var1) throws RemoteException {
            var1.method_1854(var2);
            this.b(Status.field_3960);
         }
      });
   }

   public PendingResult<Status> requestActivityUpdates(final GoogleApiClient var1, final long var2, final PendingIntent var4) {
      return var1.method_944(new class_771.class_1090(var1) {
         // $FF: renamed from: a (com.google.android.gms.internal.nk) void
         protected void method_1291(class_291 var1) throws RemoteException {
            var1.method_1853(var2, var4);
            this.b(Status.field_3960);
         }
      });
   }

   private abstract static class class_1090 extends ActivityRecognition.class_1655<Status> {
      public class_1090(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1290(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1290(var1);
      }
   }
}
