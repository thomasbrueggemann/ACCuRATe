package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.AchievementEntity;

public final class AchievementRef extends zzc implements Achievement {
   public int describeContents() {
      return 0;
   }

   public Achievement freeze() {
      return new AchievementEntity(this);
   }

   public String getAchievementId() {
      return this.getString("external_achievement_id");
   }

   public int getCurrentSteps() {
      byte var1 = 1;
      if(this.getType() != var1) {
         var1 = 0;
      }

      zzb.zzab((boolean)var1);
      return this.getInteger("current_steps");
   }

   public String getDescription() {
      return this.getString("description");
   }

   public String getFormattedCurrentSteps() {
      byte var1 = 1;
      if(this.getType() != var1) {
         var1 = 0;
      }

      zzb.zzab((boolean)var1);
      return this.getString("formatted_current_steps");
   }

   public String getFormattedTotalSteps() {
      byte var1 = 1;
      if(this.getType() != var1) {
         var1 = 0;
      }

      zzb.zzab((boolean)var1);
      return this.getString("formatted_total_steps");
   }

   public long getLastUpdatedTimestamp() {
      return this.getLong("last_updated_timestamp");
   }

   public String getName() {
      return this.getString("name");
   }

   public Player getPlayer() {
      return new PlayerRef(this.zzahi, this.zzaje);
   }

   public Uri getRevealedImageUri() {
      return this.zzcA("revealed_icon_image_uri");
   }

   public String getRevealedImageUrl() {
      return this.getString("revealed_icon_image_url");
   }

   public int getState() {
      return this.getInteger("state");
   }

   public int getTotalSteps() {
      byte var1 = 1;
      if(this.getType() != var1) {
         var1 = 0;
      }

      zzb.zzab((boolean)var1);
      return this.getInteger("total_steps");
   }

   public int getType() {
      return this.getInteger("type");
   }

   public Uri getUnlockedImageUri() {
      return this.zzcA("unlocked_icon_image_uri");
   }

   public String getUnlockedImageUrl() {
      return this.getString("unlocked_icon_image_url");
   }

   public long getXpValue() {
      return this.zzcz("instance_xp_value") && !this.zzcB("instance_xp_value")?this.getLong("instance_xp_value"):this.getLong("definition_xp_value");
   }

   public String toString() {
      return AchievementEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AchievementEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
