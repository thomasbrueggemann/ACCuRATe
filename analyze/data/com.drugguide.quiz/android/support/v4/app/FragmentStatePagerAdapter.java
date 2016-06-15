package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FragmentStatePagerAdapter extends PagerAdapter {
   private static final boolean DEBUG = false;
   private static final String TAG = "FragmentStatePagerAdapter";
   private FragmentTransaction mCurTransaction = null;
   private Fragment mCurrentPrimaryItem = null;
   private final FragmentManager mFragmentManager;
   private ArrayList<Fragment> mFragments = new ArrayList();
   private ArrayList<Fragment.SavedState> mSavedState = new ArrayList();

   public FragmentStatePagerAdapter(FragmentManager var1) {
      this.mFragmentManager = var1;
   }

   public void destroyItem(ViewGroup var1, int var2, Object var3) {
      Fragment var4 = (Fragment)var3;
      if(this.mCurTransaction == null) {
         this.mCurTransaction = this.mFragmentManager.beginTransaction();
      }

      while(this.mSavedState.size() <= var2) {
         this.mSavedState.add((Object)null);
      }

      this.mSavedState.set(var2, this.mFragmentManager.saveFragmentInstanceState(var4));
      this.mFragments.set(var2, (Object)null);
      this.mCurTransaction.remove(var4);
   }

   public void finishUpdate(ViewGroup var1) {
      if(this.mCurTransaction != null) {
         this.mCurTransaction.commitAllowingStateLoss();
         this.mCurTransaction = null;
         this.mFragmentManager.executePendingTransactions();
      }

   }

   public abstract Fragment getItem(int var1);

   public Object instantiateItem(ViewGroup var1, int var2) {
      if(this.mFragments.size() > var2) {
         Fragment var8 = (Fragment)this.mFragments.get(var2);
         if(var8 != null) {
            return var8;
         }
      }

      if(this.mCurTransaction == null) {
         this.mCurTransaction = this.mFragmentManager.beginTransaction();
      }

      Fragment var3 = this.getItem(var2);
      if(this.mSavedState.size() > var2) {
         Fragment.SavedState var7 = (Fragment.SavedState)this.mSavedState.get(var2);
         if(var7 != null) {
            var3.setInitialSavedState(var7);
         }
      }

      while(this.mFragments.size() <= var2) {
         this.mFragments.add((Object)null);
      }

      var3.setMenuVisibility(false);
      var3.setUserVisibleHint(false);
      this.mFragments.set(var2, var3);
      this.mCurTransaction.add(var1.getId(), var3);
      return var3;
   }

   public boolean isViewFromObject(View var1, Object var2) {
      return ((Fragment)var2).getView() == var1;
   }

   public void restoreState(Parcelable var1, ClassLoader var2) {
      if(var1 != null) {
         Bundle var3 = (Bundle)var1;
         var3.setClassLoader(var2);
         Parcelable[] var4 = var3.getParcelableArray("states");
         this.mSavedState.clear();
         this.mFragments.clear();
         if(var4 != null) {
            for(int var12 = 0; var12 < var4.length; ++var12) {
               this.mSavedState.add((Fragment.SavedState)var4[var12]);
            }
         }

         Iterator var5 = var3.keySet().iterator();

         while(true) {
            while(true) {
               String var6;
               do {
                  if(!var5.hasNext()) {
                     return;
                  }

                  var6 = (String)var5.next();
               } while(!var6.startsWith("f"));

               int var7 = Integer.parseInt(var6.substring(1));
               Fragment var8 = this.mFragmentManager.getFragment(var3, var6);
               if(var8 != null) {
                  while(this.mFragments.size() <= var7) {
                     this.mFragments.add((Object)null);
                  }

                  var8.setMenuVisibility(false);
                  this.mFragments.set(var7, var8);
               } else {
                  Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + var6);
               }
            }
         }
      }
   }

   public Parcelable saveState() {
      int var1 = this.mSavedState.size();
      Bundle var2 = null;
      if(var1 > 0) {
         var2 = new Bundle();
         Fragment.SavedState[] var3 = new Fragment.SavedState[this.mSavedState.size()];
         this.mSavedState.toArray(var3);
         var2.putParcelableArray("states", var3);
      }

      for(int var5 = 0; var5 < this.mFragments.size(); ++var5) {
         Fragment var6 = (Fragment)this.mFragments.get(var5);
         if(var6 != null) {
            if(var2 == null) {
               var2 = new Bundle();
            }

            String var7 = "f" + var5;
            this.mFragmentManager.putFragment(var2, var7, var6);
         }
      }

      return var2;
   }

   public void setPrimaryItem(ViewGroup var1, int var2, Object var3) {
      Fragment var4 = (Fragment)var3;
      if(var4 != this.mCurrentPrimaryItem) {
         if(this.mCurrentPrimaryItem != null) {
            this.mCurrentPrimaryItem.setMenuVisibility(false);
            this.mCurrentPrimaryItem.setUserVisibleHint(false);
         }

         if(var4 != null) {
            var4.setMenuVisibility(true);
            var4.setUserVisibleHint(true);
         }

         this.mCurrentPrimaryItem = var4;
      }

   }

   public void startUpdate(ViewGroup var1) {
   }
}
