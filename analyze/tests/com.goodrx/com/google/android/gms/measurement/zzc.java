package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.measurement.zze;
import com.google.android.gms.measurement.zzf;
import com.google.android.gms.measurement.zzg;
import com.google.android.gms.measurement.zzi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzc {
   private final zzf zzaUi;
   private boolean zzaUj;
   private long zzaUk;
   private long zzaUl;
   private long zzaUm;
   private long zzaUn;
   private long zzaUo;
   private boolean zzaUp;
   private final Map<Class<? extends zze>, zze> zzaUq;
   private final List<zzi> zzaUr;
   private final zzmq zzqW;

   zzc(zzc var1) {
      this.zzaUi = var1.zzaUi;
      this.zzqW = var1.zzqW;
      this.zzaUk = var1.zzaUk;
      this.zzaUl = var1.zzaUl;
      this.zzaUm = var1.zzaUm;
      this.zzaUn = var1.zzaUn;
      this.zzaUo = var1.zzaUo;
      this.zzaUr = new ArrayList(var1.zzaUr);
      this.zzaUq = new HashMap(var1.zzaUq.size());
      Iterator var2 = var1.zzaUq.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         zze var4 = zzg((Class)var3.getKey());
         ((zze)var3.getValue()).zza(var4);
         this.zzaUq.put(var3.getKey(), var4);
      }

   }

   zzc(zzf var1, zzmq var2) {
      zzx.zzz(var1);
      zzx.zzz(var2);
      this.zzaUi = var1;
      this.zzqW = var2;
      this.zzaUn = 1800000L;
      this.zzaUo = 3024000000L;
      this.zzaUq = new HashMap();
      this.zzaUr = new ArrayList();
   }

   private static <T extends zze> T zzg(Class<T> var0) {
      try {
         zze var3 = (zze)var0.newInstance();
         return var3;
      } catch (InstantiationException var4) {
         throw new IllegalArgumentException("dataType doesn\'t have default constructor", var4);
      } catch (IllegalAccessException var5) {
         throw new IllegalArgumentException("dataType default constructor is not accessible", var5);
      }
   }

   void zzAA() {
      this.zzaUm = this.zzqW.elapsedRealtime();
      if(this.zzaUl != 0L) {
         this.zzaUk = this.zzaUl;
      } else {
         this.zzaUk = this.zzqW.currentTimeMillis();
      }

      this.zzaUj = true;
   }

   zzf zzAB() {
      return this.zzaUi;
   }

   zzg zzAC() {
      return this.zzaUi.zzAC();
   }

   boolean zzAD() {
      return this.zzaUp;
   }

   void zzAE() {
      this.zzaUp = true;
   }

   public zzc zzAu() {
      return new zzc(this);
   }

   public Collection<zze> zzAv() {
      return this.zzaUq.values();
   }

   public List<zzi> zzAw() {
      return this.zzaUr;
   }

   public long zzAx() {
      return this.zzaUk;
   }

   public void zzAy() {
      this.zzAC().zze(this);
   }

   public boolean zzAz() {
      return this.zzaUj;
   }

   public void zzM(long var1) {
      this.zzaUl = var1;
   }

   public void zzb(zze var1) {
      zzx.zzz(var1);
      Class var3 = var1.getClass();
      if(var3.getSuperclass() != zze.class) {
         throw new IllegalArgumentException();
      } else {
         var1.zza(this.zzf(var3));
      }
   }

   public <T extends zze> T zze(Class<T> var1) {
      return (zze)this.zzaUq.get(var1);
   }

   public <T extends zze> T zzf(Class<T> var1) {
      zze var2 = (zze)this.zzaUq.get(var1);
      if(var2 == null) {
         var2 = zzg(var1);
         this.zzaUq.put(var1, var2);
      }

      return var2;
   }
}
