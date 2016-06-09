package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.HashSet;
import java.util.Set;

class ConnectivityNotifier extends BroadcastReceiver {
   private static final String TAG = "com.parse.ConnectivityNotifier";
   private static final ConnectivityNotifier singleton = new ConnectivityNotifier();
   private boolean hasRegisteredReceiver = false;
   private Set<ConnectivityNotifier.ConnectivityListener> listeners = new HashSet();
   private final Object lock = new Object();

   public static ConnectivityNotifier getNotifier(Context var0) {
      singleton.tryToRegisterForNetworkStatusNotifications(var0);
      return singleton;
   }

   public static boolean isConnected(Context var0) {
      ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService("connectivity");
      if(var1 != null) {
         NetworkInfo var2 = var1.getActiveNetworkInfo();
         if(var2 != null && var2.isConnected()) {
            return true;
         }
      }

      return false;
   }

   private boolean tryToRegisterForNetworkStatusNotifications(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public void addListener(ConnectivityNotifier.ConnectivityListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void onReceive(Context param1, Intent param2) {
      // $FF: Couldn't be decompiled
   }

   public void removeListener(ConnectivityNotifier.ConnectivityListener param1) {
      // $FF: Couldn't be decompiled
   }

   public interface ConnectivityListener {
      void networkConnectivityStatusChanged(Context var1, Intent var2);
   }
}
