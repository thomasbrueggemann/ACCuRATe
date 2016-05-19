package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsEntity;

public class PlayerStatsRef extends zzc implements PlayerStats {
   private Bundle zzaLk;

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return PlayerStatsEntity.zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzxW();
   }

   public float getAverageSessionLength() {
      return this.getFloat("ave_session_length_minutes");
   }

   public float getChurnProbability() {
      return this.getFloat("churn_probability");
   }

   public int getDaysSinceLastPlayed() {
      return this.getInteger("days_since_last_played");
   }

   public int getNumberOfPurchases() {
      return this.getInteger("num_purchases");
   }

   public int getNumberOfSessions() {
      return this.getInteger("num_sessions");
   }

   public float getSessionPercentile() {
      return this.getFloat("num_sessions_percentile");
   }

   public float getSpendPercentile() {
      return this.getFloat("spend_percentile");
   }

   public float getSpendProbability() {
      return !this.zzcz("spend_probability")?-1.0F:this.getFloat("spend_probability");
   }

   public int hashCode() {
      return PlayerStatsEntity.zza(this);
   }

   public String toString() {
      return PlayerStatsEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((PlayerStatsEntity)this.zzxW()).writeToParcel(var1, var2);
   }

   public Bundle zzxV() {
      int var1 = 0;
      if(this.zzaLk != null) {
         return this.zzaLk;
      } else {
         this.zzaLk = new Bundle();
         String var2 = this.getString("unknown_raw_keys");
         String var3 = this.getString("unknown_raw_values");
         if(var2 != null && var3 != null) {
            String[] var4 = var2.split(",");
            String[] var5 = var3.split(",");
            boolean var6;
            if(var4.length <= var5.length) {
               var6 = true;
            } else {
               var6 = false;
            }

            zzb.zza(var6, "Invalid raw arguments!");

            while(var1 < var4.length) {
               this.zzaLk.putString(var4[var1], var5[var1]);
               ++var1;
            }
         }

         return this.zzaLk;
      }
   }

   public PlayerStats zzxW() {
      return new PlayerStatsEntity(this);
   }
}
