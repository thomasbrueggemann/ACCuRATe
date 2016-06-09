package com.peirr.blooadapp.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.peirr.blooadapp.activities.PatientWizardmodel;
import com.peirr.blooadapp.activities.SummaryActivity;
import com.peirr.blooadapp.io.Cache;
import com.peirr.blooadapp.io.CalculationHelper;
import com.peirr.blooadapp.io.PreBypassCalculation;
import com.peirr.blooadapp.io.Settings;
import com.peirr.blooadapp.wizard.model.AbstractWizardModel;
import com.peirr.blooadapp.wizard.model.ModelCallbacks;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.ReviewItem;
import com.peirr.blooadapp.wizard.ui.PageFragmentCallbacks;
import com.peirr.blooadapp.wizard.ui.ReviewFragment;
import com.peirr.blooadapp.wizard.ui.StepPagerStrip;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PatientActivity extends Activity implements PageFragmentCallbacks, ReviewFragment.Callbacks, ModelCallbacks {
   String TAG = PatientActivity.class.getSimpleName();
   private Button calculate;
   private boolean mConsumePageSelectedEvent;
   private List<Page> mCurrentPageSequence;
   private boolean mEditingAfterReview;
   private ViewPager mPager;
   private PatientActivity.MyPagerAdapter mPagerAdapter;
   private Button mPrevButton;
   private StepPagerStrip mStepPagerStrip;
   private AbstractWizardModel mWizardModel;
   private ProgressDialog progress;
   private Settings settings;

   private boolean recalculateCutOffPage() {
      int var1 = 1 + this.mCurrentPageSequence.size();

      for(int var2 = 0; var2 < this.mCurrentPageSequence.size(); ++var2) {
         Page var3 = (Page)this.mCurrentPageSequence.get(var2);
         if(var3.isRequired() && !var3.isCompleted()) {
            var1 = var2;
            break;
         }
      }

      if(this.mPagerAdapter.getCutOffPage() != var1) {
         this.mPagerAdapter.setCutOffPage(var1);
         return true;
      } else {
         return false;
      }
   }

   private void updateBottomBar() {
      int var1 = this.mPager.getCurrentItem();
      if(var1 == this.mCurrentPageSequence.size()) {
         this.calculate.setText(2131230756);
         this.calculate.setBackgroundResource(2130837504);
         this.calculate.setTextAppearance(this, 2131296257);
      } else {
         Button var2 = this.calculate;
         int var3;
         if(this.mEditingAfterReview) {
            var3 = 2131230783;
         } else {
            var3 = 2131230744;
         }

         var2.setText(var3);
         this.calculate.setBackgroundResource(2130837510);
         TypedValue var4 = new TypedValue();
         this.getTheme().resolveAttribute(16842817, var4, true);
         this.calculate.setTextAppearance(this, var4.resourceId);
         Button var6 = this.calculate;
         boolean var7;
         if(var1 != this.mPagerAdapter.getCutOffPage()) {
            var7 = true;
         } else {
            var7 = false;
         }

         var6.setEnabled(var7);
      }

      Button var8 = this.mPrevButton;
      byte var9 = 0;
      if(var1 <= 0) {
         var9 = 4;
      }

      var8.setVisibility(var9);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903042);
      this.settings = new Settings(this);
      this.progress = new ProgressDialog(this);
      this.progress.setMessage(this.getString(2131230792));
      this.mWizardModel = new PatientWizardmodel(this);
      if(var1 != null) {
         this.mWizardModel.load(var1.getBundle("model"));
      }

      this.mWizardModel.registerListener(this);
      this.mPagerAdapter = new PatientActivity.MyPagerAdapter(this.getFragmentManager());
      this.mPager = (ViewPager)this.findViewById(2131427333);
      this.mPager.setAdapter(this.mPagerAdapter);
      this.mStepPagerStrip = (StepPagerStrip)this.findViewById(2131427332);
      this.mStepPagerStrip.setOnPageSelectedListener(new StepPagerStrip.OnPageSelectedListener() {
         public void onPageStripSelected(int var1) {
            int var2 = Math.min(-1 + PatientActivity.this.mPagerAdapter.getCount(), var1);
            if(PatientActivity.this.mPager.getCurrentItem() != var2) {
               PatientActivity.this.mPager.setCurrentItem(var2);
            }

         }
      });
      this.calculate = (Button)this.findViewById(2131427336);
      this.mPrevButton = (Button)this.findViewById(2131427335);
      this.mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
         public void onPageSelected(int var1) {
            PatientActivity.this.mStepPagerStrip.setCurrentPage(var1);
            if(PatientActivity.this.mConsumePageSelectedEvent) {
               PatientActivity.this.mConsumePageSelectedEvent = false;
            } else {
               PatientActivity.this.mEditingAfterReview = false;
               PatientActivity.this.updateBottomBar();
            }
         }
      });
      this.calculate.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(PatientActivity.this.mPager.getCurrentItem() != PatientActivity.this.mCurrentPageSequence.size()) {
               if(PatientActivity.this.mEditingAfterReview) {
                  PatientActivity.this.mPager.setCurrentItem(-1 + PatientActivity.this.mPagerAdapter.getCount());
               } else {
                  PatientActivity.this.mPager.setCurrentItem(1 + PatientActivity.this.mPager.getCurrentItem());
               }
            } else {
               ArrayList var2 = new ArrayList();
               Iterator var3 = PatientActivity.this.mWizardModel.getCurrentPageSequence().iterator();

               while(var3.hasNext()) {
                  ((Page)var3.next()).getReviewItems(var2);
               }

               HashMap var4 = new HashMap();
               Iterator var5 = var2.iterator();

               while(var5.hasNext()) {
                  ReviewItem var9 = (ReviewItem)var5.next();
                  Log.d(PatientActivity.this.TAG, "[" + var9.getParam() + "] -> [" + var9.getValue() + "]");
                  if((var9.getParam().equals("fluid_prebypass") || var9.getParam().equals("rbc_required") || var9.getParam().equals("urine_prebypass") || var9.getParam().equals("prime_volume")) && var9.getValue() == null) {
                     var9.setValue("0");
                  }

                  Log.d(PatientActivity.this.TAG, "[" + var9.getParam() + "] -> [" + var9.getValue() + "]");
                  var4.put(var9.getParam(), var9.getValue());
               }

               Cache.getInstance().setValues(var4);
               PreBypassCalculation var6 = CalculationHelper.calculate(var4);
               Intent var7 = new Intent(PatientActivity.this, SummaryActivity.class);
               var7.putExtra("calculation", var6);
               PatientActivity.this.startActivity(var7);
            }
         }
      });
      this.mPrevButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            PatientActivity.this.mPager.setCurrentItem(-1 + PatientActivity.this.mPager.getCurrentItem());
         }
      });
      this.onPageTreeChanged();
      this.updateBottomBar();
   }

   protected void onDestroy() {
      super.onDestroy();
      this.mWizardModel.unregisterListener(this);
   }

   public void onEditScreenAfterReview(String var1) {
      for(int var2 = -1 + this.mCurrentPageSequence.size(); var2 >= 0; --var2) {
         if(((Page)this.mCurrentPageSequence.get(var2)).getKey().equals(var1)) {
            this.mConsumePageSelectedEvent = true;
            this.mEditingAfterReview = true;
            this.mPager.setCurrentItem(var2);
            this.updateBottomBar();
            break;
         }
      }

   }

   public AbstractWizardModel onGetModel() {
      return this.mWizardModel;
   }

   public Page onGetPage(String var1) {
      return this.mWizardModel == null?null:this.mWizardModel.findByKey(var1);
   }

   public void onPageDataChanged(Page var1) {
      if(var1.isRequired() && this.recalculateCutOffPage()) {
         this.mPagerAdapter.notifyDataSetChanged();
         this.updateBottomBar();
      }

   }

   public void onPageTreeChanged() {
      this.mCurrentPageSequence = this.mWizardModel.getCurrentPageSequence();
      this.recalculateCutOffPage();
      this.mStepPagerStrip.setPageCount(1 + this.mCurrentPageSequence.size());
      this.mPagerAdapter.notifyDataSetChanged();
      this.updateBottomBar();
   }

   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putBundle("model", this.mWizardModel.save());
   }

   public class MyPagerAdapter extends FragmentStatePagerAdapter {
      private int mCutOffPage;
      private Fragment mPrimaryItem;

      public MyPagerAdapter(FragmentManager var2) {
         super(var2);
      }

      public int getCount() {
         return PatientActivity.this.mCurrentPageSequence == null?0:Math.min(1 + this.mCutOffPage, 1 + PatientActivity.this.mCurrentPageSequence.size());
      }

      public int getCutOffPage() {
         return this.mCutOffPage;
      }

      public Fragment getItem(int var1) {
         return (Fragment)(var1 >= PatientActivity.this.mCurrentPageSequence.size()?new ReviewFragment():((Page)PatientActivity.this.mCurrentPageSequence.get(var1)).createFragment());
      }

      public int getItemPosition(Object var1) {
         return var1 == this.mPrimaryItem?-1:-2;
      }

      public void setCutOffPage(int var1) {
         if(var1 < 0) {
            var1 = Integer.MAX_VALUE;
         }

         this.mCutOffPage = var1;
      }

      public void setPrimaryItem(ViewGroup var1, int var2, Object var3) {
         super.setPrimaryItem(var1, var2, var3);
         this.mPrimaryItem = (Fragment)var3;
      }
   }
}
