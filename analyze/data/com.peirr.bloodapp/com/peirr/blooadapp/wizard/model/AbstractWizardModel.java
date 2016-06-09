package com.peirr.blooadapp.wizard.model;

import android.content.Context;
import android.os.Bundle;
import com.peirr.blooadapp.wizard.model.ModelCallbacks;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.PageList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractWizardModel implements ModelCallbacks {
   protected Context mContext;
   private List<ModelCallbacks> mListeners = new ArrayList();
   private PageList mRootPageList;

   public AbstractWizardModel(Context var1) {
      this.mContext = var1;
      this.mRootPageList = this.onNewRootPageList();
   }

   public Page findByKey(String var1) {
      return this.mRootPageList.findByKey(var1);
   }

   public List<Page> getCurrentPageSequence() {
      ArrayList var1 = new ArrayList();
      this.mRootPageList.flattenCurrentPageSequence(var1);
      return var1;
   }

   public void load(Bundle var1) {
      Iterator var2 = var1.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         this.mRootPageList.findByKey(var3).resetData(var1.getBundle(var3));
      }

   }

   protected abstract PageList onNewRootPageList();

   public void onPageDataChanged(Page var1) {
      for(int var2 = 0; var2 < this.mListeners.size(); ++var2) {
         ((ModelCallbacks)this.mListeners.get(var2)).onPageDataChanged(var1);
      }

   }

   public void onPageTreeChanged() {
      for(int var1 = 0; var1 < this.mListeners.size(); ++var1) {
         ((ModelCallbacks)this.mListeners.get(var1)).onPageTreeChanged();
      }

   }

   public void registerListener(ModelCallbacks var1) {
      this.mListeners.add(var1);
   }

   public Bundle save() {
      Bundle var1 = new Bundle();
      Iterator var2 = this.getCurrentPageSequence().iterator();

      while(var2.hasNext()) {
         Page var3 = (Page)var2.next();
         var1.putBundle(var3.getKey(), var3.getData());
      }

      return var1;
   }

   public void unregisterListener(ModelCallbacks var1) {
      this.mListeners.remove(var1);
   }
}
