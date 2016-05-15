package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.zzb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FACLData implements SafeParcelable {
   public static final zzb CREATOR = new zzb();
   final int version;
   FACLConfig zzYs;
   String zzYt;
   boolean zzYu;
   String zzYv;

   FACLData(int var1, FACLConfig var2, String var3, boolean var4, String var5) {
      this.version = var1;
      this.zzYs = var2;
      this.zzYt = var3;
      this.zzYu = var4;
      this.zzYv = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
