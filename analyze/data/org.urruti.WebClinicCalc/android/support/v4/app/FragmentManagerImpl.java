package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.v4.app.BackStackRecord;
import android.support.v4.app.BackStackState;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerState;
import android.support.v4.app.FragmentState;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NoSaveStateFrameLayout;
import android.support.v4.app.SuperNotCalledException;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Animation.AnimationListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

final class FragmentManagerImpl extends FragmentManager {
   static final Interpolator ACCELERATE_CUBIC;
   static final Interpolator ACCELERATE_QUINT;
   static final int ANIM_DUR = 220;
   public static final int ANIM_STYLE_CLOSE_ENTER = 3;
   public static final int ANIM_STYLE_CLOSE_EXIT = 4;
   public static final int ANIM_STYLE_FADE_ENTER = 5;
   public static final int ANIM_STYLE_FADE_EXIT = 6;
   public static final int ANIM_STYLE_OPEN_ENTER = 1;
   public static final int ANIM_STYLE_OPEN_EXIT = 2;
   static boolean DEBUG = false;
   static final Interpolator DECELERATE_CUBIC;
   static final Interpolator DECELERATE_QUINT;
   static final boolean HONEYCOMB = false;
   static final String TAG = "FragmentManager";
   static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
   static final String TARGET_STATE_TAG = "android:target_state";
   static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
   static final String VIEW_STATE_TAG = "android:view_state";
   ArrayList<Fragment> mActive;
   FragmentActivity mActivity;
   ArrayList<Fragment> mAdded;
   ArrayList<Integer> mAvailBackStackIndices;
   ArrayList<Integer> mAvailIndices;
   ArrayList<BackStackRecord> mBackStack;
   ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
   ArrayList<BackStackRecord> mBackStackIndices;
   FragmentContainer mContainer;
   ArrayList<Fragment> mCreatedMenus;
   int mCurState = 0;
   boolean mDestroyed;
   Runnable mExecCommit = new Runnable() {
      public void run() {
         FragmentManagerImpl.this.execPendingActions();
      }
   };
   boolean mExecutingActions;
   boolean mHavePendingDeferredStart;
   boolean mNeedMenuInvalidate;
   String mNoTransactionsBecause;
   Fragment mParent;
   ArrayList<Runnable> mPendingActions;
   SparseArray<Parcelable> mStateArray = null;
   Bundle mStateBundle = null;
   boolean mStateSaved;
   Runnable[] mTmpActions;

   static {
      int var0 = VERSION.SDK_INT;
      boolean var1 = false;
      if(var0 >= 11) {
         var1 = true;
      }

      HONEYCOMB = var1;
      DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
      DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
      ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
      ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
   }

   private void checkStateLoss() {
      if(this.mStateSaved) {
         throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
      } else if(this.mNoTransactionsBecause != null) {
         throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
      }
   }

   static Animation makeFadeAnimation(Context var0, float var1, float var2) {
      AlphaAnimation var3 = new AlphaAnimation(var1, var2);
      var3.setInterpolator(DECELERATE_CUBIC);
      var3.setDuration(220L);
      return var3;
   }

   static Animation makeOpenCloseAnimation(Context var0, float var1, float var2, float var3, float var4) {
      AnimationSet var5 = new AnimationSet(false);
      ScaleAnimation var6 = new ScaleAnimation(var1, var2, var1, var2, 1, 0.5F, 1, 0.5F);
      var6.setInterpolator(DECELERATE_QUINT);
      var6.setDuration(220L);
      var5.addAnimation(var6);
      AlphaAnimation var7 = new AlphaAnimation(var3, var4);
      var7.setInterpolator(DECELERATE_CUBIC);
      var7.setDuration(220L);
      var5.addAnimation(var7);
      return var5;
   }

   public static int reverseTransit(int var0) {
      switch(var0) {
      case 4097:
         return 8194;
      case 4099:
         return 4099;
      case 8194:
         return 4097;
      default:
         return 0;
      }
   }

   private void throwException(RuntimeException var1) {
      Log.e("FragmentManager", var1.getMessage());
      Log.e("FragmentManager", "Activity state:");
      PrintWriter var4 = new PrintWriter(new LogWriter("FragmentManager"));
      if(this.mActivity != null) {
         try {
            this.mActivity.dump("  ", (FileDescriptor)null, var4, new String[0]);
         } catch (Exception var9) {
            Log.e("FragmentManager", "Failed dumping state", var9);
         }
      } else {
         try {
            this.dump("  ", (FileDescriptor)null, var4, new String[0]);
         } catch (Exception var8) {
            Log.e("FragmentManager", "Failed dumping state", var8);
         }
      }

      throw var1;
   }

   public static int transitToStyleIndex(int var0, boolean var1) {
      switch(var0) {
      case 4097:
         if(var1) {
            return 1;
         }

         return 2;
      case 4099:
         if(var1) {
            return 5;
         }

         return 6;
      case 8194:
         if(var1) {
            return 3;
         }

         return 4;
      default:
         return -1;
      }
   }

   void addBackStackState(BackStackRecord var1) {
      if(this.mBackStack == null) {
         this.mBackStack = new ArrayList();
      }

      this.mBackStack.add(var1);
      this.reportBackStackChanged();
   }

   public void addFragment(Fragment var1, boolean var2) {
      if(this.mAdded == null) {
         this.mAdded = new ArrayList();
      }

      if(DEBUG) {
         Log.v("FragmentManager", "add: " + var1);
      }

      this.makeActive(var1);
      if(!var1.mDetached) {
         if(this.mAdded.contains(var1)) {
            throw new IllegalStateException("Fragment already added: " + var1);
         }

         this.mAdded.add(var1);
         var1.mAdded = true;
         var1.mRemoving = false;
         if(var1.mHasMenu && var1.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
         }

         if(var2) {
            this.moveToState(var1);
         }
      }

   }

   public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener var1) {
      if(this.mBackStackChangeListeners == null) {
         this.mBackStackChangeListeners = new ArrayList();
      }

      this.mBackStackChangeListeners.add(var1);
   }

   public int allocBackStackIndex(BackStackRecord param1) {
      // $FF: Couldn't be decompiled
   }

   public void attachActivity(FragmentActivity var1, FragmentContainer var2, Fragment var3) {
      if(this.mActivity != null) {
         throw new IllegalStateException("Already attached");
      } else {
         this.mActivity = var1;
         this.mContainer = var2;
         this.mParent = var3;
      }
   }

   public void attachFragment(Fragment var1, int var2, int var3) {
      if(DEBUG) {
         Log.v("FragmentManager", "attach: " + var1);
      }

      if(var1.mDetached) {
         var1.mDetached = false;
         if(!var1.mAdded) {
            if(this.mAdded == null) {
               this.mAdded = new ArrayList();
            }

            if(this.mAdded.contains(var1)) {
               throw new IllegalStateException("Fragment already added: " + var1);
            }

            if(DEBUG) {
               Log.v("FragmentManager", "add from attach: " + var1);
            }

            this.mAdded.add(var1);
            var1.mAdded = true;
            if(var1.mHasMenu && var1.mMenuVisible) {
               this.mNeedMenuInvalidate = true;
            }

            this.moveToState(var1, this.mCurState, var2, var3, false);
         }
      }

   }

   public FragmentTransaction beginTransaction() {
      return new BackStackRecord(this);
   }

   public void detachFragment(Fragment var1, int var2, int var3) {
      if(DEBUG) {
         Log.v("FragmentManager", "detach: " + var1);
      }

      if(!var1.mDetached) {
         var1.mDetached = true;
         if(var1.mAdded) {
            if(this.mAdded != null) {
               if(DEBUG) {
                  Log.v("FragmentManager", "remove from detach: " + var1);
               }

               this.mAdded.remove(var1);
            }

            if(var1.mHasMenu && var1.mMenuVisible) {
               this.mNeedMenuInvalidate = true;
            }

            var1.mAdded = false;
            this.moveToState(var1, 1, var2, var3, false);
         }
      }

   }

   public void dispatchActivityCreated() {
      this.mStateSaved = false;
      this.moveToState(2, false);
   }

   public void dispatchConfigurationChanged(Configuration var1) {
      if(this.mAdded != null) {
         for(int var2 = 0; var2 < this.mAdded.size(); ++var2) {
            Fragment var3 = (Fragment)this.mAdded.get(var2);
            if(var3 != null) {
               var3.performConfigurationChanged(var1);
            }
         }
      }

   }

   public boolean dispatchContextItemSelected(MenuItem var1) {
      if(this.mAdded != null) {
         for(int var2 = 0; var2 < this.mAdded.size(); ++var2) {
            Fragment var3 = (Fragment)this.mAdded.get(var2);
            if(var3 != null && var3.performContextItemSelected(var1)) {
               return true;
            }
         }
      }

      return false;
   }

   public void dispatchCreate() {
      this.mStateSaved = false;
      this.moveToState(1, false);
   }

   public boolean dispatchCreateOptionsMenu(Menu var1, MenuInflater var2) {
      ArrayList var3 = this.mAdded;
      ArrayList var4 = null;
      boolean var5 = false;
      if(var3 != null) {
         for(int var8 = 0; var8 < this.mAdded.size(); ++var8) {
            Fragment var9 = (Fragment)this.mAdded.get(var8);
            if(var9 != null && var9.performCreateOptionsMenu(var1, var2)) {
               var5 = true;
               if(var4 == null) {
                  var4 = new ArrayList();
               }

               var4.add(var9);
            }
         }
      }

      if(this.mCreatedMenus != null) {
         for(int var6 = 0; var6 < this.mCreatedMenus.size(); ++var6) {
            Fragment var7 = (Fragment)this.mCreatedMenus.get(var6);
            if(var4 == null || !var4.contains(var7)) {
               var7.onDestroyOptionsMenu();
            }
         }
      }

      this.mCreatedMenus = var4;
      return var5;
   }

   public void dispatchDestroy() {
      this.mDestroyed = true;
      this.execPendingActions();
      this.moveToState(0, false);
      this.mActivity = null;
      this.mContainer = null;
      this.mParent = null;
   }

   public void dispatchDestroyView() {
      this.moveToState(1, false);
   }

   public void dispatchLowMemory() {
      if(this.mAdded != null) {
         for(int var1 = 0; var1 < this.mAdded.size(); ++var1) {
            Fragment var2 = (Fragment)this.mAdded.get(var1);
            if(var2 != null) {
               var2.performLowMemory();
            }
         }
      }

   }

   public boolean dispatchOptionsItemSelected(MenuItem var1) {
      if(this.mAdded != null) {
         for(int var2 = 0; var2 < this.mAdded.size(); ++var2) {
            Fragment var3 = (Fragment)this.mAdded.get(var2);
            if(var3 != null && var3.performOptionsItemSelected(var1)) {
               return true;
            }
         }
      }

      return false;
   }

   public void dispatchOptionsMenuClosed(Menu var1) {
      if(this.mAdded != null) {
         for(int var2 = 0; var2 < this.mAdded.size(); ++var2) {
            Fragment var3 = (Fragment)this.mAdded.get(var2);
            if(var3 != null) {
               var3.performOptionsMenuClosed(var1);
            }
         }
      }

   }

   public void dispatchPause() {
      this.moveToState(4, false);
   }

   public boolean dispatchPrepareOptionsMenu(Menu var1) {
      ArrayList var2 = this.mAdded;
      boolean var3 = false;
      if(var2 != null) {
         for(int var4 = 0; var4 < this.mAdded.size(); ++var4) {
            Fragment var5 = (Fragment)this.mAdded.get(var4);
            if(var5 != null && var5.performPrepareOptionsMenu(var1)) {
               var3 = true;
            }
         }
      }

      return var3;
   }

   public void dispatchReallyStop() {
      this.moveToState(2, false);
   }

   public void dispatchResume() {
      this.mStateSaved = false;
      this.moveToState(5, false);
   }

   public void dispatchStart() {
      this.mStateSaved = false;
      this.moveToState(4, false);
   }

   public void dispatchStop() {
      this.mStateSaved = true;
      this.moveToState(3, false);
   }

   public void dump(String param1, FileDescriptor param2, PrintWriter param3, String[] param4) {
      // $FF: Couldn't be decompiled
   }

   public void enqueueAction(Runnable param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public boolean execPendingActions() {
      // $FF: Couldn't be decompiled
   }

   public boolean executePendingTransactions() {
      return this.execPendingActions();
   }

   public Fragment findFragmentById(int var1) {
      Fragment var3;
      if(this.mAdded != null) {
         for(int var4 = -1 + this.mAdded.size(); var4 >= 0; --var4) {
            var3 = (Fragment)this.mAdded.get(var4);
            if(var3 != null && var3.mFragmentId == var1) {
               return var3;
            }
         }
      }

      if(this.mActive != null) {
         for(int var2 = -1 + this.mActive.size(); var2 >= 0; --var2) {
            var3 = (Fragment)this.mActive.get(var2);
            if(var3 != null && var3.mFragmentId == var1) {
               return var3;
            }
         }
      }

      return null;
   }

   public Fragment findFragmentByTag(String var1) {
      Fragment var3;
      if(this.mAdded != null && var1 != null) {
         for(int var4 = -1 + this.mAdded.size(); var4 >= 0; --var4) {
            var3 = (Fragment)this.mAdded.get(var4);
            if(var3 != null && var1.equals(var3.mTag)) {
               return var3;
            }
         }
      }

      if(this.mActive == null || var1 == null) {
         return null;
      } else {
         for(int var2 = -1 + this.mActive.size(); var2 >= 0; --var2) {
            var3 = (Fragment)this.mActive.get(var2);
            if(var3 != null && var1.equals(var3.mTag)) {
               return var3;
            }
         }

         return null;
      }
   }

   public Fragment findFragmentByWho(String var1) {
      if(this.mActive != null && var1 != null) {
         for(int var2 = -1 + this.mActive.size(); var2 >= 0; --var2) {
            Fragment var3 = (Fragment)this.mActive.get(var2);
            if(var3 != null) {
               Fragment var4 = var3.findFragmentByWho(var1);
               if(var4 != null) {
                  return var4;
               }
            }
         }
      }

      return null;
   }

   public void freeBackStackIndex(int param1) {
      // $FF: Couldn't be decompiled
   }

   public FragmentManager.BackStackEntry getBackStackEntryAt(int var1) {
      return (FragmentManager.BackStackEntry)this.mBackStack.get(var1);
   }

   public int getBackStackEntryCount() {
      return this.mBackStack != null?this.mBackStack.size():0;
   }

   public Fragment getFragment(Bundle var1, String var2) {
      int var3 = var1.getInt(var2, -1);
      Fragment var4;
      if(var3 == -1) {
         var4 = null;
      } else {
         if(var3 >= this.mActive.size()) {
            this.throwException(new IllegalStateException("Fragement no longer exists for key " + var2 + ": index " + var3));
         }

         var4 = (Fragment)this.mActive.get(var3);
         if(var4 == null) {
            this.throwException(new IllegalStateException("Fragement no longer exists for key " + var2 + ": index " + var3));
            return var4;
         }
      }

      return var4;
   }

   public List<Fragment> getFragments() {
      return this.mActive;
   }

   public void hideFragment(Fragment var1, int var2, int var3) {
      if(DEBUG) {
         Log.v("FragmentManager", "hide: " + var1);
      }

      if(!var1.mHidden) {
         var1.mHidden = true;
         if(var1.mView != null) {
            Animation var4 = this.loadAnimation(var1, var2, false, var3);
            if(var4 != null) {
               var1.mView.startAnimation(var4);
            }

            var1.mView.setVisibility(8);
         }

         if(var1.mAdded && var1.mHasMenu && var1.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
         }

         var1.onHiddenChanged(true);
      }

   }

   public boolean isDestroyed() {
      return this.mDestroyed;
   }

   Animation loadAnimation(Fragment var1, int var2, boolean var3, int var4) {
      Animation var5 = var1.onCreateAnimation(var2, var3, var1.mNextAnim);
      if(var5 != null) {
         return var5;
      } else {
         if(var1.mNextAnim != 0) {
            Animation var7 = AnimationUtils.loadAnimation(this.mActivity, var1.mNextAnim);
            if(var7 != null) {
               return var7;
            }
         }

         if(var2 == 0) {
            return null;
         } else {
            int var6 = transitToStyleIndex(var2, var3);
            if(var6 < 0) {
               return null;
            } else {
               switch(var6) {
               case 1:
                  return makeOpenCloseAnimation(this.mActivity, 1.125F, 1.0F, 0.0F, 1.0F);
               case 2:
                  return makeOpenCloseAnimation(this.mActivity, 1.0F, 0.975F, 1.0F, 0.0F);
               case 3:
                  return makeOpenCloseAnimation(this.mActivity, 0.975F, 1.0F, 0.0F, 1.0F);
               case 4:
                  return makeOpenCloseAnimation(this.mActivity, 1.0F, 1.075F, 1.0F, 0.0F);
               case 5:
                  return makeFadeAnimation(this.mActivity, 0.0F, 1.0F);
               case 6:
                  return makeFadeAnimation(this.mActivity, 1.0F, 0.0F);
               default:
                  if(var4 == 0 && this.mActivity.getWindow() != null) {
                     var4 = this.mActivity.getWindow().getAttributes().windowAnimations;
                  }

                  return var4 == 0?null:null;
               }
            }
         }
      }
   }

   void makeActive(Fragment var1) {
      if(var1.mIndex < 0) {
         if(this.mAvailIndices != null && this.mAvailIndices.size() > 0) {
            var1.setIndex(((Integer)this.mAvailIndices.remove(-1 + this.mAvailIndices.size())).intValue(), this.mParent);
            this.mActive.set(var1.mIndex, var1);
         } else {
            if(this.mActive == null) {
               this.mActive = new ArrayList();
            }

            var1.setIndex(this.mActive.size(), this.mParent);
            this.mActive.add(var1);
         }

         if(DEBUG) {
            Log.v("FragmentManager", "Allocated fragment index " + var1);
            return;
         }
      }

   }

   void makeInactive(Fragment var1) {
      if(var1.mIndex >= 0) {
         if(DEBUG) {
            Log.v("FragmentManager", "Freeing fragment index " + var1);
         }

         this.mActive.set(var1.mIndex, (Object)null);
         if(this.mAvailIndices == null) {
            this.mAvailIndices = new ArrayList();
         }

         this.mAvailIndices.add(Integer.valueOf(var1.mIndex));
         this.mActivity.invalidateSupportFragment(var1.mWho);
         var1.initState();
      }
   }

   void moveToState(int var1, int var2, int var3, boolean var4) {
      if(this.mActivity == null && var1 != 0) {
         throw new IllegalStateException("No activity");
      } else {
         if(var4 || this.mCurState != var1) {
            this.mCurState = var1;
            if(this.mActive != null) {
               boolean var5 = false;

               for(int var6 = 0; var6 < this.mActive.size(); ++var6) {
                  Fragment var7 = (Fragment)this.mActive.get(var6);
                  if(var7 != null) {
                     this.moveToState(var7, var1, var2, var3, false);
                     if(var7.mLoaderManager != null) {
                        var5 |= var7.mLoaderManager.hasRunningLoaders();
                     }
                  }
               }

               if(!var5) {
                  this.startPendingDeferredFragments();
               }

               if(this.mNeedMenuInvalidate && this.mActivity != null && this.mCurState == 5) {
                  this.mActivity.supportInvalidateOptionsMenu();
                  this.mNeedMenuInvalidate = false;
                  return;
               }
            }
         }

      }
   }

   void moveToState(int var1, boolean var2) {
      this.moveToState(var1, 0, 0, var2);
   }

   void moveToState(Fragment var1) {
      this.moveToState(var1, this.mCurState, 0, 0, false);
   }

   void moveToState(final Fragment var1, int var2, int var3, int var4, boolean var5) {
      if((!var1.mAdded || var1.mDetached) && var2 > 1) {
         var2 = 1;
      }

      if(var1.mRemoving && var2 > var1.mState) {
         var2 = var1.mState;
      }

      if(var1.mDeferStart && var1.mState < 4 && var2 > 3) {
         var2 = 3;
      }

      if(var1.mState < var2) {
         if(var1.mFromLayout && !var1.mInLayout) {
            return;
         }

         if(var1.mAnimatingAway != null) {
            var1.mAnimatingAway = null;
            this.moveToState(var1, var1.mStateAfterAnimating, 0, 0, true);
         }

         switch(var1.mState) {
         case 0:
            if(DEBUG) {
               Log.v("FragmentManager", "moveto CREATED: " + var1);
            }

            if(var1.mSavedFragmentState != null) {
               var1.mSavedViewState = var1.mSavedFragmentState.getSparseParcelableArray("android:view_state");
               var1.mTarget = this.getFragment(var1.mSavedFragmentState, "android:target_state");
               if(var1.mTarget != null) {
                  var1.mTargetRequestCode = var1.mSavedFragmentState.getInt("android:target_req_state", 0);
               }

               var1.mUserVisibleHint = var1.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
               if(!var1.mUserVisibleHint) {
                  var1.mDeferStart = true;
                  if(var2 > 3) {
                     var2 = 3;
                  }
               }
            }

            var1.mActivity = this.mActivity;
            var1.mParentFragment = this.mParent;
            FragmentManagerImpl var21;
            if(this.mParent != null) {
               var21 = this.mParent.mChildFragmentManager;
            } else {
               var21 = this.mActivity.mFragments;
            }

            var1.mFragmentManager = var21;
            var1.mCalled = false;
            var1.onAttach(this.mActivity);
            if(!var1.mCalled) {
               throw new SuperNotCalledException("Fragment " + var1 + " did not call through to super.onAttach()");
            }

            if(var1.mParentFragment == null) {
               this.mActivity.onAttachFragment(var1);
            }

            if(!var1.mRetaining) {
               var1.performCreate(var1.mSavedFragmentState);
            }

            var1.mRetaining = false;
            if(var1.mFromLayout) {
               var1.mView = var1.performCreateView(var1.getLayoutInflater(var1.mSavedFragmentState), (ViewGroup)null, var1.mSavedFragmentState);
               if(var1.mView != null) {
                  var1.mInnerView = var1.mView;
                  var1.mView = NoSaveStateFrameLayout.wrap(var1.mView);
                  if(var1.mHidden) {
                     var1.mView.setVisibility(8);
                  }

                  var1.onViewCreated(var1.mView, var1.mSavedFragmentState);
               } else {
                  var1.mInnerView = null;
               }
            }
         case 1:
            if(var2 > 1) {
               if(DEBUG) {
                  Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + var1);
               }

               if(!var1.mFromLayout) {
                  int var17 = var1.mContainerId;
                  ViewGroup var18 = null;
                  if(var17 != 0) {
                     var18 = (ViewGroup)this.mContainer.findViewById(var1.mContainerId);
                     if(var18 == null && !var1.mRestored) {
                        this.throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(var1.mContainerId) + " (" + var1.getResources().getResourceName(var1.mContainerId) + ") for fragment " + var1));
                     }
                  }

                  var1.mContainer = var18;
                  var1.mView = var1.performCreateView(var1.getLayoutInflater(var1.mSavedFragmentState), var18, var1.mSavedFragmentState);
                  if(var1.mView != null) {
                     var1.mInnerView = var1.mView;
                     var1.mView = NoSaveStateFrameLayout.wrap(var1.mView);
                     if(var18 != null) {
                        Animation var19 = this.loadAnimation(var1, var3, true, var4);
                        if(var19 != null) {
                           var1.mView.startAnimation(var19);
                        }

                        var18.addView(var1.mView);
                     }

                     if(var1.mHidden) {
                        var1.mView.setVisibility(8);
                     }

                     var1.onViewCreated(var1.mView, var1.mSavedFragmentState);
                  } else {
                     var1.mInnerView = null;
                  }
               }

               var1.performActivityCreated(var1.mSavedFragmentState);
               if(var1.mView != null) {
                  var1.restoreViewState(var1.mSavedFragmentState);
               }

               var1.mSavedFragmentState = null;
            }
         case 2:
         case 3:
            if(var2 > 3) {
               if(DEBUG) {
                  Log.v("FragmentManager", "moveto STARTED: " + var1);
               }

               var1.performStart();
            }
         case 4:
            if(var2 > 4) {
               if(DEBUG) {
                  Log.v("FragmentManager", "moveto RESUMED: " + var1);
               }

               var1.mResumed = true;
               var1.performResume();
               var1.mSavedFragmentState = null;
               var1.mSavedViewState = null;
            }
         }
      } else if(var1.mState > var2) {
         switch(var1.mState) {
         case 5:
            if(var2 < 5) {
               if(DEBUG) {
                  Log.v("FragmentManager", "movefrom RESUMED: " + var1);
               }

               var1.performPause();
               var1.mResumed = false;
            }
         case 4:
            if(var2 < 4) {
               if(DEBUG) {
                  Log.v("FragmentManager", "movefrom STARTED: " + var1);
               }

               var1.performStop();
            }
         case 3:
            if(var2 < 3) {
               if(DEBUG) {
                  Log.v("FragmentManager", "movefrom STOPPED: " + var1);
               }

               var1.performReallyStop();
            }
         case 2:
            if(var2 < 2) {
               if(DEBUG) {
                  Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + var1);
               }

               if(var1.mView != null && !this.mActivity.isFinishing() && var1.mSavedViewState == null) {
                  this.saveFragmentViewState(var1);
               }

               var1.performDestroyView();
               if(var1.mView != null && var1.mContainer != null) {
                  int var8 = this.mCurState;
                  Animation var9 = null;
                  if(var8 > 0) {
                     boolean var10 = this.mDestroyed;
                     var9 = null;
                     if(!var10) {
                        var9 = this.loadAnimation(var1, var3, false, var4);
                     }
                  }

                  if(var9 != null) {
                     var1.mAnimatingAway = var1.mView;
                     var1.mStateAfterAnimating = var2;
                     var9.setAnimationListener(new AnimationListener() {
                        public void onAnimationEnd(Animation var1x) {
                           if(var1.mAnimatingAway != null) {
                              var1.mAnimatingAway = null;
                              FragmentManagerImpl.this.moveToState(var1, var1.mStateAfterAnimating, 0, 0, false);
                           }

                        }

                        public void onAnimationRepeat(Animation var1x) {
                        }

                        public void onAnimationStart(Animation var1x) {
                        }
                     });
                     var1.mView.startAnimation(var9);
                  }

                  var1.mContainer.removeView(var1.mView);
               }

               var1.mContainer = null;
               var1.mView = null;
               var1.mInnerView = null;
            }
         case 1:
            if(var2 < 1) {
               if(this.mDestroyed && var1.mAnimatingAway != null) {
                  View var7 = var1.mAnimatingAway;
                  var1.mAnimatingAway = null;
                  var7.clearAnimation();
               }

               if(var1.mAnimatingAway != null) {
                  var1.mStateAfterAnimating = var2;
                  var2 = 1;
               } else {
                  if(DEBUG) {
                     Log.v("FragmentManager", "movefrom CREATED: " + var1);
                  }

                  if(!var1.mRetaining) {
                     var1.performDestroy();
                  }

                  var1.mCalled = false;
                  var1.onDetach();
                  if(!var1.mCalled) {
                     throw new SuperNotCalledException("Fragment " + var1 + " did not call through to super.onDetach()");
                  }

                  if(!var5) {
                     if(!var1.mRetaining) {
                        this.makeInactive(var1);
                     } else {
                        var1.mActivity = null;
                        var1.mFragmentManager = null;
                     }
                  }
               }
            }
         }
      }

      var1.mState = var2;
   }

   public void noteStateNotSaved() {
      this.mStateSaved = false;
   }

   public void performPendingDeferredStart(Fragment var1) {
      if(var1.mDeferStart) {
         if(!this.mExecutingActions) {
            var1.mDeferStart = false;
            this.moveToState(var1, this.mCurState, 0, 0, false);
            return;
         }

         this.mHavePendingDeferredStart = true;
      }

   }

   public void popBackStack() {
      this.enqueueAction(new Runnable() {
         public void run() {
            FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, (String)null, -1, 0);
         }
      }, false);
   }

   public void popBackStack(final int var1, final int var2) {
      if(var1 < 0) {
         throw new IllegalArgumentException("Bad id: " + var1);
      } else {
         this.enqueueAction(new Runnable() {
            public void run() {
               FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, (String)null, var1, var2);
            }
         }, false);
      }
   }

   public void popBackStack(final String var1, final int var2) {
      this.enqueueAction(new Runnable() {
         public void run() {
            FragmentManagerImpl.this.popBackStackState(FragmentManagerImpl.this.mActivity.mHandler, var1, -1, var2);
         }
      }, false);
   }

   public boolean popBackStackImmediate() {
      this.checkStateLoss();
      this.executePendingTransactions();
      return this.popBackStackState(this.mActivity.mHandler, (String)null, -1, 0);
   }

   public boolean popBackStackImmediate(int var1, int var2) {
      this.checkStateLoss();
      this.executePendingTransactions();
      if(var1 < 0) {
         throw new IllegalArgumentException("Bad id: " + var1);
      } else {
         return this.popBackStackState(this.mActivity.mHandler, (String)null, var1, var2);
      }
   }

   public boolean popBackStackImmediate(String var1, int var2) {
      this.checkStateLoss();
      this.executePendingTransactions();
      return this.popBackStackState(this.mActivity.mHandler, var1, -1, var2);
   }

   boolean popBackStackState(Handler var1, String var2, int var3, int var4) {
      if(this.mBackStack != null) {
         if(var2 == null && var3 < 0 && (var4 & 1) == 0) {
            int var16 = -1 + this.mBackStack.size();
            if(var16 < 0) {
               return false;
            }

            ((BackStackRecord)this.mBackStack.remove(var16)).popFromBackStack(true);
            this.reportBackStackChanged();
         } else {
            int var5 = -1;
            if(var2 != null || var3 >= 0) {
               for(var5 = -1 + this.mBackStack.size(); var5 >= 0; --var5) {
                  BackStackRecord var15 = (BackStackRecord)this.mBackStack.get(var5);
                  if(var2 != null && var2.equals(var15.getName()) || var3 >= 0 && var3 == var15.mIndex) {
                     break;
                  }
               }

               if(var5 < 0) {
                  return false;
               }

               if((var4 & 1) != 0) {
                  --var5;

                  while(var5 >= 0) {
                     BackStackRecord var14 = (BackStackRecord)this.mBackStack.get(var5);
                     if((var2 == null || !var2.equals(var14.getName())) && (var3 < 0 || var3 != var14.mIndex)) {
                        break;
                     }

                     --var5;
                  }
               }
            }

            if(var5 == -1 + this.mBackStack.size()) {
               return false;
            }

            ArrayList var6 = new ArrayList();

            for(int var7 = -1 + this.mBackStack.size(); var7 > var5; --var7) {
               var6.add(this.mBackStack.remove(var7));
            }

            int var8 = -1 + var6.size();

            for(int var9 = 0; var9 <= var8; ++var9) {
               if(DEBUG) {
                  Log.v("FragmentManager", "Popping back stack state: " + var6.get(var9));
               }

               BackStackRecord var10 = (BackStackRecord)var6.get(var9);
               boolean var11;
               if(var9 == var8) {
                  var11 = true;
               } else {
                  var11 = false;
               }

               var10.popFromBackStack(var11);
            }

            this.reportBackStackChanged();
         }

         return true;
      } else {
         return false;
      }
   }

   public void putFragment(Bundle var1, String var2, Fragment var3) {
      if(var3.mIndex < 0) {
         this.throwException(new IllegalStateException("Fragment " + var3 + " is not currently in the FragmentManager"));
      }

      var1.putInt(var2, var3.mIndex);
   }

   public void removeFragment(Fragment var1, int var2, int var3) {
      if(DEBUG) {
         Log.v("FragmentManager", "remove: " + var1 + " nesting=" + var1.mBackStackNesting);
      }

      boolean var4;
      if(!var1.isInBackStack()) {
         var4 = true;
      } else {
         var4 = false;
      }

      if(!var1.mDetached || var4) {
         if(this.mAdded != null) {
            this.mAdded.remove(var1);
         }

         if(var1.mHasMenu && var1.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
         }

         var1.mAdded = false;
         var1.mRemoving = true;
         byte var5;
         if(var4) {
            var5 = 0;
         } else {
            var5 = 1;
         }

         this.moveToState(var1, var5, var2, var3, false);
      }

   }

   public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener var1) {
      if(this.mBackStackChangeListeners != null) {
         this.mBackStackChangeListeners.remove(var1);
      }

   }

   void reportBackStackChanged() {
      if(this.mBackStackChangeListeners != null) {
         for(int var1 = 0; var1 < this.mBackStackChangeListeners.size(); ++var1) {
            ((FragmentManager.OnBackStackChangedListener)this.mBackStackChangeListeners.get(var1)).onBackStackChanged();
         }
      }

   }

   void restoreAllState(Parcelable var1, ArrayList<Fragment> var2) {
      if(var1 != null) {
         FragmentManagerState var3 = (FragmentManagerState)var1;
         if(var3.mActive != null) {
            if(var2 != null) {
               for(int var23 = 0; var23 < var2.size(); ++var23) {
                  Fragment var24 = (Fragment)var2.get(var23);
                  if(DEBUG) {
                     Log.v("FragmentManager", "restoreAllState: re-attaching retained " + var24);
                  }

                  FragmentState var25 = var3.mActive[var24.mIndex];
                  var25.mInstance = var24;
                  var24.mSavedViewState = null;
                  var24.mBackStackNesting = 0;
                  var24.mInLayout = false;
                  var24.mAdded = false;
                  var24.mTarget = null;
                  if(var25.mSavedFragmentState != null) {
                     var25.mSavedFragmentState.setClassLoader(this.mActivity.getClassLoader());
                     var24.mSavedViewState = var25.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                  }
               }
            }

            this.mActive = new ArrayList(var3.mActive.length);
            if(this.mAvailIndices != null) {
               this.mAvailIndices.clear();
            }

            for(int var4 = 0; var4 < var3.mActive.length; ++var4) {
               FragmentState var16 = var3.mActive[var4];
               if(var16 != null) {
                  Fragment var20 = var16.instantiate(this.mActivity, this.mParent);
                  if(DEBUG) {
                     Log.v("FragmentManager", "restoreAllState: active #" + var4 + ": " + var20);
                  }

                  this.mActive.add(var20);
                  var16.mInstance = null;
               } else {
                  this.mActive.add((Object)null);
                  if(this.mAvailIndices == null) {
                     this.mAvailIndices = new ArrayList();
                  }

                  if(DEBUG) {
                     Log.v("FragmentManager", "restoreAllState: avail #" + var4);
                  }

                  this.mAvailIndices.add(Integer.valueOf(var4));
               }
            }

            if(var2 != null) {
               for(int var13 = 0; var13 < var2.size(); ++var13) {
                  Fragment var14 = (Fragment)var2.get(var13);
                  if(var14.mTargetIndex >= 0) {
                     if(var14.mTargetIndex < this.mActive.size()) {
                        var14.mTarget = (Fragment)this.mActive.get(var14.mTargetIndex);
                     } else {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + var14 + " target no longer exists: " + var14.mTargetIndex);
                        var14.mTarget = null;
                     }
                  }
               }
            }

            if(var3.mAdded != null) {
               this.mAdded = new ArrayList(var3.mAdded.length);

               for(int var9 = 0; var9 < var3.mAdded.length; ++var9) {
                  Fragment var10 = (Fragment)this.mActive.get(var3.mAdded[var9]);
                  if(var10 == null) {
                     this.throwException(new IllegalStateException("No instantiated fragment for index #" + var3.mAdded[var9]));
                  }

                  var10.mAdded = true;
                  if(DEBUG) {
                     Log.v("FragmentManager", "restoreAllState: added #" + var9 + ": " + var10);
                  }

                  if(this.mAdded.contains(var10)) {
                     throw new IllegalStateException("Already added!");
                  }

                  this.mAdded.add(var10);
               }
            } else {
               this.mAdded = null;
            }

            if(var3.mBackStack == null) {
               this.mBackStack = null;
               return;
            }

            this.mBackStack = new ArrayList(var3.mBackStack.length);

            for(int var5 = 0; var5 < var3.mBackStack.length; ++var5) {
               BackStackRecord var6 = var3.mBackStack[var5].instantiate(this);
               if(DEBUG) {
                  Log.v("FragmentManager", "restoreAllState: back stack #" + var5 + " (index " + var6.mIndex + "): " + var6);
                  var6.dump("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
               }

               this.mBackStack.add(var6);
               if(var6.mIndex >= 0) {
                  this.setBackStackIndex(var6.mIndex, var6);
               }
            }
         }
      }

   }

   ArrayList<Fragment> retainNonConfig() {
      ArrayList var1 = this.mActive;
      ArrayList var2 = null;
      if(var1 != null) {
         for(int var3 = 0; var3 < this.mActive.size(); ++var3) {
            Fragment var4 = (Fragment)this.mActive.get(var3);
            if(var4 != null && var4.mRetainInstance) {
               if(var2 == null) {
                  var2 = new ArrayList();
               }

               var2.add(var4);
               var4.mRetaining = true;
               int var6;
               if(var4.mTarget != null) {
                  var6 = var4.mTarget.mIndex;
               } else {
                  var6 = -1;
               }

               var4.mTargetIndex = var6;
               if(DEBUG) {
                  Log.v("FragmentManager", "retainNonConfig: keeping retained " + var4);
               }
            }
         }
      }

      return var2;
   }

   Parcelable saveAllState() {
      this.execPendingActions();
      if(HONEYCOMB) {
         this.mStateSaved = true;
      }

      if(this.mActive != null && this.mActive.size() > 0) {
         int var2 = this.mActive.size();
         FragmentState[] var3 = new FragmentState[var2];
         boolean var4 = false;

         for(int var5 = 0; var5 < var2; ++var5) {
            Fragment var18 = (Fragment)this.mActive.get(var5);
            if(var18 != null) {
               if(var18.mIndex < 0) {
                  this.throwException(new IllegalStateException("Failure saving state: active " + var18 + " has cleared index: " + var18.mIndex));
               }

               var4 = true;
               FragmentState var19 = new FragmentState(var18);
               var3[var5] = var19;
               if(var18.mState > 0 && var19.mSavedFragmentState == null) {
                  var19.mSavedFragmentState = this.saveFragmentBasicState(var18);
                  if(var18.mTarget != null) {
                     if(var18.mTarget.mIndex < 0) {
                        this.throwException(new IllegalStateException("Failure saving state: " + var18 + " has target not in fragment manager: " + var18.mTarget));
                     }

                     if(var19.mSavedFragmentState == null) {
                        var19.mSavedFragmentState = new Bundle();
                     }

                     this.putFragment(var19.mSavedFragmentState, "android:target_state", var18.mTarget);
                     if(var18.mTargetRequestCode != 0) {
                        var19.mSavedFragmentState.putInt("android:target_req_state", var18.mTargetRequestCode);
                     }
                  }
               } else {
                  var19.mSavedFragmentState = var18.mSavedFragmentState;
               }

               if(DEBUG) {
                  Log.v("FragmentManager", "Saved state of " + var18 + ": " + var19.mSavedFragmentState);
               }
            }
         }

         if(var4) {
            ArrayList var6 = this.mAdded;
            int[] var7 = null;
            if(var6 != null) {
               int var14 = this.mAdded.size();
               var7 = null;
               if(var14 > 0) {
                  var7 = new int[var14];

                  for(int var15 = 0; var15 < var14; ++var15) {
                     var7[var15] = ((Fragment)this.mAdded.get(var15)).mIndex;
                     if(var7[var15] < 0) {
                        this.throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(var15) + " has cleared index: " + var7[var15]));
                     }

                     if(DEBUG) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + var15 + ": " + this.mAdded.get(var15));
                     }
                  }
               }
            }

            ArrayList var8 = this.mBackStack;
            BackStackState[] var9 = null;
            if(var8 != null) {
               int var11 = this.mBackStack.size();
               var9 = null;
               if(var11 > 0) {
                  var9 = new BackStackState[var11];

                  for(int var12 = 0; var12 < var11; ++var12) {
                     var9[var12] = new BackStackState(this, (BackStackRecord)this.mBackStack.get(var12));
                     if(DEBUG) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + var12 + ": " + this.mBackStack.get(var12));
                     }
                  }
               }
            }

            FragmentManagerState var10 = new FragmentManagerState();
            var10.mActive = var3;
            var10.mAdded = var7;
            var10.mBackStack = var9;
            return var10;
         }

         if(DEBUG) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
         }
      }

      return null;
   }

   Bundle saveFragmentBasicState(Fragment var1) {
      if(this.mStateBundle == null) {
         this.mStateBundle = new Bundle();
      }

      var1.performSaveInstanceState(this.mStateBundle);
      boolean var2 = this.mStateBundle.isEmpty();
      Bundle var3 = null;
      if(!var2) {
         var3 = this.mStateBundle;
         this.mStateBundle = null;
      }

      if(var1.mView != null) {
         this.saveFragmentViewState(var1);
      }

      if(var1.mSavedViewState != null) {
         if(var3 == null) {
            var3 = new Bundle();
         }

         var3.putSparseParcelableArray("android:view_state", var1.mSavedViewState);
      }

      if(!var1.mUserVisibleHint) {
         if(var3 == null) {
            var3 = new Bundle();
         }

         var3.putBoolean("android:user_visible_hint", var1.mUserVisibleHint);
      }

      return var3;
   }

   public Fragment.SavedState saveFragmentInstanceState(Fragment var1) {
      if(var1.mIndex < 0) {
         this.throwException(new IllegalStateException("Fragment " + var1 + " is not currently in the FragmentManager"));
      }

      int var2 = var1.mState;
      Fragment.SavedState var3 = null;
      if(var2 > 0) {
         Bundle var4 = this.saveFragmentBasicState(var1);
         var3 = null;
         if(var4 != null) {
            var3 = new Fragment.SavedState(var4);
         }
      }

      return var3;
   }

   void saveFragmentViewState(Fragment var1) {
      if(var1.mInnerView != null) {
         if(this.mStateArray == null) {
            this.mStateArray = new SparseArray();
         } else {
            this.mStateArray.clear();
         }

         var1.mInnerView.saveHierarchyState(this.mStateArray);
         if(this.mStateArray.size() > 0) {
            var1.mSavedViewState = this.mStateArray;
            this.mStateArray = null;
            return;
         }
      }

   }

   public void setBackStackIndex(int param1, BackStackRecord param2) {
      // $FF: Couldn't be decompiled
   }

   public void showFragment(Fragment var1, int var2, int var3) {
      if(DEBUG) {
         Log.v("FragmentManager", "show: " + var1);
      }

      if(var1.mHidden) {
         var1.mHidden = false;
         if(var1.mView != null) {
            Animation var4 = this.loadAnimation(var1, var2, true, var3);
            if(var4 != null) {
               var1.mView.startAnimation(var4);
            }

            var1.mView.setVisibility(0);
         }

         if(var1.mAdded && var1.mHasMenu && var1.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
         }

         var1.onHiddenChanged(false);
      }

   }

   void startPendingDeferredFragments() {
      if(this.mActive != null) {
         for(int var1 = 0; var1 < this.mActive.size(); ++var1) {
            Fragment var2 = (Fragment)this.mActive.get(var1);
            if(var2 != null) {
               this.performPendingDeferredStart(var2);
            }
         }
      }

   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(128);
      var1.append("FragmentManager{");
      var1.append(Integer.toHexString(System.identityHashCode(this)));
      var1.append(" in ");
      if(this.mParent != null) {
         DebugUtils.buildShortClassTag(this.mParent, var1);
      } else {
         DebugUtils.buildShortClassTag(this.mActivity, var1);
      }

      var1.append("}}");
      return var1.toString();
   }
}
