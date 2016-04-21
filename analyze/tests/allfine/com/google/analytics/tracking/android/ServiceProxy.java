package com.google.analytics.tracking.android;

import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

interface ServiceProxy {
    void clearHits();

    void createService();

    void dispatch();

    void putHit(Map<String, String> var1, long var2, String var4, List<Command> var5);

    void setForceLocalDispatch();
}
