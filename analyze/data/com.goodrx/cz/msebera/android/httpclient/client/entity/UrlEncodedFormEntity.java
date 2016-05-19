package cz.msebera.android.httpclient.client.entity;

import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

public class UrlEncodedFormEntity extends StringEntity {
   public UrlEncodedFormEntity(Iterable<? extends NameValuePair> var1, Charset var2) {
      Charset var3;
      if(var2 != null) {
         var3 = var2;
      } else {
         var3 = HTTP.DEF_CONTENT_CHARSET;
      }

      super(URLEncodedUtils.format(var1, var3), ContentType.create("application/x-www-form-urlencoded", var2));
   }

   public UrlEncodedFormEntity(List<? extends NameValuePair> var1, String var2) throws UnsupportedEncodingException {
      String var3;
      if(var2 != null) {
         var3 = var2;
      } else {
         var3 = HTTP.DEF_CONTENT_CHARSET.name();
      }

      super(URLEncodedUtils.format(var1, var3), ContentType.create("application/x-www-form-urlencoded", var2));
   }
}
