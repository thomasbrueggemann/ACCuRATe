package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_537;
import com.google.android.gms.tagmanager.class_573;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ao
class class_494 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2853;
   private static final String afB;
   private static final String afv;
   private static final String afx;

   static {
      field_2853 = class_445.field_2433.toString();
      afv = class_444.field_2234.toString();
      afB = class_444.field_2199.toString();
      afx = class_444.field_2259.toString();
   }

   public class_494() {
      String var1 = field_2853;
      String[] var2 = new String[]{afv};
      super(var1, var2);
   }

   // $FF: renamed from: c (java.lang.String, byte[]) byte[]
   private byte[] method_2904(String var1, byte[] var2) throws NoSuchAlgorithmException {
      MessageDigest var3 = MessageDigest.getInstance(var1);
      var3.update(var2);
      return var3.digest();
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
         class_52.class_816 var4 = (class_52.class_816)var1.get(afB);
         String var5;
         if(var4 == null) {
            var5 = "MD5";
         } else {
            var5 = class_537.method_3009(var4);
         }

         class_52.class_816 var6 = (class_52.class_816)var1.get(afx);
         String var7;
         if(var6 == null) {
            var7 = "text";
         } else {
            var7 = class_537.method_3009(var6);
         }

         byte[] var8;
         if("text".equals(var7)) {
            var8 = var3.getBytes();
         } else {
            if(!"base16".equals(var7)) {
               class_515.method_2916("Hash: unknown input format: " + var7);
               return class_537.method_3020();
            }

            var8 = class_573.method_3195(var3);
         }

         try {
            class_52.class_816 var10 = class_537.method_3027(class_573.method_3196(this.method_2904(var5, var8)));
            return var10;
         } catch (NoSuchAlgorithmException var11) {
            class_515.method_2916("Hash: unknown algorithm: " + var5);
            return class_537.method_3020();
         }
      } else {
         return class_537.method_3020();
      }
   }
}
