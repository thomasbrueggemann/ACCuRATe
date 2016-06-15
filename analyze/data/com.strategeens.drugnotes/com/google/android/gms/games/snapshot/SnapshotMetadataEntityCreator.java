package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public class SnapshotMetadataEntityCreator implements Creator<SnapshotMetadataEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotMetadataEntity, android.os.Parcel, int) void
   static void method_5297(SnapshotMetadataEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getGame(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getOwner(), var2, false);
      class_704.method_4038(var1, 3, var0.getSnapshotId(), false);
      class_704.method_4034(var1, 5, var0.getCoverImageUri(), var2, false);
      class_704.method_4038(var1, 6, var0.getCoverImageUrl(), false);
      class_704.method_4038(var1, 7, var0.getTitle(), false);
      class_704.method_4038(var1, 8, var0.getDescription(), false);
      class_704.method_4030(var1, 9, var0.getLastModifiedTimestamp());
      class_704.method_4030(var1, 10, var0.getPlayedTime());
      class_704.method_4029(var1, 11, var0.getCoverImageAspectRatio());
      class_704.method_4038(var1, 12, var0.getUniqueName(), false);
      class_704.method_4041(var1, 13, var0.hasChangePending());
      class_704.method_4026(var1, var3);
   }

   public SnapshotMetadataEntity createFromParcel(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      GameEntity var4 = null;
      PlayerEntity var5 = null;
      String var6 = null;
      Uri var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      long var11 = 0L;
      long var13 = 0L;
      float var15 = 0.0F;
      String var16 = null;
      boolean var17 = false;

      while(var1.dataPosition() < var2) {
         int var18 = class_705.method_4058(var1);
         switch(class_705.method_4065(var18)) {
         case 1:
            var4 = (GameEntity)class_705.method_4061(var1, var18, GameEntity.CREATOR);
            break;
         case 2:
            var5 = (PlayerEntity)class_705.method_4061(var1, var18, PlayerEntity.CREATOR);
            break;
         case 3:
            var6 = class_705.method_4081(var1, var18);
            break;
         case 5:
            var7 = (Uri)class_705.method_4061(var1, var18, Uri.CREATOR);
            break;
         case 6:
            var8 = class_705.method_4081(var1, var18);
            break;
         case 7:
            var9 = class_705.method_4081(var1, var18);
            break;
         case 8:
            var10 = class_705.method_4081(var1, var18);
            break;
         case 9:
            var11 = class_705.method_4075(var1, var18);
            break;
         case 10:
            var13 = class_705.method_4075(var1, var18);
            break;
         case 11:
            var15 = class_705.method_4078(var1, var18);
            break;
         case 12:
            var16 = class_705.method_4081(var1, var18);
            break;
         case 13:
            var17 = class_705.method_4069(var1, var18);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var18);
            break;
         default:
            class_705.method_4066(var1, var18);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new SnapshotMetadataEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var13, var15, var16, var17);
      }
   }

   public SnapshotMetadataEntity[] newArray(int var1) {
      return new SnapshotMetadataEntity[var1];
   }
}
