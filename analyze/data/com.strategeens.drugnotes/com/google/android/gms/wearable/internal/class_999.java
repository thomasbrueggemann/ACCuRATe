package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.internal.class_203;
import com.google.android.gms.wearable.internal.class_284;
import com.google.android.gms.wearable.internal.d;

// $FF: renamed from: com.google.android.gms.wearable.internal.ah
public final class class_999 implements MessageApi {
   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.wearable.MessageApi$MessageListener, android.content.IntentFilter[]) com.google.android.gms.common.api.PendingResult
   private PendingResult<Status> method_5498(GoogleApiClient var1, MessageApi.MessageListener var2, IntentFilter[] var3) {
      return var1.method_942(new class_999.class_1496(var1, var2, var3, null));
   }

   public PendingResult<Status> addListener(GoogleApiClient var1, MessageApi.MessageListener var2) {
      return this.method_5498(var1, var2, (IntentFilter[])null);
   }

   public PendingResult<Status> removeListener(final GoogleApiClient var1, final MessageApi.MessageListener var2) {
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1203(class_284 var1) throws RemoteException {
            var1.method_1807(this, var2);
         }

         // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
         public Status method_1204(Status var1) {
            return var1;
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         public Result method_1109(Status var1) {
            return this.method_1204(var1);
         }
      });
   }

   public PendingResult<MessageApi.SendMessageResult> sendMessage(final GoogleApiClient var1, final String var2, final String var3, final byte[] var4) {
      return var1.method_942(new class_203(var1) {
         // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
         protected void method_1201(class_284 var1) throws RemoteException {
            var1.method_1811(this, var2, var3, var4);
         }

         // $FF: renamed from: aI (com.google.android.gms.common.api.Status) com.google.android.gms.wearable.MessageApi$SendMessageResult
         protected MessageApi.SendMessageResult method_1202(Status var1) {
            return new class_999.class_1495(var1, -1);
         }

         // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
         // $FF: synthetic method
         protected Result method_1109(Status var1) {
            return this.method_1202(var1);
         }
      });
   }

   private static final class class_1496 extends d<Status> {
      private IntentFilter[] axD;
      private MessageApi.MessageListener axV;

      private class_1496(GoogleApiClient var1, MessageApi.MessageListener var2, IntentFilter[] var3) {
         super(var1);
         this.axV = var2;
         this.axD = var3;
      }

      // $FF: synthetic method
      class_1496(GoogleApiClient var1, MessageApi.MessageListener var2, IntentFilter[] var3, Object var4) {
         this(var1, var2, var3);
      }

      // $FF: renamed from: a (com.google.android.gms.wearable.internal.ba) void
      protected void method_1199(class_284 var1) throws RemoteException {
         var1.method_1808(this, this.axV, this.axD);
         this.axV = null;
         this.axD = null;
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1200(Status var1) {
         this.axV = null;
         this.axD = null;
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1200(var1);
      }
   }

   public static class class_1495 implements MessageApi.SendMessageResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_2969;
      // $FF: renamed from: ve int
      private final int field_2970;

      public class_1495(Status var1, int var2) {
         this.field_2969 = var1;
         this.field_2970 = var2;
      }

      public int getRequestId() {
         return this.field_2970;
      }

      public Status getStatus() {
         return this.field_2969;
      }
   }
}
