package com.google.android.gms.games.internal.constants;

public final class LeaderboardCollection {
   // $FF: renamed from: cm (int) java.lang.String
   public static String method_3287(int var0) {
      switch(var0) {
      case 0:
         return "PUBLIC";
      case 1:
         return "SOCIAL";
      default:
         throw new IllegalArgumentException("Unknown leaderboard collection: " + var0);
      }
   }
}
