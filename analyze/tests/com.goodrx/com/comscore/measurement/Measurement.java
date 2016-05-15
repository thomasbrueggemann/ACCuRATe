package com.comscore.measurement;

import com.comscore.analytics.Core;
import com.comscore.measurement.Label;
import com.comscore.measurement.PrivilegedLabel;
import com.comscore.utils.Constants;
import com.comscore.utils.Date;
import java.util.HashMap;
import java.util.Iterator;

public class Measurement {
   // $FF: renamed from: a java.util.HashMap
   protected HashMap<String, Label> field_424 = new HashMap();
   // $FF: renamed from: b java.lang.String
   protected String field_425;
   // $FF: renamed from: c long
   protected long field_426;

   protected Measurement(Core var1) {
      this.setPixelURL(var1.getPixelURL());
      this.field_426 = Date.unixTime();
   }

   // $FF: renamed from: a (java.lang.String, long) java.lang.Boolean
   protected Boolean method_314(String var1, long var2) {
      return this.method_315(var1, Long.toString(var2));
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String) java.lang.Boolean
   protected Boolean method_315(String var1, String var2) {
      Label var3 = (Label)this.field_424.get(var1);
      return var3 != null?Boolean.valueOf(var3.value.equals(var2)):Boolean.valueOf(false);
   }

   // $FF: renamed from: a (com.comscore.measurement.Label) void
   protected void method_316(Label var1) {
      if(this.field_424.get(var1.name) == null) {
         this.field_424.put(var1.name, var1);
      }

   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean) void
   protected void method_317(String var1, String var2, Boolean var3, Boolean var4) {
      if(var4.booleanValue()) {
         this.method_316(new PrivilegedLabel(var1, var2, var3));
      } else {
         this.method_316(new Label(var1, var2, var3));
      }
   }

   // $FF: renamed from: a (java.util.HashMap) void
   protected void method_318(HashMap<String, String> var1) {
      this.method_319(var1, false);
   }

   // $FF: renamed from: a (java.util.HashMap, boolean) void
   protected void method_319(HashMap<String, String> var1, boolean var2) {
      if(var1 != null) {
         Iterator var3 = var1.keySet().iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            this.setLabel(var4, (String)var1.get(var4), Boolean.valueOf(var2));
         }
      }

   }

   // $FF: renamed from: b (java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean) void
   protected void method_320(String var1, String var2, Boolean var3, Boolean var4) {
      this.removeLabel(var1, var3, var4);
      this.method_317(var1, var2, var3, var4);
   }

   public Label getLabel(String var1) {
      return (Label)this.field_424.get(var1);
   }

   public String getPixelURL() {
      return this.field_425;
   }

   public Boolean hasLabel(String var1) {
      return Boolean.valueOf(this.field_424.containsKey(var1));
   }

   public void removeLabel(String var1, Boolean var2, Boolean var3) {
      Label var4 = (Label)this.field_424.get(var1);
      if(var4 != null && (!(var4 instanceof PrivilegedLabel) || var3.booleanValue() || var2.booleanValue())) {
         this.field_424.remove(var1);
      }

   }

   public String retrieveLabelsAsString(String[] var1) {
      StringBuilder var2 = new StringBuilder();
      HashMap var3 = new HashMap(this.field_424);
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String var15 = var1[var5];
         Label var16 = (Label)var3.get(var15);
         if(var16 != null) {
            var2.append(var16.pack());
            var3.remove(var15);
         }
      }

      if(var1 != Constants.LABELS_ORDER) {
         String[] var8 = Constants.LABELS_ORDER;
         int var9 = var8.length;

         for(int var10 = 0; var10 < var9; ++var10) {
            String var11 = var8[var10];
            Label var12 = (Label)var3.get(var11);
            if(var12 != null) {
               var2.append(var12.pack());
               var3.remove(var11);
            }
         }
      }

      Iterator var6 = var3.values().iterator();

      while(var6.hasNext()) {
         var2.append(((Label)var6.next()).pack());
      }

      return var2.length() > 0 && var2.charAt(0) == 38?var2.substring(1):var2.toString();
   }

   public void setLabel(Label var1) {
      this.removeLabel(var1.name, var1.aggregate, Boolean.valueOf(var1 instanceof PrivilegedLabel));
      this.method_316(var1);
   }

   public void setLabel(String var1, String var2) {
      this.setLabel(var1, var2, Boolean.valueOf(false));
   }

   public void setLabel(String var1, String var2, Boolean var3) {
      this.removeLabel(var1, var3, Boolean.valueOf(false));
      this.method_317(var1, var2, var3, Boolean.valueOf(false));
   }

   public void setPixelURL(String var1) {
      this.field_425 = var1;
   }
}
