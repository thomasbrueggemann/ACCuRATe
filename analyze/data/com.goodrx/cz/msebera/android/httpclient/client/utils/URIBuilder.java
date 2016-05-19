package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import cz.msebera.android.httpclient.conn.util.InetAddressUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class URIBuilder {
   private String encodedAuthority;
   private String encodedFragment;
   private String encodedPath;
   private String encodedQuery;
   private String encodedSchemeSpecificPart;
   private String encodedUserInfo;
   private String fragment;
   private String host;
   private String path;
   private int port;
   private String query;
   private List<NameValuePair> queryParams;
   private String scheme;
   private String userInfo;

   public URIBuilder() {
      this.port = -1;
   }

   public URIBuilder(URI var1) {
      this.digestURI(var1);
   }

   private String buildString() {
      StringBuilder var1 = new StringBuilder();
      if(this.scheme != null) {
         var1.append(this.scheme).append(':');
      }

      if(this.encodedSchemeSpecificPart != null) {
         var1.append(this.encodedSchemeSpecificPart);
      } else {
         if(this.encodedAuthority != null) {
            var1.append("//").append(this.encodedAuthority);
         } else if(this.host != null) {
            var1.append("//");
            if(this.encodedUserInfo != null) {
               var1.append(this.encodedUserInfo).append("@");
            } else if(this.userInfo != null) {
               var1.append(this.encodeUserInfo(this.userInfo)).append("@");
            }

            if(InetAddressUtils.isIPv6Address(this.host)) {
               var1.append("[").append(this.host).append("]");
            } else {
               var1.append(this.host);
            }

            if(this.port >= 0) {
               var1.append(":").append(this.port);
            }
         }

         if(this.encodedPath != null) {
            var1.append(normalizePath(this.encodedPath));
         } else if(this.path != null) {
            var1.append(this.encodePath(normalizePath(this.path)));
         }

         if(this.encodedQuery != null) {
            var1.append("?").append(this.encodedQuery);
         } else if(this.queryParams != null) {
            var1.append("?").append(this.encodeUrlForm(this.queryParams));
         } else if(this.query != null) {
            var1.append("?").append(this.encodeUric(this.query));
         }
      }

      if(this.encodedFragment != null) {
         var1.append("#").append(this.encodedFragment);
      } else if(this.fragment != null) {
         var1.append("#").append(this.encodeUric(this.fragment));
      }

      return var1.toString();
   }

   private void digestURI(URI var1) {
      this.scheme = var1.getScheme();
      this.encodedSchemeSpecificPart = var1.getRawSchemeSpecificPart();
      this.encodedAuthority = var1.getRawAuthority();
      this.host = var1.getHost();
      this.port = var1.getPort();
      this.encodedUserInfo = var1.getRawUserInfo();
      this.userInfo = var1.getUserInfo();
      this.encodedPath = var1.getRawPath();
      this.path = var1.getPath();
      this.encodedQuery = var1.getRawQuery();
      this.queryParams = this.parseQuery(var1.getRawQuery(), Consts.UTF_8);
      this.encodedFragment = var1.getRawFragment();
      this.fragment = var1.getFragment();
   }

   private String encodePath(String var1) {
      return URLEncodedUtils.encPath(var1, Consts.UTF_8);
   }

   private String encodeUric(String var1) {
      return URLEncodedUtils.encUric(var1, Consts.UTF_8);
   }

   private String encodeUrlForm(List<NameValuePair> var1) {
      return URLEncodedUtils.format((Iterable)var1, (Charset)Consts.UTF_8);
   }

   private String encodeUserInfo(String var1) {
      return URLEncodedUtils.encUserInfo(var1, Consts.UTF_8);
   }

   private static String normalizePath(String var0) {
      String var1 = var0;
      if(var0 == null) {
         return null;
      } else {
         int var2;
         for(var2 = 0; var2 < var1.length() && var1.charAt(var2) == 47; ++var2) {
            ;
         }

         if(var2 > 1) {
            var1 = var1.substring(var2 - 1);
         }

         return var1;
      }
   }

   private List<NameValuePair> parseQuery(String var1, Charset var2) {
      return var1 != null && var1.length() > 0?URLEncodedUtils.parse(var1, var2):null;
   }

   public URIBuilder addParameters(List<NameValuePair> var1) {
      if(this.queryParams == null) {
         this.queryParams = new ArrayList();
      }

      this.queryParams.addAll(var1);
      this.encodedQuery = null;
      this.encodedSchemeSpecificPart = null;
      this.query = null;
      return this;
   }

   public URI build() throws URISyntaxException {
      return new URI(this.buildString());
   }

   public String getHost() {
      return this.host;
   }

   public String getPath() {
      return this.path;
   }

   public String getUserInfo() {
      return this.userInfo;
   }

   public URIBuilder setFragment(String var1) {
      this.fragment = var1;
      this.encodedFragment = null;
      return this;
   }

   public URIBuilder setHost(String var1) {
      this.host = var1;
      this.encodedSchemeSpecificPart = null;
      this.encodedAuthority = null;
      return this;
   }

   public URIBuilder setPath(String var1) {
      this.path = var1;
      this.encodedSchemeSpecificPart = null;
      this.encodedPath = null;
      return this;
   }

   public URIBuilder setPort(int var1) {
      if(var1 < 0) {
         var1 = -1;
      }

      this.port = var1;
      this.encodedSchemeSpecificPart = null;
      this.encodedAuthority = null;
      return this;
   }

   public URIBuilder setScheme(String var1) {
      this.scheme = var1;
      return this;
   }

   public URIBuilder setUserInfo(String var1) {
      this.userInfo = var1;
      this.encodedSchemeSpecificPart = null;
      this.encodedAuthority = null;
      this.encodedUserInfo = null;
      return this;
   }

   public String toString() {
      return this.buildString();
   }
}
