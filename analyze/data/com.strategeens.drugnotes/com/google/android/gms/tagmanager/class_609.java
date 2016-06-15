package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_565;
import com.google.android.gms.tagmanager.class_635;
import com.google.android.gms.tagmanager.class_639;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.tagmanager.ba
class class_609 {
   // $FF: renamed from: cI (java.lang.String) com.google.android.gms.tagmanager.cr$c
   public static class_639.class_1684 method_3483(String var0) throws JSONException {
      class_57.class_1084 var1 = method_3484(new JSONObject(var0));
      class_639.class_1685 var2 = class_639.class_1684.method_5555();

      for(int var3 = 0; var3 < var1.field_735.length; ++var3) {
         var2.method_5550(class_639.class_1682.method_5509().method_5513(class_519.field_2097.toString(), var1.field_735[var3]).method_5513(class_519.field_2034.toString(), class_635.method_3574(class_565.method_3452())).method_5513(class_565.method_3453(), var1.field_736[var3]).method_5515());
      }

      return var2.method_5554();
   }

   // $FF: renamed from: n (java.lang.Object) com.google.android.gms.internal.d$a
   private static class_57.class_1084 method_3484(Object var0) throws JSONException {
      return class_635.method_3597(method_3485(var0));
   }

   // $FF: renamed from: o (java.lang.Object) java.lang.Object
   static Object method_3485(Object var0) throws JSONException {
      if(var0 instanceof JSONArray) {
         throw new RuntimeException("JSONArrays are not supported");
      } else if(JSONObject.NULL.equals(var0)) {
         throw new RuntimeException("JSON nulls are not supported");
      } else {
         if(var0 instanceof JSONObject) {
            JSONObject var1 = (JSONObject)var0;
            HashMap var2 = new HashMap();
            Iterator var3 = var1.keys();

            while(var3.hasNext()) {
               String var4 = (String)var3.next();
               var2.put(var4, method_3485(var1.get(var4)));
            }

            var0 = var2;
         }

         return var0;
      }
   }
}
