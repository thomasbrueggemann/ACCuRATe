package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk implements Callback {
   private final Handler mHandler;
   private final zzk.zza zzalQ;
   private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzalR = new ArrayList();
   final ArrayList<GoogleApiClient.ConnectionCallbacks> zzalS = new ArrayList();
   private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzalT = new ArrayList();
   private volatile boolean zzalU = false;
   private final AtomicInteger zzalV = new AtomicInteger(0);
   private boolean zzalW = false;
   private final Object zzpV = new Object();

   public zzk(Looper var1, zzk.zza var2) {
      this.zzalQ = var2;
      this.mHandler = new Handler(var1, this);
   }

   public boolean handleMessage(Message param1) {
      // $FF: Couldn't be decompiled
   }

   public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks param1) {
      // $FF: Couldn't be decompiled
   }

   public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzbT(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzk(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzk(ConnectionResult param1) {
      // $FF: Couldn't be decompiled
   }

   public void zzqQ() {
      this.zzalU = false;
      this.zzalV.incrementAndGet();
   }

   public void zzqR() {
      this.zzalU = true;
   }

   public interface zza {
      boolean isConnected();

      Bundle zzoi();
   }
}
