package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzb<R extends Result> extends PendingResult<R> {
   private boolean zzL;
   private final Object zzagI = new Object();
   protected final zzb.zza<R> zzagJ;
   private final WeakReference<GoogleApiClient> zzagK;
   private final ArrayList<PendingResult.zza> zzagL = new ArrayList();
   private ResultCallback<? super R> zzagM;
   private volatile boolean zzagN;
   private boolean zzagO;
   private boolean zzagP;
   private com.google.android.gms.common.internal.zzq zzagQ;
   private Integer zzagR;
   private volatile zzx<R> zzagS;
   private volatile R zzagy;
   private final CountDownLatch zzpJ = new CountDownLatch(1);

   @Deprecated
   protected zzb(Looper var1) {
      this.zzagJ = new zzb.zza(var1);
      this.zzagK = new WeakReference((Object)null);
   }

   protected zzb(GoogleApiClient var1) {
      Looper var2;
      if(var1 != null) {
         var2 = var1.getLooper();
      } else {
         var2 = Looper.getMainLooper();
      }

      this.zzagJ = new zzb.zza(var2);
      this.zzagK = new WeakReference(var1);
   }

   private R get() {
      // $FF: Couldn't be decompiled
   }

   private void zzb(R var1) {
      this.zzagy = var1;
      this.zzagQ = null;
      this.zzpJ.countDown();
      Status var2 = this.zzagy.getStatus();
      if(this.zzagM != null) {
         this.zzagJ.zzph();
         if(!this.zzL) {
            this.zzagJ.zza(this.zzagM, this.get());
         }
      }

      Iterator var3 = this.zzagL.iterator();

      while(var3.hasNext()) {
         ((PendingResult.zza)var3.next()).zzu(var2);
      }

      this.zzagL.clear();
   }

   public static void zzc(Result var0) {
      if(var0 instanceof Releasable) {
         try {
            ((Releasable)var0).release();
         } catch (RuntimeException var2) {
            Log.w("BasePendingResult", "Unable to release " + var0, var2);
            return;
         }
      }

   }

   public void cancel() {
      // $FF: Couldn't be decompiled
   }

   public boolean isCanceled() {
      // $FF: Couldn't be decompiled
   }

   public final boolean isReady() {
      return this.zzpJ.getCount() == 0L;
   }

   public final void setResultCallback(ResultCallback<? super R> param1) {
      // $FF: Couldn't be decompiled
   }

   public final void setResultCallback(ResultCallback<? super R> param1, long param2, TimeUnit param4) {
      // $FF: Couldn't be decompiled
   }

   public final void zza(R param1) {
      // $FF: Couldn't be decompiled
   }

   protected abstract R zzc(Status var1);

   public Integer zzpa() {
      return this.zzagR;
   }

   protected void zzpf() {
   }

   public void zzpg() {
      // $FF: Couldn't be decompiled
   }

   public final void zzx(Status param1) {
      // $FF: Couldn't be decompiled
   }

   public static class zza<R extends Result> extends Handler {
      public zza() {
         this(Looper.getMainLooper());
      }

      public zza(Looper var1) {
         super(var1);
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            Pair var2 = (Pair)var1.obj;
            this.zzb((ResultCallback)var2.first, (Result)var2.second);
            return;
         case 2:
            ((zzb)var1.obj).zzx(Status.zzagF);
            return;
         default:
            Log.wtf("BasePendingResult", "Don\'t know how to handle message: " + var1.what, new Exception());
         }
      }

      public void zza(ResultCallback<? super R> var1, R var2) {
         this.sendMessage(this.obtainMessage(1, new Pair(var1, var2)));
      }

      public void zza(zzb<R> var1, long var2) {
         this.sendMessageDelayed(this.obtainMessage(2, var1), var2);
      }

      protected void zzb(ResultCallback<? super R> var1, R var2) {
         try {
            var1.onResult(var2);
         } catch (RuntimeException var4) {
            zzb.zzc(var2);
            throw var4;
         }
      }

      public void zzph() {
         this.removeMessages(2);
      }
   }
}
