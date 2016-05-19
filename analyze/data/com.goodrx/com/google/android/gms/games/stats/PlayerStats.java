package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface PlayerStats extends Parcelable, Freezable<PlayerStats> {
   float getAverageSessionLength();

   float getChurnProbability();

   int getDaysSinceLastPlayed();

   int getNumberOfPurchases();

   int getNumberOfSessions();

   float getSessionPercentile();

   float getSpendPercentile();

   float getSpendProbability();

   Bundle zzxV();
}
