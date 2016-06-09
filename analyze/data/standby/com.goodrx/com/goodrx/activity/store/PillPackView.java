package com.goodrx.activity.store;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.goodrx.model.Price;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.Utils;

public class PillPackView extends FrameLayout {
   public PillPackView(final Context var1, String var2, final Price var3) {
      super(var1);
      View var4 = LayoutInflater.from(var1).inflate(2130968786, this);
      TextView var5 = (TextView)var4.findViewById(2131886702);
      TextView var6 = (TextView)var4.findViewById(2131886704);
      Button var7 = (Button)var4.findViewById(2131886703);
      double var8 = var3.getPrice();
      var5.setText(Utils.formatPrice(Double.valueOf(var8)));
      String var10 = var1.getString(2131427448);
      Object[] var11 = new Object[]{Utils.formatPrice(Double.valueOf(var8))};
      var7.setText(String.format(var10, var11));
      var7.setOnClickListener(new OnClickListener() {
         public void onClick(View var1x) {
            DialogHelper.showDialog(DialogHelper.openExternalWebsite(var1, var3.getUrl()));
         }
      });
      if(var2 != null && var2.length() != 0) {
         var6.setVisibility(0);
         var6.setText(Html.fromHtml(var2));
      } else {
         var6.setVisibility(8);
      }
   }
}
