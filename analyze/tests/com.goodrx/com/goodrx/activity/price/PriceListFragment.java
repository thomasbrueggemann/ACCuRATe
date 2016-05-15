package com.goodrx.activity.price;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.goodrx.activity.BaseFragmentWitGA;
import com.goodrx.activity.MapActivity;
import com.goodrx.activity.price.NoticeDetailActivity;
import com.goodrx.activity.price.NoticeListActivity;
import com.goodrx.activity.store.StoreActivity;
import com.goodrx.adapter.PriceListAdapter;
import com.goodrx.model.DrugObject;
import com.goodrx.model.LocationEntity;
import com.goodrx.model.Notice;
import com.goodrx.model.Price;
import com.goodrx.utils.ArrayUtils;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.Utils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.locations.GoogleServiceLocationHelper;
import com.goodrx.utils.locations.LocationAPI;
import com.goodrx.utils.locations.LocationUpdateListener;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.utils.locations.MyLocationInterface;
import com.goodrx.widget.MyProgressBar;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.parceler.Parcels;

public class PriceListFragment extends BaseFragmentWitGA {
   protected static int DISTANCE_STEP = 2;
   protected static final String DRUG_OBJECT = "drug_object";
   private final int SNACKBAR_DELAY = 500;
   protected String bestPharmacyId;
   protected int distance = 5;
   protected DrugObject drugObject;
   protected LocationAPI locationAPI;
   protected MyLocationInterface locationInterface;
   private boolean mIsSnackbarShowing;
   private Notice[] mNotices;
   private Snackbar mSnackbar;
   protected String parsePushData;
   protected PriceListAdapter priceListAdapter;
   private MyProgressBar progressBar;
   protected RecyclerView recyclerView;
   protected View viewNoPrice;

   private void getDrugWarning() {
      this.getSavingsTip(new OnRequestFinishListener() {
         public void onSuccess(String var1) {
            if(PriceListFragment.this.isAdded()) {
               PriceListFragment.this.progressBar.dismiss();
               JsonObject var2 = (new JsonParser()).parse(var1).getAsJsonObject();
               JsonArray var3 = var2.getAsJsonObject("results").getAsJsonArray("notices");
               JsonArray var4 = var2.getAsJsonObject("results").getAsJsonArray("warnings");
               Gson var5 = new Gson();
               Object var6;
               if(!(var5 instanceof Gson)) {
                  var6 = var5.fromJson((JsonElement)var3, (Class)Notice[].class);
               } else {
                  var6 = GsonInstrumentation.fromJson((Gson)var5, (JsonElement)var3, (Class)Notice[].class);
               }

               Notice[] var7 = (Notice[])var6;
               Gson var8 = new Gson();
               Object var9;
               if(!(var8 instanceof Gson)) {
                  var9 = var8.fromJson((JsonElement)var4, (Class)Notice[].class);
               } else {
                  var9 = GsonInstrumentation.fromJson((Gson)var8, (JsonElement)var4, (Class)Notice[].class);
               }

               Notice[] var10 = (Notice[])var9;
               PriceListFragment.this.mNotices = (Notice[])ArrayUtils.addAll(var7, var10);
               if(PriceListFragment.this.mNotices != null && var7.length != 0) {
                  String var12 = PriceListFragment.this.getString(2131427705);
                  if(PriceListFragment.this.mNotices.length == 1) {
                     var12 = PriceListFragment.this.mNotices[0].getTitle();
                  }

                  PriceListFragment.this.showSnackbar(var12, PriceListFragment.this.getString(2131427643), new OnClickListener() {
                     public void onClick(View var1) {
                        PriceListFragment.this.showDetails(PriceListFragment.this.mNotices);
                     }
                  });
                  return;
               }
            }

         }
      });
   }

   private void getSavingsTip(final OnRequestFinishListener<String> var1) {
      if(this.isAdded()) {
         GoodRxAPI.getInstance().getSavingsTips(this.getActivity(), this.drugObject.getId(), Integer.valueOf(this.drugObject.getQuantity()), new OnRequestFinishListener() {
            public void onSuccess(String var1x) {
               var1.onSuccess(var1x);
            }
         });
      }
   }

   public static PriceListFragment newInstance(DrugObject var0) {
      PriceListFragment var1 = new PriceListFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("drug_object", Parcels.wrap(var0));
      var1.setArguments(var2);
      return var1;
   }

   private void showDetails(Notice[] var1) {
      if(this.isAdded()) {
         if(var1.length == 1) {
            String[] var2 = new String[]{var1[0].getLong_description()};
            if(!Utils.isValidString(var2)) {
               String[] var3 = new String[]{var1[0].getLink()};
               if(Utils.isValidString(var3)) {
                  Utils.openWebIntent(this.getActivity(), var1[0].getLink());
                  return;
               }
            }

            NoticeDetailActivity.launch(this.getActivity(), var1[0]);
         } else {
            NoticeListActivity.launch(this.getActivity(), var1);
         }
      }
   }

   private void showSnackbar(final String var1, final String var2, final OnClickListener var3) {
      if(!this.mIsSnackbarShowing) {
         this.mIsSnackbarShowing = true;
         (new Handler()).postDelayed(new Runnable() {
            public void run() {
               if(PriceListFragment.this.isAdded()) {
                  PriceListFragment.this.mSnackbar = Snackbar.make(PriceListFragment.this.getActivity().findViewById(2131886320), var1, -2);
                  TextView var2x = (TextView)PriceListFragment.this.mSnackbar.getView().findViewById(2131886403);
                  var2x.setTextColor(-1);
                  var2x.setSingleLine(true);
                  PriceListFragment.this.mSnackbar.setActionTextColor(ContextCompat.getColor(PriceListFragment.this.getActivity(), 2131755110)).setAction(var2, var3);
                  PriceListFragment.this.mSnackbar.show();
                  PriceListFragment.this.recyclerView.clearOnScrollListeners();
                  PriceListFragment.this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                     public void onScrollStateChanged(RecyclerView var1x, int var2x) {
                        if(PriceListFragment.this.mSnackbar != null && PriceListFragment.this.mSnackbar.isShown()) {
                           PriceListFragment.this.mSnackbar.dismiss();
                        } else {
                           var1x.clearOnScrollListeners();
                        }
                     }
                  });
               }
            }
         }, 500L);
      }
   }

   protected void getPrices(DrugObject var1) {
      this.getPrices(var1, (Integer)null);
   }

   protected void getPrices(DrugObject var1, final Integer var2) {
      if(this.isAdded()) {
         this.progressBar.show();
         String var3 = "https://www.goodrx.com/mobile-api/v3/price/" + var1.getDrug_slug();
         RequestParams var4 = new RequestParams();
         var4.put("form", var1.getForm());
         var4.put("dosage", var1.getDosage());
         var4.put("quantity", var1.getQuantity());
         var4.put("label_override", var1.getDrug_slug());
         LocationEntity var5 = LocationUtils.getLocationEntity(this.getActivity());
         if(var5 != null) {
            var4.put("set_coords", var5.getLatitude() + "," + var5.getLongitude());
         }

         if(var2 != null) {
            var4.put("distance", String.valueOf(var2));
         }

         CacheHttpRequestHelper.getInstance().getUsingLocationSensitiveCache(var3, var4, 14400000L, new MyResponseHandler(this.getActivity()) {
            public void onSuccess(String var1) {
               if(PriceListFragment.this.isAdded()) {
                  JsonObject var2x = (new JsonParser()).parse(var1).getAsJsonObject();
                  if(var2x.has("location")) {
                     Gson var3 = new Gson();
                     JsonObject var4 = var2x.getAsJsonObject("location");
                     Object var5;
                     if(!(var3 instanceof Gson)) {
                        var5 = var3.fromJson((JsonElement)var4, (Class)LocationEntity.class);
                     } else {
                        var5 = GsonInstrumentation.fromJson((Gson)var3, (JsonElement)var4, (Class)LocationEntity.class);
                     }

                     LocationEntity var6 = (LocationEntity)var5;
                     if(var6.getDistance() != null) {
                        PriceListFragment.this.distance = var6.getDistance().intValue();
                        if(var2 != null) {
                           FragmentActivity var11 = PriceListFragment.this.getActivity();
                           String var12 = PriceListFragment.this.getString(2131427728);
                           Object[] var13 = new Object[]{var6.getDistance()};
                           Utils.showToast(var11, String.format(var12, var13));
                        }
                     }
                  }

                  Gson var7 = new Gson();
                  JsonArray var8 = var2x.getAsJsonArray("prices");
                  Object var9;
                  if(!(var7 instanceof Gson)) {
                     var9 = var7.fromJson((JsonElement)var8, (Class)Price[].class);
                  } else {
                     var9 = GsonInstrumentation.fromJson((Gson)var7, (JsonElement)var8, (Class)Price[].class);
                  }

                  Price[] var10 = (Price[])var9;
                  PriceListFragment.this.refreshList(var10);
               }
            }
         });
      }
   }

   protected void initComponent(View var1) {
      this.viewNoPrice = var1.findViewById(2131886473);
      if(this.getArguments() != null) {
         this.drugObject = (DrugObject)Parcels.unwrap(this.getArguments().getParcelable("drug_object"));
         this.parsePushData = this.getActivity().getIntent().getStringExtra("com.parse.Data");
      }

      String var2 = "";
      if(this.parsePushData != null) {
         JsonObject var6 = (new JsonParser()).parse(this.parsePushData).getAsJsonObject();
         if(var6.has("pharmacy_id")) {
            label22: {
               String var8;
               try {
                  var8 = var6.getAsJsonPrimitive("pharmacy_id").getAsString();
               } catch (Exception var9) {
                  break label22;
               }

               var2 = var8;
            }
         }
      }

      final boolean var3 = this.drugObject.getDrug_page_type().equalsIgnoreCase("prescription");
      final FragmentActivity var4 = this.getActivity();
      final boolean var5;
      if(LocationUtils.getLocationOption(this.getActivity()) == LocationUtils.LocationOption.NONE) {
         var5 = true;
      } else {
         var5 = false;
      }

      this.priceListAdapter = new PriceListAdapter(var4, var5, var3, this.bestPharmacyId, this.drugObject, new String[]{var2}) {
         public void onFooterViewClicked(int var1) {
            if(var1 == 2131886497) {
               if(PriceListFragment.this.distance < 42 - PriceListFragment.DISTANCE_STEP) {
                  PriceListFragment var10 = PriceListFragment.this;
                  var10.distance += PriceListFragment.DISTANCE_STEP;
                  PriceListFragment.this.getPrices(PriceListFragment.this.drugObject, Integer.valueOf(PriceListFragment.this.distance));
               }
            } else {
               if(var1 == 2131886498) {
                  Price[] var8 = PriceListFragment.this.priceListAdapter.getDataArray();
                  Price var9 = var8[-1 + var8.length];
                  StoreActivity.launch(PriceListFragment.this.getActivity(), PriceListFragment.this.drugObject.getId(), var9.getPharmacy_object().getId(), PriceListFragment.this.drugObject.getQuantity(), PriceListFragment.this.distance, true);
                  return;
               }

               if(var1 == 2131886502) {
                  View var2 = View.inflate(PriceListFragment.this.getContext(), 2130968664, (ViewGroup)null);
                  AlertDialog.Builder var3 = new AlertDialog.Builder(PriceListFragment.this.getActivity());
                  var3.setTitle(2131427396);
                  var3.setView(var2);
                  var3.setPositiveButton(2131427709, (android.content.DialogInterface.OnClickListener)null);
                  DialogHelper.showDialog(var3);
                  return;
               }
            }

         }

         public void onHeaderViewClicked(int var1) {
            if(var1 == 2131886324) {
               LocationAPI var2 = PriceListFragment.this.locationAPI;
               boolean var3;
               if(LocationUtils.getLocationOption(PriceListFragment.this.getActivity()) == LocationUtils.LocationOption.NONE) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               var2.showLocationSelector(var3);
            } else if(var1 == 2131886536) {
               MapActivity.launch(PriceListFragment.this, PriceListFragment.this.drugObject, Integer.valueOf(PriceListFragment.this.distance));
               return;
            }

         }

         public void onItemClickedListener(int var1, Price var2, View var3) {
            super.onItemClickedListener(var1, var2, var3);
            FragmentActivity var4 = PriceListFragment.this.getActivity();
            String var5 = PriceListFragment.this.drugObject.getId();
            String var6 = var2.getPharmacy_object().getId();
            int var7 = PriceListFragment.this.drugObject.getQuantity();
            int var8 = PriceListFragment.this.distance;
            boolean var9;
            if(var2.getPharmacy_object().getType() != null && var2.getPharmacy_object().getType().equals("nabp")) {
               var9 = true;
            } else {
               var9 = false;
            }

            StoreActivity.launch(var4, var5, var6, var7, var8, var9);
         }
      };
      this.recyclerView = (RecyclerView)var1.findViewById(2131886472);
      this.locationAPI = new LocationAPI(this.getActivity()) {
         public void onLocationOptionSelected(View var1) {
            int var2 = var1.getId();
            LocationUtils.LocationOption var3 = LocationUtils.getLocationOption(PriceListFragment.this.getActivity());
            if(var2 == 2131886423) {
               if(ActivityCompat.checkSelfPermission(PriceListFragment.this.getContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
                  PriceListFragment.this.requestLocationPermisssion();
                  return;
               }

               PriceListFragment.this.updateLocation();
            } else {
               if(var2 == 2131886426) {
                  this.showLocationEnterDialog();
                  return;
               }

               if(var2 == 2131886430 && var3 != LocationUtils.LocationOption.NONE) {
                  LocationUtils.saveLocationOptionToDisk(PriceListFragment.this.getActivity(), LocationUtils.LocationOption.NONE, (LocationEntity)null);
                  PriceListFragment.this.getPrices(PriceListFragment.this.drugObject);
                  return;
               }
            }

         }

         public void onSetCoordinateSuccess(LocationEntity var1) {
            if(PriceListFragment.this.isAdded()) {
               PriceListFragment.this.priceListAdapter.notifyItemChanged(0);
               PriceListFragment.this.getPrices(PriceListFragment.this.drugObject);
            }
         }

         public void onSetLocationTextSuccess(LocationEntity var1) {
            if(PriceListFragment.this.isAdded()) {
               PriceListFragment.this.priceListAdapter.notifyItemChanged(0);
               PriceListFragment.this.getPrices(PriceListFragment.this.drugObject);
            }
         }
      };
      this.locationInterface = new GoogleServiceLocationHelper(this.getActivity());
      this.recyclerView.setAdapter(this.priceListAdapter);
      this.recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
      this.progressBar = (MyProgressBar)this.getActivity().findViewById(2131886399);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130968688, var2, false);
      this.initComponent(var4);
      this.getPrices(this.drugObject);
      return var4;
   }

   @Subscribe
   public void onEvent(String var1) {
      if(var1.equals("dismiss_snackbar") && this.mSnackbar != null && this.mSnackbar.isShown()) {
         this.mSnackbar.dismiss();
      }

   }

   public void onPause() {
      EventBus.getDefault().unregister(this);
      super.onPause();
   }

   public void onRequestPermissionsResult(int var1, @NonNull String[] var2, @NonNull int[] var3) {
      if(var1 == 21) {
         if(var3.length == 1 && var3[0] == 0) {
            LocationUtils.saveLocationOptionToDisk(this.getActivity(), LocationUtils.LocationOption.CURRENT_LOCATION, (LocationEntity)null);
            this.updateLocation();
         } else {
            LocationUtils.saveLocationOptionToDisk(this.getActivity(), LocationUtils.LocationOption.NONE, (LocationEntity)null);
            Utils.makeSnackBar(this.getView(), this.getString(2131427649)).show();
         }
      } else {
         super.onRequestPermissionsResult(var1, var2, var3);
      }
   }

   public void onResume() {
      super.onResume();
      EventBus.getDefault().register(this);
   }

   public void refreshList(Price[] var1) {
      if(this.isAdded()) {
         if(var1 != null && var1.length != 0) {
            this.priceListAdapter.updateData(var1, LocationUtils.getLocationOption(this.getActivity()).equals(LocationUtils.LocationOption.NONE));
            this.recyclerView.setVisibility(0);
            this.viewNoPrice.setVisibility(8);
            this.getDrugWarning();
         } else {
            this.recyclerView.setVisibility(8);
            this.viewNoPrice.setVisibility(0);
         }
      }
   }

   public void requestLocationPermisssion() {
      this.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 21);
   }

   public void updateLocation() {
      this.locationInterface.setLocationUpdateListener(new LocationUpdateListener() {
         public void onLocationUpdated(Location var1) {
            PriceListFragment.this.locationAPI.setCoordinate(var1);
         }
      });
      LocationUtils.setLastUpdateTime(this.getActivity(), 0L);
      this.locationInterface.startUpdate();
   }
}
