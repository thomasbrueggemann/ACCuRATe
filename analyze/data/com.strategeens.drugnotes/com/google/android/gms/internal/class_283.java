package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_22;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_341;
import com.google.android.gms.internal.class_342;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.jl
public abstract class class_283<T extends IInterface> implements Api.class_1390, class_342.class_1616 {
   // $FF: renamed from: MP java.lang.String[]
   public static final String[] field_594 = new String[]{"service_esmobile", "service_googleme"};
   // $FF: renamed from: JF android.os.Looper
   private final Looper field_595;
   // $FF: renamed from: JS com.google.android.gms.internal.jm
   private final class_342 field_596;
   // $FF: renamed from: MJ android.os.IInterface
   private T field_597;
   // $FF: renamed from: MK java.util.ArrayList
   private final ArrayList<com/google/android/gms/internal/jl<T>.b<?>> field_598;
   // $FF: renamed from: ML com.google.android.gms.internal.jl$f
   private com/google/android/gms/internal/jl<T>.f field_599;
   // $FF: renamed from: MM int
   private int field_600;
   // $FF: renamed from: MN java.lang.String[]
   private final String[] field_601;
   // $FF: renamed from: MO boolean
   boolean field_602;
   private final Context mContext;
   // $FF: renamed from: mH java.lang.Object
   private final Object field_603;
   final Handler mHandler;

   protected class_283(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String... var5) {
      this.field_603 = new Object();
      this.field_598 = new ArrayList();
      this.field_600 = 1;
      this.field_602 = false;
      this.mContext = (Context)class_335.method_2311(var1);
      this.field_595 = (Looper)class_335.method_2306(var2, "Looper must not be null");
      this.field_596 = new class_342(var1, var2, this);
      this.mHandler = new class_283.class_1226(var2);
      this.method_1796(var5);
      this.field_601 = var5;
      this.registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)class_335.method_2311(var3));
      this.registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)class_335.method_2311(var4));
   }

   @Deprecated
   protected class_283(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3, String... var4) {
      this(var1, var1.getMainLooper(), new class_283.class_1228(var2), new class_283.class_1232(var3), var4);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jl, com.google.android.gms.internal.jl$f) com.google.android.gms.internal.jl$f
   // $FF: synthetic method
   static class_283.class_1231 method_1780(class_283 var0, class_283.class_1231 var1) {
      var0.field_599 = var1;
      return var1;
   }

   // $FF: renamed from: a (int, android.os.IInterface) void
   private void method_1782(int param1, T param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (int, int, android.os.IInterface) boolean
   private boolean method_1784(int param1, int param2, T param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.internal.jl) java.util.ArrayList
   // $FF: synthetic method
   static ArrayList method_1786(class_283 var0) {
      return var0.field_598;
   }

   // $FF: renamed from: c (com.google.android.gms.internal.jl) com.google.android.gms.internal.jl$f
   // $FF: synthetic method
   static class_283.class_1231 method_1787(class_283 var0) {
      return var0.field_599;
   }

   // $FF: renamed from: d (com.google.android.gms.internal.jl) android.content.Context
   // $FF: synthetic method
   static Context method_1788(class_283 var0) {
      return var0.mContext;
   }

   // $FF: renamed from: N (android.os.IBinder) void
   protected final void method_1789(IBinder var1) {
      try {
         this.method_1792(class_19.class_1173.method_3045(var1), new class_283.class_1230(this));
      } catch (DeadObjectException var5) {
         Log.w("GmsClient", "service died");
         this.method_1793(1);
      } catch (RemoteException var6) {
         Log.w("GmsClient", "Remote exception occurred", var6);
      }
   }

   // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
   protected void method_1790(int var1, IBinder var2, Bundle var3) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new class_283.class_1233(var1, var2, var3)));
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jl$b) void
   @Deprecated
   public final void method_1791(com/google/android/gms/internal/jl<T>.b<?> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jt, com.google.android.gms.internal.jl$e) void
   protected abstract void method_1792(class_19 var1, class_283.class_1230 var2) throws RemoteException;

   // $FF: renamed from: aD (int) void
   public void method_1793(int var1) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(var1)));
   }

   // $FF: renamed from: bK () java.lang.String
   protected abstract String method_1794();

   // $FF: renamed from: bL () java.lang.String
   protected abstract String method_1795();

   // $FF: renamed from: c (java.lang.String[]) void
   protected void method_1796(String... var1) {
   }

   public void connect() {
      this.field_602 = true;
      this.method_1782(2, (IInterface)null);
      int var1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
      if(var1 != 0) {
         this.method_1782(1, (IInterface)null);
         this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(var1)));
      } else {
         if(this.field_599 != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + this.method_1794());
            class_341.method_2337(this.mContext).method_2341(this.method_1794(), this.field_599);
         }

         this.field_599 = new class_283.class_1231();
         if(!class_341.method_2337(this.mContext).method_2340(this.method_1794(), this.field_599)) {
            Log.e("GmsClient", "unable to connect to service: " + this.method_1794());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
            return;
         }
      }

   }

   // $FF: renamed from: dS () void
   protected final void method_1797() {
      if(!this.isConnected()) {
         throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
      }
   }

   public void disconnect() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: fX () android.os.Bundle
   public Bundle method_948() {
      return null;
   }

   // $FF: renamed from: gN () boolean
   public boolean method_949() {
      return this.field_602;
   }

   public final Context getContext() {
      return this.mContext;
   }

   public final Looper getLooper() {
      return this.field_595;
   }

   // $FF: renamed from: hv () java.lang.String[]
   public final String[] method_1798() {
      return this.field_601;
   }

   // $FF: renamed from: hw () android.os.IInterface
   public final T method_1799() throws DeadObjectException {
      // $FF: Couldn't be decompiled
   }

   public boolean isConnected() {
      // $FF: Couldn't be decompiled
   }

   public boolean isConnecting() {
      // $FF: Couldn't be decompiled
   }

   @Deprecated
   public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks var1) {
      return this.field_596.isConnectionCallbacksRegistered(new class_283.class_1228(var1));
   }

   @Deprecated
   public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      return this.field_596.isConnectionFailedListenerRegistered(var1);
   }

   // $FF: renamed from: l (android.os.IBinder) android.os.IInterface
   protected abstract T method_1800(IBinder var1);

   @Deprecated
   public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.field_596.registerConnectionCallbacks(new class_283.class_1228(var1));
   }

   public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
      this.field_596.registerConnectionCallbacks(var1);
   }

   @Deprecated
   public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.field_596.registerConnectionFailedListener(var1);
   }

   public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
      this.field_596.registerConnectionFailedListener(var1);
   }

   @Deprecated
   public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.field_596.unregisterConnectionCallbacks(new class_283.class_1228(var1));
   }

   @Deprecated
   public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.field_596.unregisterConnectionFailedListener(var1);
   }

   final class class_1226 extends Handler {
      public class_1226(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         if(var1.what == 1 && !class_283.this.isConnecting()) {
            class_283.class_1227 var5 = (class_283.class_1227)var1.obj;
            var5.method_3744();
            var5.unregister();
         } else if(var1.what == 3) {
            class_283.this.field_596.method_2345(new ConnectionResult(((Integer)var1.obj).intValue(), (PendingIntent)null));
         } else if(var1.what == 4) {
            class_283.this.method_1782(4, (IInterface)null);
            class_283.this.field_596.method_2344(((Integer)var1.obj).intValue());
            class_283.this.method_1784(4, 1, (IInterface)null);
         } else if(var1.what == 2 && !class_283.this.isConnected()) {
            class_283.class_1227 var3 = (class_283.class_1227)var1.obj;
            var3.method_3744();
            var3.unregister();
         } else if(var1.what != 2 && var1.what != 1) {
            Log.wtf("GmsClient", "Don\'t know how to handle this message.");
         } else {
            ((class_283.class_1227)var1.obj).method_3745();
         }
      }
   }

   protected abstract class class_1227<TListener> {
      // $FF: renamed from: MR boolean
      private boolean field_2843;
      private TListener mListener;

      public class_1227(TListener var1) {
         this.mListener = var2;
         this.field_2843 = false;
      }

      // $FF: renamed from: g (java.lang.Object) void
      protected abstract void method_3743(TListener var1);

      // $FF: renamed from: hx () void
      protected abstract void method_3744();

      // $FF: renamed from: hy () void
      public void method_3745() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: hz () void
      public void method_3746() {
         // $FF: Couldn't be decompiled
      }

      public void unregister() {
         // $FF: Couldn't be decompiled
      }
   }

   public static final class class_1228 implements GoogleApiClient.ConnectionCallbacks {
      // $FF: renamed from: MS com.google.android.gms.common.GooglePlayServicesClient$ConnectionCallbacks
      private final GooglePlayServicesClient.ConnectionCallbacks field_4423;

      public class_1228(GooglePlayServicesClient.ConnectionCallbacks var1) {
         this.field_4423 = var1;
      }

      public boolean equals(Object var1) {
         return var1 instanceof class_283.class_1228?this.field_4423.equals(((class_283.class_1228)var1).field_4423):this.field_4423.equals(var1);
      }

      public void onConnected(Bundle var1) {
         this.field_4423.onConnected(var1);
      }

      public void onConnectionSuspended(int var1) {
         this.field_4423.onDisconnected();
      }
   }

   public abstract class class_1229<TListener> extends com/google/android/gms/internal/jl<T>.b<TListener> {
      // $FF: renamed from: JG com.google.android.gms.common.data.DataHolder
      private final DataHolder field_2849;

      public class_1229(TListener var1, DataHolder var2) {
         super();
         this.field_2849 = var3;
      }

      // $FF: renamed from: b (java.lang.Object, com.google.android.gms.common.data.DataHolder) void
      protected abstract void method_3750(TListener var1, DataHolder var2);

      // $FF: renamed from: g (java.lang.Object) void
      protected final void method_3743(TListener var1) {
         this.method_3750(var1, this.field_2849);
      }

      // $FF: renamed from: hx () void
      protected void method_3744() {
         if(this.field_2849 != null) {
            this.field_2849.close();
         }

      }
   }

   public static final class class_1230 extends class_22.class_1377 {
      // $FF: renamed from: MT com.google.android.gms.internal.jl
      private class_283 field_3452;

      public class_1230(class_283 var1) {
         this.field_3452 = var1;
      }

      // $FF: renamed from: b (int, android.os.IBinder, android.os.Bundle) void
      public void method_171(int var1, IBinder var2, Bundle var3) {
         class_335.method_2306("onPostInitComplete can be called only once per call to getServiceFromBroker", this.field_3452);
         this.field_3452.method_1790(var1, var2, var3);
         this.field_3452 = null;
      }
   }

   public final class class_1231 implements ServiceConnection {
      public void onServiceConnected(ComponentName var1, IBinder var2) {
         class_283.this.method_1789(var2);
      }

      public void onServiceDisconnected(ComponentName var1) {
         class_283.this.mHandler.sendMessage(class_283.this.mHandler.obtainMessage(4, Integer.valueOf(1)));
      }
   }

   public static final class class_1232 implements GoogleApiClient.OnConnectionFailedListener {
      // $FF: renamed from: MU com.google.android.gms.common.GooglePlayServicesClient$OnConnectionFailedListener
      private final GooglePlayServicesClient.OnConnectionFailedListener field_4426;

      public class_1232(GooglePlayServicesClient.OnConnectionFailedListener var1) {
         this.field_4426 = var1;
      }

      public boolean equals(Object var1) {
         return var1 instanceof class_283.class_1232?this.field_4426.equals(((class_283.class_1232)var1).field_4426):this.field_4426.equals(var1);
      }

      public void onConnectionFailed(ConnectionResult var1) {
         this.field_4426.onConnectionFailed(var1);
      }
   }

   protected final class class_1233 extends com/google/android/gms/internal/jl<T>.b<Boolean> {
      // $FF: renamed from: MV android.os.Bundle
      public final Bundle field_2845;
      // $FF: renamed from: MW android.os.IBinder
      public final IBinder field_2846;
      public final int statusCode;

      public class_1233(int var2, IBinder var3, Bundle var4) {
         super();
         this.statusCode = var2;
         this.field_2846 = var3;
         this.field_2845 = var4;
      }

      // $FF: renamed from: b (java.lang.Boolean) void
      protected void method_3747(Boolean param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: g (java.lang.Object) void
      // $FF: synthetic method
      protected void method_3743(Object var1) {
         this.method_3747((Boolean)var1);
      }

      // $FF: renamed from: hx () void
      protected void method_3744() {
      }
   }
}
