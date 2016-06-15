package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.a
public class class_259 implements Creator<ParcelableEvent> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ParcelableEvent, android.os.Parcel, int) void
   static void method_1810(ParcelableEvent var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3163);
      class_599.method_3369(var1, 2, var0.field_3162, false);
      class_599.method_3369(var1, 3, var0.field_3151, false);
      class_599.method_3372(var1, 4, var0.field_3153);
      class_599.method_3369(var1, 5, var0.field_3152, false);
      class_599.method_3369(var1, 6, var0.field_3154, false);
      class_599.method_3365(var1, 7, var0.field_3155, var2, false);
      class_599.method_3365(var1, 8, var0.field_3156, var2, false);
      class_599.method_3365(var1, 9, var0.field_3157, var2, false);
      class_599.method_3365(var1, 10, var0.field_3158, var2, false);
      class_599.method_3365(var1, 11, var0.field_3159, var2, false);
      class_599.method_3365(var1, 12, var0.field_3160, var2, false);
      class_599.method_3365(var1, 13, var0.field_3161, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aT (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ParcelableEvent
   public ParcelableEvent method_1811(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      String var7 = null;
      String var8 = null;
      TextInsertedDetails var9 = null;
      TextDeletedDetails var10 = null;
      ValuesAddedDetails var11 = null;
      ValuesRemovedDetails var12 = null;
      ValuesSetDetails var13 = null;
      ValueChangedDetails var14 = null;
      ReferenceShiftedDetails var15 = null;

      while(var1.dataPosition() < var2) {
         int var16 = class_600.method_3383(var1);
         switch(class_600.method_3394(var16)) {
         case 1:
            var3 = class_600.method_3402(var1, var16);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var16);
            break;
         case 3:
            var5 = class_600.method_3410(var1, var16);
            break;
         case 4:
            var6 = class_600.method_3398(var1, var16);
            break;
         case 5:
            var7 = class_600.method_3410(var1, var16);
            break;
         case 6:
            var8 = class_600.method_3410(var1, var16);
            break;
         case 7:
            var9 = (TextInsertedDetails)class_600.method_3390(var1, var16, TextInsertedDetails.CREATOR);
            break;
         case 8:
            var10 = (TextDeletedDetails)class_600.method_3390(var1, var16, TextDeletedDetails.CREATOR);
            break;
         case 9:
            var11 = (ValuesAddedDetails)class_600.method_3390(var1, var16, ValuesAddedDetails.CREATOR);
            break;
         case 10:
            var12 = (ValuesRemovedDetails)class_600.method_3390(var1, var16, ValuesRemovedDetails.CREATOR);
            break;
         case 11:
            var13 = (ValuesSetDetails)class_600.method_3390(var1, var16, ValuesSetDetails.CREATOR);
            break;
         case 12:
            var14 = (ValueChangedDetails)class_600.method_3390(var1, var16, ValueChangedDetails.CREATOR);
            break;
         case 13:
            var15 = (ReferenceShiftedDetails)class_600.method_3390(var1, var16, ReferenceShiftedDetails.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new ParcelableEvent(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
      }
   }

   // $FF: renamed from: bQ (int) com.google.android.gms.drive.realtime.internal.event.ParcelableEvent[]
   public ParcelableEvent[] method_1812(int var1) {
      return new ParcelableEvent[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1811(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1812(var1);
   }
}
