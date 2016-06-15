package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_349;

public final class AchievementRef extends class_206 implements Achievement {
   AchievementRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public String getAchievementId() {
      return this.getString("external_achievement_id");
   }

   public int getCurrentSteps() {
      byte var1 = 1;
      if(this.getType() != var1) {
         var1 = 0;
      }

      class_322.method_2050((boolean)var1);
      return this.getInteger("current_steps");
   }

   public String getDescription() {
      return this.getString("description");
   }

   public void getDescription(CharArrayBuffer var1) {
      this.a("description", var1);
   }

   public String getFormattedCurrentSteps() {
      byte var1 = 1;
      if(this.getType() != var1) {
         var1 = 0;
      }

      class_322.method_2050((boolean)var1);
      return this.getString("formatted_current_steps");
   }

   public void getFormattedCurrentSteps(CharArrayBuffer var1) {
      byte var2 = 1;
      if(this.getType() != var2) {
         var2 = 0;
      }

      class_322.method_2050((boolean)var2);
      this.a("formatted_current_steps", var1);
   }

   public String getFormattedTotalSteps() {
      byte var1 = 1;
      if(this.getType() != var1) {
         var1 = 0;
      }

      class_322.method_2050((boolean)var1);
      return this.getString("formatted_total_steps");
   }

   public void getFormattedTotalSteps(CharArrayBuffer var1) {
      byte var2 = 1;
      if(this.getType() != var2) {
         var2 = 0;
      }

      class_322.method_2050((boolean)var2);
      this.a("formatted_total_steps", var1);
   }

   public long getLastUpdatedTimestamp() {
      return this.getLong("last_updated_timestamp");
   }

   public String getName() {
      return this.getString("name");
   }

   public void getName(CharArrayBuffer var1) {
      this.a("name", var1);
   }

   public Player getPlayer() {
      return new PlayerRef(this.DD, this.Ez);
   }

   public Uri getRevealedImageUri() {
      return this.aw("revealed_icon_image_uri");
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

      class_322.method_2050((boolean)var1);
      return this.getInteger("total_steps");
   }

   public int getType() {
      return this.getInteger("type");
   }

   public Uri getUnlockedImageUri() {
      return this.aw("unlocked_icon_image_uri");
   }

   public String getUnlockedImageUrl() {
      return this.getString("unlocked_icon_image_url");
   }

   public long getXpValue() {
      return this.av("instance_xp_value") && !this.ax("instance_xp_value")?this.getLong("instance_xp_value"):this.getLong("definition_xp_value");
   }

   public String toString() {
      class_349.class_1264 var1 = class_349.method_2174(this).method_4301("AchievementId", this.getAchievementId()).method_4301("Type", Integer.valueOf(this.getType())).method_4301("Name", this.getName()).method_4301("Description", this.getDescription()).method_4301("UnlockedImageUri", this.getUnlockedImageUri()).method_4301("UnlockedImageUrl", this.getUnlockedImageUrl()).method_4301("RevealedImageUri", this.getRevealedImageUri()).method_4301("RevealedImageUrl", this.getRevealedImageUrl()).method_4301("Player", this.getPlayer()).method_4301("LastUpdatedTimeStamp", Long.valueOf(this.getLastUpdatedTimestamp()));
      if(this.getType() == 1) {
         var1.method_4301("CurrentSteps", Integer.valueOf(this.getCurrentSteps()));
         var1.method_4301("TotalSteps", Integer.valueOf(this.getTotalSteps()));
      }

      return var1.toString();
   }
}
