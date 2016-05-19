package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.internal.multiplayer.InvitationClusterCreator;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

public final class ZInvitationCluster implements SafeParcelable, Invitation {
   public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
   private final int mVersionCode;
   private final ArrayList<InvitationEntity> zzaIl;

   ZInvitationCluster(int var1, ArrayList<InvitationEntity> var2) {
      this.mVersionCode = var1;
      this.zzaIl = var2;
      this.zzxr();
   }

   private void zzxr() {
      boolean var1;
      if(!this.zzaIl.isEmpty()) {
         var1 = true;
      } else {
         var1 = false;
      }

      zzb.zzab(var1);
      Invitation var2 = (Invitation)this.zzaIl.get(0);
      int var3 = this.zzaIl.size();

      for(int var4 = 1; var4 < var3; ++var4) {
         Invitation var5 = (Invitation)this.zzaIl.get(var4);
         zzb.zza(var2.getInviter().equals(var5.getInviter()), "All the invitations must be from the same inviter");
      }

   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof ZInvitationCluster)) {
         return false;
      } else if(this == var1) {
         return true;
      } else {
         ZInvitationCluster var2 = (ZInvitationCluster)var1;
         if(var2.zzaIl.size() != this.zzaIl.size()) {
            return false;
         } else {
            int var3 = this.zzaIl.size();

            for(int var4 = 0; var4 < var3; ++var4) {
               if(!((Invitation)this.zzaIl.get(var4)).equals((Invitation)var2.zzaIl.get(var4))) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public Invitation freeze() {
      return this;
   }

   public int getAvailableAutoMatchSlots() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public long getCreationTimestamp() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public Game getGame() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public String getInvitationId() {
      return ((InvitationEntity)this.zzaIl.get(0)).getInvitationId();
   }

   public int getInvitationType() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public Participant getInviter() {
      return ((InvitationEntity)this.zzaIl.get(0)).getInviter();
   }

   public ArrayList<Participant> getParticipants() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getVariant() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zzw.hashCode(this.zzaIl.toArray());
   }

   public void writeToParcel(Parcel var1, int var2) {
      InvitationClusterCreator.zza(this, var1, var2);
   }

   public ArrayList<Invitation> zzxs() {
      return new ArrayList(this.zzaIl);
   }
}
