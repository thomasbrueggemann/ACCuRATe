package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public final class ParticipantRef extends zzc implements Participant {
   private final PlayerRef zzaJO;

   public ParticipantRef(DataHolder var1, int var2) {
      super(var1, var2);
      this.zzaJO = new PlayerRef(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return ParticipantEntity.zza(this, var1);
   }

   public Participant freeze() {
      return new ParticipantEntity(this);
   }

   public int getCapabilities() {
      return this.getInteger("capabilities");
   }

   public String getDisplayName() {
      return this.zzcB("external_player_id")?this.getString("default_display_name"):this.zzaJO.getDisplayName();
   }

   public Uri getHiResImageUri() {
      return this.zzcB("external_player_id")?this.zzcA("default_display_hi_res_image_uri"):this.zzaJO.getHiResImageUri();
   }

   public String getHiResImageUrl() {
      return this.zzcB("external_player_id")?this.getString("default_display_hi_res_image_url"):this.zzaJO.getHiResImageUrl();
   }

   public Uri getIconImageUri() {
      return this.zzcB("external_player_id")?this.zzcA("default_display_image_uri"):this.zzaJO.getIconImageUri();
   }

   public String getIconImageUrl() {
      return this.zzcB("external_player_id")?this.getString("default_display_image_url"):this.zzaJO.getIconImageUrl();
   }

   public String getParticipantId() {
      return this.getString("external_participant_id");
   }

   public Player getPlayer() {
      return this.zzcB("external_player_id")?null:this.zzaJO;
   }

   public ParticipantResult getResult() {
      if(this.zzcB("result_type")) {
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
      return ParticipantEntity.zza(this);
   }

   public boolean isConnectedToRoom() {
      return this.getInteger("connected") > 0;
   }

   public String toString() {
      return ParticipantEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((ParticipantEntity)this.freeze()).writeToParcel(var1, var2);
   }

   public String zzwt() {
      return this.getString("client_address");
   }
}
