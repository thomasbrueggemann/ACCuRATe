package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_560;
import com.google.android.gms.wallet.wobs.class_563;
import com.google.android.gms.wallet.wobs.class_566;
import com.google.android.gms.wallet.wobs.p;

// $FF: renamed from: com.google.android.gms.wallet.wobs.p
public final class class_562 implements SafeParcelable {
   public static final Creator<p> CREATOR = new class_563();
   String akW;
   class_566 ala;
   class_560 alb;
   class_560 alc;
   // $FF: renamed from: qb java.lang.String
   String field_2975;
   // $FF: renamed from: xJ int
   private final int field_2976;

   class_562() {
      this.field_2976 = 1;
   }

   class_562(int var1, String var2, String var3, class_566 var4, class_560 var5, class_560 var6) {
      this.field_2976 = var1;
      this.akW = var2;
      this.field_2975 = var3;
      this.ala = var4;
      this.alb = var5;
      this.alc = var6;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2976;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_563.method_3154(this, var1, var2);
   }
}
