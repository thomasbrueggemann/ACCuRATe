package com.parse;

import com.parse.ParseEncoder;
import com.parse.ParseObject;
import org.json.JSONObject;

class NoObjectsEncoder extends ParseEncoder {
   private static final NoObjectsEncoder INSTANCE = new NoObjectsEncoder();

   public static NoObjectsEncoder get() {
      return INSTANCE;
   }

   public JSONObject encodeRelatedObject(ParseObject var1) {
      throw new IllegalArgumentException("ParseObjects not allowed here");
   }
}
