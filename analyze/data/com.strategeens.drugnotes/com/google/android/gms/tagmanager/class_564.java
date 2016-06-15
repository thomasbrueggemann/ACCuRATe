package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_635;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.tagmanager.s
class class_564 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2666;
   private static final String aqO;
   private static final String aqf;
   private final class_564.class_1657 aqP;

   static {
      field_2666 = class_520.field_2194.toString();
      aqO = class_519.field_2035.toString();
      aqf = class_519.field_1999.toString();
   }

   public class_564(class_564.class_1657 var1) {
      String var2 = field_2666;
      String[] var3 = new String[]{aqO};
      super(var2, var3);
      this.aqP = var1;
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      String var2 = class_635.method_3579((class_57.class_1084)var1.get(aqO));
      HashMap var3 = new HashMap();
      class_57.class_1084 var4 = (class_57.class_1084)var1.get(aqf);
      if(var4 != null) {
         Object var7 = class_635.method_3584(var4);
         if(!(var7 instanceof Map)) {
            class_613.method_3494("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
            return class_635.method_3594();
         }

         Iterator var8 = ((Map)var7).entrySet().iterator();

         while(var8.hasNext()) {
            Entry var9 = (Entry)var8.next();
            var3.put(var9.getKey().toString(), var9.getValue());
         }
      }

      try {
         class_57.class_1084 var6 = class_635.method_3597(this.aqP.method_1065(var2, var3));
         return var6;
      } catch (Exception var10) {
         class_613.method_3494("Custom macro/tag " + var2 + " threw exception " + var10.getMessage());
         return class_635.method_3594();
      }
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return false;
   }

   public interface class_1657 {
      // $FF: renamed from: b (java.lang.String, java.util.Map) java.lang.Object
      Object method_1065(String var1, Map<String, Object> var2);
   }
}
