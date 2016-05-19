package com.parse;

import com.parse.ParseDeleteOperation;
import com.parse.ParseEncoder;
import com.parse.ParseFieldOperation;
import com.parse.ParseFieldOperations;
import com.parse.ParseSetOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseAddOperation implements ParseFieldOperation {
   protected final ArrayList<Object> objects = new ArrayList();

   public ParseAddOperation(Collection<?> var1) {
      this.objects.addAll(var1);
   }

   public Object apply(Object var1, String var2) {
      if(var1 == null) {
         return this.objects;
      } else if(var1 instanceof JSONArray) {
         return new JSONArray((ArrayList)this.apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray)var1), var2));
      } else if(var1 instanceof List) {
         ArrayList var3 = new ArrayList((List)var1);
         var3.addAll(this.objects);
         return var3;
      } else {
         throw new IllegalArgumentException("Operation is invalid after previous operation.");
      }
   }

   public JSONObject encode(ParseEncoder var1) throws JSONException {
      JSONObject var2 = new JSONObject();
      var2.put("__op", "Add");
      var2.put("objects", var1.encode(this.objects));
      return var2;
   }

   public ParseFieldOperation mergeWithPrevious(ParseFieldOperation var1) {
      if(var1 == null) {
         return this;
      } else if(var1 instanceof ParseDeleteOperation) {
         return new ParseSetOperation(this.objects);
      } else if(var1 instanceof ParseSetOperation) {
         Object var4 = ((ParseSetOperation)var1).getValue();
         if(var4 instanceof JSONArray) {
            ArrayList var7 = ParseFieldOperations.jsonArrayAsArrayList((JSONArray)var4);
            var7.addAll(this.objects);
            return new ParseSetOperation(new JSONArray(var7));
         } else if(var4 instanceof List) {
            ArrayList var5 = new ArrayList((List)var4);
            var5.addAll(this.objects);
            return new ParseSetOperation(var5);
         } else {
            throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
         }
      } else if(var1 instanceof ParseAddOperation) {
         ArrayList var2 = new ArrayList(((ParseAddOperation)var1).objects);
         var2.addAll(this.objects);
         return new ParseAddOperation(var2);
      } else {
         throw new IllegalArgumentException("Operation is invalid after previous operation.");
      }
   }
}
