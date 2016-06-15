package com.smartmobilesoftware.util;

import org.json.JSONException;
import org.json.JSONObject;

public class SkuDetails {
   String mDescription;
   String mItemType;
   String mJson;
   String mPrice;
   String mSku;
   String mTitle;
   String mType;

   public SkuDetails(String var1) throws JSONException {
      this("inapp", var1);
   }

   public SkuDetails(String var1, String var2) throws JSONException {
      this.mItemType = var1;
      this.mJson = var2;
      JSONObject var3 = new JSONObject(this.mJson);
      this.mSku = var3.optString("productId");
      this.mType = var3.optString("type");
      this.mPrice = var3.optString("price");
      this.mTitle = var3.optString("title");
      this.mDescription = var3.optString("description");
   }

   public String getDescription() {
      return this.mDescription;
   }

   public String getPrice() {
      return this.mPrice;
   }

   public String getSku() {
      return this.mSku;
   }

   public String getTitle() {
      return this.mTitle;
   }

   public String getType() {
      return this.mType;
   }

   public JSONObject toJson() throws JSONException {
      return new JSONObject(this.mJson);
   }

   public String toString() {
      return "SkuDetails:" + this.mJson;
   }
}
