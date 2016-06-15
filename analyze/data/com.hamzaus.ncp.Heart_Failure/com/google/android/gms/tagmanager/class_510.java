package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_468;
import com.google.android.gms.tagmanager.class_537;
import com.google.android.gms.tagmanager.class_539;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.tagmanager.ba
class class_510 {
   // $FF: renamed from: bY (java.lang.String) com.google.android.gms.tagmanager.cq$c
   public static class_539.class_1301 method_2909(String var0) throws JSONException {
      class_52.class_816 var1 = method_2910(new JSONObject(var0));
      class_539.class_1302 var2 = class_539.class_1301.method_4219();

      for(int var3 = 0; var3 < var1.field_887.length; ++var3) {
         var2.method_4194(class_539.class_1299.method_4212().method_4216(class_444.field_2260.toString(), var1.field_887[var3]).method_4216(class_444.field_2301.toString(), class_537.method_3004(class_468.method_2884())).method_4216(class_468.method_2885(), var1.field_888[var3]).method_4218());
      }

      return var2.method_4198();
   }

   // $FF: renamed from: k (java.lang.Object) com.google.android.gms.internal.d$a
   private static class_52.class_816 method_2910(Object var0) throws JSONException {
      return class_537.method_3027(method_2911(var0));
   }

   // $FF: renamed from: l (java.lang.Object) java.lang.Object
   static Object method_2911(Object var0) throws JSONException {
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
               var2.put(var4, method_2911(var1.get(var4)));
            }

            var0 = var2;
         }

         return var0;
      }
   }
}
