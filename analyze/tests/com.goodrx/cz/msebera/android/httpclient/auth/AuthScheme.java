package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;

public interface AuthScheme {
   @Deprecated
   Header authenticate(Credentials var1, HttpRequest var2) throws AuthenticationException;

   String getRealm();

   String getSchemeName();

   boolean isComplete();

   boolean isConnectionBased();

   void processChallenge(Header var1) throws MalformedChallengeException;
}
