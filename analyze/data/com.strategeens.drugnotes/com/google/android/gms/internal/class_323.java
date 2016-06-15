package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_324;
import com.google.android.gms.internal.io;

// $FF: renamed from: com.google.android.gms.internal.ip
public class class_323 implements Creator<io> {
   // $FF: renamed from: a (com.google.android.gms.internal.io, android.os.Parcel, int) void
   static void method_2268(class_324 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4028(var1, 2, var0.method_2278());
      class_704.method_4041(var1, 3, var0.method_2279());
      class_704.method_4050(var1, 4, var0.method_2280());
      class_704.method_4034(var1, 5, var0.getApplicationMetadata(), var2, false);
      class_704.method_4050(var1, 6, var0.method_2281());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: ai (int) com.google.android.gms.internal.io[]
   public class_324[] method_2269(int var1) {
      return new class_324[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2270(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2269(var1);
   }

   // $FF: renamed from: y (android.os.Parcel) com.google.android.gms.internal.io
   public class_324 method_2270(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      double var4 = 0.0D;
      ApplicationMetadata var6 = null;
      int var7 = 0;
      boolean var8 = false;
      int var9 = 0;

      while(var1.dataPosition() < var3) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var9 = class_705.method_4073(var1, var10);
            break;
         case 2:
            var4 = class_705.method_4079(var1, var10);
            break;
         case 3:
            var8 = class_705.method_4069(var1, var10);
            break;
         case 4:
            var7 = class_705.method_4073(var1, var10);
            break;
         case 5:
            var6 = (ApplicationMetadata)class_705.method_4061(var1, var10, ApplicationMetadata.CREATOR);
            break;
         case 6:
            var2 = class_705.method_4073(var1, var10);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_324(var9, var4, var8, var7, var6, var2);
      }
   }
}
