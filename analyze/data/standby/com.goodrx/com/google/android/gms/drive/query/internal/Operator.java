package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.zzn;

public class Operator implements SafeParcelable {
   public static final Creator<Operator> CREATOR = new zzn();
   public static final Operator zzauA = new Operator(">");
   public static final Operator zzauB = new Operator(">=");
   public static final Operator zzauC = new Operator("and");
   public static final Operator zzauD = new Operator("or");
   public static final Operator zzauE = new Operator("not");
   public static final Operator zzauF = new Operator("contains");
   public static final Operator zzaux = new Operator("=");
   public static final Operator zzauy = new Operator("<");
   public static final Operator zzauz = new Operator("<=");
   final String mTag;
   final int mVersionCode;

   Operator(int var1, String var2) {
      this.mVersionCode = var1;
      this.mTag = var2;
   }

   private Operator(String var1) {
      this(1, var1);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(this.getClass() != var1.getClass()) {
            return false;
         }

         Operator var2 = (Operator)var1;
         if(this.mTag == null) {
            if(var2.mTag != null) {
               return false;
            }
         } else if(!this.mTag.equals(var2.mTag)) {
            return false;
         }
      }

      return true;
   }

   public String getTag() {
      return this.mTag;
   }

   public int hashCode() {
      int var1;
      if(this.mTag == null) {
         var1 = 0;
      } else {
         var1 = this.mTag.hashCode();
      }

      return var1 + 31;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzn.zza(this, var1, var2);
   }
}
