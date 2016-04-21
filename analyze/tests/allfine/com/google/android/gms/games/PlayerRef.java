package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends class_255 implements Player {
    // $FF: renamed from: VP com.google.android.gms.games.PlayerLevelInfo
    private final PlayerLevelInfo field_784;
    // $FF: renamed from: VY com.google.android.gms.games.internal.player.PlayerColumnNames
    private final PlayerColumnNames field_785;
    // $FF: renamed from: VZ com.google.android.gms.games.internal.player.MostRecentGameInfoRef
    private final MostRecentGameInfoRef field_786;

    public PlayerRef(DataHolder var1, int var2) {
        this(var1, var2, (String)null);
    }

    public PlayerRef(DataHolder var1, int var2, String var3) {
        super(var1, var2);
        this.field_785 = new PlayerColumnNames(var3);
        this.field_786 = new MostRecentGameInfoRef(var1, var2, this.field_785);
        if(this.method_1667()) {
            int var4 = this.getInteger(this.field_785.abc);
            int var5 = this.getInteger(this.field_785.abf);
            PlayerLevel var6 = new PlayerLevel(var4, this.getLong(this.field_785.abd), this.getLong(this.field_785.abe));
            PlayerLevel var7;
            if(var4 != var5) {
                var7 = new PlayerLevel(var5, this.getLong(this.field_785.abe), this.getLong(this.field_785.abg));
            } else {
                var7 = var6;
            }

            this.field_784 = new PlayerLevelInfo(this.getLong(this.field_785.abb), this.getLong(this.field_785.abh), var6, var7);
        } else {
            this.field_784 = null;
        }
    }

    // $FF: renamed from: jW () boolean
    private boolean method_1667() {
        return !this.aS(this.field_785.abb) && this.getLong(this.field_785.abb) != -1L;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return PlayerEntity.method_3233(this, var1);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public String getDisplayName() {
        return this.getString(this.field_785.aaT);
    }

    public void getDisplayName(CharArrayBuffer var1) {
        this.a(this.field_785.aaT, var1);
    }

    public Uri getHiResImageUri() {
        return this.aR(this.field_785.aaW);
    }

    public String getHiResImageUrl() {
        return this.getString(this.field_785.aaX);
    }

    public Uri getIconImageUri() {
        return this.aR(this.field_785.aaU);
    }

    public String getIconImageUrl() {
        return this.getString(this.field_785.aaV);
    }

    public long getLastPlayedWithTimestamp() {
        return this.aQ(this.field_785.aba) && !this.aS(this.field_785.aba)?this.getLong(this.field_785.aba):-1L;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.field_784;
    }

    public String getPlayerId() {
        return this.getString(this.field_785.aaS);
    }

    public long getRetrievedTimestamp() {
        return this.getLong(this.field_785.aaY);
    }

    public String getTitle() {
        return this.getString(this.field_785.abi);
    }

    public void getTitle(CharArrayBuffer var1) {
        this.a(this.field_785.abi, var1);
    }

    public boolean hasHiResImage() {
        return this.getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return this.getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.method_3234(this);
    }

    public boolean isProfileVisible() {
        return this.getBoolean(this.field_785.abk);
    }

    // $FF: renamed from: jU () int
    public int method_202() {
        return this.getInteger(this.field_785.aaZ);
    }

    // $FF: renamed from: jV () com.google.android.gms.games.internal.player.MostRecentGameInfo
    public MostRecentGameInfo method_203() {
        return this.aS(this.field_785.abl)?null:this.field_786;
    }

    public String toString() {
        return PlayerEntity.method_3237(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        ((PlayerEntity)this.freeze()).writeToParcel(var1, var2);
    }
}
