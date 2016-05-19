package com.goodrx.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.goodrx.model.Key;
import com.goodrx.utils.tracker.Trackers;

public class AccountInfoUtils {
   private static final String EMAIL = "email";
   private static final String TOKEN = "token";
   private static final String TOKEN_ID = "token_id";

   public static String getEmail(Context var0) {
      return var0.getSharedPreferences("goodrx", 0).getString("email", (String)null);
   }

   public static Key getKey(Context var0) {
      if(var0 == null) {
         return new Key((String)null, (String)null);
      } else {
         SharedPreferences var1 = var0.getSharedPreferences("goodrx", 0);
         return var1 == null?new Key((String)null, (String)null):new Key(var1.getString("token", (String)null), var1.getString("token_id", (String)null));
      }
   }

   public static void save(Context var0, String var1, String var2, String var3) {
      Editor var4 = var0.getSharedPreferences("goodrx", 0).edit();
      var4.putString("token", var1);
      var4.putString("token_id", var2);
      var4.putString("email", var3);
      var4.apply();
      Trackers.setParseInstallationData(var0, true, true, true);
   }
}
