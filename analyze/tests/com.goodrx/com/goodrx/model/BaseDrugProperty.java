package com.goodrx.model;

public class BaseDrugProperty {
   protected String display;
   protected String slug;

   public BaseDrugProperty(String var1, String var2) {
      this.display = var1;
      this.slug = var2;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof BaseDrugProperty)) {
         return false;
      } else {
         BaseDrugProperty var2 = (BaseDrugProperty)var1;
         return this.slug.equals(var2.getSlug());
      }
   }

   public String getDisplay() {
      return this.display;
   }

   public String getSlug() {
      return this.slug;
   }
}
