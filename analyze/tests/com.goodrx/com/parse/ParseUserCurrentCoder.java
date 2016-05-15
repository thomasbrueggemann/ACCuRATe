package com.parse;

import com.parse.ParseDecoder;
import com.parse.ParseEncoder;
import com.parse.ParseObject;
import com.parse.ParseObjectCurrentCoder;
import com.parse.ParseOperationSet;
import com.parse.ParseUser;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class ParseUserCurrentCoder extends ParseObjectCurrentCoder {
   private static final ParseUserCurrentCoder INSTANCE = new ParseUserCurrentCoder();
   private static final String KEY_AUTH_DATA = "auth_data";
   private static final String KEY_SESSION_TOKEN = "session_token";

   public static ParseUserCurrentCoder get() {
      return INSTANCE;
   }

   public <T extends ParseObject.Init<?>> T decode(T param1, JSONObject param2, ParseDecoder param3) {
      // $FF: Couldn't be decompiled
   }

   public <T extends ParseObject.State> JSONObject encode(T var1, ParseOperationSet var2, ParseEncoder var3) {
      JSONObject var4 = super.encode(var1, var2, var3);
      String var5 = ((ParseUser.State)var1).sessionToken();
      if(var5 != null) {
         try {
            var4.put("session_token", var5);
         } catch (JSONException var11) {
            throw new RuntimeException("could not encode value for key: session_token");
         }
      }

      Map var6 = ((ParseUser.State)var1).authData();
      if(var6.size() > 0) {
         try {
            var4.put("auth_data", var3.encode(var6));
         } catch (JSONException var10) {
            throw new RuntimeException("could not attach key: auth_data");
         }
      }

      return var4;
   }
}
