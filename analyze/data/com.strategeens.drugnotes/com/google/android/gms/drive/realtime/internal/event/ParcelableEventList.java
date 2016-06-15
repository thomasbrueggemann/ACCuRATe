package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.class_312;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
   public static final Creator<ParcelableEventList> CREATOR = new class_312();
   // $FF: renamed from: CK int
   final int field_2974;
   // $FF: renamed from: Tb com.google.android.gms.common.data.DataHolder
   final DataHolder field_2975;
   // $FF: renamed from: Tc boolean
   final boolean field_2976;
   // $FF: renamed from: Td java.util.List
   final List<String> field_2977;
   // $FF: renamed from: mp java.util.List
   final List<ParcelableEvent> field_2978;

   ParcelableEventList(int var1, List<ParcelableEvent> var2, DataHolder var3, boolean var4, List<String> var5) {
      this.field_2974 = var1;
      this.field_2978 = var2;
      this.field_2975 = var3;
      this.field_2976 = var4;
      this.field_2977 = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_312.method_2193(this, var1, var2);
   }
}
