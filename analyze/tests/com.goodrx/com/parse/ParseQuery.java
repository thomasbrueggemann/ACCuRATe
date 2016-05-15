package com.parse;

import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.parse.CountCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseCallback2;
import com.parse.ParseCorePlugins;
import com.parse.ParseEncoder;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseKeyValueCache;
import com.parse.ParseObject;
import com.parse.ParseObjectSubclassingController;
import com.parse.ParseQueryController;
import com.parse.ParseRESTQueryCommand;
import com.parse.ParseRelation;
import com.parse.ParseTaskUtils;
import com.parse.ParseUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseQuery<T extends ParseObject> {
   private final ParseQuery.Builder<T> builder;
   private TaskCompletionSource<Void> cts;
   private boolean isRunning;
   private final Object lock;
   private ParseUser user;

   ParseQuery(ParseQuery.Builder<T> var1) {
      this.lock = new Object();
      this.isRunning = false;
      this.builder = var1;
   }

   public ParseQuery(ParseQuery<T> var1) {
      this(new ParseQuery.Builder(var1.getBuilder()));
      this.user = var1.user;
   }

   public ParseQuery(Class<T> var1) {
      this(getSubclassingController().getClassName(var1));
   }

   public ParseQuery(String var1) {
      this(new ParseQuery.Builder(var1));
   }

   // $FF: synthetic method
   static Object access$1800(ParseQuery var0) {
      return var0.lock;
   }

   // $FF: synthetic method
   static boolean access$1902(ParseQuery var0, boolean var1) {
      var0.isRunning = var1;
      return var1;
   }

   // $FF: synthetic method
   static TaskCompletionSource access$2002(ParseQuery var0, TaskCompletionSource var1) {
      var0.cts = var1;
      return var1;
   }

   private void checkIfRunning() {
      this.checkIfRunning(false);
   }

   private void checkIfRunning(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public static void clearAllCachedResults() {
      throwIfLDSEnabled();
      ParseKeyValueCache.clearKeyValueCacheDir();
   }

   private Task<Integer> countAsync(final ParseQuery.State<T> var1) {
      return this.doWithRunningCheck(new Callable() {
         public Task<Integer> call() throws Exception {
            return ParseQuery.this.getUserAsync(var1).onSuccessTask(new Continuation() {
               public Task<Integer> then(Task<ParseUser> var1x) throws Exception {
                  ParseUser var2 = (ParseUser)var1x.getResult();
                  return ParseQuery.this.countAsync(var1, var2, ParseQuery.this.cts.getTask());
               }
            });
         }
      });
   }

   private Task<Integer> countAsync(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3) {
      return getQueryController().countAsync(var1, var2, var3);
   }

   private <TResult> Task<TResult> doCacheThenNetwork(final ParseQuery.State<T> var1, final ParseCallback2<TResult, ParseException> var2, final ParseQuery.CacheThenNetworkCallable<T, Task<TResult>> var3) {
      return this.doWithRunningCheck(new Callable() {
         public Task<TResult> call() throws Exception {
            return ParseQuery.this.getUserAsync(var1).onSuccessTask(new Continuation() {
               public Task<TResult> then(Task<ParseUser> var1x) throws Exception {
                  final ParseUser var2x = (ParseUser)var1x.getResult();
                  ParseQuery.State var3x = (new ParseQuery.Builder(var1)).setCachePolicy(ParseQuery.CachePolicy.CACHE_ONLY).build();
                  final ParseQuery.State var4 = (new ParseQuery.Builder(var1)).setCachePolicy(ParseQuery.CachePolicy.NETWORK_ONLY).build();
                  return ParseTaskUtils.callbackOnMainThreadAsync((Task)var3.call(var3x, var2x, ParseQuery.this.cts.getTask()), var2).continueWithTask(new Continuation() {
                     public Task<TResult> then(Task<TResult> var1x) throws Exception {
                        return var1x.isCancelled()?var1x:(Task)var3.call(var4, var2x, ParseQuery.this.cts.getTask());
                     }
                  });
               }
            });
         }
      });
   }

   private <TResult> Task<TResult> doWithRunningCheck(Callable<Task<TResult>> var1) {
      this.checkIfRunning(true);

      Task var3;
      try {
         var3 = (Task)var1.call();
      } catch (Exception var4) {
         var3 = Task.forError(var4);
      }

      return var3.continueWithTask(new Continuation() {
         public Task<TResult> then(Task<TResult> param1) throws Exception {
            // $FF: Couldn't be decompiled
         }
      });
   }

   private Task<List<T>> findAsync(final ParseQuery.State<T> var1) {
      return this.doWithRunningCheck(new Callable() {
         public Task<List<T>> call() throws Exception {
            return ParseQuery.this.getUserAsync(var1).onSuccessTask(new Continuation() {
               public Task<List<T>> then(Task<ParseUser> var1x) throws Exception {
                  ParseUser var2 = (ParseUser)var1x.getResult();
                  return ParseQuery.this.findAsync(var1, var2, ParseQuery.this.cts.getTask());
               }
            });
         }
      });
   }

   private Task<T> getFirstAsync(final ParseQuery.State<T> var1) {
      return this.doWithRunningCheck(new Callable() {
         public Task<T> call() throws Exception {
            return ParseQuery.this.getUserAsync(var1).onSuccessTask(new Continuation() {
               public Task<T> then(Task<ParseUser> var1x) throws Exception {
                  ParseUser var2 = (ParseUser)var1x.getResult();
                  return ParseQuery.this.getFirstAsync(var1, var2, ParseQuery.this.cts.getTask());
               }
            });
         }
      });
   }

   private Task<T> getFirstAsync(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3) {
      return getQueryController().getFirstAsync(var1, var2, var3);
   }

   public static <T extends ParseObject> ParseQuery<T> getQuery(Class<T> var0) {
      return new ParseQuery(var0);
   }

   public static <T extends ParseObject> ParseQuery<T> getQuery(String var0) {
      return new ParseQuery(var0);
   }

   private static ParseQueryController getQueryController() {
      return ParseCorePlugins.getInstance().getQueryController();
   }

   private static ParseObjectSubclassingController getSubclassingController() {
      return ParseCorePlugins.getInstance().getSubclassingController();
   }

   @Deprecated
   public static ParseQuery<ParseUser> getUserQuery() {
      return ParseUser.getQuery();
   }

   // $FF: renamed from: or (java.util.List) com.parse.ParseQuery
   public static <T extends ParseObject> ParseQuery<T> method_477(List<ParseQuery<T>> var0) {
      if(var0.isEmpty()) {
         throw new IllegalArgumentException("Can\'t take an or of an empty list of queries");
      } else {
         ArrayList var1 = new ArrayList();
         Iterator var2 = var0.iterator();

         while(var2.hasNext()) {
            var1.add(((ParseQuery)var2.next()).getBuilder());
         }

         return new ParseQuery(ParseQuery.Builder.method_350(var1));
      }
   }

   private static void throwIfLDSDisabled() {
      throwIfLDSEnabled(true);
   }

   private static void throwIfLDSEnabled() {
      throwIfLDSEnabled(false);
   }

   private static void throwIfLDSEnabled(boolean var0) {
      boolean var1 = Parse.isLocalDatastoreEnabled();
      if(var0 && !var1) {
         throw new IllegalStateException("Method requires Local Datastore. Please refer to `Parse#enableLocalDatastore(Context)`.");
      } else if(!var0 && var1) {
         throw new IllegalStateException("Unsupported method when Local Datastore is enabled.");
      }
   }

   public ParseQuery<T> addAscendingOrder(String var1) {
      this.checkIfRunning();
      this.builder.addAscendingOrder(var1);
      return this;
   }

   public ParseQuery<T> addDescendingOrder(String var1) {
      this.checkIfRunning();
      this.builder.addDescendingOrder(var1);
      return this;
   }

   public void cancel() {
      // $FF: Couldn't be decompiled
   }

   public void clearCachedResult() {
      throwIfLDSEnabled();
      ParseQuery.State var1 = this.builder.build();

      ParseUser var3;
      try {
         var3 = (ParseUser)ParseTaskUtils.wait(this.getUserAsync(var1));
      } catch (ParseException var5) {
         var3 = null;
      }

      String var4;
      if(var3 != null) {
         var4 = var3.getSessionToken();
      } else {
         var4 = null;
      }

      ParseKeyValueCache.clearFromKeyValueCache(ParseRESTQueryCommand.findCommand(var1, var4).getCacheKey());
   }

   public int count() throws ParseException {
      return ((Integer)ParseTaskUtils.wait(this.countInBackground())).intValue();
   }

   public Task<Integer> countInBackground() {
      return this.countAsync((new ParseQuery.Builder(this.builder)).setLimit(0).build());
   }

   public void countInBackground(final CountCallback var1) {
      ParseQuery.State var2 = (new ParseQuery.Builder(this.builder)).setLimit(0).build();
      ParseCallback2 var3;
      if(var1 != null) {
         var3 = new ParseCallback2() {
            public void done(Integer var1x, ParseException var2) {
               CountCallback var3 = var1;
               int var4;
               if(var2 == null) {
                  var4 = var1x.intValue();
               } else {
                  var4 = -1;
               }

               var3.done(var4, var2);
            }
         };
      } else {
         var3 = null;
      }

      Task var4;
      if(var2.cachePolicy() == ParseQuery.CachePolicy.CACHE_THEN_NETWORK && !var2.isFromLocalDatastore()) {
         var4 = this.doCacheThenNetwork(var2, var3, new ParseQuery.CacheThenNetworkCallable() {
            public Task<Integer> call(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3) {
               return ParseQuery.this.countAsync(var1, var2, var3);
            }
         });
      } else {
         var4 = this.countAsync(var2);
      }

      ParseTaskUtils.callbackOnMainThreadAsync(var4, var3);
   }

   public List<T> find() throws ParseException {
      return (List)ParseTaskUtils.wait(this.findInBackground());
   }

   Task<List<T>> findAsync(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3) {
      return getQueryController().findAsync(var1, var2, var3);
   }

   public Task<List<T>> findInBackground() {
      return this.findAsync(this.builder.build());
   }

   public void findInBackground(FindCallback<T> var1) {
      ParseQuery.State var2 = this.builder.build();
      Task var3;
      if(var2.cachePolicy() == ParseQuery.CachePolicy.CACHE_THEN_NETWORK && !var2.isFromLocalDatastore()) {
         var3 = this.doCacheThenNetwork(var2, var1, new ParseQuery.CacheThenNetworkCallable() {
            public Task<List<T>> call(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3) {
               return ParseQuery.this.findAsync(var1, var2, var3);
            }
         });
      } else {
         var3 = this.findAsync(var2);
      }

      ParseTaskUtils.callbackOnMainThreadAsync(var3, (ParseCallback2)var1);
   }

   public ParseQuery<T> fromLocalDatastore() {
      this.builder.fromLocalDatastore();
      return this;
   }

   ParseQuery<T> fromNetwork() {
      this.checkIfRunning();
      this.builder.fromNetwork();
      return this;
   }

   public ParseQuery<T> fromPin() {
      this.checkIfRunning();
      this.builder.fromPin();
      return this;
   }

   public ParseQuery<T> fromPin(String var1) {
      this.checkIfRunning();
      this.builder.fromPin(var1);
      return this;
   }

   public T get(String var1) throws ParseException {
      return (ParseObject)ParseTaskUtils.wait(this.getInBackground(var1));
   }

   ParseQuery.Builder<T> getBuilder() {
      return this.builder;
   }

   public ParseQuery.CachePolicy getCachePolicy() {
      return this.builder.getCachePolicy();
   }

   public String getClassName() {
      return this.builder.getClassName();
   }

   public T getFirst() throws ParseException {
      return (ParseObject)ParseTaskUtils.wait(this.getFirstInBackground());
   }

   public Task<T> getFirstInBackground() {
      return this.getFirstAsync(this.builder.setLimit(1).build());
   }

   public void getFirstInBackground(GetCallback<T> var1) {
      ParseQuery.State var2 = this.builder.setLimit(1).build();
      Task var3;
      if(var2.cachePolicy() == ParseQuery.CachePolicy.CACHE_THEN_NETWORK && !var2.isFromLocalDatastore()) {
         var3 = this.doCacheThenNetwork(var2, var1, new ParseQuery.CacheThenNetworkCallable() {
            public Task<T> call(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3) {
               return ParseQuery.this.getFirstAsync(var1, var2, var3);
            }
         });
      } else {
         var3 = this.getFirstAsync(var2);
      }

      ParseTaskUtils.callbackOnMainThreadAsync(var3, (ParseCallback2)var1);
   }

   public Task<T> getInBackground(String var1) {
      return this.getFirstAsync(this.builder.setSkip(-1).whereObjectIdEquals(var1).build());
   }

   public void getInBackground(String var1, GetCallback<T> var2) {
      ParseQuery.State var3 = this.builder.setSkip(-1).whereObjectIdEquals(var1).build();
      Task var4;
      if(var3.cachePolicy() == ParseQuery.CachePolicy.CACHE_THEN_NETWORK && !var3.isFromLocalDatastore()) {
         var4 = this.doCacheThenNetwork(var3, var2, new ParseQuery.CacheThenNetworkCallable() {
            public Task<T> call(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3) {
               return ParseQuery.this.getFirstAsync(var1, var2, var3);
            }
         });
      } else {
         var4 = this.getFirstAsync(var3);
      }

      ParseTaskUtils.callbackOnMainThreadAsync(var4, (ParseCallback2)var2);
   }

   public int getLimit() {
      return this.builder.getLimit();
   }

   public long getMaxCacheAge() {
      return this.builder.getMaxCacheAge();
   }

   public int getSkip() {
      return this.builder.getSkip();
   }

   Task<ParseUser> getUserAsync(ParseQuery.State<T> var1) {
      return var1.ignoreACLs()?Task.forResult((Object)null):(this.user != null?Task.forResult(this.user):ParseUser.getCurrentUserAsync());
   }

   public boolean hasCachedResult() {
      throwIfLDSEnabled();
      ParseQuery.State var1 = this.builder.build();

      ParseUser var3;
      try {
         var3 = (ParseUser)ParseTaskUtils.wait(this.getUserAsync(var1));
      } catch (ParseException var5) {
         var3 = null;
      }

      String var4;
      if(var3 != null) {
         var4 = var3.getSessionToken();
      } else {
         var4 = null;
      }

      return ParseKeyValueCache.loadFromKeyValueCache(ParseRESTQueryCommand.findCommand(var1, var4).getCacheKey(), var1.maxCacheAge()) != null;
   }

   public ParseQuery<T> ignoreACLs() {
      this.checkIfRunning();
      this.builder.ignoreACLs();
      return this;
   }

   public ParseQuery<T> include(String var1) {
      this.checkIfRunning();
      this.builder.include(var1);
      return this;
   }

   boolean isFromNetwork() {
      return this.builder.isFromNetwork();
   }

   public ParseQuery<T> orderByAscending(String var1) {
      this.checkIfRunning();
      this.builder.orderByAscending(var1);
      return this;
   }

   public ParseQuery<T> orderByDescending(String var1) {
      this.checkIfRunning();
      this.builder.orderByDescending(var1);
      return this;
   }

   public ParseQuery<T> selectKeys(Collection<String> var1) {
      this.checkIfRunning();
      this.builder.selectKeys(var1);
      return this;
   }

   public ParseQuery<T> setCachePolicy(ParseQuery.CachePolicy var1) {
      this.checkIfRunning();
      this.builder.setCachePolicy(var1);
      return this;
   }

   public ParseQuery<T> setLimit(int var1) {
      this.checkIfRunning();
      this.builder.setLimit(var1);
      return this;
   }

   public ParseQuery<T> setMaxCacheAge(long var1) {
      this.checkIfRunning();
      this.builder.setMaxCacheAge(var1);
      return this;
   }

   public ParseQuery<T> setSkip(int var1) {
      this.checkIfRunning();
      this.builder.setSkip(var1);
      return this;
   }

   public ParseQuery<T> setTrace(boolean var1) {
      this.checkIfRunning();
      this.builder.setTracingEnabled(var1);
      return this;
   }

   ParseQuery<T> setUser(ParseUser var1) {
      this.user = var1;
      return this;
   }

   public ParseQuery<T> whereContainedIn(String var1, Collection<? extends Object> var2) {
      this.checkIfRunning();
      this.builder.addCondition(var1, "$in", var2);
      return this;
   }

   public ParseQuery<T> whereContains(String var1, String var2) {
      this.whereMatches(var1, Pattern.quote(var2));
      return this;
   }

   public ParseQuery<T> whereContainsAll(String var1, Collection<?> var2) {
      this.checkIfRunning();
      this.builder.addCondition(var1, "$all", var2);
      return this;
   }

   public ParseQuery<T> whereDoesNotExist(String var1) {
      this.checkIfRunning();
      this.builder.addCondition(var1, "$exists", (Object)Boolean.valueOf(false));
      return this;
   }

   public ParseQuery<T> whereDoesNotMatchKeyInQuery(String var1, String var2, ParseQuery<?> var3) {
      this.checkIfRunning();
      this.builder.whereDoesNotMatchKeyInQuery(var1, var2, var3.getBuilder());
      return this;
   }

   public ParseQuery<T> whereDoesNotMatchQuery(String var1, ParseQuery<?> var2) {
      this.checkIfRunning();
      this.builder.whereDoesNotMatchQuery(var1, var2.getBuilder());
      return this;
   }

   public ParseQuery<T> whereEndsWith(String var1, String var2) {
      this.whereMatches(var1, Pattern.quote(var2) + "$");
      return this;
   }

   public ParseQuery<T> whereEqualTo(String var1, Object var2) {
      this.checkIfRunning();
      this.builder.whereEqualTo(var1, var2);
      return this;
   }

   public ParseQuery<T> whereExists(String var1) {
      this.checkIfRunning();
      this.builder.addCondition(var1, "$exists", (Object)Boolean.valueOf(true));
      return this;
   }

   public ParseQuery<T> whereGreaterThan(String var1, Object var2) {
      this.checkIfRunning();
      this.builder.addCondition(var1, "$gt", var2);
      return this;
   }

   public ParseQuery<T> whereGreaterThanOrEqualTo(String var1, Object var2) {
      this.checkIfRunning();
      this.builder.addCondition(var1, "$gte", var2);
      return this;
   }

   public ParseQuery<T> whereLessThan(String var1, Object var2) {
      this.checkIfRunning();
      this.builder.addCondition(var1, "$lt", var2);
      return this;
   }

   public ParseQuery<T> whereLessThanOrEqualTo(String var1, Object var2) {
      this.checkIfRunning();
      this.builder.addCondition(var1, "$lte", var2);
      return this;
   }

   public ParseQuery<T> whereMatches(String var1, String var2) {
      this.checkIfRunning();
      this.builder.addCondition(var1, "$regex", (Object)var2);
      return this;
   }

   public ParseQuery<T> whereMatches(String var1, String var2, String var3) {
      this.checkIfRunning();
      this.builder.addCondition(var1, "$regex", (Object)var2);
      if(var3.length() != 0) {
         this.builder.addCondition(var1, "$options", (Object)var3);
      }

      return this;
   }

   public ParseQuery<T> whereMatchesKeyInQuery(String var1, String var2, ParseQuery<?> var3) {
      this.checkIfRunning();
      this.builder.whereMatchesKeyInQuery(var1, var2, var3.getBuilder());
      return this;
   }

   public ParseQuery<T> whereMatchesQuery(String var1, ParseQuery<?> var2) {
      this.checkIfRunning();
      this.builder.whereMatchesQuery(var1, var2.getBuilder());
      return this;
   }

   public ParseQuery<T> whereNear(String var1, ParseGeoPoint var2) {
      this.checkIfRunning();
      this.builder.whereNear(var1, var2);
      return this;
   }

   public ParseQuery<T> whereNotContainedIn(String var1, Collection<? extends Object> var2) {
      this.checkIfRunning();
      this.builder.addCondition(var1, "$nin", var2);
      return this;
   }

   public ParseQuery<T> whereNotEqualTo(String var1, Object var2) {
      this.checkIfRunning();
      this.builder.addCondition(var1, "$ne", var2);
      return this;
   }

   public ParseQuery<T> whereStartsWith(String var1, String var2) {
      this.whereMatches(var1, "^" + Pattern.quote(var2));
      return this;
   }

   public ParseQuery<T> whereWithinGeoBox(String var1, ParseGeoPoint var2, ParseGeoPoint var3) {
      this.checkIfRunning();
      this.builder.whereWithin(var1, var2, var3);
      return this;
   }

   public ParseQuery<T> whereWithinKilometers(String var1, ParseGeoPoint var2, double var3) {
      this.checkIfRunning();
      return this.whereWithinRadians(var1, var2, var3 / ParseGeoPoint.EARTH_MEAN_RADIUS_KM);
   }

   public ParseQuery<T> whereWithinMiles(String var1, ParseGeoPoint var2, double var3) {
      this.checkIfRunning();
      return this.whereWithinRadians(var1, var2, var3 / ParseGeoPoint.EARTH_MEAN_RADIUS_MILE);
   }

   public ParseQuery<T> whereWithinRadians(String var1, ParseGeoPoint var2, double var3) {
      this.checkIfRunning();
      this.builder.whereNear(var1, var2).maxDistance(var1, var3);
      return this;
   }

   public static enum CachePolicy {
      CACHE_ELSE_NETWORK,
      CACHE_ONLY,
      CACHE_THEN_NETWORK,
      IGNORE_CACHE,
      NETWORK_ELSE_CACHE,
      NETWORK_ONLY;

      static {
         ParseQuery.CachePolicy[] var0 = new ParseQuery.CachePolicy[]{IGNORE_CACHE, CACHE_ONLY, NETWORK_ONLY, CACHE_ELSE_NETWORK, NETWORK_ELSE_CACHE, CACHE_THEN_NETWORK};
      }
   }

   private interface CacheThenNetworkCallable<T extends ParseObject, TResult> {
      TResult call(ParseQuery.State<T> var1, ParseUser var2, Task<Void> var3);
   }

   static class KeyConstraints extends HashMap<String, Object> {
   }

   static class QueryConstraints extends HashMap<String, Object> {
      public QueryConstraints() {
      }

      public QueryConstraints(Map<? extends String, ?> var1) {
         super(var1);
      }
   }

   static class RelationConstraint {
      private String key;
      private ParseObject object;

      public RelationConstraint(String var1, ParseObject var2) {
         if(var1 != null && var2 != null) {
            this.key = var1;
            this.object = var2;
         } else {
            throw new IllegalArgumentException("Arguments must not be null.");
         }
      }

      public JSONObject encode(ParseEncoder var1) {
         JSONObject var2 = new JSONObject();

         try {
            var2.put("key", this.key);
            var2.put("object", var1.encodeRelatedObject(this.object));
            return var2;
         } catch (JSONException var4) {
            throw new RuntimeException(var4);
         }
      }

      public String getKey() {
         return this.key;
      }

      public ParseObject getObject() {
         return this.object;
      }

      public ParseRelation<ParseObject> getRelation() {
         return this.object.getRelation(this.key);
      }
   }

   static class State<T extends ParseObject> {
      private final ParseQuery.CachePolicy cachePolicy;
      private final String className;
      private final Map<String, Object> extraOptions;
      private final boolean ignoreACLs;
      private final Set<String> include;
      private final boolean isFromLocalDatastore;
      private final int limit;
      private final long maxCacheAge;
      private final List<String> order;
      private final String pinName;
      private final Set<String> selectedKeys;
      private final int skip;
      private final boolean trace;
      private final ParseQuery.QueryConstraints where;

      private State(ParseQuery.Builder<T> var1) {
         this.className = var1.className;
         this.where = new ParseQuery.QueryConstraints(var1.where);
         this.include = Collections.unmodifiableSet(new HashSet(var1.includes));
         Set var2;
         if(var1.selectedKeys != null) {
            var2 = Collections.unmodifiableSet(new HashSet(var1.selectedKeys));
         } else {
            var2 = null;
         }

         this.selectedKeys = var2;
         this.limit = var1.limit;
         this.skip = var1.skip;
         this.order = Collections.unmodifiableList(new ArrayList(var1.order));
         this.extraOptions = Collections.unmodifiableMap(new HashMap(var1.extraOptions));
         this.trace = var1.trace;
         this.cachePolicy = var1.cachePolicy;
         this.maxCacheAge = var1.maxCacheAge;
         this.isFromLocalDatastore = var1.isFromLocalDatastore;
         this.pinName = var1.pinName;
         this.ignoreACLs = var1.ignoreACLs;
      }

      // $FF: synthetic method
      State(ParseQuery.Builder var1, Object var2) {
         this(var1);
      }

      public ParseQuery.CachePolicy cachePolicy() {
         return this.cachePolicy;
      }

      public String className() {
         return this.className;
      }

      public ParseQuery.QueryConstraints constraints() {
         return this.where;
      }

      public Map<String, Object> extraOptions() {
         return this.extraOptions;
      }

      public boolean ignoreACLs() {
         return this.ignoreACLs;
      }

      public Set<String> includes() {
         return this.include;
      }

      public boolean isFromLocalDatastore() {
         return this.isFromLocalDatastore;
      }

      public boolean isTracingEnabled() {
         return this.trace;
      }

      public int limit() {
         return this.limit;
      }

      public long maxCacheAge() {
         return this.maxCacheAge;
      }

      public List<String> order() {
         return this.order;
      }

      public String pinName() {
         return this.pinName;
      }

      public Set<String> selectedKeys() {
         return this.selectedKeys;
      }

      public int skip() {
         return this.skip;
      }

      JSONObject toJSON(ParseEncoder param1) {
         // $FF: Couldn't be decompiled
      }

      public String toString() {
         Locale var1 = Locale.US;
         Object[] var2 = new Object[]{this.getClass().getName(), this.className, this.where, this.include, this.selectedKeys, Integer.valueOf(this.limit), Integer.valueOf(this.skip), this.order, this.extraOptions, this.cachePolicy, Long.valueOf(this.maxCacheAge), Boolean.valueOf(this.trace)};
         return String.format(var1, "%s[className=%s, where=%s, include=%s, selectedKeys=%s, limit=%s, skip=%s, order=%s, extraOptions=%s, cachePolicy=%s, maxCacheAge=%s, trace=%s]", var2);
      }
   }

   static class Builder<T extends ParseObject> {
      private ParseQuery.CachePolicy cachePolicy;
      private final String className;
      private final Map<String, Object> extraOptions;
      private boolean ignoreACLs;
      private final Set<String> includes;
      private boolean isFromLocalDatastore;
      private int limit;
      private long maxCacheAge;
      private List<String> order;
      private String pinName;
      private Set<String> selectedKeys;
      private int skip;
      private boolean trace;
      private final ParseQuery.QueryConstraints where;

      public Builder(ParseQuery.Builder<T> var1) {
         this.where = new ParseQuery.QueryConstraints();
         this.includes = new HashSet();
         this.limit = -1;
         this.skip = 0;
         this.order = new ArrayList();
         this.extraOptions = new HashMap();
         this.cachePolicy = ParseQuery.CachePolicy.IGNORE_CACHE;
         this.maxCacheAge = Long.MAX_VALUE;
         this.isFromLocalDatastore = false;
         this.className = var1.className;
         this.where.putAll(var1.where);
         this.includes.addAll(var1.includes);
         HashSet var3;
         if(var1.selectedKeys != null) {
            var3 = new HashSet(var1.selectedKeys);
         } else {
            var3 = null;
         }

         this.selectedKeys = var3;
         this.limit = var1.limit;
         this.skip = var1.skip;
         this.order.addAll(var1.order);
         this.extraOptions.putAll(var1.extraOptions);
         this.trace = var1.trace;
         this.cachePolicy = var1.cachePolicy;
         this.maxCacheAge = var1.maxCacheAge;
         this.isFromLocalDatastore = var1.isFromLocalDatastore;
         this.pinName = var1.pinName;
         this.ignoreACLs = var1.ignoreACLs;
      }

      public Builder(ParseQuery.State var1) {
         this.where = new ParseQuery.QueryConstraints();
         this.includes = new HashSet();
         this.limit = -1;
         this.skip = 0;
         this.order = new ArrayList();
         this.extraOptions = new HashMap();
         this.cachePolicy = ParseQuery.CachePolicy.IGNORE_CACHE;
         this.maxCacheAge = Long.MAX_VALUE;
         this.isFromLocalDatastore = false;
         this.className = var1.className();
         this.where.putAll(var1.constraints());
         this.includes.addAll(var1.includes());
         HashSet var3;
         if(var1.selectedKeys() != null) {
            var3 = new HashSet(var1.selectedKeys());
         } else {
            var3 = null;
         }

         this.selectedKeys = var3;
         this.limit = var1.limit();
         this.skip = var1.skip();
         this.order.addAll(var1.order());
         this.extraOptions.putAll(var1.extraOptions());
         this.trace = var1.isTracingEnabled();
         this.cachePolicy = var1.cachePolicy();
         this.maxCacheAge = var1.maxCacheAge();
         this.isFromLocalDatastore = var1.isFromLocalDatastore();
         this.pinName = var1.pinName();
         this.ignoreACLs = var1.ignoreACLs();
      }

      public Builder(Class<T> var1) {
         this(ParseQuery.getSubclassingController().getClassName(var1));
      }

      public Builder(String var1) {
         this.where = new ParseQuery.QueryConstraints();
         this.includes = new HashSet();
         this.limit = -1;
         this.skip = 0;
         this.order = new ArrayList();
         this.extraOptions = new HashMap();
         this.cachePolicy = ParseQuery.CachePolicy.IGNORE_CACHE;
         this.maxCacheAge = Long.MAX_VALUE;
         this.isFromLocalDatastore = false;
         this.className = var1;
      }

      private ParseQuery.Builder<T> addConditionInternal(String var1, String var2, Object var3) {
         boolean var4 = this.where.containsKey(var1);
         ParseQuery.KeyConstraints var5 = null;
         if(var4) {
            Object var8 = this.where.get(var1);
            boolean var9 = var8 instanceof ParseQuery.KeyConstraints;
            var5 = null;
            if(var9) {
               var5 = (ParseQuery.KeyConstraints)var8;
            }
         }

         if(var5 == null) {
            var5 = new ParseQuery.KeyConstraints();
         }

         var5.put(var2, var3);
         this.where.put(var1, var5);
         return this;
      }

      private ParseQuery.Builder<T> addOrder(String var1) {
         this.order.add(var1);
         return this;
      }

      // $FF: renamed from: or (java.util.List) com.parse.ParseQuery$State$Builder
      public static <T extends ParseObject> ParseQuery.Builder<T> method_350(List<ParseQuery.Builder<T>> var0) {
         if(var0.isEmpty()) {
            throw new IllegalArgumentException("Can\'t take an or of an empty list of queries");
         } else {
            String var1 = null;
            ArrayList var2 = new ArrayList();
            Iterator var3 = var0.iterator();

            while(var3.hasNext()) {
               ParseQuery.Builder var4 = (ParseQuery.Builder)var3.next();
               if(var1 != null && !var4.className.equals(var1)) {
                  throw new IllegalArgumentException("All of the queries in an or query must be on the same class ");
               }

               if(var4.limit >= 0) {
                  throw new IllegalArgumentException("Cannot have limits in sub queries of an \'OR\' query");
               }

               if(var4.skip > 0) {
                  throw new IllegalArgumentException("Cannot have skips in sub queries of an \'OR\' query");
               }

               if(!var4.order.isEmpty()) {
                  throw new IllegalArgumentException("Cannot have an order in sub queries of an \'OR\' query");
               }

               if(!var4.includes.isEmpty()) {
                  throw new IllegalArgumentException("Cannot have an include in sub queries of an \'OR\' query");
               }

               if(var4.selectedKeys != null) {
                  throw new IllegalArgumentException("Cannot have an selectKeys in sub queries of an \'OR\' query");
               }

               var1 = var4.className;
               var2.add(var4.where);
            }

            return (new ParseQuery.Builder(var1)).whereSatifiesAnyOf(var2);
         }
      }

      private ParseQuery.Builder<T> setOrder(String var1) {
         this.order.clear();
         this.order.add(var1);
         return this;
      }

      private ParseQuery.Builder<T> whereSatifiesAnyOf(List<ParseQuery.QueryConstraints> var1) {
         this.where.put("$or", var1);
         return this;
      }

      public ParseQuery.Builder<T> addAscendingOrder(String var1) {
         return this.addOrder(var1);
      }

      public ParseQuery.Builder<T> addCondition(String var1, String var2, Object var3) {
         return this.addConditionInternal(var1, var2, var3);
      }

      public ParseQuery.Builder<T> addCondition(String var1, String var2, Collection<? extends Object> var3) {
         return this.addConditionInternal(var1, var2, Collections.unmodifiableCollection(var3));
      }

      public ParseQuery.Builder<T> addDescendingOrder(String var1) {
         return this.addOrder(String.format("-%s", new Object[]{var1}));
      }

      public ParseQuery.State<T> build() {
         if(!this.isFromLocalDatastore && this.ignoreACLs) {
            throw new IllegalStateException("`ignoreACLs` cannot be combined with network queries");
         } else {
            return new ParseQuery.State(this, null);
         }
      }

      public ParseQuery.Builder<T> fromLocalDatastore() {
         return this.fromPin((String)null);
      }

      public ParseQuery.Builder<T> fromNetwork() {
         ParseQuery.throwIfLDSDisabled();
         this.isFromLocalDatastore = false;
         this.pinName = null;
         return this;
      }

      public ParseQuery.Builder<T> fromPin() {
         return this.fromPin("_default");
      }

      public ParseQuery.Builder<T> fromPin(String var1) {
         ParseQuery.throwIfLDSDisabled();
         this.isFromLocalDatastore = true;
         this.pinName = var1;
         return this;
      }

      public ParseQuery.CachePolicy getCachePolicy() {
         ParseQuery.throwIfLDSEnabled();
         return this.cachePolicy;
      }

      public String getClassName() {
         return this.className;
      }

      public int getLimit() {
         return this.limit;
      }

      public long getMaxCacheAge() {
         ParseQuery.throwIfLDSEnabled();
         return this.maxCacheAge;
      }

      public int getSkip() {
         return this.skip;
      }

      public ParseQuery.Builder<T> ignoreACLs() {
         ParseQuery.throwIfLDSDisabled();
         this.ignoreACLs = true;
         return this;
      }

      public ParseQuery.Builder<T> include(String var1) {
         this.includes.add(var1);
         return this;
      }

      public boolean isFromLocalDatstore() {
         return this.isFromLocalDatastore;
      }

      public boolean isFromNetwork() {
         ParseQuery.throwIfLDSDisabled();
         return !this.isFromLocalDatastore;
      }

      public ParseQuery.Builder<T> maxDistance(String var1, double var2) {
         return this.addCondition(var1, "$maxDistance", (Object)Double.valueOf(var2));
      }

      public ParseQuery.Builder<T> orderByAscending(String var1) {
         return this.setOrder(var1);
      }

      public ParseQuery.Builder<T> orderByDescending(String var1) {
         return this.setOrder(String.format("-%s", new Object[]{var1}));
      }

      ParseQuery.Builder<T> redirectClassNameForKey(String var1) {
         this.extraOptions.put("redirectClassNameForKey", var1);
         return this;
      }

      public ParseQuery.Builder<T> selectKeys(Collection<String> var1) {
         if(this.selectedKeys == null) {
            this.selectedKeys = new HashSet();
         }

         this.selectedKeys.addAll(var1);
         return this;
      }

      public ParseQuery.Builder<T> setCachePolicy(ParseQuery.CachePolicy var1) {
         ParseQuery.throwIfLDSEnabled();
         this.cachePolicy = var1;
         return this;
      }

      public ParseQuery.Builder<T> setLimit(int var1) {
         this.limit = var1;
         return this;
      }

      public ParseQuery.Builder<T> setMaxCacheAge(long var1) {
         ParseQuery.throwIfLDSEnabled();
         this.maxCacheAge = var1;
         return this;
      }

      public ParseQuery.Builder<T> setSkip(int var1) {
         this.skip = var1;
         return this;
      }

      public ParseQuery.Builder<T> setTracingEnabled(boolean var1) {
         this.trace = var1;
         return this;
      }

      public ParseQuery.Builder<T> whereDoesNotMatchKeyInQuery(String var1, String var2, ParseQuery.Builder<?> var3) {
         HashMap var4 = new HashMap();
         var4.put("key", var2);
         var4.put("query", var3);
         return this.addConditionInternal(var1, "$dontSelect", Collections.unmodifiableMap(var4));
      }

      public ParseQuery.Builder<T> whereDoesNotMatchQuery(String var1, ParseQuery.Builder<?> var2) {
         return this.addConditionInternal(var1, "$notInQuery", var2);
      }

      public ParseQuery.Builder<T> whereEqualTo(String var1, Object var2) {
         this.where.put(var1, var2);
         return this;
      }

      public ParseQuery.Builder<T> whereMatchesKeyInQuery(String var1, String var2, ParseQuery.Builder<?> var3) {
         HashMap var4 = new HashMap();
         var4.put("key", var2);
         var4.put("query", var3);
         return this.addConditionInternal(var1, "$select", Collections.unmodifiableMap(new HashMap(var4)));
      }

      public ParseQuery.Builder<T> whereMatchesQuery(String var1, ParseQuery.Builder<?> var2) {
         return this.addConditionInternal(var1, "$inQuery", var2);
      }

      public ParseQuery.Builder<T> whereNear(String var1, ParseGeoPoint var2) {
         return this.addCondition(var1, "$nearSphere", (Object)var2);
      }

      ParseQuery.Builder<T> whereObjectIdEquals(String var1) {
         this.where.clear();
         this.where.put("objectId", var1);
         return this;
      }

      ParseQuery.Builder<T> whereRelatedTo(ParseObject var1, String var2) {
         this.where.put("$relatedTo", new ParseQuery.RelationConstraint(var2, var1));
         return this;
      }

      public ParseQuery.Builder<T> whereWithin(String var1, ParseGeoPoint var2, ParseGeoPoint var3) {
         ArrayList var4 = new ArrayList();
         var4.add(var2);
         var4.add(var3);
         HashMap var7 = new HashMap();
         var7.put("$box", var4);
         return this.addCondition(var1, "$within", (Object)var7);
      }
   }
}
