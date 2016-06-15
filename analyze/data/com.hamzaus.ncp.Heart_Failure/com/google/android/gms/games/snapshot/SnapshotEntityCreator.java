package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public class SnapshotEntityCreator implements Creator<SnapshotEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotEntity, android.os.Parcel, int) void
   static void method_4064(SnapshotEntity var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3365(var1, 1, var0.getMetadata(), var2, false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.getContents(), var2, false);
      class_599.method_3357(var1, var3);
   }

   public SnapshotEntity createFromParcel(Parcel var1) {
      Contents var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;

      SnapshotMetadataEntity var5;
      Contents var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_600.method_3383(var1);
         SnapshotMetadataEntity var8;
         int var9;
         switch(class_600.method_3394(var6)) {
         case 1:
            SnapshotMetadataEntity var12 = (SnapshotMetadataEntity)class_600.method_3390(var1, var6, SnapshotMetadataEntity.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var12;
            break;
         case 2:
            var7 = (Contents)class_600.method_3390(var1, var6, Contents.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         case 1000:
            int var10 = class_600.method_3402(var1, var6);
            var8 = var5;
            var9 = var10;
            var7 = var2;
            break;
         default:
            class_600.method_3395(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new SnapshotEntity(var4, var5, var2);
      }
   }

   public SnapshotEntity[] newArray(int var1) {
      return new SnapshotEntity[var1];
   }
}
