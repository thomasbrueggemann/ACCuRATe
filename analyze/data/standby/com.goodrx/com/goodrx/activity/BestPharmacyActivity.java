package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import com.goodrx.activity.BestPharmacyAddressFormater;
import com.goodrx.activity.BestPharmacyDetailActivity;
import com.goodrx.activity.BestPharmacySettingActivity;
import com.goodrx.adapter.BestPharmacyAdapter;
import com.goodrx.model.BestPharmacy;
import com.goodrx.model.LocationEntity;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.Utils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.locations.LocationUtils;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.util.ArrayList;
import org.apache.commons.lang3.ArrayUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class BestPharmacyActivity extends BaseActivityWithPasscode {
   private BestPharmacyAdapter adapter;
   private BestPharmacy[] bestPharmacies;
   private GoodRxAPI goodRxAPI;
   private View headerView;
   private ListView listView;
   private View noLocationView;
   private TextView txtLocation;

   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, BestPharmacyActivity.class));
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   public static void launchWithTransition(Activity var0, View var1) {
      ArrayList var2 = new ArrayList();
      var2.add(Pair.create(var1, var0.getString(2131427992)));
      ActivityOptionsCompat var4 = ActivityOptionsCompat.makeSceneTransitionAnimation(var0, (Pair[])var2.toArray(new Pair[var2.size()]));
      ActivityCompat.startActivity(var0, new Intent(var0, BestPharmacyActivity.class), var4.toBundle());
   }

   private void openBestPharmacyDetailActivity(BestPharmacy var1) {
      Intent var2 = new Intent(this, BestPharmacyDetailActivity.class);
      Gson var3 = new Gson();
      String var4;
      if(!(var3 instanceof Gson)) {
         var4 = var3.toJson((Object)var1);
      } else {
         var4 = GsonInstrumentation.toJson((Gson)var3, (Object)var1);
      }

      var2.putExtra("pharmacy_json", var4);
      this.startActivity(var2);
      this.overridePendingTransition(2131034132, 2131034138);
   }

   private void openBestPharmacySettingActivity() {
      this.startActivityForResult(new Intent(this, BestPharmacySettingActivity.class), 8);
      this.overridePendingTransition(2131034132, 2131034140);
   }

   private void showInfoDialog() {
      View var1 = View.inflate(this, 2130968669, (ViewGroup)null);
      ((TextView)var1.findViewById(2131886421)).setText(2131428029);
      AlertDialog.Builder var2 = DialogHelper.dialogWithCustomViewBuilder(this, 2131428028, var1);
      var2.setPositiveButton(2131427537, (OnClickListener)null);
      DialogHelper.showDialog(var2);
   }

   public Spanned generateLocationHtml(int var1, int var2, String var3) {
      StringBuilder var4 = (new StringBuilder()).append("").append(" <b>");
      Resources var5 = this.getResources();
      Object[] var6 = new Object[]{Integer.valueOf(var1)};
      String var7 = var4.append(var5.getQuantityString(2131361812, var1, var6)).append("</b>").toString();
      String var8 = var7 + " within ";
      StringBuilder var9 = (new StringBuilder()).append(var8).append("<b>");
      Resources var10 = this.getResources();
      Object[] var11 = new Object[]{Integer.valueOf(var2)};
      String var12 = var9.append(var10.getQuantityString(2131361816, var2, var11)).append("</b>").toString();
      String var13 = var12 + " of ";
      return Html.fromHtml(var13 + "<b>" + var3 + "</b>");
   }

   public void getBestPharmacy() {
      final MyProgressBar var1 = (MyProgressBar)this.findViewById(2131886399);
      var1.show();
      this.goodRxAPI.getBestPharmacy(this, new OnRequestFinishListener() {
         public void onSuccess(BestPharmacy[] var1x) {
            var1.dismiss();
            BestPharmacyActivity.this.bestPharmacies = var1x;
            if(BestPharmacyActivity.this.bestPharmacies.length > 0) {
               MyRxUtils.saveBestPharmacy(BestPharmacyActivity.this, BestPharmacyActivity.this.bestPharmacies);
               MyRxUtils.saveBestPharmacyDistance(BestPharmacyActivity.this, (int)BestPharmacyActivity.this.bestPharmacies[0].getDistance());
            }

            BestPharmacyActivity.this.updateUI(BestPharmacyActivity.this.bestPharmacies);
         }
      });
   }

   public void initData() {
      super.initData();
      this.bestPharmacies = MyRxUtils.getBestpharmacies(this);
      this.updateUI(this.bestPharmacies);
      long var1 = MyRxUtils.getBestPharmacyUpdateTime(this);
      long var3 = (new DateTime(DateTimeZone.getDefault())).getMillis();
      if(this.bestPharmacies.length == 0 || var3 - var1 > 86400000L) {
         this.getBestPharmacy();
      }

   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if(var1 == 8) {
         if(var2 == -1) {
            this.getBestPharmacy();
            return;
         }

         if(var2 == 0) {
            LocationEntity var4 = MyRxUtils.getLocation(this);
            LocationEntity var5 = LocationUtils.getLocationEntity(this);
            if(var4 == null || var5 == null || var4.distanceTo(var5) > 2000.0D) {
               this.getBestPharmacy();
               return;
            }
         }
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427824);
      this.setContentView(2130968604);
      this.setSupportActionBar((Toolbar)this.findViewById(2131886238));
      this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      BestPharmacyActivity.ClickListener var2 = new BestPharmacyActivity.ClickListener(null);
      this.headerView = View.inflate(this, 2130968701, (ViewGroup)null);
      this.txtLocation = (TextView)this.headerView.findViewById(2131886517);
      View var3 = this.headerView.findViewById(2131886511);
      ImageButton var4 = (ImageButton)this.headerView.findViewById(2131886516);
      var3.setOnClickListener(var2);
      var4.setOnClickListener(var2);
      this.adapter = new BestPharmacyAdapter(this);
      this.listView = (ListView)this.findViewById(2131886242);
      this.listView.addHeaderView(this.headerView, (Object)null, false);
      this.listView.setHeaderDividersEnabled(false);
      this.listView.setFooterDividersEnabled(false);
      this.listView.setAdapter(this.adapter);
      this.listView.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            BestPharmacyActivity.this.openBestPharmacyDetailActivity(BestPharmacyActivity.this.bestPharmacies[var3]);
         }
      });
      this.noLocationView = this.findViewById(2131886243);
      ((TextView)this.findViewById(2131886244)).setOnClickListener(var2);
      this.goodRxAPI = GoodRxAPI.getInstance();
      this.initData();
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131951618, var1);
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1.getItemId() == 2131886787) {
         this.showInfoDialog();
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   public void updateListHeader(BestPharmacy var1) {
      TextView var2 = (TextView)this.headerView.findViewById(2131886513);
      TextView var3 = (TextView)this.headerView.findViewById(2131886514);
      TextView var4 = (TextView)this.headerView.findViewById(2131886518);
      var2.setText(var1.getName());
      var3.setText(Utils.formatPrice(Double.valueOf(var1.getTotal_price())));
      BestPharmacyAddressFormater.format(var4, var1);
   }

   public void updateUI(BestPharmacy[] var1) {
      if(var1 != null && var1.length != 0) {
         LocationEntity var2 = LocationUtils.getLocationEntity(this);
         if(var2 == null) {
            this.listView.setVisibility(8);
            this.noLocationView.setVisibility(0);
         } else {
            this.listView.setVisibility(0);
            this.noLocationView.setVisibility(8);
            this.updateListHeader(var1[0]);
            BestPharmacy[] var3 = (BestPharmacy[])ArrayUtils.remove((Object[])var1, 0);
            this.adapter.updateData(var3);
            int var4 = (int)var1[0].getDistance();
            this.txtLocation.setText(this.generateLocationHtml(MyRxUtils.getConsideredRxCount(this), var4, var2.getDisplay()));
         }
      } else {
         this.listView.setVisibility(4);
      }
   }

   private class ClickListener implements android.view.View.OnClickListener {
      private ClickListener() {
      }

      // $FF: synthetic method
      ClickListener(Object var2) {
         this();
      }

      public void onClick(View var1) {
         int var2 = var1.getId();
         if(var2 == 2131886511) {
            BestPharmacyActivity.this.openBestPharmacyDetailActivity(BestPharmacyActivity.this.bestPharmacies[0]);
         } else if(var2 == 2131886244 || var2 == 2131886516) {
            BestPharmacyActivity.this.openBestPharmacySettingActivity();
            return;
         }

      }
   }
}
