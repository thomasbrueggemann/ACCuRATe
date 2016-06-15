package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.b
public class class_311 implements Creator<ParcelableEvent> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ParcelableEvent, android.os.Parcel, int) void
   static void method_2190(ParcelableEvent var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_3117);
      class_704.method_4038(var1, 2, var0.field_3131, false);
      class_704.method_4038(var1, 3, var0.field_3118, false);
      class_704.method_4049(var1, 4, var0.field_3120, false);
      class_704.method_4041(var1, 5, var0.field_3121);
      class_704.method_4038(var1, 6, var0.field_3119, false);
      class_704.method_4038(var1, 7, var0.field_3122, false);
      class_704.method_4034(var1, 8, var0.field_3123, var2, false);
      class_704.method_4034(var1, 9, var0.field_3124, var2, false);
      class_704.method_4034(var1, 10, var0.field_3125, var2, false);
      class_704.method_4034(var1, 11, var0.field_3126, var2, false);
      class_704.method_4034(var1, 12, var0.field_3127, var2, false);
      class_704.method_4034(var1, 13, var0.field_3128, var2, false);
      class_704.method_4034(var1, 14, var0.field_3129, var2, false);
      class_704.method_4034(var1, 15, var0.field_3130, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bh (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ParcelableEvent
   public ParcelableEvent method_2191(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      ArrayList var6 = null;
      boolean var7 = false;
      String var8 = null;
      String var9 = null;
      TextInsertedDetails var10 = null;
      TextDeletedDetails var11 = null;
      ValuesAddedDetails var12 = null;
      ValuesRemovedDetails var13 = null;
      ValuesSetDetails var14 = null;
      ValueChangedDetails var15 = null;
      ReferenceShiftedDetails var16 = null;
      ObjectChangedDetails var17 = null;

      while(var1.dataPosition() < var2) {
         int var18 = class_705.method_4058(var1);
         switch(class_705.method_4065(var18)) {
         case 1:
            var3 = class_705.method_4073(var1, var18);
            break;
         case 2:
            var4 = class_705.method_4081(var1, var18);
            break;
         case 3:
            var5 = class_705.method_4081(var1, var18);
            break;
         case 4:
            var6 = class_705.method_4055(var1, var18);
            break;
         case 5:
            var7 = class_705.method_4069(var1, var18);
            break;
         case 6:
            var8 = class_705.method_4081(var1, var18);
            break;
         case 7:
            var9 = class_705.method_4081(var1, var18);
            break;
         case 8:
            var10 = (TextInsertedDetails)class_705.method_4061(var1, var18, TextInsertedDetails.CREATOR);
            break;
         case 9:
            var11 = (TextDeletedDetails)class_705.method_4061(var1, var18, TextDeletedDetails.CREATOR);
            break;
         case 10:
            var12 = (ValuesAddedDetails)class_705.method_4061(var1, var18, ValuesAddedDetails.CREATOR);
            break;
         case 11:
            var13 = (ValuesRemovedDetails)class_705.method_4061(var1, var18, ValuesRemovedDetails.CREATOR);
            break;
         case 12:
            var14 = (ValuesSetDetails)class_705.method_4061(var1, var18, ValuesSetDetails.CREATOR);
            break;
         case 13:
            var15 = (ValueChangedDetails)class_705.method_4061(var1, var18, ValueChangedDetails.CREATOR);
            break;
         case 14:
            var16 = (ReferenceShiftedDetails)class_705.method_4061(var1, var18, ReferenceShiftedDetails.CREATOR);
            break;
         case 15:
            var17 = (ObjectChangedDetails)class_705.method_4061(var1, var18, ObjectChangedDetails.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var18);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new ParcelableEvent(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2191(var1);
   }

   // $FF: renamed from: cx (int) com.google.android.gms.drive.realtime.internal.event.ParcelableEvent[]
   public ParcelableEvent[] method_2192(int var1) {
      return new ParcelableEvent[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2192(var1);
   }
}
