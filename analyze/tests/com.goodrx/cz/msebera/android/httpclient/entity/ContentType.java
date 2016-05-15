package cz.msebera.android.httpclient.entity;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.TextUtils;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;

public final class ContentType implements Serializable {
   public static final ContentType APPLICATION_ATOM_XML;
   public static final ContentType APPLICATION_FORM_URLENCODED;
   public static final ContentType APPLICATION_JSON;
   public static final ContentType APPLICATION_OCTET_STREAM;
   public static final ContentType APPLICATION_SVG_XML;
   public static final ContentType APPLICATION_XHTML_XML;
   public static final ContentType APPLICATION_XML;
   public static final ContentType DEFAULT_BINARY;
   public static final ContentType DEFAULT_TEXT;
   public static final ContentType MULTIPART_FORM_DATA;
   public static final ContentType TEXT_HTML;
   public static final ContentType TEXT_PLAIN;
   public static final ContentType TEXT_XML;
   public static final ContentType WILDCARD;
   private final Charset charset;
   private final String mimeType;
   private final NameValuePair[] params;

   static {
      APPLICATION_ATOM_XML = create("application/atom+xml", Consts.ISO_8859_1);
      APPLICATION_FORM_URLENCODED = create("application/x-www-form-urlencoded", Consts.ISO_8859_1);
      APPLICATION_JSON = create("application/json", Consts.UTF_8);
      APPLICATION_OCTET_STREAM = create("application/octet-stream", (Charset)null);
      APPLICATION_SVG_XML = create("application/svg+xml", Consts.ISO_8859_1);
      APPLICATION_XHTML_XML = create("application/xhtml+xml", Consts.ISO_8859_1);
      APPLICATION_XML = create("application/xml", Consts.ISO_8859_1);
      MULTIPART_FORM_DATA = create("multipart/form-data", Consts.ISO_8859_1);
      TEXT_HTML = create("text/html", Consts.ISO_8859_1);
      TEXT_PLAIN = create("text/plain", Consts.ISO_8859_1);
      TEXT_XML = create("text/xml", Consts.ISO_8859_1);
      WILDCARD = create("*/*", (Charset)null);
      DEFAULT_TEXT = TEXT_PLAIN;
      DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
   }

   ContentType(String var1, Charset var2) {
      this.mimeType = var1;
      this.charset = var2;
      this.params = null;
   }

   public static ContentType create(String var0, String var1) throws UnsupportedCharsetException {
      Charset var2;
      if(!TextUtils.isBlank(var1)) {
         var2 = Charset.forName(var1);
      } else {
         var2 = null;
      }

      return create(var0, var2);
   }

   public static ContentType create(String var0, Charset var1) {
      String var2 = ((String)Args.notBlank(var0, "MIME type")).toLowerCase(Locale.ENGLISH);
      Args.check(valid(var2), "MIME type may not contain reserved characters");
      return new ContentType(var2, var1);
   }

   private static boolean valid(String var0) {
      for(int var1 = 0; var1 < var0.length(); ++var1) {
         char var2 = var0.charAt(var1);
         if(var2 == 34 || var2 == 44 || var2 == 59) {
            return false;
         }
      }

      return true;
   }

   public Charset getCharset() {
      return this.charset;
   }

   public String toString() {
      CharArrayBuffer var1 = new CharArrayBuffer(64);
      var1.append(this.mimeType);
      if(this.params != null) {
         var1.append("; ");
         BasicHeaderValueFormatter.INSTANCE.formatParameters(var1, this.params, false);
      } else if(this.charset != null) {
         var1.append("; charset=");
         var1.append(this.charset.name());
      }

      return var1.toString();
   }
}
