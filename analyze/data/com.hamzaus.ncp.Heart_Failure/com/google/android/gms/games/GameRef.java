package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;

public final class GameRef extends class_206 implements Game {
   public GameRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public boolean areSnapshotsEnabled() {
      return this.getInteger("snapshots_enabled") > 0;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return GameEntity.method_2225(this, var1);
   }

   public Game freeze() {
      return new GameEntity(this);
   }

   // $FF: renamed from: gH () boolean
   public boolean method_215() {
      return this.getBoolean("play_enabled_game");
   }

   // $FF: renamed from: gI () boolean
   public boolean method_216() {
      return this.getBoolean("identity_sharing_confirmed");
   }

   // $FF: renamed from: gJ () boolean
   public boolean method_217() {
      return this.getInteger("installed") > 0;
   }

   // $FF: renamed from: gK () java.lang.String
   public String method_218() {
      return this.getString("package_name");
   }

   // $FF: renamed from: gL () int
   public int method_219() {
      return this.getInteger("gameplay_acl_status");
   }

   public int getAchievementTotalCount() {
      return this.getInteger("achievement_total_count");
   }

   public String getApplicationId() {
      return this.getString("external_game_id");
   }

   public String getDescription() {
      return this.getString("game_description");
   }

   public void getDescription(CharArrayBuffer var1) {
      this.a("game_description", var1);
   }

   public String getDeveloperName() {
      return this.getString("developer_name");
   }

   public void getDeveloperName(CharArrayBuffer var1) {
      this.a("developer_name", var1);
   }

   public String getDisplayName() {
      return this.getString("display_name");
   }

   public void getDisplayName(CharArrayBuffer var1) {
      this.a("display_name", var1);
   }

   public Uri getFeaturedImageUri() {
      return this.aw("featured_image_uri");
   }

   public String getFeaturedImageUrl() {
      return this.getString("featured_image_url");
   }

   public Uri getHiResImageUri() {
      return this.aw("game_hi_res_image_uri");
   }

   public String getHiResImageUrl() {
      return this.getString("game_hi_res_image_url");
   }

   public Uri getIconImageUri() {
      return this.aw("game_icon_image_uri");
   }

   public String getIconImageUrl() {
      return this.getString("game_icon_image_url");
   }

   public int getLeaderboardCount() {
      return this.getInteger("leaderboard_count");
   }

   public String getPrimaryCategory() {
      return this.getString("primary_category");
   }

   public String getSecondaryCategory() {
      return this.getString("secondary_category");
   }

   public int hashCode() {
      return GameEntity.method_2224(this);
   }

   public boolean isMuted() {
      return this.getBoolean("muted");
   }

   public boolean isRealTimeMultiplayerEnabled() {
      return this.getInteger("real_time_support") > 0;
   }

   public boolean isTurnBasedMultiplayerEnabled() {
      return this.getInteger("turn_based_support") > 0;
   }

   public String toString() {
      return GameEntity.method_2227(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((GameEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
