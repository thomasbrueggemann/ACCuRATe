package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfoCreator;

public final class PlayerLevelInfo implements SafeParcelable {
    public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
    // $FF: renamed from: BR int
    private final int field_2920;
    // $FF: renamed from: VU long
    private final long field_2921;
    // $FF: renamed from: VV long
    private final long field_2922;
    // $FF: renamed from: VW com.google.android.gms.games.PlayerLevel
    private final PlayerLevel field_2923;
    // $FF: renamed from: VX com.google.android.gms.games.PlayerLevel
    private final PlayerLevel field_2924;

    PlayerLevelInfo(int var1, long var2, long var4, PlayerLevel var6, PlayerLevel var7) {
        boolean var8;
        if(var2 != -1L) {
            var8 = true;
        } else {
            var8 = false;
        }

        class_1090.method_5674(var8);
        class_1090.method_5685(var6);
        class_1090.method_5685(var7);
        this.field_2920 = var1;
        this.field_2921 = var2;
        this.field_2922 = var4;
        this.field_2923 = var6;
        this.field_2924 = var7;
    }

    public PlayerLevelInfo(long var1, long var3, PlayerLevel var5, PlayerLevel var6) {
        this(1, var1, var3, var5, var6);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof PlayerLevelInfo)) {
            var2 = false;
        } else if(var1 != this) {
            PlayerLevelInfo var3 = (PlayerLevelInfo)var1;
            if(!class_1089.equal(Long.valueOf(this.field_2921), Long.valueOf(var3.field_2921)) || !class_1089.equal(Long.valueOf(this.field_2922), Long.valueOf(var3.field_2922)) || !class_1089.equal(this.field_2923, var3.field_2923) || !class_1089.equal(this.field_2924, var3.field_2924)) {
                return false;
            }
        }

        return var2;
    }

    public PlayerLevel getCurrentLevel() {
        return this.field_2923;
    }

    public long getCurrentXpTotal() {
        return this.field_2921;
    }

    public long getLastLevelUpTimestamp() {
        return this.field_2922;
    }

    public PlayerLevel getNextLevel() {
        return this.field_2924;
    }

    public int getVersionCode() {
        return this.field_2920;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Long.valueOf(this.field_2921), Long.valueOf(this.field_2922), this.field_2923, this.field_2924};
        return class_1089.hashCode(var1);
    }

    public boolean isMaxLevel() {
        return this.field_2923.equals(this.field_2924);
    }

    public void writeToParcel(Parcel var1, int var2) {
        PlayerLevelInfoCreator.method_4762(this, var1, var2);
    }
}
