package com.koushikdutta.async.http.libcore;

public enum ResponseSource {
   CACHE,
   CONDITIONAL_CACHE,
   NETWORK;

   static {
      ResponseSource[] var0 = new ResponseSource[]{CACHE, CONDITIONAL_CACHE, NETWORK};
   }

   public boolean requiresConnection() {
      return this == CONDITIONAL_CACHE || this == NETWORK;
   }
}
