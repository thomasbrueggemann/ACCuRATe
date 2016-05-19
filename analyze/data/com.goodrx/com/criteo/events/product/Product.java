package com.criteo.events.product;

import android.util.Log;

public class Product {
   private final double price;
   private final String productId;

   public Product(String var1, double var2) {
      this.productId = this.validateProductId(var1);
      this.price = this.validatePrice(var2);
   }

   private double validatePrice(double var1) {
      if(var1 < 0.0D) {
         Log.e("[Criteo]", "Argument price must be greater than or equal to zero");
      }

      return var1;
   }

   private String validateProductId(String var1) {
      if(var1 == null) {
         Log.e("[Criteo]", "Argument productId must not be null");
         var1 = "";
      } else if(var1.length() == 0) {
         Log.e("[Criteo]", "Argument productId must be string of length greater than 0");
         return "";
      }

      return var1;
   }

   public double getPrice() {
      return this.price;
   }

   public String getProductId() {
      return this.productId;
   }
}
