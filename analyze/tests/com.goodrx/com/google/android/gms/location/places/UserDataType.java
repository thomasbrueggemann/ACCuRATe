package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.location.places.zzm;
import java.util.Set;

public final class UserDataType implements SafeParcelable {
   public static final zzm CREATOR;
   public static final UserDataType zzaPX = zzy("test_type", 1);
   public static final UserDataType zzaPY = zzy("labeled_place", 6);
   public static final UserDataType zzaPZ = zzy("here_content", 7);
   public static final Set<UserDataType> zzaQa;
   final int mVersionCode;
   final String zzJN;
   final int zzaQb;

   static {
      zzaQa = zzmr.zza(zzaPX, zzaPY, zzaPZ);
      CREATOR = new zzm();
   }

   UserDataType(int var1, String var2, int var3) {
      zzx.zzcM(var2);
      this.mVersionCode = var1;
      this.zzJN = var2;
      this.zzaQb = var3;
   }

   private static UserDataType zzy(String var0, int var1) {
      return new UserDataType(0, var0, var1);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof UserDataType)) {
            return false;
         }

         UserDataType var2 = (UserDataType)var1;
         if(!this.zzJN.equals(var2.zzJN) || this.zzaQb != var2.zzaQb) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return this.zzJN.hashCode();
   }

   public String toString() {
      return this.zzJN;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzm.zza(this, var1, var2);
   }
}
