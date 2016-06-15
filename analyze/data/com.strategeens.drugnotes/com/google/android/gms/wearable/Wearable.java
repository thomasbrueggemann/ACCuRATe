package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.class_184;
import com.google.android.gms.wearable.class_185;
import com.google.android.gms.wearable.internal.ba;
import com.google.android.gms.wearable.internal.class_284;
import com.google.android.gms.wearable.internal.class_907;
import com.google.android.gms.wearable.internal.class_925;
import com.google.android.gms.wearable.internal.class_986;
import com.google.android.gms.wearable.internal.class_992;
import com.google.android.gms.wearable.internal.class_999;

public class Wearable {
   public static final Api<Wearable.WearableOptions> API;
   // $FF: renamed from: DQ com.google.android.gms.common.api.Api$c
   public static final Api.class_1394<ba> field_2949 = new Api.class_1394();
   // $FF: renamed from: DR com.google.android.gms.common.api.Api$b
   private static final Api.class_1391<ba, Wearable.WearableOptions> field_2950 = new Api.class_1391() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.wearable.Wearable$WearableOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.wearable.internal.ba
      public class_284 method_3894(Context var1, Looper var2, class_347 var3, Wearable.WearableOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         if(var4 == null) {
            new Wearable.WearableOptions(new Wearable.Builder(), null);
         }

         return new class_284(var1, var2, var5, var6);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };
   public static final DataApi DataApi = new class_907();
   public static final MessageApi MessageApi = new class_999();
   public static final NodeApi NodeApi = new class_986();
   public static final class_184 axl = new class_925();
   public static final class_185 axm = new class_992();

   static {
      API = new Api(field_2950, field_2949, new Scope[0]);
   }

   public static final class WearableOptions implements Api.Optional {
      private WearableOptions(Wearable.Builder var1) {
      }

      // $FF: synthetic method
      WearableOptions(Wearable.Builder var1, Object var2) {
         this(var1);
      }
   }

   public static class Builder {
      public Wearable.WearableOptions build() {
         return new Wearable.WearableOptions(this, null);
      }
   }
}
