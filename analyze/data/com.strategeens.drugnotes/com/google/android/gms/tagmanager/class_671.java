package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_618;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.d
class class_671 implements DataLayer.class_1643 {
   // $FF: renamed from: lM android.content.Context
   private final Context field_2908;

   public class_671(Context var1) {
      this.field_2908 = var1;
   }

   // $FF: renamed from: C (java.util.Map) void
   public void method_1009(Map<String, Object> var1) {
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
            class_618.method_3519(this.field_2908, var4);
            return;
         }
      }

   }
}
