package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_635;
import com.google.android.gms.tagmanager.class_674;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ao
class class_592 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2696;
   private static final String arp;
   private static final String arr;
   private static final String arv;

   static {
      field_2696 = class_520.field_2237.toString();
      arp = class_519.field_2010.toString();
      arv = class_519.field_2001.toString();
      arr = class_519.field_2096.toString();
   }

   public class_592() {
      String var1 = field_2696;
      String[] var2 = new String[]{arp};
      super(var1, var2);
   }

   // $FF: renamed from: d (java.lang.String, byte[]) byte[]
   private byte[] method_3478(String var1, byte[] var2) throws NoSuchAlgorithmException {
      MessageDigest var3 = MessageDigest.getInstance(var1);
      var3.update(var2);
      return var3.digest();
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      class_57.class_1084 var2 = (class_57.class_1084)var1.get(arp);
      if(var2 != null && var2 != class_635.method_3594()) {
         String var3 = class_635.method_3579(var2);
         class_57.class_1084 var4 = (class_57.class_1084)var1.get(arv);
         String var5;
         if(var4 == null) {
            var5 = "MD5";
         } else {
            var5 = class_635.method_3579(var4);
         }

         class_57.class_1084 var6 = (class_57.class_1084)var1.get(arr);
         String var7;
         if(var6 == null) {
            var7 = "text";
         } else {
            var7 = class_635.method_3579(var6);
         }

         byte[] var8;
         if("text".equals(var7)) {
            var8 = var3.getBytes();
         } else {
            if(!"base16".equals(var7)) {
               class_613.method_3491("Hash: unknown input format: " + var7);
               return class_635.method_3594();
            }

            var8 = class_674.method_3827(var3);
         }

         try {
            class_57.class_1084 var10 = class_635.method_3597(class_674.method_3828(this.method_3478(var5, var8)));
            return var10;
         } catch (NoSuchAlgorithmException var11) {
            class_613.method_3491("Hash: unknown algorithm: " + var5);
            return class_635.method_3594();
         }
      } else {
         return class_635.method_3594();
      }
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
