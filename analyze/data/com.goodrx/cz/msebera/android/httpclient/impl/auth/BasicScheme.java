package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.extras.Base64;
import cz.msebera.android.httpclient.impl.auth.RFC2617Scheme;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.EncodingUtils;
import java.nio.charset.Charset;

public class BasicScheme extends RFC2617Scheme {
   private boolean complete;

   public BasicScheme() {
      this(Consts.ASCII);
   }

   public BasicScheme(Charset var1) {
      super(var1);
      this.complete = false;
   }

   @Deprecated
   public Header authenticate(Credentials var1, HttpRequest var2) throws AuthenticationException {
      return this.authenticate(var1, var2, new BasicHttpContext());
   }

   public Header authenticate(Credentials var1, HttpRequest var2, HttpContext var3) throws AuthenticationException {
      Args.notNull(var1, "Credentials");
      Args.notNull(var2, "HTTP request");
      StringBuilder var6 = new StringBuilder();
      var6.append(var1.getUserPrincipal().getName());
      var6.append(":");
      String var9;
      if(var1.getPassword() == null) {
         var9 = "null";
      } else {
         var9 = var1.getPassword();
      }

      var6.append(var9);
      byte[] var11 = Base64.encode(EncodingUtils.getBytes(var6.toString(), this.getCredentialsCharset(var2)), 2);
      CharArrayBuffer var12 = new CharArrayBuffer(32);
      if(this.isProxy()) {
         var12.append("Proxy-Authorization");
      } else {
         var12.append("Authorization");
      }

      var12.append(": Basic ");
      var12.append(var11, 0, var11.length);
      return new BufferedHeader(var12);
   }

   public String getSchemeName() {
      return "basic";
   }

   public boolean isComplete() {
      return this.complete;
   }

   public boolean isConnectionBased() {
      return false;
   }

   public void processChallenge(Header var1) throws MalformedChallengeException {
      super.processChallenge(var1);
      this.complete = true;
   }
}
