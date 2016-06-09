package com.google.android.gms.analytics.internal;

import android.content.res.XmlResourceParser;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.analytics.internal.zzc;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzp;

abstract class zzq<T extends zzp> extends zzc {
   zzq.zza<T> zzRx;

   public zzq(zzf var1, zzq.zza<T> var2) {
      super(var1);
      this.zzRx = var2;
   }

   private T zza(XmlResourceParser param1) {
      // $FF: Couldn't be decompiled
   }

   public T zzah(int var1) {
      try {
         zzp var3 = this.zza(this.zzji().zzjx().getResources().getXml(var1));
         return var3;
      } catch (NotFoundException var4) {
         this.zzd("inflate() called with unknown resourceId", var4);
         return null;
      }
   }

   public interface zza<U extends zzp> {
      void zzc(String var1, int var2);

      void zzf(String var1, boolean var2);

      void zzj(String var1, String var2);

      void zzk(String var1, String var2);

      U zzkq();
   }
}
