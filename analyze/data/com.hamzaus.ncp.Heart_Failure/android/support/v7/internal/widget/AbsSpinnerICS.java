package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.internal.widget.AdapterViewICS;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;

abstract class AbsSpinnerICS extends AdapterViewICS<SpinnerAdapter> {
   SpinnerAdapter mAdapter;
   boolean mBlockLayoutRequests;
   private DataSetObserver mDataSetObserver;
   int mHeightMeasureSpec;
   final AbsSpinnerICS.RecycleBin mRecycler;
   int mSelectionBottomPadding;
   int mSelectionLeftPadding;
   int mSelectionRightPadding;
   int mSelectionTopPadding;
   final Rect mSpinnerPadding;
   private Rect mTouchFrame;
   int mWidthMeasureSpec;

   AbsSpinnerICS(Context var1) {
      super(var1);
      this.mSelectionLeftPadding = 0;
      this.mSelectionTopPadding = 0;
      this.mSelectionRightPadding = 0;
      this.mSelectionBottomPadding = 0;
      this.mSpinnerPadding = new Rect();
      this.mRecycler = new AbsSpinnerICS.RecycleBin();
      this.initAbsSpinner();
   }

   AbsSpinnerICS(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   AbsSpinnerICS(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mSelectionLeftPadding = 0;
      this.mSelectionTopPadding = 0;
      this.mSelectionRightPadding = 0;
      this.mSelectionBottomPadding = 0;
      this.mSpinnerPadding = new Rect();
      this.mRecycler = new AbsSpinnerICS.RecycleBin();
      this.initAbsSpinner();
   }

   private void initAbsSpinner() {
      this.setFocusable(true);
      this.setWillNotDraw(false);
   }

   protected LayoutParams generateDefaultLayoutParams() {
      return new LayoutParams(-1, -2);
   }

   public SpinnerAdapter getAdapter() {
      return this.mAdapter;
   }

   int getChildHeight(View var1) {
      return var1.getMeasuredHeight();
   }

   int getChildWidth(View var1) {
      return var1.getMeasuredWidth();
   }

   public int getCount() {
      return this.mItemCount;
   }

   public View getSelectedView() {
      return this.mItemCount > 0 && this.mSelectedPosition >= 0?this.getChildAt(this.mSelectedPosition - this.mFirstPosition):null;
   }

   abstract void layout(int var1, boolean var2);

   protected void onMeasure(int var1, int var2) {
      int var3 = MeasureSpec.getMode(var1);
      int var4 = this.getPaddingLeft();
      int var5 = this.getPaddingTop();
      int var6 = this.getPaddingRight();
      int var7 = this.getPaddingBottom();
      Rect var8 = this.mSpinnerPadding;
      if(var4 <= this.mSelectionLeftPadding) {
         var4 = this.mSelectionLeftPadding;
      }

      var8.left = var4;
      Rect var9 = this.mSpinnerPadding;
      if(var5 <= this.mSelectionTopPadding) {
         var5 = this.mSelectionTopPadding;
      }

      var9.top = var5;
      Rect var10 = this.mSpinnerPadding;
      if(var6 <= this.mSelectionRightPadding) {
         var6 = this.mSelectionRightPadding;
      }

      var10.right = var6;
      Rect var11 = this.mSpinnerPadding;
      if(var7 <= this.mSelectionBottomPadding) {
         var7 = this.mSelectionBottomPadding;
      }

      var11.bottom = var7;
      if(this.mDataChanged) {
         this.handleDataChanged();
      }

      boolean var12 = true;
      int var13 = this.getSelectedItemPosition();
      int var14 = 0;
      int var15 = 0;
      if(var13 >= 0) {
         SpinnerAdapter var19 = this.mAdapter;
         var14 = 0;
         var15 = 0;
         if(var19 != null) {
            int var20 = this.mAdapter.getCount();
            var14 = 0;
            var15 = 0;
            if(var13 < var20) {
               View var21 = this.mRecycler.get(var13);
               if(var21 == null) {
                  var21 = this.mAdapter.getView(var13, (View)null, this);
               }

               if(var21 != null) {
                  this.mRecycler.put(var13, var21);
               }

               var14 = 0;
               var15 = 0;
               if(var21 != null) {
                  if(var21.getLayoutParams() == null) {
                     this.mBlockLayoutRequests = true;
                     var21.setLayoutParams(this.generateDefaultLayoutParams());
                     this.mBlockLayoutRequests = false;
                  }

                  this.measureChild(var21, var1, var2);
                  var14 = this.getChildHeight(var21) + this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
                  var15 = this.getChildWidth(var21) + this.mSpinnerPadding.left + this.mSpinnerPadding.right;
                  var12 = false;
               }
            }
         }
      }

      if(var12) {
         var14 = this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
         if(var3 == 0) {
            var15 = this.mSpinnerPadding.left + this.mSpinnerPadding.right;
         }
      }

      int var16 = Math.max(var14, this.getSuggestedMinimumHeight());
      int var17 = Math.max(var15, this.getSuggestedMinimumWidth());
      int var18 = resolveSize(var16, var2);
      this.setMeasuredDimension(resolveSize(var17, var1), var18);
      this.mHeightMeasureSpec = var2;
      this.mWidthMeasureSpec = var1;
   }

   public void onRestoreInstanceState(Parcelable var1) {
      AbsSpinnerICS.SavedState var2 = (AbsSpinnerICS.SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      if(var2.selectedId >= 0L) {
         this.mDataChanged = true;
         this.mNeedSync = true;
         this.mSyncRowId = var2.selectedId;
         this.mSyncPosition = var2.position;
         this.mSyncMode = 0;
         this.requestLayout();
      }

   }

   public Parcelable onSaveInstanceState() {
      AbsSpinnerICS.SavedState var1 = new AbsSpinnerICS.SavedState(super.onSaveInstanceState());
      var1.selectedId = this.getSelectedItemId();
      if(var1.selectedId >= 0L) {
         var1.position = this.getSelectedItemPosition();
         return var1;
      } else {
         var1.position = -1;
         return var1;
      }
   }

   public int pointToPosition(int var1, int var2) {
      Rect var3 = this.mTouchFrame;
      if(var3 == null) {
         this.mTouchFrame = new Rect();
         var3 = this.mTouchFrame;
      }

      for(int var4 = -1 + this.getChildCount(); var4 >= 0; --var4) {
         View var5 = this.getChildAt(var4);
         if(var5.getVisibility() == 0) {
            var5.getHitRect(var3);
            if(var3.contains(var1, var2)) {
               return var4 + this.mFirstPosition;
            }
         }
      }

      return -1;
   }

   void recycleAllViews() {
      int var1 = this.getChildCount();
      AbsSpinnerICS.RecycleBin var2 = this.mRecycler;
      int var3 = this.mFirstPosition;

      for(int var4 = 0; var4 < var1; ++var4) {
         View var5 = this.getChildAt(var4);
         var2.put(var3 + var4, var5);
      }

   }

   public void requestLayout() {
      if(!this.mBlockLayoutRequests) {
         super.requestLayout();
      }

   }

   void resetList() {
      this.mDataChanged = false;
      this.mNeedSync = false;
      this.removeAllViewsInLayout();
      this.mOldSelectedPosition = -1;
      this.mOldSelectedRowId = Long.MIN_VALUE;
      this.setSelectedPositionInt(-1);
      this.setNextSelectedPositionInt(-1);
      this.invalidate();
   }

   public void setAdapter(SpinnerAdapter var1) {
      byte var2 = -1;
      if(this.mAdapter != null) {
         this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
         this.resetList();
      }

      this.mAdapter = var1;
      this.mOldSelectedPosition = var2;
      this.mOldSelectedRowId = Long.MIN_VALUE;
      if(this.mAdapter != null) {
         this.mOldItemCount = this.mItemCount;
         this.mItemCount = this.mAdapter.getCount();
         this.checkFocus();
         this.mDataSetObserver = new AdapterViewICS.AdapterDataSetObserver();
         this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
         if(this.mItemCount > 0) {
            var2 = 0;
         }

         this.setSelectedPositionInt(var2);
         this.setNextSelectedPositionInt(var2);
         if(this.mItemCount == 0) {
            this.checkSelectionChanged();
         }
      } else {
         this.checkFocus();
         this.resetList();
         this.checkSelectionChanged();
      }

      this.requestLayout();
   }

   public void setSelection(int var1) {
      this.setNextSelectedPositionInt(var1);
      this.requestLayout();
      this.invalidate();
   }

   public void setSelection(int var1, boolean var2) {
      boolean var3;
      if(var2 && this.mFirstPosition <= var1 && var1 <= -1 + this.mFirstPosition + this.getChildCount()) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.setSelectionInt(var1, var3);
   }

   void setSelectionInt(int var1, boolean var2) {
      if(var1 != this.mOldSelectedPosition) {
         this.mBlockLayoutRequests = true;
         int var3 = var1 - this.mSelectedPosition;
         this.setNextSelectedPositionInt(var1);
         this.layout(var3, var2);
         this.mBlockLayoutRequests = false;
      }

   }

   class RecycleBin {
      private final SparseArray<View> mScrapHeap = new SparseArray();

      void clear() {
         SparseArray var1 = this.mScrapHeap;
         int var2 = var1.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            View var4 = (View)var1.valueAt(var3);
            if(var4 != null) {
               AbsSpinnerICS.this.removeDetachedView(var4, true);
            }
         }

         var1.clear();
      }

      View get(int var1) {
         View var2 = (View)this.mScrapHeap.get(var1);
         if(var2 != null) {
            this.mScrapHeap.delete(var1);
         }

         return var2;
      }

      public void put(int var1, View var2) {
         this.mScrapHeap.put(var1, var2);
      }
   }

   static class SavedState extends BaseSavedState {
      public static final Creator<AbsSpinnerICS.SavedState> CREATOR = new Creator() {
         public AbsSpinnerICS.SavedState createFromParcel(Parcel var1) {
            return new AbsSpinnerICS.SavedState(var1);
         }

         public AbsSpinnerICS.SavedState[] newArray(int var1) {
            return new AbsSpinnerICS.SavedState[var1];
         }
      };
      int position;
      long selectedId;

      private SavedState(Parcel var1) {
         super(var1);
         this.selectedId = var1.readLong();
         this.position = var1.readInt();
      }

      // $FF: synthetic method
      SavedState(Parcel var1, Object var2) {
         this(var1);
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      public String toString() {
         return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeLong(this.selectedId);
         var1.writeInt(this.position);
      }
   }
}
