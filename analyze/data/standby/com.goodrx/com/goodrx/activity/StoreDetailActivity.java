package com.goodrx.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import com.goodrx.activity.InternetErrorActivity;
import com.goodrx.model.DataQ;
import com.goodrx.model.LocationEntity;
import com.goodrx.model.PharmacyLocationObject;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.Utils;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import org.parceler.Parcels;

public class StoreDetailActivity extends BaseActivityWithPasscode {
   private String info;
   private PharmacyLocationObject pharmacyLocationObject;

   public static void launch(Activity var0, PharmacyLocationObject var1, String var2) {
      Intent var3 = new Intent(var0, StoreDetailActivity.class);
      var3.putExtra("info", var2);
      var3.putExtra("pharmacy_location_object", Parcels.wrap(var1));
      var0.startActivityForResult(var3, 19);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   private void updateOpenStatus() {
      TextView var1 = (TextView)this.findViewById(2131886388);
      if(this.pharmacyLocationObject.isOpen()) {
         var1.setText(this.getString(2131427714));
         var1.setTextColor(ContextCompat.getColor(this, 2131755085));
      } else {
         var1.setText(2131427487);
         var1.setTextColor(ContextCompat.getColor(this, 2131755129));
      }
   }

   public void initActionBar(String var1) {
      this.setSupportActionBar((Toolbar)this.findViewById(2131886238));
      ActionBar var2 = this.getSupportActionBar();
      var2.setDisplayHomeAsUpEnabled(true);
      var2.setHomeAsUpIndicator(2130837662);
      var2.setTitle(var1);
   }

   public void initComponents() {
      this.initActionBar(this.pharmacyLocationObject.getName());
      if(this.pharmacyLocationObject.getLatitude() != null && this.pharmacyLocationObject.getLongitude() != null) {
         LatLng var12 = new LatLng(this.pharmacyLocationObject.getLatitude().doubleValue(), this.pharmacyLocationObject.getLongitude().doubleValue());
         this.initMapView(var12);
      }

      TextView var1 = (TextView)this.findViewById(2131886372);
      TextView var2 = (TextView)this.findViewById(2131886373);
      TextView var3 = (TextView)this.findViewById(2131886375);
      var1.setText(this.pharmacyLocationObject.getAddress());
      var2.setText(this.pharmacyLocationObject.getCity() + ", " + this.pharmacyLocationObject.getState() + " " + this.pharmacyLocationObject.getZipcode());
      var3.setText(this.pharmacyLocationObject.getPhone());
      if(this.pharmacyLocationObject.getFax() != null && this.pharmacyLocationObject.getFax().length() != 0) {
         ((TextView)this.findViewById(2131886378)).setText(this.pharmacyLocationObject.getFax());
      } else {
         this.findViewById(2131886377).setVisibility(8);
      }

      DataQ var4 = this.pharmacyLocationObject.getData_q();
      if((this.info == null || this.info.length() == 0 || this.info.equals("null")) && !var4.hasFeatures()) {
         this.findViewById(2131886389).setVisibility(8);
      } else {
         if(var4.hasCompoundingService()) {
            this.findViewById(2131886390).setVisibility(0);
         }

         if(var4.hasDeliveryService()) {
            this.findViewById(2131886391).setVisibility(0);
         }

         if(var4.hasDriveUpWindow()) {
            this.findViewById(2131886392).setVisibility(0);
         }

         if(var4.isOpen24()) {
            this.findViewById(2131886393).setVisibility(0);
         }

         if(var4.isWalk_in_clinic()) {
            this.findViewById(2131886394).setVisibility(0);
         }

         if(this.info != null && this.info.length() > 0) {
            ((TextView)this.findViewById(2131886395)).setText(this.info);
         }
      }

      if(this.pharmacyLocationObject.getData_q() != null) {
         String[][] var5 = this.pharmacyLocationObject.getData_q().getHours();
         if(var5 == null || var5.length == 0) {
            this.findViewById(2131886379).setVisibility(8);
            return;
         }

         if(var5[0].length > 0) {
            TextView var10 = (TextView)this.findViewById(2131886382);
            TextView var11 = (TextView)this.findViewById(2131886385);
            var10.setText(var5[0][0]);
            var10.setVisibility(0);
            var11.setText(var5[1][0]);
            var11.setVisibility(0);
         }

         if(var5[0].length > 1) {
            TextView var8 = (TextView)this.findViewById(2131886383);
            TextView var9 = (TextView)this.findViewById(2131886386);
            var8.setText(var5[0][1]);
            var8.setVisibility(0);
            var9.setText(var5[1][1]);
            var9.setVisibility(0);
         }

         if(var5[0].length > 2) {
            TextView var6 = (TextView)this.findViewById(2131886384);
            TextView var7 = (TextView)this.findViewById(2131886387);
            var6.setText(var5[0][2]);
            var6.setVisibility(0);
            var7.setText(var5[1][2]);
            var7.setVisibility(0);
            return;
         }
      }

   }

   public void initMapView(LatLng var1) {
      if(Utils.isOnline(this)) {
         View var2 = this.findViewById(2131886370);
         DisplayMetrics var3 = new DisplayMetrics();
         ((WindowManager)this.getSystemService("window")).getDefaultDisplay().getMetrics(var3);
         MapFragment var4 = (MapFragment)this.getFragmentManager().findFragmentById(2131886371);
         var2.setLayoutParams(new LayoutParams(var3.widthPixels, (int)((double)var3.heightPixels / 2.5D)));
         CameraPosition var5 = (new CameraPosition.Builder()).target(var1).zoom(15.0F).build();
         GoogleMap var6 = var4.getMap();
         var6.addMarker((new MarkerOptions()).position(var1));
         var6.getUiSettings().setAllGesturesEnabled(false);
         var6.moveCamera(CameraUpdateFactory.newCameraPosition(var5));
      } else {
         InternetErrorActivity.launch(this);
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427870);
      this.setContentView(2130968645);
      this.info = this.getIntent().getStringExtra("info");
      this.pharmacyLocationObject = (PharmacyLocationObject)Parcels.unwrap(this.getIntent().getParcelableExtra("pharmacy_location_object"));
      this.initComponents();
   }

   public void onDirectionsClicked(View var1) {
      AlertDialog.Builder var2 = new AlertDialog.Builder(this);
      var2.setTitle(2131427600);
      String var4 = this.getResources().getString(2131427536);
      Object[] var5 = new Object[]{this.pharmacyLocationObject.getName()};
      var2.setMessage(String.format(var4, var5));
      var2.setPositiveButton(2131428036, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            var1.dismiss();
            LocationUtils.LocationOption var3 = LocationUtils.getLocationOption(StoreDetailActivity.this);
            LocationEntity var4 = LocationUtils.getLocationEntity(StoreDetailActivity.this);
            Uri var5;
            if(var3 == LocationUtils.LocationOption.CUSTOM && var4 != null) {
               var5 = Uri.parse("http://maps.google.com/maps?saddr=" + var4.getLatitude() + "," + var4.getLongitude() + "&daddr=" + StoreDetailActivity.this.pharmacyLocationObject.getFullAddress());
            } else {
               var5 = Uri.parse("http://maps.google.com/maps?f=d&daddr=" + StoreDetailActivity.this.pharmacyLocationObject.getFullAddress() + "&q=" + StoreDetailActivity.this.pharmacyLocationObject.getName());
            }

            Intent var6 = new Intent("android.intent.action.VIEW", var5);
            StoreDetailActivity.this.startActivity(var6);
         }
      });
      var2.setNegativeButton(2131427682, (OnClickListener)null);
      DialogHelper.showDialog(var2);
   }

   public void onPhoneClicked(View var1) {
      String var2 = this.getResources().getString(2131427452);
      String var3 = this.getResources().getString(2131427453);
      Object[] var4 = new Object[]{this.pharmacyLocationObject.getName()};
      Utils.makeCall(this, var2, String.format(var3, var4), Utils.changePhoneNumberToUriFormat(this.pharmacyLocationObject.getPhone().replace(" ", "")));
   }

   protected void onResume() {
      super.onResume();
      this.updateOpenStatus();
   }
}
