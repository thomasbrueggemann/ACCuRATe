package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_537;
import com.google.android.gms.tagmanager.class_540;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ah
class class_479 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2838;
   private final class_540 aes;

   static {
      field_2838 = class_445.field_2394.toString();
   }

   public class_479(class_540 var1) {
      super(field_2838, new String[0]);
      this.aes = var1;
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return false;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      String var2 = this.aes.method_3067();
      return var2 == null?class_537.method_3020():class_537.method_3027(var2);
   }
}
