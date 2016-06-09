package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.zzar;
import com.google.android.gms.tagmanager.zzdd;
import com.google.android.gms.tagmanager.zzz;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class zzj extends zzdd {
   // $FF: renamed from: ID java.lang.String
   private static final String field_75;
   private static final String URL;
   private static final String zzbhF;
   private static final String zzbhG;
   static final String zzbhH;
   private static final Set<String> zzbhI;
   private final Context mContext;
   private final zzj.zza zzbhJ;

   static {
      field_75 = com.google.android.gms.internal.zzad.zzcJ.toString();
      URL = com.google.android.gms.internal.zzae.zzhZ.toString();
      zzbhF = com.google.android.gms.internal.zzae.zzdI.toString();
      zzbhG = com.google.android.gms.internal.zzae.zzhY.toString();
      zzbhH = "gtm_" + field_75 + "_unrepeatable";
      zzbhI = new HashSet();
   }

   public zzj(final Context var1) {
      this(var1, new zzj.zza() {
         public zzar zzFX() {
            return zzz.zzaX(var1);
         }
      });
   }

   zzj(Context var1, zzj.zza var2) {
      String var3 = field_75;
      String[] var4 = new String[]{URL};
      super(var3, var4);
      this.zzbhJ = var2;
      this.mContext = var1;
   }

   private boolean zzfL(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzR(Map<String, com.google.android.gms.internal.zzag.zza> param1) {
      // $FF: Couldn't be decompiled
   }

   boolean zzfM(String var1) {
      return this.mContext.getSharedPreferences(zzbhH, 0).contains(var1);
   }

   boolean zzfN(String var1) {
      return zzbhI.contains(var1);
   }

   public interface zza {
      zzar zzFX();
   }
}
