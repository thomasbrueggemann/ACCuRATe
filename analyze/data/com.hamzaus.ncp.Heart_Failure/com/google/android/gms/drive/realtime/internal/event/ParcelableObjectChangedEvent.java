package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.class_258;

public class ParcelableObjectChangedEvent implements SafeParcelable {
   public static final Creator<ParcelableObjectChangedEvent> CREATOR = new class_258();
   // $FF: renamed from: LC int
   final int field_2666;
   // $FF: renamed from: LD int
   final int field_2667;
   // $FF: renamed from: Lj java.lang.String
   final String field_2668;
   // $FF: renamed from: Ln java.lang.String
   final String field_2669;
   // $FF: renamed from: Lp boolean
   final boolean field_2670;
   // $FF: renamed from: Lq java.lang.String
   final String field_2671;
   // $FF: renamed from: rO java.lang.String
   final String field_2672;
   // $FF: renamed from: xJ int
   final int field_2673;

   ParcelableObjectChangedEvent(int var1, String var2, String var3, boolean var4, String var5, String var6, int var7, int var8) {
      this.field_2672 = var2;
      this.field_2668 = var3;
      this.field_2670 = var4;
      this.field_2669 = var5;
      this.field_2671 = var6;
      this.field_2673 = var1;
      this.field_2666 = var7;
      this.field_2667 = var8;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_258.method_1807(this, var1, var2);
   }
}
