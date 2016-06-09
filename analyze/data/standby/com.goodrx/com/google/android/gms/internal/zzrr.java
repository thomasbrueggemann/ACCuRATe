package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.internal.zzrt;
import java.util.HashMap;
import java.util.Map;

public class zzrr {
   private final Context mContext;
   private String zzbio;
   private final zzrt zzbmf;
   Map<String, Object<zzrs.zzc>> zzbmg;
   private final Map<String, Object> zzbmh;
   private final zzmq zzqW;

   public zzrr(Context var1) {
      this(var1, new HashMap(), new zzrt(var1), zzmt.zzsc());
   }

   zzrr(Context var1, Map<String, Object> var2, zzrt var3, zzmq var4) {
      this.zzbio = null;
      this.zzbmg = new HashMap();
      this.mContext = var1;
      this.zzqW = var4;
      this.zzbmf = var3;
      this.zzbmh = var2;
   }

   public void zzgB(String var1) {
      this.zzbio = var1;
   }
}
