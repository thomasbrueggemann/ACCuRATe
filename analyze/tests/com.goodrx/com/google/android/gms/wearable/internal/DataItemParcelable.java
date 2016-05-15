package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import com.google.android.gms.wearable.internal.zzae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DataItemParcelable implements SafeParcelable, DataItem {
   public static final Creator<DataItemParcelable> CREATOR = new zzae();
   private final Uri mUri;
   final int mVersionCode;
   private byte[] zzaKm;
   private final Map<String, DataItemAsset> zzbsy;

   DataItemParcelable(int var1, Uri var2, Bundle var3, byte[] var4) {
      this.mVersionCode = var1;
      this.mUri = var2;
      HashMap var5 = new HashMap();
      var3.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
      Iterator var6 = var3.keySet().iterator();

      while(var6.hasNext()) {
         String var7 = (String)var6.next();
         var5.put(var7, (DataItemAssetParcelable)var3.getParcelable(var7));
      }

      this.zzbsy = var5;
      this.zzaKm = var4;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzIN();
   }

   public byte[] getData() {
      return this.zzaKm;
   }

   public Uri getUri() {
      return this.mUri;
   }

   public String toString() {
      return this.toString(Log.isLoggable("DataItem", 3));
   }

   public String toString(boolean var1) {
      StringBuilder var2 = new StringBuilder("DataItemParcelable[");
      var2.append("@");
      var2.append(Integer.toHexString(this.hashCode()));
      StringBuilder var5 = (new StringBuilder()).append(",dataSz=");
      Object var6;
      if(this.zzaKm == null) {
         var6 = "null";
      } else {
         var6 = Integer.valueOf(this.zzaKm.length);
      }

      var2.append(var5.append(var6).toString());
      var2.append(", numAssets=" + this.zzbsy.size());
      var2.append(", uri=" + this.mUri);
      if(!var1) {
         var2.append("]");
         return var2.toString();
      } else {
         var2.append("]\n  assets: ");
         Iterator var11 = this.zzbsy.keySet().iterator();

         while(var11.hasNext()) {
            String var13 = (String)var11.next();
            var2.append("\n    " + var13 + ": " + this.zzbsy.get(var13));
         }

         var2.append("\n  ]");
         return var2.toString();
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzae.zza(this, var1, var2);
   }

   public DataItemParcelable zzIN() {
      return this;
   }

   public Bundle zzIv() {
      Bundle var1 = new Bundle();
      var1.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
      Iterator var2 = this.zzbsy.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putParcelable((String)var3.getKey(), new DataItemAssetParcelable((DataItemAsset)var3.getValue()));
      }

      return var1;
   }
}
