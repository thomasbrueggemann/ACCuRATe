package com.google.android.gms.games;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

public interface Notifications {
   int NOTIFICATION_TYPES_ALL = 31;
   int NOTIFICATION_TYPES_MULTIPLAYER = 3;
   int NOTIFICATION_TYPE_INVITATION = 1;
   int NOTIFICATION_TYPE_LEVEL_UP = 16;
   int NOTIFICATION_TYPE_MATCH_UPDATE = 2;
   int NOTIFICATION_TYPE_QUEST = 8;
   int NOTIFICATION_TYPE_REQUEST = 4;

   void clear(GoogleApiClient var1, int var2);

   void clearAll(GoogleApiClient var1);

   public interface ContactSettingLoadResult extends Result {
   }

   public interface GameMuteStatusChangeResult extends Result {
   }

   public interface GameMuteStatusLoadResult extends Result {
   }

   public interface InboxCountResult extends Result {
   }
}
