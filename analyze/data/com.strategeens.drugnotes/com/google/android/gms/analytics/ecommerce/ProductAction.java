package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.internal.class_335;
import java.util.HashMap;
import java.util.Map;

public class ProductAction {
   public static final String ACTION_ADD = "add";
   public static final String ACTION_CHECKOUT = "checkout";
   public static final String ACTION_CHECKOUT_OPTION = "checkout_option";
   @Deprecated
   public static final String ACTION_CHECKOUT_OPTIONS = "checkout_options";
   public static final String ACTION_CLICK = "click";
   public static final String ACTION_DETAIL = "detail";
   public static final String ACTION_PURCHASE = "purchase";
   public static final String ACTION_REFUND = "refund";
   public static final String ACTION_REMOVE = "remove";
   // $FF: renamed from: CD java.util.Map
   Map<String, String> field_2927 = new HashMap();

   public ProductAction(String var1) {
      this.put("&pa", var1);
   }

   public Map<String, String> build() {
      return new HashMap(this.field_2927);
   }

   void put(String var1, String var2) {
      class_335.method_2306(var1, "Name should be non-null");
      this.field_2927.put(var1, var2);
   }

   public ProductAction setCheckoutOptions(String var1) {
      this.put("&col", var1);
      return this;
   }

   public ProductAction setCheckoutStep(int var1) {
      this.put("&cos", Integer.toString(var1));
      return this;
   }

   public ProductAction setProductActionList(String var1) {
      this.put("&pal", var1);
      return this;
   }

   public ProductAction setProductListSource(String var1) {
      this.put("&pls", var1);
      return this;
   }

   public ProductAction setTransactionAffiliation(String var1) {
      this.put("&ta", var1);
      return this;
   }

   public ProductAction setTransactionCouponCode(String var1) {
      this.put("&tcc", var1);
      return this;
   }

   public ProductAction setTransactionId(String var1) {
      this.put("&ti", var1);
      return this;
   }

   public ProductAction setTransactionRevenue(double var1) {
      this.put("&tr", Double.toString(var1));
      return this;
   }

   public ProductAction setTransactionShipping(double var1) {
      this.put("&ts", Double.toString(var1));
      return this;
   }

   public ProductAction setTransactionTax(double var1) {
      this.put("&tt", Double.toString(var1));
      return this;
   }
}
