package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.internal.class_161;
import com.google.android.gms.wearable.internal.class_235;

// $FF: renamed from: com.google.android.gms.wearable.internal.ae
public final class class_772 implements MessageApi {
   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.wearable.MessageApi$MessageListener, android.content.IntentFilter[]) com.google.android.gms.common.api.PendingResult
   private PendingResult<Status> method_4353(GoogleApiClient var1, final MessageApi.MessageListener var2, final IntentFilter[] var3) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_985(class_235 var1) throws RemoteException {
            var1.method_1467(this, var2, var3);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_884(Status var1) {
            return this.method_986(var1);
         }

         // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
         public Status method_986(Status var1) {
            return new Status(13);
         }
      });
   }

   public PendingResult<Status> addListener(GoogleApiClient var1, MessageApi.MessageListener var2) {
      return this.method_4353(var1, var2, (IntentFilter[])null);
   }

   public PendingResult<Status> removeListener(GoogleApiClient var1, final MessageApi.MessageListener var2) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_987(class_235 var1) throws RemoteException {
            var1.method_1466(this, var2);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_884(Status var1) {
            return this.method_988(var1);
         }

         // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
         public Status method_988(Status var1) {
            return new Status(13);
         }
      });
   }

   public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient var1, final String var2, final String var3, final byte[] var4) {
      return var1.method_772(new class_161() {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
         protected void method_989(class_235 var1) throws RemoteException {
            var1.method_1471(this, var2, var3, var4);
         }

         // $FF: renamed from: au (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.MessageApi$SendMessageResult
         protected MessageApi.SendMessageResult method_990(Status var1) {
            return new class_772.class_1008(var1, -1);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_884(Status var1) {
            return this.method_990(var1);
         }
      });
   }

   public static class class_1008 implements MessageApi.SendMessageResult {
      // $FF: renamed from: qX int
      private final int field_2788;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_2789;

      public class_1008(Status var1, int var2) {
         this.field_2789 = var1;
         this.field_2788 = var2;
      }

      public int getRequestId() {
         return this.field_2788;
      }

      public Status getStatus() {
         return this.field_2789;
      }
   }
}
