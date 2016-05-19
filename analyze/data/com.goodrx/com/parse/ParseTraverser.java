package com.parse;

import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class ParseTraverser {
   private boolean traverseParseObjects = false;
   private boolean yieldRoot = false;

   private void traverseInternal(Object var1, boolean var2, IdentityHashMap<Object, Object> var3) {
      if(var1 != null && !var3.containsKey(var1) && (!var2 || this.visit(var1))) {
         var3.put(var1, var1);
         if(var1 instanceof JSONObject) {
            JSONObject var14 = (JSONObject)var1;
            Iterator var15 = var14.keys();

            while(var15.hasNext()) {
               String var16 = (String)var15.next();

               try {
                  this.traverseInternal(var14.get(var16), true, var3);
               } catch (JSONException var20) {
                  RuntimeException var18 = new RuntimeException(var20);
                  throw var18;
               }
            }
         } else if(var1 instanceof JSONArray) {
            JSONArray var10 = (JSONArray)var1;

            for(int var11 = 0; var11 < var10.length(); ++var11) {
               try {
                  this.traverseInternal(var10.get(var11), true, var3);
               } catch (JSONException var19) {
                  RuntimeException var13 = new RuntimeException(var19);
                  throw var13;
               }
            }
         } else if(var1 instanceof Map) {
            Iterator var9 = ((Map)var1).values().iterator();

            while(var9.hasNext()) {
               this.traverseInternal(var9.next(), true, var3);
            }
         } else if(var1 instanceof List) {
            Iterator var8 = ((List)var1).iterator();

            while(var8.hasNext()) {
               this.traverseInternal(var8.next(), true, var3);
            }
         } else if(var1 instanceof ParseObject) {
            if(this.traverseParseObjects) {
               ParseObject var6 = (ParseObject)var1;
               Iterator var7 = var6.keySet().iterator();

               while(var7.hasNext()) {
                  this.traverseInternal(var6.get((String)var7.next()), true, var3);
               }
            }
         } else if(var1 instanceof ParseACL) {
            ParseUser var5 = ((ParseACL)var1).getUnresolvedUser();
            if(var5 != null && var5.isCurrentUser()) {
               this.traverseInternal(var5, true, var3);
               return;
            }
         }
      }

   }

   public ParseTraverser setTraverseParseObjects(boolean var1) {
      this.traverseParseObjects = var1;
      return this;
   }

   public ParseTraverser setYieldRoot(boolean var1) {
      this.yieldRoot = var1;
      return this;
   }

   public void traverse(Object var1) {
      IdentityHashMap var2 = new IdentityHashMap();
      this.traverseInternal(var1, this.yieldRoot, var2);
   }

   protected abstract boolean visit(Object var1);
}
