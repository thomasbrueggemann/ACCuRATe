package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.impl.auth.RFC2617Scheme;
import cz.msebera.android.httpclient.impl.auth.UnsupportedDigestAlgorithmException;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class DigestScheme extends RFC2617Scheme {
   private static final char[] HEXADECIMAL = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
   // $FF: renamed from: a1 java.lang.String
   private String field_121;
   // $FF: renamed from: a2 java.lang.String
   private String field_122;
   private String cnonce;
   private boolean complete;
   private String lastNonce;
   private long nounceCount;

   public DigestScheme() {
      this(Consts.ASCII);
   }

   public DigestScheme(Charset var1) {
      super(var1);
      this.complete = false;
   }

   public static String createCnonce() {
      SecureRandom var0 = new SecureRandom();
      byte[] var1 = new byte[8];
      var0.nextBytes(var1);
      return encode(var1);
   }

   private Header createDigestHeader(Credentials param1, HttpRequest param2) throws AuthenticationException {
      // $FF: Couldn't be decompiled
   }

   private static MessageDigest createMessageDigest(String var0) throws UnsupportedDigestAlgorithmException {
      try {
         MessageDigest var2 = MessageDigest.getInstance(var0);
         return var2;
      } catch (Exception var3) {
         throw new UnsupportedDigestAlgorithmException("Unsupported algorithm in HTTP Digest authentication: " + var0);
      }
   }

   static String encode(byte[] var0) {
      int var1 = var0.length;
      char[] var2 = new char[var1 * 2];

      for(int var3 = 0; var3 < var1; ++var3) {
         int var4 = 15 & var0[var3];
         int var5 = (240 & var0[var3]) >> 4;
         var2[var3 * 2] = HEXADECIMAL[var5];
         var2[1 + var3 * 2] = HEXADECIMAL[var4];
      }

      return new String(var2);
   }

   @Deprecated
   public Header authenticate(Credentials var1, HttpRequest var2) throws AuthenticationException {
      return this.authenticate(var1, var2, new BasicHttpContext());
   }

   public Header authenticate(Credentials var1, HttpRequest var2, HttpContext var3) throws AuthenticationException {
      Args.notNull(var1, "Credentials");
      Args.notNull(var2, "HTTP request");
      if(this.getParameter("realm") == null) {
         throw new AuthenticationException("missing realm in challenge");
      } else if(this.getParameter("nonce") == null) {
         throw new AuthenticationException("missing nonce in challenge");
      } else {
         this.getParameters().put("methodname", var2.getRequestLine().getMethod());
         this.getParameters().put("uri", var2.getRequestLine().getUri());
         if(this.getParameter("charset") == null) {
            this.getParameters().put("charset", this.getCredentialsCharset(var2));
         }

         return this.createDigestHeader(var1, var2);
      }
   }

   public String getSchemeName() {
      return "digest";
   }

   public boolean isComplete() {
      return "true".equalsIgnoreCase(this.getParameter("stale"))?false:this.complete;
   }

   public boolean isConnectionBased() {
      return false;
   }

   public void processChallenge(Header var1) throws MalformedChallengeException {
      super.processChallenge(var1);
      this.complete = true;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("DIGEST [complete=").append(this.complete).append(", nonce=").append(this.lastNonce).append(", nc=").append(this.nounceCount).append("]");
      return var1.toString();
   }
}
