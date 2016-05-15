package com.goodrx.utils.locations;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.IntentSender.SendIntentException;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.goodrx.utils.locations.LocationUpdateListener;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.utils.locations.MyLocationInterface;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class GoogleServiceLocationHelper implements MyLocationInterface, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
   private static final String DIALOG_ERROR = "dialog_error";
   public static final int FAST_CEILING_IN_SECONDS = 1;
   public static final long FAST_INTERVAL_CEILING_IN_MILLISECONDS = 1000L;
   public static final int MILLISECONDS_PER_SECOND = 1000;
   private static final int REQUEST_RESOLVE_ERROR = 1001;
   public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 5000L;
   public static final int UPDATE_INTERVAL_IN_SECONDS = 5;
   private Context context;
   private boolean isErrorDialogShowing;
   private Location lastKnownLocation;
   private LocationManager locationManager;
   private LocationUpdateListener locationUpdateListener;
   private GoogleApiClient mGoogleApiClient;
   private LocationRequest mLocationRequest;

   public GoogleServiceLocationHelper(Context var1) {
      this.context = var1;
      this.mLocationRequest = new LocationRequest();
      this.mLocationRequest.setInterval(5000L);
      this.mLocationRequest.setPriority(102);
      this.mLocationRequest.setFastestInterval(1000L);
      this.mLocationRequest.setNumUpdates(1);
      this.mGoogleApiClient = (new GoogleApiClient.Builder(var1)).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
      this.locationManager = (LocationManager)var1.getSystemService("location");
      this.isErrorDialogShowing = false;
   }

   private void fetchLocation() {
      this.lastKnownLocation = this.getLastKnownLocation();
      if(this.lastKnownLocation != null && this.locationUpdateListener != null) {
         this.locationUpdateListener.onLocationUpdated(this.lastKnownLocation);
      }

      if((new DateTime(DateTimeZone.getDefault())).getMillis() - LocationUtils.getLastUpdateTime(this.context) > 3600000L) {
         LocationServices.FusedLocationApi.requestLocationUpdates(this.mGoogleApiClient, this.mLocationRequest, this);
      }

   }

   private boolean isGPSEnabled() {
      return this.locationManager.isProviderEnabled("gps");
   }

   private boolean isLocationEnabled() {
      return this.isNetworkEnabled() || this.isGPSEnabled();
   }

   private boolean isNetworkEnabled() {
      return this.locationManager.isProviderEnabled("network");
   }

   public static void onDialogDismissed() {
   }

   private void showErrorDialog(int var1) {
      GoogleServiceLocationHelper.ErrorDialogFragment var2 = new GoogleServiceLocationHelper.ErrorDialogFragment();
      Bundle var3 = new Bundle();
      var3.putInt("dialog_error", var1);
      var2.setCancelable(false);
      var2.setArguments(var3);
      var2.show(((BaseActivityWithPasscode)this.context).getSupportFragmentManager(), "errordialog");
   }

   public Location getLastKnownLocation() {
      return LocationServices.FusedLocationApi.getLastLocation(this.mGoogleApiClient);
   }

   public void onConnected(Bundle var1) {
      this.fetchLocation();
   }

   public void onConnectionFailed(ConnectionResult var1) {
      if(var1.hasResolution()) {
         try {
            var1.startResolutionForResult((Activity)this.context, 1001);
         } catch (SendIntentException var4) {
            this.mGoogleApiClient.connect();
         }
      } else {
         try {
            this.showErrorDialog(var1.getErrorCode());
         } catch (Exception var5) {
            ;
         }
      }
   }

   public void onConnectionSuspended(int var1) {
   }

   public void onLocationChanged(Location var1) {
      LocationUtils.setLastUpdateTime(this.context);
      if((this.lastKnownLocation == null || this.lastKnownLocation.distanceTo(var1) >= 800.0F) && this.locationUpdateListener != null) {
         this.locationUpdateListener.onLocationUpdated(var1);
      }
   }

   public void setLocationUpdateListener(LocationUpdateListener var1) {
      this.locationUpdateListener = var1;
   }

   public void showLocationSettingsAlert(final Context var1) {
      if(!this.isErrorDialogShowing) {
         this.isErrorDialogShowing = true;
         Builder var2 = new Builder(var1);
         var2.setTitle(2131427651);
         var2.setMessage(2131427650);
         var2.setPositiveButton(2131427894, new OnClickListener() {
            public void onClick(DialogInterface var1x, int var2) {
               Intent var3 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
               var1.startActivity(var3);
            }
         });
         var2.setNegativeButton(2131427459, (OnClickListener)null);
         AlertDialog var7 = var2.create();
         var7.setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface var1) {
               GoogleServiceLocationHelper.this.isErrorDialogShowing = false;
            }
         });
         var7.show();
      }
   }

   public void startUpdate() {
      if(!this.isLocationEnabled()) {
         this.showLocationSettingsAlert(this.context);
      } else if(!this.mGoogleApiClient.isConnected()) {
         this.mGoogleApiClient.connect();
      } else {
         this.fetchLocation();
      }
   }

   public void stopUpdate() {
      if(this.mGoogleApiClient.isConnected()) {
         LocationServices.FusedLocationApi.removeLocationUpdates(this.mGoogleApiClient, this);
      }

      this.mGoogleApiClient.disconnect();
   }

   @Instrumented
   public static class ErrorDialogFragment extends DialogFragment implements TraceFieldInterface {
      public Dialog onCreateDialog(Bundle var1) {
         return GooglePlayServicesUtil.getErrorDialog(this.getArguments().getInt("dialog_error"), this.getActivity(), 1001);
      }

      public void onDismiss(DialogInterface var1) {
         GoogleServiceLocationHelper.onDialogDismissed();
      }

      protected void onStart() {
         super.onStart();
         ApplicationStateMonitor.getInstance().activityStarted();
      }

      protected void onStop() {
         super.onStop();
         ApplicationStateMonitor.getInstance().activityStopped();
      }
   }
}
