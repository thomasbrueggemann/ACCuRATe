package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.class_1033;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;

public final class QuestsImpl implements Quests {
   public PendingResult<Quests.AcceptQuestResult> accept(final GoogleApiClient var1, final String var2) {
      return var1.method_944(new QuestsImpl.AcceptImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1387(GamesClientImpl var1) {
            var1.method_1976(this, var2);
         }
      });
   }

   public PendingResult<Quests.ClaimMilestoneResult> claim(final GoogleApiClient var1, final String var2, final String var3) {
      return var1.method_944(new QuestsImpl.ClaimImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1365(GamesClientImpl var1) {
            var1.method_1927(this, var2, var3);
         }
      });
   }

   public Intent getQuestIntent(GoogleApiClient var1, String var2) {
      return Games.method_3259(var1).method_1938(var2);
   }

   public Intent getQuestsIntent(GoogleApiClient var1, int[] var2) {
      return Games.method_3259(var1).method_1920(var2);
   }

   public PendingResult<Quests.LoadQuestsResult> load(final GoogleApiClient var1, final int[] var2, final int var3, final boolean var4) {
      return var1.method_942(new QuestsImpl.LoadsImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1446(GamesClientImpl var1) {
            var1.method_1912(this, var2, var3, var4);
         }
      });
   }

   public PendingResult<Quests.LoadQuestsResult> loadByIds(final GoogleApiClient var1, final boolean var2, final String... var3) {
      return var1.method_942(new QuestsImpl.LoadsImpl(var1, null) {
         // $FF: renamed from: a (com.google.android.gms.games.internal.GamesClientImpl) void
         protected void method_1443(GamesClientImpl var1) {
            var1.method_1933(this, var2, var3);
         }
      });
   }

   public void registerQuestUpdateListener(GoogleApiClient var1, QuestUpdateListener var2) {
      class_1033 var3 = var1.method_945(var2);
      Games.method_3259(var1).method_1950(var3);
   }

   public void showStateChangedPopup(GoogleApiClient var1, String var2) {
      Games.method_3259(var1).method_1939(var2);
   }

   public void unregisterQuestUpdateListener(GoogleApiClient var1) {
      Games.method_3259(var1).method_1998();
   }

   private abstract static class AcceptImpl extends Games.BaseGamesApiMethodImpl<Quests.AcceptQuestResult> {
      private AcceptImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      AcceptImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: ah (com.google.android.gms.common.api.Status) com.google.android.gms.games.quest.Quests$AcceptQuestResult
      public Quests.AcceptQuestResult method_1386(final Status var1) {
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
      public Result method_1109(Status var1) {
         return this.method_1386(var1);
      }
   }

   private abstract static class ClaimImpl extends Games.BaseGamesApiMethodImpl<Quests.ClaimMilestoneResult> {
      private ClaimImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      ClaimImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: ai (com.google.android.gms.common.api.Status) com.google.android.gms.games.quest.Quests$ClaimMilestoneResult
      public Quests.ClaimMilestoneResult method_1364(final Status var1) {
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
      public Result method_1109(Status var1) {
         return this.method_1364(var1);
      }
   }

   private abstract static class LoadsImpl extends Games.BaseGamesApiMethodImpl<Quests.LoadQuestsResult> {
      private LoadsImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadsImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: aj (com.google.android.gms.common.api.Status) com.google.android.gms.games.quest.Quests$LoadQuestsResult
      public Quests.LoadQuestsResult method_1442(final Status var1) {
         return new Quests.LoadQuestsResult() {
            public QuestBuffer getQuests() {
               return new QuestBuffer(DataHolder.method_5824(var1.getStatusCode()));
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
         return this.method_1442(var1);
      }
   }
}
