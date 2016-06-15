package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.wearable.class_961;

public class Asset implements SafeParcelable {
   public static final Creator<Asset> CREATOR = new class_961();
   // $FF: renamed from: CK int
   final int field_4215;
   private byte[] aeA;
   private String axa;
   public ParcelFileDescriptor axb;
   public Uri uri;

   Asset(int var1, byte[] var2, String var3, ParcelFileDescriptor var4, Uri var5) {
      this.field_4215 = var1;
      this.aeA = var2;
      this.axa = var3;
      this.axb = var4;
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
         if(!class_336.equal(this.aeA, var2.aeA) || !class_336.equal(this.axa, var2.axa) || !class_336.equal(this.axb, var2.axb) || !class_336.equal(this.uri, var2.uri)) {
            return false;
         }
      }

      return true;
   }

   public byte[] getData() {
      return this.aeA;
   }

   public String getDigest() {
      return this.axa;
   }

   public ParcelFileDescriptor getFd() {
      return this.axb;
   }

   public Uri getUri() {
      return this.uri;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.aeA, this.axa, this.axb, this.uri};
      return class_336.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Asset[@");
      var1.append(Integer.toHexString(this.hashCode()));
      if(this.axa == null) {
         var1.append(", nodigest");
      } else {
         var1.append(", ");
         var1.append(this.axa);
      }

      if(this.aeA != null) {
         var1.append(", size=");
         var1.append(this.aeA.length);
      }

      if(this.axb != null) {
         var1.append(", fd=");
         var1.append(this.axb);
      }

      if(this.uri != null) {
         var1.append(", uri=");
         var1.append(this.uri);
      }

      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_961.method_5363(this, var1, var2 | 1);
   }
}
