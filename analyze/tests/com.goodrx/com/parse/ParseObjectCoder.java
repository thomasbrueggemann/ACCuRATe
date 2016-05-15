package com.parse;

import com.parse.ParseDecoder;
import com.parse.ParseEncoder;
import com.parse.ParseObject;
import com.parse.ParseOperationSet;
import org.json.JSONObject;

class ParseObjectCoder {
   private static final ParseObjectCoder INSTANCE = new ParseObjectCoder();
   private static final String KEY_ACL = "ACL";
   private static final String KEY_CLASS_NAME = "className";
   private static final String KEY_CREATED_AT = "createdAt";
   private static final String KEY_OBJECT_ID = "objectId";
   private static final String KEY_UPDATED_AT = "updatedAt";

   public static ParseObjectCoder get() {
      return INSTANCE;
   }

   public <T extends ParseObject.Init<?>> T decode(T param1, JSONObject param2, ParseDecoder param3) {
      // $FF: Couldn't be decompiled
   }

   public <T extends ParseObject.State> JSONObject encode(T param1, ParseOperationSet param2, ParseEncoder param3) {
      // $FF: Couldn't be decompiled
   }
}
