package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_248;
import com.google.android.gms.internal.class_356;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_37;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_38;
import com.google.android.gms.internal.class_39;
import com.google.android.gms.internal.class_423;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_440;
import com.google.android.gms.internal.ey;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.fq
@ey
public final class class_427 extends class_38.class_1388 {
   // $FF: renamed from: ut java.lang.Object
   private static final Object field_1360 = new Object();
   // $FF: renamed from: uu com.google.android.gms.internal.fq
   private static class_427 field_1361;
   private final Context mContext;
   // $FF: renamed from: uv com.google.android.gms.internal.fw
   private final class_37 field_1362;
   // $FF: renamed from: uw com.google.android.gms.internal.cn
   private final class_39 field_1363;
   // $FF: renamed from: ux com.google.android.gms.internal.bm
   private final class_248 field_1364;

   class_427(Context var1, class_248 var2, class_39 var3, class_37 var4) {
      this.mContext = var1;
      this.field_1362 = var4;
      this.field_1363 = var3;
      this.field_1364 = var2;
   }

   // $FF: renamed from: I (java.lang.String) com.google.android.gms.internal.gv$a
   private static class_356.class_1535 method_2830(final String var0) {
      return new class_356.class_1535() {
         // $FF: renamed from: a (com.google.android.gms.internal.gu) void
         public void method_729(class_371 var1) {
            Object[] var2 = new Object[]{"AFMA_buildAdURL", var0};
            String var3 = String.format("javascript:%s(%s);", var2);
            class_368.method_2505("About to execute: " + var3);
            var1.loadUrl(var3);
         }
      };
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.bm, com.google.android.gms.internal.cn, com.google.android.gms.internal.fw, com.google.android.gms.internal.fh) com.google.android.gms.internal.fj
   private static class_438 method_2831(Context param0, class_248 param1, class_39 param2, class_37 param3, class_440 param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.fu) com.google.android.gms.internal.fj
   public static class_438 method_2832(Context param0, String param1, String param2, String param3, class_423 param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.bm, com.google.android.gms.internal.cn, com.google.android.gms.internal.fw) com.google.android.gms.internal.fq
   public static class_427 method_2833(Context param0, class_248 param1, class_39 param2, class_37 param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String, java.util.Map, java.lang.String, int) void
   private static void method_2834(String var0, Map<String, List<String>> var1, String var2, int var3) {
      if(class_368.method_2511(2)) {
         class_368.method_2505("Http Response: {\n  URL:\n    " + var0 + "\n  Headers:");
         if(var1 != null) {
            Iterator var5 = var1.keySet().iterator();

            while(var5.hasNext()) {
               String var6 = (String)var5.next();
               class_368.method_2505("    " + var6 + ":");
               Iterator var7 = ((List)var1.get(var6)).iterator();

               while(var7.hasNext()) {
                  String var8 = (String)var7.next();
                  class_368.method_2505("      " + var8);
               }
            }
         }

         class_368.method_2505("  Body:");
         if(var2 != null) {
            for(int var4 = 0; var4 < Math.min(var2.length(), 100000); var4 += 1000) {
               class_368.method_2505(var2.substring(var4, Math.min(var2.length(), var4 + 1000)));
            }
         } else {
            class_368.method_2505("    null");
         }

         class_368.method_2505("  Response Code:\n    " + var3 + "\n}");
      }

   }

   // $FF: renamed from: b (com.google.android.gms.internal.fh) com.google.android.gms.internal.fj
   public class_438 method_196(class_440 var1) {
      return method_2831(this.mContext, this.field_1364, this.field_1363, this.field_1362, var1);
   }
}
