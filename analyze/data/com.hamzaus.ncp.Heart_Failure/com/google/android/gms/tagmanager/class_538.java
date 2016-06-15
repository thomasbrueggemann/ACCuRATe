package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.by;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_534;
import com.google.android.gms.tagmanager.class_537;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// $FF: renamed from: com.google.android.gms.tagmanager.dk
class class_538 {
   // $FF: renamed from: a (com.google.android.gms.tagmanager.by) com.google.android.gms.tagmanager.by
   private static by<class_52.class_816> method_3031(by<class_52.class_816> var0) {
      try {
         class_534 var1 = new class_534(class_537.method_3027(method_3034(class_537.method_3009((class_52.class_816)var0.getObject()))), var0.method_2990());
         return var1;
      } catch (UnsupportedEncodingException var3) {
         class_515.method_2920("Escape URI: unsupported encoding", var3);
         return var0;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.by, int) com.google.android.gms.tagmanager.by
   private static by<class_52.class_816> method_3032(by<class_52.class_816> var0, int var1) {
      if(!method_3035((class_52.class_816)var0.getObject())) {
         class_515.method_2916("Escaping can only be applied to strings.");
         return var0;
      } else {
         switch(var1) {
         case 12:
            return method_3031(var0);
         default:
            class_515.method_2916("Unsupported Value Escaping: " + var1);
            return var0;
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.by, int[]) com.google.android.gms.tagmanager.by
   static by<class_52.class_816> method_3033(by<class_52.class_816> var0, int... var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         var0 = method_3032(var0, var1[var3]);
      }

      return var0;
   }

   // $FF: renamed from: cv (java.lang.String) java.lang.String
   static String method_3034(String var0) throws UnsupportedEncodingException {
      return URLEncoder.encode(var0, "UTF-8").replaceAll("\\+", "%20");
   }

   // $FF: renamed from: q (com.google.android.gms.internal.d$a) boolean
   private static boolean method_3035(class_52.class_816 var0) {
      return class_537.method_3024(var0) instanceof String;
   }
}
