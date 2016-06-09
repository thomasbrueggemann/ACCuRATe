package com.criteo.events.product;

import android.util.Log;
import com.criteo.events.product.Product;

public class BasketProduct {
   private final Product product;
   private final int quantity;

   public BasketProduct(String var1, double var2, int var4) {
      this.product = new Product(var1, var2);
      this.quantity = this.validateQuantity(var4);
   }

   private int validateQuantity(int var1) {
      if(var1 < 1) {
         Log.e("[Criteo]", "Argument quantity must be greater than zero");
      }

      return var1;
   }

   public double getPrice() {
      return this.product.getPrice();
   }

   public String getProductId() {
      return this.product.getProductId();
   }

   public int getQuantity() {
      return this.quantity;
   }
}
