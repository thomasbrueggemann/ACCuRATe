package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public final class ParticipantRef extends class_206 implements Participant {
   // $FF: renamed from: Tb com.google.android.gms.games.PlayerRef
   private final PlayerRef field_682;

   public ParticipantRef(DataHolder var1, int var2) {
      super(var1, var2);
      this.field_682 = new PlayerRef(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return ParticipantEntity.method_2203(this, var1);
   }

   public Participant freeze() {
      return new ParticipantEntity(this);
   }

   // $FF: renamed from: gR () java.lang.String
   public String method_232() {
      return this.getString("client_address");
   }

   public int getCapabilities() {
      return this.getInteger("capabilities");
   }

   public String getDisplayName() {
      return this.ax("external_player_id")?this.getString("default_display_name"):this.field_682.getDisplayName();
   }

   public void getDisplayName(CharArrayBuffer var1) {
      if(this.ax("external_player_id")) {
         this.a("default_display_name", var1);
      } else {
         this.field_682.getDisplayName(var1);
      }
   }

   public Uri getHiResImageUri() {
      return this.ax("external_player_id")?this.aw("default_display_hi_res_image_uri"):this.field_682.getHiResImageUri();
   }

   public String getHiResImageUrl() {
      return this.ax("external_player_id")?this.getString("default_display_hi_res_image_url"):this.field_682.getHiResImageUrl();
   }

   public Uri getIconImageUri() {
      return this.ax("external_player_id")?this.aw("default_display_image_uri"):this.field_682.getIconImageUri();
   }

   public String getIconImageUrl() {
      return this.ax("external_player_id")?this.getString("default_display_image_url"):this.field_682.getIconImageUrl();
   }

   public String getParticipantId() {
      return this.getString("external_participant_id");
   }

   public Player getPlayer() {
      return this.ax("external_player_id")?null:this.field_682;
   }

   public ParticipantResult getResult() {
      if(this.ax("result_type")) {
         return null;
      } else {
         int var1 = this.getInteger("result_type");
         int var2 = this.getInteger("placing");
         return new ParticipantResult(this.getParticipantId(), var1, var2);
      }
   }

   public int getStatus() {
      return this.getInteger("player_status");
   }

   public int hashCode() {
      return ParticipantEntity.method_2202(this);
   }

   public boolean isConnectedToRoom() {
      return this.getInteger("connected") > 0;
   }

   public String toString() {
      return ParticipantEntity.method_2205(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((ParticipantEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
