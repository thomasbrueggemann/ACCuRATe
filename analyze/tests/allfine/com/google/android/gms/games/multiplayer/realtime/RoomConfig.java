package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomConfig {
    // $FF: renamed from: WO java.lang.String
    private final String field_3452;
    private final int acd;
    private final RoomUpdateListener aco;
    private final RoomStatusUpdateListener acp;
    private final RealTimeMessageReceivedListener acq;
    private final String[] acr;
    private final Bundle acs;
    private final boolean act;

    private RoomConfig(RoomConfig.Builder var1) {
        this.aco = var1.aco;
        this.acp = var1.acp;
        this.acq = var1.acq;
        this.field_3452 = var1.acu;
        this.acd = var1.acd;
        this.acs = var1.acs;
        this.act = var1.act;
        int var2 = var1.acv.size();
        this.acr = (String[])var1.acv.toArray(new String[var2]);
        if(this.acq == null) {
            class_1090.method_5676(this.act, "Must either enable sockets OR specify a message listener");
        }

    }

    // $FF: synthetic method
    RoomConfig(RoomConfig.Builder var1, Object var2) {
        this(var1);
    }

    public static RoomConfig.Builder builder(RoomUpdateListener var0) {
        return new RoomConfig.Builder(var0);
    }

    public static Bundle createAutoMatchCriteria(int var0, int var1, long var2) {
        Bundle var4 = new Bundle();
        var4.putInt("min_automatch_players", var0);
        var4.putInt("max_automatch_players", var1);
        var4.putLong("exclusive_bit_mask", var2);
        return var4;
    }

    public Bundle getAutoMatchCriteria() {
        return this.acs;
    }

    public String getInvitationId() {
        return this.field_3452;
    }

    public String[] getInvitedPlayerIds() {
        return this.acr;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.acq;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.acp;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.aco;
    }

    public int getVariant() {
        return this.acd;
    }

    public boolean isSocketEnabled() {
        return this.act;
    }

    public static final class Builder {
        int acd;
        final RoomUpdateListener aco;
        RoomStatusUpdateListener acp;
        RealTimeMessageReceivedListener acq;
        Bundle acs;
        boolean act;
        String acu;
        ArrayList<String> acv;

        private Builder(RoomUpdateListener var1) {
            this.acu = null;
            this.acd = -1;
            this.acv = new ArrayList();
            this.act = false;
            this.aco = (RoomUpdateListener)class_1090.method_5681(var1, "Must provide a RoomUpdateListener");
        }

        // $FF: synthetic method
        Builder(RoomUpdateListener var1, Object var2) {
            this(var1);
        }

        public RoomConfig.Builder addPlayersToInvite(ArrayList<String> var1) {
            class_1090.method_5685(var1);
            this.acv.addAll(var1);
            return this;
        }

        public RoomConfig.Builder addPlayersToInvite(String... var1) {
            class_1090.method_5685(var1);
            this.acv.addAll(Arrays.asList(var1));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfig(this);
        }

        public RoomConfig.Builder setAutoMatchCriteria(Bundle var1) {
            this.acs = var1;
            return this;
        }

        public RoomConfig.Builder setInvitationIdToAccept(String var1) {
            class_1090.method_5685(var1);
            this.acu = var1;
            return this;
        }

        public RoomConfig.Builder setMessageReceivedListener(RealTimeMessageReceivedListener var1) {
            this.acq = var1;
            return this;
        }

        public RoomConfig.Builder setRoomStatusUpdateListener(RoomStatusUpdateListener var1) {
            this.acp = var1;
            return this;
        }

        public RoomConfig.Builder setSocketCommunicationEnabled(boolean var1) {
            this.act = var1;
            return this;
        }

        public RoomConfig.Builder setVariant(int var1) {
            boolean var2;
            if(var1 != -1 && var1 <= 0) {
                var2 = false;
            } else {
                var2 = true;
            }

            class_1090.method_5683(var2, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.acd = var1;
            return this;
        }
    }
}
