package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.b;
import com.google.android.gms.wallet.wobs.class_657;

// $FF: renamed from: com.google.android.gms.wallet.wobs.b
public final class class_658 implements SafeParcelable {
   public static final Creator<b> CREATOR = new class_657();
   // $FF: renamed from: CK int
   private final int field_2866;
   String label;
   String value;

   class_658() {
      this.field_2866 = 1;
   }

   class_658(int var1, String var2, String var3) {
      this.field_2866 = var1;
      this.label = var2;
      this.value = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2866;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_657.method_3768(this, var1, var2);
   }
}
