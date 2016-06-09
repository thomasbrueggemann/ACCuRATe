package com.goodrx.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.goodrx.utils.Utils;

public class BestPharmacyDetailItem extends FrameLayout {
   private TextView txtAmount;
   private TextView txtDrugName;
   private TextView txtPrice;
   private TextView txtType;

   public BestPharmacyDetailItem(Context var1) {
      super(var1);
      this.init(var1);
   }

   public void hidePrice(boolean var1) {
      if(var1) {
         this.txtPrice.setVisibility(8);
      } else {
         this.txtPrice.setVisibility(0);
      }
   }

   public void init(Context var1) {
      View var2 = LayoutInflater.from(var1).inflate(2130968715, this, true);
      this.txtDrugName = (TextView)var2.findViewById(2131886550);
      this.txtAmount = (TextView)var2.findViewById(2131886551);
      this.txtPrice = (TextView)var2.findViewById(2131886552);
      this.txtType = (TextView)var2.findViewById(2131886553);
   }

   public void setAmount(String var1) {
      this.txtAmount.setText(var1);
   }

   public void setDrugName(String var1) {
      this.txtDrugName.setText(var1);
   }

   public void setPrice(double var1) {
      this.txtPrice.setText(Utils.formatPrice(Double.valueOf(var1)));
   }

   public void setType(String var1) {
      this.txtType.setText(var1);
   }
}
