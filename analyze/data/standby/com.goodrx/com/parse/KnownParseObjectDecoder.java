package com.parse;

import com.parse.ParseDecoder;
import com.parse.ParseObject;
import java.util.Map;

class KnownParseObjectDecoder extends ParseDecoder {
   private Map<String, ParseObject> fetchedObjects;

   public KnownParseObjectDecoder(Map<String, ParseObject> var1) {
      this.fetchedObjects = var1;
   }

   protected ParseObject decodePointer(String var1, String var2) {
      return this.fetchedObjects != null && this.fetchedObjects.containsKey(var2)?(ParseObject)this.fetchedObjects.get(var2):super.decodePointer(var1, var2);
   }
}
