package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomRef;

public final class RoomBuffer extends g<Room> {
    public RoomBuffer(DataHolder var1) {
        super(var1);
    }

    // $FF: renamed from: f (int, int) java.lang.Object
    // $FF: synthetic method
    protected Object method_2903(int var1, int var2) {
        return this.method_2913(var1, var2);
    }

    // $FF: renamed from: gD () java.lang.String
    protected String method_2904() {
        return "external_match_id";
    }

    // $FF: renamed from: k (int, int) com.google.android.gms.games.multiplayer.realtime.Room
    protected Room method_2913(int var1, int var2) {
        return new RoomRef(this.II, var1, var2);
    }
}
