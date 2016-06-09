package android.support.v7.widget.helper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.animation.AnimatorListenerCompat;
import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.class_51;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchUIUtil;
import android.support.v7.widget.helper.ItemTouchUIUtilImpl;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
   private static final int ACTION_MODE_DRAG_MASK = 16711680;
   private static final int ACTION_MODE_IDLE_MASK = 255;
   private static final int ACTION_MODE_SWIPE_MASK = 65280;
   public static final int ACTION_STATE_DRAG = 2;
   public static final int ACTION_STATE_IDLE = 0;
   public static final int ACTION_STATE_SWIPE = 1;
   private static final int ACTIVE_POINTER_ID_NONE = -1;
   public static final int ANIMATION_TYPE_DRAG = 8;
   public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
   public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
   private static final boolean DEBUG = false;
   private static final int DIRECTION_FLAG_COUNT = 8;
   public static final int DOWN = 2;
   public static final int END = 32;
   public static final int LEFT = 4;
   private static final int PIXELS_PER_SECOND = 1000;
   public static final int RIGHT = 8;
   public static final int START = 16;
   private static final String TAG = "ItemTouchHelper";
   // $FF: renamed from: UP int
   public static final int field_123 = 1;
   int mActionState = 0;
   int mActivePointerId = -1;
   ItemTouchHelper.Callback mCallback;
   private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
   private List<Integer> mDistances;
   private long mDragScrollStartTimeInMs;
   float mDx;
   float mDy;
   private GestureDetectorCompat mGestureDetector;
   float mInitialTouchX;
   float mInitialTouchY;
   float mMaxSwipeVelocity;
   private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() {
      public boolean onInterceptTouchEvent(RecyclerView var1, MotionEvent var2) {
         ItemTouchHelper.this.mGestureDetector.onTouchEvent(var2);
         int var4 = MotionEventCompat.getActionMasked(var2);
         if(var4 == 0) {
            ItemTouchHelper.this.mActivePointerId = MotionEventCompat.getPointerId(var2, 0);
            ItemTouchHelper.this.mInitialTouchX = var2.getX();
            ItemTouchHelper.this.mInitialTouchY = var2.getY();
            ItemTouchHelper.this.obtainVelocityTracker();
            if(ItemTouchHelper.this.mSelected == null) {
               ItemTouchHelper.RecoverAnimation var7 = ItemTouchHelper.this.findAnimation(var2);
               if(var7 != null) {
                  ItemTouchHelper var8 = ItemTouchHelper.this;
                  var8.mInitialTouchX -= var7.field_104;
                  ItemTouchHelper var9 = ItemTouchHelper.this;
                  var9.mInitialTouchY -= var7.field_105;
                  ItemTouchHelper.this.endRecoverAnimation(var7.mViewHolder, true);
                  if(ItemTouchHelper.this.mPendingCleanup.remove(var7.mViewHolder.itemView)) {
                     ItemTouchHelper.this.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, var7.mViewHolder);
                  }

                  ItemTouchHelper.this.select(var7.mViewHolder, var7.mActionState);
                  ItemTouchHelper.this.updateDxDy(var2, ItemTouchHelper.this.mSelectedFlags, 0);
               }
            }
         } else if(var4 != 3 && var4 != 1) {
            if(ItemTouchHelper.this.mActivePointerId != -1) {
               int var5 = MotionEventCompat.findPointerIndex(var2, ItemTouchHelper.this.mActivePointerId);
               if(var5 >= 0) {
                  ItemTouchHelper.this.checkSelectForSwipe(var4, var2, var5);
               }
            }
         } else {
            ItemTouchHelper.this.mActivePointerId = -1;
            ItemTouchHelper.this.select((RecyclerView.ViewHolder)null, 0);
         }

         if(ItemTouchHelper.this.mVelocityTracker != null) {
            ItemTouchHelper.this.mVelocityTracker.addMovement(var2);
         }

         return ItemTouchHelper.this.mSelected != null;
      }

      public void onRequestDisallowInterceptTouchEvent(boolean var1) {
         if(var1) {
            ItemTouchHelper.this.select((RecyclerView.ViewHolder)null, 0);
         }
      }

      public void onTouchEvent(RecyclerView var1, MotionEvent var2) {
         ItemTouchHelper.this.mGestureDetector.onTouchEvent(var2);
         if(ItemTouchHelper.this.mVelocityTracker != null) {
            ItemTouchHelper.this.mVelocityTracker.addMovement(var2);
         }

         if(ItemTouchHelper.this.mActivePointerId != -1) {
            int var4 = MotionEventCompat.getActionMasked(var2);
            int var5 = MotionEventCompat.findPointerIndex(var2, ItemTouchHelper.this.mActivePointerId);
            if(var5 >= 0) {
               ItemTouchHelper.this.checkSelectForSwipe(var4, var2, var5);
            }

            RecyclerView.ViewHolder var6 = ItemTouchHelper.this.mSelected;
            if(var6 != null) {
               switch(var4) {
               case 2:
                  if(var5 >= 0) {
                     ItemTouchHelper.this.updateDxDy(var2, ItemTouchHelper.this.mSelectedFlags, var5);
                     ItemTouchHelper.this.moveIfNecessary(var6);
                     ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
                     ItemTouchHelper.this.mScrollRunnable.run();
                     ItemTouchHelper.this.mRecyclerView.invalidate();
                     return;
                  }
                  break;
               case 3:
                  if(ItemTouchHelper.this.mVelocityTracker != null) {
                     ItemTouchHelper.this.mVelocityTracker.clear();
                  }
               case 1:
                  ItemTouchHelper.this.select((RecyclerView.ViewHolder)null, 0);
                  ItemTouchHelper.this.mActivePointerId = -1;
                  return;
               case 4:
               case 5:
               default:
                  return;
               case 6:
                  int var7 = MotionEventCompat.getActionIndex(var2);
                  if(MotionEventCompat.getPointerId(var2, var7) == ItemTouchHelper.this.mActivePointerId) {
                     byte var8 = 0;
                     if(var7 == 0) {
                        var8 = 1;
                     }

                     ItemTouchHelper.this.mActivePointerId = MotionEventCompat.getPointerId(var2, var8);
                     ItemTouchHelper.this.updateDxDy(var2, ItemTouchHelper.this.mSelectedFlags, var7);
                     return;
                  }
               }
            }
         }

      }
   };
   private View mOverdrawChild = null;
   private int mOverdrawChildPosition = -1;
   final List<View> mPendingCleanup = new ArrayList();
   List<ItemTouchHelper.RecoverAnimation> mRecoverAnimations = new ArrayList();
   private RecyclerView mRecyclerView;
   private final Runnable mScrollRunnable = new Runnable() {
      public void run() {
         if(ItemTouchHelper.this.mSelected != null && ItemTouchHelper.this.scrollIfNecessary()) {
            if(ItemTouchHelper.this.mSelected != null) {
               ItemTouchHelper.this.moveIfNecessary(ItemTouchHelper.this.mSelected);
            }

            ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
            ViewCompat.postOnAnimation(ItemTouchHelper.this.mRecyclerView, this);
         }

      }
   };
   RecyclerView.ViewHolder mSelected = null;
   int mSelectedFlags;
   float mSelectedStartX;
   float mSelectedStartY;
   private int mSlop;
   private List<RecyclerView.ViewHolder> mSwapTargets;
   float mSwipeEscapeVelocity;
   private final float[] mTmpPosition = new float[2];
   private Rect mTmpRect;
   private VelocityTracker mVelocityTracker;

   public ItemTouchHelper(ItemTouchHelper.Callback var1) {
      this.mCallback = var1;
   }

   private void addChildDrawingOrderCallback() {
      if(VERSION.SDK_INT < 21) {
         if(this.mChildDrawingOrderCallback == null) {
            this.mChildDrawingOrderCallback = new RecyclerView.ChildDrawingOrderCallback() {
               public int onGetChildDrawingOrder(int var1, int var2) {
                  if(ItemTouchHelper.this.mOverdrawChild != null) {
                     int var3 = ItemTouchHelper.this.mOverdrawChildPosition;
                     if(var3 == -1) {
                        var3 = ItemTouchHelper.this.mRecyclerView.indexOfChild(ItemTouchHelper.this.mOverdrawChild);
                        ItemTouchHelper.this.mOverdrawChildPosition = var3;
                     }

                     if(var2 == var1 - 1) {
                        return var3;
                     }

                     if(var2 >= var3) {
                        return var2 + 1;
                     }
                  }

                  return var2;
               }
            };
         }

         this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
      }
   }

   private int checkHorizontalSwipe(RecyclerView.ViewHolder var1, int var2) {
      if((var2 & 12) != 0) {
         byte var3;
         if(this.mDx > 0.0F) {
            var3 = 8;
         } else {
            var3 = 4;
         }

         if(this.mVelocityTracker != null && this.mActivePointerId > -1) {
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            float var5 = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
            float var6 = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
            byte var7;
            if(var5 > 0.0F) {
               var7 = 8;
            } else {
               var7 = 4;
            }

            float var8 = Math.abs(var5);
            if((var7 & var2) != 0 && var3 == var7 && var8 >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && var8 > Math.abs(var6)) {
               return var7;
            }
         }

         float var4 = (float)this.mRecyclerView.getWidth() * this.mCallback.getSwipeThreshold(var1);
         if((var2 & var3) != 0 && Math.abs(this.mDx) > var4) {
            return var3;
         }
      }

      return 0;
   }

   private boolean checkSelectForSwipe(int var1, MotionEvent var2, int var3) {
      if(this.mSelected == null && var1 == 2 && this.mActionState != 2 && this.mCallback.isItemViewSwipeEnabled()) {
         if(this.mRecyclerView.getScrollState() == 1) {
            return false;
         } else {
            RecyclerView.ViewHolder var4 = this.findSwipedView(var2);
            if(var4 == null) {
               return false;
            } else {
               int var5 = ('\uff00' & this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, var4)) >> 8;
               if(var5 == 0) {
                  return false;
               } else {
                  float var6 = MotionEventCompat.getX(var2, var3);
                  float var7 = MotionEventCompat.getY(var2, var3);
                  float var8 = var6 - this.mInitialTouchX;
                  float var9 = var7 - this.mInitialTouchY;
                  float var10 = Math.abs(var8);
                  float var11 = Math.abs(var9);
                  if(var10 < (float)this.mSlop && var11 < (float)this.mSlop) {
                     return false;
                  } else {
                     if(var10 > var11) {
                        if(var8 < 0.0F && (var5 & 4) == 0) {
                           return false;
                        }

                        if(var8 > 0.0F && (var5 & 8) == 0) {
                           return false;
                        }
                     } else {
                        if(var9 < 0.0F && (var5 & 1) == 0) {
                           return false;
                        }

                        if(var9 > 0.0F && (var5 & 2) == 0) {
                           return false;
                        }
                     }

                     this.mDy = 0.0F;
                     this.mDx = 0.0F;
                     this.mActivePointerId = MotionEventCompat.getPointerId(var2, 0);
                     this.select(var4, 1);
                     return true;
                  }
               }
            }
         }
      } else {
         return false;
      }
   }

   private int checkVerticalSwipe(RecyclerView.ViewHolder var1, int var2) {
      if((var2 & 3) != 0) {
         byte var3;
         if(this.mDy > 0.0F) {
            var3 = 2;
         } else {
            var3 = 1;
         }

         if(this.mVelocityTracker != null && this.mActivePointerId > -1) {
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            float var5 = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
            float var6 = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
            byte var7;
            if(var6 > 0.0F) {
               var7 = 2;
            } else {
               var7 = 1;
            }

            float var8 = Math.abs(var6);
            if((var7 & var2) != 0 && var7 == var3 && var8 >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && var8 > Math.abs(var5)) {
               return var7;
            }
         }

         float var4 = (float)this.mRecyclerView.getHeight() * this.mCallback.getSwipeThreshold(var1);
         if((var2 & var3) != 0 && Math.abs(this.mDy) > var4) {
            return var3;
         }
      }

      return 0;
   }

   private void destroyCallbacks() {
      this.mRecyclerView.removeItemDecoration(this);
      this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
      this.mRecyclerView.removeOnChildAttachStateChangeListener(this);

      for(int var1 = -1 + this.mRecoverAnimations.size(); var1 >= 0; --var1) {
         ItemTouchHelper.RecoverAnimation var2 = (ItemTouchHelper.RecoverAnimation)this.mRecoverAnimations.get(0);
         this.mCallback.clearView(this.mRecyclerView, var2.mViewHolder);
      }

      this.mRecoverAnimations.clear();
      this.mOverdrawChild = null;
      this.mOverdrawChildPosition = -1;
      this.releaseVelocityTracker();
   }

   private int endRecoverAnimation(RecyclerView.ViewHolder var1, boolean var2) {
      for(int var3 = -1 + this.mRecoverAnimations.size(); var3 >= 0; --var3) {
         ItemTouchHelper.RecoverAnimation var4 = (ItemTouchHelper.RecoverAnimation)this.mRecoverAnimations.get(var3);
         if(var4.mViewHolder == var1) {
            var4.mOverridden |= var2;
            if(!var4.mEnded) {
               var4.cancel();
            }

            this.mRecoverAnimations.remove(var3);
            return var4.mAnimationType;
         }
      }

      return 0;
   }

   private ItemTouchHelper.RecoverAnimation findAnimation(MotionEvent var1) {
      ItemTouchHelper.RecoverAnimation var4;
      if(this.mRecoverAnimations.isEmpty()) {
         var4 = null;
      } else {
         View var2 = this.findChildView(var1);
         int var3 = -1 + this.mRecoverAnimations.size();

         while(true) {
            if(var3 < 0) {
               return null;
            }

            var4 = (ItemTouchHelper.RecoverAnimation)this.mRecoverAnimations.get(var3);
            if(var4.mViewHolder.itemView == var2) {
               break;
            }

            --var3;
         }
      }

      return var4;
   }

   private View findChildView(MotionEvent var1) {
      float var2 = var1.getX();
      float var3 = var1.getY();
      if(this.mSelected != null) {
         View var7 = this.mSelected.itemView;
         if(hitTest(var7, var2, var3, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
            return var7;
         }
      }

      for(int var4 = -1 + this.mRecoverAnimations.size(); var4 >= 0; --var4) {
         ItemTouchHelper.RecoverAnimation var5 = (ItemTouchHelper.RecoverAnimation)this.mRecoverAnimations.get(var4);
         View var6 = var5.mViewHolder.itemView;
         if(hitTest(var6, var2, var3, var5.field_104, var5.field_105)) {
            return var6;
         }
      }

      return this.mRecyclerView.findChildViewUnder(var2, var3);
   }

   private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder var1) {
      if(this.mSwapTargets == null) {
         this.mSwapTargets = new ArrayList();
         this.mDistances = new ArrayList();
      } else {
         this.mSwapTargets.clear();
         this.mDistances.clear();
      }

      int var2 = this.mCallback.getBoundingBoxMargin();
      int var3 = Math.round(this.mSelectedStartX + this.mDx) - var2;
      int var4 = Math.round(this.mSelectedStartY + this.mDy) - var2;
      int var5 = var3 + var1.itemView.getWidth() + var2 * 2;
      int var6 = var4 + var1.itemView.getHeight() + var2 * 2;
      int var7 = (var3 + var5) / 2;
      int var8 = (var4 + var6) / 2;
      RecyclerView.LayoutManager var9 = this.mRecyclerView.getLayoutManager();
      int var10 = var9.getChildCount();

      for(int var11 = 0; var11 < var10; ++var11) {
         View var12 = var9.getChildAt(var11);
         if(var12 != var1.itemView && var12.getBottom() >= var4 && var12.getTop() <= var6 && var12.getRight() >= var3 && var12.getLeft() <= var5) {
            RecyclerView.ViewHolder var13 = this.mRecyclerView.getChildViewHolder(var12);
            if(this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, var13)) {
               int var14 = Math.abs(var7 - (var12.getLeft() + var12.getRight()) / 2);
               int var15 = Math.abs(var8 - (var12.getTop() + var12.getBottom()) / 2);
               int var16 = var14 * var14 + var15 * var15;
               int var17 = 0;
               int var18 = this.mSwapTargets.size();

               for(int var19 = 0; var19 < var18 && var16 > ((Integer)this.mDistances.get(var19)).intValue(); ++var19) {
                  ++var17;
               }

               this.mSwapTargets.add(var17, var13);
               List var20 = this.mDistances;
               Integer var21 = Integer.valueOf(var16);
               var20.add(var17, var21);
            }
         }
      }

      return this.mSwapTargets;
   }

   private RecyclerView.ViewHolder findSwipedView(MotionEvent var1) {
      RecyclerView.LayoutManager var2 = this.mRecyclerView.getLayoutManager();
      if(this.mActivePointerId != -1) {
         int var3 = MotionEventCompat.findPointerIndex(var1, this.mActivePointerId);
         float var4 = MotionEventCompat.getX(var1, var3) - this.mInitialTouchX;
         float var5 = MotionEventCompat.getY(var1, var3) - this.mInitialTouchY;
         float var6 = Math.abs(var4);
         float var7 = Math.abs(var5);
         if((var6 >= (float)this.mSlop || var7 >= (float)this.mSlop) && (var6 <= var7 || !var2.canScrollHorizontally()) && (var7 <= var6 || !var2.canScrollVertically())) {
            View var8 = this.findChildView(var1);
            if(var8 != null) {
               return this.mRecyclerView.getChildViewHolder(var8);
            }
         }
      }

      return null;
   }

   private void getSelectedDxDy(float[] var1) {
      if((12 & this.mSelectedFlags) != 0) {
         var1[0] = this.mSelectedStartX + this.mDx - (float)this.mSelected.itemView.getLeft();
      } else {
         var1[0] = ViewCompat.getTranslationX(this.mSelected.itemView);
      }

      if((3 & this.mSelectedFlags) != 0) {
         var1[1] = this.mSelectedStartY + this.mDy - (float)this.mSelected.itemView.getTop();
      } else {
         var1[1] = ViewCompat.getTranslationY(this.mSelected.itemView);
      }
   }

   private boolean hasRunningRecoverAnim() {
      int var1 = this.mRecoverAnimations.size();

      for(int var2 = 0; var2 < var1; ++var2) {
         if(!((ItemTouchHelper.RecoverAnimation)this.mRecoverAnimations.get(var2)).mEnded) {
            return true;
         }
      }

      return false;
   }

   private static boolean hitTest(View var0, float var1, float var2, float var3, float var4) {
      return var1 >= var3 && var1 <= var3 + (float)var0.getWidth() && var2 >= var4 && var2 <= var4 + (float)var0.getHeight();
   }

   private void initGestureDetector() {
      if(this.mGestureDetector == null) {
         this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), new ItemTouchHelper.ItemTouchHelperGestureListener(null));
      }
   }

   private void moveIfNecessary(RecyclerView.ViewHolder var1) {
      if(!this.mRecyclerView.isLayoutRequested() && this.mActionState == 2) {
         float var2 = this.mCallback.getMoveThreshold(var1);
         int var3 = (int)(this.mSelectedStartX + this.mDx);
         int var4 = (int)(this.mSelectedStartY + this.mDy);
         if((float)Math.abs(var4 - var1.itemView.getTop()) >= var2 * (float)var1.itemView.getHeight() || (float)Math.abs(var3 - var1.itemView.getLeft()) >= var2 * (float)var1.itemView.getWidth()) {
            List var5 = this.findSwapTargets(var1);
            if(var5.size() != 0) {
               RecyclerView.ViewHolder var6 = this.mCallback.chooseDropTarget(var1, var5, var3, var4);
               if(var6 == null) {
                  this.mSwapTargets.clear();
                  this.mDistances.clear();
                  return;
               }

               int var7 = var6.getAdapterPosition();
               int var8 = var1.getAdapterPosition();
               if(this.mCallback.onMove(this.mRecyclerView, var1, var6)) {
                  this.mCallback.onMoved(this.mRecyclerView, var1, var8, var6, var7, var3, var4);
                  return;
               }
            }
         }
      }

   }

   private void obtainVelocityTracker() {
      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.recycle();
      }

      this.mVelocityTracker = VelocityTracker.obtain();
   }

   private void postDispatchSwipe(final ItemTouchHelper.RecoverAnimation var1, final int var2) {
      this.mRecyclerView.post(new Runnable() {
         public void run() {
            if(ItemTouchHelper.this.mRecyclerView != null && ItemTouchHelper.this.mRecyclerView.isAttachedToWindow() && !var1.mOverridden && var1.mViewHolder.getAdapterPosition() != -1) {
               RecyclerView.ItemAnimator var1x = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
               if(var1x != null && var1x.isRunning((RecyclerView.ItemAnimatorFinishedListener)null) || ItemTouchHelper.this.hasRunningRecoverAnim()) {
                  ItemTouchHelper.this.mRecyclerView.post(this);
                  return;
               }

               ItemTouchHelper.this.mCallback.onSwiped(var1.mViewHolder, var2);
            }

         }
      });
   }

   private void releaseVelocityTracker() {
      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.recycle();
         this.mVelocityTracker = null;
      }

   }

   private void removeChildDrawingOrderCallbackIfNecessary(View var1) {
      if(var1 == this.mOverdrawChild) {
         this.mOverdrawChild = null;
         if(this.mChildDrawingOrderCallback != null) {
            this.mRecyclerView.setChildDrawingOrderCallback((RecyclerView.ChildDrawingOrderCallback)null);
         }
      }

   }

   private boolean scrollIfNecessary() {
      if(this.mSelected == null) {
         this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
         return false;
      } else {
         long var1 = System.currentTimeMillis();
         long var3;
         if(this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
            var3 = 0L;
         } else {
            var3 = var1 - this.mDragScrollStartTimeInMs;
         }

         RecyclerView.LayoutManager var5 = this.mRecyclerView.getLayoutManager();
         if(this.mTmpRect == null) {
            this.mTmpRect = new Rect();
         }

         var5.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
         boolean var6 = var5.canScrollHorizontally();
         int var7 = 0;
         if(var6) {
            int var14 = (int)(this.mSelectedStartX + this.mDx);
            int var15 = var14 - this.mTmpRect.left - this.mRecyclerView.getPaddingLeft();
            if(this.mDx < 0.0F && var15 < 0) {
               var7 = var15;
            } else {
               float var18;
               int var16 = (var18 = this.mDx - 0.0F) == 0.0F?0:(var18 < 0.0F?-1:1);
               var7 = 0;
               if(var16 > 0) {
                  int var17 = var14 + this.mSelected.itemView.getWidth() + this.mTmpRect.right - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight());
                  var7 = 0;
                  if(var17 > 0) {
                     var7 = var17;
                  }
               }
            }
         }

         boolean var8 = var5.canScrollVertically();
         int var9 = 0;
         if(var8) {
            int var10 = (int)(this.mSelectedStartY + this.mDy);
            int var11 = var10 - this.mTmpRect.top - this.mRecyclerView.getPaddingTop();
            if(this.mDy < 0.0F && var11 < 0) {
               var9 = var11;
            } else {
               float var19;
               int var12 = (var19 = this.mDy - 0.0F) == 0.0F?0:(var19 < 0.0F?-1:1);
               var9 = 0;
               if(var12 > 0) {
                  int var13 = var10 + this.mSelected.itemView.getHeight() + this.mTmpRect.bottom - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
                  var9 = 0;
                  if(var13 > 0) {
                     var9 = var13;
                  }
               }
            }
         }

         if(var7 != 0) {
            var7 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), var7, this.mRecyclerView.getWidth(), var3);
         }

         if(var9 != 0) {
            var9 = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), var9, this.mRecyclerView.getHeight(), var3);
         }

         if(var7 == 0 && var9 == 0) {
            this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
            return false;
         } else {
            if(this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
               this.mDragScrollStartTimeInMs = var1;
            }

            this.mRecyclerView.scrollBy(var7, var9);
            return true;
         }
      }
   }

   private void select(RecyclerView.ViewHolder var1, int var2) {
      if(var1 != this.mSelected || var2 != this.mActionState) {
         this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
         final int var3 = this.mActionState;
         this.endRecoverAnimation(var1, true);
         this.mActionState = var2;
         if(var2 == 2) {
            this.mOverdrawChild = var1.itemView;
            this.addChildDrawingOrderCallback();
         }

         int var5 = -1 + (1 << 8 + var2 * 8);
         RecyclerView.ViewHolder var6 = this.mSelected;
         boolean var7 = false;
         if(var6 != null) {
            final RecyclerView.ViewHolder var11 = this.mSelected;
            if(var11.itemView.getParent() != null) {
               final int var12;
               if(var3 == 2) {
                  var12 = 0;
               } else {
                  var12 = this.swipeIfNecessary(var11);
               }

               this.releaseVelocityTracker();
               final float var13;
               final float var14;
               switch(var12) {
               case 1:
               case 2:
                  var13 = Math.signum(this.mDy) * (float)this.mRecyclerView.getHeight();
                  var14 = 0.0F;
                  break;
               case 4:
               case 8:
               case 16:
               case 32:
                  var14 = Math.signum(this.mDx) * (float)this.mRecyclerView.getWidth();
                  var13 = 0.0F;
                  break;
               default:
                  var14 = 0.0F;
                  var13 = 0.0F;
               }

               final byte var15;
               if(var3 == 2) {
                  var15 = 8;
               } else if(var12 > 0) {
                  var15 = 2;
               } else {
                  var15 = 4;
               }

               this.getSelectedDxDy(this.mTmpPosition);
               final float var16 = this.mTmpPosition[0];
               final float var17 = this.mTmpPosition[1];
               ItemTouchHelper.RecoverAnimation var18 = new ItemTouchHelper.RecoverAnimation(var11, var15, var3, var16, var17, var14, var13) {
                  public void onAnimationEnd(ValueAnimatorCompat var1) {
                     super.onAnimationEnd(var1);
                     if(!this.mOverridden) {
                        if(var12 <= 0) {
                           ItemTouchHelper.this.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, var11);
                        } else {
                           ItemTouchHelper.this.mPendingCleanup.add(var11.itemView);
                           this.mIsPendingCleanup = true;
                           if(var12 > 0) {
                              ItemTouchHelper.this.postDispatchSwipe(this, var12);
                           }
                        }

                        if(ItemTouchHelper.this.mOverdrawChild == var11.itemView) {
                           ItemTouchHelper.this.removeChildDrawingOrderCallbackIfNecessary(var11.itemView);
                           return;
                        }
                     }

                  }
               };
               var18.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, var15, var14 - var16, var13 - var17));
               this.mRecoverAnimations.add(var18);
               var18.start();
               var7 = true;
            } else {
               this.removeChildDrawingOrderCallbackIfNecessary(var11.itemView);
               this.mCallback.clearView(this.mRecyclerView, var11);
               var7 = false;
            }

            this.mSelected = null;
         }

         if(var1 != null) {
            this.mSelectedFlags = (var5 & this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, var1)) >> 8 * this.mActionState;
            this.mSelectedStartX = (float)var1.itemView.getLeft();
            this.mSelectedStartY = (float)var1.itemView.getTop();
            this.mSelected = var1;
            if(var2 == 2) {
               this.mSelected.itemView.performHapticFeedback(0);
            }
         }

         ViewParent var8 = this.mRecyclerView.getParent();
         if(var8 != null) {
            boolean var9;
            if(this.mSelected != null) {
               var9 = true;
            } else {
               var9 = false;
            }

            var8.requestDisallowInterceptTouchEvent(var9);
         }

         if(!var7) {
            this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
         }

         this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
         this.mRecyclerView.invalidate();
      }
   }

   private void setupCallbacks() {
      this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
      this.mRecyclerView.addItemDecoration(this);
      this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
      this.mRecyclerView.addOnChildAttachStateChangeListener(this);
      this.initGestureDetector();
   }

   private int swipeIfNecessary(RecyclerView.ViewHolder var1) {
      int var5;
      if(this.mActionState == 2) {
         var5 = 0;
         return var5;
      } else {
         int var2 = this.mCallback.getMovementFlags(this.mRecyclerView, var1);
         int var3 = ('\uff00' & this.mCallback.convertToAbsoluteDirection(var2, ViewCompat.getLayoutDirection(this.mRecyclerView))) >> 8;
         if(var3 == 0) {
            return 0;
         } else {
            int var4 = (var2 & '\uff00') >> 8;
            if(Math.abs(this.mDx) > Math.abs(this.mDy)) {
               var5 = this.checkHorizontalSwipe(var1, var3);
               if(var5 > 0) {
                  if((var4 & var5) == 0) {
                     return ItemTouchHelper.Callback.convertToRelativeDirection(var5, ViewCompat.getLayoutDirection(this.mRecyclerView));
                  }

                  return var5;
               }

               var5 = this.checkVerticalSwipe(var1, var3);
               if(var5 > 0) {
                  return var5;
               }
            } else {
               var5 = this.checkVerticalSwipe(var1, var3);
               if(var5 > 0) {
                  return var5;
               }

               var5 = this.checkHorizontalSwipe(var1, var3);
               if(var5 > 0) {
                  if((var4 & var5) == 0) {
                     return ItemTouchHelper.Callback.convertToRelativeDirection(var5, ViewCompat.getLayoutDirection(this.mRecyclerView));
                  }

                  return var5;
               }
            }

            return 0;
         }
      }
   }

   private void updateDxDy(MotionEvent var1, int var2, int var3) {
      float var4 = MotionEventCompat.getX(var1, var3);
      float var5 = MotionEventCompat.getY(var1, var3);
      this.mDx = var4 - this.mInitialTouchX;
      this.mDy = var5 - this.mInitialTouchY;
      if((var2 & 4) == 0) {
         this.mDx = Math.max(0.0F, this.mDx);
      }

      if((var2 & 8) == 0) {
         this.mDx = Math.min(0.0F, this.mDx);
      }

      if((var2 & 1) == 0) {
         this.mDy = Math.max(0.0F, this.mDy);
      }

      if((var2 & 2) == 0) {
         this.mDy = Math.min(0.0F, this.mDy);
      }

   }

   public void attachToRecyclerView(@Nullable RecyclerView var1) {
      if(this.mRecyclerView != var1) {
         if(this.mRecyclerView != null) {
            this.destroyCallbacks();
         }

         this.mRecyclerView = var1;
         if(this.mRecyclerView != null) {
            Resources var2 = var1.getResources();
            this.mSwipeEscapeVelocity = var2.getDimension(class_51.dimen.item_touch_helper_swipe_escape_velocity);
            this.mMaxSwipeVelocity = var2.getDimension(class_51.dimen.item_touch_helper_swipe_escape_max_velocity);
            this.setupCallbacks();
            return;
         }
      }

   }

   public void getItemOffsets(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
      var1.setEmpty();
   }

   public void onChildViewAttachedToWindow(View var1) {
   }

   public void onChildViewDetachedFromWindow(View var1) {
      this.removeChildDrawingOrderCallbackIfNecessary(var1);
      RecyclerView.ViewHolder var2 = this.mRecyclerView.getChildViewHolder(var1);
      if(var2 != null) {
         if(this.mSelected != null && var2 == this.mSelected) {
            this.select((RecyclerView.ViewHolder)null, 0);
            return;
         }

         this.endRecoverAnimation(var2, false);
         if(this.mPendingCleanup.remove(var2.itemView)) {
            this.mCallback.clearView(this.mRecyclerView, var2);
            return;
         }
      }

   }

   public void onDraw(Canvas var1, RecyclerView var2, RecyclerView.State var3) {
      this.mOverdrawChildPosition = -1;
      RecyclerView.ViewHolder var4 = this.mSelected;
      float var5 = 0.0F;
      float var6 = 0.0F;
      if(var4 != null) {
         this.getSelectedDxDy(this.mTmpPosition);
         var5 = this.mTmpPosition[0];
         var6 = this.mTmpPosition[1];
      }

      this.mCallback.onDraw(var1, var2, this.mSelected, this.mRecoverAnimations, this.mActionState, var5, var6);
   }

   public void onDrawOver(Canvas var1, RecyclerView var2, RecyclerView.State var3) {
      RecyclerView.ViewHolder var4 = this.mSelected;
      float var5 = 0.0F;
      float var6 = 0.0F;
      if(var4 != null) {
         this.getSelectedDxDy(this.mTmpPosition);
         var5 = this.mTmpPosition[0];
         var6 = this.mTmpPosition[1];
      }

      this.mCallback.onDrawOver(var1, var2, this.mSelected, this.mRecoverAnimations, this.mActionState, var5, var6);
   }

   public void startDrag(RecyclerView.ViewHolder var1) {
      if(!this.mCallback.hasDragFlag(this.mRecyclerView, var1)) {
         Log.e("ItemTouchHelper", "Start drag has been called but swiping is not enabled");
      } else if(var1.itemView.getParent() != this.mRecyclerView) {
         Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
      } else {
         this.obtainVelocityTracker();
         this.mDy = 0.0F;
         this.mDx = 0.0F;
         this.select(var1, 2);
      }
   }

   public void startSwipe(RecyclerView.ViewHolder var1) {
      if(!this.mCallback.hasSwipeFlag(this.mRecyclerView, var1)) {
         Log.e("ItemTouchHelper", "Start swipe has been called but dragging is not enabled");
      } else if(var1.itemView.getParent() != this.mRecyclerView) {
         Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
      } else {
         this.obtainVelocityTracker();
         this.mDy = 0.0F;
         this.mDx = 0.0F;
         this.select(var1, 1);
      }
   }

   public abstract static class Callback {
      private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
      public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
      public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
      private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000L;
      static final int RELATIVE_DIR_FLAGS = 3158064;
      private static final Interpolator sDragScrollInterpolator = new Interpolator() {
         public float getInterpolation(float var1) {
            return var1 * var1 * var1 * var1 * var1;
         }
      };
      private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator() {
         public float getInterpolation(float var1) {
            float var2 = var1 - 1.0F;
            return 1.0F + var2 * var2 * var2 * var2 * var2;
         }
      };
      private static final ItemTouchUIUtil sUICallback;
      private int mCachedMaxScrollSpeed = -1;

      static {
         if(VERSION.SDK_INT >= 21) {
            sUICallback = new ItemTouchUIUtilImpl.Lollipop();
         } else if(VERSION.SDK_INT >= 11) {
            sUICallback = new ItemTouchUIUtilImpl.Honeycomb();
         } else {
            sUICallback = new ItemTouchUIUtilImpl.Gingerbread();
         }
      }

      public static int convertToRelativeDirection(int var0, int var1) {
         int var2 = var0 & 789516;
         if(var2 == 0) {
            return var0;
         } else {
            int var3 = var0 & ~var2;
            return var1 == 0?var3 | var2 << 2:var3 | -789517 & var2 << 1 | (789516 & var2 << 1) << 2;
         }
      }

      public static ItemTouchUIUtil getDefaultUIUtil() {
         return sUICallback;
      }

      private int getMaxDragScroll(RecyclerView var1) {
         if(this.mCachedMaxScrollSpeed == -1) {
            this.mCachedMaxScrollSpeed = var1.getResources().getDimensionPixelSize(class_51.dimen.item_touch_helper_max_drag_scroll_per_frame);
         }

         return this.mCachedMaxScrollSpeed;
      }

      private boolean hasDragFlag(RecyclerView var1, RecyclerView.ViewHolder var2) {
         return (16711680 & this.getAbsoluteMovementFlags(var1, var2)) != 0;
      }

      private boolean hasSwipeFlag(RecyclerView var1, RecyclerView.ViewHolder var2) {
         return ('\uff00' & this.getAbsoluteMovementFlags(var1, var2)) != 0;
      }

      public static int makeFlag(int var0, int var1) {
         return var1 << var0 * 8;
      }

      public static int makeMovementFlags(int var0, int var1) {
         return makeFlag(0, var1 | var0) | makeFlag(1, var1) | makeFlag(2, var0);
      }

      private void onDraw(Canvas var1, RecyclerView var2, RecyclerView.ViewHolder var3, List<ItemTouchHelper.RecoverAnimation> var4, int var5, float var6, float var7) {
         int var8 = var4.size();

         for(int var9 = 0; var9 < var8; ++var9) {
            ItemTouchHelper.RecoverAnimation var11 = (ItemTouchHelper.RecoverAnimation)var4.get(var9);
            var11.update();
            int var12 = var1.save();
            this.onChildDraw(var1, var2, var11.mViewHolder, var11.field_104, var11.field_105, var11.mActionState, false);
            var1.restoreToCount(var12);
         }

         if(var3 != null) {
            int var10 = var1.save();
            this.onChildDraw(var1, var2, var3, var6, var7, var5, true);
            var1.restoreToCount(var10);
         }

      }

      private void onDrawOver(Canvas var1, RecyclerView var2, RecyclerView.ViewHolder var3, List<ItemTouchHelper.RecoverAnimation> var4, int var5, float var6, float var7) {
         int var8 = var4.size();

         for(int var9 = 0; var9 < var8; ++var9) {
            ItemTouchHelper.RecoverAnimation var15 = (ItemTouchHelper.RecoverAnimation)var4.get(var9);
            int var16 = var1.save();
            this.onChildDrawOver(var1, var2, var15.mViewHolder, var15.field_104, var15.field_105, var15.mActionState, false);
            var1.restoreToCount(var16);
         }

         if(var3 != null) {
            int var14 = var1.save();
            this.onChildDrawOver(var1, var2, var3, var6, var7, var5, true);
            var1.restoreToCount(var14);
         }

         boolean var10 = false;

         for(int var11 = var8 - 1; var11 >= 0; --var11) {
            ItemTouchHelper.RecoverAnimation var12 = (ItemTouchHelper.RecoverAnimation)var4.get(var11);
            if(var12.mEnded && !var12.mIsPendingCleanup) {
               var4.remove(var11);
            } else if(!var12.mEnded) {
               var10 = true;
            }
         }

         if(var10) {
            var2.invalidate();
         }

      }

      public boolean canDropOver(RecyclerView var1, RecyclerView.ViewHolder var2, RecyclerView.ViewHolder var3) {
         return true;
      }

      public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder var1, List<RecyclerView.ViewHolder> var2, int var3, int var4) {
         int var5 = var3 + var1.itemView.getWidth();
         int var6 = var4 + var1.itemView.getHeight();
         RecyclerView.ViewHolder var7 = null;
         int var8 = -1;
         int var9 = var3 - var1.itemView.getLeft();
         int var10 = var4 - var1.itemView.getTop();
         int var11 = var2.size();

         for(int var12 = 0; var12 < var11; ++var12) {
            RecyclerView.ViewHolder var13 = (RecyclerView.ViewHolder)var2.get(var12);
            if(var9 > 0) {
               int var20 = var13.itemView.getRight() - var5;
               if(var20 < 0 && var13.itemView.getRight() > var1.itemView.getRight()) {
                  int var21 = Math.abs(var20);
                  if(var21 > var8) {
                     var8 = var21;
                     var7 = var13;
                  }
               }
            }

            if(var9 < 0) {
               int var18 = var13.itemView.getLeft() - var3;
               if(var18 > 0 && var13.itemView.getLeft() < var1.itemView.getLeft()) {
                  int var19 = Math.abs(var18);
                  if(var19 > var8) {
                     var8 = var19;
                     var7 = var13;
                  }
               }
            }

            if(var10 < 0) {
               int var16 = var13.itemView.getTop() - var4;
               if(var16 > 0 && var13.itemView.getTop() < var1.itemView.getTop()) {
                  int var17 = Math.abs(var16);
                  if(var17 > var8) {
                     var8 = var17;
                     var7 = var13;
                  }
               }
            }

            if(var10 > 0) {
               int var14 = var13.itemView.getBottom() - var6;
               if(var14 < 0 && var13.itemView.getBottom() > var1.itemView.getBottom()) {
                  int var15 = Math.abs(var14);
                  if(var15 > var8) {
                     var8 = var15;
                     var7 = var13;
                  }
               }
            }
         }

         return var7;
      }

      public void clearView(RecyclerView var1, RecyclerView.ViewHolder var2) {
         sUICallback.clearView(var2.itemView);
      }

      public int convertToAbsoluteDirection(int var1, int var2) {
         int var3 = var1 & 3158064;
         if(var3 == 0) {
            return var1;
         } else {
            int var4 = var1 & ~var3;
            return var2 == 0?var4 | var3 >> 2:var4 | -3158065 & var3 >> 1 | (3158064 & var3 >> 1) >> 2;
         }
      }

      final int getAbsoluteMovementFlags(RecyclerView var1, RecyclerView.ViewHolder var2) {
         return this.convertToAbsoluteDirection(this.getMovementFlags(var1, var2), ViewCompat.getLayoutDirection(var1));
      }

      public long getAnimationDuration(RecyclerView var1, int var2, float var3, float var4) {
         RecyclerView.ItemAnimator var5 = var1.getItemAnimator();
         return var5 == null?(var2 == 8?200L:250L):(var2 == 8?var5.getMoveDuration():var5.getRemoveDuration());
      }

      public int getBoundingBoxMargin() {
         return 0;
      }

      public float getMoveThreshold(RecyclerView.ViewHolder var1) {
         return 0.5F;
      }

      public abstract int getMovementFlags(RecyclerView var1, RecyclerView.ViewHolder var2);

      public float getSwipeEscapeVelocity(float var1) {
         return var1;
      }

      public float getSwipeThreshold(RecyclerView.ViewHolder var1) {
         return 0.5F;
      }

      public float getSwipeVelocityThreshold(float var1) {
         return var1;
      }

      public int interpolateOutOfBoundsScroll(RecyclerView var1, int var2, int var3, int var4, long var5) {
         int var7 = this.getMaxDragScroll(var1);
         int var8 = Math.abs(var3);
         int var9 = (int)Math.signum((float)var3);
         float var10 = Math.min(1.0F, 1.0F * (float)var8 / (float)var2);
         int var11 = (int)((float)(var9 * var7) * sDragViewScrollCapInterpolator.getInterpolation(var10));
         float var12;
         if(var5 > 2000L) {
            var12 = 1.0F;
         } else {
            var12 = (float)var5 / 2000.0F;
         }

         int var13 = (int)((float)var11 * sDragScrollInterpolator.getInterpolation(var12));
         return var13 == 0?(var3 > 0?1:-1):var13;
      }

      public boolean isItemViewSwipeEnabled() {
         return true;
      }

      public boolean isLongPressDragEnabled() {
         return true;
      }

      public void onChildDraw(Canvas var1, RecyclerView var2, RecyclerView.ViewHolder var3, float var4, float var5, int var6, boolean var7) {
         sUICallback.onDraw(var1, var2, var3.itemView, var4, var5, var6, var7);
      }

      public void onChildDrawOver(Canvas var1, RecyclerView var2, RecyclerView.ViewHolder var3, float var4, float var5, int var6, boolean var7) {
         sUICallback.onDrawOver(var1, var2, var3.itemView, var4, var5, var6, var7);
      }

      public abstract boolean onMove(RecyclerView var1, RecyclerView.ViewHolder var2, RecyclerView.ViewHolder var3);

      public void onMoved(RecyclerView var1, RecyclerView.ViewHolder var2, int var3, RecyclerView.ViewHolder var4, int var5, int var6, int var7) {
         RecyclerView.LayoutManager var8 = var1.getLayoutManager();
         if(var8 instanceof ItemTouchHelper.ViewDropHandler) {
            ((ItemTouchHelper.ViewDropHandler)var8).prepareForDrop(var2.itemView, var4.itemView, var6, var7);
         } else {
            if(var8.canScrollHorizontally()) {
               if(var8.getDecoratedLeft(var4.itemView) <= var1.getPaddingLeft()) {
                  var1.scrollToPosition(var5);
               }

               if(var8.getDecoratedRight(var4.itemView) >= var1.getWidth() - var1.getPaddingRight()) {
                  var1.scrollToPosition(var5);
               }
            }

            if(var8.canScrollVertically()) {
               if(var8.getDecoratedTop(var4.itemView) <= var1.getPaddingTop()) {
                  var1.scrollToPosition(var5);
               }

               if(var8.getDecoratedBottom(var4.itemView) >= var1.getHeight() - var1.getPaddingBottom()) {
                  var1.scrollToPosition(var5);
                  return;
               }
            }
         }

      }

      public void onSelectedChanged(RecyclerView.ViewHolder var1, int var2) {
         if(var1 != null) {
            sUICallback.onSelected(var1.itemView);
         }

      }

      public abstract void onSwiped(RecyclerView.ViewHolder var1, int var2);
   }

   private class ItemTouchHelperGestureListener extends SimpleOnGestureListener {
      private ItemTouchHelperGestureListener() {
      }

      // $FF: synthetic method
      ItemTouchHelperGestureListener(Object var2) {
         this();
      }

      public boolean onDown(MotionEvent var1) {
         return true;
      }

      public void onLongPress(MotionEvent var1) {
         View var2 = ItemTouchHelper.this.findChildView(var1);
         if(var2 != null) {
            RecyclerView.ViewHolder var3 = ItemTouchHelper.this.mRecyclerView.getChildViewHolder(var2);
            if(var3 != null && ItemTouchHelper.this.mCallback.hasDragFlag(ItemTouchHelper.this.mRecyclerView, var3) && MotionEventCompat.getPointerId(var1, 0) == ItemTouchHelper.this.mActivePointerId) {
               int var4 = MotionEventCompat.findPointerIndex(var1, ItemTouchHelper.this.mActivePointerId);
               float var5 = MotionEventCompat.getX(var1, var4);
               float var6 = MotionEventCompat.getY(var1, var4);
               ItemTouchHelper.this.mInitialTouchX = var5;
               ItemTouchHelper.this.mInitialTouchY = var6;
               ItemTouchHelper var7 = ItemTouchHelper.this;
               ItemTouchHelper.this.mDy = 0.0F;
               var7.mDx = 0.0F;
               if(ItemTouchHelper.this.mCallback.isLongPressDragEnabled()) {
                  ItemTouchHelper.this.select(var3, 2);
                  return;
               }
            }
         }

      }
   }

   private class RecoverAnimation implements AnimatorListenerCompat {
      final int mActionState;
      private final int mAnimationType;
      private boolean mEnded = false;
      private float mFraction;
      public boolean mIsPendingCleanup;
      boolean mOverridden = false;
      final float mStartDx;
      final float mStartDy;
      final float mTargetX;
      final float mTargetY;
      private final ValueAnimatorCompat mValueAnimator;
      final RecyclerView.ViewHolder mViewHolder;
      // $FF: renamed from: mX float
      float field_104;
      // $FF: renamed from: mY float
      float field_105;

      public RecoverAnimation(RecyclerView.ViewHolder var2, int var3, int var4, float var5, float var6, float var7, float var8) {
         this.mActionState = var4;
         this.mAnimationType = var3;
         this.mViewHolder = var2;
         this.mStartDx = var5;
         this.mStartDy = var6;
         this.mTargetX = var7;
         this.mTargetY = var8;
         this.mValueAnimator = AnimatorCompatHelper.emptyValueAnimator();
         this.mValueAnimator.addUpdateListener(new AnimatorUpdateListenerCompat() {
            public void onAnimationUpdate(ValueAnimatorCompat var1) {
               RecoverAnimation.this.setFraction(var1.getAnimatedFraction());
            }
         });
         this.mValueAnimator.setTarget(var2.itemView);
         this.mValueAnimator.addListener(this);
         this.setFraction(0.0F);
      }

      public void cancel() {
         this.mValueAnimator.cancel();
      }

      public void onAnimationCancel(ValueAnimatorCompat var1) {
         this.setFraction(1.0F);
      }

      public void onAnimationEnd(ValueAnimatorCompat var1) {
         if(!this.mEnded) {
            this.mViewHolder.setIsRecyclable(true);
         }

         this.mEnded = true;
      }

      public void onAnimationRepeat(ValueAnimatorCompat var1) {
      }

      public void onAnimationStart(ValueAnimatorCompat var1) {
      }

      public void setDuration(long var1) {
         this.mValueAnimator.setDuration(var1);
      }

      public void setFraction(float var1) {
         this.mFraction = var1;
      }

      public void start() {
         this.mViewHolder.setIsRecyclable(false);
         this.mValueAnimator.start();
      }

      public void update() {
         if(this.mStartDx == this.mTargetX) {
            this.field_104 = ViewCompat.getTranslationX(this.mViewHolder.itemView);
         } else {
            this.field_104 = this.mStartDx + this.mFraction * (this.mTargetX - this.mStartDx);
         }

         if(this.mStartDy == this.mTargetY) {
            this.field_105 = ViewCompat.getTranslationY(this.mViewHolder.itemView);
         } else {
            this.field_105 = this.mStartDy + this.mFraction * (this.mTargetY - this.mStartDy);
         }
      }
   }

   public abstract static class SimpleCallback extends ItemTouchHelper.Callback {
      private int mDefaultDragDirs;
      private int mDefaultSwipeDirs;

      public SimpleCallback(int var1, int var2) {
         this.mDefaultSwipeDirs = var2;
         this.mDefaultDragDirs = var1;
      }

      public int getDragDirs(RecyclerView var1, RecyclerView.ViewHolder var2) {
         return this.mDefaultDragDirs;
      }

      public int getMovementFlags(RecyclerView var1, RecyclerView.ViewHolder var2) {
         return makeMovementFlags(this.getDragDirs(var1, var2), this.getSwipeDirs(var1, var2));
      }

      public int getSwipeDirs(RecyclerView var1, RecyclerView.ViewHolder var2) {
         return this.mDefaultSwipeDirs;
      }

      public void setDefaultDragDirs(int var1) {
         this.mDefaultDragDirs = var1;
      }

      public void setDefaultSwipeDirs(int var1) {
         this.mDefaultSwipeDirs = var1;
      }
   }

   public interface ViewDropHandler {
      void prepareForDrop(View var1, View var2, int var3, int var4);
   }
}
