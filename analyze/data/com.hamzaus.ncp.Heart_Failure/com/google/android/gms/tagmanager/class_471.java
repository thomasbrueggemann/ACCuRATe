package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_537;
import com.google.android.gms.tagmanager.class_574;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.b
class class_471 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2829;
   private final class_574 aeg;

   static {
      field_2829 = class_445.field_2459.toString();
   }

   public class_471(Context var1) {
      this(class_574.method_3197(var1));
   }

   class_471(class_574 var1) {
      super(field_2829, new String[0]);
      this.aeg = var1;
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return false;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      String var2 = this.aeg.method_3202();
      return var2 == null?class_537.method_3020():class_537.method_3027(var2);
   }
}
