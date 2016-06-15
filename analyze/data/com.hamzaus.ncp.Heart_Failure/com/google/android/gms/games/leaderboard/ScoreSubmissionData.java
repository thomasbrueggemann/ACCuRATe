package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_349;
import java.util.HashMap;

public final class ScoreSubmissionData {
   // $FF: renamed from: Sk java.lang.String[]
   private static final String[] field_1832 = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
   // $FF: renamed from: CQ int
   private int field_1833;
   // $FF: renamed from: MP java.lang.String
   private String field_1834;
   // $FF: renamed from: SQ java.util.HashMap
   private HashMap<Integer, ScoreSubmissionData.Result> field_1835;
   // $FF: renamed from: Sm java.lang.String
   private String field_1836;

   public ScoreSubmissionData(DataHolder var1) {
      this.field_1833 = var1.getStatusCode();
      this.field_1835 = new HashMap();
      int var2 = var1.getCount();
      boolean var3;
      if(var2 == 3) {
         var3 = true;
      } else {
         var3 = false;
      }

      class_347.method_2160(var3);

      for(int var4 = 0; var4 < var2; ++var4) {
         int var5 = var1.method_4556(var4);
         if(var4 == 0) {
            this.field_1836 = var1.method_4560("leaderboardId", var4, var5);
            this.field_1834 = var1.method_4560("playerId", var4, var5);
         }

         if(var1.method_4561("hasResult", var4, var5)) {
            this.method_2543(new ScoreSubmissionData.Result(var1.method_4554("rawScore", var4, var5), var1.method_4560("formattedScore", var4, var5), var1.method_4560("scoreTag", var4, var5), var1.method_4561("newBest", var4, var5)), var1.method_4558("timeSpan", var4, var5));
         }
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.leaderboard.ScoreSubmissionData$Result, int) void
   private void method_2543(ScoreSubmissionData.Result var1, int var2) {
      this.field_1835.put(Integer.valueOf(var2), var1);
   }

   public String getLeaderboardId() {
      return this.field_1836;
   }

   public String getPlayerId() {
      return this.field_1834;
   }

   public ScoreSubmissionData.Result getScoreResult(int var1) {
      return (ScoreSubmissionData.Result)this.field_1835.get(Integer.valueOf(var1));
   }

   public String toString() {
      class_349.class_1264 var1 = class_349.method_2174(this).method_4301("PlayerId", this.field_1834).method_4301("StatusCode", Integer.valueOf(this.field_1833));

      for(int var2 = 0; var2 < 3; ++var2) {
         ScoreSubmissionData.Result var3 = (ScoreSubmissionData.Result)this.field_1835.get(Integer.valueOf(var2));
         var1.method_4301("TimesSpan", TimeSpan.method_4462(var2));
         String var5;
         if(var3 == null) {
            var5 = "null";
         } else {
            var5 = var3.toString();
         }

         var1.method_4301("Result", var5);
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
         return class_349.method_2174(this).method_4301("RawScore", Long.valueOf(this.rawScore)).method_4301("FormattedScore", this.formattedScore).method_4301("ScoreTag", this.scoreTag).method_4301("NewBest", Boolean.valueOf(this.newBest)).toString();
      }
   }
}
