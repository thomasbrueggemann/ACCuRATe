package com.newrelic.agent.android.unity;

import java.util.HashMap;
import java.util.Map;

public class UnityEvent {
   private Map<String, Object> attributes;
   private String name;

   public UnityEvent(String var1) {
      this.name = var1;
      this.attributes = new HashMap();
   }

   public void addAttribute(String var1, Double var2) {
      this.attributes.put(var1, var2);
   }

   public void addAttribute(String var1, String var2) {
      this.attributes.put(var1, var2);
   }

   public Map<String, Object> getAttributes() {
      return this.attributes;
   }

   public String getName() {
      return this.name;
   }

   public void setAttributes(Map<String, Object> var1) {
      this.attributes = var1;
   }
}
