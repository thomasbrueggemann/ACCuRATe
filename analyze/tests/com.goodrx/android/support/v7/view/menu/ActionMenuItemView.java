package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.class_22;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, ActionMenuView.ActionMenuChildView, OnClickListener, OnLongClickListener {
   private static final int MAX_ICON_SIZE = 32;
   private static final String TAG = "ActionMenuItemView";
   private boolean mAllowTextWithIcon;
   private boolean mExpandedFormat;
   private ListPopupWindow.ForwardingListener mForwardingListener;
   private Drawable mIcon;
   private MenuItemImpl mItemData;
   private MenuBuilder.ItemInvoker mItemInvoker;
   private int mMaxIconSize;
   private int mMinWidth;
   private ActionMenuItemView.PopupCallback mPopupCallback;
   private int mSavedPaddingLeft;
   private CharSequence mTitle;

   public ActionMenuItemView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ActionMenuItemView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ActionMenuItemView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      Resources var4 = var1.getResources();
      this.mAllowTextWithIcon = var4.getBoolean(class_22.bool.abc_config_allowActionMenuItemTextWithIcon);
      TypedArray var5 = var1.obtainStyledAttributes(var2, class_22.styleable.ActionMenuItemView, var3, 0);
      this.mMinWidth = var5.getDimensionPixelSize(class_22.styleable.ActionMenuItemView_android_minWidth, 0);
      var5.recycle();
      this.mMaxIconSize = (int)(0.5F + 32.0F * var4.getDisplayMetrics().density);
      this.setOnClickListener(this);
      this.setOnLongClickListener(this);
      this.mSavedPaddingLeft = -1;
   }

   private void updateTextButtonVisibility() {
      boolean var1;
      if(!TextUtils.isEmpty(this.mTitle)) {
         var1 = true;
      } else {
         var1 = false;
      }

      boolean var2;
      label25: {
         if(this.mIcon != null) {
            boolean var4 = this.mItemData.showsTextAsAction();
            var2 = false;
            if(!var4) {
               break label25;
            }

            if(!this.mAllowTextWithIcon) {
               boolean var5 = this.mExpandedFormat;
               var2 = false;
               if(!var5) {
                  break label25;
               }
            }
         }

         var2 = true;
      }

      CharSequence var3;
      if(var1 & var2) {
         var3 = this.mTitle;
      } else {
         var3 = null;
      }

      this.setText(var3);
   }

   public MenuItemImpl getItemData() {
      return this.mItemData;
   }

   public boolean hasText() {
      return !TextUtils.isEmpty(this.getText());
   }

   public void initialize(MenuItemImpl var1, int var2) {
      this.mItemData = var1;
      this.setIcon(var1.getIcon());
      this.setTitle(var1.getTitleForItemView(this));
      this.setId(var1.getItemId());
      byte var3;
      if(var1.isVisible()) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      this.setVisibility(var3);
      this.setEnabled(var1.isEnabled());
      if(var1.hasSubMenu() && this.mForwardingListener == null) {
         this.mForwardingListener = new ActionMenuItemView.ActionMenuItemForwardingListener();
      }

   }

   public boolean needsDividerAfter() {
      return this.hasText();
   }

   public boolean needsDividerBefore() {
      return this.hasText() && this.mItemData.getIcon() == null;
   }

   public void onClick(View var1) {
      if(this.mItemInvoker != null) {
         this.mItemInvoker.invokeItem(this.mItemData);
      }

   }

   public void onConfigurationChanged(Configuration var1) {
      if(VERSION.SDK_INT >= 8) {
         super.onConfigurationChanged(var1);
      }

      this.mAllowTextWithIcon = this.getContext().getResources().getBoolean(class_22.bool.abc_config_allowActionMenuItemTextWithIcon);
      this.updateTextButtonVisibility();
   }

   public boolean onLongClick(View var1) {
      if(this.hasText()) {
         return false;
      } else {
         int[] var2 = new int[2];
         Rect var3 = new Rect();
         this.getLocationOnScreen(var2);
         this.getWindowVisibleDisplayFrame(var3);
         Context var4 = this.getContext();
         int var5 = this.getWidth();
         int var6 = this.getHeight();
         int var7 = var2[1] + var6 / 2;
         int var8 = var2[0] + var5 / 2;
         if(ViewCompat.getLayoutDirection(var1) == 0) {
            var8 = var4.getResources().getDisplayMetrics().widthPixels - var8;
         }

         Toast var9 = Toast.makeText(var4, this.mItemData.getTitle(), 0);
         if(var7 < var3.height()) {
            var9.setGravity(8388661, var8, var6 + var2[1] - var3.top);
         } else {
            var9.setGravity(81, 0, var6);
         }

         var9.show();
         return true;
      }
   }

   protected void onMeasure(int var1, int var2) {
      boolean var3 = this.hasText();
      if(var3 && this.mSavedPaddingLeft >= 0) {
         super.setPadding(this.mSavedPaddingLeft, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
      }

      super.onMeasure(var1, var2);
      int var4 = MeasureSpec.getMode(var1);
      int var5 = MeasureSpec.getSize(var1);
      int var6 = this.getMeasuredWidth();
      int var7;
      if(var4 == Integer.MIN_VALUE) {
         var7 = Math.min(var5, this.mMinWidth);
      } else {
         var7 = this.mMinWidth;
      }

      if(var4 != 1073741824 && this.mMinWidth > 0 && var6 < var7) {
         super.onMeasure(MeasureSpec.makeMeasureSpec(var7, 1073741824), var2);
      }

      if(!var3 && this.mIcon != null) {
         super.setPadding((this.getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.mItemData.hasSubMenu() && this.mForwardingListener != null && this.mForwardingListener.onTouch(this, var1)?true:super.onTouchEvent(var1);
   }

   public boolean prefersCondensedTitle() {
      return true;
   }

   public void setCheckable(boolean var1) {
   }

   public void setChecked(boolean var1) {
   }

   public void setExpandedFormat(boolean var1) {
      if(this.mExpandedFormat != var1) {
         this.mExpandedFormat = var1;
         if(this.mItemData != null) {
            this.mItemData.actionFormatChanged();
         }
      }

   }

   public void setIcon(Drawable var1) {
      this.mIcon = var1;
      if(var1 != null) {
         int var2 = var1.getIntrinsicWidth();
         int var3 = var1.getIntrinsicHeight();
         if(var2 > this.mMaxIconSize) {
            float var5 = (float)this.mMaxIconSize / (float)var2;
            var2 = this.mMaxIconSize;
            var3 = (int)(var5 * (float)var3);
         }

         if(var3 > this.mMaxIconSize) {
            float var4 = (float)this.mMaxIconSize / (float)var3;
            var3 = this.mMaxIconSize;
            var2 = (int)(var4 * (float)var2);
         }

         var1.setBounds(0, 0, var2, var3);
      }

      this.setCompoundDrawables(var1, (Drawable)null, (Drawable)null, (Drawable)null);
      this.updateTextButtonVisibility();
   }

   public void setItemInvoker(MenuBuilder.ItemInvoker var1) {
      this.mItemInvoker = var1;
   }

   public void setPadding(int var1, int var2, int var3, int var4) {
      this.mSavedPaddingLeft = var1;
      super.setPadding(var1, var2, var3, var4);
   }

   public void setPopupCallback(ActionMenuItemView.PopupCallback var1) {
      this.mPopupCallback = var1;
   }

   public void setShortcut(boolean var1, char var2) {
   }

   public void setTitle(CharSequence var1) {
      this.mTitle = var1;
      this.setContentDescription(this.mTitle);
      this.updateTextButtonVisibility();
   }

   public boolean showsIcon() {
      return true;
   }

   private class ActionMenuItemForwardingListener extends ListPopupWindow.ForwardingListener {
      public ActionMenuItemForwardingListener() {
         super(ActionMenuItemView.this);
      }

      public ListPopupWindow getPopup() {
         return ActionMenuItemView.this.mPopupCallback != null?ActionMenuItemView.this.mPopupCallback.getPopup():null;
      }

      protected boolean onForwardingStarted() {
         MenuBuilder.ItemInvoker var1 = ActionMenuItemView.this.mItemInvoker;
         boolean var2 = false;
         if(var1 != null) {
            boolean var3 = ActionMenuItemView.this.mItemInvoker.invokeItem(ActionMenuItemView.this.mItemData);
            var2 = false;
            if(var3) {
               ListPopupWindow var4 = this.getPopup();
               var2 = false;
               if(var4 != null) {
                  boolean var5 = var4.isShowing();
                  var2 = false;
                  if(var5) {
                     var2 = true;
                  }
               }
            }
         }

         return var2;
      }
   }

   public abstract static class PopupCallback {
      public abstract ListPopupWindow getPopup();
   }
}
