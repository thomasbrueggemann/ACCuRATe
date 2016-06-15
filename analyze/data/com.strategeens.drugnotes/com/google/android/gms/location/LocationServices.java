package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.class_291;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_764;
import com.google.android.gms.internal.class_765;
import com.google.android.gms.internal.nk;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.GeofencingApi;

public class LocationServices {
   public static final Api<Api.NoOptions> API;
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   private static final Api.class_1394<nk> field_2749 = new Api.class_1394();
   // $FF: renamed from: DR com.google.android.gms.common.api.Api$b
   private static final Api.class_1391<nk, Api.NoOptions> field_2750 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
      // $FF: synthetic method
      public Api.class_1390 method_442(Context var1, Looper var2, class_347 var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.method_3675(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      // $FF: renamed from: e (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.nk
      public class_291 method_3675(Context var1, Looper var2, class_347 var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new class_291(var1, var2, var1.getPackageName(), var5, var6, "locationServices", var3.getAccountName());
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static FusedLocationProviderApi FusedLocationApi;
   public static GeofencingApi GeofencingApi;

   static {
      API = new Api(field_2750, field_2749, new Scope[0]);
      FusedLocationApi = new class_764();
      GeofencingApi = new class_765();
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.GoogleApiClient) com.google.android.gms.internal.nk
   public static class_291 method_3570(GoogleApiClient var0) {
      boolean var1 = true;
      boolean var2;
      if(var0 != null) {
         var2 = var1;
      } else {
         var2 = false;
      }

      class_335.method_2308(var2, "GoogleApiClient parameter is required.");
      class_291 var3 = (class_291)var0.method_941(field_2749);
      if(var3 == null) {
         var1 = false;
      }

      class_335.method_2302(var1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
      return var3;
   }

   public abstract static class class_1331<R extends Result> extends BaseImplementation.class_1057<R, nk> {
      public class_1331(GoogleApiClient var1) {
         super(LocationServices.field_2749, var1);
      }
   }
}
