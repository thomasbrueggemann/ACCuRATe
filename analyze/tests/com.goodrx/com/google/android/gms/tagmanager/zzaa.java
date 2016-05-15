package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzaa extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_53;
   private final Context mContext;

   static {
      field_53 = com.google.android.gms.internal.zzad.zzbY.toString();
   }

   public zzaa(Context var1) {
      super(field_53, new String[0]);
      this.mContext = var1;
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      String var2 = this.zzaY(this.mContext);
      return var2 == null?zzdf.zzHF():zzdf.zzR(var2);
   }

   protected String zzaY(Context var1) {
      return Secure.getString(var1.getContentResolver(), "android_id");
   }
}
