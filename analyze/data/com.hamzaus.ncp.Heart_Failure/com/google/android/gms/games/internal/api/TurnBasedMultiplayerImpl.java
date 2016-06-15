package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
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
   public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> acceptInvitation(GoogleApiClient var1, final String var2) {
      return var1.method_773(new TurnBasedMultiplayerImpl.InitiateMatchImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1098(GamesClientImpl var1) {
            var1.method_1594(this, var2);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.CancelMatchResult> cancelMatch(GoogleApiClient var1, final String var2) {
      return var1.method_773(new TurnBasedMultiplayerImpl.CancelMatchImpl(var2) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1127(GamesClientImpl var1) {
            var1.method_1605(this, var2);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> createMatch(GoogleApiClient var1, final TurnBasedMatchConfig var2) {
      return var1.method_773(new TurnBasedMultiplayerImpl.InitiateMatchImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1099(GamesClientImpl var1) {
            var1.method_1518(this, var2);
         }
      });
   }

   public void declineInvitation(GoogleApiClient var1, String var2) {
      Games.method_2780(var1).method_1643(var2, 1);
   }

   public void dismissInvitation(GoogleApiClient var1, String var2) {
      Games.method_2780(var1).method_1641(var2, 1);
   }

   public void dismissMatch(GoogleApiClient var1, String var2) {
      Games.method_2780(var1).method_1555(var2);
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

   public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient var1, final String var2, final byte[] var3, final ParticipantResult... var4) {
      return var1.method_773(new TurnBasedMultiplayerImpl.UpdateMatchImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1145(GamesClientImpl var1) {
            var1.method_1540(this, var2, var3, var4);
         }
      });
   }

   public Intent getInboxIntent(GoogleApiClient var1) {
      return Games.method_2780(var1).method_1615();
   }

   public int getMaxMatchDataSize(GoogleApiClient var1) {
      return Games.method_2780(var1).method_1625();
   }

   public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3) {
      return Games.method_2780(var1).method_1507(var2, var3, true);
   }

   public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3, boolean var4) {
      return Games.method_2780(var1).method_1507(var2, var3, var4);
   }

   public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatch(GoogleApiClient var1, final String var2) {
      return var1.method_773(new TurnBasedMultiplayerImpl.LeaveMatchImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1076(GamesClientImpl var1) {
            var1.method_1600(this, var2);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient var1, final String var2, final String var3) {
      return var1.method_773(new TurnBasedMultiplayerImpl.LeaveMatchImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1075(GamesClientImpl var1) {
            var1.method_1528(this, var2, var3);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.LoadMatchResult> loadMatch(GoogleApiClient var1, final String var2) {
      return var1.method_772(new TurnBasedMultiplayerImpl.LoadMatchImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1094(GamesClientImpl var1) {
            var1.method_1614(this, var2);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient var1, final int var2, final int[] var3) {
      return var1.method_772(new TurnBasedMultiplayerImpl.LoadMatchesImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1073(GamesClientImpl var1) {
            var1.method_1516(this, var2, var3);
         }
      });
   }

   public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient var1, int[] var2) {
      return this.loadMatchesByStatus(var1, 0, var2);
   }

   public void registerMatchUpdateListener(GoogleApiClient var1, OnTurnBasedMatchUpdateReceivedListener var2) {
      Games.method_2780(var1).method_1550(var2);
   }

   public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> rematch(GoogleApiClient var1, final String var2) {
      return var1.method_773(new TurnBasedMultiplayerImpl.InitiateMatchImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1100(GamesClientImpl var1) {
            var1.method_1587(this, var2);
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

   public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient var1, final String var2, final byte[] var3, final String var4, final ParticipantResult... var5) {
      return var1.method_773(new TurnBasedMultiplayerImpl.UpdateMatchImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1144(GamesClientImpl var1) {
            var1.method_1539(this, var2, var3, var4, var5);
         }
      });
   }

   public void unregisterMatchUpdateListener(GoogleApiClient var1) {
      Games.method_2780(var1).method_1618();
   }

   private abstract static class CancelMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.CancelMatchResult> {
      // $FF: renamed from: xD java.lang.String
      private final String field_307;

      public CancelMatchImpl(String var1) {
         this.field_307 = var1;
      }

      // $FF: renamed from: ad (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$CancelMatchResult
      public TurnBasedMultiplayer.CancelMatchResult method_1126(final Status var1) {
         return new TurnBasedMultiplayer.CancelMatchResult() {
            public String getMatchId() {
               return CancelMatchImpl.this.field_307;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
      // $FF: synthetic method
      public Result method_884(Status var1) {
         return this.method_1126(var1);
      }
   }

   private abstract static class InitiateMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.InitiateMatchResult> {
      private InitiateMatchImpl() {
      }

      // $FF: synthetic method
      InitiateMatchImpl(Object var1) {
         this();
      }

      // $FF: renamed from: ae (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$InitiateMatchResult
      public TurnBasedMultiplayer.InitiateMatchResult method_1095(final Status var1) {
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
      public Result method_884(Status var1) {
         return this.method_1095(var1);
      }
   }

   private abstract static class LeaveMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LeaveMatchResult> {
      private LeaveMatchImpl() {
      }

      // $FF: synthetic method
      LeaveMatchImpl(Object var1) {
         this();
      }

      // $FF: renamed from: af (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$LeaveMatchResult
      public TurnBasedMultiplayer.LeaveMatchResult method_1074(final Status var1) {
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
      public Result method_884(Status var1) {
         return this.method_1074(var1);
      }
   }

   private abstract static class LoadMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchResult> {
      private LoadMatchImpl() {
      }

      // $FF: synthetic method
      LoadMatchImpl(Object var1) {
         this();
      }

      // $FF: renamed from: ag (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$LoadMatchResult
      public TurnBasedMultiplayer.LoadMatchResult method_1093(final Status var1) {
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
      public Result method_884(Status var1) {
         return this.method_1093(var1);
      }
   }

   private abstract static class LoadMatchesImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchesResult> {
      private LoadMatchesImpl() {
      }

      // $FF: synthetic method
      LoadMatchesImpl(Object var1) {
         this();
      }

      // $FF: renamed from: ah (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$LoadMatchesResult
      public TurnBasedMultiplayer.LoadMatchesResult method_1071(final Status var1) {
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
      public Result method_884(Status var1) {
         return this.method_1071(var1);
      }
   }

   private abstract static class UpdateMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.UpdateMatchResult> {
      private UpdateMatchImpl() {
      }

      // $FF: synthetic method
      UpdateMatchImpl(Object var1) {
         this();
      }

      // $FF: renamed from: ai (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$UpdateMatchResult
      public TurnBasedMultiplayer.UpdateMatchResult method_1143(final Status var1) {
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
      public Result method_884(Status var1) {
         return this.method_1143(var1);
      }
   }
}
