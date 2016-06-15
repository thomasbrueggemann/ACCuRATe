package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.u
class class_466 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2824;
   private static final String NAME;
   private static final String aff;
   private final DataLayer aer;

   static {
      field_2824 = class_445.field_2388.toString();
      NAME = class_444.field_2332.toString();
      aff = class_444.field_2279.toString();
   }

   public class_466(DataLayer var1) {
      String var2 = field_2824;
      String[] var3 = new String[]{NAME};
      super(var2, var3);
      this.aer = var1;
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return false;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      Object var2 = this.aer.get(class_537.method_3009((class_52.class_816)var1.get(NAME)));
      if(var2 == null) {
         class_52.class_816 var3 = (class_52.class_816)var1.get(aff);
         return var3 != null?var3:class_537.method_3020();
      } else {
         return class_537.method_3027(var2);
      }
   }
}
