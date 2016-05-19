package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.personalized.PlaceAlias;
import com.google.android.gms.location.places.personalized.zze;
import java.util.List;

public class PlaceUserData implements SafeParcelable {
   public static final zze CREATOR = new zze();
   final int mVersionCode;
   private final String zzVa;
   private final String zzaPH;
   private final List<PlaceAlias> zzaRg;

   PlaceUserData(int var1, String var2, String var3, List<PlaceAlias> var4) {
      this.mVersionCode = var1;
      this.zzVa = var2;
      this.zzaPH = var3;
      this.zzaRg = var4;
   }

   public int describeContents() {
      zze var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof PlaceUserData)) {
            return false;
         }

         PlaceUserData var2 = (PlaceUserData)var1;
         if(!this.zzVa.equals(var2.zzVa) || !this.zzaPH.equals(var2.zzaPH) || !this.zzaRg.equals(var2.zzaRg)) {
            return false;
         }
      }

      return true;
   }

   public String getPlaceId() {
      return this.zzaPH;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzVa, this.zzaPH, this.zzaRg};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("accountName", this.zzVa).zzg("placeId", this.zzaPH).zzg("placeAliases", this.zzaRg).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze var10000 = CREATOR;
      zze.zza(this, var1, var2);
   }

   public String zzzD() {
      return this.zzVa;
   }

   public List<PlaceAlias> zzzE() {
      return this.zzaRg;
   }
}
