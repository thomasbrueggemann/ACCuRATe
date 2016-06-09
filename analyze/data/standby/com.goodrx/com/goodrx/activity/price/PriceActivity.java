package com.goodrx.activity.price;

import android.content.Intent;
import android.content.UriMatcher;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.goodrx.activity.BaseFragmentWitGA;
import com.goodrx.activity.SearchActivity;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.activity.price.ActivityWithCoupon;
import com.goodrx.activity.price.InfoFragment;
import com.goodrx.activity.price.NewsFragment;
import com.goodrx.activity.price.PriceFragmentFactory;
import com.goodrx.activity.price.SavingsFragment;
import com.goodrx.model.DrugInformation;
import com.goodrx.model.DrugObject;
import com.goodrx.model.MyRx;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.widget.MyProgressBar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.util.ArrayList;
import org.apache.commons.lang3.text.WordUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class PriceActivity extends ActivityWithCoupon {
   private final String AUTHORITY = "goodrx.com";
   private final String AUTHORITY_DESKTOP = "www.goodrx.com";
   private final String AUTHORITY_MOBILE = "m.goodrx.com";
   private FloatingActionButton btnAdd;
   private String dosageSlug;
   public DrugObject drugObject;
   private String drugSlug;
   private String formSlug;
   public GoodRxAPI goodrxApi;
   private String initTab;
   private MyProgressBar myProgressBar;
   private PriceActivity.PricePagerAdapter pricePagerAdapter;
   private ViewPager viewPager;

   private void addUriToMatcher(UriMatcher var1, String var2, int var3) {
      var1.addURI("goodrx.com", var2, var3);
      var1.addURI("m.goodrx.com", var2, var3);
      var1.addURI("www.goodrx.com", var2, var3);
   }

   private void initComponents() {
      this.getSupportActionBar().setHomeAsUpIndicator(2130837666);
      this.myProgressBar = (MyProgressBar)this.findViewById(2131886399);
      this.btnAdd = (FloatingActionButton)this.findViewById(2131886323);
      this.viewPager = (ViewPager)this.findViewById(2131886322);
      this.viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
         public void onPageSelected(int var1) {
            super.onPageSelected(var1);
            if(var1 != 0) {
               EventBus.getDefault().post("dismiss_snackbar");
            }

         }
      });
      this.pricePagerAdapter = new PriceActivity.PricePagerAdapter(this.getSupportFragmentManager());
      this.goodrxApi = GoodRxAPI.getInstance();
   }

   private void launchFromDeepLinks(String var1, final String var2) {
      GoodRxAPI.getInstance().getDrugDetail(this, var1, (String)null, (String)null, (Integer)null, false, new OnRequestFinishListener() {
         public void onSuccess(String var1) {
            JsonObject var2x = (new JsonParser()).parse(var1).getAsJsonObject();
            PriceActivity.this.drugSlug = var2x.getAsJsonPrimitive("drug_slug").getAsString();
            PriceActivity.this.formSlug = var2x.getAsJsonPrimitive("form").getAsString();
            PriceActivity.this.dosageSlug = var2x.getAsJsonPrimitive("dosage").getAsString();
            PriceActivity.this.quantity = var2x.getAsJsonPrimitive("quantity").getAsInt();
            PriceActivity.this.drugId = var2x.getAsJsonPrimitive("id").getAsString();
            PriceActivity.this.initTab = var2;
            PriceActivity.this.initData();
         }
      });
   }

   public void addRx(String var1, int var2) {
      final MyProgressBar var3 = (MyProgressBar)this.findViewById(2131886399);
      var3.show();
      this.btnAdd.hide();
      GoodRxAPI.getInstance().addRx(this, var1, var2, (String)null, (String)null, new OnRequestFinishListener() {
         public void onFailure(int var1, String var2) {
            super.onFailure(var1, var2);
            var3.dismiss();
            PriceActivity.this.btnAdd.show();
            PriceActivity.this.btnAdd.setEnabled(true);
         }

         public void onSuccess(String var1) {
            PriceActivity.this.btnAdd.setEnabled(false);
            PriceActivity.this.refreshRx();
         }
      });
   }

   public void getDrugInfo(String var1, String var2, String var3, int var4) {
      String var5 = "https://www.goodrx.com/mobile-api/v3/drug/" + var1;
      RequestParams var6 = new RequestParams();
      var6.put("form", var2);
      var6.put("dosage", var3);
      var6.put("quantity", var4);
      var6.put("drug_information", "1");
      var6.put("label_override", var1);
      this.myProgressBar.show();
      CacheHttpRequestHelper.getInstance().getUsingCache(var5, var6, 86400000L, new MyResponseHandler(this) {
         public void onSuccess(String var1) {
            PriceActivity var2 = PriceActivity.this;
            Gson var3 = new Gson();
            Object var4;
            if(!(var3 instanceof Gson)) {
               var4 = var3.fromJson(var1, DrugObject.class);
            } else {
               var4 = GsonInstrumentation.fromJson((Gson)var3, var1, DrugObject.class);
            }

            var2.drugObject = (DrugObject)var4;
            PriceActivity.this.updateUI();
         }
      });
   }

   public void initData() {
      super.initData();
      this.getDrugInfo(this.drugSlug, this.formSlug, this.dosageSlug, this.quantity);
   }

   public void initTabLayout() {
      DrugInformation var1 = this.drugObject.getDrug_information();
      boolean var2;
      if(var1.getTip_count() > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var3 = var1.isEducation_available();
      int var4 = var1.getImage_count();
      int var5 = var1.getNews_count();
      ArrayList var6 = new ArrayList();
      var6.add(this.getString(2131427765));
      if(var2) {
         var6.add(this.getString(2131427926));
      }

      if(var5 > 0) {
         var6.add(this.getString(2131427676));
      }

      if(var3 || var4 > 0) {
         var6.add(this.getString(2131427624));
      }

      this.pricePagerAdapter.setTitles(var6);
      this.viewPager.setAdapter(this.pricePagerAdapter);
      TabLayout var9 = (TabLayout)this.findViewById(2131886321);
      var9.setupWithViewPager(this.viewPager);
      if(var6.size() < 2) {
         var9.setVisibility(8);
      }

      if(this.initTab != null) {
         int var10 = var6.indexOf(this.initTab);
         if(var10 > 0 && var10 < var6.size()) {
            this.viewPager.setCurrentItem(var10);
         }
      }

   }

   public void onAddButtonClicked(View var1) {
      this.addRx(this.drugId, this.quantity);
   }

   protected void onCreate(Bundle var1) {
      this.setView(2130968633);
      super.onCreate(var1);
      this.initComponents();
      Intent var2 = this.getIntent();
      if("android.intent.action.VIEW".equals(var2.getAction()) && var2.getData() != null) {
         UriMatcher var4 = new UriMatcher(-1);
         this.addUriToMatcher(var4, "/*/what-is", 1);
         this.addUriToMatcher(var4, "/*/savings-tips", 2);
         this.addUriToMatcher(var4, "/*/latest-news", 3);
         Uri var5 = var2.getData();
         int var6 = var4.match(var5);
         if(var6 == 1) {
            this.initTab = this.getString(2131427624);
         } else if(var6 == 2) {
            this.initTab = this.getString(2131427926);
         } else if(var6 == 3) {
            this.initTab = this.getString(2131427676);
         }

         this.drugSlug = (String)var5.getPathSegments().get(0);
         this.launchFromDeepLinks(this.drugSlug, this.initTab);
         this.shouldOverrideBackAnimation(false);
      } else {
         Bundle var3 = this.getIntent().getExtras();
         this.drugId = var3.getString("drug_id");
         this.drugSlug = var3.getString("drug_slug");
         this.formSlug = var3.getString("form_slug");
         this.dosageSlug = var3.getString("dosage_slug");
         this.quantity = var3.getInt("quantity");
         this.initData();
      }
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131951625, var1);
      return true;
   }

   @Subscribe
   public void onEvent(String var1) {
      if(var1.equals("addRxSuccess")) {
         this.btnAdd.hide();
         this.btnAdd.setEnabled(false);
      }

   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      int var2 = var1.getItemId();
      if(var2 == 16908332) {
         MainActivity.launchClearTop(this);
         return true;
      } else if(var2 == 2131886791) {
         SearchActivity.launch(this);
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   protected void onResume() {
      super.onResume();
      if(MyRxUtils.containsRx(this, this.drugId)) {
         this.btnAdd.setVisibility(8);
         this.btnAdd.setEnabled(false);
      }

   }

   public void refreshRx() {
      this.goodrxApi.getRx(this, new OnRequestFinishListener() {
         public void onSuccess(MyRx[] var1) {
            PriceActivity.this.myProgressBar.dismiss();
            AlertDialog.Builder var2 = new AlertDialog.Builder(PriceActivity.this);
            var2.setTitle(2131427415);
            String var4 = PriceActivity.this.getString(2131427414);
            Object[] var5 = new Object[]{WordUtils.capitalize(PriceActivity.this.drugObject.getDisplay())};
            var2.setMessage(Html.fromHtml(String.format(var4, var5)));
            var2.setPositiveButton(2131427709, (OnClickListener)null);
            DialogHelper.showDialog(var2);
            MyRxUtils.saveRx(PriceActivity.this, var1);
         }
      });
   }

   public void updateUI() {
      ActionBar var1 = this.getSupportActionBar();
      if(var1 != null) {
         var1.setDisplayShowTitleEnabled(true);
         var1.setTitle(this.drugObject.getDisplay());
         if(!this.drugObject.isAddable()) {
            this.btnAdd.hide();
            this.btnAdd.setEnabled(false);
         }

         this.initTabLayout();
         this.myProgressBar.dismiss();
      }
   }

   private class PricePagerAdapter extends FragmentPagerAdapter {
      private ArrayList<String> titles = new ArrayList(0);

      public PricePagerAdapter(FragmentManager var2) {
         super(var2);
      }

      public int getCount() {
         return this.titles.size();
      }

      public Fragment getItem(int var1) {
         if(((String)this.titles.get(var1)).equals(PriceActivity.this.getString(2131427765))) {
            BaseFragmentWitGA var8 = PriceFragmentFactory.create(PriceActivity.this.drugObject);
            var8.enableScreenViewTracking(PriceActivity.this.getString(2131427855));
            return var8;
         } else if(((String)this.titles.get(var1)).equals(PriceActivity.this.getString(2131427926))) {
            SavingsFragment var7 = SavingsFragment.newInstance(PriceActivity.this.drugObject);
            var7.enableScreenViewTracking(PriceActivity.this.getString(2131427862));
            return var7;
         } else if(((String)this.titles.get(var1)).equals(PriceActivity.this.getString(2131427676))) {
            NewsFragment var6 = NewsFragment.newInstance(PriceActivity.this.drugSlug);
            var6.enableScreenViewTracking(PriceActivity.this.getString(2131427847));
            return var6;
         } else {
            DrugInformation var2 = PriceActivity.this.drugObject.getDrug_information();
            var2.getNews_count();
            int var4 = var2.getImage_count();
            InfoFragment var5 = InfoFragment.newInstance(PriceActivity.this.drugSlug, PriceActivity.this.formSlug, PriceActivity.this.dosageSlug, 0, var4);
            var5.enableScreenViewTracking(PriceActivity.this.getString(2131427841));
            return var5;
         }
      }

      public CharSequence getPageTitle(int var1) {
         return (CharSequence)this.titles.get(var1);
      }

      public void setTitles(ArrayList<String> var1) {
         this.titles = var1;
         this.notifyDataSetChanged();
      }
   }
}
