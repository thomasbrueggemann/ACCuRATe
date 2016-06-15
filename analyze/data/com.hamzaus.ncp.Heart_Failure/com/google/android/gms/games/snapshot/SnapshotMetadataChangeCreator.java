package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.class_749;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChange> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.snapshot.SnapshotMetadataChange, android.os.Parcel, int) void
   static void method_4513(SnapshotMetadataChange var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.getDescription(), false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3368(var1, 2, var0.getPlayedTimeMillis(), false);
      class_599.method_3365(var1, 4, var0.getCoverImageUri(), var2, false);
      class_599.method_3365(var1, 5, var0.method_2783(), var2, false);
      class_599.method_3357(var1, var3);
   }

   public SnapshotMetadataChange createFromParcel(Parcel var1) {
      Uri var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      class_749 var5 = null;
      Long var6 = null;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var7 = class_600.method_3410(var1, var8);
            break;
         case 2:
            var6 = class_600.method_3405(var1, var8);
            break;
         case 4:
            var2 = (Uri)class_600.method_3390(var1, var8, Uri.CREATOR);
            break;
         case 5:
            var5 = (class_749)class_600.method_3390(var1, var8, class_749.CREATOR);
            break;
         case 1000:
            var4 = class_600.method_3402(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new SnapshotMetadataChange(var4, var7, var6, var5, var2);
      }
   }

   public SnapshotMetadataChange[] newArray(int var1) {
      return new SnapshotMetadataChange[var1];
   }
}
