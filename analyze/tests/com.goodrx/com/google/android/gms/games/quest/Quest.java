package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.quest.Milestone;
import java.util.List;

public interface Quest extends Parcelable, Freezable<Quest> {
   @KeepName
   int[] QUEST_STATE_ALL = new int[]{1, 2, 3, 4, 6, 5};
   @KeepName
   String[] QUEST_STATE_NON_TERMINAL;

   static default {
      String[] var0 = new String[]{Integer.toString(1), Integer.toString(2), Integer.toString(3)};
      QUEST_STATE_NON_TERMINAL = var0;
   }

   long getAcceptedTimestamp();

   Uri getBannerImageUri();

   @Deprecated
   @KeepName
   String getBannerImageUrl();

   String getDescription();

   long getEndTimestamp();

   Game getGame();

   Uri getIconImageUri();

   @Deprecated
   @KeepName
   String getIconImageUrl();

   long getLastUpdatedTimestamp();

   String getName();

   String getQuestId();

   long getStartTimestamp();

   int getState();

   int getType();

   List<Milestone> zzxR();

   long zzxS();
}
