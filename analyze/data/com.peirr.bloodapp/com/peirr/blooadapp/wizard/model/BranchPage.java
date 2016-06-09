package com.peirr.blooadapp.wizard.model;

import android.app.Fragment;
import android.text.TextUtils;
import com.peirr.blooadapp.wizard.model.ModelCallbacks;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.PageList;
import com.peirr.blooadapp.wizard.model.ReviewItem;
import com.peirr.blooadapp.wizard.model.SingleFixedChoicePage;
import com.peirr.blooadapp.wizard.ui.SingleChoiceFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BranchPage extends SingleFixedChoicePage {
   private List<BranchPage.Branch> mBranches = new ArrayList();

   public BranchPage(String var1, ModelCallbacks var2, String var3) {
      super(var1, var2, var3);
   }

   public BranchPage addBranch(String var1, Page... var2) {
      PageList var3 = new PageList(var2);
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         ((Page)var4.next()).setParentKey(var1);
      }

      this.mBranches.add(new BranchPage.Branch(var1, var3));
      return this;
   }

   public Fragment createFragment() {
      return SingleChoiceFragment.create(this.getKey());
   }

   public Page findByKey(String var1) {
      if(this.getKey().equals(var1)) {
         return this;
      } else {
         Iterator var2 = this.mBranches.iterator();

         Page var3;
         do {
            if(!var2.hasNext()) {
               return null;
            }

            var3 = ((BranchPage.Branch)var2.next()).childPageList.findByKey(var1);
         } while(var3 == null);

         return var3;
      }
   }

   public void flattenCurrentPageSequence(ArrayList<Page> var1) {
      super.flattenCurrentPageSequence(var1);
      Iterator var2 = this.mBranches.iterator();

      while(var2.hasNext()) {
         BranchPage.Branch var3 = (BranchPage.Branch)var2.next();
         if(var3.choice.equals(this.mData.getString("_"))) {
            var3.childPageList.flattenCurrentPageSequence(var1);
            break;
         }
      }

   }

   public String getOptionAt(int var1) {
      return ((BranchPage.Branch)this.mBranches.get(var1)).choice;
   }

   public int getOptionCount() {
      return this.mBranches.size();
   }

   public void getReviewItems(ArrayList<ReviewItem> var1) {
      var1.add(new ReviewItem(this.getParam(), this.getTitle(), this.mData.getString("_"), this.getKey()));
   }

   public boolean isCompleted() {
      return !TextUtils.isEmpty(this.mData.getString("_"));
   }

   public void notifyDataChanged() {
      this.mCallbacks.onPageTreeChanged();
      super.notifyDataChanged();
   }

   public BranchPage setValue(String var1) {
      this.mData.putString("_", var1);
      return this;
   }

   private static class Branch {
      public PageList childPageList;
      public String choice;

      private Branch(String var1, PageList var2) {
         this.choice = var1;
         this.childPageList = var2;
      }

      // $FF: synthetic method
      Branch(String var1, PageList var2, Object var3) {
         this(var1, var2);
      }
   }
}
