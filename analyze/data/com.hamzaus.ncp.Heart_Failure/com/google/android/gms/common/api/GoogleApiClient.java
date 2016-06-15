package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.class_586;
import com.google.android.gms.common.api.class_797;
import com.google.android.gms.common.api.class_798;
import com.google.android.gms.internal.class_323;
import com.google.android.gms.internal.class_347;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {
   // $FF: renamed from: a (com.google.android.gms.common.api.Api$c) com.google.android.gms.common.api.Api$a
   <C extends Api.class_1073> C method_771(Api.class_1077<C> var1);

   // $FF: renamed from: a (com.google.android.gms.common.api.a$b) com.google.android.gms.common.api.a$b
   <A extends Api.class_1073, T extends class_797.class_1203<? extends Result, A>> T method_772(T var1);

   // $FF: renamed from: b (com.google.android.gms.common.api.a$b) com.google.android.gms.common.api.a$b
   <A extends Api.class_1073, T extends class_797.class_1203<? extends Result, A>> T method_773(T var1);

   ConnectionResult blockingConnect();

   ConnectionResult blockingConnect(long var1, TimeUnit var3);

   void connect();

   void disconnect();

   Looper getLooper();

   boolean isConnected();

   boolean isConnecting();

   boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks var1);

   boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener var1);

   void reconnect();

   void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1);

   void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1);

   void stopAutoManage();

   void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1);

   void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1);

   public static final class Builder {
      // $FF: renamed from: DC android.os.Looper
      private Looper field_2130;
      // $FF: renamed from: DE java.util.Set
      private final Set<String> field_2131;
      // $FF: renamed from: DF int
      private int field_2132;
      // $FF: renamed from: DG android.view.View
      private View field_2133;
      // $FF: renamed from: DH java.lang.String
      private String field_2134;
      // $FF: renamed from: DI java.util.Map
      private final Map<Api<?>, Api.ApiOptions> field_2135;
      // $FF: renamed from: DJ android.support.v4.app.FragmentActivity
      private FragmentActivity field_2136;
      // $FF: renamed from: DK com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
      private GoogleApiClient.OnConnectionFailedListener field_2137;
      // $FF: renamed from: DL java.util.Set
      private final Set<GoogleApiClient.ConnectionCallbacks> field_2138;
      // $FF: renamed from: DM java.util.Set
      private final Set<GoogleApiClient.OnConnectionFailedListener> field_2139;
      private final Context mContext;
      // $FF: renamed from: yN java.lang.String
      private String field_2140;

      public Builder(Context var1) {
         this.field_2131 = new HashSet();
         this.field_2135 = new HashMap();
         this.field_2138 = new HashSet();
         this.field_2139 = new HashSet();
         this.mContext = var1;
         this.field_2130 = var1.getMainLooper();
         this.field_2134 = var1.getPackageName();
      }

      public Builder(Context var1, GoogleApiClient.ConnectionCallbacks var2, GoogleApiClient.OnConnectionFailedListener var3) {
         this(var1);
         class_347.method_2166(var2, "Must provide a connected listener");
         this.field_2138.add(var2);
         class_347.method_2166(var3, "Must provide a connection failed listener");
         this.field_2139.add(var3);
      }

      // $FF: renamed from: eE () com.google.android.gms.common.api.d
      private class_586 method_2707() {
         FragmentManager var1 = this.field_2136.getSupportFragmentManager();
         if(var1.getFragments() != null) {
            Iterator var4 = var1.getFragments().iterator();

            while(var4.hasNext()) {
               Fragment var5 = (Fragment)var4.next();
               if(var5 instanceof class_586 && var5.isAdded() && !((class_586)var5).isInitialized()) {
                  return (class_586)var5;
               }
            }
         }

         class_586 var2 = new class_586();
         var1.beginTransaction().add(var2, (String)null).commit();
         return var2;
      }

      public GoogleApiClient.Builder addApi(Api<? extends Api.NotRequiredOptions> var1) {
         this.field_2135.put(var1, (Object)null);
         List var3 = var1.method_3126();
         int var4 = var3.size();

         for(int var5 = 0; var5 < var4; ++var5) {
            this.field_2131.add(((Scope)var3.get(var5)).method_1332());
         }

         return this;
      }

      public <O extends Api.HasOptions> GoogleApiClient.Builder addApi(Api<O> var1, O var2) {
         class_347.method_2166(var2, "Null options are not permitted for this Api");
         this.field_2135.put(var1, var2);
         List var5 = var1.method_3126();
         int var6 = var5.size();

         for(int var7 = 0; var7 < var6; ++var7) {
            this.field_2131.add(((Scope)var5.get(var7)).method_1332());
         }

         return this;
      }

      public GoogleApiClient.Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
         this.field_2138.add(var1);
         return this;
      }

      public GoogleApiClient.Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
         this.field_2139.add(var1);
         return this;
      }

      public GoogleApiClient.Builder addScope(Scope var1) {
         this.field_2131.add(var1.method_1332());
         return this;
      }

      public GoogleApiClient build() {
         boolean var1;
         if(!this.field_2135.isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         class_347.method_2168(var1, "must call addApi() to add at least one API");
         FragmentActivity var2 = this.field_2136;
         class_586 var3 = null;
         if(var2 != null) {
            var3 = this.method_2707();
         }

         class_798 var4 = new class_798(this.mContext, this.field_2130, this.method_2708(), this.field_2135, var3, this.field_2138, this.field_2139);
         if(var3 != null) {
            var3.method_3289(var4, this.field_2137);
         }

         return var4;
      }

      // $FF: renamed from: eD () com.google.android.gms.internal.gz
      public class_323 method_2708() {
         return new class_323(this.field_2140, this.field_2131, this.field_2132, this.field_2133, this.field_2134);
      }

      public GoogleApiClient.Builder enableAutoManage(FragmentActivity var1, GoogleApiClient.OnConnectionFailedListener var2) {
         this.field_2136 = (FragmentActivity)class_347.method_2166(var1, "Null activity is not permitted.");
         this.field_2137 = var2;
         return this;
      }

      public GoogleApiClient.Builder setAccountName(String var1) {
         this.field_2140 = var1;
         return this;
      }

      public GoogleApiClient.Builder setGravityForPopups(int var1) {
         this.field_2132 = var1;
         return this;
      }

      public GoogleApiClient.Builder setHandler(Handler var1) {
         class_347.method_2166(var1, "Handler must not be null");
         this.field_2130 = var1.getLooper();
         return this;
      }

      public GoogleApiClient.Builder setViewForPopups(View var1) {
         this.field_2133 = var1;
         return this;
      }

      public GoogleApiClient.Builder useDefaultAccount() {
         return this.setAccountName("<<default account>>");
      }
   }

   public interface ConnectionCallbacks {
      int CAUSE_NETWORK_LOST = 2;
      int CAUSE_SERVICE_DISCONNECTED = 1;

      void onConnected(Bundle var1);

      void onConnectionSuspended(int var1);
   }

   public interface OnConnectionFailedListener extends GooglePlayServicesClient.OnConnectionFailedListener {
      void onConnectionFailed(ConnectionResult var1);
   }
}
