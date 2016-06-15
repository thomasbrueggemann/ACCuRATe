package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class PlayerColumnNames {
   public final String acL;
   public final String acM;
   public final String acN;
   public final String acO;
   public final String acP;
   public final String acQ;
   public final String acR;
   public final String acS;
   public final String acT;
   public final String acU;
   public final String acV;
   public final String acW;
   public final String acX;
   public final String acY;
   public final String acZ;
   public final String ada;
   public final String adb;
   public final String adc;
   public final String add;
   public final String ade;
   public final String adf;
   public final String adg;
   public final String adh;
   public final String adi;
   public final String adj;

   public PlayerColumnNames(String var1) {
      if(TextUtils.isEmpty(var1)) {
         this.acL = "external_player_id";
         this.acM = "profile_name";
         this.acN = "profile_icon_image_uri";
         this.acO = "profile_icon_image_url";
         this.acP = "profile_hi_res_image_uri";
         this.acQ = "profile_hi_res_image_url";
         this.acR = "last_updated";
         this.acS = "is_in_circles";
         this.acT = "played_with_timestamp";
         this.acU = "current_xp_total";
         this.acV = "current_level";
         this.acW = "current_level_min_xp";
         this.acX = "current_level_max_xp";
         this.acY = "next_level";
         this.acZ = "next_level_max_xp";
         this.ada = "last_level_up_timestamp";
         this.adb = "player_title";
         this.adc = "has_all_public_acls";
         this.add = "is_profile_visible";
         this.ade = "most_recent_external_game_id";
         this.adf = "most_recent_game_name";
         this.adg = "most_recent_activity_timestamp";
         this.adh = "most_recent_game_icon_uri";
         this.adi = "most_recent_game_hi_res_uri";
         this.adj = "most_recent_game_featured_uri";
      } else {
         this.acL = var1 + "external_player_id";
         this.acM = var1 + "profile_name";
         this.acN = var1 + "profile_icon_image_uri";
         this.acO = var1 + "profile_icon_image_url";
         this.acP = var1 + "profile_hi_res_image_uri";
         this.acQ = var1 + "profile_hi_res_image_url";
         this.acR = var1 + "last_updated";
         this.acS = var1 + "is_in_circles";
         this.acT = var1 + "played_with_timestamp";
         this.acU = var1 + "current_xp_total";
         this.acV = var1 + "current_level";
         this.acW = var1 + "current_level_min_xp";
         this.acX = var1 + "current_level_max_xp";
         this.acY = var1 + "next_level";
         this.acZ = var1 + "next_level_max_xp";
         this.ada = var1 + "last_level_up_timestamp";
         this.adb = var1 + "player_title";
         this.adc = var1 + "has_all_public_acls";
         this.add = var1 + "is_profile_visible";
         this.ade = var1 + "most_recent_external_game_id";
         this.adf = var1 + "most_recent_game_name";
         this.adg = var1 + "most_recent_activity_timestamp";
         this.adh = var1 + "most_recent_game_icon_uri";
         this.adi = var1 + "most_recent_game_hi_res_uri";
         this.adj = var1 + "most_recent_game_featured_uri";
      }
   }
}
