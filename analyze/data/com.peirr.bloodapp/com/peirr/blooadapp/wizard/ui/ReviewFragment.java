package com.peirr.blooadapp.wizard.ui;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.peirr.blooadapp.io.Cache;
import com.peirr.blooadapp.wizard.model.AbstractWizardModel;
import com.peirr.blooadapp.wizard.model.ModelCallbacks;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.ReviewItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ReviewFragment extends ListFragment implements ModelCallbacks {
   private ReviewFragment.Callbacks mCallbacks;
   private List<ReviewItem> mCurrentReviewItems = new ArrayList();
   private ReviewFragment.ReviewAdapter mReviewAdapter;
   private AbstractWizardModel mWizardModel;
   private View rootView;

   public void changeBackground() {
      if(Cache.getInstance().isFemale()) {
         this.rootView.setBackgroundColor(this.getResources().getColor(2131099648));
      } else {
         this.rootView.setBackgroundColor(this.getResources().getColor(2131099649));
      }
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      if(!(var1 instanceof ReviewFragment.Callbacks)) {
         throw new ClassCastException("Activity must implement fragment\'s callbacks");
      } else {
         this.mCallbacks = (ReviewFragment.Callbacks)var1;
         this.mWizardModel = this.mCallbacks.onGetModel();
         if(this.mWizardModel != null) {
            this.mWizardModel.registerListener(this);
         }

         this.onPageTreeChanged();
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.mReviewAdapter = new ReviewFragment.ReviewAdapter(null);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      this.rootView = var1.inflate(2130903048, var2, false);
      this.changeBackground();
      TextView var4 = (TextView)this.rootView.findViewById(16908310);
      var4.setText(2131230783);
      var4.setTextColor(this.getResources().getColor(2131099650));
      ListView var5 = (ListView)this.rootView.findViewById(16908298);
      this.setListAdapter(this.mReviewAdapter);
      var5.setChoiceMode(1);
      return this.rootView;
   }

   public void onDetach() {
      super.onDetach();
      this.mCallbacks = null;
      if(this.mWizardModel != null) {
         this.mWizardModel.unregisterListener(this);
      }

   }

   public void onListItemClick(ListView var1, View var2, int var3, long var4) {
      this.mCallbacks.onEditScreenAfterReview(((ReviewItem)this.mCurrentReviewItems.get(var3)).getPageSection());
   }

   public void onPageDataChanged(Page var1) {
      ArrayList var2 = new ArrayList();
      if(this.mWizardModel != null) {
         Iterator var3 = this.mWizardModel.getCurrentPageSequence().iterator();

         while(var3.hasNext()) {
            ((Page)var3.next()).getReviewItems(var2);
         }

         Collections.sort(var2, new Comparator() {
            public int compare(ReviewItem var1, ReviewItem var2) {
               return var1.getWeight() > var2.getWeight()?1:(var1.getWeight() < var2.getWeight()?-1:0);
            }
         });
         this.mCurrentReviewItems = var2;
         if(this.mReviewAdapter != null) {
            this.mReviewAdapter.notifyDataSetInvalidated();
         }
      }

   }

   public void onPageTreeChanged() {
      this.onPageDataChanged((Page)null);
   }

   public void setUserVisibleHint(boolean var1) {
      if(this.rootView != null) {
         this.changeBackground();
      }

   }

   public interface Callbacks {
      void onEditScreenAfterReview(String var1);

      AbstractWizardModel onGetModel();
   }

   private class ReviewAdapter extends BaseAdapter {
      private ReviewAdapter() {
      }

      // $FF: synthetic method
      ReviewAdapter(Object var2) {
         this();
      }

      public boolean areAllItemsEnabled() {
         return true;
      }

      public int getCount() {
         return ReviewFragment.this.mCurrentReviewItems.size();
      }

      public Object getItem(int var1) {
         return ReviewFragment.this.mCurrentReviewItems.get(var1);
      }

      public long getItemId(int var1) {
         return (long)((ReviewItem)ReviewFragment.this.mCurrentReviewItems.get(var1)).hashCode();
      }

      public int getItemViewType(int var1) {
         return 0;
      }

      public View getView(int var1, View var2, ViewGroup var3) {
         View var4 = LayoutInflater.from(ReviewFragment.this.getActivity()).inflate(2130903057, var3, false);
         if(Cache.getInstance().isFemale()) {
            var4.setBackgroundColor(ReviewFragment.this.getResources().getColor(2131099648));
         } else {
            var4.setBackgroundColor(ReviewFragment.this.getResources().getColor(2131099649));
         }

         ReviewItem var5 = (ReviewItem)ReviewFragment.this.mCurrentReviewItems.get(var1);
         String var6 = var5.getValue();
         TextView var7 = (TextView)var4.findViewById(16908308);
         TextView var8 = (TextView)var4.findViewById(16908309);
         if(Cache.getInstance().isCardiac()) {
            if(var5.getTitle().equals("preop_lab_level")) {
               var7.setText(ReviewFragment.this.getString(2131230778));
            }

            if(var5.getParam().equals("first_pass_removed")) {
               var7.setText(ReviewFragment.this.getString(2131230737));
            }

            if(var5.getParam().equals("prime_volume")) {
               var7.setText(ReviewFragment.this.getString(2131230780));
            }

            if(var5.getParam().equals("fluid_prebypass")) {
               var7.setText(ReviewFragment.this.getString(2131230725));
            }
         } else {
            if(var5.getParam().equals("preop_lab_level")) {
               var7.setText(ReviewFragment.this.getString(2131230747));
            }

            if(var5.getParam().equals("first_pass_removed")) {
               var7.setText(ReviewFragment.this.getString(2131230746));
            }

            if(var5.getParam().equals("prime_volume")) {
               var7.setText(ReviewFragment.this.getString(2131230745));
            }

            if(var5.getParam().equals("fluid_prebypass")) {
               var7.setText(ReviewFragment.this.getString(2131230748));
            }
         }

         if(TextUtils.isEmpty(var6)) {
            var6 = "(None)";
            var7.setVisibility(8);
            var8.setVisibility(8);
         } else {
            var7.setVisibility(0);
            var8.setVisibility(0);
         }

         var7.setText(var5.getTitle());
         if(var5.getTitle().equalsIgnoreCase("gender")) {
            String var10;
            if(Integer.valueOf(var6).intValue() == 0) {
               var10 = "Male";
            } else {
               var10 = "Female";
            }

            var8.setText(var10);
            return var4;
         } else if(var5.getTitle().equalsIgnoreCase("cardiac")) {
            String var9;
            if(Integer.valueOf(var6).intValue() == 0) {
               var9 = "Non-cardiac";
            } else {
               var9 = "Cardiac";
            }

            var8.setText(var9);
            return var4;
         } else {
            var8.setText(var6);
            return var4;
         }
      }

      public int getViewTypeCount() {
         return 1;
      }

      public boolean hasStableIds() {
         return true;
      }
   }
}
