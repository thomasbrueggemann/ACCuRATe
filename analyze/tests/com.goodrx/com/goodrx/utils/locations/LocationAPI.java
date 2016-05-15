package com.goodrx.utils.locations;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.location.Location;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.goodrx.model.LocationEntity;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.DBManager;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.widget.LocationProviderSelector;
import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import cz.msebera.android.httpclient.Header;
import org.droidparts.widget.ClearableEditText;

public abstract class LocationAPI {
   private Context context;
   private DBManager dbManager;

   public LocationAPI(Context var1) {
      this.context = var1;
      this.dbManager = new DBManager(var1);
   }

   public abstract void onLocationOptionSelected(View var1);

   public abstract void onSetCoordinateSuccess(LocationEntity var1);

   public abstract void onSetLocationTextSuccess(LocationEntity var1);

   public void setCoordinate(final Location var1) {
      this.dbManager.clearLocationSensitiveData();
      RequestParams var2 = new RequestParams("set_coords", var1.getLatitude() + "," + var1.getLongitude());
      CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/v3/location", var2, new MyResponseHandler(this.context) {
         public void onFailure(int var1x, Header[] var2, byte[] var3, Throwable var4, String var5) {
            if(var1x == 400) {
               LocationAPI.this.showServiceUnavailableDialog();
            } else {
               super.onFailure(var1x, var2, var3, var4, var5);
            }
         }

         public void onSuccess(String var1x) {
            Gson var2 = new Gson();
            Object var3;
            if(!(var2 instanceof Gson)) {
               var3 = var2.fromJson(var1x, LocationEntity.class);
            } else {
               var3 = GsonInstrumentation.fromJson((Gson)var2, var1x, LocationEntity.class);
            }

            LocationEntity var4 = (LocationEntity)var3;
            var4.setLatitude(var1.getLatitude());
            var4.setLongitude(var1.getLongitude());
            LocationUtils.saveLocationOptionToDisk(LocationAPI.this.context, LocationUtils.LocationOption.CURRENT_LOCATION, var4);
            GoodRxAPI.getInstance().updateBestPharmacyLocation(LocationAPI.this.context);
            LocationAPI.this.onSetCoordinateSuccess(var4);
         }
      });
   }

   public void setLocationText(String var1) {
      this.dbManager.clearLocationSensitiveData();
      RequestParams var2 = new RequestParams();
      var2.add("set_location", var1);
      CacheHttpRequestHelper.getInstance().get("https://www.goodrx.com/mobile-api/v3/location", var2, new MyResponseHandler(this.context) {
         public void onFailure(int var1, Header[] var2, byte[] var3, Throwable var4, String var5) {
            if(var1 == 400) {
               LocationAPI.this.showLocationEnterDialog();
            } else {
               super.onFailure(var1, var2, var3, var4, var5);
            }
         }

         public void onSuccess(String var1) {
            Gson var2 = new Gson();
            Object var3;
            if(!(var2 instanceof Gson)) {
               var3 = var2.fromJson(var1, LocationEntity.class);
            } else {
               var3 = GsonInstrumentation.fromJson((Gson)var2, var1, LocationEntity.class);
            }

            LocationEntity var4 = (LocationEntity)var3;
            if(!var4.isValid()) {
               LocationAPI.this.showLocationEnterDialog();
            } else {
               LocationUtils.saveLocationOptionToDisk(LocationAPI.this.context, LocationUtils.LocationOption.CUSTOM, var4);
               LocationAPI.this.onSetLocationTextSuccess(var4);
               GoodRxAPI.getInstance().updateBestPharmacyLocation(LocationAPI.this.context);
            }
         }
      });
   }

   public void showLocationEnterDialog() {
      View var1 = View.inflate(this.context, 2130968670, (ViewGroup)null);
      final ClearableEditText var2 = (ClearableEditText)var1.findViewById(2131886422);
      var2.setHint(2131427485);
      var2.requestFocus();
      AlertDialog.Builder var4 = DialogHelper.dialogWithCustomViewBuilder(this.context, 2131427559, var1);
      var4.setPositiveButton(2131427537, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2x) {
            if(var2.getText().toString().length() != 0) {
               LocationAPI.this.setLocationText(var2.getText().toString());
            }
         }
      });
      var4.setNegativeButton(2131427459, (OnClickListener)null);
      AlertDialog var7 = var4.create();
      var7.getWindow().clearFlags(131080);
      var7.getWindow().setSoftInputMode(4);
      var7.show();
   }

   public void showLocationSelector(boolean var1) {
      (new LocationProviderSelector(this.context) {
         public void onProviderSelected(View var1) {
            LocationAPI.this.onLocationOptionSelected(var1);
         }
      }).show(var1);
   }

   public void showServiceUnavailableDialog() {
      AlertDialog.Builder var1 = new AlertDialog.Builder(this.context);
      var1.setTitle(2131427647);
      View var3 = View.inflate(this.context, 2130968669, (ViewGroup)null);
      ((TextView)var3.findViewById(2131886421)).setText(2131427648);
      var1.setView(var3);
      var1.setPositiveButton(2131427709, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            LocationAPI.this.showLocationEnterDialog();
         }
      });
      DialogHelper.showDialog(var1);
   }
}
