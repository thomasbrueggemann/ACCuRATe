package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.class_698;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
   public static final Creator<DataItemAssetParcelable> CREATOR = new class_698();
   // $FF: renamed from: JI java.lang.String
   private final String field_3596;
   // $FF: renamed from: xD java.lang.String
   private final String field_3597;
   // $FF: renamed from: xJ int
   final int field_3598;

   DataItemAssetParcelable(int var1, String var2, String var3) {
      this.field_3598 = var1;
      this.field_3597 = var2;
      this.field_3596 = var3;
   }

   public DataItemAssetParcelable(DataItemAsset var1) {
      this.field_3598 = 1;
      this.field_3597 = (String)class_347.method_2170(var1.getId());
      this.field_3596 = (String)class_347.method_2170(var1.getDataItemKey());
   }

   public int describeContents() {
      return 0;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_3922();
   }

   public String getDataItemKey() {
      return this.field_3596;
   }

   public String getId() {
      return this.field_3597;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: nl () com.google.android.gms.wearable.DataItemAsset
   public DataItemAsset method_3922() {
      return this;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DataItemAssetParcelable[");
      var1.append("@");
      var1.append(Integer.toHexString(this.hashCode()));
      if(this.field_3597 == null) {
         var1.append(",noid");
      } else {
         var1.append(",");
         var1.append(this.field_3597);
      }

      var1.append(", key=");
      var1.append(this.field_3596);
      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_698.method_4024(this, var1, var2);
   }
}
