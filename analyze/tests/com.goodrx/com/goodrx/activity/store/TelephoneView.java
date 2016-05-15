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
import com.goodrx.utils.Utils;

public class TelephoneView extends FrameLayout implements OnClickListener {
   private PharmacyObject mPharmacyObject;
   private Price mPrice;

   public TelephoneView(Context var1, Price var2, PharmacyObject var3) {
      super(var1);
      this.mPrice = var2;
      this.mPharmacyObject = var3;
      View var4 = LayoutInflater.from(var1).inflate(2130968796, this);
      TextView var5 = (TextView)var4.findViewById(2131886739);
      TextView var6 = (TextView)var4.findViewById(2131886742);
      TextView var7 = (TextView)var4.findViewById(2131886740);
      TextView var8 = (TextView)var4.findViewById(2131886743);
      TextView var9 = (TextView)var4.findViewById(2131886744);
      Button var10 = (Button)var4.findViewById(2131886741);
      var5.setText(Utils.formatPrice(Double.valueOf(var2.getPrice())));
      String var11 = var1.getString(2131428031);
      Object[] var12 = new Object[]{var2.getPhone()};
      var6.setText(String.format(var11, var12));
      var7.setText(Html.fromHtml(var3.getDisclaimer()));
      String var13 = var1.getString(2131427400);
      Object[] var14 = new Object[]{var3.getName()};
      var8.setText(String.format(var13, var14));
      var9.setText(var3.getInfo());
      var10.setOnClickListener(this);
   }

   public void onClick(View var1) {
      String var2 = this.getContext().getString(2131427451);
      Object[] var3 = new Object[]{this.mPharmacyObject.getName()};
      String var4 = String.format(var2, var3);
      Utils.makeCall(this.getContext(), (String)null, var4, this.mPrice.getPhone());
   }
}
