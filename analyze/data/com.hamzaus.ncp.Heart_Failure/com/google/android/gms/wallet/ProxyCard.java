package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_728;

public final class ProxyCard implements SafeParcelable {
   public static final Creator<ProxyCard> CREATOR = new class_728();
   String ajS;
   String ajT;
   int ajU;
   int ajV;
   // $FF: renamed from: xJ int
   private final int field_2991;

   ProxyCard(int var1, String var2, String var3, int var4, int var5) {
      this.field_2991 = var1;
      this.ajS = var2;
      this.ajT = var3;
      this.ajU = var4;
      this.ajV = var5;
   }

   public int describeContents() {
      return 0;
   }

   public String getCvn() {
      return this.ajT;
   }

   public int getExpirationMonth() {
      return this.ajU;
   }

   public int getExpirationYear() {
      return this.ajV;
   }

   public String getPan() {
      return this.ajS;
   }

   public int getVersionCode() {
      return this.field_2991;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_728.method_4116(this, var1, var2);
   }
}
