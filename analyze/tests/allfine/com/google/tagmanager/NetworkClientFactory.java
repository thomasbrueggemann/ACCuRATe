package com.google.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.HttpNetworkClient;
import com.google.tagmanager.HttpUrlConnectionNetworkClient;
import com.google.tagmanager.NetworkClient;

class NetworkClientFactory {
    public NetworkClient createNetworkClient() {
        return (NetworkClient)(this.getSdkVersion() < 8?new HttpNetworkClient():new HttpUrlConnectionNetworkClient());
    }

    @VisibleForTesting
    int getSdkVersion() {
        return VERSION.SDK_INT;
    }
}
