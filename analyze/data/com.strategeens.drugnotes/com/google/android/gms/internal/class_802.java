package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.class_285;
import com.google.android.gms.plus.internal.e;

// $FF: renamed from: com.google.android.gms.internal.oy
public final class class_802 implements Account {
   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.common.api.Api$c) com.google.android.gms.plus.internal.e
   private static e method_4445(GoogleApiClient var0, Api.class_1394<e> var1) {
      boolean var2 = true;
      boolean var3;
      if(var0 != null) {
         var3 = var2;
      } else {
         var3 = false;
      }

      class_335.method_2308(var3, "GoogleApiClient parameter is required.");
      class_335.method_2302(var0.isConnected(), "GoogleApiClient must be connected.");
      class_285 var4 = (class_285)var0.method_941(var1);
      if(var4 == null) {
         var2 = false;
      }

      class_335.method_2302(var2, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
      return var4;
   }

   public void clearDefaultAccount(GoogleApiClient var1) {
      method_4445(var1, Plus.field_741).clearDefaultAccount();
   }

   public String getAccountName(GoogleApiClient var1) {
      return method_4445(var1, Plus.field_741).getAccountName();
   }

   public PendingResult<Status> revokeAccessAndDisconnect(final GoogleApiClient var1) {
      return var1.method_944(new class_802.class_1479(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_1227(class_285 var1) {
            var1.method_1828(this);
         }
      });
   }

   private abstract static class class_1479 extends Plus.class_1089<Status> {
      private class_1479(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      class_1479(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1226(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1226(var1);
      }
   }
}
