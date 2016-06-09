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

public class OnlinePriceView extends FrameLayout {
   public OnlinePriceView(final Context var1, Price var2) {
      super(var1);
      View var3 = LayoutInflater.from(var1).inflate(2130968783, this);
      TextView var4 = (TextView)var3.findViewById(2131886699);
      TextView var5 = (TextView)var3.findViewById(2131886434);
      TextView var6 = (TextView)var3.findViewById(2131886435);
      Button var7 = (Button)var3.findViewById(2131886700);
      var7.setText("Visit Website");
      var4.setText(2131427462);
      var5.setText(Utils.formatPrice(Double.valueOf(var2.getPrice())));
      String var8 = var1.getString(2131427985);
      Object[] var9 = new Object[]{var7.getText()};
      var6.setText(String.format(var8, var9));
      var7.setOnClickListener(new OnClickListener() {
         // $FF: synthetic field
         final String val$url;

         {
            this.val$url = var3;
         }

         public void onClick(View var1x) {
            DialogHelper.showDialog(DialogHelper.openExternalWebsite(var1, this.val$url));
         }
      });
   }
}
