package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.appcompat.class_639;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import java.util.Locale;

public class ListPopupWindow {
   private static final boolean DEBUG = false;
   private static final int EXPAND_LIST_TIMEOUT = 250;
   public static final int FILL_PARENT = -1;
   public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
   public static final int INPUT_METHOD_NEEDED = 1;
   public static final int INPUT_METHOD_NOT_NEEDED = 2;
   public static final int POSITION_PROMPT_ABOVE = 0;
   public static final int POSITION_PROMPT_BELOW = 1;
   private static final String TAG = "ListPopupWindow";
   public static final int WRAP_CONTENT = -2;
   private ListAdapter mAdapter;
   private Context mContext;
   private boolean mDropDownAlwaysVisible;
   private View mDropDownAnchorView;
   private int mDropDownHeight;
   private int mDropDownHorizontalOffset;
   private ListPopupWindow.DropDownListView mDropDownList;
   private Drawable mDropDownListHighlight;
   private int mDropDownVerticalOffset;
   private boolean mDropDownVerticalOffsetSet;
   private int mDropDownWidth;
   private boolean mForceIgnoreOutsideTouch;
   private Handler mHandler;
   private final ListPopupWindow.ListSelectorHider mHideSelector;
   private OnItemClickListener mItemClickListener;
   private OnItemSelectedListener mItemSelectedListener;
   private int mLayoutDirection;
   int mListItemExpandMaximum;
   private boolean mModal;
   private DataSetObserver mObserver;
   private PopupWindow mPopup;
   private int mPromptPosition;
   private View mPromptView;
   private final ListPopupWindow.ResizePopupRunnable mResizePopupRunnable;
   private final ListPopupWindow.PopupScrollListener mScrollListener;
   private Runnable mShowDropDownRunnable;
   private Rect mTempRect;
   private final ListPopupWindow.PopupTouchInterceptor mTouchInterceptor;

   public ListPopupWindow(Context var1) {
      this(var1, (AttributeSet)null, class_639.attr.listPopupWindowStyle);
   }

   public ListPopupWindow(Context var1, AttributeSet var2) {
      this(var1, var2, class_639.attr.listPopupWindowStyle);
   }

   public ListPopupWindow(Context var1, AttributeSet var2, int var3) {
      this.mDropDownHeight = -2;
      this.mDropDownWidth = -2;
      this.mDropDownAlwaysVisible = false;
      this.mForceIgnoreOutsideTouch = false;
      this.mListItemExpandMaximum = Integer.MAX_VALUE;
      this.mPromptPosition = 0;
      this.mResizePopupRunnable = new ListPopupWindow.ResizePopupRunnable(null);
      this.mTouchInterceptor = new ListPopupWindow.PopupTouchInterceptor(null);
      this.mScrollListener = new ListPopupWindow.PopupScrollListener(null);
      this.mHideSelector = new ListPopupWindow.ListSelectorHider(null);
      this.mHandler = new Handler();
      this.mTempRect = new Rect();
      this.mContext = var1;
      this.mPopup = new PopupWindow(var1, var2, var3);
      this.mPopup.setInputMethodMode(1);
      Locale var10000 = this.mContext.getResources().getConfiguration().locale;
   }

   private int buildDropDown() {
      int var3;
      if(this.mDropDownList == null) {
         Context var12 = this.mContext;
         this.mShowDropDownRunnable = new Runnable() {
            public void run() {
               View var1 = ListPopupWindow.this.getAnchorView();
               if(var1 != null && var1.getWindowToken() != null) {
                  ListPopupWindow.this.show();
               }

            }
         };
         boolean var13;
         if(!this.mModal) {
            var13 = true;
         } else {
            var13 = false;
         }

         this.mDropDownList = new ListPopupWindow.DropDownListView(var12, var13);
         if(this.mDropDownListHighlight != null) {
            this.mDropDownList.setSelector(this.mDropDownListHighlight);
         }

         this.mDropDownList.setAdapter(this.mAdapter);
         this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
         this.mDropDownList.setFocusable(true);
         this.mDropDownList.setFocusableInTouchMode(true);
         this.mDropDownList.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> var1, View var2, int var3, long var4) {
               if(var3 != -1) {
                  ListPopupWindow.DropDownListView var6 = ListPopupWindow.this.mDropDownList;
                  if(var6 != null) {
                     var6.mListSelectionHidden = false;
                  }
               }

            }

            public void onNothingSelected(AdapterView<?> var1) {
            }
         });
         this.mDropDownList.setOnScrollListener(this.mScrollListener);
         if(this.mItemSelectedListener != null) {
            this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
         }

         Object var14 = this.mDropDownList;
         View var15 = this.mPromptView;
         var3 = 0;
         if(var15 != null) {
            LinearLayout var16 = new LinearLayout(var12);
            var16.setOrientation(1);
            LayoutParams var17 = new LayoutParams(-1, 0, 1.0F);
            switch(this.mPromptPosition) {
            case 0:
               var16.addView(var15);
               var16.addView((View)var14, var17);
               break;
            case 1:
               var16.addView((View)var14, var17);
               var16.addView(var15);
               break;
            default:
               Log.e("ListPopupWindow", "Invalid hint position " + this.mPromptPosition);
            }

            var15.measure(MeasureSpec.makeMeasureSpec(this.mDropDownWidth, Integer.MIN_VALUE), 0);
            LayoutParams var18 = (LayoutParams)var15.getLayoutParams();
            var3 = var15.getMeasuredHeight() + var18.topMargin + var18.bottomMargin;
            var14 = var16;
         }

         this.mPopup.setContentView((View)var14);
      } else {
         ViewGroup var10000 = (ViewGroup)this.mPopup.getContentView();
         View var2 = this.mPromptView;
         var3 = 0;
         if(var2 != null) {
            LayoutParams var4 = (LayoutParams)var2.getLayoutParams();
            var3 = var2.getMeasuredHeight() + var4.topMargin + var4.bottomMargin;
         }
      }

      Drawable var5 = this.mPopup.getBackground();
      int var6;
      if(var5 != null) {
         var5.getPadding(this.mTempRect);
         var6 = this.mTempRect.top + this.mTempRect.bottom;
         if(!this.mDropDownVerticalOffsetSet) {
            this.mDropDownVerticalOffset = -this.mTempRect.top;
         }
      } else {
         this.mTempRect.setEmpty();
         var6 = 0;
      }

      boolean var7;
      if(this.mPopup.getInputMethodMode() == 2) {
         var7 = true;
      } else {
         var7 = false;
      }

      int var8 = this.getMaxAvailableHeight(this.getAnchorView(), this.mDropDownVerticalOffset, var7);
      if(!this.mDropDownAlwaysVisible && this.mDropDownHeight != -1) {
         int var9;
         int var10001;
         switch(this.mDropDownWidth) {
         case -2:
            var10001 = this.mTempRect.left + this.mTempRect.right;
            var9 = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - var10001, Integer.MIN_VALUE);
            break;
         case -1:
            var10001 = this.mTempRect.left + this.mTempRect.right;
            var9 = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - var10001, 1073741824);
            break;
         default:
            var9 = MeasureSpec.makeMeasureSpec(this.mDropDownWidth, 1073741824);
         }

         int var10 = this.mDropDownList.measureHeightOfChildrenCompat(var9, 0, -1, var8 - var3, -1);
         if(var10 > 0) {
            var3 += var6;
         }

         return var10 + var3;
      } else {
         return var8 + var6;
      }
   }

   private void removePromptView() {
      if(this.mPromptView != null) {
         ViewParent var1 = this.mPromptView.getParent();
         if(var1 instanceof ViewGroup) {
            ((ViewGroup)var1).removeView(this.mPromptView);
         }
      }

   }

   public void clearListSelection() {
      ListPopupWindow.DropDownListView var1 = this.mDropDownList;
      if(var1 != null) {
         var1.mListSelectionHidden = true;
         var1.requestLayout();
      }

   }

   public void dismiss() {
      this.mPopup.dismiss();
      this.removePromptView();
      this.mPopup.setContentView((View)null);
      this.mDropDownList = null;
      this.mHandler.removeCallbacks(this.mResizePopupRunnable);
   }

   public View getAnchorView() {
      return this.mDropDownAnchorView;
   }

   public int getAnimationStyle() {
      return this.mPopup.getAnimationStyle();
   }

   public Drawable getBackground() {
      return this.mPopup.getBackground();
   }

   public int getHeight() {
      return this.mDropDownHeight;
   }

   public int getHorizontalOffset() {
      return this.mDropDownHorizontalOffset;
   }

   public int getInputMethodMode() {
      return this.mPopup.getInputMethodMode();
   }

   public ListView getListView() {
      return this.mDropDownList;
   }

   public int getMaxAvailableHeight(View var1, int var2, boolean var3) {
      Rect var4 = new Rect();
      var1.getWindowVisibleDisplayFrame(var4);
      int[] var5 = new int[2];
      var1.getLocationOnScreen(var5);
      int var6 = var4.bottom;
      if(var3) {
         var6 = var1.getContext().getResources().getDisplayMetrics().heightPixels;
      }

      int var7 = Math.max(var6 - (var5[1] + var1.getHeight()) - var2, var2 + (var5[1] - var4.top));
      if(this.mPopup.getBackground() != null) {
         this.mPopup.getBackground().getPadding(this.mTempRect);
         var7 -= this.mTempRect.top + this.mTempRect.bottom;
      }

      return var7;
   }

   public int getPromptPosition() {
      return this.mPromptPosition;
   }

   public Object getSelectedItem() {
      return !this.isShowing()?null:this.mDropDownList.getSelectedItem();
   }

   public long getSelectedItemId() {
      return !this.isShowing()?Long.MIN_VALUE:this.mDropDownList.getSelectedItemId();
   }

   public int getSelectedItemPosition() {
      return !this.isShowing()?-1:this.mDropDownList.getSelectedItemPosition();
   }

   public View getSelectedView() {
      return !this.isShowing()?null:this.mDropDownList.getSelectedView();
   }

   public int getSoftInputMode() {
      return this.mPopup.getSoftInputMode();
   }

   public int getVerticalOffset() {
      return !this.mDropDownVerticalOffsetSet?0:this.mDropDownVerticalOffset;
   }

   public int getWidth() {
      return this.mDropDownWidth;
   }

   public boolean isDropDownAlwaysVisible() {
      return this.mDropDownAlwaysVisible;
   }

   public boolean isInputMethodNotNeeded() {
      return this.mPopup.getInputMethodMode() == 2;
   }

   public boolean isModal() {
      return this.mModal;
   }

   public boolean isShowing() {
      return this.mPopup.isShowing();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(this.isShowing() && var1 != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || var1 != 66 && var1 != 23)) {
         int var3 = this.mDropDownList.getSelectedItemPosition();
         boolean var4;
         if(!this.mPopup.isAboveAnchor()) {
            var4 = true;
         } else {
            var4 = false;
         }

         ListAdapter var5 = this.mAdapter;
         int var6 = Integer.MAX_VALUE;
         int var7 = Integer.MIN_VALUE;
         if(var5 != null) {
            boolean var10 = var5.areAllItemsEnabled();
            if(var10) {
               var6 = 0;
            } else {
               var6 = this.mDropDownList.lookForSelectablePosition(0, true);
            }

            if(var10) {
               var7 = -1 + var5.getCount();
            } else {
               var7 = this.mDropDownList.lookForSelectablePosition(-1 + var5.getCount(), false);
            }
         }

         if(var4 && var1 == 19 && var3 <= var6 || !var4 && var1 == 20 && var3 >= var7) {
            this.clearListSelection();
            this.mPopup.setInputMethodMode(1);
            this.show();
            return true;
         }

         this.mDropDownList.mListSelectionHidden = false;
         if(this.mDropDownList.onKeyDown(var1, var2)) {
            this.mPopup.setInputMethodMode(2);
            this.mDropDownList.requestFocusFromTouch();
            this.show();
            switch(var1) {
            case 19:
            case 20:
            case 23:
            case 66:
               return true;
            }
         } else if(var4 && var1 == 20) {
            if(var3 == var7) {
               return true;
            }
         } else if(!var4 && var1 == 19 && var3 == var6) {
            return true;
         }
      }

      return false;
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      if(this.isShowing() && this.mDropDownList.getSelectedItemPosition() >= 0) {
         boolean var3 = this.mDropDownList.onKeyUp(var1, var2);
         if(var3) {
            switch(var1) {
            case 23:
            case 66:
               this.dismiss();
               return var3;
            }
         }

         return var3;
      } else {
         return false;
      }
   }

   public boolean performItemClick(int var1) {
      if(this.isShowing()) {
         if(this.mItemClickListener != null) {
            ListPopupWindow.DropDownListView var2 = this.mDropDownList;
            View var3 = var2.getChildAt(var1 - var2.getFirstVisiblePosition());
            ListAdapter var4 = var2.getAdapter();
            this.mItemClickListener.onItemClick(var2, var3, var1, var4.getItemId(var1));
         }

         return true;
      } else {
         return false;
      }
   }

   public void postShow() {
      this.mHandler.post(this.mShowDropDownRunnable);
   }

   public void setAdapter(ListAdapter var1) {
      if(this.mObserver == null) {
         this.mObserver = new ListPopupWindow.PopupDataSetObserver(null);
      } else if(this.mAdapter != null) {
         this.mAdapter.unregisterDataSetObserver(this.mObserver);
      }

      this.mAdapter = var1;
      if(this.mAdapter != null) {
         var1.registerDataSetObserver(this.mObserver);
      }

      if(this.mDropDownList != null) {
         this.mDropDownList.setAdapter(this.mAdapter);
      }

   }

   public void setAnchorView(View var1) {
      this.mDropDownAnchorView = var1;
   }

   public void setAnimationStyle(int var1) {
      this.mPopup.setAnimationStyle(var1);
   }

   public void setBackgroundDrawable(Drawable var1) {
      this.mPopup.setBackgroundDrawable(var1);
   }

   public void setContentWidth(int var1) {
      Drawable var2 = this.mPopup.getBackground();
      if(var2 != null) {
         var2.getPadding(this.mTempRect);
         this.mDropDownWidth = var1 + this.mTempRect.left + this.mTempRect.right;
      } else {
         this.setWidth(var1);
      }
   }

   public void setDropDownAlwaysVisible(boolean var1) {
      this.mDropDownAlwaysVisible = var1;
   }

   public void setForceIgnoreOutsideTouch(boolean var1) {
      this.mForceIgnoreOutsideTouch = var1;
   }

   public void setHeight(int var1) {
      this.mDropDownHeight = var1;
   }

   public void setHorizontalOffset(int var1) {
      this.mDropDownHorizontalOffset = var1;
   }

   public void setInputMethodMode(int var1) {
      this.mPopup.setInputMethodMode(var1);
   }

   void setListItemExpandMax(int var1) {
      this.mListItemExpandMaximum = var1;
   }

   public void setListSelector(Drawable var1) {
      this.mDropDownListHighlight = var1;
   }

   public void setModal(boolean var1) {
      this.mModal = true;
      this.mPopup.setFocusable(var1);
   }

   public void setOnDismissListener(OnDismissListener var1) {
      this.mPopup.setOnDismissListener(var1);
   }

   public void setOnItemClickListener(OnItemClickListener var1) {
      this.mItemClickListener = var1;
   }

   public void setOnItemSelectedListener(OnItemSelectedListener var1) {
      this.mItemSelectedListener = var1;
   }

   public void setPromptPosition(int var1) {
      this.mPromptPosition = var1;
   }

   public void setPromptView(View var1) {
      boolean var2 = this.isShowing();
      if(var2) {
         this.removePromptView();
      }

      this.mPromptView = var1;
      if(var2) {
         this.show();
      }

   }

   public void setSelection(int var1) {
      ListPopupWindow.DropDownListView var2 = this.mDropDownList;
      if(this.isShowing() && var2 != null) {
         var2.mListSelectionHidden = false;
         var2.setSelection(var1);
         if(var2.getChoiceMode() != 0) {
            var2.setItemChecked(var1, true);
         }
      }

   }

   public void setSoftInputMode(int var1) {
      this.mPopup.setSoftInputMode(var1);
   }

   public void setVerticalOffset(int var1) {
      this.mDropDownVerticalOffset = var1;
      this.mDropDownVerticalOffsetSet = true;
   }

   public void setWidth(int var1) {
      this.mDropDownWidth = var1;
   }

   public void show() {
      boolean var1 = true;
      byte var2 = -1;
      int var3 = this.buildDropDown();
      boolean var4 = this.isInputMethodNotNeeded();
      if(this.mPopup.isShowing()) {
         int var9;
         if(this.mDropDownWidth == var2) {
            var9 = -1;
         } else if(this.mDropDownWidth == -2) {
            var9 = this.getAnchorView().getWidth();
         } else {
            var9 = this.mDropDownWidth;
         }

         int var10;
         if(this.mDropDownHeight == var2) {
            if(var4) {
               var10 = var3;
            } else {
               var10 = var2;
            }

            if(var4) {
               PopupWindow var17 = this.mPopup;
               if(this.mDropDownWidth != var2) {
                  var2 = 0;
               }

               var17.setWindowLayoutMode(var2, 0);
            } else {
               PopupWindow var15 = this.mPopup;
               byte var16;
               if(this.mDropDownWidth == var2) {
                  var16 = var2;
               } else {
                  var16 = 0;
               }

               var15.setWindowLayoutMode(var16, var2);
            }
         } else if(this.mDropDownHeight == -2) {
            var10 = var3;
         } else {
            var10 = this.mDropDownHeight;
         }

         PopupWindow var11 = this.mPopup;
         boolean var12 = this.mForceIgnoreOutsideTouch;
         boolean var13 = false;
         if(!var12) {
            boolean var14 = this.mDropDownAlwaysVisible;
            var13 = false;
            if(!var14) {
               var13 = var1;
            }
         }

         var11.setOutsideTouchable(var13);
         this.mPopup.update(this.getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, var9, var10);
      } else {
         byte var5;
         if(this.mDropDownWidth == var2) {
            var5 = -1;
         } else if(this.mDropDownWidth == -2) {
            this.mPopup.setWidth(this.getAnchorView().getWidth());
            var5 = 0;
         } else {
            this.mPopup.setWidth(this.mDropDownWidth);
            var5 = 0;
         }

         byte var6;
         if(this.mDropDownHeight == var2) {
            var6 = -1;
         } else if(this.mDropDownHeight == -2) {
            this.mPopup.setHeight(var3);
            var6 = 0;
         } else {
            this.mPopup.setHeight(this.mDropDownHeight);
            var6 = 0;
         }

         this.mPopup.setWindowLayoutMode(var5, var6);
         PopupWindow var7 = this.mPopup;
         if(this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
            var1 = false;
         }

         var7.setOutsideTouchable(var1);
         this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
         this.mPopup.showAsDropDown(this.getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset);
         this.mDropDownList.setSelection(var2);
         if(!this.mModal || this.mDropDownList.isInTouchMode()) {
            this.clearListSelection();
         }

         if(!this.mModal) {
            this.mHandler.post(this.mHideSelector);
            return;
         }
      }

   }

   private static class DropDownListView extends ListView {
      public static final int INVALID_POSITION = -1;
      static final int NO_POSITION = -1;
      private static final String TAG = "ListPopupWindow.DropDownListView";
      private boolean mHijackFocus;
      private boolean mListSelectionHidden;

      public DropDownListView(Context var1, boolean var2) {
         super(var1, (AttributeSet)null, class_639.attr.dropDownListViewStyle);
         this.mHijackFocus = var2;
         this.setCacheColorHint(0);
      }

      private int lookForSelectablePosition(int var1, boolean var2) {
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

      public boolean hasFocus() {
         return this.mHijackFocus || super.hasFocus();
      }

      public boolean hasWindowFocus() {
         return this.mHijackFocus || super.hasWindowFocus();
      }

      public boolean isFocused() {
         return this.mHijackFocus || super.isFocused();
      }

      public boolean isInTouchMode() {
         return this.mHijackFocus && this.mListSelectionHidden || super.isInTouchMode();
      }

      final int measureHeightOfChildrenCompat(int var1, int var2, int var3, int var4, int var5) {
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
               android.view.ViewGroup.LayoutParams var21 = var16.getLayoutParams();
               int var22;
               if(var21 != null && var21.height > 0) {
                  var22 = MeasureSpec.makeMeasureSpec(var21.height, 1073741824);
               } else {
                  var22 = MeasureSpec.makeMeasureSpec(0, 0);
               }

               var16.measure(var1, var22);
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
   }

   private class ListSelectorHider implements Runnable {
      private ListSelectorHider() {
      }

      // $FF: synthetic method
      ListSelectorHider(Object var2) {
         this();
      }

      public void run() {
         ListPopupWindow.this.clearListSelection();
      }
   }

   private class PopupDataSetObserver extends DataSetObserver {
      private PopupDataSetObserver() {
      }

      // $FF: synthetic method
      PopupDataSetObserver(Object var2) {
         this();
      }

      public void onChanged() {
         if(ListPopupWindow.this.isShowing()) {
            ListPopupWindow.this.show();
         }

      }

      public void onInvalidated() {
         ListPopupWindow.this.dismiss();
      }
   }

   private class PopupScrollListener implements OnScrollListener {
      private PopupScrollListener() {
      }

      // $FF: synthetic method
      PopupScrollListener(Object var2) {
         this();
      }

      public void onScroll(AbsListView var1, int var2, int var3, int var4) {
      }

      public void onScrollStateChanged(AbsListView var1, int var2) {
         if(var2 == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
            ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
            ListPopupWindow.this.mResizePopupRunnable.run();
         }

      }
   }

   private class PopupTouchInterceptor implements OnTouchListener {
      private PopupTouchInterceptor() {
      }

      // $FF: synthetic method
      PopupTouchInterceptor(Object var2) {
         this();
      }

      public boolean onTouch(View var1, MotionEvent var2) {
         int var3 = var2.getAction();
         int var4 = (int)var2.getX();
         int var5 = (int)var2.getY();
         if(var3 == 0 && ListPopupWindow.this.mPopup != null && ListPopupWindow.this.mPopup.isShowing() && var4 >= 0 && var4 < ListPopupWindow.this.mPopup.getWidth() && var5 >= 0 && var5 < ListPopupWindow.this.mPopup.getHeight()) {
            ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250L);
         } else if(var3 == 1) {
            ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
         }

         return false;
      }
   }

   private class ResizePopupRunnable implements Runnable {
      private ResizePopupRunnable() {
      }

      // $FF: synthetic method
      ResizePopupRunnable(Object var2) {
         this();
      }

      public void run() {
         if(ListPopupWindow.this.mDropDownList != null && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
            ListPopupWindow.this.mPopup.setInputMethodMode(2);
            ListPopupWindow.this.show();
         }

      }
   }
}
