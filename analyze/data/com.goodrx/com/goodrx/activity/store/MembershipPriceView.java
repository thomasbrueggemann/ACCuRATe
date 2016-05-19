package com.goodrx.activity.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.goodrx.model.Price;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.Utils;

public class MembershipPriceView extends FrameLayout {
   public MembershipPriceView(final Context var1, Price var2) {
      super(var1);
      LayoutInflater.from(var1).inflate(2130968783, this);
      TextView var4 = (TextView)this.findViewById(2131886434);
      TextView var5 = (TextView)this.findViewById(2131886435);
      var4.setText(Utils.formatPrice(Double.valueOf(var2.getPrice())));
      String[] var6 = var2.getDiscount_program_description().split("\\.");
      var5.setText(var6[-1 + var6.length].trim());
      final String var7 = var2.getDiscount_program_url();
      ((Button)this.findViewById(2131886700)).setOnClickListener(new OnClickListener() {
         public void onClick(View var1x) {
            DialogHelper.showDialog(DialogHelper.openExternalWebsite(var1, var7));
         }
      });
   }
}
