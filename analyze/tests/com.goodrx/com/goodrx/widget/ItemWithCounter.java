package com.goodrx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.goodrx.class_3;

public class ItemWithCounter extends FrameLayout {
   private TextView txtCounter;
   private TextView txtName;

   public ItemWithCounter(Context var1) {
      super(var1);
      this.init(var1);
   }

   public ItemWithCounter(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
      this.setAttrs(var1, var2);
   }

   public ItemWithCounter(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1);
      this.setAttrs(var1, var2);
   }

   public void init(Context var1) {
      FrameLayout var2 = (FrameLayout)LayoutInflater.from(var1).inflate(2130968778, this, true);
      this.txtName = (TextView)var2.findViewById(2131886694);
      this.txtCounter = (TextView)var2.findViewById(2131886695);
   }

   public void setAttrs(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_3.styleable.ItemWithCounter);
      int var4 = var3.getResourceId(0, 0);
      boolean var5 = var3.getBoolean(1, true);
      if(var4 > 0) {
         this.txtName.setText(var4);
      }

      this.setCounterVisible(var5);
      var3.recycle();
   }

   public void setCount(int var1) {
      this.txtCounter.setText(String.valueOf(var1));
   }

   public void setCounterVisible(boolean var1) {
      if(var1) {
         this.txtCounter.setVisibility(0);
      } else {
         this.txtCounter.setVisibility(8);
      }
   }

   public void setName(String var1) {
      this.txtName.setText(var1);
   }
}
