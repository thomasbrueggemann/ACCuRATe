package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.impl.auth.AuthSchemeBase;
import cz.msebera.android.httpclient.message.BasicHeaderValueParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class RFC2617Scheme extends AuthSchemeBase {
   private final Charset credentialsCharset;
   private final Map<String, String> params = new HashMap();

   public RFC2617Scheme(Charset var1) {
      if(var1 == null) {
         var1 = Consts.ASCII;
      }

      this.credentialsCharset = var1;
   }

   String getCredentialsCharset(HttpRequest var1) {
      String var2 = (String)var1.getParams().getParameter("http.auth.credential-charset");
      if(var2 == null) {
         var2 = this.getCredentialsCharset().name();
      }

      return var2;
   }

   public Charset getCredentialsCharset() {
      return this.credentialsCharset;
   }

   public String getParameter(String var1) {
      return var1 == null?null:(String)this.params.get(var1.toLowerCase(Locale.ENGLISH));
   }

   protected Map<String, String> getParameters() {
      return this.params;
   }

   public String getRealm() {
      return this.getParameter("realm");
   }

   protected void parseChallenge(CharArrayBuffer var1, int var2, int var3) throws MalformedChallengeException {
      HeaderElement[] var4 = BasicHeaderValueParser.INSTANCE.parseElements(var1, new ParserCursor(var2, var1.length()));
      if(var4.length == 0) {
         throw new MalformedChallengeException("Authentication challenge is empty");
      } else {
         this.params.clear();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            HeaderElement var7 = var4[var6];
            this.params.put(var7.getName().toLowerCase(Locale.ENGLISH), var7.getValue());
         }

      }
   }
}
