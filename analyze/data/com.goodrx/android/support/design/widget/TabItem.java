package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.class_5;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem extends View {
   final int mCustomLayout;
   final Drawable mIcon;
   final CharSequence mText;

   public TabItem(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public TabItem(Context var1, AttributeSet var2) {
      super(var1, var2);
      TintTypedArray var3 = TintTypedArray.obtainStyledAttributes(var1, var2, class_5.styleable.TabItem);
      this.mText = var3.getText(class_5.styleable.TabItem_android_text);
      this.mIcon = var3.getDrawable(class_5.styleable.TabItem_android_icon);
      this.mCustomLayout = var3.getResourceId(class_5.styleable.TabItem_android_layout, 0);
      var3.recycle();
   }
}
