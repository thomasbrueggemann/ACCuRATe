package com.google.tagmanager;

interface HitSendingThread {
    void queueToThread(Runnable var1);

    void sendHit(String var1);
}
