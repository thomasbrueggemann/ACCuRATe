package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

// $FF: renamed from: com.google.android.gms.wearable.internal.i
public class class_693 implements DataItemAsset {
   // $FF: renamed from: JI java.lang.String
   private final String field_3692;
   // $FF: renamed from: xD java.lang.String
   private final String field_3693;

   public class_693(DataItemAsset var1) {
      this.field_3693 = var1.getId();
      this.field_3692 = var1.getDataItemKey();
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_4015();
   }

   public String getDataItemKey() {
      return this.field_3692;
   }

   public String getId() {
      return this.field_3693;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: nl () com.google.android.gms.wearable.DataItemAsset
   public DataItemAsset method_4015() {
      return this;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DataItemAssetEntity[");
      var1.append("@");
      var1.append(Integer.toHexString(this.hashCode()));
      if(this.field_3693 == null) {
         var1.append(",noid");
      } else {
         var1.append(",");
         var1.append(this.field_3693);
      }

      var1.append(", key=");
      var1.append(this.field_3692);
      var1.append("]");
      return var1.toString();
   }
}
