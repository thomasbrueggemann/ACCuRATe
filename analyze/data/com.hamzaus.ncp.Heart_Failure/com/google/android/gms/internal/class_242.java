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
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.internal.class_234;
import com.google.android.gms.internal.class_26;
import com.google.android.gms.internal.class_27;
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_324;
import com.google.android.gms.internal.class_332;
import com.google.android.gms.internal.class_334;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.gm;
import com.google.android.gms.internal.hc;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

// $FF: renamed from: com.google.android.gms.internal.gi
public final class class_242 extends hc<gm> {
   // $FF: renamed from: BD com.google.android.gms.internal.go
   private static final class_324 field_774 = new class_324("CastClientImpl");
   // $FF: renamed from: BX java.lang.Object
   private static final Object field_775 = new Object();
   // $FF: renamed from: BY java.lang.Object
   private static final Object field_776 = new Object();
   // $FF: renamed from: AM double
   private double field_777;
   // $FF: renamed from: AN boolean
   private boolean field_778;
   // $FF: renamed from: Ab com.google.android.gms.cast.Cast$Listener
   private final Cast.Listener field_779;
   // $FF: renamed from: BE com.google.android.gms.cast.ApplicationMetadata
   private ApplicationMetadata field_780;
   // $FF: renamed from: BF com.google.android.gms.cast.CastDevice
   private final CastDevice field_781;
   // $FF: renamed from: BG com.google.android.gms.internal.gn
   private final class_26 field_782;
   // $FF: renamed from: BH java.util.Map
   private final Map<String, Cast.MessageReceivedCallback> field_783;
   // $FF: renamed from: BI long
   private final long field_784;
   // $FF: renamed from: BJ java.lang.String
   private String field_785;
   // $FF: renamed from: BK boolean
   private boolean field_786;
   // $FF: renamed from: BL boolean
   private boolean field_787;
   // $FF: renamed from: BM boolean
   private boolean field_788;
   // $FF: renamed from: BN java.util.concurrent.atomic.AtomicBoolean
   private AtomicBoolean field_789;
   // $FF: renamed from: BO int
   private int field_790;
   // $FF: renamed from: BP java.util.concurrent.atomic.AtomicLong
   private final AtomicLong field_791;
   // $FF: renamed from: BQ java.lang.String
   private String field_792;
   // $FF: renamed from: BR java.lang.String
   private String field_793;
   // $FF: renamed from: BS android.os.Bundle
   private Bundle field_794;
   // $FF: renamed from: BT java.util.Map
   private Map<Long, class_797.class_1206<Status>> field_795;
   // $FF: renamed from: BU com.google.android.gms.internal.gi$b
   private class_242.class_918 field_796;
   // $FF: renamed from: BV com.google.android.gms.common.api.a$d
   private class_797.class_1206<Cast.ApplicationConnectionResult> field_797;
   // $FF: renamed from: BW com.google.android.gms.common.api.a$d
   private class_797.class_1206<Status> field_798;
   private final Handler mHandler;

   public class_242(Context var1, Looper var2, CastDevice var3, long var4, Cast.Listener var6, GoogleApiClient.ConnectionCallbacks var7, GoogleApiClient.OnConnectionFailedListener var8) {
      super(var1, var2, var7, var8, (String[])null);
      this.field_781 = var3;
      this.field_779 = var6;
      this.field_784 = var4;
      this.mHandler = new Handler(var2);
      this.field_783 = new HashMap();
      this.field_788 = false;
      this.field_790 = -1;
      this.field_780 = null;
      this.field_785 = null;
      this.field_789 = new AtomicBoolean(false);
      this.field_777 = 0.0D;
      this.field_778 = false;
      this.field_791 = new AtomicLong(0L);
      this.field_795 = new HashMap();
      this.field_796 = new class_242.class_918(null);
      this.registerConnectionFailedListener(this.field_796);
      this.field_782 = new class_26.class_1055() {
         // $FF: renamed from: X (int) boolean
         private boolean method_3430(int param1) {
            // $FF: Couldn't be decompiled
         }

         // $FF: renamed from: b (long, int) void
         private void method_3431(long param1, int param3) {
            // $FF: Couldn't be decompiled
         }

         // $FF: renamed from: T (int) void
         public void method_113(int var1) {
            class_324 var2 = class_242.field_774;
            Object[] var3 = new Object[]{Integer.valueOf(var1)};
            var2.method_2066("ICastDeviceControllerListener.onDisconnected: %d", var3);
            class_242.this.field_788 = false;
            class_242.this.field_789.set(false);
            class_242.this.field_780 = null;
            if(var1 != 0) {
               class_242.this.an(2);
            }

         }

         // $FF: renamed from: U (int) void
         public void method_114(int param1) {
            // $FF: Couldn't be decompiled
         }

         // $FF: renamed from: V (int) void
         public void method_115(int var1) {
            this.method_3430(var1);
         }

         // $FF: renamed from: W (int) void
         public void method_116(int var1) {
            this.method_3430(var1);
         }

         // $FF: renamed from: a (com.google.android.gms.cast.ApplicationMetadata, java.lang.String, java.lang.String, boolean) void
         public void method_117(ApplicationMetadata param1, String param2, String param3, boolean param4) {
            // $FF: Couldn't be decompiled
         }

         // $FF: renamed from: a (java.lang.String, double, boolean) void
         public void method_118(String var1, double var2, boolean var4) {
            class_242.field_774.method_2066("Deprecated callback: \"onStatusreceived\"", new Object[0]);
         }

         // $FF: renamed from: a (java.lang.String, long) void
         public void method_119(String var1, long var2) {
            this.method_3431(var2, 0);
         }

         // $FF: renamed from: a (java.lang.String, long, int) void
         public void method_120(String var1, long var2, int var4) {
            this.method_3431(var2, var4);
         }

         // $FF: renamed from: b (com.google.android.gms.internal.gf) void
         public void method_121(final class_336 var1) {
            class_242.field_774.method_2066("onApplicationStatusChanged", new Object[0]);
            class_242.this.mHandler.post(new Runnable() {
               public void run() {
                  class_242.this.method_1663(var1);
               }
            });
         }

         // $FF: renamed from: b (com.google.android.gms.internal.gk) void
         public void method_122(final class_334 var1) {
            class_242.field_774.method_2066("onDeviceStatusChanged", new Object[0]);
            class_242.this.mHandler.post(new Runnable() {
               public void run() {
                  class_242.this.method_1666(var1);
               }
            });
         }

         // $FF: renamed from: b (java.lang.String, byte[]) void
         public void method_123(String var1, byte[] var2) {
            class_324 var3 = class_242.field_774;
            Object[] var4 = new Object[]{var1, Integer.valueOf(var2.length)};
            var3.method_2066("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", var4);
         }

         // $FF: renamed from: g (java.lang.String, java.lang.String) void
         public void method_124(final String var1, final String var2) {
            class_242.field_774.method_2066("Receive (type=text, ns=%s) %s", new Object[]{var1, var2});
            class_242.this.mHandler.post(new Runnable() {
               public void run() {
                  // $FF: Couldn't be decompiled
               }
            });
         }

         public void onApplicationDisconnected(final int var1) {
            class_242.this.field_792 = null;
            class_242.this.field_793 = null;
            this.method_3430(var1);
            if(class_242.this.field_779 != null) {
               class_242.this.mHandler.post(new Runnable() {
                  public void run() {
                     if(class_242.this.field_779 != null) {
                        class_242.this.field_779.onApplicationDisconnected(var1);
                     }

                  }
               });
            }

         }
      };
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gi, com.google.android.gms.common.api.a$d) com.google.android.gms.common.api.a$d
   // $FF: synthetic method
   static class_797.class_1206 method_1661(class_242 var0, class_797.class_1206 var1) {
      var0.field_797 = var1;
      return var1;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gf) void
   private void method_1663(class_336 var1) {
      String var2 = var1.method_2130();
      boolean var3;
      if(!class_332.method_2117(var2, this.field_785)) {
         this.field_785 = var2;
         var3 = true;
      } else {
         var3 = false;
      }

      class_324 var4 = field_774;
      Object[] var5 = new Object[]{Boolean.valueOf(var3), Boolean.valueOf(this.field_786)};
      var4.method_2066("hasChanged=%b, mFirstApplicationStatusUpdate=%b", var5);
      if(this.field_779 != null && (var3 || this.field_786)) {
         this.field_779.onApplicationStatusChanged();
      }

      this.field_786 = false;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.gk) void
   private void method_1666(class_334 var1) {
      double var2 = var1.method_2126();
      boolean var4;
      if(var2 != Double.NaN && var2 != this.field_777) {
         this.field_777 = var2;
         var4 = true;
      } else {
         var4 = false;
      }

      boolean var5 = var1.method_2127();
      if(var5 != this.field_778) {
         this.field_778 = var5;
         var4 = true;
      }

      class_324 var6 = field_774;
      Object[] var7 = new Object[]{Boolean.valueOf(var4), Boolean.valueOf(this.field_787)};
      var6.method_2066("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", var7);
      if(this.field_779 != null && (var4 || this.field_787)) {
         this.field_779.onVolumeChanged();
      }

      int var8 = var1.method_2128();
      boolean var9;
      if(var8 != this.field_790) {
         this.field_790 = var8;
         var9 = true;
      } else {
         var9 = false;
      }

      class_324 var10 = field_774;
      Object[] var11 = new Object[]{Boolean.valueOf(var9), Boolean.valueOf(this.field_787)};
      var10.method_2066("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", var11);
      if(this.field_779 != null && (var9 || this.field_787)) {
         this.field_779.method_3285(this.field_790);
      }

      this.field_787 = false;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.gi, com.google.android.gms.common.api.a$d) com.google.android.gms.common.api.a$d
   // $FF: synthetic method
   static class_797.class_1206 method_1668(class_242 var0, class_797.class_1206 var1) {
      var0.field_798 = var1;
      return var1;
   }

   // $FF: renamed from: c (com.google.android.gms.internal.gi) com.google.android.gms.common.api.a$d
   // $FF: synthetic method
   static class_797.class_1206 method_1671(class_242 var0) {
      return var0.field_797;
   }

   // $FF: renamed from: c (com.google.android.gms.common.api.a$d) void
   private void method_1672(class_797.class_1206<Cast.ApplicationConnectionResult> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: e (com.google.android.gms.common.api.a$d) void
   private void method_1675(class_797.class_1206<Status> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ed () void
   private void method_1676() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ee () void
   private void method_1677() throws IllegalStateException {
      if(!this.field_788 || this.field_789.get()) {
         throw new IllegalStateException("Not connected to a device");
      }
   }

   // $FF: renamed from: eg () java.lang.Object
   // $FF: synthetic method
   static Object method_1679() {
      return field_775;
   }

   // $FF: renamed from: eh () java.lang.Object
   // $FF: synthetic method
   static Object method_1680() {
      return field_776;
   }

   // $FF: renamed from: f (com.google.android.gms.internal.gi) java.util.Map
   // $FF: synthetic method
   static Map method_1681(class_242 var0) {
      return var0.field_783;
   }

   // $FF: renamed from: g (com.google.android.gms.internal.gi) com.google.android.gms.cast.CastDevice
   // $FF: synthetic method
   static CastDevice method_1682(class_242 var0) {
      return var0.field_781;
   }

   // $FF: renamed from: h (com.google.android.gms.internal.gi) java.util.Map
   // $FF: synthetic method
   static Map method_1683(class_242 var0) {
      return var0.field_795;
   }

   // $FF: renamed from: i (com.google.android.gms.internal.gi) com.google.android.gms.common.api.a$d
   // $FF: synthetic method
   static class_797.class_1206 method_1684(class_242 var0) {
      return var0.field_798;
   }

   // $FF: renamed from: G (android.os.IBinder) com.google.android.gms.internal.gm
   protected class_27 method_1686(IBinder var1) {
      return class_27.class_1058.method_3805(var1);
   }

   // $FF: renamed from: a (double) void
   public void method_1687(double var1) throws IllegalArgumentException, IllegalStateException, RemoteException {
      if(!Double.isInfinite(var1) && !Double.isNaN(var1)) {
         ((class_27)this.fo()).method_125(var1, this.field_777, this.field_778);
      } else {
         throw new IllegalArgumentException("Volume cannot be " + var1);
      }
   }

   // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
   protected void method_1446(int var1, IBinder var2, Bundle var3) {
      class_324 var4 = field_774;
      Object[] var5 = new Object[]{Integer.valueOf(var1)};
      var4.method_2066("in onPostInitHandler; statusCode=%d", var5);
      if(var1 != 0 && var1 != 1001) {
         this.field_788 = false;
      } else {
         this.field_788 = true;
         this.field_786 = true;
         this.field_787 = true;
      }

      if(var1 == 1001) {
         this.field_794 = new Bundle();
         this.field_794.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
         var1 = 0;
      }

      super.method_1446(var1, var2, var3);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException {
      Bundle var3 = new Bundle();
      class_324 var4 = field_774;
      Object[] var5 = new Object[]{this.field_792, this.field_793};
      var4.method_2066("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", var5);
      this.field_781.putInBundle(var3);
      var3.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.field_784);
      if(this.field_792 != null) {
         var3.putString("last_application_id", this.field_792);
         if(this.field_793 != null) {
            var3.putString("last_session_id", this.field_793);
         }
      }

      var1.method_155(var2, 5077000, this.getContext().getPackageName(), this.field_782.asBinder(), var3);
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.cast.Cast$MessageReceivedCallback) void
   public void method_1688(String param1, Cast.MessageReceivedCallback param2) throws IllegalArgumentException, IllegalStateException, RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.cast.LaunchOptions, com.google.android.gms.common.api.a$d) void
   public void method_1689(String var1, LaunchOptions var2, class_797.class_1206<Cast.ApplicationConnectionResult> var3) throws IllegalStateException, RemoteException {
      this.method_1672(var3);
      ((class_27)this.fo()).method_126(var1, var2);
   }

   // $FF: renamed from: a (java.lang.String, com.google.android.gms.common.api.a$d) void
   public void method_1690(String var1, class_797.class_1206<Status> var2) throws IllegalStateException, RemoteException {
      this.method_1675(var2);
      ((class_27)this.fo()).method_130(var1);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, com.google.android.gms.common.api.a$d) void
   public void method_1691(String var1, String var2, class_797.class_1206<Status> var3) throws IllegalArgumentException, IllegalStateException, RemoteException {
      if(TextUtils.isEmpty(var2)) {
         throw new IllegalArgumentException("The message payload cannot be null or empty");
      } else if(var2.length() > 65536) {
         throw new IllegalArgumentException("Message exceeds maximum size");
      } else {
         class_332.method_2118(var1);
         this.method_1677();
         long var4 = this.field_791.incrementAndGet();
         ((class_27)this.fo()).method_127(var1, var2, var4);
         this.field_795.put(Long.valueOf(var4), var3);
      }
   }

   // $FF: renamed from: a (java.lang.String, boolean, com.google.android.gms.common.api.a$d) void
   public void method_1692(String var1, boolean var2, class_797.class_1206<Cast.ApplicationConnectionResult> var3) throws IllegalStateException, RemoteException {
      this.method_1672(var3);
      ((class_27)this.fo()).method_133(var1, var2);
   }

   // $FF: renamed from: aj (java.lang.String) void
   public void method_1693(String param1) throws IllegalArgumentException, RemoteException {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (java.lang.String, java.lang.String, com.google.android.gms.common.api.a$d) void
   public void method_1694(String var1, String var2, class_797.class_1206<Cast.ApplicationConnectionResult> var3) throws IllegalStateException, RemoteException {
      this.method_1672(var3);
      ((class_27)this.fo()).method_136(var1, var2);
   }

   // $FF: renamed from: bp () java.lang.String
   protected String method_1451() {
      return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
   }

   // $FF: renamed from: bq () java.lang.String
   protected String method_1452() {
      return "com.google.android.gms.cast.internal.ICastDeviceController";
   }

   // $FF: renamed from: d (com.google.android.gms.common.api.a$d) void
   public void method_1695(class_797.class_1206<Status> var1) throws IllegalStateException, RemoteException {
      this.method_1675(var1);
      ((class_27)this.fo()).method_135();
   }

   public void disconnect() {
      class_324 var1 = field_774;
      Object[] var2 = new Object[]{Boolean.valueOf(this.field_789.get()), Boolean.valueOf(this.isConnected())};
      var1.method_2066("disconnect(); mDisconnecting=%b, isConnected=%b", var2);
      if(this.field_789.getAndSet(true)) {
         field_774.method_2066("mDisconnecting is set, so short-circuiting", new Object[0]);
      } else {
         this.method_1676();

         try {
            if(this.isConnected() || this.isConnecting()) {
               ((class_27)this.fo()).disconnect();
            }

            return;
         } catch (RemoteException var9) {
            class_324 var5 = field_774;
            Object[] var6 = new Object[]{var9.getMessage()};
            var5.method_2064(var9, "Error while disconnecting the controller interface: %s", var6);
         } finally {
            super.disconnect();
         }

      }
   }

   // $FF: renamed from: ea () android.os.Bundle
   public Bundle method_777() {
      if(this.field_794 != null) {
         Bundle var1 = this.field_794;
         this.field_794 = null;
         return var1;
      } else {
         return super.method_777();
      }
   }

   // $FF: renamed from: eb () void
   public void method_1696() throws IllegalStateException, RemoteException {
      ((class_27)this.fo()).method_134();
   }

   // $FF: renamed from: ec () double
   public double method_1697() throws IllegalStateException {
      this.method_1677();
      return this.field_777;
   }

   public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
      this.method_1677();
      return this.field_780;
   }

   public String getApplicationStatus() throws IllegalStateException {
      this.method_1677();
      return this.field_785;
   }

   public boolean isMute() throws IllegalStateException {
      this.method_1677();
      return this.field_778;
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   // $FF: synthetic method
   protected IInterface method_1456(IBinder var1) {
      return this.method_1686(var1);
   }

   // $FF: renamed from: y (boolean) void
   public void method_1698(boolean var1) throws IllegalStateException, RemoteException {
      ((class_27)this.fo()).method_129(var1, this.field_777, this.field_778);
   }

   private static final class class_917 implements Cast.ApplicationConnectionResult {
      // $FF: renamed from: Cf com.google.android.gms.cast.ApplicationMetadata
      private final ApplicationMetadata field_4284;
      // $FF: renamed from: Cg java.lang.String
      private final String field_4285;
      // $FF: renamed from: Ch boolean
      private final boolean field_4286;
      // $FF: renamed from: rO java.lang.String
      private final String field_4287;
      // $FF: renamed from: yw com.google.android.gms.common.api.Status
      private final Status field_4288;

      public class_917(Status var1) {
         this(var1, (ApplicationMetadata)null, (String)null, (String)null, false);
      }

      public class_917(Status var1, ApplicationMetadata var2, String var3, String var4, boolean var5) {
         this.field_4288 = var1;
         this.field_4284 = var2;
         this.field_4285 = var3;
         this.field_4287 = var4;
         this.field_4286 = var5;
      }

      public ApplicationMetadata getApplicationMetadata() {
         return this.field_4284;
      }

      public String getApplicationStatus() {
         return this.field_4285;
      }

      public String getSessionId() {
         return this.field_4287;
      }

      public Status getStatus() {
         return this.field_4288;
      }

      public boolean getWasLaunched() {
         return this.field_4286;
      }
   }

   private class class_918 implements GoogleApiClient.OnConnectionFailedListener {
      private class_918() {
      }

      // $FF: synthetic method
      class_918(Object var2) {
         this();
      }

      public void onConnectionFailed(ConnectionResult var1) {
         class_242.this.method_1676();
      }
   }
}
