package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RoomConfigImpl;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.class_335;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class RoomConfig {
   public static RoomConfig.Builder builder(RoomUpdateListener var0) {
      return new RoomConfig.Builder(var0);
   }

   public static Bundle createAutoMatchCriteria(int var0, int var1, long var2) {
      Bundle var4 = new Bundle();
      var4.putInt("min_automatch_players", var0);
      var4.putInt("max_automatch_players", var1);
      var4.putLong("exclusive_bit_mask", var2);
      return var4;
   }

   public abstract Bundle getAutoMatchCriteria();

   public abstract String getInvitationId();

   public abstract String[] getInvitedPlayerIds();

   public abstract RealTimeMessageReceivedListener getMessageReceivedListener();

   public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();

   public abstract RoomUpdateListener getRoomUpdateListener();

   public abstract int getVariant();

   @Deprecated
   public abstract boolean isSocketEnabled();

   public static final class Builder {
      int adW;
      final RoomUpdateListener aeh;
      RoomStatusUpdateListener aei;
      RealTimeMessageReceivedListener aej;
      String aek;
      ArrayList<String> ael;
      Bundle aem;
      boolean aen;

      private Builder(RoomUpdateListener var1) {
         this.aek = null;
         this.adW = -1;
         this.ael = new ArrayList();
         this.aen = false;
         this.aeh = (RoomUpdateListener)class_335.method_2306(var1, "Must provide a RoomUpdateListener");
      }

      // $FF: synthetic method
      Builder(RoomUpdateListener var1, Object var2) {
         this(var1);
      }

      public RoomConfig.Builder addPlayersToInvite(ArrayList<String> var1) {
         class_335.method_2311(var1);
         this.ael.addAll(var1);
         return this;
      }

      public RoomConfig.Builder addPlayersToInvite(String... var1) {
         class_335.method_2311(var1);
         this.ael.addAll(Arrays.asList(var1));
         return this;
      }

      public RoomConfig build() {
         return new RoomConfigImpl(this);
      }

      public RoomConfig.Builder setAutoMatchCriteria(Bundle var1) {
         this.aem = var1;
         return this;
      }

      public RoomConfig.Builder setInvitationIdToAccept(String var1) {
         class_335.method_2311(var1);
         this.aek = var1;
         return this;
      }

      public RoomConfig.Builder setMessageReceivedListener(RealTimeMessageReceivedListener var1) {
         this.aej = var1;
         return this;
      }

      public RoomConfig.Builder setRoomStatusUpdateListener(RoomStatusUpdateListener var1) {
         this.aei = var1;
         return this;
      }

      @Deprecated
      public RoomConfig.Builder setSocketCommunicationEnabled(boolean var1) {
         this.aen = var1;
         return this;
      }

      public RoomConfig.Builder setVariant(int var1) {
         boolean var2;
         if(var1 != -1 && var1 <= 0) {
            var2 = false;
         } else {
            var2 = true;
         }

         class_335.method_2308(var2, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
         this.adW = var1;
         return this;
      }
   }
}
