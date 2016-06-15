package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.class_291;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_771;
import com.google.android.gms.internal.nk;
import com.google.android.gms.location.ActivityRecognitionApi;

public class ActivityRecognition {
   public static final Api<Api.NoOptions> API;
   public static ActivityRecognitionApi ActivityRecognitionApi;
   public static final String CLIENT_NAME = "activity_recognition";
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   private static final Api.class_1394<nk> field_3854 = new Api.class_1394();
   // $FF: renamed from: DR com.google.android.gms.common.api.Api$b
   private static final Api.class_1391<nk, Api.NoOptions> field_3855 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
      // $FF: synthetic method
      public Api.class_1390 method_442(Context var1, Looper var2, class_347 var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.method_5800(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      // $FF: renamed from: e (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.nk
      public class_291 method_5800(Context var1, Looper var2, class_347 var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new class_291(var1, var2, var1.getPackageName(), var5, var6, "activity_recognition");
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };

   static {
      API = new Api(field_3855, field_3854, new Scope[0]);
      ActivityRecognitionApi = new class_771();
   }

   public abstract static class class_1655<R extends Result> extends BaseImplementation.class_1057<R, nk> {
      public class_1655(GoogleApiClient var1) {
         super(ActivityRecognition.field_3854, var1);
      }
   }
}
