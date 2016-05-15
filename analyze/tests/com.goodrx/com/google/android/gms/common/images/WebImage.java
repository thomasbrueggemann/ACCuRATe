package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WebImage implements SafeParcelable {
   public static final Creator<WebImage> CREATOR = new zzb();
   private final int mVersionCode;
   private final Uri zzajZ;
   private final int zzoG;
   private final int zzoH;

   WebImage(int var1, Uri var2, int var3, int var4) {
      this.mVersionCode = var1;
      this.zzajZ = var2;
      this.zzoG = var3;
      this.zzoH = var4;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && var1 instanceof WebImage) {
            WebImage var2 = (WebImage)var1;
            if(zzw.equal(this.zzajZ, var2.zzajZ) && this.zzoG == var2.zzoG && this.zzoH == var2.zzoH) {
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public int getHeight() {
      return this.zzoH;
   }

   public Uri getUrl() {
      return this.zzajZ;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int getWidth() {
      return this.zzoG;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzajZ, Integer.valueOf(this.zzoG), Integer.valueOf(this.zzoH)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzoG), Integer.valueOf(this.zzoH), this.zzajZ.toString()};
      return String.format("Image %dx%d %s", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
