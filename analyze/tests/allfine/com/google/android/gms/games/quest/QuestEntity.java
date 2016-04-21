package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneEntity;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestEntityCreator;
import com.google.android.gms.internal.class_345;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
    public static final QuestEntityCreator CREATOR = new QuestEntityCreator();
    // $FF: renamed from: BR int
    private final int field_2113;
    // $FF: renamed from: FD int
    private final int field_2114;
    // $FF: renamed from: Tr java.lang.String
    private final String field_2115;
    // $FF: renamed from: Wk long
    private final long field_2116;
    private final GameEntity aay;
    private final String acR;
    private final long acS;
    private final Uri acT;
    private final String acU;
    private final long acV;
    private final Uri acW;
    private final String acX;
    private final long acY;
    private final long acZ;
    private final ArrayList<MilestoneEntity> ada;
    private final String mName;
    private final int mState;

    QuestEntity(int var1, GameEntity var2, String var3, long var4, Uri var6, String var7, String var8, long var9, long var11, Uri var13, String var14, String var15, long var16, long var18, int var20, int var21, ArrayList<MilestoneEntity> var22) {
        this.field_2113 = var1;
        this.aay = var2;
        this.acR = var3;
        this.acS = var4;
        this.acT = var6;
        this.acU = var7;
        this.field_2115 = var8;
        this.acV = var9;
        this.field_2116 = var11;
        this.acW = var13;
        this.acX = var14;
        this.mName = var15;
        this.acY = var16;
        this.acZ = var18;
        this.mState = var20;
        this.field_2114 = var21;
        this.ada = var22;
    }

    public QuestEntity(Quest var1) {
        this.field_2113 = 2;
        this.aay = new GameEntity(var1.getGame());
        this.acR = var1.getQuestId();
        this.acS = var1.getAcceptedTimestamp();
        this.field_2115 = var1.getDescription();
        this.acT = var1.getBannerImageUri();
        this.acU = var1.getBannerImageUrl();
        this.acV = var1.getEndTimestamp();
        this.acW = var1.getIconImageUri();
        this.acX = var1.getIconImageUrl();
        this.field_2116 = var1.getLastUpdatedTimestamp();
        this.mName = var1.getName();
        this.acY = var1.method_209();
        this.acZ = var1.getStartTimestamp();
        this.mState = var1.getState();
        this.field_2114 = var1.getType();
        List var2 = var1.method_208();
        int var3 = var2.size();
        this.ada = new ArrayList(var3);

        for(int var4 = 0; var4 < var3; ++var4) {
            this.ada.add((MilestoneEntity)((MilestoneEntity)((Milestone)var2.get(var4)).freeze()));
        }

    }

    // $FF: renamed from: a (com.google.android.gms.games.quest.Quest) int
    static int method_3032(Quest var0) {
        Object[] var1 = new Object[] {var0.getGame(), var0.getQuestId(), Long.valueOf(var0.getAcceptedTimestamp()), var0.getBannerImageUri(), var0.getDescription(), Long.valueOf(var0.getEndTimestamp()), var0.getIconImageUri(), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.method_208(), var0.getName(), Long.valueOf(var0.method_209()), Long.valueOf(var0.getStartTimestamp()), Integer.valueOf(var0.getState())};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.quest.Quest, java.lang.Object) boolean
    static boolean method_3033(Quest var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof Quest)) {
            var2 = false;
        } else if(var0 != var1) {
            Quest var3 = (Quest)var1;
            if(!class_1089.equal(var3.getGame(), var0.getGame()) || !class_1089.equal(var3.getQuestId(), var0.getQuestId()) || !class_1089.equal(Long.valueOf(var3.getAcceptedTimestamp()), Long.valueOf(var0.getAcceptedTimestamp())) || !class_1089.equal(var3.getBannerImageUri(), var0.getBannerImageUri()) || !class_1089.equal(var3.getDescription(), var0.getDescription()) || !class_1089.equal(Long.valueOf(var3.getEndTimestamp()), Long.valueOf(var0.getEndTimestamp())) || !class_1089.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_1089.equal(Long.valueOf(var3.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) || !class_1089.equal(var3.method_208(), var0.method_208()) || !class_1089.equal(var3.getName(), var0.getName()) || !class_1089.equal(Long.valueOf(var3.method_209()), Long.valueOf(var0.method_209())) || !class_1089.equal(Long.valueOf(var3.getStartTimestamp()), Long.valueOf(var0.getStartTimestamp())) || !class_1089.equal(Integer.valueOf(var3.getState()), Integer.valueOf(var0.getState()))) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.quest.Quest) java.lang.String
    static String method_3034(Quest var0) {
        return class_1089.method_5673(var0).method_5425("Game", var0.getGame()).method_5425("QuestId", var0.getQuestId()).method_5425("AcceptedTimestamp", Long.valueOf(var0.getAcceptedTimestamp())).method_5425("BannerImageUri", var0.getBannerImageUri()).method_5425("BannerImageUrl", var0.getBannerImageUrl()).method_5425("Description", var0.getDescription()).method_5425("EndTimestamp", Long.valueOf(var0.getEndTimestamp())).method_5425("IconImageUri", var0.getIconImageUri()).method_5425("IconImageUrl", var0.getIconImageUrl()).method_5425("LastUpdatedTimestamp", Long.valueOf(var0.getLastUpdatedTimestamp())).method_5425("Milestones", var0.method_208()).method_5425("Name", var0.getName()).method_5425("NotifyTimestamp", Long.valueOf(var0.method_209())).method_5425("StartTimestamp", Long.valueOf(var0.getStartTimestamp())).method_5425("State", Integer.valueOf(var0.getState())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_3033(this, var1);
    }

    public Quest freeze() {
        return this;
    }

    public long getAcceptedTimestamp() {
        return this.acS;
    }

    public Uri getBannerImageUri() {
        return this.acT;
    }

    public String getBannerImageUrl() {
        return this.acU;
    }

    public Milestone getCurrentMilestone() {
        return (Milestone)this.method_208().get(0);
    }

    public String getDescription() {
        return this.field_2115;
    }

    public void getDescription(CharArrayBuffer var1) {
        class_345.method_2325(this.field_2115, var1);
    }

    public long getEndTimestamp() {
        return this.acV;
    }

    public Game getGame() {
        return this.aay;
    }

    public Uri getIconImageUri() {
        return this.acW;
    }

    public String getIconImageUrl() {
        return this.acX;
    }

    public long getLastUpdatedTimestamp() {
        return this.field_2116;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer var1) {
        class_345.method_2325(this.mName, var1);
    }

    public String getQuestId() {
        return this.acR;
    }

    public long getStartTimestamp() {
        return this.acZ;
    }

    public int getState() {
        return this.mState;
    }

    public int getType() {
        return this.field_2114;
    }

    public int getVersionCode() {
        return this.field_2113;
    }

    public int hashCode() {
        return method_3032(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isEndingSoon() {
        return this.acY <= 1800000L + System.currentTimeMillis();
    }

    // $FF: renamed from: lJ () java.util.List
    public List<Milestone> method_208() {
        return new ArrayList(this.ada);
    }

    // $FF: renamed from: lK () long
    public long method_209() {
        return this.acY;
    }

    public String toString() {
        return method_3034(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        QuestEntityCreator.method_4413(this, var1, var2);
    }
}
