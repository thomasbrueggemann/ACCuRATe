package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.class_910;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
   public static final Creator<DataItemAssetParcelable> CREATOR = new class_910();
   // $FF: renamed from: CE java.lang.String
   private final String field_3734;
   // $FF: renamed from: CK int
   final int field_3735;
   // $FF: renamed from: KP java.lang.String
   private final String field_3736;

   DataItemAssetParcelable(int var1, String var2, String var3) {
      this.field_3735 = var1;
      this.field_3734 = var2;
      this.field_3736 = var3;
   }

   public DataItemAssetParcelable(DataItemAsset var1) {
      this.field_3735 = 1;
      this.field_3734 = (String)class_335.method_2311(var1.getId());
      this.field_3736 = (String)class_335.method_2311(var1.getDataItemKey());
   }

   public int describeContents() {
      return 0;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_4899();
   }

   public String getDataItemKey() {
      return this.field_3736;
   }

   public String getId() {
      return this.field_3734;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: ro () com.google.android.gms.wearable.DataItemAsset
   public DataItemAsset method_4899() {
      return this;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DataItemAssetParcelable[");
      var1.append("@");
      var1.append(Integer.toHexString(this.hashCode()));
      if(this.field_3734 == null) {
         var1.append(",noid");
      } else {
         var1.append(",");
         var1.append(this.field_3734);
      }

      var1.append(", key=");
      var1.append(this.field_3736);
      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_910.method_5063(this, var1, var2);
   }
}
