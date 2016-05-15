package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.zzb;
import com.google.android.gms.internal.zzc;
import com.google.android.gms.internal.zze;
import com.google.android.gms.internal.zzf;
import com.google.android.gms.internal.zzg;
import com.google.android.gms.internal.zzk;
import com.google.android.gms.internal.zzn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class zzl {
   private AtomicInteger zzY;
   private final Map<String, Queue<zzk<?>>> zzZ;
   private final Set<zzk<?>> zzaa;
   private final PriorityBlockingQueue<zzk<?>> zzab;
   private final PriorityBlockingQueue<zzk<?>> zzac;
   private zzg[] zzad;
   private zzc zzae;
   private List<zzl.zza> zzaf;
   private final zzb zzj;
   private final zzn zzk;
   private final zzf zzz;

   public zzl(zzb var1, zzf var2) {
      this(var1, var2, 4);
   }

   public zzl(zzb var1, zzf var2, int var3) {
      this(var1, var2, var3, new zze(new Handler(Looper.getMainLooper())));
   }

   public zzl(zzb var1, zzf var2, int var3, zzn var4) {
      this.zzY = new AtomicInteger();
      this.zzZ = new HashMap();
      this.zzaa = new HashSet();
      this.zzab = new PriorityBlockingQueue();
      this.zzac = new PriorityBlockingQueue();
      this.zzaf = new ArrayList();
      this.zzj = var1;
      this.zzz = var2;
      this.zzad = new zzg[var3];
      this.zzk = var4;
   }

   public int getSequenceNumber() {
      return this.zzY.incrementAndGet();
   }

   public void start() {
      this.stop();
      this.zzae = new zzc(this.zzab, this.zzac, this.zzj, this.zzk);
      this.zzae.start();

      for(int var1 = 0; var1 < this.zzad.length; ++var1) {
         zzg var2 = new zzg(this.zzac, this.zzz, this.zzj, this.zzk);
         this.zzad[var1] = var2;
         var2.start();
      }

   }

   public void stop() {
      if(this.zzae != null) {
         this.zzae.quit();
      }

      for(int var1 = 0; var1 < this.zzad.length; ++var1) {
         if(this.zzad[var1] != null) {
            this.zzad[var1].quit();
         }
      }

   }

   public <T> zzk<T> zze(zzk<T> param1) {
      // $FF: Couldn't be decompiled
   }

   <T> void zzf(zzk<T> param1) {
      // $FF: Couldn't be decompiled
   }

   public interface zza<T> {
      void zzg(zzk<T> var1);
   }
}
