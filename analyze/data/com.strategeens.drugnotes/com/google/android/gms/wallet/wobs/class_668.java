package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_669;
import com.google.android.gms.wallet.wobs.l;

// $FF: renamed from: com.google.android.gms.wallet.wobs.l
public final class class_668 implements SafeParcelable {
   public static final Creator<l> CREATOR = new class_669();
   // $FF: renamed from: CK int
   private final int field_2882;
   long awU;
   long awV;

   class_668() {
      this.field_2882 = 1;
   }

   class_668(int var1, long var2, long var4) {
      this.field_2882 = var1;
      this.awU = var2;
      this.awV = var4;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2882;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_669.method_3795(this, var1, var2);
   }
}
