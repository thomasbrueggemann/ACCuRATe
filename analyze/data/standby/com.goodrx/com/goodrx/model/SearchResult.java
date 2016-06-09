package com.goodrx.model;

import android.app.Activity;
import com.goodrx.activity.ClassDrugActivity;
import com.goodrx.activity.ConditionClassActivity;
import com.goodrx.activity.configure.PrescriptionConfigureActivity;
import com.goodrx.model.ClassDrug;
import com.goodrx.model.ConditionClass;
import com.goodrx.model.GlobalSearchableItem;

public class SearchResult implements GlobalSearchableItem {
   private boolean condition;
   private String display;
   private boolean drug_class;
   private String form_slug;
   private String slug;

   public String getDisplay() {
      return this.display;
   }

   public String getForm_slug() {
      return this.form_slug;
   }

   public String getSearchDisplay() {
      return this.display;
   }

   public String getSearchType() {
      return this.isCondition()?ConditionClass.class.getName():(this.isDrug_class()?ClassDrug.class.getName():SearchResult.class.getName());
   }

   public String getSlug() {
      return this.slug;
   }

   public boolean isCondition() {
      return this.condition;
   }

   public boolean isDrug_class() {
      return this.drug_class;
   }

   public void onClick(Activity var1) {
      if(this.isCondition()) {
         ConditionClassActivity.launch(var1, this.getSlug());
      } else if(this.isDrug_class()) {
         ClassDrugActivity.launch(var1, this.getSlug(), false);
      } else {
         PrescriptionConfigureActivity.launch(var1, this.getSlug(), false, this.getForm_slug(), (String)null, (Integer)null);
      }
   }
}
