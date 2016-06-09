package com.goodrx.activity.price;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import com.goodrx.activity.ReminderSettingFragment;
import com.goodrx.activity.RxEditActivity;
import com.goodrx.activity.SearchActivity;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.activity.price.ActivityWithCoupon;
import com.goodrx.activity.price.InfoFragment;
import com.goodrx.activity.price.NewsFragment;
import com.goodrx.activity.price.RxPriceListFragment;
import com.goodrx.activity.price.SavingsFragment;
import com.goodrx.model.DrugInformation;
import com.goodrx.model.DrugObject;
import com.goodrx.model.MyRx;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.utils.MyRxUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.loopj.android.http.RequestParams;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

public class RxPriceActivity extends ActivityWithCoupon {
   private String dosageSlug;
   private DrugObject drugObject;
   private String drugSlug;
   private String formSlug;
   private MyRx myRx;
   private String parseType = "";
   private RxPriceActivity.PricePagerAdapter pricePagerAdapter;
   private ViewPager viewPager;

   public static void launch(Activity var0, String var1) {
      Intent var2 = new Intent(var0, RxPriceActivity.class);
      var2.putExtra("rx_json", var1);
      var0.startActivity(var2);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   public static void launchWithParse(Activity var0, String var1, String var2) {
      Intent var3 = new Intent(var0, RxPriceActivity.class);
      var3.putExtra("drug_id", var1);
      var3.putExtra("com.parse.Data", var2);
      var0.startActivity(var3);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   private void openRxEditActivity() {
      Intent var1 = new Intent(this, RxEditActivity.class);
      Bundle var2 = new Bundle();
      var2.putString("calling_activity", RxPriceActivity.class.getName());
      var2.putString("slug", this.drugSlug);
      var2.putString("form_slug", this.formSlug);
      var2.putString("dosage_slug", this.dosageSlug);
      var2.putInt("quantity", this.quantity);
      var1.putExtras(var2);
      this.startActivity(var1);
      this.overridePendingTransition(2131034132, 2131034140);
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
            RxPriceActivity var2 = RxPriceActivity.this;
            Gson var3 = new Gson();
            Object var4;
            if(!(var3 instanceof Gson)) {
               var4 = var3.fromJson(var1, DrugObject.class);
            } else {
               var4 = GsonInstrumentation.fromJson((Gson)var3, var1, DrugObject.class);
            }

            var2.drugObject = (DrugObject)var4;
            RxPriceActivity.this.updateUI();
         }
      });
   }

   public void initComponents(MyRx var1) {
      if(var1 != null) {
         this.drugSlug = var1.getSlug().getDrug();
         this.formSlug = var1.getSlug().getDrug_form();
         this.dosageSlug = var1.getSlug().getDosage();
         this.quantity = var1.getDrug().getQuantity();
         this.viewPager = (ViewPager)this.findViewById(2131886344);
         this.pricePagerAdapter = new RxPriceActivity.PricePagerAdapter(this.getSupportFragmentManager());
         MyRx.Drug var2 = var1.getDrug();
         this.getSupportActionBar().setTitle(var2.getSelected_drug());
         this.viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            public void onPageSelected(int var1) {
               super.onPageSelected(var1);
               if(var1 != 0) {
                  EventBus.getDefault().post("dismiss_snackbar");
               }

            }
         });
      }
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
      var6.add(this.getString(2131427794));
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
      ((TabLayout)this.findViewById(2131886321)).setupWithViewPager(this.viewPager);
      int var10 = -1;
      if(this.parseType.equalsIgnoreCase("savings_alert")) {
         var10 = var6.indexOf(this.getString(2131427926));
      } else if(this.parseType.equalsIgnoreCase("news_alert")) {
         var10 = var6.indexOf(this.getString(2131427676));
      }

      if(this.getIntent().hasExtra("default_page")) {
         var10 = var6.indexOf(this.getIntent().getStringExtra("default_page"));
      }

      if(var10 > 0 && var10 < var6.size()) {
         this.viewPager.setCurrentItem(var10);
      }

   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if(var2 == -1) {
         if(var1 == 9) {
            String var5 = var3.getStringExtra("my_rx");
            Gson var6 = new Gson();
            Object var7;
            if(!(var6 instanceof Gson)) {
               var7 = var6.fromJson(var5, MyRx.class);
            } else {
               var7 = GsonInstrumentation.fromJson((Gson)var6, var5, MyRx.class);
            }

            this.myRx = (MyRx)var7;
            return;
         }

         if(var1 == 11) {
            String var4 = var3.getStringExtra("image_url");
            this.myRx.getDrug().setImage(var4);
            return;
         }
      }

   }

   public void onBackPressed() {
      if(this.getIntent().getBooleanExtra("create_back_stack", false)) {
         MainActivity.launchClearTop(this);
         this.finish();
      }

      super.onBackPressed();
   }

   protected void onCreate(Bundle var1) {
      this.setView(2130968636);
      super.onCreate(var1);
      ActionBar var2 = this.getSupportActionBar();
      var2.setDisplayShowTitleEnabled(true);
      var2.setHomeAsUpIndicator(2130837666);
      Intent var3 = this.getIntent();
      if(var3.hasExtra("rx_json")) {
         String var8 = this.getIntent().getStringExtra("rx_json");
         Gson var9 = new Gson();
         Object var10;
         if(!(var9 instanceof Gson)) {
            var10 = var9.fromJson(var8, MyRx.class);
         } else {
            var10 = GsonInstrumentation.fromJson((Gson)var9, var8, MyRx.class);
         }

         this.myRx = (MyRx)var10;
      } else if(var3.hasExtra("drug_id")) {
         try {
            this.myRx = MyRxUtils.findRxByDrugId(this, var3.getStringExtra("drug_id"));
            if(var3.hasExtra("com.parse.Data")) {
               String var7 = var3.getStringExtra("com.parse.Data");
               this.parseType = (new JsonParser()).parse(var7).getAsJsonObject().getAsJsonPrimitive("type").getAsString();
            }
         } catch (Exception var11) {
            ;
         }
      }

      if(this.myRx == null) {
         Intent var5 = new Intent(this, MainActivity.class);
         var5.setFlags(335544320);
         this.startActivity(var5);
         this.finish();
      } else {
         this.drugId = this.myRx.getDrug().getDrug_id();
         this.initComponents(this.myRx);
         this.initData();
      }
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131951623, var1);
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      int var2 = var1.getItemId();
      if(var2 == 2131886790) {
         this.openRxEditActivity();
         return true;
      } else if(var2 == 2131886791) {
         SearchActivity.launch(this);
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   public void updateUI() {
      this.initTabLayout();
      this.myProgressBar.dismiss();
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
         if(((String)this.titles.get(var1)).equals(RxPriceActivity.this.getString(2131427765))) {
            RxPriceListFragment var10 = RxPriceListFragment.newInstance(RxPriceActivity.this.drugObject);
            var10.enableScreenViewTracking(RxPriceActivity.this.getString(2131427856));
            return var10;
         } else if(((String)this.titles.get(var1)).equals(RxPriceActivity.this.getString(2131427794))) {
            Gson var2 = new Gson();
            MyRx var3 = RxPriceActivity.this.myRx;
            String var4;
            if(!(var2 instanceof Gson)) {
               var4 = var2.toJson((Object)var3);
            } else {
               var4 = GsonInstrumentation.toJson((Gson)var2, (Object)var3);
            }

            ReminderSettingFragment var5 = ReminderSettingFragment.newInstance(var4);
            var5.enableScreenViewTracking(RxPriceActivity.this.getString(2131427859));
            return var5;
         } else if(((String)this.titles.get(var1)).equals(RxPriceActivity.this.getString(2131427926))) {
            SavingsFragment var9 = SavingsFragment.newInstance(RxPriceActivity.this.drugObject);
            var9.enableScreenViewTracking(RxPriceActivity.this.getString(2131427863));
            return var9;
         } else if(((String)this.titles.get(var1)).equals(RxPriceActivity.this.getString(2131427676))) {
            NewsFragment var8 = NewsFragment.newInstance(RxPriceActivity.this.drugSlug);
            var8.enableScreenViewTracking(RxPriceActivity.this.getString(2131427848));
            return var8;
         } else {
            int var6 = RxPriceActivity.this.drugObject.getDrug_information().getImage_count();
            InfoFragment var7 = InfoFragment.newInstance(RxPriceActivity.this.drugSlug, RxPriceActivity.this.formSlug, RxPriceActivity.this.dosageSlug, 0, var6);
            var7.enableScreenViewTracking(RxPriceActivity.this.getString(2131427842));
            return var7;
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
