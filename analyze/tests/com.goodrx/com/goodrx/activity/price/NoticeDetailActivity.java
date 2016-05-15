package com.goodrx.activity.price;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.goodrx.model.Notice;
import com.goodrx.widget.BaseActivityWithPasscode;
import org.parceler.Parcels;

public class NoticeDetailActivity extends BaseActivityWithPasscode {
   private String formatNotice(Notice var1) {
      String var2 = var1.getLong_description();
      if(var2 == null || var2.length() == 0) {
         var2 = var1.getShort_description();
      }

      StringBuilder var3 = new StringBuilder("<!DOCTYPE HTML>");
      var3.append("<head><style>body{margin-top:5%; margin-left:5%; margin-right:5%;}ul{padding-left:1.5em}li{margin-bottom:1.5em}a{color:#2196F3;text-decoration:none;text-transform:uppercase;font-size:0.8em;font-weight:600;margin-top:1.1em}</style></head><body>");
      var3.append(var2);
      if(var1.getLink() != null) {
         var3.append("<br/><a href=\"").append(var1.getLink()).append("\">").append(var1.getLink_text()).append("</a>");
      }

      var3.append("</body>");
      return var3.toString();
   }

   public static void launch(Activity var0, Notice var1) {
      Intent var2 = new Intent(var0, NoticeDetailActivity.class);
      var2.putExtra("notice", Parcels.wrap(var1));
      var0.startActivity(var2);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427850);
      this.shouldOverrideBackAnimation(false);
      this.setContentView(2130968624);
      Notice var2 = (Notice)Parcels.unwrap(this.getIntent().getParcelableExtra("notice"));
      this.getSupportActionBar().setTitle(var2.getTitle());
      ((WebView)this.findViewById(2131886256)).loadDataWithBaseURL((String)null, this.formatNotice(var2), "text/html", "utf-8", (String)null);
   }
}
