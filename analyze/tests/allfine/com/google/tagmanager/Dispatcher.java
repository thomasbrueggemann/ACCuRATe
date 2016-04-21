package com.google.tagmanager;

import com.google.tagmanager.Hit;
import java.util.List;

interface Dispatcher {
    void close();

    void dispatchHits(List<Hit> var1);

    boolean okToDispatch();
}
