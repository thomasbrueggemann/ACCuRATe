package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzax;
import java.util.Map;

class zzd implements DataLayer.zzb {
   private final Context context;

   public zzd(Context var1) {
      this.context = var1;
   }

   public void zzQ(Map<String, Object> var1) {
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
            zzax.zzn(this.context, var4);
            return;
         }
      }

   }
}
