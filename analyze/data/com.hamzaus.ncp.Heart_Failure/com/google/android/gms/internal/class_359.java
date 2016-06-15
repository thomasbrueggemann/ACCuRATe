package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.class_188;
import com.google.android.gms.internal.class_199;
import com.google.android.gms.internal.class_239;
import com.google.android.gms.internal.class_358;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_382;
import com.google.android.gms.internal.class_428;
import com.google.android.gms.internal.class_431;
import com.google.android.gms.internal.class_433;
import com.google.android.gms.internal.class_435;
import com.google.android.gms.internal.class_44;

// $FF: renamed from: com.google.android.gms.internal.dr
public abstract class class_359 extends class_358 {
   // $FF: renamed from: nc com.google.android.gms.internal.dt
   private final class_433 field_1545;
   // $FF: renamed from: pR com.google.android.gms.internal.dq$a
   private final class_428.class_826 field_1546;

   public class_359(class_433 var1, class_428.class_826 var2) {
      this.field_1545 = var1;
      this.field_1546 = var2;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.dx, com.google.android.gms.internal.dt) com.google.android.gms.internal.dv
   private static class_431 method_2262(class_44 var0, class_433 var1) {
      try {
         class_431 var5 = var0.method_206(var1);
         return var5;
      } catch (RemoteException var6) {
         class_370.method_2361("Could not fetch ad response from ad request service.", var6);
         return null;
      } catch (NullPointerException var7) {
         class_370.method_2361("Could not fetch ad response from ad request service due to an Exception.", var7);
         return null;
      } catch (SecurityException var8) {
         class_370.method_2361("Could not fetch ad response from ad request service due to an Exception.", var8);
         return null;
      }
   }

   // $FF: renamed from: bc () void
   public final void method_2261() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: bn () void
   public abstract void method_2263();

   // $FF: renamed from: bo () com.google.android.gms.internal.dx
   public abstract class_44 method_2264();

   public final void onStop() {
      this.method_2263();
   }

   public static final class class_1010 extends class_359 {
      private final Context mContext;

      public class_1010(Context var1, class_433 var2, class_428.class_826 var3) {
         super(var2, var3);
         this.mContext = var1;
      }

      // $FF: renamed from: bn () void
      public void method_2263() {
      }

      // $FF: renamed from: bo () com.google.android.gms.internal.dx
      public class_44 method_2264() {
         class_188 var1 = new class_188();
         return class_435.method_2612(this.mContext, var1, new class_199(), new class_382());
      }
   }

   public static final class class_1009 extends class_359 implements GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener {
      // $FF: renamed from: lq java.lang.Object
      private final Object field_1547 = new Object();
      // $FF: renamed from: pR com.google.android.gms.internal.dq$a
      private final class_428.class_826 field_1548;
      // $FF: renamed from: pS com.google.android.gms.internal.ds
      private final class_239 field_1549;

      public class_1009(Context var1, class_433 var2, class_428.class_826 var3) {
         super(var2, var3);
         this.field_1548 = var3;
         this.field_1549 = new class_239(var1, this, this, var2.field_1901.field_1609);
         this.field_1549.connect();
      }

      // $FF: renamed from: bn () void
      public void method_2263() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: bo () com.google.android.gms.internal.dx
      public class_44 method_2264() {
         // $FF: Couldn't be decompiled
      }

      public void onConnected(Bundle var1) {
         this.start();
      }

      public void onConnectionFailed(ConnectionResult var1) {
         this.field_1548.method_71(new class_431(0));
      }

      public void onDisconnected() {
         class_370.method_2363("Disconnected from remote ad request service.");
      }
   }
}
