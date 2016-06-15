package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import java.util.ArrayList;

public final class RoomRef extends class_251 implements Room {
   // $FF: renamed from: Ya int
   private final int field_528;

   RoomRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.field_528 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return RoomEntity.method_2398(this, var1);
   }

   public Room freeze() {
      return new RoomEntity(this);
   }

   public Bundle getAutoMatchCriteria() {
      return !this.getBoolean("has_automatch_criteria")?null:RoomConfig.createAutoMatchCriteria(this.getInteger("automatch_min_players"), this.getInteger("automatch_max_players"), this.getLong("automatch_bit_mask"));
   }

   public int getAutoMatchWaitEstimateSeconds() {
      return this.getInteger("automatch_wait_estimate_sec");
   }

   public long getCreationTimestamp() {
      return this.getLong("creation_timestamp");
   }

   public String getCreatorId() {
      return this.getString("creator_external");
   }

   public String getDescription() {
      return this.getString("description");
   }

   public void getDescription(CharArrayBuffer var1) {
      this.a("description", var1);
   }

   public Participant getParticipant(String var1) {
      return RoomEntity.method_2403(this, var1);
   }

   public String getParticipantId(String var1) {
      return RoomEntity.method_2400(this, var1);
   }

   public ArrayList<String> getParticipantIds() {
      return RoomEntity.method_2404(this);
   }

   public int getParticipantStatus(String var1) {
      return RoomEntity.method_2397(this, var1);
   }

   public ArrayList<Participant> getParticipants() {
      ArrayList var1 = new ArrayList(this.field_528);

      for(int var2 = 0; var2 < this.field_528; ++var2) {
         var1.add(new ParticipantRef(this.JG, var2 + this.KZ));
      }

      return var1;
   }

   public String getRoomId() {
      return this.getString("external_match_id");
   }

   public int getStatus() {
      return this.getInteger("status");
   }

   public int getVariant() {
      return this.getInteger("variant");
   }

   public int hashCode() {
      return RoomEntity.method_2396(this);
   }

   public String toString() {
      return RoomEntity.method_2399(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((RoomEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
