package com.google.tagmanager;

abstract class ServiceManager {
    abstract void dispatch();

    abstract void onRadioPowered();

    abstract void setDispatchPeriod(int var1);

    abstract void updateConnectivityStatus(boolean var1);
}
