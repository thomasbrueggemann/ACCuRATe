package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.ControllerListener;
import javax.annotation.Nullable;

public class BaseControllerListener<INFO> implements ControllerListener<INFO> {
   private static final ControllerListener<Object> NO_OP_LISTENER = new BaseControllerListener();

   public static <INFO> ControllerListener<INFO> getNoOpListener() {
      return NO_OP_LISTENER;
   }

   public void onFailure(String var1, Throwable var2) {
   }

   public void onFinalImageSet(String var1, @Nullable INFO var2, @Nullable Animatable var3) {
   }

   public void onIntermediateImageFailed(String var1, Throwable var2) {
   }

   public void onIntermediateImageSet(String var1, @Nullable INFO var2) {
   }

   public void onRelease(String var1) {
   }

   public void onSubmit(String var1, Object var2) {
   }
}
