package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_635;
import com.google.android.gms.tagmanager.class_674;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ac
class class_573 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2677;
   private static final String arp;
   private static final String arq;
   private static final String arr;
   private static final String ars;

   static {
      field_2677 = class_520.field_2235.toString();
      arp = class_519.field_2010.toString();
      arq = class_519.field_2073.toString();
      arr = class_519.field_2096.toString();
      ars = class_519.field_2081.toString();
   }

   public class_573() {
      String var1 = field_2677;
      String[] var2 = new String[]{arp};
      super(var1, var2);
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      class_57.class_1084 var2 = (class_57.class_1084)var1.get(arp);
      if(var2 != null && var2 != class_635.method_3594()) {
         String var3 = class_635.method_3579(var2);
         class_57.class_1084 var4 = (class_57.class_1084)var1.get(arr);
         String var5;
         if(var4 == null) {
            var5 = "text";
         } else {
            var5 = class_635.method_3579(var4);
         }

         class_57.class_1084 var6 = (class_57.class_1084)var1.get(ars);
         String var7;
         if(var6 == null) {
            var7 = "base16";
         } else {
            var7 = class_635.method_3579(var6);
         }

         class_57.class_1084 var8 = (class_57.class_1084)var1.get(arq);
         byte var9;
         if(var8 != null && class_635.method_3583(var8).booleanValue()) {
            var9 = 3;
         } else {
            var9 = 2;
         }

         byte[] var12;
         label64: {
            byte[] var14;
            try {
               if(!"text".equals(var5)) {
                  if("base16".equals(var5)) {
                     var12 = class_674.method_3827(var3);
                  } else if("base64".equals(var5)) {
                     var12 = Base64.decode(var3, var9);
                  } else {
                     if(!"base64url".equals(var5)) {
                        class_613.method_3491("Encode: unknown input format: " + var5);
                        class_57.class_1084 var11 = class_635.method_3594();
                        return var11;
                     }

                     var12 = Base64.decode(var3, var9 | 8);
                  }
                  break label64;
               }

               var14 = var3.getBytes();
            } catch (IllegalArgumentException var15) {
               class_613.method_3491("Encode: invalid input:");
               return class_635.method_3594();
            }

            var12 = var14;
         }

         String var13;
         if("base16".equals(var7)) {
            var13 = class_674.method_3828(var12);
         } else if("base64".equals(var7)) {
            var13 = Base64.encodeToString(var12, var9);
         } else {
            if(!"base64url".equals(var7)) {
               class_613.method_3491("Encode: unknown output format: " + var7);
               return class_635.method_3594();
            }

            var13 = Base64.encodeToString(var12, var9 | 8);
         }

         return class_635.method_3597(var13);
      } else {
         return class_635.method_3594();
      }
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
