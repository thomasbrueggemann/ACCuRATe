package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.class_718;

// $FF: renamed from: com.google.android.gms.internal.mg
public class class_780 {
   // $FF: renamed from: UV java.lang.ThreadLocal
   private static final ThreadLocal<String> field_3438 = new ThreadLocal();

   // $FF: renamed from: bw (java.lang.String) java.lang.String
   public static String method_4401(String var0) {
      return method_4404(var0, (String)field_3438.get());
   }

   // $FF: renamed from: c (com.google.android.gms.fitness.data.DataSource) com.google.android.gms.fitness.data.DataSource
   public static DataSource method_4402(DataSource var0) {
      if(var0.method_3134()) {
         String var1 = (String)field_3438.get();
         if(!method_4403() && !var1.equals(var0.getAppPackageName())) {
            return var0.method_3132();
         }
      }

      return var0;
   }

   // $FF: renamed from: jN () boolean
   public static boolean method_4403() {
      String var0 = (String)field_3438.get();
      return var0 == null || var0.startsWith("com.google");
   }

   // $FF: renamed from: r (java.lang.String, java.lang.String) java.lang.String
   private static String method_4404(String var0, String var1) {
      if(var0 != null && var1 != null) {
         byte[] var2 = new byte[var0.length() + var1.length()];
         System.arraycopy(var0.getBytes(), 0, var2, 0, var0.length());
         System.arraycopy(var1.getBytes(), 0, var2, var0.length(), var1.length());
         return Integer.toHexString(class_718.method_4196(var2, 0, var2.length, 0));
      } else {
         return var0;
      }
   }
}
