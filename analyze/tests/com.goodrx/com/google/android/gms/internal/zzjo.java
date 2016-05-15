package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.internal.zzbx;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;

@zzhb
public class zzjo {
   private final Context mContext;
   private com.google.android.gms.ads.internal.overlay.zzk zzFo;
   private final ViewGroup zzNx;
   private final zzjp zzpD;

   public zzjo(Context var1, ViewGroup var2, zzjp var3) {
      this(var1, var2, var3, (com.google.android.gms.ads.internal.overlay.zzk)null);
   }

   zzjo(Context var1, ViewGroup var2, zzjp var3, com.google.android.gms.ads.internal.overlay.zzk var4) {
      this.mContext = var1;
      this.zzNx = var2;
      this.zzpD = var3;
      this.zzFo = var4;
   }

   public void onDestroy() {
      com.google.android.gms.common.internal.zzx.zzcD("onDestroy must be called from the UI thread.");
      if(this.zzFo != null) {
         this.zzFo.destroy();
      }

   }

   public void onPause() {
      com.google.android.gms.common.internal.zzx.zzcD("onPause must be called from the UI thread.");
      if(this.zzFo != null) {
         this.zzFo.pause();
      }

   }

   public void zza(int var1, int var2, int var3, int var4, int var5) {
      if(this.zzFo == null) {
         zzbx.zza(this.zzpD.zzic().zzdA(), this.zzpD.zzib(), new String[]{"vpr"});
         zzbz var7 = zzbx.zzb(this.zzpD.zzic().zzdA());
         this.zzFo = new com.google.android.gms.ads.internal.overlay.zzk(this.mContext, this.zzpD, var5, this.zzpD.zzic().zzdA(), var7);
         this.zzNx.addView(this.zzFo, 0, new LayoutParams(-1, -1));
         this.zzFo.zzd(var1, var2, var3, var4);
         this.zzpD.zzhU().zzG(false);
      }
   }

   public void zze(int var1, int var2, int var3, int var4) {
      com.google.android.gms.common.internal.zzx.zzcD("The underlay may only be modified from the UI thread.");
      if(this.zzFo != null) {
         this.zzFo.zzd(var1, var2, var3, var4);
      }

   }

   public com.google.android.gms.ads.internal.overlay.zzk zzhM() {
      com.google.android.gms.common.internal.zzx.zzcD("getAdVideoUnderlay must be called from the UI thread.");
      return this.zzFo;
   }
}
