package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.class_22;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;

public class DialogTitle extends TextView {
   public DialogTitle(Context var1) {
      super(var1);
   }

   public DialogTitle(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public DialogTitle(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      Layout var3 = this.getLayout();
      if(var3 != null) {
         int var4 = var3.getLineCount();
         if(var4 > 0 && var3.getEllipsisCount(var4 - 1) > 0) {
            this.setSingleLine(false);
            this.setMaxLines(2);
            TypedArray var5 = this.getContext().obtainStyledAttributes((AttributeSet)null, class_22.styleable.TextAppearance, 16842817, 16973892);
            int var6 = var5.getDimensionPixelSize(class_22.styleable.TextAppearance_android_textSize, 0);
            if(var6 != 0) {
               this.setTextSize(0, (float)var6);
            }

            var5.recycle();
            super.onMeasure(var1, var2);
         }
      }

   }
}
