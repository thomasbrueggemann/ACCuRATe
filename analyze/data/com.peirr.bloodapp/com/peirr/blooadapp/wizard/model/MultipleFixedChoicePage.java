package com.peirr.blooadapp.wizard.model;

import android.app.Fragment;
import com.peirr.blooadapp.wizard.model.ModelCallbacks;
import com.peirr.blooadapp.wizard.model.ReviewItem;
import com.peirr.blooadapp.wizard.model.SingleFixedChoicePage;
import com.peirr.blooadapp.wizard.ui.MultipleChoiceFragment;
import java.util.ArrayList;
import java.util.Iterator;

public class MultipleFixedChoicePage extends SingleFixedChoicePage {
   public MultipleFixedChoicePage(String var1, ModelCallbacks var2, String var3) {
      super(var1, var2, var3);
   }

   public Fragment createFragment() {
      return MultipleChoiceFragment.create(this.getKey());
   }

   public void getReviewItems(ArrayList<ReviewItem> var1) {
      StringBuilder var2 = new StringBuilder();
      ArrayList var3 = this.mData.getStringArrayList("_");
      String var6;
      if(var3 != null && var3.size() > 0) {
         for(Iterator var5 = var3.iterator(); var5.hasNext(); var2.append(var6)) {
            var6 = (String)var5.next();
            if(var2.length() > 0) {
               var2.append(", ");
            }
         }
      }

      var1.add(new ReviewItem(this.getParam(), this.getTitle(), var2.toString(), this.getKey()));
   }

   public boolean isCompleted() {
      ArrayList var1 = this.mData.getStringArrayList("_");
      return var1 != null && var1.size() > 0;
   }
}
