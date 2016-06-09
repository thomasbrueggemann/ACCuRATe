package android.support.v4.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerImpl;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.LogWriter;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {
   static final int OP_ADD = 1;
   static final int OP_ATTACH = 7;
   static final int OP_DETACH = 6;
   static final int OP_HIDE = 4;
   static final int OP_NULL = 0;
   static final int OP_REMOVE = 3;
   static final int OP_REPLACE = 2;
   static final int OP_SHOW = 5;
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
   BackStackRecord.class_11 mHead;
   int mIndex = -1;
   final FragmentManagerImpl mManager;
   String mName;
   int mNumOp;
   int mPopEnterAnim;
   int mPopExitAnim;
   BackStackRecord.class_11 mTail;
   int mTransition;
   int mTransitionStyle;

   public BackStackRecord(FragmentManagerImpl var1) {
      this.mManager = var1;
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

      BackStackRecord.class_11 var5 = new BackStackRecord.class_11();
      var5.cmd = var4;
      var5.fragment = var2;
      this.addOp(var5);
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

   void addOp(BackStackRecord.class_11 var1) {
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
      BackStackRecord.class_11 var2 = new BackStackRecord.class_11();
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

         for(BackStackRecord.class_11 var2 = this.mHead; var2 != null; var2 = var2.next) {
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
      BackStackRecord.class_11 var2 = new BackStackRecord.class_11();
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
         BackStackRecord.class_11 var5 = this.mHead;

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
      return this.mBreadCrumbShortTitleRes != 0?this.mManager.mActivity.getText(this.mBreadCrumbShortTitleRes):this.mBreadCrumbShortTitleText;
   }

   public int getBreadCrumbShortTitleRes() {
      return this.mBreadCrumbShortTitleRes;
   }

   public CharSequence getBreadCrumbTitle() {
      return this.mBreadCrumbTitleRes != 0?this.mManager.mActivity.getText(this.mBreadCrumbTitleRes):this.mBreadCrumbTitleText;
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
      BackStackRecord.class_11 var2 = new BackStackRecord.class_11();
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

   public void popFromBackStack(boolean var1) {
      if(FragmentManagerImpl.DEBUG) {
         Log.v("FragmentManager", "popFromBackStack: " + this);
         this.dump("  ", (FileDescriptor)null, new PrintWriter(new LogWriter("FragmentManager")), (String[])null);
      }

      this.bumpBackStackNesting(-1);

      for(BackStackRecord.class_11 var2 = this.mTail; var2 != null; var2 = var2.prev) {
         switch(var2.cmd) {
         case 1:
            Fragment var11 = var2.fragment;
            var11.mNextAnim = var2.popExitAnim;
            this.mManager.removeFragment(var11, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
            break;
         case 2:
            Fragment var8 = var2.fragment;
            if(var8 != null) {
               var8.mNextAnim = var2.popExitAnim;
               this.mManager.removeFragment(var8, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
            }

            if(var2.removed != null) {
               for(int var9 = 0; var9 < var2.removed.size(); ++var9) {
                  Fragment var10 = (Fragment)var2.removed.get(var9);
                  var10.mNextAnim = var2.popEnterAnim;
                  this.mManager.addFragment(var10, false);
               }
            }
            break;
         case 3:
            Fragment var7 = var2.fragment;
            var7.mNextAnim = var2.popEnterAnim;
            this.mManager.addFragment(var7, false);
            break;
         case 4:
            Fragment var6 = var2.fragment;
            var6.mNextAnim = var2.popEnterAnim;
            this.mManager.showFragment(var6, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
            break;
         case 5:
            Fragment var5 = var2.fragment;
            var5.mNextAnim = var2.popExitAnim;
            this.mManager.hideFragment(var5, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
            break;
         case 6:
            Fragment var4 = var2.fragment;
            var4.mNextAnim = var2.popEnterAnim;
            this.mManager.attachFragment(var4, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
            break;
         case 7:
            Fragment var3 = var2.fragment;
            var3.mNextAnim = var2.popEnterAnim;
            this.mManager.detachFragment(var3, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
            break;
         default:
            throw new IllegalArgumentException("Unknown cmd: " + var2.cmd);
         }
      }

      if(var1) {
         this.mManager.moveToState(this.mManager.mCurState, FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle, true);
      }

      if(this.mIndex >= 0) {
         this.mManager.freeBackStackIndex(this.mIndex);
         this.mIndex = -1;
      }

   }

   public FragmentTransaction remove(Fragment var1) {
      BackStackRecord.class_11 var2 = new BackStackRecord.class_11();
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

         for(BackStackRecord.class_11 var1 = this.mHead; var1 != null; var1 = var1.next) {
            switch(var1.cmd) {
            case 1:
               Fragment var13 = var1.fragment;
               var13.mNextAnim = var1.enterAnim;
               this.mManager.addFragment(var13, false);
               break;
            case 2:
               Fragment var7 = var1.fragment;
               if(this.mManager.mAdded != null) {
                  for(int var8 = 0; var8 < this.mManager.mAdded.size(); ++var8) {
                     Fragment var9 = (Fragment)this.mManager.mAdded.get(var8);
                     if(FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "OP_REPLACE: adding=" + var7 + " old=" + var9);
                     }

                     if(var7 == null || var9.mContainerId == var7.mContainerId) {
                        if(var9 == var7) {
                           var7 = null;
                           var1.fragment = null;
                        } else {
                           if(var1.removed == null) {
                              var1.removed = new ArrayList();
                           }

                           var1.removed.add(var9);
                           var9.mNextAnim = var1.exitAnim;
                           if(this.mAddToBackStack) {
                              ++var9.mBackStackNesting;
                              if(FragmentManagerImpl.DEBUG) {
                                 Log.v("FragmentManager", "Bump nesting of " + var9 + " to " + var9.mBackStackNesting);
                              }
                           }

                           this.mManager.removeFragment(var9, this.mTransition, this.mTransitionStyle);
                        }
                     }
                  }
               }

               if(var7 != null) {
                  var7.mNextAnim = var1.enterAnim;
                  this.mManager.addFragment(var7, false);
               }
               break;
            case 3:
               Fragment var6 = var1.fragment;
               var6.mNextAnim = var1.exitAnim;
               this.mManager.removeFragment(var6, this.mTransition, this.mTransitionStyle);
               break;
            case 4:
               Fragment var5 = var1.fragment;
               var5.mNextAnim = var1.exitAnim;
               this.mManager.hideFragment(var5, this.mTransition, this.mTransitionStyle);
               break;
            case 5:
               Fragment var4 = var1.fragment;
               var4.mNextAnim = var1.enterAnim;
               this.mManager.showFragment(var4, this.mTransition, this.mTransitionStyle);
               break;
            case 6:
               Fragment var3 = var1.fragment;
               var3.mNextAnim = var1.exitAnim;
               this.mManager.detachFragment(var3, this.mTransition, this.mTransitionStyle);
               break;
            case 7:
               Fragment var2 = var1.fragment;
               var2.mNextAnim = var1.enterAnim;
               this.mManager.attachFragment(var2, this.mTransition, this.mTransitionStyle);
               break;
            default:
               throw new IllegalArgumentException("Unknown cmd: " + var1.cmd);
            }
         }

         this.mManager.moveToState(this.mManager.mCurState, this.mTransition, this.mTransitionStyle, true);
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
      BackStackRecord.class_11 var2 = new BackStackRecord.class_11();
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

   static final class class_11 {
      int cmd;
      int enterAnim;
      int exitAnim;
      Fragment fragment;
      BackStackRecord.class_11 next;
      int popEnterAnim;
      int popExitAnim;
      BackStackRecord.class_11 prev;
      ArrayList<Fragment> removed;
   }
}
