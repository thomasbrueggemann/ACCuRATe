package com.parse;

import com.parse.ParseDeleteOperation;
import com.parse.ParseEncoder;
import com.parse.ParseFieldOperation;
import com.parse.ParseFieldOperations;
import com.parse.ParseObject;
import com.parse.ParseSetOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseRemoveOperation implements ParseFieldOperation {
   protected final HashSet<Object> objects = new HashSet();

   public ParseRemoveOperation(Collection<?> var1) {
      this.objects.addAll(var1);
   }

   public Object apply(Object var1, String var2) {
      ArrayList var3;
      if(var1 == null) {
         var3 = new ArrayList();
      } else {
         if(var1 instanceof JSONArray) {
            return new JSONArray((ArrayList)this.apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray)var1), var2));
         }

         if(!(var1 instanceof List)) {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
         }

         var3 = new ArrayList((List)var1);
         var3.removeAll(this.objects);
         ArrayList var5 = new ArrayList(this.objects);
         var5.removeAll(var3);
         HashSet var7 = new HashSet();
         Iterator var8 = var5.iterator();

         while(var8.hasNext()) {
            Object var11 = var8.next();
            if(var11 instanceof ParseObject) {
               var7.add(((ParseObject)var11).getObjectId());
            }
         }

         Iterator var9 = var3.iterator();

         while(var9.hasNext()) {
            Object var10 = var9.next();
            if(var10 instanceof ParseObject && var7.contains(((ParseObject)var10).getObjectId())) {
               var9.remove();
            }
         }
      }

      return var3;
   }

   public JSONObject encode(ParseEncoder var1) throws JSONException {
      JSONObject var2 = new JSONObject();
      var2.put("__op", "Remove");
      var2.put("objects", var1.encode(new ArrayList(this.objects)));
      return var2;
   }

   public ParseFieldOperation mergeWithPrevious(ParseFieldOperation var1) {
      if(var1 == null) {
         return this;
      } else if(var1 instanceof ParseDeleteOperation) {
         return new ParseSetOperation(this.objects);
      } else if(var1 instanceof ParseSetOperation) {
         Object var4 = ((ParseSetOperation)var1).getValue();
         if(!(var4 instanceof JSONArray) && !(var4 instanceof List)) {
            throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
         } else {
            return new ParseSetOperation(this.apply(var4, (String)null));
         }
      } else if(var1 instanceof ParseRemoveOperation) {
         HashSet var2 = new HashSet(((ParseRemoveOperation)var1).objects);
         var2.addAll(this.objects);
         return new ParseRemoveOperation(var2);
      } else {
         throw new IllegalArgumentException("Operation is invalid after previous operation.");
      }
   }
}
