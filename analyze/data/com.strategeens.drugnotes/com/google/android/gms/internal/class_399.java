package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.class_26;
import com.google.android.gms.internal.class_296;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_384;
import com.google.android.gms.internal.hx;

// $FF: renamed from: com.google.android.gms.internal.hc
public final class class_399 {
   // $FF: renamed from: CG com.google.android.gms.common.api.Api$c
   public static final Api.class_1394<hx> field_1235 = new Api.class_1394();
   // $FF: renamed from: CH com.google.android.gms.common.api.Api$b
   private static final Api.class_1391<hx, Api.NoOptions> field_1236 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.hx
      public class_296 method_3225(Context var1, Looper var2, class_347 var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new class_296(var1, var2, var5, var6);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   // $FF: renamed from: CI com.google.android.gms.common.api.Api
   public static final Api<Api.NoOptions> field_1237;
   // $FF: renamed from: CJ com.google.android.gms.internal.ht
   public static final class_26 field_1238;

   static {
      field_1237 = new Api(field_1236, field_1235, new Scope[0]);
      field_1238 = new class_384();
   }
}
