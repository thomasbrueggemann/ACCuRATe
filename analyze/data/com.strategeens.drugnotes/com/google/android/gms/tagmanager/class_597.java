package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_596;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.dd
abstract class class_597 extends class_596 {
   public class_597(String var1) {
      super(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.d$a, com.google.android.gms.internal.d$a, java.util.Map) boolean
   protected boolean method_3480(class_57.class_1084 var1, class_57.class_1084 var2, Map<String, class_57.class_1084> var3) {
      String var4 = class_635.method_3579(var1);
      String var5 = class_635.method_3579(var2);
      return var4 != class_635.method_3593() && var5 != class_635.method_3593()?this.method_3481(var4, var5, var3):false;
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.util.Map) boolean
   protected abstract boolean method_3481(String var1, String var2, Map<String, class_57.class_1084> var3);
}
