package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.internal.multiplayer.InvitationClusterCreator;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;

public final class ZInvitationCluster implements SafeParcelable, Invitation {
   public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
   // $FF: renamed from: RE java.util.ArrayList
   private final ArrayList<InvitationEntity> field_3634;
   // $FF: renamed from: xJ int
   private final int field_3635;

   ZInvitationCluster(int var1, ArrayList<InvitationEntity> var2) {
      this.field_3635 = var1;
      this.field_3634 = var2;
      this.method_3949();
   }

   // $FF: renamed from: id () void
   private void method_3949() {
      boolean var1;
      if(!this.field_3634.isEmpty()) {
         var1 = true;
      } else {
         var1 = false;
      }

      class_322.method_2050(var1);
      Invitation var2 = (Invitation)this.field_3634.get(0);
      int var3 = this.field_3634.size();

      for(int var4 = 1; var4 < var3; ++var4) {
         Invitation var5 = (Invitation)this.field_3634.get(var4);
         class_322.method_2051(var2.getInviter().equals(var5.getInviter()), "All the invitations must be from the same inviter");
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
         if(var2.field_3634.size() != this.field_3634.size()) {
            return false;
         } else {
            int var3 = this.field_3634.size();

            for(int var4 = 0; var4 < var3; ++var4) {
               if(!((Invitation)this.field_3634.get(var4)).equals((Invitation)var2.field_3634.get(var4))) {
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
      return ((InvitationEntity)this.field_3634.get(0)).getInvitationId();
   }

   public int getInvitationType() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public Participant getInviter() {
      return ((InvitationEntity)this.field_3634.get(0)).getInviter();
   }

   public ArrayList<Participant> getParticipants() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getVariant() {
      throw new UnsupportedOperationException("Method not supported on a cluster");
   }

   public int getVersionCode() {
      return this.field_3635;
   }

   public int hashCode() {
      return class_349.hashCode(this.field_3634.toArray());
   }

   // $FF: renamed from: ie () java.util.ArrayList
   public ArrayList<Invitation> method_3950() {
      return new ArrayList(this.field_3634);
   }

   public boolean isDataValid() {
      return true;
   }

   public void writeToParcel(Parcel var1, int var2) {
      InvitationClusterCreator.method_3802(this, var1, var2);
   }
}
