package com.google.android.gms.location.places;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.zza;
import com.google.android.gms.location.places.zzd;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class NearbyAlertFilter extends zza implements SafeParcelable {
   public static final zzd CREATOR = new zzd();
   final int mVersionCode;
   final List<String> zzaPj;
   final List<Integer> zzaPk;
   final List<UserDataType> zzaPl;
   final String zzaPm;
   final boolean zzaPn;
   private final Set<String> zzaPo;
   private final Set<Integer> zzaPp;
   private final Set<UserDataType> zzaPq;

   NearbyAlertFilter(int var1, @Nullable List<String> var2, @Nullable List<Integer> var3, @Nullable List<UserDataType> var4, @Nullable String var5, boolean var6) {
      this.mVersionCode = var1;
      List var7;
      if(var3 == null) {
         var7 = Collections.emptyList();
      } else {
         var7 = Collections.unmodifiableList(var3);
      }

      this.zzaPk = var7;
      List var8;
      if(var4 == null) {
         var8 = Collections.emptyList();
      } else {
         var8 = Collections.unmodifiableList(var4);
      }

      this.zzaPl = var8;
      List var9;
      if(var2 == null) {
         var9 = Collections.emptyList();
      } else {
         var9 = Collections.unmodifiableList(var2);
      }

      this.zzaPj = var9;
      this.zzaPp = zzw(this.zzaPk);
      this.zzaPq = zzw(this.zzaPl);
      this.zzaPo = zzw(this.zzaPj);
      this.zzaPm = var5;
      this.zzaPn = var6;
   }

   public static NearbyAlertFilter zzh(Collection<String> var0) {
      if(var0 != null && !var0.isEmpty()) {
         return new NearbyAlertFilter(0, zzf(var0), (List)null, (List)null, (String)null, false);
      } else {
         throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace ID to match results with.");
      }
   }

   public static NearbyAlertFilter zzi(Collection<Integer> var0) {
      if(var0 != null && !var0.isEmpty()) {
         return new NearbyAlertFilter(0, (List)null, zzf(var0), (List)null, (String)null, false);
      } else {
         throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace type to match results with.");
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof NearbyAlertFilter)) {
            return false;
         }

         NearbyAlertFilter var2 = (NearbyAlertFilter)var1;
         if(this.zzaPm == null && var2.zzaPm != null) {
            return false;
         }

         if(!this.zzaPp.equals(var2.zzaPp) || !this.zzaPq.equals(var2.zzaPq) || !this.zzaPo.equals(var2.zzaPo) || this.zzaPm != null && !this.zzaPm.equals(var2.zzaPm) || this.zzaPn != var2.zzyX()) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzaPp, this.zzaPq, this.zzaPo, this.zzaPm, Boolean.valueOf(this.zzaPn)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      zzw.zza var1 = zzw.zzy(this);
      if(!this.zzaPp.isEmpty()) {
         var1.zzg("types", this.zzaPp);
      }

      if(!this.zzaPo.isEmpty()) {
         var1.zzg("placeIds", this.zzaPo);
      }

      if(!this.zzaPq.isEmpty()) {
         var1.zzg("requestedUserDataTypes", this.zzaPq);
      }

      if(this.zzaPm != null) {
         var1.zzg("chainName", this.zzaPm);
      }

      var1.zzg("Beacon required: ", Boolean.valueOf(this.zzaPn));
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }

   public boolean zzyX() {
      return this.zzaPn;
   }
}
