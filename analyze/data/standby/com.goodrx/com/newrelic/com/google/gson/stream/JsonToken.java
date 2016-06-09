package com.newrelic.com.google.gson.stream;

public enum JsonToken {
   BEGIN_ARRAY,
   BEGIN_OBJECT,
   BOOLEAN,
   END_ARRAY,
   END_DOCUMENT,
   END_OBJECT,
   NAME,
   NULL,
   NUMBER,
   STRING;

   static {
      JsonToken[] var0 = new JsonToken[]{BEGIN_ARRAY, END_ARRAY, BEGIN_OBJECT, END_OBJECT, NAME, STRING, NUMBER, BOOLEAN, NULL, END_DOCUMENT};
   }
}
