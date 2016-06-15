package com.google.android.gms.games.snapshot;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;

public interface Snapshot extends Parcelable, Freezable<Snapshot> {
   Contents getContents();

   SnapshotMetadata getMetadata();

   // $FF: renamed from: iH () void
   void method_233();

   boolean modifyBytes(int var1, byte[] var2, int var3, int var4);

   byte[] readFully();

   boolean writeBytes(byte[] var1);
}
