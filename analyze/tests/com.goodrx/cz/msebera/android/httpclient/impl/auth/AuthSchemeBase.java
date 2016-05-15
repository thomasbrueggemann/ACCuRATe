package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ChallengeState;
import cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.Locale;

public abstract class AuthSchemeBase implements ContextAwareAuthScheme {
   private ChallengeState challengeState;

   public Header authenticate(Credentials var1, HttpRequest var2, HttpContext var3) throws AuthenticationException {
      return this.authenticate(var1, var2);
   }

   public boolean isProxy() {
      return this.challengeState != null && this.challengeState == ChallengeState.PROXY;
   }

   protected abstract void parseChallenge(CharArrayBuffer var1, int var2, int var3) throws MalformedChallengeException;

   public void processChallenge(Header var1) throws MalformedChallengeException {
      Args.notNull(var1, "Header");
      String var3 = var1.getName();
      if(var3.equalsIgnoreCase("WWW-Authenticate")) {
         this.challengeState = ChallengeState.TARGET;
      } else {
         if(!var3.equalsIgnoreCase("Proxy-Authenticate")) {
            throw new MalformedChallengeException("Unexpected header name: " + var3);
         }

         this.challengeState = ChallengeState.PROXY;
      }

      CharArrayBuffer var5;
      int var6;
      if(var1 instanceof FormattedHeader) {
         var5 = ((FormattedHeader)var1).getBuffer();
         var6 = ((FormattedHeader)var1).getValuePos();
      } else {
         String var4 = var1.getValue();
         if(var4 == null) {
            throw new MalformedChallengeException("Header value is null");
         }

         var5 = new CharArrayBuffer(var4.length());
         var5.append(var4);
         var6 = 0;
      }

      while(var6 < var5.length() && HTTP.isWhitespace(var5.charAt(var6))) {
         ++var6;
      }

      int var7;
      for(var7 = var6; var6 < var5.length() && !HTTP.isWhitespace(var5.charAt(var6)); ++var6) {
         ;
      }

      String var8 = var5.substring(var7, var6);
      if(!var8.equalsIgnoreCase(this.getSchemeName())) {
         throw new MalformedChallengeException("Invalid scheme identifier: " + var8);
      } else {
         this.parseChallenge(var5, var6, var5.length());
      }
   }

   public String toString() {
      String var1 = this.getSchemeName();
      return var1 != null?var1.toUpperCase(Locale.ENGLISH):super.toString();
   }
}
