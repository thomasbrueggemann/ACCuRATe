package com.appsflyer.cache;

import java.util.Scanner;

public class RequestCacheData {
   private String cacheKey;
   private String postData;
   private String requestURL;
   private String version;

   public RequestCacheData(String var1, String var2, String var3) {
      this.requestURL = var1;
      this.postData = var2;
      this.version = var3;
   }

   public RequestCacheData(char[] var1) {
      Scanner var2 = new Scanner(new String(var1));

      while(var2.hasNextLine()) {
         String var3 = var2.nextLine();
         if(var3.startsWith("url=")) {
            this.requestURL = var3.substring("url=".length()).trim();
         } else if(var3.startsWith("version=")) {
            this.version = var3.substring("version=".length()).trim();
         } else if(var3.startsWith("data=")) {
            this.postData = var3.substring("data=".length()).trim();
         }
      }

      var2.close();
   }

   public String getCacheKey() {
      return this.cacheKey;
   }

   public String getPostData() {
      return this.postData;
   }

   public String getRequestURL() {
      return this.requestURL;
   }

   public String getVersion() {
      return this.version;
   }

   public void setCacheKey(String var1) {
      this.cacheKey = var1;
   }
}
