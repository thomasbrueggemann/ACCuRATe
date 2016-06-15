package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.internal.class_243;
import com.google.android.gms.internal.class_318;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.jh;
import com.google.android.gms.location.ActivityRecognitionApi;

public class ActivityRecognition {
   public static final Api<Api.NoOptions> API;
   public static ActivityRecognitionApi ActivityRecognitionApi;
   public static final String CLIENT_NAME = "activity_recognition";
   // $FF: renamed from: yE com.google.android.gms.common.api.Api$c
   private static final Api.class_1077<jh> field_3713 = new Api.class_1077();
   // $FF: renamed from: yF com.google.android.gms.common.api.Api$b
   private static final Api.class_1074<jh, Api.NoOptions> field_3714 = new Api.class_1074() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
      // $FF: synthetic method
      public Api.class_1073 method_400(Context var1, Looper var2, class_323 var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.method_4527(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      // $FF: renamed from: c (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.jh
      public class_243 method_4527(Context var1, Looper var2, class_323 var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new class_243(var1, var2, var5, var6, "activity_recognition");
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };

   static {
      API = new Api(field_3714, field_3713, new Scope[0]);
      ActivityRecognitionApi = new class_318();
   }

   public abstract static class class_1290<R extends Result> extends class_797.class_1203<R, jh> {
      public class_1290() {
         super(ActivityRecognition.field_3713);
      }
   }
}
