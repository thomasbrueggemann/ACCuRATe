package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.c
public class class_312 implements Creator<ParcelableEventList> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ParcelableEventList, android.os.Parcel, int) void
   static void method_2193(ParcelableEventList var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_2974);
      class_704.method_4051(var1, 2, var0.field_2978, false);
      class_704.method_4034(var1, 3, var0.field_2975, var2, false);
      class_704.method_4041(var1, 4, var0.field_2976);
      class_704.method_4049(var1, 5, var0.field_2977, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bi (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ParcelableEventList
   public ParcelableEventList method_2194(Parcel var1) {
      boolean var2 = false;
      ArrayList var3 = null;
      int var4 = class_705.method_4059(var1);
      DataHolder var5 = null;
      ArrayList var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var7 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var6 = class_705.method_4068(var1, var8, ParcelableEvent.CREATOR);
            break;
         case 3:
            var5 = (DataHolder)class_705.method_4061(var1, var8, DataHolder.CREATOR);
            break;
         case 4:
            var2 = class_705.method_4069(var1, var8);
            break;
         case 5:
            var3 = class_705.method_4055(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new ParcelableEventList(var7, var6, var5, var2, var3);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2194(var1);
   }

   // $FF: renamed from: cy (int) com.google.android.gms.drive.realtime.internal.event.ParcelableEventList[]
   public ParcelableEventList[] method_2195(int var1) {
      return new ParcelableEventList[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2195(var1);
   }
}
