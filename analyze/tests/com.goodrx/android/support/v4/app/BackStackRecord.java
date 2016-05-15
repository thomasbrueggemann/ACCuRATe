package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerImpl;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentTransitionCompat21;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {
   static final int OP_ADD = 1;
   static final int OP_ATTACH = 7;
   static final int OP_DETACH = 6;
   static final int OP_HIDE = 4;
   static final int OP_NULL = 0;
   static final int OP_REMOVE = 3;
   static final int OP_REPLACE = 2;
   static final int OP_SHOW = 5;
   static final boolean SUPPORTS_TRANSITIONS = false;
   static final String TAG = "FragmentManager";
   boolean mAddToBackStack;
   boolean mAllowAddToBackStack = true;
   int mBreadCrumbShortTitleRes;
   CharSequence mBreadCrumbShortTitleText;
   int mBreadCrumbTitleRes;
   CharSequence mBreadCrumbTitleText;
   boolean mCommitted;
   int mEnterAnim;
   int mExitAnim;
   BackStackRecord.class_103 mHead;
   int mIndex = -1;
   final FragmentManagerImpl mManager;
   String mName;
   int mNumOp;
   int mPopEnterAnim;
   int mPopExitAnim;
   ArrayList<String> mSharedElementSourceNames;
   ArrayList<String> mSharedElementTargetNames;
   BackStackRecord.class_103 mTail;
   int mTransition;
   int mTransitionStyle;

   static {
      boolean var0;
      if(VERSION.SDK_INT >= 21) {
         var0 = true;
      } else {
         var0 = false;
      }

      SUPPORTS_TRANSITIONS = var0;
   }

   public BackStackRecord(FragmentManagerImpl var1) {
      this.mManager = var1;
   }

   private BackStackRecord.TransitionState beginTransition(SparseArray<Fragment> var1, SparseArray<Fragment> var2, boolean var3) {
      this.ensureFragmentsAreInitialized(var2);
      BackStackRecord.TransitionState var4 = new BackStackRecord.TransitionState();
      var4.nonExistentView = new View(this.mManager.mHost.getContext());
      boolean var5 = false;

      for(int var6 = 0; var6 < var1.size(); ++var6) {
         if(this.configureTransitions(var1.keyAt(var6), var4, var3, var1, var2)) {
            var5 = true;
         }
      }

      for(int var7 = 0; var7 < var2.size(); ++var7) {
         int var8 = var2.keyAt(var7);
         if(var1.get(var8) == null && this.configureTransitions(var8, var4, var3, var1, var2)) {
            var5 = true;
         }
      }

      if(!var5) {
         var4 = null;
      }

      return var4;
   }

   private void calculateFragments(SparseArray<Fragment> var1, SparseArray<Fragment> var2) {
      if(this.mManager.mContainer.onHasView()) {
         for(BackStackRecord.class_103 var3 = this.mHead; var3 != null; var3 = var3.next) {
            switch(var3.cmd) {
            case 1:
               this.setLastIn(var1, var2, var3.fragment);
               break;
            case 2:
               Fragment var4 = var3.fragment;
               if(this.mManager.mAdded != null) {
                  for(int var5 = 0; var5 < this.mManager.mAdded.size(); ++var5) {
                     Fragment var6 = (Fragment)this.mManager.mAdded.get(var5);
                     if(var4 == null || var6.mContainerId == var4.mContainerId) {
                        if(var6 == var4) {
                           var4 = null;
                           var2.remove(var6.mContainerId);
                        } else {
                           setFirstOut(var1, var2, var6);
                        }
                     }
                  }
               }

               this.setLastIn(var1, var2, var3.fragment);
               break;
            case 3:
               setFirstOut(var1, var2, var3.fragment);
               break;
            case 4:
               setFirstOut(var1, var2, var3.fragment);
               break;
            case 5:
               this.setLastIn(var1, var2, var3.fragment);
               break;
            case 6:
               setFirstOut(var1, var2, var3.fragment);
               break;
            case 7:
               this.setLastIn(var1, var2, var3.fragment);
            }
         }
      }

   }

   private void callSharedElementEnd(BackStackRecord.TransitionState var1, Fragment var2, Fragment var3, boolean var4, ArrayMap<String, View> var5) {
      SharedElementCallback var6;
      if(var4) {
         var6 = var3.mEnterTransitionCallback;
      } else {
         var6 = var2.mEnterTransitionCallback;
      }

      if(var6 != null) {
         var6.onSharedElementEnd(new ArrayList(var5.keySet()), new ArrayList(var5.values()), (List)null);
      }

   }

   private static Object captureExitingViews(Object var0, Fragment var1, ArrayList<View> var2, ArrayMap<String, View> var3, View var4) {
      if(var0 != null) {
         var0 = FragmentTransitionCompat21.captureExitingViews(var0, var1.getView(), var2, var3, var4);
      }

      return var0;
   }

   private boolean configureTransitions(int var1, BackStackRecord.TransitionState var2, boolean var3, SparseArray<Fragment> var4, SparseArray<Fragment> var5) {
      ViewGroup var6 = (ViewGroup)this.mManager.mContainer.onFindViewById(var1);
      if(var6 == null) {
         return false;
      } else {
         final Fragment var7 = (Fragment)var5.get(var1);
         Fragment var8 = (Fragment)var4.get(var1);
         Object var9 = getEnterTransition(var7, var3);
         Object var10 = getSharedElementTransition(var7, var8, var3);
         Object var11 = getExitTransition(var8, var3);
         ArrayList var12 = new ArrayList();
         ArrayMap var13 = null;
         if(var10 != null) {
            var13 = this.remapSharedElements(var2, var8, var3);
            if(var13.isEmpty()) {
               var10 = null;
               var13 = null;
            } else {
               SharedElementCallback var29;
               if(var3) {
                  var29 = var8.mEnterTransitionCallback;
               } else {
                  var29 = var7.mEnterTransitionCallback;
               }

               if(var29 != null) {
                  ArrayList var30 = new ArrayList(var13.keySet());
                  ArrayList var31 = new ArrayList(var13.values());
                  var29.onSharedElementStart(var30, var31, (List)null);
               }

               this.prepareSharedElementTransition(var2, var6, var10, var7, var8, var3, var12);
            }
         }

         if(var9 == null && var10 == null && var11 == null) {
            return false;
         } else {
            ArrayList var14 = new ArrayList();
            View var15 = var2.nonExistentView;
            Object var16 = captureExitingViews(var11, var8, var14, var13, var15);
            if(this.mSharedElementTargetNames != null && var13 != null) {
               Object var27 = this.mSharedElementTargetNames.get(0);
               View var28 = (View)var13.get(var27);
               if(var28 != null) {
                  if(var16 != null) {
                     FragmentTransitionCompat21.setEpicenter(var16, var28);
                  }

                  if(var10 != null) {
                     FragmentTransitionCompat21.setEpicenter(var10, var28);
                  }
               }
            }

            FragmentTransitionCompat21.ViewRetriever var17 = new FragmentTransitionCompat21.ViewRetriever() {
               public View getView() {
                  return var7.getView();
               }
            };
            ArrayList var18 = new ArrayList();
            ArrayMap var19 = new ArrayMap();
            boolean var20 = true;
            if(var7 != null) {
               if(var3) {
                  var20 = var7.getAllowReturnTransitionOverlap();
               } else {
                  var20 = var7.getAllowEnterTransitionOverlap();
               }
            }

            Object var21 = FragmentTransitionCompat21.mergeTransitions(var9, var16, var10, var20);
            if(var21 != null) {
               View var22 = var2.nonExistentView;
               FragmentTransitionCompat21.EpicenterView var23 = var2.enteringEpicenterView;
               ArrayMap var24 = var2.nameOverrides;
               FragmentTransitionCompat21.addTransitionTargets(var9, var10, var6, var17, var22, var23, var24, var18, var13, var19, var12);
               this.excludeHiddenFragmentsAfterEnter(var6, var2, var1, var21);
               FragmentTransitionCompat21.excludeTarget(var21, var2.nonExistentView, true);
               this.excludeHiddenFragments(var2, var1, var21);
               FragmentTransitionCompat21.beginDelayedTransition(var6, var21);
               View var25 = var2.nonExistentView;
               ArrayList var26 = var2.hiddenFragmentViews;
               FragmentTransitionCompat21.cleanupTransitions(var6, var25, var9, var18, var16, var14, var10, var12, var21, var26, var19);
            }

            return var21 != null;
         }
      }
   }

   private void doAddOp(int var1, Fragment var2, String var3, int var4) {
      var2.mFragmentManager = this.mManager;
      if(var3 != null) {
         if(var2.mTag != null && !var3.equals(var2.mTag)) {
            throw new IllegalStateException("Can\'t change tag of fragment " + var2 + ": was " + var2.mTag + " now " + var3);
         }

         var2.mTag = var3;
      }

      if(var1 != 0) {
         if(var2.mFragmentId != 0 && var2.mFragmentId != var1) {
            throw new IllegalStateException("Can\'t change container ID of fragment " + var2 + ": was " + var2.mFragmentId + " now " + var1);
         }

         var2.mFragmentId = var1;
         var2.mContainerId = var1;
      }

      BackStackRecord.class_103 var5 = new BackStackRecord.class_103();
      var5.cmd = var4;
      var5.fragment = var2;
      this.addOp(var5);
   }

   private void ensureFragmentsAreInitialized(SparseArray<Fragment> var1) {
      int var2 = var1.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         Fragment var4 = (Fragment)var1.valueAt(var3);
         if(var4.mState < 1) {
            this.mManager.makeActive(var4);
            this.mManager.moveToState(var4, 1, 0, 0, false);
         }
      }

   }

   private void excludeHiddenFragments(BackStackRecord.TransitionState var1, int var2, Object var3) {
      if(this.mManager.mAdded != null) {
         for(int var4 = 0; var4 < this.mManager.mAdded.size(); ++var4) {
            Fragment var5 = (Fragment)this.mManager.mAdded.get(var4);
            if(var5.mView != null && var5.mContainer != null && var5.mContainerId == var2) {
               if(var5.mHidden) {
                  if(!var1.hiddenFragmentViews.contains(var5.mView)) {
                     FragmentTransitionCompat21.excludeTarget(var3, var5.mView, true);
                     var1.hiddenFragmentViews.add(var5.mView);
                  }
               } else {
                  FragmentTransitionCompat21.excludeTarget(var3, var5.mView, false);
                  var1.hiddenFragmentViews.remove(var5.mView);
               }
            }
         }
      }

   }

   private void excludeHiddenFragmentsAfterEnter(final View var1, final BackStackRecord.TransitionState var2, final int var3, final Object var4) {
      var1.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
         public boolean onPreDraw() {
            var1.getViewTreeObserver().removeOnPreDrawListener(this);
            BackStackRecord.this.excludeHiddenFragments(var2, var3, var4);
            return true;
         }
      });
   }

   private static Object getEnterTransition(Fragment var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         Object var2;
         if(var1) {
            var2 = var0.getReenterTransition();
         } else {
            var2 = var0.getEnterTransition();
         }

         return FragmentTransitionCompat21.cloneTransition(var2);
      }
   }

   private static Object getExitTransition(Fragment var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         Object var2;
         if(var1) {
            var2 = var0.getReturnTransition();
         } else {
            var2 = var0.getExitTransition();
         }

         return FragmentTransitionCompat21.cloneTransition(var2);
      }
   }

   private static Object getSharedElementTransition(Fragment var0, Fragment var1, boolean var2) {
      if(var0 != null && var1 != null) {
         Object var3;
         if(var2) {
            var3 = var1.getSharedElementReturnTransition();
         } else {
            var3 = var0.getSharedElementEnterTransition();
         }

         return FragmentTransitionCompat21.wrapSharedElementTransition(var3);
      } else {
         return null;
      }
   }

   private ArrayMap<String, View> mapEnteringSharedElements(BackStackRecord.TransitionState var1, Fragment var2, boolean var3) {
      ArrayMap var4 = new ArrayMap();
      View var5 = var2.getView();
      if(var5 != null && this.mSharedElementSourceNames != null) {
         FragmentTransitionCompat21.findNamedViews(var4, var5);
         if(!var3) {
            var4.retainAll(this.mSharedElementTargetNames);
            return var4;
         }

         var4 = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, var4);
      }

      return var4;
   }

   private ArrayMap<String, View> mapSharedElementsIn(BackStackRecord.TransitionState var1, boolean var2, Fragment var3) {
      ArrayMap var4 = this.mapEnteringSharedElements(var1, var3, var2);
      if(var2) {
         if(var3.mExitTransitionCallback != null) {
            var3.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, var4);
         }

         this.setBackNameOverrides(var1, var4, true);
         return var4;
      } else {
         if(var3.mEnterTransitionCallback != null) {
            var3.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, var4);
         }

         this.setNameOverrides(var1, var4, true);
         return var4;
      }
   }

   private void prepareSharedElementTransition(final BackStackRecord.TransitionState var1, final View var2, final Object var3, final Fragment var4, final Fragment var5, final boolean var6, final ArrayList<View> var7) {
      var2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
         public boolean onPreDraw() {
            var2.getViewTreeObserver().removeOnPreDrawListener(this);
            if(var3 != null) {
               FragmentTransitionCompat21.removeTargets(var3, var7);
               var7.clear();
               ArrayMap var1x = BackStackRecord.this.mapSharedElementsIn(var1, var6, var4);
               FragmentTransitionCompat21.setSharedElementTargets(var3, var1.nonExistentView, var1x, var7);
               BackStackRecord.this.setEpicenterIn(var1x, var1);
               BackStackRecord.this.callSharedElementEnd(var1, var4, var5, var6, var1x);
            }

            return true;
         }
      });
   }

   private static ArrayMap<String, View> remapNames(ArrayList<String> var0, ArrayList<String> var1, ArrayMap<String, View> var2) {
      if(var2.isEmpty()) {
         return var2;
      } else {
         ArrayMap var3 = new ArrayMap();
         int var4 = var0.size();

         for(int var5 = 0; var5 < var4; ++var5) {
            View var6 = (View)var2.get(var0.get(var5));
            if(var6 != null) {
               var3.put(var1.get(var5), var6);
            }
         }

         return var3;
      }
   }

   private ArrayMap<String, View> remapSharedElements(BackStackRecord.TransitionState var1, Fragment var2, boolean var3) {
      ArrayMap var4 = new ArrayMap();
      if(this.mSharedElementSourceNames != null) {
         FragmentTransitionCompat21.findNamedViews(var4, var2.getView());
         if(var3) {
            var4.retainAll(this.mSharedElementTargetNames);
         } else {
            var4 = remapNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames, var4);
         }
      }

      if(var3) {
         if(var2.mEnterTransitionCallback != null) {
            var2.mEnterTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, var4);
         }

         this.setBackNameOverrides(var1, var4, false);
         return var4;
      } else {
         if(var2.mExitTransitionCallback != null) {
            var2.mExitTransitionCallback.onMapSharedElements(this.mSharedElementTargetNames, var4);
         }

         this.setNameOverrides(var1, var4, false);
         return var4;
      }
   }

   private void setBackNameOverrides(BackStackRecord.TransitionState var1, ArrayMap<String, View> var2, boolean var3) {
      int var4;
      if(this.mSharedElementTargetNames == null) {
         var4 = 0;
      } else {
         var4 = this.mSharedElementTargetNames.size();
      }

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = (String)this.mSharedElementSourceNames.get(var5);
         View var7 = (View)var2.get((String)this.mSharedElementTargetNames.get(var5));
         if(var7 != null) {
            String var8 = FragmentTransitionCompat21.getTransitionName(var7);
            if(var3) {
               setNameOverride(var1.nameOverrides, var6, var8);
            } else {
               setNameOverride(var1.nameOverrides, var8, var6);
            }
         }
      }

   }

   private void setEpicenterIn(ArrayMap<String, View> var1, BackStackRecord.TransitionState var2) {
      if(this.mSharedElementTargetNames != null && !var1.isEmpty()) {
         View var3 = (View)var1.get(this.mSharedElementTargetNames.get(0));
         if(var3 != null) {
            var2.enteringEpicenterView.epicenter = var3;
         }
      }

   }

   private static void setFirstOut(SparseArray<Fragment> var0, SparseArray<Fragment> var1, Fragment var2) {
      if(var2 != null) {
         int var3 = var2.mContainerId;
         if(var3 != 0 && !var2.isHidden()) {
            if(var2.isAdded() && var2.getView() != null && var0.get(var3) == null) {
               var0.put(var3, var2);
            }

            if(var1.get(var3) == var2) {
               var1.remove(var3);
            }
         }
      }

   }

   private void setLastIn(SparseArray<Fragment> var1, SparseArray<Fragment> var2, Fragment var3) {
      if(var3 != null) {
         int var4 = var3.mContainerId;
         if(var4 != 0) {
            if(!var3.isAdded()) {
               var2.put(var4, var3);
            }

            if(var1.get(var4) == var3) {
               var1.remove(var4);
            }
         }
      }

   }

   private static void setNameOverride(ArrayMap<String, String> var0, String var1, String var2) {
      if(var1 != null && var2 != null) {
         int var3 = 0;

         while(true) {
            if(var3 >= var0.size()) {
               var0.put(var1, var2);
               return;
            }

            if(var1.equals(var0.valueAt(var3))) {
               var0.setValueAt(var3, var2);
               break;
            }

            ++var3;
         }
      }

   }

   private void setNameOverrides(BackStackRecord.TransitionState var1, ArrayMap<String, View> var2, boolean var3) {
      int var4 = var2.size();

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = (String)var2.keyAt(var5);
         String var7 = FragmentTransitionCompat21.getTransitionName((View)var2.valueAt(var5));
         if(var3) {
            setNameOverride(var1.nameOverrides, var6, var7);
         } else {
            setNameOverride(var1.nameOverrides, var7, var6);
         }
      }

   }

   private static void setNameOverrides(BackStackRecord.TransitionState var0, ArrayList<String> var1, ArrayList<String> var2) {
      if(var1 != null) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            String var4 = (String)var1.get(var3);
            String var5 = (String)var2.get(var3);
            setNameOverride(var0.nameOverrides, var4, var5);
         }
      }

   }

   public FragmentTransaction add(int var1, Fragment var2) {
      this.doAddOp(var1, var2, (String)null, 1);
      return this;
   }

   public FragmentTransaction add(int var1, Fragment var2, String var3) {
      this.doAddOp(var1, var2, var3, 1);
      return this;
   }

   public FragmentTransaction add(Fragment var1, String var2) {
      this.doAddOp(0, var1, var2, 1);
      return this;
   }

   void addOp(BackStackRecord.class_103 var1) {
      if(this.mHead == null) {
         this.mTail = var1;
         this.mHead = var1;
      } else {
         var1.prev = this.mTail;
         this.mTail.next = var1;
         this.mTail = var1;
      }

      var1.enterAnim = this.mEnterAnim;
      var1.exitAnim = this.mExitAnim;
      var1.popEnterAnim = this.mPopEnterAnim;
      var1.popExitAnim = this.mPopExitAnim;
      ++this.mNumOp;
   }

   public FragmentTransaction addSharedElement(View var1, String var2) {
      if(SUPPORTS_TRANSITIONS) {
         String var3 = FragmentTransitionCompat21.getTransitionName(var1);
         if(var3 == null) {
            throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
         }

         if(this.mSharedElementSourceNames == null) {
            this.mSharedElementSourceNames = new ArrayList();
            this.mSharedElementTargetNames = new ArrayList();
         }

         this.mSharedElementSourceNames.add(var3);
         this.mSharedElementTargetNames.add(var2);
      }

      return this;
   }

   public FragmentTransaction addToBackStack(String var1) {
      if(!this.mAllowAddToBackStack) {
         throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
      } else {
         this.mAddToBackStack = true;
         this.mName = var1;
         return this;
      }
   }

   public FragmentTransaction attach(Fragment var1) {
      BackStackRecord.class_103 var2 = new BackStackRecord.class_103();
      var2.cmd = 7;
      var2.fragment = var1;
      this.addOp(var2);
      return this;
   }

   void bumpBackStackNesting(int var1) {
      if(this.mAddToBackStack) {
         if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + var1);
         }

         for(BackStackRecord.class_103 var2 = this.mHead; var2 != null; var2 = var2.next) {
            if(var2.fragment != null) {
               Fragment var6 = var2.fragment;
               var6.mBackStackNesting += var1;
               if(FragmentManagerImpl.DEBUG) {
                  Log.v("FragmentManager", "Bump nesting of " + var2.fragment + " to " + var2.fragment.mBackStackNesting);
               }
            }

            if(var2.removed != null) {
               for(int var3 = -1 + var2.removed.size(); var3 >= 0; --var3) {
                  Fragment var4 = (Fragment)var2.removed.get(var3);
                  var4.mBackStackNesting += var1;
                  if(FragmentManagerImpl.DEBUG) {
                     Log.v("FragmentManager", "Bump nesting of " + var4 + " to " + var4.mBackStackNesting);
                  }
               }
            }
         }
      }

   }

   public void calculateBackFragments(SparseArray<Fragment> var1, SparseArray<Fragment> var2) {
      if(this.mManager.mContainer.onHasView()) {
         for(BackStackRecord.class_103 var3 = this.mTail; var3 != null; var3 = var3.prev) {
            switch(var3.cmd) {
            case 1:
               setFirstOut(var1, var2, var3.fragment);
               break;
            case 2:
               if(var3.removed != null) {
                  for(int var4 = -1 + var3.removed.size(); var4 >= 0; --var4) {
                     this.setLastIn(var1, var2, (Fragment)var3.removed.get(var4));
                  }
               }

               setFirstOut(var1, var2, var3.fragment);
               break;
            case 3:
               this.setLastIn(var1, var2, var3.fragment);
               break;
            case 4:
               this.setLastIn(var1, var2, var3.fragment);
               break;
            case 5:
               setFirstOut(var1, var2, var3.fragment);
               break;
            case 6:
               this.setLastIn(var1, var2, var3.fragment);
               break;
            case 7:
               setFirstOut(var1, var2, var3.fragment);
            }
         }
      }

   }

   public int commit() {
      return this.commitInternal(false);
   }

   public int commitAllowingStateLoss() {
      return this.commitInternal(true);
   }

   int commitInternal(boolean var1) {
      if(this.mCommitted) {
         throw new IllegalStateException("commit already called");
      } else {
         if(FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Commit: " + this);
            this.dump("  ", (FileDescriptor)null, new PrintWriter(new LogWriter("FragmentManager")), (String[])null);
         }

         this.mCommitted = true;
         if(this.mAddToBackStack) {
            this.mIndex = this.mManager.allocBackStackIndex(this);
         } else {
            this.mIndex = -1;
         }

         this.mManager.enqueueAction(this, var1);
         return this.mIndex;
      }
   }

   public FragmentTransaction detach(Fragment var1) {
      BackStackRecord.class_103 var2 = new BackStackRecord.class_103();
      var2.cmd = 6;
      var2.fragment = var1;
      this.addOp(var2);
      return this;
   }

   public FragmentTransaction disallowAddToBackStack() {
      if(this.mAddToBackStack) {
         throw new IllegalStateException("This transaction is already being added to the back stack");
      } else {
         this.mAllowAddToBackStack = false;
         return this;
      }
   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      this.dump(var1, var3, true);
   }

   public void dump(String var1, PrintWriter var2, boolean var3) {
      if(var3) {
         var2.print(var1);
         var2.print("mName=");
         var2.print(this.mName);
         var2.print(" mIndex=");
         var2.print(this.mIndex);
         var2.print(" mCommitted=");
         var2.println(this.mCommitted);
         if(this.mTransition != 0) {
            var2.print(var1);
            var2.print("mTransition=#");
            var2.print(Integer.toHexString(this.mTransition));
            var2.print(" mTransitionStyle=#");
            var2.println(Integer.toHexString(this.mTransitionStyle));
         }

         if(this.mEnterAnim != 0 || this.mExitAnim != 0) {
            var2.print(var1);
            var2.print("mEnterAnim=#");
            var2.print(Integer.toHexString(this.mEnterAnim));
            var2.print(" mExitAnim=#");
            var2.println(Integer.toHexString(this.mExitAnim));
         }

         if(this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
            var2.print(var1);
            var2.print("mPopEnterAnim=#");
            var2.print(Integer.toHexString(this.mPopEnterAnim));
            var2.print(" mPopExitAnim=#");
            var2.println(Integer.toHexString(this.mPopExitAnim));
         }

         if(this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
            var2.print(var1);
            var2.print("mBreadCrumbTitleRes=#");
            var2.print(Integer.toHexString(this.mBreadCrumbTitleRes));
            var2.print(" mBreadCrumbTitleText=");
            var2.println(this.mBreadCrumbTitleText);
         }

         if(this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
            var2.print(var1);
            var2.print("mBreadCrumbShortTitleRes=#");
            var2.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
            var2.print(" mBreadCrumbShortTitleText=");
            var2.println(this.mBreadCrumbShortTitleText);
         }
      }

      if(this.mHead != null) {
         var2.print(var1);
         var2.println("Operations:");
         String var4 = var1 + "    ";
         BackStackRecord.class_103 var5 = this.mHead;

         for(int var6 = 0; var5 != null; ++var6) {
            String var7;
            switch(var5.cmd) {
            case 0:
               var7 = "NULL";
               break;
            case 1:
               var7 = "ADD";
               break;
            case 2:
               var7 = "REPLACE";
               break;
            case 3:
               var7 = "REMOVE";
               break;
            case 4:
               var7 = "HIDE";
               break;
            case 5:
               var7 = "SHOW";
               break;
            case 6:
               var7 = "DETACH";
               break;
            case 7:
               var7 = "ATTACH";
               break;
            default:
               var7 = "cmd=" + var5.cmd;
            }

            var2.print(var1);
            var2.print("  Op #");
            var2.print(var6);
            var2.print(": ");
            var2.print(var7);
            var2.print(" ");
            var2.println(var5.fragment);
            if(var3) {
               if(var5.enterAnim != 0 || var5.exitAnim != 0) {
                  var2.print(var1);
                  var2.print("enterAnim=#");
                  var2.print(Integer.toHexString(var5.enterAnim));
                  var2.print(" exitAnim=#");
                  var2.println(Integer.toHexString(var5.exitAnim));
               }

               if(var5.popEnterAnim != 0 || var5.popExitAnim != 0) {
                  var2.print(var1);
                  var2.print("popEnterAnim=#");
                  var2.print(Integer.toHexString(var5.popEnterAnim));
                  var2.print(" popExitAnim=#");
                  var2.println(Integer.toHexString(var5.popExitAnim));
               }
            }

            if(var5.removed != null && var5.removed.size() > 0) {
               for(int var8 = 0; var8 < var5.removed.size(); ++var8) {
                  var2.print(var4);
                  if(var5.removed.size() == 1) {
                     var2.print("Removed: ");
                  } else {
                     if(var8 == 0) {
                        var2.println("Removed:");
                     }

                     var2.print(var4);
                     var2.print("  #");
                     var2.print(var8);
                     var2.print(": ");
                  }

                  var2.println(var5.removed.get(var8));
               }
            }

            var5 = var5.next;
         }
      }

   }

   public CharSequence getBreadCrumbShortTitle() {
      return this.mBreadCrumbShortTitleRes != 0?this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes):this.mBreadCrumbShortTitleText;
   }

   public int getBreadCrumbShortTitleRes() {
      return this.mBreadCrumbShortTitleRes;
   }

   public CharSequence getBreadCrumbTitle() {
      return this.mBreadCrumbTitleRes != 0?this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes):this.mBreadCrumbTitleText;
   }

   public int getBreadCrumbTitleRes() {
      return this.mBreadCrumbTitleRes;
   }

   public int getId() {
      return this.mIndex;
   }

   public String getName() {
      return this.mName;
   }

   public int getTransition() {
      return this.mTransition;
   }

   public int getTransitionStyle() {
      return this.mTransitionStyle;
   }

   public FragmentTransaction hide(Fragment var1) {
      BackStackRecord.class_103 var2 = new BackStackRecord.class_103();
      var2.cmd = 4;
      var2.fragment = var1;
      this.addOp(var2);
      return this;
   }

   public boolean isAddToBackStackAllowed() {
      return this.mAllowAddToBackStack;
   }

   public boolean isEmpty() {
      return this.mNumOp == 0;
   }

   public BackStackRecord.TransitionState popFromBackStack(boolean var1, BackStackRecord.TransitionState var2, SparseArray<Fragment> var3, SparseArray<Fragment> var4) {
      if(FragmentManagerImpl.DEBUG) {
         Log.v("FragmentManager", "popFromBackStack: " + this);
         this.dump("  ", (FileDescriptor)null, new PrintWriter(new LogWriter("FragmentManager")), (String[])null);
      }

      if(SUPPORTS_TRANSITIONS) {
         if(var2 == null) {
            if(var3.size() != 0 || var4.size() != 0) {
               var2 = this.beginTransition(var3, var4, true);
            }
         } else if(!var1) {
            ArrayList var19 = this.mSharedElementTargetNames;
            ArrayList var20 = this.mSharedElementSourceNames;
            setNameOverrides(var2, var19, var20);
         }
      }

      this.bumpBackStackNesting(-1);
      int var5;
      if(var2 != null) {
         var5 = 0;
      } else {
         var5 = this.mTransitionStyle;
      }

      int var6;
      if(var2 != null) {
         var6 = 0;
      } else {
         var6 = this.mTransition;
      }

      for(BackStackRecord.class_103 var7 = this.mTail; var7 != null; var7 = var7.prev) {
         int var8;
         if(var2 != null) {
            var8 = 0;
         } else {
            var8 = var7.popEnterAnim;
         }

         int var9;
         if(var2 != null) {
            var9 = 0;
         } else {
            var9 = var7.popExitAnim;
         }

         switch(var7.cmd) {
         case 1:
            Fragment var18 = var7.fragment;
            var18.mNextAnim = var9;
            this.mManager.removeFragment(var18, FragmentManagerImpl.reverseTransit(var6), var5);
            break;
         case 2:
            Fragment var15 = var7.fragment;
            if(var15 != null) {
               var15.mNextAnim = var9;
               this.mManager.removeFragment(var15, FragmentManagerImpl.reverseTransit(var6), var5);
            }

            if(var7.removed != null) {
               for(int var16 = 0; var16 < var7.removed.size(); ++var16) {
                  Fragment var17 = (Fragment)var7.removed.get(var16);
                  var17.mNextAnim = var8;
                  this.mManager.addFragment(var17, false);
               }
            }
            break;
         case 3:
            Fragment var14 = var7.fragment;
            var14.mNextAnim = var8;
            this.mManager.addFragment(var14, false);
            break;
         case 4:
            Fragment var13 = var7.fragment;
            var13.mNextAnim = var8;
            this.mManager.showFragment(var13, FragmentManagerImpl.reverseTransit(var6), var5);
            break;
         case 5:
            Fragment var12 = var7.fragment;
            var12.mNextAnim = var9;
            this.mManager.hideFragment(var12, FragmentManagerImpl.reverseTransit(var6), var5);
            break;
         case 6:
            Fragment var11 = var7.fragment;
            var11.mNextAnim = var8;
            this.mManager.attachFragment(var11, FragmentManagerImpl.reverseTransit(var6), var5);
            break;
         case 7:
            Fragment var10 = var7.fragment;
            var10.mNextAnim = var8;
            this.mManager.detachFragment(var10, FragmentManagerImpl.reverseTransit(var6), var5);
            break;
         default:
            throw new IllegalArgumentException("Unknown cmd: " + var7.cmd);
         }
      }

      if(var1) {
         this.mManager.moveToState(this.mManager.mCurState, FragmentManagerImpl.reverseTransit(var6), var5, true);
         var2 = null;
      }

      if(this.mIndex >= 0) {
         this.mManager.freeBackStackIndex(this.mIndex);
         this.mIndex = -1;
      }

      return var2;
   }

   public FragmentTransaction remove(Fragment var1) {
      BackStackRecord.class_103 var2 = new BackStackRecord.class_103();
      var2.cmd = 3;
      var2.fragment = var1;
      this.addOp(var2);
      return this;
   }

   public FragmentTransaction replace(int var1, Fragment var2) {
      return this.replace(var1, var2, (String)null);
   }

   public FragmentTransaction replace(int var1, Fragment var2, String var3) {
      if(var1 == 0) {
         throw new IllegalArgumentException("Must use non-zero containerViewId");
      } else {
         this.doAddOp(var1, var2, var3, 2);
         return this;
      }
   }

   public void run() {
      if(FragmentManagerImpl.DEBUG) {
         Log.v("FragmentManager", "Run: " + this);
      }

      if(this.mAddToBackStack && this.mIndex < 0) {
         throw new IllegalStateException("addToBackStack() called after commit()");
      } else {
         this.bumpBackStackNesting(1);
         boolean var1 = SUPPORTS_TRANSITIONS;
         BackStackRecord.TransitionState var2 = null;
         if(var1) {
            SparseArray var3 = new SparseArray();
            SparseArray var4 = new SparseArray();
            this.calculateFragments(var3, var4);
            var2 = this.beginTransition(var3, var4, false);
         }

         int var5;
         if(var2 != null) {
            var5 = 0;
         } else {
            var5 = this.mTransitionStyle;
         }

         int var6;
         if(var2 != null) {
            var6 = 0;
         } else {
            var6 = this.mTransition;
         }

         for(BackStackRecord.class_103 var7 = this.mHead; var7 != null; var7 = var7.next) {
            int var8;
            if(var2 != null) {
               var8 = 0;
            } else {
               var8 = var7.enterAnim;
            }

            int var9;
            if(var2 != null) {
               var9 = 0;
            } else {
               var9 = var7.exitAnim;
            }

            switch(var7.cmd) {
            case 1:
               Fragment var22 = var7.fragment;
               var22.mNextAnim = var8;
               this.mManager.addFragment(var22, false);
               break;
            case 2:
               Fragment var15 = var7.fragment;
               int var16 = var15.mContainerId;
               if(this.mManager.mAdded != null) {
                  for(int var17 = -1 + this.mManager.mAdded.size(); var17 >= 0; --var17) {
                     Fragment var18 = (Fragment)this.mManager.mAdded.get(var17);
                     if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "OP_REPLACE: adding=" + var15 + " old=" + var18);
                     }

                     if(var18.mContainerId == var16) {
                        if(var18 == var15) {
                           var15 = null;
                           var7.fragment = null;
                        } else {
                           if(var7.removed == null) {
                              var7.removed = new ArrayList();
                           }

                           var7.removed.add(var18);
                           var18.mNextAnim = var9;
                           if(this.mAddToBackStack) {
                              ++var18.mBackStackNesting;
                              if(FragmentManagerImpl.DEBUG) {
                                 Log.v("FragmentManager", "Bump nesting of " + var18 + " to " + var18.mBackStackNesting);
                              }
                           }

                           this.mManager.removeFragment(var18, var6, var5);
                        }
                     }
                  }
               }

               if(var15 != null) {
                  var15.mNextAnim = var8;
                  this.mManager.addFragment(var15, false);
               }
               break;
            case 3:
               Fragment var14 = var7.fragment;
               var14.mNextAnim = var9;
               this.mManager.removeFragment(var14, var6, var5);
               break;
            case 4:
               Fragment var13 = var7.fragment;
               var13.mNextAnim = var9;
               this.mManager.hideFragment(var13, var6, var5);
               break;
            case 5:
               Fragment var12 = var7.fragment;
               var12.mNextAnim = var8;
               this.mManager.showFragment(var12, var6, var5);
               break;
            case 6:
               Fragment var11 = var7.fragment;
               var11.mNextAnim = var9;
               this.mManager.detachFragment(var11, var6, var5);
               break;
            case 7:
               Fragment var10 = var7.fragment;
               var10.mNextAnim = var8;
               this.mManager.attachFragment(var10, var6, var5);
               break;
            default:
               throw new IllegalArgumentException("Unknown cmd: " + var7.cmd);
            }
         }

         this.mManager.moveToState(this.mManager.mCurState, var6, var5, true);
         if(this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
         }

      }
   }

   public FragmentTransaction setBreadCrumbShortTitle(int var1) {
      this.mBreadCrumbShortTitleRes = var1;
      this.mBreadCrumbShortTitleText = null;
      return this;
   }

   public FragmentTransaction setBreadCrumbShortTitle(CharSequence var1) {
      this.mBreadCrumbShortTitleRes = 0;
      this.mBreadCrumbShortTitleText = var1;
      return this;
   }

   public FragmentTransaction setBreadCrumbTitle(int var1) {
      this.mBreadCrumbTitleRes = var1;
      this.mBreadCrumbTitleText = null;
      return this;
   }

   public FragmentTransaction setBreadCrumbTitle(CharSequence var1) {
      this.mBreadCrumbTitleRes = 0;
      this.mBreadCrumbTitleText = var1;
      return this;
   }

   public FragmentTransaction setCustomAnimations(int var1, int var2) {
      return this.setCustomAnimations(var1, var2, 0, 0);
   }

   public FragmentTransaction setCustomAnimations(int var1, int var2, int var3, int var4) {
      this.mEnterAnim = var1;
      this.mExitAnim = var2;
      this.mPopEnterAnim = var3;
      this.mPopExitAnim = var4;
      return this;
   }

   public FragmentTransaction setTransition(int var1) {
      this.mTransition = var1;
      return this;
   }

   public FragmentTransaction setTransitionStyle(int var1) {
      this.mTransitionStyle = var1;
      return this;
   }

   public FragmentTransaction show(Fragment var1) {
      BackStackRecord.class_103 var2 = new BackStackRecord.class_103();
      var2.cmd = 5;
      var2.fragment = var1;
      this.addOp(var2);
      return this;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(128);
      var1.append("BackStackEntry{");
      var1.append(Integer.toHexString(System.identityHashCode(this)));
      if(this.mIndex >= 0) {
         var1.append(" #");
         var1.append(this.mIndex);
      }

      if(this.mName != null) {
         var1.append(" ");
         var1.append(this.mName);
      }

      var1.append("}");
      return var1.toString();
   }

   static final class class_103 {
      int cmd;
      int enterAnim;
      int exitAnim;
      Fragment fragment;
      BackStackRecord.class_103 next;
      int popEnterAnim;
      int popExitAnim;
      BackStackRecord.class_103 prev;
      ArrayList<Fragment> removed;
   }

   public class TransitionState {
      public FragmentTransitionCompat21.EpicenterView enteringEpicenterView = new FragmentTransitionCompat21.EpicenterView();
      public ArrayList<View> hiddenFragmentViews = new ArrayList();
      public ArrayMap<String, String> nameOverrides = new ArrayMap();
      public View nonExistentView;
   }
}
