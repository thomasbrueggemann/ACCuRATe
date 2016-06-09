package com.goodrx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import com.goodrx.activity.store.StoreActivity;
import com.goodrx.model.DrugObject;
import com.goodrx.model.LocationEntity;
import com.goodrx.model.PharmacyLocationObject;
import com.goodrx.model.PharmacyObject;
import com.goodrx.model.Price;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.MarkerIcon;
import com.goodrx.utils.MarkerIconFactory;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.Utils;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.util.HashMap;
import org.parceler.Parcels;

public class MapActivity extends BaseActivityWithPasscode implements OnMapReadyCallback {
   private Integer distance;
   private DrugObject drugObject;
   private GoogleMap map;

   private void getData(DrugObject var1, Integer var2) {
      String var3 = "https://www.goodrx.com/mobile-api/v3/price/" + var1.getDrug_slug();
      final MyProgressBar var4 = (MyProgressBar)this.findViewById(2131886399);
      var4.show();
      RequestParams var5 = new RequestParams();
      var5.put("form", var1.getForm());
      var5.put("dosage", var1.getDosage());
      var5.put("quantity", var1.getQuantity());
      var5.put("label_override", var1.getDrug_slug());
      var5.put("pharmacy_locations_object", "1");
      if(var2 != null) {
         var5.put("distance", String.valueOf(var2));
      }

      LocationEntity var6 = LocationUtils.getLocationEntity(this);
      if(var6 != null) {
         var5.put("set_coords", var6.getLatitude() + "," + var6.getLongitude());
      }

      if(var2 != null) {
         var5.put("distance", String.valueOf(var2));
      }

      CacheHttpRequestHelper.getInstance().getUsingLocationSensitiveCache(var3, var5, 14400000L, new MyResponseHandler(this) {
         public void onSuccess(String var1) {
            var4.dismiss();
            JsonObject var2 = (new JsonParser()).parse(var1).getAsJsonObject();
            Gson var3 = new Gson();
            JsonArray var4x = var2.getAsJsonArray("prices");
            Object var5;
            if(!(var3 instanceof Gson)) {
               var5 = var3.fromJson((JsonElement)var4x, (Class)Price[].class);
            } else {
               var5 = GsonInstrumentation.fromJson((Gson)var3, (JsonElement)var4x, (Class)Price[].class);
            }

            Price[] var6 = (Price[])var5;
            MapActivity.this.updateUI(var6);
         }
      });
   }

   public static void launch(Fragment var0, DrugObject var1, Integer var2) {
      if(var0.isAdded()) {
         Intent var3 = new Intent(var0.getActivity(), MapActivity.class);
         Bundle var4 = new Bundle();
         var4.putParcelable("drug_object", Parcels.wrap(var1));
         var4.putInt("distance", var2.intValue());
         var3.putExtras(var4);
         var0.startActivityForResult(var3, 5);
         var0.getActivity().overridePendingTransition(2131034132, 2131034140);
      }
   }

   private void moveAndZoom(GoogleMap var1, LatLng var2, int var3) {
      var1.moveCamera(CameraUpdateFactory.newCameraPosition((new CameraPosition.Builder()).target(var2).zoom((float)var3).tilt(45.0F).build()));
   }

   private void updateUI(final Price[] var1) {
      final HashMap var2 = new HashMap();

      for(int var3 = 0; var3 < var1.length; ++var3) {
         Price var6 = var1[var3];
         PharmacyLocationObject[] var7 = var6.getPharmacy_locations_object();
         if(!var6.getPharmacy_object().getType().equals("nabp") && var7 != null && var7.length != 0) {
            PharmacyLocationObject var8 = var7[0];
            if(var8.getLongitude() != null && var8.getLatitude() != null) {
               LatLng var9 = new LatLng(var8.getLatitude().doubleValue(), var8.getLongitude().doubleValue());
               MarkerIcon var10 = MarkerIconFactory.create(this, MarkerIconFactory.MarkerIconType.PHARMACY_DETAIL);
               TextView var11 = (TextView)var10.getView().findViewById(2131886697);
               TextView var12 = (TextView)var10.getView().findViewById(2131886698);
               var11.setText(var6.getPharmacy_object().getName());
               var12.setText(Utils.formatPrice(Double.valueOf(var6.getPrice())));
               double var13 = var8.getDistance();
               Object[] var15 = new Object[]{Double.valueOf(var13)};
               String var16 = String.format("%.1f", var15);
               var2.put(this.map.addMarker((new MarkerOptions()).position(var9).title(var8.getAddress()).snippet(var16 + " mi").icon(var10.getBitMapDescriptor())), Integer.valueOf(var3));
            }
         }
      }

      GoogleMap var4 = this.map;
      GoogleMap.OnInfoWindowClickListener var5 = new GoogleMap.OnInfoWindowClickListener() {
         public void onInfoWindowClick(Marker var1x) {
            Integer var2x = (Integer)var2.get(var1x);
            if(var2x != null) {
               PharmacyObject var3 = var1[var2x.intValue()].getPharmacy_object();
               StoreActivity.launch(MapActivity.this, MapActivity.this.drugObject.getId(), var3.getId(), MapActivity.this.drugObject.getQuantity(), 5, false);
            }

         }
      };
      var4.setOnInfoWindowClickListener(var5);
   }

   public void initData() {
      super.initData();
      this.getData(this.drugObject, this.distance);
   }

   public void onBackPressed() {
      this.finish();
      this.overridePendingTransition(2131034141, 2131034139);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427845);
      this.setContentView(2130968622);
      Bundle var2 = this.getIntent().getExtras();
      this.drugObject = (DrugObject)Parcels.unwrap(var2.getParcelable("drug_object"));
      this.distance = Integer.valueOf(var2.getInt("distance", -1));
      if(this.distance.intValue() < 0) {
         this.distance = null;
      }

      ((MapFragment)this.getFragmentManager().findFragmentById(2131886298)).getMapAsync(this);
   }

   public void onMapReady(GoogleMap var1) {
      this.map = var1;
      this.map.getUiSettings().setZoomControlsEnabled(false);
      LocationEntity var2 = LocationUtils.getLocationEntity(this);
      if(var2 != null) {
         LatLng var3 = new LatLng(var2.getLatitude(), var2.getLongitude());
         MarkerIcon var4 = MarkerIconFactory.create(this, MarkerIconFactory.MarkerIconType.CURRENT_LOCATION);
         this.map.addMarker((new MarkerOptions()).position(var3).title(this.getResources().getString(2131428038))).setIcon(var4.getBitMapDescriptor());
         this.moveAndZoom(this.map, var3, 13);
         this.initData();
      }
   }
}
