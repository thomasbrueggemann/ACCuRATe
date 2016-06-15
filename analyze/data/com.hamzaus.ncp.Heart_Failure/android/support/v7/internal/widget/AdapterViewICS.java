package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;
import android.widget.AdapterView;

abstract class AdapterViewICS<T extends Adapter> extends ViewGroup {
   public static final int INVALID_POSITION = -1;
   public static final long INVALID_ROW_ID = Long.MIN_VALUE;
   static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
   static final int ITEM_VIEW_TYPE_IGNORE = -1;
   static final int SYNC_FIRST_POSITION = 1;
   static final int SYNC_MAX_DURATION_MILLIS = 100;
   static final int SYNC_SELECTED_POSITION;
   boolean mBlockLayoutRequests = false;
   boolean mDataChanged;
   private boolean mDesiredFocusableInTouchModeState;
   private boolean mDesiredFocusableState;
   private View mEmptyView;
   @ExportedProperty(
      category = "scrolling"
   )
   int mFirstPosition = 0;
   boolean mInLayout = false;
   @ExportedProperty(
      category = "list"
   )
   int mItemCount;
   private int mLayoutHeight;
   boolean mNeedSync = false;
   @ExportedProperty(
      category = "list"
   )
   int mNextSelectedPosition = -1;
   long mNextSelectedRowId = Long.MIN_VALUE;
   int mOldItemCount;
   int mOldSelectedPosition = -1;
   long mOldSelectedRowId = Long.MIN_VALUE;
   AdapterViewICS.OnItemClickListener mOnItemClickListener;
   AdapterViewICS.OnItemLongClickListener mOnItemLongClickListener;
   AdapterViewICS.OnItemSelectedListener mOnItemSelectedListener;
   @ExportedProperty(
      category = "list"
   )
   int mSelectedPosition = -1;
   long mSelectedRowId = Long.MIN_VALUE;
   private AdapterViewICS<T>.SelectionNotifier mSelectionNotifier;
   int mSpecificTop;
   long mSyncHeight;
   int mSyncMode;
   int mSyncPosition;
   long mSyncRowId = Long.MIN_VALUE;

   AdapterViewICS(Context var1) {
      super(var1);
   }

   AdapterViewICS(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   AdapterViewICS(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   private void fireOnSelected() {
      if(this.mOnItemSelectedListener != null) {
         int var1 = this.getSelectedItemPosition();
         if(var1 >= 0) {
            View var2 = this.getSelectedView();
            this.mOnItemSelectedListener.onItemSelected(this, var2, var1, this.getAdapter().getItemId(var1));
         } else {
            this.mOnItemSelectedListener.onNothingSelected(this);
         }
      }
   }

   private void updateEmptyStatus(boolean var1) {
      if(this.isInFilterMode()) {
         var1 = false;
      }

      if(var1) {
         if(this.mEmptyView != null) {
            this.mEmptyView.setVisibility(0);
            this.setVisibility(8);
         } else {
            this.setVisibility(0);
         }

         if(this.mDataChanged) {
            this.onLayout(false, this.getLeft(), this.getTop(), this.getRight(), this.getBottom());
         }

      } else {
         if(this.mEmptyView != null) {
            this.mEmptyView.setVisibility(8);
         }

         this.setVisibility(0);
      }
   }

   public void addView(View var1) {
      throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
   }

   public void addView(View var1, int var2) {
      throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
   }

   public void addView(View var1, int var2, LayoutParams var3) {
      throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
   }

   public void addView(View var1, LayoutParams var2) {
      throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
   }

   protected boolean canAnimate() {
      return super.canAnimate() && this.mItemCount > 0;
   }

   void checkFocus() {
      Adapter var1 = this.getAdapter();
      boolean var2;
      if(var1 != null && var1.getCount() != 0) {
         var2 = false;
      } else {
         var2 = true;
      }

      boolean var3;
      if(var2 && !this.isInFilterMode()) {
         var3 = false;
      } else {
         var3 = true;
      }

      boolean var4;
      if(var3 && this.mDesiredFocusableInTouchModeState) {
         var4 = true;
      } else {
         var4 = false;
      }

      super.setFocusableInTouchMode(var4);
      boolean var5;
      if(var3 && this.mDesiredFocusableState) {
         var5 = true;
      } else {
         var5 = false;
      }

      super.setFocusable(var5);
      if(this.mEmptyView != null) {
         boolean var6;
         label29: {
            if(var1 != null) {
               boolean var7 = var1.isEmpty();
               var6 = false;
               if(!var7) {
                  break label29;
               }
            }

            var6 = true;
         }

         this.updateEmptyStatus(var6);
      }

   }

   void checkSelectionChanged() {
      if(this.mSelectedPosition != this.mOldSelectedPosition || this.mSelectedRowId != this.mOldSelectedRowId) {
         this.selectionChanged();
         this.mOldSelectedPosition = this.mSelectedPosition;
         this.mOldSelectedRowId = this.mSelectedRowId;
      }

   }

   public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
      View var2 = this.getSelectedView();
      return var2 != null && var2.getVisibility() == 0 && var2.dispatchPopulateAccessibilityEvent(var1);
   }

   protected void dispatchRestoreInstanceState(SparseArray<Parcelable> var1) {
      this.dispatchThawSelfOnly(var1);
   }

   protected void dispatchSaveInstanceState(SparseArray<Parcelable> var1) {
      this.dispatchFreezeSelfOnly(var1);
   }

   int findSyncPosition() {
      int var1 = this.mItemCount;
      int var6;
      if(var1 == 0) {
         var6 = -1;
         return var6;
      } else {
         long var2 = this.mSyncRowId;
         int var4 = this.mSyncPosition;
         if(var2 == Long.MIN_VALUE) {
            return -1;
         } else {
            int var5 = Math.max(0, var4);
            var6 = Math.min(var1 - 1, var5);
            long var7 = 100L + SystemClock.uptimeMillis();
            int var9 = var6;
            int var10 = var6;
            Adapter var11 = this.getAdapter();
            boolean var12 = false;
            if(var11 == null) {
               return -1;
            } else {
               while(SystemClock.uptimeMillis() <= var7) {
                  if(var11.getItemId(var6) == var2) {
                     return var6;
                  }

                  boolean var13;
                  if(var10 == var1 - 1) {
                     var13 = true;
                  } else {
                     var13 = false;
                  }

                  boolean var14;
                  if(var9 == 0) {
                     var14 = true;
                  } else {
                     var14 = false;
                  }

                  if(var13 && var14) {
                     break;
                  }

                  if(!var14 && (!var12 || var13)) {
                     if(var13 || !var12 && !var14) {
                        --var9;
                        var6 = var9;
                        var12 = true;
                     }
                  } else {
                     ++var10;
                     var6 = var10;
                     var12 = false;
                  }
               }

               return -1;
            }
         }
      }
   }

   public abstract T getAdapter();

   @CapturedViewProperty
   public int getCount() {
      return this.mItemCount;
   }

   public View getEmptyView() {
      return this.mEmptyView;
   }

   public int getFirstVisiblePosition() {
      return this.mFirstPosition;
   }

   public Object getItemAtPosition(int var1) {
      Adapter var2 = this.getAdapter();
      return var2 != null && var1 >= 0?var2.getItem(var1):null;
   }

   public long getItemIdAtPosition(int var1) {
      Adapter var2 = this.getAdapter();
      return var2 != null && var1 >= 0?var2.getItemId(var1):Long.MIN_VALUE;
   }

   public int getLastVisiblePosition() {
      return -1 + this.mFirstPosition + this.getChildCount();
   }

   public final AdapterViewICS.OnItemClickListener getOnItemClickListener() {
      return this.mOnItemClickListener;
   }

   public final AdapterViewICS.OnItemLongClickListener getOnItemLongClickListener() {
      return this.mOnItemLongClickListener;
   }

   public final AdapterViewICS.OnItemSelectedListener getOnItemSelectedListener() {
      return this.mOnItemSelectedListener;
   }

   public int getPositionForView(View var1) {
      View var2 = var1;

      while(true) {
         View var4;
         boolean var5;
         try {
            var4 = (View)var2.getParent();
            var5 = var4.equals(this);
         } catch (ClassCastException var8) {
            return -1;
         }

         if(var5) {
            int var6 = this.getChildCount();

            for(int var7 = 0; var7 < var6; ++var7) {
               if(this.getChildAt(var7).equals(var2)) {
                  return var7 + this.mFirstPosition;
               }
            }

            return -1;
         }

         var2 = var4;
      }
   }

   public Object getSelectedItem() {
      Adapter var1 = this.getAdapter();
      int var2 = this.getSelectedItemPosition();
      return var1 != null && var1.getCount() > 0 && var2 >= 0?var1.getItem(var2):null;
   }

   @CapturedViewProperty
   public long getSelectedItemId() {
      return this.mNextSelectedRowId;
   }

   @CapturedViewProperty
   public int getSelectedItemPosition() {
      return this.mNextSelectedPosition;
   }

   public abstract View getSelectedView();

   void handleDataChanged() {
      int var1 = this.mItemCount;
      boolean var2 = false;
      if(var1 > 0) {
         boolean var3 = this.mNeedSync;
         var2 = false;
         if(var3) {
            this.mNeedSync = false;
            int var6 = this.findSyncPosition();
            var2 = false;
            if(var6 >= 0) {
               int var7 = this.lookForSelectablePosition(var6, true);
               var2 = false;
               if(var7 == var6) {
                  this.setNextSelectedPositionInt(var6);
                  var2 = true;
               }
            }
         }

         if(!var2) {
            int var4 = this.getSelectedItemPosition();
            if(var4 >= var1) {
               var4 = var1 - 1;
            }

            if(var4 < 0) {
               var4 = 0;
            }

            int var5 = this.lookForSelectablePosition(var4, true);
            if(var5 < 0) {
               var5 = this.lookForSelectablePosition(var4, false);
            }

            if(var5 >= 0) {
               this.setNextSelectedPositionInt(var5);
               this.checkSelectionChanged();
               var2 = true;
            }
         }
      }

      if(!var2) {
         this.mSelectedPosition = -1;
         this.mSelectedRowId = Long.MIN_VALUE;
         this.mNextSelectedPosition = -1;
         this.mNextSelectedRowId = Long.MIN_VALUE;
         this.mNeedSync = false;
         this.checkSelectionChanged();
      }

   }

   boolean isInFilterMode() {
      return false;
   }

   int lookForSelectablePosition(int var1, boolean var2) {
      return var1;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.removeCallbacks(this.mSelectionNotifier);
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      this.mLayoutHeight = this.getHeight();
   }

   public boolean performItemClick(View var1, int var2, long var3) {
      AdapterViewICS.OnItemClickListener var5 = this.mOnItemClickListener;
      boolean var6 = false;
      if(var5 != null) {
         this.playSoundEffect(0);
         if(var1 != null) {
            var1.sendAccessibilityEvent(1);
         }

         this.mOnItemClickListener.onItemClick(this, var1, var2, var3);
         var6 = true;
      }

      return var6;
   }

   void rememberSyncState() {
      if(this.getChildCount() > 0) {
         this.mNeedSync = true;
         this.mSyncHeight = (long)this.mLayoutHeight;
         if(this.mSelectedPosition < 0) {
            View var1 = this.getChildAt(0);
            Adapter var2 = this.getAdapter();
            if(this.mFirstPosition >= 0 && this.mFirstPosition < var2.getCount()) {
               this.mSyncRowId = var2.getItemId(this.mFirstPosition);
            } else {
               this.mSyncRowId = -1L;
            }

            this.mSyncPosition = this.mFirstPosition;
            if(var1 != null) {
               this.mSpecificTop = var1.getTop();
            }

            this.mSyncMode = 1;
            return;
         }

         View var3 = this.getChildAt(this.mSelectedPosition - this.mFirstPosition);
         this.mSyncRowId = this.mNextSelectedRowId;
         this.mSyncPosition = this.mNextSelectedPosition;
         if(var3 != null) {
            this.mSpecificTop = var3.getTop();
         }

         this.mSyncMode = 0;
      }

   }

   public void removeAllViews() {
      throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
   }

   public void removeView(View var1) {
      throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
   }

   public void removeViewAt(int var1) {
      throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
   }

   void selectionChanged() {
      if(this.mOnItemSelectedListener != null) {
         if(!this.mInLayout && !this.mBlockLayoutRequests) {
            this.fireOnSelected();
         } else {
            if(this.mSelectionNotifier == null) {
               this.mSelectionNotifier = new AdapterViewICS.SelectionNotifier();
            }

            this.post(this.mSelectionNotifier);
         }
      }

      if(this.mSelectedPosition != -1 && this.isShown() && !this.isInTouchMode()) {
         this.sendAccessibilityEvent(4);
      }

   }

   public abstract void setAdapter(T var1);

   public void setEmptyView(View var1) {
      this.mEmptyView = var1;
      Adapter var2 = this.getAdapter();
      boolean var3;
      if(var2 != null && !var2.isEmpty()) {
         var3 = false;
      } else {
         var3 = true;
      }

      this.updateEmptyStatus(var3);
   }

   public void setFocusable(boolean var1) {
      boolean var2 = true;
      Adapter var3 = this.getAdapter();
      boolean var4;
      if(var3 != null && var3.getCount() != 0) {
         var4 = false;
      } else {
         var4 = var2;
      }

      this.mDesiredFocusableState = var1;
      if(!var1) {
         this.mDesiredFocusableInTouchModeState = false;
      }

      if(!var1 || var4 && !this.isInFilterMode()) {
         var2 = false;
      }

      super.setFocusable(var2);
   }

   public void setFocusableInTouchMode(boolean var1) {
      boolean var2 = true;
      Adapter var3 = this.getAdapter();
      boolean var4;
      if(var3 != null && var3.getCount() != 0) {
         var4 = false;
      } else {
         var4 = var2;
      }

      this.mDesiredFocusableInTouchModeState = var1;
      if(var1) {
         this.mDesiredFocusableState = var2;
      }

      if(!var1 || var4 && !this.isInFilterMode()) {
         var2 = false;
      }

      super.setFocusableInTouchMode(var2);
   }

   void setNextSelectedPositionInt(int var1) {
      this.mNextSelectedPosition = var1;
      this.mNextSelectedRowId = this.getItemIdAtPosition(var1);
      if(this.mNeedSync && this.mSyncMode == 0 && var1 >= 0) {
         this.mSyncPosition = var1;
         this.mSyncRowId = this.mNextSelectedRowId;
      }

   }

   public void setOnClickListener(OnClickListener var1) {
      throw new RuntimeException("Don\'t call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
   }

   public void setOnItemClickListener(AdapterViewICS.OnItemClickListener var1) {
      this.mOnItemClickListener = var1;
   }

   public void setOnItemLongClickListener(AdapterViewICS.OnItemLongClickListener var1) {
      if(!this.isLongClickable()) {
         this.setLongClickable(true);
      }

      this.mOnItemLongClickListener = var1;
   }

   public void setOnItemSelectedListener(AdapterViewICS.OnItemSelectedListener var1) {
      this.mOnItemSelectedListener = var1;
   }

   void setSelectedPositionInt(int var1) {
      this.mSelectedPosition = var1;
      this.mSelectedRowId = this.getItemIdAtPosition(var1);
   }

   public abstract void setSelection(int var1);

   public static class AdapterContextMenuInfo implements ContextMenuInfo {
      // $FF: renamed from: id long
      public long field_3916;
      public int position;
      public View targetView;

      public AdapterContextMenuInfo(View var1, int var2, long var3) {
         this.targetView = var1;
         this.position = var2;
         this.field_3916 = var3;
      }
   }

   class AdapterDataSetObserver extends DataSetObserver {
      private Parcelable mInstanceState = null;

      public void clearSavedState() {
         this.mInstanceState = null;
      }

      public void onChanged() {
         AdapterViewICS.this.mDataChanged = true;
         AdapterViewICS.this.mOldItemCount = AdapterViewICS.this.mItemCount;
         AdapterViewICS.this.mItemCount = AdapterViewICS.this.getAdapter().getCount();
         if(AdapterViewICS.this.getAdapter().hasStableIds() && this.mInstanceState != null && AdapterViewICS.this.mOldItemCount == 0 && AdapterViewICS.this.mItemCount > 0) {
            AdapterViewICS.this.onRestoreInstanceState(this.mInstanceState);
            this.mInstanceState = null;
         } else {
            AdapterViewICS.this.rememberSyncState();
         }

         AdapterViewICS.this.checkFocus();
         AdapterViewICS.this.requestLayout();
      }

      public void onInvalidated() {
         AdapterViewICS.this.mDataChanged = true;
         if(AdapterViewICS.this.getAdapter().hasStableIds()) {
            this.mInstanceState = AdapterViewICS.this.onSaveInstanceState();
         }

         AdapterViewICS.this.mOldItemCount = AdapterViewICS.this.mItemCount;
         AdapterViewICS.this.mItemCount = 0;
         AdapterViewICS.this.mSelectedPosition = -1;
         AdapterViewICS.this.mSelectedRowId = Long.MIN_VALUE;
         AdapterViewICS.this.mNextSelectedPosition = -1;
         AdapterViewICS.this.mNextSelectedRowId = Long.MIN_VALUE;
         AdapterViewICS.this.mNeedSync = false;
         AdapterViewICS.this.checkFocus();
         AdapterViewICS.this.requestLayout();
      }
   }

   public interface OnItemClickListener {
      void onItemClick(AdapterViewICS<?> var1, View var2, int var3, long var4);
   }

   class OnItemClickListenerWrapper implements android.widget.AdapterView.OnItemClickListener {
      private final AdapterViewICS.OnItemClickListener mWrappedListener;

      public OnItemClickListenerWrapper(AdapterViewICS.OnItemClickListener var2) {
         this.mWrappedListener = var2;
      }

      public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
         this.mWrappedListener.onItemClick(AdapterViewICS.this, var2, var3, var4);
      }
   }

   public interface OnItemLongClickListener {
      boolean onItemLongClick(AdapterViewICS<?> var1, View var2, int var3, long var4);
   }

   public interface OnItemSelectedListener {
      void onItemSelected(AdapterViewICS<?> var1, View var2, int var3, long var4);

      void onNothingSelected(AdapterViewICS<?> var1);
   }

   private class SelectionNotifier implements Runnable {
      private SelectionNotifier() {
      }

      // $FF: synthetic method
      SelectionNotifier(Object var2) {
         this();
      }

      public void run() {
         if(AdapterViewICS.this.mDataChanged) {
            if(AdapterViewICS.this.getAdapter() != null) {
               AdapterViewICS.this.post(this);
            }

         } else {
            AdapterViewICS.this.fireOnSelected();
         }
      }
   }
}
