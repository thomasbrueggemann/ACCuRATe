package com.google.analytics.tracking.android;

import com.google.analytics.tracking.android.Hit;
import java.util.List;

interface Dispatcher {
    void close();

    int dispatchHits(List<Hit> var1);

    boolean okToDispatch();

    void overrideHostUrl(String var1);
}
