package com.google.android.gms.measurement.internal;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzl;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzy;

public class zzd extends zzy {
   static final String zzaVA;
   private Boolean zzRy;

   static {
      zzaVA = String.valueOf(com.google.android.gms.common.zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
   }

   zzd(zzw var1) {
      super(var1);
   }

   public int zzBA() {
      return 25;
   }

   int zzBB() {
      return 32;
   }

   public int zzBC() {
      return 24;
   }

   int zzBD() {
      return 36;
   }

   int zzBE() {
      return 256;
   }

   public int zzBF() {
      return 36;
   }

   public int zzBG() {
      return 2048;
   }

   int zzBH() {
      return 500;
   }

   public long zzBI() {
      return (long)((Integer)zzl.zzaWk.get()).intValue();
   }

   public long zzBJ() {
      return (long)((Integer)zzl.zzaWl.get()).intValue();
   }

   public long zzBK() {
      return (long)((Integer)zzl.zzaWm.get()).intValue();
   }

   int zzBL() {
      return 25;
   }

   int zzBM() {
      return 50;
   }

   long zzBN() {
      return 3600000L;
   }

   long zzBO() {
      return 60000L;
   }

   long zzBP() {
      return 61000L;
   }

   public long zzBQ() {
      return ((Long)zzl.zzaWw.get()).longValue();
   }

   public long zzBR() {
      return ((Long)zzl.zzaWs.get()).longValue();
   }

   public long zzBS() {
      return 1000L;
   }

   public int zzBT() {
      return Math.max(0, ((Integer)zzl.zzaWi.get()).intValue());
   }

   public int zzBU() {
      return Math.max(1, ((Integer)zzl.zzaWj.get()).intValue());
   }

   public String zzBV() {
      return (String)zzl.zzaWo.get();
   }

   public long zzBW() {
      return ((Long)zzl.zzaWd.get()).longValue();
   }

   public long zzBX() {
      return Math.max(0L, ((Long)zzl.zzaWp.get()).longValue());
   }

   public long zzBY() {
      return Math.max(0L, ((Long)zzl.zzaWr.get()).longValue());
   }

   public long zzBZ() {
      return ((Long)zzl.zzaWq.get()).longValue();
   }

   public long zzBp() {
      return (long)(com.google.android.gms.common.zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000);
   }

   String zzBz() {
      return (String)zzl.zzaWa.get();
   }

   public long zzCa() {
      return Math.max(0L, ((Long)zzl.zzaWt.get()).longValue());
   }

   public long zzCb() {
      return Math.max(0L, ((Long)zzl.zzaWu.get()).longValue());
   }

   public int zzCc() {
      return Math.min(20, Math.max(0, ((Integer)zzl.zzaWv.get()).intValue()));
   }

   public String zzH(String var1, String var2) {
      Builder var3 = new Builder();
      var3.scheme((String)zzl.zzaWe.get()).authority((String)zzl.zzaWf.get()).path("config/app/" + var1).appendQueryParameter("app_instance_id", var2).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(this.zzBp()));
      return var3.build().toString();
   }

   public long zza(String var1, zzl.zza<Long> var2) {
      if(var1 == null) {
         return ((Long)var2.get()).longValue();
      } else {
         String var3 = this.zzCl().zzO(var1, var2.getKey());
         if(TextUtils.isEmpty(var3)) {
            return ((Long)var2.get()).longValue();
         } else {
            try {
               long var5 = ((Long)var2.get(Long.valueOf(Long.valueOf(var3).longValue()))).longValue();
               return var5;
            } catch (NumberFormatException var7) {
               return ((Long)var2.get()).longValue();
            }
         }
      }
   }

   public int zzb(String var1, zzl.zza<Integer> var2) {
      if(var1 == null) {
         return ((Integer)var2.get()).intValue();
      } else {
         String var3 = this.zzCl().zzO(var1, var2.getKey());
         if(TextUtils.isEmpty(var3)) {
            return ((Integer)var2.get()).intValue();
         } else {
            try {
               int var5 = ((Integer)var2.get(Integer.valueOf(Integer.valueOf(var3).intValue()))).intValue();
               return var5;
            } catch (NumberFormatException var6) {
               return ((Integer)var2.get()).intValue();
            }
         }
      }
   }

   long zzeS(String var1) {
      return this.zza(var1, zzl.zzaWb);
   }

   int zzeT(String var1) {
      return this.zzb(var1, zzl.zzaWx);
   }

   public int zzeU(String var1) {
      return this.zzb(var1, zzl.zzaWg);
   }

   public int zzeV(String var1) {
      return Math.max(0, this.zzb(var1, zzl.zzaWh));
   }

   public int zzeW(String var1) {
      return Math.max(0, Math.min(1000000, this.zzb(var1, zzl.zzaWn)));
   }

   long zzkM() {
      return ((Long)zzl.zzaWy.get()).longValue();
   }

   public String zzkR() {
      return "google_app_measurement.db";
   }

   public String zzkS() {
      return "google_app_measurement2.db";
   }

   public long zzkX() {
      return Math.max(0L, ((Long)zzl.zzaWc.get()).longValue());
   }

   public boolean zzkr() {
      return com.google.android.gms.common.internal.zzd.zzakE;
   }

   public boolean zzks() {
      // $FF: Couldn't be decompiled
   }
}
