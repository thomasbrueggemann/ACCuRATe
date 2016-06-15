package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_789;

public class OnListParentsResponse implements SafeParcelable {
   public static final Creator<OnListParentsResponse> CREATOR = new class_789();
   // $FF: renamed from: Jy com.google.android.gms.common.data.DataHolder
   final DataHolder field_3227;
   // $FF: renamed from: xJ int
   final int field_3228;

   OnListParentsResponse(int var1, DataHolder var2) {
      this.field_3228 = var1;
      this.field_3227 = var2;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: gv () com.google.android.gms.common.data.DataHolder
   public DataHolder method_3449() {
      return this.field_3227;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_789.method_4404(this, var1, var2);
   }
}
