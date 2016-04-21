package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {
    public Game getCurrentGame(GoogleApiClient var1) {
        return Games.method_3257(var1).method_2002();
    }

    public PendingResult<GamesMetadata.LoadGamesResult> loadGame(GoogleApiClient var1) {
        return var1.method_897(new GamesMetadataImpl.LoadGamesImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1407(GamesClientImpl var1) {
                var1.method_1981(this);
            }
        });
    }

    private abstract static class LoadExtendedGamesImpl extends Games.BaseGamesApiMethodImpl<GamesMetadata.LoadExtendedGamesResult> {
        // $FF: renamed from: P (com.google.android.gms.common.api.Status) com.google.android.gms.games.GamesMetadata$LoadExtendedGamesResult
        public GamesMetadata.LoadExtendedGamesResult method_1447(final Status var1) {
            return new GamesMetadata.LoadExtendedGamesResult() {
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
            return this.method_1447(var1);
        }
    }

    private abstract static class LoadGameInstancesImpl extends Games.BaseGamesApiMethodImpl<GamesMetadata.LoadGameInstancesResult> {
        // $FF: renamed from: Q (com.google.android.gms.common.api.Status) com.google.android.gms.games.GamesMetadata$LoadGameInstancesResult
        public GamesMetadata.LoadGameInstancesResult method_1464(final Status var1) {
            return new GamesMetadata.LoadGameInstancesResult() {
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
            return this.method_1464(var1);
        }
    }

    private abstract static class LoadGameSearchSuggestionsImpl extends Games.BaseGamesApiMethodImpl<GamesMetadata.LoadGameSearchSuggestionsResult> {
        // $FF: renamed from: R (com.google.android.gms.common.api.Status) com.google.android.gms.games.GamesMetadata$LoadGameSearchSuggestionsResult
        public GamesMetadata.LoadGameSearchSuggestionsResult method_1445(final Status var1) {
            return new GamesMetadata.LoadGameSearchSuggestionsResult() {
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
            return this.method_1445(var1);
        }
    }

    private abstract static class LoadGamesImpl extends Games.BaseGamesApiMethodImpl<GamesMetadata.LoadGamesResult> {
        private LoadGamesImpl() {
        }

        // $FF: synthetic method
        LoadGamesImpl(Object var1) {
            this();
        }

        // $FF: renamed from: S (com.google.android.gms.common.api.Status) com.google.android.gms.games.GamesMetadata$LoadGamesResult
        public GamesMetadata.LoadGamesResult method_1406(final Status var1) {
            return new GamesMetadata.LoadGamesResult() {
                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.method_5982(14));
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
            return this.method_1406(var1);
        }
    }
}
