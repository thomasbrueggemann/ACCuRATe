package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_581;

public class StorageStats implements SafeParcelable {
   public static final Creator<StorageStats> CREATOR = new class_581();
   // $FF: renamed from: HY long
   final long field_2964;
   // $FF: renamed from: HZ long
   final long field_2965;
   // $FF: renamed from: Ia long
   final long field_2966;
   // $FF: renamed from: Ib long
   final long field_2967;
   // $FF: renamed from: Ic int
   final int field_2968;
   // $FF: renamed from: xJ int
   final int field_2969;

   StorageStats(int var1, long var2, long var4, long var6, long var8, int var10) {
      this.field_2969 = var1;
      this.field_2964 = var2;
      this.field_2965 = var4;
      this.field_2966 = var6;
      this.field_2967 = var8;
      this.field_2968 = var10;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_581.method_3258(this, var1, var2);
   }
}
