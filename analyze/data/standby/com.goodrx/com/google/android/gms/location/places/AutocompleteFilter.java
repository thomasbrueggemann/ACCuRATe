package com.google.android.gms.location.places;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.zzc;
import java.util.Collection;
import java.util.List;

public class AutocompleteFilter implements SafeParcelable {
   public static final zzc CREATOR = new zzc();
   final int mVersionCode;
   final boolean zzaPg;
   final List<Integer> zzaPh;
   final int zzaPi;

   AutocompleteFilter(int var1, boolean var2, List<Integer> var3) {
      byte var4 = 1;
      super();
      this.mVersionCode = var1;
      this.zzaPh = var3;
      this.zzaPi = zzg(var3);
      if(this.mVersionCode < var4) {
         if(var2) {
            var4 = 0;
         }

         this.zzaPg = (boolean)var4;
      } else {
         this.zzaPg = var2;
      }
   }

   private static int zzg(@Nullable Collection<Integer> var0) {
      return var0 != null && !var0.isEmpty()?((Integer)var0.iterator().next()).intValue():0;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof AutocompleteFilter)) {
            return false;
         }

         AutocompleteFilter var2 = (AutocompleteFilter)var1;
         if(this.zzaPi != this.zzaPi || this.zzaPg != var2.zzaPg) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Boolean.valueOf(this.zzaPg), Integer.valueOf(this.zzaPi)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("includeQueryPredictions", Boolean.valueOf(this.zzaPg)).zzg("typeFilter", Integer.valueOf(this.zzaPi)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
