package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.AbstractQueryController;
import com.parse.NetworkQueryController;
import com.parse.ParseException;
import com.parse.ParseKeyValueCache;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

class CacheQueryController extends AbstractQueryController {
   private final NetworkQueryController networkController;

   public CacheQueryController(NetworkQueryController var1) {
      this.networkController = var1;
   }

   private <T extends ParseObject> Task<Integer> countFromCacheAsync(final ParseQuery.State<T> var1, String var2) {
      return Task.call(new Callable() {
         // $FF: synthetic field
         final String val$cacheKey;

         {
            this.val$cacheKey = var2;
         }

         public Integer call() throws Exception {
            JSONObject var1x = ParseKeyValueCache.jsonFromKeyValueCache(this.val$cacheKey, var1.maxCacheAge());
            if(var1x == null) {
               throw new ParseException(120, "results not cached");
            } else {
               try {
                  Integer var3 = Integer.valueOf(var1x.getInt("count"));
                  return var3;
               } catch (JSONException var4) {
                  throw new ParseException(120, "the cache contains corrupted json");
               }
            }
         }
      }, Task.BACKGROUND_EXECUTOR);
   }

   private <T extends ParseObject> Task<List<T>> findFromCacheAsync(final ParseQuery.State<T> var1, String var2) {
      return Task.call(new Callable() {
         // $FF: synthetic field
         final String val$cacheKey;

         {
            this.val$cacheKey = var2;
         }

         public List<T> call() throws Exception {
            JSONObject var1x = ParseKeyValueCache.jsonFromKeyValueCache(this.val$cacheKey, var1.maxCacheAge());
            if(var1x == null) {
               throw new ParseException(120, "results not cached");
            } else {
               try {
                  List var3 = CacheQueryController.this.networkController.convertFindResponse(var1, var1x);
                  return var3;
               } catch (JSONException var4) {
                  throw new ParseException(120, "the cache contains corrupted json");
               }
            }
         }
      }, Task.BACKGROUND_EXECUTOR);
   }

   private <TResult> Task<TResult> runCommandWithPolicyAsync(final CacheQueryController.CommandDelegate<TResult> var1, ParseQuery.CachePolicy var2) {
      switch(null.$SwitchMap$com$parse$ParseQuery$CachePolicy[var2.ordinal()]) {
      case 1:
      case 2:
         return var1.runOnNetworkAsync(true);
      case 3:
         return var1.runFromCacheAsync();
      case 4:
         return var1.runFromCacheAsync().continueWithTask(new Continuation() {
            public Task<TResult> then(Task<TResult> var1x) throws Exception {
               if(var1x.getError() instanceof ParseException) {
                  var1x = var1.runOnNetworkAsync(true);
               }

               return var1x;
            }
         });
      case 5:
         return var1.runOnNetworkAsync(false).continueWithTask(new Continuation() {
            public Task<TResult> then(Task<TResult> var1x) throws Exception {
               Exception var2 = var1x.getError();
               if(var2 instanceof ParseException && ((ParseException)var2).getCode() == 100) {
                  var1x = var1.runFromCacheAsync();
               }

               return var1x;
            }
         });
      case 6:
         throw new RuntimeException("You cannot use the cache policy CACHE_THEN_NETWORK with find()");
      default:
         throw new RuntimeException("Unknown cache policy: " + var2);
      }
   }

   public <T extends ParseObject> Task<Integer> countAsync(final ParseQuery.State<T> var1, ParseUser var2, final Task<Void> var3) {
      final String var4;
      if(var2 != null) {
         var4 = var2.getSessionToken();
      } else {
         var4 = null;
      }

      return this.runCommandWithPolicyAsync(new CacheQueryController.CommandDelegate() {
         public Task<Integer> runFromCacheAsync() {
            return CacheQueryController.this.countFromCacheAsync(var1, var4);
         }

         public Task<Integer> runOnNetworkAsync(boolean var1x) {
            return CacheQueryController.this.networkController.countAsync(var1, var4, var1x, var3);
         }
      }, var1.cachePolicy());
   }

   public <T extends ParseObject> Task<List<T>> findAsync(final ParseQuery.State<T> var1, ParseUser var2, final Task<Void> var3) {
      final String var4;
      if(var2 != null) {
         var4 = var2.getSessionToken();
      } else {
         var4 = null;
      }

      return this.runCommandWithPolicyAsync(new CacheQueryController.CommandDelegate() {
         public Task<List<T>> runFromCacheAsync() {
            return CacheQueryController.this.findFromCacheAsync(var1, var4);
         }

         public Task<List<T>> runOnNetworkAsync(boolean var1x) {
            return CacheQueryController.this.networkController.findAsync(var1, var4, var1x, var3);
         }
      }, var1.cachePolicy());
   }

   private interface CommandDelegate<T> {
      Task<T> runFromCacheAsync();

      Task<T> runOnNetworkAsync(boolean var1);
   }
}
