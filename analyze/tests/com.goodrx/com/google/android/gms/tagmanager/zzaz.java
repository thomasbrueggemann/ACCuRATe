package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzrs;
import com.google.android.gms.tagmanager.zzdf;
import com.google.android.gms.tagmanager.zzn;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zzaz {
   private static com.google.android.gms.internal.zzag.zza zzK(Object var0) throws JSONException {
      return zzdf.zzR(zzL(var0));
   }

   static Object zzL(Object var0) throws JSONException {
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
               var2.put(var4, zzL(var1.get(var4)));
            }

            var0 = var2;
         }

         return var0;
      }
   }

   public static zzrs.zzc zzgi(String var0) throws JSONException {
      new JSONObject;
      com.google.android.gms.internal.zzag.zza var2 = zzK(JSONObjectInstrumentation.init(var0));
      zzrs.zzd var3 = zzrs.zzc.zzHK();

      for(int var4 = 0; var4 < var2.zzjz.length; ++var4) {
         var3.zzc(zzrs.zza.zzHH().zzb(com.google.android.gms.internal.zzae.zzfR.toString(), var2.zzjz[var4]).zzb(com.google.android.gms.internal.zzae.zzfG.toString(), zzdf.zzgt(zzn.zzFZ())).zzb(zzn.zzGa(), var2.zzjA[var4]).zzHJ());
      }

      return var3.zzHN();
   }
}
