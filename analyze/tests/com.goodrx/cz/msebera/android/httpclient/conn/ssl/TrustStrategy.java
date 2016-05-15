package cz.msebera.android.httpclient.conn.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public interface TrustStrategy {
   boolean isTrusted(X509Certificate[] var1, String var2) throws CertificateException;
}
