package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntityCreator;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.class_336;

public final class SnapshotEntity implements SafeParcelable, Snapshot {
   public static final SnapshotEntityCreator CREATOR = new SnapshotEntityCreator();
   // $FF: renamed from: CK int
   private final int field_2815;
   private final SnapshotMetadataEntity aeZ;
   private final SnapshotContentsEntity afa;

   SnapshotEntity(int var1, SnapshotMetadata var2, SnapshotContentsEntity var3) {
      this.field_2815 = var1;
      this.aeZ = new SnapshotMetadataEntity(var2);
      this.afa = var3;
   }

   public SnapshotEntity(SnapshotMetadata var1, SnapshotContentsEntity var2) {
      this(2, var1, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.Snapshot, java.lang.Object) boolean
   static boolean method_3708(Snapshot var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Snapshot)) {
         var2 = false;
      } else if(var0 != var1) {
         Snapshot var3 = (Snapshot)var1;
         if(!class_336.equal(var3.getMetadata(), var0.getMetadata()) || !class_336.equal(var3.getSnapshotContents(), var0.getSnapshotContents())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.snapshot.Snapshot) int
   static int method_3709(Snapshot var0) {
      Object[] var1 = new Object[]{var0.getMetadata(), var0.getSnapshotContents()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: c (com.google.android.gms.games.snapshot.Snapshot) java.lang.String
   static String method_3710(Snapshot var0) {
      class_336.class_1339 var1 = class_336.method_2312(var0).method_3424("Metadata", var0.getMetadata());
      boolean var2;
      if(var0.getSnapshotContents() != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var1.method_3424("HasContents", Boolean.valueOf(var2)).toString();
   }

   private boolean isClosed() {
      return this.afa.isClosed();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_3708(this, var1);
   }

   public Snapshot freeze() {
      return this;
   }

   public SnapshotMetadata getMetadata() {
      return this.aeZ;
   }

   public SnapshotContents getSnapshotContents() {
      return this.isClosed()?null:this.afa;
   }

   public int getVersionCode() {
      return this.field_2815;
   }

   public int hashCode() {
      return method_3709(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_3710(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotEntityCreator.method_5130(this, var1, var2);
   }
}
