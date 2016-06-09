package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.cookie.SetCookie2;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class RequestAddCookies implements HttpRequestInterceptor {
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());

   public void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "HTTP context");
      if(!var1.getRequestLine().getMethod().equalsIgnoreCase("CONNECT")) {
         HttpClientContext var5 = HttpClientContext.adapt(var2);
         CookieStore var6 = var5.getCookieStore();
         if(var6 == null) {
            this.log.debug("Cookie store not specified in HTTP context");
         } else {
            Lookup var7 = var5.getCookieSpecRegistry();
            if(var7 == null) {
               this.log.debug("CookieSpec registry not specified in HTTP context");
            } else {
               HttpHost var8 = var5.getTargetHost();
               if(var8 == null) {
                  this.log.debug("Target host not set in the context");
               } else {
                  RouteInfo var9 = var5.getHttpRoute();
                  if(var9 == null) {
                     this.log.debug("Connection route not set in the context");
                  } else {
                     String var10 = var5.getRequestConfig().getCookieSpec();
                     if(var10 == null) {
                        var10 = "best-match";
                     }

                     if(this.log.isDebugEnabled()) {
                        this.log.debug("CookieSpec selected: " + var10);
                     }

                     URI var12;
                     if(var1 instanceof HttpUriRequest) {
                        var12 = ((HttpUriRequest)var1).getURI();
                     } else {
                        label109: {
                           URI var11;
                           try {
                              var11 = new URI(var1.getRequestLine().getUri());
                           } catch (URISyntaxException var33) {
                              var12 = null;
                              break label109;
                           }

                           var12 = var11;
                        }
                     }

                     String var13;
                     if(var12 != null) {
                        var13 = var12.getPath();
                     } else {
                        var13 = null;
                     }

                     String var14 = var8.getHostName();
                     int var15 = var8.getPort();
                     if(var15 < 0) {
                        var15 = var9.getTargetHost().getPort();
                     }

                     if(var15 < 0) {
                        var15 = 0;
                     }

                     if(TextUtils.isEmpty(var13)) {
                        var13 = "/";
                     }

                     boolean var16 = var9.isSecure();
                     CookieOrigin var17 = new CookieOrigin(var14, var15, var13, var16);
                     CookieSpecProvider var18 = (CookieSpecProvider)var7.lookup(var10);
                     if(var18 == null) {
                        throw new HttpException("Unsupported cookie policy: " + var10);
                     } else {
                        CookieSpec var19 = var18.create(var5);
                        ArrayList var20 = new ArrayList(var6.getCookies());
                        ArrayList var21 = new ArrayList();
                        Date var22 = new Date();
                        Iterator var23 = var20.iterator();

                        while(var23.hasNext()) {
                           Cookie var30 = (Cookie)var23.next();
                           if(!var30.isExpired(var22)) {
                              if(var19.match(var30, var17)) {
                                 if(this.log.isDebugEnabled()) {
                                    this.log.debug("Cookie " + var30 + " match " + var17);
                                 }

                                 var21.add(var30);
                              }
                           } else if(this.log.isDebugEnabled()) {
                              this.log.debug("Cookie " + var30 + " expired");
                           }
                        }

                        if(!var21.isEmpty()) {
                           Iterator var29 = var19.formatCookies(var21).iterator();

                           while(var29.hasNext()) {
                              var1.addHeader((Header)var29.next());
                           }
                        }

                        int var24 = var19.getVersion();
                        if(var24 > 0) {
                           boolean var25 = false;
                           Iterator var26 = var21.iterator();

                           label89:
                           while(true) {
                              Cookie var28;
                              do {
                                 if(!var26.hasNext()) {
                                    if(var25) {
                                       Header var27 = var19.getVersionHeader();
                                       if(var27 != null) {
                                          var1.addHeader(var27);
                                       }
                                    }
                                    break label89;
                                 }

                                 var28 = (Cookie)var26.next();
                              } while(var24 == var28.getVersion() && var28 instanceof SetCookie2);

                              var25 = true;
                           }
                        }

                        var2.setAttribute("http.cookie-spec", var19);
                        var2.setAttribute("http.cookie-origin", var17);
                     }
                  }
               }
            }
         }
      }
   }
}
