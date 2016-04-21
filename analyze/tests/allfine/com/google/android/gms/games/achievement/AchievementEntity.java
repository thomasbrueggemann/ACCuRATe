package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1097;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.AchievementEntityCreator;
import com.google.android.gms.internal.class_345;

public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final AchievementEntityCreator CREATOR = new AchievementEntityCreator();
    // $FF: renamed from: BR int
    private final int field_4064;
    // $FF: renamed from: FD int
    private final int field_4065;
    // $FF: renamed from: Tr java.lang.String
    private final String field_4066;
    // $FF: renamed from: Wa java.lang.String
    private final String field_4067;
    // $FF: renamed from: Wb android.net.Uri
    private final Uri field_4068;
    // $FF: renamed from: Wc java.lang.String
    private final String field_4069;
    // $FF: renamed from: Wd android.net.Uri
    private final Uri field_4070;
    // $FF: renamed from: We java.lang.String
    private final String field_4071;
    // $FF: renamed from: Wf int
    private final int field_4072;
    // $FF: renamed from: Wg java.lang.String
    private final String field_4073;
    // $FF: renamed from: Wh com.google.android.gms.games.PlayerEntity
    private final PlayerEntity field_4074;
    // $FF: renamed from: Wi int
    private final int field_4075;
    // $FF: renamed from: Wj java.lang.String
    private final String field_4076;
    // $FF: renamed from: Wk long
    private final long field_4077;
    // $FF: renamed from: Wl long
    private final long field_4078;
    private final String mName;
    private final int mState;

    AchievementEntity(int var1, String var2, int var3, String var4, String var5, Uri var6, String var7, Uri var8, String var9, int var10, String var11, PlayerEntity var12, int var13, int var14, String var15, long var16, long var18) {
        this.field_4064 = var1;
        this.field_4067 = var2;
        this.field_4065 = var3;
        this.mName = var4;
        this.field_4066 = var5;
        this.field_4068 = var6;
        this.field_4069 = var7;
        this.field_4070 = var8;
        this.field_4071 = var9;
        this.field_4072 = var10;
        this.field_4073 = var11;
        this.field_4074 = var12;
        this.mState = var13;
        this.field_4075 = var14;
        this.field_4076 = var15;
        this.field_4077 = var16;
        this.field_4078 = var18;
    }

    public AchievementEntity(Achievement var1) {
        this.field_4064 = 1;
        this.field_4067 = var1.getAchievementId();
        this.field_4065 = var1.getType();
        this.mName = var1.getName();
        this.field_4066 = var1.getDescription();
        this.field_4068 = var1.getUnlockedImageUri();
        this.field_4069 = var1.getUnlockedImageUrl();
        this.field_4070 = var1.getRevealedImageUri();
        this.field_4071 = var1.getRevealedImageUrl();
        this.field_4074 = (PlayerEntity)var1.getPlayer().freeze();
        this.mState = var1.getState();
        this.field_4077 = var1.getLastUpdatedTimestamp();
        this.field_4078 = var1.getXpValue();
        if(var1.getType() == 1) {
            this.field_4072 = var1.getTotalSteps();
            this.field_4073 = var1.getFormattedTotalSteps();
            this.field_4075 = var1.getCurrentSteps();
            this.field_4076 = var1.getFormattedCurrentSteps();
        } else {
            this.field_4072 = 0;
            this.field_4073 = null;
            this.field_4075 = 0;
            this.field_4076 = null;
        }

        class_1097.method_5714(this.field_4067);
        class_1097.method_5714(this.field_4066);
    }

    // $FF: renamed from: a (com.google.android.gms.games.achievement.Achievement) int
    static int method_4410(Achievement var0) {
        int var1;
        int var2;
        if(var0.getType() == 1) {
            var2 = var0.getCurrentSteps();
            var1 = var0.getTotalSteps();
        } else {
            var1 = 0;
            var2 = 0;
        }

        Object[] var3 = new Object[] {var0.getAchievementId(), var0.getName(), Integer.valueOf(var0.getType()), var0.getDescription(), Long.valueOf(var0.getXpValue()), Integer.valueOf(var0.getState()), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.getPlayer(), Integer.valueOf(var2), Integer.valueOf(var1)};
        return class_1089.hashCode(var3);
    }

    // $FF: renamed from: a (com.google.android.gms.games.achievement.Achievement, java.lang.Object) boolean
    static boolean method_4411(Achievement var0, Object var1) {
        byte var2 = 1;
        if(!(var1 instanceof Achievement)) {
            var2 = 0;
        } else if(var0 != var1) {
            Achievement var3 = (Achievement)var1;
            byte var4;
            byte var5;
            if(var0.getType() == var2) {
                var5 = class_1089.equal(Integer.valueOf(var3.getCurrentSteps()), Integer.valueOf(var0.getCurrentSteps()));
                var4 = class_1089.equal(Integer.valueOf(var3.getTotalSteps()), Integer.valueOf(var0.getTotalSteps()));
            } else {
                var4 = var2;
                var5 = var2;
            }

            if(!class_1089.equal(var3.getAchievementId(), var0.getAchievementId()) || !class_1089.equal(var3.getName(), var0.getName()) || !class_1089.equal(Integer.valueOf(var3.getType()), Integer.valueOf(var0.getType())) || !class_1089.equal(var3.getDescription(), var0.getDescription()) || !class_1089.equal(Long.valueOf(var3.getXpValue()), Long.valueOf(var0.getXpValue())) || !class_1089.equal(Integer.valueOf(var3.getState()), Integer.valueOf(var0.getState())) || !class_1089.equal(Long.valueOf(var3.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) || !class_1089.equal(var3.getPlayer(), var0.getPlayer()) || var5 == 0 || var4 == 0) {
                return false;
            }
        }

        return (boolean)var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.achievement.Achievement) java.lang.String
    static String method_4412(Achievement var0) {
        class_1089.class_1785 var1 = class_1089.method_5673(var0).method_5425("Id", var0.getAchievementId()).method_5425("Type", Integer.valueOf(var0.getType())).method_5425("Name", var0.getName()).method_5425("Description", var0.getDescription()).method_5425("Player", var0.getPlayer()).method_5425("State", Integer.valueOf(var0.getState()));
        if(var0.getType() == 1) {
            var1.method_5425("CurrentSteps", Integer.valueOf(var0.getCurrentSteps()));
            var1.method_5425("TotalSteps", Integer.valueOf(var0.getTotalSteps()));
        }

        return var1.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_4411(this, var1);
    }

    public Achievement freeze() {
        return this;
    }

    public String getAchievementId() {
        return this.field_4067;
    }

    public int getCurrentSteps() {
        return this.field_4075;
    }

    public String getDescription() {
        return this.field_4066;
    }

    public void getDescription(CharArrayBuffer var1) {
        class_345.method_2325(this.field_4066, var1);
    }

    public String getFormattedCurrentSteps() {
        return this.field_4076;
    }

    public void getFormattedCurrentSteps(CharArrayBuffer var1) {
        class_345.method_2325(this.field_4076, var1);
    }

    public String getFormattedTotalSteps() {
        return this.field_4073;
    }

    public void getFormattedTotalSteps(CharArrayBuffer var1) {
        class_345.method_2325(this.field_4073, var1);
    }

    public long getLastUpdatedTimestamp() {
        return this.field_4077;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer var1) {
        class_345.method_2325(this.mName, var1);
    }

    public Player getPlayer() {
        return this.field_4074;
    }

    public Uri getRevealedImageUri() {
        return this.field_4070;
    }

    public String getRevealedImageUrl() {
        return this.field_4071;
    }

    public int getState() {
        return this.mState;
    }

    public int getTotalSteps() {
        return this.field_4072;
    }

    public int getType() {
        return this.field_4065;
    }

    public Uri getUnlockedImageUri() {
        return this.field_4068;
    }

    public String getUnlockedImageUrl() {
        return this.field_4069;
    }

    public int getVersionCode() {
        return this.field_4064;
    }

    public long getXpValue() {
        return this.field_4078;
    }

    public int hashCode() {
        return method_4410(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return method_4412(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        AchievementEntityCreator.method_3125(this, var1, var2);
    }
}
