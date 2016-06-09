package com.mobileapptracker;

import java.util.HashMap;
import org.json.JSONObject;

public class MATEventItem {
   public String attribute_sub1;
   public String attribute_sub2;
   public String attribute_sub3;
   public String attribute_sub4;
   public String attribute_sub5;
   public String itemname;
   public int quantity;
   public double revenue;
   public double unitPrice;

   public MATEventItem(String var1) {
      this.itemname = var1;
   }

   public String getAttrStringByName(String var1) {
      return var1.equals("itemname")?this.itemname:(var1.equals("quantity")?Integer.toString(this.quantity):(var1.equals("unitPrice")?Double.toString(this.unitPrice):(var1.equals("revenue")?Double.toString(this.revenue):(var1.equals("attribute_sub1")?this.attribute_sub1:(var1.equals("attribute_sub2")?this.attribute_sub2:(var1.equals("attribute_sub3")?this.attribute_sub3:(var1.equals("attribute_sub4")?this.attribute_sub4:(var1.equals("attribute_sub5")?this.attribute_sub5:null))))))));
   }

   public JSONObject toJSON() {
      HashMap var1 = new HashMap();
      if(this.itemname != null) {
         var1.put("item", this.itemname);
      }

      var1.put("quantity", Integer.toString(this.quantity));
      var1.put("unit_price", Double.toString(this.unitPrice));
      if(this.revenue != 0.0D) {
         var1.put("revenue", Double.toString(this.revenue));
      }

      if(this.attribute_sub1 != null) {
         var1.put("attribute_sub1", this.attribute_sub1);
      }

      if(this.attribute_sub2 != null) {
         var1.put("attribute_sub2", this.attribute_sub2);
      }

      if(this.attribute_sub3 != null) {
         var1.put("attribute_sub3", this.attribute_sub3);
      }

      if(this.attribute_sub4 != null) {
         var1.put("attribute_sub4", this.attribute_sub4);
      }

      if(this.attribute_sub5 != null) {
         var1.put("attribute_sub5", this.attribute_sub5);
      }

      return new JSONObject(var1);
   }

   public MATEventItem withAttribute1(String var1) {
      this.attribute_sub1 = var1;
      return this;
   }

   public MATEventItem withAttribute2(String var1) {
      this.attribute_sub2 = var1;
      return this;
   }

   public MATEventItem withAttribute3(String var1) {
      this.attribute_sub3 = var1;
      return this;
   }

   public MATEventItem withAttribute4(String var1) {
      this.attribute_sub4 = var1;
      return this;
   }

   public MATEventItem withAttribute5(String var1) {
      this.attribute_sub5 = var1;
      return this;
   }

   public MATEventItem withQuantity(int var1) {
      this.quantity = var1;
      return this;
   }

   public MATEventItem withRevenue(double var1) {
      this.revenue = var1;
      return this;
   }

   public MATEventItem withUnitPrice(double var1) {
      this.unitPrice = var1;
      return this;
   }
}
