package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_720;

public final class InstrumentInfo implements SafeParcelable {
   public static final Creator<InstrumentInfo> CREATOR = new class_720();
   private String aiZ;
   private String aja;
   // $FF: renamed from: xJ int
   private final int field_3473;

   InstrumentInfo(int var1, String var2, String var3) {
      this.field_3473 = var1;
      this.aiZ = var2;
      this.aja = var3;
   }

   public int describeContents() {
      return 0;
   }

   public String getInstrumentDetails() {
      return this.aja;
   }

   public String getInstrumentType() {
      return this.aiZ;
   }

   public int getVersionCode() {
      return this.field_3473;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_720.method_4090(this, var1, var2);
   }
}
