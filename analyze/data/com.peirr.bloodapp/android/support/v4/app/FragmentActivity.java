package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityCompatHoneycomb;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerImpl;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManagerImpl;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FragmentActivity extends Activity {
   static final String FRAGMENTS_TAG = "android:support:fragments";
   private static final int HONEYCOMB = 11;
   static final int MSG_REALLY_STOPPED = 1;
   static final int MSG_RESUME_PENDING = 2;
   private static final String TAG = "FragmentActivity";
   SimpleArrayMap<String, LoaderManagerImpl> mAllLoaderManagers;
   boolean mCheckedForLoaderManager;
   final FragmentContainer mContainer = new FragmentContainer() {
      public View findViewById(int var1) {
         return FragmentActivity.this.findViewById(var1);
      }
   };
   boolean mCreated;
   final FragmentManagerImpl mFragments = new FragmentManagerImpl();
   final Handler mHandler = new Handler() {
      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            if(FragmentActivity.this.mStopped) {
               FragmentActivity.this.doReallyStop(false);
               return;
            }
            break;
         case 2:
            FragmentActivity.this.onResumeFragments();
            FragmentActivity.this.mFragments.execPendingActions();
            return;
         default:
            super.handleMessage(var1);
         }

      }
   };
   LoaderManagerImpl mLoaderManager;
   boolean mLoadersStarted;
   boolean mOptionsMenuInvalidated;
   boolean mReallyStopped;
   boolean mResumed;
   boolean mRetaining;
   boolean mStopped;

   private void dumpViewHierarchy(String var1, PrintWriter var2, View var3) {
      var2.print(var1);
      if(var3 == null) {
         var2.println("null");
      } else {
         var2.println(viewToString(var3));
         if(var3 instanceof ViewGroup) {
            ViewGroup var4 = (ViewGroup)var3;
            int var5 = var4.getChildCount();
            if(var5 > 0) {
               String var6 = var1 + "  ";

               for(int var7 = 0; var7 < var5; ++var7) {
                  this.dumpViewHierarchy(var6, var2, var4.getChildAt(var7));
               }
            }
         }
      }

   }

   private static String viewToString(View param0) {
      // $FF: Couldn't be decompiled
   }

   void doReallyStop(boolean var1) {
      if(!this.mReallyStopped) {
         this.mReallyStopped = true;
         this.mRetaining = var1;
         this.mHandler.removeMessages(1);
         this.onReallyStop();
      }

   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      if(VERSION.SDK_INT >= 11) {
         ;
      }

      var3.print(var1);
      var3.print("Local FragmentActivity ");
      var3.print(Integer.toHexString(System.identityHashCode(this)));
      var3.println(" State:");
      String var5 = var1 + "  ";
      var3.print(var5);
      var3.print("mCreated=");
      var3.print(this.mCreated);
      var3.print("mResumed=");
      var3.print(this.mResumed);
      var3.print(" mStopped=");
      var3.print(this.mStopped);
      var3.print(" mReallyStopped=");
      var3.println(this.mReallyStopped);
      var3.print(var5);
      var3.print("mLoadersStarted=");
      var3.println(this.mLoadersStarted);
      if(this.mLoaderManager != null) {
         var3.print(var1);
         var3.print("Loader Manager ");
         var3.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
         var3.println(":");
         this.mLoaderManager.dump(var1 + "  ", var2, var3, var4);
      }

      this.mFragments.dump(var1, var2, var3, var4);
      var3.print(var1);
      var3.println("View Hierarchy:");
      this.dumpViewHierarchy(var1 + "  ", var3, this.getWindow().getDecorView());
   }

   public Object getLastCustomNonConfigurationInstance() {
      FragmentActivity.NonConfigurationInstances var1 = (FragmentActivity.NonConfigurationInstances)this.getLastNonConfigurationInstance();
      return var1 != null?var1.custom:null;
   }

   LoaderManagerImpl getLoaderManager(String var1, boolean var2, boolean var3) {
      if(this.mAllLoaderManagers == null) {
         this.mAllLoaderManagers = new SimpleArrayMap();
      }

      LoaderManagerImpl var4 = (LoaderManagerImpl)this.mAllLoaderManagers.get(var1);
      if(var4 == null) {
         if(var3) {
            var4 = new LoaderManagerImpl(var1, this, var2);
            this.mAllLoaderManagers.put(var1, var4);
         }

         return var4;
      } else {
         var4.updateActivity(this);
         return var4;
      }
   }

   public FragmentManager getSupportFragmentManager() {
      return this.mFragments;
   }

   public LoaderManager getSupportLoaderManager() {
      if(this.mLoaderManager != null) {
         return this.mLoaderManager;
      } else {
         this.mCheckedForLoaderManager = true;
         this.mLoaderManager = this.getLoaderManager("(root)", this.mLoadersStarted, true);
         return this.mLoaderManager;
      }
   }

   void invalidateSupportFragment(String var1) {
      if(this.mAllLoaderManagers != null) {
         LoaderManagerImpl var2 = (LoaderManagerImpl)this.mAllLoaderManagers.get(var1);
         if(var2 != null && !var2.mRetaining) {
            var2.doDestroy();
            this.mAllLoaderManagers.remove(var1);
         }
      }

   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      this.mFragments.noteStateNotSaved();
      int var4 = var1 >> 16;
      if(var4 != 0) {
         int var5 = var4 - 1;
         if(this.mFragments.mActive != null && var5 >= 0 && var5 < this.mFragments.mActive.size()) {
            Fragment var7 = (Fragment)this.mFragments.mActive.get(var5);
            if(var7 == null) {
               Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(var1));
            } else {
               var7.onActivityResult('\uffff' & var1, var2, var3);
            }
         } else {
            Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(var1));
         }
      } else {
         super.onActivityResult(var1, var2, var3);
      }
   }

   public void onAttachFragment(Fragment var1) {
   }

   public void onBackPressed() {
      if(!this.mFragments.popBackStackImmediate()) {
         this.finish();
      }

   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.mFragments.dispatchConfigurationChanged(var1);
   }

   protected void onCreate(Bundle var1) {
      this.mFragments.attachActivity(this, this.mContainer, (Fragment)null);
      if(this.getLayoutInflater().getFactory() == null) {
         this.getLayoutInflater().setFactory(this);
      }

      super.onCreate(var1);
      FragmentActivity.NonConfigurationInstances var2 = (FragmentActivity.NonConfigurationInstances)this.getLastNonConfigurationInstance();
      if(var2 != null) {
         this.mAllLoaderManagers = var2.loaders;
      }

      if(var1 != null) {
         Parcelable var3 = var1.getParcelable("android:support:fragments");
         FragmentManagerImpl var4 = this.mFragments;
         ArrayList var5 = null;
         if(var2 != null) {
            var5 = var2.fragments;
         }

         var4.restoreAllState(var3, var5);
      }

      this.mFragments.dispatchCreate();
   }

   public boolean onCreatePanelMenu(int var1, Menu var2) {
      if(var1 == 0) {
         boolean var3 = super.onCreatePanelMenu(var1, var2) | this.mFragments.dispatchCreateOptionsMenu(var2, this.getMenuInflater());
         return VERSION.SDK_INT >= 11?var3:true;
      } else {
         return super.onCreatePanelMenu(var1, var2);
      }
   }

   public View onCreateView(String var1, Context var2, AttributeSet var3) {
      if(!"fragment".equals(var1)) {
         return super.onCreateView(var1, var2, var3);
      } else {
         String var4 = var3.getAttributeValue((String)null, "class");
         TypedArray var5 = var2.obtainStyledAttributes(var3, FragmentActivity.FragmentTag.Fragment);
         if(var4 == null) {
            var4 = var5.getString(0);
         }

         int var6 = var5.getResourceId(1, -1);
         String var7 = var5.getString(2);
         var5.recycle();
         if(!Fragment.isSupportFragmentClass(this, var4)) {
            return super.onCreateView(var1, var2, var3);
         } else {
            int var8 = 0;
            if(false) {
               var8 = null.getId();
            }

            if(var8 == -1 && var6 == -1 && var7 == null) {
               throw new IllegalArgumentException(var3.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + var4);
            } else {
               Fragment var9 = null;
               if(var6 != -1) {
                  var9 = this.mFragments.findFragmentById(var6);
               }

               if(var9 == null && var7 != null) {
                  var9 = this.mFragments.findFragmentByTag(var7);
               }

               if(var9 == null && var8 != -1) {
                  var9 = this.mFragments.findFragmentById(var8);
               }

               if(FragmentManagerImpl.DEBUG) {
                  Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(var6) + " fname=" + var4 + " existing=" + var9);
               }

               if(var9 == null) {
                  var9 = Fragment.instantiate(this, var4);
                  var9.mFromLayout = true;
                  int var10;
                  if(var6 != 0) {
                     var10 = var6;
                  } else {
                     var10 = var8;
                  }

                  var9.mFragmentId = var10;
                  var9.mContainerId = var8;
                  var9.mTag = var7;
                  var9.mInLayout = true;
                  var9.mFragmentManager = this.mFragments;
                  var9.onInflate(this, var3, var9.mSavedFragmentState);
                  this.mFragments.addFragment(var9, true);
               } else {
                  if(var9.mInLayout) {
                     throw new IllegalArgumentException(var3.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(var6) + ", tag " + var7 + ", or parent id 0x" + Integer.toHexString(var8) + " with another fragment for " + var4);
                  }

                  var9.mInLayout = true;
                  if(!var9.mRetaining) {
                     var9.onInflate(this, var3, var9.mSavedFragmentState);
                  }

                  this.mFragments.moveToState(var9);
               }

               if(var9.mView == null) {
                  throw new IllegalStateException("Fragment " + var4 + " did not create a view.");
               } else {
                  if(var6 != 0) {
                     var9.mView.setId(var6);
                  }

                  if(var9.mView.getTag() == null) {
                     var9.mView.setTag(var7);
                  }

                  return var9.mView;
               }
            }
         }
      }
   }

   protected void onDestroy() {
      super.onDestroy();
      this.doReallyStop(false);
      this.mFragments.dispatchDestroy();
      if(this.mLoaderManager != null) {
         this.mLoaderManager.doDestroy();
      }

   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(VERSION.SDK_INT < 5 && var1 == 4 && var2.getRepeatCount() == 0) {
         this.onBackPressed();
         return true;
      } else {
         return super.onKeyDown(var1, var2);
      }
   }

   public void onLowMemory() {
      super.onLowMemory();
      this.mFragments.dispatchLowMemory();
   }

   public boolean onMenuItemSelected(int var1, MenuItem var2) {
      if(super.onMenuItemSelected(var1, var2)) {
         return true;
      } else {
         switch(var1) {
         case 0:
            return this.mFragments.dispatchOptionsItemSelected(var2);
         case 6:
            return this.mFragments.dispatchContextItemSelected(var2);
         default:
            return false;
         }
      }
   }

   protected void onNewIntent(Intent var1) {
      super.onNewIntent(var1);
      this.mFragments.noteStateNotSaved();
   }

   public void onPanelClosed(int var1, Menu var2) {
      switch(var1) {
      case 0:
         this.mFragments.dispatchOptionsMenuClosed(var2);
      default:
         super.onPanelClosed(var1, var2);
      }
   }

   protected void onPause() {
      super.onPause();
      this.mResumed = false;
      if(this.mHandler.hasMessages(2)) {
         this.mHandler.removeMessages(2);
         this.onResumeFragments();
      }

      this.mFragments.dispatchPause();
   }

   protected void onPostResume() {
      super.onPostResume();
      this.mHandler.removeMessages(2);
      this.onResumeFragments();
      this.mFragments.execPendingActions();
   }

   protected boolean onPrepareOptionsPanel(View var1, Menu var2) {
      return super.onPreparePanel(0, var1, var2);
   }

   public boolean onPreparePanel(int var1, View var2, Menu var3) {
      if(var1 == 0 && var3 != null) {
         if(this.mOptionsMenuInvalidated) {
            this.mOptionsMenuInvalidated = false;
            var3.clear();
            this.onCreatePanelMenu(var1, var3);
         }

         return this.onPrepareOptionsPanel(var2, var3) | this.mFragments.dispatchPrepareOptionsMenu(var3);
      } else {
         return super.onPreparePanel(var1, var2, var3);
      }
   }

   void onReallyStop() {
      if(this.mLoadersStarted) {
         this.mLoadersStarted = false;
         if(this.mLoaderManager != null) {
            if(!this.mRetaining) {
               this.mLoaderManager.doStop();
            } else {
               this.mLoaderManager.doRetain();
            }
         }
      }

      this.mFragments.dispatchReallyStop();
   }

   protected void onResume() {
      super.onResume();
      this.mHandler.sendEmptyMessage(2);
      this.mResumed = true;
      this.mFragments.execPendingActions();
   }

   protected void onResumeFragments() {
      this.mFragments.dispatchResume();
   }

   public Object onRetainCustomNonConfigurationInstance() {
      return null;
   }

   public final Object onRetainNonConfigurationInstance() {
      if(this.mStopped) {
         this.doReallyStop(true);
      }

      Object var1 = this.onRetainCustomNonConfigurationInstance();
      ArrayList var2 = this.mFragments.retainNonConfig();
      SimpleArrayMap var3 = this.mAllLoaderManagers;
      boolean var4 = false;
      if(var3 != null) {
         int var6 = this.mAllLoaderManagers.size();
         LoaderManagerImpl[] var7 = new LoaderManagerImpl[var6];

         for(int var8 = var6 - 1; var8 >= 0; --var8) {
            var7[var8] = (LoaderManagerImpl)this.mAllLoaderManagers.valueAt(var8);
         }

         for(int var9 = 0; var9 < var6; ++var9) {
            LoaderManagerImpl var10 = var7[var9];
            if(var10.mRetaining) {
               var4 = true;
            } else {
               var10.doDestroy();
               this.mAllLoaderManagers.remove(var10.mWho);
            }
         }
      }

      if(var2 == null && !var4 && var1 == null) {
         return null;
      } else {
         FragmentActivity.NonConfigurationInstances var5 = new FragmentActivity.NonConfigurationInstances();
         var5.activity = null;
         var5.custom = var1;
         var5.children = null;
         var5.fragments = var2;
         var5.loaders = this.mAllLoaderManagers;
         return var5;
      }
   }

   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      Parcelable var2 = this.mFragments.saveAllState();
      if(var2 != null) {
         var1.putParcelable("android:support:fragments", var2);
      }

   }

   protected void onStart() {
      super.onStart();
      this.mStopped = false;
      this.mReallyStopped = false;
      this.mHandler.removeMessages(1);
      if(!this.mCreated) {
         this.mCreated = true;
         this.mFragments.dispatchActivityCreated();
      }

      this.mFragments.noteStateNotSaved();
      this.mFragments.execPendingActions();
      if(!this.mLoadersStarted) {
         this.mLoadersStarted = true;
         if(this.mLoaderManager != null) {
            this.mLoaderManager.doStart();
         } else if(!this.mCheckedForLoaderManager) {
            this.mLoaderManager = this.getLoaderManager("(root)", this.mLoadersStarted, false);
            if(this.mLoaderManager != null && !this.mLoaderManager.mStarted) {
               this.mLoaderManager.doStart();
            }
         }

         this.mCheckedForLoaderManager = true;
      }

      this.mFragments.dispatchStart();
      if(this.mAllLoaderManagers != null) {
         int var2 = this.mAllLoaderManagers.size();
         LoaderManagerImpl[] var3 = new LoaderManagerImpl[var2];

         for(int var4 = var2 - 1; var4 >= 0; --var4) {
            var3[var4] = (LoaderManagerImpl)this.mAllLoaderManagers.valueAt(var4);
         }

         for(int var5 = 0; var5 < var2; ++var5) {
            LoaderManagerImpl var6 = var3[var5];
            var6.finishRetain();
            var6.doReportStart();
         }
      }

   }

   protected void onStop() {
      super.onStop();
      this.mStopped = true;
      this.mHandler.sendEmptyMessage(1);
      this.mFragments.dispatchStop();
   }

   public void startActivityForResult(Intent var1, int var2) {
      if(var2 != -1 && (-65536 & var2) != 0) {
         throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
      } else {
         super.startActivityForResult(var1, var2);
      }
   }

   public void startActivityFromFragment(Fragment var1, Intent var2, int var3) {
      if(var3 == -1) {
         super.startActivityForResult(var2, -1);
      } else if((-65536 & var3) != 0) {
         throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
      } else {
         super.startActivityForResult(var2, (1 + var1.mIndex << 16) + ('\uffff' & var3));
      }
   }

   public void supportInvalidateOptionsMenu() {
      if(VERSION.SDK_INT >= 11) {
         ActivityCompatHoneycomb.invalidateOptionsMenu(this);
      } else {
         this.mOptionsMenuInvalidated = true;
      }
   }

   static class FragmentTag {
      public static final int[] Fragment = new int[]{16842755, 16842960, 16842961};
      public static final int Fragment_id = 1;
      public static final int Fragment_name = 0;
      public static final int Fragment_tag = 2;
   }

   static final class NonConfigurationInstances {
      Object activity;
      SimpleArrayMap<String, Object> children;
      Object custom;
      ArrayList<Fragment> fragments;
      SimpleArrayMap<String, LoaderManagerImpl> loaders;
   }
}
