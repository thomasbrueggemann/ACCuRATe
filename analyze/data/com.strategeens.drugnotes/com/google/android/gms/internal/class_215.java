package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.dynamic.class_211;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.class_33;
import com.google.android.gms.internal.class_34;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_418;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.et
@ey
public final class class_215 extends g<ep> {
   // $FF: renamed from: td com.google.android.gms.internal.et
   private static final class_215 field_354 = new class_215();

   private class_215() {
      super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
   }

   // $FF: renamed from: c (android.app.Activity) boolean
   private static boolean method_1521(Activity var0) throws class_215.class_1205 {
      Intent var1 = var0.getIntent();
      if(!var1.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
         throw new class_215.class_1205("InAppPurchaseManager requires the useClientJar flag in intent extras.");
      } else {
         return var1.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
      }
   }

   // $FF: renamed from: e (android.app.Activity) com.google.android.gms.internal.eo
   public static class_34 method_1522(Activity var0) {
      try {
         if(method_1521(var0)) {
            class_368.method_2502("Using AdOverlay from the client jar.");
            return new class_418(var0);
         } else {
            class_34 var2 = field_354.method_1523(var0);
            return var2;
         }
      } catch (class_215.class_1205 var3) {
         class_368.method_2506(var3.getMessage());
         return null;
      }
   }

   // $FF: renamed from: f (android.app.Activity) com.google.android.gms.internal.eo
   private class_34 method_1523(Activity var1) {
      try {
         class_198 var4 = class_960.method_5293(var1);
         class_34 var5 = class_34.class_1216.method_2773(((class_33)this.L(var1)).method_191(var4));
         return var5;
      } catch (RemoteException var6) {
         class_368.method_2510("Could not create remote InAppPurchaseManager.", var6);
         return null;
      } catch (class_211.class_1565 var7) {
         class_368.method_2510("Could not create remote InAppPurchaseManager.", var7);
         return null;
      }
   }

   // $FF: renamed from: A (android.os.IBinder) com.google.android.gms.internal.ep
   protected class_33 method_1524(IBinder var1) {
      return class_33.class_1386.method_5388(var1);
   }

   // $FF: renamed from: d (android.os.IBinder) java.lang.Object
   // $FF: synthetic method
   protected Object method_1511(IBinder var1) {
      return this.method_1524(var1);
   }

   private static final class class_1205 extends Exception {
      public class_1205(String var1) {
         super(var1);
      }
   }
}
