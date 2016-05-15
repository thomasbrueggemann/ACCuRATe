package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import java.util.ArrayList;

public final class RoomRef extends zzc implements Room {
   private final int zzaDQ;

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return RoomEntity.zza(this, var1);
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

   public ArrayList<Participant> getParticipants() {
      ArrayList var1 = new ArrayList(this.zzaDQ);

      for(int var2 = 0; var2 < this.zzaDQ; ++var2) {
         var1.add(new ParticipantRef(this.zzahi, var2 + this.zzaje));
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
      return RoomEntity.zza(this);
   }

   public String toString() {
      return RoomEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((RoomEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
