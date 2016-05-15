package com.goodrx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.goodrx.class_3;

public class PillIdDropdownButton extends FrameLayout {
   private ImageView imageView;
   private TextView textView;

   public PillIdDropdownButton(Context var1) {
      super(var1);
      this.init(var1);
   }

   public PillIdDropdownButton(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
      this.setAttrs(var1, var2);
   }

   public PillIdDropdownButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1);
      this.setAttrs(var1, var2);
   }

   public ImageView getImageView() {
      return this.imageView;
   }

   public void init(Context var1) {
      FrameLayout var2 = (FrameLayout)LayoutInflater.from(var1).inflate(2130968802, this, true);
      this.imageView = (ImageView)var2.findViewById(2131886772);
      this.textView = (TextView)var2.findViewById(2131886773);
   }

   public void setAttrs(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_3.styleable.PillIdDropdownButton);
      int var4 = var3.getResourceId(1, 0);
      int var5 = var3.getResourceId(2, 0);
      int var6 = var3.getResourceId(0, 0);
      if(var4 != 0) {
         this.setBackground(var4);
      }

      if(var5 != 0) {
         this.setImageSrc(var5);
      }

      if(var6 != 0) {
         this.textView.setText(var6);
      }

      var3.recycle();
   }

   public void setBackground(int var1) {
      this.imageView.setBackgroundResource(var1);
   }

   public void setImageSrc(int var1) {
      this.imageView.setImageResource(var1);
   }

   public void setText(String var1) {
      this.textView.setText(var1);
   }
}
