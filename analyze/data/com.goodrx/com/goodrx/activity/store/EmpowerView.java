package com.goodrx.activity.store;

import android.content.Context;
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

public class EmpowerView extends FrameLayout implements OnClickListener {
   private Price mPrice;

   public EmpowerView(Context var1, Price var2, PharmacyObject var3) {
      super(var1);
      this.mPrice = var2;
      View var4 = LayoutInflater.from(var1).inflate(2130968777, this);
      TextView var5 = (TextView)var4.findViewById(2131886666);
      TextView var6 = (TextView)var4.findViewById(2131886670);
      TextView var7 = (TextView)var4.findViewById(2131886671);
      Button var8 = (Button)var4.findViewById(2131886669);
      var5.setText(Utils.formatPrice(Double.valueOf(var2.getPrice())));
      String var9 = var1.getString(2131427400);
      Object[] var10 = new Object[]{var3.getName()};
      var6.setText(String.format(var9, var10));
      var7.setText(var3.getInfo());
      String var11 = var1.getString(2131428019);
      Object[] var12 = new Object[]{var3.getName()};
      var8.setText(String.format(var11, var12));
      var8.setOnClickListener(this);
   }

   public void onClick(View var1) {
      DialogHelper.showDialog(DialogHelper.openExternalWebsite(this.getContext(), this.mPrice.getUrl()));
   }
}
