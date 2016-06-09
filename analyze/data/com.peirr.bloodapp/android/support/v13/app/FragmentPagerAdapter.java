package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Parcelable;
import android.support.v13.app.FragmentCompat;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentPagerAdapter extends PagerAdapter {
   private static final boolean DEBUG = false;
   private static final String TAG = "FragmentPagerAdapter";
   private FragmentTransaction mCurTransaction = null;
   private Fragment mCurrentPrimaryItem = null;
   private final FragmentManager mFragmentManager;

   public FragmentPagerAdapter(FragmentManager var1) {
      this.mFragmentManager = var1;
   }

   private static String makeFragmentName(int var0, long var1) {
      return "android:switcher:" + var0 + ":" + var1;
   }

   public void destroyItem(ViewGroup var1, int var2, Object var3) {
      if(this.mCurTransaction == null) {
         this.mCurTransaction = this.mFragmentManager.beginTransaction();
      }

      this.mCurTransaction.detach((Fragment)var3);
   }

   public void finishUpdate(ViewGroup var1) {
      if(this.mCurTransaction != null) {
         this.mCurTransaction.commitAllowingStateLoss();
         this.mCurTransaction = null;
         this.mFragmentManager.executePendingTransactions();
      }

   }

   public abstract Fragment getItem(int var1);

   public long getItemId(int var1) {
      return (long)var1;
   }

   public Object instantiateItem(ViewGroup var1, int var2) {
      if(this.mCurTransaction == null) {
         this.mCurTransaction = this.mFragmentManager.beginTransaction();
      }

      long var3 = this.getItemId(var2);
      String var5 = makeFragmentName(var1.getId(), var3);
      Fragment var6 = this.mFragmentManager.findFragmentByTag(var5);
      if(var6 != null) {
         this.mCurTransaction.attach(var6);
      } else {
         var6 = this.getItem(var2);
         this.mCurTransaction.add(var1.getId(), var6, makeFragmentName(var1.getId(), var3));
      }

      if(var6 != this.mCurrentPrimaryItem) {
         FragmentCompat.setMenuVisibility(var6, false);
         FragmentCompat.setUserVisibleHint(var6, false);
      }

      return var6;
   }

   public boolean isViewFromObject(View var1, Object var2) {
      return ((Fragment)var2).getView() == var1;
   }

   public void restoreState(Parcelable var1, ClassLoader var2) {
   }

   public Parcelable saveState() {
      return null;
   }

   public void setPrimaryItem(ViewGroup var1, int var2, Object var3) {
      Fragment var4 = (Fragment)var3;
      if(var4 != this.mCurrentPrimaryItem) {
         if(this.mCurrentPrimaryItem != null) {
            FragmentCompat.setMenuVisibility(this.mCurrentPrimaryItem, false);
            FragmentCompat.setUserVisibleHint(this.mCurrentPrimaryItem, false);
         }

         if(var4 != null) {
            FragmentCompat.setMenuVisibility(var4, true);
            FragmentCompat.setUserVisibleHint(var4, true);
         }

         this.mCurrentPrimaryItem = var4;
      }

   }

   public void startUpdate(ViewGroup var1) {
   }
}
