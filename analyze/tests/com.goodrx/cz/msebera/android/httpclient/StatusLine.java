package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.ProtocolVersion;

public interface StatusLine {
   ProtocolVersion getProtocolVersion();

   String getReasonPhrase();

   int getStatusCode();
}
