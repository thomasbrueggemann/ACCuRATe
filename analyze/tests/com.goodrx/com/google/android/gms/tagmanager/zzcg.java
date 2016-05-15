package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzcg extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_48;
   private final Context mContext;

   static {
      field_48 = com.google.android.gms.internal.zzad.zzbR.toString();
   }

   public zzcg(Context var1) {
      super(field_48, new String[0]);
      this.mContext = var1;
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      DisplayMetrics var2 = new DisplayMetrics();
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(var2);
      int var3 = var2.widthPixels;
      int var4 = var2.heightPixels;
      return zzdf.zzR(var3 + "x" + var4);
   }
}
