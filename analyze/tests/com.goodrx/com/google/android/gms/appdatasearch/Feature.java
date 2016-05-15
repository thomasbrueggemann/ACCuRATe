package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appdatasearch.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Feature implements SafeParcelable {
   public static final zze CREATOR = new zze();
   // $FF: renamed from: id int
   public final int field_532;
   final int mVersionCode;
   final Bundle zzTS;

   Feature(int var1, int var2, Bundle var3) {
      this.mVersionCode = var1;
      this.field_532 = var2;
      this.zzTS = var3;
   }

   public int describeContents() {
      zze var10000 = CREATOR;
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze var10000 = CREATOR;
      zze.zza(this, var1, var2);
   }
}
