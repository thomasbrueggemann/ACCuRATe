package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.games.leaderboard.LeaderboardVariantEntity;

public final class LeaderboardVariantRef extends class_206 implements LeaderboardVariant {
   LeaderboardVariantRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public boolean equals(Object var1) {
      return LeaderboardVariantEntity.method_4066(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1379();
   }

   public int getCollection() {
      return this.getInteger("collection");
   }

   public String getDisplayPlayerRank() {
      return this.getString("player_display_rank");
   }

   public String getDisplayPlayerScore() {
      return this.getString("player_display_score");
   }

   public long getNumScores() {
      return this.ax("total_scores")?-1L:this.getLong("total_scores");
   }

   public long getPlayerRank() {
      return this.ax("player_rank")?-1L:this.getLong("player_rank");
   }

   public String getPlayerScoreTag() {
      return this.getString("player_score_tag");
   }

   public long getRawPlayerScore() {
      return this.ax("player_raw_score")?-1L:this.getLong("player_raw_score");
   }

   public int getTimeSpan() {
      return this.getInteger("timespan");
   }

   public boolean hasPlayerInfo() {
      return !this.ax("player_raw_score");
   }

   public int hashCode() {
      return LeaderboardVariantEntity.method_4065(this);
   }

   // $FF: renamed from: iA () java.lang.String
   public String method_229() {
      return this.getString("window_page_token_next");
   }

   // $FF: renamed from: iB () com.google.android.gms.games.leaderboard.LeaderboardVariant
   public LeaderboardVariant method_1379() {
      return new LeaderboardVariantEntity(this);
   }

   // $FF: renamed from: iy () java.lang.String
   public String method_230() {
      return this.getString("top_page_token_next");
   }

   // $FF: renamed from: iz () java.lang.String
   public String method_231() {
      return this.getString("window_page_token_prev");
   }

   public String toString() {
      return LeaderboardVariantEntity.method_4067(this);
   }
}
