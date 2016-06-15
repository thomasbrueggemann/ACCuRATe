package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;

public final class GameRef extends class_251 implements Game {
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
      return GameEntity.method_2413(this, var1);
   }

   public Game freeze() {
      return new GameEntity(this);
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
      return this.aR("featured_image_uri");
   }

   public String getFeaturedImageUrl() {
      return this.getString("featured_image_url");
   }

   public Uri getHiResImageUri() {
      return this.aR("game_hi_res_image_uri");
   }

   public String getHiResImageUrl() {
      return this.getString("game_hi_res_image_url");
   }

   public Uri getIconImageUri() {
      return this.aR("game_icon_image_uri");
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

   public String getThemeColor() {
      return this.getString("theme_color");
   }

   public int hashCode() {
      return GameEntity.method_2412(this);
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

   // $FF: renamed from: kA () boolean
   public boolean method_229() {
      return this.getInteger("installed") > 0;
   }

   // $FF: renamed from: kB () java.lang.String
   public String method_230() {
      return this.getString("package_name");
   }

   // $FF: renamed from: kC () int
   public int method_231() {
      return this.getInteger("gameplay_acl_status");
   }

   // $FF: renamed from: ky () boolean
   public boolean method_232() {
      return this.getBoolean("play_enabled_game");
   }

   // $FF: renamed from: kz () boolean
   public boolean method_233() {
      return this.getBoolean("identity_sharing_confirmed");
   }

   public String toString() {
      return GameEntity.method_2414(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((GameEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
