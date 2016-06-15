package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.internal.class_243;
import com.google.android.gms.internal.class_316;
import com.google.android.gms.internal.class_317;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.jh;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.GeofencingApi;

public class LocationServices {
   public static final Api<Api.NoOptions> API;
   public static FusedLocationProviderApi FusedLocationApi;
   public static GeofencingApi GeofencingApi;
   // $FF: renamed from: yE com.google.android.gms.common.api.Api$c
   private static final Api.class_1077<jh> field_2895 = new Api.class_1077();
   // $FF: renamed from: yF com.google.android.gms.common.api.Api$b
   private static final Api.class_1074<jh, Api.NoOptions> field_2896 = new Api.class_1074() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
      // $FF: synthetic method
      public Api.class_1073 method_400(Context var1, Looper var2, class_323 var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.method_3094(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      // $FF: renamed from: c (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.jh
      public class_243 method_3094(Context var1, Looper var2, class_323 var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new class_243(var1, var2, var5, var6, "locationServices");
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };

   static {
      API = new Api(field_2896, field_2895, new Scope[0]);
      FusedLocationApi = new class_317();
      GeofencingApi = new class_316();
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.internal.jh
   public static class_243 method_2991(GoogleApiClient var0) {
      boolean var1 = true;
      boolean var2;
      if(var0 != null) {
         var2 = var1;
      } else {
         var2 = false;
      }

      class_347.method_2168(var2, "GoogleApiClient parameter is required.");
      class_243 var3 = (class_243)var0.method_771(field_2895);
      if(var3 == null) {
         var1 = false;
      }

      class_347.method_2161(var1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
      return var3;
   }

   public abstract static class class_1002<R extends Result> extends class_797.class_1203<R, jh> {
      public class_1002() {
         super(LocationServices.field_2895);
      }
   }
}
