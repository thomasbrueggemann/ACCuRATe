package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_537;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.tagmanager.s
class class_467 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2825;
   private static final String aeT;
   private static final String aej;
   private final class_467.class_1273 aeU;

   static {
      field_2825 = class_445.field_2395.toString();
      aeT = class_444.field_2302.toString();
      aej = class_444.field_2197.toString();
   }

   public class_467(class_467.class_1273 var1) {
      String var2 = field_2825;
      String[] var3 = new String[]{aeT};
      super(var2, var3);
      this.aeU = var1;
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return false;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      String var2 = class_537.method_3009((class_52.class_816)var1.get(aeT));
      HashMap var3 = new HashMap();
      class_52.class_816 var4 = (class_52.class_816)var1.get(aej);
      if(var4 != null) {
         Object var7 = class_537.method_3024(var4);
         if(!(var7 instanceof Map)) {
            class_515.method_2919("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
            return class_537.method_3020();
         }

         Iterator var8 = ((Map)var7).entrySet().iterator();

         while(var8.hasNext()) {
            Entry var9 = (Entry)var8.next();
            var3.put(var9.getKey().toString(), var9.getValue());
         }
      }

      try {
         class_52.class_816 var6 = class_537.method_3027(this.aeU.method_867(var2, var3));
         return var6;
      } catch (Exception var10) {
         class_515.method_2919("Custom macro/tag " + var2 + " threw exception " + var10.getMessage());
         return class_537.method_3020();
      }
   }

   public interface class_1273 {
      // $FF: renamed from: b (java.lang.String, java.util.Map) java.lang.Object
      Object method_867(String var1, Map<String, Object> var2);
   }
}
