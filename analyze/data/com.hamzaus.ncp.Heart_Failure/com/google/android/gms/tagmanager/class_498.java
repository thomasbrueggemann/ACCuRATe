package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_497;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.dc
abstract class class_498 extends class_497 {
   public class_498(String var1) {
      super(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.d$a, com.google.android.gms.internal.d$a, java.util.Map) boolean
   protected boolean method_2906(class_52.class_816 var1, class_52.class_816 var2, Map<String, class_52.class_816> var3) {
      String var4 = class_537.method_3009(var1);
      String var5 = class_537.method_3009(var2);
      return var4 != class_537.method_3019() && var5 != class_537.method_3019()?this.method_2907(var4, var5, var3):false;
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.util.Map) boolean
   protected abstract boolean method_2907(String var1, String var2, Map<String, class_52.class_816> var3);
}
