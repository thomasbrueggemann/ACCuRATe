package com.goodrx.model;

public class ResponseEntity {
   private String content;
   private long lastModified;
   private int locationSensitive;
   private String params;
   private String url;

   public ResponseEntity(String var1, String var2, String var3, long var4, int var6) {
      this.url = var1;
      this.params = var2;
      this.content = var3;
      this.lastModified = var4;
      this.locationSensitive = var6;
   }

   public String getContent() {
      return this.content;
   }

   public long getLastModified() {
      return this.lastModified;
   }

   public int getLocationSensitive() {
      return this.locationSensitive;
   }

   public String getParams() {
      return this.params;
   }

   public String getUrl() {
      return this.url;
   }
}
