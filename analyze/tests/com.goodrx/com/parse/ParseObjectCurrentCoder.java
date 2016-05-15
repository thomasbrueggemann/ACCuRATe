package com.parse;

import com.parse.ParseDecoder;
import com.parse.ParseEncoder;
import com.parse.ParseObject;
import com.parse.ParseObjectCoder;
import com.parse.ParseOperationSet;
import org.json.JSONObject;

class ParseObjectCurrentCoder extends ParseObjectCoder {
   private static final ParseObjectCurrentCoder INSTANCE = new ParseObjectCurrentCoder();
   private static final String KEY_CLASS_NAME = "classname";
   private static final String KEY_CREATED_AT = "createdAt";
   private static final String KEY_DATA = "data";
   private static final String KEY_OBJECT_ID = "objectId";
   private static final String KEY_OLD_CREATED_AT = "created_at";
   private static final String KEY_OLD_OBJECT_ID = "id";
   private static final String KEY_OLD_POINTERS = "pointers";
   private static final String KEY_OLD_UPDATED_AT = "updated_at";
   private static final String KEY_UPDATED_AT = "updatedAt";

   public static ParseObjectCurrentCoder get() {
      return INSTANCE;
   }

   public <T extends ParseObject.Init<?>> T decode(T param1, JSONObject param2, ParseDecoder param3) {
      // $FF: Couldn't be decompiled
   }

   public <T extends ParseObject.State> JSONObject encode(T param1, ParseOperationSet param2, ParseEncoder param3) {
      // $FF: Couldn't be decompiled
   }
}
