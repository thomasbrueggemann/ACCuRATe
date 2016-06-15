package com.google.android.gms.games.quest;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;

public interface Quests {
   String EXTRA_QUEST = "quest";
   int SELECT_ACCEPTED = 3;
   int SELECT_COMPLETED = 4;
   int SELECT_COMPLETED_UNCLAIMED = 101;
   int SELECT_ENDING_SOON = 102;
   int SELECT_EXPIRED = 5;
   int SELECT_FAILED = 6;
   int SELECT_OPEN = 2;
   int SELECT_UPCOMING = 1;
   int SORT_ORDER_ENDING_SOON_FIRST = 1;
   int SORT_ORDER_RECENTLY_UPDATED_FIRST;
   // $FF: renamed from: TW int[]
   int[] field_11 = new int[]{1, 2, 3, 4, 101, 5, 102, 6};

   PendingResult<Quests.AcceptQuestResult> accept(GoogleApiClient var1, String var2);

   PendingResult<Quests.ClaimMilestoneResult> claim(GoogleApiClient var1, String var2, String var3);

   Intent getQuestIntent(GoogleApiClient var1, String var2);

   Intent getQuestsIntent(GoogleApiClient var1, int[] var2);

   PendingResult<Quests.LoadQuestsResult> load(GoogleApiClient var1, int[] var2, int var3, boolean var4);

   PendingResult<Quests.LoadQuestsResult> loadByIds(GoogleApiClient var1, boolean var2, String... var3);

   void registerQuestUpdateListener(GoogleApiClient var1, QuestUpdateListener var2);

   void unregisterQuestUpdateListener(GoogleApiClient var1);

   public interface AcceptQuestResult extends Result {
      Quest getQuest();
   }

   public interface ClaimMilestoneResult extends Result {
      Milestone getMilestone();

      Quest getQuest();
   }

   public interface LoadQuestsResult extends Releasable, Result {
      QuestBuffer getQuests();
   }
}
