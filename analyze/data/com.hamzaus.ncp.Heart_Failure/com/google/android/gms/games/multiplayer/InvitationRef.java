package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.internal.class_347;
import java.util.ArrayList;

public final class InvitationRef extends class_206 implements Invitation {
   // $FF: renamed from: SU java.util.ArrayList
   private final ArrayList<Participant> field_700;
   // $FF: renamed from: SX com.google.android.gms.games.multiplayer.ParticipantRef
   private final ParticipantRef field_701;
   // $FF: renamed from: Sp com.google.android.gms.games.Game
   private final Game field_702;

   InvitationRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.field_702 = new GameRef(var1, var2);
      this.field_700 = new ArrayList(var3);
      String var4 = this.getString("external_inviter_id");
      int var5 = 0;

      ParticipantRef var6;
      for(var6 = null; var5 < var3; ++var5) {
         ParticipantRef var7 = new ParticipantRef(this.DD, var5 + this.Ez);
         if(var7.getParticipantId().equals(var4)) {
            var6 = var7;
         }

         this.field_700.add(var7);
      }

      this.field_701 = (ParticipantRef)class_347.method_2166(var6, "Must have a valid inviter!");
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return InvitationEntity.method_2197(this, var1);
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
      return this.field_702;
   }

   public String getInvitationId() {
      return this.getString("external_invitation_id");
   }

   public int getInvitationType() {
      return this.getInteger("type");
   }

   public Participant getInviter() {
      return this.field_701;
   }

   public ArrayList<Participant> getParticipants() {
      return this.field_700;
   }

   public int getVariant() {
      return this.getInteger("variant");
   }

   public int hashCode() {
      return InvitationEntity.method_2196(this);
   }

   public String toString() {
      return InvitationEntity.method_2199(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((InvitationEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
