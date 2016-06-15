package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface Game extends Parcelable, Freezable<Game> {
   boolean areSnapshotsEnabled();

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

   String getThemeColor();

   boolean isMuted();

   boolean isRealTimeMultiplayerEnabled();

   boolean isTurnBasedMultiplayerEnabled();

   // $FF: renamed from: kA () boolean
   boolean method_229();

   // $FF: renamed from: kB () java.lang.String
   String method_230();

   // $FF: renamed from: kC () int
   int method_231();

   // $FF: renamed from: ky () boolean
   boolean method_232();

   // $FF: renamed from: kz () boolean
   boolean method_233();
}
