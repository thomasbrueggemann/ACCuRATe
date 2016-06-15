package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_248;
import com.google.android.gms.internal.class_295;
import com.google.android.gms.internal.class_360;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_38;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_427;
import com.google.android.gms.internal.class_433;
import com.google.android.gms.internal.class_435;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_440;
import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.ff
@ey
public abstract class class_361 extends class_360 {
   // $FF: renamed from: qh com.google.android.gms.internal.fh
   private final class_440 field_1080;
   // $FF: renamed from: tI com.google.android.gms.internal.fe$a
   private final class_435.class_1523 field_1081;

   public class_361(class_440 var1, class_435.class_1523 var2) {
      this.field_1080 = var1;
      this.field_1081 = var2;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.fl, com.google.android.gms.internal.fh) com.google.android.gms.internal.fj
   private static class_438 method_2465(class_38 var0, class_440 var1) {
      try {
         class_438 var6 = var0.method_196(var1);
         return var6;
      } catch (RemoteException var7) {
         class_368.method_2510("Could not fetch ad response from ad request service.", var7);
         return null;
      } catch (NullPointerException var8) {
         class_368.method_2510("Could not fetch ad response from ad request service due to an Exception.", var8);
         return null;
      } catch (SecurityException var9) {
         class_368.method_2510("Could not fetch ad response from ad request service due to an Exception.", var9);
         return null;
      } catch (Throwable var10) {
         class_381.method_2613(var10);
         return null;
      }
   }

   // $FF: renamed from: cJ () void
   public abstract void method_2466();

   // $FF: renamed from: cK () com.google.android.gms.internal.fl
   public abstract class_38 method_2467();

   // $FF: renamed from: cx () void
   public final void method_2464() {
      // $FF: Couldn't be decompiled
   }

   public final void onStop() {
      this.method_2466();
   }

   @ey
   public static final class class_1621 extends class_361 {
      private final Context mContext;

      public class_1621(Context var1, class_440 var2, class_435.class_1523 var3) {
         super(var2, var3);
         this.mContext = var1;
      }

      // $FF: renamed from: cJ () void
      public void method_2466() {
      }

      // $FF: renamed from: cK () com.google.android.gms.internal.fl
      public class_38 method_2467() {
         Bundle var1 = class_381.method_2605();
         class_248 var2 = new class_248(var1.getString("gads:sdk_core_location"), var1.getString("gads:sdk_core_experiment_id"), var1.getString("gads:block_autoclicks_experiment_id"), var1.getString("gads:spam_app_context:experiment_id"));
         return class_427.method_2833(this.mContext, var2, new class_444(), new class_433());
      }
   }

   @ey
   public static final class class_1622 extends class_361 implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
      // $FF: renamed from: mH java.lang.Object
      private final Object field_1082 = new Object();
      // $FF: renamed from: tI com.google.android.gms.internal.fe$a
      private final class_435.class_1523 field_1083;
      // $FF: renamed from: tJ com.google.android.gms.internal.fg
      private final class_295 field_1084;

      public class_1622(Context var1, class_440 var2, class_435.class_1523 var3) {
         super(var2, var3);
         this.field_1083 = var3;
         this.field_1084 = new class_295(var1, this, this, var2.field_1460.field_1123);
         this.field_1084.connect();
      }

      // $FF: renamed from: cJ () void
      public void method_2466() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: cK () com.google.android.gms.internal.fl
      public class_38 method_2467() {
         // $FF: Couldn't be decompiled
      }

      public void onConnected(Bundle var1) {
         this.start();
      }

      public void onConnectionFailed(ConnectionResult var1) {
         this.field_1083.method_666(new class_438(0));
      }

      public void onConnectionSuspended(int var1) {
         class_368.method_2502("Disconnected from remote ad request service.");
      }
   }
}
