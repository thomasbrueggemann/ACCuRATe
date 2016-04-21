package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntityCreator;
import com.google.android.gms.internal.class_345;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
    public static final SnapshotMetadataEntityCreator CREATOR = new SnapshotMetadataEntityCreator();
    // $FF: renamed from: BR int
    private final int field_4704;
    // $FF: renamed from: Nw java.lang.String
    private final String field_4705;
    // $FF: renamed from: Tr java.lang.String
    private final String field_4706;
    // $FF: renamed from: WI java.lang.String
    private final String field_4707;
    private final GameEntity aay;
    private final Uri adk;
    private final PlayerEntity ado;
    private final String adp;
    private final long adq;
    private final long adr;
    private final float ads;
    private final String adt;

    SnapshotMetadataEntity(int var1, GameEntity var2, PlayerEntity var3, String var4, Uri var5, String var6, String var7, String var8, long var9, long var11, float var13, String var14) {
        this.field_4704 = var1;
        this.aay = var2;
        this.ado = var3;
        this.field_4707 = var4;
        this.adk = var5;
        this.adp = var6;
        this.ads = var13;
        this.field_4705 = var7;
        this.field_4706 = var8;
        this.adq = var9;
        this.adr = var11;
        this.adt = var14;
    }

    public SnapshotMetadataEntity(SnapshotMetadata var1) {
        this.field_4704 = 3;
        this.aay = new GameEntity(var1.getGame());
        this.ado = new PlayerEntity(var1.getOwner());
        this.field_4707 = var1.getSnapshotId();
        this.adk = var1.getCoverImageUri();
        this.adp = var1.getCoverImageUrl();
        this.ads = var1.getCoverImageAspectRatio();
        this.field_4705 = var1.getTitle();
        this.field_4706 = var1.getDescription();
        this.adq = var1.getLastModifiedTimestamp();
        this.adr = var1.getPlayedTime();
        this.adt = var1.getUniqueName();
    }

    // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotMetadata) int
    static int method_5321(SnapshotMetadata var0) {
        Object[] var1 = new Object[] {var0.getGame(), var0.getOwner(), var0.getSnapshotId(), var0.getCoverImageUri(), Float.valueOf(var0.getCoverImageAspectRatio()), var0.getTitle(), var0.getDescription(), Long.valueOf(var0.getLastModifiedTimestamp()), Long.valueOf(var0.getPlayedTime()), var0.getUniqueName()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotMetadata, java.lang.Object) boolean
    static boolean method_5322(SnapshotMetadata var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof SnapshotMetadata)) {
            var2 = false;
        } else if(var0 != var1) {
            SnapshotMetadata var3 = (SnapshotMetadata)var1;
            if(!class_1089.equal(var3.getGame(), var0.getGame()) || !class_1089.equal(var3.getOwner(), var0.getOwner()) || !class_1089.equal(var3.getSnapshotId(), var0.getSnapshotId()) || !class_1089.equal(var3.getCoverImageUri(), var0.getCoverImageUri()) || !class_1089.equal(Float.valueOf(var3.getCoverImageAspectRatio()), Float.valueOf(var0.getCoverImageAspectRatio())) || !class_1089.equal(var3.getTitle(), var0.getTitle()) || !class_1089.equal(var3.getDescription(), var0.getDescription()) || !class_1089.equal(Long.valueOf(var3.getLastModifiedTimestamp()), Long.valueOf(var0.getLastModifiedTimestamp())) || !class_1089.equal(Long.valueOf(var3.getPlayedTime()), Long.valueOf(var0.getPlayedTime())) || !class_1089.equal(var3.getUniqueName(), var0.getUniqueName())) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.snapshot.SnapshotMetadata) java.lang.String
    static String method_5323(SnapshotMetadata var0) {
        return class_1089.method_5673(var0).method_5425("Game", var0.getGame()).method_5425("Owner", var0.getOwner()).method_5425("SnapshotId", var0.getSnapshotId()).method_5425("CoverImageUri", var0.getCoverImageUri()).method_5425("CoverImageUrl", var0.getCoverImageUrl()).method_5425("CoverImageAspectRatio", Float.valueOf(var0.getCoverImageAspectRatio())).method_5425("Description", var0.getDescription()).method_5425("LastModifiedTimestamp", Long.valueOf(var0.getLastModifiedTimestamp())).method_5425("PlayedTime", Long.valueOf(var0.getPlayedTime())).method_5425("UniqueName", var0.getUniqueName()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_5322(this, var1);
    }

    public SnapshotMetadata freeze() {
        return this;
    }

    public float getCoverImageAspectRatio() {
        return this.ads;
    }

    public Uri getCoverImageUri() {
        return this.adk;
    }

    public String getCoverImageUrl() {
        return this.adp;
    }

    public String getDescription() {
        return this.field_4706;
    }

    public void getDescription(CharArrayBuffer var1) {
        class_345.method_2325(this.field_4706, var1);
    }

    public Game getGame() {
        return this.aay;
    }

    public long getLastModifiedTimestamp() {
        return this.adq;
    }

    public Player getOwner() {
        return this.ado;
    }

    public long getPlayedTime() {
        return this.adr;
    }

    public String getSnapshotId() {
        return this.field_4707;
    }

    public String getTitle() {
        return this.field_4705;
    }

    public String getUniqueName() {
        return this.adt;
    }

    public int getVersionCode() {
        return this.field_4704;
    }

    public int hashCode() {
        return method_5321(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return method_5323(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        SnapshotMetadataEntityCreator.method_5439(this, var1, var2);
    }
}
