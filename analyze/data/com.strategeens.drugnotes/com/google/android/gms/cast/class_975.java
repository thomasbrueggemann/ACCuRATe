package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;

// $FF: renamed from: com.google.android.gms.cast.c
public class class_975 implements Creator<LaunchOptions> {
   // $FF: renamed from: a (com.google.android.gms.cast.LaunchOptions, android.os.Parcel, int) void
   static void method_5433(LaunchOptions var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4041(var1, 2, var0.getRelaunchIfRunning());
      class_704.method_4038(var1, 3, var0.getLanguage(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: aa (int) com.google.android.gms.cast.LaunchOptions[]
   public LaunchOptions[] method_5434(int var1) {
      return new LaunchOptions[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5435(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5434(var1);
   }

   // $FF: renamed from: w (android.os.Parcel) com.google.android.gms.cast.LaunchOptions
   public LaunchOptions method_5435(Parcel var1) {
      boolean var2 = false;
      int var3 = class_705.method_4059(var1);
      String var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var5 = class_705.method_4073(var1, var6);
            break;
         case 2:
            var2 = class_705.method_4069(var1, var6);
            break;
         case 3:
            var4 = class_705.method_4081(var1, var6);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new LaunchOptions(var5, var2, var4);
      }
   }
}
