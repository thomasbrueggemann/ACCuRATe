package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjt;

@zzhb
public class zzjr {
   public zzjp zza(Context var1, AdSizeParcel var2, boolean var3, boolean var4, zzan var5, VersionInfoParcel var6, zzcb var7, com.google.android.gms.ads.internal.zzd var8) {
      zzjs var9 = new zzjs(zzjt.zzb(var1, var2, var3, var4, var5, var6, var7, var8));
      var9.setWebViewClient(com.google.android.gms.ads.internal.zzr.zzbE().zzb(var9, var4));
      var9.setWebChromeClient(com.google.android.gms.ads.internal.zzr.zzbE().zzk(var9));
      return var9;
   }
}
