package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.NearbyAlertFilter;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.zze;

public final class NearbyAlertRequest implements SafeParcelable {
   public static final zze CREATOR = new zze();
   private int mPriority = 110;
   private final int mVersionCode;
   private final int zzaNC;
   private final int zzaPr;
   @Deprecated
   private final PlaceFilter zzaPs;
   private final NearbyAlertFilter zzaPt;
   private final boolean zzaPu;
   private final int zzaPv;

   NearbyAlertRequest(int var1, int var2, int var3, PlaceFilter var4, NearbyAlertFilter var5, boolean var6, int var7, int var8) {
      this.mVersionCode = var1;
      this.zzaNC = var2;
      this.zzaPr = var3;
      if(var5 != null) {
         this.zzaPt = var5;
      } else if(var4 != null) {
         if(var4.getPlaceIds() != null && !var4.getPlaceIds().isEmpty()) {
            this.zzaPt = NearbyAlertFilter.zzh(var4.getPlaceIds());
         } else if(var4.getPlaceTypes() != null && !var4.getPlaceTypes().isEmpty()) {
            this.zzaPt = NearbyAlertFilter.zzi(var4.getPlaceTypes());
         } else {
            this.zzaPt = null;
         }
      } else {
         this.zzaPt = null;
      }

      this.zzaPs = null;
      this.zzaPu = var6;
      this.zzaPv = var7;
      this.mPriority = var8;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof NearbyAlertRequest)) {
            return false;
         }

         NearbyAlertRequest var2 = (NearbyAlertRequest)var1;
         if(this.zzaNC != var2.zzaNC || this.zzaPr != var2.zzaPr || !zzw.equal(this.zzaPt, var2.zzaPt) || this.mPriority != var2.mPriority) {
            return false;
         }
      }

      return true;
   }

   public int getPriority() {
      return this.mPriority;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzaNC), Integer.valueOf(this.zzaPr), this.zzaPt, Integer.valueOf(this.mPriority)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("transitionTypes", Integer.valueOf(this.zzaNC)).zzg("loiteringTimeMillis", Integer.valueOf(this.zzaPr)).zzg("nearbyAlertFilter", this.zzaPt).zzg("priority", Integer.valueOf(this.mPriority)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }

   public int zzyV() {
      return this.zzaNC;
   }

   public int zzyY() {
      return this.zzaPr;
   }

   @Deprecated
   public PlaceFilter zzyZ() {
      return null;
   }

   public NearbyAlertFilter zzza() {
      return this.zzaPt;
   }

   public boolean zzzb() {
      return this.zzaPu;
   }

   public int zzzc() {
      return this.zzaPv;
   }
}
