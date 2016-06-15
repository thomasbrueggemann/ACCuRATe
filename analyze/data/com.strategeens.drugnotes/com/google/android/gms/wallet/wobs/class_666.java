package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_667;
import com.google.android.gms.wallet.wobs.j;

// $FF: renamed from: com.google.android.gms.wallet.wobs.j
public final class class_666 implements SafeParcelable {
   public static final Creator<j> CREATOR = new class_667();
   // $FF: renamed from: CK int
   private final int field_2880;
   String awT;
   // $FF: renamed from: tU java.lang.String
   String field_2881;

   class_666() {
      this.field_2880 = 1;
   }

   class_666(int var1, String var2, String var3) {
      this.field_2880 = var1;
      this.awT = var2;
      this.field_2881 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2880;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_667.method_3792(this, var1, var2);
   }
}
