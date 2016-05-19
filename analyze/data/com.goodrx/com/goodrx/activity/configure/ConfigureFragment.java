package com.goodrx.activity.configure;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import butterknife.ButterKnife;
import com.goodrx.activity.SearchActivity;
import com.goodrx.activity.price.PriceActivity;
import com.goodrx.model.DrugObject;
import com.goodrx.model.EventBusMessage;
import com.goodrx.model.Key;
import com.goodrx.model.LocationEntity;
import com.goodrx.model.RecentSearch;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.HistoryRecordOperator;
import com.goodrx.utils.Utils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.locations.GoogleServiceLocationHelper;
import com.goodrx.utils.locations.LocationAPI;
import com.goodrx.utils.locations.LocationUpdateListener;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.utils.locations.MyLocationInterface;
import com.goodrx.utils.tracker.GAHelper;
import com.goodrx.widget.MyProgressBar;
import com.goodrx.widget.ConfigureItem.ConfigureItem;
import com.goodrx.widget.ConfigureItem.DrugNameItem;
import com.goodrx.widget.ConfigureItem.OnContentChangeListener;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mobileapptracker.MATEvent;
import com.mobileapptracker.MobileAppTracker;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.droidparts.widget.ClearableEditText;
import org.greenrobot.eventbus.EventBus;

@Instrumented
public class ConfigureFragment extends Fragment implements TraceFieldInterface {
   private static final String DOSAGE = "dosage";
   private static final String FORM = "form";
   private static final String MATCH_MANUFACTURER = "match_manufacturer";
   private static final String QUANTITY = "quantity";
   private static final String SLUG = "slug";
   private ArrayList<String> brandList;
   Button btnPrice;
   private DrugObject defaultDrugObject;
   private String dosage;
   private JsonObject drugEquivlentsObject;
   private String form;
   View formDivider;
   private ArrayList<String> genericList;
   ConfigureItem itemDosage;
   DrugNameItem itemDrugName;
   ConfigureItem itemForm;
   ConfigureItem itemLocation;
   ConfigureItem itemQuantity;
   private LocationAPI locationAPI;
   private LocationEntity locationEntity;
   private MyLocationInterface locationInterface;
   private LocationUtils.LocationOption locationOption;
   private boolean matchManufacturer;
   MyProgressBar myProgressBar;
   private Integer quantity;
   private int[] quantityArray;
   private String selectedDosage;
   private String selectedDrug;
   private String selectedForm;
   private int selectedQuantity;
   private String slug;

   private String getDrugId() {
      return this.drugEquivlentsObject.getAsJsonObject(this.selectedDrug).getAsJsonObject("forms").getAsJsonObject(this.selectedForm).getAsJsonObject("dosages").getAsJsonObject(this.selectedDosage).getAsJsonPrimitive("drug_id").getAsString();
   }

   private String getSlug() {
      try {
         String var2 = this.drugEquivlentsObject.getAsJsonObject(this.selectedDrug).getAsJsonPrimitive("slug").getAsString();
         return var2;
      } catch (Exception var3) {
         return null;
      }
   }

   private void initComponents() {
      this.brandList = new ArrayList();
      this.genericList = new ArrayList();
      this.itemDosage.setOnContentChangeListener(new OnContentChangeListener() {
         public void contentChanged(int var1, String var2) {
            String[] var3 = ConfigureFragment.this.getDosageArray();
            ConfigureFragment.this.selectedDosage = var3[var1];
            ConfigureFragment.this.updateDrugName(ConfigureFragment.this.selectedDrug, ConfigureFragment.this.selectedForm, ConfigureFragment.this.selectedDosage);
            ConfigureFragment.this.sendGAFilterEvent("Dosage", var2);
         }
      });
      this.itemQuantity.setOnContentChangeListener(new OnContentChangeListener() {
         public void contentChanged(int var1, String var2) {
            ConfigureFragment.this.itemQuantity.setSelectedIndex(var1);
            ConfigureFragment.this.selectedQuantity = ConfigureFragment.this.getQuantityArray(false)[var1];
            ConfigureFragment.this.sendGAFilterEvent("Quantity", var2);
         }
      });
      this.locationAPI = new LocationAPI(this.getActivity()) {
         public void onLocationOptionSelected(View var1) {
            int var2 = var1.getId();
            if(var2 == 2131886423) {
               LocationUtils.setLastUpdateTime(ConfigureFragment.this.getActivity(), 0L);
               ConfigureFragment.this.locationOption = LocationUtils.LocationOption.CURRENT_LOCATION;
               ConfigureFragment.this.locationEntity = null;
               ConfigureFragment.this.prepareCurrentLocation();
            } else {
               if(var2 == 2131886426) {
                  this.showLocationEnterDialog();
                  return;
               }

               if(var2 == 2131886430) {
                  ConfigureFragment.this.locationOption = LocationUtils.LocationOption.NONE;
                  ConfigureFragment.this.locationEntity = null;
                  ConfigureFragment.this.btnPrice.setEnabled(true);
                  ConfigureFragment.this.itemLocation.setContent(ConfigureFragment.this.getResources().getString(2131427688));
                  ConfigureFragment.this.itemLocation.setContentTextColor(ContextCompat.getColor(ConfigureFragment.this.getContext(), 2131755021));
                  LocationUtils.saveLocationOptionToDisk(ConfigureFragment.this.getActivity(), ConfigureFragment.this.locationOption, ConfigureFragment.this.locationEntity);
                  return;
               }
            }

         }

         public void onSetCoordinateSuccess(LocationEntity var1) {
            if(ConfigureFragment.this.isAdded()) {
               ConfigureFragment.this.btnPrice.setEnabled(true);
               ConfigureFragment.this.locationEntity = var1;
            }
         }

         public void onSetLocationTextSuccess(LocationEntity var1) {
            if(ConfigureFragment.this.isAdded()) {
               ConfigureFragment.this.btnPrice.setEnabled(true);
               ConfigureFragment.this.locationOption = LocationUtils.LocationOption.CUSTOM;
               ConfigureFragment.this.locationEntity = var1;
               String var4 = var1.getDisplay();
               ConfigureFragment.this.itemLocation.setContent(var4);
               ConfigureFragment.this.itemLocation.setContentTextColor(ContextCompat.getColor(ConfigureFragment.this.getContext(), 17170444));
            }
         }

         public void setLocationText(String var1) {
            ConfigureFragment.this.btnPrice.setEnabled(false);
            super.setLocationText(var1);
         }
      };
      this.locationInterface = new GoogleServiceLocationHelper(this.getActivity());
      this.locationOption = LocationUtils.getLocationOption(this.getActivity());
   }

   public static ConfigureFragment newInstance(String var0, boolean var1, String var2, String var3, String var4) {
      ConfigureFragment var5 = new ConfigureFragment();
      Bundle var6 = new Bundle();
      var6.putString("slug", var0);
      var6.putBoolean("match_manufacturer", var1);
      var6.putString("form", var2);
      var6.putString("dosage", var3);
      var6.putString("quantity", var4);
      var5.setArguments(var6);
      return var5;
   }

   private void openPriceActivity() {
      if(this.isAdded()) {
         MobileAppTracker var1 = MobileAppTracker.getInstance();
         Key var2 = GoodRxAPI.getInstance().getToken(this.getActivity());
         if(var2 != null && var1 != null) {
            var1.setUserId(var2.getToken_id());
            var1.measureEvent((new MATEvent("search")).withCurrencyCode("USD").withQuantity(1));
         }

         Intent var3 = new Intent(this.getActivity(), PriceActivity.class);
         Bundle var4 = new Bundle();
         var4.putString("drug_id", this.getDrugId());
         var4.putString("drug_slug", this.getSlug());
         var4.putString("form_slug", this.selectedForm);
         var4.putString("dosage_slug", this.selectedDosage);
         var4.putInt("quantity", this.selectedQuantity);
         var3.putExtras(var4);
         this.getActivity().startActivity(var3);
         this.getActivity().overridePendingTransition(2131034132, 2131034138);
      }
   }

   private void sendGAFilterEvent(String var1, String var2) {
      GAHelper.sendGoogleAnalyticsEvent(this.getContext(), this.getString(2131427572), var1, var2);
   }

   private void showDosageSelector() {
      final int var1 = this.itemDosage.getSelectedIndex();
      final String[] var2 = this.getDosageDisplayArray();
      DialogHelper.showDialog(DialogHelper.createSingleChoiceDialog(this.getActivity(), 2131427478, var2, var1, new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1x, View var2x, int var3, long var4) {
            ConfigureFragment.this.itemDosage.setSelectedIndex(var3);
            ConfigureFragment.this.selectedDosage = ConfigureFragment.this.getDosageArray()[var3];
            ConfigureFragment.this.updateDrugName(ConfigureFragment.this.selectedDrug, ConfigureFragment.this.selectedForm, ConfigureFragment.this.selectedDosage);
            ConfigureFragment.this.sendGAFilterEvent("Dosage", var2[var1]);
         }
      }));
   }

   private void showDrugSelector() {
      String[] var1 = new String[this.brandList.size() + this.genericList.size()];
      int var2 = 0;

      for(int var3 = 0; var3 < this.brandList.size(); ++var3) {
         var1[var3] = this.getFullName((String)this.brandList.get(var3));
         if(this.selectedDrug.equals(this.brandList.get(var3))) {
            var2 = var3;
         }
      }

      for(int var4 = 0; var4 < this.genericList.size(); ++var4) {
         var1[var4 + this.brandList.size()] = this.getFullName((String)this.genericList.get(var4));
         if(this.selectedDrug.equals(this.genericList.get(var4))) {
            var2 = var4 + this.brandList.size();
         }
      }

      DialogHelper.showDialog(DialogHelper.createSingleChoiceDialog(this.getActivity(), 2131427479, var1, var2, new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            if(var3 < ConfigureFragment.this.brandList.size()) {
               ConfigureFragment.this.selectedDrug = (String)ConfigureFragment.this.brandList.get(var3);
            } else {
               int var6 = var3 - ConfigureFragment.this.brandList.size();
               ConfigureFragment.this.selectedDrug = (String)ConfigureFragment.this.genericList.get(var6);
            }

            ConfigureFragment.this.sendGAFilterEvent("Brand", ConfigureFragment.this.selectedDrug);
            ConfigureFragment.this.updateUI();
         }
      }));
   }

   private void showFormSelector() {
      final String[] var1 = this.getFormDisplayArray();
      final int var2 = this.itemForm.getSelectedIndex();
      DialogHelper.showDialog(DialogHelper.createSingleChoiceDialog(this.getActivity(), 2131427480, var1, var2, new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1x, View var2x, int var3, long var4) {
            ConfigureFragment.this.itemForm.setSelectedIndex(var3);
            ConfigureFragment.this.selectedForm = ConfigureFragment.this.getFormSlugArray()[var3];
            JsonObject var7 = ConfigureFragment.this.drugEquivlentsObject.getAsJsonObject(ConfigureFragment.this.selectedDrug);
            ConfigureFragment.this.selectedDosage = var7.getAsJsonObject("forms").getAsJsonObject(ConfigureFragment.this.selectedForm).getAsJsonPrimitive("default_dosage").getAsString();
            ConfigureFragment.this.updateDosage(ConfigureFragment.this.selectedDosage);
            ConfigureFragment.this.updateDrugName(ConfigureFragment.this.selectedDrug, ConfigureFragment.this.selectedForm, ConfigureFragment.this.selectedDosage);
            ConfigureFragment.this.getQuantityArray(true);
            ConfigureFragment.this.selectedQuantity = var7.getAsJsonObject("forms").getAsJsonObject(ConfigureFragment.this.selectedForm).getAsJsonObject("dosages").getAsJsonObject(ConfigureFragment.this.selectedDosage).getAsJsonPrimitive("default_quantity").getAsInt();
            ConfigureFragment.this.updateQuantity(ConfigureFragment.this.selectedQuantity);
            ConfigureFragment.this.sendGAFilterEvent("Form", var1[var2]);
         }
      }));
   }

   private void showQuantityDialog() {
      int var1 = this.itemQuantity.getSelectedIndex();
      final int[] var2 = this.getQuantityArray(false);
      String[] var3 = this.convertIntArrToStr(var2);
      DialogHelper.showDialog(DialogHelper.createSingleChoiceDialogWithPositiveButton(this.getActivity(), 2131427483, var3, var1, new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2x, int var3, long var4) {
            ConfigureFragment.this.itemQuantity.setSelectedIndex(var3);
            ConfigureFragment.this.selectedQuantity = var2[var3];
            ConfigureFragment.this.sendGAFilterEvent("Quantity", String.valueOf(ConfigureFragment.this.selectedQuantity));
         }
      }, 2131427558, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            var1.dismiss();
            ConfigureFragment.this.showQuantityEnterDialog();
         }
      }));
   }

   private void showQuantityEnterDialog() {
      View var1 = View.inflate(this.getActivity(), 2130968670, (ViewGroup)null);
      final ClearableEditText var2 = (ClearableEditText)var1.findViewById(2131886422);
      var2.setHint(this.getResources().getString(2131427568) + 5000);
      var2.setSingleLine(true);
      var2.setEllipsize(TruncateAt.END);
      var2.setInputType(2);
      var2.addTextChangedListener(new TextWatcher() {
         // $FF: synthetic field
         final Toast val$toast;

         {
            this.val$toast = var2;
         }

         public void afterTextChanged(Editable var1) {
            if(var1.length() > 0) {
               int var2 = Integer.valueOf(var1.toString()).intValue();
               if(var2 > 5000 || var2 == 0) {
                  var1.delete(-1 + var1.length(), var1.length());
                  if(!this.val$toast.getView().isShown()) {
                     this.val$toast.show();
                  }
               }
            }

         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      });
      AlertDialog.Builder var3 = DialogHelper.dialogWithCustomViewBuilder(this.getActivity(), 2131427518, var1);
      var3.setNegativeButton(2131427459, (OnClickListener)null);
      var3.setPositiveButton(2131427537, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2x) {
            if(var2.getText().toString().length() != 0) {
               int var3 = Integer.valueOf(var2.getText().toString()).intValue();
               int[] var4 = ConfigureFragment.this.getQuantityArray(false);
               int var5 = ArrayUtils.indexOf(var4, var3);
               if(var5 != -1) {
                  ConfigureFragment.this.itemQuantity.setSelectedIndex(var5);
               } else {
                  int[] var6 = new int[1 + var4.length];
                  System.arraycopy(var4, 0, var6, 0, var4.length);
                  var6[-1 + var6.length] = var3;
                  ConfigureFragment.this.quantityArray = var6;
                  Arrays.sort(ConfigureFragment.this.quantityArray);
                  int var8 = ArrayUtils.indexOf(ConfigureFragment.this.quantityArray, var3);
                  ConfigureFragment.this.selectedQuantity = var3;
                  ConfigureFragment.this.itemQuantity.setContentArray(ConfigureFragment.this.convertIntArrToStr(ConfigureFragment.this.quantityArray));
                  ConfigureFragment.this.itemQuantity.setSelectedIndex(var8);
                  ConfigureFragment.this.itemQuantity.setStepperEnabled(true);
                  ConfigureFragment.this.sendGAFilterEvent("Quantity", String.valueOf(ConfigureFragment.this.selectedQuantity));
               }
            }
         }
      });
      AlertDialog var6 = var3.create();
      var6.getWindow().clearFlags(131080);
      var6.getWindow().setSoftInputMode(4);
      var6.show();
   }

   public String[] convertIntArrToStr(int[] var1) {
      String[] var2 = new String[var1.length];

      for(int var3 = 0; var3 < var1.length; ++var3) {
         var2[var3] = String.valueOf(var1[var3]);
      }

      return var2;
   }

   public String[] getDosageArray() {
      JsonObject var1 = this.drugEquivlentsObject.getAsJsonObject(this.selectedDrug);
      Gson var2 = new Gson();
      JsonArray var3 = var1.getAsJsonObject("forms").getAsJsonObject(this.selectedForm).getAsJsonArray("dosage_sort");
      Object var4;
      if(!(var2 instanceof Gson)) {
         var4 = var2.fromJson((JsonElement)var3, (Class)String[].class);
      } else {
         var4 = GsonInstrumentation.fromJson((Gson)var2, (JsonElement)var3, (Class)String[].class);
      }

      return (String[])var4;
   }

   public String[] getDosageDisplayArray() {
      String[] var1 = this.getDosageArray();
      String[] var2 = new String[var1.length];
      JsonObject var3 = this.drugEquivlentsObject.getAsJsonObject(this.selectedDrug).getAsJsonObject("forms").getAsJsonObject(this.selectedForm).getAsJsonObject("dosages");

      for(int var4 = 0; var4 < var1.length; ++var4) {
         var2[var4] = var3.getAsJsonObject(var1[var4]).getAsJsonPrimitive("name").getAsString();
      }

      return var2;
   }

   public void getDrugDetail(String var1, final String var2, final String var3, final Integer var4, boolean var5, boolean var6) {
      if(var1 != null) {
         this.myProgressBar.show();
         GoodRxAPI.getInstance().getDrugDetail(this.getActivity(), var1, var2, var3, var4, var5, new OnRequestFinishListener() {
            public void onSuccess(String var1) {
               if(ConfigureFragment.this.isAdded()) {
                  JsonObject var2x = (JsonObject)(new JsonParser()).parse(var1);
                  ConfigureFragment var3x = ConfigureFragment.this;
                  Gson var4x = new Gson();
                  Object var5;
                  if(!(var4x instanceof Gson)) {
                     var5 = var4x.fromJson((JsonElement)var2x, (Class)DrugObject.class);
                  } else {
                     var5 = GsonInstrumentation.fromJson((Gson)var4x, (JsonElement)var2x, (Class)DrugObject.class);
                  }

                  var3x.defaultDrugObject = (DrugObject)var5;
                  ConfigureFragment.this.selectedDrug = var2x.getAsJsonPrimitive("display").getAsString();
                  ConfigureFragment.this.drugEquivlentsObject = var2x.getAsJsonObject("drug_equivalents");
                  Iterator var9 = ConfigureFragment.this.drugEquivlentsObject.entrySet().iterator();

                  while(var9.hasNext()) {
                     String var13 = (String)((Entry)var9.next()).getKey();
                     if(ConfigureFragment.this.drugEquivlentsObject.getAsJsonObject(var13).getAsJsonPrimitive("generic").getAsBoolean()) {
                        ConfigureFragment.this.genericList.add(var13);
                     } else {
                        ConfigureFragment.this.brandList.add(var13);
                     }
                  }

                  ConfigureFragment.this.updateUI();
                  if(var2 != null) {
                     ConfigureFragment.this.updateFormDosage(var2);
                  }

                  if(var3 != null) {
                     ConfigureFragment.this.updateDosage(var3);
                  }

                  if(var2 != null || var3 != null) {
                     ConfigureFragment.this.updateDrugName(ConfigureFragment.this.selectedDrug, ConfigureFragment.this.selectedForm, ConfigureFragment.this.selectedDosage);
                  }

                  if(var4 != null) {
                     ConfigureFragment.this.updateQuantity(var4.intValue());
                  }

                  ConfigureFragment.this.myProgressBar.dismiss();
                  HashMap var10 = new HashMap();
                  var10.put("drug_slug", ConfigureFragment.this.selectedDrug);
                  var10.put("appindex_title", ConfigureFragment.this.getFullName(ConfigureFragment.this.selectedDrug));
                  EventBus.getDefault().post(new EventBusMessage("app_index_info", var10));
               }
            }
         });
      }
   }

   public String getEquivlentBrand(String var1, String var2, String var3) {
      if(!this.drugEquivlentsObject.getAsJsonObject(var1).getAsJsonPrimitive("generic").getAsBoolean()) {
         return null;
      } else if(this.brandList.size() == 0) {
         return null;
      } else {
         Gson var4 = new Gson();

         for(int var5 = 0; var5 < this.brandList.size(); ++var5) {
            JsonArray var6 = this.drugEquivlentsObject.getAsJsonObject((String)this.brandList.get(var5)).getAsJsonArray("form_sort");
            Object var7;
            if(!(var4 instanceof Gson)) {
               var7 = var4.fromJson((JsonElement)var6, (Class)String[].class);
            } else {
               var7 = GsonInstrumentation.fromJson((Gson)var4, (JsonElement)var6, (Class)String[].class);
            }

            if(ArrayUtils.indexOf((String[])var7, var2) != -1) {
               JsonArray var8 = this.drugEquivlentsObject.getAsJsonObject((String)this.brandList.get(var5)).getAsJsonObject("forms").getAsJsonObject(var2).getAsJsonArray("dosage_sort");
               Object var9;
               if(!(var4 instanceof Gson)) {
                  var9 = var4.fromJson((JsonElement)var8, (Class)String[].class);
               } else {
                  var9 = GsonInstrumentation.fromJson((Gson)var4, (JsonElement)var8, (Class)String[].class);
               }

               if(ArrayUtils.indexOf((String[])var9, var3) != -1) {
                  return (String)this.brandList.get(var5);
               }
            }
         }

         return null;
      }
   }

   public String[] getFormDisplayArray() {
      JsonObject var1 = this.drugEquivlentsObject.getAsJsonObject(this.selectedDrug);
      Gson var2 = new Gson();
      JsonArray var3 = var1.getAsJsonArray("form_sort");
      Object var4;
      if(!(var2 instanceof Gson)) {
         var4 = var2.fromJson((JsonElement)var3, (Class)String[].class);
      } else {
         var4 = GsonInstrumentation.fromJson((Gson)var2, (JsonElement)var3, (Class)String[].class);
      }

      String[] var5 = (String[])var4;
      String[] var6 = new String[var5.length];

      for(int var7 = 0; var7 < var6.length; ++var7) {
         var6[var7] = WordUtils.capitalize(var1.getAsJsonObject("forms").getAsJsonObject(var5[var7]).getAsJsonPrimitive("display").getAsString(), new char[]{'^'});
      }

      return var6;
   }

   public String[] getFormSlugArray() {
      JsonObject var1 = this.drugEquivlentsObject.getAsJsonObject(this.selectedDrug);
      Gson var2 = new Gson();
      JsonArray var3 = var1.getAsJsonArray("form_sort");
      Object var4;
      if(!(var2 instanceof Gson)) {
         var4 = var2.fromJson((JsonElement)var3, (Class)String[].class);
      } else {
         var4 = GsonInstrumentation.fromJson((Gson)var2, (JsonElement)var3, (Class)String[].class);
      }

      return (String[])var4;
   }

   public String getFullName(String var1) {
      if(!this.drugEquivlentsObject.getAsJsonObject(var1).getAsJsonPrimitive("generic").getAsBoolean()) {
         var1 = var1 + " (" + this.getString(2131427446) + ")";
      } else if(this.brandList.size() != 0) {
         String var2 = this.getEquivlentBrand(var1, this.selectedForm, this.selectedDosage);
         if(var2 != null) {
            return var1 + " (" + this.getString(2131427599) + " " + var2 + ")";
         }
      }

      return var1;
   }

   public int[] getQuantityArray(boolean var1) {
      if(this.quantityArray == null || var1) {
         JsonArray var2 = this.drugEquivlentsObject.getAsJsonObject(this.selectedDrug).getAsJsonObject("forms").getAsJsonObject(this.selectedForm).getAsJsonObject("dosages").getAsJsonObject(this.selectedDosage).getAsJsonArray("quantities");
         Gson var3 = new Gson();
         Object var4;
         if(!(var3 instanceof Gson)) {
            var4 = var3.fromJson((JsonElement)var2, (Class)int[].class);
         } else {
            var4 = GsonInstrumentation.fromJson((Gson)var3, (JsonElement)var2, (Class)int[].class);
         }

         this.quantityArray = (int[])var4;
      }

      return this.quantityArray;
   }

   public void onClick(View var1) {
      int var2 = var1.getId();
      if(var2 == 2131886445) {
         this.showDrugSelector();
      } else {
         if(var2 == 2131886446) {
            this.showFormSelector();
            return;
         }

         if(var2 == 2131886448) {
            this.showDosageSelector();
            return;
         }

         if(var2 == 2131886449) {
            this.showQuantityDialog();
            return;
         }

         if(var2 == 2131886450) {
            LocationAPI var3 = this.locationAPI;
            boolean var4;
            if(this.locationOption == LocationUtils.LocationOption.NONE) {
               var4 = true;
            } else {
               var4 = false;
            }

            var3.showLocationSelector(var4);
            return;
         }
      }

   }

   public void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
      var2.inflate(2131951625, var1);
   }

   public View onCreateView(LayoutInflater param1, ViewGroup param2, Bundle param3) {
      // $FF: Couldn't be decompiled
   }

   public void onDestroyView() {
      super.onDestroyView();
      ButterKnife.unbind(this);
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(!this.isAdded()) {
         return true;
      } else {
         switch(var1.getItemId()) {
         case 2131886791:
            SearchActivity.launch(this.getActivity());
            return true;
         default:
            return super.onOptionsItemSelected(var1);
         }
      }
   }

   public void onPause() {
      if(this.locationOption == LocationUtils.LocationOption.CURRENT_LOCATION) {
         this.locationInterface.stopUpdate();
      }

      super.onPause();
   }

   public void onPriceButtonClicked() {
      String var1 = this.getSlug();
      if(var1 != null) {
         HistoryRecordOperator.update(new RecentSearch(var1, this.getFullName(this.selectedDrug), this.selectedForm, this.selectedDosage, this.selectedQuantity), this.getActivity());
         this.openPriceActivity();
      }
   }

   public void onRequestPermissionsResult(int var1, @NonNull String[] var2, @NonNull int[] var3) {
      if(var1 == 21) {
         if(var3.length == 1 && var3[0] == 0) {
            LocationUtils.saveLocationOptionToDisk(this.getActivity(), LocationUtils.LocationOption.CURRENT_LOCATION, (LocationEntity)null);
         } else {
            LocationUtils.saveLocationOptionToDisk(this.getActivity(), LocationUtils.LocationOption.NONE, (LocationEntity)null);
            Utils.makeSnackBar(this.getView(), this.getString(2131427649)).show();
         }
      } else {
         super.onRequestPermissionsResult(var1, var2, var3);
      }
   }

   public void onResume() {
      this.locationOption = LocationUtils.getLocationOption(this.getActivity());
      this.locationEntity = LocationUtils.getLocationEntity(this.getActivity());
      if(this.locationOption == LocationUtils.LocationOption.CURRENT_LOCATION) {
         this.prepareCurrentLocation();
         this.itemLocation.setContent(this.getResources().getString(2131427515));
         this.itemLocation.setContentTextColor(ContextCompat.getColor(this.getContext(), 2131755021));
      } else if(this.locationOption == LocationUtils.LocationOption.CUSTOM) {
         String var1 = this.locationEntity.getDisplay();
         this.itemLocation.setContent(var1);
         this.itemLocation.setContentTextColor(ContextCompat.getColor(this.getContext(), 17170444));
         this.btnPrice.setEnabled(true);
      } else if(this.locationOption == LocationUtils.LocationOption.NONE) {
         this.btnPrice.setEnabled(true);
         this.itemLocation.setContent(this.getResources().getString(2131427688));
         this.itemLocation.setContentTextColor(ContextCompat.getColor(this.getContext(), 2131755021));
      }

      if(this.locationOption == LocationUtils.LocationOption.CURRENT_LOCATION) {
         this.locationInterface.startUpdate();
      }

      super.onResume();
   }

   protected void onStart() {
      super.onStart();
      ApplicationStateMonitor.getInstance().activityStarted();
   }

   protected void onStop() {
      super.onStop();
      ApplicationStateMonitor.getInstance().activityStopped();
   }

   public void prepareCurrentLocation() {
      this.btnPrice.setEnabled(false);
      this.itemLocation.setContent(this.getResources().getString(2131427515));
      this.itemLocation.setContentTextColor(ContextCompat.getColor(this.getContext(), 2131755021));
      if(ActivityCompat.checkSelfPermission(this.getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
         this.updateLocation();
      } else {
         this.requestLocationPermisssion();
      }
   }

   public void requestLocationPermisssion() {
      this.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 21);
   }

   public void updateDosage(String var1) {
      if(!this.drugEquivlentsObject.getAsJsonObject(this.selectedDrug).getAsJsonObject("forms").getAsJsonObject(this.selectedForm).getAsJsonObject("dosages").has(var1)) {
         var1 = this.getDosageArray()[0];
      }

      this.selectedDosage = var1;
      String[] var2 = this.getDosageArray();
      if(var2.length < 2) {
         this.itemDosage.setEnabled(false);
         String var4 = this.getDosageDisplayArray()[0];
         if(Utils.isValidString(new String[]{var4})) {
            this.itemDosage.setContent(var4 + " " + this.getResources().getString(2131427712));
         }

      } else {
         this.itemDosage.setEnabled(true);
         int var3 = ArrayUtils.indexOf(var2, var1);
         this.itemDosage.setContentArray(this.getDosageDisplayArray());
         this.itemDosage.setSelectedIndex(var3);
      }
   }

   public void updateDrugName(String var1, String var2, String var3) {
      this.itemDrugName.setTitle(var1);
      if(this.genericList.size() + this.brandList.size() == 1) {
         this.itemDrugName.setEnabled(false);
         this.itemDrugName.setHideContent(true);
      } else {
         this.itemDrugName.setEnabled(true);
         this.itemDrugName.setHideContent(false);
         String var4 = this.getEquivlentBrand(var1, var2, var3);
         if(var4 == null) {
            this.itemDrugName.setHideContent(true);
         } else {
            this.itemDrugName.setContent("generic " + var4);
         }
      }
   }

   public void updateFormDosage(String var1) {
      JsonObject var2 = this.drugEquivlentsObject.getAsJsonObject(this.selectedDrug);
      if(!var2.getAsJsonObject("forms").has(var1)) {
         var1 = this.getFormSlugArray()[0];
      }

      this.selectedForm = var1;
      String var3 = WordUtils.capitalize(var2.getAsJsonObject("forms").getAsJsonObject(var1).getAsJsonPrimitive("display").getAsString(), new char[]{'^'});
      Gson var4 = new Gson();
      JsonArray var5 = var2.getAsJsonArray("form_sort");
      Object var6;
      if(!(var4 instanceof Gson)) {
         var6 = var4.fromJson((JsonElement)var5, (Class)String[].class);
      } else {
         var6 = GsonInstrumentation.fromJson((Gson)var4, (JsonElement)var5, (Class)String[].class);
      }

      String[] var7 = (String[])var6;
      if(var7.length < 2) {
         this.itemForm.setEnabled(false);
         this.itemForm.setContent(var3 + " " + this.getResources().getString(2131427712));
      } else {
         this.itemForm.setEnabled(true);
         this.itemForm.setStepperEnabled(false);
         this.itemForm.setContent(var3);
         int var8 = ArrayUtils.indexOf(var7, var1);
         this.itemForm.setContentArray(this.getFormDisplayArray());
         this.itemForm.setSelectedIndex(var8);
      }

      this.updateDosage(var2.getAsJsonObject("forms").getAsJsonObject(var1).getAsJsonPrimitive("default_dosage").getAsString());
   }

   public void updateLocation() {
      this.locationInterface.setLocationUpdateListener(new LocationUpdateListener() {
         public void onLocationUpdated(Location var1) {
            if(ConfigureFragment.this.isAdded()) {
               if(ConfigureFragment.this.locationEntity == null) {
                  ConfigureFragment.this.locationAPI.setCoordinate(var1);
               } else {
                  Location var2 = new Location("saved_location");
                  var2.setLatitude(ConfigureFragment.this.locationEntity.getLatitude());
                  var2.setLongitude(ConfigureFragment.this.locationEntity.getLongitude());
                  if(var1.distanceTo(var2) > 1600.0F) {
                     ConfigureFragment.this.locationAPI.setCoordinate(var1);
                  } else {
                     ConfigureFragment.this.btnPrice.setEnabled(true);
                  }
               }
            }
         }
      });
      this.locationInterface.startUpdate();
   }

   public void updateQuantity(int var1) {
      this.selectedQuantity = var1;
      int[] var2 = this.getQuantityArray(true);
      if(var2.length < 2) {
         this.itemQuantity.setStepperEnabled(false);
      } else {
         this.itemQuantity.setStepperEnabled(true);
      }

      int var3 = ArrayUtils.indexOf(var2, var1);
      if(var3 == -1) {
         this.quantityArray = ArrayUtils.add(this.quantityArray, var1);
         Arrays.sort(this.quantityArray);
         var3 = ArrayUtils.indexOf(this.getQuantityArray(false), var1);
      }

      this.itemQuantity.setContentArray(this.getQuantityArray(false));
      this.itemQuantity.setSelectedIndex(var3);
   }

   public void updateUI() {
      JsonObject var1 = this.drugEquivlentsObject.getAsJsonObject(this.selectedDrug);
      this.selectedForm = var1.getAsJsonPrimitive("default_form").getAsString();
      this.updateFormDosage(this.selectedForm);
      this.selectedQuantity = var1.getAsJsonObject("forms").getAsJsonObject(this.selectedForm).getAsJsonObject("dosages").getAsJsonObject(this.selectedDosage).getAsJsonPrimitive("default_quantity").getAsInt();
      this.updateQuantity(this.selectedQuantity);
      this.updateDrugName(this.selectedDrug, this.selectedForm, this.selectedDosage);
      if(this.locationOption == LocationUtils.LocationOption.CURRENT_LOCATION) {
         this.itemLocation.setContent(this.getResources().getString(2131427515));
         this.itemLocation.setContentTextColor(ContextCompat.getColor(this.getContext(), 2131755021));
      } else if(this.locationOption == LocationUtils.LocationOption.CUSTOM) {
         this.itemLocation.setContentTextColor(ContextCompat.getColor(this.getContext(), 17170444));
      }

      if(this.defaultDrugObject.getDrug_page_type() != null && this.defaultDrugObject.getDrug_page_type().equals("otc") && this.brandList.size() + this.genericList.size() == 1) {
         this.openPriceActivity();
         this.getActivity().finish();
      }

   }
}
