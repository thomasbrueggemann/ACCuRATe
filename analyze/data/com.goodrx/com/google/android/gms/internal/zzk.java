package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.zza;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzd;
import com.google.android.gms.internal.zzi;
import com.google.android.gms.internal.zzl;
import com.google.android.gms.internal.zzm;
import com.google.android.gms.internal.zzo;
import com.google.android.gms.internal.zzr;
import com.google.android.gms.internal.zzs;
import java.util.Collections;
import java.util.Map;

public abstract class zzk<T> implements Comparable<zzk<T>> {
   private final zzs.zza zzD;
   private final int zzE;
   private final String zzF;
   private final int zzG;
   private final zzm.zza zzH;
   private Integer zzI;
   private zzl zzJ;
   private boolean zzK;
   private boolean zzL;
   private boolean zzM;
   private long zzN;
   private zzo zzO;
   private zzb.zza zzP;

   public zzk(int var1, String var2, zzm.zza var3) {
      zzs.zza var4;
      if(zzs.zza.zzak) {
         var4 = new zzs.zza();
      } else {
         var4 = null;
      }

      this.zzD = var4;
      this.zzK = true;
      this.zzL = false;
      this.zzM = false;
      this.zzN = 0L;
      this.zzP = null;
      this.zzE = var1;
      this.zzF = var2;
      this.zzH = var3;
      this.zza((zzo)(new zzd()));
      this.zzG = zzb(var2);
   }

   private byte[] zza(Map<String, String> param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private static int zzb(String var0) {
      if(!TextUtils.isEmpty(var0)) {
         Uri var1 = Uri.parse(var0);
         if(var1 != null) {
            String var2 = var1.getHost();
            if(var2 != null) {
               return var2.hashCode();
            }
         }
      }

      return 0;
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.zzc((zzk)var1);
   }

   public Map<String, String> getHeaders() throws zza {
      return Collections.emptyMap();
   }

   public int getMethod() {
      return this.zzE;
   }

   public String getUrl() {
      return this.zzF;
   }

   public boolean isCanceled() {
      return this.zzL;
   }

   public String toString() {
      String var1 = "0x" + Integer.toHexString(this.zzg());
      StringBuilder var2 = new StringBuilder();
      String var3;
      if(this.zzL) {
         var3 = "[X] ";
      } else {
         var3 = "[ ] ";
      }

      return var2.append(var3).append(this.getUrl()).append(" ").append(var1).append(" ").append(this.zzs()).append(" ").append(this.zzI).toString();
   }

   public final zzk<?> zza(int var1) {
      this.zzI = Integer.valueOf(var1);
      return this;
   }

   public zzk<?> zza(zzb.zza var1) {
      this.zzP = var1;
      return this;
   }

   public zzk<?> zza(zzl var1) {
      this.zzJ = var1;
      return this;
   }

   public zzk<?> zza(zzo var1) {
      this.zzO = var1;
      return this;
   }

   protected abstract zzm<T> zza(zzi var1);

   protected abstract void zza(T var1);

   protected zzr zzb(zzr var1) {
      return var1;
   }

   public int zzc(zzk<T> var1) {
      zzk.zza var2 = this.zzs();
      zzk.zza var3 = var1.zzs();
      return var2 == var3?this.zzI.intValue() - var1.zzI.intValue():var3.ordinal() - var2.ordinal();
   }

   public void zzc(zzr var1) {
      if(this.zzH != null) {
         this.zzH.zze(var1);
      }

   }

   public void zzc(String var1) {
      if(zzs.zza.zzak) {
         this.zzD.zza(var1, Thread.currentThread().getId());
      } else if(this.zzN == 0L) {
         this.zzN = SystemClock.elapsedRealtime();
         return;
      }

   }

   void zzd(final String var1) {
      if(this.zzJ != null) {
         this.zzJ.zzf(this);
      }

      if(zzs.zza.zzak) {
         final long var5 = Thread.currentThread().getId();
         if(Looper.myLooper() == Looper.getMainLooper()) {
            this.zzD.zza(var1, var5);
            this.zzD.zzd(this.toString());
            return;
         }

         (new Handler(Looper.getMainLooper())).post(new Runnable() {
            public void run() {
               zzk.this.zzD.zza(var1, var5);
               zzk.this.zzD.zzd(this.toString());
            }
         });
      } else {
         long var2 = SystemClock.elapsedRealtime() - this.zzN;
         if(var2 >= 3000L) {
            Object[] var4 = new Object[]{Long.valueOf(var2), this.toString()};
            zzs.zzb("%d ms: %s", var4);
            return;
         }
      }

   }

   public int zzg() {
      return this.zzG;
   }

   public String zzh() {
      return this.getUrl();
   }

   public zzb.zza zzi() {
      return this.zzP;
   }

   @Deprecated
   protected Map<String, String> zzj() throws zza {
      return this.zzn();
   }

   @Deprecated
   protected String zzk() {
      return this.zzo();
   }

   @Deprecated
   public String zzl() {
      return this.zzp();
   }

   @Deprecated
   public byte[] zzm() throws zza {
      Map var1 = this.zzj();
      return var1 != null && var1.size() > 0?this.zza(var1, this.zzk()):null;
   }

   protected Map<String, String> zzn() throws zza {
      return null;
   }

   protected String zzo() {
      return "UTF-8";
   }

   public String zzp() {
      return "application/x-www-form-urlencoded; charset=" + this.zzo();
   }

   public byte[] zzq() throws zza {
      Map var1 = this.zzn();
      return var1 != null && var1.size() > 0?this.zza(var1, this.zzo()):null;
   }

   public final boolean zzr() {
      return this.zzK;
   }

   public zzk.zza zzs() {
      return zzk.zza.zzU;
   }

   public final int zzt() {
      return this.zzO.zzd();
   }

   public zzo zzu() {
      return this.zzO;
   }

   public void zzv() {
      this.zzM = true;
   }

   public boolean zzw() {
      return this.zzM;
   }

   public static enum zza {
      zzT,
      zzU,
      zzV,
      zzW;

      static {
         zzk.zza[] var0 = new zzk.zza[]{zzT, zzU, zzV, zzW};
      }
   }
}
