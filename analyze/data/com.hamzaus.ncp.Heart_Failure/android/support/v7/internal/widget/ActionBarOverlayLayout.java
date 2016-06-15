package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.class_639;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarOverlayLayout extends FrameLayout {
   static final int[] mActionBarSizeAttr;
   private ActionBar mActionBar;
   private View mActionBarBottom;
   private int mActionBarHeight;
   private View mActionBarTop;
   private ActionBarView mActionView;
   private ActionBarContainer mContainerView;
   private View mContent;
   private final Rect mZeroRect = new Rect(0, 0, 0, 0);

   static {
      int[] var0 = new int[]{class_639.attr.actionBarSize};
      mActionBarSizeAttr = var0;
   }

   public ActionBarOverlayLayout(Context var1) {
      super(var1);
      this.init(var1);
   }

   public ActionBarOverlayLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
   }

   private boolean applyInsets(View var1, Rect var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      LayoutParams var7 = (LayoutParams)var1.getLayoutParams();
      boolean var8 = false;
      if(var3) {
         int var9 = var7.leftMargin;
         int var10 = var2.left;
         var8 = false;
         if(var9 != var10) {
            var8 = true;
            var7.leftMargin = var2.left;
         }
      }

      if(var4 && var7.topMargin != var2.top) {
         var8 = true;
         var7.topMargin = var2.top;
      }

      if(var6 && var7.rightMargin != var2.right) {
         var8 = true;
         var7.rightMargin = var2.right;
      }

      if(var5 && var7.bottomMargin != var2.bottom) {
         var8 = true;
         var7.bottomMargin = var2.bottom;
      }

      return var8;
   }

   private void init(Context var1) {
      TypedArray var2 = this.getContext().getTheme().obtainStyledAttributes(mActionBarSizeAttr);
      this.mActionBarHeight = var2.getDimensionPixelSize(0, 0);
      var2.recycle();
   }

   void pullChildren() {
      if(this.mContent == null) {
         this.mContent = this.findViewById(class_639.class_981.action_bar_activity_content);
         if(this.mContent == null) {
            this.mContent = this.findViewById(16908290);
         }

         this.mActionBarTop = this.findViewById(class_639.class_981.top_action_bar);
         this.mContainerView = (ActionBarContainer)this.findViewById(class_639.class_981.action_bar_container);
         this.mActionView = (ActionBarView)this.findViewById(class_639.class_981.action_bar);
         this.mActionBarBottom = this.findViewById(class_639.class_981.split_action_bar);
      }

   }

   public void setActionBar(ActionBar var1) {
      this.mActionBar = var1;
   }
}
