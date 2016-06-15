package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_939;

public final class InstrumentInfo implements SafeParcelable {
   public static final Creator<InstrumentInfo> CREATOR = new class_939();
   // $FF: renamed from: CK int
   private final int field_3582;
   private String auX;
   private String auY;

   InstrumentInfo(int var1, String var2, String var3) {
      this.field_3582 = var1;
      this.auX = var2;
      this.auY = var3;
   }

   public int describeContents() {
      return 0;
   }

   public String getInstrumentDetails() {
      return this.auY;
   }

   public String getInstrumentType() {
      return this.auX;
   }

   public int getVersionCode() {
      return this.field_3582;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_939.method_5201(this, var1, var2);
   }
}
