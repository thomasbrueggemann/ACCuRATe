package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntityCreator;
import com.google.android.gms.internal.class_335;
import java.io.IOException;

public final class SnapshotContentsEntity implements SafeParcelable, SnapshotContents {
   public static final SnapshotContentsEntityCreator CREATOR = new SnapshotContentsEntityCreator();
   private static final Object aeY = new Object();
   // $FF: renamed from: CK int
   private final int field_4518;
   // $FF: renamed from: PW com.google.android.gms.drive.Contents
   private Contents field_4519;

   SnapshotContentsEntity(int var1, Contents var2) {
      this.field_4518 = var1;
      this.field_4519 = var2;
   }

   public SnapshotContentsEntity(Contents var1) {
      this(1, var1);
   }

   // $FF: renamed from: a (int, byte[], int, int, boolean) boolean
   private boolean method_5868(int param1, byte[] param2, int param3, int param4, boolean param5) {
      // $FF: Couldn't be decompiled
   }

   public void close() {
      this.field_4519 = null;
   }

   public int describeContents() {
      return 0;
   }

   public ParcelFileDescriptor getParcelFileDescriptor() {
      boolean var1;
      if(!this.isClosed()) {
         var1 = true;
      } else {
         var1 = false;
      }

      class_335.method_2302(var1, "Cannot mutate closed contents!");
      return this.field_4519.getParcelFileDescriptor();
   }

   public int getVersionCode() {
      return this.field_4518;
   }

   // $FF: renamed from: ir () com.google.android.gms.drive.Contents
   public Contents method_1061() {
      return this.field_4519;
   }

   public boolean isClosed() {
      return this.field_4519 == null;
   }

   public boolean modifyBytes(int var1, byte[] var2, int var3, int var4) {
      return this.method_5868(var1, var2, var3, var2.length, false);
   }

   public byte[] readFully() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public boolean writeBytes(byte[] var1) {
      return this.method_5868(0, var1, 0, var1.length, true);
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotContentsEntityCreator.method_3740(this, var1, var2);
   }
}
