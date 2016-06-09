package com.parse;

import com.parse.ParseDeleteOperation;
import com.parse.ParseEncoder;
import com.parse.ParseFieldOperation;
import com.parse.ParseFieldOperations;
import com.parse.ParseObject;
import com.parse.ParseSetOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseAddUniqueOperation implements ParseFieldOperation {
   protected final LinkedHashSet<Object> objects = new LinkedHashSet();

   public ParseAddUniqueOperation(Collection<?> var1) {
      this.objects.addAll(var1);
   }

   public Object apply(Object var1, String var2) {
      ArrayList var3;
      if(var1 == null) {
         var3 = new ArrayList(this.objects);
         return var3;
      } else if(var1 instanceof JSONArray) {
         return new JSONArray((ArrayList)this.apply(ParseFieldOperations.jsonArrayAsArrayList((JSONArray)var1), var2));
      } else if(!(var1 instanceof List)) {
         throw new IllegalArgumentException("Operation is invalid after previous operation.");
      } else {
         var3 = new ArrayList((List)var1);
         HashMap var4 = new HashMap();

         for(int var5 = 0; var5 < var3.size(); ++var5) {
            if(var3.get(var5) instanceof ParseObject) {
               var4.put(((ParseObject)var3.get(var5)).getObjectId(), Integer.valueOf(var5));
            }
         }

         Iterator var6 = this.objects.iterator();

         while(true) {
            while(true) {
               while(var6.hasNext()) {
                  Object var7 = var6.next();
                  if(var7 instanceof ParseObject) {
                     String var9 = ((ParseObject)var7).getObjectId();
                     if(var9 != null && var4.containsKey(var9)) {
                        var3.set(((Integer)var4.get(var9)).intValue(), var7);
                     } else if(!var3.contains(var7)) {
                        var3.add(var7);
                     }
                  } else if(!var3.contains(var7)) {
                     var3.add(var7);
                  }
               }

               return var3;
            }
         }
      }
   }

   public JSONObject encode(ParseEncoder var1) throws JSONException {
      JSONObject var2 = new JSONObject();
      var2.put("__op", "AddUnique");
      var2.put("objects", var1.encode(new ArrayList(this.objects)));
      return var2;
   }

   public ParseFieldOperation mergeWithPrevious(ParseFieldOperation var1) {
      if(var1 == null) {
         return this;
      } else if(var1 instanceof ParseDeleteOperation) {
         return new ParseSetOperation(this.objects);
      } else if(var1 instanceof ParseSetOperation) {
         Object var2 = ((ParseSetOperation)var1).getValue();
         if(!(var2 instanceof JSONArray) && !(var2 instanceof List)) {
            throw new IllegalArgumentException("You can only add an item to a List or JSONArray.");
         } else {
            return new ParseSetOperation(this.apply(var2, (String)null));
         }
      } else if(var1 instanceof ParseAddUniqueOperation) {
         return new ParseAddUniqueOperation((List)this.apply(new ArrayList(((ParseAddUniqueOperation)var1).objects), (String)null));
      } else {
         throw new IllegalArgumentException("Operation is invalid after previous operation.");
      }
   }
}
