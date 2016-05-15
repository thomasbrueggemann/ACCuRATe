package com.goodrx.widget.ConfigureItem;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import com.goodrx.widget.ConfigureItem.ConfigureItem;

public class DrugNameItem extends ConfigureItem {
   public DrugNameItem(Context var1) {
      super(var1);
      this.initTextStyle();
   }

   public DrugNameItem(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.initTextStyle();
   }

   public DrugNameItem(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.initTextStyle();
   }

   public void initTextStyle() {
      this.txtTitle.setTextSize(0, this.getResources().getDimension(2131558452));
      this.txtTitle.setTextColor(ContextCompat.getColor(this.getContext(), 17170444));
      this.txtTitle.setTypeface(Typeface.create("sans-serif-medium", 0));
      this.txtContent.setTextSize(0, this.getResources().getDimension(2131558454));
      this.txtContent.setTextColor(ContextCompat.getColor(this.getContext(), 2131755084));
      this.txtContent.setTypeface(Typeface.DEFAULT);
   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      if(var1) {
         this.txtTitle.setTextColor(ContextCompat.getColor(this.getContext(), 2131755124));
         this.txtContent.setTextColor(ContextCompat.getColor(this.getContext(), 2131755134));
      } else {
         this.txtTitle.setTextColor(ContextCompat.getColor(this.getContext(), 2131755079));
      }

      this.setStepperEnabled(false);
   }

   public void setHideContent(boolean var1) {
      if(var1) {
         this.txtContent.setVisibility(8);
      } else {
         this.txtContent.setVisibility(0);
      }
   }

   public void setTitle(String var1) {
      this.txtTitle.setText(var1);
   }
}
