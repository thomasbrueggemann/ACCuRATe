package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.request.GameRequestClusterCreator;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestCluster implements SafeParcelable, GameRequest {
   public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
   // $FF: renamed from: CK int
   private final int field_4194;
   private final ArrayList<GameRequestEntity> adk;

   GameRequestCluster(int var1, ArrayList<GameRequestEntity> var2) {
      this.field_4194 = var1;
      this.adk = var2;
      this.method_5430();
   }

   // $FF: renamed from: mp () void
   private void method_5430() {
      boolean var1;
      if(!this.adk.isEmpty()) {
         var1 = true;
      } else {
         var1 = false;
      }

      class_349.method_2425(var1);
      GameRequest var2 = (GameRequest)this.adk.get(0);
      int var3 = this.adk.size();

      for(int var4 = 1; var4 < var3; ++var4) {
         GameRequest var5 = (GameRequest)this.adk.get(var4);
         boolean var6;
         if(var2.getType() == var5.getType()) {
            var6 = true;
         } else {
            var6 = false;
         }

         class_349.method_2426(var6, "All the requests must be of the same type");
         class_349.method_2426(var2.getSender().equals(var5.getSender()), "All the requests must be from the same sender");
      }

   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof GameRequestCluster)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         GameRequestCluster var2 = (GameRequestCluster)var1;
         if(var2.adk.size() != this.adk.size()) {
            return false;
         } else {
            int var3 = this.adk.size();

            for(int var4 = 0; var4 < var3; ++var4) {
               if(!((GameRequest)this.adk.get(var4)).equals((GameRequest)var2.adk.get(var4))) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public GameRequest freeze() {
      return this;
   }

   public long getCreationTimestamp() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public byte[] getData() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public long getExpirationTimestamp() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public Game getGame() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getRecipientStatus(String var1) {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   // $FF: synthetic method
   public List getRecipients() {
      return this.method_5432();
   }

   public String getRequestId() {
      return ((GameRequestEntity)this.adk.get(0)).getRequestId();
   }

   public Player getSender() {
      return ((GameRequestEntity)this.adk.get(0)).getSender();
   }

   public int getStatus() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getType() {
      return ((GameRequestEntity)this.adk.get(0)).getType();
   }

   public int getVersionCode() {
      return this.field_4194;
   }

   public int hashCode() {
      return class_336.hashCode(this.adk.toArray());
   }

   public boolean isConsumed(String var1) {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: mD () java.util.ArrayList
   public ArrayList<GameRequest> method_5431() {
      return new ArrayList(this.adk);
   }

   // $FF: renamed from: mE () java.util.ArrayList
   public ArrayList<Player> method_5432() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public void writeToParcel(Parcel var1, int var2) {
      GameRequestClusterCreator.method_5521(this, var1, var2);
   }
}
