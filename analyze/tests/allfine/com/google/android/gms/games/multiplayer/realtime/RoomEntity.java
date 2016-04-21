package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomEntityCreator;
import com.google.android.gms.internal.class_345;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Creator<RoomEntity> CREATOR = new RoomEntity.RoomEntityCreatorCompat();
    // $FF: renamed from: BR int
    private final int field_2793;
    // $FF: renamed from: Tr java.lang.String
    private final String field_2794;
    // $FF: renamed from: WQ java.lang.String
    private final String field_2795;
    private final long abZ;
    private final ArrayList<ParticipantEntity> acc;
    private final int acd;
    private final Bundle acs;
    private final String acw;
    private final int acx;
    private final int acy;

    RoomEntity(int var1, String var2, String var3, long var4, int var6, String var7, int var8, Bundle var9, ArrayList<ParticipantEntity> var10, int var11) {
        this.field_2793 = var1;
        this.field_2795 = var2;
        this.acw = var3;
        this.abZ = var4;
        this.acx = var6;
        this.field_2794 = var7;
        this.acd = var8;
        this.acs = var9;
        this.acc = var10;
        this.acy = var11;
    }

    public RoomEntity(Room var1) {
        this.field_2793 = 2;
        this.field_2795 = var1.getRoomId();
        this.acw = var1.getCreatorId();
        this.abZ = var1.getCreationTimestamp();
        this.acx = var1.getStatus();
        this.field_2794 = var1.getDescription();
        this.acd = var1.getVariant();
        this.acs = var1.getAutoMatchCriteria();
        ArrayList var2 = var1.getParticipants();
        int var3 = var2.size();
        this.acc = new ArrayList(var3);

        for(int var4 = 0; var4 < var3; ++var4) {
            this.acc.add((ParticipantEntity)((Participant)var2.get(var4)).freeze());
        }

        this.acy = var1.getAutoMatchWaitEstimateSeconds();
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.Room) int
    static int method_3223(Room var0) {
        Object[] var1 = new Object[] {var0.getRoomId(), var0.getCreatorId(), Long.valueOf(var0.getCreationTimestamp()), Integer.valueOf(var0.getStatus()), var0.getDescription(), Integer.valueOf(var0.getVariant()), var0.getAutoMatchCriteria(), var0.getParticipants(), Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds())};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.Room, java.lang.String) int
    static int method_3224(Room var0, String var1) {
        ArrayList var2 = var0.getParticipants();
        int var3 = var2.size();

        for(int var4 = 0; var4 < var3; ++var4) {
            Participant var5 = (Participant)var2.get(var4);
            if(var5.getParticipantId().equals(var1)) {
                return var5.getStatus();
            }
        }

        throw new IllegalStateException("Participant " + var1 + " is not in room " + var0.getRoomId());
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.Room, java.lang.Object) boolean
    static boolean method_3225(Room var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof Room)) {
            var2 = false;
        } else if(var0 != var1) {
            Room var3 = (Room)var1;
            if(!class_1089.equal(var3.getRoomId(), var0.getRoomId()) || !class_1089.equal(var3.getCreatorId(), var0.getCreatorId()) || !class_1089.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !class_1089.equal(Integer.valueOf(var3.getStatus()), Integer.valueOf(var0.getStatus())) || !class_1089.equal(var3.getDescription(), var0.getDescription()) || !class_1089.equal(Integer.valueOf(var3.getVariant()), Integer.valueOf(var0.getVariant())) || !class_1089.equal(var3.getAutoMatchCriteria(), var0.getAutoMatchCriteria()) || !class_1089.equal(var3.getParticipants(), var0.getParticipants()) || !class_1089.equal(Integer.valueOf(var3.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds()))) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.multiplayer.realtime.Room) java.lang.String
    static String method_3226(Room var0) {
        return class_1089.method_5673(var0).method_5425("RoomId", var0.getRoomId()).method_5425("CreatorId", var0.getCreatorId()).method_5425("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).method_5425("RoomStatus", Integer.valueOf(var0.getStatus())).method_5425("Description", var0.getDescription()).method_5425("Variant", Integer.valueOf(var0.getVariant())).method_5425("AutoMatchCriteria", var0.getAutoMatchCriteria()).method_5425("Participants", var0.getParticipants()).method_5425("AutoMatchWaitEstimateSeconds", Integer.valueOf(var0.getAutoMatchWaitEstimateSeconds())).toString();
    }

    // $FF: renamed from: b (com.google.android.gms.games.multiplayer.realtime.Room, java.lang.String) java.lang.String
    static String method_3227(Room var0, String var1) {
        ArrayList var2 = var0.getParticipants();
        int var3 = var2.size();

        for(int var4 = 0; var4 < var3; ++var4) {
            Participant var5 = (Participant)var2.get(var4);
            Player var6 = var5.getPlayer();
            if(var6 != null && var6.getPlayerId().equals(var1)) {
                return var5.getParticipantId();
            }
        }

        return null;
    }

    // $FF: renamed from: c (com.google.android.gms.games.multiplayer.realtime.Room, java.lang.String) com.google.android.gms.games.multiplayer.Participant
    static Participant method_3230(Room var0, String var1) {
        ArrayList var2 = var0.getParticipants();
        int var3 = var2.size();

        for(int var4 = 0; var4 < var3; ++var4) {
            Participant var5 = (Participant)var2.get(var4);
            if(var5.getParticipantId().equals(var1)) {
                return var5;
            }
        }

        throw new IllegalStateException("Participant " + var1 + " is not in match " + var0.getRoomId());
    }

    // $FF: renamed from: c (com.google.android.gms.games.multiplayer.realtime.Room) java.util.ArrayList
    static ArrayList<String> method_3231(Room var0) {
        ArrayList var1 = var0.getParticipants();
        int var2 = var1.size();
        ArrayList var3 = new ArrayList(var2);

        for(int var4 = 0; var4 < var2; ++var4) {
            var3.add(((Participant)var1.get(var4)).getParticipantId());
        }

        return var3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_3225(this, var1);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.acs;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.acy;
    }

    public long getCreationTimestamp() {
        return this.abZ;
    }

    public String getCreatorId() {
        return this.acw;
    }

    public String getDescription() {
        return this.field_2794;
    }

    public void getDescription(CharArrayBuffer var1) {
        class_345.method_2325(this.field_2794, var1);
    }

    public Participant getParticipant(String var1) {
        return method_3230(this, var1);
    }

    public String getParticipantId(String var1) {
        return method_3227(this, var1);
    }

    public ArrayList<String> getParticipantIds() {
        return method_3231(this);
    }

    public int getParticipantStatus(String var1) {
        return method_3224(this, var1);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.acc);
    }

    public String getRoomId() {
        return this.field_2795;
    }

    public int getStatus() {
        return this.acx;
    }

    public int getVariant() {
        return this.acd;
    }

    public int getVersionCode() {
        return this.field_2793;
    }

    public int hashCode() {
        return method_3223(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return method_3226(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(!this.gQ()) {
            RoomEntityCreator.method_4074(this, var1, var2);
        } else {
            var1.writeString(this.field_2795);
            var1.writeString(this.acw);
            var1.writeLong(this.abZ);
            var1.writeInt(this.acx);
            var1.writeString(this.field_2794);
            var1.writeInt(this.acd);
            var1.writeBundle(this.acs);
            int var3 = this.acc.size();
            var1.writeInt(var3);

            for(int var4 = 0; var4 < var3; ++var4) {
                ((ParticipantEntity)this.acc.get(var4)).writeToParcel(var1, var2);
            }
        }

    }

    static final class RoomEntityCreatorCompat extends RoomEntityCreator {
        // $FF: renamed from: co (android.os.Parcel) com.google.android.gms.games.multiplayer.realtime.RoomEntity
        public RoomEntity method_4075(Parcel var1) {
            if(!RoomEntity.c(RoomEntity.gP()) && !RoomEntity.aV(RoomEntity.class.getCanonicalName())) {
                String var2 = var1.readString();
                String var3 = var1.readString();
                long var4 = var1.readLong();
                int var6 = var1.readInt();
                String var7 = var1.readString();
                int var8 = var1.readInt();
                Bundle var9 = var1.readBundle();
                int var10 = var1.readInt();
                ArrayList var11 = new ArrayList(var10);

                for(int var12 = 0; var12 < var10; ++var12) {
                    var11.add(ParticipantEntity.CREATOR.createFromParcel(var1));
                }

                return new RoomEntity(2, var2, var3, var4, var6, var7, var8, var9, var11, -1);
            } else {
                return super.method_4075(var1);
            }
        }

        // $FF: synthetic method
        public Object createFromParcel(Parcel var1) {
            return this.method_4075(var1);
        }
    }
}
