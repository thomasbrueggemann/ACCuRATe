package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_291;
import com.google.android.gms.wallet.wobs.b;
import com.google.android.gms.wallet.wobs.class_557;
import com.google.android.gms.wallet.wobs.d;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.wobs.d
public final class class_558 implements SafeParcelable {
   public static final Creator<d> CREATOR = new class_557();
   String akM;
   String akN;
   ArrayList<b> akO;
   // $FF: renamed from: xJ int
   private final int field_2973;

   class_558() {
      this.field_2973 = 1;
      this.akO = class_291.method_1966();
   }

   class_558(int var1, String var2, String var3, ArrayList<b> var4) {
      this.field_2973 = var1;
      this.akM = var2;
      this.akN = var3;
      this.akO = var4;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2973;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_557.method_3143(this, var1, var2);
   }
}
