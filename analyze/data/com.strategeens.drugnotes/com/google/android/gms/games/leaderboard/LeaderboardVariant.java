package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.Freezable;

public interface LeaderboardVariant extends Freezable<LeaderboardVariant> {
   int COLLECTION_PUBLIC = 0;
   int COLLECTION_SOCIAL = 1;
   int NUM_SCORES_UNKNOWN = -1;
   int NUM_TIME_SPANS = 3;
   int PLAYER_RANK_UNKNOWN = -1;
   int PLAYER_SCORE_UNKNOWN = -1;
   int TIME_SPAN_ALL_TIME = 2;
   int TIME_SPAN_DAILY = 0;
   int TIME_SPAN_WEEKLY = 1;

   int getCollection();

   String getDisplayPlayerRank();

   String getDisplayPlayerScore();

   long getNumScores();

   long getPlayerRank();

   String getPlayerScoreTag();

   long getRawPlayerScore();

   int getTimeSpan();

   boolean hasPlayerInfo();

   // $FF: renamed from: mK () java.lang.String
   String method_254();

   // $FF: renamed from: mL () java.lang.String
   String method_255();

   // $FF: renamed from: mM () java.lang.String
   String method_256();
}
