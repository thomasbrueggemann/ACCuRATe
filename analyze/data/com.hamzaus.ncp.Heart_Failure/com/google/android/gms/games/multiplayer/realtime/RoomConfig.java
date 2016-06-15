package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.class_347;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomConfig {
   // $FF: renamed from: NN java.lang.String
   private final String field_3009;
   // $FF: renamed from: SV int
   private final int field_3010;
   // $FF: renamed from: Th com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
   private final RoomUpdateListener field_3011;
   // $FF: renamed from: Ti com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
   private final RoomStatusUpdateListener field_3012;
   // $FF: renamed from: Tj com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener
   private final RealTimeMessageReceivedListener field_3013;
   // $FF: renamed from: Tk java.lang.String[]
   private final String[] field_3014;
   // $FF: renamed from: Tl android.os.Bundle
   private final Bundle field_3015;
   // $FF: renamed from: Tm boolean
   private final boolean field_3016;

   private RoomConfig(RoomConfig.Builder var1) {
      this.field_3011 = var1.field_4076;
      this.field_3012 = var1.field_4077;
      this.field_3013 = var1.field_4078;
      this.field_3009 = var1.field_4081;
      this.field_3010 = var1.field_4075;
      this.field_3015 = var1.field_4079;
      this.field_3016 = var1.field_4080;
      int var2 = var1.field_4082.size();
      this.field_3014 = (String[])var1.field_4082.toArray(new String[var2]);
      if(this.field_3013 == null) {
         class_347.method_2161(this.field_3016, "Must either enable sockets OR specify a message listener");
      }

   }

   // $FF: synthetic method
   RoomConfig(RoomConfig.Builder var1, Object var2) {
      this(var1);
   }

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

   public Bundle getAutoMatchCriteria() {
      return this.field_3015;
   }

   public String getInvitationId() {
      return this.field_3009;
   }

   public String[] getInvitedPlayerIds() {
      return this.field_3014;
   }

   public RealTimeMessageReceivedListener getMessageReceivedListener() {
      return this.field_3013;
   }

   public RoomStatusUpdateListener getRoomStatusUpdateListener() {
      return this.field_3012;
   }

   public RoomUpdateListener getRoomUpdateListener() {
      return this.field_3011;
   }

   public int getVariant() {
      return this.field_3010;
   }

   public boolean isSocketEnabled() {
      return this.field_3016;
   }

   public static final class Builder {
      // $FF: renamed from: SV int
      int field_4075;
      // $FF: renamed from: Th com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
      final RoomUpdateListener field_4076;
      // $FF: renamed from: Ti com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
      RoomStatusUpdateListener field_4077;
      // $FF: renamed from: Tj com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener
      RealTimeMessageReceivedListener field_4078;
      // $FF: renamed from: Tl android.os.Bundle
      Bundle field_4079;
      // $FF: renamed from: Tm boolean
      boolean field_4080;
      // $FF: renamed from: Tn java.lang.String
      String field_4081;
      // $FF: renamed from: To java.util.ArrayList
      ArrayList<String> field_4082;

      private Builder(RoomUpdateListener var1) {
         this.field_4081 = null;
         this.field_4075 = -1;
         this.field_4082 = new ArrayList();
         this.field_4080 = false;
         this.field_4076 = (RoomUpdateListener)class_347.method_2166(var1, "Must provide a RoomUpdateListener");
      }

      // $FF: synthetic method
      Builder(RoomUpdateListener var1, Object var2) {
         this(var1);
      }

      public RoomConfig.Builder addPlayersToInvite(ArrayList<String> var1) {
         class_347.method_2170(var1);
         this.field_4082.addAll(var1);
         return this;
      }

      public RoomConfig.Builder addPlayersToInvite(String... var1) {
         class_347.method_2170(var1);
         this.field_4082.addAll(Arrays.asList(var1));
         return this;
      }

      public RoomConfig build() {
         return new RoomConfig(this);
      }

      public RoomConfig.Builder setAutoMatchCriteria(Bundle var1) {
         this.field_4079 = var1;
         return this;
      }

      public RoomConfig.Builder setInvitationIdToAccept(String var1) {
         class_347.method_2170(var1);
         this.field_4081 = var1;
         return this;
      }

      public RoomConfig.Builder setMessageReceivedListener(RealTimeMessageReceivedListener var1) {
         this.field_4078 = var1;
         return this;
      }

      public RoomConfig.Builder setRoomStatusUpdateListener(RoomStatusUpdateListener var1) {
         this.field_4077 = var1;
         return this;
      }

      public RoomConfig.Builder setSocketCommunicationEnabled(boolean var1) {
         this.field_4080 = var1;
         return this;
      }

      public RoomConfig.Builder setVariant(int var1) {
         boolean var2;
         if(var1 != -1 && var1 <= 0) {
            var2 = false;
         } else {
            var2 = true;
         }

         class_347.method_2168(var2, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
         this.field_4075 = var1;
         return this;
      }
   }
}
