package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;

public interface ControllerListener<INFO> {
   void onFailure(String var1, Throwable var2);

   void onFinalImageSet(String var1, @Nullable INFO var2, @Nullable Animatable var3);

   void onIntermediateImageFailed(String var1, Throwable var2);

   void onIntermediateImageSet(String var1, @Nullable INFO var2);

   void onRelease(String var1);

   void onSubmit(String var1, Object var2);
}
