package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.class_286;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_811;
import com.google.android.gms.internal.om;
import com.google.android.gms.panorama.PanoramaApi;

public final class Panorama {
   public static final Api<Api.NoOptions> API;
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   public static final Api.class_1394<om> field_4292 = new Api.class_1394();
   // $FF: renamed from: DR com.google.android.gms.common.api.Api$b
   static final Api.class_1391<om, Api.NoOptions> field_4293 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
      // $FF: synthetic method
      public Api.class_1390 method_442(Context var1, Looper var2, class_347 var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.method_5362(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      // $FF: renamed from: f (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.om
      public class_286 method_5362(Context var1, Looper var2, class_347 var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new class_286(var1, var2, var5, var6);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final PanoramaApi PanoramaApi;

   static {
      API = new Api(field_4293, field_4292, new Scope[0]);
      PanoramaApi = new class_811();
   }
}
