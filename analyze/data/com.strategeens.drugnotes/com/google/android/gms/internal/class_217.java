package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.dynamic.class_211;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.be;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_450;
import com.google.android.gms.internal.class_5;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.class_6;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.au
@ey
public final class class_217 extends g<be> {
   // $FF: renamed from: oc com.google.android.gms.internal.au
   private static final class_217 field_356 = new class_217();

   private class_217() {
      super("com.google.android.gms.ads.AdManagerCreatorImpl");
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.ay, java.lang.String, com.google.android.gms.internal.cx) com.google.android.gms.internal.bd
   public static class_6 method_1528(Context var0, class_237 var1, String var2, class_450 var3) {
      Object var4;
      if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0) == 0) {
         var4 = field_356.method_1529(var0, var1, var2, var3);
         if(var4 != null) {
            return (class_6)var4;
         }
      }

      class_368.method_2502("Using AdManager from the client jar.");
      var4 = new class_548(var0, var1, var2, var3, new class_369(6587000, 6587000, true));
      return (class_6)var4;
   }

   // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.ay, java.lang.String, com.google.android.gms.internal.cx) com.google.android.gms.internal.bd
   private class_6 method_1529(Context var1, class_237 var2, String var3, class_450 var4) {
      try {
         class_198 var7 = class_960.method_5293(var1);
         class_6 var8 = class_6.class_1477.method_3313(((class_5)this.L(var1)).method_9(var7, var2, var3, var4, 6587000));
         return var8;
      } catch (RemoteException var9) {
         class_368.method_2510("Could not create remote AdManager.", var9);
         return null;
      } catch (class_211.class_1565 var10) {
         class_368.method_2510("Could not create remote AdManager.", var10);
         return null;
      }
   }

   // $FF: renamed from: c (android.os.IBinder) com.google.android.gms.internal.be
   protected class_5 method_1530(IBinder var1) {
      return class_5.class_1542.method_5842(var1);
   }

   // $FF: renamed from: d (android.os.IBinder) java.lang.Object
   // $FF: synthetic method
   protected Object method_1511(IBinder var1) {
      return this.method_1530(var1);
   }
}
