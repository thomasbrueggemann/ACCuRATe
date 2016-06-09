package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzf extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_60;
   private final Context mContext;

   static {
      field_60 = com.google.android.gms.internal.zzad.zzbt.toString();
   }

   public zzf(Context var1) {
      super(field_60, new String[0]);
      this.mContext = var1;
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      return zzdf.zzR(this.mContext.getPackageName());
   }
}
