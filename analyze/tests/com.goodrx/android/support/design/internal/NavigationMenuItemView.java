package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.design.class_5;
import android.support.design.internal.ForegroundLinearLayout;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
   private static final int[] CHECKED_STATE_SET = new int[]{16842912};
   private FrameLayout mActionArea;
   private final int mIconSize;
   private ColorStateList mIconTintList;
   private MenuItemImpl mItemData;
   private final CheckedTextView mTextView;

   public NavigationMenuItemView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public NavigationMenuItemView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public NavigationMenuItemView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.setOrientation(0);
      LayoutInflater.from(var1).inflate(class_5.layout.design_navigation_menu_item, this, true);
      this.mIconSize = var1.getResources().getDimensionPixelSize(class_5.dimen.design_navigation_icon_size);
      this.mTextView = (CheckedTextView)this.findViewById(class_5.class_113.design_menu_item_text);
      this.mTextView.setDuplicateParentStateEnabled(true);
   }

   private StateListDrawable createDefaultBackground() {
      TypedValue var1 = new TypedValue();
      if(this.getContext().getTheme().resolveAttribute(class_5.attr.colorControlHighlight, var1, true)) {
         StateListDrawable var2 = new StateListDrawable();
         var2.addState(CHECKED_STATE_SET, new ColorDrawable(var1.data));
         var2.addState(EMPTY_STATE_SET, new ColorDrawable(0));
         return var2;
      } else {
         return null;
      }
   }

   private void setActionView(View var1) {
      if(this.mActionArea == null) {
         this.mActionArea = (FrameLayout)((ViewStub)this.findViewById(class_5.class_113.design_menu_item_action_area_stub)).inflate();
      }

      this.mActionArea.removeAllViews();
      if(var1 != null) {
         this.mActionArea.addView(var1);
      }

   }

   public MenuItemImpl getItemData() {
      return this.mItemData;
   }

   public void initialize(MenuItemImpl var1, int var2) {
      this.mItemData = var1;
      byte var3;
      if(var1.isVisible()) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      this.setVisibility(var3);
      if(this.getBackground() == null) {
         this.setBackgroundDrawable(this.createDefaultBackground());
      }

      this.setCheckable(var1.isCheckable());
      this.setChecked(var1.isChecked());
      this.setEnabled(var1.isEnabled());
      this.setTitle(var1.getTitle());
      this.setIcon(var1.getIcon());
      this.setActionView(var1.getActionView());
   }

   protected int[] onCreateDrawableState(int var1) {
      int[] var2 = super.onCreateDrawableState(var1 + 1);
      if(this.mItemData != null && this.mItemData.isCheckable() && this.mItemData.isChecked()) {
         mergeDrawableStates(var2, CHECKED_STATE_SET);
      }

      return var2;
   }

   public boolean prefersCondensedTitle() {
      return false;
   }

   public void recycle() {
      if(this.mActionArea != null) {
         this.mActionArea.removeAllViews();
      }

      this.mTextView.setCompoundDrawables((Drawable)null, (Drawable)null, (Drawable)null, (Drawable)null);
   }

   public void setCheckable(boolean var1) {
      this.refreshDrawableState();
   }

   public void setChecked(boolean var1) {
      this.refreshDrawableState();
      this.mTextView.setChecked(var1);
   }

   public void setIcon(Drawable var1) {
      if(var1 != null) {
         ConstantState var2 = var1.getConstantState();
         if(var2 != null) {
            var1 = var2.newDrawable();
         }

         var1 = DrawableCompat.wrap(var1).mutate();
         var1.setBounds(0, 0, this.mIconSize, this.mIconSize);
         DrawableCompat.setTintList(var1, this.mIconTintList);
      }

      TextViewCompat.setCompoundDrawablesRelative(this.mTextView, var1, (Drawable)null, (Drawable)null, (Drawable)null);
   }

   void setIconTintList(ColorStateList var1) {
      this.mIconTintList = var1;
      if(this.mItemData != null) {
         this.setIcon(this.mItemData.getIcon());
      }

   }

   public void setShortcut(boolean var1, char var2) {
   }

   public void setTextAppearance(Context var1, int var2) {
      this.mTextView.setTextAppearance(var1, var2);
   }

   public void setTextColor(ColorStateList var1) {
      this.mTextView.setTextColor(var1);
   }

   public void setTitle(CharSequence var1) {
      this.mTextView.setText(var1);
   }

   public boolean showsIcon() {
      return true;
   }
}
