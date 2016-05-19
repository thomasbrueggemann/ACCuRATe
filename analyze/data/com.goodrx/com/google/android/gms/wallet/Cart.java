package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.LineItem;
import com.google.android.gms.wallet.zzb;
import java.util.ArrayList;

public final class Cart implements SafeParcelable {
   public static final Creator<Cart> CREATOR = new zzb();
   private final int mVersionCode;
   String zzboh;
   String zzboi;
   ArrayList<LineItem> zzboj;

   Cart() {
      this.mVersionCode = 1;
      this.zzboj = new ArrayList();
   }

   Cart(int var1, String var2, String var3, ArrayList<LineItem> var4) {
      this.mVersionCode = var1;
      this.zzboh = var2;
      this.zzboi = var3;
      this.zzboj = var4;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
