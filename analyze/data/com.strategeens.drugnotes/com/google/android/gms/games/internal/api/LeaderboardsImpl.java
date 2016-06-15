package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl implements Leaderboards {
   public Intent getAllLeaderboardsIntent(GoogleApiClient var1) {
      return Games.method_3259(var1).method_1992();
   }

   public Intent getLeaderboardIntent(GoogleApiClient var1, String var2) {
      return this.getLeaderboardIntent(var1, var2, -1);
   }

   public Intent getLeaderboardIntent(GoogleApiClient var1, String var2, int var3) {
      return Games.method_3259(var1).method_2008(var2, var3);
   }

   public PendingResult<Leaderboards.LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(final GoogleApiClient var1, final String var2, final int var3, final int var4) {
      return var1.method_942(new LeaderboardsImpl.LoadPlayerScoreImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1448(GamesClientImpl var1) {
            var1.method_1896(this, (String)null, var2, var3, var4);
         }
      });
   }

   public PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(final GoogleApiClient var1, final String var2, final boolean var3) {
      return var1.method_942(new LeaderboardsImpl.LoadMetadataImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1484(GamesClientImpl var1) {
            var1.method_1931(this, var2, var3);
         }
      });
   }

   public PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(final GoogleApiClient var1, final boolean var2) {
      return var1.method_942(new LeaderboardsImpl.LoadMetadataImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1483(GamesClientImpl var1) {
            var1.method_1932(this, var2);
         }
      });
   }

   public PendingResult<Leaderboards.LoadScoresResult> loadMoreScores(final GoogleApiClient var1, final LeaderboardScoreBuffer var2, final int var3, final int var4) {
      return var1.method_942(new LeaderboardsImpl.LoadScoresImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1407(GamesClientImpl var1) {
            var1.method_1885(this, var2, var3, var4);
         }
      });
   }

   public PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient var1, String var2, int var3, int var4, int var5) {
      return this.loadPlayerCenteredScores(var1, var2, var3, var4, var5, false);
   }

   public PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(final GoogleApiClient var1, final String var2, final int var3, final int var4, final int var5, final boolean var6) {
      return var1.method_942(new LeaderboardsImpl.LoadScoresImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1406(GamesClientImpl var1) {
            var1.method_1925(this, var2, var3, var4, var5, var6);
         }
      });
   }

   public PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient var1, String var2, int var3, int var4, int var5) {
      return this.loadTopScores(var1, var2, var3, var4, var5, false);
   }

   public PendingResult<Leaderboards.LoadScoresResult> loadTopScores(final GoogleApiClient var1, final String var2, final int var3, final int var4, final int var5, final boolean var6) {
      return var1.method_942(new LeaderboardsImpl.LoadScoresImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1405(GamesClientImpl var1) {
            var1.method_1890(this, var2, var3, var4, var5, var6);
         }
      });
   }

   public void submitScore(GoogleApiClient var1, String var2, long var3) {
      this.submitScore(var1, var2, var3, (String)null);
   }

   public void submitScore(GoogleApiClient var1, String var2, long var3, String var5) {
      Games.method_3259(var1).method_1894((BaseImplementation.class_1058)null, var2, var3, var5);
   }

   public PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient var1, String var2, long var3) {
      return this.submitScoreImmediate(var1, var2, var3, (String)null);
   }

   public PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(final GoogleApiClient var1, final String var2, final long var3, final String var5) {
      return var1.method_944(new LeaderboardsImpl.SubmitScoreImpl(var1) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1441(GamesClientImpl var1) {
            var1.method_1894(this, var2, var3, var5);
         }
      });
   }

   private abstract static class LoadMetadataImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LeaderboardMetadataResult> {
      private LoadMetadataImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadMetadataImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: U (com.google.android.gms.common.api.Status) com.google.android.gms.games.leaderboard.Leaderboards$LeaderboardMetadataResult
      public Leaderboards.LeaderboardMetadataResult method_1482(final Status var1) {
         return new Leaderboards.LeaderboardMetadataResult() {
            public LeaderboardBuffer getLeaderboards() {
               return new LeaderboardBuffer(DataHolder.method_5824(14));
            }

            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1482(var1);
      }
   }

   private abstract static class LoadPlayerScoreImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LoadPlayerScoreResult> {
      private LoadPlayerScoreImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadPlayerScoreImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: V (com.google.android.gms.common.api.Status) com.google.android.gms.games.leaderboard.Leaderboards$LoadPlayerScoreResult
      public Leaderboards.LoadPlayerScoreResult method_1447(final Status var1) {
         return new Leaderboards.LoadPlayerScoreResult() {
            public LeaderboardScore getScore() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1447(var1);
      }
   }

   private abstract static class LoadScoresImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LoadScoresResult> {
      private LoadScoresImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadScoresImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: W (com.google.android.gms.common.api.Status) com.google.android.gms.games.leaderboard.Leaderboards$LoadScoresResult
      public Leaderboards.LoadScoresResult method_1404(final Status var1) {
         return new Leaderboards.LoadScoresResult() {
            public Leaderboard getLeaderboard() {
               return null;
            }

            public LeaderboardScoreBuffer getScores() {
               return new LeaderboardScoreBuffer(DataHolder.method_5824(14));
            }

            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1404(var1);
      }
   }

   protected abstract static class SubmitScoreImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.SubmitScoreResult> {
      protected SubmitScoreImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: renamed from: X (com.google.android.gms.common.api.Status) com.google.android.gms.games.leaderboard.Leaderboards$SubmitScoreResult
      public Leaderboards.SubmitScoreResult method_1440(final Status var1) {
         return new Leaderboards.SubmitScoreResult() {
            public ScoreSubmissionData getScoreData() {
               return new ScoreSubmissionData(DataHolder.method_5824(14));
            }

            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1440(var1);
      }
   }
}
