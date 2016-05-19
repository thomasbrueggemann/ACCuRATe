package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Map;
import java.util.Queue;

public interface AuthenticationStrategy {
   void authFailed(HttpHost var1, AuthScheme var2, HttpContext var3);

   void authSucceeded(HttpHost var1, AuthScheme var2, HttpContext var3);

   Map<String, Header> getChallenges(HttpHost var1, HttpResponse var2, HttpContext var3) throws MalformedChallengeException;

   boolean isAuthenticationRequested(HttpHost var1, HttpResponse var2, HttpContext var3);

   Queue<AuthOption> select(Map<String, Header> var1, HttpHost var2, HttpResponse var3, HttpContext var4) throws MalformedChallengeException;
}
