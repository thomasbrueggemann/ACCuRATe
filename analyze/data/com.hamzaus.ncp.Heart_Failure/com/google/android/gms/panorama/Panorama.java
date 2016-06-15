package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_633;
import com.google.android.gms.internal.kh;
import com.google.android.gms.panorama.PanoramaApi;

public final class Panorama {
   public static final Api<Api.NoOptions> API;
   public static final PanoramaApi PanoramaApi;
   // $FF: renamed from: yE com.google.android.gms.common.api.Api$c
   public static final Api.class_1077<kh> field_4144 = new Api.class_1077();
   // $FF: renamed from: yF com.google.android.gms.common.api.Api$b
   static final Api.class_1074<kh, Api.NoOptions> field_4145 = new Api.class_1074() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
      // $FF: synthetic method
      public Api.class_1073 method_400(Context var1, Looper var2, class_323 var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.method_4257(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      // $FF: renamed from: d (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.kh
      public class_237 method_4257(Context var1, Looper var2, class_323 var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new class_237(var1, var2, var5, var6);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };

   static {
      API = new Api(field_4145, field_4144, new Scope[0]);
      PanoramaApi = new class_633();
   }
}
