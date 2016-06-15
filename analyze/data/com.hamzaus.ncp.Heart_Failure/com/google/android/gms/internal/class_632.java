package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.class_236;
import com.google.android.gms.plus.internal.e;

// $FF: renamed from: com.google.android.gms.internal.kj
public final class class_632 implements Account {
   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.common.api.Api$c) com.google.android.gms.plus.internal.e
   private static e method_3626(GoogleApiClient var0, Api.class_1077<e> var1) {
      boolean var2 = true;
      boolean var3;
      if(var0 != null) {
         var3 = var2;
      } else {
         var3 = false;
      }

      class_347.method_2168(var3, "GoogleApiClient parameter is required.");
      class_347.method_2161(var0.isConnected(), "GoogleApiClient must be connected.");
      class_236 var4 = (class_236)var0.method_771(var1);
      if(var4 == null) {
         var2 = false;
      }

      class_347.method_2161(var2, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
      return var4;
   }

   public void clearDefaultAccount(GoogleApiClient var1) {
      method_3626(var1, Plus.field_896).clearDefaultAccount();
   }

   public String getAccountName(GoogleApiClient var1) {
      return method_3626(var1, Plus.field_896).getAccountName();
   }

   public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient var1) {
      return var1.method_773(new class_632.class_1270(null) {
         // $FF: renamed from: a (com.google.android.gms.plus.internal.e) void
         protected void method_934(class_236 var1) {
            var1.method_1488(this);
         }
      });
   }

   private abstract static class class_1270 extends Plus.class_817<Status> {
      private class_1270() {
      }

      // $FF: synthetic method
      class_1270(Object var1) {
         this();
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_933(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_933(Status var1) {
         return var1;
      }
   }
}
