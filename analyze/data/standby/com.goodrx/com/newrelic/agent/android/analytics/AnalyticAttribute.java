package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class AnalyticAttribute {
   public static final String ACCOUNT_ID_ATTRIBUTE = "accountId";
   public static final String APP_ID_ATTRIBUTE = "appId";
   public static final String APP_INSTALL_ATTRIBUTE = "install";
   public static final String APP_NAME_ATTRIBUTE = "appName";
   public static final String APP_UPGRADE_ATTRIBUTE = "upgradeFrom";
   public static final int ATTRIBUTE_NAME_MAX_LENGTH = 256;
   public static final int ATTRIBUTE_VALUE_MAX_LENGTH = 4096;
   public static final String CAMPAIGN_ID_ATTRIBUTE = "campaignId";
   public static final String CARRIER_ATTRIBUTE = "carrier";
   public static final String DEVICE_MANUFACTURER_ATTRIBUTE = "deviceManufacturer";
   public static final String DEVICE_MODEL_ATTRIBUTE = "deviceModel";
   private static final String DOUBLE_ATTRIBUTE_FORMAT = "\"%s\"=%f";
   public static final String EVENT_CATEGORY_ATTRIBUTE = "category";
   public static final String EVENT_NAME_ATTRIBUTE = "name";
   public static final String EVENT_SESSION_ELAPSED_TIME_ATTRIBUTE = "sessionElapsedTime";
   public static final String EVENT_TIMESTAMP_ATTRIBUTE = "timestamp";
   public static final String EVENT_TIME_SINCE_LOAD_ATTRIBUTE = "timeSinceLoad";
   public static final String EVENT_TYPE_ATTRIBUTE = "eventType";
   public static final String EVENT_TYPE_ATTRIBUTE_MOBILE = "Mobile";
   public static final String INTERACTION_DURATION_ATTRIBUTE = "interactionDuration";
   public static final String MEM_USAGE_MB_ATTRIBUTE = "memUsageMb";
   public static final String NEW_RELIC_VERSION_ATTRIBUTE = "newRelicVersion";
   public static final String OS_MAJOR_VERSION_ATTRIBUTE = "osMajorVersion";
   public static final String OS_NAME_ATTRIBUTE = "osName";
   public static final String OS_VERSION_ATTRIBUTE = "osVersion";
   public static final String PURCHASE_EVENT_ATTRIBUTE = "Purchase";
   public static final String PURCHASE_EVENT_QUANTITY_ATTRIBUTE = "quantity";
   public static final String PURCHASE_EVENT_SKU_ATTRIBUTE = "sku";
   public static final String PURCHASE_EVENT_TOTAL_PRICE_ATTRIBUTE = "total";
   public static final String PURCHASE_EVENT_UNIT_PRICE_ATTRIBUTE = "unitprice";
   public static final String SESSION_DURATION_ATTRIBUTE = "sessionDuration";
   public static final String SESSION_ID_ATTRIBUTE = "sessionId";
   public static final String SESSION_REVENUE_ATTRIBUTE = "sessionRevenue";
   public static final String SESSION_TIME_SINCE_LOAD_ATTRIBUTE = "timeSinceLoad";
   private static final String STRING_ATTRIBUTE_FORMAT = "\"%s\"=\"%s\"";
   public static final String SUBSCRIPTION_ATTRIBUTE = "subscription";
   public static final String SUBSCRIPTION_REVENUE_ATTRIBUTE = "subscriptionRevenue";
   public static final String TYPE_ATTRIBUTE = "type";
   public static final String USERNAME_ATTRIBUTE = "username";
   public static final String USER_EMAIL_ATTRIBUTE = "email";
   public static final String USER_ID_ATTRIBUTE = "userId";
   public static final String UUID_ATTRIBUTE = "uuid";
   protected static Set<String> blackList = new HashSet() {
      {
         this.add("install");
         this.add("upgradeFrom");
         this.add("sessionDuration");
      }
   };
   private AnalyticAttribute.AttributeDataType attributeDataType;
   private float floatValue;
   private boolean isPersistent;
   private String name;
   private String stringValue;

   protected AnalyticAttribute() {
      this.stringValue = null;
      this.floatValue = Float.NaN;
      this.isPersistent = false;
      this.attributeDataType = AnalyticAttribute.AttributeDataType.VOID;
   }

   public AnalyticAttribute(AnalyticAttribute var1) {
      this.name = var1.name;
      this.floatValue = var1.floatValue;
      this.stringValue = var1.stringValue;
      this.isPersistent = var1.isPersistent;
      this.attributeDataType = var1.attributeDataType;
   }

   public AnalyticAttribute(String var1, float var2) {
      this(var1, var2, true);
   }

   public AnalyticAttribute(String var1, float var2, boolean var3) {
      this.name = var1;
      this.setFloatValue(var2);
      this.isPersistent = var3;
   }

   public AnalyticAttribute(String var1, String var2) {
      this(var1, var2, true);
   }

   public AnalyticAttribute(String var1, String var2, boolean var3) {
      this.name = var1;
      this.setStringValue(var2);
      this.isPersistent = var3;
   }

   public AnalyticAttribute(String var1, boolean var2) {
      this(var1, var2, true);
   }

   public AnalyticAttribute(String var1, boolean var2, boolean var3) {
      this.name = var1;
      this.setBooleanValue(var2);
      this.isPersistent = var3;
   }

   public static boolean isAttributeBlacklisted(AnalyticAttribute var0) {
      return blackList.contains(var0.getName());
   }

   public static Set<AnalyticAttribute> newFromJson(JsonObject var0) {
      HashSet var1 = new HashSet();
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         String var4 = (String)var3.getKey();
         if(((JsonElement)var3.getValue()).isJsonPrimitive()) {
            JsonPrimitive var6 = ((JsonElement)var3.getValue()).getAsJsonPrimitive();
            if(var6.isString()) {
               var1.add(new AnalyticAttribute(var4, var6.getAsString(), false));
            } else if(var6.isBoolean()) {
               var1.add(new AnalyticAttribute(var4, var6.getAsBoolean(), false));
            } else if(var6.isNumber()) {
               var1.add(new AnalyticAttribute(var4, var6.getAsFloat(), false));
            }
         } else {
            var1.add(new AnalyticAttribute(var4, ((JsonElement)var3.getValue()).getAsString(), false));
         }
      }

      return var1;
   }

   public JsonElement asJsonElement() {
      switch(null.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[this.attributeDataType.ordinal()]) {
      case 2:
         return SafeJsonPrimitive.factory(this.getStringValue());
      case 3:
         return SafeJsonPrimitive.factory((Number)Float.valueOf(this.getFloatValue()));
      case 4:
         return SafeJsonPrimitive.factory(Boolean.valueOf(this.getBooleanValue()));
      default:
         return null;
      }
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null || this.getClass() != var1.getClass()) {
            return false;
         }

         AnalyticAttribute var2 = (AnalyticAttribute)var1;
         if(!this.name.equals(var2.name)) {
            return false;
         }
      }

      return true;
   }

   public AnalyticAttribute.AttributeDataType getAttributeDataType() {
      return this.attributeDataType;
   }

   public boolean getBooleanValue() {
      return this.attributeDataType == AnalyticAttribute.AttributeDataType.BOOLEAN?Boolean.valueOf(this.stringValue).booleanValue():false;
   }

   public float getFloatValue() {
      return this.attributeDataType == AnalyticAttribute.AttributeDataType.FLOAT?this.floatValue:Float.NaN;
   }

   public String getName() {
      return this.name;
   }

   public String getStringValue() {
      return this.attributeDataType == AnalyticAttribute.AttributeDataType.STRING?this.stringValue:null;
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   public boolean isBooleanAttribute() {
      return this.attributeDataType == AnalyticAttribute.AttributeDataType.BOOLEAN;
   }

   public boolean isFloatAttribute() {
      return this.attributeDataType == AnalyticAttribute.AttributeDataType.FLOAT;
   }

   public boolean isPersistent() {
      return this.isPersistent && !isAttributeBlacklisted(this);
   }

   public boolean isStringAttribute() {
      return this.attributeDataType == AnalyticAttribute.AttributeDataType.STRING;
   }

   public void setBooleanValue(boolean var1) {
      this.stringValue = Boolean.toString(var1);
      this.floatValue = Float.NaN;
      this.attributeDataType = AnalyticAttribute.AttributeDataType.BOOLEAN;
   }

   public void setFloatValue(float var1) {
      this.floatValue = var1;
      this.stringValue = null;
      this.attributeDataType = AnalyticAttribute.AttributeDataType.FLOAT;
   }

   public void setPersistent(boolean var1) {
      this.isPersistent = var1;
   }

   public void setStringValue(String var1) {
      this.stringValue = var1;
      this.floatValue = Float.NaN;
      this.attributeDataType = AnalyticAttribute.AttributeDataType.STRING;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("AnalyticAttribute{");
      var1.append("name=\'" + this.name + "\'");
      switch(null.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[this.attributeDataType.ordinal()]) {
      case 1:
      default:
         break;
      case 2:
         var1.append(",stringValue=\'" + this.stringValue + "\'");
         break;
      case 3:
         var1.append(",floatValue=\'" + this.floatValue + "\'");
         break;
      case 4:
         var1.append(",booleanValue=" + Boolean.valueOf(this.stringValue).toString());
      }

      var1.append(",isPersistent=" + this.isPersistent);
      var1.append("}");
      return var1.toString();
   }

   public String valueAsString() {
      switch(null.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[this.attributeDataType.ordinal()]) {
      case 2:
         return this.stringValue;
      case 3:
         return Float.toString(this.floatValue);
      case 4:
         return Boolean.valueOf(this.getBooleanValue()).toString();
      default:
         return null;
      }
   }

   public static enum AttributeDataType {
      BOOLEAN,
      FLOAT,
      STRING,
      VOID;

      static {
         AnalyticAttribute.AttributeDataType[] var0 = new AnalyticAttribute.AttributeDataType[]{VOID, STRING, FLOAT, BOOLEAN};
      }
   }
}
