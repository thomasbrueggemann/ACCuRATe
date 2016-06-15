package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.class_243;

@Deprecated
public class ActivityRecognitionClient implements GooglePlayServicesClient {
   // $FF: renamed from: UR com.google.android.gms.internal.jh
   private final class_243 field_2781;

   public ActivityRecognitionClient(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3) {
      this.field_2781 = new class_243(var1, var2, var3, "activity_recognition");
   }

   public void connect() {
      this.field_2781.connect();
   }

   public void disconnect() {
      this.field_2781.disconnect();
   }

   public boolean isConnected() {
      return this.field_2781.isConnected();
   }

   public boolean isConnecting() {
      return this.field_2781.isConnecting();
   }

   public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks var1) {
      return this.field_2781.isConnectionCallbacksRegistered(var1);
   }

   public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      return this.field_2781.isConnectionFailedListenerRegistered(var1);
   }

   public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.field_2781.registerConnectionCallbacks(var1);
   }

   public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.field_2781.registerConnectionFailedListener(var1);
   }

   public void removeActivityUpdates(PendingIntent var1) {
      try {
         this.field_2781.removeActivityUpdates(var1);
      } catch (RemoteException var3) {
         throw new IllegalStateException(var3);
      }
   }

   public void requestActivityUpdates(long var1, PendingIntent var3) {
      try {
         this.field_2781.requestActivityUpdates(var1, var3);
      } catch (RemoteException var5) {
         throw new IllegalStateException(var5);
      }
   }

   public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.field_2781.unregisterConnectionCallbacks(var1);
   }

   public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.field_2781.unregisterConnectionFailedListener(var1);
   }
}
