package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.games.internal.game.GameInstance;

public final class GameInstanceRef extends class_255 implements GameInstance {
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

    // $FF: renamed from: iR () int
    public int method_1654() {
        return this.getInteger("platform_type");
    }

    // $FF: renamed from: le () boolean
    public boolean method_1655() {
        return this.getInteger("real_time_support") > 0;
    }

    // $FF: renamed from: lf () boolean
    public boolean method_1656() {
        return this.getInteger("turn_based_support") > 0;
    }

    // $FF: renamed from: lg () boolean
    public boolean method_1657() {
        return this.getInteger("piracy_check") > 0;
    }

    // $FF: renamed from: lh () boolean
    public boolean method_1658() {
        return this.getInteger("installed") > 0;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("ApplicationId", this.getApplicationId()).method_5425("DisplayName", this.getDisplayName()).method_5425("SupportsRealTime", Boolean.valueOf(this.method_1655())).method_5425("SupportsTurnBased", Boolean.valueOf(this.method_1656())).method_5425("PlatformType", PlatformType.method_5978(this.method_1654())).method_5425("PackageName", this.getPackageName()).method_5425("PiracyCheckEnabled", Boolean.valueOf(this.method_1657())).method_5425("Installed", Boolean.valueOf(this.method_1658())).toString();
    }
}
