package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_823;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.PutDataRequest;

public class PutDataMapRequest {
   private final DataMap axh;
   private final PutDataRequest axi;

   private PutDataMapRequest(PutDataRequest var1, DataMap var2) {
      this.axi = var1;
      this.axh = new DataMap();
      if(var2 != null) {
         this.axh.putAll(var2);
      }

   }

   public static PutDataMapRequest create(String var0) {
      return new PutDataMapRequest(PutDataRequest.create(var0), (DataMap)null);
   }

   public static PutDataMapRequest createFromDataMapItem(DataMapItem var0) {
      return new PutDataMapRequest(PutDataRequest.method_1640(var0.getUri()), var0.getDataMap());
   }

   public static PutDataMapRequest createWithAutoAppendedId(String var0) {
      return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(var0), (DataMap)null);
   }

   public PutDataRequest asPutDataRequest() {
      class_823.class_1548 var1 = class_823.method_4491(this.axh);
      this.axi.setData(class_300.method_2088(var1.ayo));
      int var3 = var1.ayp.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = Integer.toString(var4);
         Asset var6 = (Asset)var1.ayp.get(var4);
         if(var5 == null) {
            throw new IllegalStateException("asset key cannot be null: " + var6);
         }

         if(var6 == null) {
            throw new IllegalStateException("asset cannot be null: key=" + var5);
         }

         if(Log.isLoggable("DataMap", 3)) {
            Log.d("DataMap", "asPutDataRequest: adding asset: " + var5 + " " + var6);
         }

         this.axi.putAsset(var5, var6);
      }

      return this.axi;
   }

   public DataMap getDataMap() {
      return this.axh;
   }

   public Uri getUri() {
      return this.axi.getUri();
   }
}
