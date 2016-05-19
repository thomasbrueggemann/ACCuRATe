package cz.msebera.android.httpclient.conn.routing;

import cz.msebera.android.httpclient.conn.routing.HttpRouteDirector;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.util.Args;

public class BasicRouteDirector implements HttpRouteDirector {
   protected int directStep(RouteInfo var1, RouteInfo var2) {
      return var2.getHopCount() <= 1 && var1.getTargetHost().equals(var2.getTargetHost()) && var1.isSecure() == var2.isSecure() && (var1.getLocalAddress() == null || var1.getLocalAddress().equals(var2.getLocalAddress()))?0:-1;
   }

   protected int firstStep(RouteInfo var1) {
      byte var2 = 1;
      if(var1.getHopCount() > var2) {
         var2 = 2;
      }

      return var2;
   }

   public int nextStep(RouteInfo var1, RouteInfo var2) {
      Args.notNull(var1, "Planned route");
      return var2 != null && var2.getHopCount() >= 1?(var1.getHopCount() > 1?this.proxiedStep(var1, var2):this.directStep(var1, var2)):this.firstStep(var1);
   }

   protected int proxiedStep(RouteInfo var1, RouteInfo var2) {
      if(var2.getHopCount() > 1 && var1.getTargetHost().equals(var2.getTargetHost())) {
         int var3 = var1.getHopCount();
         int var4 = var2.getHopCount();
         if(var3 >= var4) {
            int var5 = 0;

            while(true) {
               if(var5 >= var4 - 1) {
                  if(var3 > var4) {
                     return 4;
                  }

                  if((!var2.isTunnelled() || var1.isTunnelled()) && (!var2.isLayered() || var1.isLayered())) {
                     if(var1.isTunnelled() && !var2.isTunnelled()) {
                        return 3;
                     }

                     if(var1.isLayered() && !var2.isLayered()) {
                        return 5;
                     }

                     if(var1.isSecure() == var2.isSecure()) {
                        return 0;
                     }
                  }
                  break;
               }

               if(!var1.getHopTarget(var5).equals(var2.getHopTarget(var5))) {
                  break;
               }

               ++var5;
            }
         }
      }

      return -1;
   }
}
