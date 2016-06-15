package android.support.v4.net;

import android.net.ConnectivityManager;

class ConnectivityManagerCompatJellyBean {
   public static boolean isActiveNetworkMetered(ConnectivityManager var0) {
      return var0.isActiveNetworkMetered();
   }
}
