package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;

public final class LeaderboardScoreRef extends class_206 implements LeaderboardScore {
   // $FF: renamed from: SD com.google.android.gms.games.PlayerRef
   private final PlayerRef field_681;

   LeaderboardScoreRef(DataHolder var1, int var2) {
      super(var1, var2);
      this.field_681 = new PlayerRef(var1, var2);
   }

   public boolean equals(Object var1) {
      return LeaderboardScoreEntity.method_4169(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1353();
   }

   public String getDisplayRank() {
      return this.getString("display_rank");
   }

   public void getDisplayRank(CharArrayBuffer var1) {
      this.a("display_rank", var1);
   }

   public String getDisplayScore() {
      return this.getString("display_score");
   }

   public void getDisplayScore(CharArrayBuffer var1) {
      this.a("display_score", var1);
   }

   public long getRank() {
      return this.getLong("rank");
   }

   public long getRawScore() {
      return this.getLong("raw_score");
   }

   public Player getScoreHolder() {
      return this.ax("external_player_id")?null:this.field_681;
   }

   public String getScoreHolderDisplayName() {
      return this.ax("external_player_id")?this.getString("default_display_name"):this.field_681.getDisplayName();
   }

   public void getScoreHolderDisplayName(CharArrayBuffer var1) {
      if(this.ax("external_player_id")) {
         this.a("default_display_name", var1);
      } else {
         this.field_681.getDisplayName(var1);
      }
   }

   public Uri getScoreHolderHiResImageUri() {
      return this.ax("external_player_id")?null:this.field_681.getHiResImageUri();
   }

   public String getScoreHolderHiResImageUrl() {
      return this.ax("external_player_id")?null:this.field_681.getHiResImageUrl();
   }

   public Uri getScoreHolderIconImageUri() {
      return this.ax("external_player_id")?this.aw("default_display_image_uri"):this.field_681.getIconImageUri();
   }

   public String getScoreHolderIconImageUrl() {
      return this.ax("external_player_id")?this.getString("default_display_image_url"):this.field_681.getIconImageUrl();
   }

   public String getScoreTag() {
      return this.getString("score_tag");
   }

   public long getTimestampMillis() {
      return this.getLong("achieved_timestamp");
   }

   public int hashCode() {
      return LeaderboardScoreEntity.method_4168(this);
   }

   // $FF: renamed from: ix () com.google.android.gms.games.leaderboard.LeaderboardScore
   public LeaderboardScore method_1353() {
      return new LeaderboardScoreEntity(this);
   }

   public String toString() {
      return LeaderboardScoreEntity.method_4170(this);
   }
}
