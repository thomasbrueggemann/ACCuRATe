package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_777;

public class TrashResourceRequest implements SafeParcelable {
   public static final Creator<TrashResourceRequest> CREATOR = new class_777();
   // $FF: renamed from: Ir com.google.android.gms.drive.DriveId
   final DriveId field_4209;
   // $FF: renamed from: xJ int
   final int field_4210;

   TrashResourceRequest(int var1, DriveId var2) {
      this.field_4210 = var1;
      this.field_4209 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_777.method_4368(this, var1, var2);
   }
}
