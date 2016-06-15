package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_375;
import com.google.android.gms.internal.ey;
import java.math.BigInteger;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.ge
@ey
public final class class_383 {
   // $FF: renamed from: ut java.lang.Object
   private static final Object field_1192 = new Object();
   // $FF: renamed from: wt java.lang.String
   private static String field_1193;

   // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String) java.lang.String
   public static String method_2634(Context param0, String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (android.content.Context, java.lang.String, java.lang.String) void
   private static void method_2635(Context var0, String var1, String var2) {
      ClassLoader var4;
      Class var5;
      try {
         var4 = var0.createPackageContext(var2, 3).getClassLoader();
         var5 = Class.forName("com.google.ads.mediation.MediationAdapter", false, var4);
      } catch (Throwable var10) {
         field_1193 = "err";
         return;
      }

      BigInteger var6 = new BigInteger(new byte[1]);
      String[] var7 = var1.split(",");
      BigInteger var8 = var6;

      for(int var9 = 0; var9 < var7.length; ++var9) {
         if(class_375.method_2564(var4, var5, var7[var9])) {
            var8 = var8.setBit(var9);
         }
      }

      field_1193 = String.format(Locale.US, "%X", new Object[]{var8});
   }

   // $FF: renamed from: dr () java.lang.String
   public static String method_2636() {
      // $FF: Couldn't be decompiled
   }
}
