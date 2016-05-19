package com.goodrx.model;

public class Drug {
   private String brand;
   private String generic;
   private String selected_format;
   private String selected_format_plural;
   private int selected_quantity;
   private String selected_strength;
   private String selected_type;

   public String getAmount() {
      return this.getQuantityText() + " " + this.selected_strength;
   }

   public String getDisplay() {
      return this.selected_type.equals("brand")?this.brand:this.generic;
   }

   public String getFullName() {
      return this.selected_type.equals("brand")?this.brand + " (brand drug)":(this.brand != null && this.brand.length() != 0?this.generic + " (generic " + this.brand + ")":this.generic);
   }

   public String getQuantityText() {
      StringBuilder var1 = new StringBuilder(this.selected_quantity + " ");
      if(this.selected_quantity > 1) {
         var1.append(this.selected_format_plural);
      } else {
         var1.append(this.selected_format);
      }

      return var1.toString();
   }
}
