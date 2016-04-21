package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1097;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.internal.multiplayer.InvitationClusterCreator;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

public final class ZInvitationCluster implements SafeParcelable, Invitation {
    public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
    // $FF: renamed from: BR int
    private final int field_4510;
    private final ArrayList<InvitationEntity> aaL;

    ZInvitationCluster(int var1, ArrayList<InvitationEntity> var2) {
        this.field_4510 = var1;
        this.aaL = var2;
        this.method_5081();
    }

    // $FF: renamed from: li () void
    private void method_5081() {
        boolean var1;
        if(!this.aaL.isEmpty()) {
            var1 = true;
        } else {
            var1 = false;
        }

        class_1097.method_5710(var1);
        Invitation var2 = (Invitation)this.aaL.get(0);
        int var3 = this.aaL.size();

        for(int var4 = 1; var4 < var3; ++var4) {
            Invitation var5 = (Invitation)this.aaL.get(var4);
            class_1097.method_5711(var2.getInviter().equals(var5.getInviter()), "All the invitations must be from the same inviter");
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
            if(var2.aaL.size() != this.aaL.size()) {
                return false;
            } else {
                int var3 = this.aaL.size();

                for(int var4 = 0; var4 < var3; ++var4) {
                    if(!((Invitation)this.aaL.get(var4)).equals((Invitation)var2.aaL.get(var4))) {
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
        return ((InvitationEntity)this.aaL.get(0)).getInvitationId();
    }

    public int getInvitationType() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Participant getInviter() {
        return ((InvitationEntity)this.aaL.get(0)).getInviter();
    }

    public ArrayList<Participant> getParticipants() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVariant() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVersionCode() {
        return this.field_4510;
    }

    public int hashCode() {
        return class_1089.hashCode(this.aaL.toArray());
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: lj () java.util.ArrayList
    public ArrayList<Invitation> method_5082() {
        return new ArrayList(this.aaL);
    }

    public void writeToParcel(Parcel var1, int var2) {
        InvitationClusterCreator.method_4913(this, var1, var2);
    }
}
