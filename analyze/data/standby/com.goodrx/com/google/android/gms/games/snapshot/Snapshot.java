package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;

public interface Snapshot extends Parcelable, Freezable<Snapshot> {
   SnapshotMetadata getMetadata();

   SnapshotContents getSnapshotContents();
}
