package com.goodrx.model;

public class PharmacyObject {
   private String alternate_logo;
   private String block_cash_price;
   private String block_drug_name;
   private String block_logo;
   private String block_pharmacy_name;
   private Double closest_location;
   private String disclaimer;
   private String has_24hr;
   // $FF: renamed from: id java.lang.String
   private String field_144;
   private String info;
   private String name;
   private int number_of_locations;
   private String type;
   private String use_discount_noun;

   private boolean convertStringToBoolean(String var1) {
      return !var1.equals("0") && !var1.equalsIgnoreCase("false");
   }

   public String getAlternate_logo() {
      return this.alternate_logo;
   }

   public Double getClosest_location() {
      return this.closest_location;
   }

   public String getDisclaimer() {
      return this.disclaimer;
   }

   public String getId() {
      return this.field_144;
   }

   public String getInfo() {
      return this.info;
   }

   public String getName() {
      return this.name;
   }

   public int getNumber_of_locations() {
      return this.number_of_locations;
   }

   public String getType() {
      return this.type;
   }

   public boolean isBlock_cash_price() {
      return this.convertStringToBoolean(this.block_cash_price);
   }

   public boolean isBlock_drug_name() {
      return this.convertStringToBoolean(this.block_drug_name);
   }

   public boolean isBlock_pharmacy_name() {
      return this.convertStringToBoolean(this.block_pharmacy_name);
   }

   public boolean isHas_24hr() {
      return this.convertStringToBoolean(this.has_24hr);
   }

   public boolean isUse_discount_noun() {
      return this.convertStringToBoolean(this.use_discount_noun);
   }

   public boolean shouldBlock_logo() {
      return this.convertStringToBoolean(this.block_logo);
   }
}
