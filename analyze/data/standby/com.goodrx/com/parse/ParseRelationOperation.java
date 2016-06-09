package com.parse;

import com.parse.Parse;
import com.parse.ParseDeleteOperation;
import com.parse.ParseEncoder;
import com.parse.ParseFieldOperation;
import com.parse.ParseObject;
import com.parse.ParseRelation;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ParseRelationOperation<T extends ParseObject> implements ParseFieldOperation {
   private final Set<ParseObject> relationsToAdd;
   private final Set<ParseObject> relationsToRemove;
   private final String targetClass;

   private ParseRelationOperation(String var1, Set<ParseObject> var2, Set<ParseObject> var3) {
      this.targetClass = var1;
      this.relationsToAdd = new HashSet(var2);
      this.relationsToRemove = new HashSet(var3);
   }

   ParseRelationOperation(Set<T> var1, Set<T> var2) {
      this.relationsToAdd = new HashSet();
      this.relationsToRemove = new HashSet();
      String var3 = null;
      if(var1 != null) {
         Iterator var6 = var1.iterator();

         while(var6.hasNext()) {
            ParseObject var7 = (ParseObject)var6.next();
            this.addParseObjectToSet(var7, this.relationsToAdd);
            if(var3 == null) {
               var3 = var7.getClassName();
            } else if(!var3.equals(var7.getClassName())) {
               throw new IllegalArgumentException("All objects in a relation must be of the same class.");
            }
         }
      }

      if(var2 != null) {
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            ParseObject var5 = (ParseObject)var4.next();
            this.addParseObjectToSet(var5, this.relationsToRemove);
            if(var3 == null) {
               var3 = var5.getClassName();
            } else if(!var3.equals(var5.getClassName())) {
               throw new IllegalArgumentException("All objects in a relation must be of the same class.");
            }
         }
      }

      if(var3 == null) {
         throw new IllegalArgumentException("Cannot create a ParseRelationOperation with no objects.");
      } else {
         this.targetClass = var3;
      }
   }

   private void addAllParseObjectsToSet(Collection<ParseObject> var1, Set<ParseObject> var2) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         this.addParseObjectToSet((ParseObject)var3.next(), var2);
      }

   }

   private void addParseObjectToSet(ParseObject var1, Set<ParseObject> var2) {
      if(Parse.getLocalDatastore() == null && var1.getObjectId() != null) {
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            ParseObject var6 = (ParseObject)var4.next();
            if(var1.getObjectId().equals(var6.getObjectId())) {
               var2.remove(var6);
            }
         }

         var2.add(var1);
      } else {
         var2.add(var1);
      }
   }

   private void removeAllParseObjectsFromSet(Collection<ParseObject> var1, Set<ParseObject> var2) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         this.removeParseObjectFromSet((ParseObject)var3.next(), var2);
      }

   }

   private void removeParseObjectFromSet(ParseObject var1, Set<ParseObject> var2) {
      if(Parse.getLocalDatastore() == null && var1.getObjectId() != null) {
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            ParseObject var5 = (ParseObject)var4.next();
            if(var1.getObjectId().equals(var5.getObjectId())) {
               var2.remove(var5);
            }
         }
      } else {
         var2.remove(var1);
      }

   }

   public Object apply(Object var1, String var2) {
      ParseRelation var3;
      if(var1 == null) {
         var3 = new ParseRelation(this.targetClass);
      } else {
         if(!(var1 instanceof ParseRelation)) {
            throw new IllegalArgumentException("Operation is invalid after previous operation.");
         }

         var3 = (ParseRelation)var1;
         if(this.targetClass != null && !this.targetClass.equals(var3.getTargetClass())) {
            throw new IllegalArgumentException("Related object object must be of class " + var3.getTargetClass() + ", but " + this.targetClass + " was passed in.");
         }
      }

      Iterator var4 = this.relationsToAdd.iterator();

      while(var4.hasNext()) {
         var3.addKnownObject((ParseObject)var4.next());
      }

      Iterator var5 = this.relationsToRemove.iterator();

      while(var5.hasNext()) {
         var3.removeKnownObject((ParseObject)var5.next());
      }

      return var3;
   }

   JSONArray convertSetToArray(Set<ParseObject> var1, ParseEncoder var2) throws JSONException {
      JSONArray var3 = new JSONArray();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         var3.put(var2.encode((ParseObject)var4.next()));
      }

      return var3;
   }

   public JSONObject encode(ParseEncoder var1) throws JSONException {
      int var2 = this.relationsToAdd.size();
      JSONObject var3 = null;
      if(var2 > 0) {
         var3 = new JSONObject();
         var3.put("__op", "AddRelation");
         var3.put("objects", this.convertSetToArray(this.relationsToAdd, var1));
      }

      int var6 = this.relationsToRemove.size();
      JSONObject var7 = null;
      if(var6 > 0) {
         var7 = new JSONObject();
         var7.put("__op", "RemoveRelation");
         var7.put("objects", this.convertSetToArray(this.relationsToRemove, var1));
      }

      if(var3 != null && var7 != null) {
         JSONObject var10 = new JSONObject();
         var10.put("__op", "Batch");
         JSONArray var12 = new JSONArray();
         var12.put(var3);
         var12.put(var7);
         var10.put("ops", var12);
         return var10;
      } else if(var3 != null) {
         return var3;
      } else if(var7 != null) {
         return var7;
      } else {
         throw new IllegalArgumentException("A ParseRelationOperation was created without any data.");
      }
   }

   String getTargetClass() {
      return this.targetClass;
   }

   public ParseFieldOperation mergeWithPrevious(ParseFieldOperation var1) {
      if(var1 == null) {
         return this;
      } else if(var1 instanceof ParseDeleteOperation) {
         throw new IllegalArgumentException("You can\'t modify a relation after deleting it.");
      } else if(var1 instanceof ParseRelationOperation) {
         ParseRelationOperation var2 = (ParseRelationOperation)var1;
         if(var2.targetClass != null && !var2.targetClass.equals(this.targetClass)) {
            throw new IllegalArgumentException("Related object object must be of class " + var2.targetClass + ", but " + this.targetClass + " was passed in.");
         } else {
            HashSet var3 = new HashSet(var2.relationsToAdd);
            HashSet var4 = new HashSet(var2.relationsToRemove);
            if(this.relationsToAdd != null) {
               this.addAllParseObjectsToSet(this.relationsToAdd, var3);
               this.removeAllParseObjectsFromSet(this.relationsToAdd, var4);
            }

            if(this.relationsToRemove != null) {
               this.removeAllParseObjectsFromSet(this.relationsToRemove, var3);
               this.addAllParseObjectsToSet(this.relationsToRemove, var4);
            }

            return new ParseRelationOperation(this.targetClass, var3, var4);
         }
      } else {
         throw new IllegalArgumentException("Operation is invalid after previous operation.");
      }
   }
}
