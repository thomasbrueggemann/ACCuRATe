package com.google.android.gms.location.places;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.zza;
import com.google.android.gms.location.places.zzg;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter extends zza implements SafeParcelable {
   public static final zzg CREATOR = new zzg();
   private static final PlaceFilter zzaPz = new PlaceFilter();
   final int mVersionCode;
   final boolean zzaPA;
   final List<String> zzaPj;
   final List<Integer> zzaPk;
   final List<UserDataType> zzaPl;
   private final Set<String> zzaPo;
   private final Set<Integer> zzaPp;
   private final Set<UserDataType> zzaPq;

   public PlaceFilter() {
      this(false, (Collection)null);
   }

   PlaceFilter(int var1, @Nullable List<Integer> var2, boolean var3, @Nullable List<String> var4, @Nullable List<UserDataType> var5) {
      this.mVersionCode = var1;
      List var6;
      if(var2 == null) {
         var6 = Collections.emptyList();
      } else {
         var6 = Collections.unmodifiableList(var2);
      }

      this.zzaPk = var6;
      this.zzaPA = var3;
      List var7;
      if(var5 == null) {
         var7 = Collections.emptyList();
      } else {
         var7 = Collections.unmodifiableList(var5);
      }

      this.zzaPl = var7;
      List var8;
      if(var4 == null) {
         var8 = Collections.emptyList();
      } else {
         var8 = Collections.unmodifiableList(var4);
      }

      this.zzaPj = var8;
      this.zzaPp = zzw(this.zzaPk);
      this.zzaPq = zzw(this.zzaPl);
      this.zzaPo = zzw(this.zzaPj);
   }

   public PlaceFilter(@Nullable Collection<Integer> var1, boolean var2, @Nullable Collection<String> var3, @Nullable Collection<UserDataType> var4) {
      this(0, zzf(var1), var2, zzf(var3), zzf(var4));
   }

   public PlaceFilter(boolean var1, @Nullable Collection<String> var2) {
      this((Collection)null, var1, var2, (Collection)null);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof PlaceFilter)) {
            return false;
         }

         PlaceFilter var2 = (PlaceFilter)var1;
         if(!this.zzaPp.equals(var2.zzaPp) || this.zzaPA != var2.zzaPA || !this.zzaPq.equals(var2.zzaPq) || !this.zzaPo.equals(var2.zzaPo)) {
            return false;
         }
      }

      return true;
   }

   public Set<String> getPlaceIds() {
      return this.zzaPo;
   }

   public Set<Integer> getPlaceTypes() {
      return this.zzaPp;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzaPp, Boolean.valueOf(this.zzaPA), this.zzaPq, this.zzaPo};
      return zzw.hashCode(var1);
   }

   public String toString() {
      zzw.zza var1 = zzw.zzy(this);
      if(!this.zzaPp.isEmpty()) {
         var1.zzg("types", this.zzaPp);
      }

      var1.zzg("requireOpenNow", Boolean.valueOf(this.zzaPA));
      if(!this.zzaPo.isEmpty()) {
         var1.zzg("placeIds", this.zzaPo);
      }

      if(!this.zzaPq.isEmpty()) {
         var1.zzg("requestedUserDataTypes", this.zzaPq);
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }
}
