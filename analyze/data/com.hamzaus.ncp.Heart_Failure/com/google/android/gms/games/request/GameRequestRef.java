package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef extends class_206 implements GameRequest {
   // $FF: renamed from: RD int
   private final int field_694;

   public GameRequestRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.field_694 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return GameRequestEntity.method_3276(this, var1);
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
      return new GameRef(this.DD, this.Ez);
   }

   public int getRecipientStatus(String var1) {
      for(int var2 = this.Ez; var2 < this.Ez + this.field_694; ++var2) {
         int var3 = this.DD.method_4556(var2);
         if(this.DD.method_4560("recipient_external_player_id", var2, var3).equals(var1)) {
            return this.DD.method_4558("recipient_status", var2, var3);
         }
      }

      return -1;
   }

   public List<Player> getRecipients() {
      ArrayList var1 = new ArrayList(this.field_694);

      for(int var2 = 0; var2 < this.field_694; ++var2) {
         var1.add(new PlayerRef(this.DD, var2 + this.Ez, "recipient_"));
      }

      return var1;
   }

   public String getRequestId() {
      return this.getString("external_request_id");
   }

   public Player getSender() {
      return new PlayerRef(this.DD, this.eQ(), "sender_");
   }

   public int getStatus() {
      return this.getInteger("status");
   }

   public int getType() {
      return this.getInteger("type");
   }

   public int hashCode() {
      return GameRequestEntity.method_3275(this);
   }

   public boolean isConsumed(String var1) {
      return this.getRecipientStatus(var1) == 1;
   }

   public String toString() {
      return GameRequestEntity.method_3278(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((GameRequestEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
