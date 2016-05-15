package com.goodrx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.goodrx.class_3;

public class SettingItem extends FrameLayout {
   private TextView textView;

   public SettingItem(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
      this.setAttrs(var1, var2);
   }

   public void init(Context var1) {
      this.textView = (TextView)LayoutInflater.from(var1).inflate(2130968804, this, true).findViewById(2131886567);
   }

   public void setAttrs(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_3.styleable.SettingItem);
      String var4 = var3.getString(0);
      if(var4 != null) {
         this.textView.setText(var4);
      }

      var3.recycle();
   }
}
