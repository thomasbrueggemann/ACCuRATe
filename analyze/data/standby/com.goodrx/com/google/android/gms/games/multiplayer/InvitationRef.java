package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import java.util.ArrayList;

public final class InvitationRef extends zzc implements Invitation {
   private final ArrayList<Participant> zzaJI;
   private final ParticipantRef zzaJL;
   private final Game zzaJc;

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return InvitationEntity.zza(this, var1);
   }

   public Invitation freeze() {
      return new InvitationEntity(this);
   }

   public int getAvailableAutoMatchSlots() {
      return !this.getBoolean("has_automatch_criteria")?0:this.getInteger("automatch_max_players");
   }

   public long getCreationTimestamp() {
      return Math.max(this.getLong("creation_timestamp"), this.getLong("last_modified_timestamp"));
   }

   public Game getGame() {
      return this.zzaJc;
   }

   public String getInvitationId() {
      return this.getString("external_invitation_id");
   }

   public int getInvitationType() {
      return this.getInteger("type");
   }

   public Participant getInviter() {
      return this.zzaJL;
   }

   public ArrayList<Participant> getParticipants() {
      return this.zzaJI;
   }

   public int getVariant() {
      return this.getInteger("variant");
   }

   public int hashCode() {
      return InvitationEntity.zza(this);
   }

   public String toString() {
      return InvitationEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((InvitationEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
