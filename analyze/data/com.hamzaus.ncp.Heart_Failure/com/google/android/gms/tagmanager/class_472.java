package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_520;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.e
class class_472 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2830;
   private static final String aeh;
   private static final String aei;
   // $FF: renamed from: kM android.content.Context
   private final Context field_2831;

   static {
      field_2830 = class_445.field_2408.toString();
      aeh = class_444.field_2207.toString();
      aei = class_444.field_2210.toString();
   }

   public class_472(Context var1) {
      String var2 = field_2830;
      String[] var3 = new String[]{aei};
      super(var2, var3);
      this.field_2831 = var1;
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return true;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      class_52.class_816 var2 = (class_52.class_816)var1.get(aei);
      if(var2 == null) {
         return class_537.method_3020();
      } else {
         String var3 = class_537.method_3009(var2);
         class_52.class_816 var4 = (class_52.class_816)var1.get(aeh);
         String var5;
         if(var4 != null) {
            var5 = class_537.method_3009(var4);
         } else {
            var5 = null;
         }

         String var6 = class_520.method_2941(this.field_2831, var3, var5);
         return var6 != null?class_537.method_3027(var6):class_537.method_3020();
      }
   }
}
