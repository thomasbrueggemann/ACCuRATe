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

    // $FF: renamed from: jO () boolean
    boolean method_191();

    // $FF: renamed from: jP () boolean
    boolean method_192();

    // $FF: renamed from: jQ () boolean
    boolean method_193();

    // $FF: renamed from: jR () java.lang.String
    String method_194();

    // $FF: renamed from: jS () int
    int method_195();
}
