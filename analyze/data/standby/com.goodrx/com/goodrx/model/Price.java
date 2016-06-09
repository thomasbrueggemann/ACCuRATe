package com.goodrx.model;

import com.goodrx.model.PharmacyLocationObject;
import com.goodrx.model.PharmacyObject;

public class Price {
   private String coupon_network;
   private Double discount_program_cost;
   private String discount_program_description;
   private String discount_program_url;
   private String no_price_disclaimer;
   private String note;
   private String[] other_price_data;
   private String[][] other_price_fields;
   private PharmacyLocationObject[] pharmacy_locations_object;
   private PharmacyObject pharmacy_object;
   private String phone;
   private double price;
   private Double savings;
   private String savings_percent;
   private boolean show_discount_card;
   private String type;
   private String type_display;
   private String url;

   public String getCoupon_network() {
      return this.coupon_network;
   }

   public Double getDiscount_program_cost() {
      return this.discount_program_cost;
   }

   public String getDiscount_program_description() {
      return this.discount_program_description;
   }

   public String getDiscount_program_url() {
      return this.discount_program_url;
   }

   public String getNo_price_disclaimer() {
      return this.no_price_disclaimer;
   }

   public String getNote() {
      return this.note;
   }

   public String[] getOther_price_data() {
      return this.other_price_data;
   }

   public String[][] getOther_price_fields() {
      return this.other_price_fields;
   }

   public PharmacyLocationObject[] getPharmacy_locations_object() {
      return this.pharmacy_locations_object;
   }

   public PharmacyObject getPharmacy_object() {
      return this.pharmacy_object;
   }

   public String getPhone() {
      return this.phone;
   }

   public double getPrice() {
      return this.price;
   }

   public Double getSavings() {
      return this.savings;
   }

   public String getSavings_percent() {
      return this.savings_percent;
   }

   public String getType() {
      return this.type;
   }

   public String getType_display() {
      return this.type_display;
   }

   public String getUrl() {
      return this.url;
   }

   public boolean isShow_discount_card() {
      return this.show_discount_card;
   }

   public void setPharmacy_object(PharmacyObject var1) {
      this.pharmacy_object = var1;
   }
}
