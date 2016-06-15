package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_656;
import com.google.android.gms.wallet.wobs.g;

// $FF: renamed from: com.google.android.gms.wallet.wobs.g
public final class class_653 implements SafeParcelable {
   public static final Creator<g> CREATOR = new class_656();
   // $FF: renamed from: CK int
   private final int field_2864;
   int awN;
   String awO;
   double awP;
   String awQ;
   long awR;
   int awS;

   class_653() {
      this.field_2864 = 1;
      this.awS = -1;
      this.awN = -1;
      this.awP = -1.0D;
   }

   class_653(int var1, int var2, String var3, double var4, String var6, long var7, int var9) {
      this.field_2864 = var1;
      this.awN = var2;
      this.awO = var3;
      this.awP = var4;
      this.awQ = var6;
      this.awR = var7;
      this.awS = var9;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2864;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_656.method_3765(this, var1, var2);
   }
}
