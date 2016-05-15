package com.goodrx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.goodrx.class_3;

public class ClickableTextView extends TextView {
   private int normalTextColor;
   private int pressedTextColor;

   public ClickableTextView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
      this.setAttrs(var1, var2);
   }

   public void init(Context var1) {
      this.setClickable(true);
   }

   public void setAttrs(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_3.styleable.ClickableTextView);
      this.normalTextColor = var3.getColor(0, ContextCompat.getColor(var1, 2131755124));
      this.pressedTextColor = var3.getColor(1, ContextCompat.getColor(var1, 2131755124));
      this.setTextColor(this.normalTextColor);
      this.setOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2) {
            if(var2.getAction() == 0) {
               ClickableTextView.this.setTextColor(ClickableTextView.this.pressedTextColor);
            }

            if(var2.getAction() == 3 || var2.getAction() == 1) {
               ClickableTextView.this.setTextColor(ClickableTextView.this.normalTextColor);
            }

            return false;
         }
      });
      var3.recycle();
   }
}
