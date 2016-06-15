package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.class_273;

public class CloseContentsRequest implements SafeParcelable {
   public static final Creator<CloseContentsRequest> CREATOR = new class_273();
   // $FF: renamed from: CK int
   final int field_3927;
   // $FF: renamed from: Pr com.google.android.gms.drive.Contents
   final Contents field_3928;
   // $FF: renamed from: Pt java.lang.Boolean
   final Boolean field_3929;

   CloseContentsRequest(int var1, Contents var2, Boolean var3) {
      this.field_3927 = var1;
      this.field_3928 = var2;
      this.field_3929 = var3;
   }

   public CloseContentsRequest(Contents var1, boolean var2) {
      this(1, var1, Boolean.valueOf(var2));
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_273.method_1738(this, var1, var2);
   }
}
