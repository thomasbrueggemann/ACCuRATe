package com.google.tagmanager;

import java.io.IOException;
import java.io.InputStream;

interface NetworkClient {
    int DEFAULT_CONNECTION_TIMEOUT_MILLIS = 20000;
    int DEFAULT_SOCKET_TIMEOUT_MILLIS = 20000;

    void close();

    InputStream getInputStream(String var1) throws IOException;

    void sendPostRequest(String var1, byte[] var2) throws IOException;
}
