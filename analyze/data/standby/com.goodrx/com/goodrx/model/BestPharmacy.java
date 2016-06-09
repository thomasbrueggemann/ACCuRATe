package com.goodrx.model;

import android.content.Context;
import com.goodrx.model.CouponInfo;
import com.goodrx.model.PharmacyLocationObject;

public class BestPharmacy {
   private CouponInfo account;
   private String coupon_display;
   private double distance;
   private BestPharmacy.Entry[] entries;
   private String name;
   private String pharm_id;
   private PharmacyLocationObject[] pharmacy_info;
   private double total_price;
   private String type;

   public CouponInfo getAccount() {
      return this.account;
   }

   public String getCoupon_display() {
      return this.coupon_display;
   }

   public double getDistance() {
      return this.distance;
   }

   public BestPharmacy.Entry[] getEntries() {
      return this.entries;
   }

   public String getName() {
      return this.name;
   }

   public String getPharm_id() {
      return this.pharm_id;
   }

   public PharmacyLocationObject[] getPharmacy_info() {
      return this.pharmacy_info;
   }

   public double getTotal_price() {
      return this.total_price;
   }

   public String getType() {
      return this.type;
   }

   public class Entry {
      private String brand;
      private String dosage;
      private String drug_id;
      private String generic;
      private double price;
      private String qty_form;
      private String selected_drug;
      private String type;

      public String getAmount() {
         return this.qty_form + " " + this.dosage;
      }

      public String getBrand() {
         return this.brand;
      }

      public String getDisplay(Context var1) {
         String var2;
         if(this.selected_drug.equals(this.brand)) {
            var2 = this.selected_drug + " (" + var1.getString(2131427446) + ")";
         } else {
            var2 = this.selected_drug;
            if(this.brand != null && this.brand.length() > 0) {
               return var2 + " (" + var1.getString(2131427599) + " " + this.brand + ")";
            }
         }

         return var2;
      }

      public String getDosage() {
         return this.dosage;
      }

      public String getDrug_id() {
         return this.drug_id;
      }

      public String getGeneric() {
         return this.generic;
      }

      public double getPrice() {
         return this.price;
      }

      public String getQty_form() {
         return this.qty_form;
      }

      public String getSelected_drug() {
         return this.selected_drug;
      }

      public String getType() {
         return this.type;
      }
   }
}
