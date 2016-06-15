package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_1032;
import com.google.android.gms.common.api.class_690;
import com.google.android.gms.common.api.d;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_347;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {
   // $FF: renamed from: a (com.google.android.gms.common.api.Api$c) com.google.android.gms.common.api.Api$a
   <C extends Api.class_1390> C method_941(Api.class_1394<C> var1);

   // $FF: renamed from: a (com.google.android.gms.common.api.BaseImplementation$a) com.google.android.gms.common.api.BaseImplementation$a
   <A extends Api.class_1390, R extends Result, T extends BaseImplementation.class_1057<R, A>> T method_942(T var1);

   // $FF: renamed from: a (com.google.android.gms.common.api.Scope) boolean
   boolean method_943(Scope var1);

   // $FF: renamed from: b (com.google.android.gms.common.api.BaseImplementation$a) com.google.android.gms.common.api.BaseImplementation$a
   <A extends Api.class_1390, T extends BaseImplementation.class_1057<? extends Result, A>> T method_944(T var1);

   ConnectionResult blockingConnect();

   ConnectionResult blockingConnect(long var1, TimeUnit var3);

   PendingResult<Status> clearDefaultAccountAndReconnect();

   void connect();

   // $FF: renamed from: d (java.lang.Object) com.google.android.gms.common.api.d
   <L> d<L> method_945(L var1);

   void disconnect();

   Looper getLooper();

   boolean isConnected();

   boolean isConnecting();

   boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks var1);

   boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener var1);

   void reconnect();

   void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1);

   void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1);

   void stopAutoManage(FragmentActivity var1);

   void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1);

   void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1);

   public static final class Builder {
      // $FF: renamed from: DZ java.lang.String
      private String field_1815;
      // $FF: renamed from: JF android.os.Looper
      private Looper field_1816;
      // $FF: renamed from: JH java.util.Set
      private final Set<String> field_1817;
      // $FF: renamed from: JI int
      private int field_1818;
      // $FF: renamed from: JJ android.view.View
      private View field_1819;
      // $FF: renamed from: JK java.lang.String
      private String field_1820;
      // $FF: renamed from: JL java.util.Map
      private final Map<Api<?>, Api.ApiOptions> field_1821;
      // $FF: renamed from: JM android.support.v4.app.FragmentActivity
      private FragmentActivity field_1822;
      // $FF: renamed from: JN int
      private int field_1823;
      // $FF: renamed from: JO com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
      private GoogleApiClient.OnConnectionFailedListener field_1824;
      // $FF: renamed from: JP java.util.Set
      private final Set<GoogleApiClient.ConnectionCallbacks> field_1825;
      // $FF: renamed from: JQ java.util.Set
      private final Set<GoogleApiClient.OnConnectionFailedListener> field_1826;
      private final Context mContext;

      public Builder(Context var1) {
         this.field_1817 = new HashSet();
         this.field_1821 = new HashMap();
         this.field_1823 = -1;
         this.field_1825 = new HashSet();
         this.field_1826 = new HashSet();
         this.mContext = var1;
         this.field_1816 = var1.getMainLooper();
         this.field_1820 = var1.getPackageName();
      }

      public Builder(Context var1, GoogleApiClient.ConnectionCallbacks var2, GoogleApiClient.OnConnectionFailedListener var3) {
         this(var1);
         class_335.method_2306(var2, "Must provide a connected listener");
         this.field_1825.add(var2);
         class_335.method_2306(var3, "Must provide a connection failed listener");
         this.field_1826.add(var3);
      }

      // $FF: renamed from: gI () com.google.android.gms.common.api.GoogleApiClient
      private GoogleApiClient method_3076() {
         class_690 var1 = class_690.method_3924(this.field_1822);
         Object var2 = var1.method_3933(this.field_1823);
         if(var2 == null) {
            var2 = new class_1032(this.mContext.getApplicationContext(), this.field_1816, this.method_3077(), this.field_1821, this.field_1825, this.field_1826, this.field_1823);
         }

         var1.method_3931(this.field_1823, (GoogleApiClient)var2, this.field_1824);
         return (GoogleApiClient)var2;
      }

      public GoogleApiClient.Builder addApi(Api<? extends Api.NotRequiredOptions> var1) {
         this.field_1821.put(var1, (Object)null);
         List var3 = var1.method_3732();
         int var4 = var3.size();

         for(int var5 = 0; var5 < var4; ++var5) {
            this.field_1817.add(((Scope)var3.get(var5)).method_1632());
         }

         return this;
      }

      public <O extends Api.HasOptions> GoogleApiClient.Builder addApi(Api<O> var1, O var2) {
         class_335.method_2306(var2, "Null options are not permitted for this Api");
         this.field_1821.put(var1, var2);
         List var5 = var1.method_3732();
         int var6 = var5.size();

         for(int var7 = 0; var7 < var6; ++var7) {
            this.field_1817.add(((Scope)var5.get(var7)).method_1632());
         }

         return this;
      }

      public GoogleApiClient.Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
         this.field_1825.add(var1);
         return this;
      }

      public GoogleApiClient.Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
         this.field_1826.add(var1);
         return this;
      }

      public GoogleApiClient.Builder addScope(Scope var1) {
         this.field_1817.add(var1.method_1632());
         return this;
      }

      public GoogleApiClient build() {
         boolean var1;
         if(!this.field_1821.isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         class_335.method_2308(var1, "must call addApi() to add at least one API");
         return (GoogleApiClient)(this.field_1823 >= 0?this.method_3076():new class_1032(this.mContext, this.field_1816, this.method_3077(), this.field_1821, this.field_1825, this.field_1826, -1));
      }

      public GoogleApiClient.Builder enableAutoManage(FragmentActivity var1, int var2, GoogleApiClient.OnConnectionFailedListener var3) {
         boolean var4;
         if(var2 >= 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         class_335.method_2308(var4, "clientId must be non-negative");
         this.field_1823 = var2;
         this.field_1822 = (FragmentActivity)class_335.method_2306(var1, "Null activity is not permitted.");
         this.field_1824 = var3;
         return this;
      }

      // $FF: renamed from: gH () com.google.android.gms.internal.jg
      public class_347 method_3077() {
         return new class_347(this.field_1815, this.field_1817, this.field_1818, this.field_1819, this.field_1820);
      }

      public GoogleApiClient.Builder setAccountName(String var1) {
         this.field_1815 = var1;
         return this;
      }

      public GoogleApiClient.Builder setGravityForPopups(int var1) {
         this.field_1818 = var1;
         return this;
      }

      public GoogleApiClient.Builder setHandler(Handler var1) {
         class_335.method_2306(var1, "Handler must not be null");
         this.field_1816 = var1.getLooper();
         return this;
      }

      public GoogleApiClient.Builder setViewForPopups(View var1) {
         this.field_1819 = var1;
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
