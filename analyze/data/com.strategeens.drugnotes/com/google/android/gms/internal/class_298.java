package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_14;
import com.google.android.gms.internal.class_15;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.class_319;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_324;
import com.google.android.gms.internal.class_325;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.jl;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

// $FF: renamed from: com.google.android.gms.internal.im
public final class class_298 extends jl<iq> {
   // $FF: renamed from: HB java.lang.Object
   private static final Object field_626 = new Object();
   // $FF: renamed from: HC java.lang.Object
   private static final Object field_627 = new Object();
   // $FF: renamed from: Hh com.google.android.gms.internal.is
   private static final class_319 field_628 = new class_319("CastClientImpl");
   // $FF: renamed from: FD com.google.android.gms.cast.Cast$Listener
   private final Cast.Listener field_629;
   // $FF: renamed from: Gp double
   private double field_630;
   // $FF: renamed from: Gq boolean
   private boolean field_631;
   // $FF: renamed from: HA com.google.android.gms.common.api.BaseImplementation$b
   private BaseImplementation.class_1058<Status> field_632;
   // $FF: renamed from: Hi com.google.android.gms.cast.ApplicationMetadata
   private ApplicationMetadata field_633;
   // $FF: renamed from: Hj com.google.android.gms.cast.CastDevice
   private final CastDevice field_634;
   // $FF: renamed from: Hk java.util.Map
   private final Map<String, Cast.MessageReceivedCallback> field_635;
   // $FF: renamed from: Hl long
   private final long field_636;
   // $FF: renamed from: Hm com.google.android.gms.internal.im$c
   private class_298.class_1249 field_637;
   // $FF: renamed from: Hn java.lang.String
   private String field_638;
   // $FF: renamed from: Ho boolean
   private boolean field_639;
   // $FF: renamed from: Hp boolean
   private boolean field_640;
   // $FF: renamed from: Hq boolean
   private boolean field_641;
   // $FF: renamed from: Hr int
   private int field_642;
   // $FF: renamed from: Hs int
   private int field_643;
   // $FF: renamed from: Ht java.util.concurrent.atomic.AtomicLong
   private final AtomicLong field_644;
   // $FF: renamed from: Hu java.lang.String
   private String field_645;
   // $FF: renamed from: Hv java.lang.String
   private String field_646;
   // $FF: renamed from: Hw android.os.Bundle
   private Bundle field_647;
   // $FF: renamed from: Hx java.util.Map
   private final Map<Long, BaseImplementation.class_1058<Status>> field_648;
   // $FF: renamed from: Hy com.google.android.gms.internal.im$b
   private final class_298.class_1248 field_649;
   // $FF: renamed from: Hz com.google.android.gms.common.api.BaseImplementation$b
   private BaseImplementation.class_1058<Cast.ApplicationConnectionResult> field_650;
   private final Handler mHandler;

   public class_298(Context var1, Looper var2, CastDevice var3, long var4, Cast.Listener var6, GoogleApiClient.ConnectionCallbacks var7, GoogleApiClient.OnConnectionFailedListener var8) {
      super(var1, var2, var7, var8, (String[])null);
      this.field_634 = var3;
      this.field_629 = var6;
      this.field_636 = var4;
      this.mHandler = new Handler(var2);
      this.field_635 = new HashMap();
      this.field_644 = new AtomicLong(0L);
      this.field_648 = new HashMap();
      this.method_2047();
      this.field_649 = new class_298.class_1248();
      this.registerConnectionFailedListener(this.field_649);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.im, com.google.android.gms.cast.ApplicationMetadata) com.google.android.gms.cast.ApplicationMetadata
   // $FF: synthetic method
   static ApplicationMetadata method_2031(class_298 var0, ApplicationMetadata var1) {
      var0.field_633 = var1;
      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.im, com.google.android.gms.common.api.BaseImplementation$b) com.google.android.gms.common.api.BaseImplementation$b
   // $FF: synthetic method
   static BaseImplementation.class_1058 method_2032(class_298 var0, BaseImplementation.class_1058 var1) {
      var0.field_650 = var1;
      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ij) void
   private void method_2034(class_325 var1) {
      String var2 = var1.method_2282();
      boolean var3;
      if(!class_322.method_2262(var2, this.field_638)) {
         this.field_638 = var2;
         var3 = true;
      } else {
         var3 = false;
      }

      class_319 var4 = field_628;
      Object[] var5 = new Object[]{Boolean.valueOf(var3), Boolean.valueOf(this.field_639)};
      var4.method_2233("hasChanged=%b, mFirstApplicationStatusUpdate=%b", var5);
      if(this.field_629 != null && (var3 || this.field_639)) {
         this.field_629.onApplicationStatusChanged();
      }

      this.field_639 = false;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.io) void
   private void method_2037(class_324 var1) {
      ApplicationMetadata var2 = var1.getApplicationMetadata();
      if(!class_322.method_2262(var2, this.field_633)) {
         this.field_633 = var2;
         this.field_629.onApplicationMetadataChanged(this.field_633);
      }

      double var3 = var1.method_2278();
      boolean var5;
      if(var3 != Double.NaN && var3 != this.field_630) {
         this.field_630 = var3;
         var5 = true;
      } else {
         var5 = false;
      }

      boolean var6 = var1.method_2279();
      if(var6 != this.field_631) {
         this.field_631 = var6;
         var5 = true;
      }

      class_319 var7 = field_628;
      Object[] var8 = new Object[]{Boolean.valueOf(var5), Boolean.valueOf(this.field_640)};
      var7.method_2233("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", var8);
      if(this.field_629 != null && (var5 || this.field_640)) {
         this.field_629.onVolumeChanged();
      }

      int var9 = var1.method_2280();
      boolean var10;
      if(var9 != this.field_642) {
         this.field_642 = var9;
         var10 = true;
      } else {
         var10 = false;
      }

      class_319 var11 = field_628;
      Object[] var12 = new Object[]{Boolean.valueOf(var10), Boolean.valueOf(this.field_640)};
      var11.method_2233("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", var12);
      if(this.field_629 != null && (var10 || this.field_640)) {
         this.field_629.method_3900(this.field_642);
      }

      int var13 = var1.method_2281();
      boolean var14;
      if(var13 != this.field_643) {
         this.field_643 = var13;
         var14 = true;
      } else {
         var14 = false;
      }

      class_319 var15 = field_628;
      Object[] var16 = new Object[]{Boolean.valueOf(var14), Boolean.valueOf(this.field_640)};
      var15.method_2233("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", var16);
      if(this.field_629 != null && (var14 || this.field_640)) {
         this.field_629.method_3901(this.field_643);
      }

      this.field_640 = false;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.im, com.google.android.gms.common.api.BaseImplementation$b) com.google.android.gms.common.api.BaseImplementation$b
   // $FF: synthetic method
   static BaseImplementation.class_1058 method_2038(class_298 var0, BaseImplementation.class_1058 var1) {
      var0.field_632 = var1;
      return var1;
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.BaseImplementation$b) void
   private void method_2041(BaseImplementation.class_1058<Cast.ApplicationConnectionResult> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d (com.google.android.gms.internal.im) com.google.android.gms.common.api.BaseImplementation$b
   // $FF: synthetic method
   static BaseImplementation.class_1058 method_2043(class_298 var0) {
      return var0.field_650;
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.BaseImplementation$b) void
   private void method_2045(BaseImplementation.class_1058<Status> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: fW () void
   private void method_2047() {
      this.field_641 = false;
      this.field_642 = -1;
      this.field_643 = -1;
      this.field_633 = null;
      this.field_638 = null;
      this.field_630 = 0.0D;
      this.field_631 = false;
   }

   // $FF: renamed from: g (com.google.android.gms.internal.im) java.util.Map
   // $FF: synthetic method
   static Map method_2048(class_298 var0) {
      return var0.field_635;
   }

   // $FF: renamed from: ga () void
   private void method_2049() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: gb () void
   private void method_2050() throws IllegalStateException {
      if(!this.field_641 || this.field_637 == null || this.field_637.method_3970()) {
         throw new IllegalStateException("Not connected to a device");
      }
   }

   // $FF: renamed from: ge () java.lang.Object
   // $FF: synthetic method
   static Object method_2052() {
      return field_626;
   }

   // $FF: renamed from: gf () java.lang.Object
   // $FF: synthetic method
   static Object method_2053() {
      return field_627;
   }

   // $FF: renamed from: h (com.google.android.gms.internal.im) com.google.android.gms.cast.CastDevice
   // $FF: synthetic method
   static CastDevice method_2054(class_298 var0) {
      return var0.field_634;
   }

   // $FF: renamed from: i (com.google.android.gms.internal.im) java.util.Map
   // $FF: synthetic method
   static Map method_2055(class_298 var0) {
      return var0.field_648;
   }

   // $FF: renamed from: j (com.google.android.gms.internal.im) com.google.android.gms.common.api.BaseImplementation$b
   // $FF: synthetic method
   static BaseImplementation.class_1058 method_2056(class_298 var0) {
      return var0.field_632;
   }

   // $FF: renamed from: I (boolean) void
   public void method_2057(boolean var1) throws IllegalStateException, RemoteException {
      ((class_14)this.hw()).method_90(var1, this.field_630, this.field_631);
   }

   // $FF: renamed from: L (android.os.IBinder) com.google.android.gms.internal.iq
   protected class_14 method_2058(IBinder var1) {
      return class_14.class_1402.method_5444(var1);
   }

   // $FF: renamed from: a (double) void
   public void method_2059(double var1) throws IllegalArgumentException, IllegalStateException, RemoteException {
      if(!Double.isInfinite(var1) && !Double.isNaN(var1)) {
         ((class_14)this.hw()).method_86(var1, this.field_630, this.field_631);
      } else {
         throw new IllegalArgumentException("Volume cannot be " + var1);
      }
   }

   // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
   protected void method_1790(int var1, IBinder var2, Bundle var3) {
      class_319 var4 = field_628;
      Object[] var5 = new Object[]{Integer.valueOf(var1)};
      var4.method_2233("in onPostInitHandler; statusCode=%d", var5);
      if(var1 != 0 && var1 != 1001) {
         this.field_641 = false;
      } else {
         this.field_641 = true;
         this.field_639 = true;
         this.field_640 = true;
      }

      if(var1 == 1001) {
         this.field_647 = new Bundle();
         this.field_647.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
         var1 = 0;
      }

      super.method_1790(var1, var2, var3);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException {
      Bundle var3 = new Bundle();
      class_319 var4 = field_628;
      Object[] var5 = new Object[]{this.field_645, this.field_646};
      var4.method_2233("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", var5);
      this.field_634.putInBundle(var3);
      var3.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.field_636);
      if(this.field_645 != null) {
         var3.putString("last_application_id", this.field_645);
         if(this.field_646 != null) {
            var3.putString("last_session_id", this.field_646);
         }
      }

      this.field_637 = new class_298.class_1249();
      var1.method_130(var2, 6587000, this.getContext().getPackageName(), this.field_637.asBinder(), var3);
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.cast.Cast$MessageReceivedCallback) void
   public void method_2060(String param1, Cast.MessageReceivedCallback param2) throws IllegalArgumentException, IllegalStateException, RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.cast.LaunchOptions, com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_2061(String var1, LaunchOptions var2, BaseImplementation.class_1058<Cast.ApplicationConnectionResult> var3) throws IllegalStateException, RemoteException {
      this.method_2041(var3);
      ((class_14)this.hw()).method_87(var1, var2);
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_2062(String var1, BaseImplementation.class_1058<Status> var2) throws IllegalStateException, RemoteException {
      this.method_2045(var2);
      ((class_14)this.hw()).method_91(var1);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_2063(String var1, String var2, BaseImplementation.class_1058<Status> var3) throws IllegalArgumentException, IllegalStateException, RemoteException {
      if(TextUtils.isEmpty(var2)) {
         throw new IllegalArgumentException("The message payload cannot be null or empty");
      } else if(var2.length() > 65536) {
         throw new IllegalArgumentException("Message exceeds maximum size");
      } else {
         class_322.method_2263(var1);
         this.method_2050();
         long var4 = this.field_644.incrementAndGet();

         try {
            this.field_648.put(Long.valueOf(var4), var3);
            ((class_14)this.hw()).method_88(var1, var2, var4);
         } catch (Throwable var7) {
            this.field_648.remove(Long.valueOf(var4));
            throw var7;
         }
      }
   }

   // $FF: renamed from: a (java.lang.String, boolean, com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_2064(String var1, boolean var2, BaseImplementation.class_1058<Cast.ApplicationConnectionResult> var3) throws IllegalStateException, RemoteException {
      this.method_2041(var3);
      ((class_14)this.hw()).method_95(var1, var2);
   }

   // $FF: renamed from: aE (java.lang.String) void
   public void method_2065(String param1) throws IllegalArgumentException, RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (java.lang.String, java.lang.String, com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_2066(String var1, String var2, BaseImplementation.class_1058<Cast.ApplicationConnectionResult> var3) throws IllegalStateException, RemoteException {
      this.method_2041(var3);
      ((class_14)this.hw()).method_97(var1, var2);
   }

   // $FF: renamed from: bK () java.lang.String
   protected String method_1794() {
      return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
   }

   // $FF: renamed from: bL () java.lang.String
   protected String method_1795() {
      return "com.google.android.gms.cast.internal.ICastDeviceController";
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.BaseImplementation$b) void
   public void method_2067(BaseImplementation.class_1058<Status> var1) throws IllegalStateException, RemoteException {
      this.method_2045(var1);
      ((class_14)this.hw()).method_96();
   }

   public void disconnect() {
      class_319 var1 = field_628;
      Object[] var2 = new Object[]{this.field_637, Boolean.valueOf(this.isConnected())};
      var1.method_2233("disconnect(); ServiceListener=%s, isConnected=%b", var2);
      class_298.class_1249 var3 = this.field_637;
      this.field_637 = null;
      if(var3 != null && var3.method_3969()) {
         this.method_2049();

         try {
            if(this.isConnected() || this.isConnecting()) {
               ((class_14)this.hw()).disconnect();
            }

            return;
         } catch (RemoteException var10) {
            class_319 var6 = field_628;
            Object[] var7 = new Object[]{var10.getMessage()};
            var6.method_2231(var10, "Error while disconnecting the controller interface: %s", var7);
         } finally {
            super.disconnect();
         }

      } else {
         field_628.method_2233("already disposed, so short-circuiting", new Object[0]);
      }
   }

   // $FF: renamed from: fX () android.os.Bundle
   public Bundle method_948() {
      if(this.field_647 != null) {
         Bundle var1 = this.field_647;
         this.field_647 = null;
         return var1;
      } else {
         return super.method_948();
      }
   }

   // $FF: renamed from: fY () void
   public void method_2068() throws IllegalStateException, RemoteException {
      ((class_14)this.hw()).method_94();
   }

   // $FF: renamed from: fZ () double
   public double method_2069() throws IllegalStateException {
      this.method_2050();
      return this.field_630;
   }

   public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
      this.method_2050();
      return this.field_633;
   }

   public String getApplicationStatus() throws IllegalStateException {
      this.method_2050();
      return this.field_638;
   }

   public boolean isMute() throws IllegalStateException {
      this.method_2050();
      return this.field_631;
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1800(IBinder var1) {
      return this.method_2058(var1);
   }

   private static final class class_1247 implements Cast.ApplicationConnectionResult {
      // $FF: renamed from: Eb com.google.android.gms.common.api.Status
      private final Status field_3066;
      // $FF: renamed from: HD com.google.android.gms.cast.ApplicationMetadata
      private final ApplicationMetadata field_3067;
      // $FF: renamed from: HE java.lang.String
      private final String field_3068;
      // $FF: renamed from: HF boolean
      private final boolean field_3069;
      // $FF: renamed from: vZ java.lang.String
      private final String field_3070;

      public class_1247(Status var1) {
         this(var1, (ApplicationMetadata)null, (String)null, (String)null, false);
      }

      public class_1247(Status var1, ApplicationMetadata var2, String var3, String var4, boolean var5) {
         this.field_3066 = var1;
         this.field_3067 = var2;
         this.field_3068 = var3;
         this.field_3070 = var4;
         this.field_3069 = var5;
      }

      public ApplicationMetadata getApplicationMetadata() {
         return this.field_3067;
      }

      public String getApplicationStatus() {
         return this.field_3068;
      }

      public String getSessionId() {
         return this.field_3070;
      }

      public Status getStatus() {
         return this.field_3066;
      }

      public boolean getWasLaunched() {
         return this.field_3069;
      }
   }

   private class class_1248 implements GoogleApiClient.OnConnectionFailedListener {
      private class_1248() {
      }

      // $FF: synthetic method
      class_1248(Object var2) {
         this();
      }

      public void onConnectionFailed(ConnectionResult var1) {
         class_298.this.method_2049();
      }
   }

   private class class_1249 extends class_15.class_1404 {
      // $FF: renamed from: HH java.util.concurrent.atomic.AtomicBoolean
      private final AtomicBoolean field_3073;

      private class_1249() {
         this.field_3073 = new AtomicBoolean(false);
      }

      // $FF: synthetic method
      class_1249(Object var2) {
         this();
      }

      // $FF: renamed from: ah (int) boolean
      private boolean method_3967(int param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (long, int) void
      private void method_3968(long param1, int param3) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.cast.ApplicationMetadata, java.lang.String, java.lang.String, boolean) void
      public void method_98(ApplicationMetadata param1, String param2, String param3, boolean param4) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (java.lang.String, double, boolean) void
      public void method_99(String var1, double var2, boolean var4) {
         class_298.field_628.method_2233("Deprecated callback: \"onStatusreceived\"", new Object[0]);
      }

      // $FF: renamed from: a (java.lang.String, long) void
      public void method_100(String var1, long var2) {
         if(!this.field_3073.get()) {
            this.method_3968(var2, 0);
         }
      }

      // $FF: renamed from: a (java.lang.String, long, int) void
      public void method_101(String var1, long var2, int var4) {
         if(!this.field_3073.get()) {
            this.method_3968(var2, var4);
         }
      }

      // $FF: renamed from: ad (int) void
      public void method_102(int var1) {
         if(this.method_3969()) {
            class_319 var2 = class_298.field_628;
            Object[] var3 = new Object[]{Integer.valueOf(var1)};
            var2.method_2233("ICastDeviceControllerListener.onDisconnected: %d", var3);
            if(var1 != 0) {
               class_298.this.aD(2);
               return;
            }
         }

      }

      // $FF: renamed from: ae (int) void
      public void method_103(int param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: af (int) void
      public void method_104(int var1) {
         if(!this.field_3073.get()) {
            this.method_3967(var1);
         }
      }

      // $FF: renamed from: ag (int) void
      public void method_105(int var1) {
         if(!this.field_3073.get()) {
            this.method_3967(var1);
         }
      }

      // $FF: renamed from: b (com.google.android.gms.internal.ij) void
      public void method_106(final class_325 var1) {
         if(!this.field_3073.get()) {
            class_298.field_628.method_2233("onApplicationStatusChanged", new Object[0]);
            class_298.this.mHandler.post(new Runnable() {
               public void run() {
                  class_298.this.method_2034(var1);
               }
            });
         }
      }

      // $FF: renamed from: b (com.google.android.gms.internal.io) void
      public void method_107(final class_324 var1) {
         if(!this.field_3073.get()) {
            class_298.field_628.method_2233("onDeviceStatusChanged", new Object[0]);
            class_298.this.mHandler.post(new Runnable() {
               public void run() {
                  class_298.this.method_2037(var1);
               }
            });
         }
      }

      // $FF: renamed from: b (java.lang.String, byte[]) void
      public void method_108(String var1, byte[] var2) {
         if(!this.field_3073.get()) {
            class_319 var3 = class_298.field_628;
            Object[] var4 = new Object[]{var1, Integer.valueOf(var2.length)};
            var3.method_2233("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", var4);
         }
      }

      // $FF: renamed from: gg () boolean
      public boolean method_3969() {
         if(this.field_3073.getAndSet(true)) {
            return false;
         } else {
            class_298.this.method_2047();
            return true;
         }
      }

      // $FF: renamed from: gh () boolean
      public boolean method_3970() {
         return this.field_3073.get();
      }

      // $FF: renamed from: j (java.lang.String, java.lang.String) void
      public void method_109(final String var1, final String var2) {
         if(!this.field_3073.get()) {
            class_298.field_628.method_2233("Receive (type=text, ns=%s) %s", new Object[]{var1, var2});
            class_298.this.mHandler.post(new Runnable() {
               public void run() {
                  // $FF: Couldn't be decompiled
               }
            });
         }
      }

      public void onApplicationDisconnected(final int var1) {
         if(!this.field_3073.get()) {
            class_298.this.field_645 = null;
            class_298.this.field_646 = null;
            this.method_3967(var1);
            if(class_298.this.field_629 != null) {
               class_298.this.mHandler.post(new Runnable() {
                  public void run() {
                     if(class_298.this.field_629 != null) {
                        class_298.this.field_629.onApplicationDisconnected(var1);
                     }

                  }
               });
               return;
            }
         }

      }
   }
}
