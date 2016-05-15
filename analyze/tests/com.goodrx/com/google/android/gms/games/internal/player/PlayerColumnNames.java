package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class PlayerColumnNames {
   public final String name;
   public final String title;
   public final String zzaIA;
   public final String zzaIB;
   public final String zzaIC;
   public final String zzaID;
   public final String zzaIE;
   public final String zzaIF;
   public final String zzaIG;
   public final String zzaIH;
   public final String zzaII;
   public final String zzaIJ;
   public final String zzaIK;
   public final String zzaIL;
   public final String zzaIM;
   public final String zzaIN;
   public final String zzaIO;
   public final String zzaIP;
   public final String zzaIQ;
   public final String zzaIR;
   public final String zzaIS;
   public final String zzaIT;
   public final String zzaIU;
   public final String zzaIV;
   public final String zzaIs;
   public final String zzaIt;
   public final String zzaIu;
   public final String zzaIv;
   public final String zzaIw;
   public final String zzaIx;
   public final String zzaIy;
   public final String zzaIz;

   public PlayerColumnNames(String var1) {
      if(TextUtils.isEmpty(var1)) {
         this.zzaIs = "external_player_id";
         this.zzaIt = "profile_name";
         this.zzaIu = "profile_icon_image_uri";
         this.zzaIv = "profile_icon_image_url";
         this.zzaIw = "profile_hi_res_image_uri";
         this.zzaIx = "profile_hi_res_image_url";
         this.zzaIy = "last_updated";
         this.zzaIz = "is_in_circles";
         this.zzaIA = "played_with_timestamp";
         this.zzaIB = "current_xp_total";
         this.zzaIC = "current_level";
         this.zzaID = "current_level_min_xp";
         this.zzaIE = "current_level_max_xp";
         this.zzaIF = "next_level";
         this.zzaIG = "next_level_max_xp";
         this.zzaIH = "last_level_up_timestamp";
         this.title = "player_title";
         this.zzaII = "has_all_public_acls";
         this.zzaIJ = "is_profile_visible";
         this.zzaIK = "most_recent_external_game_id";
         this.zzaIL = "most_recent_game_name";
         this.zzaIM = "most_recent_activity_timestamp";
         this.zzaIN = "most_recent_game_icon_uri";
         this.zzaIO = "most_recent_game_hi_res_uri";
         this.zzaIP = "most_recent_game_featured_uri";
         this.zzaIQ = "has_debug_access";
         this.zzaIR = "gamer_tag";
         this.name = "real_name";
         this.zzaIS = "banner_image_landscape_uri";
         this.zzaIT = "banner_image_landscape_url";
         this.zzaIU = "banner_image_portrait_uri";
         this.zzaIV = "banner_image_portrait_url";
      } else {
         this.zzaIs = var1 + "external_player_id";
         this.zzaIt = var1 + "profile_name";
         this.zzaIu = var1 + "profile_icon_image_uri";
         this.zzaIv = var1 + "profile_icon_image_url";
         this.zzaIw = var1 + "profile_hi_res_image_uri";
         this.zzaIx = var1 + "profile_hi_res_image_url";
         this.zzaIy = var1 + "last_updated";
         this.zzaIz = var1 + "is_in_circles";
         this.zzaIA = var1 + "played_with_timestamp";
         this.zzaIB = var1 + "current_xp_total";
         this.zzaIC = var1 + "current_level";
         this.zzaID = var1 + "current_level_min_xp";
         this.zzaIE = var1 + "current_level_max_xp";
         this.zzaIF = var1 + "next_level";
         this.zzaIG = var1 + "next_level_max_xp";
         this.zzaIH = var1 + "last_level_up_timestamp";
         this.title = var1 + "player_title";
         this.zzaII = var1 + "has_all_public_acls";
         this.zzaIJ = var1 + "is_profile_visible";
         this.zzaIK = var1 + "most_recent_external_game_id";
         this.zzaIL = var1 + "most_recent_game_name";
         this.zzaIM = var1 + "most_recent_activity_timestamp";
         this.zzaIN = var1 + "most_recent_game_icon_uri";
         this.zzaIO = var1 + "most_recent_game_hi_res_uri";
         this.zzaIP = var1 + "most_recent_game_featured_uri";
         this.zzaIQ = var1 + "has_debug_access";
         this.zzaIR = var1 + "gamer_tag";
         this.name = var1 + "real_name";
         this.zzaIS = var1 + "banner_image_landscape_uri";
         this.zzaIT = var1 + "banner_image_landscape_url";
         this.zzaIU = var1 + "banner_image_portrait_uri";
         this.zzaIV = var1 + "banner_image_portrait_url";
      }
   }
}
