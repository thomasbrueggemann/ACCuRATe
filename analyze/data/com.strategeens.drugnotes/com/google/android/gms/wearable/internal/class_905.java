package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

// $FF: renamed from: com.google.android.gms.wearable.internal.i
public class class_905 implements DataItemAsset {
   // $FF: renamed from: CE java.lang.String
   private final String field_3828;
   // $FF: renamed from: KP java.lang.String
   private final String field_3829;

   public class_905(DataItemAsset var1) {
      this.field_3828 = var1.getId();
      this.field_3829 = var1.getDataItemKey();
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_5054();
   }

   public String getDataItemKey() {
      return this.field_3829;
   }

   public String getId() {
      return this.field_3828;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: ro () com.google.android.gms.wearable.DataItemAsset
   public DataItemAsset method_5054() {
      return this;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DataItemAssetEntity[");
      var1.append("@");
      var1.append(Integer.toHexString(this.hashCode()));
      if(this.field_3828 == null) {
         var1.append(",noid");
      } else {
         var1.append(",");
         var1.append(this.field_3828);
      }

      var1.append(", key=");
      var1.append(this.field_3829);
      var1.append("]");
      return var1.toString();
   }
}
