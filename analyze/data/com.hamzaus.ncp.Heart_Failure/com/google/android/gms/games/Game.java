package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface Game extends Parcelable, Freezable<Game> {
   boolean areSnapshotsEnabled();

   // $FF: renamed from: gH () boolean
   boolean method_215();

   // $FF: renamed from: gI () boolean
   boolean method_216();

   // $FF: renamed from: gJ () boolean
   boolean method_217();

   // $FF: renamed from: gK () java.lang.String
   String method_218();

   // $FF: renamed from: gL () int
   int method_219();

   int getAchievementTotalCount();

   String getApplicationId();

   String getDescription();

   void getDescription(CharArrayBuffer var1);

   String getDeveloperName();

   void getDeveloperName(CharArrayBuffer var1);

   String getDisplayName();

   void getDisplayName(CharArrayBuffer var1);

   Uri getFeaturedImageUri();

   @Deprecated
   String getFeaturedImageUrl();

   Uri getHiResImageUri();

   @Deprecated
   String getHiResImageUrl();

   Uri getIconImageUri();

   @Deprecated
   String getIconImageUrl();

   int getLeaderboardCount();

   String getPrimaryCategory();

   String getSecondaryCategory();

   boolean isMuted();

   boolean isRealTimeMultiplayerEnabled();

   boolean isTurnBasedMultiplayerEnabled();
}
