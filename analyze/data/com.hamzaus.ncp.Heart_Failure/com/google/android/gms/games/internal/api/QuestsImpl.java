package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;

public final class QuestsImpl implements Quests {
   public PendingResult<Quests.AcceptQuestResult> accept(GoogleApiClient var1, final String var2) {
      return var1.method_773(new QuestsImpl.AcceptImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1124(GamesClientImpl var1) {
            var1.method_1633(this, var2);
         }
      });
   }

   public PendingResult<Quests.ClaimMilestoneResult> claim(GoogleApiClient var1, final String var2, final String var3) {
      return var1.method_773(new QuestsImpl.ClaimImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1102(GamesClientImpl var1) {
            var1.method_1565(this, var2, var3);
         }
      });
   }

   public Intent getQuestIntent(GoogleApiClient var1, String var2) {
      return Games.method_2780(var1).method_1556(var2);
   }

   public Intent getQuestsIntent(GoogleApiClient var1, int[] var2) {
      return Games.method_2780(var1).method_1511(var2);
   }

   public PendingResult<Quests.LoadQuestsResult> load(GoogleApiClient var1, final int[] var2, final int var3, final boolean var4) {
      return var1.method_772(new QuestsImpl.LoadsImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1180(GamesClientImpl var1) {
            var1.method_1545(this, var2, var3, var4);
         }
      });
   }

   public PendingResult<Quests.LoadQuestsResult> loadByIds(GoogleApiClient var1, final boolean var2, final String... var3) {
      return var1.method_772(new QuestsImpl.LoadsImpl(null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1177(GamesClientImpl var1) {
            var1.method_1570(this, var2, var3);
         }
      });
   }

   public void registerQuestUpdateListener(GoogleApiClient var1, QuestUpdateListener var2) {
      Games.method_2780(var1).method_1551(var2);
   }

   public void unregisterQuestUpdateListener(GoogleApiClient var1) {
      Games.method_2780(var1).method_1619();
   }

   private abstract static class AcceptImpl extends Games.BaseGamesApiMethodImpl<Quests.AcceptQuestResult> {
      private AcceptImpl() {
      }

      // $FF: synthetic method
      AcceptImpl(Object var1) {
         this();
      }

      // $FF: renamed from: S (com.google.android.gms.common.api.Status) com.google.android.gms.games.quest.Quests$AcceptQuestResult
      public Quests.AcceptQuestResult method_1123(final Status var1) {
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
      public Result method_884(Status var1) {
         return this.method_1123(var1);
      }
   }

   private abstract static class ClaimImpl extends Games.BaseGamesApiMethodImpl<Quests.ClaimMilestoneResult> {
      private ClaimImpl() {
      }

      // $FF: synthetic method
      ClaimImpl(Object var1) {
         this();
      }

      // $FF: renamed from: T (com.google.android.gms.common.api.Status) com.google.android.gms.games.quest.Quests$ClaimMilestoneResult
      public Quests.ClaimMilestoneResult method_1101(final Status var1) {
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
      public Result method_884(Status var1) {
         return this.method_1101(var1);
      }
   }

   private abstract static class LoadsImpl extends Games.BaseGamesApiMethodImpl<Quests.LoadQuestsResult> {
      private LoadsImpl() {
      }

      // $FF: synthetic method
      LoadsImpl(Object var1) {
         this();
      }

      // $FF: renamed from: U (com.google.android.gms.common.api.Status) com.google.android.gms.games.quest.Quests$LoadQuestsResult
      public Quests.LoadQuestsResult method_1176(final Status var1) {
         return new Quests.LoadQuestsResult() {
            public QuestBuffer getQuests() {
               return null;
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
         return this.method_1176(var1);
      }
   }
}
