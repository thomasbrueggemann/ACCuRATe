package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.class_693;

// $FF: renamed from: com.google.android.gms.wearable.internal.k
public class class_208 extends class_206 implements DataItemAsset {
   public class_208(DataHolder var1, int var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1361();
   }

   public String getDataItemKey() {
      return this.getString("asset_key");
   }

   public String getId() {
      return this.getString("asset_id");
   }

   // $FF: renamed from: nl () com.google.android.gms.wearable.DataItemAsset
   public DataItemAsset method_1361() {
      return new class_693(this);
   }
}
