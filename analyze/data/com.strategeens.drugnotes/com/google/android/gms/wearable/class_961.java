package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wearable.Asset;

// $FF: renamed from: com.google.android.gms.wearable.a
public class class_961 implements Creator<Asset> {
   // $FF: renamed from: a (com.google.android.gms.wearable.Asset, android.os.Parcel, int) void
   static void method_5363(Asset var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_4215);
      class_704.method_4042(var1, 2, var0.getData(), false);
      class_704.method_4038(var1, 3, var0.getDigest(), false);
      class_704.method_4034(var1, 4, var0.axb, var2, false);
      class_704.method_4034(var1, 5, var0.uri, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5364(var1);
   }

   // $FF: renamed from: el (android.os.Parcel) com.google.android.gms.wearable.Asset
   public Asset method_5364(Parcel var1) {
      Uri var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      ParcelFileDescriptor var5 = null;
      String var6 = null;
      byte[] var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var4 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var7 = class_705.method_4084(var1, var8);
            break;
         case 3:
            var6 = class_705.method_4081(var1, var8);
            break;
         case 4:
            var5 = (ParcelFileDescriptor)class_705.method_4061(var1, var8, ParcelFileDescriptor.CREATOR);
            break;
         case 5:
            var2 = (Uri)class_705.method_4061(var1, var8, Uri.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new Asset(var4, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: gu (int) com.google.android.gms.wearable.Asset[]
   public Asset[] method_5365(int var1) {
      return new Asset[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5365(var1);
   }
}
