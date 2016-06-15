package com.google.android.gms.games.leaderboard;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public interface Leaderboards {
   Intent getAllLeaderboardsIntent(GoogleApiClient var1);

   Intent getLeaderboardIntent(GoogleApiClient var1, String var2);

   PendingResult<Leaderboards.LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient var1, String var2, int var3, int var4);

   PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient var1, String var2, boolean var3);

   PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient var1, boolean var2);

   PendingResult<Leaderboards.LoadScoresResult> loadMoreScores(GoogleApiClient var1, LeaderboardScoreBuffer var2, int var3, int var4);

   PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient var1, String var2, int var3, int var4, int var5);

   PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient var1, String var2, int var3, int var4, int var5, boolean var6);

   PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient var1, String var2, int var3, int var4, int var5);

   PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient var1, String var2, int var3, int var4, int var5, boolean var6);

   void submitScore(GoogleApiClient var1, String var2, long var3);

   void submitScore(GoogleApiClient var1, String var2, long var3, String var5);

   PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient var1, String var2, long var3);

   PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient var1, String var2, long var3, String var5);

   public interface LeaderboardMetadataResult extends Releasable, Result {
      LeaderboardBuffer getLeaderboards();
   }

   public interface LoadPlayerScoreResult extends Result {
      LeaderboardScore getScore();
   }

   public interface LoadScoresResult extends Releasable, Result {
      Leaderboard getLeaderboard();

      LeaderboardScoreBuffer getScores();
   }

   public interface SubmitScoreResult extends Releasable, Result {
      ScoreSubmissionData getScoreData();
   }
}
