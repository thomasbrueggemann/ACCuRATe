package com.goodrx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.goodrx.class_3;

public class ClickableItemWithSubtext extends FrameLayout {
   private TextView txtMain;
   private TextView txtSubText;

   public ClickableItemWithSubtext(Context var1) {
      super(var1);
      this.init(var1);
   }

   public ClickableItemWithSubtext(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
      this.setAttr(var1, var2);
   }

   private void init(Context var1) {
      View var2 = LayoutInflater.from(var1).inflate(2130968797, this, true);
      this.txtMain = (TextView)var2.findViewById(2131886745);
      this.txtSubText = (TextView)var2.findViewById(2131886747);
   }

   private void setAttr(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_3.styleable.ClickableItemWithSubtext);
      String var4 = var3.getString(0);
      String var5 = var3.getString(1);
      if(var4 != null) {
         this.txtMain.setText(var4);
      }

      if(var5 != null) {
         this.txtSubText.setText(var5);
      }

      var3.recycle();
   }

   public void setMainText(int var1) {
      this.txtMain.setText(var1);
   }

   public void setMainText(String var1) {
      this.txtMain.setText(var1);
   }

   public void setSubText(int var1) {
      this.txtSubText.setText(var1);
   }

   public void setSubText(String var1) {
      this.txtSubText.setText(var1);
   }
}
