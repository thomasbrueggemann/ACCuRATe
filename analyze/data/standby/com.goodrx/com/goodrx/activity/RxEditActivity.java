package com.goodrx.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import butterknife.ButterKnife;
import com.goodrx.activity.ImageSelectorActivity;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.activity.price.RxPriceActivity;
import com.goodrx.model.BaseDrugProperty;
import com.goodrx.model.DrugDetail;
import com.goodrx.model.ImageResult;
import com.goodrx.model.MyRx;
import com.goodrx.model.Pharmacy;
import com.goodrx.model.SelectedDrug;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.ViewUtils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.tracker.GAHelper;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.goodrx.widget.MyRx.RxEditImage;
import com.goodrx.widget.MyRx.RxEditOption;
import com.google.gson.Gson;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import org.droidparts.widget.ClearableEditText;
import org.json.JSONException;
import org.json.JSONObject;

public class RxEditActivity extends BaseActivityWithPasscode {
   Button btnAdd;
   private String callingActivity;
   RxEditOption dosageOption;
   private String dosageSlug;
   private DrugDetail drugDetail;
   RxEditOption drugOption;
   RxEditOption formOption;
   private String formSlug;
   private GoodRxAPI goodRxAPI;
   RxEditImage imageOption;
   private ImageResult[] imageResults;
   private boolean isInMyRx;
   View layoutDelete;
   private String originalId;
   private Pharmacy[] pharmacyList;
   RxEditOption pharmacyOption;
   private int quantity;
   RxEditOption quantityOption;
   private String selectedPharmacyId;
   private String slug;

   private void openMainActivity(boolean var1) {
      if(var1) {
         MyRxUtils.setRxUpdateFlag(this);
      }

      Intent var2 = new Intent(this, MainActivity.class);
      var2.addFlags(67108864);
      Gson var4 = new Gson();
      MainActivity.MainFragmentStatus var5 = MainActivity.MainFragmentStatus.MY_RX;
      String var6;
      if(!(var4 instanceof Gson)) {
         var6 = var4.toJson((Object)var5);
      } else {
         var6 = GsonInstrumentation.toJson((Gson)var4, (Object)var5);
      }

      var2.putExtra("init_status", var6);
      this.startActivity(var2);
      this.finish();
   }

   private void showAddButton() {
      ViewUtils.show(this.btnAdd, 0.9F);
   }

   private void showDosageSelector() {
      DialogHelper.showDialog(DialogHelper.createSingleChoiceDialog(this, 2131427478, this.getDisplayStringFromProperty(this.drugDetail.getDosages()), ArrayUtils.indexOf(this.drugDetail.getDosages(), this.drugDetail.getSelectedDrug().getDosage()), new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            RxEditActivity.this.dosageSlug = RxEditActivity.this.drugDetail.getDosages()[var3].getSlug();
            RxEditActivity.this.getDrugDetail(RxEditActivity.this.slug, RxEditActivity.this.formSlug, RxEditActivity.this.dosageSlug, RxEditActivity.this.quantity, true);
            RxEditActivity.this.showAddButton();
         }
      }));
   }

   private void showDrugSelector() {
      String[] var1 = new String[this.drugDetail.getBrands().length + this.drugDetail.getGenerics().length];
      int var2 = 0;

      for(int var3 = 0; var3 < var1.length; ++var3) {
         if(var3 < this.drugDetail.getBrands().length) {
            var1[var3] = this.drugDetail.getBrands()[var3].getLongName();
         } else {
            var1[var3] = this.drugDetail.getGenerics()[var3 - this.drugDetail.getBrands().length].getLongName();
         }

         if(var1[var3].equals(this.drugDetail.getSelectedDrugLongName())) {
            var2 = var3;
         }
      }

      DialogHelper.showDialog(DialogHelper.createSingleChoiceDialog(this, 2131427479, var1, var2, new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            String var7;
            if(var3 < RxEditActivity.this.drugDetail.getBrands().length) {
               var7 = RxEditActivity.this.drugDetail.getBrands()[var3].getSlug();
            } else {
               int var6 = var3 - RxEditActivity.this.drugDetail.getBrands().length;
               var7 = RxEditActivity.this.drugDetail.getGenerics()[var6].getSlug();
            }

            RxEditActivity.this.getDrugDetail(var7, (String)null, (String)null, -1, true);
            RxEditActivity.this.showAddButton();
         }
      }));
   }

   private void showFormSelector() {
      DialogHelper.showDialog(DialogHelper.createSingleChoiceDialog(this, 2131427480, this.getDisplayStringFromProperty(this.drugDetail.getForms()), ArrayUtils.indexOf(this.drugDetail.getForms(), this.drugDetail.getSelectedDrug().getForm()), new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            RxEditActivity.this.formSlug = RxEditActivity.this.drugDetail.getForms()[var3].getSlug();
            RxEditActivity.this.getDrugDetail(RxEditActivity.this.slug, RxEditActivity.this.formSlug, RxEditActivity.this.dosageSlug, RxEditActivity.this.quantity, true);
            RxEditActivity.this.showAddButton();
         }
      }));
   }

   private void showQuantityEnterDialog() {
      View var1 = View.inflate(this, 2130968670, (ViewGroup)null);
      final ClearableEditText var2 = (ClearableEditText)var1.findViewById(2131886422);
      var2.setHint(this.getResources().getString(2131427568) + 5000);
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
      AlertDialog.Builder var3 = DialogHelper.dialogWithCustomViewBuilder(this, 2131427518, var1);
      var3.setNegativeButton(2131427459, (OnClickListener)null);
      var3.setPositiveButton(2131427537, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2x) {
            var1.dismiss();
            if(var2.getText().toString().length() != 0) {
               int var3 = Integer.valueOf(var2.getText().toString()).intValue();
               int[] var4 = RxEditActivity.this.drugDetail.getQuantities();
               int var5 = ArrayUtils.indexOf(var4, var3);
               RxEditActivity.this.quantityOption.setText2(RxEditActivity.this.getQuantityString(var3, RxEditActivity.this.drugDetail.getSelectedDrug().getFormSingular(), RxEditActivity.this.drugDetail.getSelectedDrug().getFormPlural()));
               if(var5 == -1) {
                  int[] var6 = new int[1 + var4.length];
                  System.arraycopy(var4, 0, var6, 0, var4.length);
                  var6[-1 + var6.length] = var3;
                  Arrays.sort(var6);
                  RxEditActivity.this.drugDetail.setQuantities(var6);
                  RxEditActivity.this.drugDetail.getSelectedDrug().setQuantity(var3);
               }

               RxEditActivity.this.showAddButton();
            }
         }
      });
      AlertDialog var6 = var3.create();
      var6.getWindow().clearFlags(131080);
      var6.getWindow().setSoftInputMode(4);
      var6.show();
   }

   private void showQuantitySelector() {
      int var1 = ArrayUtils.indexOf(this.drugDetail.getQuantities(), this.drugDetail.getSelectedDrug().getQuantity());
      DialogHelper.showDialog(DialogHelper.createSingleChoiceDialogWithPositiveButton(this, 2131427483, this.convertIntArrToStr(this.drugDetail.getQuantities()), var1, new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            int var6 = RxEditActivity.this.drugDetail.getQuantities()[var3];
            RxEditActivity.this.drugDetail.getSelectedDrug().setQuantity(var6);
            RxEditActivity.this.quantityOption.setText2(RxEditActivity.this.getQuantityString(var6, RxEditActivity.this.drugDetail.getSelectedDrug().getFormSingular(), RxEditActivity.this.drugDetail.getSelectedDrug().getFormPlural()));
            RxEditActivity.this.showAddButton();
         }
      }, 2131427558, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            var1.dismiss();
            RxEditActivity.this.showQuantityEnterDialog();
         }
      }));
   }

   public void addDrug(String var1, int var2, String var3, String var4) {
      final MyProgressBar var5 = (MyProgressBar)this.findViewById(2131886399);
      var5.show();
      this.goodRxAPI.addRx(this, var1, var2, var3, var4, new OnRequestFinishListener() {
         public void onSuccess(String var1) {
            var5.dismiss();
            RxEditActivity.this.openMainActivity(true);
         }
      });
      GAHelper.sendGoogleAnalyticsEvent(this, this.getString(2131427469), this.getString(2131427571), this.getString(2131427575));
      if(this.selectedPharmacyId != null && this.selectedPharmacyId.length() > 0) {
         GAHelper.sendGoogleAnalyticsEvent(this, this.getString(2131427573), this.getString(2131427571), this.getString(2131427577));
      }

   }

   public String[] convertIntArrToStr(int[] var1) {
      String[] var2 = new String[var1.length];

      for(int var3 = 0; var3 < var1.length; ++var3) {
         var2[var3] = String.valueOf(var1[var3]);
      }

      return var2;
   }

   public void getDefaultImage(String var1, String var2, String var3) {
      this.goodRxAPI.getDefaultImages(this, var1, var3, var2, new OnRequestFinishListener() {
         public void onFailure(int var1, String var2) {
            super.onFailure(var1, var2);
            RxEditActivity.this.imageOption.setEnabled(false);
         }

         public void onSuccess(ImageResult[] var1) {
            byte var2 = 1;
            RxEditActivity.this.imageResults = var1;
            RxEditActivity.this.imageOption.setImageUrl(RxEditActivity.this.imageResults[0].getImage());
            RxEditImage var4 = RxEditActivity.this.imageOption;
            if(RxEditActivity.this.imageResults.length <= var2) {
               var2 = 0;
            }

            var4.setEnabled((boolean)var2);
         }
      });
   }

   public <T extends BaseDrugProperty> String[] getDisplayStringFromProperty(T[] var1) {
      String[] var2 = new String[var1.length];

      for(int var3 = 0; var3 < var1.length; ++var3) {
         var2[var3] = var1[var3].getDisplay();
      }

      return var2;
   }

   public void getDrugDetail(String var1, String var2, String var3, int var4, boolean var5) {
      final MyProgressBar var6 = (MyProgressBar)this.findViewById(2131886399);
      var6.show();
      StringBuilder var7 = new StringBuilder("https://www.goodrx.com/mobile-api/v2/details/" + var1);
      if(var2 != null) {
         var7.append("/").append(var2);
      }

      if(var3 != null) {
         var7.append("/").append(var3);
      }

      if(var4 > 0) {
         var7.append("/").append(var4);
      }

      RequestParams var8 = new RequestParams();
      var8.add("trackable_only", "1");
      if(var5) {
         var8.add("manufacturer", "match");
      }

      CacheHttpRequestHelper.getInstance().getUsingCache(var7.toString(), var8, 86400000L, new MyResponseHandler(this) {
         public void onSuccess(String var1) {
            try {
               new JSONObject;
               JSONObject var4 = JSONObjectInstrumentation.init(var1);
               RxEditActivity.this.drugDetail = new DrugDetail(var4);
               SelectedDrug var6x = RxEditActivity.this.drugDetail.getSelectedDrug();
               RxEditActivity.this.slug = var6x.getSlug();
               RxEditActivity.this.dosageSlug = var6x.getDosage().getSlug();
               RxEditActivity.this.formSlug = var6x.getForm().getSlug();
               if(RxEditActivity.this.originalId == null) {
                  RxEditActivity.this.originalId = RxEditActivity.this.drugDetail.getSelectedDrug().getDrugId();
               }

               RxEditActivity.this.updateUI();
               var6.dismiss();
            } catch (JSONException var7) {
               var7.printStackTrace();
            }
         }
      });
   }

   public void getPharmacyList() {
      final MyProgressBar var1 = (MyProgressBar)this.findViewById(2131886399);
      var1.show();
      GoodRxAPI.getInstance().getPharmacyList(this, new OnRequestFinishListener() {
         public void onSuccess(Pharmacy[] var1x) {
            var1.dismiss();
            RxEditActivity.this.pharmacyList = var1x;
            RxEditActivity.this.showPharmacySelector();
         }
      });
   }

   public String getQuantityString(int var1, String var2, String var3) {
      return var1 < 0?"":(var1 < 2?var1 + " " + var2:var1 + " " + var3);
   }

   public void initData() {
      super.initData();
      String var1 = this.callingActivity;
      boolean var2 = false;
      if(var1 != null) {
         boolean var3 = this.callingActivity.equals(RxPriceActivity.class.getName());
         var2 = false;
         if(var3) {
            var2 = true;
            this.getSupportActionBar().setTitle(2131427549);
         }
      }

      this.getDrugDetail(this.slug, this.formSlug, this.dosageSlug, this.quantity, var2);
   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      if(var2 == -1 && var1 == 11) {
         String var4 = var3.getStringExtra("image_url");
         this.imageOption.setImageUrl(var4);
         this.showAddButton();
      }
   }

   public void onAddRxClicked(View var1) {
      SelectedDrug var2 = this.drugDetail.getSelectedDrug();
      if(this.drugDetail != null && var2 != null) {
         if(this.callingActivity != null && this.callingActivity.equals(RxPriceActivity.class.getName())) {
            boolean var3 = this.isInMyRx;
            String var4 = null;
            if(!var3) {
               var4 = this.imageOption.getImageUrl();
            }

            this.replaceDrug(var2.getDrugId(), var2.getQuantity(), this.selectedPharmacyId, var4);
         } else {
            this.addDrug(var2.getDrugId(), var2.getQuantity(), this.selectedPharmacyId, this.imageOption.getImageUrl());
         }
      }
   }

   public void onBackPressed() {
      super.onBackPressed();
      if(this.callingActivity != null && this.callingActivity.equals(RxPriceActivity.class.getName())) {
         this.overridePendingTransition(2131034141, 2131034139);
      } else {
         this.overridePendingTransition(2131034131, 2131034139);
      }
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427861);
      this.setContentView(2130968635);
      ButterKnife.bind(this);
      Bundle var2 = this.getIntent().getExtras();
      this.slug = var2.getString("slug");
      this.formSlug = var2.getString("form_slug");
      this.dosageSlug = var2.getString("dosage_slug");
      this.quantity = var2.getInt("quantity", -1);
      this.callingActivity = var2.getString("calling_activity");
      this.pharmacyOption.setText2("------");
      this.selectedPharmacyId = null;
      this.goodRxAPI = GoodRxAPI.getInstance();
      if(this.callingActivity != null && this.callingActivity.equals(RxPriceActivity.class.getName())) {
         this.btnAdd.setVisibility(8);
      }

      this.initData();
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1.getItemId() == 16908332) {
         this.onBackPressed();
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   void onRxEditClicked(View var1) {
      int var2 = var1.getId();
      if(var2 == 2131886336) {
         this.showDrugSelector();
      }

      if(var2 == 2131886337) {
         this.showFormSelector();
      } else {
         if(var2 == 2131886338) {
            this.showDosageSelector();
            return;
         }

         if(var2 == 2131886339) {
            this.showQuantitySelector();
            return;
         }

         if(var2 == 2131886340) {
            this.showImageSelector();
            return;
         }

         if(var2 == 2131886341) {
            this.showPharmacySelector();
            return;
         }
      }

   }

   public void remove(final String var1) {
      final MyProgressBar var2 = (MyProgressBar)this.findViewById(2131886399);
      var2.show();
      GoodRxAPI.getInstance().removeRx(this, new OnRequestFinishListener() {
         public void onSuccess(String var1x) {
            var2.dismiss();
            RxEditActivity var2x = RxEditActivity.this;
            String[] var3 = new String[]{var1};
            MyRxUtils.removeRx(var2x, var3);
            RxEditActivity.this.openMainActivity(false);
         }
      }, new String[]{var1});
   }

   public void replaceDrug(String var1, int var2, String var3, String var4) {
      final MyProgressBar var5 = (MyProgressBar)this.findViewById(2131886399);
      var5.show();
      this.goodRxAPI.replaceDrug(this, var1, this.originalId, var2, var3, var4, new OnRequestFinishListener() {
         public void onSuccess(String var1) {
            var5.dismiss();
            RxEditActivity.this.openMainActivity(true);
         }
      });
      if(this.selectedPharmacyId != null && this.selectedPharmacyId.length() > 0) {
         GAHelper.sendGoogleAnalyticsEvent(this, this.getString(2131427573), this.getString(2131427571), this.getString(2131427577));
      }

   }

   public void showImageSelector() {
      if(this.isInMyRx) {
         ImageSelectorActivity.launchWithUserImages(this, this.imageOption.getImageView(), this.imageOption.getImageUrl(), this.drugDetail.getSelectedDrug().getDrugId());
      } else {
         SelectedDrug var1 = this.drugDetail.getSelectedDrug();
         ImageSelectorActivity.launchWithDefaultImages(this, this.imageOption.getImageView(), this.slug, this.formSlug, this.dosageSlug, var1.getDrugId(), this.imageOption.getImageUrl());
      }
   }

   public void showPharmacySelector() {
      if(this.pharmacyList == null) {
         this.getPharmacyList();
      } else {
         final String[] var1 = new String[1 + this.pharmacyList.length];

         for(int var2 = 0; var2 < this.pharmacyList.length; ++var2) {
            var1[var2 + 1] = this.pharmacyList[var2].getName();
         }

         var1[0] = this.getResources().getString(2131427702);
         String var3 = this.selectedPharmacyId;
         int var4 = 0;
         if(var3 != null) {
            int var5 = 0;

            while(true) {
               int var6 = this.pharmacyList.length;
               var4 = 0;
               if(var5 >= var6) {
                  break;
               }

               if(this.pharmacyList[var5].getId().equals(this.selectedPharmacyId)) {
                  var4 = var5 + 1;
                  break;
               }

               ++var5;
            }
         }

         DialogHelper.showDialog(DialogHelper.createSingleChoiceDialogWithPositiveButton(this, 2131427482, var1, var4, new OnItemClickListener() {
            public void onItemClick(AdapterView<?> var1x, View var2, int var3, long var4) {
               if(var3 == 0) {
                  RxEditActivity.this.selectedPharmacyId = "";
               } else {
                  RxEditActivity.this.selectedPharmacyId = RxEditActivity.this.pharmacyList[var3 - 1].getId();
               }

               RxEditActivity.this.pharmacyOption.setText2(var1[var3]);
               RxEditActivity.this.showAddButton();
            }
         }, 2131427537, new OnClickListener() {
            public void onClick(DialogInterface var1x, int var2) {
               var1x.dismiss();
               if(RxEditActivity.this.selectedPharmacyId == null) {
                  RxEditActivity.this.selectedPharmacyId = "";
                  RxEditActivity.this.pharmacyOption.setText2(var1[0]);
                  RxEditActivity.this.showAddButton();
               }

            }
         }));
      }
   }

   public void updateUI() {
      final SelectedDrug var1 = this.drugDetail.getSelectedDrug();
      this.drugOption.setText2(this.drugDetail.getSelectedDrugLongName());
      RxEditOption var2 = this.drugOption;
      boolean var3;
      if(this.drugDetail.getBrands().length + this.drugDetail.getGenerics().length > 1) {
         var3 = true;
      } else {
         var3 = false;
      }

      var2.setEnabled(var3);
      this.formOption.setText2(var1.getForm().getDisplay());
      RxEditOption var4 = this.formOption;
      boolean var5;
      if(this.drugDetail.getForms().length > 1) {
         var5 = true;
      } else {
         var5 = false;
      }

      var4.setEnabled(var5);
      this.dosageOption.setText2(var1.getDosage().getDisplay());
      RxEditOption var6 = this.dosageOption;
      boolean var7;
      if(this.drugDetail.getDosages().length > 1) {
         var7 = true;
      } else {
         var7 = false;
      }

      var6.setEnabled(var7);
      this.quantityOption.setText2(this.getQuantityString(var1.getQuantity(), var1.getFormSingular(), var1.getFormPlural()));
      MyRx[] var8 = MyRxUtils.getRx(this);
      int var9 = -1;

      for(int var10 = 0; var10 < var8.length; ++var10) {
         if(var8[var10].getStatus() == 0 && var8[var10].getDrug().getDrug_id().equals(var1.getDrugId())) {
            var9 = var10;
            break;
         }
      }

      boolean var11;
      if(var9 != -1) {
         var11 = true;
      } else {
         var11 = false;
      }

      this.isInMyRx = var11;
      if(this.isInMyRx) {
         MyRx var12 = var8[var9];
         this.imageOption.setEnabled(true);
         this.imageOption.setImageUrl(var12.getDrug().getImage());
         this.selectedPharmacyId = var12.getPreferredPharmacy().getPharm_id();
         if(this.selectedPharmacyId != null) {
            this.pharmacyOption.setText2(var12.getPreferredPharmacy().getName());
            this.quantityOption.setText2(var12.getDrug().getQty_form());
         }

         int var13 = var12.getDrug().getQuantity();
         this.drugDetail.getSelectedDrug().setQuantity(var13);
         int[] var14 = this.drugDetail.getQuantities();
         if(!ArrayUtils.contains(var14, var13)) {
            int[] var15 = ArrayUtils.add(var14, var13);
            Arrays.sort(var15);
            this.drugDetail.setQuantities(var15);
         }

         this.btnAdd.setText(2131427819);
         ViewUtils.show(this.layoutDelete);
         this.layoutDelete.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View var1x) {
               View var2 = View.inflate(RxEditActivity.this, 2130968669, (ViewGroup)null);
               String var3 = RxEditActivity.this.getString(2131427526);
               Object[] var4 = new Object[]{var1.getNameDisplay()};
               String var5 = String.format(var3, var4);
               ((TextView)var2.findViewById(2131886421)).setText(Html.fromHtml(var5));
               AlertDialog.Builder var6 = DialogHelper.dialogWithCustomViewBuilder(RxEditActivity.this, 2131427525, var2);
               var6.setPositiveButton(2131427709, new OnClickListener() {
                  public void onClick(DialogInterface var1x, int var2) {
                     RxEditActivity.this.remove(var1.getDrugId());
                  }
               });
               var6.setNegativeButton(2131427459, (OnClickListener)null);
               DialogHelper.showDialog(var6);
            }
         });
      } else {
         if(this.callingActivity != null && this.callingActivity.equals(RxPriceActivity.class.getName())) {
            this.btnAdd.setText(2131427819);
         } else {
            this.btnAdd.setText(2131427416);
         }

         ViewUtils.hide(this.layoutDelete);
         this.imageOption.setEnabled(false);
         this.getDefaultImage(this.slug, this.formSlug, this.dosageSlug);
      }
   }
}
