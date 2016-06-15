package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.dynamic.class_176;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_410;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_49;
import com.google.android.gms.internal.df;

// $FF: renamed from: com.google.android.gms.internal.dj
public final class class_178 extends g<df> {
   // $FF: renamed from: pt com.google.android.gms.internal.dj
   private static final class_178 field_575 = new class_178();

   private class_178() {
      super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
   }

   // $FF: renamed from: b (android.app.Activity) boolean
   private static boolean method_1281(Activity var0) throws class_178.class_1104 {
      Intent var1 = var0.getIntent();
      if(!var1.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
         throw new class_178.class_1104("InAppPurchaseManager requires the useClientJar flag in intent extras.");
      } else {
         return var1.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
      }
   }

   // $FF: renamed from: d (android.app.Activity) com.google.android.gms.internal.de
   public static class_49 method_1282(Activity var0) {
      try {
         if(method_1281(var0)) {
            class_370.method_2363("Using AdOverlay from the client jar.");
            return new class_410(var0);
         } else {
            class_49 var2 = field_575.method_1283(var0);
            return var2;
         }
      } catch (class_178.class_1104 var3) {
         class_370.method_2358(var3.getMessage());
         return null;
      }
   }

   // $FF: renamed from: e (android.app.Activity) com.google.android.gms.internal.de
   private class_49 method_1283(Activity var1) {
      try {
         class_157 var4 = class_741.method_4178(var1);
         class_49 var5 = class_49.class_848.method_2521(((class_46)this.D(var1)).method_207(var4));
         return var5;
      } catch (RemoteException var6) {
         class_370.method_2361("Could not create remote InAppPurchaseManager.", var6);
         return null;
      } catch (class_176.class_1202 var7) {
         class_370.method_2361("Could not create remote InAppPurchaseManager.", var7);
         return null;
      }
   }

   // $FF: renamed from: d (android.os.IBinder) java.lang.Object
   // $FF: synthetic method
   protected Object method_1277(IBinder var1) {
      return this.method_1284(var1);
   }

   // $FF: renamed from: v (android.os.IBinder) com.google.android.gms.internal.df
   protected class_46 method_1284(IBinder var1) {
      return class_46.class_1041.method_4498(var1);
   }

   private static final class class_1104 extends Exception {
      public class_1104(String var1) {
         super(var1);
      }
   }
}
