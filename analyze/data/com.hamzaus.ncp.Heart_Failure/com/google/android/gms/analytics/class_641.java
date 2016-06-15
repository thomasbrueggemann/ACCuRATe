package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.analytics.class_140;
import com.google.android.gms.analytics.class_669;
import com.google.android.gms.internal.class_39;
import com.google.android.gms.internal.fe;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.analytics.c
class class_641 implements class_140 {
   private Context mContext;
   // $FF: renamed from: tu android.content.ServiceConnection
   private ServiceConnection field_3376;
   // $FF: renamed from: tv com.google.android.gms.analytics.c$b
   private class_641.class_1330 field_3377;
   // $FF: renamed from: tw com.google.android.gms.analytics.c$c
   private class_641.class_1331 field_3378;
   // $FF: renamed from: tx com.google.android.gms.internal.ff
   private class_39 field_3379;

   public class_641(Context var1, class_641.class_1330 var2, class_641.class_1331 var3) {
      this.mContext = var1;
      if(var2 == null) {
         throw new IllegalArgumentException("onConnectedListener cannot be null");
      } else {
         this.field_3377 = var2;
         if(var3 == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
         } else {
            this.field_3378 = var3;
         }
      }
   }

   // $FF: renamed from: ch () com.google.android.gms.internal.ff
   private class_39 method_3675() {
      this.method_3679();
      return this.field_3379;
   }

   // $FF: renamed from: cj () void
   private void method_3676() {
      this.method_3677();
   }

   // $FF: renamed from: ck () void
   private void method_3677() {
      this.field_3377.onConnected();
   }

   // $FF: renamed from: a (java.util.Map, long, java.lang.String, java.util.List) void
   public void method_711(Map<String, String> var1, long var2, String var4, List<fe> var5) {
      try {
         this.method_3675().method_199(var1, var2, var4, var5);
      } catch (RemoteException var7) {
         class_669.method_3888("sendHit failed: " + var7);
      }
   }

   // $FF: renamed from: cg () void
   public void method_712() {
      try {
         this.method_3675().method_200();
      } catch (RemoteException var2) {
         class_669.method_3888("clear hits failed: " + var2);
      }
   }

   // $FF: renamed from: ci () void
   protected void method_3679() {
      if(!this.isConnected()) {
         throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
      }
   }

   public void connect() {
      Intent var1 = new Intent("com.google.android.gms.analytics.service.START");
      var1.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
      var1.putExtra("app_package_name", this.mContext.getPackageName());
      if(this.field_3376 != null) {
         class_669.method_3888("Calling connect() while still connected, missing disconnect().");
      } else {
         this.field_3376 = new class_641.class_1329();
         boolean var4 = this.mContext.bindService(var1, this.field_3376, 129);
         class_669.method_3890("connect: bindService returned " + var4 + " for " + var1);
         if(!var4) {
            this.field_3376 = null;
            this.field_3378.method_865(1, (Intent)null);
            return;
         }
      }

   }

   public void disconnect() {
      this.field_3379 = null;
      if(this.field_3376 != null) {
         try {
            this.mContext.unbindService(this.field_3376);
         } catch (IllegalStateException var3) {
            ;
         } catch (IllegalArgumentException var4) {
            ;
         }

         this.field_3376 = null;
         this.field_3377.onDisconnected();
      }

   }

   public boolean isConnected() {
      return this.field_3379 != null;
   }

   final class class_1329 implements ServiceConnection {
      public void onServiceConnected(ComponentName var1, IBinder var2) {
         class_669.method_3890("service connected, binder: " + var2);

         try {
            if("com.google.android.gms.analytics.internal.IAnalyticsService".equals(var2.getInterfaceDescriptor())) {
               class_669.method_3890("bound to service");
               class_641.this.field_3379 = class_39.class_1069.method_4180(var2);
               class_641.this.method_3676();
               return;
            }
         } catch (RemoteException var4) {
            ;
         }

         class_641.this.mContext.unbindService(this);
         class_641.this.field_3376 = null;
         class_641.this.field_3378.method_865(2, (Intent)null);
      }

      public void onServiceDisconnected(ComponentName var1) {
         class_669.method_3890("service disconnected: " + var1);
         class_641.this.field_3376 = null;
         class_641.this.field_3377.onDisconnected();
      }
   }

   public interface class_1330 {
      void onConnected();

      void onDisconnected();
   }

   public interface class_1331 {
      // $FF: renamed from: a (int, android.content.Intent) void
      void method_865(int var1, Intent var2);
   }
}
