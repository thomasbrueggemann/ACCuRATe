package com.criteo.events;

import com.criteo.events.CRTOLog;
import com.criteo.events.Event;
import com.criteo.events.product.BasketProduct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class TransactionConfirmationEvent extends Event {
   private CopyOnWriteArrayList<BasketProduct> basketProductList = new CopyOnWriteArrayList();
   private AtomicReference<Currency> currency = new AtomicReference();
   private AtomicBoolean newCustomer = new AtomicBoolean();
   private AtomicReference<String> transactionId = new AtomicReference();

   public TransactionConfirmationEvent(String var1, BasketProduct... var2) {
      this.setTransactionId(var1);
      this.setBasketProductList(new ArrayList(Arrays.asList(var2)));
   }

   private CopyOnWriteArrayList<BasketProduct> makeBasketProducts(Iterable<BasketProduct> var1) {
      CopyOnWriteArrayList var2 = new CopyOnWriteArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         BasketProduct var4 = (BasketProduct)var3.next();
         var2.add(new BasketProduct(var4.getProductId(), var4.getPrice(), var4.getQuantity()));
      }

      return var2;
   }

   public CopyOnWriteArrayList<BasketProduct> getBasketProductList() {
      return this.basketProductList;
   }

   public Currency getCurrency() {
      return (Currency)this.currency.get();
   }

   public String getTransactionId() {
      return (String)this.transactionId.get();
   }

   public void setBasketProductList(Iterable<BasketProduct> var1) {
      if(var1 == null) {
         CRTOLog.method_473("Argument basketProductList must not be null");
      } else {
         this.basketProductList = this.makeBasketProducts(var1);
      }
   }

   public void setTransactionId(String var1) {
      if(var1 == null) {
         CRTOLog.method_473("Argument transactionId must not be null");
      } else {
         this.transactionId.set(var1);
      }
   }
}
