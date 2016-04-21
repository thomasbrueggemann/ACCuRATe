package com.google.android.gms.games.request;

import com.google.android.gms.games.request.GameRequest;

public interface OnRequestReceivedListener {
    void onRequestReceived(GameRequest var1);

    void onRequestRemoved(String var1);
}
