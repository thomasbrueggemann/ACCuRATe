package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;

public interface Snapshot extends Parcelable, Freezable<Snapshot> {
    @Deprecated
    Contents getContents();

    SnapshotMetadata getMetadata();

    SnapshotContents getSnapshotContents();

    @Deprecated
    boolean modifyBytes(int var1, byte[] var2, int var3, int var4);

    @Deprecated
    byte[] readFully();

    @Deprecated
    boolean writeBytes(byte[] var1);
}
