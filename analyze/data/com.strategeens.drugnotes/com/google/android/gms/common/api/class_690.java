package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.class_335;

// $FF: renamed from: com.google.android.gms.common.api.g
public class class_690 extends Fragment implements OnCancelListener, LoaderManager.LoaderCallbacks<ConnectionResult> {
   // $FF: renamed from: KC boolean
   private boolean field_3054;
   // $FF: renamed from: KD int
   private int field_3055 = -1;
   // $FF: renamed from: KE com.google.android.gms.common.ConnectionResult
   private ConnectionResult field_3056;
   // $FF: renamed from: KF android.os.Handler
   private final Handler field_3057 = new Handler(Looper.getMainLooper());
   // $FF: renamed from: KG android.util.SparseArray
   private final SparseArray<class_690.class_1626> field_3058 = new SparseArray();

   // $FF: renamed from: a (android.support.v4.app.FragmentActivity) com.google.android.gms.common.api.g
   public static class_690 method_3924(FragmentActivity var0) {
      class_335.method_2304("Must be called from main thread of process");
      FragmentManager var1 = var0.getSupportFragmentManager();

      class_690 var3;
      try {
         var3 = (class_690)var1.findFragmentByTag("GmsSupportLifecycleFragment");
      } catch (ClassCastException var4) {
         throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", var4);
      }

      if(var3 == null || var3.isRemoving()) {
         var3 = new class_690();
         var1.beginTransaction().add(var3, "GmsSupportLifecycleFragment").commit();
         var1.executePendingTransactions();
      }

      return var3;
   }

   // $FF: renamed from: a (int, com.google.android.gms.common.ConnectionResult) void
   private void method_3925(int var1, ConnectionResult var2) {
      if(!this.field_3054) {
         this.field_3054 = true;
         this.field_3055 = var1;
         this.field_3056 = var2;
         this.field_3057.post(new class_690.class_1627(var1, var2));
      }

   }

   // $FF: renamed from: aq (int) void
   private void method_3928(int var1) {
      if(var1 == this.field_3055) {
         this.method_3930();
      }

   }

   // $FF: renamed from: b (int, com.google.android.gms.common.ConnectionResult) void
   private void method_3929(int var1, ConnectionResult var2) {
      Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
      class_690.class_1626 var4 = (class_690.class_1626)this.field_3058.get(var1);
      if(var4 != null) {
         this.method_3934(var1);
         GoogleApiClient.OnConnectionFailedListener var5 = var4.field_4167;
         if(var5 != null) {
            var5.onConnectionFailed(var2);
         }
      }

      this.method_3930();
   }

   // $FF: renamed from: gR () void
   private void method_3930() {
      int var1 = 0;
      this.field_3054 = false;
      this.field_3055 = -1;
      this.field_3056 = null;

      for(LoaderManager var2 = this.getLoaderManager(); var1 < this.field_3058.size(); ++var1) {
         int var3 = this.field_3058.keyAt(var1);
         class_690.class_1625 var4 = this.method_3935(var3);
         if(var4 != null) {
            var4.method_3736();
         }

         var2.initLoader(var3, (Bundle)null, this);
      }

   }

   // $FF: renamed from: a (int, com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) void
   public void method_3931(int var1, GoogleApiClient var2, GoogleApiClient.OnConnectionFailedListener var3) {
      class_335.method_2306(var2, "GoogleApiClient instance cannot be null");
      boolean var5;
      if(this.field_3058.indexOfKey(var1) < 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      class_335.method_2302(var5, "Already managing a GoogleApiClient with id " + var1);
      class_690.class_1626 var6 = new class_690.class_1626(var2, var3);
      this.field_3058.put(var1, var6);
      if(this.getActivity() != null) {
         this.getLoaderManager().initLoader(var1, (Bundle)null, this);
      }

   }

   // $FF: renamed from: a (android.support.v4.content.Loader, com.google.android.gms.common.ConnectionResult) void
   public void method_3932(Loader<ConnectionResult> var1, ConnectionResult var2) {
      if(var2.isSuccess()) {
         this.method_3928(var1.getId());
      } else {
         this.method_3925(var1.getId(), var2);
      }
   }

   // $FF: renamed from: an (int) com.google.android.gms.common.api.GoogleApiClient
   public GoogleApiClient method_3933(int var1) {
      if(this.getActivity() != null) {
         class_690.class_1625 var2 = this.method_3935(var1);
         if(var2 != null) {
            return var2.field_2835;
         }
      }

      return null;
   }

   // $FF: renamed from: ao (int) void
   public void method_3934(int var1) {
      this.getLoaderManager().destroyLoader(var1);
      this.field_3058.remove(var1);
   }

   // $FF: renamed from: ap (int) com.google.android.gms.common.api.g$a
   class_690.class_1625 method_3935(int var1) {
      try {
         class_690.class_1625 var3 = (class_690.class_1625)this.getLoaderManager().getLoader(var1);
         return var3;
      } catch (ClassCastException var4) {
         throw new IllegalStateException("Unknown loader in SupportLifecycleFragment", var4);
      }
   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      boolean var4;
      label21: {
         var4 = true;
         switch(var1) {
         case 1:
            if(var2 == -1) {
               break label21;
            }
            break;
         case 2:
            if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.getActivity()) == 0) {
               break label21;
            }
         }

         var4 = false;
      }

      if(var4) {
         this.method_3930();
      } else {
         this.method_3929(this.field_3055, this.field_3056);
      }
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);

      for(int var2 = 0; var2 < this.field_3058.size(); ++var2) {
         int var3 = this.field_3058.keyAt(var2);
         class_690.class_1625 var4 = this.method_3935(var3);
         if(var4 != null && ((class_690.class_1626)this.field_3058.valueAt(var2)).field_4166 != var4.field_2835) {
            this.getLoaderManager().restartLoader(var3, (Bundle)null, this);
         } else {
            this.getLoaderManager().initLoader(var3, (Bundle)null, this);
         }
      }

   }

   public void onCancel(DialogInterface var1) {
      this.method_3929(this.field_3055, this.field_3056);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(var1 != null) {
         this.field_3054 = var1.getBoolean("resolving_error", false);
         this.field_3055 = var1.getInt("failed_client_id", -1);
         if(this.field_3055 >= 0) {
            this.field_3056 = new ConnectionResult(var1.getInt("failed_status"), (PendingIntent)var1.getParcelable("failed_resolution"));
         }
      }

   }

   public Loader<ConnectionResult> onCreateLoader(int var1, Bundle var2) {
      return new class_690.class_1625(this.getActivity(), ((class_690.class_1626)this.field_3058.get(var1)).field_4166);
   }

   // $FF: synthetic method
   public void onLoadFinished(Loader var1, Object var2) {
      this.method_3932(var1, (ConnectionResult)var2);
   }

   public void onLoaderReset(Loader<ConnectionResult> var1) {
      if(var1.getId() == this.field_3055) {
         this.method_3930();
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putBoolean("resolving_error", this.field_3054);
      if(this.field_3055 >= 0) {
         var1.putInt("failed_client_id", this.field_3055);
         var1.putInt("failed_status", this.field_3056.getErrorCode());
         var1.putParcelable("failed_resolution", this.field_3056.getResolution());
      }

   }

   public void onStart() {
      super.onStart();
      if(!this.field_3054) {
         for(int var1 = 0; var1 < this.field_3058.size(); ++var1) {
            this.getLoaderManager().initLoader(this.field_3058.keyAt(var1), (Bundle)null, this);
         }
      }

   }

   static class class_1625 extends Loader<ConnectionResult> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
      // $FF: renamed from: KH com.google.android.gms.common.api.GoogleApiClient
      public final GoogleApiClient field_2835;
      // $FF: renamed from: KI boolean
      private boolean field_2836;
      // $FF: renamed from: KJ com.google.android.gms.common.ConnectionResult
      private ConnectionResult field_2837;

      public class_1625(Context var1, GoogleApiClient var2) {
         super(var1);
         this.field_2835 = var2;
      }

      // $FF: renamed from: a (com.google.android.gms.common.ConnectionResult) void
      private void method_3735(ConnectionResult var1) {
         this.field_2837 = var1;
         if(this.isStarted() && !this.isAbandoned()) {
            this.deliverResult(var1);
         }

      }

      // $FF: renamed from: gS () void
      public void method_3736() {
         if(this.field_2836) {
            this.field_2836 = false;
            if(this.isStarted() && !this.isAbandoned()) {
               this.field_2835.connect();
            }
         }

      }

      public void onConnected(Bundle var1) {
         this.field_2836 = false;
         this.method_3735(ConnectionResult.field_3608);
      }

      public void onConnectionFailed(ConnectionResult var1) {
         this.field_2836 = true;
         this.method_3735(var1);
      }

      public void onConnectionSuspended(int var1) {
      }

      protected void onReset() {
         this.field_2837 = null;
         this.field_2836 = false;
         this.field_2835.unregisterConnectionCallbacks(this);
         this.field_2835.unregisterConnectionFailedListener(this);
         this.field_2835.disconnect();
      }

      protected void onStartLoading() {
         super.onStartLoading();
         this.field_2835.registerConnectionCallbacks(this);
         this.field_2835.registerConnectionFailedListener(this);
         if(this.field_2837 != null) {
            this.deliverResult(this.field_2837);
         }

         if(!this.field_2835.isConnected() && !this.field_2835.isConnecting() && !this.field_2836) {
            this.field_2835.connect();
         }

      }

      protected void onStopLoading() {
         this.field_2835.disconnect();
      }
   }

   private static class class_1626 {
      // $FF: renamed from: KH com.google.android.gms.common.api.GoogleApiClient
      public final GoogleApiClient field_4166;
      // $FF: renamed from: KK com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
      public final GoogleApiClient.OnConnectionFailedListener field_4167;

      private class_1626(GoogleApiClient var1, GoogleApiClient.OnConnectionFailedListener var2) {
         this.field_4166 = var1;
         this.field_4167 = var2;
      }

      // $FF: synthetic method
      class_1626(GoogleApiClient var1, GoogleApiClient.OnConnectionFailedListener var2, Object var3) {
         this(var1, var2);
      }
   }

   private class class_1627 implements Runnable {
      // $FF: renamed from: KL int
      private final int field_4168;
      // $FF: renamed from: KM com.google.android.gms.common.ConnectionResult
      private final ConnectionResult field_4169;

      public class_1627(int var2, ConnectionResult var3) {
         this.field_4168 = var2;
         this.field_4169 = var3;
      }

      public void run() {
         if(this.field_4169.hasResolution()) {
            try {
               int var3 = 1 + (1 + class_690.this.getActivity().getSupportFragmentManager().getFragments().indexOf(class_690.this) << 16);
               this.field_4169.startResolutionForResult(class_690.this.getActivity(), var3);
            } catch (SendIntentException var4) {
               class_690.this.method_3930();
            }
         } else if(GooglePlayServicesUtil.isUserRecoverableError(this.field_4169.getErrorCode())) {
            GooglePlayServicesUtil.showErrorDialogFragment(this.field_4169.getErrorCode(), class_690.this.getActivity(), class_690.this, 2, class_690.this);
         } else {
            class_690.this.method_3929(this.field_4168, this.field_4169);
         }
      }
   }
}
