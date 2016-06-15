package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.class_964;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class PutDataRequest implements SafeParcelable {
   public static final Creator<PutDataRequest> CREATOR = new class_964();
   public static final String WEAR_URI_SCHEME = "wear";
   private static final Random axj = new SecureRandom();
   // $FF: renamed from: CK int
   final int field_524;
   private byte[] aeA;
   private final Bundle axk;
   private final Uri mUri;

   private PutDataRequest(int var1, Uri var2) {
      this(var1, var2, new Bundle(), (byte[])null);
   }

   PutDataRequest(int var1, Uri var2, Bundle var3, byte[] var4) {
      this.field_524 = var1;
      this.mUri = var2;
      this.axk = var3;
      this.axk.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
      this.aeA = var4;
   }

   public static PutDataRequest create(String var0) {
      return method_1640(method_1639(var0));
   }

   public static PutDataRequest createFromDataItem(DataItem var0) {
      PutDataRequest var1 = method_1640(var0.getUri());
      Iterator var2 = var0.getAssets().entrySet().iterator();

      while(var2.hasNext()) {
         Entry var4 = (Entry)var2.next();
         if(((DataItemAsset)var4.getValue()).getId() == null) {
            throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + (String)var4.getKey());
         }

         var1.putAsset((String)var4.getKey(), Asset.createFromRef(((DataItemAsset)var4.getValue()).getId()));
      }

      var1.setData(var0.getData());
      return var1;
   }

   public static PutDataRequest createWithAutoAppendedId(String var0) {
      StringBuilder var1 = new StringBuilder(var0);
      if(!var0.endsWith("/")) {
         var1.append("/");
      }

      var1.append("PN").append(axj.nextLong());
      return new PutDataRequest(1, method_1639(var1.toString()));
   }

   // $FF: renamed from: di (java.lang.String) android.net.Uri
   private static Uri method_1639(String var0) {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException("An empty path was supplied.");
      } else if(!var0.startsWith("/")) {
         throw new IllegalArgumentException("A path must start with a single / .");
      } else if(var0.startsWith("//")) {
         throw new IllegalArgumentException("A path must start with a single / .");
      } else {
         return (new Builder()).scheme("wear").path(var0).build();
      }
   }

   // $FF: renamed from: k (android.net.Uri) com.google.android.gms.wearable.PutDataRequest
   public static PutDataRequest method_1640(Uri var0) {
      return new PutDataRequest(1, var0);
   }

   public int describeContents() {
      return 0;
   }

   public Asset getAsset(String var1) {
      return (Asset)this.axk.getParcelable(var1);
   }

   public Map<String, Asset> getAssets() {
      HashMap var1 = new HashMap();
      Iterator var2 = this.axk.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.put(var3, (Asset)this.axk.getParcelable(var3));
      }

      return Collections.unmodifiableMap(var1);
   }

   public byte[] getData() {
      return this.aeA;
   }

   public Uri getUri() {
      return this.mUri;
   }

   public boolean hasAsset(String var1) {
      return this.axk.containsKey(var1);
   }

   public PutDataRequest putAsset(String var1, Asset var2) {
      class_335.method_2311(var1);
      class_335.method_2311(var2);
      this.axk.putParcelable(var1, var2);
      return this;
   }

   public PutDataRequest removeAsset(String var1) {
      this.axk.remove(var1);
      return this;
   }

   // $FF: renamed from: rk () android.os.Bundle
   public Bundle method_1641() {
      return this.axk;
   }

   public PutDataRequest setData(byte[] var1) {
      this.aeA = var1;
      return this;
   }

   public String toString() {
      return this.toString(Log.isLoggable("DataMap", 3));
   }

   public String toString(boolean var1) {
      StringBuilder var2 = new StringBuilder("PutDataRequest[");
      StringBuilder var3 = (new StringBuilder()).append("dataSz=");
      Object var4;
      if(this.aeA == null) {
         var4 = "null";
      } else {
         var4 = Integer.valueOf(this.aeA.length);
      }

      var2.append(var3.append(var4).toString());
      var2.append(", numAssets=" + this.axk.size());
      var2.append(", uri=" + this.mUri);
      if(!var1) {
         var2.append("]");
         return var2.toString();
      } else {
         var2.append("]\n  assets: ");
         Iterator var9 = this.axk.keySet().iterator();

         while(var9.hasNext()) {
            String var11 = (String)var9.next();
            var2.append("\n    " + var11 + ": " + this.axk.getParcelable(var11));
         }

         var2.append("\n  ]");
         return var2.toString();
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_964.method_5370(this, var1, var2);
   }
}
