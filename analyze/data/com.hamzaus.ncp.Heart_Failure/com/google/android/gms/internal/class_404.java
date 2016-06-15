package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.class_240;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_36;
import com.google.android.gms.internal.class_392;
import com.google.android.gms.internal.fy;

// $FF: renamed from: com.google.android.gms.internal.fg
public final class class_404 {
   // $FF: renamed from: xF com.google.android.gms.common.api.Api$c
   public static final Api.class_1077<fy> field_1785 = new Api.class_1077();
   // $FF: renamed from: xG com.google.android.gms.common.api.Api$b
   private static final Api.class_1074<fy, Api.NoOptions> field_1786 = new Api.class_1074() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.common.api.Api$ApiOptions$NoOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.internal.fy
      public class_240 method_3856(Context var1, Looper var2, class_323 var3, Api.NoOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new class_240(var1, var2, var5, var6);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   // $FF: renamed from: xH com.google.android.gms.common.api.Api
   public static final Api<Api.NoOptions> field_1787;
   // $FF: renamed from: xI com.google.android.gms.internal.fu
   public static final class_36 field_1788;

   static {
      field_1787 = new Api(field_1786, field_1785, new Scope[0]);
      field_1788 = new class_392();
   }
}
