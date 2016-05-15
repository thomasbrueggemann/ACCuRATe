package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class ListViewCompat extends ListView {
   public static final int INVALID_POSITION = -1;
   public static final int NO_POSITION = -1;
   private static final int[] STATE_SET_NOTHING = new int[]{0};
   private Field mIsChildViewEnabled;
   protected int mMotionPosition;
   int mSelectionBottomPadding;
   int mSelectionLeftPadding;
   int mSelectionRightPadding;
   int mSelectionTopPadding;
   private ListViewCompat.GateKeeperDrawable mSelector;
   final Rect mSelectorRect;

   public ListViewCompat(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ListViewCompat(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ListViewCompat(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mSelectorRect = new Rect();
      this.mSelectionLeftPadding = 0;
      this.mSelectionTopPadding = 0;
      this.mSelectionRightPadding = 0;
      this.mSelectionBottomPadding = 0;

      try {
         this.mIsChildViewEnabled = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
         this.mIsChildViewEnabled.setAccessible(true);
      } catch (NoSuchFieldException var5) {
         var5.printStackTrace();
      }
   }

   protected void dispatchDraw(Canvas var1) {
      this.drawSelectorCompat(var1);
      super.dispatchDraw(var1);
   }

   protected void drawSelectorCompat(Canvas var1) {
      if(!this.mSelectorRect.isEmpty()) {
         Drawable var2 = this.getSelector();
         if(var2 != null) {
            var2.setBounds(this.mSelectorRect);
            var2.draw(var1);
         }
      }

   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      this.setSelectorEnabled(true);
      this.updateSelectorStateCompat();
   }

   public int lookForSelectablePosition(int var1, boolean var2) {
      ListAdapter var3 = this.getAdapter();
      if(var3 != null && !this.isInTouchMode()) {
         int var4 = var3.getCount();
         if(!this.getAdapter().areAllItemsEnabled()) {
            int var5;
            if(var2) {
               for(var5 = Math.max(0, var1); var5 < var4 && !var3.isEnabled(var5); ++var5) {
                  ;
               }
            } else {
               for(var5 = Math.min(var1, var4 - 1); var5 >= 0 && !var3.isEnabled(var5); --var5) {
                  ;
               }
            }

            if(var5 >= 0 && var5 < var4) {
               return var5;
            }
         } else if(var1 >= 0 && var1 < var4) {
            return var1;
         }
      }

      return -1;
   }

   public int measureHeightOfChildrenCompat(int var1, int var2, int var3, int var4, int var5) {
      int var6 = this.getListPaddingTop();
      int var7 = this.getListPaddingBottom();
      this.getListPaddingLeft();
      this.getListPaddingRight();
      int var10 = this.getDividerHeight();
      Drawable var11 = this.getDivider();
      ListAdapter var12 = this.getAdapter();
      int var15;
      if(var12 == null) {
         var15 = var6 + var7;
      } else {
         int var13 = var6 + var7;
         int var14;
         if(var10 > 0 && var11 != null) {
            var14 = var10;
         } else {
            var14 = 0;
         }

         var15 = 0;
         View var16 = null;
         int var17 = 0;
         int var18 = var12.getCount();
         int var19 = 0;

         while(true) {
            if(var19 >= var18) {
               return var13;
            }

            int var20 = var12.getItemViewType(var19);
            if(var20 != var17) {
               var16 = null;
               var17 = var20;
            }

            var16 = var12.getView(var19, var16, this);
            LayoutParams var21 = var16.getLayoutParams();
            if(var21 == null) {
               var21 = this.generateDefaultLayoutParams();
               var16.setLayoutParams(var21);
            }

            int var22;
            if(var21.height > 0) {
               var22 = MeasureSpec.makeMeasureSpec(var21.height, 1073741824);
            } else {
               var22 = MeasureSpec.makeMeasureSpec(0, 0);
            }

            var16.measure(var1, var22);
            var16.forceLayout();
            if(var19 > 0) {
               var13 += var14;
            }

            var13 += var16.getMeasuredHeight();
            if(var13 >= var4) {
               if(var5 >= 0 && var19 > var5 && var15 > 0 && var13 != var4) {
                  break;
               }

               return var4;
            }

            if(var5 >= 0 && var19 >= var5) {
               var15 = var13;
            }

            ++var19;
         }
      }

      return var15;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      switch(var1.getAction()) {
      case 0:
         this.mMotionPosition = this.pointToPosition((int)var1.getX(), (int)var1.getY());
      default:
         return super.onTouchEvent(var1);
      }
   }

   protected void positionSelectorCompat(int param1, View param2) {
      // $FF: Couldn't be decompiled
   }

   protected void positionSelectorLikeFocusCompat(int var1, View var2) {
      boolean var3 = true;
      Drawable var4 = this.getSelector();
      boolean var5;
      if(var4 != null && var1 != -1) {
         var5 = var3;
      } else {
         var5 = false;
      }

      if(var5) {
         var4.setVisible(false, false);
      }

      this.positionSelectorCompat(var1, var2);
      if(var5) {
         Rect var6 = this.mSelectorRect;
         float var7 = var6.exactCenterX();
         float var8 = var6.exactCenterY();
         if(this.getVisibility() != 0) {
            var3 = false;
         }

         var4.setVisible(var3, false);
         DrawableCompat.setHotspot(var4, var7, var8);
      }

   }

   protected void positionSelectorLikeTouchCompat(int var1, View var2, float var3, float var4) {
      this.positionSelectorLikeFocusCompat(var1, var2);
      Drawable var5 = this.getSelector();
      if(var5 != null && var1 != -1) {
         DrawableCompat.setHotspot(var5, var3, var4);
      }

   }

   public void setSelector(Drawable var1) {
      ListViewCompat.GateKeeperDrawable var2;
      if(var1 != null) {
         var2 = new ListViewCompat.GateKeeperDrawable(var1);
      } else {
         var2 = null;
      }

      this.mSelector = var2;
      super.setSelector(this.mSelector);
      Rect var3 = new Rect();
      if(var1 != null) {
         var1.getPadding(var3);
      }

      this.mSelectionLeftPadding = var3.left;
      this.mSelectionTopPadding = var3.top;
      this.mSelectionRightPadding = var3.right;
      this.mSelectionBottomPadding = var3.bottom;
   }

   protected void setSelectorEnabled(boolean var1) {
      if(this.mSelector != null) {
         this.mSelector.setEnabled(var1);
      }

   }

   protected boolean shouldShowSelectorCompat() {
      return this.touchModeDrawsInPressedStateCompat() && this.isPressed();
   }

   protected boolean touchModeDrawsInPressedStateCompat() {
      return false;
   }

   protected void updateSelectorStateCompat() {
      Drawable var1 = this.getSelector();
      if(var1 != null && this.shouldShowSelectorCompat()) {
         var1.setState(this.getDrawableState());
      }

   }

   private static class GateKeeperDrawable extends DrawableWrapper {
      private boolean mEnabled = true;

      public GateKeeperDrawable(Drawable var1) {
         super(var1);
      }

      public void draw(Canvas var1) {
         if(this.mEnabled) {
            super.draw(var1);
         }

      }

      void setEnabled(boolean var1) {
         this.mEnabled = var1;
      }

      public void setHotspot(float var1, float var2) {
         if(this.mEnabled) {
            super.setHotspot(var1, var2);
         }

      }

      public void setHotspotBounds(int var1, int var2, int var3, int var4) {
         if(this.mEnabled) {
            super.setHotspotBounds(var1, var2, var3, var4);
         }

      }

      public boolean setState(int[] var1) {
         return this.mEnabled?super.setState(var1):false;
      }

      public boolean setVisible(boolean var1, boolean var2) {
         return this.mEnabled?super.setVisible(var1, var2):false;
      }
   }
}
