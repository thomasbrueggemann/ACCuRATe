package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.internal.class_335;
import java.util.ArrayList;

public final class InvitationRef extends class_251 implements Invitation {
   private final ArrayList<Participant> adV;
   private final ParticipantRef adY;
   private final Game adq;

   InvitationRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.adq = new GameRef(var1, var2);
      this.adV = new ArrayList(var3);
      String var4 = this.getString("external_inviter_id");
      int var5 = 0;

      ParticipantRef var6;
      for(var6 = null; var5 < var3; ++var5) {
         ParticipantRef var7 = new ParticipantRef(this.JG, var5 + this.KZ);
         if(var7.getParticipantId().equals(var4)) {
            var6 = var7;
         }

         this.adV.add(var7);
      }

      this.adY = (ParticipantRef)class_335.method_2306(var6, "Must have a valid inviter!");
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return InvitationEntity.method_2385(this, var1);
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
      return this.adq;
   }

   public String getInvitationId() {
      return this.getString("external_invitation_id");
   }

   public int getInvitationType() {
      return this.getInteger("type");
   }

   public Participant getInviter() {
      return this.adY;
   }

   public ArrayList<Participant> getParticipants() {
      return this.adV;
   }

   public int getVariant() {
      return this.getInteger("variant");
   }

   public int hashCode() {
      return InvitationEntity.method_2384(this);
   }

   public String toString() {
      return InvitationEntity.method_2386(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((InvitationEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
