package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_520;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.d
class class_570 implements DataLayer.class_1286 {
   // $FF: renamed from: kM android.content.Context
   private final Context field_3018;

   public class_570(Context var1) {
      this.field_3018 = var1;
   }

   // $FF: renamed from: x (java.util.Map) void
   public void method_823(Map<String, Object> var1) {
      Object var3;
      label22: {
         Object var2 = var1.get("gtm.url");
         if(var2 == null) {
            Object var5 = var1.get("gtm");
            if(var5 != null && var5 instanceof Map) {
               var3 = ((Map)var5).get("url");
               break label22;
            }
         }

         var3 = var2;
      }

      if(var3 != null && var3 instanceof String) {
         String var4 = Uri.parse((String)var3).getQueryParameter("referrer");
         if(var4 != null) {
            class_520.method_2944(this.field_3018, var4);
            return;
         }
      }

   }
}
