package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_653;
import com.google.android.gms.wallet.wobs.class_655;
import com.google.android.gms.wallet.wobs.class_668;
import com.google.android.gms.wallet.wobs.f;

// $FF: renamed from: com.google.android.gms.wallet.wobs.f
public final class class_654 implements SafeParcelable {
   public static final Creator<f> CREATOR = new class_655();
   // $FF: renamed from: CK int
   private final int field_2865;
   class_668 avm;
   class_653 awM;
   String label;
   String type;

   class_654() {
      this.field_2865 = 1;
   }

   class_654(int var1, String var2, class_653 var3, String var4, class_668 var5) {
      this.field_2865 = var1;
      this.label = var2;
      this.awM = var3;
      this.type = var4;
      this.avm = var5;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2865;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_655.method_3762(this, var1, var2);
   }
}
