package com.smartmobilesoftware.util;

import com.smartmobilesoftware.util.Purchase;
import com.smartmobilesoftware.util.SkuDetails;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Inventory {
   Map<String, Purchase> mPurchaseMap = new HashMap();
   Map<String, SkuDetails> mSkuMap = new HashMap();

   public void addPurchase(Purchase var1) {
      this.mPurchaseMap.put(var1.getSku(), var1);
   }

   void addSkuDetails(SkuDetails var1) {
      this.mSkuMap.put(var1.getSku(), var1);
   }

   public void erasePurchase(String var1) {
      if(this.mPurchaseMap.containsKey(var1)) {
         this.mPurchaseMap.remove(var1);
      }

   }

   public List<String> getAllOwnedSkus() {
      return new ArrayList(this.mPurchaseMap.keySet());
   }

   List<String> getAllOwnedSkus(String var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.mPurchaseMap.values().iterator();

      while(var3.hasNext()) {
         Purchase var4 = (Purchase)var3.next();
         if(var4.getItemType().equals(var1)) {
            var2.add(var4.getSku());
         }
      }

      return var2;
   }

   public List<SkuDetails> getAllProducts() {
      return new ArrayList(this.mSkuMap.values());
   }

   public List<Purchase> getAllPurchases() {
      return new ArrayList(this.mPurchaseMap.values());
   }

   public Purchase getPurchase(String var1) {
      return (Purchase)this.mPurchaseMap.get(var1);
   }

   public SkuDetails getSkuDetails(String var1) {
      return (SkuDetails)this.mSkuMap.get(var1);
   }

   public boolean hasDetails(String var1) {
      return this.mSkuMap.containsKey(var1);
   }

   public boolean hasPurchase(String var1) {
      return this.mPurchaseMap.containsKey(var1);
   }
}
