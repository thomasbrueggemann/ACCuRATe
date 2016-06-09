package com.peirr.blooadapp.wizard.model;

import android.app.Fragment;
import android.text.TextUtils;
import com.peirr.blooadapp.wizard.model.ModelCallbacks;
import com.peirr.blooadapp.wizard.model.Page;
import com.peirr.blooadapp.wizard.model.ReviewItem;
import com.peirr.blooadapp.wizard.ui.SingleChoiceFragment;
import java.util.ArrayList;
import java.util.Arrays;

public class SingleFixedChoicePage extends Page {
   protected ArrayList<String> mChoices = new ArrayList();
   private String param;

   public SingleFixedChoicePage(String var1, ModelCallbacks var2, String var3) {
      super(var2, var3);
      this.param = var1;
   }

   public Fragment createFragment() {
      return SingleChoiceFragment.create(this.getKey());
   }

   public String getOptionAt(int var1) {
      return (String)this.mChoices.get(var1);
   }

   public int getOptionCount() {
      return this.mChoices.size();
   }

   public String getParam() {
      return this.param;
   }

   public void getReviewItems(ArrayList<ReviewItem> var1) {
      var1.add(new ReviewItem(this.getParam(), this.getTitle(), this.mData.getString("_"), this.getKey()));
   }

   public boolean isCompleted() {
      return !TextUtils.isEmpty(this.mData.getString("_"));
   }

   public SingleFixedChoicePage setChoices(String... var1) {
      this.mChoices.addAll(Arrays.asList(var1));
      return this;
   }

   public SingleFixedChoicePage setValue(String var1) {
      this.mData.putString("_", var1);
      return this;
   }
}
