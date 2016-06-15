package com.google.android.gms.games.multiplayer.realtime;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

public interface RealTimeMultiplayer {
   int REAL_TIME_MESSAGE_FAILED = -1;

   void create(GoogleApiClient var1, RoomConfig var2);

   void declineInvitation(GoogleApiClient var1, String var2);

   void dismissInvitation(GoogleApiClient var1, String var2);

   Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3);

   Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3, boolean var4);

   @Deprecated
   RealTimeSocket getSocketForParticipant(GoogleApiClient var1, String var2, String var3);

   Intent getWaitingRoomIntent(GoogleApiClient var1, Room var2, int var3);

   void join(GoogleApiClient var1, RoomConfig var2);

   void leave(GoogleApiClient var1, RoomUpdateListener var2, String var3);

   int sendReliableMessage(GoogleApiClient var1, RealTimeMultiplayer.ReliableMessageSentCallback var2, byte[] var3, String var4, String var5);

   int sendUnreliableMessage(GoogleApiClient var1, byte[] var2, String var3, String var4);

   int sendUnreliableMessage(GoogleApiClient var1, byte[] var2, String var3, List<String> var4);

   int sendUnreliableMessageToOthers(GoogleApiClient var1, byte[] var2, String var3);

   public interface ReliableMessageSentCallback {
      void onRealTimeMessageSent(int var1, int var2, String var3);
   }
}
