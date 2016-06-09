package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Scope implements SafeParcelable {
   public static final Creator<Scope> CREATOR = new zzb();
   final int mVersionCode;
   private final String zzagB;

   Scope(int var1, String var2) {
      zzx.zzh(var2, "scopeUri must not be null or empty");
      this.mVersionCode = var1;
      this.zzagB = var2;
   }

   public Scope(String var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Scope)?false:this.zzagB.equals(((Scope)var1).zzagB));
   }

   public int hashCode() {
      return this.zzagB.hashCode();
   }

   public String toString() {
      return this.zzagB;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   public String zzpb() {
      return this.zzagB;
   }
}
