package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntityCreator;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
    // $FF: renamed from: BR int
    private final int field_4494;
    private final String aaM;
    private final String aaN;
    private final long aaO;
    private final Uri aaP;
    private final Uri aaQ;
    private final Uri aaR;

    MostRecentGameInfoEntity(int var1, String var2, String var3, long var4, Uri var6, Uri var7, Uri var8) {
        this.field_4494 = var1;
        this.aaM = var2;
        this.aaN = var3;
        this.aaO = var4;
        this.aaP = var6;
        this.aaQ = var7;
        this.aaR = var8;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo var1) {
        this.field_4494 = 2;
        this.aaM = var1.method_196();
        this.aaN = var1.method_197();
        this.aaO = var1.method_198();
        this.aaP = var1.method_199();
        this.aaQ = var1.method_200();
        this.aaR = var1.method_201();
    }

    // $FF: renamed from: a (com.google.android.gms.games.internal.player.MostRecentGameInfo) int
    static int method_5050(MostRecentGameInfo var0) {
        Object[] var1 = new Object[] {var0.method_196(), var0.method_197(), Long.valueOf(var0.method_198()), var0.method_199(), var0.method_200(), var0.method_201()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.internal.player.MostRecentGameInfo, java.lang.Object) boolean
    static boolean method_5051(MostRecentGameInfo var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof MostRecentGameInfo)) {
            var2 = false;
        } else if(var0 != var1) {
            MostRecentGameInfo var3 = (MostRecentGameInfo)var1;
            if(!class_1089.equal(var3.method_196(), var0.method_196()) || !class_1089.equal(var3.method_197(), var0.method_197()) || !class_1089.equal(Long.valueOf(var3.method_198()), Long.valueOf(var0.method_198())) || !class_1089.equal(var3.method_199(), var0.method_199()) || !class_1089.equal(var3.method_200(), var0.method_200()) || !class_1089.equal(var3.method_201(), var0.method_201())) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.internal.player.MostRecentGameInfo) java.lang.String
    static String method_5052(MostRecentGameInfo var0) {
        return class_1089.method_5673(var0).method_5425("GameId", var0.method_196()).method_5425("GameName", var0.method_197()).method_5425("ActivityTimestampMillis", Long.valueOf(var0.method_198())).method_5425("GameIconUri", var0.method_199()).method_5425("GameHiResUri", var0.method_200()).method_5425("GameFeaturedUri", var0.method_201()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_5051(this, var1);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_5053();
    }

    public int getVersionCode() {
        return this.field_4494;
    }

    public int hashCode() {
        return method_5050(this);
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: lp () java.lang.String
    public String method_196() {
        return this.aaM;
    }

    // $FF: renamed from: lq () java.lang.String
    public String method_197() {
        return this.aaN;
    }

    // $FF: renamed from: lr () long
    public long method_198() {
        return this.aaO;
    }

    // $FF: renamed from: ls () android.net.Uri
    public Uri method_199() {
        return this.aaP;
    }

    // $FF: renamed from: lt () android.net.Uri
    public Uri method_200() {
        return this.aaQ;
    }

    // $FF: renamed from: lu () android.net.Uri
    public Uri method_201() {
        return this.aaR;
    }

    // $FF: renamed from: lv () com.google.android.gms.games.internal.player.MostRecentGameInfo
    public MostRecentGameInfo method_5053() {
        return this;
    }

    public String toString() {
        return method_5052(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        MostRecentGameInfoEntityCreator.method_2629(this, var1, var2);
    }
}
