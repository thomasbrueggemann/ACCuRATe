package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_537;
import java.util.Locale;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.bc
class class_496 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2855;

   static {
      field_2855 = class_445.field_2397.toString();
   }

   public class_496() {
      super(field_2855, new String[0]);
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return false;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      Locale var2 = Locale.getDefault();
      if(var2 == null) {
         return class_537.method_3020();
      } else {
         String var3 = var2.getLanguage();
         return var3 == null?class_537.method_3020():class_537.method_3027(var3.toLowerCase());
      }
   }
}
