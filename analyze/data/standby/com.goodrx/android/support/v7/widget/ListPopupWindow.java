package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.class_22;
import android.support.v7.widget.AppCompatPopupWindow;
import android.support.v7.widget.ListViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.KeyEvent.DispatcherState;
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
import java.lang.reflect.Method;

public class ListPopupWindow {
   private static final boolean DEBUG = false;
   private static final int EXPAND_LIST_TIMEOUT = 250;
   public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
   public static final int INPUT_METHOD_NEEDED = 1;
   public static final int INPUT_METHOD_NOT_NEEDED = 2;
   public static final int MATCH_PARENT = -1;
   public static final int POSITION_PROMPT_ABOVE = 0;
   public static final int POSITION_PROMPT_BELOW = 1;
   private static final String TAG = "ListPopupWindow";
   public static final int WRAP_CONTENT = -2;
   private static Method sClipToWindowEnabledMethod;
   private static Method sGetMaxAvailableHeightMethod;
   private ListAdapter mAdapter;
   private Context mContext;
   private boolean mDropDownAlwaysVisible;
   private View mDropDownAnchorView;
   private int mDropDownGravity;
   private int mDropDownHeight;
   private int mDropDownHorizontalOffset;
   private ListPopupWindow.DropDownListView mDropDownList;
   private Drawable mDropDownListHighlight;
   private int mDropDownVerticalOffset;
   private boolean mDropDownVerticalOffsetSet;
   private int mDropDownWidth;
   private int mDropDownWindowLayoutType;
   private boolean mForceIgnoreOutsideTouch;
   private final Handler mHandler;
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

   static {
      try {
         Class[] var5 = new Class[]{Boolean.TYPE};
         sClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", var5);
      } catch (NoSuchMethodException var7) {
         Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
      }

      try {
         Class[] var4 = new Class[]{View.class, Integer.TYPE, Boolean.TYPE};
         sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", var4);
      } catch (NoSuchMethodException var6) {
         Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
      }
   }

   public ListPopupWindow(Context var1) {
      this(var1, (AttributeSet)null, class_22.attr.listPopupWindowStyle);
   }

   public ListPopupWindow(Context var1, AttributeSet var2) {
      this(var1, var2, class_22.attr.listPopupWindowStyle);
   }

   public ListPopupWindow(Context var1, AttributeSet var2, int var3) {
      this(var1, var2, var3, 0);
   }

   public ListPopupWindow(Context var1, AttributeSet var2, int var3, int var4) {
      this.mDropDownHeight = -2;
      this.mDropDownWidth = -2;
      this.mDropDownWindowLayoutType = 1002;
      this.mDropDownGravity = 0;
      this.mDropDownAlwaysVisible = false;
      this.mForceIgnoreOutsideTouch = false;
      this.mListItemExpandMaximum = Integer.MAX_VALUE;
      this.mPromptPosition = 0;
      this.mResizePopupRunnable = new ListPopupWindow.ResizePopupRunnable(null);
      this.mTouchInterceptor = new ListPopupWindow.PopupTouchInterceptor(null);
      this.mScrollListener = new ListPopupWindow.PopupScrollListener(null);
      this.mHideSelector = new ListPopupWindow.ListSelectorHider(null);
      this.mTempRect = new Rect();
      this.mContext = var1;
      this.mHandler = new Handler(var1.getMainLooper());
      TypedArray var5 = var1.obtainStyledAttributes(var2, class_22.styleable.ListPopupWindow, var3, var4);
      this.mDropDownHorizontalOffset = var5.getDimensionPixelOffset(class_22.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
      this.mDropDownVerticalOffset = var5.getDimensionPixelOffset(class_22.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
      if(this.mDropDownVerticalOffset != 0) {
         this.mDropDownVerticalOffsetSet = true;
      }

      var5.recycle();
      this.mPopup = new AppCompatPopupWindow(var1, var2, var3);
      this.mPopup.setInputMethodMode(1);
      this.mLayoutDirection = TextUtilsCompat.getLayoutDirectionFromLocale(this.mContext.getResources().getConfiguration().locale);
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

            int var19;
            int var18;
            if(this.mDropDownWidth >= 0) {
               var18 = Integer.MIN_VALUE;
               var19 = this.mDropDownWidth;
            } else {
               var18 = 0;
               var19 = 0;
            }

            var15.measure(MeasureSpec.makeMeasureSpec(var19, var18), 0);
            LayoutParams var20 = (LayoutParams)var15.getLayoutParams();
            var3 = var15.getMeasuredHeight() + var20.topMargin + var20.bottomMargin;
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

   private int getMaxAvailableHeight(View var1, int var2, boolean var3) {
      if(sGetMaxAvailableHeightMethod != null) {
         try {
            Method var6 = sGetMaxAvailableHeightMethod;
            PopupWindow var7 = this.mPopup;
            Object[] var8 = new Object[]{var1, Integer.valueOf(var2), Boolean.valueOf(var3)};
            int var9 = ((Integer)var6.invoke(var7, var8)).intValue();
            return var9;
         } catch (Exception var10) {
            Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
         }
      }

      return this.mPopup.getMaxAvailableHeight(var1, var2);
   }

   private static boolean isConfirmKey(int var0) {
      return var0 == 66 || var0 == 23;
   }

   private void removePromptView() {
      if(this.mPromptView != null) {
         ViewParent var1 = this.mPromptView.getParent();
         if(var1 instanceof ViewGroup) {
            ((ViewGroup)var1).removeView(this.mPromptView);
         }
      }

   }

   private void setPopupClipToScreenEnabled(boolean var1) {
      if(sClipToWindowEnabledMethod != null) {
         try {
            Method var4 = sClipToWindowEnabledMethod;
            PopupWindow var5 = this.mPopup;
            Object[] var6 = new Object[]{Boolean.valueOf(var1)};
            var4.invoke(var5, var6);
         } catch (Exception var7) {
            Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            return;
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

   public OnTouchListener createDragToOpenListener(final View var1) {
      return new ListPopupWindow.ForwardingListener(var1) {
         public ListPopupWindow getPopup() {
            return ListPopupWindow.this;
         }
      };
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
      if(this.isShowing() && var1 != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(var1))) {
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

   public boolean onKeyPreIme(int var1, KeyEvent var2) {
      if(var1 == 4 && this.isShowing()) {
         View var3 = this.mDropDownAnchorView;
         if(var2.getAction() == 0 && var2.getRepeatCount() == 0) {
            DispatcherState var5 = var3.getKeyDispatcherState();
            if(var5 != null) {
               var5.startTracking(var2, this);
            }

            return true;
         }

         if(var2.getAction() == 1) {
            DispatcherState var4 = var3.getKeyDispatcherState();
            if(var4 != null) {
               var4.handleUpEvent(var2);
            }

            if(var2.isTracking() && !var2.isCanceled()) {
               this.dismiss();
               return true;
            }
         }
      }

      return false;
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      if(this.isShowing() && this.mDropDownList.getSelectedItemPosition() >= 0) {
         boolean var3 = this.mDropDownList.onKeyUp(var1, var2);
         if(var3 && isConfirmKey(var1)) {
            this.dismiss();
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

   public void setDropDownGravity(int var1) {
      this.mDropDownGravity = var1;
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
      this.mModal = var1;
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
         if(VERSION.SDK_INT >= 11 && var2.getChoiceMode() != 0) {
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

   public void setWindowLayoutType(int var1) {
      this.mDropDownWindowLayoutType = var1;
   }

   public void show() {
      boolean var1 = true;
      int var2 = -1;
      int var3 = this.buildDropDown();
      boolean var4 = this.isInputMethodNotNeeded();
      PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
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
               PopupWindow var22 = this.mPopup;
               int var23;
               if(this.mDropDownWidth == var2) {
                  var23 = var2;
               } else {
                  var23 = 0;
               }

               var22.setWidth(var23);
               this.mPopup.setHeight(0);
            } else {
               PopupWindow var20 = this.mPopup;
               int var21;
               if(this.mDropDownWidth == var2) {
                  var21 = var2;
               } else {
                  var21 = 0;
               }

               var20.setWidth(var21);
               this.mPopup.setHeight(var2);
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
            boolean var19 = this.mDropDownAlwaysVisible;
            var13 = false;
            if(!var19) {
               var13 = var1;
            }
         }

         var11.setOutsideTouchable(var13);
         PopupWindow var14 = this.mPopup;
         View var15 = this.getAnchorView();
         int var16 = this.mDropDownHorizontalOffset;
         int var17 = this.mDropDownVerticalOffset;
         int var18;
         if(var9 < 0) {
            var18 = var2;
         } else {
            var18 = var9;
         }

         if(var10 >= 0) {
            var2 = var10;
         }

         var14.update(var15, var16, var17, var18, var2);
      } else {
         int var5;
         if(this.mDropDownWidth == var2) {
            var5 = -1;
         } else if(this.mDropDownWidth == -2) {
            var5 = this.getAnchorView().getWidth();
         } else {
            var5 = this.mDropDownWidth;
         }

         int var6;
         if(this.mDropDownHeight == var2) {
            var6 = -1;
         } else if(this.mDropDownHeight == -2) {
            var6 = var3;
         } else {
            var6 = this.mDropDownHeight;
         }

         this.mPopup.setWidth(var5);
         this.mPopup.setHeight(var6);
         this.setPopupClipToScreenEnabled(var1);
         PopupWindow var7 = this.mPopup;
         if(this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
            var1 = false;
         }

         var7.setOutsideTouchable(var1);
         this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
         PopupWindowCompat.showAsDropDown(this.mPopup, this.getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
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

   private static class DropDownListView extends ListViewCompat {
      private ViewPropertyAnimatorCompat mClickAnimation;
      private boolean mDrawsInPressedState;
      private boolean mHijackFocus;
      private boolean mListSelectionHidden;
      private ListViewAutoScrollHelper mScrollHelper;

      public DropDownListView(Context var1, boolean var2) {
         super(var1, (AttributeSet)null, class_22.attr.dropDownListViewStyle);
         this.mHijackFocus = var2;
         this.setCacheColorHint(0);
      }

      private void clearPressedItem() {
         this.mDrawsInPressedState = false;
         this.setPressed(false);
         this.drawableStateChanged();
         View var1 = this.getChildAt(this.mMotionPosition - this.getFirstVisiblePosition());
         if(var1 != null) {
            var1.setPressed(false);
         }

         if(this.mClickAnimation != null) {
            this.mClickAnimation.cancel();
            this.mClickAnimation = null;
         }

      }

      private void clickPressedItem(View var1, int var2) {
         this.performItemClick(var1, var2, this.getItemIdAtPosition(var2));
      }

      private void setPressedItem(View var1, int var2, float var3, float var4) {
         this.mDrawsInPressedState = true;
         if(VERSION.SDK_INT >= 21) {
            this.drawableHotspotChanged(var3, var4);
         }

         if(!this.isPressed()) {
            this.setPressed(true);
         }

         this.layoutChildren();
         if(this.mMotionPosition != -1) {
            View var7 = this.getChildAt(this.mMotionPosition - this.getFirstVisiblePosition());
            if(var7 != null && var7 != var1 && var7.isPressed()) {
               var7.setPressed(false);
            }
         }

         this.mMotionPosition = var2;
         float var5 = var3 - (float)var1.getLeft();
         float var6 = var4 - (float)var1.getTop();
         if(VERSION.SDK_INT >= 21) {
            var1.drawableHotspotChanged(var5, var6);
         }

         if(!var1.isPressed()) {
            var1.setPressed(true);
         }

         this.positionSelectorLikeTouchCompat(var2, var1, var3, var4);
         this.setSelectorEnabled(false);
         this.refreshDrawableState();
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

      public boolean onForwardedEvent(MotionEvent var1, int var2) {
         boolean var3 = true;
         int var4 = MotionEventCompat.getActionMasked(var1);
         boolean var5 = false;
         switch(var4) {
         case 1:
            var3 = false;
         case 2:
            int var6 = var1.findPointerIndex(var2);
            if(var6 < 0) {
               var5 = false;
               var3 = false;
            } else {
               int var10 = (int)var1.getX(var6);
               int var11 = (int)var1.getY(var6);
               int var12 = this.pointToPosition(var10, var11);
               if(var12 == -1) {
                  var5 = true;
               } else {
                  View var13 = this.getChildAt(var12 - this.getFirstVisiblePosition());
                  this.setPressedItem(var13, var12, (float)var10, (float)var11);
                  var3 = true;
                  var5 = false;
                  if(var4 == 1) {
                     this.clickPressedItem(var13, var12);
                     var5 = false;
                  }
               }
            }
            break;
         case 3:
            var5 = false;
            var3 = false;
         }

         if(!var3 || var5) {
            this.clearPressedItem();
         }

         if(var3) {
            if(this.mScrollHelper == null) {
               this.mScrollHelper = new ListViewAutoScrollHelper(this);
            }

            this.mScrollHelper.setEnabled(true);
            this.mScrollHelper.onTouch(this, var1);
         } else if(this.mScrollHelper != null) {
            this.mScrollHelper.setEnabled(false);
            return var3;
         }

         return var3;
      }

      protected boolean touchModeDrawsInPressedStateCompat() {
         return this.mDrawsInPressedState || super.touchModeDrawsInPressedStateCompat();
      }
   }

   public abstract static class ForwardingListener implements OnTouchListener {
      private int mActivePointerId;
      private Runnable mDisallowIntercept;
      private boolean mForwarding;
      private final int mLongPressTimeout;
      private final float mScaledTouchSlop;
      private final View mSrc;
      private final int mTapTimeout;
      private final int[] mTmpLocation = new int[2];
      private Runnable mTriggerLongPress;
      private boolean mWasLongPress;

      public ForwardingListener(View var1) {
         this.mSrc = var1;
         this.mScaledTouchSlop = (float)ViewConfiguration.get(var1.getContext()).getScaledTouchSlop();
         this.mTapTimeout = ViewConfiguration.getTapTimeout();
         this.mLongPressTimeout = (this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
      }

      private void clearCallbacks() {
         if(this.mTriggerLongPress != null) {
            this.mSrc.removeCallbacks(this.mTriggerLongPress);
         }

         if(this.mDisallowIntercept != null) {
            this.mSrc.removeCallbacks(this.mDisallowIntercept);
         }

      }

      private void onLongPress() {
         this.clearCallbacks();
         View var1 = this.mSrc;
         if(var1.isEnabled() && !var1.isLongClickable() && this.onForwardingStarted()) {
            var1.getParent().requestDisallowInterceptTouchEvent(true);
            long var2 = SystemClock.uptimeMillis();
            MotionEvent var4 = MotionEvent.obtain(var2, var2, 3, 0.0F, 0.0F, 0);
            var1.onTouchEvent(var4);
            var4.recycle();
            this.mForwarding = true;
            this.mWasLongPress = true;
         }
      }

      private boolean onTouchForwarded(MotionEvent var1) {
         byte var2 = 1;
         View var3 = this.mSrc;
         ListPopupWindow var4 = this.getPopup();
         if(var4 != null && var4.isShowing()) {
            ListPopupWindow.DropDownListView var5 = var4.mDropDownList;
            if(var5 != null && var5.isShown()) {
               MotionEvent var6 = MotionEvent.obtainNoHistory(var1);
               this.toGlobalMotionEvent(var3, var6);
               this.toLocalMotionEvent(var5, var6);
               boolean var9 = var5.onForwardedEvent(var6, this.mActivePointerId);
               var6.recycle();
               int var10 = MotionEventCompat.getActionMasked(var1);
               byte var11;
               if(var10 != var2 && var10 != 3) {
                  var11 = var2;
               } else {
                  var11 = 0;
               }

               if(!var9 || var11 == 0) {
                  var2 = 0;
               }

               return (boolean)var2;
            }
         }

         return false;
      }

      private boolean onTouchObserved(MotionEvent var1) {
         View var2 = this.mSrc;
         if(var2.isEnabled()) {
            switch(MotionEventCompat.getActionMasked(var1)) {
            case 0:
               this.mActivePointerId = var1.getPointerId(0);
               this.mWasLongPress = false;
               if(this.mDisallowIntercept == null) {
                  this.mDisallowIntercept = new ListPopupWindow.DisallowIntercept(null);
               }

               var2.postDelayed(this.mDisallowIntercept, (long)this.mTapTimeout);
               if(this.mTriggerLongPress == null) {
                  this.mTriggerLongPress = new ListPopupWindow.TriggerLongPress(null);
               }

               var2.postDelayed(this.mTriggerLongPress, (long)this.mLongPressTimeout);
               return false;
            case 1:
            case 3:
               this.clearCallbacks();
               return false;
            case 2:
               int var3 = var1.findPointerIndex(this.mActivePointerId);
               if(var3 >= 0 && !pointInView(var2, var1.getX(var3), var1.getY(var3), this.mScaledTouchSlop)) {
                  this.clearCallbacks();
                  var2.getParent().requestDisallowInterceptTouchEvent(true);
                  return true;
               }
               break;
            default:
               return false;
            }
         }

         return false;
      }

      private static boolean pointInView(View var0, float var1, float var2, float var3) {
         return var1 >= -var3 && var2 >= -var3 && var1 < var3 + (float)(var0.getRight() - var0.getLeft()) && var2 < var3 + (float)(var0.getBottom() - var0.getTop());
      }

      private boolean toGlobalMotionEvent(View var1, MotionEvent var2) {
         int[] var3 = this.mTmpLocation;
         var1.getLocationOnScreen(var3);
         var2.offsetLocation((float)var3[0], (float)var3[1]);
         return true;
      }

      private boolean toLocalMotionEvent(View var1, MotionEvent var2) {
         int[] var3 = this.mTmpLocation;
         var1.getLocationOnScreen(var3);
         var2.offsetLocation((float)(-var3[0]), (float)(-var3[1]));
         return true;
      }

      public abstract ListPopupWindow getPopup();

      protected boolean onForwardingStarted() {
         ListPopupWindow var1 = this.getPopup();
         if(var1 != null && !var1.isShowing()) {
            var1.show();
         }

         return true;
      }

      protected boolean onForwardingStopped() {
         ListPopupWindow var1 = this.getPopup();
         if(var1 != null && var1.isShowing()) {
            var1.dismiss();
         }

         return true;
      }

      public boolean onTouch(View var1, MotionEvent var2) {
         boolean var3 = this.mForwarding;
         boolean var4;
         if(var3) {
            if(this.mWasLongPress) {
               var4 = this.onTouchForwarded(var2);
            } else if(!this.onTouchForwarded(var2) && this.onForwardingStopped()) {
               var4 = false;
            } else {
               var4 = true;
            }
         } else {
            if(this.onTouchObserved(var2) && this.onForwardingStarted()) {
               var4 = true;
            } else {
               var4 = false;
            }

            if(var4) {
               long var5 = SystemClock.uptimeMillis();
               MotionEvent var7 = MotionEvent.obtain(var5, var5, 3, 0.0F, 0.0F, 0);
               this.mSrc.onTouchEvent(var7);
               var7.recycle();
            }
         }

         this.mForwarding = var4;
         boolean var9;
         if(!var4) {
            var9 = false;
            if(!var3) {
               return var9;
            }
         }

         var9 = true;
         return var9;
      }
   }

   private class DisallowIntercept implements Runnable {
      private DisallowIntercept() {
      }

      // $FF: synthetic method
      DisallowIntercept(Object var2) {
         this();
      }

      public void run() {
         ListPopupWindow.super.mSrc.getParent().requestDisallowInterceptTouchEvent(true);
      }
   }

   private class TriggerLongPress implements Runnable {
      private TriggerLongPress() {
      }

      // $FF: synthetic method
      TriggerLongPress(Object var2) {
         this();
      }

      public void run() {
         ListPopupWindow.super.onLongPress();
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
         if(ListPopupWindow.this.mDropDownList != null && ViewCompat.isAttachedToWindow(ListPopupWindow.this.mDropDownList) && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
            ListPopupWindow.this.mPopup.setInputMethodMode(2);
            ListPopupWindow.this.show();
         }

      }
   }
}
