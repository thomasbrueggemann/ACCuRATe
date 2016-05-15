package com.comscore.measurement;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Label {
   public Boolean aggregate;
   public String name;
   public String value;

   public Label(String var1, String var2, Boolean var3) {
      this.name = var1;
      this.value = var2;
      this.aggregate = var3;
   }

   // $FF: renamed from: a (java.lang.String) java.lang.String
   private String method_80(String var1) {
      StringBuilder var2 = new StringBuilder();
      int var3 = 0;

      for(int var4 = var1.length(); var3 < var4; ++var3) {
         char var5 = Character.toLowerCase(var1.charAt(var3));
         if(var5 >= 97 && var5 <= 122 || var5 >= 48 && var5 <= 57 || var5 == 95 || var5 == 45 || var5 == 46) {
            var2.append(var5);
         }
      }

      return var2.toString();
   }

   public String pack() {
      StringBuilder var1 = new StringBuilder();
      if(this.name != null && this.value != null) {
         String var2 = this.method_80(this.name);
         if(var2.length() > 0) {
            try {
               var1.append("&").append(var2).append("=").append(URLEncoder.encode(this.value, "UTF-8").replace("+", "%20"));
               String var5 = var1.toString();
               return var5;
            } catch (UnsupportedEncodingException var6) {
               ;
            }
         }
      }

      return "";
   }
}
