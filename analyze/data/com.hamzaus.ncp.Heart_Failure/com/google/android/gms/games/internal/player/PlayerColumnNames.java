package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class PlayerColumnNames {
   // $FF: renamed from: RL java.lang.String
   public final String field_3538;
   // $FF: renamed from: RM java.lang.String
   public final String field_3539;
   // $FF: renamed from: RN java.lang.String
   public final String field_3540;
   // $FF: renamed from: RO java.lang.String
   public final String field_3541;
   // $FF: renamed from: RP java.lang.String
   public final String field_3542;
   // $FF: renamed from: RQ java.lang.String
   public final String field_3543;
   // $FF: renamed from: RR java.lang.String
   public final String field_3544;
   // $FF: renamed from: RS java.lang.String
   public final String field_3545;
   // $FF: renamed from: RT java.lang.String
   public final String field_3546;
   // $FF: renamed from: RU java.lang.String
   public final String field_3547;
   // $FF: renamed from: RV java.lang.String
   public final String field_3548;
   // $FF: renamed from: RW java.lang.String
   public final String field_3549;
   // $FF: renamed from: RX java.lang.String
   public final String field_3550;
   // $FF: renamed from: RY java.lang.String
   public final String field_3551;
   // $FF: renamed from: RZ java.lang.String
   public final String field_3552;
   // $FF: renamed from: Sa java.lang.String
   public final String field_3553;
   // $FF: renamed from: Sb java.lang.String
   public final String field_3554;
   // $FF: renamed from: Sc java.lang.String
   public final String field_3555;
   // $FF: renamed from: Sd java.lang.String
   public final String field_3556;
   // $FF: renamed from: Se java.lang.String
   public final String field_3557;
   // $FF: renamed from: Sf java.lang.String
   public final String field_3558;
   // $FF: renamed from: Sg java.lang.String
   public final String field_3559;
   // $FF: renamed from: Sh java.lang.String
   public final String field_3560;
   // $FF: renamed from: Si java.lang.String
   public final String field_3561;

   public PlayerColumnNames(String var1) {
      if(TextUtils.isEmpty(var1)) {
         this.field_3538 = "external_player_id";
         this.field_3539 = "profile_name";
         this.field_3540 = "profile_icon_image_uri";
         this.field_3541 = "profile_icon_image_url";
         this.field_3542 = "profile_hi_res_image_uri";
         this.field_3543 = "profile_hi_res_image_url";
         this.field_3544 = "last_updated";
         this.field_3545 = "is_in_circles";
         this.field_3546 = "played_with_timestamp";
         this.field_3547 = "current_xp_total";
         this.field_3548 = "current_level";
         this.field_3549 = "current_level_min_xp";
         this.field_3550 = "current_level_max_xp";
         this.field_3551 = "next_level";
         this.field_3552 = "next_level_max_xp";
         this.field_3553 = "last_level_up_timestamp";
         this.field_3554 = "player_title";
         this.field_3555 = "has_all_public_acls";
         this.field_3556 = "most_recent_external_game_id";
         this.field_3557 = "most_recent_game_name";
         this.field_3558 = "most_recent_activity_timestamp";
         this.field_3559 = "most_recent_game_icon_uri";
         this.field_3560 = "most_recent_game_hi_res_uri";
         this.field_3561 = "most_recent_game_featured_uri";
      } else {
         this.field_3538 = var1 + "external_player_id";
         this.field_3539 = var1 + "profile_name";
         this.field_3540 = var1 + "profile_icon_image_uri";
         this.field_3541 = var1 + "profile_icon_image_url";
         this.field_3542 = var1 + "profile_hi_res_image_uri";
         this.field_3543 = var1 + "profile_hi_res_image_url";
         this.field_3544 = var1 + "last_updated";
         this.field_3545 = var1 + "is_in_circles";
         this.field_3546 = var1 + "played_with_timestamp";
         this.field_3547 = var1 + "current_xp_total";
         this.field_3548 = var1 + "current_level";
         this.field_3549 = var1 + "current_level_min_xp";
         this.field_3550 = var1 + "current_level_max_xp";
         this.field_3551 = var1 + "next_level";
         this.field_3552 = var1 + "next_level_max_xp";
         this.field_3553 = var1 + "last_level_up_timestamp";
         this.field_3554 = var1 + "player_title";
         this.field_3555 = var1 + "has_all_public_acls";
         this.field_3556 = var1 + "most_recent_external_game_id";
         this.field_3557 = var1 + "most_recent_game_name";
         this.field_3558 = var1 + "most_recent_activity_timestamp";
         this.field_3559 = var1 + "most_recent_game_icon_uri";
         this.field_3560 = var1 + "most_recent_game_hi_res_uri";
         this.field_3561 = var1 + "most_recent_game_featured_uri";
      }
   }
}
