package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.dynamic.class_176;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.as;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_195;
import com.google.android.gms.internal.class_3;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_373;
import com.google.android.gms.internal.class_452;
import com.google.android.gms.internal.class_6;

// $FF: renamed from: com.google.android.gms.internal.ai
public final class class_181 extends g<as> {
   // $FF: renamed from: lP com.google.android.gms.internal.ai
   private static final class_181 field_578 = new class_181();

   private class_181() {
      super("com.google.android.gms.ads.AdManagerCreatorImpl");
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.am, java.lang.String, com.google.android.gms.internal.bt) com.google.android.gms.internal.ar
   public static class_6 method_1292(Context var0, class_172 var1, String var2, class_195 var3) {
      Object var4;
      if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0) == 0) {
         var4 = field_578.method_1293(var0, var1, var2, var3);
         if(var4 != null) {
            return (class_6)var4;
         }
      }

      class_370.method_2363("Using AdManager from the client jar.");
      var4 = new class_452(var0, var1, var2, var3, new class_373(5077000, 5077000, true));
      return (class_6)var4;
   }

   // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.am, java.lang.String, com.google.android.gms.internal.bt) com.google.android.gms.internal.ar
   private class_6 method_1293(Context var1, class_172 var2, String var3, class_195 var4) {
      try {
         class_157 var7 = class_741.method_4178(var1);
         class_6 var8 = class_6.class_996.method_2794(((class_3)this.D(var1)).method_7(var7, var2, var3, var4, 5077000));
         return var8;
      } catch (RemoteException var9) {
         class_370.method_2361("Could not create remote AdManager.", var9);
         return null;
      } catch (class_176.class_1202 var10) {
         class_370.method_2361("Could not create remote AdManager.", var10);
         return null;
      }
   }

   // $FF: renamed from: c (android.os.IBinder) com.google.android.gms.internal.as
   protected class_3 method_1294(IBinder var1) {
      return class_3.class_829.method_2009(var1);
   }

   // $FF: renamed from: d (android.os.IBinder) java.lang.Object
   // $FF: synthetic method
   protected Object method_1277(IBinder var1) {
      return this.method_1294(var1);
   }
}
