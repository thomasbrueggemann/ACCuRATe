package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzm;
import com.google.android.gms.analytics.internal.zzo;
import com.google.android.gms.analytics.internal.zzy;
import java.util.HashSet;
import java.util.Set;

public class zzr {
   private final zzf zzOK;
   private Set<Integer> zzRA;
   private volatile Boolean zzRy;
   private String zzRz;

   protected zzr(zzf var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzOK = var1;
   }

   public long zzkA() {
      return ((Long)zzy.zzRV.get()).longValue();
   }

   public long zzkB() {
      return ((Long)zzy.zzRW.get()).longValue();
   }

   public int zzkC() {
      return ((Integer)zzy.zzRX.get()).intValue();
   }

   public int zzkD() {
      return ((Integer)zzy.zzRY.get()).intValue();
   }

   public long zzkE() {
      return (long)((Integer)zzy.zzSl.get()).intValue();
   }

   public String zzkF() {
      return (String)zzy.zzSa.get();
   }

   public String zzkG() {
      return (String)zzy.zzRZ.get();
   }

   public String zzkH() {
      return (String)zzy.zzSb.get();
   }

   public String zzkI() {
      return (String)zzy.zzSc.get();
   }

   public zzm zzkJ() {
      return zzm.zzbm((String)zzy.zzSe.get());
   }

   public zzo zzkK() {
      return zzo.zzbn((String)zzy.zzSf.get());
   }

   public Set<Integer> zzkL() {
      String var1 = (String)zzy.zzSk.get();
      if(this.zzRA == null || this.zzRz == null || !this.zzRz.equals(var1)) {
         String[] var2 = TextUtils.split(var1, ",");
         HashSet var3 = new HashSet();
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            String var6 = var2[var5];

            try {
               var3.add(Integer.valueOf(Integer.parseInt(var6)));
            } catch (NumberFormatException var8) {
               ;
            }
         }

         this.zzRz = var1;
         this.zzRA = var3;
      }

      return this.zzRA;
   }

   public long zzkM() {
      return ((Long)zzy.zzSt.get()).longValue();
   }

   public long zzkN() {
      return ((Long)zzy.zzSu.get()).longValue();
   }

   public long zzkO() {
      return ((Long)zzy.zzSx.get()).longValue();
   }

   public int zzkP() {
      return ((Integer)zzy.zzRO.get()).intValue();
   }

   public int zzkQ() {
      return ((Integer)zzy.zzRQ.get()).intValue();
   }

   public String zzkR() {
      return "google_analytics_v4.db";
   }

   public String zzkS() {
      return "google_analytics2_v4.db";
   }

   public long zzkT() {
      return 86400000L;
   }

   public int zzkU() {
      return ((Integer)zzy.zzSn.get()).intValue();
   }

   public int zzkV() {
      return ((Integer)zzy.zzSo.get()).intValue();
   }

   public long zzkW() {
      return ((Long)zzy.zzSp.get()).longValue();
   }

   public long zzkX() {
      return ((Long)zzy.zzSy.get()).longValue();
   }

   public boolean zzkr() {
      return com.google.android.gms.common.internal.zzd.zzakE;
   }

   public boolean zzks() {
      // $FF: Couldn't be decompiled
   }

   public boolean zzkt() {
      return ((Boolean)zzy.zzRK.get()).booleanValue();
   }

   public int zzku() {
      return ((Integer)zzy.zzSd.get()).intValue();
   }

   public int zzkv() {
      return ((Integer)zzy.zzSh.get()).intValue();
   }

   public int zzkw() {
      return ((Integer)zzy.zzSi.get()).intValue();
   }

   public int zzkx() {
      return ((Integer)zzy.zzSj.get()).intValue();
   }

   public long zzky() {
      return ((Long)zzy.zzRS.get()).longValue();
   }

   public long zzkz() {
      return ((Long)zzy.zzRR.get()).longValue();
   }
}
