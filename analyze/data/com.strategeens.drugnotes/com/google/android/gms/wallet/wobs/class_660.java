package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_724;
import com.google.android.gms.wallet.wobs.b;
import com.google.android.gms.wallet.wobs.class_659;
import com.google.android.gms.wallet.wobs.d;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wallet.wobs.d
public final class class_660 implements SafeParcelable {
   public static final Creator<d> CREATOR = new class_659();
   // $FF: renamed from: CK int
   private final int field_2867;
   String awJ;
   String awK;
   ArrayList<b> awL;

   class_660() {
      this.field_2867 = 1;
      this.awL = class_724.method_4217();
   }

   class_660(int var1, String var2, String var3, ArrayList<b> var4) {
      this.field_2867 = var1;
      this.awJ = var2;
      this.awK = var3;
      this.awL = var4;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2867;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_659.method_3771(this, var1, var2);
   }
}
