package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.class_905;

// $FF: renamed from: com.google.android.gms.wearable.internal.k
public class class_254 extends class_251 implements DataItemAsset {
   public class_254(DataHolder var1, int var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1668();
   }

   public String getDataItemKey() {
      return this.getString("asset_key");
   }

   public String getId() {
      return this.getString("asset_id");
   }

   // $FF: renamed from: ro () com.google.android.gms.wearable.DataItemAsset
   public DataItemAsset method_1668() {
      return new class_905(this);
   }
}
