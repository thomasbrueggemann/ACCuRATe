package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.class_244;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.ix;

public final class Address {
   public static final Api<Address.AddressOptions> API;
   // $FF: renamed from: yE com.google.android.gms.common.api.Api$c
   static final Api.class_1077<ix> field_4083 = new Api.class_1077();
   // $FF: renamed from: yF com.google.android.gms.common.api.Api$b
   private static final Api.class_1074<ix, Address.AddressOptions> field_4084 = new Api.class_1074() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.identity.intents.Address$AddressOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.ix
      public class_244 method_3336(Context var1, Looper var2, class_323 var3, Address.AddressOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         class_347.method_2168(var1 instanceof Activity, "An Activity must be used for Address APIs");
         if(var4 == null) {
            var4 = new Address.AddressOptions();
         }

         return new class_244((Activity)var1, var2, var5, var6, var3.getAccountName(), var4.theme);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };

   static {
      API = new Api(field_4084, field_4083, new Scope[0]);
   }

   public static void requestUserAddress(GoogleApiClient var0, final UserAddressRequest var1, final int var2) {
      var0.method_772(new Address.class_1172() {
         // $FF: renamed from: a (com.google.android.gms.internal.ix) void
         protected void method_932(class_244 var1x) throws RemoteException {
            var1x.method_1701(var1, var2);
            this.b(Status.field_3880);
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

   private abstract static class class_1172 extends class_797.class_1203<Status, ix> {
      public class_1172() {
         super(Address.field_4083);
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_931(var1);
      }

      // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
      public Status method_931(Status var1) {
         return var1;
      }
   }
}
