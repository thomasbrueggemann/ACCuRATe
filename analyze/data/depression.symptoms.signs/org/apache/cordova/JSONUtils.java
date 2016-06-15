package org.apache.cordova;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

@Deprecated
public class JSONUtils {
   public static List<String> toStringList(JSONArray var0) throws JSONException {
      ArrayList var1;
      if(var0 == null) {
         var1 = null;
      } else {
         var1 = new ArrayList();

         for(int var2 = 0; var2 < var0.length(); ++var2) {
            var1.add(var0.get(var2).toString());
         }
      }

      return var1;
   }
}
