package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatDrawableManager;

public class TintResources extends Resources {
   private final Context mContext;

   public TintResources(@NonNull Context var1, @NonNull Resources var2) {
      super(var2.getAssets(), var2.getDisplayMetrics(), var2.getConfiguration());
      this.mContext = var1;
   }

   public Drawable getDrawable(int var1) throws NotFoundException {
      return AppCompatDrawableManager.get().onDrawableLoadedFromResources(this.mContext, this, var1);
   }

   final Drawable superGetDrawable(int var1) {
      return super.getDrawable(var1);
   }
}
