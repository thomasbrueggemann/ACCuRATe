package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.bz;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_631;
import com.google.android.gms.tagmanager.class_635;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// $FF: renamed from: com.google.android.gms.tagmanager.dm
class class_637 {
   // $FF: renamed from: a (com.google.android.gms.tagmanager.bz) com.google.android.gms.tagmanager.bz
   private static bz<class_57.class_1084> method_3612(bz<class_57.class_1084> var0) {
      try {
         class_631 var1 = new class_631(class_635.method_3597(method_3615(class_635.method_3579((class_57.class_1084)var0.getObject()))), var0.method_3564());
         return var1;
      } catch (UnsupportedEncodingException var3) {
         class_613.method_3495("Escape URI: unsupported encoding", var3);
         return var0;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.bz, int) com.google.android.gms.tagmanager.bz
   private static bz<class_57.class_1084> method_3613(bz<class_57.class_1084> var0, int var1) {
      if(!method_3616((class_57.class_1084)var0.getObject())) {
         class_613.method_3491("Escaping can only be applied to strings.");
         return var0;
      } else {
         switch(var1) {
         case 12:
            return method_3612(var0);
         default:
            class_613.method_3491("Unsupported Value Escaping: " + var1);
            return var0;
         }
      }
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.bz, int[]) com.google.android.gms.tagmanager.bz
   static bz<class_57.class_1084> method_3614(bz<class_57.class_1084> var0, int... var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         var0 = method_3613(var0, var1[var3]);
      }

      return var0;
   }

   // $FF: renamed from: dg (java.lang.String) java.lang.String
   static String method_3615(String var0) throws UnsupportedEncodingException {
      return URLEncoder.encode(var0, "UTF-8").replaceAll("\\+", "%20");
   }

   // $FF: renamed from: q (com.google.android.gms.internal.d$a) boolean
   private static boolean method_3616(class_57.class_1084 var0) {
      return class_635.method_3584(var0) instanceof String;
   }
}
