package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_554;
import com.google.android.gms.wallet.wobs.g;

// $FF: renamed from: com.google.android.gms.wallet.wobs.g
public final class class_551 implements SafeParcelable {
   public static final Creator<g> CREATOR = new class_554();
   int akQ;
   String akR;
   double akS;
   String akT;
   long akU;
   int akV;
   // $FF: renamed from: xJ int
   private final int field_2970;

   class_551() {
      this.field_2970 = 1;
      this.akV = -1;
      this.akQ = -1;
      this.akS = -1.0D;
   }

   class_551(int var1, int var2, String var3, double var4, String var6, long var7, int var9) {
      this.field_2970 = var1;
      this.akQ = var2;
      this.akR = var3;
      this.akS = var4;
      this.akT = var6;
      this.akU = var7;
      this.akV = var9;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2970;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_554.method_3137(this, var1, var2);
   }
}
