package com.goodrx.model;

public class Key {
   String token;
   String token_id;

   public Key() {
   }

   public Key(String var1, String var2) {
      this.token = var1;
      this.token_id = var2;
   }

   public String getToken() {
      return this.token;
   }

   public String getToken_id() {
      return this.token_id;
   }

   public boolean isValid() {
      return this.token != null && this.token_id != null;
   }
}
