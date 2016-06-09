package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
   private static final int MIN_DELAY = 500;
   private static final int MIN_SHOW_TIME = 500;
   private final Runnable mDelayedHide;
   private final Runnable mDelayedShow;
   private boolean mDismissed;
   private boolean mPostedHide;
   private boolean mPostedShow;
   private long mStartTime;

   public ContentLoadingProgressBar(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ContentLoadingProgressBar(Context var1, AttributeSet var2) {
      super(var1, var2, 0);
      this.mStartTime = -1L;
      this.mPostedHide = false;
      this.mPostedShow = false;
      this.mDismissed = false;
      this.mDelayedHide = new Runnable() {
         public void run() {
            ContentLoadingProgressBar.this.mPostedHide = false;
            ContentLoadingProgressBar.this.mStartTime = -1L;
            ContentLoadingProgressBar.this.setVisibility(8);
         }
      };
      this.mDelayedShow = new Runnable() {
         public void run() {
            ContentLoadingProgressBar.this.mPostedShow = false;
            if(!ContentLoadingProgressBar.this.mDismissed) {
               ContentLoadingProgressBar.this.mStartTime = System.currentTimeMillis();
               ContentLoadingProgressBar.this.setVisibility(0);
            }

         }
      };
   }

   private void removeCallbacks() {
      this.removeCallbacks(this.mDelayedHide);
      this.removeCallbacks(this.mDelayedShow);
   }

   public void hide() {
      this.mDismissed = true;
      this.removeCallbacks(this.mDelayedShow);
      long var2 = System.currentTimeMillis() - this.mStartTime;
      if(var2 < 500L && this.mStartTime != -1L) {
         if(!this.mPostedHide) {
            this.postDelayed(this.mDelayedHide, 500L - var2);
            this.mPostedHide = true;
            return;
         }
      } else {
         this.setVisibility(8);
      }

   }

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.removeCallbacks();
   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.removeCallbacks();
   }

   public void show() {
      this.mStartTime = -1L;
      this.mDismissed = false;
      this.removeCallbacks(this.mDelayedHide);
      if(!this.mPostedShow) {
         this.postDelayed(this.mDelayedShow, 500L);
         this.mPostedShow = true;
      }

   }
}
