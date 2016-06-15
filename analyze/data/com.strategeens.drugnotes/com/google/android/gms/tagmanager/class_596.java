package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.cd
abstract class class_596 extends class_561 {
   private static final String arp;
   private static final String ask;

   static {
      arp = class_519.field_2010.toString();
      ask = class_519.field_2011.toString();
   }

   public class_596(String var1) {
      String[] var2 = new String[]{arp, ask};
      super(var1, var2);
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      Iterator var2 = var1.values().iterator();

      while(var2.hasNext()) {
         if((class_57.class_1084)var2.next() == class_635.method_3594()) {
            return class_635.method_3597(Boolean.valueOf(false));
         }
      }

      class_57.class_1084 var3 = (class_57.class_1084)var1.get(arp);
      class_57.class_1084 var4 = (class_57.class_1084)var1.get(ask);
      boolean var5;
      if(var3 != null && var4 != null) {
         var5 = this.method_3480(var3, var4, var1);
      } else {
         var5 = false;
      }

      return class_635.method_3597(Boolean.valueOf(var5));
   }

   // $FF: renamed from: a (com.google.android.gms.internal.d$a, com.google.android.gms.internal.d$a, java.util.Map) boolean
   protected abstract boolean method_3480(class_57.class_1084 var1, class_57.class_1084 var2, Map<String, class_57.class_1084> var3);

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
