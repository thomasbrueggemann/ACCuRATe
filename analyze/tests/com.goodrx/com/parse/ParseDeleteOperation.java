package com.parse;

import com.parse.ParseEncoder;
import com.parse.ParseFieldOperation;
import org.json.JSONException;
import org.json.JSONObject;

class ParseDeleteOperation implements ParseFieldOperation {
   private static final ParseDeleteOperation defaultInstance = new ParseDeleteOperation();

   public static ParseDeleteOperation getInstance() {
      return defaultInstance;
   }

   public Object apply(Object var1, String var2) {
      return null;
   }

   public JSONObject encode(ParseEncoder var1) throws JSONException {
      JSONObject var2 = new JSONObject();
      var2.put("__op", "Delete");
      return var2;
   }

   public ParseFieldOperation mergeWithPrevious(ParseFieldOperation var1) {
      return this;
   }
}
