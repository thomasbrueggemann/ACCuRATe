package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntityCreator;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public final class SnapshotEntity implements SafeParcelable, Snapshot {
   public static final Creator<SnapshotEntity> CREATOR = new SnapshotEntityCreator();
   private final int mVersionCode;
   private final SnapshotMetadataEntity zzaKL;
   private final SnapshotContentsEntity zzaKM;

   SnapshotEntity(int var1, SnapshotMetadata var2, SnapshotContentsEntity var3) {
      this.mVersionCode = var1;
      this.zzaKL = new SnapshotMetadataEntity(var2);
      this.zzaKM = var3;
   }

   private boolean isClosed() {
      return this.zzaKM.isClosed();
   }

   static boolean zza(Snapshot var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Snapshot)) {
         var2 = false;
      } else if(var0 != var1) {
         Snapshot var3 = (Snapshot)var1;
         if(!zzw.equal(var3.getMetadata(), var0.getMetadata()) || !zzw.equal(var3.getSnapshotContents(), var0.getSnapshotContents())) {
            return false;
         }
      }

      return var2;
   }

   static int zzb(Snapshot var0) {
      Object[] var1 = new Object[]{var0.getMetadata(), var0.getSnapshotContents()};
      return zzw.hashCode(var1);
   }

   static String zzc(Snapshot var0) {
      zzw.zza var1 = zzw.zzy(var0).zzg("Metadata", var0.getMetadata());
      boolean var2;
      if(var0.getSnapshotContents() != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var1.zzg("HasContents", Boolean.valueOf(var2)).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public Snapshot freeze() {
      return this;
   }

   public SnapshotMetadata getMetadata() {
      return this.zzaKL;
   }

   public SnapshotContents getSnapshotContents() {
      return this.isClosed()?null:this.zzaKM;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zzb(this);
   }

   public String toString() {
      return zzc(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotEntityCreator.zza(this, var1, var2);
   }
}
