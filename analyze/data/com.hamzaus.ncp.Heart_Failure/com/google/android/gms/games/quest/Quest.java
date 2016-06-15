package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.quest.Milestone;
import java.util.List;

public interface Quest extends Parcelable, Freezable<Quest> {
   int[] QUEST_STATE_ALL = new int[]{1, 2, 3, 4, 6, 5};
   String[] QUEST_STATE_NON_TERMINAL;
   int STATE_ACCEPTED = 3;
   int STATE_COMPLETED = 4;
   int STATE_EXPIRED = 5;
   int STATE_FAILED = 6;
   int STATE_OPEN = 2;
   int STATE_UPCOMING = 1;
   long UNSET_QUEST_TIMESTAMP = -1L;

   static default {
      String[] var0 = new String[]{Integer.toString(1), Integer.toString(2), Integer.toString(3)};
      QUEST_STATE_NON_TERMINAL = var0;
   }

   long getAcceptedTimestamp();

   Uri getBannerImageUri();

   @Deprecated
   String getBannerImageUrl();

   Milestone getCurrentMilestone();

   String getDescription();

   void getDescription(CharArrayBuffer var1);

   long getEndTimestamp();

   Game getGame();

   Uri getIconImageUri();

   @Deprecated
   String getIconImageUrl();

   long getLastUpdatedTimestamp();

   String getName();

   void getName(CharArrayBuffer var1);

   String getQuestId();

   long getStartTimestamp();

   int getState();

   int getType();

   // $FF: renamed from: iE () java.util.List
   List<Milestone> method_234();

   // $FF: renamed from: iF () long
   long method_235();

   boolean isEndingSoon();
}
