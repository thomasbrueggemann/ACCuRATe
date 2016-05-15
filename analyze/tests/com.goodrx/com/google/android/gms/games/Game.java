package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;

public interface Game extends Parcelable, Freezable<Game> {
   boolean areSnapshotsEnabled();

   int getAchievementTotalCount();

   String getApplicationId();

   String getDescription();

   String getDeveloperName();

   String getDisplayName();

   Uri getFeaturedImageUri();

   @Deprecated
   @KeepName
   String getFeaturedImageUrl();

   Uri getHiResImageUri();

   @Deprecated
   @KeepName
   String getHiResImageUrl();

   Uri getIconImageUri();

   @Deprecated
   @KeepName
   String getIconImageUrl();

   int getLeaderboardCount();

   String getPrimaryCategory();

   String getSecondaryCategory();

   String getThemeColor();

   boolean hasGamepadSupport();

   boolean isMuted();

   boolean isRealTimeMultiplayerEnabled();

   boolean isTurnBasedMultiplayerEnabled();

   String zzvA();

   int zzvB();

   boolean zzvx();

   boolean zzvy();

   boolean zzvz();
}
