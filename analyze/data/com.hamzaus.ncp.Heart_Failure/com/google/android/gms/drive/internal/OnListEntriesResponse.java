package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_790;

public class OnListEntriesResponse implements SafeParcelable {
   public static final Creator<OnListEntriesResponse> CREATOR = new class_790();
   // $FF: renamed from: IM boolean
   final boolean field_2011;
   // $FF: renamed from: Jx com.google.android.gms.common.data.DataHolder
   final DataHolder field_2012;
   // $FF: renamed from: xJ int
   final int field_2013;

   OnListEntriesResponse(int var1, DataHolder var2, boolean var3) {
      this.field_2013 = var1;
      this.field_2012 = var2;
      this.field_2011 = var3;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: gt () com.google.android.gms.common.data.DataHolder
   public DataHolder method_2676() {
      return this.field_2012;
   }

   // $FF: renamed from: gu () boolean
   public boolean method_2677() {
      return this.field_2011;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_790.method_4407(this, var1, var2);
   }
}
