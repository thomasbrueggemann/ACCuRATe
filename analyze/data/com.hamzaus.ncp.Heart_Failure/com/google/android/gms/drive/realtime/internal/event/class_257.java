package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;
import com.google.android.gms.drive.realtime.internal.event.ParcelableObjectChangedEvent;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.b
public class class_257 implements Creator<ParcelableEventList> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ParcelableEventList, android.os.Parcel, int) void
   static void method_1804(ParcelableEventList var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3100);
      class_599.method_3375(var1, 2, var0.field_3098, var2, false);
      class_599.method_3365(var1, 3, var0.field_3099, var2, false);
      class_599.method_3372(var1, 4, var0.field_3096);
      class_599.method_3375(var1, 5, var0.field_3097, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aU (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ParcelableEventList
   public ParcelableEventList method_1805(Parcel var1) {
      boolean var2 = false;
      ParcelableObjectChangedEvent[] var3 = null;
      int var4 = class_600.method_3385(var1);
      DataHolder var5 = null;
      ParcelableEvent[] var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var7 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var6 = (ParcelableEvent[])class_600.method_3396(var1, var8, ParcelableEvent.CREATOR);
            break;
         case 3:
            var5 = (DataHolder)class_600.method_3390(var1, var8, DataHolder.CREATOR);
            break;
         case 4:
            var2 = class_600.method_3398(var1, var8);
            break;
         case 5:
            var3 = (ParcelableObjectChangedEvent[])class_600.method_3396(var1, var8, ParcelableObjectChangedEvent.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new ParcelableEventList(var7, var6, var5, var2, var3);
      }
   }

   // $FF: renamed from: bR (int) com.google.android.gms.drive.realtime.internal.event.ParcelableEventList[]
   public ParcelableEventList[] method_1806(int var1) {
      return new ParcelableEventList[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1805(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1806(var1);
   }
}
