package com.comscore.utils;

import android.content.Context;

public class Permissions {
   // $FF: renamed from: a java.lang.String[]
   private static String[] field_423 = null;

   public static Boolean check(Context var0, String var1) {
      Boolean var2 = Boolean.valueOf(false);
      if(field_423 == null) {
         try {
            field_423 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 4096).requestedPermissions;
         } catch (Exception var6) {
            ;
         }
      }

      String[] var3 = field_423;
      int var4 = 0;
      if(var3 != null) {
         while(var4 < field_423.length) {
            if(field_423[var4].equals(var1)) {
               return Boolean.valueOf(true);
            }

            ++var4;
         }
      }

      return var2;
   }
}
