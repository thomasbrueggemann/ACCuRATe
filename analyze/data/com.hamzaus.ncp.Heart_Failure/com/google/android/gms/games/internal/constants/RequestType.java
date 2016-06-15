package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;

public final class RequestType {
   // $FF: renamed from: cm (int) java.lang.String
   public static String method_4063(int var0) {
      switch(var0) {
      case 1:
         return "GIFT";
      case 2:
         return "WISH";
      default:
         GamesLog.method_4574("RequestType", "Unknown request type: " + var0);
         return "UNKNOWN_TYPE";
      }
   }
}
