package com.smartmobilesoftware.util;

import org.json.JSONException;
import org.json.JSONObject;

public class Purchase {
   String mDeveloperPayload;
   String mItemType;
   String mOrderId;
   String mOriginalJson;
   String mPackageName;
   int mPurchaseState;
   long mPurchaseTime;
   String mSignature;
   String mSku;
   String mToken;

   public Purchase(String var1, String var2, String var3) throws JSONException {
      this.mItemType = var1;
      this.mOriginalJson = var2;
      JSONObject var4 = new JSONObject(this.mOriginalJson);
      this.mOrderId = var4.optString("orderId");
      this.mPackageName = var4.optString("packageName");
      this.mSku = var4.optString("productId");
      this.mPurchaseTime = var4.optLong("purchaseTime");
      this.mPurchaseState = var4.optInt("purchaseState");
      this.mDeveloperPayload = var4.optString("developerPayload");
      this.mToken = var4.optString("token", var4.optString("purchaseToken"));
      this.mSignature = var3;
   }

   public String getDeveloperPayload() {
      return this.mDeveloperPayload;
   }

   public String getItemType() {
      return this.mItemType;
   }

   public String getOrderId() {
      return this.mOrderId;
   }

   public String getOriginalJson() {
      return this.mOriginalJson;
   }

   public String getPackageName() {
      return this.mPackageName;
   }

   public int getPurchaseState() {
      return this.mPurchaseState;
   }

   public long getPurchaseTime() {
      return this.mPurchaseTime;
   }

   public String getSignature() {
      return this.mSignature;
   }

   public String getSku() {
      return this.mSku;
   }

   public String getToken() {
      return this.mToken;
   }

   public String toString() {
      return "PurchaseInfo(type:" + this.mItemType + "):" + this.mOriginalJson;
   }
}
