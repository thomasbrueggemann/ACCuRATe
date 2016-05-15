package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef extends zzc implements GameRequest {
   private final int zzaDQ;

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return GameRequestEntity.zza(this, var1);
   }

   public GameRequest freeze() {
      return new GameRequestEntity(this);
   }

   public long getCreationTimestamp() {
      return this.getLong("creation_timestamp");
   }

   public byte[] getData() {
      return this.getByteArray("data");
   }

   public long getExpirationTimestamp() {
      return this.getLong("expiration_timestamp");
   }

   public Game getGame() {
      return new GameRef(this.zzahi, this.zzaje);
   }

   public int getRecipientStatus(String var1) {
      for(int var2 = this.zzaje; var2 < this.zzaje + this.zzaDQ; ++var2) {
         int var3 = this.zzahi.zzbH(var2);
         if(this.zzahi.zzd("recipient_external_player_id", var2, var3).equals(var1)) {
            return this.zzahi.zzc("recipient_status", var2, var3);
         }
      }

      return -1;
   }

   public List<Player> getRecipients() {
      ArrayList var1 = new ArrayList(this.zzaDQ);

      for(int var2 = 0; var2 < this.zzaDQ; ++var2) {
         var1.add(new PlayerRef(this.zzahi, var2 + this.zzaje, "recipient_"));
      }

      return var1;
   }

   public String getRequestId() {
      return this.getString("external_request_id");
   }

   public Player getSender() {
      return new PlayerRef(this.zzahi, this.zzqc(), "sender_");
   }

   public int getStatus() {
      return this.getInteger("status");
   }

   public int getType() {
      return this.getInteger("type");
   }

   public int hashCode() {
      return GameRequestEntity.zza(this);
   }

   public String toString() {
      return GameRequestEntity.zzc(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((GameRequestEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
