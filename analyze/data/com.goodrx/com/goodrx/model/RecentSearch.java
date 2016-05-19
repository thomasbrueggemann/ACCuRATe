package com.goodrx.model;

import android.app.Activity;
import com.goodrx.activity.configure.PrescriptionConfigureActivity;
import com.goodrx.model.DrugDetail;
import com.goodrx.model.GlobalSearchableItem;

public class RecentSearch implements GlobalSearchableItem {
   private String display;
   private String dosageSlug;
   private String formSlug;
   private int quantity;
   private String slug;

   public RecentSearch(DrugDetail var1) {
      this.slug = var1.getSelectedDrug().getSlug();
      this.display = this.getName(var1);
      this.formSlug = var1.getSelectedDrug().getForm().getSlug();
      this.dosageSlug = var1.getSelectedDrug().getDosage().getSlug();
      this.quantity = var1.getSelectedDrug().getQuantity();
   }

   public RecentSearch(String var1, String var2, String var3, String var4, int var5) {
      this.slug = var1;
      this.display = var2;
      this.formSlug = var3;
      this.dosageSlug = var4;
      this.quantity = var5;
   }

   public boolean equals(Object var1) {
      return !(var1 instanceof RecentSearch)?false:((RecentSearch)var1).getSlug().equals(this.slug);
   }

   public String getDisplay() {
      return this.display;
   }

   public String getDosageSlug() {
      return this.dosageSlug;
   }

   public String getFormSlug() {
      return this.formSlug;
   }

   public String getName(DrugDetail var1) {
      String var2 = var1.getSelectedDrug().getNameDisplay();
      if(var1.getSelectedDrug().getLabel().equals("brand")) {
         var2 = var2 + " (brand drug)";
      } else if(var1.getBrands().length != 0) {
         return var2 + " (generic " + var1.getBrands()[0].getDisplay() + ")";
      }

      return var2;
   }

   public int getQuantity() {
      return this.quantity;
   }

   public String getSearchDisplay() {
      return this.getDisplay();
   }

   public String getSearchType() {
      return RecentSearch.class.getName();
   }

   public String getSlug() {
      return this.slug;
   }

   public void onClick(Activity var1) {
      PrescriptionConfigureActivity.launch(var1, this.getSlug(), true, this.getFormSlug(), this.getDosageSlug(), Integer.valueOf(this.getQuantity()));
   }
}
