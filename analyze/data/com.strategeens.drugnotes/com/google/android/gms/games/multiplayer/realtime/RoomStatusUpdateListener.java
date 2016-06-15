package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.games.multiplayer.realtime.Room;
import java.util.List;

public interface RoomStatusUpdateListener {
   void onConnectedToRoom(Room var1);

   void onDisconnectedFromRoom(Room var1);

   void onP2PConnected(String var1);

   void onP2PDisconnected(String var1);

   void onPeerDeclined(Room var1, List<String> var2);

   void onPeerInvitedToRoom(Room var1, List<String> var2);

   void onPeerJoined(Room var1, List<String> var2);

   void onPeerLeft(Room var1, List<String> var2);

   void onPeersConnected(Room var1, List<String> var2);

   void onPeersDisconnected(Room var1, List<String> var2);

   void onRoomAutoMatching(Room var1);

   void onRoomConnecting(Room var1);
}
