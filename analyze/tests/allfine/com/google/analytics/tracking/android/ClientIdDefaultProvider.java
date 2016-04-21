package com.google.analytics.tracking.android;

import android.content.Context;
import com.google.analytics.tracking.android.DefaultProvider;
import com.google.analytics.tracking.android.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class ClientIdDefaultProvider implements DefaultProvider {
    private static ClientIdDefaultProvider sInstance;
    private static final Object sInstanceLock = new Object();
    private String mClientId;
    private boolean mClientIdLoaded = false;
    private final Object mClientIdLock = new Object();
    private final Context mContext;

    protected ClientIdDefaultProvider(Context var1) {
        this.mContext = var1;
        this.asyncInitializeClientId();
    }

    // $FF: synthetic method
    static Object access$000(ClientIdDefaultProvider var0) {
        return var0.mClientIdLock;
    }

    // $FF: synthetic method
    static String access$102(ClientIdDefaultProvider var0, String var1) {
        var0.mClientId = var1;
        return var1;
    }

    // $FF: synthetic method
    static boolean access$202(ClientIdDefaultProvider var0, boolean var1) {
        var0.mClientIdLoaded = var1;
        return var1;
    }

    private void asyncInitializeClientId() {
        (new Thread("client_id_fetcher") {
            public void run() {
                // $FF: Couldn't be decompiled
            }
        }).start();
    }

    private String blockingGetClientId() {
        // $FF: Couldn't be decompiled
    }

    @VisibleForTesting
    static void dropInstance() {
        // $FF: Couldn't be decompiled
    }

    public static ClientIdDefaultProvider getProvider() {
        // $FF: Couldn't be decompiled
    }

    public static void initializeProvider(Context param0) {
        // $FF: Couldn't be decompiled
    }

    private boolean storeClientId(String var1) {
        try {
            Log.method_2106("Storing clientId.");
            FileOutputStream var4 = this.mContext.openFileOutput("gaClientId", 0);
            var4.write(var1.getBytes());
            var4.close();
            return true;
        } catch (FileNotFoundException var5) {
            Log.method_2104("Error creating clientId file.");
            return false;
        } catch (IOException var6) {
            Log.method_2104("Error writing to clientId file.");
            return false;
        }
    }

    protected String generateClientId() {
        String var1 = UUID.randomUUID().toString().toLowerCase();
        if(!this.storeClientId(var1)) {
            var1 = "0";
        }

        return var1;
    }

    public String getValue(String var1) {
        return "&cid".equals(var1)?this.blockingGetClientId():null;
    }

    @VisibleForTesting
    String initializeClientId() {
        // $FF: Couldn't be decompiled
    }

    public boolean providesField(String var1) {
        return "&cid".equals(var1);
    }
}
