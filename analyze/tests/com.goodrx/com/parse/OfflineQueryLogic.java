package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.Numbers;
import com.parse.OfflineStore;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParsePin;
import com.parse.ParseQuery;
import com.parse.ParseSQLiteDatabase;
import com.parse.ParseUser;
import com.parse.PointerEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OfflineQueryLogic {
   private final OfflineStore store;

   OfflineQueryLogic(OfflineStore var1) {
      this.store = var1;
   }

   private static boolean compare(Object var0, Object var1, OfflineQueryLogic.Decider var2) {
      return var1 instanceof List?compareList(var0, (List)var1, var2):(var1 instanceof JSONArray?compareArray(var0, (JSONArray)var1, var2):var2.decide(var0, var1));
   }

   private static boolean compareArray(Object var0, JSONArray var1, OfflineQueryLogic.Decider var2) {
      for(int var3 = 0; var3 < var1.length(); ++var3) {
         boolean var5;
         try {
            var5 = var2.decide(var0, var1.get(var3));
         } catch (JSONException var6) {
            throw new RuntimeException(var6);
         }

         if(var5) {
            return true;
         }
      }

      return false;
   }

   private static boolean compareList(Object var0, List<?> var1, OfflineQueryLogic.Decider var2) {
      Iterator var3 = var1.iterator();

      do {
         if(!var3.hasNext()) {
            return false;
         }
      } while(!var2.decide(var0, var3.next()));

      return true;
   }

   private static int compareTo(Object var0, Object var1) {
      boolean var2;
      if(var0 != JSONObject.NULL && var0 != null) {
         var2 = false;
      } else {
         var2 = true;
      }

      boolean var3;
      if(var1 != JSONObject.NULL && var1 != null) {
         var3 = false;
      } else {
         var3 = true;
      }

      if(!var2 && !var3) {
         if(var0 instanceof Date && var1 instanceof Date) {
            return ((Date)var0).compareTo((Date)var1);
         } else if(var0 instanceof String && var1 instanceof String) {
            return ((String)var0).compareTo((String)var1);
         } else if(var0 instanceof Number && var1 instanceof Number) {
            return Numbers.compare((Number)var0, (Number)var1);
         } else {
            throw new IllegalArgumentException(String.format("Cannot compare %s against %s", new Object[]{var0, var1}));
         }
      } else {
         return !var2?1:(!var3?-1:0);
      }
   }

   private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createDontSelectMatcher(final ParseUser var1, Object var2, String var3) {
      return new OfflineQueryLogic.ConstraintMatcher(var1) {
         // $FF: synthetic field
         final OfflineQueryLogic.ConstraintMatcher val$selectMatcher;

         {
            this.val$selectMatcher = var3;
         }

         public Task<Boolean> matchesAsync(T var1, ParseSQLiteDatabase var2) {
            return this.val$selectMatcher.matchesAsync(var1, var2).onSuccess(new Continuation() {
               public Boolean then(Task<Boolean> var1) throws Exception {
                  boolean var2;
                  if(!((Boolean)var1.getResult()).booleanValue()) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  return Boolean.valueOf(var2);
               }
            });
         }
      };
   }

   private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createInQueryMatcher(final ParseUser var1, Object var2, final String var3) {
      return new OfflineQueryLogic.SubQueryMatcher(var1, ((ParseQuery.Builder)var2).build()) {
         protected boolean matches(T var1, List<T> var2) throws ParseException {
            return OfflineQueryLogic.matchesInConstraint(var2, OfflineQueryLogic.getValue(var1, var3));
         }
      };
   }

   private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createMatcher(final ParseUser var1, ParseQuery.QueryConstraints var2) {
      final ArrayList var3 = new ArrayList();
      Iterator var4 = var2.keySet().iterator();

      while(true) {
         while(var4.hasNext()) {
            final String var5 = (String)var4.next();
            final Object var6 = var2.get(var5);
            if(var5.equals("$or")) {
               var3.add(this.createOrMatcher(var1, (ArrayList)var6));
            } else if(var6 instanceof ParseQuery.KeyConstraints) {
               ParseQuery.KeyConstraints var9 = (ParseQuery.KeyConstraints)var6;
               Iterator var10 = var9.keySet().iterator();

               while(var10.hasNext()) {
                  String var11 = (String)var10.next();
                  var3.add(this.createMatcher(var1, var11, var9.get(var11), var5, var9));
               }
            } else if(var6 instanceof ParseQuery.RelationConstraint) {
               var3.add(new OfflineQueryLogic.ConstraintMatcher(var1) {
                  // $FF: synthetic field
                  final ParseQuery.RelationConstraint val$relation;

                  {
                     this.val$relation = var3;
                  }

                  public Task<Boolean> matchesAsync(T var1, ParseSQLiteDatabase var2) {
                     return Task.forResult(Boolean.valueOf(this.val$relation.getRelation().hasKnownObject(var1)));
                  }
               });
            } else {
               var3.add(new OfflineQueryLogic.ConstraintMatcher(var1) {
                  public Task<Boolean> matchesAsync(T var1, ParseSQLiteDatabase var2) {
                     Object var4;
                     try {
                        var4 = OfflineQueryLogic.getValue(var1, var5);
                     } catch (ParseException var5x) {
                        return Task.forError(var5x);
                     }

                     return Task.forResult(Boolean.valueOf(OfflineQueryLogic.matchesEqualConstraint(var6, var4)));
                  }
               });
            }
         }

         return new OfflineQueryLogic.ConstraintMatcher(var1) {
            public Task<Boolean> matchesAsync(final T var1, final ParseSQLiteDatabase var2) {
               Task var3x = Task.forResult(Boolean.valueOf(true));

               for(Iterator var4 = var3.iterator(); var4.hasNext(); var3x = var3x.onSuccessTask(new Continuation() {
                  // $FF: synthetic field
                  final OfflineQueryLogic.ConstraintMatcher val$matcher;

                  {
                     this.val$matcher = var2x;
                  }

                  public Task<Boolean> then(Task<Boolean> var1x) throws Exception {
                     return !((Boolean)var1x.getResult()).booleanValue()?var1x:this.val$matcher.matchesAsync(var1, var2);
                  }
               })) {
                  ;
               }

               return var3x;
            }
         };
      }
   }

   private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createMatcher(final ParseUser var1, final String var2, final Object var3, final String var4, final ParseQuery.KeyConstraints var5) {
      byte var6 = -1;
      switch(var2.hashCode()) {
      case -721570031:
         if(var2.equals("$dontSelect")) {
            var6 = 3;
         }
         break;
      case 242866687:
         if(var2.equals("$inQuery")) {
            var6 = 0;
         }
         break;
      case 427054964:
         if(var2.equals("$notInQuery")) {
            var6 = 1;
         }
         break;
      case 979339808:
         if(var2.equals("$select")) {
            var6 = 2;
         }
      }

      switch(var6) {
      case 0:
         return this.createInQueryMatcher(var1, var3, var4);
      case 1:
         return this.createNotInQueryMatcher(var1, var3, var4);
      case 2:
         return this.createSelectMatcher(var1, var3, var4);
      case 3:
         return this.createDontSelectMatcher(var1, var3, var4);
      default:
         return new OfflineQueryLogic.ConstraintMatcher(var1) {
            public Task<Boolean> matchesAsync(T var1, ParseSQLiteDatabase var2x) {
               try {
                  Object var4x = OfflineQueryLogic.getValue(var1, var4);
                  Task var5x = Task.forResult(Boolean.valueOf(OfflineQueryLogic.matchesStatelessConstraint(var2, var3, var4x, var5)));
                  return var5x;
               } catch (ParseException var6) {
                  return Task.forError(var6);
               }
            }
         };
      }
   }

   private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createNotInQueryMatcher(final ParseUser var1, Object var2, String var3) {
      return new OfflineQueryLogic.ConstraintMatcher(var1) {
         // $FF: synthetic field
         final OfflineQueryLogic.ConstraintMatcher val$inQueryMatcher;

         {
            this.val$inQueryMatcher = var3;
         }

         public Task<Boolean> matchesAsync(T var1, ParseSQLiteDatabase var2) {
            return this.val$inQueryMatcher.matchesAsync(var1, var2).onSuccess(new Continuation() {
               public Boolean then(Task<Boolean> var1) throws Exception {
                  boolean var2;
                  if(!((Boolean)var1.getResult()).booleanValue()) {
                     var2 = true;
                  } else {
                     var2 = false;
                  }

                  return Boolean.valueOf(var2);
               }
            });
         }
      };
   }

   private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createOrMatcher(final ParseUser var1, ArrayList<ParseQuery.QueryConstraints> var2) {
      final ArrayList var3 = new ArrayList();
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         var3.add(this.createMatcher(var1, (ParseQuery.QueryConstraints)var4.next()));
      }

      return new OfflineQueryLogic.ConstraintMatcher(var1) {
         public Task<Boolean> matchesAsync(final T var1, final ParseSQLiteDatabase var2) {
            Task var3x = Task.forResult(Boolean.valueOf(false));

            for(Iterator var4 = var3.iterator(); var4.hasNext(); var3x = var3x.onSuccessTask(new Continuation() {
               // $FF: synthetic field
               final OfflineQueryLogic.ConstraintMatcher val$matcher;

               {
                  this.val$matcher = var2x;
               }

               public Task<Boolean> then(Task<Boolean> var1x) throws Exception {
                  return ((Boolean)var1x.getResult()).booleanValue()?var1x:this.val$matcher.matchesAsync(var1, var2);
               }
            })) {
               ;
            }

            return var3x;
         }
      };
   }

   private <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createSelectMatcher(final ParseUser var1, Object var2, final String var3) {
      Map var4 = (Map)var2;
      return new OfflineQueryLogic.SubQueryMatcher(var1, ((ParseQuery.Builder)var4.get("query")).build()) {
         // $FF: synthetic field
         final String val$resultKey;

         {
            this.val$resultKey = var5;
         }

         protected boolean matches(T var1, List<T> var2) throws ParseException {
            Object var3x = OfflineQueryLogic.getValue(var1, var3);
            Iterator var4 = var2.iterator();

            do {
               if(!var4.hasNext()) {
                  return false;
               }
            } while(!OfflineQueryLogic.matchesEqualConstraint(var3x, OfflineQueryLogic.getValue((ParseObject)var4.next(), this.val$resultKey)));

            return true;
         }
      };
   }

   private static Task<Void> fetchIncludeAsync(final OfflineStore var0, final Object var1, final String var2, final ParseSQLiteDatabase var3) throws ParseException {
      Task var8;
      if(var1 == null) {
         var8 = Task.forResult((Object)null);
      } else if(var1 instanceof Collection) {
         Collection var11 = (Collection)var1;
         var8 = Task.forResult((Object)null);

         Continuation var13;
         for(Iterator var12 = var11.iterator(); var12.hasNext(); var8 = var8.onSuccessTask(var13)) {
            var13 = new Continuation() {
               // $FF: synthetic field
               final Object val$item;

               {
                  this.val$item = var2x;
               }

               public Task<Void> then(Task<Void> var1) throws Exception {
                  return OfflineQueryLogic.fetchIncludeAsync(var0, this.val$item, var2, var3);
               }
            };
         }
      } else {
         if(!(var1 instanceof JSONArray)) {
            if(var2 == null) {
               if(JSONObject.NULL.equals(var1)) {
                  return Task.forResult((Object)null);
               }

               if(var1 instanceof ParseObject) {
                  return var0.fetchLocallyAsync((ParseObject)var1, var3).makeVoid();
               }

               return Task.forError(new ParseException(121, "include is invalid for non-ParseObjects"));
            }

            String[] var4 = var2.split("\\.", 2);
            final String var5 = var4[0];
            final String var6;
            if(var4.length > 1) {
               var6 = var4[1];
            } else {
               var6 = null;
            }

            return Task.forResult((Object)null).continueWithTask(new Continuation() {
               public Task<Object> then(Task<Void> var1x) throws Exception {
                  Task var3x;
                  if(var1 instanceof ParseObject) {
                     var3x = OfflineQueryLogic.fetchIncludeAsync(var0, var1, (String)null, var3).onSuccess(new Continuation() {
                        public Object then(Task<Void> var1x) throws Exception {
                           return ((ParseObject)var1).get(var5);
                        }
                     });
                  } else {
                     if(var1 instanceof Map) {
                        return Task.forResult(((Map)var1).get(var5));
                     }

                     if(var1 instanceof JSONObject) {
                        return Task.forResult(((JSONObject)var1).opt(var5));
                     }

                     boolean var2 = JSONObject.NULL.equals(var1);
                     var3x = null;
                     if(!var2) {
                        return Task.forError(new IllegalStateException("include is invalid"));
                     }
                  }

                  return var3x;
               }
            }).onSuccessTask(new Continuation() {
               public Task<Void> then(Task<Object> var1) throws Exception {
                  return OfflineQueryLogic.fetchIncludeAsync(var0, var1.getResult(), var6, var3);
               }
            });
         }

         final JSONArray var7 = (JSONArray)var1;
         var8 = Task.forResult((Object)null);

         for(final int var9 = 0; var9 < var7.length(); ++var9) {
            Continuation var10 = new Continuation() {
               public Task<Void> then(Task<Void> var1) throws Exception {
                  return OfflineQueryLogic.fetchIncludeAsync(var0, var7.get(var9), var2, var3);
               }
            };
            var8 = var8.onSuccessTask(var10);
         }
      }

      return var8;
   }

   static <T extends ParseObject> Task<Void> fetchIncludesAsync(final OfflineStore var0, final T var1, ParseQuery.State<T> var2, final ParseSQLiteDatabase var3) {
      Set var4 = var2.includes();
      Task var5 = Task.forResult((Object)null);

      for(Iterator var6 = var4.iterator(); var6.hasNext(); var5 = var5.onSuccessTask(new Continuation() {
         // $FF: synthetic field
         final String val$include;

         {
            this.val$include = var3x;
         }

         public Task<Void> then(Task<Void> var1x) throws Exception {
            return OfflineQueryLogic.fetchIncludeAsync(var0, var1, this.val$include, var3);
         }
      })) {
         ;
      }

      return var5;
   }

   private static Object getValue(Object var0, String var1) throws ParseException {
      return getValue(var0, var1, 0);
   }

   private static Object getValue(Object var0, String var1, int var2) throws ParseException {
      Object var4;
      if(!var1.contains(".")) {
         if(var0 instanceof ParseObject) {
            ParseObject var5 = (ParseObject)var0;
            if(!var5.isDataAvailable()) {
               throw new ParseException(121, String.format("Bad key: %s", new Object[]{var1}));
            }

            byte var6 = -1;
            switch(var1.hashCode()) {
            case -1949194674:
               if(var1.equals("updatedAt")) {
                  var6 = 3;
               }
               break;
            case -1836974455:
               if(var1.equals("_created_at")) {
                  var6 = 2;
               }
               break;
            case 90495162:
               if(var1.equals("objectId")) {
                  var6 = 0;
               }
               break;
            case 598371643:
               if(var1.equals("createdAt")) {
                  var6 = 1;
               }
               break;
            case 792848342:
               if(var1.equals("_updated_at")) {
                  var6 = 4;
               }
            }

            switch(var6) {
            case 0:
               return var5.getObjectId();
            case 1:
            case 2:
               return var5.getCreatedAt();
            case 3:
            case 4:
               return var5.getUpdatedAt();
            default:
               return var5.get(var1);
            }
         }

         if(var0 instanceof JSONObject) {
            return ((JSONObject)var0).opt(var1);
         }

         if(var0 instanceof Map) {
            return ((Map)var0).get(var1);
         }

         Object var3 = JSONObject.NULL;
         var4 = null;
         if(var0 != var3) {
            var4 = null;
            if(var0 != null) {
               throw new ParseException(121, String.format("Bad key: %s", new Object[]{var1}));
            }
         }
      } else {
         String[] var7 = var1.split("\\.", 2);
         Object var8 = getValue(var0, var7[0], var2 + 1);
         if(var8 != null && var8 != JSONObject.NULL && !(var8 instanceof Map) && !(var8 instanceof JSONObject)) {
            if(var2 > 0) {
               Object var10;
               label71: {
                  Object var11;
                  try {
                     var11 = PointerEncoder.get().encode(var8);
                  } catch (Exception var12) {
                     var10 = null;
                     break label71;
                  }

                  var10 = var11;
               }

               if(var10 instanceof JSONObject) {
                  var4 = getValue(var10, var7[1], var2 + 1);
                  return var4;
               }
            }

            throw new ParseException(102, String.format("Key %s is invalid.", new Object[]{var1}));
         }

         return getValue(var8, var7[1], var2 + 1);
      }

      return var4;
   }

   static <T extends ParseObject> boolean hasReadAccess(ParseUser var0, T var1) {
      if(var0 != var1) {
         ParseACL var2 = var1.getACL();
         if(var2 != null && !var2.getPublicReadAccess() && (var0 == null || !var2.getReadAccess(var0))) {
            return false;
         }
      }

      return true;
   }

   static <T extends ParseObject> boolean hasWriteAccess(ParseUser var0, T var1) {
      if(var0 != var1) {
         ParseACL var2 = var1.getACL();
         if(var2 != null && !var2.getPublicWriteAccess() && (var0 == null || !var2.getWriteAccess(var0))) {
            return false;
         }
      }

      return true;
   }

   private static boolean matchesAllConstraint(Object var0, Object var1) {
      if(var1 != null && var1 != JSONObject.NULL) {
         if(!(var1 instanceof Collection)) {
            throw new IllegalArgumentException("Value type not supported for $all queries.");
         } else if(var0 instanceof Collection) {
            Iterator var2 = ((Collection)var0).iterator();

            do {
               if(!var2.hasNext()) {
                  return true;
               }
            } while(matchesEqualConstraint(var2.next(), var1));

            return false;
         } else {
            throw new IllegalArgumentException("Constraint type not supported for $all queries.");
         }
      } else {
         return false;
      }
   }

   private static boolean matchesEqualConstraint(Object var0, Object var1) {
      if(var0 != null && var1 != null) {
         if(var0 instanceof Number && var1 instanceof Number) {
            if(compareTo(var0, var1) != 0) {
               return false;
            }
         } else {
            if(var0 instanceof ParseGeoPoint && var1 instanceof ParseGeoPoint) {
               ParseGeoPoint var2 = (ParseGeoPoint)var0;
               ParseGeoPoint var3 = (ParseGeoPoint)var1;
               if(var2.getLatitude() == var3.getLatitude() && var2.getLongitude() == var3.getLongitude()) {
                  return true;
               }

               return false;
            }

            return compare(var0, var1, new OfflineQueryLogic.Decider() {
               public boolean decide(Object var1, Object var2) {
                  return var1.equals(var2);
               }
            });
         }
      } else if(var0 != var1) {
         return false;
      }

      return true;
   }

   private static boolean matchesExistsConstraint(Object var0, Object var1) {
      if(var0 != null && ((Boolean)var0).booleanValue()) {
         return var1 != null && var1 != JSONObject.NULL;
      } else {
         boolean var2;
         if(var1 != null) {
            Object var3 = JSONObject.NULL;
            var2 = false;
            if(var1 != var3) {
               return var2;
            }
         }

         var2 = true;
         return var2;
      }
   }

   private static boolean matchesGreaterThanConstraint(Object var0, Object var1) {
      return compare(var0, var1, new OfflineQueryLogic.Decider() {
         public boolean decide(Object var1, Object var2) {
            return var2 != null && var2 != JSONObject.NULL && OfflineQueryLogic.compareTo(var1, var2) < 0;
         }
      });
   }

   private static boolean matchesGreaterThanOrEqualToConstraint(Object var0, Object var1) {
      return compare(var0, var1, new OfflineQueryLogic.Decider() {
         public boolean decide(Object var1, Object var2) {
            return var2 != null && var2 != JSONObject.NULL && OfflineQueryLogic.compareTo(var1, var2) <= 0;
         }
      });
   }

   private static boolean matchesInConstraint(Object var0, Object var1) {
      if(var0 instanceof Collection) {
         Iterator var2 = ((Collection)var0).iterator();

         do {
            if(!var2.hasNext()) {
               return false;
            }
         } while(!matchesEqualConstraint(var2.next(), var1));

         return true;
      } else {
         throw new IllegalArgumentException("Constraint type not supported for $in queries.");
      }
   }

   private static boolean matchesLessThanConstraint(Object var0, Object var1) {
      return compare(var0, var1, new OfflineQueryLogic.Decider() {
         public boolean decide(Object var1, Object var2) {
            return var2 != null && var2 != JSONObject.NULL && OfflineQueryLogic.compareTo(var1, var2) > 0;
         }
      });
   }

   private static boolean matchesLessThanOrEqualToConstraint(Object var0, Object var1) {
      return compare(var0, var1, new OfflineQueryLogic.Decider() {
         public boolean decide(Object var1, Object var2) {
            return var2 != null && var2 != JSONObject.NULL && OfflineQueryLogic.compareTo(var1, var2) >= 0;
         }
      });
   }

   private static boolean matchesNearSphereConstraint(Object var0, Object var1, Double var2) {
      boolean var3 = true;
      if(var1 != null && var1 != JSONObject.NULL) {
         if(var2 != null && ((ParseGeoPoint)var0).distanceInRadiansTo((ParseGeoPoint)var1) > var2.doubleValue()) {
            return false;
         }
      } else {
         var3 = false;
      }

      return var3;
   }

   private static boolean matchesNotEqualConstraint(Object var0, Object var1) {
      return !matchesEqualConstraint(var0, var1);
   }

   private static boolean matchesNotInConstraint(Object var0, Object var1) {
      return !matchesInConstraint(var0, var1);
   }

   private static boolean matchesRegexConstraint(Object var0, Object var1, String var2) throws ParseException {
      if(var1 != null && var1 != JSONObject.NULL) {
         if(var2 == null) {
            var2 = "";
         }

         if(!var2.matches("^[imxs]*$")) {
            throw new ParseException(102, String.format("Invalid regex options: %s", new Object[]{var2}));
         } else {
            boolean var3 = var2.contains("i");
            int var4 = 0;
            if(var3) {
               var4 = 0 | 2;
            }

            if(var2.contains("m")) {
               var4 |= 8;
            }

            if(var2.contains("x")) {
               var4 |= 4;
            }

            if(var2.contains("s")) {
               var4 |= 32;
            }

            return Pattern.compile((String)var0, var4).matcher((String)var1).find();
         }
      } else {
         return false;
      }
   }

   private static boolean matchesStatelessConstraint(String var0, Object var1, Object var2, ParseQuery.KeyConstraints var3) throws ParseException {
      byte var4 = 1;
      byte var5 = -1;
      switch(var0.hashCode()) {
      case -1622199595:
         if(var0.equals("$maxDistance")) {
            var5 = 12;
         }
         break;
      case -443727559:
         if(var0.equals("$nearSphere")) {
            var5 = 11;
         }
         break;
      case 37905:
         if(var0.equals("$gt")) {
            var5 = 3;
         }
         break;
      case 37961:
         if(var0.equals("$in")) {
            var5 = 5;
         }
         break;
      case 38060:
         if(var0.equals("$lt")) {
            var5 = var4;
         }
         break;
      case 38107:
         if(var0.equals("$ne")) {
            var5 = 0;
         }
         break;
      case 1169149:
         if(var0.equals("$all")) {
            var5 = 7;
         }
         break;
      case 1175156:
         if(var0.equals("$gte")) {
            var5 = 4;
         }
         break;
      case 1179961:
         if(var0.equals("$lte")) {
            var5 = 2;
         }
         break;
      case 1181551:
         if(var0.equals("$nin")) {
            var5 = 6;
         }
         break;
      case 596003200:
         if(var0.equals("$exists")) {
            var5 = 10;
         }
         break;
      case 1097791887:
         if(var0.equals("$within")) {
            var5 = 13;
         }
         break;
      case 1139041955:
         if(var0.equals("$regex")) {
            var5 = 8;
         }
         break;
      case 1362155002:
         if(var0.equals("$options")) {
            var5 = 9;
         }
      }

      switch(var5) {
      case 0:
         var4 = matchesNotEqualConstraint(var1, var2);
      case 9:
      case 12:
         return (boolean)var4;
      case 1:
         return matchesLessThanConstraint(var1, var2);
      case 2:
         return matchesLessThanOrEqualToConstraint(var1, var2);
      case 3:
         return matchesGreaterThanConstraint(var1, var2);
      case 4:
         return matchesGreaterThanOrEqualToConstraint(var1, var2);
      case 5:
         return matchesInConstraint(var1, var2);
      case 6:
         return matchesNotInConstraint(var1, var2);
      case 7:
         return matchesAllConstraint(var1, var2);
      case 8:
         return matchesRegexConstraint(var1, var2, (String)var3.get("$options"));
      case 10:
         return matchesExistsConstraint(var1, var2);
      case 11:
         return matchesNearSphereConstraint(var1, var2, (Double)var3.get("$maxDistance"));
      case 13:
         return matchesWithinConstraint(var1, var2);
      default:
         Object[] var6 = new Object[var4];
         var6[0] = var0;
         throw new UnsupportedOperationException(String.format("The offline store does not yet support the %s operator.", var6));
      }
   }

   private static boolean matchesWithinConstraint(Object var0, Object var1) throws ParseException {
      byte var2 = 1;
      if(var1 != null && var1 != JSONObject.NULL) {
         ArrayList var3 = (ArrayList)((HashMap)var0).get("$box");
         ParseGeoPoint var4 = (ParseGeoPoint)var3.get(0);
         ParseGeoPoint var5 = (ParseGeoPoint)var3.get(var2);
         ParseGeoPoint var6 = (ParseGeoPoint)var1;
         if(var5.getLongitude() < var4.getLongitude()) {
            throw new ParseException(102, "whereWithinGeoBox queries cannot cross the International Date Line.");
         }

         if(var5.getLatitude() < var4.getLatitude()) {
            throw new ParseException(102, "The southwest corner of a geo box must be south of the northeast corner.");
         }

         if(var5.getLongitude() - var4.getLongitude() > 180.0D) {
            throw new ParseException(102, "Geo box queries larger than 180 degrees in longitude are not supported. Please check point order.");
         }

         if(var6.getLatitude() < var4.getLatitude() || var6.getLatitude() > var5.getLatitude() || var6.getLongitude() < var4.getLongitude() || var6.getLongitude() > var5.getLongitude()) {
            return false;
         }
      } else {
         var2 = 0;
      }

      return (boolean)var2;
   }

   static <T extends ParseObject> void sort(List<T> var0, ParseQuery.State<T> var1) throws ParseException {
      final List var2 = var1.order();
      Iterator var3 = var1.order().iterator();

      String var12;
      do {
         if(!var3.hasNext()) {
            final String var4 = null;
            final ParseGeoPoint var5 = null;
            Iterator var6 = var1.constraints().keySet().iterator();

            while(var6.hasNext()) {
               String var9 = (String)var6.next();
               Object var10 = var1.constraints().get(var9);
               if(var10 instanceof ParseQuery.KeyConstraints) {
                  ParseQuery.KeyConstraints var11 = (ParseQuery.KeyConstraints)var10;
                  if(var11.containsKey("$nearSphere")) {
                     var4 = var9;
                     var5 = (ParseGeoPoint)var11.get("$nearSphere");
                  }
               }
            }

            if(var2.size() == 0 && var4 == null) {
               return;
            }

            Collections.sort(var0, new Comparator() {
               public int compare(T var1, T var2x) {
                  if(var4 != null) {
                     ParseGeoPoint var14;
                     ParseGeoPoint var15;
                     try {
                        var14 = (ParseGeoPoint)OfflineQueryLogic.getValue(var1, var4);
                        var15 = (ParseGeoPoint)OfflineQueryLogic.getValue(var2x, var4);
                     } catch (ParseException var22) {
                        throw new RuntimeException(var22);
                     }

                     double var16 = var14.distanceInRadiansTo(var5);
                     double var18 = var15.distanceInRadiansTo(var5);
                     if(var16 != var18) {
                        if(var16 - var18 > 0.0D) {
                           return 1;
                        }

                        return -1;
                     }
                  }

                  Iterator var3 = var2.iterator();

                  boolean var6;
                  int var11;
                  int var12;
                  do {
                     if(!var3.hasNext()) {
                        return 0;
                     }

                     String var4x = (String)var3.next();
                     boolean var5x = var4x.startsWith("-");
                     var6 = false;
                     if(var5x) {
                        var6 = true;
                        var4x = var4x.substring(1);
                     }

                     Object var8;
                     Object var9;
                     try {
                        var8 = OfflineQueryLogic.getValue(var1, var4x);
                        var9 = OfflineQueryLogic.getValue(var2x, var4x);
                     } catch (ParseException var21) {
                        throw new RuntimeException(var21);
                     }

                     try {
                        var11 = OfflineQueryLogic.compareTo(var8, var9);
                     } catch (IllegalArgumentException var20) {
                        throw new IllegalArgumentException(String.format("Unable to sort by key %s.", new Object[]{var4x}), var20);
                     }

                     var12 = var11;
                  } while(var11 == 0);

                  if(var6) {
                     var12 = -var11;
                  }

                  return var12;
               }
            });
            return;
         }

         var12 = (String)var3.next();
      } while(var12.matches("^-?[A-Za-z][A-Za-z0-9_]*$") || "_created_at".equals(var12) || "_updated_at".equals(var12));

      throw new ParseException(105, String.format("Invalid key name: \"%s\".", new Object[]{var12}));
   }

   <T extends ParseObject> OfflineQueryLogic.ConstraintMatcher<T> createMatcher(ParseQuery.State<T> var1, final ParseUser var2) {
      return new OfflineQueryLogic.ConstraintMatcher(var2) {
         // $FF: synthetic field
         final OfflineQueryLogic.ConstraintMatcher val$constraintMatcher;
         // $FF: synthetic field
         final boolean val$ignoreACLs;

         {
            this.val$ignoreACLs = var3;
            this.val$constraintMatcher = var4;
         }

         public Task<Boolean> matchesAsync(T var1, ParseSQLiteDatabase var2) {
            return !this.val$ignoreACLs && !OfflineQueryLogic.hasReadAccess(this.user, var1)?Task.forResult(Boolean.valueOf(false)):this.val$constraintMatcher.matchesAsync(var1, var2);
         }
      };
   }

   abstract class ConstraintMatcher<T extends ParseObject> {
      final ParseUser user;

      public ConstraintMatcher(ParseUser var2) {
         this.user = var2;
      }

      abstract Task<Boolean> matchesAsync(T var1, ParseSQLiteDatabase var2);
   }

   private interface Decider {
      boolean decide(Object var1, Object var2);
   }

   private abstract class SubQueryMatcher<T extends ParseObject> extends OfflineQueryLogic.ConstraintMatcher<T> {
      private final ParseQuery.State<T> subQuery;
      private Task<List<T>> subQueryResults = null;

      public SubQueryMatcher(ParseUser var1, ParseQuery.State<T> var2) {
         super();
         this.subQuery = var3;
      }

      protected abstract boolean matches(T var1, List<T> var2) throws ParseException;

      public Task<Boolean> matchesAsync(final T var1, ParseSQLiteDatabase var2) {
         if(this.subQueryResults == null) {
            this.subQueryResults = OfflineQueryLogic.this.store.findAsync(this.subQuery, this.user, (ParsePin)null, var2);
         }

         return this.subQueryResults.onSuccess(new Continuation() {
            public Boolean then(Task<List<T>> var1x) throws ParseException {
               return Boolean.valueOf(SubQueryMatcher.this.matches(var1, (List)var1x.getResult()));
            }
         });
      }
   }
}
