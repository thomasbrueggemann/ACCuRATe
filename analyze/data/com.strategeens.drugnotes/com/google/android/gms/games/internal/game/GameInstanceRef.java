package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.games.internal.game.GameInstance;
import com.google.android.gms.internal.class_336;

public final class GameInstanceRef extends class_251 implements GameInstance {
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

   // $FF: renamed from: jC () int
   public int method_1662() {
      return this.getInteger("platform_type");
   }

   // $FF: renamed from: ml () boolean
   public boolean method_1663() {
      return this.getInteger("real_time_support") > 0;
   }

   // $FF: renamed from: mm () boolean
   public boolean method_1664() {
      return this.getInteger("turn_based_support") > 0;
   }

   // $FF: renamed from: mn () boolean
   public boolean method_1665() {
      return this.getInteger("piracy_check") > 0;
   }

   // $FF: renamed from: mo () boolean
   public boolean method_1666() {
      return this.getInteger("installed") > 0;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("ApplicationId", this.getApplicationId()).method_3424("DisplayName", this.getDisplayName()).method_3424("SupportsRealTime", Boolean.valueOf(this.method_1663())).method_3424("SupportsTurnBased", Boolean.valueOf(this.method_1664())).method_3424("PlatformType", PlatformType.method_5821(this.method_1662())).method_3424("PackageName", this.getPackageName()).method_3424("PiracyCheckEnabled", Boolean.valueOf(this.method_1665())).method_3424("Installed", Boolean.valueOf(this.method_1666())).toString();
   }
}
