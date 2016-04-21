package com.google.analytics.tracking.android;

import com.google.analytics.tracking.android.Dispatcher;
import com.google.android.gms.analytics.internal.Command;
import java.util.Collection;
import java.util.Map;

interface AnalyticsStore {
    void clearHits(long var1);

    void close();

    void dispatch();

    Dispatcher getDispatcher();

    void putHit(Map<String, String> var1, long var2, String var4, Collection<Command> var5);

    void setDispatch(boolean var1);
}
