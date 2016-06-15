package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.CloseContentsRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.f
public class class_223 implements Creator<CloseContentsRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsRequest, android.os.Parcel, int) void
   static void method_1396(CloseContentsRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3841);
      class_599.method_3365(var1, 2, var0.field_3839, var2, false);
      class_599.method_3366(var1, 3, var0.field_3840, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: V (android.os.Parcel) com.google.android.gms.drive.internal.CloseContentsRequest
   public CloseContentsRequest method_1397(Parcel var1) {
      Boolean var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;

      Contents var5;
      Boolean var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_600.method_3383(var1);
         Contents var8;
         int var9;
         switch(class_600.method_3394(var6)) {
         case 1:
            int var11 = class_600.method_3402(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            Contents var10 = (Contents)class_600.method_3390(var1, var6, Contents.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = class_600.method_3399(var1, var6);
            var8 = var5;
            var9 = var4;
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
         return new CloseContentsRequest(var4, var5, var2);
      }
   }

   // $FF: renamed from: aQ (int) com.google.android.gms.drive.internal.CloseContentsRequest[]
   public CloseContentsRequest[] method_1398(int var1) {
      return new CloseContentsRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1397(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1398(var1);
   }
}
