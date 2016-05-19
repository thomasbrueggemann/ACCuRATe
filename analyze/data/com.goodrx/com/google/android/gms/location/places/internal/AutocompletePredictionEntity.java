package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.internal.zza;
import com.google.android.gms.location.places.internal.zzu;
import java.util.Collections;
import java.util.List;

public class AutocompletePredictionEntity implements SafeParcelable, AutocompletePrediction {
   public static final Creator<AutocompletePredictionEntity> CREATOR = new zza();
   private static final List<AutocompletePredictionEntity.SubstringEntity> zzaQc = Collections.emptyList();
   final int mVersionCode;
   final String zzaPH;
   final List<Integer> zzaPd;
   final String zzaQd;
   final List<AutocompletePredictionEntity.SubstringEntity> zzaQe;
   final int zzaQf;
   final String zzaQg;
   final List<AutocompletePredictionEntity.SubstringEntity> zzaQh;
   final String zzaQi;
   final List<AutocompletePredictionEntity.SubstringEntity> zzaQj;

   AutocompletePredictionEntity(int var1, String var2, List<Integer> var3, int var4, String var5, List<AutocompletePredictionEntity.SubstringEntity> var6, String var7, List<AutocompletePredictionEntity.SubstringEntity> var8, String var9, List<AutocompletePredictionEntity.SubstringEntity> var10) {
      this.mVersionCode = var1;
      this.zzaPH = var2;
      this.zzaPd = var3;
      this.zzaQf = var4;
      this.zzaQd = var5;
      this.zzaQe = var6;
      this.zzaQg = var7;
      this.zzaQh = var8;
      this.zzaQi = var9;
      this.zzaQj = var10;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof AutocompletePredictionEntity)) {
            return false;
         }

         AutocompletePredictionEntity var2 = (AutocompletePredictionEntity)var1;
         if(!zzw.equal(this.zzaPH, var2.zzaPH) || !zzw.equal(this.zzaPd, var2.zzaPd) || !zzw.equal(Integer.valueOf(this.zzaQf), Integer.valueOf(var2.zzaQf)) || !zzw.equal(this.zzaQd, var2.zzaQd) || !zzw.equal(this.zzaQe, var2.zzaQe) || !zzw.equal(this.zzaQg, var2.zzaQg) || !zzw.equal(this.zzaQh, var2.zzaQh) || !zzw.equal(this.zzaQi, var2.zzaQi) || !zzw.equal(this.zzaQj, var2.zzaQj)) {
            return false;
         }
      }

      return true;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzzf();
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzaPH, this.zzaPd, Integer.valueOf(this.zzaQf), this.zzaQd, this.zzaQe, this.zzaQg, this.zzaQh, this.zzaQi, this.zzaQj};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("placeId", this.zzaPH).zzg("placeTypes", this.zzaPd).zzg("fullText", this.zzaQd).zzg("fullTextMatchedSubstrings", this.zzaQe).zzg("primaryText", this.zzaQg).zzg("primaryTextMatchedSubstrings", this.zzaQh).zzg("secondaryText", this.zzaQi).zzg("secondaryTextMatchedSubstrings", this.zzaQj).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }

   public AutocompletePrediction zzzf() {
      return this;
   }

   public static class SubstringEntity implements SafeParcelable {
      public static final Creator<AutocompletePredictionEntity.SubstringEntity> CREATOR = new zzu();
      final int mLength;
      final int mOffset;
      final int mVersionCode;

      public SubstringEntity(int var1, int var2, int var3) {
         this.mVersionCode = var1;
         this.mOffset = var2;
         this.mLength = var3;
      }

      public int describeContents() {
         return 0;
      }

      public boolean equals(Object var1) {
         if(this != var1) {
            if(!(var1 instanceof AutocompletePredictionEntity.SubstringEntity)) {
               return false;
            }

            AutocompletePredictionEntity.SubstringEntity var2 = (AutocompletePredictionEntity.SubstringEntity)var1;
            if(!zzw.equal(Integer.valueOf(this.mOffset), Integer.valueOf(var2.mOffset)) || !zzw.equal(Integer.valueOf(this.mLength), Integer.valueOf(var2.mLength))) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         Object[] var1 = new Object[]{Integer.valueOf(this.mOffset), Integer.valueOf(this.mLength)};
         return zzw.hashCode(var1);
      }

      public String toString() {
         return zzw.zzy(this).zzg("offset", Integer.valueOf(this.mOffset)).zzg("length", Integer.valueOf(this.mLength)).toString();
      }

      public void writeToParcel(Parcel var1, int var2) {
         zzu.zza(this, var1, var2);
      }
   }
}
