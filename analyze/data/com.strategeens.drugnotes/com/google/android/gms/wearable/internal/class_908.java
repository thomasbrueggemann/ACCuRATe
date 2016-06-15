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
import com.google.android.gms.wearable.internal.class_913;
import com.google.android.gms.wearable.internal.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.wearable.internal.m
public class class_908 implements SafeParcelable, DataItem {
   public static final Creator<m> CREATOR = new class_913();
   // $FF: renamed from: CK int
   final int field_3831;
   private byte[] aeA;
   private final Map<String, DataItemAsset> axH;
   private final Uri mUri;

   class_908(int var1, Uri var2, Bundle var3, byte[] var4) {
      this.field_3831 = var1;
      this.mUri = var2;
      HashMap var5 = new HashMap();
      var3.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
      Iterator var6 = var3.keySet().iterator();

      while(var6.hasNext()) {
         String var7 = (String)var6.next();
         var5.put(var7, (DataItemAssetParcelable)var3.getParcelable(var7));
      }

      this.axH = var5;
      this.aeA = var4;
   }

   public int describeContents() {
      return 0;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_5061();
   }

   public Map<String, DataItemAsset> getAssets() {
      return this.axH;
   }

   public byte[] getData() {
      return this.aeA;
   }

   public Uri getUri() {
      return this.mUri;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: m (byte[]) com.google.android.gms.wearable.internal.m
   public class_908 method_5059(byte[] var1) {
      this.aeA = var1;
      return this;
   }

   // $FF: renamed from: rk () android.os.Bundle
   public Bundle method_5060() {
      Bundle var1 = new Bundle();
      var1.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
      Iterator var2 = this.axH.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putParcelable((String)var3.getKey(), new DataItemAssetParcelable((DataItemAsset)var3.getValue()));
      }

      return var1;
   }

   // $FF: renamed from: rq () com.google.android.gms.wearable.internal.m
   public class_908 method_5061() {
      return this;
   }

   // $FF: synthetic method
   public DataItem setData(byte[] var1) {
      return this.method_5059(var1);
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
      if(this.aeA == null) {
         var6 = "null";
      } else {
         var6 = Integer.valueOf(this.aeA.length);
      }

      var2.append(var5.append(var6).toString());
      var2.append(", numAssets=" + this.axH.size());
      var2.append(", uri=" + this.mUri);
      if(!var1) {
         var2.append("]");
         return var2.toString();
      } else {
         var2.append("]\n  assets: ");
         Iterator var11 = this.axH.keySet().iterator();

         while(var11.hasNext()) {
            String var13 = (String)var11.next();
            var2.append("\n    " + var13 + ": " + this.axH.get(var13));
         }

         var2.append("\n  ]");
         return var2.toString();
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_913.method_5076(this, var1, var2);
   }
}
