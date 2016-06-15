package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.class_291;

// $FF: renamed from: com.google.android.gms.location.c
@Deprecated
public class class_651 implements GooglePlayServicesClient {
   private final class_291 agq;

   public void connect() {
      this.agq.connect();
   }

   public void disconnect() {
      this.agq.disconnect();
   }

   public boolean isConnected() {
      return this.agq.isConnected();
   }

   public boolean isConnecting() {
      return this.agq.isConnecting();
   }

   public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks var1) {
      return this.agq.isConnectionCallbacksRegistered(var1);
   }

   public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      return this.agq.isConnectionFailedListenerRegistered(var1);
   }

   public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.agq.registerConnectionCallbacks(var1);
   }

   public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.agq.registerConnectionFailedListener(var1);
   }

   public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.agq.unregisterConnectionCallbacks(var1);
   }

   public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.agq.unregisterConnectionFailedListener(var1);
   }

   public interface class_1259 {
      // $FF: renamed from: a (int, java.lang.String[]) void
      void method_283(int var1, String[] var2);
   }

   public interface class_1261 {
      // $FF: renamed from: a (int, android.app.PendingIntent) void
      void method_284(int var1, PendingIntent var2);

      // $FF: renamed from: b (int, java.lang.String[]) void
      void method_285(int var1, String[] var2);
   }
}
