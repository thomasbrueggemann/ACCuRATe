package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import java.util.HashMap;

public final class ScoreSubmissionData {
   private static final String[] adl = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
   // $FF: renamed from: Iv int
   private int field_1520;
   // $FF: renamed from: Xh java.lang.String
   private String field_1521;
   private HashMap<Integer, ScoreSubmissionData.Result> adR;
   private String adn;

   public ScoreSubmissionData(DataHolder var1) {
      this.field_1520 = var1.getStatusCode();
      this.adR = new HashMap();
      int var2 = var1.getCount();
      boolean var3;
      if(var2 == 3) {
         var3 = true;
      } else {
         var3 = false;
      }

      class_335.method_2301(var3);

      for(int var4 = 0; var4 < var2; ++var4) {
         int var5 = var1.method_5829(var4);
         if(var4 == 0) {
            this.adn = var1.method_5831("leaderboardId", var4, var5);
            this.field_1521 = var1.method_5831("playerId", var4, var5);
         }

         if(var1.method_5832("hasResult", var4, var5)) {
            this.method_2919(new ScoreSubmissionData.Result(var1.method_5826("rawScore", var4, var5), var1.method_5831("formattedScore", var4, var5), var1.method_5831("scoreTag", var4, var5), var1.method_5832("newBest", var4, var5)), var1.method_5830("timeSpan", var4, var5));
         }
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.ScoreSubmissionData$Result, int) void
   private void method_2919(ScoreSubmissionData.Result var1, int var2) {
      this.adR.put(Integer.valueOf(var2), var1);
   }

   public String getLeaderboardId() {
      return this.adn;
   }

   public String getPlayerId() {
      return this.field_1521;
   }

   public ScoreSubmissionData.Result getScoreResult(int var1) {
      return (ScoreSubmissionData.Result)this.adR.get(Integer.valueOf(var1));
   }

   public String toString() {
      class_336.class_1339 var1 = class_336.method_2312(this).method_3424("PlayerId", this.field_1521).method_3424("StatusCode", Integer.valueOf(this.field_1520));

      for(int var2 = 0; var2 < 3; ++var2) {
         ScoreSubmissionData.Result var3 = (ScoreSubmissionData.Result)this.adR.get(Integer.valueOf(var2));
         var1.method_3424("TimesSpan", TimeSpan.method_5689(var2));
         String var5;
         if(var3 == null) {
            var5 = "null";
         } else {
            var5 = var3.toString();
         }

         var1.method_3424("Result", var5);
      }

      return var1.toString();
   }

   public static final class Result {
      public final String formattedScore;
      public final boolean newBest;
      public final long rawScore;
      public final String scoreTag;

      public Result(long var1, String var3, String var4, boolean var5) {
         this.rawScore = var1;
         this.formattedScore = var3;
         this.scoreTag = var4;
         this.newBest = var5;
      }

      public String toString() {
         return class_336.method_2312(this).method_3424("RawScore", Long.valueOf(this.rawScore)).method_3424("FormattedScore", this.formattedScore).method_3424("ScoreTag", this.scoreTag).method_3424("NewBest", Boolean.valueOf(this.newBest)).toString();
      }
   }
}
