package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;

public final class GameRef extends zzc implements Game {
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
      return GameEntity.zza(this, var1);
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

   public String getDeveloperName() {
      return this.getString("developer_name");
   }

   public String getDisplayName() {
      return this.getString("display_name");
   }

   public Uri getFeaturedImageUri() {
      return this.zzcA("featured_image_uri");
   }

   public String getFeaturedImageUrl() {
      return this.getString("featured_image_url");
   }

   public Uri getHiResImageUri() {
      return this.zzcA("game_hi_res_image_uri");
   }

   public String getHiResImageUrl() {
      return this.getString("game_hi_res_image_url");
   }

   public Uri getIconImageUri() {
      return this.zzcA("game_icon_image_uri");
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

   public boolean hasGamepadSupport() {
      return this.getInteger("gamepad_support") > 0;
   }

   public int hashCode() {
      return GameEntity.zza(this);
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
      return GameEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((GameEntity)this.freeze()).writeToParcel(var1, var2);
   }

   public String zzvA() {
      return this.getString("package_name");
   }

   public int zzvB() {
      return this.getInteger("gameplay_acl_status");
   }

   public boolean zzvx() {
      return this.getBoolean("play_enabled_game");
   }

   public boolean zzvy() {
      return this.getBoolean("identity_sharing_confirmed");
   }

   public boolean zzvz() {
      return this.getInteger("installed") > 0;
   }
}
