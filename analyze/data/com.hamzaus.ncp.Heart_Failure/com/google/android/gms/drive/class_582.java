package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;

// $FF: renamed from: com.google.android.gms.drive.a
public class class_582 implements Creator<Contents> {
   // $FF: renamed from: a (com.google.android.gms.drive.Contents, android.os.Parcel, int) void
   static void method_3261(Contents var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3139);
      class_599.method_3365(var1, 2, var0.field_3130, var2, false);
      class_599.method_3381(var1, 3, var0.field_3138);
      class_599.method_3381(var1, 4, var0.field_3133);
      class_599.method_3365(var1, 5, var0.field_3134, var2, false);
      class_599.method_3369(var1, 6, var0.field_3135, false);
      class_599.method_3372(var1, 7, var0.field_3136);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: M (android.os.Parcel) com.google.android.gms.drive.Contents
   public Contents method_3262(Parcel var1) {
      String var2 = null;
      boolean var3 = false;
      int var4 = class_600.method_3385(var1);
      DriveId var5 = null;
      int var6 = 0;
      int var7 = 0;
      ParcelFileDescriptor var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = class_600.method_3383(var1);
         switch(class_600.method_3394(var10)) {
         case 1:
            var9 = class_600.method_3402(var1, var10);
            break;
         case 2:
            var8 = (ParcelFileDescriptor)class_600.method_3390(var1, var10, ParcelFileDescriptor.CREATOR);
            break;
         case 3:
            var7 = class_600.method_3402(var1, var10);
            break;
         case 4:
            var6 = class_600.method_3402(var1, var10);
            break;
         case 5:
            var5 = (DriveId)class_600.method_3390(var1, var10, DriveId.CREATOR);
            break;
         case 6:
            var2 = class_600.method_3410(var1, var10);
            break;
         case 7:
            var3 = class_600.method_3398(var1, var10);
            break;
         default:
            class_600.method_3395(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new Contents(var9, var8, var7, var6, var5, var2, var3);
      }
   }

   // $FF: renamed from: aG (int) com.google.android.gms.drive.Contents[]
   public Contents[] method_3263(int var1) {
      return new Contents[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3262(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3263(var1);
   }
}
