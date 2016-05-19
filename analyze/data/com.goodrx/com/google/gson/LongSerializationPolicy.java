package com.google.gson;

public enum LongSerializationPolicy {
   DEFAULT {
   },
   STRING {
   };

   static {
      LongSerializationPolicy[] var0 = new LongSerializationPolicy[]{DEFAULT, STRING};
   }

   private LongSerializationPolicy() {
   }

   // $FF: synthetic method
   LongSerializationPolicy(Object var3) {
      this();
   }
}
