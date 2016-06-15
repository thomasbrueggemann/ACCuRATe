package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_596;
import com.google.android.gms.tagmanager.class_635;
import com.google.android.gms.tagmanager.class_636;
import com.google.android.gms.tagmanager.dh;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.by
abstract class class_603 extends class_596 {
   public class_603(String var1) {
      super(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.d$a, com.google.android.gms.internal.d$a, java.util.Map) boolean
   protected boolean method_3480(class_57.class_1084 var1, class_57.class_1084 var2, Map<String, class_57.class_1084> var3) {
      class_636 var4 = class_635.method_3580(var1);
      class_636 var5 = class_635.method_3580(var2);
      return var4 != class_635.method_3591() && var5 != class_635.method_3591()?this.method_3482(var4, var5, var3):false;
   }

   // $FF: renamed from: a (com.google.android.gms.tagmanager.dh, com.google.android.gms.tagmanager.dh, java.util.Map) boolean
   protected abstract boolean method_3482(dh var1, dh var2, Map<String, class_57.class_1084> var3);
}
