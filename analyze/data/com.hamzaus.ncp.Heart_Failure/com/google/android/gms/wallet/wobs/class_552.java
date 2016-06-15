package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_551;
import com.google.android.gms.wallet.wobs.class_553;
import com.google.android.gms.wallet.wobs.class_566;
import com.google.android.gms.wallet.wobs.f;

// $FF: renamed from: com.google.android.gms.wallet.wobs.f
public final class class_552 implements SafeParcelable {
   public static final Creator<f> CREATOR = new class_553();
   class_566 ajp;
   class_551 akP;
   String label;
   String type;
   // $FF: renamed from: xJ int
   private final int field_2971;

   class_552() {
      this.field_2971 = 1;
   }

   class_552(int var1, String var2, class_551 var3, String var4, class_566 var5) {
      this.field_2971 = var1;
      this.label = var2;
      this.akP = var3;
      this.type = var4;
      this.ajp = var5;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2971;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_553.method_3134(this, var1, var2);
   }
}
