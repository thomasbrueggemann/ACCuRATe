package com.goodrx.model;

public class CouponObject {
   private String coupon_network;
   private String customer_phone;
   private String member_id;
   private String pharmacist_phone;
   private String rxbin;
   private String rxgroup;
   private String rxgroup_mobile;
   private String rxpcn;

   public String getCoupon_network() {
      return this.coupon_network;
   }

   public String getCustomer_phone() {
      return this.customer_phone;
   }

   public String getMember_id() {
      return this.member_id;
   }

   public String getPharmacist_phone() {
      return this.pharmacist_phone;
   }

   public String getRxbin() {
      return this.rxbin;
   }

   public String getRxgroup() {
      return this.rxgroup;
   }

   public String getRxgroup_mobile() {
      return this.rxgroup_mobile;
   }

   public String getRxpcn() {
      return this.rxpcn;
   }

   public void setCoupon_network(String var1) {
      this.coupon_network = var1;
   }

   public void setCustomer_phone(String var1) {
      this.customer_phone = var1;
   }

   public void setMember_id(String var1) {
      this.member_id = var1;
   }

   public void setPharmacist_phone(String var1) {
      this.pharmacist_phone = var1;
   }

   public void setRxbin(String var1) {
      this.rxbin = var1;
   }

   public void setRxgroup(String var1) {
      this.rxgroup = var1;
   }

   public void setRxgroup_mobile(String var1) {
      this.rxgroup_mobile = var1;
   }

   public void setRxpcn(String var1) {
      this.rxpcn = var1;
   }
}
