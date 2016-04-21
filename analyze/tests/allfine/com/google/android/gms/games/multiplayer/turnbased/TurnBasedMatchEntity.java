package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntityCreator;
import com.google.android.gms.internal.class_345;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
    public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();
    // $FF: renamed from: BR int
    private final int field_3973;
    // $FF: renamed from: Di int
    private final int field_3974;
    // $FF: renamed from: Tr java.lang.String
    private final String field_3975;
    // $FF: renamed from: Wk long
    private final long field_3976;
    // $FF: renamed from: Xh java.lang.String
    private final String field_3977;
    private final GameEntity aay;
    private final long abZ;
    private final String acE;
    private final String acF;
    private final int acG;
    private final byte[] acH;
    private final String acI;
    private final byte[] acJ;
    private final int acK;
    private final int acL;
    private final boolean acM;
    private final String acN;
    private final ArrayList<ParticipantEntity> acc;
    private final int acd;
    private final Bundle acs;
    private final String acw;

    TurnBasedMatchEntity(int var1, GameEntity var2, String var3, String var4, long var5, String var7, long var8, String var10, int var11, int var12, int var13, byte[] var14, ArrayList<ParticipantEntity> var15, String var16, byte[] var17, int var18, Bundle var19, int var20, boolean var21, String var22, String var23) {
        this.field_3973 = var1;
        this.aay = var2;
        this.field_3977 = var3;
        this.acw = var4;
        this.abZ = var5;
        this.acE = var7;
        this.field_3976 = var8;
        this.acF = var10;
        this.acG = var11;
        this.acL = var20;
        this.acd = var12;
        this.field_3974 = var13;
        this.acH = var14;
        this.acc = var15;
        this.acI = var16;
        this.acJ = var17;
        this.acK = var18;
        this.acs = var19;
        this.acM = var21;
        this.field_3975 = var22;
        this.acN = var23;
    }

    public TurnBasedMatchEntity(TurnBasedMatch var1) {
        this.field_3973 = 2;
        this.aay = new GameEntity(var1.getGame());
        this.field_3977 = var1.getMatchId();
        this.acw = var1.getCreatorId();
        this.abZ = var1.getCreationTimestamp();
        this.acE = var1.getLastUpdaterId();
        this.field_3976 = var1.getLastUpdatedTimestamp();
        this.acF = var1.getPendingParticipantId();
        this.acG = var1.getStatus();
        this.acL = var1.getTurnStatus();
        this.acd = var1.getVariant();
        this.field_3974 = var1.getVersion();
        this.acI = var1.getRematchId();
        this.acK = var1.getMatchNumber();
        this.acs = var1.getAutoMatchCriteria();
        this.acM = var1.isLocallyModified();
        this.field_3975 = var1.getDescription();
        this.acN = var1.getDescriptionParticipantId();
        byte[] var2 = var1.getData();
        if(var2 == null) {
            this.acH = null;
        } else {
            this.acH = new byte[var2.length];
            System.arraycopy(var2, 0, this.acH, 0, var2.length);
        }

        byte[] var3 = var1.getPreviousMatchData();
        if(var3 == null) {
            this.acJ = null;
        } else {
            this.acJ = new byte[var3.length];
            System.arraycopy(var3, 0, this.acJ, 0, var3.length);
        }

        ArrayList var4 = var1.getParticipants();
        int var5 = var4.size();
        this.acc = new ArrayList(var5);

        for(int var6 = 0; var6 < var5; ++var6) {
            this.acc.add((ParticipantEntity)((ParticipantEntity)((Participant)var4.get(var6)).freeze()));
        }

    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch) int
    static int method_4378(TurnBasedMatch var0) {
        Object[] var1 = new Object[] {var0.getGame(), var0.getMatchId(), var0.getCreatorId(), Long.valueOf(var0.getCreationTimestamp()), var0.getLastUpdaterId(), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.getPendingParticipantId(), Integer.valueOf(var0.getStatus()), Integer.valueOf(var0.getTurnStatus()), var0.getDescription(), Integer.valueOf(var0.getVariant()), Integer.valueOf(var0.getVersion()), var0.getParticipants(), var0.getRematchId(), Integer.valueOf(var0.getMatchNumber()), var0.getAutoMatchCriteria(), Integer.valueOf(var0.getAvailableAutoMatchSlots()), Boolean.valueOf(var0.isLocallyModified())};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch, java.lang.String) int
    static int method_4379(TurnBasedMatch var0, String var1) {
        ArrayList var2 = var0.getParticipants();
        int var3 = var2.size();

        for(int var4 = 0; var4 < var3; ++var4) {
            Participant var5 = (Participant)var2.get(var4);
            if(var5.getParticipantId().equals(var1)) {
                return var5.getStatus();
            }
        }

        throw new IllegalStateException("Participant " + var1 + " is not in match " + var0.getMatchId());
    }

    // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch, java.lang.Object) boolean
    static boolean method_4380(TurnBasedMatch var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof TurnBasedMatch)) {
            var2 = false;
        } else if(var0 != var1) {
            TurnBasedMatch var3 = (TurnBasedMatch)var1;
            if(!class_1089.equal(var3.getGame(), var0.getGame()) || !class_1089.equal(var3.getMatchId(), var0.getMatchId()) || !class_1089.equal(var3.getCreatorId(), var0.getCreatorId()) || !class_1089.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !class_1089.equal(var3.getLastUpdaterId(), var0.getLastUpdaterId()) || !class_1089.equal(Long.valueOf(var3.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) || !class_1089.equal(var3.getPendingParticipantId(), var0.getPendingParticipantId()) || !class_1089.equal(Integer.valueOf(var3.getStatus()), Integer.valueOf(var0.getStatus())) || !class_1089.equal(Integer.valueOf(var3.getTurnStatus()), Integer.valueOf(var0.getTurnStatus())) || !class_1089.equal(var3.getDescription(), var0.getDescription()) || !class_1089.equal(Integer.valueOf(var3.getVariant()), Integer.valueOf(var0.getVariant())) || !class_1089.equal(Integer.valueOf(var3.getVersion()), Integer.valueOf(var0.getVersion())) || !class_1089.equal(var3.getParticipants(), var0.getParticipants()) || !class_1089.equal(var3.getRematchId(), var0.getRematchId()) || !class_1089.equal(Integer.valueOf(var3.getMatchNumber()), Integer.valueOf(var0.getMatchNumber())) || !class_1089.equal(var3.getAutoMatchCriteria(), var0.getAutoMatchCriteria()) || !class_1089.equal(Integer.valueOf(var3.getAvailableAutoMatchSlots()), Integer.valueOf(var0.getAvailableAutoMatchSlots())) || !class_1089.equal(Boolean.valueOf(var3.isLocallyModified()), Boolean.valueOf(var0.isLocallyModified()))) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch) java.lang.String
    static String method_4381(TurnBasedMatch var0) {
        return class_1089.method_5673(var0).method_5425("Game", var0.getGame()).method_5425("MatchId", var0.getMatchId()).method_5425("CreatorId", var0.getCreatorId()).method_5425("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).method_5425("LastUpdaterId", var0.getLastUpdaterId()).method_5425("LastUpdatedTimestamp", Long.valueOf(var0.getLastUpdatedTimestamp())).method_5425("PendingParticipantId", var0.getPendingParticipantId()).method_5425("MatchStatus", Integer.valueOf(var0.getStatus())).method_5425("TurnStatus", Integer.valueOf(var0.getTurnStatus())).method_5425("Description", var0.getDescription()).method_5425("Variant", Integer.valueOf(var0.getVariant())).method_5425("Data", var0.getData()).method_5425("Version", Integer.valueOf(var0.getVersion())).method_5425("Participants", var0.getParticipants()).method_5425("RematchId", var0.getRematchId()).method_5425("PreviousData", var0.getPreviousMatchData()).method_5425("MatchNumber", Integer.valueOf(var0.getMatchNumber())).method_5425("AutoMatchCriteria", var0.getAutoMatchCriteria()).method_5425("AvailableAutoMatchSlots", Integer.valueOf(var0.getAvailableAutoMatchSlots())).method_5425("LocallyModified", Boolean.valueOf(var0.isLocallyModified())).method_5425("DescriptionParticipantId", var0.getDescriptionParticipantId()).toString();
    }

    // $FF: renamed from: b (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch, java.lang.String) java.lang.String
    static String method_4382(TurnBasedMatch var0, String var1) {
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

    // $FF: renamed from: c (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch, java.lang.String) com.google.android.gms.games.multiplayer.Participant
    static Participant method_4383(TurnBasedMatch var0, String var1) {
        ArrayList var2 = var0.getParticipants();
        int var3 = var2.size();

        for(int var4 = 0; var4 < var3; ++var4) {
            Participant var5 = (Participant)var2.get(var4);
            if(var5.getParticipantId().equals(var1)) {
                return var5;
            }
        }

        throw new IllegalStateException("Participant " + var1 + " is not in match " + var0.getMatchId());
    }

    // $FF: renamed from: c (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch) java.util.ArrayList
    static ArrayList<String> method_4384(TurnBasedMatch var0) {
        ArrayList var1 = var0.getParticipants();
        int var2 = var1.size();
        ArrayList var3 = new ArrayList(var2);

        for(int var4 = 0; var4 < var2; ++var4) {
            var3.add(((Participant)var1.get(var4)).getParticipantId());
        }

        return var3;
    }

    public boolean canRematch() {
        return this.acG == 2 && this.acI == null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_4380(this, var1);
    }

    public TurnBasedMatch freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.acs;
    }

    public int getAvailableAutoMatchSlots() {
        return this.acs == null?0:this.acs.getInt("max_automatch_players");
    }

    public long getCreationTimestamp() {
        return this.abZ;
    }

    public String getCreatorId() {
        return this.acw;
    }

    public byte[] getData() {
        return this.acH;
    }

    public String getDescription() {
        return this.field_3975;
    }

    public void getDescription(CharArrayBuffer var1) {
        class_345.method_2325(this.field_3975, var1);
    }

    public Participant getDescriptionParticipant() {
        String var1 = this.getDescriptionParticipantId();
        return var1 == null?null:this.getParticipant(var1);
    }

    public String getDescriptionParticipantId() {
        return this.acN;
    }

    public Game getGame() {
        return this.aay;
    }

    public long getLastUpdatedTimestamp() {
        return this.field_3976;
    }

    public String getLastUpdaterId() {
        return this.acE;
    }

    public String getMatchId() {
        return this.field_3977;
    }

    public int getMatchNumber() {
        return this.acK;
    }

    public Participant getParticipant(String var1) {
        return method_4383(this, var1);
    }

    public String getParticipantId(String var1) {
        return method_4382(this, var1);
    }

    public ArrayList<String> getParticipantIds() {
        return method_4384(this);
    }

    public int getParticipantStatus(String var1) {
        return method_4379(this, var1);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.acc);
    }

    public String getPendingParticipantId() {
        return this.acF;
    }

    public byte[] getPreviousMatchData() {
        return this.acJ;
    }

    public String getRematchId() {
        return this.acI;
    }

    public int getStatus() {
        return this.acG;
    }

    public int getTurnStatus() {
        return this.acL;
    }

    public int getVariant() {
        return this.acd;
    }

    public int getVersion() {
        return this.field_3974;
    }

    public int getVersionCode() {
        return this.field_3973;
    }

    public int hashCode() {
        return method_4378(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isLocallyModified() {
        return this.acM;
    }

    public String toString() {
        return method_4381(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        TurnBasedMatchEntityCreator.method_4368(this, var1, var2);
    }
}
