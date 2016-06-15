package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.wearable.internal.l
public class class_697 implements DataItem {
   // $FF: renamed from: TC byte[]
   private byte[] field_3699;
   private Map<String, DataItemAsset> alH;
   private Uri mUri;

   public class_697(DataItem var1) {
      this.mUri = var1.getUri();
      this.field_3699 = var1.getData();
      HashMap var2 = new HashMap();
      Iterator var3 = var1.getAssets().entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if(var4.getKey() != null) {
            var2.put(var4.getKey(), ((DataItemAsset)var4.getValue()).freeze());
         }
      }

      this.alH = Collections.unmodifiableMap(var2);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_4023();
   }

   public Map<String, DataItemAsset> getAssets() {
      return this.alH;
   }

   public byte[] getData() {
      return this.field_3699;
   }

   public Uri getUri() {
      return this.mUri;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: nm () com.google.android.gms.wearable.DataItem
   public DataItem method_4023() {
      return this;
   }

   public DataItem setData(byte[] var1) {
      throw new UnsupportedOperationException();
   }

   public String toString() {
      return this.toString(Log.isLoggable("DataItem", 3));
   }

   public String toString(boolean var1) {
      StringBuilder var2 = new StringBuilder("DataItemEntity[");
      var2.append("@");
      var2.append(Integer.toHexString(this.hashCode()));
      StringBuilder var5 = (new StringBuilder()).append(",dataSz=");
      Object var6;
      if(this.field_3699 == null) {
         var6 = "null";
      } else {
         var6 = Integer.valueOf(this.field_3699.length);
      }

      var2.append(var5.append(var6).toString());
      var2.append(", numAssets=" + this.alH.size());
      var2.append(", uri=" + this.mUri);
      if(!var1) {
         var2.append("]");
         return var2.toString();
      } else {
         var2.append("]\n  assets: ");
         Iterator var11 = this.alH.keySet().iterator();

         while(var11.hasNext()) {
            String var13 = (String)var11.next();
            var2.append("\n    " + var13 + ": " + this.alH.get(var13));
         }

         var2.append("\n  ]");
         return var2.toString();
      }
   }
}
