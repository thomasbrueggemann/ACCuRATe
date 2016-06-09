package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import javax.annotation.Nullable;

public interface DraweeController {
   Animatable getAnimatable();

   @Nullable
   DraweeHierarchy getHierarchy();

   void onAttach();

   void onDetach();

   boolean onTouchEvent(MotionEvent var1);

   void setHierarchy(@Nullable DraweeHierarchy var1);
}
