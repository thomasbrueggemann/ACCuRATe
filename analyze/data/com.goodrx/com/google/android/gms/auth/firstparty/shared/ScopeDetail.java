package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.auth.firstparty.shared.FACLData;
import com.google.android.gms.auth.firstparty.shared.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ScopeDetail implements SafeParcelable {
   public static final zzc CREATOR = new zzc();
   String description;
   final int version;
   List<String> zzYA;
   public FACLData zzYB;
   String zzYw;
   String zzYx;
   String zzYy;
   String zzYz;

   ScopeDetail(int var1, String var2, String var3, String var4, String var5, String var6, List<String> var7, FACLData var8) {
      this.version = var1;
      this.description = var2;
      this.zzYw = var3;
      this.zzYx = var4;
      this.zzYy = var5;
      this.zzYz = var6;
      this.zzYA = var7;
      this.zzYB = var8;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
