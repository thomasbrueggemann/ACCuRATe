package com.goodrx.widget.MyRx;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.goodrx.class_3;

public class RxEditOption extends FrameLayout {
   private TextView txtT1;
   private TextView txtT2;

   public RxEditOption(Context var1) {
      super(var1);
      this.init(var1);
   }

   public RxEditOption(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
      this.setAttrs(var1, var2);
   }

   public RxEditOption(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1);
      this.setAttrs(var1, var2);
   }

   public String getText1() {
      return this.txtT1.getText().toString();
   }

   public String getText2() {
      return this.txtT2.getText().toString();
   }

   public void init(Context var1) {
      View var2 = LayoutInflater.from(var1).inflate(2130968790, this, true);
      this.txtT1 = (TextView)var2.findViewById(2131886716);
      this.txtT2 = (TextView)var2.findViewById(2131886717);
      this.setEnabled(true);
   }

   public void setAttrs(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_3.styleable.RxEditOption);
      int var4 = var3.getResourceId(0, 0);
      if(var4 != 0) {
         this.txtT1.setText(var4);
      }

      var3.recycle();
   }

   public void setEnabled(boolean var1) {
      if(var1) {
         this.setClickable(true);
         this.txtT1.setTextColor(ContextCompat.getColor(this.getContext(), 17170444));
         this.txtT2.setTextColor(ContextCompat.getColor(this.getContext(), 2131755084));
      } else {
         this.setClickable(false);
         this.txtT1.setTextColor(ContextCompat.getColor(this.getContext(), 2131755079));
         this.txtT2.setTextColor(ContextCompat.getColor(this.getContext(), 2131755079));
      }
   }

   public void setText1(String var1) {
      this.txtT1.setText(var1);
   }

   public void setText2(String var1) {
      this.txtT2.setText(var1);
   }
}
