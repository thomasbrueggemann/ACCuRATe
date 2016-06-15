package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_537;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.cc
abstract class class_497 extends class_464 {
   private static final String afv;
   private static final String ags;

   static {
      afv = class_444.field_2234.toString();
      ags = class_444.field_2235.toString();
   }

   public class_497(String var1) {
      String[] var2 = new String[]{afv, ags};
      super(var1, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.d$a, com.google.android.gms.internal.d$a, java.util.Map) boolean
   protected abstract boolean method_2906(class_52.class_816 var1, class_52.class_816 var2, Map<String, class_52.class_816> var3);

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return true;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      Iterator var2 = var1.values().iterator();

      while(var2.hasNext()) {
         if((class_52.class_816)var2.next() == class_537.method_3020()) {
            return class_537.method_3027(Boolean.valueOf(false));
         }
      }

      class_52.class_816 var3 = (class_52.class_816)var1.get(afv);
      class_52.class_816 var4 = (class_52.class_816)var1.get(ags);
      boolean var5;
      if(var3 != null && var4 != null) {
         var5 = this.method_2906(var3, var4, var1);
      } else {
         var5 = false;
      }

      return class_537.method_3027(Boolean.valueOf(var5));
   }
}
