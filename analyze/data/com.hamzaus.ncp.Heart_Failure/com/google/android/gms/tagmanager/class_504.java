package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_497;
import com.google.android.gms.tagmanager.class_536;
import com.google.android.gms.tagmanager.class_537;
import com.google.android.gms.tagmanager.dg;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.bx
abstract class class_504 extends class_497 {
   public class_504(String var1) {
      super(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.d$a, com.google.android.gms.internal.d$a, java.util.Map) boolean
   protected boolean method_2906(class_52.class_816 var1, class_52.class_816 var2, Map<String, class_52.class_816> var3) {
      class_536 var4 = class_537.method_3010(var1);
      class_536 var5 = class_537.method_3010(var2);
      return var4 != class_537.method_3018() && var5 != class_537.method_3018()?this.method_2908(var4, var5, var3):false;
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.dg, com.google.android.gms.tagmanager.dg, java.util.Map) boolean
   protected abstract boolean method_2908(dg var1, dg var2, Map<String, class_52.class_816> var3);
}
