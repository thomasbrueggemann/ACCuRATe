package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import java.util.ArrayList;

public interface Leaderboard extends Freezable<Leaderboard> {
    int SCORE_ORDER_LARGER_IS_BETTER = 1;
    int SCORE_ORDER_SMALLER_IS_BETTER;

    String getDisplayName();

    void getDisplayName(CharArrayBuffer var1);

    Game getGame();

    Uri getIconImageUri();

    @Deprecated
    String getIconImageUrl();

    String getLeaderboardId();

    int getScoreOrder();

    ArrayList<LeaderboardVariant> getVariants();
}
