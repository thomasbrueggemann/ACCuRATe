package com.goodrx.model;

public class DataQ {
   boolean compounding_service;
   boolean delivery_service;
   boolean drive_up_window;
   String fax;
   boolean has_features;
   String[][] hours;
   String[] languages;
   boolean open24;
   String phone;
   String[] provider_codes;
   boolean walk_in_clinic;

   public String getFax() {
      return this.fax;
   }

   public String[][] getHours() {
      return this.hours;
   }

   public String[] getLanguages() {
      return this.languages;
   }

   public String getPhone() {
      return this.phone;
   }

   public String[] getProvider_codes() {
      return this.provider_codes;
   }

   public boolean hasCompoundingService() {
      return this.compounding_service;
   }

   public boolean hasDeliveryService() {
      return this.delivery_service;
   }

   public boolean hasDriveUpWindow() {
      return this.drive_up_window;
   }

   public boolean hasFeatures() {
      return this.has_features;
   }

   public boolean isOpen24() {
      return this.open24;
   }

   public boolean isWalk_in_clinic() {
      return this.walk_in_clinic;
   }
}
