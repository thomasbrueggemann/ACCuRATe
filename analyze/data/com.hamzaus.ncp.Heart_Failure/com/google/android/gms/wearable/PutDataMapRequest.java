package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_607;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.PutDataRequest;

public class PutDataMapRequest {
   private final DataMap ali;
   private final PutDataRequest alj;

   private PutDataMapRequest(PutDataRequest var1, DataMap var2) {
      this.alj = var1;
      this.ali = new DataMap();
      if(var2 != null) {
         this.ali.putAll(var2);
      }

   }

   public static PutDataMapRequest create(String var0) {
      return new PutDataMapRequest(PutDataRequest.create(var0), (DataMap)null);
   }

   public static PutDataMapRequest createFromDataMapItem(DataMapItem var0) {
      return new PutDataMapRequest(PutDataRequest.method_1338(var0.getUri()), var0.getDataMap());
   }

   public static PutDataMapRequest createWithAutoAppendedId(String var0) {
      return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(var0), (DataMap)null);
   }

   public PutDataRequest asPutDataRequest() {
      class_607.class_831 var1 = class_607.method_3577(this.ali);
      this.alj.setData(class_246.method_1720(var1.amm));
      int var3 = var1.amn.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = Integer.toString(var4);
         Asset var6 = (Asset)var1.amn.get(var4);
         if(var5 == null) {
            throw new IllegalStateException("asset key cannot be null: " + var6);
         }

         if(var6 == null) {
            throw new IllegalStateException("asset cannot be null: key=" + var5);
         }

         if(Log.isLoggable("DataMap", 3)) {
            Log.d("DataMap", "asPutDataRequest: adding asset: " + var5 + " " + var6);
         }

         this.alj.putAsset(var5, var6);
      }

      return this.alj;
   }

   public DataMap getDataMap() {
      return this.ali;
   }

   public Uri getUri() {
      return this.alj.getUri();
   }
}
