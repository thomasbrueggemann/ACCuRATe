package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;

interface DebugInformationHandler {
    void receiveEventInfo(Debug.EventInfo var1);
}
