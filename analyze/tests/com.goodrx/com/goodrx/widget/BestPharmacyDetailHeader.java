package com.goodrx.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BestPharmacyDetailHeader extends FrameLayout {
   private Button btnCoupon;
   private TextView txtTitle;

   public BestPharmacyDetailHeader(Context var1) {
      super(var1);
      this.init(var1);
   }

   public void init(Context var1) {
      View var2 = LayoutInflater.from(var1).inflate(2130968702, this, true);
      this.txtTitle = (TextView)var2.findViewById(2131886519);
      this.btnCoupon = (Button)var2.findViewById(2131886520);
      this.setButtonAvailable(false);
   }

   public void setButtonAvailable(boolean var1) {
      if(var1) {
         this.btnCoupon.setVisibility(0);
      } else {
         this.btnCoupon.setVisibility(8);
      }
   }

   public void setButtonText(String var1) {
      this.btnCoupon.setText(var1);
   }

   public void setOnButtonClickListener(OnClickListener var1) {
      this.btnCoupon.setOnClickListener(var1);
   }

   public void setTitle(String var1) {
      this.txtTitle.setText(var1);
   }
}
