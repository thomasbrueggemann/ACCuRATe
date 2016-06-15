package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_274;
import com.google.android.gms.internal.class_335;

public class CreateContentsRequest implements SafeParcelable {
   public static final Creator<CreateContentsRequest> CREATOR = new class_274();
   // $FF: renamed from: CK int
   final int field_4180;
   // $FF: renamed from: Oi int
   final int field_4181;

   public CreateContentsRequest(int var1) {
      this(1, var1);
   }

   CreateContentsRequest(int var1, int var2) {
      this.field_4180 = var1;
      boolean var3;
      if(var2 != 536870912 && var2 != 805306368) {
         var3 = false;
      } else {
         var3 = true;
      }

      class_335.method_2308(var3, "Cannot create a new read-only contents!");
      this.field_4181 = var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_274.method_1741(this, var1, var2);
   }
}
