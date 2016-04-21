package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {
    public Intent getAchievementsIntent(GoogleApiClient var1) {
        return Games.method_3257(var1).method_2004();
    }

    public void increment(GoogleApiClient var1, final String var2, final int var3) {
        var1.method_899(new AchievementsImpl.UpdateImpl(var2) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            public void method_1374(GamesClientImpl var1) {
                var1.method_1902((BaseImplementation.class_1147)null, var2, var3);
            }
        });
    }

    public PendingResult<Achievements.UpdateAchievementResult> incrementImmediate(GoogleApiClient var1, final String var2, final int var3) {
        return var1.method_899(new AchievementsImpl.UpdateImpl(var2) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            public void method_1373(GamesClientImpl var1) {
                var1.method_1902(this, var2, var3);
            }
        });
    }

    public PendingResult<Achievements.LoadAchievementsResult> load(GoogleApiClient var1, final boolean var2) {
        return var1.method_897(new AchievementsImpl.LoadImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            public void method_1325(GamesClientImpl var1) {
                var1.method_1964(this, var2);
            }
        });
    }

    public void reveal(GoogleApiClient var1, final String var2) {
        var1.method_899(new AchievementsImpl.UpdateImpl(var2) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            public void method_1371(GamesClientImpl var1) {
                var1.method_1940((BaseImplementation.class_1147)null, var2);
            }
        });
    }

    public PendingResult<Achievements.UpdateAchievementResult> revealImmediate(GoogleApiClient var1, final String var2) {
        return var1.method_899(new AchievementsImpl.UpdateImpl(var2) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            public void method_1370(GamesClientImpl var1) {
                var1.method_1940(this, var2);
            }
        });
    }

    public void setSteps(GoogleApiClient var1, final String var2, final int var3) {
        var1.method_899(new AchievementsImpl.UpdateImpl(var2) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            public void method_1372(GamesClientImpl var1) {
                var1.method_1941((BaseImplementation.class_1147)null, var2, var3);
            }
        });
    }

    public PendingResult<Achievements.UpdateAchievementResult> setStepsImmediate(GoogleApiClient var1, final String var2, final int var3) {
        return var1.method_899(new AchievementsImpl.UpdateImpl(var2) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            public void method_1376(GamesClientImpl var1) {
                var1.method_1941(this, var2, var3);
            }
        });
    }

    public void unlock(GoogleApiClient var1, final String var2) {
        var1.method_899(new AchievementsImpl.UpdateImpl(var2) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            public void method_1369(GamesClientImpl var1) {
                var1.method_1958((BaseImplementation.class_1147)null, var2);
            }
        });
    }

    public PendingResult<Achievements.UpdateAchievementResult> unlockImmediate(GoogleApiClient var1, final String var2) {
        return var1.method_899(new AchievementsImpl.UpdateImpl(var2) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            public void method_1375(GamesClientImpl var1) {
                var1.method_1958(this, var2);
            }
        });
    }

    private abstract static class LoadImpl extends Games.BaseGamesApiMethodImpl<Achievements.LoadAchievementsResult> {
        private LoadImpl() {
        }

        // $FF: synthetic method
        LoadImpl(Object var1) {
            this();
        }

        // $FF: renamed from: J (com.google.android.gms.common.api.Status) com.google.android.gms.games.achievement.Achievements$LoadAchievementsResult
        public Achievements.LoadAchievementsResult method_1324(final Status var1) {
            return new Achievements.LoadAchievementsResult() {
                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.method_5982(14));
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
            return this.method_1324(var1);
        }
    }

    private abstract static class UpdateImpl extends Games.BaseGamesApiMethodImpl<Achievements.UpdateAchievementResult> {
        // $FF: renamed from: BL java.lang.String
        private final String field_311;

        public UpdateImpl(String var1) {
            this.field_311 = var1;
        }

        // $FF: renamed from: K (com.google.android.gms.common.api.Status) com.google.android.gms.games.achievement.Achievements$UpdateAchievementResult
        public Achievements.UpdateAchievementResult method_1368(final Status var1) {
            return new Achievements.UpdateAchievementResult() {
                public String getAchievementId() {
                    return UpdateImpl.this.field_311;
                }

                public Status getStatus() {
                    return var1;
                }
            };
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        public Result method_1104(Status var1) {
            return this.method_1368(var1);
        }
    }
}
