package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.internal.multiplayer.InvitationClusterCreator;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;

public final class ZInvitationCluster implements SafeParcelable, Invitation {
   public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
   // $FF: renamed from: CK int
   private final int field_3773;
   private final ArrayList<InvitationEntity> acE;

   ZInvitationCluster(int var1, ArrayList<InvitationEntity> var2) {
      this.field_3773 = var1;
      this.acE = var2;
      this.method_4934();
   }

   // $FF: renamed from: mp () void
   private void method_4934() {
      boolean var1;
      if(!this.acE.isEmpty()) {
         var1 = true;
      } else {
         var1 = false;
      }

      class_349.method_2425(var1);
      Invitation var2 = (Invitation)this.acE.get(0);
      int var3 = this.acE.size();

      for(int var4 = 1; var4 < var3; ++var4) {
         Invitation var5 = (Invitation)this.acE.get(var4);
         class_349.method_2426(var2.getInviter().equals(var5.getInviter()), "All the invitations must be from the same inviter");
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
         if(var2.acE.size() != this.acE.size()) {
            return false;
         } else {
            int var3 = this.acE.size();

            for(int var4 = 0; var4 < var3; ++var4) {
               if(!((Invitation)this.acE.get(var4)).equals((Invitation)var2.acE.get(var4))) {
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
      return ((InvitationEntity)this.acE.get(0)).getInvitationId();
   }

   public int getInvitationType() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public Participant getInviter() {
      return ((InvitationEntity)this.acE.get(0)).getInviter();
   }

   public ArrayList<Participant> getParticipants() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getVariant() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getVersionCode() {
      return this.field_3773;
   }

   public int hashCode() {
      return class_336.hashCode(this.acE.toArray());
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: mq () java.util.ArrayList
   public ArrayList<Invitation> method_4935() {
      return new ArrayList(this.acE);
   }

   public void writeToParcel(Parcel var1, int var2) {
      InvitationClusterCreator.method_4756(this, var1, var2);
   }
}
