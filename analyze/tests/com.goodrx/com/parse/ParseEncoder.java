package com.parse;

import com.parse.ParseACL;
import com.parse.ParseDateFormat;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseRelation;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

abstract class ParseEncoder {
   static boolean isValidType(Object var0) {
      return var0 instanceof String || var0 instanceof Number || var0 instanceof Boolean || var0 instanceof Date || var0 instanceof List || var0 instanceof Map || var0 instanceof byte[] || var0 == JSONObject.NULL || var0 instanceof ParseObject || var0 instanceof ParseACL || var0 instanceof ParseFile || var0 instanceof ParseGeoPoint || var0 instanceof ParseRelation;
   }

   public Object encode(Object param1) {
      // $FF: Couldn't be decompiled
   }

   protected JSONObject encodeDate(Date var1) {
      JSONObject var2 = new JSONObject();
      String var3 = ParseDateFormat.getInstance().format(var1);

      try {
         var2.put("__type", "Date");
         var2.put("iso", var3);
         return var2;
      } catch (JSONException var5) {
         throw new RuntimeException(var5);
      }
   }

   protected abstract JSONObject encodeRelatedObject(ParseObject var1);
}
