package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.class_962;

// $FF: renamed from: com.google.android.gms.wearable.d
public class class_963 implements Creator<c> {
   // $FF: renamed from: a (com.google.android.gms.wearable.c, android.os.Parcel, int) void
   static void method_5367(class_962 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_4096);
      class_704.method_4038(var1, 2, var0.getName(), false);
      class_704.method_4038(var1, 3, var0.getAddress(), false);
      class_704.method_4050(var1, 4, var0.getType());
      class_704.method_4050(var1, 5, var0.getRole());
      class_704.method_4041(var1, 6, var0.isEnabled());
      class_704.method_4041(var1, 7, var0.isConnected());
      class_704.method_4038(var1, 8, var0.method_5366(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5368(var1);
   }

   // $FF: renamed from: em (android.os.Parcel) com.google.android.gms.wearable.c
   public class_962 method_5368(Parcel var1) {
      String var2 = null;
      boolean var3 = false;
      int var4 = class_705.method_4059(var1);
      boolean var5 = false;
      int var6 = 0;
      int var7 = 0;
      String var8 = null;
      String var9 = null;
      int var10 = 0;

      while(var1.dataPosition() < var4) {
         int var11 = class_705.method_4058(var1);
         switch(class_705.method_4065(var11)) {
         case 1:
            var10 = class_705.method_4073(var1, var11);
            break;
         case 2:
            var9 = class_705.method_4081(var1, var11);
            break;
         case 3:
            var8 = class_705.method_4081(var1, var11);
            break;
         case 4:
            var7 = class_705.method_4073(var1, var11);
            break;
         case 5:
            var6 = class_705.method_4073(var1, var11);
            break;
         case 6:
            var5 = class_705.method_4069(var1, var11);
            break;
         case 7:
            var3 = class_705.method_4069(var1, var11);
            break;
         case 8:
            var2 = class_705.method_4081(var1, var11);
            break;
         default:
            class_705.method_4066(var1, var11);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_962(var10, var9, var8, var7, var6, var5, var3, var2);
      }
   }

   // $FF: renamed from: gv (int) com.google.android.gms.wearable.c[]
   public class_962[] method_5369(int var1) {
      return new class_962[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5369(var1);
   }
}
