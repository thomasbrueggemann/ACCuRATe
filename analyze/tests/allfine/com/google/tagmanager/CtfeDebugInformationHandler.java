package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.ArrayUtils;
import com.google.tagmanager.CtfeHost;
import com.google.tagmanager.DebugInformationHandler;
import com.google.tagmanager.Log;
import com.google.tagmanager.NetworkClient;
import com.google.tagmanager.NetworkClientFactory;
import com.google.tagmanager.protobuf.nano.MessageNano;
import java.io.IOException;

class CtfeDebugInformationHandler implements DebugInformationHandler {
    @VisibleForTesting
    static final String CTFE_URL_PATH_PREFIX = "/d?";
    @VisibleForTesting
    static final int NUM_EVENTS_PER_SEND = 1;
    private int currentDebugEventNumber;
    private NetworkClient mClient;
    private CtfeHost mCtfeHost;
    private Debug.DebugEvents mDebugEvents;

    public CtfeDebugInformationHandler(CtfeHost var1) {
        this((new NetworkClientFactory()).createNetworkClient(), var1);
    }

    @VisibleForTesting
    CtfeDebugInformationHandler(NetworkClient var1, CtfeHost var2) {
        this.mCtfeHost = var2;
        this.mClient = var1;
        this.mDebugEvents = new Debug.DebugEvents();
    }

    private byte[] getDebugEventsAsBytes() throws IOException {
        return MessageNano.toByteArray(this.mDebugEvents);
    }

    private boolean sendDebugInformationtoCtfe() {
        try {
            NetworkClient var2 = this.mClient;
            CtfeHost var3 = this.mCtfeHost;
            int var4 = this.currentDebugEventNumber;
            this.currentDebugEventNumber = var4 + 1;
            var2.sendPostRequest(var3.constructCtfeDebugUrl(var4), this.getDebugEventsAsBytes());
            return true;
        } catch (IOException var5) {
            Log.method_5503("CtfeDebugInformationHandler: Error sending information to server that handles debug information: " + var5.getMessage());
            return false;
        }
    }

    public void receiveEventInfo(Debug.EventInfo var1) {
        synchronized(this) {}

        try {
            this.mDebugEvents.event = ArrayUtils.appendToArray(this.mDebugEvents.event, var1);
            if(this.mDebugEvents.event.length >= 1 && this.sendDebugInformationtoCtfe()) {
                this.mDebugEvents.clear();
            }
        } finally {
            ;
        }

    }
}
