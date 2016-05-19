package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzlv implements com.google.android.gms.clearcut.zzc {
   private static final Object zzafn = new Object();
   private static final zzlv.zze zzafo = new zzlv.zze(null);
   private static final long zzafp;
   private GoogleApiClient zzaaj;
   private final zzlv.zza zzafq;
   private final Object zzafr;
   private long zzafs;
   private final long zzaft;
   private ScheduledFuture<?> zzafu;
   private final Runnable zzafv;
   private final zzmq zzqW;

   static {
      zzafp = TimeUnit.MILLISECONDS.convert(2L, TimeUnit.MINUTES);
   }

   public zzlv() {
      this(new zzmt(), zzafp, new zzlv.zzb());
   }

   public zzlv(zzmq var1, long var2, zzlv.zza var4) {
      this.zzafr = new Object();
      this.zzafs = 0L;
      this.zzafu = null;
      this.zzaaj = null;
      this.zzafv = new Runnable() {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      };
      this.zzqW = var1;
      this.zzaft = var2;
      this.zzafq = var4;
   }

   // $FF: synthetic method
   static GoogleApiClient zza(zzlv var0, GoogleApiClient var1) {
      var0.zzaaj = var1;
      return var1;
   }

   // $FF: synthetic method
   static Object zza(zzlv var0) {
      return var0.zzafr;
   }

   // $FF: synthetic method
   static long zzb(zzlv var0) {
      return var0.zzafs;
   }

   // $FF: synthetic method
   static zzmq zzc(zzlv var0) {
      return var0.zzqW;
   }

   // $FF: synthetic method
   static GoogleApiClient zzd(zzlv var0) {
      return var0.zzaaj;
   }

   public interface zza {
   }

   public static class zzb implements zzlv.zza {
   }

   private static final class zze {
      private int mSize;

      private zze() {
         this.mSize = 0;
      }

      // $FF: synthetic method
      zze(Object var1) {
         this();
      }
   }
}
