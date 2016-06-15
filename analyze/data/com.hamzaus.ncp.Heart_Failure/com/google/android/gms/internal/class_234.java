package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
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
import com.google.android.gms.internal.class_31;
import com.google.android.gms.internal.class_32;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_354;
import com.google.android.gms.internal.class_355;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.hc
public abstract class class_234<T extends IInterface> implements Api.class_1073, class_355.class_1267 {
   // $FF: renamed from: Ge java.lang.String[]
   public static final String[] field_745 = new String[]{"service_esmobile", "service_googleme"};
   // $FF: renamed from: DC android.os.Looper
   private final Looper field_746;
   // $FF: renamed from: DP com.google.android.gms.internal.hd
   private final class_355 field_747;
   // $FF: renamed from: FY android.os.IInterface
   private T field_748;
   // $FF: renamed from: FZ java.util.ArrayList
   private final ArrayList<com/google/android/gms/internal/hc<T>.b<?>> field_749;
   // $FF: renamed from: Ga com.google.android.gms.internal.hc$f
   private com/google/android/gms/internal/hc<T>.f field_750;
   // $FF: renamed from: Gb int
   private volatile int field_751;
   // $FF: renamed from: Gc java.lang.String[]
   private final String[] field_752;
   // $FF: renamed from: Gd boolean
   boolean field_753;
   private final Context mContext;
   final Handler mHandler;

   protected class_234(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String... var5) {
      this.field_749 = new ArrayList();
      this.field_751 = 1;
      this.field_753 = false;
      this.mContext = (Context)class_347.method_2170(var1);
      this.field_746 = (Looper)class_347.method_2166(var2, "Looper must not be null");
      this.field_747 = new class_355(var1, var2, this);
      this.mHandler = new class_234.class_907(var2);
      this.method_1450(var5);
      this.field_752 = var5;
      this.registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)class_347.method_2170(var3));
      this.registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)class_347.method_2170(var4));
   }

   @Deprecated
   protected class_234(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3, String... var4) {
      this(var1, var1.getMainLooper(), new class_234.class_909(var2), new class_234.class_913(var3), var4);
   }

   // $FF: renamed from: am (int) void
   private void method_1440(int var1) {
      int var2 = this.field_751;
      this.field_751 = var1;
      if(var2 != var1) {
         if(var1 == 3) {
            this.onConnected();
         } else if(var2 == 3 && var1 == 1) {
            this.onDisconnected();
            return;
         }
      }

   }

   // $FF: renamed from: b (com.google.android.gms.internal.hc) java.util.ArrayList
   // $FF: synthetic method
   static ArrayList method_1441(class_234 var0) {
      return var0.field_749;
   }

   // $FF: renamed from: I (android.os.IBinder) void
   protected final void method_1445(IBinder var1) {
      try {
         this.method_1448(class_31.class_809.method_1346(var1), new class_234.class_911(this));
      } catch (RemoteException var3) {
         Log.w("GmsClient", "service died");
      }
   }

   // $FF: renamed from: a (int, android.os.IBinder, android.os.Bundle) void
   protected void method_1446(int var1, IBinder var2, Bundle var3) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new class_234.class_914(var1, var2, var3)));
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hc$b) void
   @Deprecated
   public final void method_1447(com/google/android/gms/internal/hc<T>.b<?> param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hj, com.google.android.gms.internal.hc$e) void
   protected abstract void method_1448(class_31 var1, class_234.class_911 var2) throws RemoteException;

   // $FF: renamed from: an (int) void
   public void method_1449(int var1) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(var1)));
   }

   // $FF: renamed from: b (java.lang.String[]) void
   protected void method_1450(String... var1) {
   }

   // $FF: renamed from: bp () java.lang.String
   protected abstract String method_1451();

   // $FF: renamed from: bq () java.lang.String
   protected abstract String method_1452();

   // $FF: renamed from: ci () void
   protected final void method_1453() {
      if(!this.isConnected()) {
         throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
      }
   }

   public void connect() {
      this.field_753 = true;
      this.method_1440(2);
      int var1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
      if(var1 != 0) {
         this.method_1440(1);
         this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(var1)));
      } else {
         if(this.field_750 != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
            this.field_748 = null;
            class_354.method_2240(this.mContext).method_2243(this.method_1451(), this.field_750);
         }

         this.field_750 = new class_234.class_912();
         if(!class_354.method_2240(this.mContext).method_2242(this.method_1451(), this.field_750)) {
            Log.e("GmsClient", "unable to connect to service: " + this.method_1451());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
            return;
         }
      }

   }

   public void disconnect() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: eJ () boolean
   public boolean method_776() {
      return this.field_753;
   }

   // $FF: renamed from: ea () android.os.Bundle
   public Bundle method_777() {
      return null;
   }

   // $FF: renamed from: fn () java.lang.String[]
   public final String[] method_1454() {
      return this.field_752;
   }

   // $FF: renamed from: fo () android.os.IInterface
   public final T method_1455() {
      this.method_1453();
      return this.field_748;
   }

   public final Context getContext() {
      return this.mContext;
   }

   public final Looper getLooper() {
      return this.field_746;
   }

   public boolean isConnected() {
      return this.field_751 == 3;
   }

   public boolean isConnecting() {
      return this.field_751 == 2;
   }

   @Deprecated
   public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks var1) {
      return this.field_747.isConnectionCallbacksRegistered(new class_234.class_909(var1));
   }

   @Deprecated
   public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      return this.field_747.isConnectionFailedListenerRegistered(var1);
   }

   protected void onConnected() {
   }

   protected void onDisconnected() {
   }

   @Deprecated
   public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.field_747.registerConnectionCallbacks(new class_234.class_909(var1));
   }

   public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
      this.field_747.registerConnectionCallbacks(var1);
   }

   @Deprecated
   public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.field_747.registerConnectionFailedListener(var1);
   }

   public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
      this.field_747.registerConnectionFailedListener(var1);
   }

   @Deprecated
   public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.field_747.unregisterConnectionCallbacks(new class_234.class_909(var1));
   }

   @Deprecated
   public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.field_747.unregisterConnectionFailedListener(var1);
   }

   // $FF: renamed from: x (android.os.IBinder) android.os.IInterface
   protected abstract T method_1456(IBinder var1);

   final class class_907 extends Handler {
      public class_907(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         if(var1.what == 1 && !class_234.this.isConnecting()) {
            class_234.class_908 var5 = (class_234.class_908)var1.obj;
            var5.method_2639();
            var5.unregister();
         } else if(var1.what == 3) {
            class_234.this.field_747.method_2246(new ConnectionResult(((Integer)var1.obj).intValue(), (PendingIntent)null));
         } else if(var1.what == 4) {
            class_234.this.method_1440(1);
            class_234.this.field_748 = null;
            class_234.this.field_747.method_2247(((Integer)var1.obj).intValue());
         } else if(var1.what == 2 && !class_234.this.isConnected()) {
            class_234.class_908 var3 = (class_234.class_908)var1.obj;
            var3.method_2639();
            var3.unregister();
         } else if(var1.what != 2 && var1.what != 1) {
            Log.wtf("GmsClient", "Don\'t know how to handle this message.");
         } else {
            ((class_234.class_908)var1.obj).method_2640();
         }
      }
   }

   protected abstract class class_908<TListener> {
      // $FF: renamed from: Gg boolean
      private boolean field_1931;
      private TListener mListener;

      public class_908(TListener var1) {
         this.mListener = var2;
         this.field_1931 = false;
      }

      // $FF: renamed from: d (java.lang.Object) void
      protected abstract void method_2638(TListener var1);

      // $FF: renamed from: fp () void
      protected abstract void method_2639();

      // $FF: renamed from: fq () void
      public void method_2640() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: fr () void
      public void method_2641() {
         // $FF: Couldn't be decompiled
      }

      public void unregister() {
         // $FF: Couldn't be decompiled
      }
   }

   public static final class class_909 implements GoogleApiClient.ConnectionCallbacks {
      // $FF: renamed from: Gh com.google.android.gms.common.GooglePlayServicesClient$ConnectionCallbacks
      private final GooglePlayServicesClient.ConnectionCallbacks field_2674;

      public class_909(GooglePlayServicesClient.ConnectionCallbacks var1) {
         this.field_2674 = var1;
      }

      public boolean equals(Object var1) {
         return var1 instanceof class_234.class_909?this.field_2674.equals(((class_234.class_909)var1).field_2674):this.field_2674.equals(var1);
      }

      public void onConnected(Bundle var1) {
         this.field_2674.onConnected(var1);
      }

      public void onConnectionSuspended(int var1) {
         this.field_2674.onDisconnected();
      }
   }

   public abstract class class_910<TListener> extends com/google/android/gms/internal/hc<T>.b<TListener> {
      // $FF: renamed from: DD com.google.android.gms.common.data.DataHolder
      private final DataHolder field_1971;

      public class_910(TListener var1, DataHolder var2) {
         super();
         this.field_1971 = var3;
      }

      // $FF: renamed from: a (java.lang.Object, com.google.android.gms.common.data.DataHolder) void
      protected abstract void method_2659(TListener var1, DataHolder var2);

      // $FF: renamed from: d (java.lang.Object) void
      protected final void method_2638(TListener var1) {
         this.method_2659(var1, this.field_1971);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
         if(this.field_1971 != null) {
            this.field_1971.close();
         }

      }
   }

   public static final class class_911 extends class_32.class_1064 {
      // $FF: renamed from: Gi com.google.android.gms.internal.hc
      private class_234 field_2684;

      public class_911(class_234 var1) {
         this.field_2684 = var1;
      }

      // $FF: renamed from: b (int, android.os.IBinder, android.os.Bundle) void
      public void method_187(int var1, IBinder var2, Bundle var3) {
         class_347.method_2166("onPostInitComplete can be called only once per call to getServiceFromBroker", this.field_2684);
         this.field_2684.method_1446(var1, var2, var3);
         this.field_2684 = null;
      }
   }

   final class class_912 implements ServiceConnection {
      public void onServiceConnected(ComponentName var1, IBinder var2) {
         class_234.this.method_1445(var2);
      }

      public void onServiceDisconnected(ComponentName var1) {
         class_234.this.mHandler.sendMessage(class_234.this.mHandler.obtainMessage(4, Integer.valueOf(1)));
      }
   }

   public static final class class_913 implements GoogleApiClient.OnConnectionFailedListener {
      // $FF: renamed from: Gj com.google.android.gms.common.GooglePlayServicesClient$OnConnectionFailedListener
      private final GooglePlayServicesClient.OnConnectionFailedListener field_2676;

      public class_913(GooglePlayServicesClient.OnConnectionFailedListener var1) {
         this.field_2676 = var1;
      }

      public boolean equals(Object var1) {
         return var1 instanceof class_234.class_913?this.field_2676.equals(((class_234.class_913)var1).field_2676):this.field_2676.equals(var1);
      }

      public void onConnectionFailed(ConnectionResult var1) {
         this.field_2676.onConnectionFailed(var1);
      }
   }

   protected final class class_914 extends com/google/android/gms/internal/hc<T>.b<Boolean> {
      // $FF: renamed from: Gk android.os.Bundle
      public final Bundle field_1969;
      // $FF: renamed from: Gl android.os.IBinder
      public final IBinder field_1970;
      public final int statusCode;

      public class_914(int var2, IBinder var3, Bundle var4) {
         super();
         this.statusCode = var2;
         this.field_1970 = var3;
         this.field_1969 = var4;
      }

      // $FF: renamed from: b (java.lang.Boolean) void
      protected void method_2658(Boolean var1) {
         if(var1 == null) {
            class_234.this.method_1440(1);
         } else {
            switch(this.statusCode) {
            case 0:
               try {
                  String var5 = this.field_1970.getInterfaceDescriptor();
                  if(class_234.this.method_1452().equals(var5)) {
                     class_234.this.field_748 = class_234.this.method_1456(this.field_1970);
                     if(class_234.this.field_748 != null) {
                        class_234.this.method_1440(3);
                        class_234.this.field_747.method_2249();
                        return;
                     }
                  }
               } catch (RemoteException var8) {
                  ;
               }

               class_354.method_2240(class_234.this.mContext).method_2243(class_234.this.method_1451(), class_234.this.field_750);
               class_234.this.field_750 = null;
               class_234.this.method_1440(1);
               class_234.this.field_748 = null;
               class_234.this.field_747.method_2246(new ConnectionResult(8, (PendingIntent)null));
               return;
            case 10:
               class_234.this.method_1440(1);
               throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
               PendingIntent var7;
               if(this.field_1969 != null) {
                  var7 = (PendingIntent)this.field_1969.getParcelable("pendingIntent");
               } else {
                  var7 = null;
               }

               if(class_234.this.field_750 != null) {
                  class_354.method_2240(class_234.this.mContext).method_2243(class_234.this.method_1451(), class_234.this.field_750);
                  class_234.this.field_750 = null;
               }

               class_234.this.method_1440(1);
               class_234.this.field_748 = null;
               class_234.this.field_747.method_2246(new ConnectionResult(this.statusCode, var7));
            }
         }
      }

      // $FF: renamed from: d (java.lang.Object) void
      // $FF: synthetic method
      protected void method_2638(Object var1) {
         this.method_2658((Boolean)var1);
      }

      // $FF: renamed from: fp () void
      protected void method_2639() {
      }
   }
}
