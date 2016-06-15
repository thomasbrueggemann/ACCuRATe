package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {
   public Player getCurrentPlayer(GoogleApiClient var1) {
      return Games.method_2780(var1).method_1609();
   }

   public String getCurrentPlayerId(GoogleApiClient var1) {
      return Games.method_2780(var1).method_1608();
   }

   public Intent getPlayerSearchIntent(GoogleApiClient var1) {
      return Games.method_2780(var1).method_1621();
   }

   public PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient var1, final boolean var2) {
      return var1.method_772(new PlayersImpl.LoadPlayersImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1173(GamesClientImpl var1) {
            var1.method_1542(this, var2);
         }
      });
   }

   public PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient var1, final int var2, final boolean var3) {
      return var1.method_772(new PlayersImpl.LoadPlayersImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1170(GamesClientImpl var1) {
            var1.method_1515(this, var2, false, var3);
         }
      });
   }

   public PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient var1, final int var2) {
      return var1.method_772(new PlayersImpl.LoadPlayersImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1169(GamesClientImpl var1) {
            var1.method_1515(this, var2, true, false);
         }
      });
   }

   public PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient var1, final int var2) {
      return var1.method_772(new PlayersImpl.LoadPlayersImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1167(GamesClientImpl var1) {
            var1.method_1524(this, "played_with", var2, true, false);
         }
      });
   }

   public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient var1, final String var2) {
      return var1.method_772(new PlayersImpl.LoadPlayersImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1172(GamesClientImpl var1) {
            var1.method_1520(this, var2);
         }
      });
   }

   public PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient var1, final int var2, final boolean var3) {
      return var1.method_772(new PlayersImpl.LoadPlayersImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1168(GamesClientImpl var1) {
            var1.method_1524(this, "played_with", var2, false, var3);
         }
      });
   }

   private abstract static class LoadOwnerCoverPhotoUrisImpl extends Games.BaseGamesApiMethodImpl<Players.LoadOwnerCoverPhotoUrisResult> {
      // $FF: renamed from: O (com.google.android.gms.common.api.Status) com.google.android.gms.games.Players$LoadOwnerCoverPhotoUrisResult
      public Players.LoadOwnerCoverPhotoUrisResult method_1128(final Status var1) {
         return new Players.LoadOwnerCoverPhotoUrisResult() {
            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1128(var1);
      }
   }

   private abstract static class LoadPlayersImpl extends Games.BaseGamesApiMethodImpl<Players.LoadPlayersResult> {
      private LoadPlayersImpl() {
      }

      // $FF: synthetic method
      LoadPlayersImpl(Object var1) {
         this();
      }

      // $FF: renamed from: P (com.google.android.gms.common.api.Status) com.google.android.gms.games.Players$LoadPlayersResult
      public Players.LoadPlayersResult method_1151(final Status var1) {
         return new Players.LoadPlayersResult() {
            public PlayerBuffer getPlayers() {
               return new PlayerBuffer(DataHolder.method_4552(14));
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
         return this.method_1151(var1);
      }
   }

   private abstract static class LoadXpForGameCategoriesResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadXpForGameCategoriesResult> {
      // $FF: renamed from: Q (com.google.android.gms.common.api.Status) com.google.android.gms.games.Players$LoadXpForGameCategoriesResult
      public Players.LoadXpForGameCategoriesResult method_1130(final Status var1) {
         return new Players.LoadXpForGameCategoriesResult() {
            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1130(var1);
      }
   }

   private abstract static class LoadXpForGameResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadXpForGamesResult> {
   }

   private abstract static class LoadXpStreamResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadXpStreamResult> {
      // $FF: renamed from: R (com.google.android.gms.common.api.Status) com.google.android.gms.games.Players$LoadXpStreamResult
      public Players.LoadXpStreamResult method_1132(final Status var1) {
         return new Players.LoadXpStreamResult() {
            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1132(var1);
      }
   }
}
