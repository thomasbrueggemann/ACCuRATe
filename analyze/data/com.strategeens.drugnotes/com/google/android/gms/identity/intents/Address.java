package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.class_289;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.mw;

public final class Address {
   public static final Api<Address.AddressOptions> API;
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   static final Api.class_1394<mw> field_4199 = new Api.class_1394();
   // $FF: renamed from: DR com.google.android.gms.common.api.Api$b
   private static final Api.class_1391<mw, Address.AddressOptions> field_4200 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.identity.intents.Address$AddressOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.mw
      public class_289 method_4001(Context var1, Looper var2, class_347 var3, Address.AddressOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         class_335.method_2308(var1 instanceof Activity, "An Activity must be used for Address APIs");
         if(var4 == null) {
            var4 = new Address.AddressOptions();
         }

         return new class_289((Activity)var1, var2, var5, var6, var3.getAccountName(), var4.theme);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };

   static {
      API = new Api(field_4200, field_4199, new Scope[0]);
   }

   public static void requestUserAddress(final GoogleApiClient var0, final UserAddressRequest var1, final int var2) {
      var0.method_942(new Address.class_1534(var0) {
         // $FF: renamed from: a (com.google.android.gms.internal.mw) void
         protected void method_1158(class_289 var1x) throws RemoteException {
            var1x.method_1846(var1, var2);
            this.b(Status.field_3960);
         }
      });
   }

   public static final class AddressOptions implements Api.HasOptions {
      public final int theme;

      public AddressOptions() {
         this.theme = 0;
      }

      public AddressOptions(int var1) {
         this.theme = var1;
      }
   }

   private abstract static class class_1534 extends BaseImplementation.class_1057<Status, mw> {
      public class_1534(GoogleApiClient var1) {
         super(Address.field_4199, var1);
      }

      // $FF: renamed from: b (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_1157(Status var1) {
         return var1;
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1157(var1);
      }
   }
}
