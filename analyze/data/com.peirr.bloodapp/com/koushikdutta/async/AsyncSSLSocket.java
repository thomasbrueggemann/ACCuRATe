package com.koushikdutta.async;

import com.koushikdutta.async.AsyncSocket;
import java.security.cert.X509Certificate;

public interface AsyncSSLSocket extends AsyncSocket {
   X509Certificate[] getPeerCertificates();
}
