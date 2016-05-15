package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.personalized.zzb;

public class PlaceAlias implements SafeParcelable {
   public static final zzb CREATOR = new zzb();
   public static final PlaceAlias zzaRc = new PlaceAlias(0, "Home");
   public static final PlaceAlias zzaRd = new PlaceAlias(0, "Work");
   final int mVersionCode;
   private final String zzaRe;

   PlaceAlias(int var1, String var2) {
      this.mVersionCode = var1;
      this.zzaRe = var2;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof PlaceAlias)) {
         return false;
      } else {
         PlaceAlias var2 = (PlaceAlias)var1;
         return zzw.equal(this.zzaRe, var2.zzaRe);
      }
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzaRe};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("alias", this.zzaRe).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   public String zzzB() {
      return this.zzaRe;
   }
}
