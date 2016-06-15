package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.class_639;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements MenuView.ItemView {
   private static final String TAG = "ListMenuItemView";
   private Drawable mBackground;
   private CheckBox mCheckBox;
   private Context mContext;
   private boolean mForceShowIcon;
   private ImageView mIconView;
   private LayoutInflater mInflater;
   private MenuItemImpl mItemData;
   private int mMenuType;
   private boolean mPreserveIconSpacing;
   private RadioButton mRadioButton;
   private TextView mShortcutView;
   private int mTextAppearance;
   private Context mTextAppearanceContext;
   private TextView mTitleView;

   public ListMenuItemView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public ListMenuItemView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2);
      this.mContext = var1;
      TypedArray var4 = var1.obtainStyledAttributes(var2, class_639.styleable.MenuView, var3, 0);
      this.mBackground = var4.getDrawable(5);
      this.mTextAppearance = var4.getResourceId(1, -1);
      this.mPreserveIconSpacing = var4.getBoolean(7, false);
      this.mTextAppearanceContext = var1;
      var4.recycle();
   }

   private LayoutInflater getInflater() {
      if(this.mInflater == null) {
         this.mInflater = LayoutInflater.from(this.mContext);
      }

      return this.mInflater;
   }

   private void insertCheckBox() {
      this.mCheckBox = (CheckBox)this.getInflater().inflate(class_639.layout.abc_list_menu_item_checkbox, this, false);
      this.addView(this.mCheckBox);
   }

   private void insertIconView() {
      this.mIconView = (ImageView)this.getInflater().inflate(class_639.layout.abc_list_menu_item_icon, this, false);
      this.addView(this.mIconView, 0);
   }

   private void insertRadioButton() {
      this.mRadioButton = (RadioButton)this.getInflater().inflate(class_639.layout.abc_list_menu_item_radio, this, false);
      this.addView(this.mRadioButton);
   }

   public MenuItemImpl getItemData() {
      return this.mItemData;
   }

   public void initialize(MenuItemImpl var1, int var2) {
      this.mItemData = var1;
      this.mMenuType = var2;
      byte var3;
      if(var1.isVisible()) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      this.setVisibility(var3);
      this.setTitle(var1.getTitleForItemView(this));
      this.setCheckable(var1.isCheckable());
      this.setShortcut(var1.shouldShowShortcut(), var1.getShortcut());
      this.setIcon(var1.getIcon());
      this.setEnabled(var1.isEnabled());
   }

   protected void onFinishInflate() {
      super.onFinishInflate();
      this.setBackgroundDrawable(this.mBackground);
      this.mTitleView = (TextView)this.findViewById(class_639.class_981.title);
      if(this.mTextAppearance != -1) {
         this.mTitleView.setTextAppearance(this.mTextAppearanceContext, this.mTextAppearance);
      }

      this.mShortcutView = (TextView)this.findViewById(class_639.class_981.shortcut);
   }

   protected void onMeasure(int var1, int var2) {
      if(this.mIconView != null && this.mPreserveIconSpacing) {
         LayoutParams var3 = this.getLayoutParams();
         android.widget.LinearLayout.LayoutParams var4 = (android.widget.LinearLayout.LayoutParams)this.mIconView.getLayoutParams();
         if(var3.height > 0 && var4.width <= 0) {
            var4.width = var3.height;
         }
      }

      super.onMeasure(var1, var2);
   }

   public boolean prefersCondensedTitle() {
      return false;
   }

   public void setCheckable(boolean var1) {
      if(var1 || this.mRadioButton != null || this.mCheckBox != null) {
         Object var2;
         Object var3;
         if(this.mItemData.isExclusiveCheckable()) {
            if(this.mRadioButton == null) {
               this.insertRadioButton();
            }

            var2 = this.mRadioButton;
            var3 = this.mCheckBox;
         } else {
            if(this.mCheckBox == null) {
               this.insertCheckBox();
            }

            var2 = this.mCheckBox;
            var3 = this.mRadioButton;
         }

         if(var1) {
            ((CompoundButton)var2).setChecked(this.mItemData.isChecked());
            byte var4;
            if(var1) {
               var4 = 0;
            } else {
               var4 = 8;
            }

            if(((CompoundButton)var2).getVisibility() != var4) {
               ((CompoundButton)var2).setVisibility(var4);
            }

            if(var3 != null && ((CompoundButton)var3).getVisibility() != 8) {
               ((CompoundButton)var3).setVisibility(8);
               return;
            }
         } else {
            if(this.mCheckBox != null) {
               this.mCheckBox.setVisibility(8);
            }

            if(this.mRadioButton != null) {
               this.mRadioButton.setVisibility(8);
               return;
            }
         }
      }

   }

   public void setChecked(boolean var1) {
      Object var2;
      if(this.mItemData.isExclusiveCheckable()) {
         if(this.mRadioButton == null) {
            this.insertRadioButton();
         }

         var2 = this.mRadioButton;
      } else {
         if(this.mCheckBox == null) {
            this.insertCheckBox();
         }

         var2 = this.mCheckBox;
      }

      ((CompoundButton)var2).setChecked(var1);
   }

   public void setForceShowIcon(boolean var1) {
      this.mForceShowIcon = var1;
      this.mPreserveIconSpacing = var1;
   }

   public void setIcon(Drawable var1) {
      boolean var2;
      if(!this.mItemData.shouldShowIcon() && !this.mForceShowIcon) {
         var2 = false;
      } else {
         var2 = true;
      }

      if((var2 || this.mPreserveIconSpacing) && (this.mIconView != null || var1 != null || this.mPreserveIconSpacing)) {
         if(this.mIconView == null) {
            this.insertIconView();
         }

         if(var1 == null && !this.mPreserveIconSpacing) {
            this.mIconView.setVisibility(8);
            return;
         }

         ImageView var3 = this.mIconView;
         if(!var2) {
            var1 = null;
         }

         var3.setImageDrawable(var1);
         if(this.mIconView.getVisibility() != 0) {
            this.mIconView.setVisibility(0);
            return;
         }
      }

   }

   public void setShortcut(boolean var1, char var2) {
      byte var3;
      if(var1 && this.mItemData.shouldShowShortcut()) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      if(var3 == 0) {
         this.mShortcutView.setText(this.mItemData.getShortcutLabel());
      }

      if(this.mShortcutView.getVisibility() != var3) {
         this.mShortcutView.setVisibility(var3);
      }

   }

   public void setTitle(CharSequence var1) {
      if(var1 != null) {
         this.mTitleView.setText(var1);
         if(this.mTitleView.getVisibility() != 0) {
            this.mTitleView.setVisibility(0);
         }
      } else if(this.mTitleView.getVisibility() != 8) {
         this.mTitleView.setVisibility(8);
         return;
      }

   }

   public boolean showsIcon() {
      return this.mForceShowIcon;
   }
}
