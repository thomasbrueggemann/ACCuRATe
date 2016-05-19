package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.class_22;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatSeekBarHelper;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar extends SeekBar {
   private AppCompatSeekBarHelper mAppCompatSeekBarHelper;
   private AppCompatDrawableManager mDrawableManager;

   public AppCompatSeekBar(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatSeekBar(Context var1, AttributeSet var2) {
      this(var1, var2, class_22.attr.seekBarStyle);
   }

   public AppCompatSeekBar(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mDrawableManager = AppCompatDrawableManager.get();
      this.mAppCompatSeekBarHelper = new AppCompatSeekBarHelper(this, this.mDrawableManager);
      this.mAppCompatSeekBarHelper.loadFromAttributes(var2, var3);
   }
}
