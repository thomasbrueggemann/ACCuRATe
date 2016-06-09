package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzbc;

public class NodeParcelable implements SafeParcelable {
   public static final Creator<NodeParcelable> CREATOR = new zzbc();
   final int mVersionCode;
   private final String zzWQ;
   private final int zzbsY;
   private final boolean zzbsZ;
   private final String zzyv;

   NodeParcelable(int var1, String var2, String var3, int var4, boolean var5) {
      this.mVersionCode = var1;
      this.zzyv = var2;
      this.zzWQ = var3;
      this.zzbsY = var4;
      this.zzbsZ = var5;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return !(var1 instanceof NodeParcelable)?false:((NodeParcelable)var1).zzyv.equals(this.zzyv);
   }

   public String getDisplayName() {
      return this.zzWQ;
   }

   public int getHopCount() {
      return this.zzbsY;
   }

   public String getId() {
      return this.zzyv;
   }

   public int hashCode() {
      return this.zzyv.hashCode();
   }

   public boolean isNearby() {
      return this.zzbsZ;
   }

   public String toString() {
      return "Node{" + this.zzWQ + ", id=" + this.zzyv + ", hops=" + this.zzbsY + ", isNearby=" + this.zzbsZ + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbc.zza(this, var1, var2);
   }
}
