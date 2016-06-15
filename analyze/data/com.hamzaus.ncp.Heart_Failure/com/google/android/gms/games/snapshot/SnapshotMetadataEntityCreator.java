package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public class SnapshotMetadataEntityCreator implements Creator<SnapshotMetadataEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotMetadataEntity, android.os.Parcel, int) void
   static void method_4182(SnapshotMetadataEntity var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3365(var1, 1, var0.getGame(), var2, false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.getOwner(), var2, false);
      class_599.method_3369(var1, 3, var0.getSnapshotId(), false);
      class_599.method_3365(var1, 5, var0.getCoverImageUri(), var2, false);
      class_599.method_3369(var1, 6, var0.getCoverImageUrl(), false);
      class_599.method_3369(var1, 7, var0.getTitle(), false);
      class_599.method_3369(var1, 8, var0.getDescription(), false);
      class_599.method_3361(var1, 9, var0.getLastModifiedTimestamp());
      class_599.method_3361(var1, 10, var0.getPlayedTime());
      class_599.method_3360(var1, 11, var0.getCoverImageAspectRatio());
      class_599.method_3369(var1, 12, var0.getUniqueName(), false);
      class_599.method_3357(var1, var3);
   }

   public SnapshotMetadataEntity createFromParcel(Parcel var1) {
      int var2 = class_600.method_3385(var1);
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

      while(var1.dataPosition() < var2) {
         int var17 = class_600.method_3383(var1);
         switch(class_600.method_3394(var17)) {
         case 1:
            var4 = (GameEntity)class_600.method_3390(var1, var17, GameEntity.CREATOR);
            break;
         case 2:
            var5 = (PlayerEntity)class_600.method_3390(var1, var17, PlayerEntity.CREATOR);
            break;
         case 3:
            var6 = class_600.method_3410(var1, var17);
            break;
         case 5:
            var7 = (Uri)class_600.method_3390(var1, var17, Uri.CREATOR);
            break;
         case 6:
            var8 = class_600.method_3410(var1, var17);
            break;
         case 7:
            var9 = class_600.method_3410(var1, var17);
            break;
         case 8:
            var10 = class_600.method_3410(var1, var17);
            break;
         case 9:
            var11 = class_600.method_3404(var1, var17);
            break;
         case 10:
            var13 = class_600.method_3404(var1, var17);
            break;
         case 11:
            var15 = class_600.method_3407(var1, var17);
            break;
         case 12:
            var16 = class_600.method_3410(var1, var17);
            break;
         case 1000:
            var3 = class_600.method_3402(var1, var17);
            break;
         default:
            class_600.method_3395(var1, var17);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new SnapshotMetadataEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var13, var15, var16);
      }
   }

   public SnapshotMetadataEntity[] newArray(int var1) {
      return new SnapshotMetadataEntity[var1];
   }
}
