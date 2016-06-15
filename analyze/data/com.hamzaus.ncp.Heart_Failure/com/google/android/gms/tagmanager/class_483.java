package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_482;
import com.google.android.gms.tagmanager.class_537;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.w
class class_483 extends class_482 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2841;
   private static final String VALUE;
   private static final String afq;
   private final DataLayer aer;

   static {
      field_2841 = class_445.field_2438.toString();
      VALUE = class_444.field_2381.toString();
      afq = class_444.field_2203.toString();
   }

   public class_483(DataLayer var1) {
      String var2 = field_2841;
      String[] var3 = new String[]{VALUE};
      super(var2, var3);
      this.aer = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.d$a) void
   private void method_2887(class_52.class_816 var1) {
      if(var1 != null && var1 != class_537.method_3014()) {
         String var2 = class_537.method_3009(var1);
         if(var2 != class_537.method_3019()) {
            this.aer.method_3997(var2);
            return;
         }
      }

   }

   // $FF: renamed from: b (com.google.android.gms.internal.d$a) void
   private void method_2888(class_52.class_816 var1) {
      if(var1 != null && var1 != class_537.method_3014()) {
         Object var2 = class_537.method_3024(var1);
         if(var2 instanceof List) {
            Iterator var3 = ((List)var2).iterator();

            while(var3.hasNext()) {
               Object var4 = var3.next();
               if(var4 instanceof Map) {
                  Map var5 = (Map)var4;
                  this.aer.push(var5);
               }
            }
         }
      }

   }

   // $FF: renamed from: y (java.util.Map) void
   public void method_2886(Map<String, class_52.class_816> var1) {
      this.method_2888((class_52.class_816)var1.get(VALUE));
      this.method_2887((class_52.class_816)var1.get(afq));
   }
}
