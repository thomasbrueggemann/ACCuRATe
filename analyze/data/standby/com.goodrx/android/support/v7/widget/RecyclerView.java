package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.os.TraceCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.recyclerview.class_51;
import android.support.v7.widget.AdapterHelper;
import android.support.v7.widget.ChildHelper;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.support.v7.widget.ViewInfoStore;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements NestedScrollingChild, ScrollingView {
   private static final boolean DEBUG = false;
   private static final boolean DISPATCH_TEMP_DETACH = false;
   private static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
   public static final int HORIZONTAL = 0;
   private static final int INVALID_POINTER = -1;
   public static final int INVALID_TYPE = -1;
   private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
   private static final int MAX_SCROLL_DURATION = 2000;
   public static final long NO_ID = -1L;
   public static final int NO_POSITION = -1;
   public static final int SCROLL_STATE_DRAGGING = 1;
   public static final int SCROLL_STATE_IDLE = 0;
   public static final int SCROLL_STATE_SETTLING = 2;
   private static final String TAG = "RecyclerView";
   public static final int TOUCH_SLOP_DEFAULT = 0;
   public static final int TOUCH_SLOP_PAGING = 1;
   private static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
   private static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
   private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
   private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
   private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
   private static final String TRACE_SCROLL_TAG = "RV Scroll";
   public static final int VERTICAL = 1;
   private static final Interpolator sQuinticInterpolator;
   private RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
   private final AccessibilityManager mAccessibilityManager;
   private RecyclerView.OnItemTouchListener mActiveOnItemTouchListener;
   private RecyclerView.Adapter mAdapter;
   AdapterHelper mAdapterHelper;
   private boolean mAdapterUpdateDuringMeasure;
   private EdgeEffectCompat mBottomGlow;
   private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback;
   ChildHelper mChildHelper;
   private boolean mClipToPadding;
   private boolean mDataSetHasChangedAfterLayout;
   private int mEatRequestLayout;
   private int mEatenAccessibilityChangeFlags;
   private boolean mFirstLayoutComplete;
   private boolean mHasFixedSize;
   private boolean mIgnoreMotionEventTillDown;
   private int mInitialTouchX;
   private int mInitialTouchY;
   private boolean mIsAttached;
   RecyclerView.ItemAnimator mItemAnimator;
   private RecyclerView.ItemAnimatorListener mItemAnimatorListener;
   private Runnable mItemAnimatorRunner;
   private final ArrayList<RecyclerView.ItemDecoration> mItemDecorations;
   boolean mItemsAddedOrRemoved;
   boolean mItemsChanged;
   private int mLastTouchX;
   private int mLastTouchY;
   @VisibleForTesting
   RecyclerView.LayoutManager mLayout;
   private boolean mLayoutFrozen;
   private int mLayoutOrScrollCounter;
   private boolean mLayoutRequestEaten;
   private EdgeEffectCompat mLeftGlow;
   private final int mMaxFlingVelocity;
   private final int mMinFlingVelocity;
   private final int[] mMinMaxLayoutPositions;
   private final int[] mNestedOffsets;
   private final RecyclerView.RecyclerViewDataObserver mObserver;
   private List<RecyclerView.OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
   private final ArrayList<RecyclerView.OnItemTouchListener> mOnItemTouchListeners;
   private RecyclerView.SavedState mPendingSavedState;
   private final boolean mPostUpdatesOnAnimation;
   private boolean mPostedAnimatorRunner;
   final RecyclerView.Recycler mRecycler;
   private RecyclerView.RecyclerListener mRecyclerListener;
   private EdgeEffectCompat mRightGlow;
   private final int[] mScrollConsumed;
   private float mScrollFactor;
   private RecyclerView.OnScrollListener mScrollListener;
   private List<RecyclerView.OnScrollListener> mScrollListeners;
   private final int[] mScrollOffset;
   private int mScrollPointerId;
   private int mScrollState;
   private final NestedScrollingChildHelper mScrollingChildHelper;
   final RecyclerView.State mState;
   private final Rect mTempRect;
   private EdgeEffectCompat mTopGlow;
   private int mTouchSlop;
   private final Runnable mUpdateChildViewsRunnable;
   private VelocityTracker mVelocityTracker;
   private final RecyclerView.ViewFlinger mViewFlinger;
   private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
   final ViewInfoStore mViewInfoStore;

   static {
      boolean var0;
      if(VERSION.SDK_INT != 18 && VERSION.SDK_INT != 19 && VERSION.SDK_INT != 20) {
         var0 = false;
      } else {
         var0 = true;
      }

      FORCE_INVALIDATE_DISPLAY_LIST = var0;
      Class[] var1 = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
      LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = var1;
      sQuinticInterpolator = new Interpolator() {
         public float getInterpolation(float var1) {
            float var2 = var1 - 1.0F;
            return 1.0F + var2 * var2 * var2 * var2 * var2;
         }
      };
   }

   public RecyclerView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public RecyclerView(Context var1, @Nullable AttributeSet var2) {
      this(var1, var2, 0);
   }

   public RecyclerView(Context var1, @Nullable AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mObserver = new RecyclerView.RecyclerViewDataObserver(null);
      this.mRecycler = new RecyclerView.Recycler();
      this.mViewInfoStore = new ViewInfoStore();
      this.mUpdateChildViewsRunnable = new Runnable() {
         public void run() {
            if(RecyclerView.this.mFirstLayoutComplete && !RecyclerView.this.isLayoutRequested()) {
               if(RecyclerView.this.mLayoutFrozen) {
                  RecyclerView.this.mLayoutRequestEaten = true;
               } else {
                  RecyclerView.this.consumePendingUpdateOperations();
               }
            }
         }
      };
      this.mTempRect = new Rect();
      this.mItemDecorations = new ArrayList();
      this.mOnItemTouchListeners = new ArrayList();
      this.mEatRequestLayout = 0;
      this.mDataSetHasChangedAfterLayout = false;
      this.mLayoutOrScrollCounter = 0;
      this.mItemAnimator = new DefaultItemAnimator();
      this.mScrollState = 0;
      this.mScrollPointerId = -1;
      this.mScrollFactor = Float.MIN_VALUE;
      this.mViewFlinger = new RecyclerView.ViewFlinger();
      this.mState = new RecyclerView.State();
      this.mItemsAddedOrRemoved = false;
      this.mItemsChanged = false;
      this.mItemAnimatorListener = new RecyclerView.ItemAnimatorRestoreListener(null);
      this.mPostedAnimatorRunner = false;
      this.mMinMaxLayoutPositions = new int[2];
      this.mScrollOffset = new int[2];
      this.mScrollConsumed = new int[2];
      this.mNestedOffsets = new int[2];
      this.mItemAnimatorRunner = new Runnable() {
         public void run() {
            if(RecyclerView.this.mItemAnimator != null) {
               RecyclerView.this.mItemAnimator.runPendingAnimations();
            }

            RecyclerView.this.mPostedAnimatorRunner = false;
         }
      };
      this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() {
         public void processAppeared(RecyclerView.ViewHolder var1, RecyclerView.ItemHolderInfo var2, RecyclerView.ItemHolderInfo var3) {
            RecyclerView.this.animateAppearance(var1, var2, var3);
         }

         public void processDisappeared(RecyclerView.ViewHolder var1, RecyclerView.ItemHolderInfo var2, RecyclerView.ItemHolderInfo var3) {
            RecyclerView.this.mRecycler.unscrapView(var1);
            RecyclerView.this.animateDisappearance(var1, var2, var3);
         }

         public void processPersistent(RecyclerView.ViewHolder var1, @NonNull RecyclerView.ItemHolderInfo var2, @NonNull RecyclerView.ItemHolderInfo var3) {
            var1.setIsRecyclable(false);
            if(RecyclerView.this.mDataSetHasChangedAfterLayout) {
               if(RecyclerView.this.mItemAnimator.animateChange(var1, var1, var2, var3)) {
                  RecyclerView.this.postAnimationRunner();
               }
            } else if(RecyclerView.this.mItemAnimator.animatePersistence(var1, var2, var3)) {
               RecyclerView.this.postAnimationRunner();
               return;
            }

         }

         public void unused(RecyclerView.ViewHolder var1) {
            RecyclerView.this.mLayout.removeAndRecycleView(var1.itemView, RecyclerView.this.mRecycler);
         }
      };
      this.setScrollContainer(true);
      this.setFocusableInTouchMode(true);
      boolean var4;
      if(VERSION.SDK_INT >= 16) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.mPostUpdatesOnAnimation = var4;
      ViewConfiguration var5 = ViewConfiguration.get(var1);
      this.mTouchSlop = var5.getScaledTouchSlop();
      this.mMinFlingVelocity = var5.getScaledMinimumFlingVelocity();
      this.mMaxFlingVelocity = var5.getScaledMaximumFlingVelocity();
      int var6 = ViewCompat.getOverScrollMode(this);
      boolean var7 = false;
      if(var6 == 2) {
         var7 = true;
      }

      this.setWillNotDraw(var7);
      this.mItemAnimator.setListener(this.mItemAnimatorListener);
      this.initAdapterManager();
      this.initChildrenHelper();
      if(ViewCompat.getImportantForAccessibility(this) == 0) {
         ViewCompat.setImportantForAccessibility(this, 1);
      }

      this.mAccessibilityManager = (AccessibilityManager)this.getContext().getSystemService("accessibility");
      this.setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
      if(var2 != null) {
         TypedArray var8 = var1.obtainStyledAttributes(var2, class_51.styleable.RecyclerView, var3, 0);
         String var9 = var8.getString(class_51.styleable.RecyclerView_layoutManager);
         var8.recycle();
         this.createLayoutManager(var1, var9, var2, var3, 0);
      }

      this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
      this.setNestedScrollingEnabled(true);
   }

   private void addAnimatingView(RecyclerView.ViewHolder var1) {
      View var2 = var1.itemView;
      boolean var3;
      if(var2.getParent() == this) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.mRecycler.unscrapView(this.getChildViewHolder(var2));
      if(var1.isTmpDetached()) {
         this.mChildHelper.attachViewToParent(var2, -1, var2.getLayoutParams(), true);
      } else if(!var3) {
         this.mChildHelper.addView(var2, true);
      } else {
         this.mChildHelper.hide(var2);
      }
   }

   private void animateAppearance(@NonNull RecyclerView.ViewHolder var1, @Nullable RecyclerView.ItemHolderInfo var2, @NonNull RecyclerView.ItemHolderInfo var3) {
      var1.setIsRecyclable(false);
      if(this.mItemAnimator.animateAppearance(var1, var2, var3)) {
         this.postAnimationRunner();
      }

   }

   private void animateChange(@NonNull RecyclerView.ViewHolder var1, @NonNull RecyclerView.ViewHolder var2, @NonNull RecyclerView.ItemHolderInfo var3, @NonNull RecyclerView.ItemHolderInfo var4, boolean var5, boolean var6) {
      var1.setIsRecyclable(false);
      if(var5) {
         this.addAnimatingView(var1);
      }

      if(var1 != var2) {
         if(var6) {
            this.addAnimatingView(var2);
         }

         var1.mShadowedHolder = var2;
         this.addAnimatingView(var1);
         this.mRecycler.unscrapView(var1);
         var2.setIsRecyclable(false);
         var2.mShadowingHolder = var1;
      }

      if(this.mItemAnimator.animateChange(var1, var2, var3, var4)) {
         this.postAnimationRunner();
      }

   }

   private void animateDisappearance(@NonNull RecyclerView.ViewHolder var1, @NonNull RecyclerView.ItemHolderInfo var2, @Nullable RecyclerView.ItemHolderInfo var3) {
      this.addAnimatingView(var1);
      var1.setIsRecyclable(false);
      if(this.mItemAnimator.animateDisappearance(var1, var2, var3)) {
         this.postAnimationRunner();
      }

   }

   private boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder var1) {
      return this.mItemAnimator == null || this.mItemAnimator.canReuseUpdatedViewHolder(var1, var1.getUnmodifiedPayloads());
   }

   private void cancelTouch() {
      this.resetTouch();
      this.setScrollState(0);
   }

   private void considerReleasingGlowsOnScroll(int var1, int var2) {
      EdgeEffectCompat var3 = this.mLeftGlow;
      boolean var4 = false;
      if(var3 != null) {
         boolean var5 = this.mLeftGlow.isFinished();
         var4 = false;
         if(!var5) {
            var4 = false;
            if(var1 > 0) {
               var4 = this.mLeftGlow.onRelease();
            }
         }
      }

      if(this.mRightGlow != null && !this.mRightGlow.isFinished() && var1 < 0) {
         var4 |= this.mRightGlow.onRelease();
      }

      if(this.mTopGlow != null && !this.mTopGlow.isFinished() && var2 > 0) {
         var4 |= this.mTopGlow.onRelease();
      }

      if(this.mBottomGlow != null && !this.mBottomGlow.isFinished() && var2 < 0) {
         var4 |= this.mBottomGlow.onRelease();
      }

      if(var4) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   private void consumePendingUpdateOperations() {
      if(this.mFirstLayoutComplete) {
         if(this.mDataSetHasChangedAfterLayout) {
            TraceCompat.beginSection("RV FullInvalidate");
            this.dispatchLayout();
            TraceCompat.endSection();
            return;
         }

         if(this.mAdapterHelper.hasPendingUpdates()) {
            if(this.mAdapterHelper.hasAnyUpdateTypes(4) && !this.mAdapterHelper.hasAnyUpdateTypes(11)) {
               TraceCompat.beginSection("RV PartialInvalidate");
               this.eatRequestLayout();
               this.mAdapterHelper.preProcess();
               if(!this.mLayoutRequestEaten) {
                  if(this.hasUpdatedView()) {
                     this.dispatchLayout();
                  } else {
                     this.mAdapterHelper.consumePostponedUpdates();
                  }
               }

               this.resumeRequestLayout(true);
               TraceCompat.endSection();
               return;
            }

            if(this.mAdapterHelper.hasPendingUpdates()) {
               TraceCompat.beginSection("RV FullInvalidate");
               this.dispatchLayout();
               TraceCompat.endSection();
               return;
            }
         }
      }

   }

   private void createLayoutManager(Context param1, String param2, AttributeSet param3, int param4, int param5) {
      // $FF: Couldn't be decompiled
   }

   private void defaultOnMeasure(int var1, int var2) {
      int var3 = MeasureSpec.getMode(var1);
      int var4 = MeasureSpec.getMode(var2);
      int var5 = MeasureSpec.getSize(var1);
      int var6 = MeasureSpec.getSize(var2);
      int var7;
      switch(var3) {
      case Integer.MIN_VALUE:
      case 1073741824:
         var7 = var5;
         break;
      default:
         var7 = ViewCompat.getMinimumWidth(this);
      }

      int var8;
      switch(var4) {
      case Integer.MIN_VALUE:
      case 1073741824:
         var8 = var6;
         break;
      default:
         var8 = ViewCompat.getMinimumHeight(this);
      }

      this.setMeasuredDimension(var7, var8);
   }

   private boolean didChildRangeChange(int var1, int var2) {
      int var3 = this.mChildHelper.getChildCount();
      boolean var5;
      if(var3 == 0) {
         if(var1 == 0) {
            var5 = false;
            if(var2 == 0) {
               return var5;
            }
         }

         var5 = true;
      } else {
         int var4 = 0;

         while(true) {
            var5 = false;
            if(var4 >= var3) {
               break;
            }

            RecyclerView.ViewHolder var6 = getChildViewHolderInt(this.mChildHelper.getChildAt(var4));
            if(!var6.shouldIgnore()) {
               int var7 = var6.getLayoutPosition();
               if(var7 < var1 || var7 > var2) {
                  return true;
               }
            }

            ++var4;
         }
      }

      return var5;
   }

   private void dispatchChildAttached(View var1) {
      RecyclerView.ViewHolder var2 = getChildViewHolderInt(var1);
      this.onChildAttachedToWindow(var1);
      if(this.mAdapter != null && var2 != null) {
         this.mAdapter.onViewAttachedToWindow(var2);
      }

      if(this.mOnChildAttachStateListeners != null) {
         for(int var3 = -1 + this.mOnChildAttachStateListeners.size(); var3 >= 0; --var3) {
            ((RecyclerView.OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(var3)).onChildViewAttachedToWindow(var1);
         }
      }

   }

   private void dispatchChildDetached(View var1) {
      RecyclerView.ViewHolder var2 = getChildViewHolderInt(var1);
      this.onChildDetachedFromWindow(var1);
      if(this.mAdapter != null && var2 != null) {
         this.mAdapter.onViewDetachedFromWindow(var2);
      }

      if(this.mOnChildAttachStateListeners != null) {
         for(int var3 = -1 + this.mOnChildAttachStateListeners.size(); var3 >= 0; --var3) {
            ((RecyclerView.OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(var3)).onChildViewDetachedFromWindow(var1);
         }
      }

   }

   private void dispatchContentChangedIfNecessary() {
      int var1 = this.mEatenAccessibilityChangeFlags;
      this.mEatenAccessibilityChangeFlags = 0;
      if(var1 != 0 && this.isAccessibilityEnabled()) {
         AccessibilityEvent var2 = AccessibilityEvent.obtain();
         var2.setEventType(2048);
         AccessibilityEventCompat.setContentChangeTypes(var2, var1);
         this.sendAccessibilityEventUnchecked(var2);
      }

   }

   private void dispatchLayoutStep1() {
      this.mState.assertLayoutStep(1);
      this.mState.mIsMeasuring = false;
      this.eatRequestLayout();
      this.mViewInfoStore.clear();
      this.onEnterLayoutOrScroll();
      this.processAdapterUpdatesAndSetAnimationFlags();
      RecyclerView.State var2 = this.mState;
      boolean var3;
      if(this.mState.mRunSimpleAnimations && this.mItemsChanged) {
         var3 = true;
      } else {
         var3 = false;
      }

      var2.mTrackOldChangeHolders = var3;
      this.mItemsChanged = false;
      this.mItemsAddedOrRemoved = false;
      this.mState.mInPreLayout = this.mState.mRunPredictiveAnimations;
      this.mState.mItemCount = this.mAdapter.getItemCount();
      this.findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
      if(this.mState.mRunSimpleAnimations) {
         int var15 = this.mChildHelper.getChildCount();

         for(int var16 = 0; var16 < var15; ++var16) {
            RecyclerView.ViewHolder var17 = getChildViewHolderInt(this.mChildHelper.getChildAt(var16));
            if(!var17.shouldIgnore() && (!var17.isInvalid() || this.mAdapter.hasStableIds())) {
               RecyclerView.ItemHolderInfo var18 = this.mItemAnimator.recordPreLayoutInformation(this.mState, var17, RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations(var17), var17.getUnmodifiedPayloads());
               this.mViewInfoStore.addToPreLayout(var17, var18);
               if(this.mState.mTrackOldChangeHolders && var17.isUpdated() && !var17.isRemoved() && !var17.shouldIgnore() && !var17.isInvalid()) {
                  long var19 = this.getChangedHolderKey(var17);
                  this.mViewInfoStore.addToOldChangeHolders(var19, var17);
               }
            }
         }
      }

      if(this.mState.mRunPredictiveAnimations) {
         this.saveOldPositions();
         boolean var7 = this.mState.mStructureChanged;
         this.mState.mStructureChanged = false;
         this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
         this.mState.mStructureChanged = var7;

         for(int var10 = 0; var10 < this.mChildHelper.getChildCount(); ++var10) {
            RecyclerView.ViewHolder var11 = getChildViewHolderInt(this.mChildHelper.getChildAt(var10));
            if(!var11.shouldIgnore() && !this.mViewInfoStore.isInPreLayout(var11)) {
               int var12 = RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations(var11);
               boolean var13 = var11.hasAnyOfTheFlags(8192);
               if(!var13) {
                  var12 |= 4096;
               }

               RecyclerView.ItemHolderInfo var14 = this.mItemAnimator.recordPreLayoutInformation(this.mState, var11, var12, var11.getUnmodifiedPayloads());
               if(var13) {
                  this.recordAnimationInfoIfBouncedHiddenView(var11, var14);
               } else {
                  this.mViewInfoStore.addToAppearedInPreLayoutHolders(var11, var14);
               }
            }
         }

         this.clearOldPositions();
      } else {
         this.clearOldPositions();
      }

      this.onExitLayoutOrScroll();
      this.resumeRequestLayout(false);
      this.mState.mLayoutStep = 2;
   }

   private void dispatchLayoutStep2() {
      this.eatRequestLayout();
      this.onEnterLayoutOrScroll();
      this.mState.assertLayoutStep(6);
      this.mAdapterHelper.consumeUpdatesInOnePass();
      this.mState.mItemCount = this.mAdapter.getItemCount();
      this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
      this.mState.mInPreLayout = false;
      this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
      this.mState.mStructureChanged = false;
      this.mPendingSavedState = null;
      RecyclerView.State var4 = this.mState;
      boolean var5;
      if(this.mState.mRunSimpleAnimations && this.mItemAnimator != null) {
         var5 = true;
      } else {
         var5 = false;
      }

      var4.mRunSimpleAnimations = var5;
      this.mState.mLayoutStep = 4;
      this.onExitLayoutOrScroll();
      this.resumeRequestLayout(false);
   }

   private void dispatchLayoutStep3() {
      this.mState.assertLayoutStep(4);
      this.eatRequestLayout();
      this.mState.mLayoutStep = 1;
      if(this.mState.mRunSimpleAnimations) {
         int var6 = this.mChildHelper.getChildCount();

         for(int var7 = 0; var7 < var6; ++var7) {
            RecyclerView.ViewHolder var8 = getChildViewHolderInt(this.mChildHelper.getChildAt(var7));
            if(!var8.shouldIgnore()) {
               long var9 = this.getChangedHolderKey(var8);
               RecyclerView.ItemHolderInfo var11 = this.mItemAnimator.recordPostLayoutInformation(this.mState, var8);
               RecyclerView.ViewHolder var12 = this.mViewInfoStore.getFromOldChangeHolders(var9);
               if(var12 != null && !var12.shouldIgnore()) {
                  boolean var13 = this.mViewInfoStore.isDisappearing(var12);
                  boolean var14 = this.mViewInfoStore.isDisappearing(var8);
                  RecyclerView.ItemHolderInfo var15 = this.mViewInfoStore.popFromPreLayout(var12);
                  this.mViewInfoStore.addToPostLayout(var8, var11);
                  RecyclerView.ItemHolderInfo var16 = this.mViewInfoStore.popFromPostLayout(var8);
                  if(var15 == null) {
                     this.handleMissingPreInfoForChangeError(var9, var8, var12);
                  } else {
                     this.animateChange(var12, var8, var15, var16, var13, var14);
                  }
               } else {
                  this.mViewInfoStore.addToPostLayout(var8, var11);
               }
            }
         }

         this.mViewInfoStore.process(this.mViewInfoProcessCallback);
      }

      this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
      this.mState.mPreviousLayoutItemCount = this.mState.mItemCount;
      this.mDataSetHasChangedAfterLayout = false;
      this.mState.mRunSimpleAnimations = false;
      this.mState.mRunPredictiveAnimations = false;
      this.mLayout.mRequestedSimpleAnimations = false;
      if(this.mRecycler.mChangedScrap != null) {
         this.mRecycler.mChangedScrap.clear();
      }

      this.resumeRequestLayout(false);
      this.mViewInfoStore.clear();
      if(this.didChildRangeChange(this.mMinMaxLayoutPositions[0], this.mMinMaxLayoutPositions[1])) {
         this.dispatchOnScrolled(0, 0);
      }

   }

   private boolean dispatchOnItemTouch(MotionEvent var1) {
      int var2 = var1.getAction();
      if(this.mActiveOnItemTouchListener != null) {
         if(var2 != 0) {
            this.mActiveOnItemTouchListener.onTouchEvent(this, var1);
            if(var2 != 3 && var2 != 1) {
               return true;
            }

            this.mActiveOnItemTouchListener = null;
            return true;
         }

         this.mActiveOnItemTouchListener = null;
      }

      if(var2 != 0) {
         int var3 = this.mOnItemTouchListeners.size();

         for(int var4 = 0; var4 < var3; ++var4) {
            RecyclerView.OnItemTouchListener var5 = (RecyclerView.OnItemTouchListener)this.mOnItemTouchListeners.get(var4);
            if(var5.onInterceptTouchEvent(this, var1)) {
               this.mActiveOnItemTouchListener = var5;
               return true;
            }
         }
      }

      return false;
   }

   private boolean dispatchOnItemTouchIntercept(MotionEvent var1) {
      int var2 = var1.getAction();
      if(var2 == 3 || var2 == 0) {
         this.mActiveOnItemTouchListener = null;
      }

      int var3 = this.mOnItemTouchListeners.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         RecyclerView.OnItemTouchListener var5 = (RecyclerView.OnItemTouchListener)this.mOnItemTouchListeners.get(var4);
         if(var5.onInterceptTouchEvent(this, var1) && var2 != 3) {
            this.mActiveOnItemTouchListener = var5;
            return true;
         }
      }

      return false;
   }

   private void findMinMaxChildLayoutPositions(int[] var1) {
      int var2 = this.mChildHelper.getChildCount();
      if(var2 == 0) {
         var1[0] = 0;
         var1[1] = 0;
      } else {
         int var3 = Integer.MAX_VALUE;
         int var4 = Integer.MIN_VALUE;

         for(int var5 = 0; var5 < var2; ++var5) {
            RecyclerView.ViewHolder var6 = getChildViewHolderInt(this.mChildHelper.getChildAt(var5));
            if(!var6.shouldIgnore()) {
               int var7 = var6.getLayoutPosition();
               if(var7 < var3) {
                  var3 = var7;
               }

               if(var7 > var4) {
                  var4 = var7;
               }
            }
         }

         var1[0] = var3;
         var1[1] = var4;
      }
   }

   private int getAdapterPositionFor(RecyclerView.ViewHolder var1) {
      return !var1.hasAnyOfTheFlags(524) && var1.isBound()?this.mAdapterHelper.applyPendingUpdatesToPosition(var1.mPosition):-1;
   }

   static RecyclerView.ViewHolder getChildViewHolderInt(View var0) {
      return var0 == null?null:((RecyclerView.LayoutParams)var0.getLayoutParams()).mViewHolder;
   }

   private String getFullClassName(Context var1, String var2) {
      if(var2.charAt(0) == 46) {
         var2 = var1.getPackageName() + var2;
      } else if(!var2.contains(".")) {
         return RecyclerView.class.getPackage().getName() + '.' + var2;
      }

      return var2;
   }

   private float getScrollFactor() {
      if(this.mScrollFactor == Float.MIN_VALUE) {
         TypedValue var1 = new TypedValue();
         if(!this.getContext().getTheme().resolveAttribute(16842829, var1, true)) {
            return 0.0F;
         }

         this.mScrollFactor = var1.getDimension(this.getContext().getResources().getDisplayMetrics());
      }

      return this.mScrollFactor;
   }

   private void handleMissingPreInfoForChangeError(long var1, RecyclerView.ViewHolder var3, RecyclerView.ViewHolder var4) {
      int var5 = this.mChildHelper.getChildCount();

      for(int var6 = 0; var6 < var5; ++var6) {
         RecyclerView.ViewHolder var8 = getChildViewHolderInt(this.mChildHelper.getChildAt(var6));
         if(var8 != var3 && this.getChangedHolderKey(var8) == var1) {
            if(this.mAdapter != null && this.mAdapter.hasStableIds()) {
               throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + var8 + " \n View Holder 2:" + var3);
            }

            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + var8 + " \n View Holder 2:" + var3);
         }
      }

      Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + var4 + " cannot be found but it is necessary for " + var3);
   }

   private boolean hasUpdatedView() {
      int var1 = this.mChildHelper.getChildCount();

      for(int var2 = 0; var2 < var1; ++var2) {
         RecyclerView.ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.getChildAt(var2));
         if(var3 != null && !var3.shouldIgnore() && var3.isUpdated()) {
            return true;
         }
      }

      return false;
   }

   private void initChildrenHelper() {
      this.mChildHelper = new ChildHelper(new ChildHelper.Callback() {
         public void addView(View var1, int var2) {
            RecyclerView.this.addView(var1, var2);
            RecyclerView.this.dispatchChildAttached(var1);
         }

         public void attachViewToParent(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
            RecyclerView.ViewHolder var4 = RecyclerView.getChildViewHolderInt(var1);
            if(var4 != null) {
               if(!var4.isTmpDetached() && !var4.shouldIgnore()) {
                  throw new IllegalArgumentException("Called attach on a child which is not detached: " + var4);
               }

               var4.clearTmpDetachFlag();
            }

            RecyclerView.this.attachViewToParent(var1, var2, var3);
         }

         public void detachViewFromParent(int var1) {
            View var2 = this.getChildAt(var1);
            if(var2 != null) {
               RecyclerView.ViewHolder var3 = RecyclerView.getChildViewHolderInt(var2);
               if(var3 != null) {
                  if(var3.isTmpDetached() && !var3.shouldIgnore()) {
                     throw new IllegalArgumentException("called detach on an already detached child " + var3);
                  }

                  var3.addFlags(256);
               }
            }

            RecyclerView.this.detachViewFromParent(var1);
         }

         public View getChildAt(int var1) {
            return RecyclerView.this.getChildAt(var1);
         }

         public int getChildCount() {
            return RecyclerView.this.getChildCount();
         }

         public RecyclerView.ViewHolder getChildViewHolder(View var1) {
            return RecyclerView.getChildViewHolderInt(var1);
         }

         public int indexOfChild(View var1) {
            return RecyclerView.this.indexOfChild(var1);
         }

         public void onEnteredHiddenState(View var1) {
            RecyclerView.ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
            if(var2 != null) {
               var2.onEnteredHiddenState();
            }

         }

         public void onLeftHiddenState(View var1) {
            RecyclerView.ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
            if(var2 != null) {
               var2.onLeftHiddenState();
            }

         }

         public void removeAllViews() {
            int var1 = this.getChildCount();

            for(int var2 = 0; var2 < var1; ++var2) {
               RecyclerView.this.dispatchChildDetached(this.getChildAt(var2));
            }

            RecyclerView.this.removeAllViews();
         }

         public void removeViewAt(int var1) {
            View var2 = RecyclerView.this.getChildAt(var1);
            if(var2 != null) {
               RecyclerView.this.dispatchChildDetached(var2);
            }

            RecyclerView.this.removeViewAt(var1);
         }
      });
   }

   private void jumpToPositionForSmoothScroller(int var1) {
      if(this.mLayout != null) {
         this.mLayout.scrollToPosition(var1);
         this.awakenScrollBars();
      }
   }

   private void onEnterLayoutOrScroll() {
      ++this.mLayoutOrScrollCounter;
   }

   private void onExitLayoutOrScroll() {
      this.mLayoutOrScrollCounter += -1;
      if(this.mLayoutOrScrollCounter < 1) {
         this.mLayoutOrScrollCounter = 0;
         this.dispatchContentChangedIfNecessary();
      }

   }

   private void onPointerUp(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionIndex(var1);
      if(MotionEventCompat.getPointerId(var1, var2) == this.mScrollPointerId) {
         byte var3;
         if(var2 == 0) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         this.mScrollPointerId = MotionEventCompat.getPointerId(var1, var3);
         int var4 = (int)(0.5F + MotionEventCompat.getX(var1, var3));
         this.mLastTouchX = var4;
         this.mInitialTouchX = var4;
         int var5 = (int)(0.5F + MotionEventCompat.getY(var1, var3));
         this.mLastTouchY = var5;
         this.mInitialTouchY = var5;
      }

   }

   private void postAnimationRunner() {
      if(!this.mPostedAnimatorRunner && this.mIsAttached) {
         ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
         this.mPostedAnimatorRunner = true;
      }

   }

   private boolean predictiveItemAnimationsEnabled() {
      return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
   }

   private void processAdapterUpdatesAndSetAnimationFlags() {
      boolean var1 = true;
      if(this.mDataSetHasChangedAfterLayout) {
         this.mAdapterHelper.reset();
         this.markKnownViewsInvalid();
         this.mLayout.onItemsChanged(this);
      }

      if(this.predictiveItemAnimationsEnabled()) {
         this.mAdapterHelper.preProcess();
      } else {
         this.mAdapterHelper.consumeUpdatesInOnePass();
      }

      boolean var2;
      if(!this.mItemsAddedOrRemoved && !this.mItemsChanged) {
         var2 = false;
      } else {
         var2 = var1;
      }

      RecyclerView.State var3 = this.mState;
      boolean var4;
      if(this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || var2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds())) {
         var4 = var1;
      } else {
         var4 = false;
      }

      var3.mRunSimpleAnimations = var4;
      RecyclerView.State var6 = this.mState;
      if(!this.mState.mRunSimpleAnimations || !var2 || this.mDataSetHasChangedAfterLayout || !this.predictiveItemAnimationsEnabled()) {
         var1 = false;
      }

      var6.mRunPredictiveAnimations = var1;
   }

   private void pullGlows(float var1, float var2, float var3, float var4) {
      boolean var6;
      if(var2 < 0.0F) {
         this.ensureLeftGlow();
         boolean var8 = this.mLeftGlow.onPull(-var2 / (float)this.getWidth(), 1.0F - var3 / (float)this.getHeight());
         var6 = false;
         if(var8) {
            var6 = true;
         }
      } else {
         float var9;
         int var5 = (var9 = var2 - 0.0F) == 0.0F?0:(var9 < 0.0F?-1:1);
         var6 = false;
         if(var5 > 0) {
            this.ensureRightGlow();
            boolean var7 = this.mRightGlow.onPull(var2 / (float)this.getWidth(), var3 / (float)this.getHeight());
            var6 = false;
            if(var7) {
               var6 = true;
            }
         }
      }

      if(var4 < 0.0F) {
         this.ensureTopGlow();
         if(this.mTopGlow.onPull(-var4 / (float)this.getHeight(), var1 / (float)this.getWidth())) {
            var6 = true;
         }
      } else if(var4 > 0.0F) {
         this.ensureBottomGlow();
         if(this.mBottomGlow.onPull(var4 / (float)this.getHeight(), 1.0F - var1 / (float)this.getWidth())) {
            var6 = true;
         }
      }

      if(var6 || var2 != 0.0F || var4 != 0.0F) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   private void recordAnimationInfoIfBouncedHiddenView(RecyclerView.ViewHolder var1, RecyclerView.ItemHolderInfo var2) {
      var1.setFlags(0, 8192);
      if(this.mState.mTrackOldChangeHolders && var1.isUpdated() && !var1.isRemoved() && !var1.shouldIgnore()) {
         long var3 = this.getChangedHolderKey(var1);
         this.mViewInfoStore.addToOldChangeHolders(var3, var1);
      }

      this.mViewInfoStore.addToPreLayout(var1, var2);
   }

   private void releaseGlows() {
      EdgeEffectCompat var1 = this.mLeftGlow;
      boolean var2 = false;
      if(var1 != null) {
         var2 = this.mLeftGlow.onRelease();
      }

      if(this.mTopGlow != null) {
         var2 |= this.mTopGlow.onRelease();
      }

      if(this.mRightGlow != null) {
         var2 |= this.mRightGlow.onRelease();
      }

      if(this.mBottomGlow != null) {
         var2 |= this.mBottomGlow.onRelease();
      }

      if(var2) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   private boolean removeAnimatingView(View var1) {
      this.eatRequestLayout();
      boolean var2 = this.mChildHelper.removeViewIfHidden(var1);
      if(var2) {
         RecyclerView.ViewHolder var4 = getChildViewHolderInt(var1);
         this.mRecycler.unscrapView(var4);
         this.mRecycler.recycleViewHolderInternal(var4);
      }

      boolean var3;
      if(!var2) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.resumeRequestLayout(var3);
      return var2;
   }

   private void repositionShadowingViews() {
      int var1 = this.mChildHelper.getChildCount();

      for(int var2 = 0; var2 < var1; ++var2) {
         View var3 = this.mChildHelper.getChildAt(var2);
         RecyclerView.ViewHolder var4 = this.getChildViewHolder(var3);
         if(var4 != null && var4.mShadowingHolder != null) {
            View var5 = var4.mShadowingHolder.itemView;
            int var6 = var3.getLeft();
            int var7 = var3.getTop();
            if(var6 != var5.getLeft() || var7 != var5.getTop()) {
               var5.layout(var6, var7, var6 + var5.getWidth(), var7 + var5.getHeight());
            }
         }
      }

   }

   private void resetTouch() {
      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.clear();
      }

      this.stopNestedScroll();
      this.releaseGlows();
   }

   private void setAdapterInternal(RecyclerView.Adapter var1, boolean var2, boolean var3) {
      if(this.mAdapter != null) {
         this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
         this.mAdapter.onDetachedFromRecyclerView(this);
      }

      if(!var2 || var3) {
         if(this.mItemAnimator != null) {
            this.mItemAnimator.endAnimations();
         }

         if(this.mLayout != null) {
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
         }

         this.mRecycler.clear();
      }

      this.mAdapterHelper.reset();
      RecyclerView.Adapter var4 = this.mAdapter;
      this.mAdapter = var1;
      if(var1 != null) {
         var1.registerAdapterDataObserver(this.mObserver);
         var1.onAttachedToRecyclerView(this);
      }

      if(this.mLayout != null) {
         this.mLayout.onAdapterChanged(var4, this.mAdapter);
      }

      this.mRecycler.onAdapterChanged(var4, this.mAdapter, var2);
      this.mState.mStructureChanged = true;
      this.markKnownViewsInvalid();
   }

   private void setDataSetChangedAfterLayout() {
      if(!this.mDataSetHasChangedAfterLayout) {
         this.mDataSetHasChangedAfterLayout = true;
         int var1 = this.mChildHelper.getUnfilteredChildCount();

         for(int var2 = 0; var2 < var1; ++var2) {
            RecyclerView.ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var2));
            if(var3 != null && !var3.shouldIgnore()) {
               var3.addFlags(512);
            }
         }

         this.mRecycler.setAdapterPositionsAsUnknown();
      }
   }

   private void setScrollState(int var1) {
      if(var1 != this.mScrollState) {
         this.mScrollState = var1;
         if(var1 != 2) {
            this.stopScrollersInternal();
         }

         this.dispatchOnScrollStateChanged(var1);
      }
   }

   private void stopScrollersInternal() {
      this.mViewFlinger.stop();
      if(this.mLayout != null) {
         this.mLayout.stopSmoothScroller();
      }

   }

   void absorbGlows(int var1, int var2) {
      if(var1 < 0) {
         this.ensureLeftGlow();
         this.mLeftGlow.onAbsorb(-var1);
      } else if(var1 > 0) {
         this.ensureRightGlow();
         this.mRightGlow.onAbsorb(var1);
      }

      if(var2 < 0) {
         this.ensureTopGlow();
         this.mTopGlow.onAbsorb(-var2);
      } else if(var2 > 0) {
         this.ensureBottomGlow();
         this.mBottomGlow.onAbsorb(var2);
      }

      if(var1 != 0 || var2 != 0) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   public void addFocusables(ArrayList<View> var1, int var2, int var3) {
      if(this.mLayout == null || !this.mLayout.onAddFocusables(this, var1, var2, var3)) {
         super.addFocusables(var1, var2, var3);
      }

   }

   public void addItemDecoration(RecyclerView.ItemDecoration var1) {
      this.addItemDecoration(var1, -1);
   }

   public void addItemDecoration(RecyclerView.ItemDecoration var1, int var2) {
      if(this.mLayout != null) {
         this.mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
      }

      if(this.mItemDecorations.isEmpty()) {
         this.setWillNotDraw(false);
      }

      if(var2 < 0) {
         this.mItemDecorations.add(var1);
      } else {
         this.mItemDecorations.add(var2, var1);
      }

      this.markItemDecorInsetsDirty();
      this.requestLayout();
   }

   public void addOnChildAttachStateChangeListener(RecyclerView.OnChildAttachStateChangeListener var1) {
      if(this.mOnChildAttachStateListeners == null) {
         this.mOnChildAttachStateListeners = new ArrayList();
      }

      this.mOnChildAttachStateListeners.add(var1);
   }

   public void addOnItemTouchListener(RecyclerView.OnItemTouchListener var1) {
      this.mOnItemTouchListeners.add(var1);
   }

   public void addOnScrollListener(RecyclerView.OnScrollListener var1) {
      if(this.mScrollListeners == null) {
         this.mScrollListeners = new ArrayList();
      }

      this.mScrollListeners.add(var1);
   }

   void assertInLayoutOrScroll(String var1) {
      if(!this.isComputingLayout()) {
         if(var1 == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling");
         } else {
            throw new IllegalStateException(var1);
         }
      }
   }

   void assertNotInLayoutOrScroll(String var1) {
      if(this.isComputingLayout()) {
         if(var1 == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
         } else {
            throw new IllegalStateException(var1);
         }
      }
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof RecyclerView.LayoutParams && this.mLayout.checkLayoutParams((RecyclerView.LayoutParams)var1);
   }

   void clearOldPositions() {
      int var1 = this.mChildHelper.getUnfilteredChildCount();

      for(int var2 = 0; var2 < var1; ++var2) {
         RecyclerView.ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var2));
         if(!var3.shouldIgnore()) {
            var3.clearOldPosition();
         }
      }

      this.mRecycler.clearOldPositions();
   }

   public void clearOnChildAttachStateChangeListeners() {
      if(this.mOnChildAttachStateListeners != null) {
         this.mOnChildAttachStateListeners.clear();
      }

   }

   public void clearOnScrollListeners() {
      if(this.mScrollListeners != null) {
         this.mScrollListeners.clear();
      }

   }

   public int computeHorizontalScrollExtent() {
      return this.mLayout != null && this.mLayout.canScrollHorizontally()?this.mLayout.computeHorizontalScrollExtent(this.mState):0;
   }

   public int computeHorizontalScrollOffset() {
      return this.mLayout != null && this.mLayout.canScrollHorizontally()?this.mLayout.computeHorizontalScrollOffset(this.mState):0;
   }

   public int computeHorizontalScrollRange() {
      return this.mLayout != null && this.mLayout.canScrollHorizontally()?this.mLayout.computeHorizontalScrollRange(this.mState):0;
   }

   public int computeVerticalScrollExtent() {
      return this.mLayout != null && this.mLayout.canScrollVertically()?this.mLayout.computeVerticalScrollExtent(this.mState):0;
   }

   public int computeVerticalScrollOffset() {
      return this.mLayout != null && this.mLayout.canScrollVertically()?this.mLayout.computeVerticalScrollOffset(this.mState):0;
   }

   public int computeVerticalScrollRange() {
      return this.mLayout != null && this.mLayout.canScrollVertically()?this.mLayout.computeVerticalScrollRange(this.mState):0;
   }

   void dispatchLayout() {
      if(this.mAdapter == null) {
         Log.e("RecyclerView", "No adapter attached; skipping layout");
      } else if(this.mLayout == null) {
         Log.e("RecyclerView", "No layout manager attached; skipping layout");
      } else {
         this.mState.mIsMeasuring = false;
         this.onEnterLayoutOrScroll();
         if(this.mState.mLayoutStep == 1) {
            this.dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
         } else if(!this.mAdapterHelper.hasUpdates() && this.mLayout.getWidth() == this.getWidth() && this.mLayout.getHeight() == this.getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
         } else {
            this.mLayout.setExactMeasureSpecsFrom(this);
            this.dispatchLayoutStep2();
         }

         this.dispatchLayoutStep3();
         this.onExitLayoutOrScroll();
      }
   }

   public boolean dispatchNestedFling(float var1, float var2, boolean var3) {
      return this.mScrollingChildHelper.dispatchNestedFling(var1, var2, var3);
   }

   public boolean dispatchNestedPreFling(float var1, float var2) {
      return this.mScrollingChildHelper.dispatchNestedPreFling(var1, var2);
   }

   public boolean dispatchNestedPreScroll(int var1, int var2, int[] var3, int[] var4) {
      return this.mScrollingChildHelper.dispatchNestedPreScroll(var1, var2, var3, var4);
   }

   public boolean dispatchNestedScroll(int var1, int var2, int var3, int var4, int[] var5) {
      return this.mScrollingChildHelper.dispatchNestedScroll(var1, var2, var3, var4, var5);
   }

   void dispatchOnScrollStateChanged(int var1) {
      if(this.mLayout != null) {
         this.mLayout.onScrollStateChanged(var1);
      }

      this.onScrollStateChanged(var1);
      if(this.mScrollListener != null) {
         this.mScrollListener.onScrollStateChanged(this, var1);
      }

      if(this.mScrollListeners != null) {
         for(int var2 = -1 + this.mScrollListeners.size(); var2 >= 0; --var2) {
            ((RecyclerView.OnScrollListener)this.mScrollListeners.get(var2)).onScrollStateChanged(this, var1);
         }
      }

   }

   void dispatchOnScrolled(int var1, int var2) {
      int var3 = this.getScrollX();
      int var4 = this.getScrollY();
      this.onScrollChanged(var3, var4, var3, var4);
      this.onScrolled(var1, var2);
      if(this.mScrollListener != null) {
         this.mScrollListener.onScrolled(this, var1, var2);
      }

      if(this.mScrollListeners != null) {
         for(int var5 = -1 + this.mScrollListeners.size(); var5 >= 0; --var5) {
            ((RecyclerView.OnScrollListener)this.mScrollListeners.get(var5)).onScrolled(this, var1, var2);
         }
      }

   }

   protected void dispatchRestoreInstanceState(SparseArray<Parcelable> var1) {
      this.dispatchThawSelfOnly(var1);
   }

   protected void dispatchSaveInstanceState(SparseArray<Parcelable> var1) {
      this.dispatchFreezeSelfOnly(var1);
   }

   public void draw(Canvas var1) {
      boolean var2 = true;
      super.draw(var1);
      int var3 = this.mItemDecorations.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         ((RecyclerView.ItemDecoration)this.mItemDecorations.get(var4)).onDrawOver(var1, this, this.mState);
      }

      EdgeEffectCompat var5 = this.mLeftGlow;
      boolean var6 = false;
      if(var5 != null) {
         boolean var14 = this.mLeftGlow.isFinished();
         var6 = false;
         if(!var14) {
            int var15 = var1.save();
            int var16;
            if(this.mClipToPadding) {
               var16 = this.getPaddingBottom();
            } else {
               var16 = 0;
            }

            var1.rotate(270.0F);
            var1.translate((float)(var16 + -this.getHeight()), 0.0F);
            if(this.mLeftGlow != null && this.mLeftGlow.draw(var1)) {
               var6 = var2;
            } else {
               var6 = false;
            }

            var1.restoreToCount(var15);
         }
      }

      if(this.mTopGlow != null && !this.mTopGlow.isFinished()) {
         int var12 = var1.save();
         if(this.mClipToPadding) {
            var1.translate((float)this.getPaddingLeft(), (float)this.getPaddingTop());
         }

         boolean var13;
         if(this.mTopGlow != null && this.mTopGlow.draw(var1)) {
            var13 = var2;
         } else {
            var13 = false;
         }

         var6 |= var13;
         var1.restoreToCount(var12);
      }

      if(this.mRightGlow != null && !this.mRightGlow.isFinished()) {
         int var8 = var1.save();
         int var9 = this.getWidth();
         int var10;
         if(this.mClipToPadding) {
            var10 = this.getPaddingTop();
         } else {
            var10 = 0;
         }

         var1.rotate(90.0F);
         var1.translate((float)(-var10), (float)(-var9));
         boolean var11;
         if(this.mRightGlow != null && this.mRightGlow.draw(var1)) {
            var11 = var2;
         } else {
            var11 = false;
         }

         var6 |= var11;
         var1.restoreToCount(var8);
      }

      if(this.mBottomGlow != null && !this.mBottomGlow.isFinished()) {
         int var7 = var1.save();
         var1.rotate(180.0F);
         if(this.mClipToPadding) {
            var1.translate((float)(-this.getWidth() + this.getPaddingRight()), (float)(-this.getHeight() + this.getPaddingBottom()));
         } else {
            var1.translate((float)(-this.getWidth()), (float)(-this.getHeight()));
         }

         if(this.mBottomGlow == null || !this.mBottomGlow.draw(var1)) {
            var2 = false;
         }

         var6 |= var2;
         var1.restoreToCount(var7);
      }

      if(!var6 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.isRunning()) {
         var6 = true;
      }

      if(var6) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   public boolean drawChild(Canvas var1, View var2, long var3) {
      return super.drawChild(var1, var2, var3);
   }

   void eatRequestLayout() {
      ++this.mEatRequestLayout;
      if(this.mEatRequestLayout == 1 && !this.mLayoutFrozen) {
         this.mLayoutRequestEaten = false;
      }

   }

   void ensureBottomGlow() {
      if(this.mBottomGlow == null) {
         this.mBottomGlow = new EdgeEffectCompat(this.getContext());
         if(this.mClipToPadding) {
            this.mBottomGlow.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
         } else {
            this.mBottomGlow.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
         }
      }
   }

   void ensureLeftGlow() {
      if(this.mLeftGlow == null) {
         this.mLeftGlow = new EdgeEffectCompat(this.getContext());
         if(this.mClipToPadding) {
            this.mLeftGlow.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
         } else {
            this.mLeftGlow.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
         }
      }
   }

   void ensureRightGlow() {
      if(this.mRightGlow == null) {
         this.mRightGlow = new EdgeEffectCompat(this.getContext());
         if(this.mClipToPadding) {
            this.mRightGlow.setSize(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
         } else {
            this.mRightGlow.setSize(this.getMeasuredHeight(), this.getMeasuredWidth());
         }
      }
   }

   void ensureTopGlow() {
      if(this.mTopGlow == null) {
         this.mTopGlow = new EdgeEffectCompat(this.getContext());
         if(this.mClipToPadding) {
            this.mTopGlow.setSize(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
         } else {
            this.mTopGlow.setSize(this.getMeasuredWidth(), this.getMeasuredHeight());
         }
      }
   }

   public View findChildViewUnder(float var1, float var2) {
      for(int var3 = -1 + this.mChildHelper.getChildCount(); var3 >= 0; --var3) {
         View var4 = this.mChildHelper.getChildAt(var3);
         float var5 = ViewCompat.getTranslationX(var4);
         float var6 = ViewCompat.getTranslationY(var4);
         if(var1 >= var5 + (float)var4.getLeft() && var1 <= var5 + (float)var4.getRight() && var2 >= var6 + (float)var4.getTop() && var2 <= var6 + (float)var4.getBottom()) {
            return var4;
         }
      }

      return null;
   }

   @Nullable
   public View findContainingItemView(View var1) {
      ViewParent var2;
      for(var2 = var1.getParent(); var2 != null && var2 != this && var2 instanceof View; var2 = var1.getParent()) {
         var1 = (View)var2;
      }

      return var2 == this?var1:null;
   }

   @Nullable
   public RecyclerView.ViewHolder findContainingViewHolder(View var1) {
      View var2 = this.findContainingItemView(var1);
      return var2 == null?null:this.getChildViewHolder(var2);
   }

   public RecyclerView.ViewHolder findViewHolderForAdapterPosition(int var1) {
      RecyclerView.ViewHolder var4;
      if(this.mDataSetHasChangedAfterLayout) {
         var4 = null;
      } else {
         int var2 = this.mChildHelper.getUnfilteredChildCount();
         int var3 = 0;

         while(true) {
            if(var3 >= var2) {
               return null;
            }

            var4 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var3));
            if(var4 != null && !var4.isRemoved() && this.getAdapterPositionFor(var4) == var1) {
               break;
            }

            ++var3;
         }
      }

      return var4;
   }

   public RecyclerView.ViewHolder findViewHolderForItemId(long var1) {
      int var3 = this.mChildHelper.getUnfilteredChildCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         RecyclerView.ViewHolder var5 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var4));
         if(var5 != null && var5.getItemId() == var1) {
            return var5;
         }
      }

      return null;
   }

   public RecyclerView.ViewHolder findViewHolderForLayoutPosition(int var1) {
      return this.findViewHolderForPosition(var1, false);
   }

   @Deprecated
   public RecyclerView.ViewHolder findViewHolderForPosition(int var1) {
      return this.findViewHolderForPosition(var1, false);
   }

   RecyclerView.ViewHolder findViewHolderForPosition(int var1, boolean var2) {
      int var3 = this.mChildHelper.getUnfilteredChildCount();
      int var4 = 0;

      RecyclerView.ViewHolder var5;
      while(true) {
         if(var4 >= var3) {
            return null;
         }

         var5 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var4));
         if(var5 != null && !var5.isRemoved()) {
            if(var2) {
               if(var5.mPosition == var1) {
                  break;
               }
            } else if(var5.getLayoutPosition() == var1) {
               break;
            }
         }

         ++var4;
      }

      return var5;
   }

   public boolean fling(int var1, int var2) {
      if(this.mLayout == null) {
         Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      } else if(!this.mLayoutFrozen) {
         boolean var3 = this.mLayout.canScrollHorizontally();
         boolean var4 = this.mLayout.canScrollVertically();
         if(!var3 || Math.abs(var1) < this.mMinFlingVelocity) {
            var1 = 0;
         }

         if(!var4 || Math.abs(var2) < this.mMinFlingVelocity) {
            var2 = 0;
         }

         if((var1 != 0 || var2 != 0) && !this.dispatchNestedPreFling((float)var1, (float)var2)) {
            boolean var5;
            if(!var3 && !var4) {
               var5 = false;
            } else {
               var5 = true;
            }

            this.dispatchNestedFling((float)var1, (float)var2, var5);
            if(var5) {
               int var7 = Math.max(-this.mMaxFlingVelocity, Math.min(var1, this.mMaxFlingVelocity));
               int var8 = Math.max(-this.mMaxFlingVelocity, Math.min(var2, this.mMaxFlingVelocity));
               this.mViewFlinger.fling(var7, var8);
               return true;
            }
         }
      }

      return false;
   }

   public View focusSearch(View var1, int var2) {
      View var3 = this.mLayout.onInterceptFocusSearch(var1, var2);
      if(var3 != null) {
         return var3;
      } else {
         View var4 = FocusFinder.getInstance().findNextFocus(this, var1, var2);
         if(var4 == null && this.mAdapter != null && this.mLayout != null && !this.isComputingLayout() && !this.mLayoutFrozen) {
            this.eatRequestLayout();
            var4 = this.mLayout.onFocusSearchFailed(var1, var2, this.mRecycler, this.mState);
            this.resumeRequestLayout(false);
         }

         return var4 != null?var4:super.focusSearch(var1, var2);
      }
   }

   protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
      if(this.mLayout == null) {
         throw new IllegalStateException("RecyclerView has no LayoutManager");
      } else {
         return this.mLayout.generateDefaultLayoutParams();
      }
   }

   public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet var1) {
      if(this.mLayout == null) {
         throw new IllegalStateException("RecyclerView has no LayoutManager");
      } else {
         return this.mLayout.generateLayoutParams(this.getContext(), var1);
      }
   }

   protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      if(this.mLayout == null) {
         throw new IllegalStateException("RecyclerView has no LayoutManager");
      } else {
         return this.mLayout.generateLayoutParams(var1);
      }
   }

   public RecyclerView.Adapter getAdapter() {
      return this.mAdapter;
   }

   public int getBaseline() {
      return this.mLayout != null?this.mLayout.getBaseline():super.getBaseline();
   }

   long getChangedHolderKey(RecyclerView.ViewHolder var1) {
      return this.mAdapter.hasStableIds()?var1.getItemId():(long)var1.mPosition;
   }

   public int getChildAdapterPosition(View var1) {
      RecyclerView.ViewHolder var2 = getChildViewHolderInt(var1);
      return var2 != null?var2.getAdapterPosition():-1;
   }

   protected int getChildDrawingOrder(int var1, int var2) {
      return this.mChildDrawingOrderCallback == null?super.getChildDrawingOrder(var1, var2):this.mChildDrawingOrderCallback.onGetChildDrawingOrder(var1, var2);
   }

   public long getChildItemId(View var1) {
      if(this.mAdapter != null && this.mAdapter.hasStableIds()) {
         RecyclerView.ViewHolder var2 = getChildViewHolderInt(var1);
         if(var2 != null) {
            return var2.getItemId();
         }
      }

      return -1L;
   }

   public int getChildLayoutPosition(View var1) {
      RecyclerView.ViewHolder var2 = getChildViewHolderInt(var1);
      return var2 != null?var2.getLayoutPosition():-1;
   }

   @Deprecated
   public int getChildPosition(View var1) {
      return this.getChildAdapterPosition(var1);
   }

   public RecyclerView.ViewHolder getChildViewHolder(View var1) {
      ViewParent var2 = var1.getParent();
      if(var2 != null && var2 != this) {
         throw new IllegalArgumentException("View " + var1 + " is not a direct child of " + this);
      } else {
         return getChildViewHolderInt(var1);
      }
   }

   public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
      return this.mAccessibilityDelegate;
   }

   public RecyclerView.ItemAnimator getItemAnimator() {
      return this.mItemAnimator;
   }

   Rect getItemDecorInsetsForChild(View var1) {
      RecyclerView.LayoutParams var2 = (RecyclerView.LayoutParams)var1.getLayoutParams();
      if(!var2.mInsetsDirty) {
         return var2.mDecorInsets;
      } else {
         Rect var3 = var2.mDecorInsets;
         var3.set(0, 0, 0, 0);
         int var4 = this.mItemDecorations.size();

         for(int var5 = 0; var5 < var4; ++var5) {
            this.mTempRect.set(0, 0, 0, 0);
            ((RecyclerView.ItemDecoration)this.mItemDecorations.get(var5)).getItemOffsets(this.mTempRect, var1, this, this.mState);
            var3.left += this.mTempRect.left;
            var3.top += this.mTempRect.top;
            var3.right += this.mTempRect.right;
            var3.bottom += this.mTempRect.bottom;
         }

         var2.mInsetsDirty = false;
         return var3;
      }
   }

   public RecyclerView.LayoutManager getLayoutManager() {
      return this.mLayout;
   }

   public int getMaxFlingVelocity() {
      return this.mMaxFlingVelocity;
   }

   public int getMinFlingVelocity() {
      return this.mMinFlingVelocity;
   }

   public RecyclerView.RecycledViewPool getRecycledViewPool() {
      return this.mRecycler.getRecycledViewPool();
   }

   public int getScrollState() {
      return this.mScrollState;
   }

   public boolean hasFixedSize() {
      return this.mHasFixedSize;
   }

   public boolean hasNestedScrollingParent() {
      return this.mScrollingChildHelper.hasNestedScrollingParent();
   }

   public boolean hasPendingAdapterUpdates() {
      return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.hasPendingUpdates();
   }

   void initAdapterManager() {
      this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() {
         void dispatchUpdate(AdapterHelper.UpdateOp var1) {
            switch(var1.cmd) {
            case 1:
               RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, var1.positionStart, var1.itemCount);
               return;
            case 2:
               RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, var1.positionStart, var1.itemCount);
               return;
            case 3:
            case 5:
            case 6:
            case 7:
            default:
               return;
            case 4:
               RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, var1.positionStart, var1.itemCount, var1.payload);
               return;
            case 8:
               RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, var1.positionStart, var1.itemCount, 1);
            }
         }

         public RecyclerView.ViewHolder findViewHolder(int var1) {
            RecyclerView.ViewHolder var2 = RecyclerView.this.findViewHolderForPosition(var1, true);
            if(var2 == null) {
               var2 = null;
            } else if(RecyclerView.this.mChildHelper.isHidden(var2.itemView)) {
               return null;
            }

            return var2;
         }

         public void markViewHoldersUpdated(int var1, int var2, Object var3) {
            RecyclerView.this.viewRangeUpdate(var1, var2, var3);
            RecyclerView.this.mItemsChanged = true;
         }

         public void offsetPositionsForAdd(int var1, int var2) {
            RecyclerView.this.offsetPositionRecordsForInsert(var1, var2);
            RecyclerView.this.mItemsAddedOrRemoved = true;
         }

         public void offsetPositionsForMove(int var1, int var2) {
            RecyclerView.this.offsetPositionRecordsForMove(var1, var2);
            RecyclerView.this.mItemsAddedOrRemoved = true;
         }

         public void offsetPositionsForRemovingInvisible(int var1, int var2) {
            RecyclerView.this.offsetPositionRecordsForRemove(var1, var2, true);
            RecyclerView.this.mItemsAddedOrRemoved = true;
            RecyclerView.State.access$1712(RecyclerView.this.mState, var2);
         }

         public void offsetPositionsForRemovingLaidOutOrNewView(int var1, int var2) {
            RecyclerView.this.offsetPositionRecordsForRemove(var1, var2, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
         }

         public void onDispatchFirstPass(AdapterHelper.UpdateOp var1) {
            this.dispatchUpdate(var1);
         }

         public void onDispatchSecondPass(AdapterHelper.UpdateOp var1) {
            this.dispatchUpdate(var1);
         }
      });
   }

   void invalidateGlows() {
      this.mBottomGlow = null;
      this.mTopGlow = null;
      this.mRightGlow = null;
      this.mLeftGlow = null;
   }

   public void invalidateItemDecorations() {
      if(this.mItemDecorations.size() != 0) {
         if(this.mLayout != null) {
            this.mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
         }

         this.markItemDecorInsetsDirty();
         this.requestLayout();
      }
   }

   boolean isAccessibilityEnabled() {
      return this.mAccessibilityManager != null && this.mAccessibilityManager.isEnabled();
   }

   public boolean isAnimating() {
      return this.mItemAnimator != null && this.mItemAnimator.isRunning();
   }

   public boolean isAttachedToWindow() {
      return this.mIsAttached;
   }

   public boolean isComputingLayout() {
      return this.mLayoutOrScrollCounter > 0;
   }

   public boolean isLayoutFrozen() {
      return this.mLayoutFrozen;
   }

   public boolean isNestedScrollingEnabled() {
      return this.mScrollingChildHelper.isNestedScrollingEnabled();
   }

   void markItemDecorInsetsDirty() {
      int var1 = this.mChildHelper.getUnfilteredChildCount();

      for(int var2 = 0; var2 < var1; ++var2) {
         ((RecyclerView.LayoutParams)this.mChildHelper.getUnfilteredChildAt(var2).getLayoutParams()).mInsetsDirty = true;
      }

      this.mRecycler.markItemDecorInsetsDirty();
   }

   void markKnownViewsInvalid() {
      int var1 = this.mChildHelper.getUnfilteredChildCount();

      for(int var2 = 0; var2 < var1; ++var2) {
         RecyclerView.ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var2));
         if(var3 != null && !var3.shouldIgnore()) {
            var3.addFlags(6);
         }
      }

      this.markItemDecorInsetsDirty();
      this.mRecycler.markKnownViewsInvalid();
   }

   public void offsetChildrenHorizontal(int var1) {
      int var2 = this.mChildHelper.getChildCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         this.mChildHelper.getChildAt(var3).offsetLeftAndRight(var1);
      }

   }

   public void offsetChildrenVertical(int var1) {
      int var2 = this.mChildHelper.getChildCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         this.mChildHelper.getChildAt(var3).offsetTopAndBottom(var1);
      }

   }

   void offsetPositionRecordsForInsert(int var1, int var2) {
      int var3 = this.mChildHelper.getUnfilteredChildCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         RecyclerView.ViewHolder var5 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var4));
         if(var5 != null && !var5.shouldIgnore() && var5.mPosition >= var1) {
            var5.offsetPosition(var2, false);
            this.mState.mStructureChanged = true;
         }
      }

      this.mRecycler.offsetPositionRecordsForInsert(var1, var2);
      this.requestLayout();
   }

   void offsetPositionRecordsForMove(int var1, int var2) {
      int var3 = this.mChildHelper.getUnfilteredChildCount();
      int var4;
      int var5;
      byte var6;
      if(var1 < var2) {
         var4 = var1;
         var5 = var2;
         var6 = -1;
      } else {
         var4 = var2;
         var5 = var1;
         var6 = 1;
      }

      for(int var7 = 0; var7 < var3; ++var7) {
         RecyclerView.ViewHolder var8 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var7));
         if(var8 != null && var8.mPosition >= var4 && var8.mPosition <= var5) {
            if(var8.mPosition == var1) {
               var8.offsetPosition(var2 - var1, false);
            } else {
               var8.offsetPosition(var6, false);
            }

            this.mState.mStructureChanged = true;
         }
      }

      this.mRecycler.offsetPositionRecordsForMove(var1, var2);
      this.requestLayout();
   }

   void offsetPositionRecordsForRemove(int var1, int var2, boolean var3) {
      int var4 = var1 + var2;
      int var5 = this.mChildHelper.getUnfilteredChildCount();

      for(int var6 = 0; var6 < var5; ++var6) {
         RecyclerView.ViewHolder var7 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var6));
         if(var7 != null && !var7.shouldIgnore()) {
            if(var7.mPosition >= var4) {
               var7.offsetPosition(-var2, var3);
               this.mState.mStructureChanged = true;
            } else if(var7.mPosition >= var1) {
               var7.flagRemovedAndOffsetPosition(var1 - 1, -var2, var3);
               this.mState.mStructureChanged = true;
            }
         }
      }

      this.mRecycler.offsetPositionRecordsForRemove(var1, var2, var3);
      this.requestLayout();
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mLayoutOrScrollCounter = 0;
      this.mIsAttached = true;
      this.mFirstLayoutComplete = false;
      if(this.mLayout != null) {
         this.mLayout.dispatchAttachedToWindow(this);
      }

      this.mPostedAnimatorRunner = false;
   }

   public void onChildAttachedToWindow(View var1) {
   }

   public void onChildDetachedFromWindow(View var1) {
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      if(this.mItemAnimator != null) {
         this.mItemAnimator.endAnimations();
      }

      this.mFirstLayoutComplete = false;
      this.stopScroll();
      this.mIsAttached = false;
      if(this.mLayout != null) {
         this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
      }

      this.removeCallbacks(this.mItemAnimatorRunner);
      this.mViewInfoStore.onDetach();
   }

   public void onDraw(Canvas var1) {
      super.onDraw(var1);
      int var2 = this.mItemDecorations.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         ((RecyclerView.ItemDecoration)this.mItemDecorations.get(var3)).onDraw(var1, this, this.mState);
      }

   }

   public boolean onGenericMotionEvent(MotionEvent var1) {
      if(this.mLayout != null && !this.mLayoutFrozen && (2 & MotionEventCompat.getSource(var1)) != 0 && var1.getAction() == 8) {
         float var2;
         if(this.mLayout.canScrollVertically()) {
            var2 = -MotionEventCompat.getAxisValue(var1, 9);
         } else {
            var2 = 0.0F;
         }

         float var3;
         if(this.mLayout.canScrollHorizontally()) {
            var3 = MotionEventCompat.getAxisValue(var1, 10);
         } else {
            var3 = 0.0F;
         }

         if(var2 != 0.0F || var3 != 0.0F) {
            float var4 = this.getScrollFactor();
            this.scrollByInternal((int)(var3 * var4), (int)(var2 * var4), var1);
            return false;
         }
      }

      return false;
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      if(this.mLayoutFrozen) {
         return false;
      } else if(this.dispatchOnItemTouchIntercept(var1)) {
         this.cancelTouch();
         return true;
      } else if(this.mLayout == null) {
         return false;
      } else {
         boolean var2 = this.mLayout.canScrollHorizontally();
         boolean var3 = this.mLayout.canScrollVertically();
         if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
         }

         this.mVelocityTracker.addMovement(var1);
         int var4 = MotionEventCompat.getActionMasked(var1);
         int var5 = MotionEventCompat.getActionIndex(var1);
         switch(var4) {
         case 0:
            if(this.mIgnoreMotionEventTillDown) {
               this.mIgnoreMotionEventTillDown = false;
            }

            this.mScrollPointerId = MotionEventCompat.getPointerId(var1, 0);
            int var23 = (int)(0.5F + var1.getX());
            this.mLastTouchX = var23;
            this.mInitialTouchX = var23;
            int var24 = (int)(0.5F + var1.getY());
            this.mLastTouchY = var24;
            this.mInitialTouchY = var24;
            if(this.mScrollState == 2) {
               this.getParent().requestDisallowInterceptTouchEvent(true);
               this.setScrollState(1);
            }

            int[] var25 = this.mNestedOffsets;
            this.mNestedOffsets[1] = 0;
            var25[0] = 0;
            int var26 = 0;
            if(var2) {
               var26 = 0 | 1;
            }

            if(var3) {
               var26 |= 2;
            }

            this.startNestedScroll(var26);
            break;
         case 1:
            this.mVelocityTracker.clear();
            this.stopNestedScroll();
            break;
         case 2:
            int var6 = MotionEventCompat.findPointerIndex(var1, this.mScrollPointerId);
            if(var6 < 0) {
               Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
               return false;
            }

            int var7 = (int)(0.5F + MotionEventCompat.getX(var1, var6));
            int var8 = (int)(0.5F + MotionEventCompat.getY(var1, var6));
            if(this.mScrollState != 1) {
               int var9 = var7 - this.mInitialTouchX;
               int var10 = var8 - this.mInitialTouchY;
               boolean var11 = false;
               if(var2) {
                  int var15 = Math.abs(var9);
                  int var16 = this.mTouchSlop;
                  var11 = false;
                  if(var15 > var16) {
                     int var17 = this.mInitialTouchX;
                     int var18 = this.mTouchSlop;
                     byte var19;
                     if(var9 < 0) {
                        var19 = -1;
                     } else {
                        var19 = 1;
                     }

                     this.mLastTouchX = var17 + var19 * var18;
                     var11 = true;
                  }
               }

               if(var3 && Math.abs(var10) > this.mTouchSlop) {
                  int var12 = this.mInitialTouchY;
                  int var13 = this.mTouchSlop;
                  byte var14;
                  if(var10 < 0) {
                     var14 = -1;
                  } else {
                     var14 = 1;
                  }

                  this.mLastTouchY = var12 + var14 * var13;
                  var11 = true;
               }

               if(var11) {
                  this.setScrollState(1);
               }
            }
            break;
         case 3:
            this.cancelTouch();
         case 4:
         default:
            break;
         case 5:
            this.mScrollPointerId = MotionEventCompat.getPointerId(var1, var5);
            int var21 = (int)(0.5F + MotionEventCompat.getX(var1, var5));
            this.mLastTouchX = var21;
            this.mInitialTouchX = var21;
            int var22 = (int)(0.5F + MotionEventCompat.getY(var1, var5));
            this.mLastTouchY = var22;
            this.mInitialTouchY = var22;
            break;
         case 6:
            this.onPointerUp(var1);
         }

         return this.mScrollState == 1;
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      TraceCompat.beginSection("RV OnLayout");
      this.dispatchLayout();
      TraceCompat.endSection();
      this.mFirstLayoutComplete = true;
   }

   protected void onMeasure(int var1, int var2) {
      if(this.mLayout == null) {
         this.defaultOnMeasure(var1, var2);
      } else {
         if(!this.mLayout.mAutoMeasure) {
            if(this.mHasFixedSize) {
               this.mLayout.onMeasure(this.mRecycler, this.mState, var1, var2);
               return;
            }

            if(this.mAdapterUpdateDuringMeasure) {
               this.eatRequestLayout();
               this.processAdapterUpdatesAndSetAnimationFlags();
               if(this.mState.mRunPredictiveAnimations) {
                  this.mState.mInPreLayout = true;
               } else {
                  this.mAdapterHelper.consumeUpdatesInOnePass();
                  this.mState.mInPreLayout = false;
               }

               this.mAdapterUpdateDuringMeasure = false;
               this.resumeRequestLayout(false);
            }

            if(this.mAdapter != null) {
               this.mState.mItemCount = this.mAdapter.getItemCount();
            } else {
               this.mState.mItemCount = 0;
            }

            this.eatRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, var1, var2);
            this.resumeRequestLayout(false);
            this.mState.mInPreLayout = false;
            return;
         }

         int var6 = MeasureSpec.getMode(var1);
         int var7 = MeasureSpec.getMode(var2);
         boolean var8 = false;
         if(var6 == 1073741824) {
            var8 = false;
            if(var7 == 1073741824) {
               var8 = true;
            }
         }

         this.mLayout.onMeasure(this.mRecycler, this.mState, var1, var2);
         if(!var8 && this.mAdapter != null) {
            if(this.mState.mLayoutStep == 1) {
               this.dispatchLayoutStep1();
            }

            this.mLayout.setMeasureSpecs(var1, var2);
            this.mState.mIsMeasuring = true;
            this.dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(var1, var2);
            if(this.mLayout.shouldMeasureTwice()) {
               this.mLayout.setMeasureSpecs(MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 1073741824));
               this.mState.mIsMeasuring = true;
               this.dispatchLayoutStep2();
               this.mLayout.setMeasuredDimensionFromChildren(var1, var2);
               return;
            }
         }
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      this.mPendingSavedState = (RecyclerView.SavedState)var1;
      super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
      if(this.mLayout != null && this.mPendingSavedState.mLayoutState != null) {
         this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
      }

   }

   protected Parcelable onSaveInstanceState() {
      RecyclerView.SavedState var1 = new RecyclerView.SavedState(super.onSaveInstanceState());
      if(this.mPendingSavedState != null) {
         var1.copyFrom(this.mPendingSavedState);
         return var1;
      } else if(this.mLayout != null) {
         var1.mLayoutState = this.mLayout.onSaveInstanceState();
         return var1;
      } else {
         var1.mLayoutState = null;
         return var1;
      }
   }

   public void onScrollStateChanged(int var1) {
   }

   public void onScrolled(int var1, int var2) {
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if(var1 != var3 || var2 != var4) {
         this.invalidateGlows();
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      if(!this.mLayoutFrozen && !this.mIgnoreMotionEventTillDown) {
         if(this.dispatchOnItemTouch(var1)) {
            this.cancelTouch();
            return true;
         } else if(this.mLayout == null) {
            return false;
         } else {
            boolean var2 = this.mLayout.canScrollHorizontally();
            boolean var3 = this.mLayout.canScrollVertically();
            if(this.mVelocityTracker == null) {
               this.mVelocityTracker = VelocityTracker.obtain();
            }

            MotionEvent var4 = MotionEvent.obtain(var1);
            int var5 = MotionEventCompat.getActionMasked(var1);
            int var6 = MotionEventCompat.getActionIndex(var1);
            if(var5 == 0) {
               int[] var29 = this.mNestedOffsets;
               this.mNestedOffsets[1] = 0;
               var29[0] = 0;
            }

            var4.offsetLocation((float)this.mNestedOffsets[0], (float)this.mNestedOffsets[1]);
            boolean var7 = false;
            switch(var5) {
            case 0:
               this.mScrollPointerId = MotionEventCompat.getPointerId(var1, 0);
               int var25 = (int)(0.5F + var1.getX());
               this.mLastTouchX = var25;
               this.mInitialTouchX = var25;
               int var26 = (int)(0.5F + var1.getY());
               this.mLastTouchY = var26;
               this.mInitialTouchY = var26;
               int var27 = 0;
               if(var2) {
                  var27 = 0 | 1;
               }

               if(var3) {
                  var27 |= 2;
               }

               this.startNestedScroll(var27);
               var7 = false;
               break;
            case 1:
               this.mVelocityTracker.addMovement(var4);
               var7 = true;
               this.mVelocityTracker.computeCurrentVelocity(1000, (float)this.mMaxFlingVelocity);
               float var8;
               if(var2) {
                  var8 = -VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mScrollPointerId);
               } else {
                  var8 = 0.0F;
               }

               float var9;
               if(var3) {
                  var9 = -VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mScrollPointerId);
               } else {
                  var9 = 0.0F;
               }

               if(var8 == 0.0F && var9 == 0.0F || !this.fling((int)var8, (int)var9)) {
                  this.setScrollState(0);
               }

               this.resetTouch();
               break;
            case 2:
               int var10 = MotionEventCompat.findPointerIndex(var1, this.mScrollPointerId);
               if(var10 < 0) {
                  Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                  return false;
               }

               int var11 = (int)(0.5F + MotionEventCompat.getX(var1, var10));
               int var12 = (int)(0.5F + MotionEventCompat.getY(var1, var10));
               int var13 = this.mLastTouchX - var11;
               int var14 = this.mLastTouchY - var12;
               if(this.dispatchNestedPreScroll(var13, var14, this.mScrollConsumed, this.mScrollOffset)) {
                  var13 -= this.mScrollConsumed[0];
                  var14 -= this.mScrollConsumed[1];
                  var4.offsetLocation((float)this.mScrollOffset[0], (float)this.mScrollOffset[1]);
                  int[] var20 = this.mNestedOffsets;
                  var20[0] += this.mScrollOffset[0];
                  int[] var21 = this.mNestedOffsets;
                  var21[1] += this.mScrollOffset[1];
               }

               if(this.mScrollState != 1) {
                  boolean var15 = false;
                  if(var2) {
                     int var18 = Math.abs(var13);
                     int var19 = this.mTouchSlop;
                     var15 = false;
                     if(var18 > var19) {
                        if(var13 > 0) {
                           var13 -= this.mTouchSlop;
                        } else {
                           var13 += this.mTouchSlop;
                        }

                        var15 = true;
                     }
                  }

                  if(var3 && Math.abs(var14) > this.mTouchSlop) {
                     if(var14 > 0) {
                        var14 -= this.mTouchSlop;
                     } else {
                        var14 += this.mTouchSlop;
                     }

                     var15 = true;
                  }

                  if(var15) {
                     this.setScrollState(1);
                  }
               }

               int var16 = this.mScrollState;
               var7 = false;
               if(var16 == 1) {
                  this.mLastTouchX = var11 - this.mScrollOffset[0];
                  this.mLastTouchY = var12 - this.mScrollOffset[1];
                  if(!var2) {
                     var13 = 0;
                  }

                  if(!var3) {
                     var14 = 0;
                  }

                  boolean var17 = this.scrollByInternal(var13, var14, var4);
                  var7 = false;
                  if(var17) {
                     this.getParent().requestDisallowInterceptTouchEvent(true);
                     var7 = false;
                  }
               }
               break;
            case 3:
               this.cancelTouch();
               var7 = false;
            case 4:
            default:
               break;
            case 5:
               this.mScrollPointerId = MotionEventCompat.getPointerId(var1, var6);
               int var23 = (int)(0.5F + MotionEventCompat.getX(var1, var6));
               this.mLastTouchX = var23;
               this.mInitialTouchX = var23;
               int var24 = (int)(0.5F + MotionEventCompat.getY(var1, var6));
               this.mLastTouchY = var24;
               this.mInitialTouchY = var24;
               var7 = false;
               break;
            case 6:
               this.onPointerUp(var1);
               var7 = false;
            }

            if(!var7) {
               this.mVelocityTracker.addMovement(var4);
            }

            var4.recycle();
            return true;
         }
      } else {
         return false;
      }
   }

   protected void removeDetachedView(View var1, boolean var2) {
      RecyclerView.ViewHolder var3 = getChildViewHolderInt(var1);
      if(var3 != null) {
         if(var3.isTmpDetached()) {
            var3.clearTmpDetachFlag();
         } else if(!var3.shouldIgnore()) {
            throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + var3);
         }
      }

      this.dispatchChildDetached(var1);
      super.removeDetachedView(var1, var2);
   }

   public void removeItemDecoration(RecyclerView.ItemDecoration var1) {
      if(this.mLayout != null) {
         this.mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
      }

      this.mItemDecorations.remove(var1);
      if(this.mItemDecorations.isEmpty()) {
         boolean var3;
         if(ViewCompat.getOverScrollMode(this) == 2) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.setWillNotDraw(var3);
      }

      this.markItemDecorInsetsDirty();
      this.requestLayout();
   }

   public void removeOnChildAttachStateChangeListener(RecyclerView.OnChildAttachStateChangeListener var1) {
      if(this.mOnChildAttachStateListeners != null) {
         this.mOnChildAttachStateListeners.remove(var1);
      }
   }

   public void removeOnItemTouchListener(RecyclerView.OnItemTouchListener var1) {
      this.mOnItemTouchListeners.remove(var1);
      if(this.mActiveOnItemTouchListener == var1) {
         this.mActiveOnItemTouchListener = null;
      }

   }

   public void removeOnScrollListener(RecyclerView.OnScrollListener var1) {
      if(this.mScrollListeners != null) {
         this.mScrollListeners.remove(var1);
      }

   }

   public void requestChildFocus(View var1, View var2) {
      if(!this.mLayout.onRequestChildFocus(this, this.mState, var1, var2) && var2 != null) {
         this.mTempRect.set(0, 0, var2.getWidth(), var2.getHeight());
         android.view.ViewGroup.LayoutParams var3 = var2.getLayoutParams();
         if(var3 instanceof RecyclerView.LayoutParams) {
            RecyclerView.LayoutParams var8 = (RecyclerView.LayoutParams)var3;
            if(!var8.mInsetsDirty) {
               Rect var9 = var8.mDecorInsets;
               Rect var10 = this.mTempRect;
               var10.left -= var9.left;
               Rect var11 = this.mTempRect;
               var11.right += var9.right;
               Rect var12 = this.mTempRect;
               var12.top -= var9.top;
               Rect var13 = this.mTempRect;
               var13.bottom += var9.bottom;
            }
         }

         this.offsetDescendantRectToMyCoords(var2, this.mTempRect);
         this.offsetRectIntoDescendantCoords(var1, this.mTempRect);
         Rect var4 = this.mTempRect;
         boolean var5 = this.mFirstLayoutComplete;
         boolean var6 = false;
         if(!var5) {
            var6 = true;
         }

         this.requestChildRectangleOnScreen(var1, var4, var6);
      }

      super.requestChildFocus(var1, var2);
   }

   public boolean requestChildRectangleOnScreen(View var1, Rect var2, boolean var3) {
      return this.mLayout.requestChildRectangleOnScreen(this, var1, var2, var3);
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      int var2 = this.mOnItemTouchListeners.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         ((RecyclerView.OnItemTouchListener)this.mOnItemTouchListeners.get(var3)).onRequestDisallowInterceptTouchEvent(var1);
      }

      super.requestDisallowInterceptTouchEvent(var1);
   }

   public void requestLayout() {
      if(this.mEatRequestLayout == 0 && !this.mLayoutFrozen) {
         super.requestLayout();
      } else {
         this.mLayoutRequestEaten = true;
      }
   }

   void resumeRequestLayout(boolean var1) {
      if(this.mEatRequestLayout < 1) {
         this.mEatRequestLayout = 1;
      }

      if(!var1) {
         this.mLayoutRequestEaten = false;
      }

      if(this.mEatRequestLayout == 1) {
         if(var1 && this.mLayoutRequestEaten && !this.mLayoutFrozen && this.mLayout != null && this.mAdapter != null) {
            this.dispatchLayout();
         }

         if(!this.mLayoutFrozen) {
            this.mLayoutRequestEaten = false;
         }
      }

      this.mEatRequestLayout += -1;
   }

   void saveOldPositions() {
      int var1 = this.mChildHelper.getUnfilteredChildCount();

      for(int var2 = 0; var2 < var1; ++var2) {
         RecyclerView.ViewHolder var3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(var2));
         if(!var3.shouldIgnore()) {
            var3.saveOldPosition();
         }
      }

   }

   public void scrollBy(int var1, int var2) {
      if(this.mLayout == null) {
         Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      } else if(!this.mLayoutFrozen) {
         boolean var3 = this.mLayout.canScrollHorizontally();
         boolean var4 = this.mLayout.canScrollVertically();
         if(var3 || var4) {
            if(!var3) {
               var1 = 0;
            }

            if(!var4) {
               var2 = 0;
            }

            this.scrollByInternal(var1, var2, (MotionEvent)null);
            return;
         }
      }

   }

   boolean scrollByInternal(int var1, int var2, MotionEvent var3) {
      this.consumePendingUpdateOperations();
      RecyclerView.Adapter var4 = this.mAdapter;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      if(var4 != null) {
         this.eatRequestLayout();
         this.onEnterLayoutOrScroll();
         TraceCompat.beginSection("RV Scroll");
         var5 = 0;
         var7 = 0;
         if(var1 != 0) {
            var5 = this.mLayout.scrollHorizontallyBy(var1, this.mRecycler, this.mState);
            var7 = var1 - var5;
         }

         var6 = 0;
         var8 = 0;
         if(var2 != 0) {
            var6 = this.mLayout.scrollVerticallyBy(var2, this.mRecycler, this.mState);
            var8 = var2 - var6;
         }

         TraceCompat.endSection();
         this.repositionShadowingViews();
         this.onExitLayoutOrScroll();
         this.resumeRequestLayout(false);
      }

      if(!this.mItemDecorations.isEmpty()) {
         this.invalidate();
      }

      if(this.dispatchNestedScroll(var5, var6, var7, var8, this.mScrollOffset)) {
         this.mLastTouchX -= this.mScrollOffset[0];
         this.mLastTouchY -= this.mScrollOffset[1];
         if(var3 != null) {
            var3.offsetLocation((float)this.mScrollOffset[0], (float)this.mScrollOffset[1]);
         }

         int[] var9 = this.mNestedOffsets;
         var9[0] += this.mScrollOffset[0];
         int[] var10 = this.mNestedOffsets;
         var10[1] += this.mScrollOffset[1];
      } else if(ViewCompat.getOverScrollMode(this) != 2) {
         if(var3 != null) {
            this.pullGlows(var3.getX(), (float)var7, var3.getY(), (float)var8);
         }

         this.considerReleasingGlowsOnScroll(var1, var2);
      }

      if(var5 != 0 || var6 != 0) {
         this.dispatchOnScrolled(var5, var6);
      }

      if(!this.awakenScrollBars()) {
         this.invalidate();
      }

      return var5 != 0 || var6 != 0;
   }

   public void scrollTo(int var1, int var2) {
      Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
   }

   public void scrollToPosition(int var1) {
      if(!this.mLayoutFrozen) {
         this.stopScroll();
         if(this.mLayout == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
         } else {
            this.mLayout.scrollToPosition(var1);
            this.awakenScrollBars();
         }
      }
   }

   public void sendAccessibilityEventUnchecked(AccessibilityEvent var1) {
      if(!this.shouldDeferAccessibilityEvent(var1)) {
         super.sendAccessibilityEventUnchecked(var1);
      }
   }

   public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate var1) {
      this.mAccessibilityDelegate = var1;
      ViewCompat.setAccessibilityDelegate(this, this.mAccessibilityDelegate);
   }

   public void setAdapter(RecyclerView.Adapter var1) {
      this.setLayoutFrozen(false);
      this.setAdapterInternal(var1, false, true);
      this.requestLayout();
   }

   public void setChildDrawingOrderCallback(RecyclerView.ChildDrawingOrderCallback var1) {
      if(var1 != this.mChildDrawingOrderCallback) {
         this.mChildDrawingOrderCallback = var1;
         boolean var2;
         if(this.mChildDrawingOrderCallback != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.setChildrenDrawingOrderEnabled(var2);
      }
   }

   public void setClipToPadding(boolean var1) {
      if(var1 != this.mClipToPadding) {
         this.invalidateGlows();
      }

      this.mClipToPadding = var1;
      super.setClipToPadding(var1);
      if(this.mFirstLayoutComplete) {
         this.requestLayout();
      }

   }

   public void setHasFixedSize(boolean var1) {
      this.mHasFixedSize = var1;
   }

   public void setItemAnimator(RecyclerView.ItemAnimator var1) {
      if(this.mItemAnimator != null) {
         this.mItemAnimator.endAnimations();
         this.mItemAnimator.setListener((RecyclerView.ItemAnimatorListener)null);
      }

      this.mItemAnimator = var1;
      if(this.mItemAnimator != null) {
         this.mItemAnimator.setListener(this.mItemAnimatorListener);
      }

   }

   public void setItemViewCacheSize(int var1) {
      this.mRecycler.setViewCacheSize(var1);
   }

   public void setLayoutFrozen(boolean var1) {
      if(var1 != this.mLayoutFrozen) {
         this.assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
         if(var1) {
            long var2 = SystemClock.uptimeMillis();
            this.onTouchEvent(MotionEvent.obtain(var2, var2, 3, 0.0F, 0.0F, 0));
            this.mLayoutFrozen = true;
            this.mIgnoreMotionEventTillDown = true;
            this.stopScroll();
            return;
         }

         this.mLayoutFrozen = false;
         if(this.mLayoutRequestEaten && this.mLayout != null && this.mAdapter != null) {
            this.requestLayout();
         }

         this.mLayoutRequestEaten = false;
      }

   }

   public void setLayoutManager(RecyclerView.LayoutManager var1) {
      if(var1 != this.mLayout) {
         this.stopScroll();
         if(this.mLayout != null) {
            if(this.mIsAttached) {
               this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }

            this.mLayout.setRecyclerView((RecyclerView)null);
         }

         this.mRecycler.clear();
         this.mChildHelper.removeAllViewsUnfiltered();
         this.mLayout = var1;
         if(var1 != null) {
            if(var1.mRecyclerView != null) {
               throw new IllegalArgumentException("LayoutManager " + var1 + " is already attached to a RecyclerView: " + var1.mRecyclerView);
            }

            this.mLayout.setRecyclerView(this);
            if(this.mIsAttached) {
               this.mLayout.dispatchAttachedToWindow(this);
            }
         }

         this.requestLayout();
      }
   }

   public void setNestedScrollingEnabled(boolean var1) {
      this.mScrollingChildHelper.setNestedScrollingEnabled(var1);
   }

   @Deprecated
   public void setOnScrollListener(RecyclerView.OnScrollListener var1) {
      this.mScrollListener = var1;
   }

   public void setRecycledViewPool(RecyclerView.RecycledViewPool var1) {
      this.mRecycler.setRecycledViewPool(var1);
   }

   public void setRecyclerListener(RecyclerView.RecyclerListener var1) {
      this.mRecyclerListener = var1;
   }

   public void setScrollingTouchSlop(int var1) {
      ViewConfiguration var2 = ViewConfiguration.get(this.getContext());
      switch(var1) {
      case 1:
         this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(var2);
         return;
      default:
         Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + var1 + "; using default value");
      case 0:
         this.mTouchSlop = var2.getScaledTouchSlop();
      }
   }

   public void setViewCacheExtension(RecyclerView.ViewCacheExtension var1) {
      this.mRecycler.setViewCacheExtension(var1);
   }

   boolean shouldDeferAccessibilityEvent(AccessibilityEvent var1) {
      if(this.isComputingLayout()) {
         int var2 = 0;
         if(var1 != null) {
            var2 = AccessibilityEventCompat.getContentChangeTypes(var1);
         }

         if(var2 == 0) {
            var2 = 0;
         }

         this.mEatenAccessibilityChangeFlags |= var2;
         return true;
      } else {
         return false;
      }
   }

   public void smoothScrollBy(int var1, int var2) {
      if(this.mLayout == null) {
         Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      } else if(!this.mLayoutFrozen) {
         if(!this.mLayout.canScrollHorizontally()) {
            var1 = 0;
         }

         if(!this.mLayout.canScrollVertically()) {
            var2 = 0;
         }

         if(var1 != 0 || var2 != 0) {
            this.mViewFlinger.smoothScrollBy(var1, var2);
            return;
         }
      }

   }

   public void smoothScrollToPosition(int var1) {
      if(!this.mLayoutFrozen) {
         if(this.mLayout == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
         } else {
            this.mLayout.smoothScrollToPosition(this, this.mState, var1);
         }
      }
   }

   public boolean startNestedScroll(int var1) {
      return this.mScrollingChildHelper.startNestedScroll(var1);
   }

   public void stopNestedScroll() {
      this.mScrollingChildHelper.stopNestedScroll();
   }

   public void stopScroll() {
      this.setScrollState(0);
      this.stopScrollersInternal();
   }

   public void swapAdapter(RecyclerView.Adapter var1, boolean var2) {
      this.setLayoutFrozen(false);
      this.setAdapterInternal(var1, true, var2);
      this.setDataSetChangedAfterLayout();
      this.requestLayout();
   }

   void viewRangeUpdate(int var1, int var2, Object var3) {
      int var4 = this.mChildHelper.getUnfilteredChildCount();
      int var5 = var1 + var2;

      for(int var6 = 0; var6 < var4; ++var6) {
         View var7 = this.mChildHelper.getUnfilteredChildAt(var6);
         RecyclerView.ViewHolder var8 = getChildViewHolderInt(var7);
         if(var8 != null && !var8.shouldIgnore() && var8.mPosition >= var1 && var8.mPosition < var5) {
            var8.addFlags(2);
            var8.addChangePayload(var3);
            ((RecyclerView.LayoutParams)var7.getLayoutParams()).mInsetsDirty = true;
         }
      }

      this.mRecycler.viewRangeUpdate(var1, var2);
   }

   public abstract static class Adapter<VH extends RecyclerView.ViewHolder> {
      private boolean mHasStableIds = false;
      private final RecyclerView.AdapterDataObservable mObservable = new RecyclerView.AdapterDataObservable();

      public final void bindViewHolder(VH var1, int var2) {
         var1.mPosition = var2;
         if(this.hasStableIds()) {
            var1.mItemId = this.getItemId(var2);
         }

         var1.setFlags(1, 519);
         TraceCompat.beginSection("RV OnBindView");
         this.onBindViewHolder(var1, var2, var1.getUnmodifiedPayloads());
         var1.clearPayload();
         TraceCompat.endSection();
      }

      public final VH createViewHolder(ViewGroup var1, int var2) {
         TraceCompat.beginSection("RV CreateView");
         RecyclerView.ViewHolder var3 = this.onCreateViewHolder(var1, var2);
         var3.mItemViewType = var2;
         TraceCompat.endSection();
         return var3;
      }

      public abstract int getItemCount();

      public long getItemId(int var1) {
         return -1L;
      }

      public int getItemViewType(int var1) {
         return 0;
      }

      public final boolean hasObservers() {
         return this.mObservable.hasObservers();
      }

      public final boolean hasStableIds() {
         return this.mHasStableIds;
      }

      public final void notifyDataSetChanged() {
         this.mObservable.notifyChanged();
      }

      public final void notifyItemChanged(int var1) {
         this.mObservable.notifyItemRangeChanged(var1, 1);
      }

      public final void notifyItemChanged(int var1, Object var2) {
         this.mObservable.notifyItemRangeChanged(var1, 1, var2);
      }

      public final void notifyItemInserted(int var1) {
         this.mObservable.notifyItemRangeInserted(var1, 1);
      }

      public final void notifyItemMoved(int var1, int var2) {
         this.mObservable.notifyItemMoved(var1, var2);
      }

      public final void notifyItemRangeChanged(int var1, int var2) {
         this.mObservable.notifyItemRangeChanged(var1, var2);
      }

      public final void notifyItemRangeChanged(int var1, int var2, Object var3) {
         this.mObservable.notifyItemRangeChanged(var1, var2, var3);
      }

      public final void notifyItemRangeInserted(int var1, int var2) {
         this.mObservable.notifyItemRangeInserted(var1, var2);
      }

      public final void notifyItemRangeRemoved(int var1, int var2) {
         this.mObservable.notifyItemRangeRemoved(var1, var2);
      }

      public final void notifyItemRemoved(int var1) {
         this.mObservable.notifyItemRangeRemoved(var1, 1);
      }

      public void onAttachedToRecyclerView(RecyclerView var1) {
      }

      public abstract void onBindViewHolder(VH var1, int var2);

      public void onBindViewHolder(VH var1, int var2, List<Object> var3) {
         this.onBindViewHolder(var1, var2);
      }

      public abstract VH onCreateViewHolder(ViewGroup var1, int var2);

      public void onDetachedFromRecyclerView(RecyclerView var1) {
      }

      public boolean onFailedToRecycleView(VH var1) {
         return false;
      }

      public void onViewAttachedToWindow(VH var1) {
      }

      public void onViewDetachedFromWindow(VH var1) {
      }

      public void onViewRecycled(VH var1) {
      }

      public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver var1) {
         this.mObservable.registerObserver(var1);
      }

      public void setHasStableIds(boolean var1) {
         if(this.hasObservers()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
         } else {
            this.mHasStableIds = var1;
         }
      }

      public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver var1) {
         this.mObservable.unregisterObserver(var1);
      }
   }

   static class AdapterDataObservable extends Observable<RecyclerView.AdapterDataObserver> {
      public boolean hasObservers() {
         return !this.mObservers.isEmpty();
      }

      public void notifyChanged() {
         for(int var1 = -1 + this.mObservers.size(); var1 >= 0; --var1) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(var1)).onChanged();
         }

      }

      public void notifyItemMoved(int var1, int var2) {
         for(int var3 = -1 + this.mObservers.size(); var3 >= 0; --var3) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(var3)).onItemRangeMoved(var1, var2, 1);
         }

      }

      public void notifyItemRangeChanged(int var1, int var2) {
         this.notifyItemRangeChanged(var1, var2, (Object)null);
      }

      public void notifyItemRangeChanged(int var1, int var2, Object var3) {
         for(int var4 = -1 + this.mObservers.size(); var4 >= 0; --var4) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(var4)).onItemRangeChanged(var1, var2, var3);
         }

      }

      public void notifyItemRangeInserted(int var1, int var2) {
         for(int var3 = -1 + this.mObservers.size(); var3 >= 0; --var3) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(var3)).onItemRangeInserted(var1, var2);
         }

      }

      public void notifyItemRangeRemoved(int var1, int var2) {
         for(int var3 = -1 + this.mObservers.size(); var3 >= 0; --var3) {
            ((RecyclerView.AdapterDataObserver)this.mObservers.get(var3)).onItemRangeRemoved(var1, var2);
         }

      }
   }

   public abstract static class AdapterDataObserver {
      public void onChanged() {
      }

      public void onItemRangeChanged(int var1, int var2) {
      }

      public void onItemRangeChanged(int var1, int var2, Object var3) {
         this.onItemRangeChanged(var1, var2);
      }

      public void onItemRangeInserted(int var1, int var2) {
      }

      public void onItemRangeMoved(int var1, int var2, int var3) {
      }

      public void onItemRangeRemoved(int var1, int var2) {
      }
   }

   public interface ChildDrawingOrderCallback {
      int onGetChildDrawingOrder(int var1, int var2);
   }

   public abstract static class ItemAnimator {
      public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
      public static final int FLAG_CHANGED = 2;
      public static final int FLAG_INVALIDATED = 4;
      public static final int FLAG_MOVED = 2048;
      public static final int FLAG_REMOVED = 8;
      private long mAddDuration = 120L;
      private long mChangeDuration = 250L;
      private ArrayList<RecyclerView.ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList();
      private RecyclerView.ItemAnimatorListener mListener = null;
      private long mMoveDuration = 250L;
      private long mRemoveDuration = 120L;

      static int buildAdapterChangeFlagsForAnimations(RecyclerView.ViewHolder var0) {
         int var1 = 14 & var0.mFlags;
         if(var0.isInvalid()) {
            return 4;
         } else {
            if((var1 & 4) == 0) {
               int var2 = var0.getOldPosition();
               int var3 = var0.getAdapterPosition();
               if(var2 != -1 && var3 != -1 && var2 != var3) {
                  var1 |= 2048;
               }
            }

            return var1;
         }
      }

      public abstract boolean animateAppearance(@NonNull RecyclerView.ViewHolder var1, @Nullable RecyclerView.ItemHolderInfo var2, @NonNull RecyclerView.ItemHolderInfo var3);

      public abstract boolean animateChange(@NonNull RecyclerView.ViewHolder var1, @NonNull RecyclerView.ViewHolder var2, @NonNull RecyclerView.ItemHolderInfo var3, @NonNull RecyclerView.ItemHolderInfo var4);

      public abstract boolean animateDisappearance(@NonNull RecyclerView.ViewHolder var1, @NonNull RecyclerView.ItemHolderInfo var2, @Nullable RecyclerView.ItemHolderInfo var3);

      public abstract boolean animatePersistence(@NonNull RecyclerView.ViewHolder var1, @NonNull RecyclerView.ItemHolderInfo var2, @NonNull RecyclerView.ItemHolderInfo var3);

      public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder var1) {
         return true;
      }

      public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder var1, @NonNull List<Object> var2) {
         return this.canReuseUpdatedViewHolder(var1);
      }

      public final void dispatchAnimationFinished(RecyclerView.ViewHolder var1) {
         this.onAnimationFinished(var1);
         if(this.mListener != null) {
            this.mListener.onAnimationFinished(var1);
         }

      }

      public final void dispatchAnimationStarted(RecyclerView.ViewHolder var1) {
         this.onAnimationStarted(var1);
      }

      public final void dispatchAnimationsFinished() {
         int var1 = this.mFinishedListeners.size();

         for(int var2 = 0; var2 < var1; ++var2) {
            ((RecyclerView.ItemAnimatorFinishedListener)this.mFinishedListeners.get(var2)).onAnimationsFinished();
         }

         this.mFinishedListeners.clear();
      }

      public abstract void endAnimation(RecyclerView.ViewHolder var1);

      public abstract void endAnimations();

      public long getAddDuration() {
         return this.mAddDuration;
      }

      public long getChangeDuration() {
         return this.mChangeDuration;
      }

      public long getMoveDuration() {
         return this.mMoveDuration;
      }

      public long getRemoveDuration() {
         return this.mRemoveDuration;
      }

      public abstract boolean isRunning();

      public final boolean isRunning(RecyclerView.ItemAnimatorFinishedListener var1) {
         boolean var2 = this.isRunning();
         if(var1 != null) {
            if(var2) {
               this.mFinishedListeners.add(var1);
               return var2;
            }

            var1.onAnimationsFinished();
         }

         return var2;
      }

      public RecyclerView.ItemHolderInfo obtainHolderInfo() {
         return new RecyclerView.ItemHolderInfo();
      }

      public void onAnimationFinished(RecyclerView.ViewHolder var1) {
      }

      public void onAnimationStarted(RecyclerView.ViewHolder var1) {
      }

      @NonNull
      public RecyclerView.ItemHolderInfo recordPostLayoutInformation(@NonNull RecyclerView.State var1, @NonNull RecyclerView.ViewHolder var2) {
         return this.obtainHolderInfo().setFrom(var2);
      }

      @NonNull
      public RecyclerView.ItemHolderInfo recordPreLayoutInformation(@NonNull RecyclerView.State var1, @NonNull RecyclerView.ViewHolder var2, int var3, @NonNull List<Object> var4) {
         return this.obtainHolderInfo().setFrom(var2);
      }

      public abstract void runPendingAnimations();

      public void setAddDuration(long var1) {
         this.mAddDuration = var1;
      }

      public void setChangeDuration(long var1) {
         this.mChangeDuration = var1;
      }

      void setListener(RecyclerView.ItemAnimatorListener var1) {
         this.mListener = var1;
      }

      public void setMoveDuration(long var1) {
         this.mMoveDuration = var1;
      }

      public void setRemoveDuration(long var1) {
         this.mRemoveDuration = var1;
      }
   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface AdapterChanges {
   }

   public interface ItemAnimatorFinishedListener {
      void onAnimationsFinished();
   }

   interface ItemAnimatorListener {
      void onAnimationFinished(RecyclerView.ViewHolder var1);
   }

   public static class ItemHolderInfo {
      public int bottom;
      public int changeFlags;
      public int left;
      public int right;
      public int top;

      public RecyclerView.ItemHolderInfo setFrom(RecyclerView.ViewHolder var1) {
         return this.setFrom(var1, 0);
      }

      public RecyclerView.ItemHolderInfo setFrom(RecyclerView.ViewHolder var1, int var2) {
         View var3 = var1.itemView;
         this.left = var3.getLeft();
         this.top = var3.getTop();
         this.right = var3.getRight();
         this.bottom = var3.getBottom();
         return this;
      }
   }

   private class ItemAnimatorRestoreListener implements RecyclerView.ItemAnimatorListener {
      private ItemAnimatorRestoreListener() {
      }

      // $FF: synthetic method
      ItemAnimatorRestoreListener(Object var2) {
         this();
      }

      public void onAnimationFinished(RecyclerView.ViewHolder var1) {
         var1.setIsRecyclable(true);
         if(var1.mShadowedHolder != null && var1.mShadowingHolder == null) {
            var1.mShadowedHolder = null;
         }

         var1.mShadowingHolder = null;
         if(!var1.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(var1.itemView) && var1.isTmpDetached()) {
            RecyclerView.this.removeDetachedView(var1.itemView, false);
         }

      }
   }

   public abstract static class ItemDecoration {
      @Deprecated
      public void getItemOffsets(Rect var1, int var2, RecyclerView var3) {
         var1.set(0, 0, 0, 0);
      }

      public void getItemOffsets(Rect var1, View var2, RecyclerView var3, RecyclerView.State var4) {
         this.getItemOffsets(var1, ((RecyclerView.LayoutParams)var2.getLayoutParams()).getViewLayoutPosition(), var3);
      }

      @Deprecated
      public void onDraw(Canvas var1, RecyclerView var2) {
      }

      public void onDraw(Canvas var1, RecyclerView var2, RecyclerView.State var3) {
         this.onDraw(var1, var2);
      }

      @Deprecated
      public void onDrawOver(Canvas var1, RecyclerView var2) {
      }

      public void onDrawOver(Canvas var1, RecyclerView var2, RecyclerView.State var3) {
         this.onDrawOver(var1, var2);
      }
   }

   public abstract static class LayoutManager {
      private boolean mAutoMeasure = false;
      ChildHelper mChildHelper;
      private int mHeightSpec;
      boolean mIsAttachedToWindow = false;
      private boolean mMeasurementCacheEnabled = true;
      RecyclerView mRecyclerView;
      private boolean mRequestedSimpleAnimations = false;
      @Nullable
      RecyclerView.SmoothScroller mSmoothScroller;
      private int mWidthSpec;

      private void addViewInt(View var1, int var2, boolean var3) {
         RecyclerView.ViewHolder var4 = RecyclerView.getChildViewHolderInt(var1);
         if(!var3 && !var4.isRemoved()) {
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(var4);
         } else {
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(var4);
         }

         RecyclerView.LayoutParams var5 = (RecyclerView.LayoutParams)var1.getLayoutParams();
         if(!var4.wasReturnedFromScrap() && !var4.isScrap()) {
            if(var1.getParent() == this.mRecyclerView) {
               int var6 = this.mChildHelper.indexOfChild(var1);
               if(var2 == -1) {
                  var2 = this.mChildHelper.getChildCount();
               }

               if(var6 == -1) {
                  throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(var1));
               }

               if(var6 != var2) {
                  this.mRecyclerView.mLayout.moveView(var6, var2);
               }
            } else {
               this.mChildHelper.addView(var1, var2, false);
               var5.mInsetsDirty = true;
               if(this.mSmoothScroller != null && this.mSmoothScroller.isRunning()) {
                  this.mSmoothScroller.onChildAttachedToWindow(var1);
               }
            }
         } else {
            if(var4.isScrap()) {
               var4.unScrap();
            } else {
               var4.clearReturnedFromScrapFlag();
            }

            this.mChildHelper.attachViewToParent(var1, var2, var1.getLayoutParams(), false);
         }

         if(var5.mPendingInvalidate) {
            var4.itemView.invalidate();
            var5.mPendingInvalidate = false;
         }

      }

      public static int chooseSize(int var0, int var1, int var2) {
         int var3 = MeasureSpec.getMode(var0);
         int var4 = MeasureSpec.getSize(var0);
         switch(var3) {
         case Integer.MIN_VALUE:
            var1 = Math.min(var4, var1);
         default:
            var4 = Math.max(var1, var2);
         case 1073741824:
            return var4;
         }
      }

      private void detachViewInternal(int var1, View var2) {
         this.mChildHelper.detachViewFromParent(var1);
      }

      public static int getChildMeasureSpec(int var0, int var1, int var2, int var3, boolean var4) {
         int var5 = Math.max(0, var0 - var2);
         int var6;
         int var7;
         if(var4) {
            if(var3 >= 0) {
               var7 = var3;
               var6 = 1073741824;
            } else if(var3 == -1) {
               switch(var1) {
               case Integer.MIN_VALUE:
               case 1073741824:
                  var7 = var5;
                  var6 = var1;
                  break;
               case 0:
                  var6 = 0;
                  var7 = 0;
                  break;
               default:
                  var6 = 0;
                  var7 = 0;
               }
            } else {
               var6 = 0;
               var7 = 0;
               if(var3 == -2) {
                  var6 = 0;
                  var7 = 0;
               }
            }
         } else if(var3 >= 0) {
            var7 = var3;
            var6 = 1073741824;
         } else if(var3 == -1) {
            var7 = var5;
            var6 = var1;
         } else {
            var6 = 0;
            var7 = 0;
            if(var3 == -2) {
               var7 = var5;
               if(var1 != Integer.MIN_VALUE && var1 != 1073741824) {
                  var6 = 0;
               } else {
                  var6 = Integer.MIN_VALUE;
               }
            }
         }

         return MeasureSpec.makeMeasureSpec(var7, var6);
      }

      @Deprecated
      public static int getChildMeasureSpec(int var0, int var1, int var2, boolean var3) {
         int var4 = Math.max(0, var0 - var1);
         int var5;
         int var6;
         if(var3) {
            if(var2 >= 0) {
               var6 = var2;
               var5 = 1073741824;
            } else {
               var5 = 0;
               var6 = 0;
            }
         } else if(var2 >= 0) {
            var6 = var2;
            var5 = 1073741824;
         } else if(var2 == -1) {
            var6 = var4;
            var5 = 1073741824;
         } else {
            var5 = 0;
            var6 = 0;
            if(var2 == -2) {
               var6 = var4;
               var5 = Integer.MIN_VALUE;
            }
         }

         return MeasureSpec.makeMeasureSpec(var6, var5);
      }

      public static RecyclerView.Properties getProperties(Context var0, AttributeSet var1, int var2, int var3) {
         RecyclerView.Properties var4 = new RecyclerView.Properties();
         TypedArray var5 = var0.obtainStyledAttributes(var1, class_51.styleable.RecyclerView, var2, var3);
         var4.orientation = var5.getInt(class_51.styleable.RecyclerView_android_orientation, 1);
         var4.spanCount = var5.getInt(class_51.styleable.RecyclerView_spanCount, 1);
         var4.reverseLayout = var5.getBoolean(class_51.styleable.RecyclerView_reverseLayout, false);
         var4.stackFromEnd = var5.getBoolean(class_51.styleable.RecyclerView_stackFromEnd, false);
         var5.recycle();
         return var4;
      }

      private static boolean isMeasurementUpToDate(int var0, int var1, int var2) {
         boolean var3 = true;
         int var4 = MeasureSpec.getMode(var1);
         int var5 = MeasureSpec.getSize(var1);
         if(var2 > 0 && var0 != var2) {
            var3 = false;
         } else {
            switch(var4) {
            case Integer.MIN_VALUE:
               if(var5 < var0) {
                  return false;
               }
            case 0:
               break;
            case 1073741824:
               if(var5 != var0) {
                  return false;
               }
               break;
            default:
               return false;
            }
         }

         return var3;
      }

      private void onSmoothScrollerStopped(RecyclerView.SmoothScroller var1) {
         if(this.mSmoothScroller == var1) {
            this.mSmoothScroller = null;
         }

      }

      private void scrapOrRecycleView(RecyclerView.Recycler var1, int var2, View var3) {
         RecyclerView.ViewHolder var4 = RecyclerView.getChildViewHolderInt(var3);
         if(!var4.shouldIgnore()) {
            if(var4.isInvalid() && !var4.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
               this.removeViewAt(var2);
               var1.recycleViewHolderInternal(var4);
            } else {
               this.detachViewAt(var2);
               var1.scrapView(var3);
               this.mRecyclerView.mViewInfoStore.onViewDetached(var4);
            }
         }
      }

      public void addDisappearingView(View var1) {
         this.addDisappearingView(var1, -1);
      }

      public void addDisappearingView(View var1, int var2) {
         this.addViewInt(var1, var2, true);
      }

      public void addView(View var1) {
         this.addView(var1, -1);
      }

      public void addView(View var1, int var2) {
         this.addViewInt(var1, var2, false);
      }

      public void assertInLayoutOrScroll(String var1) {
         if(this.mRecyclerView != null) {
            this.mRecyclerView.assertInLayoutOrScroll(var1);
         }

      }

      public void assertNotInLayoutOrScroll(String var1) {
         if(this.mRecyclerView != null) {
            this.mRecyclerView.assertNotInLayoutOrScroll(var1);
         }

      }

      public void attachView(View var1) {
         this.attachView(var1, -1);
      }

      public void attachView(View var1, int var2) {
         this.attachView(var1, var2, (RecyclerView.LayoutParams)var1.getLayoutParams());
      }

      public void attachView(View var1, int var2, RecyclerView.LayoutParams var3) {
         RecyclerView.ViewHolder var4 = RecyclerView.getChildViewHolderInt(var1);
         if(var4.isRemoved()) {
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(var4);
         } else {
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(var4);
         }

         this.mChildHelper.attachViewToParent(var1, var2, var3, var4.isRemoved());
      }

      public void calculateItemDecorationsForChild(View var1, Rect var2) {
         if(this.mRecyclerView == null) {
            var2.set(0, 0, 0, 0);
         } else {
            var2.set(this.mRecyclerView.getItemDecorInsetsForChild(var1));
         }
      }

      public boolean canScrollHorizontally() {
         return false;
      }

      public boolean canScrollVertically() {
         return false;
      }

      public boolean checkLayoutParams(RecyclerView.LayoutParams var1) {
         return var1 != null;
      }

      public int computeHorizontalScrollExtent(RecyclerView.State var1) {
         return 0;
      }

      public int computeHorizontalScrollOffset(RecyclerView.State var1) {
         return 0;
      }

      public int computeHorizontalScrollRange(RecyclerView.State var1) {
         return 0;
      }

      public int computeVerticalScrollExtent(RecyclerView.State var1) {
         return 0;
      }

      public int computeVerticalScrollOffset(RecyclerView.State var1) {
         return 0;
      }

      public int computeVerticalScrollRange(RecyclerView.State var1) {
         return 0;
      }

      public void detachAndScrapAttachedViews(RecyclerView.Recycler var1) {
         for(int var2 = -1 + this.getChildCount(); var2 >= 0; --var2) {
            this.scrapOrRecycleView(var1, var2, this.getChildAt(var2));
         }

      }

      public void detachAndScrapView(View var1, RecyclerView.Recycler var2) {
         this.scrapOrRecycleView(var2, this.mChildHelper.indexOfChild(var1), var1);
      }

      public void detachAndScrapViewAt(int var1, RecyclerView.Recycler var2) {
         this.scrapOrRecycleView(var2, var1, this.getChildAt(var1));
      }

      public void detachView(View var1) {
         int var2 = this.mChildHelper.indexOfChild(var1);
         if(var2 >= 0) {
            this.detachViewInternal(var2, var1);
         }

      }

      public void detachViewAt(int var1) {
         this.detachViewInternal(var1, this.getChildAt(var1));
      }

      void dispatchAttachedToWindow(RecyclerView var1) {
         this.mIsAttachedToWindow = true;
         this.onAttachedToWindow(var1);
      }

      void dispatchDetachedFromWindow(RecyclerView var1, RecyclerView.Recycler var2) {
         this.mIsAttachedToWindow = false;
         this.onDetachedFromWindow(var1, var2);
      }

      public void endAnimation(View var1) {
         if(this.mRecyclerView.mItemAnimator != null) {
            this.mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(var1));
         }

      }

      @Nullable
      public View findContainingItemView(View var1) {
         View var2;
         if(this.mRecyclerView == null) {
            var2 = null;
         } else {
            var2 = this.mRecyclerView.findContainingItemView(var1);
            if(var2 == null) {
               return null;
            }

            if(this.mChildHelper.isHidden(var2)) {
               return null;
            }
         }

         return var2;
      }

      public View findViewByPosition(int var1) {
         int var2 = this.getChildCount();

         for(int var3 = 0; var3 < var2; ++var3) {
            View var4 = this.getChildAt(var3);
            RecyclerView.ViewHolder var5 = RecyclerView.getChildViewHolderInt(var4);
            if(var5 != null && var5.getLayoutPosition() == var1 && !var5.shouldIgnore() && (this.mRecyclerView.mState.isPreLayout() || !var5.isRemoved())) {
               return var4;
            }
         }

         return null;
      }

      public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();

      public RecyclerView.LayoutParams generateLayoutParams(Context var1, AttributeSet var2) {
         return new RecyclerView.LayoutParams(var1, var2);
      }

      public RecyclerView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
         return var1 instanceof RecyclerView.LayoutParams?new RecyclerView.LayoutParams((RecyclerView.LayoutParams)var1):(var1 instanceof MarginLayoutParams?new RecyclerView.LayoutParams((MarginLayoutParams)var1):new RecyclerView.LayoutParams(var1));
      }

      public int getBaseline() {
         return -1;
      }

      public int getBottomDecorationHeight(View var1) {
         return ((RecyclerView.LayoutParams)var1.getLayoutParams()).mDecorInsets.bottom;
      }

      public View getChildAt(int var1) {
         return this.mChildHelper != null?this.mChildHelper.getChildAt(var1):null;
      }

      public int getChildCount() {
         return this.mChildHelper != null?this.mChildHelper.getChildCount():0;
      }

      public boolean getClipToPadding() {
         return this.mRecyclerView != null && this.mRecyclerView.mClipToPadding;
      }

      public int getColumnCountForAccessibility(RecyclerView.Recycler var1, RecyclerView.State var2) {
         return this.mRecyclerView != null && this.mRecyclerView.mAdapter != null && this.canScrollHorizontally()?this.mRecyclerView.mAdapter.getItemCount():1;
      }

      public int getDecoratedBottom(View var1) {
         return var1.getBottom() + this.getBottomDecorationHeight(var1);
      }

      public int getDecoratedLeft(View var1) {
         return var1.getLeft() - this.getLeftDecorationWidth(var1);
      }

      public int getDecoratedMeasuredHeight(View var1) {
         Rect var2 = ((RecyclerView.LayoutParams)var1.getLayoutParams()).mDecorInsets;
         return var1.getMeasuredHeight() + var2.top + var2.bottom;
      }

      public int getDecoratedMeasuredWidth(View var1) {
         Rect var2 = ((RecyclerView.LayoutParams)var1.getLayoutParams()).mDecorInsets;
         return var1.getMeasuredWidth() + var2.left + var2.right;
      }

      public int getDecoratedRight(View var1) {
         return var1.getRight() + this.getRightDecorationWidth(var1);
      }

      public int getDecoratedTop(View var1) {
         return var1.getTop() - this.getTopDecorationHeight(var1);
      }

      public View getFocusedChild() {
         View var1;
         if(this.mRecyclerView == null) {
            var1 = null;
         } else {
            var1 = this.mRecyclerView.getFocusedChild();
            if(var1 == null || this.mChildHelper.isHidden(var1)) {
               return null;
            }
         }

         return var1;
      }

      public int getHeight() {
         return MeasureSpec.getSize(this.mHeightSpec);
      }

      public int getHeightMode() {
         return MeasureSpec.getMode(this.mHeightSpec);
      }

      public int getItemCount() {
         RecyclerView.Adapter var1;
         if(this.mRecyclerView != null) {
            var1 = this.mRecyclerView.getAdapter();
         } else {
            var1 = null;
         }

         return var1 != null?var1.getItemCount():0;
      }

      public int getItemViewType(View var1) {
         return RecyclerView.getChildViewHolderInt(var1).getItemViewType();
      }

      public int getLayoutDirection() {
         return ViewCompat.getLayoutDirection(this.mRecyclerView);
      }

      public int getLeftDecorationWidth(View var1) {
         return ((RecyclerView.LayoutParams)var1.getLayoutParams()).mDecorInsets.left;
      }

      public int getMinimumHeight() {
         return ViewCompat.getMinimumHeight(this.mRecyclerView);
      }

      public int getMinimumWidth() {
         return ViewCompat.getMinimumWidth(this.mRecyclerView);
      }

      public int getPaddingBottom() {
         return this.mRecyclerView != null?this.mRecyclerView.getPaddingBottom():0;
      }

      public int getPaddingEnd() {
         return this.mRecyclerView != null?ViewCompat.getPaddingEnd(this.mRecyclerView):0;
      }

      public int getPaddingLeft() {
         return this.mRecyclerView != null?this.mRecyclerView.getPaddingLeft():0;
      }

      public int getPaddingRight() {
         return this.mRecyclerView != null?this.mRecyclerView.getPaddingRight():0;
      }

      public int getPaddingStart() {
         return this.mRecyclerView != null?ViewCompat.getPaddingStart(this.mRecyclerView):0;
      }

      public int getPaddingTop() {
         return this.mRecyclerView != null?this.mRecyclerView.getPaddingTop():0;
      }

      public int getPosition(View var1) {
         return ((RecyclerView.LayoutParams)var1.getLayoutParams()).getViewLayoutPosition();
      }

      public int getRightDecorationWidth(View var1) {
         return ((RecyclerView.LayoutParams)var1.getLayoutParams()).mDecorInsets.right;
      }

      public int getRowCountForAccessibility(RecyclerView.Recycler var1, RecyclerView.State var2) {
         return this.mRecyclerView != null && this.mRecyclerView.mAdapter != null && this.canScrollVertically()?this.mRecyclerView.mAdapter.getItemCount():1;
      }

      public int getSelectionModeForAccessibility(RecyclerView.Recycler var1, RecyclerView.State var2) {
         return 0;
      }

      public int getTopDecorationHeight(View var1) {
         return ((RecyclerView.LayoutParams)var1.getLayoutParams()).mDecorInsets.top;
      }

      public int getWidth() {
         return MeasureSpec.getSize(this.mWidthSpec);
      }

      public int getWidthMode() {
         return MeasureSpec.getMode(this.mWidthSpec);
      }

      boolean hasFlexibleChildInBothOrientations() {
         int var1 = this.getChildCount();

         for(int var2 = 0; var2 < var1; ++var2) {
            android.view.ViewGroup.LayoutParams var3 = this.getChildAt(var2).getLayoutParams();
            if(var3.width < 0 && var3.height < 0) {
               return true;
            }
         }

         return false;
      }

      public boolean hasFocus() {
         return this.mRecyclerView != null && this.mRecyclerView.hasFocus();
      }

      public void ignoreView(View var1) {
         if(var1.getParent() == this.mRecyclerView && this.mRecyclerView.indexOfChild(var1) != -1) {
            RecyclerView.ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
            var2.addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder(var2);
         } else {
            throw new IllegalArgumentException("View should be fully attached to be ignored");
         }
      }

      public boolean isAttachedToWindow() {
         return this.mIsAttachedToWindow;
      }

      public boolean isAutoMeasureEnabled() {
         return this.mAutoMeasure;
      }

      public boolean isFocused() {
         return this.mRecyclerView != null && this.mRecyclerView.isFocused();
      }

      public boolean isLayoutHierarchical(RecyclerView.Recycler var1, RecyclerView.State var2) {
         return false;
      }

      public boolean isMeasurementCacheEnabled() {
         return this.mMeasurementCacheEnabled;
      }

      public boolean isSmoothScrolling() {
         return this.mSmoothScroller != null && this.mSmoothScroller.isRunning();
      }

      public void layoutDecorated(View var1, int var2, int var3, int var4, int var5) {
         Rect var6 = ((RecyclerView.LayoutParams)var1.getLayoutParams()).mDecorInsets;
         var1.layout(var2 + var6.left, var3 + var6.top, var4 - var6.right, var5 - var6.bottom);
      }

      public void measureChild(View var1, int var2, int var3) {
         RecyclerView.LayoutParams var4 = (RecyclerView.LayoutParams)var1.getLayoutParams();
         Rect var5 = this.mRecyclerView.getItemDecorInsetsForChild(var1);
         int var6 = var2 + var5.left + var5.right;
         int var7 = var3 + var5.top + var5.bottom;
         int var8 = getChildMeasureSpec(this.getWidth(), this.getWidthMode(), var6 + this.getPaddingLeft() + this.getPaddingRight(), var4.width, this.canScrollHorizontally());
         int var9 = getChildMeasureSpec(this.getHeight(), this.getHeightMode(), var7 + this.getPaddingTop() + this.getPaddingBottom(), var4.height, this.canScrollVertically());
         if(this.shouldMeasureChild(var1, var8, var9, var4)) {
            var1.measure(var8, var9);
         }

      }

      public void measureChildWithMargins(View var1, int var2, int var3) {
         RecyclerView.LayoutParams var4 = (RecyclerView.LayoutParams)var1.getLayoutParams();
         Rect var5 = this.mRecyclerView.getItemDecorInsetsForChild(var1);
         int var6 = var2 + var5.left + var5.right;
         int var7 = var3 + var5.top + var5.bottom;
         int var8 = getChildMeasureSpec(this.getWidth(), this.getWidthMode(), var6 + this.getPaddingLeft() + this.getPaddingRight() + var4.leftMargin + var4.rightMargin, var4.width, this.canScrollHorizontally());
         int var9 = getChildMeasureSpec(this.getHeight(), this.getHeightMode(), var7 + this.getPaddingTop() + this.getPaddingBottom() + var4.topMargin + var4.bottomMargin, var4.height, this.canScrollVertically());
         if(this.shouldMeasureChild(var1, var8, var9, var4)) {
            var1.measure(var8, var9);
         }

      }

      public void moveView(int var1, int var2) {
         View var3 = this.getChildAt(var1);
         if(var3 == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + var1);
         } else {
            this.detachViewAt(var1);
            this.attachView(var3, var2);
         }
      }

      public void offsetChildrenHorizontal(int var1) {
         if(this.mRecyclerView != null) {
            this.mRecyclerView.offsetChildrenHorizontal(var1);
         }

      }

      public void offsetChildrenVertical(int var1) {
         if(this.mRecyclerView != null) {
            this.mRecyclerView.offsetChildrenVertical(var1);
         }

      }

      public void onAdapterChanged(RecyclerView.Adapter var1, RecyclerView.Adapter var2) {
      }

      public boolean onAddFocusables(RecyclerView var1, ArrayList<View> var2, int var3, int var4) {
         return false;
      }

      @CallSuper
      public void onAttachedToWindow(RecyclerView var1) {
      }

      @Deprecated
      public void onDetachedFromWindow(RecyclerView var1) {
      }

      @CallSuper
      public void onDetachedFromWindow(RecyclerView var1, RecyclerView.Recycler var2) {
         this.onDetachedFromWindow(var1);
      }

      @Nullable
      public View onFocusSearchFailed(View var1, int var2, RecyclerView.Recycler var3, RecyclerView.State var4) {
         return null;
      }

      public void onInitializeAccessibilityEvent(RecyclerView.Recycler var1, RecyclerView.State var2, AccessibilityEvent var3) {
         byte var4 = 1;
         AccessibilityRecordCompat var5 = AccessibilityEventCompat.asRecord(var3);
         if(this.mRecyclerView != null && var5 != null) {
            if(!ViewCompat.canScrollVertically(this.mRecyclerView, var4) && !ViewCompat.canScrollVertically(this.mRecyclerView, -1) && !ViewCompat.canScrollHorizontally(this.mRecyclerView, -1) && !ViewCompat.canScrollHorizontally(this.mRecyclerView, var4)) {
               var4 = 0;
            }

            var5.setScrollable((boolean)var4);
            if(this.mRecyclerView.mAdapter != null) {
               var5.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
               return;
            }
         }

      }

      public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
         this.onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, var1);
      }

      void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat var1) {
         this.onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, var1);
      }

      public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler var1, RecyclerView.State var2, AccessibilityNodeInfoCompat var3) {
         if(ViewCompat.canScrollVertically(this.mRecyclerView, -1) || ViewCompat.canScrollHorizontally(this.mRecyclerView, -1)) {
            var3.addAction(8192);
            var3.setScrollable(true);
         }

         if(ViewCompat.canScrollVertically(this.mRecyclerView, 1) || ViewCompat.canScrollHorizontally(this.mRecyclerView, 1)) {
            var3.addAction(4096);
            var3.setScrollable(true);
         }

         var3.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(this.getRowCountForAccessibility(var1, var2), this.getColumnCountForAccessibility(var1, var2), this.isLayoutHierarchical(var1, var2), this.getSelectionModeForAccessibility(var1, var2)));
      }

      public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler var1, RecyclerView.State var2, View var3, AccessibilityNodeInfoCompat var4) {
         int var5;
         if(this.canScrollVertically()) {
            var5 = this.getPosition(var3);
         } else {
            var5 = 0;
         }

         int var6;
         if(this.canScrollHorizontally()) {
            var6 = this.getPosition(var3);
         } else {
            var6 = 0;
         }

         var4.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(var5, 1, var6, 1, false, false));
      }

      void onInitializeAccessibilityNodeInfoForItem(View var1, AccessibilityNodeInfoCompat var2) {
         RecyclerView.ViewHolder var3 = RecyclerView.getChildViewHolderInt(var1);
         if(var3 != null && !var3.isRemoved() && !this.mChildHelper.isHidden(var3.itemView)) {
            this.onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, var1, var2);
         }

      }

      public View onInterceptFocusSearch(View var1, int var2) {
         return null;
      }

      public void onItemsAdded(RecyclerView var1, int var2, int var3) {
      }

      public void onItemsChanged(RecyclerView var1) {
      }

      public void onItemsMoved(RecyclerView var1, int var2, int var3, int var4) {
      }

      public void onItemsRemoved(RecyclerView var1, int var2, int var3) {
      }

      public void onItemsUpdated(RecyclerView var1, int var2, int var3) {
      }

      public void onItemsUpdated(RecyclerView var1, int var2, int var3, Object var4) {
         this.onItemsUpdated(var1, var2, var3);
      }

      public void onLayoutChildren(RecyclerView.Recycler var1, RecyclerView.State var2) {
         Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
      }

      public void onMeasure(RecyclerView.Recycler var1, RecyclerView.State var2, int var3, int var4) {
         this.mRecyclerView.defaultOnMeasure(var3, var4);
      }

      public boolean onRequestChildFocus(RecyclerView var1, RecyclerView.State var2, View var3, View var4) {
         return this.onRequestChildFocus(var1, var3, var4);
      }

      @Deprecated
      public boolean onRequestChildFocus(RecyclerView var1, View var2, View var3) {
         return this.isSmoothScrolling() || var1.isComputingLayout();
      }

      public void onRestoreInstanceState(Parcelable var1) {
      }

      public Parcelable onSaveInstanceState() {
         return null;
      }

      public void onScrollStateChanged(int var1) {
      }

      boolean performAccessibilityAction(int var1, Bundle var2) {
         return this.performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, var1, var2);
      }

      public boolean performAccessibilityAction(RecyclerView.Recycler var1, RecyclerView.State var2, int var3, Bundle var4) {
         if(this.mRecyclerView != null) {
            int var5 = 0;
            int var6 = 0;
            switch(var3) {
            case 4096:
               boolean var7 = ViewCompat.canScrollVertically(this.mRecyclerView, 1);
               var6 = 0;
               if(var7) {
                  var6 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
               }

               boolean var8 = ViewCompat.canScrollHorizontally(this.mRecyclerView, 1);
               var5 = 0;
               if(var8) {
                  var5 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
               }
               break;
            case 8192:
               boolean var9 = ViewCompat.canScrollVertically(this.mRecyclerView, -1);
               var6 = 0;
               if(var9) {
                  var6 = -(this.getHeight() - this.getPaddingTop() - this.getPaddingBottom());
               }

               boolean var10 = ViewCompat.canScrollHorizontally(this.mRecyclerView, -1);
               var5 = 0;
               if(var10) {
                  var5 = -(this.getWidth() - this.getPaddingLeft() - this.getPaddingRight());
               }
            }

            if(var6 != 0 || var5 != 0) {
               this.mRecyclerView.scrollBy(var5, var6);
               return true;
            }
         }

         return false;
      }

      public boolean performAccessibilityActionForItem(RecyclerView.Recycler var1, RecyclerView.State var2, View var3, int var4, Bundle var5) {
         return false;
      }

      boolean performAccessibilityActionForItem(View var1, int var2, Bundle var3) {
         return this.performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, var1, var2, var3);
      }

      public void postOnAnimation(Runnable var1) {
         if(this.mRecyclerView != null) {
            ViewCompat.postOnAnimation(this.mRecyclerView, var1);
         }

      }

      public void removeAllViews() {
         for(int var1 = -1 + this.getChildCount(); var1 >= 0; --var1) {
            this.mChildHelper.removeViewAt(var1);
         }

      }

      public void removeAndRecycleAllViews(RecyclerView.Recycler var1) {
         for(int var2 = -1 + this.getChildCount(); var2 >= 0; --var2) {
            if(!RecyclerView.getChildViewHolderInt(this.getChildAt(var2)).shouldIgnore()) {
               this.removeAndRecycleViewAt(var2, var1);
            }
         }

      }

      void removeAndRecycleScrapInt(RecyclerView.Recycler var1) {
         int var2 = var1.getScrapCount();

         for(int var3 = var2 - 1; var3 >= 0; --var3) {
            View var4 = var1.getScrapViewAt(var3);
            RecyclerView.ViewHolder var5 = RecyclerView.getChildViewHolderInt(var4);
            if(!var5.shouldIgnore()) {
               var5.setIsRecyclable(false);
               if(var5.isTmpDetached()) {
                  this.mRecyclerView.removeDetachedView(var4, false);
               }

               if(this.mRecyclerView.mItemAnimator != null) {
                  this.mRecyclerView.mItemAnimator.endAnimation(var5);
               }

               var5.setIsRecyclable(true);
               var1.quickRecycleScrapView(var4);
            }
         }

         var1.clearScrap();
         if(var2 > 0) {
            this.mRecyclerView.invalidate();
         }

      }

      public void removeAndRecycleView(View var1, RecyclerView.Recycler var2) {
         this.removeView(var1);
         var2.recycleView(var1);
      }

      public void removeAndRecycleViewAt(int var1, RecyclerView.Recycler var2) {
         View var3 = this.getChildAt(var1);
         this.removeViewAt(var1);
         var2.recycleView(var3);
      }

      public boolean removeCallbacks(Runnable var1) {
         return this.mRecyclerView != null?this.mRecyclerView.removeCallbacks(var1):false;
      }

      public void removeDetachedView(View var1) {
         this.mRecyclerView.removeDetachedView(var1, false);
      }

      public void removeView(View var1) {
         this.mChildHelper.removeView(var1);
      }

      public void removeViewAt(int var1) {
         if(this.getChildAt(var1) != null) {
            this.mChildHelper.removeViewAt(var1);
         }

      }

      public boolean requestChildRectangleOnScreen(RecyclerView var1, View var2, Rect var3, boolean var4) {
         int var5 = this.getPaddingLeft();
         int var6 = this.getPaddingTop();
         int var7 = this.getWidth() - this.getPaddingRight();
         int var8 = this.getHeight() - this.getPaddingBottom();
         int var9 = var2.getLeft() + var3.left - var2.getScrollX();
         int var10 = var2.getTop() + var3.top - var2.getScrollY();
         int var11 = var9 + var3.width();
         int var12 = var10 + var3.height();
         int var13 = Math.min(0, var9 - var5);
         int var14 = Math.min(0, var10 - var6);
         int var15 = Math.max(0, var11 - var7);
         int var16 = Math.max(0, var12 - var8);
         int var17;
         if(this.getLayoutDirection() == 1) {
            if(var15 != 0) {
               var17 = var15;
            } else {
               var17 = Math.max(var13, var11 - var7);
            }
         } else if(var13 != 0) {
            var17 = var13;
         } else {
            var17 = Math.min(var9 - var5, var15);
         }

         int var18;
         if(var14 != 0) {
            var18 = var14;
         } else {
            var18 = Math.min(var10 - var6, var16);
         }

         if(var17 == 0 && var18 == 0) {
            return false;
         } else {
            if(var4) {
               var1.scrollBy(var17, var18);
            } else {
               var1.smoothScrollBy(var17, var18);
            }

            return true;
         }
      }

      public void requestLayout() {
         if(this.mRecyclerView != null) {
            this.mRecyclerView.requestLayout();
         }

      }

      public void requestSimpleAnimationsInNextLayout() {
         this.mRequestedSimpleAnimations = true;
      }

      public int scrollHorizontallyBy(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
         return 0;
      }

      public void scrollToPosition(int var1) {
      }

      public int scrollVerticallyBy(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
         return 0;
      }

      public void setAutoMeasureEnabled(boolean var1) {
         this.mAutoMeasure = var1;
      }

      void setExactMeasureSpecsFrom(RecyclerView var1) {
         this.setMeasureSpecs(MeasureSpec.makeMeasureSpec(var1.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(var1.getHeight(), 1073741824));
      }

      void setMeasureSpecs(int var1, int var2) {
         this.mWidthSpec = var1;
         this.mHeightSpec = var2;
      }

      public void setMeasuredDimension(int var1, int var2) {
         this.mRecyclerView.setMeasuredDimension(var1, var2);
      }

      public void setMeasuredDimension(Rect var1, int var2, int var3) {
         int var4 = var1.width() + this.getPaddingLeft() + this.getPaddingRight();
         int var5 = var1.height() + this.getPaddingTop() + this.getPaddingBottom();
         this.setMeasuredDimension(chooseSize(var2, var4, this.getMinimumWidth()), chooseSize(var3, var5, this.getMinimumHeight()));
      }

      void setMeasuredDimensionFromChildren(int var1, int var2) {
         int var3 = this.getChildCount();
         if(var3 == 0) {
            this.mRecyclerView.defaultOnMeasure(var1, var2);
         } else {
            int var4 = Integer.MAX_VALUE;
            int var5 = Integer.MAX_VALUE;
            int var6 = Integer.MIN_VALUE;
            int var7 = Integer.MIN_VALUE;

            for(int var8 = 0; var8 < var3; ++var8) {
               View var9 = this.getChildAt(var8);
               RecyclerView.LayoutParams var10 = (RecyclerView.LayoutParams)var9.getLayoutParams();
               int var11 = this.getDecoratedLeft(var9) - var10.leftMargin;
               int var12 = this.getDecoratedRight(var9) + var10.rightMargin;
               int var13 = this.getDecoratedTop(var9) - var10.topMargin;
               int var14 = this.getDecoratedBottom(var9) + var10.bottomMargin;
               if(var11 < var4) {
                  var4 = var11;
               }

               if(var12 > var6) {
                  var6 = var12;
               }

               if(var13 < var5) {
                  var5 = var13;
               }

               if(var14 > var7) {
                  var7 = var14;
               }
            }

            this.mRecyclerView.mTempRect.set(var4, var5, var6, var7);
            this.setMeasuredDimension(this.mRecyclerView.mTempRect, var1, var2);
         }
      }

      public void setMeasurementCacheEnabled(boolean var1) {
         this.mMeasurementCacheEnabled = var1;
      }

      void setRecyclerView(RecyclerView var1) {
         if(var1 == null) {
            this.mRecyclerView = null;
            this.mChildHelper = null;
            this.mWidthSpec = MeasureSpec.makeMeasureSpec(0, 1073741824);
            this.mHeightSpec = MeasureSpec.makeMeasureSpec(0, 1073741824);
         } else {
            this.mRecyclerView = var1;
            this.mChildHelper = var1.mChildHelper;
            this.mWidthSpec = MeasureSpec.makeMeasureSpec(var1.getWidth(), 1073741824);
            this.mHeightSpec = MeasureSpec.makeMeasureSpec(var1.getHeight(), 1073741824);
         }
      }

      boolean shouldMeasureChild(View var1, int var2, int var3, RecyclerView.LayoutParams var4) {
         return var1.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(var1.getWidth(), var2, var4.width) || !isMeasurementUpToDate(var1.getHeight(), var3, var4.height);
      }

      boolean shouldMeasureTwice() {
         return false;
      }

      boolean shouldReMeasureChild(View var1, int var2, int var3, RecyclerView.LayoutParams var4) {
         return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(var1.getMeasuredWidth(), var2, var4.width) || !isMeasurementUpToDate(var1.getMeasuredHeight(), var3, var4.height);
      }

      public void smoothScrollToPosition(RecyclerView var1, RecyclerView.State var2, int var3) {
         Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
      }

      public void startSmoothScroll(RecyclerView.SmoothScroller var1) {
         if(this.mSmoothScroller != null && var1 != this.mSmoothScroller && this.mSmoothScroller.isRunning()) {
            this.mSmoothScroller.stop();
         }

         this.mSmoothScroller = var1;
         this.mSmoothScroller.start(this.mRecyclerView, this);
      }

      public void stopIgnoringView(View var1) {
         RecyclerView.ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
         var2.stopIgnoring();
         var2.resetInternal();
         var2.addFlags(4);
      }

      void stopSmoothScroller() {
         if(this.mSmoothScroller != null) {
            this.mSmoothScroller.stop();
         }

      }

      public boolean supportsPredictiveItemAnimations() {
         return false;
      }
   }

   public static class Properties {
      public int orientation;
      public boolean reverseLayout;
      public int spanCount;
      public boolean stackFromEnd;
   }

   public static class LayoutParams extends MarginLayoutParams {
      final Rect mDecorInsets = new Rect();
      boolean mInsetsDirty = true;
      boolean mPendingInvalidate = false;
      RecyclerView.ViewHolder mViewHolder;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      public LayoutParams(RecyclerView.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }

      public int getViewAdapterPosition() {
         return this.mViewHolder.getAdapterPosition();
      }

      public int getViewLayoutPosition() {
         return this.mViewHolder.getLayoutPosition();
      }

      public int getViewPosition() {
         return this.mViewHolder.getPosition();
      }

      public boolean isItemChanged() {
         return this.mViewHolder.isUpdated();
      }

      public boolean isItemRemoved() {
         return this.mViewHolder.isRemoved();
      }

      public boolean isViewInvalid() {
         return this.mViewHolder.isInvalid();
      }

      public boolean viewNeedsUpdate() {
         return this.mViewHolder.needsUpdate();
      }
   }

   public interface OnChildAttachStateChangeListener {
      void onChildViewAttachedToWindow(View var1);

      void onChildViewDetachedFromWindow(View var1);
   }

   public interface OnItemTouchListener {
      boolean onInterceptTouchEvent(RecyclerView var1, MotionEvent var2);

      void onRequestDisallowInterceptTouchEvent(boolean var1);

      void onTouchEvent(RecyclerView var1, MotionEvent var2);
   }

   public abstract static class OnScrollListener {
      public void onScrollStateChanged(RecyclerView var1, int var2) {
      }

      public void onScrolled(RecyclerView var1, int var2, int var3) {
      }
   }

   public static class RecycledViewPool {
      private static final int DEFAULT_MAX_SCRAP = 5;
      private int mAttachCount = 0;
      private SparseIntArray mMaxScrap = new SparseIntArray();
      private SparseArray<ArrayList<RecyclerView.ViewHolder>> mScrap = new SparseArray();

      private ArrayList<RecyclerView.ViewHolder> getScrapHeapForType(int var1) {
         ArrayList var2 = (ArrayList)this.mScrap.get(var1);
         if(var2 == null) {
            var2 = new ArrayList();
            this.mScrap.put(var1, var2);
            if(this.mMaxScrap.indexOfKey(var1) < 0) {
               this.mMaxScrap.put(var1, 5);
            }
         }

         return var2;
      }

      void attach(RecyclerView.Adapter var1) {
         ++this.mAttachCount;
      }

      public void clear() {
         this.mScrap.clear();
      }

      void detach() {
         this.mAttachCount += -1;
      }

      public RecyclerView.ViewHolder getRecycledView(int var1) {
         ArrayList var2 = (ArrayList)this.mScrap.get(var1);
         if(var2 != null && !var2.isEmpty()) {
            int var3 = -1 + var2.size();
            RecyclerView.ViewHolder var4 = (RecyclerView.ViewHolder)var2.get(var3);
            var2.remove(var3);
            return var4;
         } else {
            return null;
         }
      }

      void onAdapterChanged(RecyclerView.Adapter var1, RecyclerView.Adapter var2, boolean var3) {
         if(var1 != null) {
            this.detach();
         }

         if(!var3 && this.mAttachCount == 0) {
            this.clear();
         }

         if(var2 != null) {
            this.attach(var2);
         }

      }

      public void putRecycledView(RecyclerView.ViewHolder var1) {
         int var2 = var1.getItemViewType();
         ArrayList var3 = this.getScrapHeapForType(var2);
         if(this.mMaxScrap.get(var2) > var3.size()) {
            var1.resetInternal();
            var3.add(var1);
         }
      }

      public void setMaxRecycledViews(int var1, int var2) {
         this.mMaxScrap.put(var1, var2);
         ArrayList var3 = (ArrayList)this.mScrap.get(var1);
         if(var3 != null) {
            while(var3.size() > var2) {
               var3.remove(-1 + var3.size());
            }
         }

      }

      int size() {
         int var1 = 0;

         for(int var2 = 0; var2 < this.mScrap.size(); ++var2) {
            ArrayList var3 = (ArrayList)this.mScrap.valueAt(var2);
            if(var3 != null) {
               var1 += var3.size();
            }
         }

         return var1;
      }
   }

   public final class Recycler {
      private static final int DEFAULT_CACHE_SIZE = 2;
      final ArrayList<RecyclerView.ViewHolder> mAttachedScrap = new ArrayList();
      final ArrayList<RecyclerView.ViewHolder> mCachedViews = new ArrayList();
      private ArrayList<RecyclerView.ViewHolder> mChangedScrap = null;
      private RecyclerView.RecycledViewPool mRecyclerPool;
      private final List<RecyclerView.ViewHolder> mUnmodifiableAttachedScrap;
      private RecyclerView.ViewCacheExtension mViewCacheExtension;
      private int mViewCacheMax;

      public Recycler() {
         this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
         this.mViewCacheMax = 2;
      }

      private void attachAccessibilityDelegate(View var1) {
         if(RecyclerView.this.isAccessibilityEnabled()) {
            if(ViewCompat.getImportantForAccessibility(var1) == 0) {
               ViewCompat.setImportantForAccessibility(var1, 1);
            }

            if(!ViewCompat.hasAccessibilityDelegate(var1)) {
               ViewCompat.setAccessibilityDelegate(var1, RecyclerView.this.mAccessibilityDelegate.getItemDelegate());
            }
         }

      }

      private void invalidateDisplayListInt(RecyclerView.ViewHolder var1) {
         if(var1.itemView instanceof ViewGroup) {
            this.invalidateDisplayListInt((ViewGroup)var1.itemView, false);
         }

      }

      private void invalidateDisplayListInt(ViewGroup var1, boolean var2) {
         for(int var3 = -1 + var1.getChildCount(); var3 >= 0; --var3) {
            View var5 = var1.getChildAt(var3);
            if(var5 instanceof ViewGroup) {
               this.invalidateDisplayListInt((ViewGroup)var5, true);
            }
         }

         if(var2) {
            if(var1.getVisibility() == 4) {
               var1.setVisibility(0);
               var1.setVisibility(4);
            } else {
               int var4 = var1.getVisibility();
               var1.setVisibility(4);
               var1.setVisibility(var4);
            }
         }
      }

      void addViewHolderToRecycledViewPool(RecyclerView.ViewHolder var1) {
         ViewCompat.setAccessibilityDelegate(var1.itemView, (AccessibilityDelegateCompat)null);
         this.dispatchViewRecycled(var1);
         var1.mOwnerRecyclerView = null;
         this.getRecycledViewPool().putRecycledView(var1);
      }

      public void bindViewToPosition(View var1, int var2) {
         boolean var3 = true;
         RecyclerView.ViewHolder var4 = RecyclerView.getChildViewHolderInt(var1);
         if(var4 == null) {
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
         } else {
            int var5 = RecyclerView.this.mAdapterHelper.findPositionOffset(var2);
            if(var5 >= 0 && var5 < RecyclerView.this.mAdapter.getItemCount()) {
               var4.mOwnerRecyclerView = RecyclerView.this;
               RecyclerView.this.mAdapter.bindViewHolder(var4, var5);
               this.attachAccessibilityDelegate(var1);
               if(RecyclerView.this.mState.isPreLayout()) {
                  var4.mPreLayoutPosition = var2;
               }

               android.view.ViewGroup.LayoutParams var6 = var4.itemView.getLayoutParams();
               RecyclerView.LayoutParams var7;
               if(var6 == null) {
                  var7 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
                  var4.itemView.setLayoutParams(var7);
               } else if(!RecyclerView.this.checkLayoutParams(var6)) {
                  var7 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams(var6);
                  var4.itemView.setLayoutParams(var7);
               } else {
                  var7 = (RecyclerView.LayoutParams)var6;
               }

               var7.mInsetsDirty = var3;
               var7.mViewHolder = var4;
               if(var4.itemView.getParent() != null) {
                  var3 = false;
               }

               var7.mPendingInvalidate = var3;
            } else {
               throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + var2 + "(offset:" + var5 + ")." + "state:" + RecyclerView.this.mState.getItemCount());
            }
         }
      }

      public void clear() {
         this.mAttachedScrap.clear();
         this.recycleAndClearCachedViews();
      }

      void clearOldPositions() {
         int var1 = this.mCachedViews.size();

         for(int var2 = 0; var2 < var1; ++var2) {
            ((RecyclerView.ViewHolder)this.mCachedViews.get(var2)).clearOldPosition();
         }

         int var3 = this.mAttachedScrap.size();

         for(int var4 = 0; var4 < var3; ++var4) {
            ((RecyclerView.ViewHolder)this.mAttachedScrap.get(var4)).clearOldPosition();
         }

         if(this.mChangedScrap != null) {
            int var5 = this.mChangedScrap.size();

            for(int var6 = 0; var6 < var5; ++var6) {
               ((RecyclerView.ViewHolder)this.mChangedScrap.get(var6)).clearOldPosition();
            }
         }

      }

      void clearScrap() {
         this.mAttachedScrap.clear();
         if(this.mChangedScrap != null) {
            this.mChangedScrap.clear();
         }

      }

      public int convertPreLayoutPositionToPostLayout(int var1) {
         if(var1 >= 0 && var1 < RecyclerView.this.mState.getItemCount()) {
            return !RecyclerView.this.mState.isPreLayout()?var1:RecyclerView.this.mAdapterHelper.findPositionOffset(var1);
         } else {
            throw new IndexOutOfBoundsException("invalid position " + var1 + ". State " + "item count is " + RecyclerView.this.mState.getItemCount());
         }
      }

      void dispatchViewRecycled(RecyclerView.ViewHolder var1) {
         if(RecyclerView.this.mRecyclerListener != null) {
            RecyclerView.this.mRecyclerListener.onViewRecycled(var1);
         }

         if(RecyclerView.this.mAdapter != null) {
            RecyclerView.this.mAdapter.onViewRecycled(var1);
         }

         if(RecyclerView.this.mState != null) {
            RecyclerView.this.mViewInfoStore.removeViewHolder(var1);
         }

      }

      RecyclerView.ViewHolder getChangedScrapViewForPosition(int var1) {
         if(this.mChangedScrap != null) {
            int var2 = this.mChangedScrap.size();
            if(var2 != 0) {
               for(int var3 = 0; var3 < var2; ++var3) {
                  RecyclerView.ViewHolder var9 = (RecyclerView.ViewHolder)this.mChangedScrap.get(var3);
                  if(!var9.wasReturnedFromScrap() && var9.getLayoutPosition() == var1) {
                     var9.addFlags(32);
                     return var9;
                  }
               }

               if(RecyclerView.this.mAdapter.hasStableIds()) {
                  int var4 = RecyclerView.this.mAdapterHelper.findPositionOffset(var1);
                  if(var4 > 0 && var4 < RecyclerView.this.mAdapter.getItemCount()) {
                     long var5 = RecyclerView.this.mAdapter.getItemId(var4);

                     for(int var7 = 0; var7 < var2; ++var7) {
                        RecyclerView.ViewHolder var8 = (RecyclerView.ViewHolder)this.mChangedScrap.get(var7);
                        if(!var8.wasReturnedFromScrap() && var8.getItemId() == var5) {
                           var8.addFlags(32);
                           return var8;
                        }
                     }
                  }
               }

               return null;
            }
         }

         return null;
      }

      RecyclerView.RecycledViewPool getRecycledViewPool() {
         if(this.mRecyclerPool == null) {
            this.mRecyclerPool = new RecyclerView.RecycledViewPool();
         }

         return this.mRecyclerPool;
      }

      int getScrapCount() {
         return this.mAttachedScrap.size();
      }

      public List<RecyclerView.ViewHolder> getScrapList() {
         return this.mUnmodifiableAttachedScrap;
      }

      View getScrapViewAt(int var1) {
         return ((RecyclerView.ViewHolder)this.mAttachedScrap.get(var1)).itemView;
      }

      RecyclerView.ViewHolder getScrapViewForId(long var1, int var3, boolean var4) {
         int var5 = -1 + this.mAttachedScrap.size();

         RecyclerView.ViewHolder var7;
         while(true) {
            if(var5 < 0) {
               for(int var6 = -1 + this.mCachedViews.size(); var6 >= 0; --var6) {
                  var7 = (RecyclerView.ViewHolder)this.mCachedViews.get(var6);
                  if(var7.getItemId() == var1) {
                     if(var3 == var7.getItemViewType()) {
                        if(!var4) {
                           this.mCachedViews.remove(var6);
                           return var7;
                        }

                        return var7;
                     }

                     if(!var4) {
                        this.recycleCachedViewAt(var6);
                     }
                  }
               }

               return null;
            }

            var7 = (RecyclerView.ViewHolder)this.mAttachedScrap.get(var5);
            if(var7.getItemId() == var1 && !var7.wasReturnedFromScrap()) {
               if(var3 == var7.getItemViewType()) {
                  var7.addFlags(32);
                  if(var7.isRemoved() && !RecyclerView.this.mState.isPreLayout()) {
                     var7.setFlags(2, 14);
                  }
                  break;
               }

               if(!var4) {
                  this.mAttachedScrap.remove(var5);
                  RecyclerView.this.removeDetachedView(var7.itemView, false);
                  this.quickRecycleScrapView(var7.itemView);
               }
            }

            --var5;
         }

         return var7;
      }

      RecyclerView.ViewHolder getScrapViewForPosition(int var1, int var2, boolean var3) {
         int var4 = this.mAttachedScrap.size();
         int var5 = 0;

         while(true) {
            RecyclerView.ViewHolder var8;
            if(var5 < var4) {
               var8 = (RecyclerView.ViewHolder)this.mAttachedScrap.get(var5);
               if(var8.wasReturnedFromScrap() || var8.getLayoutPosition() != var1 || var8.isInvalid() || !RecyclerView.this.mState.mInPreLayout && var8.isRemoved()) {
                  ++var5;
                  continue;
               }

               if(var2 == -1 || var8.getItemViewType() == var2) {
                  var8.addFlags(32);
                  return var8;
               }

               Log.e("RecyclerView", "Scrap view for position " + var1 + " isn\'t dirty but has" + " wrong view type! (found " + var8.getItemViewType() + " but expected " + var2 + ")");
            }

            if(!var3) {
               View var10 = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(var1, var2);
               if(var10 != null) {
                  RecyclerView.ViewHolder var11 = RecyclerView.getChildViewHolderInt(var10);
                  RecyclerView.this.mChildHelper.unhide(var10);
                  int var12 = RecyclerView.this.mChildHelper.indexOfChild(var10);
                  if(var12 == -1) {
                     throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + var11);
                  }

                  RecyclerView.this.mChildHelper.detachViewFromParent(var12);
                  this.scrapView(var10);
                  var11.addFlags(8224);
                  return var11;
               }
            }

            int var6 = this.mCachedViews.size();

            for(int var7 = 0; var7 < var6; ++var7) {
               var8 = (RecyclerView.ViewHolder)this.mCachedViews.get(var7);
               if(!var8.isInvalid() && var8.getLayoutPosition() == var1) {
                  if(!var3) {
                     this.mCachedViews.remove(var7);
                     return var8;
                  }

                  return var8;
               }
            }

            return null;
         }
      }

      public View getViewForPosition(int var1) {
         return this.getViewForPosition(var1, false);
      }

      View getViewForPosition(int var1, boolean var2) {
         if(var1 >= 0 && var1 < RecyclerView.this.mState.getItemCount()) {
            boolean var3 = RecyclerView.this.mState.isPreLayout();
            boolean var4 = false;
            RecyclerView.ViewHolder var5 = null;
            if(var3) {
               var5 = this.getChangedScrapViewForPosition(var1);
               if(var5 != null) {
                  var4 = true;
               } else {
                  var4 = false;
               }
            }

            if(var5 == null) {
               var5 = this.getScrapViewForPosition(var1, -1, var2);
               if(var5 != null) {
                  if(!this.validateViewHolderForOffsetPosition(var5)) {
                     if(!var2) {
                        var5.addFlags(4);
                        if(var5.isScrap()) {
                           RecyclerView.this.removeDetachedView(var5.itemView, false);
                           var5.unScrap();
                        } else if(var5.wasReturnedFromScrap()) {
                           var5.clearReturnedFromScrapFlag();
                        }

                        this.recycleViewHolderInternal(var5);
                     }

                     var5 = null;
                  } else {
                     var4 = true;
                  }
               }
            }

            if(var5 == null) {
               int var14 = RecyclerView.this.mAdapterHelper.findPositionOffset(var1);
               if(var14 < 0 || var14 >= RecyclerView.this.mAdapter.getItemCount()) {
                  throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + var1 + "(offset:" + var14 + ")." + "state:" + RecyclerView.this.mState.getItemCount());
               }

               int var15 = RecyclerView.this.mAdapter.getItemViewType(var14);
               if(RecyclerView.this.mAdapter.hasStableIds()) {
                  var5 = this.getScrapViewForId(RecyclerView.this.mAdapter.getItemId(var14), var15, var2);
                  if(var5 != null) {
                     var5.mPosition = var14;
                     var4 = true;
                  }
               }

               if(var5 == null && this.mViewCacheExtension != null) {
                  View var16 = this.mViewCacheExtension.getViewForPositionAndType(this, var1, var15);
                  if(var16 != null) {
                     var5 = RecyclerView.this.getChildViewHolder(var16);
                     if(var5 == null) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                     }

                     if(var5.shouldIgnore()) {
                        throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                     }
                  }
               }

               if(var5 == null) {
                  var5 = this.getRecycledViewPool().getRecycledView(var15);
                  if(var5 != null) {
                     var5.resetInternal();
                     if(RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                        this.invalidateDisplayListInt(var5);
                     }
                  }
               }

               if(var5 == null) {
                  var5 = RecyclerView.this.mAdapter.createViewHolder(RecyclerView.this, var15);
               }
            }

            if(var4 && !RecyclerView.this.mState.isPreLayout() && var5.hasAnyOfTheFlags(8192)) {
               var5.setFlags(0, 8192);
               if(RecyclerView.this.mState.mRunSimpleAnimations) {
                  int var12 = 4096 | RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations(var5);
                  RecyclerView.ItemHolderInfo var13 = RecyclerView.this.mItemAnimator.recordPreLayoutInformation(RecyclerView.this.mState, var5, var12, var5.getUnmodifiedPayloads());
                  RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(var5, var13);
               }
            }

            boolean var6 = false;
            if(RecyclerView.this.mState.isPreLayout() && var5.isBound()) {
               var5.mPreLayoutPosition = var1;
            } else {
               label132: {
                  if(var5.isBound() && !var5.needsUpdate()) {
                     boolean var11 = var5.isInvalid();
                     var6 = false;
                     if(!var11) {
                        break label132;
                     }
                  }

                  int var7 = RecyclerView.this.mAdapterHelper.findPositionOffset(var1);
                  var5.mOwnerRecyclerView = RecyclerView.this;
                  RecyclerView.this.mAdapter.bindViewHolder(var5, var7);
                  this.attachAccessibilityDelegate(var5.itemView);
                  var6 = true;
                  if(RecyclerView.this.mState.isPreLayout()) {
                     var5.mPreLayoutPosition = var1;
                  }
               }
            }

            android.view.ViewGroup.LayoutParams var8 = var5.itemView.getLayoutParams();
            RecyclerView.LayoutParams var9;
            if(var8 == null) {
               var9 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
               var5.itemView.setLayoutParams(var9);
            } else if(!RecyclerView.this.checkLayoutParams(var8)) {
               var9 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams(var8);
               var5.itemView.setLayoutParams(var9);
            } else {
               var9 = (RecyclerView.LayoutParams)var8;
            }

            var9.mViewHolder = var5;
            boolean var10;
            if(var4 && var6) {
               var10 = true;
            } else {
               var10 = false;
            }

            var9.mPendingInvalidate = var10;
            return var5.itemView;
         } else {
            throw new IndexOutOfBoundsException("Invalid item position " + var1 + "(" + var1 + "). Item count:" + RecyclerView.this.mState.getItemCount());
         }
      }

      void markItemDecorInsetsDirty() {
         int var1 = this.mCachedViews.size();

         for(int var2 = 0; var2 < var1; ++var2) {
            RecyclerView.LayoutParams var3 = (RecyclerView.LayoutParams)((RecyclerView.ViewHolder)this.mCachedViews.get(var2)).itemView.getLayoutParams();
            if(var3 != null) {
               var3.mInsetsDirty = true;
            }
         }

      }

      void markKnownViewsInvalid() {
         if(RecyclerView.this.mAdapter != null && RecyclerView.this.mAdapter.hasStableIds()) {
            int var1 = this.mCachedViews.size();

            for(int var2 = 0; var2 < var1; ++var2) {
               RecyclerView.ViewHolder var3 = (RecyclerView.ViewHolder)this.mCachedViews.get(var2);
               if(var3 != null) {
                  var3.addFlags(6);
                  var3.addChangePayload((Object)null);
               }
            }
         } else {
            this.recycleAndClearCachedViews();
         }

      }

      void offsetPositionRecordsForInsert(int var1, int var2) {
         int var3 = this.mCachedViews.size();

         for(int var4 = 0; var4 < var3; ++var4) {
            RecyclerView.ViewHolder var5 = (RecyclerView.ViewHolder)this.mCachedViews.get(var4);
            if(var5 != null && var5.mPosition >= var1) {
               var5.offsetPosition(var2, true);
            }
         }

      }

      void offsetPositionRecordsForMove(int var1, int var2) {
         int var3;
         int var4;
         byte var5;
         if(var1 < var2) {
            var3 = var1;
            var4 = var2;
            var5 = -1;
         } else {
            var3 = var2;
            var4 = var1;
            var5 = 1;
         }

         int var6 = this.mCachedViews.size();

         for(int var7 = 0; var7 < var6; ++var7) {
            RecyclerView.ViewHolder var8 = (RecyclerView.ViewHolder)this.mCachedViews.get(var7);
            if(var8 != null && var8.mPosition >= var3 && var8.mPosition <= var4) {
               if(var8.mPosition == var1) {
                  var8.offsetPosition(var2 - var1, false);
               } else {
                  var8.offsetPosition(var5, false);
               }
            }
         }

      }

      void offsetPositionRecordsForRemove(int var1, int var2, boolean var3) {
         int var4 = var1 + var2;

         for(int var5 = -1 + this.mCachedViews.size(); var5 >= 0; --var5) {
            RecyclerView.ViewHolder var6 = (RecyclerView.ViewHolder)this.mCachedViews.get(var5);
            if(var6 != null) {
               if(var6.mPosition >= var4) {
                  var6.offsetPosition(-var2, var3);
               } else if(var6.mPosition >= var1) {
                  var6.addFlags(8);
                  this.recycleCachedViewAt(var5);
               }
            }
         }

      }

      void onAdapterChanged(RecyclerView.Adapter var1, RecyclerView.Adapter var2, boolean var3) {
         this.clear();
         this.getRecycledViewPool().onAdapterChanged(var1, var2, var3);
      }

      void quickRecycleScrapView(View var1) {
         RecyclerView.ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
         var2.mScrapContainer = null;
         var2.mInChangeScrap = false;
         var2.clearReturnedFromScrapFlag();
         this.recycleViewHolderInternal(var2);
      }

      void recycleAndClearCachedViews() {
         for(int var1 = -1 + this.mCachedViews.size(); var1 >= 0; --var1) {
            this.recycleCachedViewAt(var1);
         }

         this.mCachedViews.clear();
      }

      void recycleCachedViewAt(int var1) {
         this.addViewHolderToRecycledViewPool((RecyclerView.ViewHolder)this.mCachedViews.get(var1));
         this.mCachedViews.remove(var1);
      }

      public void recycleView(View var1) {
         RecyclerView.ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
         if(var2.isTmpDetached()) {
            RecyclerView.this.removeDetachedView(var1, false);
         }

         if(var2.isScrap()) {
            var2.unScrap();
         } else if(var2.wasReturnedFromScrap()) {
            var2.clearReturnedFromScrapFlag();
         }

         this.recycleViewHolderInternal(var2);
      }

      void recycleViewHolderInternal(RecyclerView.ViewHolder var1) {
         boolean var2 = true;
         if(!var1.isScrap() && var1.itemView.getParent() == null) {
            if(var1.isTmpDetached()) {
               throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + var1);
            } else if(var1.shouldIgnore()) {
               throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
               boolean var4 = var1.doesTransientStatePreventRecycling();
               boolean var5;
               if(RecyclerView.this.mAdapter != null && var4 && RecyclerView.this.mAdapter.onFailedToRecycleView(var1)) {
                  var5 = var2;
               } else {
                  var5 = false;
               }

               boolean var7;
               boolean var8;
               label66: {
                  if(!var5) {
                     boolean var12 = var1.isRecyclable();
                     var7 = false;
                     var8 = false;
                     if(!var12) {
                        break label66;
                     }
                  }

                  boolean var6 = var1.hasAnyOfTheFlags(14);
                  var7 = false;
                  if(!var6) {
                     int var9 = this.mCachedViews.size();
                     if(var9 == this.mViewCacheMax && var9 > 0) {
                        this.recycleCachedViewAt(0);
                     }

                     int var10 = this.mViewCacheMax;
                     var7 = false;
                     if(var9 < var10) {
                        this.mCachedViews.add(var1);
                        var7 = true;
                     }
                  }

                  var8 = false;
                  if(!var7) {
                     this.addViewHolderToRecycledViewPool(var1);
                     var8 = true;
                  }
               }

               RecyclerView.this.mViewInfoStore.removeViewHolder(var1);
               if(!var7 && !var8 && var4) {
                  var1.mOwnerRecyclerView = null;
               }

            }
         } else {
            StringBuilder var3 = (new StringBuilder()).append("Scrapped or attached views may not be recycled. isScrap:").append(var1.isScrap()).append(" isAttached:");
            if(var1.itemView.getParent() == null) {
               var2 = false;
            }

            throw new IllegalArgumentException(var3.append(var2).toString());
         }
      }

      void recycleViewInternal(View var1) {
         this.recycleViewHolderInternal(RecyclerView.getChildViewHolderInt(var1));
      }

      void scrapView(View var1) {
         RecyclerView.ViewHolder var2 = RecyclerView.getChildViewHolderInt(var1);
         if(!var2.hasAnyOfTheFlags(12) && var2.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(var2)) {
            if(this.mChangedScrap == null) {
               this.mChangedScrap = new ArrayList();
            }

            var2.setScrapContainer(this, true);
            this.mChangedScrap.add(var2);
         } else if(var2.isInvalid() && !var2.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
         } else {
            var2.setScrapContainer(this, false);
            this.mAttachedScrap.add(var2);
         }
      }

      void setAdapterPositionsAsUnknown() {
         int var1 = this.mCachedViews.size();

         for(int var2 = 0; var2 < var1; ++var2) {
            RecyclerView.ViewHolder var3 = (RecyclerView.ViewHolder)this.mCachedViews.get(var2);
            if(var3 != null) {
               var3.addFlags(512);
            }
         }

      }

      void setRecycledViewPool(RecyclerView.RecycledViewPool var1) {
         if(this.mRecyclerPool != null) {
            this.mRecyclerPool.detach();
         }

         this.mRecyclerPool = var1;
         if(var1 != null) {
            this.mRecyclerPool.attach(RecyclerView.this.getAdapter());
         }

      }

      void setViewCacheExtension(RecyclerView.ViewCacheExtension var1) {
         this.mViewCacheExtension = var1;
      }

      public void setViewCacheSize(int var1) {
         this.mViewCacheMax = var1;

         for(int var2 = -1 + this.mCachedViews.size(); var2 >= 0 && this.mCachedViews.size() > var1; --var2) {
            this.recycleCachedViewAt(var2);
         }

      }

      void unscrapView(RecyclerView.ViewHolder var1) {
         if(var1.mInChangeScrap) {
            this.mChangedScrap.remove(var1);
         } else {
            this.mAttachedScrap.remove(var1);
         }

         var1.mScrapContainer = null;
         var1.mInChangeScrap = false;
         var1.clearReturnedFromScrapFlag();
      }

      boolean validateViewHolderForOffsetPosition(RecyclerView.ViewHolder var1) {
         boolean var2 = true;
         if(var1.isRemoved()) {
            var2 = RecyclerView.this.mState.isPreLayout();
         } else {
            if(var1.mPosition < 0 || var1.mPosition >= RecyclerView.this.mAdapter.getItemCount()) {
               throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + var1);
            }

            if(!RecyclerView.this.mState.isPreLayout() && RecyclerView.this.mAdapter.getItemViewType(var1.mPosition) != var1.getItemViewType()) {
               return false;
            }

            if(RecyclerView.this.mAdapter.hasStableIds() && var1.getItemId() != RecyclerView.this.mAdapter.getItemId(var1.mPosition)) {
               return false;
            }
         }

         return var2;
      }

      void viewRangeUpdate(int var1, int var2) {
         int var3 = var1 + var2;

         for(int var4 = -1 + this.mCachedViews.size(); var4 >= 0; --var4) {
            RecyclerView.ViewHolder var5 = (RecyclerView.ViewHolder)this.mCachedViews.get(var4);
            if(var5 != null) {
               int var6 = var5.getLayoutPosition();
               if(var6 >= var1 && var6 < var3) {
                  var5.addFlags(2);
                  this.recycleCachedViewAt(var4);
               }
            }
         }

      }
   }

   public interface RecyclerListener {
      void onViewRecycled(RecyclerView.ViewHolder var1);
   }

   private class RecyclerViewDataObserver extends RecyclerView.AdapterDataObserver {
      private RecyclerViewDataObserver() {
      }

      // $FF: synthetic method
      RecyclerViewDataObserver(Object var2) {
         this();
      }

      public void onChanged() {
         RecyclerView.this.assertNotInLayoutOrScroll((String)null);
         if(RecyclerView.this.mAdapter.hasStableIds()) {
            RecyclerView.this.mState.mStructureChanged = true;
            RecyclerView.this.setDataSetChangedAfterLayout();
         } else {
            RecyclerView.this.mState.mStructureChanged = true;
            RecyclerView.this.setDataSetChangedAfterLayout();
         }

         if(!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
            RecyclerView.this.requestLayout();
         }

      }

      public void onItemRangeChanged(int var1, int var2, Object var3) {
         RecyclerView.this.assertNotInLayoutOrScroll((String)null);
         if(RecyclerView.this.mAdapterHelper.onItemRangeChanged(var1, var2, var3)) {
            this.triggerUpdateProcessor();
         }

      }

      public void onItemRangeInserted(int var1, int var2) {
         RecyclerView.this.assertNotInLayoutOrScroll((String)null);
         if(RecyclerView.this.mAdapterHelper.onItemRangeInserted(var1, var2)) {
            this.triggerUpdateProcessor();
         }

      }

      public void onItemRangeMoved(int var1, int var2, int var3) {
         RecyclerView.this.assertNotInLayoutOrScroll((String)null);
         if(RecyclerView.this.mAdapterHelper.onItemRangeMoved(var1, var2, var3)) {
            this.triggerUpdateProcessor();
         }

      }

      public void onItemRangeRemoved(int var1, int var2) {
         RecyclerView.this.assertNotInLayoutOrScroll((String)null);
         if(RecyclerView.this.mAdapterHelper.onItemRangeRemoved(var1, var2)) {
            this.triggerUpdateProcessor();
         }

      }

      void triggerUpdateProcessor() {
         if(RecyclerView.this.mPostUpdatesOnAnimation && RecyclerView.this.mHasFixedSize && RecyclerView.this.mIsAttached) {
            ViewCompat.postOnAnimation(RecyclerView.this, RecyclerView.this.mUpdateChildViewsRunnable);
         } else {
            RecyclerView.this.mAdapterUpdateDuringMeasure = true;
            RecyclerView.this.requestLayout();
         }
      }
   }

   public static class SavedState extends BaseSavedState {
      public static final Creator<RecyclerView.SavedState> CREATOR = new Creator() {
         public RecyclerView.SavedState createFromParcel(Parcel var1) {
            return new RecyclerView.SavedState(var1);
         }

         public RecyclerView.SavedState[] newArray(int var1) {
            return new RecyclerView.SavedState[var1];
         }
      };
      Parcelable mLayoutState;

      SavedState(Parcel var1) {
         super(var1);
         this.mLayoutState = var1.readParcelable(RecyclerView.LayoutManager.class.getClassLoader());
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      private void copyFrom(RecyclerView.SavedState var1) {
         this.mLayoutState = var1.mLayoutState;
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeParcelable(this.mLayoutState, 0);
      }
   }

   public static class SimpleOnItemTouchListener implements RecyclerView.OnItemTouchListener {
      public boolean onInterceptTouchEvent(RecyclerView var1, MotionEvent var2) {
         return false;
      }

      public void onRequestDisallowInterceptTouchEvent(boolean var1) {
      }

      public void onTouchEvent(RecyclerView var1, MotionEvent var2) {
      }
   }

   public abstract static class SmoothScroller {
      private RecyclerView.LayoutManager mLayoutManager;
      private boolean mPendingInitialRun;
      private RecyclerView mRecyclerView;
      private final RecyclerView.Action mRecyclingAction = new RecyclerView.Action(0, 0);
      private boolean mRunning;
      private int mTargetPosition = -1;
      private View mTargetView;

      private void onAnimation(int var1, int var2) {
         RecyclerView var3 = this.mRecyclerView;
         if(!this.mRunning || this.mTargetPosition == -1 || var3 == null) {
            this.stop();
         }

         this.mPendingInitialRun = false;
         if(this.mTargetView != null) {
            if(this.getChildPosition(this.mTargetView) == this.mTargetPosition) {
               this.onTargetFound(this.mTargetView, var3.mState, this.mRecyclingAction);
               this.mRecyclingAction.runIfNecessary(var3);
               this.stop();
            } else {
               Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
               this.mTargetView = null;
            }
         }

         if(this.mRunning) {
            this.onSeekTargetStep(var1, var2, var3.mState, this.mRecyclingAction);
            boolean var4 = this.mRecyclingAction.hasJumpTarget();
            this.mRecyclingAction.runIfNecessary(var3);
            if(var4) {
               if(!this.mRunning) {
                  this.stop();
                  return;
               }

               this.mPendingInitialRun = true;
               var3.mViewFlinger.postOnAnimation();
            }
         }

      }

      public View findViewByPosition(int var1) {
         return this.mRecyclerView.mLayout.findViewByPosition(var1);
      }

      public int getChildCount() {
         return this.mRecyclerView.mLayout.getChildCount();
      }

      public int getChildPosition(View var1) {
         return this.mRecyclerView.getChildLayoutPosition(var1);
      }

      @Nullable
      public RecyclerView.LayoutManager getLayoutManager() {
         return this.mLayoutManager;
      }

      public int getTargetPosition() {
         return this.mTargetPosition;
      }

      @Deprecated
      public void instantScrollToPosition(int var1) {
         this.mRecyclerView.scrollToPosition(var1);
      }

      public boolean isPendingInitialRun() {
         return this.mPendingInitialRun;
      }

      public boolean isRunning() {
         return this.mRunning;
      }

      protected void normalize(PointF var1) {
         double var2 = Math.sqrt((double)(var1.x * var1.x + var1.y * var1.y));
         var1.x = (float)((double)var1.x / var2);
         var1.y = (float)((double)var1.y / var2);
      }

      protected void onChildAttachedToWindow(View var1) {
         if(this.getChildPosition(var1) == this.getTargetPosition()) {
            this.mTargetView = var1;
         }

      }

      protected abstract void onSeekTargetStep(int var1, int var2, RecyclerView.State var3, RecyclerView.Action var4);

      protected abstract void onStart();

      protected abstract void onStop();

      protected abstract void onTargetFound(View var1, RecyclerView.State var2, RecyclerView.Action var3);

      public void setTargetPosition(int var1) {
         this.mTargetPosition = var1;
      }

      void start(RecyclerView var1, RecyclerView.LayoutManager var2) {
         this.mRecyclerView = var1;
         this.mLayoutManager = var2;
         if(this.mTargetPosition == -1) {
            throw new IllegalArgumentException("Invalid target position");
         } else {
            this.mRecyclerView.mState.mTargetPosition = this.mTargetPosition;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = this.findViewByPosition(this.getTargetPosition());
            this.onStart();
            this.mRecyclerView.mViewFlinger.postOnAnimation();
         }
      }

      protected final void stop() {
         if(this.mRunning) {
            this.onStop();
            this.mRecyclerView.mState.mTargetPosition = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mRunning = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
         }
      }
   }

   public static class Action {
      public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
      private boolean changed;
      private int consecutiveUpdates;
      private int mDuration;
      private int mDx;
      private int mDy;
      private Interpolator mInterpolator;
      private int mJumpToPosition;

      public Action(int var1, int var2) {
         this(var1, var2, Integer.MIN_VALUE, (Interpolator)null);
      }

      public Action(int var1, int var2, int var3) {
         this(var1, var2, var3, (Interpolator)null);
      }

      public Action(int var1, int var2, int var3, Interpolator var4) {
         this.mJumpToPosition = -1;
         this.changed = false;
         this.consecutiveUpdates = 0;
         this.mDx = var1;
         this.mDy = var2;
         this.mDuration = var3;
         this.mInterpolator = var4;
      }

      private void runIfNecessary(RecyclerView var1) {
         if(this.mJumpToPosition >= 0) {
            int var3 = this.mJumpToPosition;
            this.mJumpToPosition = -1;
            var1.jumpToPositionForSmoothScroller(var3);
            this.changed = false;
         } else if(this.changed) {
            this.validate();
            if(this.mInterpolator == null) {
               if(this.mDuration == Integer.MIN_VALUE) {
                  var1.mViewFlinger.smoothScrollBy(this.mDx, this.mDy);
               } else {
                  var1.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration);
               }
            } else {
               var1.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
            }

            ++this.consecutiveUpdates;
            if(this.consecutiveUpdates > 10) {
               Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }

            this.changed = false;
         } else {
            this.consecutiveUpdates = 0;
         }
      }

      private void validate() {
         if(this.mInterpolator != null && this.mDuration < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
         } else if(this.mDuration < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
         }
      }

      public int getDuration() {
         return this.mDuration;
      }

      public int getDx() {
         return this.mDx;
      }

      public int getDy() {
         return this.mDy;
      }

      public Interpolator getInterpolator() {
         return this.mInterpolator;
      }

      boolean hasJumpTarget() {
         return this.mJumpToPosition >= 0;
      }

      public void jumpTo(int var1) {
         this.mJumpToPosition = var1;
      }

      public void setDuration(int var1) {
         this.changed = true;
         this.mDuration = var1;
      }

      public void setDx(int var1) {
         this.changed = true;
         this.mDx = var1;
      }

      public void setDy(int var1) {
         this.changed = true;
         this.mDy = var1;
      }

      public void setInterpolator(Interpolator var1) {
         this.changed = true;
         this.mInterpolator = var1;
      }

      public void update(int var1, int var2, int var3, Interpolator var4) {
         this.mDx = var1;
         this.mDy = var2;
         this.mDuration = var3;
         this.mInterpolator = var4;
         this.changed = true;
      }
   }

   public static class State {
      static final int STEP_ANIMATIONS = 4;
      static final int STEP_LAYOUT = 2;
      static final int STEP_START = 1;
      private SparseArray<Object> mData;
      private int mDeletedInvisibleItemCountSincePreviousLayout = 0;
      private boolean mInPreLayout = false;
      private boolean mIsMeasuring = false;
      int mItemCount = 0;
      private int mLayoutStep = 1;
      private int mPreviousLayoutItemCount = 0;
      private boolean mRunPredictiveAnimations = false;
      private boolean mRunSimpleAnimations = false;
      private boolean mStructureChanged = false;
      private int mTargetPosition = -1;
      private boolean mTrackOldChangeHolders = false;

      // $FF: synthetic method
      static int access$1712(RecyclerView.State var0, int var1) {
         int var2 = var1 + var0.mDeletedInvisibleItemCountSincePreviousLayout;
         var0.mDeletedInvisibleItemCountSincePreviousLayout = var2;
         return var2;
      }

      void assertLayoutStep(int var1) {
         if((var1 & this.mLayoutStep) == 0) {
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(var1) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
         }
      }

      public boolean didStructureChange() {
         return this.mStructureChanged;
      }

      public <T> T get(int var1) {
         return this.mData == null?null:this.mData.get(var1);
      }

      public int getItemCount() {
         return this.mInPreLayout?this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout:this.mItemCount;
      }

      public int getTargetScrollPosition() {
         return this.mTargetPosition;
      }

      public boolean hasTargetScrollPosition() {
         return this.mTargetPosition != -1;
      }

      public boolean isMeasuring() {
         return this.mIsMeasuring;
      }

      public boolean isPreLayout() {
         return this.mInPreLayout;
      }

      public void put(int var1, Object var2) {
         if(this.mData == null) {
            this.mData = new SparseArray();
         }

         this.mData.put(var1, var2);
      }

      public void remove(int var1) {
         if(this.mData != null) {
            this.mData.remove(var1);
         }
      }

      RecyclerView.State reset() {
         this.mTargetPosition = -1;
         if(this.mData != null) {
            this.mData.clear();
         }

         this.mItemCount = 0;
         this.mStructureChanged = false;
         this.mIsMeasuring = false;
         return this;
      }

      public String toString() {
         return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
      }

      public boolean willRunPredictiveAnimations() {
         return this.mRunPredictiveAnimations;
      }

      public boolean willRunSimpleAnimations() {
         return this.mRunSimpleAnimations;
      }
   }

   public abstract static class ViewCacheExtension {
      public abstract View getViewForPositionAndType(RecyclerView.Recycler var1, int var2, int var3);
   }

   private class ViewFlinger implements Runnable {
      private boolean mEatRunOnAnimationRequest;
      private Interpolator mInterpolator;
      private int mLastFlingX;
      private int mLastFlingY;
      private boolean mReSchedulePostAnimationCallback;
      private ScrollerCompat mScroller;

      public ViewFlinger() {
         this.mInterpolator = RecyclerView.sQuinticInterpolator;
         this.mEatRunOnAnimationRequest = false;
         this.mReSchedulePostAnimationCallback = false;
         this.mScroller = ScrollerCompat.create(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
      }

      private int computeScrollDuration(int var1, int var2, int var3, int var4) {
         int var5 = Math.abs(var1);
         int var6 = Math.abs(var2);
         boolean var7;
         if(var5 > var6) {
            var7 = true;
         } else {
            var7 = false;
         }

         int var8 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4));
         int var9 = (int)Math.sqrt((double)(var1 * var1 + var2 * var2));
         int var10;
         if(var7) {
            var10 = RecyclerView.this.getWidth();
         } else {
            var10 = RecyclerView.this.getHeight();
         }

         int var11 = var10 / 2;
         float var12 = Math.min(1.0F, 1.0F * (float)var9 / (float)var10);
         float var13 = (float)var11 + (float)var11 * this.distanceInfluenceForSnapDuration(var12);
         int var14;
         if(var8 > 0) {
            var14 = 4 * Math.round(1000.0F * Math.abs(var13 / (float)var8));
         } else {
            if(!var7) {
               var5 = var6;
            }

            var14 = (int)(300.0F * (1.0F + (float)var5 / (float)var10));
         }

         return Math.min(var14, 2000);
      }

      private void disableRunOnAnimationRequests() {
         this.mReSchedulePostAnimationCallback = false;
         this.mEatRunOnAnimationRequest = true;
      }

      private float distanceInfluenceForSnapDuration(float var1) {
         return (float)Math.sin((double)((float)(0.4712389167638204D * (double)(var1 - 0.5F))));
      }

      private void enableRunOnAnimationRequests() {
         this.mEatRunOnAnimationRequest = false;
         if(this.mReSchedulePostAnimationCallback) {
            this.postOnAnimation();
         }

      }

      public void fling(int var1, int var2) {
         RecyclerView.this.setScrollState(2);
         this.mLastFlingY = 0;
         this.mLastFlingX = 0;
         this.mScroller.fling(0, 0, var1, var2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
         this.postOnAnimation();
      }

      void postOnAnimation() {
         if(this.mEatRunOnAnimationRequest) {
            this.mReSchedulePostAnimationCallback = true;
         } else {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
         }
      }

      public void run() {
         if(RecyclerView.this.mLayout == null) {
            this.stop();
         } else {
            this.disableRunOnAnimationRequests();
            RecyclerView.this.consumePendingUpdateOperations();
            ScrollerCompat var1 = this.mScroller;
            RecyclerView.SmoothScroller var2 = RecyclerView.this.mLayout.mSmoothScroller;
            if(var1.computeScrollOffset()) {
               int var3 = var1.getCurrX();
               int var4 = var1.getCurrY();
               int var5 = var3 - this.mLastFlingX;
               int var6 = var4 - this.mLastFlingY;
               this.mLastFlingX = var3;
               this.mLastFlingY = var4;
               RecyclerView.Adapter var7 = RecyclerView.this.mAdapter;
               int var8 = 0;
               int var9 = 0;
               int var10 = 0;
               int var11 = 0;
               if(var7 != null) {
                  RecyclerView.this.eatRequestLayout();
                  RecyclerView.this.onEnterLayoutOrScroll();
                  TraceCompat.beginSection("RV Scroll");
                  var8 = 0;
                  var9 = 0;
                  if(var5 != 0) {
                     var8 = RecyclerView.this.mLayout.scrollHorizontallyBy(var5, RecyclerView.this.mRecycler, RecyclerView.this.mState);
                     var9 = var5 - var8;
                  }

                  var10 = 0;
                  var11 = 0;
                  if(var6 != 0) {
                     var11 = RecyclerView.this.mLayout.scrollVerticallyBy(var6, RecyclerView.this.mRecycler, RecyclerView.this.mState);
                     var10 = var6 - var11;
                  }

                  TraceCompat.endSection();
                  RecyclerView.this.repositionShadowingViews();
                  RecyclerView.this.onExitLayoutOrScroll();
                  RecyclerView.this.resumeRequestLayout(false);
                  if(var2 != null && !var2.isPendingInitialRun() && var2.isRunning()) {
                     int var18 = RecyclerView.this.mState.getItemCount();
                     if(var18 == 0) {
                        var2.stop();
                     } else if(var2.getTargetPosition() >= var18) {
                        var2.setTargetPosition(var18 - 1);
                        var2.onAnimation(var5 - var9, var6 - var10);
                     } else {
                        var2.onAnimation(var5 - var9, var6 - var10);
                     }
                  }
               }

               if(!RecyclerView.this.mItemDecorations.isEmpty()) {
                  RecyclerView.this.invalidate();
               }

               if(ViewCompat.getOverScrollMode(RecyclerView.this) != 2) {
                  RecyclerView.this.considerReleasingGlowsOnScroll(var5, var6);
               }

               if(var9 != 0 || var10 != 0) {
                  int var12 = (int)var1.getCurrVelocity();
                  int var13 = 0;
                  if(var9 != var3) {
                     if(var9 < 0) {
                        var13 = -var12;
                     } else if(var9 > 0) {
                        var13 = var12;
                     } else {
                        var13 = 0;
                     }
                  }

                  int var14 = 0;
                  if(var10 != var4) {
                     if(var10 < 0) {
                        var14 = -var12;
                     } else if(var10 > 0) {
                        var14 = var12;
                     } else {
                        var14 = 0;
                     }
                  }

                  if(ViewCompat.getOverScrollMode(RecyclerView.this) != 2) {
                     RecyclerView.this.absorbGlows(var13, var14);
                  }

                  if((var13 != 0 || var9 == var3 || var1.getFinalX() == 0) && (var14 != 0 || var10 == var4 || var1.getFinalY() == 0)) {
                     var1.abortAnimation();
                  }
               }

               if(var8 != 0 || var11 != 0) {
                  RecyclerView.this.dispatchOnScrolled(var8, var11);
               }

               if(!RecyclerView.this.awakenScrollBars()) {
                  RecyclerView.this.invalidate();
               }

               boolean var15;
               if(var6 != 0 && RecyclerView.this.mLayout.canScrollVertically() && var11 == var6) {
                  var15 = true;
               } else {
                  var15 = false;
               }

               boolean var16;
               if(var5 != 0 && RecyclerView.this.mLayout.canScrollHorizontally() && var8 == var5) {
                  var16 = true;
               } else {
                  var16 = false;
               }

               boolean var17;
               if((var5 != 0 || var6 != 0) && !var16 && !var15) {
                  var17 = false;
               } else {
                  var17 = true;
               }

               if(!var1.isFinished() && var17) {
                  this.postOnAnimation();
               } else {
                  RecyclerView.this.setScrollState(0);
               }
            }

            if(var2 != null) {
               if(var2.isPendingInitialRun()) {
                  var2.onAnimation(0, 0);
               }

               if(!this.mReSchedulePostAnimationCallback) {
                  var2.stop();
               }
            }

            this.enableRunOnAnimationRequests();
         }
      }

      public void smoothScrollBy(int var1, int var2) {
         this.smoothScrollBy(var1, var2, 0, 0);
      }

      public void smoothScrollBy(int var1, int var2, int var3) {
         this.smoothScrollBy(var1, var2, var3, RecyclerView.sQuinticInterpolator);
      }

      public void smoothScrollBy(int var1, int var2, int var3, int var4) {
         this.smoothScrollBy(var1, var2, this.computeScrollDuration(var1, var2, var3, var4));
      }

      public void smoothScrollBy(int var1, int var2, int var3, Interpolator var4) {
         if(this.mInterpolator != var4) {
            this.mInterpolator = var4;
            this.mScroller = ScrollerCompat.create(RecyclerView.this.getContext(), var4);
         }

         RecyclerView.this.setScrollState(2);
         this.mLastFlingY = 0;
         this.mLastFlingX = 0;
         this.mScroller.startScroll(0, 0, var1, var2, var3);
         this.postOnAnimation();
      }

      public void stop() {
         RecyclerView.this.removeCallbacks(this);
         this.mScroller.abortAnimation();
      }
   }

   public abstract static class ViewHolder {
      static final int FLAG_ADAPTER_FULLUPDATE = 1024;
      static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
      static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
      static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
      static final int FLAG_BOUND = 1;
      static final int FLAG_IGNORE = 128;
      static final int FLAG_INVALID = 4;
      static final int FLAG_MOVED = 2048;
      static final int FLAG_NOT_RECYCLABLE = 16;
      static final int FLAG_REMOVED = 8;
      static final int FLAG_RETURNED_FROM_SCRAP = 32;
      static final int FLAG_TMP_DETACHED = 256;
      static final int FLAG_UPDATE = 2;
      private static final List<Object> FULLUPDATE_PAYLOADS;
      public final View itemView;
      private int mFlags;
      private boolean mInChangeScrap = false;
      private int mIsRecyclableCount = 0;
      long mItemId = -1L;
      int mItemViewType = -1;
      int mOldPosition = -1;
      RecyclerView mOwnerRecyclerView;
      List<Object> mPayloads = null;
      int mPosition = -1;
      int mPreLayoutPosition = -1;
      private RecyclerView.Recycler mScrapContainer = null;
      RecyclerView.ViewHolder mShadowedHolder = null;
      RecyclerView.ViewHolder mShadowingHolder = null;
      List<Object> mUnmodifiedPayloads = null;
      private int mWasImportantForAccessibilityBeforeHidden = 0;

      static {
         FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
      }

      public ViewHolder(View var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("itemView may not be null");
         } else {
            this.itemView = var1;
         }
      }

      private void createPayloadsIfNeeded() {
         if(this.mPayloads == null) {
            this.mPayloads = new ArrayList();
            this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
         }

      }

      private boolean doesTransientStatePreventRecycling() {
         return (16 & this.mFlags) == 0 && ViewCompat.hasTransientState(this.itemView);
      }

      private void onEnteredHiddenState() {
         this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
         ViewCompat.setImportantForAccessibility(this.itemView, 4);
      }

      private void onLeftHiddenState() {
         ViewCompat.setImportantForAccessibility(this.itemView, this.mWasImportantForAccessibilityBeforeHidden);
         this.mWasImportantForAccessibilityBeforeHidden = 0;
      }

      private boolean shouldBeKeptAsChild() {
         return (16 & this.mFlags) != 0;
      }

      void addChangePayload(Object var1) {
         if(var1 == null) {
            this.addFlags(1024);
         } else if((1024 & this.mFlags) == 0) {
            this.createPayloadsIfNeeded();
            this.mPayloads.add(var1);
            return;
         }

      }

      void addFlags(int var1) {
         this.mFlags |= var1;
      }

      void clearOldPosition() {
         this.mOldPosition = -1;
         this.mPreLayoutPosition = -1;
      }

      void clearPayload() {
         if(this.mPayloads != null) {
            this.mPayloads.clear();
         }

         this.mFlags &= -1025;
      }

      void clearReturnedFromScrapFlag() {
         this.mFlags &= -33;
      }

      void clearTmpDetachFlag() {
         this.mFlags &= -257;
      }

      void flagRemovedAndOffsetPosition(int var1, int var2, boolean var3) {
         this.addFlags(8);
         this.offsetPosition(var2, var3);
         this.mPosition = var1;
      }

      public final int getAdapterPosition() {
         return this.mOwnerRecyclerView == null?-1:this.mOwnerRecyclerView.getAdapterPositionFor(this);
      }

      public final long getItemId() {
         return this.mItemId;
      }

      public final int getItemViewType() {
         return this.mItemViewType;
      }

      public final int getLayoutPosition() {
         return this.mPreLayoutPosition == -1?this.mPosition:this.mPreLayoutPosition;
      }

      public final int getOldPosition() {
         return this.mOldPosition;
      }

      @Deprecated
      public final int getPosition() {
         return this.mPreLayoutPosition == -1?this.mPosition:this.mPreLayoutPosition;
      }

      List<Object> getUnmodifiedPayloads() {
         return (1024 & this.mFlags) == 0?(this.mPayloads != null && this.mPayloads.size() != 0?this.mUnmodifiedPayloads:FULLUPDATE_PAYLOADS):FULLUPDATE_PAYLOADS;
      }

      boolean hasAnyOfTheFlags(int var1) {
         return (var1 & this.mFlags) != 0;
      }

      boolean isAdapterPositionUnknown() {
         return (512 & this.mFlags) != 0 || this.isInvalid();
      }

      boolean isBound() {
         return (1 & this.mFlags) != 0;
      }

      boolean isInvalid() {
         return (4 & this.mFlags) != 0;
      }

      public final boolean isRecyclable() {
         return (16 & this.mFlags) == 0 && !ViewCompat.hasTransientState(this.itemView);
      }

      boolean isRemoved() {
         return (8 & this.mFlags) != 0;
      }

      boolean isScrap() {
         return this.mScrapContainer != null;
      }

      boolean isTmpDetached() {
         return (256 & this.mFlags) != 0;
      }

      boolean isUpdated() {
         return (2 & this.mFlags) != 0;
      }

      boolean needsUpdate() {
         return (2 & this.mFlags) != 0;
      }

      void offsetPosition(int var1, boolean var2) {
         if(this.mOldPosition == -1) {
            this.mOldPosition = this.mPosition;
         }

         if(this.mPreLayoutPosition == -1) {
            this.mPreLayoutPosition = this.mPosition;
         }

         if(var2) {
            this.mPreLayoutPosition += var1;
         }

         this.mPosition += var1;
         if(this.itemView.getLayoutParams() != null) {
            ((RecyclerView.LayoutParams)this.itemView.getLayoutParams()).mInsetsDirty = true;
         }

      }

      void resetInternal() {
         this.mFlags = 0;
         this.mPosition = -1;
         this.mOldPosition = -1;
         this.mItemId = -1L;
         this.mPreLayoutPosition = -1;
         this.mIsRecyclableCount = 0;
         this.mShadowedHolder = null;
         this.mShadowingHolder = null;
         this.clearPayload();
         this.mWasImportantForAccessibilityBeforeHidden = 0;
      }

      void saveOldPosition() {
         if(this.mOldPosition == -1) {
            this.mOldPosition = this.mPosition;
         }

      }

      void setFlags(int var1, int var2) {
         this.mFlags = this.mFlags & ~var2 | var1 & var2;
      }

      public final void setIsRecyclable(boolean var1) {
         int var2;
         if(var1) {
            var2 = -1 + this.mIsRecyclableCount;
         } else {
            var2 = 1 + this.mIsRecyclableCount;
         }

         this.mIsRecyclableCount = var2;
         if(this.mIsRecyclableCount < 0) {
            this.mIsRecyclableCount = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
         } else {
            if(!var1 && this.mIsRecyclableCount == 1) {
               this.mFlags |= 16;
               return;
            }

            if(var1 && this.mIsRecyclableCount == 0) {
               this.mFlags &= -17;
               return;
            }
         }

      }

      void setScrapContainer(RecyclerView.Recycler var1, boolean var2) {
         this.mScrapContainer = var1;
         this.mInChangeScrap = var2;
      }

      boolean shouldIgnore() {
         return (128 & this.mFlags) != 0;
      }

      void stopIgnoring() {
         this.mFlags &= -129;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("ViewHolder{" + Integer.toHexString(this.hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
         if(this.isScrap()) {
            StringBuilder var12 = var1.append(" scrap ");
            String var13;
            if(this.mInChangeScrap) {
               var13 = "[changeScrap]";
            } else {
               var13 = "[attachedScrap]";
            }

            var12.append(var13);
         }

         if(this.isInvalid()) {
            var1.append(" invalid");
         }

         if(!this.isBound()) {
            var1.append(" unbound");
         }

         if(this.needsUpdate()) {
            var1.append(" update");
         }

         if(this.isRemoved()) {
            var1.append(" removed");
         }

         if(this.shouldIgnore()) {
            var1.append(" ignored");
         }

         if(this.isTmpDetached()) {
            var1.append(" tmpDetached");
         }

         if(!this.isRecyclable()) {
            var1.append(" not recyclable(" + this.mIsRecyclableCount + ")");
         }

         if(this.isAdapterPositionUnknown()) {
            var1.append(" undefined adapter position");
         }

         if(this.itemView.getParent() == null) {
            var1.append(" no parent");
         }

         var1.append("}");
         return var1.toString();
      }

      void unScrap() {
         this.mScrapContainer.unscrapView(this);
      }

      boolean wasReturnedFromScrap() {
         return (32 & this.mFlags) != 0;
      }
   }
}
