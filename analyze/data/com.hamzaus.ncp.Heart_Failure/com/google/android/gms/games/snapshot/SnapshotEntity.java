package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotEntityCreator;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.internal.class_349;

public final class SnapshotEntity implements SafeParcelable, Snapshot {
   public static final SnapshotEntityCreator CREATOR = new SnapshotEntityCreator();
   // $FF: renamed from: Ub java.lang.Object
   private static final Object field_2936 = new Object();
   // $FF: renamed from: HD com.google.android.gms.drive.Contents
   private Contents field_2937;
   // $FF: renamed from: Uc com.google.android.gms.games.snapshot.SnapshotMetadataEntity
   private final SnapshotMetadataEntity field_2938;
   // $FF: renamed from: xJ int
   private final int field_2939;

   SnapshotEntity(int var1, SnapshotMetadata var2, Contents var3) {
      this.field_2939 = var1;
      this.field_2938 = new SnapshotMetadataEntity(var2);
      this.field_2937 = var3;
   }

   public SnapshotEntity(SnapshotMetadata var1, Contents var2) {
      this(1, var1, var2);
   }

   // $FF: renamed from: a (int, byte[], int, int, boolean) boolean
   private boolean method_3109(int param1, byte[] param2, int param3, int param4, boolean param5) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.Snapshot, java.lang.Object) boolean
   static boolean method_3110(Snapshot var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Snapshot)) {
         var2 = false;
      } else if(var0 != var1) {
         Snapshot var3 = (Snapshot)var1;
         if(!class_349.equal(var3.getMetadata(), var0.getMetadata()) || !class_349.equal(var3.getContents(), var0.getContents())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.snapshot.Snapshot) int
   static int method_3111(Snapshot var0) {
      Object[] var1 = new Object[]{var0.getMetadata(), var0.getContents()};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: c (com.google.android.gms.games.snapshot.Snapshot) java.lang.String
   static String method_3112(Snapshot var0) {
      class_349.class_1264 var1 = class_349.method_2174(var0).method_4301("Metadata", var0.getMetadata());
      boolean var2;
      if(var0.getContents() != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var1.method_4301("HasContents", Boolean.valueOf(var2)).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_3110(this, var1);
   }

   public Snapshot freeze() {
      return this;
   }

   public Contents getContents() {
      return this.field_2937;
   }

   public SnapshotMetadata getMetadata() {
      return this.field_2938;
   }

   public int getVersionCode() {
      return this.field_2939;
   }

   public int hashCode() {
      return method_3111(this);
   }

   // $FF: renamed from: iH () void
   public void method_233() {
      this.field_2937.close();
      this.field_2937 = null;
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean modifyBytes(int var1, byte[] var2, int var3, int var4) {
      return this.method_3109(var1, var2, var3, var2.length, false);
   }

   public byte[] readFully() {
      // $FF: Couldn't be decompiled
   }

   public String toString() {
      return method_3112(this);
   }

   public boolean writeBytes(byte[] var1) {
      return this.method_3109(0, var1, 0, var1.length, true);
   }

   public void writeToParcel(Parcel var1, int var2) {
      SnapshotEntityCreator.method_4064(this, var1, var2);
   }
}
