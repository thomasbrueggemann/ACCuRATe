package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzm;

public class MapValue implements SafeParcelable {
   public static final Creator<MapValue> CREATOR = new zzm();
   private final int mVersionCode;
   private final int zzawZ;
   private final float zzaxe;

   MapValue(int var1, int var2, float var3) {
      this.mVersionCode = var1;
      this.zzawZ = var2;
      this.zzaxe = var3;
   }

   private boolean zza(MapValue var1) {
      if(this.zzawZ == var1.zzawZ) {
         switch(this.zzawZ) {
         case 2:
            if(this.asFloat() != var1.asFloat()) {
               return false;
            }
            break;
         default:
            if(this.zzaxe != var1.zzaxe) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public float asFloat() {
      boolean var1;
      if(this.zzawZ == 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      zzx.zza(var1, "Value is not in float format");
      return this.zzaxe;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof MapValue && this.zza((MapValue)var1);
   }

   int getFormat() {
      return this.zzawZ;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return (int)this.zzaxe;
   }

   public String toString() {
      switch(this.zzawZ) {
      case 2:
         return Float.toString(this.asFloat());
      default:
         return "unknown";
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzm.zza(this, var1, var2);
   }

   float zzuv() {
      return this.zzaxe;
   }
}
