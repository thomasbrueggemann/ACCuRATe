package com.goodrx.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class VolBar extends FrameLayout {
   private View[] bars;

   public VolBar(Context var1) {
      super(var1);
      this.init(var1);
   }

   public VolBar(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
   }

   public VolBar(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1);
   }

   public void init(Context var1) {
      View var2 = LayoutInflater.from(var1).inflate(2130968807, this, true);
      this.bars = new View[5];
      this.bars[0] = var2.findViewById(2131886783);
      this.bars[1] = var2.findViewById(2131886782);
      this.bars[2] = var2.findViewById(2131886781);
      this.bars[3] = var2.findViewById(2131886780);
      this.bars[4] = var2.findViewById(2131886779);
   }

   public void setVol(int var1) {
      if(var1 < 0) {
         var1 = 0;
      }

      if(var1 > 5) {
         var1 = 5;
      }

      for(int var2 = 0; var2 < 5; ++var2) {
         this.bars[var2].setBackgroundResource(2131755075);
      }

      for(int var3 = 0; var3 < var1; ++var3) {
         this.bars[var3].setBackgroundResource(2131755090);
      }

   }
}
