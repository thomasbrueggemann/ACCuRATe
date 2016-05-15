package com.goodrx.activity;

import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import butterknife.ButterKnife;
import com.goodrx.model.LocationEntity;
import com.goodrx.model.MyRx;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.Utils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.locations.GoogleServiceLocationHelper;
import com.goodrx.utils.locations.LocationAPI;
import com.goodrx.utils.locations.LocationUpdateListener;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.utils.locations.MyLocationInterface;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.goodrx.widget.MyRx.BestPharmacyDrugNameView;

public class BestPharmacySettingActivity extends BaseActivityWithPasscode implements OnCheckedChangeListener {
   private int distance;
   LinearLayout drugsLayout;
   private LocationAPI locationAPI;
   private MyLocationInterface locationInterface;
   MyProgressBar myProgressBar;
   private MyRx[] myRxes;
   AppCompatSeekBar sbRadius;
   TextView txtLocation;
   TextView txtRadius;

   private void saveRxAndDistance() {
      MyRxUtils.saveRx(this, this.myRxes);
      MyRxUtils.saveBestPharmacyDistance(this, this.distance);
      this.setResult(-1);
   }

   private void updateLocation() {
      this.myProgressBar.show();
      this.locationInterface.setLocationUpdateListener(new LocationUpdateListener() {
         public void onLocationUpdated(Location var1) {
            BestPharmacySettingActivity.this.locationAPI.setCoordinate(var1);
         }
      });
      LocationUtils.setLastUpdateTime(this, 0L);
      this.locationInterface.startUpdate();
   }

   public void initComponents() {
      this.sbRadius.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            if(var2 > 0) {
               TextView var4 = BestPharmacySettingActivity.this.txtRadius;
               Resources var5 = BestPharmacySettingActivity.this.getResources();
               Object[] var6 = new Object[]{Integer.valueOf(var2)};
               var4.setText(var5.getQuantityString(2131361816, var2, var6));
            } else {
               var1.setProgress(1);
            }
         }

         public void onStartTrackingTouch(SeekBar var1) {
         }

         public void onStopTrackingTouch(SeekBar var1) {
            BestPharmacySettingActivity.this.distance = var1.getProgress();
            BestPharmacySettingActivity.this.saveSettings();
         }
      });
      this.locationInterface = new GoogleServiceLocationHelper(this);
      this.locationAPI = new LocationAPI(this) {
         public void onLocationOptionSelected(View var1) {
            int var2 = var1.getId();
            if(var2 == 2131886423) {
               if(ActivityCompat.checkSelfPermission(BestPharmacySettingActivity.this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                  BestPharmacySettingActivity.this.requestLocationPermisssion();
                  return;
               }

               BestPharmacySettingActivity.this.updateLocation();
            } else if(var2 == 2131886426) {
               try {
                  this.showLocationEnterDialog();
                  return;
               } catch (Exception var4) {
                  return;
               }
            }

         }

         public void onSetCoordinateSuccess(LocationEntity var1) {
            BestPharmacySettingActivity.this.myProgressBar.dismiss();
            BestPharmacySettingActivity.this.txtLocation.setText(var1.getFullDisplay());
            BestPharmacySettingActivity.this.saveRxAndDistance();
         }

         public void onSetLocationTextSuccess(LocationEntity var1) {
            BestPharmacySettingActivity.this.myProgressBar.dismiss();
            BestPharmacySettingActivity.this.txtLocation.setText(var1.getFullDisplay());
            BestPharmacySettingActivity.this.saveRxAndDistance();
         }

         public void setLocationText(String var1) {
            BestPharmacySettingActivity.this.myProgressBar.show();
            super.setLocationText(var1);
         }
      };
   }

   public void onBackPressed() {
      super.onBackPressed();
      this.overridePendingTransition(2131034141, 2131034139);
   }

   public void onButtonClicked(View var1) {
      if(var1.getId() == 2131886251) {
         this.locationAPI.showLocationSelector(true);
      }

   }

   public void onCheckedChanged(CompoundButton var1, boolean var2) {
      int var3 = ((Integer)var1.getTag()).intValue();
      this.myRxes[var3].getDrug().setConsidered(Boolean.valueOf(var2));
      this.saveSettings();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427827);
      this.setContentView(2130968606);
      this.shouldOverrideBackAnimation(false);
      ButterKnife.bind(this);
      this.initComponents();
      this.updateUI();
   }

   public void onRequestPermissionsResult(int var1, @NonNull String[] var2, @NonNull int[] var3) {
      if(var1 == 21) {
         if(var3.length == 1 && var3[0] == 0) {
            LocationUtils.saveLocationOptionToDisk(this, LocationUtils.LocationOption.CURRENT_LOCATION, (LocationEntity)null);
            this.updateLocation();
         } else {
            Utils.makeSnackBar(this.findViewById(2131886250), this.getString(2131427649)).show();
         }
      } else {
         super.onRequestPermissionsResult(var1, var2, var3);
      }
   }

   public void requestLocationPermisssion() {
      ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 21);
   }

   public void saveSettings() {
      GoodRxAPI.getInstance().saveBestPharmacySettings(this, this.myRxes, this.distance, new OnRequestFinishListener() {
         public void onSuccess(String var1) {
            BestPharmacySettingActivity.this.saveRxAndDistance();
         }
      });
   }

   public void updateUI() {
      String var1 = this.getString(2131427688);
      if(LocationUtils.getLocationEntity(this) != null) {
         var1 = LocationUtils.getLocationEntity(this).getFullDisplay();
      }

      this.txtLocation.setText(var1);
      this.distance = MyRxUtils.getBestPharmacyDistance(this);
      this.sbRadius.setProgress(this.distance);
      this.myRxes = MyRxUtils.getRx(this);

      for(int var2 = 0; var2 < this.myRxes.length; ++var2) {
         BestPharmacyDrugNameView var3 = new BestPharmacyDrugNameView(this, this.myRxes[var2]);
         var3.setTag(Integer.valueOf(var2));
         if(this.myRxes[var2].getDrug().isConsidered()) {
            var3.setChecked(true);
         } else {
            var3.setChecked(false);
         }

         var3.getCheckBox().setOnCheckedChangeListener(this);
         this.drugsLayout.addView(var3);
      }

   }
}
