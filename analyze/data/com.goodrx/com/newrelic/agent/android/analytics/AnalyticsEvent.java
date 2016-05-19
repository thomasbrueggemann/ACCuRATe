package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEventCategory;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class AnalyticsEvent extends HarvestableObject {
   private Set<AnalyticAttribute> attributeSet;
   private AnalyticsEventCategory category;
   private String eventType;
   private final AgentLog log;
   private String name;
   private long timestamp;

   protected AnalyticsEvent(String var1) {
      this(var1, AnalyticsEventCategory.Custom, (String)null, (Set)null);
   }

   protected AnalyticsEvent(String var1, AnalyticsEventCategory var2) {
      this(var1, var2, (String)null, (Set)null);
   }

   private AnalyticsEvent(String var1, AnalyticsEventCategory var2, String var3, long var4, Set<AnalyticAttribute> var6) {
      this.log = AgentLogManager.getAgentLog();
      this.attributeSet = Collections.synchronizedSet(new HashSet());
      this.name = var1;
      if(var2 == null) {
         this.category = AnalyticsEventCategory.Custom;
      } else {
         this.category = var2;
      }

      if(var3 == null) {
         this.eventType = "Mobile";
      } else {
         this.eventType = var3;
      }

      this.timestamp = var4;
      if(var6 != null) {
         Iterator var11 = var6.iterator();

         while(var11.hasNext()) {
            AnalyticAttribute var12 = (AnalyticAttribute)var11.next();
            this.attributeSet.add(new AnalyticAttribute(var12));
         }
      }

      if(var1 != null) {
         this.attributeSet.add(new AnalyticAttribute("name", this.name));
      }

      this.attributeSet.add(new AnalyticAttribute("timestamp", String.valueOf(this.timestamp)));
      this.attributeSet.add(new AnalyticAttribute("category", this.category.name()));
      this.attributeSet.add(new AnalyticAttribute("eventType", this.eventType));
   }

   protected AnalyticsEvent(String var1, AnalyticsEventCategory var2, String var3, Set<AnalyticAttribute> var4) {
      this(var1, var2, var3, System.currentTimeMillis(), var4);
   }

   public static AnalyticsEvent newFromJson(JsonObject var0) {
      Iterator var1 = var0.entrySet().iterator();
      String var2 = null;
      String var3 = null;
      AnalyticsEventCategory var4 = null;
      long var5 = 0L;
      HashSet var7 = new HashSet();

      while(var1.hasNext()) {
         Entry var8 = (Entry)var1.next();
         String var9 = (String)var8.getKey();
         if(var9.equalsIgnoreCase("name")) {
            var2 = ((JsonElement)var8.getValue()).getAsString();
         } else if(var9.equalsIgnoreCase("category")) {
            var4 = AnalyticsEventCategory.fromString(((JsonElement)var8.getValue()).getAsString());
         } else if(var9.equalsIgnoreCase("eventType")) {
            var3 = ((JsonElement)var8.getValue()).getAsString();
         } else if(var9.equalsIgnoreCase("timestamp")) {
            var5 = ((JsonElement)var8.getValue()).getAsLong();
         } else {
            JsonPrimitive var10 = ((JsonElement)var8.getValue()).getAsJsonPrimitive();
            if(var10.isString()) {
               var7.add(new AnalyticAttribute(var9, var10.getAsString(), false));
            } else if(var10.isBoolean()) {
               var7.add(new AnalyticAttribute(var9, var10.getAsBoolean(), false));
            } else if(var10.isNumber()) {
               var7.add(new AnalyticAttribute(var9, var10.getAsFloat(), false));
            }
         }
      }

      return new AnalyticsEvent(var2, var4, var3, var5, var7);
   }

   public static Collection<AnalyticsEvent> newFromJson(JsonArray var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         var1.add(newFromJson(((JsonElement)var2.next()).getAsJsonObject()));
      }

      return var1;
   }

   public void addAttributes(Set<AnalyticAttribute> var1) {
      if(var1 != null) {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            AnalyticAttribute var3 = (AnalyticAttribute)var2.next();
            if(!this.attributeSet.add(var3)) {
               this.log.error("Failed to add attribute " + var3.getName() + " to event " + this.getName() + ": the event already contains that attribute.");
            }
         }
      }

   }

   public JsonObject asJsonObject() {
      // $FF: Couldn't be decompiled
   }

   public Collection<AnalyticAttribute> getAttributeSet() {
      return Collections.unmodifiableCollection(this.attributeSet);
   }

   public AnalyticsEventCategory getCategory() {
      return this.category;
   }

   public String getEventType() {
      return this.eventType;
   }

   public String getName() {
      return this.name;
   }

   public long getTimestamp() {
      return this.timestamp;
   }
}
