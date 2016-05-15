package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.class_5;
import android.support.design.internal.NavigationMenuItemView;
import android.support.design.internal.NavigationMenuView;
import android.support.design.internal.ParcelableSparseArray;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public class NavigationMenuPresenter implements MenuPresenter {
   private static final String STATE_ADAPTER = "android:menu:adapter";
   private static final String STATE_HIERARCHY = "android:menu:list";
   private NavigationMenuPresenter.NavigationMenuAdapter mAdapter;
   private MenuPresenter.Callback mCallback;
   private LinearLayout mHeaderLayout;
   private ColorStateList mIconTintList;
   private int mId;
   private Drawable mItemBackground;
   private LayoutInflater mLayoutInflater;
   private MenuBuilder mMenu;
   private NavigationMenuView mMenuView;
   private final OnClickListener mOnClickListener = new OnClickListener() {
      public void onClick(View var1) {
         NavigationMenuItemView var2 = (NavigationMenuItemView)var1;
         NavigationMenuPresenter.this.setUpdateSuspended(true);
         MenuItemImpl var3 = var2.getItemData();
         boolean var4 = NavigationMenuPresenter.this.mMenu.performItemAction(var3, NavigationMenuPresenter.this, 0);
         if(var3 != null && var3.isCheckable() && var4) {
            NavigationMenuPresenter.this.mAdapter.setCheckedItem(var3);
         }

         NavigationMenuPresenter.this.setUpdateSuspended(false);
         NavigationMenuPresenter.this.updateMenuView(false);
      }
   };
   private int mPaddingSeparator;
   private int mPaddingTopDefault;
   private int mTextAppearance;
   private boolean mTextAppearanceSet;
   private ColorStateList mTextColor;

   public void addHeaderView(@NonNull View var1) {
      this.mHeaderLayout.addView(var1);
      this.mMenuView.setPadding(0, 0, 0, this.mMenuView.getPaddingBottom());
   }

   public boolean collapseItemActionView(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   public boolean expandItemActionView(MenuBuilder var1, MenuItemImpl var2) {
      return false;
   }

   public boolean flagActionItems() {
      return false;
   }

   public int getHeaderCount() {
      return this.mHeaderLayout.getChildCount();
   }

   public View getHeaderView(int var1) {
      return this.mHeaderLayout.getChildAt(var1);
   }

   public int getId() {
      return this.mId;
   }

   @Nullable
   public Drawable getItemBackground() {
      return this.mItemBackground;
   }

   @Nullable
   public ColorStateList getItemTextColor() {
      return this.mTextColor;
   }

   @Nullable
   public ColorStateList getItemTintList() {
      return this.mIconTintList;
   }

   public MenuView getMenuView(ViewGroup var1) {
      if(this.mMenuView == null) {
         this.mMenuView = (NavigationMenuView)this.mLayoutInflater.inflate(class_5.layout.design_navigation_menu, var1, false);
         if(this.mAdapter == null) {
            this.mAdapter = new NavigationMenuPresenter.NavigationMenuAdapter();
         }

         this.mHeaderLayout = (LinearLayout)this.mLayoutInflater.inflate(class_5.layout.design_navigation_item_header, this.mMenuView, false);
         this.mMenuView.setAdapter(this.mAdapter);
      }

      return this.mMenuView;
   }

   public View inflateHeaderView(@LayoutRes int var1) {
      View var2 = this.mLayoutInflater.inflate(var1, this.mHeaderLayout, false);
      this.addHeaderView(var2);
      return var2;
   }

   public void initForMenu(Context var1, MenuBuilder var2) {
      this.mLayoutInflater = LayoutInflater.from(var1);
      this.mMenu = var2;
      this.mPaddingSeparator = var1.getResources().getDimensionPixelOffset(class_5.dimen.design_navigation_separator_vertical_padding);
   }

   public void onCloseMenu(MenuBuilder var1, boolean var2) {
      if(this.mCallback != null) {
         this.mCallback.onCloseMenu(var1, var2);
      }

   }

   public void onRestoreInstanceState(Parcelable var1) {
      Bundle var2 = (Bundle)var1;
      SparseArray var3 = var2.getSparseParcelableArray("android:menu:list");
      if(var3 != null) {
         this.mMenuView.restoreHierarchyState(var3);
      }

      Bundle var4 = var2.getBundle("android:menu:adapter");
      if(var4 != null) {
         this.mAdapter.restoreInstanceState(var4);
      }

   }

   public Parcelable onSaveInstanceState() {
      Bundle var1 = new Bundle();
      if(this.mMenuView != null) {
         SparseArray var2 = new SparseArray();
         this.mMenuView.saveHierarchyState(var2);
         var1.putSparseParcelableArray("android:menu:list", var2);
      }

      if(this.mAdapter != null) {
         var1.putBundle("android:menu:adapter", this.mAdapter.createInstanceState());
      }

      return var1;
   }

   public boolean onSubMenuSelected(SubMenuBuilder var1) {
      return false;
   }

   public void removeHeaderView(@NonNull View var1) {
      this.mHeaderLayout.removeView(var1);
      if(this.mHeaderLayout.getChildCount() == 0) {
         this.mMenuView.setPadding(0, this.mPaddingTopDefault, 0, this.mMenuView.getPaddingBottom());
      }

   }

   public void setCallback(MenuPresenter.Callback var1) {
      this.mCallback = var1;
   }

   public void setCheckedItem(MenuItemImpl var1) {
      this.mAdapter.setCheckedItem(var1);
   }

   public void setId(int var1) {
      this.mId = var1;
   }

   public void setItemBackground(@Nullable Drawable var1) {
      this.mItemBackground = var1;
      this.updateMenuView(false);
   }

   public void setItemIconTintList(@Nullable ColorStateList var1) {
      this.mIconTintList = var1;
      this.updateMenuView(false);
   }

   public void setItemTextAppearance(@StyleRes int var1) {
      this.mTextAppearance = var1;
      this.mTextAppearanceSet = true;
      this.updateMenuView(false);
   }

   public void setItemTextColor(@Nullable ColorStateList var1) {
      this.mTextColor = var1;
      this.updateMenuView(false);
   }

   public void setPaddingTopDefault(int var1) {
      if(this.mPaddingTopDefault != var1) {
         this.mPaddingTopDefault = var1;
         if(this.mHeaderLayout.getChildCount() == 0) {
            this.mMenuView.setPadding(0, this.mPaddingTopDefault, 0, this.mMenuView.getPaddingBottom());
         }
      }

   }

   public void setUpdateSuspended(boolean var1) {
      if(this.mAdapter != null) {
         this.mAdapter.setUpdateSuspended(var1);
      }

   }

   public void updateMenuView(boolean var1) {
      if(this.mAdapter != null) {
         this.mAdapter.update();
      }

   }

   private static class HeaderViewHolder extends NavigationMenuPresenter.ViewHolder {
      public HeaderViewHolder(View var1) {
         super(var1);
      }
   }

   private class NavigationMenuAdapter extends RecyclerView.Adapter<NavigationMenuPresenter.ViewHolder> {
      private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
      private static final String STATE_CHECKED_ITEM = "android:menu:checked";
      private static final int VIEW_TYPE_HEADER = 3;
      private static final int VIEW_TYPE_NORMAL = 0;
      private static final int VIEW_TYPE_SEPARATOR = 2;
      private static final int VIEW_TYPE_SUBHEADER = 1;
      private MenuItemImpl mCheckedItem;
      private final ArrayList<NavigationMenuPresenter.NavigationMenuItem> mItems = new ArrayList();
      private ColorDrawable mTransparentIcon;
      private boolean mUpdateSuspended;

      NavigationMenuAdapter() {
         this.prepareMenuItems();
      }

      private void appendTransparentIconIfMissing(int var1, int var2) {
         for(int var3 = var1; var3 < var2; ++var3) {
            MenuItemImpl var4 = ((NavigationMenuPresenter.NavigationMenuTextItem)this.mItems.get(var3)).getMenuItem();
            if(var4.getIcon() == null) {
               if(this.mTransparentIcon == null) {
                  this.mTransparentIcon = new ColorDrawable(0);
               }

               var4.setIcon(this.mTransparentIcon);
            }
         }

      }

      private void prepareMenuItems() {
         if(!this.mUpdateSuspended) {
            this.mUpdateSuspended = true;
            this.mItems.clear();
            this.mItems.add(new NavigationMenuPresenter.NavigationMenuHeaderItem(null));
            int var2 = -1;
            int var3 = 0;
            boolean var4 = false;
            int var5 = 0;

            for(int var6 = NavigationMenuPresenter.this.mMenu.getVisibleItems().size(); var5 < var6; ++var5) {
               MenuItemImpl var7 = (MenuItemImpl)NavigationMenuPresenter.this.mMenu.getVisibleItems().get(var5);
               if(var7.isChecked()) {
                  this.setCheckedItem(var7);
               }

               if(var7.isCheckable()) {
                  var7.setExclusiveCheckable(false);
               }

               if(!var7.hasSubMenu()) {
                  int var8 = var7.getGroupId();
                  if(var8 != var2) {
                     var3 = this.mItems.size();
                     if(var7.getIcon() != null) {
                        var4 = true;
                     } else {
                        var4 = false;
                     }

                     if(var5 != 0) {
                        ++var3;
                        this.mItems.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(NavigationMenuPresenter.this.mPaddingSeparator, NavigationMenuPresenter.this.mPaddingSeparator));
                     }
                  } else if(!var4 && var7.getIcon() != null) {
                     var4 = true;
                     this.appendTransparentIconIfMissing(var3, this.mItems.size());
                  }

                  if(var4 && var7.getIcon() == null) {
                     var7.setIcon(17170445);
                  }

                  this.mItems.add(new NavigationMenuPresenter.NavigationMenuTextItem(var7, null));
                  var2 = var8;
               } else {
                  SubMenu var12 = var7.getSubMenu();
                  if(var12.hasVisibleItems()) {
                     if(var5 != 0) {
                        this.mItems.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(NavigationMenuPresenter.this.mPaddingSeparator, 0));
                     }

                     this.mItems.add(new NavigationMenuPresenter.NavigationMenuTextItem(var7, null));
                     boolean var14 = false;
                     int var15 = this.mItems.size();
                     int var16 = 0;

                     for(int var17 = var12.size(); var16 < var17; ++var16) {
                        MenuItemImpl var18 = (MenuItemImpl)var12.getItem(var16);
                        if(var18.isVisible()) {
                           if(!var14 && var18.getIcon() != null) {
                              var14 = true;
                           }

                           if(var18.isCheckable()) {
                              var18.setExclusiveCheckable(false);
                           }

                           if(var7.isChecked()) {
                              this.setCheckedItem(var7);
                           }

                           this.mItems.add(new NavigationMenuPresenter.NavigationMenuTextItem(var18, null));
                        }
                     }

                     if(var14) {
                        this.appendTransparentIconIfMissing(var15, this.mItems.size());
                     }
                  }
               }
            }

            this.mUpdateSuspended = false;
         }
      }

      public Bundle createInstanceState() {
         Bundle var1 = new Bundle();
         if(this.mCheckedItem != null) {
            var1.putInt("android:menu:checked", this.mCheckedItem.getItemId());
         }

         SparseArray var2 = new SparseArray();
         Iterator var3 = this.mItems.iterator();

         while(var3.hasNext()) {
            NavigationMenuPresenter.NavigationMenuItem var4 = (NavigationMenuPresenter.NavigationMenuItem)var3.next();
            if(var4 instanceof NavigationMenuPresenter.NavigationMenuTextItem) {
               MenuItemImpl var5 = ((NavigationMenuPresenter.NavigationMenuTextItem)var4).getMenuItem();
               View var6;
               if(var5 != null) {
                  var6 = var5.getActionView();
               } else {
                  var6 = null;
               }

               if(var6 != null) {
                  ParcelableSparseArray var7 = new ParcelableSparseArray();
                  var6.saveHierarchyState(var7);
                  var2.put(var5.getItemId(), var7);
               }
            }
         }

         var1.putSparseParcelableArray("android:menu:action_views", var2);
         return var1;
      }

      public int getItemCount() {
         return this.mItems.size();
      }

      public long getItemId(int var1) {
         return (long)var1;
      }

      public int getItemViewType(int var1) {
         NavigationMenuPresenter.NavigationMenuItem var2 = (NavigationMenuPresenter.NavigationMenuItem)this.mItems.get(var1);
         if(var2 instanceof NavigationMenuPresenter.NavigationMenuSeparatorItem) {
            return 2;
         } else if(var2 instanceof NavigationMenuPresenter.NavigationMenuHeaderItem) {
            return 3;
         } else if(var2 instanceof NavigationMenuPresenter.NavigationMenuTextItem) {
            return ((NavigationMenuPresenter.NavigationMenuTextItem)var2).getMenuItem().hasSubMenu()?1:0;
         } else {
            throw new RuntimeException("Unknown item type.");
         }
      }

      public void onBindViewHolder(NavigationMenuPresenter.ViewHolder var1, int var2) {
         switch(this.getItemViewType(var2)) {
         case 0:
            NavigationMenuItemView var4 = (NavigationMenuItemView)var1.itemView;
            var4.setIconTintList(NavigationMenuPresenter.this.mIconTintList);
            if(NavigationMenuPresenter.this.mTextAppearanceSet) {
               var4.setTextAppearance(var4.getContext(), NavigationMenuPresenter.this.mTextAppearance);
            }

            if(NavigationMenuPresenter.this.mTextColor != null) {
               var4.setTextColor(NavigationMenuPresenter.this.mTextColor);
            }

            Drawable var5;
            if(NavigationMenuPresenter.this.mItemBackground != null) {
               var5 = NavigationMenuPresenter.this.mItemBackground.getConstantState().newDrawable();
            } else {
               var5 = null;
            }

            var4.setBackgroundDrawable(var5);
            var4.initialize(((NavigationMenuPresenter.NavigationMenuTextItem)this.mItems.get(var2)).getMenuItem(), 0);
            return;
         case 1:
            ((TextView)var1.itemView).setText(((NavigationMenuPresenter.NavigationMenuTextItem)this.mItems.get(var2)).getMenuItem().getTitle());
            return;
         case 2:
            NavigationMenuPresenter.NavigationMenuSeparatorItem var3 = (NavigationMenuPresenter.NavigationMenuSeparatorItem)this.mItems.get(var2);
            var1.itemView.setPadding(0, var3.getPaddingTop(), 0, var3.getPaddingBottom());
            return;
         default:
         }
      }

      public NavigationMenuPresenter.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
         switch(var2) {
         case 0:
            return new NavigationMenuPresenter.NormalViewHolder(NavigationMenuPresenter.this.mLayoutInflater, var1, NavigationMenuPresenter.this.mOnClickListener);
         case 1:
            return new NavigationMenuPresenter.SubheaderViewHolder(NavigationMenuPresenter.this.mLayoutInflater, var1);
         case 2:
            return new NavigationMenuPresenter.SeparatorViewHolder(NavigationMenuPresenter.this.mLayoutInflater, var1);
         case 3:
            return new NavigationMenuPresenter.HeaderViewHolder(NavigationMenuPresenter.this.mHeaderLayout);
         default:
            return null;
         }
      }

      public void onViewRecycled(NavigationMenuPresenter.ViewHolder var1) {
         if(var1 instanceof NavigationMenuPresenter.NormalViewHolder) {
            ((NavigationMenuItemView)var1.itemView).recycle();
         }

      }

      public void restoreInstanceState(Bundle var1) {
         int var2 = var1.getInt("android:menu:checked", 0);
         if(var2 != 0) {
            this.mUpdateSuspended = true;
            Iterator var8 = this.mItems.iterator();

            while(var8.hasNext()) {
               NavigationMenuPresenter.NavigationMenuItem var9 = (NavigationMenuPresenter.NavigationMenuItem)var8.next();
               if(var9 instanceof NavigationMenuPresenter.NavigationMenuTextItem) {
                  MenuItemImpl var10 = ((NavigationMenuPresenter.NavigationMenuTextItem)var9).getMenuItem();
                  if(var10 != null && var10.getItemId() == var2) {
                     this.setCheckedItem(var10);
                     break;
                  }
               }
            }

            this.mUpdateSuspended = false;
            this.prepareMenuItems();
         }

         SparseArray var3 = var1.getSparseParcelableArray("android:menu:action_views");
         Iterator var4 = this.mItems.iterator();

         while(var4.hasNext()) {
            NavigationMenuPresenter.NavigationMenuItem var5 = (NavigationMenuPresenter.NavigationMenuItem)var4.next();
            if(var5 instanceof NavigationMenuPresenter.NavigationMenuTextItem) {
               MenuItemImpl var6 = ((NavigationMenuPresenter.NavigationMenuTextItem)var5).getMenuItem();
               View var7;
               if(var6 != null) {
                  var7 = var6.getActionView();
               } else {
                  var7 = null;
               }

               if(var7 != null) {
                  var7.restoreHierarchyState((SparseArray)var3.get(var6.getItemId()));
               }
            }
         }

      }

      public void setCheckedItem(MenuItemImpl var1) {
         if(this.mCheckedItem != var1 && var1.isCheckable()) {
            if(this.mCheckedItem != null) {
               this.mCheckedItem.setChecked(false);
            }

            this.mCheckedItem = var1;
            var1.setChecked(true);
         }
      }

      public void setUpdateSuspended(boolean var1) {
         this.mUpdateSuspended = var1;
      }

      public void update() {
         this.prepareMenuItems();
         this.notifyDataSetChanged();
      }
   }

   private static class NavigationMenuHeaderItem implements NavigationMenuPresenter.NavigationMenuItem {
      private NavigationMenuHeaderItem() {
      }

      // $FF: synthetic method
      NavigationMenuHeaderItem(Object var1) {
         this();
      }
   }

   private interface NavigationMenuItem {
   }

   private static class NavigationMenuSeparatorItem implements NavigationMenuPresenter.NavigationMenuItem {
      private final int mPaddingBottom;
      private final int mPaddingTop;

      public NavigationMenuSeparatorItem(int var1, int var2) {
         this.mPaddingTop = var1;
         this.mPaddingBottom = var2;
      }

      public int getPaddingBottom() {
         return this.mPaddingBottom;
      }

      public int getPaddingTop() {
         return this.mPaddingTop;
      }
   }

   private static class NavigationMenuTextItem implements NavigationMenuPresenter.NavigationMenuItem {
      private final MenuItemImpl mMenuItem;

      private NavigationMenuTextItem(MenuItemImpl var1) {
         this.mMenuItem = var1;
      }

      // $FF: synthetic method
      NavigationMenuTextItem(MenuItemImpl var1, Object var2) {
         this(var1);
      }

      public MenuItemImpl getMenuItem() {
         return this.mMenuItem;
      }
   }

   private static class NormalViewHolder extends NavigationMenuPresenter.ViewHolder {
      public NormalViewHolder(LayoutInflater var1, ViewGroup var2, OnClickListener var3) {
         super(var1.inflate(class_5.layout.design_navigation_item, var2, false));
         this.itemView.setOnClickListener(var3);
      }
   }

   private static class SeparatorViewHolder extends NavigationMenuPresenter.ViewHolder {
      public SeparatorViewHolder(LayoutInflater var1, ViewGroup var2) {
         super(var1.inflate(class_5.layout.design_navigation_item_separator, var2, false));
      }
   }

   private static class SubheaderViewHolder extends NavigationMenuPresenter.ViewHolder {
      public SubheaderViewHolder(LayoutInflater var1, ViewGroup var2) {
         super(var1.inflate(class_5.layout.design_navigation_item_subheader, var2, false));
      }
   }

   private abstract static class ViewHolder extends RecyclerView.ViewHolder {
      public ViewHolder(View var1) {
         super(var1);
      }
   }
}
