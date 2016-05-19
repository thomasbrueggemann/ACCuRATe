package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.conn.routing.RouteInfo;

public interface HttpRouteDirector {
   int nextStep(RouteInfo var1, RouteInfo var2);
}
