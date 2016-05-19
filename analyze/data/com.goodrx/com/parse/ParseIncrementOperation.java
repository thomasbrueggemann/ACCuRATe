package com.parse;

import com.parse.Numbers;
import com.parse.ParseDeleteOperation;
import com.parse.ParseEncoder;
import com.parse.ParseFieldOperation;
import com.parse.ParseSetOperation;
import org.json.JSONException;
import org.json.JSONObject;

class ParseIncrementOperation implements ParseFieldOperation {
   private final Number amount;

   public ParseIncrementOperation(Number var1) {
      this.amount = var1;
   }

   public Object apply(Object var1, String var2) {
      if(var1 == null) {
         return this.amount;
      } else if(var1 instanceof Number) {
         return Numbers.add((Number)var1, this.amount);
      } else {
         throw new IllegalArgumentException("You cannot increment a non-number.");
      }
   }

   public JSONObject encode(ParseEncoder var1) throws JSONException {
      JSONObject var2 = new JSONObject();
      var2.put("__op", "Increment");
      var2.put("amount", this.amount);
      return var2;
   }

   public ParseFieldOperation mergeWithPrevious(ParseFieldOperation var1) {
      if(var1 == null) {
         return this;
      } else if(var1 instanceof ParseDeleteOperation) {
         return new ParseSetOperation(this.amount);
      } else if(var1 instanceof ParseSetOperation) {
         Object var2 = ((ParseSetOperation)var1).getValue();
         if(var2 instanceof Number) {
            return new ParseSetOperation(Numbers.add((Number)var2, this.amount));
         } else {
            throw new IllegalArgumentException("You cannot increment a non-number.");
         }
      } else if(var1 instanceof ParseIncrementOperation) {
         return new ParseIncrementOperation(Numbers.add(((ParseIncrementOperation)var1).amount, this.amount));
      } else {
         throw new IllegalArgumentException("Operation is invalid after previous operation.");
      }
   }
}
