package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zza;
import com.google.android.gms.common.server.response.FastJsonResponse;

public class ConverterWrapper implements SafeParcelable {
   public static final zza CREATOR = new zza();
   private final int mVersionCode;
   private final StringToIntConverter zzamF;

   ConverterWrapper(int var1, StringToIntConverter var2) {
      this.mVersionCode = var1;
      this.zzamF = var2;
   }

   private ConverterWrapper(StringToIntConverter var1) {
      this.mVersionCode = 1;
      this.zzamF = var1;
   }

   public static ConverterWrapper zza(FastJsonResponse.zza<?, ?> var0) {
      if(var0 instanceof StringToIntConverter) {
         return new ConverterWrapper((StringToIntConverter)var0);
      } else {
         throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
      }
   }

   public int describeContents() {
      zza var10000 = CREATOR;
      return 0;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza var10000 = CREATOR;
      zza.zza(this, var1, var2);
   }

   StringToIntConverter zzrg() {
      return this.zzamF;
   }

   public FastJsonResponse.zza<?, ?> zzrh() {
      if(this.zzamF != null) {
         return this.zzamF;
      } else {
         throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
      }
   }
}
