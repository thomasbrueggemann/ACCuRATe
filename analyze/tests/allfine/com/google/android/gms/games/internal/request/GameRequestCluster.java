package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1097;
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
    // $FF: renamed from: BR int
    private final int field_5045;
    private final ArrayList<GameRequestEntity> abr;

    GameRequestCluster(int var1, ArrayList<GameRequestEntity> var2) {
        this.field_5045 = var1;
        this.abr = var2;
        this.method_5550();
    }

    // $FF: renamed from: li () void
    private void method_5550() {
        boolean var1;
        if(!this.abr.isEmpty()) {
            var1 = true;
        } else {
            var1 = false;
        }

        class_1097.method_5710(var1);
        GameRequest var2 = (GameRequest)this.abr.get(0);
        int var3 = this.abr.size();

        for(int var4 = 1; var4 < var3; ++var4) {
            GameRequest var5 = (GameRequest)this.abr.get(var4);
            boolean var6;
            if(var2.getType() == var5.getType()) {
                var6 = true;
            } else {
                var6 = false;
            }

            class_1097.method_5711(var6, "All the requests must be of the same type");
            class_1097.method_5711(var2.getSender().equals(var5.getSender()), "All the requests must be from the same sender");
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
            if(var2.abr.size() != this.abr.size()) {
                return false;
            } else {
                int var3 = this.abr.size();

                for(int var4 = 0; var4 < var3; ++var4) {
                    if(!((GameRequest)this.abr.get(var4)).equals((GameRequest)var2.abr.get(var4))) {
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
        return this.method_5552();
    }

    public String getRequestId() {
        return ((GameRequestEntity)this.abr.get(0)).getRequestId();
    }

    public Player getSender() {
        return ((GameRequestEntity)this.abr.get(0)).getSender();
    }

    public int getStatus() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getType() {
        return ((GameRequestEntity)this.abr.get(0)).getType();
    }

    public int getVersionCode() {
        return this.field_5045;
    }

    public int hashCode() {
        return class_1089.hashCode(this.abr.toArray());
    }

    public boolean isConsumed(String var1) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public boolean isDataValid() {
        return true;
    }

    // $FF: renamed from: lw () java.util.ArrayList
    public ArrayList<GameRequest> method_5551() {
        return new ArrayList(this.abr);
    }

    // $FF: renamed from: lx () java.util.ArrayList
    public ArrayList<Player> method_5552() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public void writeToParcel(Parcel var1, int var2) {
        GameRequestClusterCreator.method_5630(this, var1, var2);
    }
}
