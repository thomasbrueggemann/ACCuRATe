package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.google.android.gms.internal.class_15;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.class_186;
import com.google.android.gms.internal.class_188;
import com.google.android.gms.internal.class_35;
import com.google.android.gms.internal.class_367;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_374;
import com.google.android.gms.internal.class_376;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_431;
import com.google.android.gms.internal.class_433;
import com.google.android.gms.internal.class_434;
import com.google.android.gms.internal.class_44;
import com.google.android.gms.internal.class_457;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.dy
public final class class_435 extends class_44.class_885 {
   // $FF: renamed from: qm java.lang.Object
   private static final Object field_1914 = new Object();
   // $FF: renamed from: qn com.google.android.gms.internal.dy
   private static class_435 field_1915;
   private final Context mContext;
   // $FF: renamed from: qo com.google.android.gms.internal.ee
   private final class_35 field_1916;
   // $FF: renamed from: qp com.google.android.gms.internal.bj
   private final class_15 field_1917;
   // $FF: renamed from: qq com.google.android.gms.internal.az
   private final class_188 field_1918;

   class_435(Context var1, class_188 var2, class_15 var3, class_35 var4) {
      this.mContext = var1;
      this.field_1916 = var4;
      this.field_1917 = var3;
      this.field_1918 = var2;
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.az, com.google.android.gms.internal.bj, com.google.android.gms.internal.ee, com.google.android.gms.internal.dt) com.google.android.gms.internal.dv
   private static class_431 method_2610(final Context var0, class_188 var1, class_15 var2, class_35 var3, final class_433 var4) {
      class_370.method_2363("Starting ad request from service.");
      var2.init();
      class_377 var5 = new class_377(var0);
      if(var5.field_1650 == -1) {
         class_370.method_2363("Device is offline.");
         return new class_431(2);
      } else {
         final class_374 var6 = new class_374(var4.applicationInfo.packageName);
         if(var4.field_1904.extras != null) {
            String var15 = var4.field_1904.extras.getString("_ad");
            if(var15 != null) {
               return class_434.method_2601(var0, var4, var15);
            }
         }

         Location var7 = var2.method_30(250L);
         final String var8 = var1.method_1300();
         String var9 = class_434.method_2602(var4, var5, var7, var1.method_1301());
         if(var9 == null) {
            return new class_431(0);
         } else {
            final class_367.class_1262 var10 = method_2614(var9);
            class_371.field_1606.post(new Runnable() {
               public void run() {
                  class_369 var1 = class_369.method_2333(var0, new class_172(), false, false, (class_457)null, var4.field_1901);
                  var1.setWillNotDraw(true);
                  var6.method_2380(var1);
                  class_367 var2 = var1.method_2349();
                  var2.method_2325("/invalidRequest", var6.field_1614);
                  var2.method_2325("/loadAdURL", var6.field_1615);
                  var2.method_2325("/log", class_186.field_598);
                  var2.method_2322(var10);
                  class_370.method_2363("Loading the JS library.");
                  var1.loadUrl(var8);
               }
            });
            class_376 var12 = var6.method_2381();
            if(var12 != null && !TextUtils.isEmpty(var12.getUrl())) {
               boolean var13 = var12.method_2401();
               String var14 = null;
               if(var13) {
                  var14 = var3.method_189(var4.field_1905.packageName);
               }

               return method_2611(var0, var4.field_1901.field_1607, var12.getUrl(), var14, var12);
            } else {
               return new class_431(var6.getErrorCode());
            }
         }
      }
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ec) com.google.android.gms.internal.dv
   public static class_431 method_2611(Context param0, String param1, String param2, String param3, class_376 param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.az, com.google.android.gms.internal.bj, com.google.android.gms.internal.ee) com.google.android.gms.internal.dy
   public static class_435 method_2612(Context param0, class_188 param1, class_15 param2, class_35 param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String, java.util.Map, java.lang.String, int) void
   private static void method_2613(String var0, Map<String, List<String>> var1, String var2, int var3) {
      if(class_370.method_2362(2)) {
         class_370.method_2357("Http Response: {\n  URL:\n    " + var0 + "\n  Headers:");
         if(var1 != null) {
            Iterator var5 = var1.keySet().iterator();

            while(var5.hasNext()) {
               String var6 = (String)var5.next();
               class_370.method_2357("    " + var6 + ":");
               Iterator var7 = ((List)var1.get(var6)).iterator();

               while(var7.hasNext()) {
                  String var8 = (String)var7.next();
                  class_370.method_2357("      " + var8);
               }
            }
         }

         class_370.method_2357("  Body:");
         if(var2 != null) {
            for(int var4 = 0; var4 < Math.min(var2.length(), 100000); var4 += 1000) {
               class_370.method_2357(var2.substring(var4, Math.min(var2.length(), var4 + 1000)));
            }
         } else {
            class_370.method_2357("    null");
         }

         class_370.method_2357("  Response Code:\n    " + var3 + "\n}");
      }

   }

   // $FF: renamed from: s (java.lang.String) com.google.android.gms.internal.ez$a
   private static class_367.class_1262 method_2614(final String var0) {
      return new class_367.class_1262() {
         // $FF: renamed from: a (com.google.android.gms.internal.ey) void
         public void method_756(class_369 var1) {
            Object[] var2 = new Object[]{"AFMA_buildAdURL", var0};
            String var3 = String.format("javascript:%s(%s);", var2);
            class_370.method_2357("About to execute: " + var3);
            var1.loadUrl(var3);
         }
      };
   }

   // $FF: renamed from: b (com.google.android.gms.internal.dt) com.google.android.gms.internal.dv
   public class_431 method_206(class_433 var1) {
      return method_2610(this.mContext, this.field_1918, this.field_1917, this.field_1916, var1);
   }
}
