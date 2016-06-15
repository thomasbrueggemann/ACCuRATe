package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.class_1033;
import com.google.android.gms.common.api.class_201;
import com.google.android.gms.common.api.class_690;
import com.google.android.gms.common.api.d;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_342;
import com.google.android.gms.internal.class_745;
import com.google.android.gms.internal.jg;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// $FF: renamed from: com.google.android.gms.common.api.c
final class class_1032 implements GoogleApiClient {
   // $FF: renamed from: JF android.os.Looper
   private final Looper field_4308;
   // $FF: renamed from: JR java.util.concurrent.locks.Condition
   private final Condition field_4309;
   // $FF: renamed from: JS com.google.android.gms.internal.jm
   private final class_342 field_4310;
   // $FF: renamed from: JT int
   private final int field_4311;
   // $FF: renamed from: JU java.util.Queue
   final Queue<class_1032.class_1141<?>> field_4312;
   // $FF: renamed from: JV com.google.android.gms.common.ConnectionResult
   private ConnectionResult field_4313;
   // $FF: renamed from: JW int
   private int field_4314;
   // $FF: renamed from: JX int
   private volatile int field_4315;
   // $FF: renamed from: JY boolean
   private volatile boolean field_4316;
   // $FF: renamed from: JZ boolean
   private boolean field_4317;
   // $FF: renamed from: Jy com.google.android.gms.common.api.c$b
   private final class_1032.class_1139 field_4318;
   // $FF: renamed from: Ka int
   private int field_4319;
   // $FF: renamed from: Kb long
   private long field_4320;
   // $FF: renamed from: Kc long
   private long field_4321;
   // $FF: renamed from: Kd android.os.Handler
   final Handler field_4322;
   // $FF: renamed from: Ke android.content.BroadcastReceiver
   BroadcastReceiver field_4323;
   // $FF: renamed from: Kf android.os.Bundle
   private final Bundle field_4324;
   // $FF: renamed from: Kg java.util.Map
   private final Map<Api.class_1394<?>, Api.class_1390> field_4325;
   // $FF: renamed from: Kh java.util.List
   private final List<String> field_4326;
   // $FF: renamed from: Ki boolean
   private boolean field_4327;
   // $FF: renamed from: Kj java.util.Set
   private final Set<d<?>> field_4328;
   // $FF: renamed from: Kk java.util.Set
   final Set<class_1032.class_1141<?>> field_4329;
   // $FF: renamed from: Kl com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
   private final GoogleApiClient.ConnectionCallbacks field_4330;
   // $FF: renamed from: Km com.google.android.gms.internal.jm$b
   private final class_342.class_1616 field_4331;
   private final Context mContext;
   // $FF: renamed from: zO java.util.concurrent.locks.Lock
   private final Lock field_4332 = new ReentrantLock();

   public class_1032(Context var1, Looper var2, jg var3, Map<Api<?>, Api.ApiOptions> var4, Set<GoogleApiClient.ConnectionCallbacks> var5, Set<GoogleApiClient.OnConnectionFailedListener> var6, int var7) {
      this.field_4309 = this.field_4332.newCondition();
      this.field_4312 = new LinkedList();
      this.field_4315 = 4;
      this.field_4317 = false;
      this.field_4320 = 120000L;
      this.field_4321 = 5000L;
      this.field_4324 = new Bundle();
      this.field_4325 = new HashMap();
      this.field_4328 = Collections.newSetFromMap(new WeakHashMap());
      this.field_4329 = Collections.newSetFromMap(new ConcurrentHashMap());
      this.field_4318 = new class_1032.class_1139() {
         // $FF: renamed from: b (com.google.android.gms.common.api.c$d) void
         public void method_394(class_1032.class_1141<?> var1) {
            class_1032.this.field_4329.remove(var1);
         }
      };
      this.field_4330 = new GoogleApiClient.ConnectionCallbacks() {
         public void onConnected(Bundle param1) {
            // $FF: Couldn't be decompiled
         }

         public void onConnectionSuspended(int param1) {
            // $FF: Couldn't be decompiled
         }
      };
      this.field_4331 = new class_342.class_1616() {
         // $FF: renamed from: fX () android.os.Bundle
         public Bundle method_948() {
            return null;
         }

         // $FF: renamed from: gN () boolean
         public boolean method_949() {
            return class_1032.this.field_4327;
         }

         public boolean isConnected() {
            return class_1032.this.isConnected();
         }
      };
      this.mContext = var1;
      this.field_4310 = new class_342(var1, var2, this.field_4331);
      this.field_4308 = var2;
      this.field_4322 = new class_1032.class_1140(var2);
      this.field_4311 = var7;
      Iterator var8 = var5.iterator();

      while(var8.hasNext()) {
         GoogleApiClient.ConnectionCallbacks var16 = (GoogleApiClient.ConnectionCallbacks)var8.next();
         this.field_4310.registerConnectionCallbacks(var16);
      }

      Iterator var9 = var6.iterator();

      while(var9.hasNext()) {
         GoogleApiClient.OnConnectionFailedListener var15 = (GoogleApiClient.OnConnectionFailedListener)var9.next();
         this.field_4310.registerConnectionFailedListener(var15);
      }

      Iterator var10 = var4.keySet().iterator();

      while(var10.hasNext()) {
         Api var11 = (Api)var10.next();
         final Api.class_1391 var12 = var11.method_3731();
         Object var13 = var4.get(var11);
         this.field_4325.put(var11.method_3733(), method_5653(var12, var13, var1, var2, var3, this.field_4330, new GoogleApiClient.OnConnectionFailedListener() {
            public void onConnectionFailed(ConnectionResult var1) {
               class_1032.this.field_4332.lock();

               try {
                  if(class_1032.this.field_4313 == null || var12.getPriority() < class_1032.this.field_4314) {
                     class_1032.this.field_4313 = var1;
                     class_1032.this.field_4314 = var12.getPriority();
                  }

                  class_1032.this.method_5668();
               } finally {
                  class_1032.this.field_4332.unlock();
               }

            }
         }));
      }

      this.field_4326 = Collections.unmodifiableList(var3.method_2420());
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.Api$b, java.lang.Object, android.content.Context, android.os.Looper, com.google.android.gms.internal.jg, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
   private static <C extends Api.class_1390, O> C method_5653(Api.class_1391<C, O> var0, Object var1, Context var2, Looper var3, jg var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
      return var0.method_442(var2, var3, var4, var1, var5, var6);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.common.api.f, boolean) void
   private void method_5655(final GoogleApiClient var1, final class_201 var2, final boolean var3) {
      class_745.field_3407.method_768(var1).setResultCallback(new ResultCallback() {
         // $FF: renamed from: j (com.google.android.gms.common.api.Status) void
         public void method_3443(Status var1x) {
            if(var1x.isSuccess() && class_1032.this.isConnected()) {
               class_1032.this.reconnect();
            }

            var2.b(var1x);
            if(var3) {
               var1.disconnect();
            }

         }

         // $FF: synthetic method
         public void onResult(Result var1x) {
            this.method_3443((Status)var1x);
         }
      });
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.c$d) void
   private <A extends Api.class_1390> void method_5656(class_1032.class_1141<A> param1) throws DeadObjectException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.c, int) void
   // $FF: synthetic method
   static void method_5657(class_1032 var0, int var1) {
      var0.method_5660(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.c, boolean) boolean
   // $FF: synthetic method
   static boolean method_5659(class_1032 var0, boolean var1) {
      var0.field_4316 = var1;
      return var1;
   }

   // $FF: renamed from: al (int) void
   private void method_5660(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.c) int
   // $FF: synthetic method
   static int method_5661(class_1032 var0) {
      return var0.field_4315;
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.c) android.os.Bundle
   // $FF: synthetic method
   static Bundle method_5663(class_1032 var0) {
      return var0.field_4324;
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.c) android.content.Context
   // $FF: synthetic method
   static Context method_5665(class_1032 var0) {
      return var0.mContext;
   }

   // $FF: renamed from: f (com.google.android.gms.common.api.c) long
   // $FF: synthetic method
   static long method_5666(class_1032 var0) {
      return var0.field_4320;
   }

   // $FF: renamed from: g (com.google.android.gms.common.api.c) long
   // $FF: synthetic method
   static long method_5667(class_1032 var0) {
      return var0.field_4321;
   }

   // $FF: renamed from: gJ () void
   private void method_5668() {
      this.field_4319 += -1;
      if(this.field_4319 == 0) {
         if(this.field_4313 == null) {
            this.field_4315 = 2;
            this.method_5670();
            this.field_4309.signalAll();
            this.method_5669();
            if(this.field_4317) {
               this.field_4317 = false;
               this.method_5660(-1);
               return;
            }

            Bundle var1;
            if(this.field_4324.isEmpty()) {
               var1 = null;
            } else {
               var1 = this.field_4324;
            }

            this.field_4310.method_2347(var1);
            return;
         }

         this.field_4317 = false;
         this.method_5660(3);
         if(!this.method_5676() || !GooglePlayServicesUtil.method_4811(this.mContext, this.field_4313.getErrorCode())) {
            this.method_5670();
            this.field_4310.method_2345(this.field_4313);
         }

         this.field_4327 = false;
      }

   }

   // $FF: renamed from: gK () void
   private void method_5669() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: gM () void
   private void method_5670() {
      // $FF: Couldn't be decompiled
   }

   private void resume() {
      this.field_4332.lock();

      try {
         if(this.method_5676()) {
            this.connect();
         }
      } finally {
         this.field_4332.unlock();
      }

   }

   // $FF: renamed from: a (com.google.android.gms.common.api.Api$c) com.google.android.gms.common.api.Api$a
   public <C extends Api.class_1390> C method_941(Api.class_1394<C> var1) {
      Api.class_1390 var2 = (Api.class_1390)this.field_4325.get(var1);
      class_335.method_2306(var2, "Appropriate Api was not requested.");
      return var2;
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$a) com.google.android.gms.common.api.BaseImplementation$a
   public <A extends Api.class_1390, R extends Result, T extends BaseImplementation.class_1057<R, A>> T method_942(T var1) {
      this.field_4332.lock();

      try {
         if(this.isConnected()) {
            this.method_944(var1);
         } else {
            this.field_4312.add(var1);
         }
      } finally {
         this.field_4332.unlock();
      }

      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.Scope) boolean
   public boolean method_943(Scope var1) {
      return this.field_4326.contains(var1.method_1632());
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$a) com.google.android.gms.common.api.BaseImplementation$a
   public <A extends Api.class_1390, T extends BaseImplementation.class_1057<? extends Result, A>> T method_944(T var1) {
      boolean var2;
      if(!this.isConnected() && !this.method_5676()) {
         var2 = false;
      } else {
         var2 = true;
      }

      class_335.method_2302(var2, "GoogleApiClient is not connected yet.");
      this.method_5669();

      try {
         this.method_5656(var1);
         return var1;
      } catch (DeadObjectException var4) {
         this.method_5660(1);
         return var1;
      }
   }

   public ConnectionResult blockingConnect() {
      // $FF: Couldn't be decompiled
   }

   public ConnectionResult blockingConnect(long param1, TimeUnit param3) {
      // $FF: Couldn't be decompiled
   }

   public PendingResult<Status> clearDefaultAccountAndReconnect() {
      class_335.method_2302(this.isConnected(), "GoogleApiClient is not connected yet.");
      final class_201 var1 = new class_201(this.field_4308);
      if(this.field_4325.containsKey(class_745.field_3405)) {
         this.method_5655(this, var1, false);
         return var1;
      } else {
         final AtomicReference var2 = new AtomicReference();
         GoogleApiClient.ConnectionCallbacks var3 = new GoogleApiClient.ConnectionCallbacks() {
            public void onConnected(Bundle var1x) {
               class_1032.this.method_5655((GoogleApiClient)var2.get(), var1, true);
            }

            public void onConnectionSuspended(int var1x) {
            }
         };
         GoogleApiClient.OnConnectionFailedListener var4 = new GoogleApiClient.OnConnectionFailedListener() {
            public void onConnectionFailed(ConnectionResult var1x) {
               var1.b(new Status(8));
            }
         };
         GoogleApiClient var5 = (new GoogleApiClient.Builder(this.mContext)).addApi(class_745.API).addConnectionCallbacks(var3).addOnConnectionFailedListener(var4).setHandler(this.field_4322).build();
         var2.set(var5);
         var5.connect();
         return var1;
      }
   }

   public void connect() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d (java.lang.Object) com.google.android.gms.common.api.d
   public <L> d<L> method_945(L var1) {
      class_335.method_2306(var1, "Listener must not be null");
      this.field_4332.lock();

      class_1033 var3;
      try {
         var3 = new class_1033(this.field_4308, var1);
         this.field_4328.add(var3);
      } finally {
         this.field_4332.unlock();
      }

      return var3;
   }

   public void disconnect() {
      this.method_5670();
      this.method_5660(-1);
   }

   // $FF: renamed from: gL () boolean
   boolean method_5676() {
      return this.field_4316;
   }

   public Looper getLooper() {
      return this.field_4308;
   }

   public boolean isConnected() {
      return this.field_4315 == 2;
   }

   public boolean isConnecting() {
      return this.field_4315 == 1;
   }

   public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks var1) {
      return this.field_4310.isConnectionCallbacksRegistered(var1);
   }

   public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener var1) {
      return this.field_4310.isConnectionFailedListenerRegistered(var1);
   }

   public void reconnect() {
      this.disconnect();
      this.connect();
   }

   public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
      this.field_4310.registerConnectionCallbacks(var1);
   }

   public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
      this.field_4310.registerConnectionFailedListener(var1);
   }

   public void stopAutoManage(FragmentActivity var1) {
      boolean var2;
      if(this.field_4311 >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_335.method_2302(var2, "Called stopAutoManage but automatic lifecycle management is not enabled.");
      class_690.method_3924(var1).method_3934(this.field_4311);
   }

   public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
      this.field_4310.unregisterConnectionCallbacks(var1);
   }

   public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
      this.field_4310.unregisterConnectionFailedListener(var1);
   }

   private static class class_1138 extends BroadcastReceiver {
      // $FF: renamed from: Ks java.lang.ref.WeakReference
      private WeakReference<c> field_2635;

      class_1138(class_1032 var1) {
         this.field_2635 = new WeakReference(var1);
      }

      public void onReceive(Context var1, Intent var2) {
         Uri var3 = var2.getData();
         String var4 = null;
         if(var3 != null) {
            var4 = var3.getSchemeSpecificPart();
         }

         if(var4 != null && var4.equals("com.google.android.gms")) {
            class_1032 var5 = (class_1032)this.field_2635.get();
            if(var5 != null && !var5.isConnected() && !var5.isConnecting() && var5.method_5676()) {
               var5.connect();
               return;
            }
         }

      }
   }

   interface class_1139 {
      // $FF: renamed from: b (com.google.android.gms.common.api.c$d) void
      void method_394(class_1032.class_1141<?> var1);
   }

   private class class_1140 extends Handler {
      class_1140(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            class_1032.this.method_5670();
            return;
         case 2:
            class_1032.this.resume();
            return;
         default:
            Log.w("GoogleApiClientImpl", "Unknown message id: " + var1.what);
         }
      }
   }

   interface class_1141<A extends Api.class_1390> {
      // $FF: renamed from: a (com.google.android.gms.common.api.c$b) void
      void method_389(class_1032.class_1139 var1);

      // $FF: renamed from: b (com.google.android.gms.common.api.Api$a) void
      void method_390(A var1) throws DeadObjectException;

      void cancel();

      // $FF: renamed from: gF () int
      int method_391();

      // $FF: renamed from: gz () com.google.android.gms.common.api.Api$c
      Api.class_1394<A> method_392();

      // $FF: renamed from: l (com.google.android.gms.common.api.Status) void
      void method_393(Status var1);
   }
}
