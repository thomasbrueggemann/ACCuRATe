package com.goodrx.activity.store;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.goodrx.model.PharmacyObject;
import com.goodrx.model.Price;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.Utils;

public class AffiliateView extends FrameLayout implements OnClickListener {
   private Price mPrice;

   public AffiliateView(Context var1, Price var2, PharmacyObject var3) {
      super(var1);
      this.mPrice = var2;
      View var4 = LayoutInflater.from(var1).inflate(2130968772, this);
      TextView var5 = (TextView)var4.findViewById(2131886666);
      View var6 = var4.findViewById(2131886667);
      TextView var7 = (TextView)var4.findViewById(2131886668);
      TextView var8 = (TextView)var4.findViewById(2131886670);
      TextView var9 = (TextView)var4.findViewById(2131886671);
      Button var10 = (Button)var4.findViewById(2131886669);
      var5.setText(Utils.formatPrice(Double.valueOf(var2.getPrice())));
      String var11 = var3.getDisclaimer();
      if(var11 != null && var11.length() != 0 && !var11.equalsIgnoreCase("null")) {
         var7.setText(Html.fromHtml(var3.getDisclaimer()));
      } else {
         var6.setVisibility(8);
      }

      String var12 = var1.getString(2131427400);
      Object[] var13 = new Object[]{var3.getName()};
      var8.setText(String.format(var12, var13));
      var9.setText(var3.getInfo());
      String var14 = var1.getString(2131428019);
      Object[] var15 = new Object[]{var3.getName()};
      var10.setText(String.format(var14, var15));
      var10.setOnClickListener(this);
   }

   public void onClick(View var1) {
      DialogHelper.showDialog(DialogHelper.openExternalWebsite(this.getContext(), this.mPrice.getUrl()));
   }
}
