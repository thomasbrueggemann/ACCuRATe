package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsEntityCreator;

public class PlayerStatsEntity implements SafeParcelable, PlayerStats {
   public static final Creator<PlayerStatsEntity> CREATOR = new PlayerStatsEntityCreator();
   private final int mVersionCode;
   private final float zzaLd;
   private final float zzaLe;
   private final int zzaLf;
   private final int zzaLg;
   private final int zzaLh;
   private final float zzaLi;
   private final float zzaLj;
   private final Bundle zzaLk;
   private final float zzaLl;

   PlayerStatsEntity(int var1, float var2, float var3, int var4, int var5, int var6, float var7, float var8, Bundle var9, float var10) {
      this.mVersionCode = var1;
      this.zzaLd = var2;
      this.zzaLe = var3;
      this.zzaLf = var4;
      this.zzaLg = var5;
      this.zzaLh = var6;
      this.zzaLi = var7;
      this.zzaLj = var8;
      this.zzaLk = var9;
      this.zzaLl = var10;
   }

   public PlayerStatsEntity(PlayerStats var1) {
      this.mVersionCode = 3;
      this.zzaLd = var1.getAverageSessionLength();
      this.zzaLe = var1.getChurnProbability();
      this.zzaLf = var1.getDaysSinceLastPlayed();
      this.zzaLg = var1.getNumberOfPurchases();
      this.zzaLh = var1.getNumberOfSessions();
      this.zzaLi = var1.getSessionPercentile();
      this.zzaLj = var1.getSpendPercentile();
      this.zzaLl = var1.getSpendProbability();
      this.zzaLk = var1.zzxV();
   }

   static int zza(PlayerStats var0) {
      Object[] var1 = new Object[]{Float.valueOf(var0.getAverageSessionLength()), Float.valueOf(var0.getChurnProbability()), Integer.valueOf(var0.getDaysSinceLastPlayed()), Integer.valueOf(var0.getNumberOfPurchases()), Integer.valueOf(var0.getNumberOfSessions()), Float.valueOf(var0.getSessionPercentile()), Float.valueOf(var0.getSpendPercentile()), Float.valueOf(var0.getSpendProbability())};
      return zzw.hashCode(var1);
   }

   static boolean zza(PlayerStats var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof PlayerStats)) {
         var2 = false;
      } else if(var0 != var1) {
         PlayerStats var3 = (PlayerStats)var1;
         if(!zzw.equal(Float.valueOf(var3.getAverageSessionLength()), Float.valueOf(var0.getAverageSessionLength())) || !zzw.equal(Float.valueOf(var3.getChurnProbability()), Float.valueOf(var0.getChurnProbability())) || !zzw.equal(Integer.valueOf(var3.getDaysSinceLastPlayed()), Integer.valueOf(var0.getDaysSinceLastPlayed())) || !zzw.equal(Integer.valueOf(var3.getNumberOfPurchases()), Integer.valueOf(var0.getNumberOfPurchases())) || !zzw.equal(Integer.valueOf(var3.getNumberOfSessions()), Integer.valueOf(var0.getNumberOfSessions())) || !zzw.equal(Float.valueOf(var3.getSessionPercentile()), Float.valueOf(var0.getSessionPercentile())) || !zzw.equal(Float.valueOf(var3.getSpendPercentile()), Float.valueOf(var0.getSpendPercentile())) || !zzw.equal(Float.valueOf(var3.getSpendProbability()), Float.valueOf(var0.getSpendProbability()))) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(PlayerStats var0) {
      return zzw.zzy(var0).zzg("AverageSessionLength", Float.valueOf(var0.getAverageSessionLength())).zzg("ChurnProbability", Float.valueOf(var0.getChurnProbability())).zzg("DaysSinceLastPlayed", Integer.valueOf(var0.getDaysSinceLastPlayed())).zzg("NumberOfPurchases", Integer.valueOf(var0.getNumberOfPurchases())).zzg("NumberOfSessions", Integer.valueOf(var0.getNumberOfSessions())).zzg("SessionPercentile", Float.valueOf(var0.getSessionPercentile())).zzg("SpendPercentile", Float.valueOf(var0.getSpendPercentile())).zzg("SpendProbability", Float.valueOf(var0.getSpendProbability())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzxW();
   }

   public float getAverageSessionLength() {
      return this.zzaLd;
   }

   public float getChurnProbability() {
      return this.zzaLe;
   }

   public int getDaysSinceLastPlayed() {
      return this.zzaLf;
   }

   public int getNumberOfPurchases() {
      return this.zzaLg;
   }

   public int getNumberOfSessions() {
      return this.zzaLh;
   }

   public float getSessionPercentile() {
      return this.zzaLi;
   }

   public float getSpendPercentile() {
      return this.zzaLj;
   }

   public float getSpendProbability() {
      return this.zzaLl;
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
      PlayerStatsEntityCreator.zza(this, var1, var2);
   }

   public Bundle zzxV() {
      return this.zzaLk;
   }

   public PlayerStats zzxW() {
      return this;
   }
}
