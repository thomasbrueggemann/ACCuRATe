package com.google.android.gms.location.places;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.zzk;
import java.util.concurrent.TimeUnit;

public final class PlaceRequest implements SafeParcelable {
   public static final Creator<PlaceRequest> CREATOR = new zzk();
   static final long zzaPJ;
   private final int mPriority;
   final int mVersionCode;
   private final long zzaND;
   private final long zzaNY;
   private final PlaceFilter zzaPK;

   static {
      zzaPJ = TimeUnit.HOURS.toMillis(1L);
   }

   public PlaceRequest(int var1, PlaceFilter var2, long var3, int var5, long var6) {
      this.mVersionCode = var1;
      this.zzaPK = var2;
      this.zzaNY = var3;
      this.mPriority = var5;
      this.zzaND = var6;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof PlaceRequest)) {
            return false;
         }

         PlaceRequest var2 = (PlaceRequest)var1;
         if(!zzw.equal(this.zzaPK, var2.zzaPK) || this.zzaNY != var2.zzaNY || this.mPriority != var2.mPriority || this.zzaND != var2.zzaND) {
            return false;
         }
      }

      return true;
   }

   public long getExpirationTime() {
      return this.zzaND;
   }

   public long getInterval() {
      return this.zzaNY;
   }

   public int getPriority() {
      return this.mPriority;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzaPK, Long.valueOf(this.zzaNY), Integer.valueOf(this.mPriority), Long.valueOf(this.zzaND)};
      return zzw.hashCode(var1);
   }

   @SuppressLint({"DefaultLocale"})
   public String toString() {
      return zzw.zzy(this).zzg("filter", this.zzaPK).zzg("interval", Long.valueOf(this.zzaNY)).zzg("priority", Integer.valueOf(this.mPriority)).zzg("expireAt", Long.valueOf(this.zzaND)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }

   public PlaceFilter zzyZ() {
      return this.zzaPK;
   }
}
