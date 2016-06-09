package com.peirr.blooadapp.wizard.model;

import android.app.Fragment;
import android.os.Bundle;
import com.peirr.blooadapp.wizard.model.ModelCallbacks;
import com.peirr.blooadapp.wizard.model.PageTreeNode;
import com.peirr.blooadapp.wizard.model.ReviewItem;
import java.util.ArrayList;

public abstract class Page implements PageTreeNode {
   public static final String SIMPLE_DATA_KEY = "_";
   protected ModelCallbacks mCallbacks;
   protected Bundle mData = new Bundle();
   protected String mParentKey;
   protected boolean mRequired = false;
   protected String mTitle;

   protected Page(ModelCallbacks var1, String var2) {
      this.mCallbacks = var1;
      this.mTitle = var2;
   }

   public abstract Fragment createFragment();

   public Page findByKey(String var1) {
      return this.getKey().equals(var1)?this:null;
   }

   public void flattenCurrentPageSequence(ArrayList<Page> var1) {
      var1.add(this);
   }

   public Bundle getData() {
      return this.mData;
   }

   public String getKey() {
      return this.mParentKey != null?this.mParentKey + ":" + this.mTitle:this.mTitle;
   }

   public abstract void getReviewItems(ArrayList<ReviewItem> var1);

   public String getTitle() {
      return this.mTitle;
   }

   public boolean isCompleted() {
      return true;
   }

   public boolean isRequired() {
      return this.mRequired;
   }

   public void notifyDataChanged() {
      this.mCallbacks.onPageDataChanged(this);
   }

   public void resetData(Bundle var1) {
      this.mData = var1;
      this.notifyDataChanged();
   }

   void setParentKey(String var1) {
      this.mParentKey = var1;
   }

   public Page setRequired(boolean var1) {
      this.mRequired = var1;
      return this;
   }
}
