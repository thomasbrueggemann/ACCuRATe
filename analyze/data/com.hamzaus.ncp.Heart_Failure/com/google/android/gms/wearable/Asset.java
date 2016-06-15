package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.wearable.class_742;

public class Asset implements SafeParcelable {
   public static final Creator<Asset> CREATOR = new class_742();
   // $FF: renamed from: TC byte[]
   private byte[] field_4096;
   private String ald;
   public ParcelFileDescriptor ale;
   public Uri uri;
   // $FF: renamed from: xJ int
   final int field_4097;

   Asset(int var1, byte[] var2, String var3, ParcelFileDescriptor var4, Uri var5) {
      this.field_4097 = var1;
      this.field_4096 = var2;
      this.ald = var3;
      this.ale = var4;
      this.uri = var5;
   }

   public static Asset createFromBytes(byte[] var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Asset data cannot be null");
      } else {
         return new Asset(1, var0, (String)null, (ParcelFileDescriptor)null, (Uri)null);
      }
   }

   public static Asset createFromFd(ParcelFileDescriptor var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Asset fd cannot be null");
      } else {
         return new Asset(1, (byte[])null, (String)null, var0, (Uri)null);
      }
   }

   public static Asset createFromRef(String var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Asset digest cannot be null");
      } else {
         return new Asset(1, (byte[])null, var0, (ParcelFileDescriptor)null, (Uri)null);
      }
   }

   public static Asset createFromUri(Uri var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Asset uri cannot be null");
      } else {
         return new Asset(1, (byte[])null, (String)null, (ParcelFileDescriptor)null, var0);
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof Asset)) {
            return false;
         }

         Asset var2 = (Asset)var1;
         if(!class_349.equal(this.field_4096, var2.field_4096) || !class_349.equal(this.ald, var2.ald) || !class_349.equal(this.ale, var2.ale) || !class_349.equal(this.uri, var2.uri)) {
            return false;
         }
      }

      return true;
   }

   public byte[] getData() {
      return this.field_4096;
   }

   public String getDigest() {
      return this.ald;
   }

   public ParcelFileDescriptor getFd() {
      return this.ale;
   }

   public Uri getUri() {
      return this.uri;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_4096, this.ald, this.ale, this.uri};
      return class_349.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Asset[@");
      var1.append(Integer.toHexString(this.hashCode()));
      if(this.ald == null) {
         var1.append(", nodigest");
      } else {
         var1.append(", ");
         var1.append(this.ald);
      }

      if(this.field_4096 != null) {
         var1.append(", size=");
         var1.append(this.field_4096.length);
      }

      if(this.ale != null) {
         var1.append(", fd=");
         var1.append(this.ale);
      }

      if(this.uri != null) {
         var1.append(", uri=");
         var1.append(this.uri);
      }

      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_742.method_4258(this, var1, var2 | 1);
   }
}
