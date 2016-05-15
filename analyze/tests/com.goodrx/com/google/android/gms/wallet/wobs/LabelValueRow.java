package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wallet.wobs.LabelValue;
import com.google.android.gms.wallet.wobs.zzc;
import java.util.ArrayList;

public final class LabelValueRow implements SafeParcelable {
   public static final Creator<LabelValueRow> CREATOR = new zzc();
   private final int mVersionCode;
   String zzbqF;
   String zzbqG;
   ArrayList<LabelValue> zzbqH;

   LabelValueRow() {
      this.mVersionCode = 1;
      this.zzbqH = zzmn.zzsa();
   }

   LabelValueRow(int var1, String var2, String var3, ArrayList<LabelValue> var4) {
      this.mVersionCode = var1;
      this.zzbqF = var2;
      this.zzbqG = var3;
      this.zzbqH = var4;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
