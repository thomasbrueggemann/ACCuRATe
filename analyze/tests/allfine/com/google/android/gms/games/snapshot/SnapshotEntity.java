package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotEntityCreator;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.io.IOException;

public final class SnapshotEntity implements SafeParcelable, Snapshot {
    public static final SnapshotEntityCreator CREATOR = new SnapshotEntityCreator();
    // $FF: renamed from: BR int
    private final int field_3220;
    private final SnapshotMetadataEntity adh;
    private final SnapshotContents adi;

    SnapshotEntity(int var1, SnapshotMetadata var2, SnapshotContents var3) {
        this.field_3220 = var1;
        this.adh = new SnapshotMetadataEntity(var2);
        this.adi = var3;
    }

    public SnapshotEntity(SnapshotMetadata var1, SnapshotContents var2) {
        this(2, var1, var2);
    }

    // $FF: renamed from: a (com.google.android.gms.games.snapshot.Snapshot, java.lang.Object) boolean
    static boolean method_3702(Snapshot var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof Snapshot)) {
            var2 = false;
        } else if(var0 != var1) {
            Snapshot var3 = (Snapshot)var1;
            if(!class_1089.equal(var3.getMetadata(), var0.getMetadata()) || !class_1089.equal(var3.getSnapshotContents(), var0.getSnapshotContents())) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.snapshot.Snapshot) int
    static int method_3703(Snapshot var0) {
        Object[] var1 = new Object[] {var0.getMetadata(), var0.getSnapshotContents()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: c (com.google.android.gms.games.snapshot.Snapshot) java.lang.String
    static String method_3704(Snapshot var0) {
        class_1089.class_1785 var1 = class_1089.method_5673(var0).method_5425("Metadata", var0.getMetadata());
        boolean var2;
        if(var0.getSnapshotContents() != null) {
            var2 = true;
        } else {
            var2 = false;
        }

        return var1.method_5425("HasContents", Boolean.valueOf(var2)).toString();
    }

    private boolean isClosed() {
        return this.adi.isClosed();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_3702(this, var1);
    }

    public Snapshot freeze() {
        return this;
    }

    public Contents getContents() {
        return this.isClosed()?null:this.adi.getContents();
    }

    public SnapshotMetadata getMetadata() {
        return this.adh;
    }

    public SnapshotContents getSnapshotContents() {
        return this.isClosed()?null:this.adi;
    }

    public int getVersionCode() {
        return this.field_3220;
    }

    public int hashCode() {
        return method_3703(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean modifyBytes(int var1, byte[] var2, int var3, int var4) {
        return this.adi.modifyBytes(var1, var2, var3, var4);
    }

    public byte[] readFully() {
        try {
            byte[] var2 = this.adi.readFully();
            return var2;
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }

    public String toString() {
        return method_3704(this);
    }

    public boolean writeBytes(byte[] var1) {
        return this.adi.writeBytes(var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        SnapshotEntityCreator.method_5275(this, var1, var2);
    }
}
