package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

interface AnalyticsClient {
    void clearHits();

    void connect();

    void disconnect();

    void sendHit(Map<String, String> var1, long var2, String var4, List<Command> var5);
}
