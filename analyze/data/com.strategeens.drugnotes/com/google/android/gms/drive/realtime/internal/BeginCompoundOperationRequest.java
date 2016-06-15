package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.class_699;

public class BeginCompoundOperationRequest implements SafeParcelable {
   public static final Creator<BeginCompoundOperationRequest> CREATOR = new class_699();
   // $FF: renamed from: CK int
   final int field_4196;
   // $FF: renamed from: SF boolean
   final boolean field_4197;
   // $FF: renamed from: SG boolean
   final boolean field_4198;
   final String mName;

   BeginCompoundOperationRequest(int var1, boolean var2, String var3, boolean var4) {
      this.field_4196 = var1;
      this.field_4197 = var2;
      this.mName = var3;
      this.field_4198 = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_699.method_4004(this, var1, var2);
   }
}
