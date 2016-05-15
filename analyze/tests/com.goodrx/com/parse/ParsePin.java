package com.parse;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import java.util.List;

@ParseClassName("_Pin")
class ParsePin extends ParseObject {
   static final String KEY_NAME = "_name";
   private static final String KEY_OBJECTS = "_objects";

   public String getName() {
      return this.getString("_name");
   }

   public List<ParseObject> getObjects() {
      return this.getList("_objects");
   }

   boolean needsDefaultACL() {
      return false;
   }

   public void setName(String var1) {
      this.put("_name", var1);
   }

   public void setObjects(List<ParseObject> var1) {
      this.put("_objects", var1);
   }
}
