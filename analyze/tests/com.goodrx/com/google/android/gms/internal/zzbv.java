package com.google.android.gms.internal;

import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzhb;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

@zzhb
public class zzbv {
   BlockingQueue<zzcb> zzxl;
   Map<String, zzby> zzxo;

   public zzby zzL(String var1) {
      zzby var2 = (zzby)this.zzxo.get(var1);
      return var2 != null?var2:zzby.zzxs;
   }

   public boolean zza(zzcb var1) {
      return this.zzxl.offer(var1);
   }
}
