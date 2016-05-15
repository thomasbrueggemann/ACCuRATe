package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentHostCallback;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerImpl;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManagerImpl;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.app.SuperNotCalledException;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
   static final int ACTIVITY_CREATED = 2;
   static final int CREATED = 1;
   static final int INITIALIZING = 0;
   static final int RESUMED = 5;
   static final int STARTED = 4;
   static final int STOPPED = 3;
   static final Object USE_DEFAULT_TRANSITION = new Object();
   private static final SimpleArrayMap<String, Class<?>> sClassMap = new SimpleArrayMap();
   boolean mAdded;
   Boolean mAllowEnterTransitionOverlap;
   Boolean mAllowReturnTransitionOverlap;
   View mAnimatingAway;
   Bundle mArguments;
   int mBackStackNesting;
   boolean mCalled;
   boolean mCheckedForLoaderManager;
   FragmentManagerImpl mChildFragmentManager;
   ViewGroup mContainer;
   int mContainerId;
   boolean mDeferStart;
   boolean mDetached;
   Object mEnterTransition = null;
   SharedElementCallback mEnterTransitionCallback;
   Object mExitTransition;
   SharedElementCallback mExitTransitionCallback;
   int mFragmentId;
   FragmentManagerImpl mFragmentManager;
   boolean mFromLayout;
   boolean mHasMenu;
   boolean mHidden;
   FragmentHostCallback mHost;
   boolean mInLayout;
   int mIndex = -1;
   View mInnerView;
   LoaderManagerImpl mLoaderManager;
   boolean mLoadersStarted;
   boolean mMenuVisible = true;
   int mNextAnim;
   Fragment mParentFragment;
   Object mReenterTransition;
   boolean mRemoving;
   boolean mRestored;
   boolean mRetainInstance;
   boolean mRetaining;
   Object mReturnTransition;
   Bundle mSavedFragmentState;
   SparseArray<Parcelable> mSavedViewState;
   Object mSharedElementEnterTransition;
   Object mSharedElementReturnTransition;
   int mState = 0;
   int mStateAfterAnimating;
   String mTag;
   Fragment mTarget;
   int mTargetIndex = -1;
   int mTargetRequestCode;
   boolean mUserVisibleHint = true;
   View mView;
   String mWho;

   public Fragment() {
      this.mReturnTransition = USE_DEFAULT_TRANSITION;
      this.mExitTransition = null;
      this.mReenterTransition = USE_DEFAULT_TRANSITION;
      this.mSharedElementEnterTransition = null;
      this.mSharedElementReturnTransition = USE_DEFAULT_TRANSITION;
      this.mEnterTransitionCallback = null;
      this.mExitTransitionCallback = null;
   }

   public static Fragment instantiate(Context var0, String var1) {
      return instantiate(var0, var1, (Bundle)null);
   }

   public static Fragment instantiate(Context param0, String param1, @Nullable Bundle param2) {
      // $FF: Couldn't be decompiled
   }

   static boolean isSupportFragmentClass(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      var3.print(var1);
      var3.print("mFragmentId=#");
      var3.print(Integer.toHexString(this.mFragmentId));
      var3.print(" mContainerId=#");
      var3.print(Integer.toHexString(this.mContainerId));
      var3.print(" mTag=");
      var3.println(this.mTag);
      var3.print(var1);
      var3.print("mState=");
      var3.print(this.mState);
      var3.print(" mIndex=");
      var3.print(this.mIndex);
      var3.print(" mWho=");
      var3.print(this.mWho);
      var3.print(" mBackStackNesting=");
      var3.println(this.mBackStackNesting);
      var3.print(var1);
      var3.print("mAdded=");
      var3.print(this.mAdded);
      var3.print(" mRemoving=");
      var3.print(this.mRemoving);
      var3.print(" mFromLayout=");
      var3.print(this.mFromLayout);
      var3.print(" mInLayout=");
      var3.println(this.mInLayout);
      var3.print(var1);
      var3.print("mHidden=");
      var3.print(this.mHidden);
      var3.print(" mDetached=");
      var3.print(this.mDetached);
      var3.print(" mMenuVisible=");
      var3.print(this.mMenuVisible);
      var3.print(" mHasMenu=");
      var3.println(this.mHasMenu);
      var3.print(var1);
      var3.print("mRetainInstance=");
      var3.print(this.mRetainInstance);
      var3.print(" mRetaining=");
      var3.print(this.mRetaining);
      var3.print(" mUserVisibleHint=");
      var3.println(this.mUserVisibleHint);
      if(this.mFragmentManager != null) {
         var3.print(var1);
         var3.print("mFragmentManager=");
         var3.println(this.mFragmentManager);
      }

      if(this.mHost != null) {
         var3.print(var1);
         var3.print("mHost=");
         var3.println(this.mHost);
      }

      if(this.mParentFragment != null) {
         var3.print(var1);
         var3.print("mParentFragment=");
         var3.println(this.mParentFragment);
      }

      if(this.mArguments != null) {
         var3.print(var1);
         var3.print("mArguments=");
         var3.println(this.mArguments);
      }

      if(this.mSavedFragmentState != null) {
         var3.print(var1);
         var3.print("mSavedFragmentState=");
         var3.println(this.mSavedFragmentState);
      }

      if(this.mSavedViewState != null) {
         var3.print(var1);
         var3.print("mSavedViewState=");
         var3.println(this.mSavedViewState);
      }

      if(this.mTarget != null) {
         var3.print(var1);
         var3.print("mTarget=");
         var3.print(this.mTarget);
         var3.print(" mTargetRequestCode=");
         var3.println(this.mTargetRequestCode);
      }

      if(this.mNextAnim != 0) {
         var3.print(var1);
         var3.print("mNextAnim=");
         var3.println(this.mNextAnim);
      }

      if(this.mContainer != null) {
         var3.print(var1);
         var3.print("mContainer=");
         var3.println(this.mContainer);
      }

      if(this.mView != null) {
         var3.print(var1);
         var3.print("mView=");
         var3.println(this.mView);
      }

      if(this.mInnerView != null) {
         var3.print(var1);
         var3.print("mInnerView=");
         var3.println(this.mView);
      }

      if(this.mAnimatingAway != null) {
         var3.print(var1);
         var3.print("mAnimatingAway=");
         var3.println(this.mAnimatingAway);
         var3.print(var1);
         var3.print("mStateAfterAnimating=");
         var3.println(this.mStateAfterAnimating);
      }

      if(this.mLoaderManager != null) {
         var3.print(var1);
         var3.println("Loader Manager:");
         this.mLoaderManager.dump(var1 + "  ", var2, var3, var4);
      }

      if(this.mChildFragmentManager != null) {
         var3.print(var1);
         var3.println("Child " + this.mChildFragmentManager + ":");
         this.mChildFragmentManager.dump(var1 + "  ", var2, var3, var4);
      }

   }

   public final boolean equals(Object var1) {
      return super.equals(var1);
   }

   Fragment findFragmentByWho(String var1) {
      return var1.equals(this.mWho)?this:(this.mChildFragmentManager != null?this.mChildFragmentManager.findFragmentByWho(var1):null);
   }

   public final FragmentActivity getActivity() {
      return this.mHost == null?null:(FragmentActivity)this.mHost.getActivity();
   }

   public boolean getAllowEnterTransitionOverlap() {
      return this.mAllowEnterTransitionOverlap == null?true:this.mAllowEnterTransitionOverlap.booleanValue();
   }

   public boolean getAllowReturnTransitionOverlap() {
      return this.mAllowReturnTransitionOverlap == null?true:this.mAllowReturnTransitionOverlap.booleanValue();
   }

   public final Bundle getArguments() {
      return this.mArguments;
   }

   public final FragmentManager getChildFragmentManager() {
      if(this.mChildFragmentManager == null) {
         this.instantiateChildFragmentManager();
         if(this.mState >= 5) {
            this.mChildFragmentManager.dispatchResume();
         } else if(this.mState >= 4) {
            this.mChildFragmentManager.dispatchStart();
         } else if(this.mState >= 2) {
            this.mChildFragmentManager.dispatchActivityCreated();
         } else if(this.mState >= 1) {
            this.mChildFragmentManager.dispatchCreate();
         }
      }

      return this.mChildFragmentManager;
   }

   public Context getContext() {
      return this.mHost == null?null:this.mHost.getContext();
   }

   public Object getEnterTransition() {
      return this.mEnterTransition;
   }

   public Object getExitTransition() {
      return this.mExitTransition;
   }

   public final FragmentManager getFragmentManager() {
      return this.mFragmentManager;
   }

   public final Object getHost() {
      return this.mHost == null?null:this.mHost.onGetHost();
   }

   public final int getId() {
      return this.mFragmentId;
   }

   public LayoutInflater getLayoutInflater(Bundle var1) {
      LayoutInflater var2 = this.mHost.onGetLayoutInflater();
      this.getChildFragmentManager();
      LayoutInflaterCompat.setFactory(var2, this.mChildFragmentManager.getLayoutInflaterFactory());
      return var2;
   }

   public LoaderManager getLoaderManager() {
      if(this.mLoaderManager != null) {
         return this.mLoaderManager;
      } else if(this.mHost == null) {
         throw new IllegalStateException("Fragment " + this + " not attached to Activity");
      } else {
         this.mCheckedForLoaderManager = true;
         this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, true);
         return this.mLoaderManager;
      }
   }

   public final Fragment getParentFragment() {
      return this.mParentFragment;
   }

   public Object getReenterTransition() {
      return this.mReenterTransition == USE_DEFAULT_TRANSITION?this.getExitTransition():this.mReenterTransition;
   }

   public final Resources getResources() {
      if(this.mHost == null) {
         throw new IllegalStateException("Fragment " + this + " not attached to Activity");
      } else {
         return this.mHost.getContext().getResources();
      }
   }

   public final boolean getRetainInstance() {
      return this.mRetainInstance;
   }

   public Object getReturnTransition() {
      return this.mReturnTransition == USE_DEFAULT_TRANSITION?this.getEnterTransition():this.mReturnTransition;
   }

   public Object getSharedElementEnterTransition() {
      return this.mSharedElementEnterTransition;
   }

   public Object getSharedElementReturnTransition() {
      return this.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION?this.getSharedElementEnterTransition():this.mSharedElementReturnTransition;
   }

   public final String getString(@StringRes int var1) {
      return this.getResources().getString(var1);
   }

   public final String getString(@StringRes int var1, Object... var2) {
      return this.getResources().getString(var1, var2);
   }

   public final String getTag() {
      return this.mTag;
   }

   public final Fragment getTargetFragment() {
      return this.mTarget;
   }

   public final int getTargetRequestCode() {
      return this.mTargetRequestCode;
   }

   public final CharSequence getText(@StringRes int var1) {
      return this.getResources().getText(var1);
   }

   public boolean getUserVisibleHint() {
      return this.mUserVisibleHint;
   }

   @Nullable
   public View getView() {
      return this.mView;
   }

   public final boolean hasOptionsMenu() {
      return this.mHasMenu;
   }

   public final int hashCode() {
      return super.hashCode();
   }

   void initState() {
      this.mIndex = -1;
      this.mWho = null;
      this.mAdded = false;
      this.mRemoving = false;
      this.mFromLayout = false;
      this.mInLayout = false;
      this.mRestored = false;
      this.mBackStackNesting = 0;
      this.mFragmentManager = null;
      this.mChildFragmentManager = null;
      this.mHost = null;
      this.mFragmentId = 0;
      this.mContainerId = 0;
      this.mTag = null;
      this.mHidden = false;
      this.mDetached = false;
      this.mRetaining = false;
      this.mLoaderManager = null;
      this.mLoadersStarted = false;
      this.mCheckedForLoaderManager = false;
   }

   void instantiateChildFragmentManager() {
      this.mChildFragmentManager = new FragmentManagerImpl();
      this.mChildFragmentManager.attachController(this.mHost, new FragmentContainer() {
         @Nullable
         public View onFindViewById(int var1) {
            if(Fragment.this.mView == null) {
               throw new IllegalStateException("Fragment does not have a view");
            } else {
               return Fragment.this.mView.findViewById(var1);
            }
         }

         public boolean onHasView() {
            return Fragment.this.mView != null;
         }
      }, this);
   }

   public final boolean isAdded() {
      return this.mHost != null && this.mAdded;
   }

   public final boolean isDetached() {
      return this.mDetached;
   }

   public final boolean isHidden() {
      return this.mHidden;
   }

   final boolean isInBackStack() {
      return this.mBackStackNesting > 0;
   }

   public final boolean isInLayout() {
      return this.mInLayout;
   }

   public final boolean isMenuVisible() {
      return this.mMenuVisible;
   }

   public final boolean isRemoving() {
      return this.mRemoving;
   }

   public final boolean isResumed() {
      return this.mState >= 5;
   }

   public final boolean isVisible() {
      return this.isAdded() && !this.isHidden() && this.mView != null && this.mView.getWindowToken() != null && this.mView.getVisibility() == 0;
   }

   public void onActivityCreated(@Nullable Bundle var1) {
      this.mCalled = true;
   }

   public void onActivityResult(int var1, int var2, Intent var3) {
   }

   @Deprecated
   public void onAttach(Activity var1) {
      this.mCalled = true;
   }

   public void onAttach(Context var1) {
      this.mCalled = true;
      Activity var2;
      if(this.mHost == null) {
         var2 = null;
      } else {
         var2 = this.mHost.getActivity();
      }

      if(var2 != null) {
         this.mCalled = false;
         this.onAttach(var2);
      }

   }

   public void onConfigurationChanged(Configuration var1) {
      this.mCalled = true;
   }

   public boolean onContextItemSelected(MenuItem var1) {
      return false;
   }

   public void onCreate(@Nullable Bundle var1) {
      this.mCalled = true;
   }

   public Animation onCreateAnimation(int var1, boolean var2, int var3) {
      return null;
   }

   public void onCreateContextMenu(ContextMenu var1, View var2, ContextMenuInfo var3) {
      this.getActivity().onCreateContextMenu(var1, var2, var3);
   }

   public void onCreateOptionsMenu(Menu var1, MenuInflater var2) {
   }

   @Nullable
   public View onCreateView(LayoutInflater var1, @Nullable ViewGroup var2, @Nullable Bundle var3) {
      return null;
   }

   public void onDestroy() {
      this.mCalled = true;
      if(!this.mCheckedForLoaderManager) {
         this.mCheckedForLoaderManager = true;
         this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
      }

      if(this.mLoaderManager != null) {
         this.mLoaderManager.doDestroy();
      }

   }

   public void onDestroyOptionsMenu() {
   }

   public void onDestroyView() {
      this.mCalled = true;
   }

   public void onDetach() {
      this.mCalled = true;
   }

   public void onHiddenChanged(boolean var1) {
   }

   @Deprecated
   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      this.mCalled = true;
   }

   public void onInflate(Context var1, AttributeSet var2, Bundle var3) {
      this.mCalled = true;
      Activity var4;
      if(this.mHost == null) {
         var4 = null;
      } else {
         var4 = this.mHost.getActivity();
      }

      if(var4 != null) {
         this.mCalled = false;
         this.onInflate(var4, var2, var3);
      }

   }

   public void onLowMemory() {
      this.mCalled = true;
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      return false;
   }

   public void onOptionsMenuClosed(Menu var1) {
   }

   public void onPause() {
      this.mCalled = true;
   }

   public void onPrepareOptionsMenu(Menu var1) {
   }

   public void onRequestPermissionsResult(int var1, @NonNull String[] var2, @NonNull int[] var3) {
   }

   public void onResume() {
      this.mCalled = true;
   }

   public void onSaveInstanceState(Bundle var1) {
   }

   public void onStart() {
      this.mCalled = true;
      if(!this.mLoadersStarted) {
         this.mLoadersStarted = true;
         if(!this.mCheckedForLoaderManager) {
            this.mCheckedForLoaderManager = true;
            this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
         }

         if(this.mLoaderManager != null) {
            this.mLoaderManager.doStart();
         }
      }

   }

   public void onStop() {
      this.mCalled = true;
   }

   public void onViewCreated(View var1, @Nullable Bundle var2) {
   }

   public void onViewStateRestored(@Nullable Bundle var1) {
      this.mCalled = true;
   }

   void performActivityCreated(Bundle var1) {
      if(this.mChildFragmentManager != null) {
         this.mChildFragmentManager.noteStateNotSaved();
      }

      this.mState = 2;
      this.mCalled = false;
      this.onActivityCreated(var1);
      if(!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
      } else {
         if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchActivityCreated();
         }

      }
   }

   void performConfigurationChanged(Configuration var1) {
      this.onConfigurationChanged(var1);
      if(this.mChildFragmentManager != null) {
         this.mChildFragmentManager.dispatchConfigurationChanged(var1);
      }

   }

   boolean performContextItemSelected(MenuItem var1) {
      return !this.mHidden && (this.onContextItemSelected(var1) || this.mChildFragmentManager != null && this.mChildFragmentManager.dispatchContextItemSelected(var1));
   }

   void performCreate(Bundle var1) {
      if(this.mChildFragmentManager != null) {
         this.mChildFragmentManager.noteStateNotSaved();
      }

      this.mState = 1;
      this.mCalled = false;
      this.onCreate(var1);
      if(!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
      } else {
         if(var1 != null) {
            Parcelable var2 = var1.getParcelable("android:support:fragments");
            if(var2 != null) {
               if(this.mChildFragmentManager == null) {
                  this.instantiateChildFragmentManager();
               }

               this.mChildFragmentManager.restoreAllState(var2, (List)null);
               this.mChildFragmentManager.dispatchCreate();
            }
         }

      }
   }

   boolean performCreateOptionsMenu(Menu var1, MenuInflater var2) {
      boolean var3 = this.mHidden;
      boolean var4 = false;
      if(!var3) {
         boolean var5 = this.mHasMenu;
         var4 = false;
         if(var5) {
            boolean var6 = this.mMenuVisible;
            var4 = false;
            if(var6) {
               var4 = true;
               this.onCreateOptionsMenu(var1, var2);
            }
         }

         if(this.mChildFragmentManager != null) {
            var4 |= this.mChildFragmentManager.dispatchCreateOptionsMenu(var1, var2);
         }
      }

      return var4;
   }

   View performCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      if(this.mChildFragmentManager != null) {
         this.mChildFragmentManager.noteStateNotSaved();
      }

      return this.onCreateView(var1, var2, var3);
   }

   void performDestroy() {
      if(this.mChildFragmentManager != null) {
         this.mChildFragmentManager.dispatchDestroy();
      }

      this.mState = 0;
      this.mCalled = false;
      this.onDestroy();
      if(!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
      }
   }

   void performDestroyView() {
      if(this.mChildFragmentManager != null) {
         this.mChildFragmentManager.dispatchDestroyView();
      }

      this.mState = 1;
      this.mCalled = false;
      this.onDestroyView();
      if(!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
      } else {
         if(this.mLoaderManager != null) {
            this.mLoaderManager.doReportNextStart();
         }

      }
   }

   void performLowMemory() {
      this.onLowMemory();
      if(this.mChildFragmentManager != null) {
         this.mChildFragmentManager.dispatchLowMemory();
      }

   }

   boolean performOptionsItemSelected(MenuItem var1) {
      return !this.mHidden && (this.mHasMenu && this.mMenuVisible && this.onOptionsItemSelected(var1) || this.mChildFragmentManager != null && this.mChildFragmentManager.dispatchOptionsItemSelected(var1));
   }

   void performOptionsMenuClosed(Menu var1) {
      if(!this.mHidden) {
         if(this.mHasMenu && this.mMenuVisible) {
            this.onOptionsMenuClosed(var1);
         }

         if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchOptionsMenuClosed(var1);
         }
      }

   }

   void performPause() {
      if(this.mChildFragmentManager != null) {
         this.mChildFragmentManager.dispatchPause();
      }

      this.mState = 4;
      this.mCalled = false;
      this.onPause();
      if(!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
      }
   }

   boolean performPrepareOptionsMenu(Menu var1) {
      boolean var2 = this.mHidden;
      boolean var3 = false;
      if(!var2) {
         boolean var4 = this.mHasMenu;
         var3 = false;
         if(var4) {
            boolean var5 = this.mMenuVisible;
            var3 = false;
            if(var5) {
               var3 = true;
               this.onPrepareOptionsMenu(var1);
            }
         }

         if(this.mChildFragmentManager != null) {
            var3 |= this.mChildFragmentManager.dispatchPrepareOptionsMenu(var1);
         }
      }

      return var3;
   }

   void performReallyStop() {
      if(this.mChildFragmentManager != null) {
         this.mChildFragmentManager.dispatchReallyStop();
      }

      this.mState = 2;
      if(this.mLoadersStarted) {
         this.mLoadersStarted = false;
         if(!this.mCheckedForLoaderManager) {
            this.mCheckedForLoaderManager = true;
            this.mLoaderManager = this.mHost.getLoaderManager(this.mWho, this.mLoadersStarted, false);
         }

         if(this.mLoaderManager != null) {
            if(!this.mHost.getRetainLoaders()) {
               this.mLoaderManager.doStop();
               return;
            }

            this.mLoaderManager.doRetain();
         }
      }

   }

   void performResume() {
      if(this.mChildFragmentManager != null) {
         this.mChildFragmentManager.noteStateNotSaved();
         this.mChildFragmentManager.execPendingActions();
      }

      this.mState = 5;
      this.mCalled = false;
      this.onResume();
      if(!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
      } else {
         if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchResume();
            this.mChildFragmentManager.execPendingActions();
         }

      }
   }

   void performSaveInstanceState(Bundle var1) {
      this.onSaveInstanceState(var1);
      if(this.mChildFragmentManager != null) {
         Parcelable var2 = this.mChildFragmentManager.saveAllState();
         if(var2 != null) {
            var1.putParcelable("android:support:fragments", var2);
         }
      }

   }

   void performStart() {
      if(this.mChildFragmentManager != null) {
         this.mChildFragmentManager.noteStateNotSaved();
         this.mChildFragmentManager.execPendingActions();
      }

      this.mState = 4;
      this.mCalled = false;
      this.onStart();
      if(!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
      } else {
         if(this.mChildFragmentManager != null) {
            this.mChildFragmentManager.dispatchStart();
         }

         if(this.mLoaderManager != null) {
            this.mLoaderManager.doReportStart();
         }

      }
   }

   void performStop() {
      if(this.mChildFragmentManager != null) {
         this.mChildFragmentManager.dispatchStop();
      }

      this.mState = 3;
      this.mCalled = false;
      this.onStop();
      if(!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
      }
   }

   public void registerForContextMenu(View var1) {
      var1.setOnCreateContextMenuListener(this);
   }

   public final void requestPermissions(@NonNull String[] var1, int var2) {
      if(this.mHost == null) {
         throw new IllegalStateException("Fragment " + this + " not attached to Activity");
      } else {
         this.mHost.onRequestPermissionsFromFragment(this, var1, var2);
      }
   }

   final void restoreViewState(Bundle var1) {
      if(this.mSavedViewState != null) {
         this.mInnerView.restoreHierarchyState(this.mSavedViewState);
         this.mSavedViewState = null;
      }

      this.mCalled = false;
      this.onViewStateRestored(var1);
      if(!this.mCalled) {
         throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
      }
   }

   public void setAllowEnterTransitionOverlap(boolean var1) {
      this.mAllowEnterTransitionOverlap = Boolean.valueOf(var1);
   }

   public void setAllowReturnTransitionOverlap(boolean var1) {
      this.mAllowReturnTransitionOverlap = Boolean.valueOf(var1);
   }

   public void setArguments(Bundle var1) {
      if(this.mIndex >= 0) {
         throw new IllegalStateException("Fragment already active");
      } else {
         this.mArguments = var1;
      }
   }

   public void setEnterSharedElementCallback(SharedElementCallback var1) {
      this.mEnterTransitionCallback = var1;
   }

   public void setEnterTransition(Object var1) {
      this.mEnterTransition = var1;
   }

   public void setExitSharedElementCallback(SharedElementCallback var1) {
      this.mExitTransitionCallback = var1;
   }

   public void setExitTransition(Object var1) {
      this.mExitTransition = var1;
   }

   public void setHasOptionsMenu(boolean var1) {
      if(this.mHasMenu != var1) {
         this.mHasMenu = var1;
         if(this.isAdded() && !this.isHidden()) {
            this.mHost.onSupportInvalidateOptionsMenu();
         }
      }

   }

   final void setIndex(int var1, Fragment var2) {
      this.mIndex = var1;
      if(var2 != null) {
         this.mWho = var2.mWho + ":" + this.mIndex;
      } else {
         this.mWho = "android:fragment:" + this.mIndex;
      }
   }

   public void setInitialSavedState(Fragment.SavedState var1) {
      if(this.mIndex >= 0) {
         throw new IllegalStateException("Fragment already active");
      } else {
         Bundle var2;
         if(var1 != null && var1.mState != null) {
            var2 = var1.mState;
         } else {
            var2 = null;
         }

         this.mSavedFragmentState = var2;
      }
   }

   public void setMenuVisibility(boolean var1) {
      if(this.mMenuVisible != var1) {
         this.mMenuVisible = var1;
         if(this.mHasMenu && this.isAdded() && !this.isHidden()) {
            this.mHost.onSupportInvalidateOptionsMenu();
         }
      }

   }

   public void setReenterTransition(Object var1) {
      this.mReenterTransition = var1;
   }

   public void setRetainInstance(boolean var1) {
      if(var1 && this.mParentFragment != null) {
         throw new IllegalStateException("Can\'t retain fragements that are nested in other fragments");
      } else {
         this.mRetainInstance = var1;
      }
   }

   public void setReturnTransition(Object var1) {
      this.mReturnTransition = var1;
   }

   public void setSharedElementEnterTransition(Object var1) {
      this.mSharedElementEnterTransition = var1;
   }

   public void setSharedElementReturnTransition(Object var1) {
      this.mSharedElementReturnTransition = var1;
   }

   public void setTargetFragment(Fragment var1, int var2) {
      this.mTarget = var1;
      this.mTargetRequestCode = var2;
   }

   public void setUserVisibleHint(boolean var1) {
      if(!this.mUserVisibleHint && var1 && this.mState < 4) {
         this.mFragmentManager.performPendingDeferredStart(this);
      }

      this.mUserVisibleHint = var1;
      boolean var2;
      if(!var1) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mDeferStart = var2;
   }

   public boolean shouldShowRequestPermissionRationale(@NonNull String var1) {
      return this.mHost != null?this.mHost.onShouldShowRequestPermissionRationale(var1):false;
   }

   public void startActivity(Intent var1) {
      this.startActivity(var1, (Bundle)null);
   }

   public void startActivity(Intent var1, @Nullable Bundle var2) {
      if(this.mHost == null) {
         throw new IllegalStateException("Fragment " + this + " not attached to Activity");
      } else {
         this.mHost.onStartActivityFromFragment(this, var1, -1, var2);
      }
   }

   public void startActivityForResult(Intent var1, int var2) {
      this.startActivityForResult(var1, var2, (Bundle)null);
   }

   public void startActivityForResult(Intent var1, int var2, @Nullable Bundle var3) {
      if(this.mHost == null) {
         throw new IllegalStateException("Fragment " + this + " not attached to Activity");
      } else {
         this.mHost.onStartActivityFromFragment(this, var1, var2, var3);
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(128);
      DebugUtils.buildShortClassTag(this, var1);
      if(this.mIndex >= 0) {
         var1.append(" #");
         var1.append(this.mIndex);
      }

      if(this.mFragmentId != 0) {
         var1.append(" id=0x");
         var1.append(Integer.toHexString(this.mFragmentId));
      }

      if(this.mTag != null) {
         var1.append(" ");
         var1.append(this.mTag);
      }

      var1.append('}');
      return var1.toString();
   }

   public void unregisterForContextMenu(View var1) {
      var1.setOnCreateContextMenuListener((OnCreateContextMenuListener)null);
   }

   public static class InstantiationException extends RuntimeException {
      public InstantiationException(String var1, Exception var2) {
         super(var1, var2);
      }
   }

   public static class SavedState implements Parcelable {
      public static final Creator<Fragment.SavedState> CREATOR = new Creator() {
         public Fragment.SavedState createFromParcel(Parcel var1) {
            return new Fragment.SavedState(var1, (ClassLoader)null);
         }

         public Fragment.SavedState[] newArray(int var1) {
            return new Fragment.SavedState[var1];
         }
      };
      final Bundle mState;

      SavedState(Bundle var1) {
         this.mState = var1;
      }

      SavedState(Parcel var1, ClassLoader var2) {
         this.mState = var1.readBundle();
         if(var2 != null && this.mState != null) {
            this.mState.setClassLoader(var2);
         }

      }

      public int describeContents() {
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeBundle(this.mState);
      }
   }
}
