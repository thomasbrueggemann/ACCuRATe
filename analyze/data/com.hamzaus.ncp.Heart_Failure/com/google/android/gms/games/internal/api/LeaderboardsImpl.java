package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_797;
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
      return Games.method_2780(var1).method_1611();
   }

   public Intent getLeaderboardIntent(GoogleApiClient var1, String var2) {
      return Games.method_2780(var1).method_1554(var2);
   }

   public PendingResult<Leaderboards.LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient var1, final String var2, final int var3, final int var4) {
      return var1.method_772(new LeaderboardsImpl.LoadPlayerScoreImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1182(GamesClientImpl var1) {
            var1.method_1529(this, (String)null, var2, var3, var4);
         }
      });
   }

   public PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient var1, final String var2, final boolean var3) {
      return var1.method_772(new LeaderboardsImpl.LoadMetadataImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1216(GamesClientImpl var1) {
            var1.method_1538(this, var2, var3);
         }
      });
   }

   public PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient var1, final boolean var2) {
      return var1.method_772(new LeaderboardsImpl.LoadMetadataImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1215(GamesClientImpl var1) {
            var1.method_1569(this, var2);
         }
      });
   }

   public PendingResult<Leaderboards.LoadScoresResult> loadMoreScores(GoogleApiClient var1, final LeaderboardScoreBuffer var2, final int var3, final int var4) {
      return var1.method_772(new LeaderboardsImpl.LoadScoresImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1140(GamesClientImpl var1) {
            var1.method_1517(this, var2, var3, var4);
         }
      });
   }

   public PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient var1, String var2, int var3, int var4, int var5) {
      return this.loadPlayerCenteredScores(var1, var2, var3, var4, var5, false);
   }

   public PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient var1, final String var2, final int var3, final int var4, final int var5, final boolean var6) {
      return var1.method_772(new LeaderboardsImpl.LoadScoresImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1139(GamesClientImpl var1) {
            var1.method_1563(this, var2, var3, var4, var5, var6);
         }
      });
   }

   public PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient var1, String var2, int var3, int var4, int var5) {
      return this.loadTopScores(var1, var2, var3, var4, var5, false);
   }

   public PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient var1, final String var2, final int var3, final int var4, final int var5, final boolean var6) {
      return var1.method_772(new LeaderboardsImpl.LoadScoresImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1138(GamesClientImpl var1) {
            var1.method_1522(this, var2, var3, var4, var5, var6);
         }
      });
   }

   public void submitScore(GoogleApiClient var1, String var2, long var3) {
      this.submitScore(var1, var2, var3, (String)null);
   }

   public void submitScore(GoogleApiClient var1, String var2, long var3, String var5) {
      Games.method_2780(var1).method_1527((class_797.class_1206)null, var2, var3, var5);
   }

   public PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient var1, String var2, long var3) {
      return this.submitScoreImmediate(var1, var2, var3, (String)null);
   }

   public PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient var1, final String var2, final long var3, final String var5) {
      return var1.method_773(new LeaderboardsImpl.SubmitScoreImpl() {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1175(GamesClientImpl var1) {
            var1.method_1527(this, var2, var3, var5);
         }
      });
   }

   private abstract static class LoadMetadataImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LeaderboardMetadataResult> {
      private LoadMetadataImpl() {
      }

      // $FF: synthetic method
      LoadMetadataImpl(Object var1) {
         this();
      }

      // $FF: renamed from: G (com.google.android.gms.common.api.Status) com.google.android.gms.games.leaderboard.Leaderboards$LeaderboardMetadataResult
      public Leaderboards.LeaderboardMetadataResult method_1214(final Status var1) {
         return new Leaderboards.LeaderboardMetadataResult() {
            public LeaderboardBuffer getLeaderboards() {
               return new LeaderboardBuffer(DataHolder.method_4552(14));
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
      public Result method_884(Status var1) {
         return this.method_1214(var1);
      }
   }

   private abstract static class LoadPlayerScoreImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LoadPlayerScoreResult> {
      private LoadPlayerScoreImpl() {
      }

      // $FF: synthetic method
      LoadPlayerScoreImpl(Object var1) {
         this();
      }

      // $FF: renamed from: H (com.google.android.gms.common.api.Status) com.google.android.gms.games.leaderboard.Leaderboards$LoadPlayerScoreResult
      public Leaderboards.LoadPlayerScoreResult method_1181(final Status var1) {
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
      public Result method_884(Status var1) {
         return this.method_1181(var1);
      }
   }

   private abstract static class LoadScoresImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LoadScoresResult> {
      private LoadScoresImpl() {
      }

      // $FF: synthetic method
      LoadScoresImpl(Object var1) {
         this();
      }

      // $FF: renamed from: I (com.google.android.gms.common.api.Status) com.google.android.gms.games.leaderboard.Leaderboards$LoadScoresResult
      public Leaderboards.LoadScoresResult method_1137(final Status var1) {
         return new Leaderboards.LoadScoresResult() {
            public Leaderboard getLeaderboard() {
               return null;
            }

            public LeaderboardScoreBuffer getScores() {
               return new LeaderboardScoreBuffer(DataHolder.method_4552(14));
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
      public Result method_884(Status var1) {
         return this.method_1137(var1);
      }
   }

   protected abstract static class SubmitScoreImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.SubmitScoreResult> {
      // $FF: renamed from: J (com.google.android.gms.common.api.Status) com.google.android.gms.games.leaderboard.Leaderboards$SubmitScoreResult
      public Leaderboards.SubmitScoreResult method_1174(final Status var1) {
         return new Leaderboards.SubmitScoreResult() {
            public ScoreSubmissionData getScoreData() {
               return new ScoreSubmissionData(DataHolder.method_4552(14));
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
      public Result method_884(Status var1) {
         return this.method_1174(var1);
      }
   }
}
