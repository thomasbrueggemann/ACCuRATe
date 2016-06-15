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
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_719;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
   public static final Creator<RoomEntity> CREATOR = new RoomEntity.RoomEntityCreatorCompat();
   // $FF: renamed from: CK int
   private final int field_996;
   // $FF: renamed from: UO java.lang.String
   private final String field_997;
   // $FF: renamed from: YI java.lang.String
   private final String field_998;
   private final long adS;
   private final ArrayList<ParticipantEntity> adV;
   private final int adW;
   private final Bundle aem;
   private final String aep;
   private final int aeq;
   private final int aer;

   RoomEntity(int var1, String var2, String var3, long var4, int var6, String var7, int var8, Bundle var9, ArrayList<ParticipantEntity> var10, int var11) {
      this.field_996 = var1;
      this.field_998 = var2;
      this.aep = var3;
      this.adS = var4;
      this.aeq = var6;
      this.field_997 = var7;
      this.adW = var8;
      this.aem = var9;
      this.adV = var10;
      this.aer = var11;
   }

   public RoomEntity(Room var1) {
      this.field_996 = 2;
      this.field_998 = var1.getRoomId();
      this.aep = var1.getCreatorId();
      this.adS = var1.getCreationTimestamp();
      this.aeq = var1.getStatus();
      this.field_997 = var1.getDescription();
      this.adW = var1.getVariant();
      this.aem = var1.getAutoMatchCriteria();
      ArrayList var2 = var1.getParticipants();
      int var3 = var2.size();
      this.adV = new ArrayList(var3);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.adV.add((ParticipantEntity)((Participant)var2.get(var4)).freeze());
      }

      this.aer = var1.getAutoMatchWaitEstimateSeconds();
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.Room) int
   static int method_2396(Room var0) {
      Object[] var1 = new Object[]{var0.getRoomId(), var0.getCreatorId(), Long.valueOf(var0.getCreationTimestamp()), Integer.valueOf(var0.getStatus()), var0.getDescription(), Integer.valueOf(var0.getVariant()), var0.getAutoMatchCriteria(), var0.getParticipants(), Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds())};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.Room, java.lang.String) int
   static int method_2397(Room var0, String var1) {
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
   static boolean method_2398(Room var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Room)) {
         var2 = false;
      } else if(var0 != var1) {
         Room var3 = (Room)var1;
         if(!class_336.equal(var3.getRoomId(), var0.getRoomId()) || !class_336.equal(var3.getCreatorId(), var0.getCreatorId()) || !class_336.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !class_336.equal(Integer.valueOf(var3.getStatus()), Integer.valueOf(var0.getStatus())) || !class_336.equal(var3.getDescription(), var0.getDescription()) || !class_336.equal(Integer.valueOf(var3.getVariant()), Integer.valueOf(var0.getVariant())) || !class_336.equal(var3.getAutoMatchCriteria(), var0.getAutoMatchCriteria()) || !class_336.equal(var3.getParticipants(), var0.getParticipants()) || !class_336.equal(Integer.valueOf(var3.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.realtime.Room) java.lang.String
   static String method_2399(Room var0) {
      return class_336.method_2312(var0).method_3424("RoomId", var0.getRoomId()).method_3424("CreatorId", var0.getCreatorId()).method_3424("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).method_3424("RoomStatus", Integer.valueOf(var0.getStatus())).method_3424("Description", var0.getDescription()).method_3424("Variant", Integer.valueOf(var0.getVariant())).method_3424("AutoMatchCriteria", var0.getAutoMatchCriteria()).method_3424("Participants", var0.getParticipants()).method_3424("AutoMatchWaitEstimateSeconds", Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds())).toString();
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.realtime.Room, java.lang.String) java.lang.String
   static String method_2400(Room var0, String var1) {
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
   static Participant method_2403(Room var0, String var1) {
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
   static ArrayList<String> method_2404(Room var0) {
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
      return method_2398(this, var1);
   }

   public Room freeze() {
      return this;
   }

   public Bundle getAutoMatchCriteria() {
      return this.aem;
   }

   public int getAutoMatchWaitEstimateSeconds() {
      return this.aer;
   }

   public long getCreationTimestamp() {
      return this.adS;
   }

   public String getCreatorId() {
      return this.aep;
   }

   public String getDescription() {
      return this.field_997;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_719.method_4197(this.field_997, var1);
   }

   public Participant getParticipant(String var1) {
      return method_2403(this, var1);
   }

   public String getParticipantId(String var1) {
      return method_2400(this, var1);
   }

   public ArrayList<String> getParticipantIds() {
      return method_2404(this);
   }

   public int getParticipantStatus(String var1) {
      return method_2397(this, var1);
   }

   public ArrayList<Participant> getParticipants() {
      return new ArrayList(this.adV);
   }

   public String getRoomId() {
      return this.field_998;
   }

   public int getStatus() {
      return this.aeq;
   }

   public int getVariant() {
      return this.adW;
   }

   public int getVersionCode() {
      return this.field_996;
   }

   public int hashCode() {
      return method_2396(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String toString() {
      return method_2399(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.hu()) {
         RoomEntityCreator.method_3897(this, var1, var2);
      } else {
         var1.writeString(this.field_998);
         var1.writeString(this.aep);
         var1.writeLong(this.adS);
         var1.writeInt(this.aeq);
         var1.writeString(this.field_997);
         var1.writeInt(this.adW);
         var1.writeBundle(this.aem);
         int var3 = this.adV.size();
         var1.writeInt(var3);

         for(int var4 = 0; var4 < var3; ++var4) {
            ((ParticipantEntity)this.adV.get(var4)).writeToParcel(var1, var2);
         }
      }

   }

   static final class RoomEntityCreatorCompat extends RoomEntityCreator {
      // $FF: renamed from: cC (android.os.Parcel) com.google.android.gms.games.multiplayer.realtime.RoomEntity
      public RoomEntity method_3898(Parcel var1) {
         if(!RoomEntity.c(RoomEntity.ht()) && !RoomEntity.aW(RoomEntity.class.getCanonicalName())) {
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
            return super.method_3898(var1);
         }
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.method_3898(var1);
      }
   }
}
