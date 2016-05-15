package com.parse;

import com.parse.ParseDecoder;
import com.parse.ParseEncoder;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseRelation<T extends ParseObject> {
   private String key;
   private Set<ParseObject> knownObjects = new HashSet();
   private final Object mutex = new Object();
   private WeakReference<ParseObject> parent;
   private String parentClassName;
   private String parentObjectId;
   private String targetClass;

   ParseRelation(ParseObject var1, String var2) {
      this.parent = new WeakReference(var1);
      this.parentObjectId = var1.getObjectId();
      this.parentClassName = var1.getClassName();
      this.key = var2;
      this.targetClass = null;
   }

   ParseRelation(String var1) {
      this.parent = null;
      this.parentObjectId = null;
      this.parentClassName = null;
      this.key = null;
      this.targetClass = var1;
   }

   ParseRelation(JSONObject var1, ParseDecoder var2) {
      this.parent = null;
      this.parentObjectId = null;
      this.parentClassName = null;
      this.key = null;
      this.targetClass = var1.optString("className", (String)null);
      JSONArray var3 = var1.optJSONArray("objects");
      if(var3 != null) {
         for(int var4 = 0; var4 < var3.length(); ++var4) {
            this.knownObjects.add((ParseObject)var2.decode(var3.optJSONObject(var4)));
         }
      }

   }

   public void add(T param1) {
      // $FF: Couldn't be decompiled
   }

   void addKnownObject(ParseObject param1) {
      // $FF: Couldn't be decompiled
   }

   JSONObject encodeToJSON(ParseEncoder param1) throws JSONException {
      // $FF: Couldn't be decompiled
   }

   void ensureParentAndKey(ParseObject param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   String getKey() {
      return this.key;
   }

   Set<ParseObject> getKnownObjects() {
      return this.knownObjects;
   }

   ParseObject getParent() {
      return this.parent == null?null:(this.parent.get() == null?ParseObject.createWithoutData(this.parentClassName, this.parentObjectId):(ParseObject)this.parent.get());
   }

   public ParseQuery<T> getQuery() {
      // $FF: Couldn't be decompiled
   }

   String getTargetClass() {
      // $FF: Couldn't be decompiled
   }

   boolean hasKnownObject(ParseObject param1) {
      // $FF: Couldn't be decompiled
   }

   public void remove(T param1) {
      // $FF: Couldn't be decompiled
   }

   void removeKnownObject(ParseObject param1) {
      // $FF: Couldn't be decompiled
   }

   void setTargetClass(String param1) {
      // $FF: Couldn't be decompiled
   }
}
