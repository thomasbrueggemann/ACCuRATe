package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomEntityCreator;
import com.google.android.gms.internal.class_284;
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
   public static final Creator<RoomEntity> CREATOR = new RoomEntity.RoomEntityCreatorCompat();
   // $FF: renamed from: Mm java.lang.String
   private final String field_1468;
   // $FF: renamed from: NP java.lang.String
   private final String field_1469;
   // $FF: renamed from: SR long
   private final long field_1470;
   // $FF: renamed from: SU java.util.ArrayList
   private final ArrayList<ParticipantEntity> field_1471;
   // $FF: renamed from: SV int
   private final int field_1472;
   // $FF: renamed from: Tl android.os.Bundle
   private final Bundle field_1473;
   // $FF: renamed from: Tp java.lang.String
   private final String field_1474;
   // $FF: renamed from: Tq int
   private final int field_1475;
   // $FF: renamed from: Tr int
   private final int field_1476;
   // $FF: renamed from: xJ int
   private final int field_1477;

   RoomEntity(int var1, String var2, String var3, long var4, int var6, String var7, int var8, Bundle var9, ArrayList<ParticipantEntity> var10, int var11) {
      this.field_1477 = var1;
      this.field_1469 = var2;
      this.field_1474 = var3;
      this.field_1470 = var4;
      this.field_1475 = var6;
      this.field_1468 = var7;
      this.field_1472 = var8;
      this.field_1473 = var9;
      this.field_1471 = var10;
      this.field_1476 = var11;
   }

   public RoomEntity(Room var1) {
      this.field_1477 = 2;
      this.field_1469 = var1.getRoomId();
      this.field_1474 = var1.getCreatorId();
      this.field_1470 = var1.getCreationTimestamp();
      this.field_1475 = var1.getStatus();
      this.field_1468 = var1.getDescription();
      this.field_1472 = var1.getVariant();
      this.field_1473 = var1.getAutoMatchCriteria();
      ArrayList var2 = var1.getParticipants();
      int var3 = var2.size();
      this.field_1471 = new ArrayList(var3);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field_1471.add((ParticipantEntity)((Participant)var2.get(var4)).freeze());
      }

      this.field_1476 = var1.getAutoMatchWaitEstimateSeconds();
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.Room) int
   static int method_2208(Room var0) {
      Object[] var1 = new Object[]{var0.getRoomId(), var0.getCreatorId(), Long.valueOf(var0.getCreationTimestamp()), Integer.valueOf(var0.getStatus()), var0.getDescription(), Integer.valueOf(var0.getVariant()), var0.getAutoMatchCriteria(), var0.getParticipants(), Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds())};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.Room, java.lang.String) int
   static int method_2209(Room var0, String var1) {
      ArrayList var2 = var0.getParticipants();
      int var3 = var2.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         Participant var5 = (Participant)var2.get(var4);
         if(var5.getParticipantId().equals(var1)) {
            return var5.getStatus();
         }
      }

      throw new IllegalStateException("Participant " + var1 + " is not in room " + var0.getRoomId());
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.Room, java.lang.Object) boolean
   static boolean method_2210(Room var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Room)) {
         var2 = false;
      } else if(var0 != var1) {
         Room var3 = (Room)var1;
         if(!class_349.equal(var3.getRoomId(), var0.getRoomId()) || !class_349.equal(var3.getCreatorId(), var0.getCreatorId()) || !class_349.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !class_349.equal(Integer.valueOf(var3.getStatus()), Integer.valueOf(var0.getStatus())) || !class_349.equal(var3.getDescription(), var0.getDescription()) || !class_349.equal(Integer.valueOf(var3.getVariant()), Integer.valueOf(var0.getVariant())) || !class_349.equal(var3.getAutoMatchCriteria(), var0.getAutoMatchCriteria()) || !class_349.equal(var3.getParticipants(), var0.getParticipants()) || !class_349.equal(Integer.valueOf(var3.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.realtime.Room) java.lang.String
   static String method_2212(Room var0) {
      return class_349.method_2174(var0).method_4301("RoomId", var0.getRoomId()).method_4301("CreatorId", var0.getCreatorId()).method_4301("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).method_4301("RoomStatus", Integer.valueOf(var0.getStatus())).method_4301("Description", var0.getDescription()).method_4301("Variant", Integer.valueOf(var0.getVariant())).method_4301("AutoMatchCriteria", var0.getAutoMatchCriteria()).method_4301("Participants", var0.getParticipants()).method_4301("AutoMatchWaitEstimateSeconds", Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds())).toString();
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.realtime.Room, java.lang.String) java.lang.String
   static String method_2213(Room var0, String var1) {
      ArrayList var2 = var0.getParticipants();
      int var3 = var2.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         Participant var5 = (Participant)var2.get(var4);
         Player var6 = var5.getPlayer();
         if(var6 != null && var6.getPlayerId().equals(var1)) {
            return var5.getParticipantId();
         }
      }

      return null;
   }

   // $FF: renamed from: c (com.google.android.gms.games.multiplayer.realtime.Room, java.lang.String) com.google.android.gms.games.multiplayer.Participant
   static Participant method_2215(Room var0, String var1) {
      ArrayList var2 = var0.getParticipants();
      int var3 = var2.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         Participant var5 = (Participant)var2.get(var4);
         if(var5.getParticipantId().equals(var1)) {
            return var5;
         }
      }

      throw new IllegalStateException("Participant " + var1 + " is not in match " + var0.getRoomId());
   }

   // $FF: renamed from: c (com.google.android.gms.games.multiplayer.realtime.Room) java.util.ArrayList
   static ArrayList<String> method_2216(Room var0) {
      ArrayList var1 = var0.getParticipants();
      int var2 = var1.size();
      ArrayList var3 = new ArrayList(var2);

      for(int var4 = 0; var4 < var2; ++var4) {
         var3.add(((Participant)var1.get(var4)).getParticipantId());
      }

      return var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2210(this, var1);
   }

   public Room freeze() {
      return this;
   }

   public Bundle getAutoMatchCriteria() {
      return this.field_1473;
   }

   public int getAutoMatchWaitEstimateSeconds() {
      return this.field_1476;
   }

   public long getCreationTimestamp() {
      return this.field_1470;
   }

   public String getCreatorId() {
      return this.field_1474;
   }

   public String getDescription() {
      return this.field_1468;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_284.method_1876(this.field_1468, var1);
   }

   public Participant getParticipant(String var1) {
      return method_2215(this, var1);
   }

   public String getParticipantId(String var1) {
      return method_2213(this, var1);
   }

   public ArrayList<String> getParticipantIds() {
      return method_2216(this);
   }

   public int getParticipantStatus(String var1) {
      return method_2209(this, var1);
   }

   public ArrayList<Participant> getParticipants() {
      return new ArrayList(this.field_1471);
   }

   public String getRoomId() {
      return this.field_1469;
   }

   public int getStatus() {
      return this.field_1475;
   }

   public int getVariant() {
      return this.field_1472;
   }

   public int getVersionCode() {
      return this.field_1477;
   }

   public int hashCode() {
      return method_2208(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_2212(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.fm()) {
         RoomEntityCreator.method_3282(this, var1, var2);
      } else {
         var1.writeString(this.field_1469);
         var1.writeString(this.field_1474);
         var1.writeLong(this.field_1470);
         var1.writeInt(this.field_1475);
         var1.writeString(this.field_1468);
         var1.writeInt(this.field_1472);
         var1.writeBundle(this.field_1473);
         int var3 = this.field_1471.size();
         var1.writeInt(var3);

         for(int var4 = 0; var4 < var3; ++var4) {
            ((ParticipantEntity)this.field_1471.get(var4)).writeToParcel(var1, var2);
         }
      }

   }

   static final class RoomEntityCreatorCompat extends RoomEntityCreator {
      // $FF: renamed from: bo (android.os.Parcel) com.google.android.gms.games.multiplayer.realtime.RoomEntity
      public RoomEntity method_3283(Parcel var1) {
         if(!RoomEntity.c(RoomEntity.fl()) && !RoomEntity.aA(RoomEntity.class.getCanonicalName())) {
            String var2 = var1.readString();
            String var3 = var1.readString();
            long var4 = var1.readLong();
            int var6 = var1.readInt();
            String var7 = var1.readString();
            int var8 = var1.readInt();
            Bundle var9 = var1.readBundle();
            int var10 = var1.readInt();
            ArrayList var11 = new ArrayList(var10);

            for(int var12 = 0; var12 < var10; ++var12) {
               var11.add(ParticipantEntity.CREATOR.createFromParcel(var1));
            }

            return new RoomEntity(2, var2, var3, var4, var6, var7, var8, var9, var11, -1);
         } else {
            return super.method_3283(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_3283(var1);
      }
   }
}
