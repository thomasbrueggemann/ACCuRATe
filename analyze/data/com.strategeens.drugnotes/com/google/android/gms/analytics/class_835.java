package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.class_175;
import com.google.android.gms.analytics.class_863;
import com.google.android.gms.internal.class_28;
import com.google.android.gms.internal.ha;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.analytics.c
class class_835 implements class_175 {
   private Context mContext;
   // $FF: renamed from: xV android.content.ServiceConnection
   private ServiceConnection field_3462;
   // $FF: renamed from: xW com.google.android.gms.analytics.c$b
   private class_835.class_1312 field_3463;
   // $FF: renamed from: xX com.google.android.gms.analytics.c$c
   private class_835.class_1313 field_3464;
   // $FF: renamed from: xY com.google.android.gms.internal.hb
   private class_28 field_3465;

   public class_835(Context var1, class_835.class_1312 var2, class_835.class_1313 var3) {
      this.mContext = var1;
      if(var2 == null) {
         throw new IllegalArgumentException("onConnectedListener cannot be null");
      } else {
         this.field_3463 = var2;
         if(var3 == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
         } else {
            this.field_3464 = var3;
         }
      }
   }

   // $FF: renamed from: dR () com.google.android.gms.internal.hb
   private class_28 method_4631() {
      this.method_4634();
      return this.field_3465;
   }

   // $FF: renamed from: dT () void
   private void method_4632() {
      this.method_4633();
   }

   // $FF: renamed from: dU () void
   private void method_4633() {
      this.field_3463.onConnected();
   }

   // $FF: renamed from: a (java.util.Map, long, java.lang.String, java.util.List) void
   public void method_866(Map<String, String> var1, long var2, String var4, List<ha> var5) {
      try {
         this.method_4631().method_186(var1, var2, var4, var5);
      } catch (RemoteException var7) {
         class_863.method_4839("sendHit failed: " + var7);
      }
   }

   public void connect() {
      Intent var1 = new Intent("com.google.android.gms.analytics.service.START");
      var1.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
      var1.putExtra("app_package_name", this.mContext.getPackageName());
      if(this.field_3462 != null) {
         class_863.method_4839("Calling connect() while still connected, missing disconnect().");
      } else {
         this.field_3462 = new class_835.class_1311();
         boolean var4 = this.mContext.bindService(var1, this.field_3462, 129);
         class_863.method_4841("connect: bindService returned " + var4 + " for " + var1);
         if(!var4) {
            this.field_3462 = null;
            this.field_3464.method_1062(1, (Intent)null);
            return;
         }
      }

   }

   // $FF: renamed from: dQ () void
   public void method_867() {
      try {
         this.method_4631().method_187();
      } catch (RemoteException var2) {
         class_863.method_4839("clear hits failed: " + var2);
      }
   }

   // $FF: renamed from: dS () void
   protected void method_4634() {
      if(!this.isConnected()) {
         throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
      }
   }

   public void disconnect() {
      this.field_3465 = null;
      if(this.field_3462 != null) {
         try {
            this.mContext.unbindService(this.field_3462);
         } catch (IllegalStateException var3) {
            ;
         } catch (IllegalArgumentException var4) {
            ;
         }

         this.field_3462 = null;
         this.field_3463.onDisconnected();
      }

   }

   public boolean isConnected() {
      return this.field_3465 != null;
   }

   final class class_1311 implements ServiceConnection {
      public void onServiceConnected(ComponentName var1, IBinder var2) {
         class_863.method_4841("service connected, binder: " + var2);

         try {
            if("com.google.android.gms.analytics.internal.IAnalyticsService".equals(var2.getInterfaceDescriptor())) {
               class_863.method_4841("bound to service");
               class_835.this.field_3465 = class_28.class_1073.method_1642(var2);
               class_835.this.method_4632();
               return;
            }
         } catch (RemoteException var6) {
            ;
         }

         try {
            class_835.this.mContext.unbindService(this);
         } catch (IllegalArgumentException var5) {
            ;
         }

         class_835.this.field_3462 = null;
         class_835.this.field_3464.method_1062(2, (Intent)null);
      }

      public void onServiceDisconnected(ComponentName var1) {
         class_863.method_4841("service disconnected: " + var1);
         class_835.this.field_3462 = null;
         class_835.this.field_3463.onDisconnected();
      }
   }

   public interface class_1312 {
      void onConnected();

      void onDisconnected();
   }

   public interface class_1313 {
      // $FF: renamed from: a (int, android.content.Intent) void
      void method_1062(int var1, Intent var2);
   }
}
