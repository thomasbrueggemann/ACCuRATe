package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.SnapshotContentsCreator;
import java.io.IOException;

public final class SnapshotContents implements SafeParcelable {
    public static final SnapshotContentsCreator CREATOR = new SnapshotContentsCreator();
    private static final Object adg = new Object();
    // $FF: renamed from: BR int
    private final int field_5200;
    // $FF: renamed from: Ox com.google.android.gms.drive.Contents
    private Contents field_5201;

    SnapshotContents(int var1, Contents var2) {
        this.field_5200 = var1;
        this.field_5201 = var2;
    }

    public SnapshotContents(Contents var1) {
        this(1, var1);
    }

    // $FF: renamed from: a (int, byte[], int, int, boolean) boolean
    private boolean method_5838(int param1, byte[] param2, int param3, int param4, boolean param5) {
        // $FF: Couldn't be decompiled
    }

    public void close() {
        this.field_5201.method_4245();
        this.field_5201 = null;
    }

    public int describeContents() {
        return 0;
    }

    public Contents getContents() {
        return this.field_5201;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        boolean var1;
        if(!this.isClosed()) {
            var1 = true;
        } else {
            var1 = false;
        }

        class_1090.method_5676(var1, "Cannot mutate closed contents!");
        return this.field_5201.getParcelFileDescriptor();
    }

    public int getVersionCode() {
        return this.field_5200;
    }

    public boolean isClosed() {
        return this.field_5201 == null;
    }

    public boolean modifyBytes(int var1, byte[] var2, int var3, int var4) {
        return this.method_5838(var1, var2, var3, var2.length, false);
    }

    public byte[] readFully() throws IOException {
        // $FF: Couldn't be decompiled
    }

    public boolean writeBytes(byte[] var1) {
        return this.method_5838(0, var1, 0, var1.length, true);
    }

    public void writeToParcel(Parcel var1, int var2) {
        SnapshotContentsCreator.method_5617(this, var1, var2);
    }
}
