package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzc;
import com.google.android.gms.common.api.internal.zzg;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.api.internal.zzi;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.common.api.internal.zzp;
import com.google.android.gms.common.api.internal.zzu;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzl implements zzp {
   private final Context mContext;
   private final Lock zzXG;
   final zzj zzagW;
   private final com.google.android.gms.common.zzc zzags;
   final Api.zza<? extends zzrn, zzro> zzagt;
   final Map<Api<?>, Integer> zzahA;
   final Map<Api.zzc<?>, Api.zzb> zzahT;
   final zzf zzahz;
   private final Condition zzaim;
   private final zzl.zzb zzain;
   final Map<Api.zzc<?>, ConnectionResult> zzaio = new HashMap();
   private volatile zzk zzaip;
   private ConnectionResult zzaiq = null;
   int zzair;
   final zzp.zza zzais;

   public zzl(Context var1, zzj var2, Lock var3, Looper var4, com.google.android.gms.common.zzc var5, Map<Api.zzc<?>, Api.zzb> var6, zzf var7, Map<Api<?>, Integer> var8, Api.zza<? extends zzrn, zzro> var9, ArrayList<zzc> var10, zzp.zza var11) {
      this.mContext = var1;
      this.zzXG = var3;
      this.zzags = var5;
      this.zzahT = var6;
      this.zzahz = var7;
      this.zzahA = var8;
      this.zzagt = var9;
      this.zzagW = var2;
      this.zzais = var11;
      Iterator var12 = var10.iterator();

      while(var12.hasNext()) {
         ((zzc)var12.next()).zza(this);
      }

      this.zzain = new zzl.zzb(var4);
      this.zzaim = var3.newCondition();
      this.zzaip = new zzi(this);
   }

   // $FF: synthetic method
   static Lock zzb(zzl var0) {
      return var0.zzXG;
   }

   // $FF: synthetic method
   static zzk zzc(zzl var0) {
      return var0.zzaip;
   }

   public ConnectionResult blockingConnect() {
      this.connect();

      while(this.isConnecting()) {
         try {
            this.zzaim.await();
         } catch (InterruptedException var2) {
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, (PendingIntent)null);
         }
      }

      return this.isConnected()?ConnectionResult.zzafB:(this.zzaiq != null?this.zzaiq:new ConnectionResult(13, (PendingIntent)null));
   }

   public void connect() {
      this.zzaip.connect();
   }

   public boolean disconnect() {
      boolean var1 = this.zzaip.disconnect();
      if(var1) {
         this.zzaio.clear();
      }

      return var1;
   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      String var5 = var1 + "  ";
      Iterator var6 = this.zzahA.keySet().iterator();

      while(var6.hasNext()) {
         Api var7 = (Api)var6.next();
         var3.append(var1).append(var7.getName()).println(":");
         ((Api.zzb)this.zzahT.get(var7.zzoR())).dump(var5, var2, var3, var4);
      }

   }

   public boolean isConnected() {
      return this.zzaip instanceof zzg;
   }

   public boolean isConnecting() {
      return this.zzaip instanceof zzh;
   }

   public void onConnected(@Nullable Bundle var1) {
      this.zzXG.lock();

      try {
         this.zzaip.onConnected(var1);
      } finally {
         this.zzXG.unlock();
      }

   }

   public void onConnectionSuspended(int var1) {
      this.zzXG.lock();

      try {
         this.zzaip.onConnectionSuspended(var1);
      } finally {
         this.zzXG.unlock();
      }

   }

   public <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(@NonNull T var1) {
      return this.zzaip.zza(var1);
   }

   public void zza(@NonNull ConnectionResult var1, @NonNull Api<?> var2, int var3) {
      this.zzXG.lock();

      try {
         this.zzaip.zza(var1, var2, var3);
      } finally {
         this.zzXG.unlock();
      }

   }

   void zza(zzl.zza var1) {
      Message var2 = this.zzain.obtainMessage(1, var1);
      this.zzain.sendMessage(var2);
   }

   void zza(RuntimeException var1) {
      Message var2 = this.zzain.obtainMessage(2, var1);
      this.zzain.sendMessage(var2);
   }

   public boolean zza(zzu var1) {
      return false;
   }

   public <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(@NonNull T var1) {
      return this.zzaip.zzb(var1);
   }

   void zzh(ConnectionResult var1) {
      this.zzXG.lock();

      try {
         this.zzaiq = var1;
         this.zzaip = new zzi(this);
         this.zzaip.begin();
         this.zzaim.signalAll();
      } finally {
         this.zzXG.unlock();
      }

   }

   public void zzoW() {
   }

   void zzpK() {
      this.zzXG.lock();

      try {
         this.zzaip = new zzh(this, this.zzahz, this.zzahA, this.zzags, this.zzagt, this.zzXG, this.mContext);
         this.zzaip.begin();
         this.zzaim.signalAll();
      } finally {
         this.zzXG.unlock();
      }

   }

   void zzpL() {
      this.zzXG.lock();

      try {
         this.zzagW.zzpF();
         this.zzaip = new zzg(this);
         this.zzaip.begin();
         this.zzaim.signalAll();
      } finally {
         this.zzXG.unlock();
      }

   }

   void zzpM() {
      Iterator var1 = this.zzahT.values().iterator();

      while(var1.hasNext()) {
         ((Api.zzb)var1.next()).disconnect();
      }

   }

   public void zzpj() {
      if(this.isConnected()) {
         ((zzg)this.zzaip).zzps();
      }

   }

   abstract static class zza {
      private final zzk zzait;

      protected zza(zzk var1) {
         this.zzait = var1;
      }

      public final void zzd(zzl param1) {
         // $FF: Couldn't be decompiled
      }

      protected abstract void zzpt();
   }

   final class zzb extends Handler {
      zzb(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            ((zzl.zza)var1.obj).zzd(zzl.this);
            return;
         case 2:
            throw (RuntimeException)var1.obj;
         default:
            Log.w("GACStateManager", "Unknown message id: " + var1.what);
         }
      }
   }
}
