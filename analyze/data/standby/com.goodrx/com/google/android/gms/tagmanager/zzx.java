package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzdd;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class zzx extends zzdd {
   // $FF: renamed from: ID java.lang.String
   private static final String field_76;
   private static final String VALUE;
   private static final String zzbiL;
   private final DataLayer zzbhN;

   static {
      field_76 = com.google.android.gms.internal.zzad.zzcg.toString();
      VALUE = com.google.android.gms.internal.zzae.zzih.toString();
      zzbiL = com.google.android.gms.internal.zzae.zzes.toString();
   }

   public zzx(DataLayer var1) {
      String var2 = field_76;
      String[] var3 = new String[]{VALUE};
      super(var2, var3);
      this.zzbhN = var1;
   }

   private void zza(com.google.android.gms.internal.zzag.zza var1) {
      if(var1 != null && var1 != zzdf.zzHz()) {
         String var2 = zzdf.zzg(var1);
         if(var2 != zzdf.zzHE()) {
            this.zzbhN.zzfX(var2);
            return;
         }
      }

   }

   private void zzb(com.google.android.gms.internal.zzag.zza var1) {
      if(var1 != null && var1 != zzdf.zzHz()) {
         Object var2 = zzdf.zzl(var1);
         if(var2 instanceof List) {
            Iterator var3 = ((List)var2).iterator();

            while(var3.hasNext()) {
               Object var4 = var3.next();
               if(var4 instanceof Map) {
                  Map var5 = (Map)var4;
                  this.zzbhN.push(var5);
               }
            }
         }
      }

   }

   public void zzR(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      this.zzb((com.google.android.gms.internal.zzag.zza)var1.get(VALUE));
      this.zza((com.google.android.gms.internal.zzag.zza)var1.get(zzbiL));
   }
}
