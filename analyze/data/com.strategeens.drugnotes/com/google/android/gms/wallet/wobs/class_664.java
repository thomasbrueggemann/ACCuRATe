package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_662;
import com.google.android.gms.wallet.wobs.class_665;
import com.google.android.gms.wallet.wobs.class_668;
import com.google.android.gms.wallet.wobs.p;

// $FF: renamed from: com.google.android.gms.wallet.wobs.p
public final class class_664 implements SafeParcelable {
   public static final Creator<p> CREATOR = new class_665();
   // $FF: renamed from: CK int
   private final int field_2878;
   String awT;
   class_668 awX;
   class_662 awY;
   class_662 awZ;
   // $FF: renamed from: tU java.lang.String
   String field_2879;

   class_664() {
      this.field_2878 = 1;
   }

   class_664(int var1, String var2, String var3, class_668 var4, class_662 var5, class_662 var6) {
      this.field_2878 = var1;
      this.awT = var2;
      this.field_2879 = var3;
      this.awX = var4;
      this.awY = var5;
      this.awZ = var6;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2878;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_665.method_3789(this, var1, var2);
   }
}
