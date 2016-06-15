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
import com.google.android.gms.internal.class_41;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_422;
import com.google.android.gms.internal.cp;

// $FF: renamed from: com.google.android.gms.internal.cn
public final class class_179 extends g<cp> {
   // $FF: renamed from: oQ com.google.android.gms.internal.cn
   private static final class_179 field_576 = new class_179();

   private class_179() {
      super("com.google.android.gms.ads.AdOverlayCreatorImpl");
   }

   // $FF: renamed from: a (android.app.Activity) com.google.android.gms.internal.co
   public static class_42 method_1285(Activity var0) {
      try {
         if(method_1286(var0)) {
            class_370.method_2363("Using AdOverlay from the client jar.");
            return new class_422(var0);
         } else {
            class_42 var2 = field_576.method_1287(var0);
            return var2;
         }
      } catch (class_179.class_1105 var3) {
         class_370.method_2358(var3.getMessage());
         return null;
      }
   }

   // $FF: renamed from: b (android.app.Activity) boolean
   private static boolean method_1286(Activity var0) throws class_179.class_1105 {
      Intent var1 = var0.getIntent();
      if(!var1.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
         throw new class_179.class_1105("Ad overlay requires the useClientJar flag in intent extras.");
      } else {
         return var1.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
      }
   }

   // $FF: renamed from: c (android.app.Activity) com.google.android.gms.internal.co
   private class_42 method_1287(Activity var1) {
      try {
         class_157 var4 = class_741.method_4178(var1);
         class_42 var5 = class_42.class_1039.method_2553(((class_41)this.D(var1)).method_202(var4));
         return var5;
      } catch (RemoteException var6) {
         class_370.method_2361("Could not create remote AdOverlay.", var6);
         return null;
      } catch (class_176.class_1202 var7) {
         class_370.method_2361("Could not create remote AdOverlay.", var7);
         return null;
      }
   }

   // $FF: renamed from: d (android.os.IBinder) java.lang.Object
   // $FF: synthetic method
   protected Object method_1277(IBinder var1) {
      return this.method_1288(var1);
   }

   // $FF: renamed from: l (android.os.IBinder) com.google.android.gms.internal.cp
   protected class_41 method_1288(IBinder var1) {
      return class_41.class_1037.method_4172(var1);
   }

   private static final class class_1105 extends Exception {
      public class_1105(String var1) {
         super(var1);
      }
   }
}
