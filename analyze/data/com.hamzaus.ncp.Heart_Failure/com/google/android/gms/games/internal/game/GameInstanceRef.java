package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.games.internal.game.GameInstance;
import com.google.android.gms.internal.class_349;

public final class GameInstanceRef extends class_206 implements GameInstance {
   GameInstanceRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public String getApplicationId() {
      return this.getString("external_game_id");
   }

   public String getDisplayName() {
      return this.getString("instance_display_name");
   }

   public String getPackageName() {
      return this.getString("package_name");
   }

   // $FF: renamed from: hY () boolean
   public boolean method_1355() {
      return this.getInteger("real_time_support") > 0;
   }

   // $FF: renamed from: hZ () boolean
   public boolean method_1356() {
      return this.getInteger("turn_based_support") > 0;
   }

   // $FF: renamed from: ia () int
   public int method_1357() {
      return this.getInteger("platform_type");
   }

   // $FF: renamed from: ib () boolean
   public boolean method_1358() {
      return this.getInteger("piracy_check") > 0;
   }

   // $FF: renamed from: ic () boolean
   public boolean method_1359() {
      return this.getInteger("installed") > 0;
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("ApplicationId", this.getApplicationId()).method_4301("DisplayName", this.getDisplayName()).method_4301("SupportsRealTime", Boolean.valueOf(this.method_1355())).method_4301("SupportsTurnBased", Boolean.valueOf(this.method_1356())).method_4301("PlatformType", PlatformType.method_4548(this.method_1357())).method_4301("PackageName", this.getPackageName()).method_4301("PiracyCheckEnabled", Boolean.valueOf(this.method_1358())).method_4301("Installed", Boolean.valueOf(this.method_1359())).toString();
   }
}
