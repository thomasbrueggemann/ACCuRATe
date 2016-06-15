package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.data.class_749;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;

// $FF: renamed from: com.google.android.gms.common.data.b
public class class_750 implements Creator<a> {
   // $FF: renamed from: a (com.google.android.gms.common.data.a, android.os.Parcel, int) void
   static void method_4289(class_749 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_4046);
      class_599.method_3365(var1, 2, var0.field_4042, var2, false);
      class_599.method_3381(var1, 3, var0.field_4041);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: ab (int) com.google.android.gms.common.data.a[]
   public class_749[] method_4290(int var1) {
      return new class_749[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4291(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4290(var1);
   }

   // $FF: renamed from: w (android.os.Parcel) com.google.android.gms.common.data.a
   public class_749 method_4291(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      ParcelFileDescriptor var4 = null;

      int var5;
      int var7;
      for(var5 = 0; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_600.method_3383(var1);
         ParcelFileDescriptor var8;
         int var9;
         switch(class_600.method_3394(var6)) {
         case 1:
            int var11 = class_600.method_3402(var1, var6);
            var8 = var4;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            ParcelFileDescriptor var10 = (ParcelFileDescriptor)class_600.method_3390(var1, var6, ParcelFileDescriptor.CREATOR);
            var9 = var5;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = class_600.method_3402(var1, var6);
            var8 = var4;
            var9 = var5;
            break;
         default:
            class_600.method_3395(var1, var6);
            var7 = var2;
            var8 = var4;
            var9 = var5;
         }

         var5 = var9;
         var4 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_749(var5, var4, var2);
      }
   }
}
