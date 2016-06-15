package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.class_144;
import com.google.android.gms.internal.class_292;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_744;
import com.google.android.gms.internal.kg;

// $FF: renamed from: com.google.android.gms.internal.kc
public final class class_745 {
   public static final Api<Api.NoOptions> API;
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   public static final Api.class_1394<kg> field_3405 = new Api.class_1394();
   // $FF: renamed from: DR com.google.android.gms.common.api.Api$b
   private static final Api.class_1391<kg, Api.NoOptions> field_3406 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, java.lang.Object, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
      // $FF: synthetic method
      public Api.class_1390 method_442(Context var1, Looper var2, class_347 var3, Object var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return this.method_5053(var1, var2, var3, (Api.NoOptions)var4, var5, var6);
      }

      // $FF: renamed from: c (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.kg
      public class_292 method_5053(Context var1, Looper var2, class_347 var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new class_292(var1, var2, var5, var6, new String[0]);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   // $FF: renamed from: Nu com.google.android.gms.internal.kd
   public static final class_144 field_3407;

   static {
      API = new Api(field_3406, field_3405, new Scope[0]);
      field_3407 = new class_744();
   }
}
