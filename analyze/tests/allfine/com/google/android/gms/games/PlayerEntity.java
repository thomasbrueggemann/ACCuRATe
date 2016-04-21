package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1097;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntityCreator;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.class_345;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Creator<PlayerEntity> CREATOR = new PlayerEntity.PlayerEntityCreatorCompat();
    // $FF: renamed from: BR int
    private final int field_2796;
    // $FF: renamed from: NH java.lang.String
    private final String field_2797;
    // $FF: renamed from: Nw java.lang.String
    private final String field_2798;
    // $FF: renamed from: VK java.lang.String
    private final String field_2799;
    // $FF: renamed from: VL long
    private final long field_2800;
    // $FF: renamed from: VM int
    private final int field_2801;
    // $FF: renamed from: VN long
    private final long field_2802;
    // $FF: renamed from: VO com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
    private final MostRecentGameInfoEntity field_2803;
    // $FF: renamed from: VP com.google.android.gms.games.PlayerLevelInfo
    private final PlayerLevelInfo field_2804;
    // $FF: renamed from: VQ boolean
    private final boolean field_2805;
    // $FF: renamed from: Vh android.net.Uri
    private final Uri field_2806;
    // $FF: renamed from: Vi android.net.Uri
    private final Uri field_2807;
    // $FF: renamed from: Vs java.lang.String
    private final String field_2808;
    // $FF: renamed from: Vt java.lang.String
    private final String field_2809;

    PlayerEntity(int var1, String var2, String var3, Uri var4, Uri var5, long var6, int var8, long var9, String var11, String var12, String var13, MostRecentGameInfoEntity var14, PlayerLevelInfo var15, boolean var16) {
        this.field_2796 = var1;
        this.field_2799 = var2;
        this.field_2797 = var3;
        this.field_2806 = var4;
        this.field_2808 = var11;
        this.field_2807 = var5;
        this.field_2809 = var12;
        this.field_2800 = var6;
        this.field_2801 = var8;
        this.field_2802 = var9;
        this.field_2798 = var13;
        this.field_2805 = var16;
        this.field_2803 = var14;
        this.field_2804 = var15;
    }

    public PlayerEntity(Player var1) {
        this.field_2796 = 11;
        this.field_2799 = var1.getPlayerId();
        this.field_2797 = var1.getDisplayName();
        this.field_2806 = var1.getIconImageUri();
        this.field_2808 = var1.getIconImageUrl();
        this.field_2807 = var1.getHiResImageUri();
        this.field_2809 = var1.getHiResImageUrl();
        this.field_2800 = var1.getRetrievedTimestamp();
        this.field_2801 = var1.method_202();
        this.field_2802 = var1.getLastPlayedWithTimestamp();
        this.field_2798 = var1.getTitle();
        this.field_2805 = var1.isProfileVisible();
        MostRecentGameInfo var2 = var1.method_203();
        MostRecentGameInfoEntity var3;
        if(var2 == null) {
            var3 = null;
        } else {
            var3 = new MostRecentGameInfoEntity(var2);
        }

        this.field_2803 = var3;
        this.field_2804 = var1.getLevelInfo();
        class_1097.method_5714(this.field_2799);
        class_1097.method_5714(this.field_2797);
        boolean var4;
        if(this.field_2800 > 0L) {
            var4 = true;
        } else {
            var4 = false;
        }

        class_1097.method_5710(var4);
    }

    // $FF: renamed from: a (com.google.android.gms.games.Player, java.lang.Object) boolean
    static boolean method_3233(Player var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof Player)) {
            var2 = false;
        } else if(var0 != var1) {
            Player var3 = (Player)var1;
            if(!class_1089.equal(var3.getPlayerId(), var0.getPlayerId()) || !class_1089.equal(var3.getDisplayName(), var0.getDisplayName()) || !class_1089.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_1089.equal(var3.getHiResImageUri(), var0.getHiResImageUri()) || !class_1089.equal(Long.valueOf(var3.getRetrievedTimestamp()), Long.valueOf(var0.getRetrievedTimestamp())) || !class_1089.equal(var3.getTitle(), var0.getTitle()) || !class_1089.equal(var3.getLevelInfo(), var0.getLevelInfo())) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.Player) int
    static int method_3234(Player var0) {
        Object[] var1 = new Object[] {var0.getPlayerId(), var0.getDisplayName(), var0.getIconImageUri(), var0.getHiResImageUri(), Long.valueOf(var0.getRetrievedTimestamp()), var0.getTitle(), var0.getLevelInfo()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: c (com.google.android.gms.games.Player) java.lang.String
    static String method_3237(Player var0) {
        return class_1089.method_5673(var0).method_5425("PlayerId", var0.getPlayerId()).method_5425("DisplayName", var0.getDisplayName()).method_5425("IconImageUri", var0.getIconImageUri()).method_5425("IconImageUrl", var0.getIconImageUrl()).method_5425("HiResImageUri", var0.getHiResImageUri()).method_5425("HiResImageUrl", var0.getHiResImageUrl()).method_5425("RetrievedTimestamp", Long.valueOf(var0.getRetrievedTimestamp())).method_5425("Title", var0.getTitle()).method_5425("LevelInfo", var0.getLevelInfo()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_3233(this, var1);
    }

    public Player freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.field_2797;
    }

    public void getDisplayName(CharArrayBuffer var1) {
        class_345.method_2325(this.field_2797, var1);
    }

    public Uri getHiResImageUri() {
        return this.field_2807;
    }

    public String getHiResImageUrl() {
        return this.field_2809;
    }

    public Uri getIconImageUri() {
        return this.field_2806;
    }

    public String getIconImageUrl() {
        return this.field_2808;
    }

    public long getLastPlayedWithTimestamp() {
        return this.field_2802;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.field_2804;
    }

    public String getPlayerId() {
        return this.field_2799;
    }

    public long getRetrievedTimestamp() {
        return this.field_2800;
    }

    public String getTitle() {
        return this.field_2798;
    }

    public void getTitle(CharArrayBuffer var1) {
        class_345.method_2325(this.field_2798, var1);
    }

    public int getVersionCode() {
        return this.field_2796;
    }

    public boolean hasHiResImage() {
        return this.getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return this.getIconImageUri() != null;
    }

    public int hashCode() {
        return method_3234(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isProfileVisible() {
        return this.field_2805;
    }

    // $FF: renamed from: jU () int
    public int method_202() {
        return this.field_2801;
    }

    // $FF: renamed from: jV () com.google.android.gms.games.internal.player.MostRecentGameInfo
    public MostRecentGameInfo method_203() {
        return this.field_2803;
    }

    public String toString() {
        return method_3237(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(!this.gQ()) {
            PlayerEntityCreator.method_3888(this, var1, var2);
        } else {
            var1.writeString(this.field_2799);
            var1.writeString(this.field_2797);
            String var3;
            if(this.field_2806 == null) {
                var3 = null;
            } else {
                var3 = this.field_2806.toString();
            }

            var1.writeString(var3);
            Uri var4 = this.field_2807;
            String var5 = null;
            if(var4 != null) {
                var5 = this.field_2807.toString();
            }

            var1.writeString(var5);
            var1.writeLong(this.field_2800);
        }
    }

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        // $FF: renamed from: ce (android.os.Parcel) com.google.android.gms.games.PlayerEntity
        public PlayerEntity method_3889(Parcel var1) {
            if(!PlayerEntity.c(PlayerEntity.gP()) && !PlayerEntity.aV(PlayerEntity.class.getCanonicalName())) {
                String var2 = var1.readString();
                String var3 = var1.readString();
                String var4 = var1.readString();
                String var5 = var1.readString();
                Uri var6;
                if(var4 == null) {
                    var6 = null;
                } else {
                    var6 = Uri.parse(var4);
                }

                Uri var7;
                if(var5 == null) {
                    var7 = null;
                } else {
                    var7 = Uri.parse(var5);
                }

                return new PlayerEntity(11, var2, var3, var6, var7, var1.readLong(), -1, -1L, (String)null, (String)null, (String)null, (MostRecentGameInfoEntity)null, (PlayerLevelInfo)null, true);
            } else {
                return super.method_3889(var1);
            }
        }

        // $FF: synthetic method
        public Object createFromParcel(Parcel var1) {
            return this.method_3889(var1);
        }
    }
}
