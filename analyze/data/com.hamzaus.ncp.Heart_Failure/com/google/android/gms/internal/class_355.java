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

// $FF: renamed from: com.google.android.gms.internal.hd
public final class class_355 {
   // $FF: renamed from: Gm com.google.android.gms.internal.hd$b
   private final class_355.class_1267 field_1533;
   // $FF: renamed from: Gn java.util.ArrayList
   private final ArrayList<GoogleApiClient.ConnectionCallbacks> field_1534 = new ArrayList();
   // $FF: renamed from: Go java.util.ArrayList
   final ArrayList<GoogleApiClient.ConnectionCallbacks> field_1535 = new ArrayList();
   // $FF: renamed from: Gp boolean
   private boolean field_1536 = false;
   // $FF: renamed from: Gq java.util.ArrayList
   private final ArrayList<GooglePlayServicesClient.OnConnectionFailedListener> field_1537 = new ArrayList();
   private final Handler mHandler;

   public class_355(Context var1, Looper var2, class_355.class_1267 var3) {
      this.field_1533 = var3;
      this.mHandler = new class_355.class_1266(var2);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hd) java.util.ArrayList
   // $FF: synthetic method
   static ArrayList method_2244(class_355 var0) {
      return var0.field_1534;
   }

   // $FF: renamed from: b (com.google.android.gms.internal.hd) com.google.android.gms.internal.hd$b
   // $FF: synthetic method
   static class_355.class_1267 method_2245(class_355 var0) {
      return var0.field_1533;
   }

   // $FF: renamed from: a (com.google.android.gms.common.ConnectionResult) void
   public void method_2246(ConnectionResult param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ao (int) void
   public void method_2247(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: c (android.os.Bundle) void
   public void method_2248(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ck () void
   protected void method_2249() {
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

   final class class_1266 extends Handler {
      public class_1266(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message param1) {
         // $FF: Couldn't be decompiled
      }
   }

   public interface class_1267 {
      // $FF: renamed from: eJ () boolean
      boolean method_776();

      // $FF: renamed from: ea () android.os.Bundle
      Bundle method_777();

      boolean isConnected();
   }
}
