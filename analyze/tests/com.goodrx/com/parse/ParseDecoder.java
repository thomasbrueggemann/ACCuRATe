package com.parse;

import android.util.Base64;
import com.parse.ParseDateFormat;
import com.parse.ParseFieldOperation;
import com.parse.ParseFieldOperations;
import com.parse.ParseFile;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseRelation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseDecoder {
   private static final ParseDecoder INSTANCE = new ParseDecoder();

   public static ParseDecoder get() {
      return INSTANCE;
   }

   List<Object> convertJSONArrayToList(JSONArray var1) {
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         var2.add(this.decode(var1.opt(var3)));
      }

      return var2;
   }

   Map<String, Object> convertJSONObjectToMap(JSONObject var1) {
      HashMap var2 = new HashMap();
      Iterator var3 = var1.keys();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         var2.put(var4, this.decode(var1.opt(var4)));
      }

      return var2;
   }

   public Object decode(Object var1) {
      if(var1 instanceof JSONArray) {
         var1 = this.convertJSONArrayToList((JSONArray)var1);
      } else if(var1 instanceof JSONObject) {
         JSONObject var2 = (JSONObject)var1;
         if(var2.optString("__op", (String)null) != null) {
            try {
               ParseFieldOperation var11 = ParseFieldOperations.decode(var2, this);
               return var11;
            } catch (JSONException var12) {
               throw new RuntimeException(var12);
            }
         }

         String var3 = var2.optString("__type", (String)null);
         if(var3 == null) {
            return this.convertJSONObjectToMap(var2);
         }

         if(var3.equals("Date")) {
            String var9 = var2.optString("iso");
            return ParseDateFormat.getInstance().parse(var9);
         }

         if(var3.equals("Bytes")) {
            return Base64.decode(var2.optString("base64"), 2);
         }

         if(var3.equals("Pointer")) {
            return this.decodePointer(var2.optString("className"), var2.optString("objectId"));
         }

         if(var3.equals("File")) {
            return new ParseFile(var2, this);
         }

         if(var3.equals("GeoPoint")) {
            double var5;
            double var7;
            try {
               var5 = var2.getDouble("latitude");
               var7 = var2.getDouble("longitude");
            } catch (JSONException var13) {
               throw new RuntimeException(var13);
            }

            return new ParseGeoPoint(var5, var7);
         }

         if(var3.equals("Object")) {
            return ParseObject.fromJSON(var2, (String)null, true, this);
         }

         if(var3.equals("Relation")) {
            return new ParseRelation(var2, this);
         }

         if(var3.equals("OfflineObject")) {
            throw new RuntimeException("An unexpected offline pointer was encountered.");
         }

         return null;
      }

      return var1;
   }

   protected ParseObject decodePointer(String var1, String var2) {
      return ParseObject.createWithoutData(var1, var2);
   }
}
