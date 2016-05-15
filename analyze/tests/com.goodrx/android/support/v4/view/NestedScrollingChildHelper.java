package android.support.v4.view;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.view.View;
import android.view.ViewParent;

public class NestedScrollingChildHelper {
   private boolean mIsNestedScrollingEnabled;
   private ViewParent mNestedScrollingParent;
   private int[] mTempNestedScrollConsumed;
   private final View mView;

   public NestedScrollingChildHelper(View var1) {
      this.mView = var1;
   }

   public boolean dispatchNestedFling(float var1, float var2, boolean var3) {
      return this.isNestedScrollingEnabled() && this.mNestedScrollingParent != null?ViewParentCompat.onNestedFling(this.mNestedScrollingParent, this.mView, var1, var2, var3):false;
   }

   public boolean dispatchNestedPreFling(float var1, float var2) {
      return this.isNestedScrollingEnabled() && this.mNestedScrollingParent != null?ViewParentCompat.onNestedPreFling(this.mNestedScrollingParent, this.mView, var1, var2):false;
   }

   public boolean dispatchNestedPreScroll(int var1, int var2, int[] var3, int[] var4) {
      boolean var5 = this.isNestedScrollingEnabled();
      boolean var6 = false;
      if(var5) {
         ViewParent var7 = this.mNestedScrollingParent;
         var6 = false;
         if(var7 != null) {
            if(var1 == 0 && var2 == 0) {
               var6 = false;
               if(var4 != null) {
                  var4[0] = 0;
                  var4[1] = 0;
                  return false;
               }
            } else {
               int var8 = 0;
               int var9 = 0;
               if(var4 != null) {
                  this.mView.getLocationInWindow(var4);
                  var8 = var4[0];
                  var9 = var4[1];
               }

               if(var3 == null) {
                  if(this.mTempNestedScrollConsumed == null) {
                     this.mTempNestedScrollConsumed = new int[2];
                  }

                  var3 = this.mTempNestedScrollConsumed;
               }

               var3[0] = 0;
               var3[1] = 0;
               ViewParentCompat.onNestedPreScroll(this.mNestedScrollingParent, this.mView, var1, var2, var3);
               if(var4 != null) {
                  this.mView.getLocationInWindow(var4);
                  var4[0] -= var8;
                  var4[1] -= var9;
               }

               if(var3[0] == 0) {
                  int var10 = var3[1];
                  var6 = false;
                  if(var10 == 0) {
                     return var6;
                  }
               }

               var6 = true;
            }
         }
      }

      return var6;
   }

   public boolean dispatchNestedScroll(int var1, int var2, int var3, int var4, int[] var5) {
      if(this.isNestedScrollingEnabled() && this.mNestedScrollingParent != null) {
         if(var1 != 0 || var2 != 0 || var3 != 0 || var4 != 0) {
            int var6 = 0;
            int var7 = 0;
            if(var5 != null) {
               this.mView.getLocationInWindow(var5);
               var6 = var5[0];
               var7 = var5[1];
            }

            ViewParentCompat.onNestedScroll(this.mNestedScrollingParent, this.mView, var1, var2, var3, var4);
            if(var5 != null) {
               this.mView.getLocationInWindow(var5);
               var5[0] -= var6;
               var5[1] -= var7;
            }

            return true;
         }

         if(var5 != null) {
            var5[0] = 0;
            var5[1] = 0;
         }
      }

      return false;
   }

   public boolean hasNestedScrollingParent() {
      return this.mNestedScrollingParent != null;
   }

   public boolean isNestedScrollingEnabled() {
      return this.mIsNestedScrollingEnabled;
   }

   public void onDetachedFromWindow() {
      ViewCompat.stopNestedScroll(this.mView);
   }

   public void onStopNestedScroll(View var1) {
      ViewCompat.stopNestedScroll(this.mView);
   }

   public void setNestedScrollingEnabled(boolean var1) {
      if(this.mIsNestedScrollingEnabled) {
         ViewCompat.stopNestedScroll(this.mView);
      }

      this.mIsNestedScrollingEnabled = var1;
   }

   public boolean startNestedScroll(int var1) {
      if(this.hasNestedScrollingParent()) {
         return true;
      } else {
         if(this.isNestedScrollingEnabled()) {
            ViewParent var2 = this.mView.getParent();

            for(View var3 = this.mView; var2 != null; var2 = var2.getParent()) {
               if(ViewParentCompat.onStartNestedScroll(var2, var3, this.mView, var1)) {
                  this.mNestedScrollingParent = var2;
                  ViewParentCompat.onNestedScrollAccepted(var2, var3, this.mView, var1);
                  return true;
               }

               if(var2 instanceof View) {
                  var3 = (View)var2;
               }
            }
         }

         return false;
      }
   }

   public void stopNestedScroll() {
      if(this.mNestedScrollingParent != null) {
         ViewParentCompat.onStopNestedScroll(this.mNestedScrollingParent, this.mView);
         this.mNestedScrollingParent = null;
      }

   }
}
