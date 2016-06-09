package com.goodrx.activity.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.goodrx.model.Price;
import com.goodrx.utils.Utils;

public class PriceWithCouponView extends FrameLayout {
   public PriceWithCouponView(Context var1, Price var2, boolean var3, OnClickListener var4) {
      super(var1);
      LayoutInflater.from(var1).inflate(2130968787, this);
      Button var6 = (Button)this.findViewById(2131886711);
      var6.setOnClickListener(var4);
      TextView var7 = (TextView)this.findViewById(2131886706);
      TextView var8 = (TextView)this.findViewById(2131886707);
      TextView var9 = (TextView)this.findViewById(2131886709);
      TextView var10 = (TextView)this.findViewById(2131886710);
      LinearLayout var11 = (LinearLayout)this.findViewById(2131886708);
      if(var3) {
         var7.setText(2131427763);
         var6.setText(2131428014);
      }

      var8.setText(Utils.formatPrice(Double.valueOf(var2.getPrice())));
      String var12 = var2.getSavings_percent();
      String var13 = null;
      if(var12 != null) {
         var13 = var2.getSavings_percent();
      }

      if(var13 != null && var13.length() != 0 && !var13.equals("null")) {
         int var19 = (int)Math.round(var2.getPrice() + var2.getSavings().doubleValue());
         String var20 = this.getResources().getString(2131427820);
         Object[] var21 = new Object[]{var13, "$" + var19};
         var10.setText(String.format(var20, var21));
      } else {
         var10.setVisibility(8);
      }

      if(var2.getOther_price_fields() == null) {
         var8.setVisibility(0);
         var9.setVisibility(8);
         var11.setVisibility(8);
      } else {
         var8.setVisibility(8);
         var9.setVisibility(0);
         var11.setVisibility(0);
         String[][] var14 = var2.getOther_price_fields();

         for(int var15 = 0; var15 < var14.length; ++var15) {
            View var16 = LayoutInflater.from(var1).inflate(2130968720, var11, false);
            TextView var17 = (TextView)var16.findViewById(2131886564);
            TextView var18 = (TextView)var16.findViewById(2131886565);
            var17.setText(var14[var15][0] + " days");
            var18.setText(Utils.formatPrice(Double.valueOf(Double.parseDouble(var14[var15][1]))));
            var11.addView(var16);
         }
      }

   }
}
