package com.goodrx.utils.tracker;

import android.content.Context;
import com.goodrx.model.Condition;
import com.goodrx.model.CouponObject;
import com.goodrx.model.DrugObject;
import com.goodrx.utils.tracker.GAHelper;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.format.DateTimeFormat;

public class CouponGAHelper {
   private CouponObject mCouponObject;
   private DrugObject mDrugObject;
   private String mPharmacyName;
   private String mPrice;

   public CouponGAHelper(CouponObject var1, DrugObject var2, String var3, String var4) {
      this.mCouponObject = var1;
      this.mDrugObject = var2;
      this.mPharmacyName = var3;
      this.mPrice = var4;
   }

   private Map<String, Object> generateDataMap() {
      HashMap var1 = new HashMap();
      var1.put("transactionId", this.mCouponObject.getMember_id());
      var1.put("transactionAffiliation", this.mPharmacyName);
      var1.put("transactionTotal", this.mPrice);
      HashMap var5 = new HashMap();
      var5.put("sku", this.getSku());
      var5.put("name", this.getProductName());
      var5.put("category", this.getCategory());
      var5.put("price", this.mPrice);
      var5.put("quantity", "1");
      var1.put("transactionProducts", var5);
      return var1;
   }

   private String getCategory() {
      Condition[] var1 = this.mDrugObject.getDrug_information().getDrug_conditions();
      if(var1 != null && var1.length != 0) {
         StringBuilder var2 = new StringBuilder();
         int var3 = var1.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            var2.append(var1[var4].getSlug());
            var2.append(",");
         }

         var2.deleteCharAt(-1 + var2.length());
         return var2.toString();
      } else {
         return "";
      }
   }

   private String getCurrentTimeStamp() {
      DateTime var1 = new DateTime();
      return DateTimeFormat.forPattern("yyyyMMddHHmmssSSS").print((ReadableInstant)var1);
   }

   private String getProductName() {
      return (this.mDrugObject.getName() + this.mDrugObject.getDosage_form_display_short()).replaceAll(" ", "");
   }

   private String getSku() {
      String var1 = (new DecimalFormat("00000")).format((long)((int)(10000.0D * Math.random())));
      return this.mCouponObject.getMember_id() + "-" + this.getCurrentTimeStamp() + "-" + var1;
   }

   public void push(Context var1) {
      GAHelper.pushMapToDataLayer(var1, this.generateDataMap());
   }
}
