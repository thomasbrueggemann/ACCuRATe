package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.ProtocolVersion;

public interface RequestLine {
   String getMethod();

   ProtocolVersion getProtocolVersion();

   String getUri();
}
