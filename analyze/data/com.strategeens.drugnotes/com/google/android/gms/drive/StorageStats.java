package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_685;

public class StorageStats implements SafeParcelable {
   public static final Creator<StorageStats> CREATOR = new class_685();
   // $FF: renamed from: CK int
   final int field_2858;
   // $FF: renamed from: OM long
   final long field_2859;
   // $FF: renamed from: ON long
   final long field_2860;
   // $FF: renamed from: OO long
   final long field_2861;
   // $FF: renamed from: OP long
   final long field_2862;
   // $FF: renamed from: OQ int
   final int field_2863;

   StorageStats(int var1, long var2, long var4, long var6, long var8, int var10) {
      this.field_2858 = var1;
      this.field_2859 = var2;
      this.field_2860 = var4;
      this.field_2861 = var6;
      this.field_2862 = var8;
      this.field_2863 = var10;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_685.method_3871(this, var1, var2);
   }
}
