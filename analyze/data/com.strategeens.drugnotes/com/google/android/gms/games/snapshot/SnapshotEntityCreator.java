package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public class SnapshotEntityCreator implements Creator<SnapshotEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotEntity, android.os.Parcel, int) void
   static void method_5130(SnapshotEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getMetadata(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 3, var0.getSnapshotContents(), var2, false);
      class_704.method_4026(var1, var3);
   }

   public SnapshotEntity createFromParcel(Parcel var1) {
      SnapshotContentsEntity var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;

      SnapshotMetadataEntity var5;
      SnapshotContentsEntity var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_705.method_4058(var1);
         SnapshotMetadataEntity var8;
         int var9;
         switch(class_705.method_4065(var6)) {
         case 1:
            SnapshotMetadataEntity var12 = (SnapshotMetadataEntity)class_705.method_4061(var1, var6, SnapshotMetadataEntity.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var12;
            break;
         case 3:
            var7 = (SnapshotContentsEntity)class_705.method_4061(var1, var6, SnapshotContentsEntity.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         case 1000:
            int var10 = class_705.method_4073(var1, var6);
            var8 = var5;
            var9 = var10;
            var7 = var2;
            break;
         default:
            class_705.method_4066(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new SnapshotEntity(var4, var5, var2);
      }
   }

   public SnapshotEntity[] newArray(int var1) {
      return new SnapshotEntity[var1];
   }
}
