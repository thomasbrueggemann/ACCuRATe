package com.parse;

import com.parse.ParseEncoder;
import com.parse.ParseFieldOperation;

class ParseSetOperation implements ParseFieldOperation {
   private final Object value;

   public ParseSetOperation(Object var1) {
      this.value = var1;
   }

   public Object apply(Object var1, String var2) {
      return this.value;
   }

   public Object encode(ParseEncoder var1) {
      return var1.encode(this.value);
   }

   public Object getValue() {
      return this.value;
   }

   public ParseFieldOperation mergeWithPrevious(ParseFieldOperation var1) {
      return this;
   }
}
