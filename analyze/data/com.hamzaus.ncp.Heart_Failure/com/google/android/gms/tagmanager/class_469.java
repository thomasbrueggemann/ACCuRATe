package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.p
class class_469 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2827;
   private final String aeR;

   static {
      field_2827 = class_445.field_2389.toString();
   }

   public class_469(String var1) {
      super(field_2827, new String[0]);
      this.aeR = var1;
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return true;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      return this.aeR == null?class_537.method_3020():class_537.method_3027(this.aeR);
   }
}
