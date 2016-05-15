package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import com.goodrx.utils.CacheHttpRequestHelper;
import com.goodrx.utils.MyResponseHandler;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.MyProgressBar;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.RequestParams;

public class BlogDetailActivity extends BaseActivityWithPasscode {
   private MyProgressBar mProgressBar;
   private WebView mWebView;

   public static void launch(Activity var0, String var1) {
      Intent var2 = new Intent(var0, BlogDetailActivity.class);
      var2.putExtra("slug", var1);
      var0.startActivity(var2);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   public void getBlogContent(String var1) {
      this.mProgressBar.show();
      CacheHttpRequestHelper.getInstance().getUsingCache("https://www.goodrx.com/mobile-api/v3/blog/" + var1, (RequestParams)null, 86400000L, new MyResponseHandler(this) {
         public void onSuccess(String var1) {
            JsonObject var2 = (new JsonParser()).parse(var1).getAsJsonObject();
            String var3 = var2.getAsJsonPrimitive("title").getAsString();
            BlogDetailActivity.this.getSupportActionBar().setTitle(var3);
            String var4 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n<html>\n<body><style>p, li { font-family: arial; } p {padding: 5px 10px; } ul, li {margin:0px 10px 0 15px; padding:0px; }</style>" + "<p><font size=4><b>" + var3 + "</b></font></p>";
            String var5 = var4 + var2.getAsJsonPrimitive("content").getAsString();
            BlogDetailActivity.this.mWebView.loadDataWithBaseURL((String)null, var5, "text/html", "utf-8", (String)null);
            BlogDetailActivity.this.mProgressBar.dismiss();
         }
      });
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427864);
      this.setContentView(2130968607);
      this.mWebView = (WebView)this.findViewById(2131886256);
      this.mProgressBar = (MyProgressBar)this.findViewById(2131886399);
      Intent var2 = this.getIntent();
      String var3 = var2.getAction();
      Uri var4 = var2.getData();
      String var5;
      if("android.intent.action.VIEW".equals(var3) && var4 != null) {
         var5 = (String)var4.getPathSegments().get(1);
         this.shouldOverrideBackAnimation(false);
      } else {
         var5 = var2.getStringExtra("slug");
      }

      this.getBlogContent(var5);
   }
}
