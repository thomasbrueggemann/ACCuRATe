package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntityCreator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.class_345;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Creator<GameEntity> CREATOR = new GameEntity.GameEntityCreatorCompat();
    // $FF: renamed from: BR int
    private final int field_2810;
    // $FF: renamed from: Ez java.lang.String
    private final String field_2811;
    // $FF: renamed from: NH java.lang.String
    private final String field_2812;
    // $FF: renamed from: Tr java.lang.String
    private final String field_2813;
    // $FF: renamed from: Ve java.lang.String
    private final String field_2814;
    // $FF: renamed from: Vf java.lang.String
    private final String field_2815;
    // $FF: renamed from: Vg java.lang.String
    private final String field_2816;
    // $FF: renamed from: Vh android.net.Uri
    private final Uri field_2817;
    // $FF: renamed from: Vi android.net.Uri
    private final Uri field_2818;
    // $FF: renamed from: Vj android.net.Uri
    private final Uri field_2819;
    // $FF: renamed from: Vk boolean
    private final boolean field_2820;
    // $FF: renamed from: Vl boolean
    private final boolean field_2821;
    // $FF: renamed from: Vm java.lang.String
    private final String field_2822;
    // $FF: renamed from: Vn int
    private final int field_2823;
    // $FF: renamed from: Vo int
    private final int field_2824;
    // $FF: renamed from: Vp int
    private final int field_2825;
    // $FF: renamed from: Vq boolean
    private final boolean field_2826;
    // $FF: renamed from: Vr boolean
    private final boolean field_2827;
    // $FF: renamed from: Vs java.lang.String
    private final String field_2828;
    // $FF: renamed from: Vt java.lang.String
    private final String field_2829;
    // $FF: renamed from: Vu java.lang.String
    private final String field_2830;
    // $FF: renamed from: Vv boolean
    private final boolean field_2831;
    // $FF: renamed from: Vw boolean
    private final boolean field_2832;
    // $FF: renamed from: Vx boolean
    private final boolean field_2833;
    // $FF: renamed from: Vy java.lang.String
    private final String field_2834;

    GameEntity(int var1, String var2, String var3, String var4, String var5, String var6, String var7, Uri var8, Uri var9, Uri var10, boolean var11, boolean var12, String var13, int var14, int var15, int var16, boolean var17, boolean var18, String var19, String var20, String var21, boolean var22, boolean var23, boolean var24, String var25) {
        this.field_2810 = var1;
        this.field_2811 = var2;
        this.field_2812 = var3;
        this.field_2814 = var4;
        this.field_2815 = var5;
        this.field_2813 = var6;
        this.field_2816 = var7;
        this.field_2817 = var8;
        this.field_2828 = var19;
        this.field_2818 = var9;
        this.field_2829 = var20;
        this.field_2819 = var10;
        this.field_2830 = var21;
        this.field_2820 = var11;
        this.field_2821 = var12;
        this.field_2822 = var13;
        this.field_2823 = var14;
        this.field_2824 = var15;
        this.field_2825 = var16;
        this.field_2826 = var17;
        this.field_2827 = var18;
        this.field_2831 = var22;
        this.field_2832 = var23;
        this.field_2833 = var24;
        this.field_2834 = var25;
    }

    public GameEntity(Game var1) {
        this.field_2810 = 5;
        this.field_2811 = var1.getApplicationId();
        this.field_2814 = var1.getPrimaryCategory();
        this.field_2815 = var1.getSecondaryCategory();
        this.field_2813 = var1.getDescription();
        this.field_2816 = var1.getDeveloperName();
        this.field_2812 = var1.getDisplayName();
        this.field_2817 = var1.getIconImageUri();
        this.field_2828 = var1.getIconImageUrl();
        this.field_2818 = var1.getHiResImageUri();
        this.field_2829 = var1.getHiResImageUrl();
        this.field_2819 = var1.getFeaturedImageUri();
        this.field_2830 = var1.getFeaturedImageUrl();
        this.field_2820 = var1.method_191();
        this.field_2821 = var1.method_193();
        this.field_2822 = var1.method_194();
        this.field_2823 = var1.method_195();
        this.field_2824 = var1.getAchievementTotalCount();
        this.field_2825 = var1.getLeaderboardCount();
        this.field_2826 = var1.isRealTimeMultiplayerEnabled();
        this.field_2827 = var1.isTurnBasedMultiplayerEnabled();
        this.field_2831 = var1.isMuted();
        this.field_2832 = var1.method_192();
        this.field_2833 = var1.areSnapshotsEnabled();
        this.field_2834 = var1.getThemeColor();
    }

    // $FF: renamed from: a (com.google.android.gms.games.Game) int
    static int method_3239(Game var0) {
        Object[] var1 = new Object[] {var0.getApplicationId(), var0.getDisplayName(), var0.getPrimaryCategory(), var0.getSecondaryCategory(), var0.getDescription(), var0.getDeveloperName(), var0.getIconImageUri(), var0.getHiResImageUri(), var0.getFeaturedImageUri(), Boolean.valueOf(var0.method_191()), Boolean.valueOf(var0.method_193()), var0.method_194(), Integer.valueOf(var0.method_195()), Integer.valueOf(var0.getAchievementTotalCount()), Integer.valueOf(var0.getLeaderboardCount()), Boolean.valueOf(var0.isRealTimeMultiplayerEnabled()), Boolean.valueOf(var0.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(var0.isMuted()), Boolean.valueOf(var0.method_192()), Boolean.valueOf(var0.areSnapshotsEnabled()), var0.getThemeColor()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.Game, java.lang.Object) boolean
    static boolean method_3240(Game var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof Game)) {
            var2 = false;
        } else if(var0 != var1) {
            Game var3 = (Game)var1;
            if(class_1089.equal(var3.getApplicationId(), var0.getApplicationId()) && class_1089.equal(var3.getDisplayName(), var0.getDisplayName()) && class_1089.equal(var3.getPrimaryCategory(), var0.getPrimaryCategory()) && class_1089.equal(var3.getSecondaryCategory(), var0.getSecondaryCategory()) && class_1089.equal(var3.getDescription(), var0.getDescription()) && class_1089.equal(var3.getDeveloperName(), var0.getDeveloperName()) && class_1089.equal(var3.getIconImageUri(), var0.getIconImageUri()) && class_1089.equal(var3.getHiResImageUri(), var0.getHiResImageUri()) && class_1089.equal(var3.getFeaturedImageUri(), var0.getFeaturedImageUri()) && class_1089.equal(Boolean.valueOf(var3.method_191()), Boolean.valueOf(var0.method_191())) && class_1089.equal(Boolean.valueOf(var3.method_193()), Boolean.valueOf(var0.method_193())) && class_1089.equal(var3.method_194(), var0.method_194()) && class_1089.equal(Integer.valueOf(var3.method_195()), Integer.valueOf(var0.method_195())) && class_1089.equal(Integer.valueOf(var3.getAchievementTotalCount()), Integer.valueOf(var0.getAchievementTotalCount())) && class_1089.equal(Integer.valueOf(var3.getLeaderboardCount()), Integer.valueOf(var0.getLeaderboardCount())) && class_1089.equal(Boolean.valueOf(var3.isRealTimeMultiplayerEnabled()), Boolean.valueOf(var0.isRealTimeMultiplayerEnabled()))) {
                Boolean var4 = Boolean.valueOf(var3.isTurnBasedMultiplayerEnabled());
                boolean var5;
                if(var0.isTurnBasedMultiplayerEnabled() && class_1089.equal(Boolean.valueOf(var3.isMuted()), Boolean.valueOf(var0.isMuted())) && class_1089.equal(Boolean.valueOf(var3.method_192()), Boolean.valueOf(var0.method_192()))) {
                    var5 = var2;
                } else {
                    var5 = false;
                }

                if(class_1089.equal(var4, Boolean.valueOf(var5)) && class_1089.equal(Boolean.valueOf(var3.areSnapshotsEnabled()), Boolean.valueOf(var0.areSnapshotsEnabled())) && class_1089.equal(var3.getThemeColor(), var0.getThemeColor())) {
                    return var2;
                }
            }

            return false;
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.Game) java.lang.String
    static String method_3241(Game var0) {
        return class_1089.method_5673(var0).method_5425("ApplicationId", var0.getApplicationId()).method_5425("DisplayName", var0.getDisplayName()).method_5425("PrimaryCategory", var0.getPrimaryCategory()).method_5425("SecondaryCategory", var0.getSecondaryCategory()).method_5425("Description", var0.getDescription()).method_5425("DeveloperName", var0.getDeveloperName()).method_5425("IconImageUri", var0.getIconImageUri()).method_5425("IconImageUrl", var0.getIconImageUrl()).method_5425("HiResImageUri", var0.getHiResImageUri()).method_5425("HiResImageUrl", var0.getHiResImageUrl()).method_5425("FeaturedImageUri", var0.getFeaturedImageUri()).method_5425("FeaturedImageUrl", var0.getFeaturedImageUrl()).method_5425("PlayEnabledGame", Boolean.valueOf(var0.method_191())).method_5425("InstanceInstalled", Boolean.valueOf(var0.method_193())).method_5425("InstancePackageName", var0.method_194()).method_5425("AchievementTotalCount", Integer.valueOf(var0.getAchievementTotalCount())).method_5425("LeaderboardCount", Integer.valueOf(var0.getLeaderboardCount())).method_5425("RealTimeMultiplayerEnabled", Boolean.valueOf(var0.isRealTimeMultiplayerEnabled())).method_5425("TurnBasedMultiplayerEnabled", Boolean.valueOf(var0.isTurnBasedMultiplayerEnabled())).method_5425("AreSnapshotsEnabled", Boolean.valueOf(var0.areSnapshotsEnabled())).method_5425("ThemeColor", var0.getThemeColor()).toString();
    }

    public boolean areSnapshotsEnabled() {
        return this.field_2833;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_3240(this, var1);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.field_2824;
    }

    public String getApplicationId() {
        return this.field_2811;
    }

    public String getDescription() {
        return this.field_2813;
    }

    public void getDescription(CharArrayBuffer var1) {
        class_345.method_2325(this.field_2813, var1);
    }

    public String getDeveloperName() {
        return this.field_2816;
    }

    public void getDeveloperName(CharArrayBuffer var1) {
        class_345.method_2325(this.field_2816, var1);
    }

    public String getDisplayName() {
        return this.field_2812;
    }

    public void getDisplayName(CharArrayBuffer var1) {
        class_345.method_2325(this.field_2812, var1);
    }

    public Uri getFeaturedImageUri() {
        return this.field_2819;
    }

    public String getFeaturedImageUrl() {
        return this.field_2830;
    }

    public Uri getHiResImageUri() {
        return this.field_2818;
    }

    public String getHiResImageUrl() {
        return this.field_2829;
    }

    public Uri getIconImageUri() {
        return this.field_2817;
    }

    public String getIconImageUrl() {
        return this.field_2828;
    }

    public int getLeaderboardCount() {
        return this.field_2825;
    }

    public String getPrimaryCategory() {
        return this.field_2814;
    }

    public String getSecondaryCategory() {
        return this.field_2815;
    }

    public String getThemeColor() {
        return this.field_2834;
    }

    public int getVersionCode() {
        return this.field_2810;
    }

    public int hashCode() {
        return method_3239(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isMuted() {
        return this.field_2831;
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return this.field_2826;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return this.field_2827;
    }

    // $FF: renamed from: jO () boolean
    public boolean method_191() {
        return this.field_2820;
    }

    // $FF: renamed from: jP () boolean
    public boolean method_192() {
        return this.field_2832;
    }

    // $FF: renamed from: jQ () boolean
    public boolean method_193() {
        return this.field_2821;
    }

    // $FF: renamed from: jR () java.lang.String
    public String method_194() {
        return this.field_2822;
    }

    // $FF: renamed from: jS () int
    public int method_195() {
        return this.field_2823;
    }

    public String toString() {
        return method_3241(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        byte var3 = 1;
        if(!this.gQ()) {
            GameEntityCreator.method_3076(this, var1, var2);
        } else {
            var1.writeString(this.field_2811);
            var1.writeString(this.field_2812);
            var1.writeString(this.field_2814);
            var1.writeString(this.field_2815);
            var1.writeString(this.field_2813);
            var1.writeString(this.field_2816);
            String var4;
            if(this.field_2817 == null) {
                var4 = null;
            } else {
                var4 = this.field_2817.toString();
            }

            var1.writeString(var4);
            String var5;
            if(this.field_2818 == null) {
                var5 = null;
            } else {
                var5 = this.field_2818.toString();
            }

            var1.writeString(var5);
            Uri var6 = this.field_2819;
            String var7 = null;
            if(var6 != null) {
                var7 = this.field_2819.toString();
            }

            var1.writeString(var7);
            byte var8;
            if(this.field_2820) {
                var8 = var3;
            } else {
                var8 = 0;
            }

            var1.writeInt(var8);
            if(!this.field_2821) {
                var3 = 0;
            }

            var1.writeInt(var3);
            var1.writeString(this.field_2822);
            var1.writeInt(this.field_2823);
            var1.writeInt(this.field_2824);
            var1.writeInt(this.field_2825);
        }
    }

    static final class GameEntityCreatorCompat extends GameEntityCreator {
        // $FF: renamed from: cd (android.os.Parcel) com.google.android.gms.games.GameEntity
        public GameEntity method_3077(Parcel var1) {
            if(!GameEntity.c(GameEntity.gP()) && !GameEntity.aV(GameEntity.class.getCanonicalName())) {
                String var2 = var1.readString();
                String var3 = var1.readString();
                String var4 = var1.readString();
                String var5 = var1.readString();
                String var6 = var1.readString();
                String var7 = var1.readString();
                String var8 = var1.readString();
                Uri var9;
                if(var8 == null) {
                    var9 = null;
                } else {
                    var9 = Uri.parse(var8);
                }

                String var10 = var1.readString();
                Uri var11;
                if(var10 == null) {
                    var11 = null;
                } else {
                    var11 = Uri.parse(var10);
                }

                String var12 = var1.readString();
                Uri var13;
                if(var12 == null) {
                    var13 = null;
                } else {
                    var13 = Uri.parse(var12);
                }

                boolean var14;
                if(var1.readInt() > 0) {
                    var14 = true;
                } else {
                    var14 = false;
                }

                boolean var15;
                if(var1.readInt() > 0) {
                    var15 = true;
                } else {
                    var15 = false;
                }

                return new GameEntity(5, var2, var3, var4, var5, var6, var7, var9, var11, var13, var14, var15, var1.readString(), var1.readInt(), var1.readInt(), var1.readInt(), false, false, (String)null, (String)null, (String)null, false, false, false, (String)null);
            } else {
                return super.method_3077(var1);
            }
        }

        // $FF: synthetic method
        public Object createFromParcel(Parcel var1) {
            return this.method_3077(var1);
        }
    }
}
