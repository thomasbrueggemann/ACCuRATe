package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.class_254;
import com.google.android.gms.wearable.internal.class_909;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.wearable.internal.o
public final class class_253 extends class_251 implements DataItem {
   // $FF: renamed from: Ya int
   private final int field_531;

   public class_253(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.field_531 = var3;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1667();
   }

   public Map<String, DataItemAsset> getAssets() {
      HashMap var1 = new HashMap(this.field_531);

      for(int var2 = 0; var2 < this.field_531; ++var2) {
         class_254 var3 = new class_254(this.JG, var2 + this.KZ);
         if(var3.getDataItemKey() != null) {
            var1.put(var3.getDataItemKey(), var3);
         }
      }

      return var1;
   }

   public byte[] getData() {
      return this.getByteArray("data");
   }

   public Uri getUri() {
      return Uri.parse(this.getString("path"));
   }

   // $FF: renamed from: rp () com.google.android.gms.wearable.DataItem
   public DataItem method_1667() {
      return new class_909(this);
   }

   public DataItem setData(byte[] var1) {
      throw new UnsupportedOperationException();
   }
}
