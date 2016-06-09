package com.comscore.utils.id;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.comscore.utils.Storage;
import com.comscore.utils.Utils;

public class IdChecker {
   // $FF: renamed from: a java.lang.String[]
   private static final String[] field_447 = new String[]{"0123456789ABCDEF", "0123456789abcdef", "9774d56d682e549c", "9774D56D682E549C", "unknown", "UNKNOWN", "android_id", "ANDROID_ID"};
   // $FF: renamed from: b android.content.Context
   private Context field_448;
   // $FF: renamed from: c boolean
   private boolean field_449;
   // $FF: renamed from: d java.lang.String
   private String field_450;
   // $FF: renamed from: e com.comscore.utils.Storage
   private Storage field_451;

   public IdChecker(Context var1, Storage var2) {
      this.field_448 = var1;
      this.field_451 = var2;
      this.field_449 = false;
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String) boolean
   private boolean method_342(String var1, String var2) {
      String[] var3 = this.field_451.get(var2).split(";");
      int var4 = 0;

      boolean var6;
      while(true) {
         int var5 = var3.length;
         var6 = false;
         if(var4 >= var5) {
            break;
         }

         if(var3[var4].equals(var1)) {
            var6 = true;
            break;
         }

         ++var4;
      }

      return var6;
   }

   // $FF: renamed from: b () java.lang.String
   private String method_343() {
      int var1 = Integer.valueOf(VERSION.SDK_INT).intValue();
      String var2 = null;
      if(var1 >= 9) {
         var2 = Build.SERIAL;
      }

      return var2;
   }

   // $FF: renamed from: b (java.lang.String, java.lang.String) void
   private void method_344(String var1, String var2) {
      String var3 = this.field_451.get(var2);
      if(var3.length() > 0) {
         var1 = var3 + ";" + var1;
      }

      this.field_451.set(var2, var1);
   }

   // $FF: renamed from: c () java.lang.String
   private String method_345() {
      if(Integer.valueOf(VERSION.SDK_INT).intValue() >= 3) {
         String var1 = Secure.getString(this.field_448.getContentResolver(), "android_id");
         if(var1 != null && var1.length() > 0) {
            return var1;
         }
      }

      return null;
   }

   // $FF: renamed from: a () java.lang.String
   protected String method_346() {
      if(this.field_449) {
         return this.field_450;
      } else {
         this.field_449 = true;
         String var1 = this.method_343();
         if(var1 == null || var1.length() == 0) {
            var1 = this.method_345();
            if(var1 == null || var1.length() == 0) {
               return null;
            }
         }

         int var2 = 0;

         boolean var4;
         while(true) {
            int var3 = field_447.length;
            var4 = false;
            if(var2 >= var3) {
               break;
            }

            if(field_447[var2].equals(var1)) {
               var4 = true;
               break;
            }

            ++var2;
         }

         if(var4) {
            this.field_450 = var1;
            return var1;
         } else {
            return null;
         }
      }
   }

   public boolean checkCrossPublisherId(String var1) {
      if(var1 != null && var1.length() != 0) {
         String var2 = this.method_346();
         if(var2 != null && !this.method_342(var2, "adIdCheckData")) {
            this.method_344(var2, "adIdCheckData");
            if(Utils.md5(var2).equals(var1)) {
               return false;
            }
         }
      }

      return true;
   }

   public boolean checkVisitorId() {
      String var1 = this.method_346();
      if(var1 != null && !this.method_342(var1, "idCheckData")) {
         this.method_344(var1, "idCheckData");
         return false;
      } else {
         return true;
      }
   }
}
