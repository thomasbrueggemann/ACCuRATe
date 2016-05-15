package com.goodrx.widget.ConfigureItem;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.goodrx.class_3;
import com.goodrx.widget.ConfigureItem.OnContentChangeListener;
import com.goodrx.widget.MyStepper.MyStepper;
import com.goodrx.widget.MyStepper.OnStepperClickListener;

public class ConfigureItem extends FrameLayout {
   protected String[] contentArray;
   protected OnContentChangeListener contentChangeListener;
   protected ImageView imgIndicator;
   protected int selectedIndex;
   protected MyStepper stepper;
   protected TextView txtContent;
   protected TextView txtTitle;

   public ConfigureItem(Context var1) {
      super(var1);
      this.init(var1);
   }

   public ConfigureItem(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
      this.setAttrs(var1, var2);
   }

   public ConfigureItem(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1);
      this.setAttrs(var1, var2);
   }

   public int getSelectedIndex() {
      return this.selectedIndex;
   }

   public void init(Context var1) {
      FrameLayout var2 = (FrameLayout)LayoutInflater.from(var1).inflate(2130968798, this, true);
      this.txtTitle = (TextView)var2.findViewById(2131886749);
      this.txtContent = (TextView)var2.findViewById(2131886750);
      this.stepper = (MyStepper)var2.findViewById(2131886748);
      if(!this.isInEditMode()) {
         this.stepper.setOnStepperClickListener(new OnStepperClickListener() {
            public void onStepperClicked(int var1, int var2) {
               ConfigureItem.this.setSelectedIndex(var2);
               if(ConfigureItem.this.contentChangeListener != null) {
                  ConfigureItem.this.contentChangeListener.contentChanged(var2, ConfigureItem.this.contentArray[var2]);
               }

            }
         });
      }

      this.imgIndicator = (ImageView)var2.findViewById(2131886751);
   }

   public void setAttrs(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_3.styleable.ConfigureItem);
      int var4 = var3.getResourceId(0, 0);
      int var5 = var3.getResourceId(1, 0);
      int var6 = var3.getResourceId(2, 0);
      boolean var7 = var3.getBoolean(3, false);
      boolean var8 = var3.getBoolean(4, false);
      int var9 = var3.getResourceId(5, 0);
      if(var4 != 0) {
         this.txtTitle.setText(var4);
      }

      if(var5 != 0) {
         this.txtContent.setText(var5);
      }

      if(var6 != 0) {
         this.txtContent.setTextColor(ContextCompat.getColor(var1, var6));
      }

      if(var7) {
         this.stepper.setVisibility(0);
      } else {
         this.stepper.setVisibility(8);
      }

      if(var8) {
         this.imgIndicator.setVisibility(0);
      } else {
         this.imgIndicator.setVisibility(8);
      }

      if(var9 == 0) {
         this.imgIndicator.setImageResource(2130837735);
      } else {
         this.imgIndicator.setImageResource(var9);
      }

      var3.recycle();
   }

   public void setContent(String var1) {
      this.txtContent.setText(var1);
   }

   public void setContentArray(int[] var1) {
      String[] var2 = new String[var1.length];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         var2[var3] = String.valueOf(var1[var3]);
      }

      this.setContentArray(var2);
   }

   public void setContentArray(String[] var1) {
      this.contentArray = var1;
      this.stepper.setRange(0, -1 + var1.length);
   }

   public void setContentTextColor(int var1) {
      this.txtContent.setTextColor(var1);
   }

   public void setEnabled(boolean var1) {
      if(var1) {
         this.txtTitle.setTextColor(ContextCompat.getColor(this.getContext(), 2131755134));
         this.txtContent.setTextColor(ContextCompat.getColor(this.getContext(), 2131755124));
      } else {
         this.imgIndicator.setVisibility(8);
         this.txtTitle.setTextColor(ContextCompat.getColor(this.getContext(), 2131755079));
         this.txtContent.setTextColor(ContextCompat.getColor(this.getContext(), 2131755079));
      }

      this.setClickable(var1);
      this.setStepperEnabled(var1);
   }

   public void setOnContentChangeListener(OnContentChangeListener var1) {
      this.contentChangeListener = var1;
   }

   public void setSelectedIndex(int var1) {
      if(var1 >= 0 && this.contentArray != null && var1 <= -1 + this.contentArray.length) {
         this.selectedIndex = var1;
         this.txtContent.setText(this.contentArray[var1]);
         this.stepper.setCurrentVal(var1);
      }
   }

   public void setStepperEnabled(boolean var1) {
      if(var1) {
         this.stepper.setVisibility(0);
      } else {
         this.stepper.setVisibility(8);
      }
   }
}
