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
        return var1.method_899(new TurnBasedMultiplayerImpl.InitiateMatchImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1354(GamesClientImpl var1) {
                var1.method_1977(this, var2);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.CancelMatchResult> cancelMatch(GoogleApiClient var1, final String var2) {
        return var1.method_899(new TurnBasedMultiplayerImpl.CancelMatchImpl(var2) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1383(GamesClientImpl var1) {
                var1.method_1987(this, var2);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> createMatch(GoogleApiClient var1, final TurnBasedMatchConfig var2) {
        return var1.method_899(new TurnBasedMultiplayerImpl.InitiateMatchImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1355(GamesClientImpl var1) {
                var1.method_1899(this, var2);
            }
        });
    }

    public void declineInvitation(GoogleApiClient var1, String var2) {
        Games.method_3257(var1).method_2029(var2, 1);
    }

    public void dismissInvitation(GoogleApiClient var1, String var2) {
        Games.method_3257(var1).method_2027(var2, 1);
    }

    public void dismissMatch(GoogleApiClient var1, String var2) {
        Games.method_3257(var1).method_1955(var2);
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
        return var1.method_899(new TurnBasedMultiplayerImpl.UpdateMatchImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1405(GamesClientImpl var1) {
                var1.method_1921(this, var2, var3, var4);
            }
        });
    }

    public Intent getInboxIntent(GoogleApiClient var1) {
        return Games.method_3257(var1).method_2005();
    }

    public int getMaxMatchDataSize(GoogleApiClient var1) {
        return Games.method_3257(var1).method_2015();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3) {
        return Games.method_3257(var1).method_1889(var2, var3, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3, boolean var4) {
        return Games.method_3257(var1).method_1889(var2, var3, var4);
    }

    public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatch(GoogleApiClient var1, final String var2) {
        return var1.method_899(new TurnBasedMultiplayerImpl.LeaveMatchImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1332(GamesClientImpl var1) {
                var1.method_1982(this, var2);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient var1, final String var2, final String var3) {
        return var1.method_899(new TurnBasedMultiplayerImpl.LeaveMatchImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1331(GamesClientImpl var1) {
                var1.method_1909(this, var2, var3);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.LoadMatchResult> loadMatch(GoogleApiClient var1, final String var2) {
        return var1.method_897(new TurnBasedMultiplayerImpl.LoadMatchImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1350(GamesClientImpl var1) {
                var1.method_1991(this, var2);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient var1, final int var2, final int[] var3) {
        return var1.method_897(new TurnBasedMultiplayerImpl.LoadMatchesImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1329(GamesClientImpl var1) {
                var1.method_1897(this, var2, var3);
            }
        });
    }

    public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient var1, int[] var2) {
        return this.loadMatchesByStatus(var1, 0, var2);
    }

    public void registerMatchUpdateListener(GoogleApiClient var1, OnTurnBasedMatchUpdateReceivedListener var2) {
        Games.method_3257(var1).method_1931(var2);
    }

    public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> rematch(GoogleApiClient var1, final String var2) {
        return var1.method_899(new TurnBasedMultiplayerImpl.InitiateMatchImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1356(GamesClientImpl var1) {
                var1.method_1968(this, var2);
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
        return var1.method_899(new TurnBasedMultiplayerImpl.UpdateMatchImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1404(GamesClientImpl var1) {
                var1.method_1920(this, var2, var3, var4, var5);
            }
        });
    }

    public void unregisterMatchUpdateListener(GoogleApiClient var1) {
        Games.method_3257(var1).method_2008();
    }

    private abstract static class CancelMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.CancelMatchResult> {
        // $FF: renamed from: BL java.lang.String
        private final String field_334;

        public CancelMatchImpl(String var1) {
            this.field_334 = var1;
        }

        // $FF: renamed from: as (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$CancelMatchResult
        public TurnBasedMultiplayer.CancelMatchResult method_1382(final Status var1) {
            return new TurnBasedMultiplayer.CancelMatchResult() {
                public String getMatchId() {
                    return CancelMatchImpl.this.field_334;
                }

                public Status getStatus() {
                    return var1;
                }
            };
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1382(var1);
        }
    }

    private abstract static class InitiateMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.InitiateMatchResult> {
        private InitiateMatchImpl() {
        }

        // $FF: synthetic method
        InitiateMatchImpl(Object var1) {
            this();
        }

        // $FF: renamed from: at (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$InitiateMatchResult
        public TurnBasedMultiplayer.InitiateMatchResult method_1351(final Status var1) {
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
        public Result method_1104(Status var1) {
            return this.method_1351(var1);
        }
    }

    private abstract static class LeaveMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LeaveMatchResult> {
        private LeaveMatchImpl() {
        }

        // $FF: synthetic method
        LeaveMatchImpl(Object var1) {
            this();
        }

        // $FF: renamed from: au (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$LeaveMatchResult
        public TurnBasedMultiplayer.LeaveMatchResult method_1330(final Status var1) {
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
        public Result method_1104(Status var1) {
            return this.method_1330(var1);
        }
    }

    private abstract static class LoadMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchResult> {
        private LoadMatchImpl() {
        }

        // $FF: synthetic method
        LoadMatchImpl(Object var1) {
            this();
        }

        // $FF: renamed from: av (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$LoadMatchResult
        public TurnBasedMultiplayer.LoadMatchResult method_1349(final Status var1) {
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
        public Result method_1104(Status var1) {
            return this.method_1349(var1);
        }
    }

    private abstract static class LoadMatchesImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchesResult> {
        private LoadMatchesImpl() {
        }

        // $FF: synthetic method
        LoadMatchesImpl(Object var1) {
            this();
        }

        // $FF: renamed from: aw (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$LoadMatchesResult
        public TurnBasedMultiplayer.LoadMatchesResult method_1327(final Status var1) {
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
        public Result method_1104(Status var1) {
            return this.method_1327(var1);
        }
    }

    private abstract static class UpdateMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.UpdateMatchResult> {
        private UpdateMatchImpl() {
        }

        // $FF: synthetic method
        UpdateMatchImpl(Object var1) {
            this();
        }

        // $FF: renamed from: ax (com.google.android.gms.common.api.Status) com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer$UpdateMatchResult
        public TurnBasedMultiplayer.UpdateMatchResult method_1403(final Status var1) {
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
        public Result method_1104(Status var1) {
            return this.method_1403(var1);
        }
    }
}
