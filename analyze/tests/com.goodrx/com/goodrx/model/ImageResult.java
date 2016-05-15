package com.goodrx.model;

public class ImageResult {
   String company_name;
   String description;
   String image;
   String image_id;
   String product_name_long;

   public ImageResult() {
   }

   public ImageResult(String var1, String var2, String var3, String var4, String var5) {
      this.image_id = var1;
      this.company_name = var2;
      this.description = var3;
      this.image = var4;
      this.product_name_long = var5;
   }

   public String getCompany_name() {
      if(this.company_name == null) {
         this.company_name = "";
      }

      return this.company_name;
   }

   public String getDescription() {
      return this.description == null?"":this.description;
   }

   public String getImage() {
      return this.image == null?"":this.image;
   }

   public String getImage_id() {
      return this.image_id;
   }

   public String getProduct_name_long() {
      if(this.product_name_long == null) {
         this.description = "";
      }

      return this.product_name_long;
   }
}
