package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wearable.Asset;

// $FF: renamed from: com.google.android.gms.wearable.a
public class class_742 implements Creator<Asset> {
   // $FF: renamed from: a (com.google.android.gms.wearable.Asset, android.os.Parcel, int) void
   static void method_4258(Asset var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_4097);
      class_599.method_3373(var1, 2, var0.getData(), false);
      class_599.method_3369(var1, 3, var0.getDigest(), false);
      class_599.method_3365(var1, 4, var0.ale, var2, false);
      class_599.method_3365(var1, 5, var0.uri, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4259(var1);
   }

   // $FF: renamed from: cs (android.os.Parcel) com.google.android.gms.wearable.Asset
   public Asset method_4259(Parcel var1) {
      Uri var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      ParcelFileDescriptor var5 = null;
      String var6 = null;
      byte[] var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var4 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var7 = class_600.method_3413(var1, var8);
            break;
         case 3:
            var6 = class_600.method_3410(var1, var8);
            break;
         case 4:
            var5 = (ParcelFileDescriptor)class_600.method_3390(var1, var8, ParcelFileDescriptor.CREATOR);
            break;
         case 5:
            var2 = (Uri)class_600.method_3390(var1, var8, Uri.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new Asset(var4, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: ea (int) com.google.android.gms.wearable.Asset[]
   public Asset[] method_4260(int var1) {
      return new Asset[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4260(var1);
   }
}
