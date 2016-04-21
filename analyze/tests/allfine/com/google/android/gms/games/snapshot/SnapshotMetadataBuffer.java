package com.google.android.gms.games.snapshot;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataRef;

public final class SnapshotMetadataBuffer extends DataBuffer<SnapshotMetadata> {
    public SnapshotMetadataBuffer(DataHolder var1) {
        super(var1);
    }

    public SnapshotMetadata get(int var1) {
        return new SnapshotMetadataRef(this.II, var1);
    }
}
