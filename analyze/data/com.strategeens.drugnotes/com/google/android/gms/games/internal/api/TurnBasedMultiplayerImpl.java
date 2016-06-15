package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_1033;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {
   public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> acceptInvitation(final GoogleApiClient var1, final String var2) {
      return var1.method_944(new TurnBasedMultiplayerImpl.InitiateMatchImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1361(GamesClientImpl var1) {
            var1.method_1953(this, var2);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.CancelMatchResult> cancelMatch(final GoogleApiClient var1, final String var2) {
      return var1.method_944(new TurnBasedMultiplayerImpl.CancelMatchImpl(var2, var1) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1390(GamesClientImpl var1) {
            var1.method_1968(this, var2);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> createMatch(final GoogleApiClient var1, final TurnBasedMatchConfig var2) {
      return var1.method_944(new TurnBasedMultiplayerImpl.InitiateMatchImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1362(GamesClientImpl var1) {
            var1.method_1886(this, var2);
         }
      });
   }

   public void declineInvitation(GoogleApiClient var1, String var2) {
      Games.method_3259(var1).method_2014(var2, 1);
   }

   public void dismissInvitation(GoogleApiClient var1, String var2) {
      Games.method_3259(var1).method_2013(var2, 1);
   }

   public void dismissMatch(GoogleApiClient var1, String var2) {
      Games.method_3259(var1).method_1937(var2);
   }

   public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient var1, String var2) {
      return this.finishMatch(var1, var2, (byte[])null, (ParticipantResult[])((ParticipantResult[])null));
   }

   public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient var1, String var2, byte[] var3, List<ParticipantResult> var4) {
      ParticipantResult[] var5;
      if(var4 == null) {
         var5 = null;
      } else {
         var5 = (ParticipantResult[])var4.toArray(new ParticipantResult[var4.size()]);
      }

      return this.finishMatch(var1, var2, var3, var5);
   }

   public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(final GoogleApiClient var1, final String var2, final byte[] var3, final ParticipantResult... var4) {
      return var1.method_944(new TurnBasedMultiplayerImpl.UpdateMatchImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1412(GamesClientImpl var1) {
            var1.method_1907(this, var2, var3, var4);
         }
      });
   }

   public Intent getInboxIntent(GoogleApiClient var1) {
      return Games.method_3259(var1).method_1994();
   }

   public int getMaxMatchDataSize(GoogleApiClient var1) {
      return Games.method_3259(var1).method_2004();
   }

   public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3) {
      return Games.method_3259(var1).method_1875(var2, var3, true);
   }

   public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3, boolean var4) {
      return Games.method_3259(var1).method_1875(var2, var3, var4);
   }

   public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatch(final GoogleApiClient var1, final String var2) {
      return var1.method_944(new TurnBasedMultiplayerImpl.LeaveMatchImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1339(GamesClientImpl var1) {
            var1.method_1962(this, var2);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatchDuringTurn(final GoogleApiClient var1, final String var2, final String var3) {
      return var1.method_944(new TurnBasedMultiplayerImpl.LeaveMatchImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1338(GamesClientImpl var1) {
            var1.method_1895(this, var2, var3);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.LoadMatchResult> loadMatch(final GoogleApiClient var1, final String var2) {
      return var1.method_942(new TurnBasedMultiplayerImpl.LoadMatchImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1357(GamesClientImpl var1) {
            var1.method_1973(this, var2);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(final GoogleApiClient var1, final int var2, final int[] var3) {
      return var1.method_942(new TurnBasedMultiplayerImpl.LoadMatchesImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1336(GamesClientImpl var1) {
            var1.method_1884(this, var2, var3);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient var1, int[] var2) {
      return this.loadMatchesByStatus(var1, 0, var2);
   }

   public void registerMatchUpdateListener(GoogleApiClient var1, OnTurnBasedMatchUpdateReceivedListener var2) {
      class_1033 var3 = var1.method_945(var2);
      Games.method_3259(var1).method_1935(var3);
   }

   public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> rematch(final GoogleApiClient var1, final String var2) {
      return var1.method_944(new TurnBasedMultiplayerImpl.InitiateMatchImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1363(GamesClientImpl var1) {
            var1.method_1942(this, var2);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient var1, String var2, byte[] var3, String var4) {
      return this.takeTurn(var1, var2, var3, var4, (ParticipantResult[])null);
   }

   public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient var1, String var2, byte[] var3, String var4, List<ParticipantResult> var5) {
      ParticipantResult[] var6;
      if(var5 == null) {
         var6 = null;
      } else {
         var6 = (ParticipantResult[])var5.toArray(new ParticipantResult[var5.size()]);
      }

      return this.takeTurn(var1, var2, var3, var4, var6);
   }

   public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(final GoogleApiClient var1, final String var2, final byte[] var3, final String var4, final ParticipantResult... var5) {
      return var1.method_944(new TurnBasedMultiplayerImpl.UpdateMatchImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1411(GamesClientImpl var1) {
            var1.method_1906(this, var2, var3, var4, var5);
         }
      });
   }

   public void unregisterMatchUpdateListener(GoogleApiClient var1) {
      Games.method_3259(var1).method_1997();
   }

   private abstract static class CancelMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.CancelMatchResult> {
      // $FF: renamed from: CE java.lang.String
      private final String field_274;

      public CancelMatchImpl(String var1, GoogleApiClient var2) {
         super(var2);
         this.field_274 = var1;
      }

      // $FF: renamed from: as (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$CancelMatchResult
      public TurnBasedMultiplayer.CancelMatchResult method_1389(final Status var1) {
         return new TurnBasedMultiplayer.CancelMatchResult() {
            public String getMatchId() {
               return CancelMatchImpl.this.field_274;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_1109(Status var1) {
         return this.method_1389(var1);
      }
   }

   private abstract static class InitiateMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.InitiateMatchResult> {
      private InitiateMatchImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      InitiateMatchImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: at (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$InitiateMatchResult
      public TurnBasedMultiplayer.InitiateMatchResult method_1358(final Status var1) {
         return new TurnBasedMultiplayer.InitiateMatchResult() {
            public TurnBasedMatch getMatch() {
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
         return this.method_1358(var1);
      }
   }

   private abstract static class LeaveMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LeaveMatchResult> {
      private LeaveMatchImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LeaveMatchImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: au (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$LeaveMatchResult
      public TurnBasedMultiplayer.LeaveMatchResult method_1337(final Status var1) {
         return new TurnBasedMultiplayer.LeaveMatchResult() {
            public TurnBasedMatch getMatch() {
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
         return this.method_1337(var1);
      }
   }

   private abstract static class LoadMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchResult> {
      private LoadMatchImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadMatchImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: av (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$LoadMatchResult
      public TurnBasedMultiplayer.LoadMatchResult method_1356(final Status var1) {
         return new TurnBasedMultiplayer.LoadMatchResult() {
            public TurnBasedMatch getMatch() {
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
         return this.method_1356(var1);
      }
   }

   private abstract static class LoadMatchesImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchesResult> {
      private LoadMatchesImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadMatchesImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: aw (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$LoadMatchesResult
      public TurnBasedMultiplayer.LoadMatchesResult method_1334(final Status var1) {
         return new TurnBasedMultiplayer.LoadMatchesResult() {
            public LoadMatchesResponse getMatches() {
               return new LoadMatchesResponse(new Bundle());
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
         return this.method_1334(var1);
      }
   }

   private abstract static class UpdateMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.UpdateMatchResult> {
      private UpdateMatchImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      UpdateMatchImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: ax (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$UpdateMatchResult
      public TurnBasedMultiplayer.UpdateMatchResult method_1410(final Status var1) {
         return new TurnBasedMultiplayer.UpdateMatchResult() {
            public TurnBasedMatch getMatch() {
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
         return this.method_1410(var1);
      }
   }
}
