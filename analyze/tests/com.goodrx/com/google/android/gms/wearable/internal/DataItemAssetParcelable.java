package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.zzab;

@KeepName
public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
   public static final Creator<DataItemAssetParcelable> CREATOR = new zzab();
   final int mVersionCode;
   private final String zzvs;
   private final String zzyv;

   DataItemAssetParcelable(int var1, String var2, String var3) {
      this.mVersionCode = var1;
      this.zzyv = var2;
      this.zzvs = var3;
   }

   public DataItemAssetParcelable(DataItemAsset var1) {
      this.mVersionCode = 1;
      this.zzyv = (String)zzx.zzz(var1.getId());
      this.zzvs = (String)zzx.zzz(var1.getDataItemKey());
   }

   public int describeContents() {
      return 0;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzIL();
   }

   public String getDataItemKey() {
      return this.zzvs;
   }

   public String getId() {
      return this.zzyv;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DataItemAssetParcelable[");
      var1.append("@");
      var1.append(Integer.toHexString(this.hashCode()));
      if(this.zzyv == null) {
         var1.append(",noid");
      } else {
         var1.append(",");
         var1.append(this.zzyv);
      }

      var1.append(", key=");
      var1.append(this.zzvs);
      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzab.zza(this, var1, var2);
   }

   public DataItemAsset zzIL() {
      return this;
   }
}
