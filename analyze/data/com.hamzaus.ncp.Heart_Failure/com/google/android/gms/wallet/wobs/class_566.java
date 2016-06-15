package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_567;
import com.google.android.gms.wallet.wobs.l;

// $FF: renamed from: com.google.android.gms.wallet.wobs.l
public final class class_566 implements SafeParcelable {
   public static final Creator<l> CREATOR = new class_567();
   long akX;
   long akY;
   // $FF: renamed from: xJ int
   private final int field_2979;

   class_566() {
      this.field_2979 = 1;
   }

   class_566(int var1, long var2, long var4) {
      this.field_2979 = var1;
      this.akX = var2;
      this.akY = var4;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2979;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_567.method_3160(this, var1, var2);
   }
}
