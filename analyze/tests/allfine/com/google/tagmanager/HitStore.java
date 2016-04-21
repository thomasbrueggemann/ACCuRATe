package com.google.tagmanager;

import com.google.tagmanager.Dispatcher;

interface HitStore {
    void close();

    void dispatch();

    Dispatcher getDispatcher();

    void putHit(long var1, String var3);
}
