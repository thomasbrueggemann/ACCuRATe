package android.support.v7.widget;

import android.graphics.Outline;
import android.support.annotation.NonNull;
import android.support.v7.widget.ActionBarBackgroundDrawable;
import android.support.v7.widget.ActionBarContainer;

class ActionBarBackgroundDrawableV21 extends ActionBarBackgroundDrawable {
   public ActionBarBackgroundDrawableV21(ActionBarContainer var1) {
      super(var1);
   }

   public void getOutline(@NonNull Outline var1) {
      if(this.mContainer.mIsSplit) {
         if(this.mContainer.mSplitBackground != null) {
            this.mContainer.mSplitBackground.getOutline(var1);
         }
      } else if(this.mContainer.mBackground != null) {
         this.mContainer.mBackground.getOutline(var1);
         return;
      }

   }
}
