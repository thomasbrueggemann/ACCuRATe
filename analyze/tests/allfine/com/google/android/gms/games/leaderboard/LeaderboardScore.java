package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

public interface LeaderboardScore extends Freezable<LeaderboardScore> {
    int LEADERBOARD_RANK_UNKNOWN = -1;

    String getDisplayRank();

    void getDisplayRank(CharArrayBuffer var1);

    String getDisplayScore();

    void getDisplayScore(CharArrayBuffer var1);

    long getRank();

    long getRawScore();

    Player getScoreHolder();

    String getScoreHolderDisplayName();

    void getScoreHolderDisplayName(CharArrayBuffer var1);

    Uri getScoreHolderHiResImageUri();

    @Deprecated
    String getScoreHolderHiResImageUrl();

    Uri getScoreHolderIconImageUri();

    @Deprecated
    String getScoreHolderIconImageUrl();

    String getScoreTag();

    long getTimestampMillis();
}
