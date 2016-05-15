package com.goodrx.widget.MyRx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MyRxDrugNameView extends FrameLayout {
   private String drugName;
   private ImageView imgChecked;

   public MyRxDrugNameView(Context var1, String var2) {
      super(var1);
      this.drugName = var2;
      this.init(var1);
   }

   public void init(Context var1) {
      View var2 = LayoutInflater.from(var1).inflate(2130968788, this, true);
      ((TextView)var2.findViewById(2131886713)).setText(this.drugName);
      this.imgChecked = (ImageView)var2.findViewById(2131886712);
   }

   public boolean isChecked() {
      return this.imgChecked.getVisibility() == 0;
   }

   public void setChecked(boolean var1) {
      if(var1) {
         this.imgChecked.setVisibility(0);
      } else {
         this.imgChecked.setVisibility(8);
      }
   }
}
