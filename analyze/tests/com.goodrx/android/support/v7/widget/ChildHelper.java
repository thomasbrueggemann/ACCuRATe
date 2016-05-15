package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
   private static final boolean DEBUG = false;
   private static final String TAG = "ChildrenHelper";
   final ChildHelper.Bucket mBucket;
   final ChildHelper.Callback mCallback;
   final List<View> mHiddenViews;

   ChildHelper(ChildHelper.Callback var1) {
      this.mCallback = var1;
      this.mBucket = new ChildHelper.Bucket();
      this.mHiddenViews = new ArrayList();
   }

   private int getOffset(int var1) {
      int var3;
      if(var1 < 0) {
         var3 = -1;
      } else {
         int var2 = this.mCallback.getChildCount();
         var3 = var1;

         while(true) {
            if(var3 >= var2) {
               return -1;
            }

            int var4 = var1 - (var3 - this.mBucket.countOnesBefore(var3));
            if(var4 == 0) {
               while(this.mBucket.get(var3)) {
                  ++var3;
               }
               break;
            }

            var3 += var4;
         }
      }

      return var3;
   }

   private void hideViewInternal(View var1) {
      this.mHiddenViews.add(var1);
      this.mCallback.onEnteredHiddenState(var1);
   }

   private boolean unhideViewInternal(View var1) {
      if(this.mHiddenViews.remove(var1)) {
         this.mCallback.onLeftHiddenState(var1);
         return true;
      } else {
         return false;
      }
   }

   void addView(View var1, int var2, boolean var3) {
      int var4;
      if(var2 < 0) {
         var4 = this.mCallback.getChildCount();
      } else {
         var4 = this.getOffset(var2);
      }

      this.mBucket.insert(var4, var3);
      if(var3) {
         this.hideViewInternal(var1);
      }

      this.mCallback.addView(var1, var4);
   }

   void addView(View var1, boolean var2) {
      this.addView(var1, -1, var2);
   }

   void attachViewToParent(View var1, int var2, LayoutParams var3, boolean var4) {
      int var5;
      if(var2 < 0) {
         var5 = this.mCallback.getChildCount();
      } else {
         var5 = this.getOffset(var2);
      }

      this.mBucket.insert(var5, var4);
      if(var4) {
         this.hideViewInternal(var1);
      }

      this.mCallback.attachViewToParent(var1, var5, var3);
   }

   void detachViewFromParent(int var1) {
      int var2 = this.getOffset(var1);
      this.mBucket.remove(var2);
      this.mCallback.detachViewFromParent(var2);
   }

   View findHiddenNonRemovedView(int var1, int var2) {
      int var3 = this.mHiddenViews.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         View var5 = (View)this.mHiddenViews.get(var4);
         RecyclerView.ViewHolder var6 = this.mCallback.getChildViewHolder(var5);
         if(var6.getLayoutPosition() == var1 && !var6.isInvalid() && !var6.isRemoved() && (var2 == -1 || var6.getItemViewType() == var2)) {
            return var5;
         }
      }

      return null;
   }

   View getChildAt(int var1) {
      int var2 = this.getOffset(var1);
      return this.mCallback.getChildAt(var2);
   }

   int getChildCount() {
      return this.mCallback.getChildCount() - this.mHiddenViews.size();
   }

   View getUnfilteredChildAt(int var1) {
      return this.mCallback.getChildAt(var1);
   }

   int getUnfilteredChildCount() {
      return this.mCallback.getChildCount();
   }

   void hide(View var1) {
      int var2 = this.mCallback.indexOfChild(var1);
      if(var2 < 0) {
         throw new IllegalArgumentException("view is not a child, cannot hide " + var1);
      } else {
         this.mBucket.set(var2);
         this.hideViewInternal(var1);
      }
   }

   int indexOfChild(View var1) {
      int var2 = this.mCallback.indexOfChild(var1);
      return var2 != -1 && !this.mBucket.get(var2)?var2 - this.mBucket.countOnesBefore(var2):-1;
   }

   boolean isHidden(View var1) {
      return this.mHiddenViews.contains(var1);
   }

   void removeAllViewsUnfiltered() {
      this.mBucket.reset();

      for(int var1 = -1 + this.mHiddenViews.size(); var1 >= 0; --var1) {
         this.mCallback.onLeftHiddenState((View)this.mHiddenViews.get(var1));
         this.mHiddenViews.remove(var1);
      }

      this.mCallback.removeAllViews();
   }

   void removeView(View var1) {
      int var2 = this.mCallback.indexOfChild(var1);
      if(var2 >= 0) {
         if(this.mBucket.remove(var2)) {
            this.unhideViewInternal(var1);
         }

         this.mCallback.removeViewAt(var2);
      }
   }

   void removeViewAt(int var1) {
      int var2 = this.getOffset(var1);
      View var3 = this.mCallback.getChildAt(var2);
      if(var3 != null) {
         if(this.mBucket.remove(var2)) {
            this.unhideViewInternal(var3);
         }

         this.mCallback.removeViewAt(var2);
      }
   }

   boolean removeViewIfHidden(View var1) {
      int var2 = this.mCallback.indexOfChild(var1);
      if(var2 == -1) {
         if(this.unhideViewInternal(var1)) {
            ;
         }

         return true;
      } else if(this.mBucket.get(var2)) {
         this.mBucket.remove(var2);
         if(!this.unhideViewInternal(var1)) {
            ;
         }

         this.mCallback.removeViewAt(var2);
         return true;
      } else {
         return false;
      }
   }

   public String toString() {
      return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
   }

   void unhide(View var1) {
      int var2 = this.mCallback.indexOfChild(var1);
      if(var2 < 0) {
         throw new IllegalArgumentException("view is not a child, cannot hide " + var1);
      } else if(!this.mBucket.get(var2)) {
         throw new RuntimeException("trying to unhide a view that was not hidden" + var1);
      } else {
         this.mBucket.clear(var2);
         this.unhideViewInternal(var1);
      }
   }

   static class Bucket {
      static final int BITS_PER_WORD = 64;
      static final long LAST_BIT = Long.MIN_VALUE;
      long mData = 0L;
      ChildHelper.Bucket next;

      private void ensureNext() {
         if(this.next == null) {
            this.next = new ChildHelper.Bucket();
         }

      }

      void clear(int var1) {
         if(var1 >= 64) {
            if(this.next != null) {
               this.next.clear(var1 - 64);
            }

         } else {
            this.mData &= ~(1L << var1);
         }
      }

      int countOnesBefore(int var1) {
         return this.next == null?(var1 >= 64?Long.bitCount(this.mData):Long.bitCount(this.mData & (1L << var1) - 1L)):(var1 < 64?Long.bitCount(this.mData & (1L << var1) - 1L):this.next.countOnesBefore(var1 - 64) + Long.bitCount(this.mData));
      }

      boolean get(int var1) {
         if(var1 >= 64) {
            this.ensureNext();
            return this.next.get(var1 - 64);
         } else {
            return (this.mData & 1L << var1) != 0L;
         }
      }

      void insert(int var1, boolean var2) {
         if(var1 >= 64) {
            this.ensureNext();
            this.next.insert(var1 - 64, var2);
         } else {
            boolean var3;
            if((Long.MIN_VALUE & this.mData) != 0L) {
               var3 = true;
            } else {
               var3 = false;
            }

            long var4 = (1L << var1) - 1L;
            this.mData = var4 & this.mData | (this.mData & ~var4) << 1;
            if(var2) {
               this.set(var1);
            } else {
               this.clear(var1);
            }

            if(var3 || this.next != null) {
               this.ensureNext();
               this.next.insert(0, var3);
               return;
            }
         }

      }

      boolean remove(int var1) {
         boolean var4;
         if(var1 >= 64) {
            this.ensureNext();
            var4 = this.next.remove(var1 - 64);
         } else {
            long var2 = 1L << var1;
            if((var2 & this.mData) != 0L) {
               var4 = true;
            } else {
               var4 = false;
            }

            this.mData &= ~var2;
            long var5 = var2 - 1L;
            this.mData = var5 & this.mData | Long.rotateRight(this.mData & ~var5, 1);
            if(this.next != null) {
               if(this.next.get(0)) {
                  this.set(63);
               }

               this.next.remove(0);
               return var4;
            }
         }

         return var4;
      }

      void reset() {
         this.mData = 0L;
         if(this.next != null) {
            this.next.reset();
         }

      }

      void set(int var1) {
         if(var1 >= 64) {
            this.ensureNext();
            this.next.set(var1 - 64);
         } else {
            this.mData |= 1L << var1;
         }
      }

      public String toString() {
         return this.next == null?Long.toBinaryString(this.mData):this.next.toString() + "xx" + Long.toBinaryString(this.mData);
      }
   }

   interface Callback {
      void addView(View var1, int var2);

      void attachViewToParent(View var1, int var2, LayoutParams var3);

      void detachViewFromParent(int var1);

      View getChildAt(int var1);

      int getChildCount();

      RecyclerView.ViewHolder getChildViewHolder(View var1);

      int indexOfChild(View var1);

      void onEnteredHiddenState(View var1);

      void onLeftHiddenState(View var1);

      void removeAllViews();

      void removeViewAt(int var1);
   }
}
