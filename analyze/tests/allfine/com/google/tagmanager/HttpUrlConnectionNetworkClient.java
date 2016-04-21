package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.NetworkClient;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class HttpUrlConnectionNetworkClient implements NetworkClient {
    private HttpURLConnection mConnection;

    private void closeURLConnection(HttpURLConnection var1) {
        if(var1 != null) {
            var1.disconnect();
        }

    }

    private InputStream handleServerResponse(HttpURLConnection var1) throws IOException {
        int var2 = var1.getResponseCode();
        if(var2 == 200) {
            return var1.getInputStream();
        } else {
            String var3 = "Bad response: " + var2;
            if(var2 == 404) {
                throw new FileNotFoundException(var3);
            } else {
                throw new IOException(var3);
            }
        }
    }

    public void close() {
        this.closeURLConnection(this.mConnection);
    }

    public InputStream getInputStream(String var1) throws IOException {
        this.mConnection = this.getUrlConnection(var1);
        return this.handleServerResponse(this.mConnection);
    }

    @VisibleForTesting
    HttpURLConnection getUrlConnection(String var1) throws IOException {
        HttpURLConnection var2 = (HttpURLConnection)(new URL(var1)).openConnection();
        var2.setReadTimeout(20000);
        var2.setConnectTimeout(20000);
        return var2;
    }

    public void sendPostRequest(String param1, byte[] param2) throws IOException {
        // $FF: Couldn't be decompiled
    }
}
