package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_520;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ax
class class_493 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2851;
   private static final String aeh;
   // $FF: renamed from: kM android.content.Context
   private final Context field_2852;

   static {
      field_2851 = class_445.field_2434.toString();
      aeh = class_444.field_2207.toString();
   }

   public class_493(Context var1) {
      super(field_2851, new String[0]);
      this.field_2852 = var1;
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return true;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      String var2;
      if((class_52.class_816)var1.get(aeh) != null) {
         var2 = class_537.method_3009((class_52.class_816)var1.get(aeh));
      } else {
         var2 = null;
      }

      String var3 = class_520.method_2943(this.field_2852, var2);
      return var3 != null?class_537.method_3027(var3):class_537.method_3020();
   }
}
