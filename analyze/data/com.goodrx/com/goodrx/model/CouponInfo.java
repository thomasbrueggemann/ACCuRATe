package com.goodrx.model;

import com.goodrx.model.CouponObject;

public class CouponInfo {
   String member_id;
   String name;
   String pharm_phone;
   String phone;
   String rxbin;
   String rxgroup;
   String rxpcn;

   public CouponObject convertToCouponObject() {
      CouponObject var1 = new CouponObject();
      var1.setMember_id(this.member_id);
      var1.setPharmacist_phone(this.pharm_phone);
      var1.setCustomer_phone(this.phone);
      var1.setRxbin(this.rxbin);
      var1.setRxgroup(this.rxgroup);
      var1.setRxpcn(this.rxpcn);
      var1.setCoupon_network(this.name);
      return var1;
   }

   public String getMember_id() {
      return this.member_id;
   }

   public String getName() {
      return this.name;
   }

   public String getPharm_phone() {
      return this.pharm_phone;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getRxbin() {
      return this.rxbin;
   }

   public String getRxgroup() {
      return this.rxgroup;
   }

   public String getRxpcn() {
      return this.rxpcn;
   }
}
