package com.parse;

import com.parse.ParseAddOperation;
import com.parse.ParseAddUniqueOperation;
import com.parse.ParseDecoder;
import com.parse.ParseDeleteOperation;
import com.parse.ParseFieldOperation;
import com.parse.ParseIncrementOperation;
import com.parse.ParseRelationOperation;
import com.parse.ParseRemoveOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ParseFieldOperations {
   private static Map<String, ParseFieldOperations.ParseFieldOperationFactory> opDecoderMap = new HashMap();

   static ParseFieldOperation decode(JSONObject var0, ParseDecoder var1) throws JSONException {
      String var2 = var0.optString("__op");
      ParseFieldOperations.ParseFieldOperationFactory var3 = (ParseFieldOperations.ParseFieldOperationFactory)opDecoderMap.get(var2);
      if(var3 == null) {
         throw new RuntimeException("Unable to decode operation of type " + var2);
      } else {
         return var3.decode(var0, var1);
      }
   }

   static ArrayList<Object> jsonArrayAsArrayList(JSONArray var0) {
      ArrayList var1 = new ArrayList(var0.length());

      for(int var2 = 0; var2 < var0.length(); ++var2) {
         try {
            var1.add(var0.get(var2));
         } catch (JSONException var4) {
            throw new RuntimeException(var4);
         }
      }

      return var1;
   }

   private static void registerDecoder(String var0, ParseFieldOperations.ParseFieldOperationFactory var1) {
      opDecoderMap.put(var0, var1);
   }

   static void registerDefaultDecoders() {
      registerDecoder("Batch", new ParseFieldOperations.ParseFieldOperationFactory() {
         public ParseFieldOperation decode(JSONObject var1, ParseDecoder var2) throws JSONException {
            ParseFieldOperation var3 = null;
            JSONArray var4 = var1.getJSONArray("ops");

            for(int var5 = 0; var5 < var4.length(); ++var5) {
               var3 = ParseFieldOperations.decode(var4.getJSONObject(var5), var2).mergeWithPrevious(var3);
            }

            return var3;
         }
      });
      registerDecoder("Delete", new ParseFieldOperations.ParseFieldOperationFactory() {
         public ParseFieldOperation decode(JSONObject var1, ParseDecoder var2) throws JSONException {
            return ParseDeleteOperation.getInstance();
         }
      });
      registerDecoder("Increment", new ParseFieldOperations.ParseFieldOperationFactory() {
         public ParseFieldOperation decode(JSONObject var1, ParseDecoder var2) throws JSONException {
            return new ParseIncrementOperation((Number)var2.decode(var1.opt("amount")));
         }
      });
      registerDecoder("Add", new ParseFieldOperations.ParseFieldOperationFactory() {
         public ParseFieldOperation decode(JSONObject var1, ParseDecoder var2) throws JSONException {
            return new ParseAddOperation((Collection)var2.decode(var1.opt("objects")));
         }
      });
      registerDecoder("AddUnique", new ParseFieldOperations.ParseFieldOperationFactory() {
         public ParseFieldOperation decode(JSONObject var1, ParseDecoder var2) throws JSONException {
            return new ParseAddUniqueOperation((Collection)var2.decode(var1.opt("objects")));
         }
      });
      registerDecoder("Remove", new ParseFieldOperations.ParseFieldOperationFactory() {
         public ParseFieldOperation decode(JSONObject var1, ParseDecoder var2) throws JSONException {
            return new ParseRemoveOperation((Collection)var2.decode(var1.opt("objects")));
         }
      });
      registerDecoder("AddRelation", new ParseFieldOperations.ParseFieldOperationFactory() {
         public ParseFieldOperation decode(JSONObject var1, ParseDecoder var2) throws JSONException {
            return new ParseRelationOperation(new HashSet((List)var2.decode(var1.optJSONArray("objects"))), (Set)null);
         }
      });
      registerDecoder("RemoveRelation", new ParseFieldOperations.ParseFieldOperationFactory() {
         public ParseFieldOperation decode(JSONObject var1, ParseDecoder var2) throws JSONException {
            return new ParseRelationOperation((Set)null, new HashSet((List)var2.decode(var1.optJSONArray("objects"))));
         }
      });
   }

   private interface ParseFieldOperationFactory {
      ParseFieldOperation decode(JSONObject var1, ParseDecoder var2) throws JSONException;
   }
}
