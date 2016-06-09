package com.goodrx.widget.MyStepper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.goodrx.class_3;
import com.goodrx.widget.MyStepper.OnStepperClickListener;

public class MyStepper extends FrameLayout {
   private ImageButton btnMinus;
   private ImageButton btnPlus;
   private int currentVal;
   private OnStepperClickListener listener;
   private int maxVal;
   private int minVal;

   public MyStepper(Context var1) {
      super(var1);
      this.init(var1);
   }

   public MyStepper(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
      this.setAttr(var1, var2);
   }

   public MyStepper(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1);
      this.setAttr(var1, var2);
   }

   public void decrease() {
      if(this.currentVal > this.minVal) {
         this.currentVal += -1;
      }

      this.refreshButtonStatus();
   }

   public void increase() {
      if(this.currentVal < this.maxVal) {
         ++this.currentVal;
      }

      this.refreshButtonStatus();
   }

   public void init(Context var1) {
      this.maxVal = Integer.MIN_VALUE;
      this.minVal = Integer.MAX_VALUE;
      this.currentVal = 0;
      FrameLayout var2 = (FrameLayout)LayoutInflater.from(var1).inflate(2130968800, this, true);
      this.btnPlus = (ImageButton)var2.findViewById(2131886755);
      this.btnMinus = (ImageButton)var2.findViewById(2131886754);
      if(!this.isInEditMode()) {
         MyStepper.MyOnCLickListener var3 = new MyStepper.MyOnCLickListener();
         this.btnPlus.setOnClickListener(var3);
         this.btnMinus.setOnClickListener(var3);
      }

   }

   public void refreshButtonStatus() {
      if(this.currentVal <= this.minVal) {
         this.btnMinus.setEnabled(false);
      } else {
         this.btnMinus.setEnabled(true);
      }

      if(this.currentVal >= this.maxVal) {
         this.btnPlus.setEnabled(false);
      } else {
         this.btnPlus.setEnabled(true);
      }
   }

   public void setAttr(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_3.styleable.MyStepper);
      this.maxVal = var3.getInt(0, 0);
      this.minVal = var3.getInt(1, 0);
      this.currentVal = var3.getInt(2, 0);
      var3.recycle();
      if(!this.isInEditMode()) {
         this.refreshButtonStatus();
      }

   }

   public void setCurrentVal(int var1) {
      if(var1 >= this.minVal && var1 <= this.maxVal) {
         this.currentVal = var1;
         this.refreshButtonStatus();
      }
   }

   public void setOnStepperClickListener(OnStepperClickListener var1) {
      this.listener = var1;
   }

   public void setRange(int var1, int var2) {
      if(var1 <= var2) {
         this.minVal = var1;
         this.maxVal = var2;
         this.refreshButtonStatus();
      }
   }

   private class MyOnCLickListener implements OnClickListener {
      private MyOnCLickListener() {
      }

      // $FF: synthetic method
      MyOnCLickListener(Object var2) {
         this();
      }

      public void onClick(View var1) {
         int var2 = var1.getId();
         if(var2 == 2131886755) {
            MyStepper.this.increase();
            if(MyStepper.this.listener != null) {
               MyStepper.this.listener.onStepperClicked(1, MyStepper.this.currentVal);
            }
         } else if(var2 == 2131886754) {
            MyStepper.this.decrease();
            if(MyStepper.this.listener != null) {
               MyStepper.this.listener.onStepperClicked(-1, MyStepper.this.currentVal);
               return;
            }
         }

      }
   }
}
