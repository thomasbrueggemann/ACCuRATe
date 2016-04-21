package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class MostRecentGameInfoRef extends class_255 implements MostRecentGameInfo {
    // $FF: renamed from: VY com.google.android.gms.games.internal.player.PlayerColumnNames
    private final PlayerColumnNames field_783;

    public MostRecentGameInfoRef(DataHolder var1, int var2, PlayerColumnNames var3) {
        super(var1, var2);
        this.field_783 = var3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return MostRecentGameInfoEntity.method_5051(this, var1);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_1653();
    }

    public int hashCode() {
        return MostRecentGameInfoEntity.method_5050(this);
    }

    // $FF: renamed from: lp () java.lang.String
    public String method_196() {
        return this.getString(this.field_783.abl);
    }

    // $FF: renamed from: lq () java.lang.String
    public String method_197() {
        return this.getString(this.field_783.abm);
    }

    // $FF: renamed from: lr () long
    public long method_198() {
        return this.getLong(this.field_783.abn);
    }

    // $FF: renamed from: ls () android.net.Uri
    public Uri method_199() {
        return this.aR(this.field_783.abo);
    }

    // $FF: renamed from: lt () android.net.Uri
    public Uri method_200() {
        return this.aR(this.field_783.abp);
    }

    // $FF: renamed from: lu () android.net.Uri
    public Uri method_201() {
        return this.aR(this.field_783.abq);
    }

    // $FF: renamed from: lv () com.google.android.gms.games.internal.player.MostRecentGameInfo
    public MostRecentGameInfo method_1653() {
        return new MostRecentGameInfoEntity(this);
    }

    public String toString() {
        return MostRecentGameInfoEntity.method_5052(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        ((MostRecentGameInfoEntity)this.method_1653()).writeToParcel(var1, var2);
    }
}
