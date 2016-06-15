package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
   private boolean mAttached;
   private int mContainerId;
   private Context mContext;
   private FragmentManager mFragmentManager;
   private FragmentTabHost.TabInfo mLastTab;
   private OnTabChangeListener mOnTabChangeListener;
   private FrameLayout mRealTabContent;
   private final ArrayList<FragmentTabHost.TabInfo> mTabs = new ArrayList();

   public FragmentTabHost(Context var1) {
      super(var1, (AttributeSet)null);
      this.initFragmentTabHost(var1, (AttributeSet)null);
   }

   public FragmentTabHost(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.initFragmentTabHost(var1, var2);
   }

   private FragmentTransaction doTabChanged(String var1, FragmentTransaction var2) {
      FragmentTabHost.TabInfo var3 = null;

      for(int var4 = 0; var4 < this.mTabs.size(); ++var4) {
         FragmentTabHost.TabInfo var9 = (FragmentTabHost.TabInfo)this.mTabs.get(var4);
         if(var9.tag.equals(var1)) {
            var3 = var9;
         }
      }

      if(var3 == null) {
         throw new IllegalStateException("No tab known for tag " + var1);
      } else {
         if(this.mLastTab != var3) {
            if(var2 == null) {
               var2 = this.mFragmentManager.beginTransaction();
            }

            if(this.mLastTab != null && this.mLastTab.fragment != null) {
               var2.detach(this.mLastTab.fragment);
            }

            if(var3 != null) {
               if(var3.fragment == null) {
                  var3.fragment = Fragment.instantiate(this.mContext, var3.clss.getName(), var3.args);
                  var2.add(this.mContainerId, var3.fragment, var3.tag);
               } else {
                  var2.attach(var3.fragment);
               }
            }

            this.mLastTab = var3;
         }

         return var2;
      }
   }

   private void ensureContent() {
      if(this.mRealTabContent == null) {
         this.mRealTabContent = (FrameLayout)this.findViewById(this.mContainerId);
         if(this.mRealTabContent == null) {
            throw new IllegalStateException("No tab content FrameLayout found for id " + this.mContainerId);
         }
      }

   }

   private void initFragmentTabHost(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, new int[]{16842995}, 0, 0);
      this.mContainerId = var3.getResourceId(0, 0);
      var3.recycle();
      super.setOnTabChangedListener(this);
      if(this.findViewById(16908307) == null) {
         LinearLayout var4 = new LinearLayout(var1);
         var4.setOrientation(1);
         this.addView(var4, new LayoutParams(-1, -1));
         TabWidget var5 = new TabWidget(var1);
         var5.setId(16908307);
         var5.setOrientation(0);
         var4.addView(var5, new android.widget.LinearLayout.LayoutParams(-1, -2, 0.0F));
         FrameLayout var6 = new FrameLayout(var1);
         var6.setId(16908305);
         var4.addView(var6, new android.widget.LinearLayout.LayoutParams(0, 0, 0.0F));
         FrameLayout var7 = new FrameLayout(var1);
         this.mRealTabContent = var7;
         this.mRealTabContent.setId(this.mContainerId);
         var4.addView(var7, new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0F));
      }

   }

   public void addTab(TabSpec var1, Class<?> var2, Bundle var3) {
      var1.setContent(new FragmentTabHost.DummyTabFactory(this.mContext));
      String var5 = var1.getTag();
      FragmentTabHost.TabInfo var6 = new FragmentTabHost.TabInfo(var5, var2, var3);
      if(this.mAttached) {
         var6.fragment = this.mFragmentManager.findFragmentByTag(var5);
         if(var6.fragment != null && !var6.fragment.isDetached()) {
            FragmentTransaction var9 = this.mFragmentManager.beginTransaction();
            var9.detach(var6.fragment);
            var9.commit();
         }
      }

      this.mTabs.add(var6);
      this.addTab(var1);
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      String var1 = this.getCurrentTabTag();
      FragmentTransaction var2 = null;

      for(int var3 = 0; var3 < this.mTabs.size(); ++var3) {
         FragmentTabHost.TabInfo var7 = (FragmentTabHost.TabInfo)this.mTabs.get(var3);
         var7.fragment = this.mFragmentManager.findFragmentByTag(var7.tag);
         if(var7.fragment != null && !var7.fragment.isDetached()) {
            if(var7.tag.equals(var1)) {
               this.mLastTab = var7;
            } else {
               if(var2 == null) {
                  var2 = this.mFragmentManager.beginTransaction();
               }

               var2.detach(var7.fragment);
            }
         }
      }

      this.mAttached = true;
      FragmentTransaction var4 = this.doTabChanged(var1, var2);
      if(var4 != null) {
         var4.commit();
         this.mFragmentManager.executePendingTransactions();
      }

   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.mAttached = false;
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      FragmentTabHost.SavedState var2 = (FragmentTabHost.SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      this.setCurrentTabByTag(var2.curTab);
   }

   protected Parcelable onSaveInstanceState() {
      FragmentTabHost.SavedState var1 = new FragmentTabHost.SavedState(super.onSaveInstanceState());
      var1.curTab = this.getCurrentTabTag();
      return var1;
   }

   public void onTabChanged(String var1) {
      if(this.mAttached) {
         FragmentTransaction var2 = this.doTabChanged(var1, (FragmentTransaction)null);
         if(var2 != null) {
            var2.commit();
         }
      }

      if(this.mOnTabChangeListener != null) {
         this.mOnTabChangeListener.onTabChanged(var1);
      }

   }

   public void setOnTabChangedListener(OnTabChangeListener var1) {
      this.mOnTabChangeListener = var1;
   }

   @Deprecated
   public void setup() {
      throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
   }

   public void setup(Context var1, FragmentManager var2) {
      super.setup();
      this.mContext = var1;
      this.mFragmentManager = var2;
      this.ensureContent();
   }

   public void setup(Context var1, FragmentManager var2, int var3) {
      super.setup();
      this.mContext = var1;
      this.mFragmentManager = var2;
      this.mContainerId = var3;
      this.ensureContent();
      this.mRealTabContent.setId(var3);
      if(this.getId() == -1) {
         this.setId(16908306);
      }

   }

   static class DummyTabFactory implements TabContentFactory {
      private final Context mContext;

      public DummyTabFactory(Context var1) {
         this.mContext = var1;
      }

      public View createTabContent(String var1) {
         View var2 = new View(this.mContext);
         var2.setMinimumWidth(0);
         var2.setMinimumHeight(0);
         return var2;
      }
   }

   static class SavedState extends BaseSavedState {
      public static final Creator<FragmentTabHost.SavedState> CREATOR = new Creator() {
         public FragmentTabHost.SavedState createFromParcel(Parcel var1) {
            return new FragmentTabHost.SavedState(var1);
         }

         public FragmentTabHost.SavedState[] newArray(int var1) {
            return new FragmentTabHost.SavedState[var1];
         }
      };
      String curTab;

      private SavedState(Parcel var1) {
         super(var1);
         this.curTab = var1.readString();
      }

      // $FF: synthetic method
      SavedState(Parcel var1, Object var2) {
         this(var1);
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      public String toString() {
         return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.curTab + "}";
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeString(this.curTab);
      }
   }

   static final class TabInfo {
      private final Bundle args;
      private final Class<?> clss;
      private Fragment fragment;
      private final String tag;

      TabInfo(String var1, Class<?> var2, Bundle var3) {
         this.tag = var1;
         this.clss = var2;
         this.args = var3;
      }
   }
}
