package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntityCreator;

public final class SnapshotContentsEntity implements SafeParcelable, SnapshotContents {
   public static final SnapshotContentsEntityCreator CREATOR = new SnapshotContentsEntityCreator();
   private static final Object zzaKK = new Object();
   private final int mVersionCode;
   private Contents zzara;

   SnapshotContentsEntity(int var1, Contents var2) {
      this.mVersionCode = var1;
      this.zzara = var2;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public boolean isClosed() {
      return this.zzara == null;
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotContentsEntityCreator.zza(this, var1, var2);
   }

   public Contents zzsx() {
      return this.zzara;
   }
}
