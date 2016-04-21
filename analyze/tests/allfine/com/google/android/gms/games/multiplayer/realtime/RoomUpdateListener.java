package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.games.multiplayer.realtime.Room;

public interface RoomUpdateListener {
    void onJoinedRoom(int var1, Room var2);

    void onLeftRoom(int var1, String var2);

    void onRoomConnected(int var1, Room var2);

    void onRoomCreated(int var1, Room var2);
}
