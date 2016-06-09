package com.goodrx.model;

public class Store {
   String address;
   String distance;
   String drug_id;
   double latitude;
   double longitude;
   String name;
   String pharmacy_id;
   double price;
   String price_type;
   int quantity;

   public String getAddress() {
      return this.address;
   }

   public String getDistance() {
      return this.distance;
   }

   public String getDrug_id() {
      return this.drug_id;
   }

   public double getLatitude() {
      return this.latitude;
   }

   public double getLongitude() {
      return this.longitude;
   }

   public String getName() {
      return this.name;
   }

   public String getPharmacy_id() {
      return this.pharmacy_id;
   }

   public double getPrice() {
      return this.price;
   }

   public String getPrice_type() {
      return this.price_type;
   }

   public int getQuantity() {
      return this.quantity;
   }

   public String getShortName() {
      StringBuilder var1 = new StringBuilder();
      String[] var2 = this.name.split(" ");
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         if(var5.length() != 0) {
            if(var5.equals("Pharmacy") || var5.charAt(0) == 35 || var5.charAt(0) >= 48 && var5.charAt(0) <= 57) {
               break;
            }

            var1.append(var5);
            var1.append(" ");
         }
      }

      return var1.substring(0, -1 + var1.length());
   }
}
