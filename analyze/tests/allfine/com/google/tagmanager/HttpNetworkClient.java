package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Log;
import com.google.tagmanager.NetworkClient;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

class HttpNetworkClient implements NetworkClient {
    private HttpClient mClient;

    private void closeWithClient(HttpClient var1) {
        if(var1 != null && var1.getConnectionManager() != null) {
            var1.getConnectionManager().shutdown();
        }

    }

    private InputStream handleServerResponse(HttpClient var1, HttpResponse var2) throws IOException {
        int var3 = var2.getStatusLine().getStatusCode();
        if(var3 == 200) {
            Log.method_5507("Success response");
            return var2.getEntity().getContent();
        } else {
            String var4 = "Bad response: " + var3;
            if(var3 == 404) {
                throw new FileNotFoundException(var4);
            } else {
                throw new IOException(var4);
            }
        }
    }

    public void close() {
        this.closeWithClient(this.mClient);
    }

    @VisibleForTesting
    HttpClient createNewHttpClient() {
        BasicHttpParams var1 = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(var1, 20000);
        HttpConnectionParams.setSoTimeout(var1, 20000);
        return new DefaultHttpClient(var1);
    }

    @VisibleForTesting
    HttpPost createPostRequest(String var1, byte[] var2) {
        HttpPost var3 = new HttpPost(var1);
        var3.setEntity(new ByteArrayEntity(var2));
        return var3;
    }

    public InputStream getInputStream(String var1) throws IOException {
        this.mClient = this.createNewHttpClient();
        HttpResponse var2 = this.mClient.execute(new HttpGet(var1));
        return this.handleServerResponse(this.mClient, var2);
    }

    public void sendPostRequest(String var1, byte[] var2) throws IOException {
        HttpClient var3 = this.createNewHttpClient();
        this.handleServerResponse(var3, var3.execute(this.createPostRequest(var1, var2)));
        this.closeWithClient(var3);
    }
}
