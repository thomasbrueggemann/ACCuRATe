package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_537;
import com.google.android.gms.tagmanager.class_573;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ac
class class_476 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2835;
   private static final String afv;
   private static final String afw;
   private static final String afx;
   private static final String afy;

   static {
      field_2835 = class_445.field_2410.toString();
      afv = class_444.field_2234.toString();
      afw = class_444.field_2338.toString();
      afx = class_444.field_2259.toString();
      afy = class_444.field_2346.toString();
   }

   public class_476() {
      String var1 = field_2835;
      String[] var2 = new String[]{afv};
      super(var1, var2);
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return true;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      class_52.class_816 var2 = (class_52.class_816)var1.get(afv);
      if(var2 != null && var2 != class_537.method_3020()) {
         String var3 = class_537.method_3009(var2);
         class_52.class_816 var4 = (class_52.class_816)var1.get(afx);
         String var5;
         if(var4 == null) {
            var5 = "text";
         } else {
            var5 = class_537.method_3009(var4);
         }

         class_52.class_816 var6 = (class_52.class_816)var1.get(afy);
         String var7;
         if(var6 == null) {
            var7 = "base16";
         } else {
            var7 = class_537.method_3009(var6);
         }

         class_52.class_816 var8 = (class_52.class_816)var1.get(afw);
         byte var9;
         if(var8 != null && class_537.method_3022(var8).booleanValue()) {
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
                     var12 = class_573.method_3195(var3);
                  } else if("base64".equals(var5)) {
                     var12 = Base64.decode(var3, var9);
                  } else {
                     if(!"base64url".equals(var5)) {
                        class_515.method_2916("Encode: unknown input format: " + var5);
                        class_52.class_816 var11 = class_537.method_3020();
                        return var11;
                     }

                     var12 = Base64.decode(var3, var9 | 8);
                  }
                  break label64;
               }

               var14 = var3.getBytes();
            } catch (IllegalArgumentException var15) {
               class_515.method_2916("Encode: invalid input:");
               return class_537.method_3020();
            }

            var12 = var14;
         }

         String var13;
         if("base16".equals(var7)) {
            var13 = class_573.method_3196(var12);
         } else if("base64".equals(var7)) {
            var13 = Base64.encodeToString(var12, var9);
         } else {
            if(!"base64url".equals(var7)) {
               class_515.method_2916("Encode: unknown output format: " + var7);
               return class_537.method_3020();
            }

            var13 = Base64.encodeToString(var12, var9 | 8);
         }

         return class_537.method_3027(var13);
      } else {
         return class_537.method_3020();
      }
   }
}
