package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Map;

@Deprecated
public interface AuthenticationHandler {
   Map<String, Header> getChallenges(HttpResponse var1, HttpContext var2) throws MalformedChallengeException;

   boolean isAuthenticationRequested(HttpResponse var1, HttpContext var2);

   AuthScheme selectScheme(Map<String, Header> var1, HttpResponse var2, HttpContext var3) throws AuthenticationException;
}
