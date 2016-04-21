package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

public final class RealTimeMultiplayerImpl implements RealTimeMultiplayer {
    public void create(GoogleApiClient var1, RoomConfig var2) {
        Games.method_3257(var1).method_1929(var2);
    }

    public void declineInvitation(GoogleApiClient var1, String var2) {
        Games.method_3257(var1).method_2029(var2, 0);
    }

    public void dismissInvitation(GoogleApiClient var1, String var2) {
        Games.method_3257(var1).method_2027(var2, 0);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3) {
        return Games.method_3257(var1).method_1936(var2, var3, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3, boolean var4) {
        return Games.method_3257(var1).method_1936(var2, var3, var4);
    }

    public RealTimeSocket getSocketForParticipant(GoogleApiClient var1, String var2, String var3) {
        return Games.method_3257(var1).method_2031(var2, var3);
    }

    public Intent getWaitingRoomIntent(GoogleApiClient var1, Room var2, int var3) {
        return Games.method_3257(var1).method_1891(var2, var3);
    }

    public void join(GoogleApiClient var1, RoomConfig var2) {
        Games.method_3257(var1).method_1951(var2);
    }

    public void leave(GoogleApiClient var1, RoomUpdateListener var2, String var3) {
        Games.method_3257(var1).method_1930(var2, var3);
    }

    public int sendReliableMessage(GoogleApiClient var1, RealTimeMultiplayer.ReliableMessageSentCallback var2, byte[] var3, String var4, String var5) {
        return Games.method_3257(var1).method_1887(var2, var3, var4, var5);
    }

    public int sendUnreliableMessage(GoogleApiClient var1, byte[] var2, String var3, String var4) {
        return Games.method_3257(var1).method_1888(var2, var3, new String[] {var4});
    }

    public int sendUnreliableMessage(GoogleApiClient var1, byte[] var2, String var3, List<String> var4) {
        String[] var5 = (String[])var4.toArray(new String[var4.size()]);
        return Games.method_3257(var1).method_1888(var2, var3, var5);
    }

    public int sendUnreliableMessageToOthers(GoogleApiClient var1, byte[] var2, String var3) {
        return Games.method_3257(var1).method_1966(var2, var3);
    }
}
