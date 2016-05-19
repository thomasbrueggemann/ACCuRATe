package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;

public interface Player extends Parcelable, Freezable<Player> {
   Uri getBannerImageLandscapeUri();

   @Deprecated
   @KeepName
   String getBannerImageLandscapeUrl();

   Uri getBannerImagePortraitUri();

   @Deprecated
   @KeepName
   String getBannerImagePortraitUrl();

   String getDisplayName();

   Uri getHiResImageUri();

   @Deprecated
   @KeepName
   String getHiResImageUrl();

   Uri getIconImageUri();

   @Deprecated
   @KeepName
   String getIconImageUrl();

   long getLastPlayedWithTimestamp();

   PlayerLevelInfo getLevelInfo();

   String getName();

   String getPlayerId();

   long getRetrievedTimestamp();

   String getTitle();

   String zzvE();

   boolean zzvF();

   int zzvG();

   boolean zzvH();

   MostRecentGameInfo zzvI();
}
