package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzbk extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_43;
   private final Context mContext;

   static {
      field_43 = com.google.android.gms.internal.zzad.zzce.toString();
   }

   public zzbk(Context var1) {
      super(field_43, new String[0]);
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
