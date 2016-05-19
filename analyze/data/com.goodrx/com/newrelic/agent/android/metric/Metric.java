package com.newrelic.agent.android.metric;

import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;

public class Metric extends HarvestableObject {
   private long count;
   private Double exclusive;
   private Double max;
   private Double min;
   private String name;
   private String scope;
   private Double sumOfSquares;
   private Double total;

   public Metric(Metric var1) {
      this.name = var1.getName();
      this.scope = var1.getScope();
      this.min = Double.valueOf(var1.getMin());
      this.max = Double.valueOf(var1.getMax());
      this.total = Double.valueOf(var1.getTotal());
      this.sumOfSquares = Double.valueOf(var1.getSumOfSquares());
      this.exclusive = Double.valueOf(var1.getExclusive());
      this.count = var1.getCount();
   }

   public Metric(String var1) {
      this(var1, (String)null);
   }

   public Metric(String var1, String var2) {
      this.name = var1;
      this.scope = var2;
      this.count = 0L;
   }

   public void addExclusive(double var1) {
      if(this.exclusive == null) {
         this.exclusive = Double.valueOf(var1);
      } else {
         this.exclusive = Double.valueOf(var1 + this.exclusive.doubleValue());
      }
   }

   public void aggregate(Metric var1) {
      if(var1 != null) {
         this.increment(var1.getCount());
         if(!var1.isCountOnly()) {
            double var2;
            if(this.total == null) {
               var2 = var1.getTotal();
            } else {
               var2 = this.total.doubleValue() + var1.getTotal();
            }

            this.total = Double.valueOf(var2);
            double var4;
            if(this.sumOfSquares == null) {
               var4 = var1.getSumOfSquares();
            } else {
               var4 = this.sumOfSquares.doubleValue() + var1.getSumOfSquares();
            }

            this.sumOfSquares = Double.valueOf(var4);
            double var6;
            if(this.exclusive == null) {
               var6 = var1.getExclusive();
            } else {
               var6 = this.exclusive.doubleValue() + var1.getExclusive();
            }

            this.exclusive = Double.valueOf(var6);
            this.setMin(Double.valueOf(var1.getMin()));
            this.setMax(Double.valueOf(var1.getMax()));
            return;
         }
      }

   }

   public JsonElement asJson() {
      return (JsonElement)(this.isCountOnly()?new JsonPrimitive(Long.valueOf(this.count)):this.asJsonObject());
   }

   public JsonObject asJsonObject() {
      JsonObject var1 = new JsonObject();
      var1.add("count", new JsonPrimitive(Long.valueOf(this.count)));
      if(this.total != null) {
         var1.add("total", new JsonPrimitive(this.total));
      }

      if(this.min != null) {
         var1.add("min", new JsonPrimitive(this.min));
      }

      if(this.max != null) {
         var1.add("max", new JsonPrimitive(this.max));
      }

      if(this.sumOfSquares != null) {
         var1.add("sum_of_squares", new JsonPrimitive(this.sumOfSquares));
      }

      if(this.exclusive != null) {
         var1.add("exclusive", new JsonPrimitive(this.exclusive));
      }

      return var1;
   }

   public void clear() {
      this.min = null;
      this.max = null;
      this.total = null;
      this.sumOfSquares = null;
      this.exclusive = null;
      this.count = 0L;
   }

   public long getCount() {
      return this.count;
   }

   public double getExclusive() {
      return this.exclusive == null?0.0D:this.exclusive.doubleValue();
   }

   public double getMax() {
      return this.max == null?0.0D:this.max.doubleValue();
   }

   public double getMin() {
      return this.min == null?0.0D:this.min.doubleValue();
   }

   public String getName() {
      return this.name;
   }

   public String getScope() {
      return this.scope;
   }

   public String getStringScope() {
      return this.scope == null?"":this.scope;
   }

   public double getSumOfSquares() {
      return this.sumOfSquares == null?0.0D:this.sumOfSquares.doubleValue();
   }

   public double getTotal() {
      return this.total == null?0.0D:this.total.doubleValue();
   }

   public void increment() {
      this.increment(1L);
   }

   public void increment(long var1) {
      this.count += var1;
   }

   public boolean isCountOnly() {
      return this.total == null;
   }

   public boolean isScoped() {
      return this.scope != null;
   }

   public boolean isUnscoped() {
      return this.scope == null;
   }

   public void sample(double var1) {
      ++this.count;
      if(this.total == null) {
         this.total = Double.valueOf(var1);
         this.sumOfSquares = Double.valueOf(var1 * var1);
      } else {
         this.total = Double.valueOf(var1 + this.total.doubleValue());
         this.sumOfSquares = Double.valueOf(this.sumOfSquares.doubleValue() + var1 * var1);
      }

      this.setMin(Double.valueOf(var1));
      this.setMax(Double.valueOf(var1));
   }

   public void setCount(long var1) {
      this.count = var1;
   }

   public void setExclusive(Double var1) {
      this.exclusive = var1;
   }

   public void setMax(Double var1) {
      if(var1 != null) {
         if(this.max == null) {
            this.max = var1;
            return;
         }

         if(var1.doubleValue() > this.max.doubleValue()) {
            this.max = var1;
            return;
         }
      }

   }

   public void setMaxFieldValue(Double var1) {
      this.max = var1;
   }

   public void setMin(Double var1) {
      if(var1 != null) {
         if(this.min == null) {
            this.min = var1;
            return;
         }

         if(var1.doubleValue() < this.min.doubleValue()) {
            this.min = var1;
            return;
         }
      }

   }

   public void setMinFieldValue(Double var1) {
      this.min = var1;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public void setScope(String var1) {
      this.scope = var1;
   }

   public void setSumOfSquares(Double var1) {
      this.sumOfSquares = var1;
   }

   public void setTotal(Double var1) {
      this.total = var1;
   }

   public String toString() {
      return "Metric{count=" + this.count + ", total=" + this.total + ", max=" + this.max + ", min=" + this.min + ", scope=\'" + this.scope + '\'' + ", name=\'" + this.name + '\'' + ", exclusive=\'" + this.exclusive + '\'' + ", sumofsquares=\'" + this.sumOfSquares + '\'' + '}';
   }
}
