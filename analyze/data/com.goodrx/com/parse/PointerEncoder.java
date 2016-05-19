package com.parse;

import com.parse.ParseObject;
import com.parse.PointerOrLocalIdEncoder;
import org.json.JSONObject;

class PointerEncoder extends PointerOrLocalIdEncoder {
   private static final PointerEncoder INSTANCE = new PointerEncoder();

   public static PointerEncoder get() {
      return INSTANCE;
   }

   public JSONObject encodeRelatedObject(ParseObject var1) {
      if(var1.getObjectId() == null) {
         throw new IllegalStateException("unable to encode an association with an unsaved ParseObject");
      } else {
         return super.encodeRelatedObject(var1);
      }
   }
}
