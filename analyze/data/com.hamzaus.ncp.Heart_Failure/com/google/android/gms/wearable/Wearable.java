package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.class_148;
import com.google.android.gms.wearable.internal.au;
import com.google.android.gms.wearable.internal.class_235;
import com.google.android.gms.wearable.internal.class_695;
import com.google.android.gms.wearable.internal.class_713;
import com.google.android.gms.wearable.internal.class_769;
import com.google.android.gms.wearable.internal.class_772;

public class Wearable {
   public static final Api<Wearable.WearableOptions> API;
   public static final DataApi DataApi = new class_695();
   public static final MessageApi MessageApi = new class_772();
   public static final NodeApi NodeApi = new class_769();
   public static final class_148 alm = new class_713();
   // $FF: renamed from: yE com.google.android.gms.common.api.Api$c
   public static final Api.class_1077<au> field_3088 = new Api.class_1077();
   // $FF: renamed from: yF com.google.android.gms.common.api.Api$b
   private static final Api.class_1074<au, Wearable.WearableOptions> field_3089 = new Api.class_1074() {
      // $FF: renamed from: a (android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.wearable.Wearable$WearableOptions, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.wearable.internal.au
      public class_235 method_3280(Context var1, Looper var2, class_323 var3, Wearable.WearableOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         if(var4 == null) {
            new Wearable.WearableOptions(new Wearable.Builder(), null);
         }

         return new class_235(var1, var2, var5, var6);
      }

      public int getPriority() {
         return Integer.MAX_VALUE;
      }
   };

   static {
      API = new Api(field_3089, field_3088, new Scope[0]);
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
