package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.PlayerLevelCreator;

public final class PlayerLevel implements SafeParcelable {
    public static final PlayerLevelCreator CREATOR = new PlayerLevelCreator();
    // $FF: renamed from: BR int
    private final int field_5063;
    // $FF: renamed from: VR int
    private final int field_5064;
    // $FF: renamed from: VS long
    private final long field_5065;
    // $FF: renamed from: VT long
    private final long field_5066;

    PlayerLevel(int var1, int var2, long var3, long var5) {
        boolean var7 = true;
        super();
        boolean var8;
        if(var3 >= 0L) {
            var8 = var7;
        } else {
            var8 = false;
        }

        class_1090.method_5676(var8, "Min XP must be positive!");
        if(var5 <= var3) {
            var7 = false;
        }

        class_1090.method_5676(var7, "Max XP must be more than min XP!");
        this.field_5063 = var1;
        this.field_5064 = var2;
        this.field_5065 = var3;
        this.field_5066 = var5;
    }

    public PlayerLevel(int var1, long var2, long var4) {
        this(1, var1, var2, var4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof PlayerLevel)) {
            var2 = false;
        } else if(this != var1) {
            PlayerLevel var3 = (PlayerLevel)var1;
            if(!class_1089.equal(Integer.valueOf(var3.getLevelNumber()), Integer.valueOf(this.getLevelNumber())) || !class_1089.equal(Long.valueOf(var3.getMinXp()), Long.valueOf(this.getMinXp())) || !class_1089.equal(Long.valueOf(var3.getMaxXp()), Long.valueOf(this.getMaxXp()))) {
                return false;
            }
        }

        return var2;
    }

    public int getLevelNumber() {
        return this.field_5064;
    }

    public long getMaxXp() {
        return this.field_5066;
    }

    public long getMinXp() {
        return this.field_5065;
    }

    public int getVersionCode() {
        return this.field_5063;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.field_5064), Long.valueOf(this.field_5065), Long.valueOf(this.field_5066)};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("LevelNumber", Integer.valueOf(this.getLevelNumber())).method_5425("MinXp", Long.valueOf(this.getMinXp())).method_5425("MaxXp", Long.valueOf(this.getMaxXp())).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        PlayerLevelCreator.method_4408(this, var1, var2);
    }
}
