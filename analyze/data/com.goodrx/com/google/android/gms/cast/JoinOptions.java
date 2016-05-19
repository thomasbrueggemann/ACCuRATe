package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class JoinOptions implements SafeParcelable {
   public static final Creator<JoinOptions> CREATOR = new zzc();
   private final int mVersionCode;
   private int zzaaJ;

   public JoinOptions() {
      this(1, 0);
   }

   JoinOptions(int var1, int var2) {
      this.mVersionCode = var1;
      this.zzaaJ = var2;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof JoinOptions)) {
            return false;
         }

         JoinOptions var2 = (JoinOptions)var1;
         if(this.zzaaJ != var2.zzaaJ) {
            return false;
         }
      }

      return true;
   }

   public int getConnectionType() {
      return this.zzaaJ;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzaaJ)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      String var1;
      switch(this.zzaaJ) {
      case 0:
         var1 = "STRONG";
         break;
      case 1:
      default:
         var1 = "UNKNOWN";
         break;
      case 2:
         var1 = "INVISIBLE";
      }

      return String.format("joinOptions(connectionType=%s)", new Object[]{var1});
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
