package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;

public class DataMapItem {
   private final DataMap axh;
   private final Uri mUri;

   private DataMapItem(DataItem var1) {
      this.mUri = var1.getUri();
      this.axh = this.method_5302((DataItem)var1.freeze());
   }

   // $FF: renamed from: a (com.google.android.gms.wearable.DataItem) com.google.android.gms.wearable.DataMap
   private DataMap method_5302(DataItem param1) {
      // $FF: Couldn't be decompiled
   }

   public static DataMapItem fromDataItem(DataItem var0) {
      if(var0 == null) {
         throw new IllegalStateException("provided dataItem is null");
      } else {
         return new DataMapItem(var0);
      }
   }

   public DataMap getDataMap() {
      return this.axh;
   }

   public Uri getUri() {
      return this.mUri;
   }
}
