package com.goodrx.utils.locations;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.goodrx.utils.locations.LocationUpdateListener;
import com.goodrx.utils.locations.MyLocationInterface;

public class GPSLocationHelper implements LocationListener, MyLocationInterface {
   private final long MIN_UPDATE_DISTANCE = 1L;
   private final long MIN_UPDATE_TIME = 500L;
   private Context context;
   private boolean isActive;
   private LocationUpdateListener listener;
   private LocationManager locationManager;
   private boolean updated;

   public GPSLocationHelper(Context var1) {
      this.context = var1;
      this.locationManager = (LocationManager)var1.getSystemService("location");
   }

   private Location getLastKnownLocation() {
      return this.isNetworkEnabled()?this.locationManager.getLastKnownLocation("network"):(this.isGPSEnabled()?this.locationManager.getLastKnownLocation("gps"):null);
   }

   private boolean isGPSEnabled() {
      return this.locationManager.isProviderEnabled("gps");
   }

   private boolean isNetworkEnabled() {
      return this.locationManager.isProviderEnabled("network");
   }

   public boolean isActive() {
      return this.isActive;
   }

   public void onLocationChanged(Location var1) {
      Handler var2 = new Handler() {
         public void handleMessage(Message var1) {
            super.handleMessage(var1);
            if(var1.what == 1) {
               GPSLocationHelper.this.stopUpdate();
            }

         }
      };
      if(this.listener != null && !this.updated) {
         this.listener.onLocationUpdated(var1);
         this.updated = true;
         var2.sendEmptyMessageDelayed(1, 500L);
      }

   }

   public void onProviderDisabled(String var1) {
   }

   public void onProviderEnabled(String var1) {
   }

   public void onStatusChanged(String var1, int var2, Bundle var3) {
   }

   public void setLocationUpdateListener(LocationUpdateListener var1) {
      this.listener = var1;
   }

   public void showLocationSettingsAlert(final Context var1) {
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
      var2.create().setOnDismissListener(new OnDismissListener() {
         public void onDismiss(DialogInterface var1) {
            GPSLocationHelper.this.isActive = false;
         }
      });
      var2.show();
   }

   public void startUpdate() {
      if(!this.isActive()) {
         this.isActive = true;
         this.updated = false;
         if(!this.isNetworkEnabled() && !this.isGPSEnabled()) {
            this.showLocationSettingsAlert(this.context);
            return;
         }

         Location var1 = this.getLastKnownLocation();
         if(var1 != null && this.listener != null) {
            this.onLocationChanged(var1);
         }

         if(this.isNetworkEnabled()) {
            this.locationManager.requestLocationUpdates("network", 500L, 1.0F, this);
         }

         if(this.isGPSEnabled()) {
            this.locationManager.requestLocationUpdates("gps", 500L, 1.0F, this);
            return;
         }
      }

   }

   public void stopUpdate() {
      this.isActive = false;
      this.locationManager.removeUpdates(this);
   }
}
