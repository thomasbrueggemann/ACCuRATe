package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.jm
public final class class_342 {
   // $FF: renamed from: MX com.google.android.gms.internal.jm$b
   private final class_342.class_1616 field_908;
   // $FF: renamed from: MY java.util.ArrayList
   private final ArrayList<GoogleApiClient.ConnectionCallbacks> field_909 = new ArrayList();
   // $FF: renamed from: MZ java.util.ArrayList
   final ArrayList<GoogleApiClient.ConnectionCallbacks> field_910 = new ArrayList();
   // $FF: renamed from: Na boolean
   private boolean field_911 = false;
   // $FF: renamed from: Nb java.util.ArrayList
   private final ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> field_912 = new ArrayList();
   private final Handler mHandler;

   public class_342(Context var1, Looper var2, class_342.class_1616 var3) {
      this.field_908 = var3;
      this.mHandler = new class_342.class_1615(var2);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.jm) java.util.ArrayList
   // $FF: synthetic method
   static ArrayList method_2342(class_342 var0) {
      return var0.field_909;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.jm) com.google.android.gms.internal.jm$b
   // $FF: synthetic method
   static class_342.class_1616 method_2343(class_342 var0) {
      return var0.field_908;
   }

   // $FF: renamed from: aE (int) void
   public void method_2344(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: b (com.google.android.gms.common.ConnectionResult) void
   public void method_2345(ConnectionResult param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dU () void
   protected void method_2346() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: f (android.os.Bundle) void
   public void method_2347(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks param1) {
      // $FF: Couldn't be decompiled
   }

   public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks param1) {
      // $FF: Couldn't be decompiled
   }

   public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener param1) {
      // $FF: Couldn't be decompiled
   }

   final class class_1615 extends Handler {
      public class_1615(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message param1) {
         // $FF: Couldn't be decompiled
      }
   }

   public interface class_1616 {
      // $FF: renamed from: fX () android.os.Bundle
      Bundle method_948();

      // $FF: renamed from: gN () boolean
      boolean method_949();

      boolean isConnected();
   }
}
