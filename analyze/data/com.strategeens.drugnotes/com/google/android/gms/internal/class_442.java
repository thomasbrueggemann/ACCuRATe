package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_294;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.ck
@ey
public final class class_442 {
   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ck$b) void
   public static void method_2886(Context var0, class_442.class_1520 var1) {
      if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0) != 0) {
         var1.method_641(class_242.method_1613());
      } else {
         new class_442.class_1519(var0, var1);
      }
   }

   public static final class class_1519 implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
      // $FF: renamed from: mH java.lang.Object
      private final Object field_3077;
      // $FF: renamed from: qe com.google.android.gms.internal.ck$b
      private final class_442.class_1520 field_3078;
      // $FF: renamed from: qf com.google.android.gms.internal.cl
      private final class_294 field_3079;

      public class_1519(Context var1, class_442.class_1520 var2) {
         this(var1, var2, false);
      }

      class_1519(Context var1, class_442.class_1520 var2, boolean var3) {
         this.field_3077 = new Object();
         this.field_3078 = var2;
         this.field_3079 = new class_294(var1, this, this, 6587000);
         if(!var3) {
            this.field_3079.connect();
         }

      }

      public void onConnected(Bundle param1) {
         // $FF: Couldn't be decompiled
      }

      public void onConnectionFailed(ConnectionResult var1) {
         this.field_3078.method_641(class_242.method_1613());
      }

      public void onConnectionSuspended(int var1) {
         class_368.method_2502("Disconnected from remote ad request service.");
      }
   }

   public interface class_1520 {
      // $FF: renamed from: a (android.os.Bundle) void
      void method_641(Bundle var1);
   }
}
