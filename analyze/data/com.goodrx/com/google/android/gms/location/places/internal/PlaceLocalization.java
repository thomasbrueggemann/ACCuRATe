package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.internal.zzo;
import java.util.List;

@Deprecated
public final class PlaceLocalization implements SafeParcelable {
   public static final zzo CREATOR = new zzo();
   public final String address;
   public final String name;
   public final int versionCode;
   public final String zzaQO;
   public final String zzaQP;
   public final List<String> zzaQQ;

   public PlaceLocalization(int var1, String var2, String var3, String var4, String var5, List<String> var6) {
      this.versionCode = var1;
      this.name = var2;
      this.address = var3;
      this.zzaQO = var4;
      this.zzaQP = var5;
      this.zzaQQ = var6;
   }

   public int describeContents() {
      zzo var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof PlaceLocalization)) {
            return false;
         }

         PlaceLocalization var2 = (PlaceLocalization)var1;
         if(!zzw.equal(this.name, var2.name) || !zzw.equal(this.address, var2.address) || !zzw.equal(this.zzaQO, var2.zzaQO) || !zzw.equal(this.zzaQP, var2.zzaQP) || !zzw.equal(this.zzaQQ, var2.zzaQQ)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.name, this.address, this.zzaQO, this.zzaQP};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("name", this.name).zzg("address", this.address).zzg("internationalPhoneNumber", this.zzaQO).zzg("regularOpenHours", this.zzaQP).zzg("attributions", this.zzaQQ).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzo var10000 = CREATOR;
      zzo.zza(this, var1, var2);
   }
}
