package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;
import com.facebook.drawee.interfaces.DraweeHierarchy;

public interface SettableDraweeHierarchy extends DraweeHierarchy {
   void reset();

   void setControllerOverlay(Drawable var1);

   void setFailure(Throwable var1);

   void setImage(Drawable var1, float var2, boolean var3);

   void setProgress(float var1, boolean var2);

   void setRetry(Throwable var1);
}
