package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_355;
import com.google.android.gms.internal.gz;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// $FF: renamed from: com.google.android.gms.common.api.c
final class class_798 implements GoogleApiClient {
   // $FF: renamed from: DC android.os.Looper
   private final Looper field_4163;
   // $FF: renamed from: DN java.util.concurrent.locks.Lock
   private final Lock field_4164 = new ReentrantLock();
   // $FF: renamed from: DO java.util.concurrent.locks.Condition
   private final Condition field_4165;
   // $FF: renamed from: DP com.google.android.gms.internal.hd
   private final class_355 field_4166;
   // $FF: renamed from: DQ android.support.v4.app.Fragment
   private final Fragment field_4167;
   // $FF: renamed from: DR java.util.Queue
   final Queue<class_798.class_1019<?>> field_4168;
   // $FF: renamed from: DS com.google.android.gms.common.ConnectionResult
   private ConnectionResult field_4169;
   // $FF: renamed from: DT int
   private int field_4170;
   // $FF: renamed from: DU int
   private int field_4171;
   // $FF: renamed from: DV int
   private int field_4172;
   // $FF: renamed from: DW boolean
   private boolean field_4173;
   // $FF: renamed from: DX int
   private int field_4174;
   // $FF: renamed from: DY long
   private long field_4175;
   // $FF: renamed from: DZ android.os.Handler
   final Handler field_4176;
   // $FF: renamed from: Dv com.google.android.gms.common.api.c$a
   private final class_798.class_1021 field_4177;
   // $FF: renamed from: Ea android.os.Bundle
   private final Bundle field_4178;
   // $FF: renamed from: Eb java.util.Map
   private final Map<Api.class_1077<?>, Api.class_1073> field_4179;
   // $FF: renamed from: Ec java.util.List
   private final List<String> field_4180;
   // $FF: renamed from: Ed boolean
   private boolean field_4181;
   // $FF: renamed from: Ee java.util.Set
   final Set<class_798.class_1019<?>> field_4182;
   // $FF: renamed from: Ef com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks
   final GoogleApiClient.ConnectionCallbacks field_4183;
   // $FF: renamed from: Eg com.google.android.gms.internal.hd$b
   private final class_355.class_1267 field_4184;

   public class_798(Context var1, Looper var2, gz var3, Map<Api<?>, Api.ApiOptions> var4, Fragment var5, Set<GoogleApiClient.ConnectionCallbacks> var6, Set<GoogleApiClient.OnConnectionFailedListener> var7) {
      this.field_4165 = this.field_4164.newCondition();
      this.field_4168 = new LinkedList();
      this.field_4171 = 4;
      this.field_4172 = 0;
      this.field_4173 = false;
      this.field_4175 = 5000L;
      this.field_4178 = new Bundle();
      this.field_4179 = new HashMap();
      this.field_4182 = Collections.newSetFromMap(new ConcurrentHashMap());
      this.field_4177 = new class_798.class_1021() {
         // $FF: renamed from: b (com.google.android.gms.common.api.c$c) void
         public void method_352(class_798.class_1019<?> var1) {
            class_798.this.field_4182.remove(var1);
         }
      };
      this.field_4183 = new GoogleApiClient.ConnectionCallbacks() {
         public void onConnected(Bundle param1) {
            // $FF: Couldn't be decompiled
         }

         public void onConnectionSuspended(int param1) {
            // $FF: Couldn't be decompiled
         }
      };
      this.field_4184 = new class_355.class_1267() {
         // $FF: renamed from: eJ () boolean
         public boolean method_776() {
            return class_798.this.field_4181;
         }

         // $FF: renamed from: ea () android.os.Bundle
         public Bundle method_777() {
            return null;
         }

         public boolean isConnected() {
            return class_798.this.isConnected();
         }
      };
      this.field_4166 = new class_355(var1, var2, this.field_4184);
      this.field_4167 = var5;
      this.field_4163 = var2;
      this.field_4176 = new class_798.class_1020(var2);
      Iterator var8 = var6.iterator();

      while(var8.hasNext()) {
         GoogleApiClient.ConnectionCallbacks var16 = (GoogleApiClient.ConnectionCallbacks)var8.next();
         this.field_4166.registerConnectionCallbacks(var16);
      }

      Iterator var9 = var7.iterator();

      while(var9.hasNext()) {
         GoogleApiClient.OnConnectionFailedListener var15 = (GoogleApiClient.OnConnectionFailedListener)var9.next();
         this.field_4166.registerConnectionFailedListener(var15);
      }

      Iterator var10 = var4.keySet().iterator();

      while(var10.hasNext()) {
         Api var11 = (Api)var10.next();
         final Api.class_1074 var12 = var11.method_3125();
         Object var13 = var4.get(var11);
         this.field_4179.put(var11.method_3127(), method_4435(var12, var13, var1, var2, var3, this.field_4183, new GoogleApiClient.OnConnectionFailedListener() {
            public void onConnectionFailed(ConnectionResult var1) {
               class_798.this.field_4164.lock();

               try {
                  if(class_798.this.field_4169 == null || var12.getPriority() < class_798.this.field_4170) {
                     class_798.this.field_4169 = var1;
                     class_798.this.field_4170 = var12.getPriority();
                  }

                  class_798.this.method_4446();
               } finally {
                  class_798.this.field_4164.unlock();
               }

            }
         }));
      }

      this.field_4180 = Collections.unmodifiableList(var3.method_2057());
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.Api$b, java.lang.Object, android.content.Context, android.os.Looper, com.google.android.gms.internal.gz, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) com.google.android.gms.common.api.Api$a
   private static <C extends Api.class_1073, O> C method_4435(Api.class_1074<C, O> var0, Object var1, Context var2, Looper var3, gz var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
      return var0.method_400(var2, var3, var4, var1, var5, var6);
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.c$c) void
   private <A extends Api.class_1073> void method_4437(class_798.class_1019<A> param1) throws DeadObjectException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.c, int) void
   // $FF: synthetic method
   static void method_4438(class_798 var0, int var1) {
      var0.method_4439(var1);
   }

   // $FF: renamed from: aa (int) void
   private void method_4439(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.c) int
   // $FF: synthetic method
   static int method_4440(class_798 var0) {
      return var0.field_4171;
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.c, int) int
   // $FF: synthetic method
   static int method_4441(class_798 var0, int var1) {
      var0.field_4172 = var1;
      return var1;
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.c) android.os.Bundle
   // $FF: synthetic method
   static Bundle method_4443(class_798 var0) {
      return var0.field_4178;
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.c) boolean
   // $FF: synthetic method
   static boolean method_4445(class_798 var0) {
      return var0.method_4448();
   }

   // $FF: renamed from: eF () void
   private void method_4446() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: eG () void
   private void method_4447() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: eH () boolean
   private boolean method_4448() {
      this.field_4164.lock();
      boolean var5 = false;

      int var2;
      try {
         var5 = true;
         var2 = this.field_4172;
         var5 = false;
      } finally {
         if(var5) {
            this.field_4164.unlock();
         }
      }

      boolean var3;
      if(var2 != 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.field_4164.unlock();
      return var3;
   }

   // $FF: renamed from: eI () void
   private void method_4449() {
      this.field_4164.lock();

      try {
         this.field_4172 = 0;
         this.field_4176.removeMessages(1);
      } finally {
         this.field_4164.unlock();
      }

   }

   // $FF: renamed from: f (com.google.android.gms.common.api.c) long
   // $FF: synthetic method
   static long method_4450(class_798 var0) {
      return var0.field_4175;
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.Api$c) com.google.android.gms.common.api.Api$a
   public <C extends Api.class_1073> C method_771(Api.class_1077<C> var1) {
      Api.class_1073 var2 = (Api.class_1073)this.field_4179.get(var1);
      class_347.method_2166(var2, "Appropriate Api was not requested.");
      return var2;
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.a$b) com.google.android.gms.common.api.a$b
   public <A extends Api.class_1073, T extends class_797.class_1203<? extends Result, A>> T method_772(T var1) {
      this.field_4164.lock();

      try {
         if(this.isConnected()) {
            this.method_773(var1);
         } else {
            this.field_4168.add(var1);
         }
      } finally {
         this.field_4164.unlock();
      }

      return var1;
   }

   // $FF: renamed from: b (com.google.android.gms.common.api.a$b) com.google.android.gms.common.api.a$b
   public <A extends Api.class_1073, T extends class_797.class_1203<? extends Result, A>> T method_773(T var1) {
      boolean var2;
      if(!this.isConnected() && !this.method_4448()) {
         var2 = false;
      } else {
         var2 = true;
      }

      class_347.method_2161(var2, "GoogleApiClient is not connected yet.");
      this.method_4447();

      try {
         this.method_4437(var1);
         return var1;
      } catch (DeadObjectException var4) {
         this.method_4439(1);
         return var1;
      }
   }

   public ConnectionResult blockingConnect() {
      // $FF: Couldn't be decompiled
   }

   public ConnectionResult blockingConnect(long param1, TimeUnit param3) {
      // $FF: Couldn't be decompiled
   }

   public void connect() {
      // $FF: Couldn't be decompiled
   }

   public void disconnect() {
      this.method_4449();
      this.method_4439(-1);
   }

   public Looper getLooper() {
      return this.field_4163;
   }

   public boolean isConnected() {
      this.field_4164.lock();
      boolean var5 = false;

      int var2;
      try {
         var5 = true;
         var2 = this.field_4171;
         var5 = false;
      } finally {
         if(var5) {
            this.field_4164.unlock();
         }
      }

      boolean var3;
      if(var2 == 2) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.field_4164.unlock();
      return var3;
   }

   public boolean isConnecting() {
      byte var1 = 1;
      this.field_4164.lock();
      boolean var5 = false;

      int var3;
      try {
         var5 = true;
         var3 = this.field_4171;
         var5 = false;
      } finally {
         if(var5) {
            this.field_4164.unlock();
         }
      }

      if(var3 != var1) {
         var1 = 0;
      }

      this.field_4164.unlock();
      return (boolean)var1;
   }

   public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks var1) {
      return this.field_4166.isConnectionCallbacksRegistered(var1);
   }

   public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener var1) {
      return this.field_4166.isConnectionFailedListenerRegistered(var1);
   }

   public void reconnect() {
      this.disconnect();
      this.connect();
   }

   public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
      this.field_4166.registerConnectionCallbacks(var1);
   }

   public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
      this.field_4166.registerConnectionFailedListener(var1);
   }

   public void stopAutoManage() {
      boolean var1;
      if(this.field_4167 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      class_347.method_2161(var1, "Called stopAutoManage but automatic lifecycle management is not enabled.");
      if(this.field_4167.getActivity() != null) {
         this.field_4167.getActivity().getSupportFragmentManager().beginTransaction().remove(this.field_4167).commit();
         this.disconnect();
      }

   }

   public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
      this.field_4166.unregisterConnectionCallbacks(var1);
   }

   public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
      this.field_4166.unregisterConnectionFailedListener(var1);
   }

   interface class_1021 {
      // $FF: renamed from: b (com.google.android.gms.common.api.c$c) void
      void method_352(class_798.class_1019<?> var1);
   }

   class class_1020 extends Handler {
      class_1020(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         if(var1.what == 1) {
            class_798.this.field_4164.lock();

            try {
               if(!class_798.this.isConnected() && !class_798.this.isConnecting()) {
                  class_798.this.connect();
               }
            } finally {
               class_798.this.field_4164.unlock();
            }

         } else {
            Log.wtf("GoogleApiClientImpl", "Don\'t know how to handle this message.");
         }
      }
   }

   interface class_1019<A extends Api.class_1073> {
      // $FF: renamed from: a (com.google.android.gms.common.api.c$a) void
      void method_347(class_798.class_1021 var1);

      // $FF: renamed from: b (com.google.android.gms.common.api.Api$a) void
      void method_348(A var1) throws DeadObjectException;

      void cancel();

      // $FF: renamed from: eB () int
      int method_349();

      // $FF: renamed from: ew () com.google.android.gms.common.api.Api$c
      Api.class_1077<A> method_350();

      // $FF: renamed from: m (com.google.android.gms.common.api.Status) void
      void method_351(Status var1);
   }
}
