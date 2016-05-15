package com.comscore.applications;

import com.comscore.analytics.Core;
import com.comscore.applications.ApplicationMeasurement;
import com.comscore.applications.EventType;
import com.comscore.measurement.Label;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AggregateMeasurement extends ApplicationMeasurement {
   protected AggregateMeasurement(Core var1, EventType var2, String var3) {
      super(var1, var2, var3);
   }

   // $FF: renamed from: a (java.lang.String) java.lang.Boolean
   private Boolean method_323(String var1) {
      for(int var2 = 0; var2 < var1.length(); ++var2) {
         if(!"0123456789".contains("" + var1.charAt(var2))) {
            return Boolean.valueOf(false);
         }
      }

      return Boolean.valueOf(true);
   }

   // $FF: renamed from: b (java.lang.String) java.lang.Boolean
   private Boolean method_324(String var1) {
      return var1 == null?Boolean.valueOf(false):(!var1.contains(",")?Boolean.valueOf(false):(!var1.contains(" ")?Boolean.valueOf(true):Boolean.valueOf(false)));
   }

   // $FF: renamed from: b (java.lang.String, java.lang.String) java.lang.Boolean
   private Boolean method_325(String var1, String var2) {
      return Boolean.valueOf(var1.contains(var2));
   }

   // $FF: renamed from: c (java.lang.String, java.lang.String) java.lang.String
   private String method_326(String var1, String var2) {
      StringBuilder var3 = new StringBuilder(var2);
      Iterator var4 = this.method_327(var1).iterator();

      while(true) {
         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            if(!var3.toString().contains(var5)) {
               if(var3.toString().equals("")) {
                  var3.append(var5).append(":1");
               } else {
                  var3.append(";").append(var5).append(":1");
               }
            } else {
               String[] var6 = var3.toString().split(";");

               for(int var7 = 0; var7 < var6.length; ++var7) {
                  if(var6[var7].contains(var5)) {
                     String[] var8 = var6[var7].split(":");
                     Integer var9 = Integer.valueOf(1 + Integer.valueOf(var8[1]).intValue());
                     String var10 = var8[0] + ":" + var9;
                     var3.replace(var3.indexOf(var6[var7]), var3.indexOf(var6[var7]) + var6[var7].length(), var10);
                  }
               }
            }
         }

         return var3.toString();
      }
   }

   // $FF: renamed from: c (java.lang.String) java.util.List
   private List<String> method_327(String var1) {
      String[] var2 = var1.split(",");
      ArrayList var3 = new ArrayList();

      for(int var4 = 0; var4 < var2.length; ++var4) {
         var3.add(var2[var4]);
      }

      return var3;
   }

   public void aggregateLabels(List<Label> var1) {
      Iterator var2 = var1.iterator();

      while(true) {
         while(var2.hasNext()) {
            Label var3 = (Label)var2.next();
            Label var4 = (Label)this.a.get(var3.name);
            if(var4 == null) {
               if(this.method_324(var3.value).booleanValue()) {
                  String var8 = this.method_326(var3.value, "");
                  this.setLabel(var3.name, var8, Boolean.valueOf(true));
               } else {
                  this.setLabel(var3);
               }
            } else if(this.method_323(var4.value).booleanValue() && this.method_323(var3.value).booleanValue()) {
               Integer var7 = Integer.valueOf(Integer.valueOf(var4.value).intValue() + Integer.valueOf(var3.value).intValue());
               this.setLabel(var4.name, var7.toString(), Boolean.valueOf(true));
            } else if(this.method_324(var3.value).booleanValue()) {
               String var6 = this.method_326(var3.value, var4.value);
               this.setLabel(var3.name, var6, Boolean.valueOf(true));
            } else if(!this.method_325(var4.value, var3.value).booleanValue()) {
               String var5 = var4.value + "," + var3.value;
               this.setLabel(var4.name, var5, Boolean.valueOf(true));
            }
         }

         return;
      }
   }

   public void formatLists() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.a.values().iterator();

      while(var2.hasNext()) {
         Label var5 = (Label)var2.next();
         if(this.method_324(var5.value).booleanValue()) {
            var1.add(var5);
         }
      }

      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Label var4 = (Label)var3.next();
         this.setLabel(var4.name, this.method_326(var4.value, ""), Boolean.valueOf(true));
      }

   }

   public List<Label> getAggregateLabels() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.a.values().iterator();

      while(var2.hasNext()) {
         Label var3 = (Label)var2.next();
         if(var3.aggregate.booleanValue()) {
            var1.add(var3);
         }
      }

      return var1;
   }
}
