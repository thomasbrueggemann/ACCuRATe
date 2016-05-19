package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.parse.AbstractQueryController;
import com.parse.PLog;
import com.parse.ParseHttpClient;
import com.parse.ParseKeyValueCache;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseRESTQueryCommand;
import com.parse.ParseUser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class NetworkQueryController extends AbstractQueryController {
   private static final String TAG = "NetworkQueryController";
   private final ParseHttpClient restClient;

   public NetworkQueryController(ParseHttpClient var1) {
      this.restClient = var1;
   }

   <T extends ParseObject> List<T> convertFindResponse(ParseQuery.State<T> var1, JSONObject var2) throws JSONException {
      ArrayList var3 = new ArrayList();
      JSONArray var4 = var2.getJSONArray("results");
      if(var4 == null) {
         PLog.method_359("NetworkQueryController", "null results in find response");
      } else {
         String var5 = var2.optString("className", (String)null);
         if(var5 == null) {
            var5 = var1.className();
         }

         for(int var6 = 0; var6 < var4.length(); ++var6) {
            JSONObject var7 = var4.getJSONObject(var6);
            boolean var8;
            if(var1.selectedKeys() == null) {
               var8 = true;
            } else {
               var8 = false;
            }

            ParseObject var9 = ParseObject.fromJSON(var7, var5, var8);
            var3.add(var9);
            ParseQuery.RelationConstraint var11 = (ParseQuery.RelationConstraint)var1.constraints().get("$relatedTo");
            if(var11 != null) {
               var11.getRelation().addKnownObject(var9);
            }
         }
      }

      return var3;
   }

   public <T extends ParseObject> Task<Integer> countAsync(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3) {
      String var4;
      if(var2 != null) {
         var4 = var2.getSessionToken();
      } else {
         var4 = null;
      }

      return this.countAsync(var1, var4, true, var3);
   }

   <T extends ParseObject> Task<Integer> countAsync(final ParseQuery.State<T> var1, String var2, boolean var3, Task<Void> var4) {
      final ParseRESTQueryCommand var5 = ParseRESTQueryCommand.countCommand(var1, var2);
      if(var3) {
         var5.enableRetrying();
      }

      return var5.executeAsync(this.restClient, var4).onSuccessTask(new Continuation() {
         public Task<JSONObject> then(Task<JSONObject> var1x) throws Exception {
            ParseQuery.CachePolicy var2 = var1.cachePolicy();
            if(var2 != null && var2 != ParseQuery.CachePolicy.IGNORE_CACHE) {
               JSONObject var3 = (JSONObject)var1x.getResult();
               String var4 = var5.getCacheKey();
               String var5x;
               if(!(var3 instanceof JSONObject)) {
                  var5x = var3.toString();
               } else {
                  var5x = JSONObjectInstrumentation.toString((JSONObject)var3);
               }

               ParseKeyValueCache.saveToKeyValueCache(var4, var5x);
            }

            return var1x;
         }
      }, Task.BACKGROUND_EXECUTOR).onSuccess(new Continuation() {
         public Integer then(Task<JSONObject> var1) throws Exception {
            return Integer.valueOf(((JSONObject)var1.getResult()).optInt("count"));
         }
      });
   }

   public <T extends ParseObject> Task<List<T>> findAsync(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3) {
      String var4;
      if(var2 != null) {
         var4 = var2.getSessionToken();
      } else {
         var4 = null;
      }

      return this.findAsync(var1, var4, true, var3);
   }

   <T extends ParseObject> Task<List<T>> findAsync(final ParseQuery.State<T> var1, String var2, boolean var3, Task<Void> var4) {
      final long var5 = System.nanoTime();
      final ParseRESTQueryCommand var7 = ParseRESTQueryCommand.findCommand(var1, var2);
      if(var3) {
         var7.enableRetrying();
      }

      final long var8 = System.nanoTime();
      return var7.executeAsync(this.restClient, var4).onSuccess(new Continuation() {
         public List<T> then(Task<JSONObject> var1x) throws Exception {
            JSONObject var2 = (JSONObject)var1x.getResult();
            ParseQuery.CachePolicy var3 = var1.cachePolicy();
            if(var3 != null && var3 != ParseQuery.CachePolicy.IGNORE_CACHE) {
               String var11 = var7.getCacheKey();
               String var12;
               if(!(var2 instanceof JSONObject)) {
                  var12 = var2.toString();
               } else {
                  var12 = JSONObjectInstrumentation.toString((JSONObject)var2);
               }

               ParseKeyValueCache.saveToKeyValueCache(var11, var12);
            }

            long var4 = System.nanoTime();
            List var6 = NetworkQueryController.this.convertFindResponse(var1, (JSONObject)var1x.getResult());
            long var7x = System.nanoTime();
            if(var2.has("trace")) {
               Object var9 = var2.get("trace");
               Object[] var10 = new Object[]{Float.valueOf((float)(var8 - var5) / 1000000.0F), var9, Float.valueOf((float)(var7x - var4) / 1000000.0F)};
               PLog.method_359("ParseQuery", String.format("Query pre-processing took %f seconds\n%s\nClient side parsing took %f seconds\n", var10));
            }

            return var6;
         }
      }, Task.BACKGROUND_EXECUTOR);
   }
}
