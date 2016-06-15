package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.class_208;
import com.google.android.gms.wearable.internal.class_697;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.wearable.internal.o
public final class class_207 extends class_206 implements DataItem {
   // $FF: renamed from: RD int
   private final int field_689;

   public class_207(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.field_689 = var3;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1360();
   }

   public Map<String, DataItemAsset> getAssets() {
      HashMap var1 = new HashMap(this.field_689);

      for(int var2 = 0; var2 < this.field_689; ++var2) {
         class_208 var3 = new class_208(this.DD, var2 + this.Ez);
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

   // $FF: renamed from: nm () com.google.android.gms.wearable.DataItem
   public DataItem method_1360() {
      return new class_697(this);
   }

   public DataItem setData(byte[] var1) {
      throw new UnsupportedOperationException();
   }
}
