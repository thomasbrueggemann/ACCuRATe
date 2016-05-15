package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.impl.client.RequestWrapper;

@Deprecated
public class RoutedRequest {
   protected final RequestWrapper request;
   protected final HttpRoute route;

   public RoutedRequest(RequestWrapper var1, HttpRoute var2) {
      this.request = var1;
      this.route = var2;
   }

   public final RequestWrapper getRequest() {
      return this.request;
   }

   public final HttpRoute getRoute() {
      return this.route;
   }
}
