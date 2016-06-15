package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;

// $FF: renamed from: com.google.android.gms.common.api.d
public class class_586 extends Fragment implements OnCancelListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
   // $FF: renamed from: DK com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener
   private GoogleApiClient.OnConnectionFailedListener field_3105;
   // $FF: renamed from: Eq com.google.android.gms.common.api.GoogleApiClient
   private GoogleApiClient field_3106;
   // $FF: renamed from: Er com.google.android.gms.common.ConnectionResult
   private ConnectionResult field_3107;
   // $FF: renamed from: Es boolean
   private boolean field_3108;

   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener) void
   public void method_3289(GoogleApiClient var1, GoogleApiClient.OnConnectionFailedListener var2) {
      this.field_3106 = var1;
      this.field_3106.registerConnectionCallbacks(this);
      this.field_3105 = var2;
      this.field_3106.registerConnectionCallbacks(this);
      this.field_3106.registerConnectionFailedListener(this);
   }

   public boolean isInitialized() {
      return this.field_3106 != null;
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
         this.field_3106.connect();
         this.field_3108 = false;
      } else {
         this.field_3105.onConnectionFailed(this.field_3107);
      }
   }

   public void onCancel(DialogInterface var1) {
      this.field_3108 = false;
      this.field_3105.onConnectionFailed(this.field_3107);
   }

   public void onConnected(Bundle var1) {
      this.field_3108 = false;
   }

   public void onConnectionFailed(ConnectionResult var1) {
      this.field_3107 = var1;
      if(!this.field_3108) {
         int var2 = this.getActivity().getSupportFragmentManager().getFragments().indexOf(this);
         if(var1.hasResolution()) {
            int var4 = 1 + (var2 + 1 << 16);

            try {
               var1.startResolutionForResult(this.getActivity(), var4);
            } catch (SendIntentException var6) {
               this.field_3106.connect();
            }
         } else if(GooglePlayServicesUtil.isUserRecoverableError(var1.getErrorCode())) {
            GooglePlayServicesUtil.method_3836(var1.getErrorCode(), this.getActivity(), this, 2, this);
         } else {
            this.field_3105.onConnectionFailed(this.field_3107);
         }
      }
   }

   public void onConnectionSuspended(int var1) {
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(var1 != null) {
         this.field_3108 = var1.getBoolean("resolving_error", false);
         int var2 = var1.getInt("connection_result_status");
         if(var2 != 0) {
            this.field_3107 = new ConnectionResult(var2, (PendingIntent)var1.getParcelable("resolution_pending_intent"));
         }
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putBoolean("resolving_error", this.field_3108);
      if(this.field_3107 != null) {
         var1.putInt("connection_result_status", this.field_3107.getErrorCode());
         var1.putParcelable("resolution_pending_intent", this.field_3107.getResolution());
      }

   }

   public void onStart() {
      super.onStart();
      if(!this.field_3108 && this.field_3106 != null) {
         this.field_3106.connect();
      }

   }

   public void onStop() {
      super.onStop();
      if(this.field_3106 != null) {
         this.field_3106.disconnect();
      }

   }
}
