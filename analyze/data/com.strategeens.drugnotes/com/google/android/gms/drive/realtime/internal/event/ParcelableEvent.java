package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;
import com.google.android.gms.drive.realtime.internal.event.class_311;
import java.util.List;

public class ParcelableEvent implements SafeParcelable {
   public static final Creator<ParcelableEvent> CREATOR = new class_311();
   // $FF: renamed from: CK int
   final int field_3117;
   // $FF: renamed from: SJ java.lang.String
   final String field_3118;
   // $FF: renamed from: SM java.lang.String
   final String field_3119;
   // $FF: renamed from: SQ java.util.List
   final List<String> field_3120;
   // $FF: renamed from: SR boolean
   final boolean field_3121;
   // $FF: renamed from: SS java.lang.String
   final String field_3122;
   // $FF: renamed from: ST com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails
   final TextInsertedDetails field_3123;
   // $FF: renamed from: SU com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails
   final TextDeletedDetails field_3124;
   // $FF: renamed from: SV com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails
   final ValuesAddedDetails field_3125;
   // $FF: renamed from: SW com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails
   final ValuesRemovedDetails field_3126;
   // $FF: renamed from: SX com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails
   final ValuesSetDetails field_3127;
   // $FF: renamed from: SY com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails
   final ValueChangedDetails field_3128;
   // $FF: renamed from: SZ com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails
   final ReferenceShiftedDetails field_3129;
   // $FF: renamed from: Ta com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails
   final ObjectChangedDetails field_3130;
   // $FF: renamed from: vZ java.lang.String
   final String field_3131;

   ParcelableEvent(int var1, String var2, String var3, List<String> var4, boolean var5, String var6, String var7, TextInsertedDetails var8, TextDeletedDetails var9, ValuesAddedDetails var10, ValuesRemovedDetails var11, ValuesSetDetails var12, ValueChangedDetails var13, ReferenceShiftedDetails var14, ObjectChangedDetails var15) {
      this.field_3117 = var1;
      this.field_3131 = var2;
      this.field_3118 = var3;
      this.field_3120 = var4;
      this.field_3121 = var5;
      this.field_3119 = var6;
      this.field_3122 = var7;
      this.field_3123 = var8;
      this.field_3124 = var9;
      this.field_3125 = var10;
      this.field_3126 = var11;
      this.field_3127 = var12;
      this.field_3128 = var13;
      this.field_3129 = var14;
      this.field_3130 = var15;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_311.method_2190(this, var1, var2);
   }
}
