package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.DetectedActivityCreator;
import java.util.Comparator;

public class DetectedActivity implements SafeParcelable {
   public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
   public static final Comparator<DetectedActivity> zzaNy = new Comparator() {
      // $FF: synthetic method
      public int compare(Object var1, Object var2) {
         return this.zza((DetectedActivity)var1, (DetectedActivity)var2);
      }

      public int zza(DetectedActivity var1, DetectedActivity var2) {
         int var3 = Integer.valueOf(var2.getConfidence()).compareTo(Integer.valueOf(var1.getConfidence()));
         if(var3 == 0) {
            var3 = Integer.valueOf(var1.getType()).compareTo(Integer.valueOf(var2.getType()));
         }

         return var3;
      }
   };
   public static final int[] zzaNz = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14};
   private final int mVersionCode;
   int zzaNA;
   int zzaNB;

   public DetectedActivity(int var1, int var2, int var3) {
      this.mVersionCode = var1;
      this.zzaNA = var2;
      this.zzaNB = var3;
   }

   private int zzhn(int var1) {
      if(var1 > 15) {
         var1 = 4;
      }

      return var1;
   }

   public static String zzho(int var0) {
      switch(var0) {
      case 0:
         return "IN_VEHICLE";
      case 1:
         return "ON_BICYCLE";
      case 2:
         return "ON_FOOT";
      case 3:
         return "STILL";
      case 4:
         return "UNKNOWN";
      case 5:
         return "TILTING";
      case 6:
      default:
         return Integer.toString(var0);
      case 7:
         return "WALKING";
      case 8:
         return "RUNNING";
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && this.getClass() == var1.getClass()) {
            DetectedActivity var2 = (DetectedActivity)var1;
            if(this.zzaNA == var2.zzaNA && this.zzaNB == var2.zzaNB) {
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

   public int getConfidence() {
      return this.zzaNB;
   }

   public int getType() {
      return this.zzhn(this.zzaNA);
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzaNA), Integer.valueOf(this.zzaNB)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return "DetectedActivity [type=" + zzho(this.getType()) + ", confidence=" + this.zzaNB + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      DetectedActivityCreator.zza(this, var1, var2);
   }
}
