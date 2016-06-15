package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;
import com.google.android.gms.drive.realtime.internal.event.class_259;

public class ParcelableEvent implements SafeParcelable {
   public static final Creator<ParcelableEvent> CREATOR = new class_259();
   // $FF: renamed from: Lj java.lang.String
   final String field_3151;
   // $FF: renamed from: Ln java.lang.String
   final String field_3152;
   // $FF: renamed from: Lp boolean
   final boolean field_3153;
   // $FF: renamed from: Lq java.lang.String
   final String field_3154;
   // $FF: renamed from: Lr com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails
   final TextInsertedDetails field_3155;
   // $FF: renamed from: Ls com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails
   final TextDeletedDetails field_3156;
   // $FF: renamed from: Lt com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails
   final ValuesAddedDetails field_3157;
   // $FF: renamed from: Lu com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails
   final ValuesRemovedDetails field_3158;
   // $FF: renamed from: Lv com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails
   final ValuesSetDetails field_3159;
   // $FF: renamed from: Lw com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails
   final ValueChangedDetails field_3160;
   // $FF: renamed from: Lx com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails
   final ReferenceShiftedDetails field_3161;
   // $FF: renamed from: rO java.lang.String
   final String field_3162;
   // $FF: renamed from: xJ int
   final int field_3163;

   ParcelableEvent(int var1, String var2, String var3, boolean var4, String var5, String var6, TextInsertedDetails var7, TextDeletedDetails var8, ValuesAddedDetails var9, ValuesRemovedDetails var10, ValuesSetDetails var11, ValueChangedDetails var12, ReferenceShiftedDetails var13) {
      this.field_3163 = var1;
      this.field_3162 = var2;
      this.field_3151 = var3;
      this.field_3153 = var4;
      this.field_3152 = var5;
      this.field_3154 = var6;
      this.field_3155 = var7;
      this.field_3156 = var8;
      this.field_3157 = var9;
      this.field_3158 = var10;
      this.field_3159 = var11;
      this.field_3160 = var12;
      this.field_3161 = var13;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_259.method_1810(this, var1, var2);
   }
}
