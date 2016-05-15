package com.criteo.events;

import com.criteo.events.Event;
import com.criteo.events.product.Product;
import java.util.Currency;
import java.util.concurrent.atomic.AtomicReference;

public class ProductViewEvent extends Event {
   private AtomicReference<Currency> currency = new AtomicReference();
   private AtomicReference<Product> product = new AtomicReference();

   public ProductViewEvent(String var1, double var2) {
      this.product.set(new Product(var1, var2));
   }

   public Currency getCurrency() {
      return (Currency)this.currency.get();
   }

   public Product getProduct() {
      return (Product)this.product.get();
   }
}
