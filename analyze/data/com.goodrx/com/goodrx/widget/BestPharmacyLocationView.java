package com.goodrx.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;

public abstract class BestPharmacyLocationView extends FrameLayout {
   public BestPharmacyLocationView(Context var1, final int var2, String var3, double var4) {
      super(var1);
      LayoutInflater.from(var1).inflate(2130968714, this);
      TextView var7 = (TextView)this.findViewById(2131886546);
      TextView var8 = (TextView)this.findViewById(2131886548);
      var7.setText(var3);
      Object[] var9 = new Object[]{Double.valueOf(var4)};
      String var10 = String.format("%.1f", var9);
      if(var10.equals("0.0")) {
         var10 = "0.1";
      }

      if(!var10.equals("1") && !var10.equals("1.0")) {
         var8.setText(var10 + " miles");
      } else {
         var8.setText(var10 + " mile");
      }

      this.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BestPharmacyLocationView.this.onClicked(var2);
         }
      });
   }

   public abstract void onClicked(int var1);
}
