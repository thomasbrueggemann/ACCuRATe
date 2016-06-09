package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentConditionEntityCreator;

public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
   public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
   private final int mVersionCode;
   private final String zzaDJ;
   private final String zzaDK;
   private final String zzaDL;
   private final Bundle zzaDM;

   AppContentConditionEntity(int var1, String var2, String var3, String var4, Bundle var5) {
      this.mVersionCode = var1;
      this.zzaDJ = var2;
      this.zzaDK = var3;
      this.zzaDL = var4;
      this.zzaDM = var5;
   }

   public AppContentConditionEntity(AppContentCondition var1) {
      this.mVersionCode = 1;
      this.zzaDJ = var1.zzwf();
      this.zzaDK = var1.zzwg();
      this.zzaDL = var1.zzwh();
      this.zzaDM = var1.zzwi();
   }

   static int zza(AppContentCondition var0) {
      Object[] var1 = new Object[]{var0.zzwf(), var0.zzwg(), var0.zzwh(), var0.zzwi()};
      return zzw.hashCode(var1);
   }

   static boolean zza(AppContentCondition var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppContentCondition)) {
         var2 = false;
      } else if(var0 != var1) {
         AppContentCondition var3 = (AppContentCondition)var1;
         if(!zzw.equal(var3.zzwf(), var0.zzwf()) || !zzw.equal(var3.zzwg(), var0.zzwg()) || !zzw.equal(var3.zzwh(), var0.zzwh()) || !zzw.equal(var3.zzwi(), var0.zzwi())) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(AppContentCondition var0) {
      return zzw.zzy(var0).zzg("DefaultValue", var0.zzwf()).zzg("ExpectedValue", var0.zzwg()).zzg("Predicate", var0.zzwh()).zzg("PredicateParameters", var0.zzwi()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzwj();
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zza(this);
   }

   public String toString() {
      return zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentConditionEntityCreator.zza(this, var1, var2);
   }

   public String zzwf() {
      return this.zzaDJ;
   }

   public String zzwg() {
      return this.zzaDK;
   }

   public String zzwh() {
      return this.zzaDL;
   }

   public Bundle zzwi() {
      return this.zzaDM;
   }

   public AppContentCondition zzwj() {
      return this;
   }
}
