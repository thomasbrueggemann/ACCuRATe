package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.class_1033;
import com.google.android.gms.common.api.d;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

public final class RealTimeMultiplayerImpl implements RealTimeMultiplayer {
   // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, java.lang.Object) com.google.android.gms.common.api.d
   private static <L> d<L> method_5295(GoogleApiClient var0, L var1) {
      return var1 == null?null:var0.method_945(var1);
   }

   public void create(GoogleApiClient var1, RoomConfig var2) {
      class_1033 var3 = var1.method_945(var2.getRoomUpdateListener());
      class_1033 var4 = method_5295(var1, var2.getRoomStatusUpdateListener());
      class_1033 var5 = method_5295(var1, var2.getMessageReceivedListener());
      Games.method_3259(var1).method_1915(var3, var4, var5, var2);
   }

   public void declineInvitation(GoogleApiClient var1, String var2) {
      Games.method_3259(var1).method_2014(var2, 0);
   }

   public void dismissInvitation(GoogleApiClient var1, String var2) {
      Games.method_3259(var1).method_2013(var2, 0);
   }

   public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3) {
      return Games.method_3259(var1).method_1919(var2, var3, true);
   }

   public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3, boolean var4) {
      return Games.method_3259(var1).method_1919(var2, var3, var4);
   }

   public RealTimeSocket getSocketForParticipant(GoogleApiClient var1, String var2, String var3) {
      return Games.method_3259(var1).method_2015(var2, var3);
   }

   public Intent getWaitingRoomIntent(GoogleApiClient var1, Room var2, int var3) {
      return Games.method_3259(var1).method_1877(var2, var3);
   }

   public void join(GoogleApiClient var1, RoomConfig var2) {
      class_1033 var3 = var1.method_945(var2.getRoomUpdateListener());
      class_1033 var4 = method_5295(var1, var2.getRoomStatusUpdateListener());
      class_1033 var5 = method_5295(var1, var2.getMessageReceivedListener());
      Games.method_3259(var1).method_1936(var3, var4, var5, var2);
   }

   public void leave(GoogleApiClient var1, RoomUpdateListener var2, String var3) {
      class_1033 var4 = var1.method_945(var2);
      Games.method_3259(var1).method_1916(var4, var3);
   }

   public int sendReliableMessage(GoogleApiClient var1, RealTimeMultiplayer.ReliableMessageSentCallback var2, byte[] var3, String var4, String var5) {
      class_1033 var6 = method_5295(var1, var2);
      return Games.method_3259(var1).method_1873(var6, var3, var4, var5);
   }

   public int sendUnreliableMessage(GoogleApiClient var1, byte[] var2, String var3, String var4) {
      return Games.method_3259(var1).method_1874(var2, var3, new String[]{var4});
   }

   public int sendUnreliableMessage(GoogleApiClient var1, byte[] var2, String var3, List<String> var4) {
      String[] var5 = (String[])var4.toArray(new String[var4.size()]);
      return Games.method_3259(var1).method_1874(var2, var3, var5);
   }

   public int sendUnreliableMessageToOthers(GoogleApiClient var1, byte[] var2, String var3) {
      return Games.method_3259(var1).method_1951(var2, var3);
   }
}
