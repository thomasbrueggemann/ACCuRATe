package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;

public final class QuestsImpl implements Quests {
    public PendingResult<Quests.AcceptQuestResult> accept(GoogleApiClient var1, final String var2) {
        return var1.method_899(new QuestsImpl.AcceptImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1380(GamesClientImpl var1) {
                var1.method_1994(this, var2);
            }
        });
    }

    public PendingResult<Quests.ClaimMilestoneResult> claim(GoogleApiClient var1, final String var2, final String var3) {
        return var1.method_899(new QuestsImpl.ClaimImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1358(GamesClientImpl var1) {
                var1.method_1944(this, var2, var3);
            }
        });
    }

    public Intent getQuestIntent(GoogleApiClient var1, String var2) {
        return Games.method_3257(var1).method_1952(var2);
    }

    public Intent getQuestsIntent(GoogleApiClient var1, int[] var2) {
        return Games.method_3257(var1).method_1937(var2);
    }

    public PendingResult<Quests.LoadQuestsResult> load(GoogleApiClient var1, final int[] var2, final int var3, final boolean var4) {
        return var1.method_897(new QuestsImpl.LoadsImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1442(GamesClientImpl var1) {
                var1.method_1926(this, var2, var3, var4);
            }
        });
    }

    public PendingResult<Quests.LoadQuestsResult> loadByIds(GoogleApiClient var1, final boolean var2, final String... var3) {
        return var1.method_897(new QuestsImpl.LoadsImpl(null) {
            // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
            protected void method_1439(GamesClientImpl var1) {
                var1.method_1949(this, var2, var3);
            }
        });
    }

    public void registerQuestUpdateListener(GoogleApiClient var1, QuestUpdateListener var2) {
        Games.method_3257(var1).method_1932(var2);
    }

    public void showStateChangedPopup(GoogleApiClient var1, String var2) {
        Games.method_3257(var1).method_1953(var2);
    }

    public void unregisterQuestUpdateListener(GoogleApiClient var1) {
        Games.method_3257(var1).method_2009();
    }

    private abstract static class AcceptImpl extends Games.BaseGamesApiMethodImpl<Quests.AcceptQuestResult> {
        private AcceptImpl() {
        }

        // $FF: synthetic method
        AcceptImpl(Object var1) {
            this();
        }

        // $FF: renamed from: ah (com.google.android.gms.common.api.Status) com.google.android.gms.games.quest.Quests$AcceptQuestResult
        public Quests.AcceptQuestResult method_1379(final Status var1) {
            return new Quests.AcceptQuestResult() {
                public Quest getQuest() {
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
            return this.method_1379(var1);
        }
    }

    private abstract static class ClaimImpl extends Games.BaseGamesApiMethodImpl<Quests.ClaimMilestoneResult> {
        private ClaimImpl() {
        }

        // $FF: synthetic method
        ClaimImpl(Object var1) {
            this();
        }

        // $FF: renamed from: ai (com.google.android.gms.common.api.Status) com.google.android.gms.games.quest.Quests$ClaimMilestoneResult
        public Quests.ClaimMilestoneResult method_1357(final Status var1) {
            return new Quests.ClaimMilestoneResult() {
                public Milestone getMilestone() {
                    return null;
                }

                public Quest getQuest() {
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
            return this.method_1357(var1);
        }
    }

    private abstract static class LoadsImpl extends Games.BaseGamesApiMethodImpl<Quests.LoadQuestsResult> {
        private LoadsImpl() {
        }

        // $FF: synthetic method
        LoadsImpl(Object var1) {
            this();
        }

        // $FF: renamed from: aj (com.google.android.gms.common.api.Status) com.google.android.gms.games.quest.Quests$LoadQuestsResult
        public Quests.LoadQuestsResult method_1438(final Status var1) {
            return new Quests.LoadQuestsResult() {
                public QuestBuffer getQuests() {
                    return new QuestBuffer(DataHolder.method_5982(var1.getStatusCode()));
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
            return this.method_1438(var1);
        }
    }
}
