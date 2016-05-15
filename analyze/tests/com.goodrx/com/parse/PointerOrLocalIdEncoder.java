package com.parse;

import com.parse.ParseEncoder;
import com.parse.ParseObject;
import org.json.JSONException;
import org.json.JSONObject;

class PointerOrLocalIdEncoder extends ParseEncoder {
   private static final PointerOrLocalIdEncoder INSTANCE = new PointerOrLocalIdEncoder();

   public static PointerOrLocalIdEncoder get() {
      return INSTANCE;
   }

   public JSONObject encodeRelatedObject(ParseObject var1) {
      JSONObject var2 = new JSONObject();

      try {
         if(var1.getObjectId() != null) {
            var2.put("__type", "Pointer");
            var2.put("className", var1.getClassName());
            var2.put("objectId", var1.getObjectId());
            return var2;
         } else {
            var2.put("__type", "Pointer");
            var2.put("className", var1.getClassName());
            var2.put("localId", var1.getOrCreateLocalId());
            return var2;
         }
      } catch (JSONException var4) {
         throw new RuntimeException(var4);
      }
   }
}
