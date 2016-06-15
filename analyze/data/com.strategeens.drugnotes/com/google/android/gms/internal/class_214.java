package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.dynamic.class_211;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_464;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.internal.dy;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.dw
@ey
public final class class_214 extends g<dy> {
   // $FF: renamed from: sy com.google.android.gms.internal.dw
   private static final class_214 field_353 = new class_214();

   private class_214() {
      super("com.google.android.gms.ads.AdOverlayCreatorImpl");
   }

   // $FF: renamed from: b (android.app.Activity) com.google.android.gms.internal.dx
   public static class_52 method_1517(Activity var0) {
      try {
         if(method_1518(var0)) {
            class_368.method_2502("Using AdOverlay from the client jar.");
            return new class_464(var0);
         } else {
            class_52 var2 = field_353.method_1519(var0);
            return var2;
         }
      } catch (class_214.class_1204 var3) {
         class_368.method_2506(var3.getMessage());
         return null;
      }
   }

   // $FF: renamed from: c (android.app.Activity) boolean
   private static boolean method_1518(Activity var0) throws class_214.class_1204 {
      Intent var1 = var0.getIntent();
      if(!var1.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
         throw new class_214.class_1204("Ad overlay requires the useClientJar flag in intent extras.");
      } else {
         return var1.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
      }
   }

   // $FF: renamed from: d (android.app.Activity) com.google.android.gms.internal.dx
   private class_52 method_1519(Activity var1) {
      try {
         class_198 var4 = class_960.method_5293(var1);
         class_52 var5 = class_52.class_1202.method_2947(((class_51)this.L(var1)).method_219(var4));
         return var5;
      } catch (RemoteException var6) {
         class_368.method_2510("Could not create remote AdOverlay.", var6);
         return null;
      } catch (class_211.class_1565 var7) {
         class_368.method_2510("Could not create remote AdOverlay.", var7);
         return null;
      }
   }

   // $FF: renamed from: d (android.os.IBinder) java.lang.Object
   // $FF: synthetic method
   protected Object method_1511(IBinder var1) {
      return this.method_1520(var1);
   }

   // $FF: renamed from: q (android.os.IBinder) com.google.android.gms.internal.dy
   protected class_51 method_1520(IBinder var1) {
      return class_51.class_1118.method_2690(var1);
   }

   private static final class class_1204 extends Exception {
      public class_1204(String var1) {
         super(var1);
      }
   }
}
