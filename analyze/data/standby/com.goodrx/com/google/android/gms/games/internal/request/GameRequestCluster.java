package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.request.GameRequestClusterCreator;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestCluster implements SafeParcelable, GameRequest {
   public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
   private final int mVersionCode;
   private final ArrayList<GameRequestEntity> zzaIW;

   GameRequestCluster(int var1, ArrayList<GameRequestEntity> var2) {
      this.mVersionCode = var1;
      this.zzaIW = var2;
      this.zzxr();
   }

   private void zzxr() {
      boolean var1;
      if(!this.zzaIW.isEmpty()) {
         var1 = true;
      } else {
         var1 = false;
      }

      zzb.zzab(var1);
      GameRequest var2 = (GameRequest)this.zzaIW.get(0);
      int var3 = this.zzaIW.size();

      for(int var4 = 1; var4 < var3; ++var4) {
         GameRequest var5 = (GameRequest)this.zzaIW.get(var4);
         boolean var6;
         if(var2.getType() == var5.getType()) {
            var6 = true;
         } else {
            var6 = false;
         }

         zzb.zza(var6, "All the requests must be of the same type");
         zzb.zza(var2.getSender().equals(var5.getSender()), "All the requests must be from the same sender");
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
         if(var2.zzaIW.size() != this.zzaIW.size()) {
            return false;
         } else {
            int var3 = this.zzaIW.size();

            for(int var4 = 0; var4 < var3; ++var4) {
               if(!((GameRequest)this.zzaIW.get(var4)).equals((GameRequest)var2.zzaIW.get(var4))) {
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
      return this.zzxG();
   }

   public String getRequestId() {
      return ((GameRequestEntity)this.zzaIW.get(0)).getRequestId();
   }

   public Player getSender() {
      return ((GameRequestEntity)this.zzaIW.get(0)).getSender();
   }

   public int getStatus() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getType() {
      return ((GameRequestEntity)this.zzaIW.get(0)).getType();
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zzw.hashCode(this.zzaIW.toArray());
   }

   public void writeToParcel(Parcel var1, int var2) {
      GameRequestClusterCreator.zza(this, var1, var2);
   }

   public ArrayList<GameRequest> zzxF() {
      return new ArrayList(this.zzaIW);
   }

   public ArrayList<Player> zzxG() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }
}
