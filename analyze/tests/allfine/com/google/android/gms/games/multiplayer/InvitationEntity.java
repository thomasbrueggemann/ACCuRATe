package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntityCreator;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Creator<InvitationEntity> CREATOR = new InvitationEntity.InvitationEntityCreatorCompat();
    // $FF: renamed from: BR int
    private final int field_2780;
    // $FF: renamed from: WO java.lang.String
    private final String field_2781;
    private final GameEntity aay;
    private final long abZ;
    private final int aca;
    private final ParticipantEntity acb;
    private final ArrayList<ParticipantEntity> acc;
    private final int acd;
    private final int ace;

    InvitationEntity(int var1, GameEntity var2, String var3, long var4, int var6, ParticipantEntity var7, ArrayList<ParticipantEntity> var8, int var9, int var10) {
        this.field_2780 = var1;
        this.aay = var2;
        this.field_2781 = var3;
        this.abZ = var4;
        this.aca = var6;
        this.acb = var7;
        this.acc = var8;
        this.acd = var9;
        this.ace = var10;
    }

    InvitationEntity(Invitation var1) {
        this.field_2780 = 2;
        this.aay = new GameEntity(var1.getGame());
        this.field_2781 = var1.getInvitationId();
        this.abZ = var1.getCreationTimestamp();
        this.aca = var1.getInvitationType();
        this.acd = var1.getVariant();
        this.ace = var1.getAvailableAutoMatchSlots();
        String var2 = var1.getInviter().getParticipantId();
        Participant var3 = null;
        ArrayList var4 = var1.getParticipants();
        int var5 = var4.size();
        this.acc = new ArrayList(var5);

        for(int var6 = 0; var6 < var5; ++var6) {
            Participant var8 = (Participant)var4.get(var6);
            if(var8.getParticipantId().equals(var2)) {
                var3 = var8;
            }

            this.acc.add((ParticipantEntity)var8.freeze());
        }

        class_1090.method_5681(var3, "Must have a valid inviter!");
        this.acb = (ParticipantEntity)var3.freeze();
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.Invitation) int
    static int method_3211(Invitation var0) {
        Object[] var1 = new Object[] {var0.getGame(), var0.getInvitationId(), Long.valueOf(var0.getCreationTimestamp()), Integer.valueOf(var0.getInvitationType()), var0.getInviter(), var0.getParticipants(), Integer.valueOf(var0.getVariant()), Integer.valueOf(var0.getAvailableAutoMatchSlots())};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.Invitation, java.lang.Object) boolean
    static boolean method_3212(Invitation var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof Invitation)) {
            var2 = false;
        } else if(var0 != var1) {
            Invitation var3 = (Invitation)var1;
            if(!class_1089.equal(var3.getGame(), var0.getGame()) || !class_1089.equal(var3.getInvitationId(), var0.getInvitationId()) || !class_1089.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !class_1089.equal(Integer.valueOf(var3.getInvitationType()), Integer.valueOf(var0.getInvitationType())) || !class_1089.equal(var3.getInviter(), var0.getInviter()) || !class_1089.equal(var3.getParticipants(), var0.getParticipants()) || !class_1089.equal(Integer.valueOf(var3.getVariant()), Integer.valueOf(var0.getVariant())) || !class_1089.equal(Integer.valueOf(var3.getAvailableAutoMatchSlots()), Integer.valueOf(var0.getAvailableAutoMatchSlots()))) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.multiplayer.Invitation) java.lang.String
    static String method_3213(Invitation var0) {
        return class_1089.method_5673(var0).method_5425("Game", var0.getGame()).method_5425("InvitationId", var0.getInvitationId()).method_5425("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).method_5425("InvitationType", Integer.valueOf(var0.getInvitationType())).method_5425("Inviter", var0.getInviter()).method_5425("Participants", var0.getParticipants()).method_5425("Variant", Integer.valueOf(var0.getVariant())).method_5425("AvailableAutoMatchSlots", Integer.valueOf(var0.getAvailableAutoMatchSlots())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_3212(this, var1);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        return this.ace;
    }

    public long getCreationTimestamp() {
        return this.abZ;
    }

    public Game getGame() {
        return this.aay;
    }

    public String getInvitationId() {
        return this.field_2781;
    }

    public int getInvitationType() {
        return this.aca;
    }

    public Participant getInviter() {
        return this.acb;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.acc);
    }

    public int getVariant() {
        return this.acd;
    }

    public int getVersionCode() {
        return this.field_2780;
    }

    public int hashCode() {
        return method_3211(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return method_3213(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        if(!this.gQ()) {
            InvitationEntityCreator.method_4759(this, var1, var2);
        } else {
            this.aay.writeToParcel(var1, var2);
            var1.writeString(this.field_2781);
            var1.writeLong(this.abZ);
            var1.writeInt(this.aca);
            this.acb.writeToParcel(var1, var2);
            int var3 = this.acc.size();
            var1.writeInt(var3);

            for(int var4 = 0; var4 < var3; ++var4) {
                ((ParticipantEntity)this.acc.get(var4)).writeToParcel(var1, var2);
            }
        }

    }

    static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
        // $FF: renamed from: cl (android.os.Parcel) com.google.android.gms.games.multiplayer.InvitationEntity
        public InvitationEntity method_4760(Parcel var1) {
            if(!InvitationEntity.c(InvitationEntity.gP()) && !InvitationEntity.aV(InvitationEntity.class.getCanonicalName())) {
                GameEntity var2 = (GameEntity)GameEntity.CREATOR.createFromParcel(var1);
                String var3 = var1.readString();
                long var4 = var1.readLong();
                int var6 = var1.readInt();
                ParticipantEntity var7 = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(var1);
                int var8 = var1.readInt();
                ArrayList var9 = new ArrayList(var8);

                for(int var10 = 0; var10 < var8; ++var10) {
                    var9.add(ParticipantEntity.CREATOR.createFromParcel(var1));
                }

                return new InvitationEntity(2, var2, var3, var4, var6, var7, var9, -1, 0);
            } else {
                return super.method_4760(var1);
            }
        }

        // $FF: synthetic method
        public Object createFromParcel(Parcel var1) {
            return this.method_4760(var1);
        }
    }
}
