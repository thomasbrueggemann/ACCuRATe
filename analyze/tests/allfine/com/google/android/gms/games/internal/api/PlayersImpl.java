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
        return Games.method_3257(var1).method_2001();
    }

    public String getCurrentPlayerId(GoogleApiClient var1) {
        return Games.method_3257(var1).method_2000();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient var1) {
        return Games.method_3257(var1).method_2011();
    }

    public PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient var1, final boolean var2) {
        return var1.method_897(new PlayersImpl.LoadPlayersImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1428(GamesClientImpl var1) {
                var1.method_1923(this, var2);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient var1, final int var2, final boolean var3) {
        return var1.method_897(new PlayersImpl.LoadPlayersImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1432(GamesClientImpl var1) {
                var1.method_1896(this, var2, false, var3);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient var1, final int var2) {
        return var1.method_897(new PlayersImpl.LoadPlayersImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1431(GamesClientImpl var1) {
                var1.method_1896(this, var2, true, false);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient var1, final int var2) {
        return var1.method_897(new PlayersImpl.LoadPlayersImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1429(GamesClientImpl var1) {
                var1.method_1905(this, "played_with", var2, true, false);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient var1, final String var2) {
        return var1.method_897(new PlayersImpl.LoadPlayersImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1434(GamesClientImpl var1) {
                var1.method_1901(this, var2);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient var1, final int var2, final boolean var3) {
        return var1.method_897(new PlayersImpl.LoadPlayersImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1430(GamesClientImpl var1) {
                var1.method_1905(this, "played_with", var2, false, var3);
            }
        });
    }

    private abstract static class LoadOwnerCoverPhotoUrisImpl extends Games.BaseGamesApiMethodImpl<Players.LoadOwnerCoverPhotoUrisResult> {
        // $FF: renamed from: ac (com.google.android.gms.common.api.Status) com.google.android.gms.games.Players$LoadOwnerCoverPhotoUrisResult
        public Players.LoadOwnerCoverPhotoUrisResult method_1384(final Status var1) {
            return new Players.LoadOwnerCoverPhotoUrisResult() {
                public Status getStatus() {
                    return var1;
                }
            };
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1384(var1);
        }
    }

    private abstract static class LoadPlayersImpl extends Games.BaseGamesApiMethodImpl<Players.LoadPlayersResult> {
        private LoadPlayersImpl() {
        }

        // $FF: synthetic method
        LoadPlayersImpl(Object var1) {
            this();
        }

        // $FF: renamed from: ad (com.google.android.gms.common.api.Status) com.google.android.gms.games.Players$LoadPlayersResult
        public Players.LoadPlayersResult method_1411(final Status var1) {
            return new Players.LoadPlayersResult() {
                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.method_5982(14));
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
            return this.method_1411(var1);
        }
    }

    private abstract static class LoadProfileSettingsResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadProfileSettingsResult> {
        // $FF: renamed from: ae (com.google.android.gms.common.api.Status) com.google.android.gms.games.Players$LoadProfileSettingsResult
        protected Players.LoadProfileSettingsResult method_1391(final Status var1) {
            return new Players.LoadProfileSettingsResult() {
                public Status getStatus() {
                    return var1;
                }

                public boolean isProfileVisible() {
                    return true;
                }

                public boolean isVisibilityExplicitlySet() {
                    return false;
                }
            };
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        protected Result method_1104(Status var1) {
            return this.method_1391(var1);
        }
    }

    private abstract static class LoadXpForGameCategoriesResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadXpForGameCategoriesResult> {
        // $FF: renamed from: af (com.google.android.gms.common.api.Status) com.google.android.gms.games.Players$LoadXpForGameCategoriesResult
        public Players.LoadXpForGameCategoriesResult method_1386(final Status var1) {
            return new Players.LoadXpForGameCategoriesResult() {
                public Status getStatus() {
                    return var1;
                }
            };
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1386(var1);
        }
    }

    private abstract static class LoadXpStreamResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadXpStreamResult> {
        // $FF: renamed from: ag (com.google.android.gms.common.api.Status) com.google.android.gms.games.Players$LoadXpStreamResult
        public Players.LoadXpStreamResult method_1388(final Status var1) {
            return new Players.LoadXpStreamResult() {
                public Status getStatus() {
                    return var1;
                }
            };
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1388(var1);
        }
    }

    private abstract static class UpdateProfileSettingsResultImpl extends Games.BaseGamesApiMethodImpl<Status> {
        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        protected Result method_1104(Status var1) {
            return this.method_1393(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        protected Status method_1393(Status var1) {
            return var1;
        }
    }
}
