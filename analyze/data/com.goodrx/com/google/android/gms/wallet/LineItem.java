package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.zzj;

public final class LineItem implements SafeParcelable {
   public static final Creator<LineItem> CREATOR = new zzj();
   String description;
   private final int mVersionCode;
   String zzboL;
   String zzboM;
   int zzboN;
   String zzboh;
   String zzboi;

   LineItem() {
      this.mVersionCode = 1;
      this.zzboN = 0;
   }

   LineItem(int var1, String var2, String var3, String var4, String var5, int var6, String var7) {
      this.mVersionCode = var1;
      this.description = var2;
      this.zzboL = var3;
      this.zzboM = var4;
      this.zzboh = var5;
      this.zzboN = var6;
      this.zzboi = var7;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }
}
