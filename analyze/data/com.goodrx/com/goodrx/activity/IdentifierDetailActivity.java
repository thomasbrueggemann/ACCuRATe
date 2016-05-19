package com.goodrx.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.goodrx.activity.configure.PrescriptionConfigureActivity;
import com.goodrx.model.Pill;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import org.apache.commons.lang3.text.WordUtils;

public class IdentifierDetailActivity extends BaseActivityWithPasscode {
   private View contentView;
   private ImageView imageView;

   public void onBackPressed() {
      super.onBackPressed();
      this.overridePendingTransition(2131034141, 2131034137);
   }

   public void onButtonClicked(View var1) {
      Intent var2 = this.getIntent();
      PrescriptionConfigureActivity.launch(this, var2.getStringExtra("slug"), true, var2.getStringExtra("form"), var2.getStringExtra("dosage"), (Integer)null);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427852);
      this.setContentView(2130968615);
      this.shouldOverrideBackAnimation(false);
      String var2 = this.getIntent().getStringExtra("title");
      String var3 = this.getIntent().getStringExtra("drug_name");
      String var4 = this.getIntent().getStringExtra("pills");
      Gson var5 = new Gson();
      Object var6;
      if(!(var5 instanceof Gson)) {
         var6 = var5.fromJson(var4, Pill[].class);
      } else {
         var6 = GsonInstrumentation.fromJson((Gson)var5, var4, Pill[].class);
      }

      Pill[] var7 = (Pill[])var6;
      String var8 = var7[0].getDisplay();
      String var9 = var7[0].getAttribute_text();
      String var10 = var7[0].getImage();
      this.getSupportActionBar().setTitle(var2);
      this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
      String var11;
      if(var8.toLowerCase().indexOf(var3.toLowerCase()) == 0) {
         String var20 = var8.substring(1 + var3.length());
         var11 = "<b>" + WordUtils.capitalize(var3) + "</b>&nbsp;" + var20;
      } else {
         var11 = "<b>" + var8 + "</b>";
      }

      ((TextView)this.findViewById(2131886274)).setText(Html.fromHtml(var11));
      ((TextView)this.findViewById(2131886275)).setText(var9);
      TextView var12 = (TextView)this.findViewById(2131886276);
      TextView var13 = (TextView)this.findViewById(2131886277);
      if(var7.length > 1) {
         var12.setVisibility(0);
         var13.setVisibility(0);
         var12.setText(2131427715);
         StringBuilder var17 = new StringBuilder();

         for(int var18 = 1; var18 < var7.length; ++var18) {
            var17.append(var7[var18].getManufacturer()).append("<br/>");
         }

         var13.setText(Html.fromHtml(var17.toString()));
      } else {
         var12.setVisibility(8);
         var13.setVisibility(8);
      }

      this.imageView = (ImageView)this.findViewById(2131886273);
      final MyProgressBar var14 = (MyProgressBar)this.findViewById(2131886399);
      var14.show();
      this.contentView = this.findViewById(2131886272);
      ImageLoader var15 = ImageLoader.getInstance();
      SimpleImageLoadingListener var16 = new SimpleImageLoadingListener() {
         public void onLoadingComplete(String var1, View var2, Bitmap var3) {
            super.onLoadingComplete(var1, var2, var3);
            IdentifierDetailActivity.this.imageView.setImageBitmap(var3);
            var14.dismiss();
            IdentifierDetailActivity.this.contentView.setVisibility(0);
         }
      };
      var15.loadImage(var10, var16);
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131951619, var1);
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1.getItemId() == 2131886788) {
         this.onBackPressed();
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }
}
