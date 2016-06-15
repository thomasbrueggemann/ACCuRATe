package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_947;

public final class ProxyCard implements SafeParcelable {
   public static final Creator<ProxyCard> CREATOR = new class_947();
   // $FF: renamed from: CK int
   private final int field_2891;
   String avP;
   String avQ;
   int avR;
   int avS;

   ProxyCard(int var1, String var2, String var3, int var4, int var5) {
      this.field_2891 = var1;
      this.avP = var2;
      this.avQ = var3;
      this.avR = var4;
      this.avS = var5;
   }

   public int describeContents() {
      return 0;
   }

   public String getCvn() {
      return this.avQ;
   }

   public int getExpirationMonth() {
      return this.avR;
   }

   public int getExpirationYear() {
      return this.avS;
   }

   public String getPan() {
      return this.avP;
   }

   public int getVersionCode() {
      return this.field_2891;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_947.method_5227(this, var1, var2);
   }
}
