package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.class_223;

public class CloseContentsRequest implements SafeParcelable {
   public static final Creator<CloseContentsRequest> CREATOR = new class_223();
   // $FF: renamed from: It com.google.android.gms.drive.Contents
   final Contents field_3839;
   // $FF: renamed from: Iw java.lang.Boolean
   final Boolean field_3840;
   // $FF: renamed from: xJ int
   final int field_3841;

   CloseContentsRequest(int var1, Contents var2, Boolean var3) {
      this.field_3841 = var1;
      this.field_3839 = var2;
      this.field_3840 = var3;
   }

   public CloseContentsRequest(Contents var1, boolean var2) {
      this(1, var1, Boolean.valueOf(var2));
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_223.method_1396(this, var1, var2);
   }
}
