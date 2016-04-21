package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneEntityCreator;

public final class MilestoneEntity implements SafeParcelable, Milestone {
    public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
    // $FF: renamed from: BR int
    private final int field_4321;
    // $FF: renamed from: Wm java.lang.String
    private final String field_4322;
    // $FF: renamed from: Xu java.lang.String
    private final String field_4323;
    private final long acO;
    private final long acP;
    private final byte[] acQ;
    private final int mState;

    MilestoneEntity(int var1, String var2, long var3, long var5, byte[] var7, int var8, String var9) {
        this.field_4321 = var1;
        this.field_4323 = var2;
        this.acO = var3;
        this.acP = var5;
        this.acQ = var7;
        this.mState = var8;
        this.field_4322 = var9;
    }

    public MilestoneEntity(Milestone var1) {
        this.field_4321 = 4;
        this.field_4323 = var1.getMilestoneId();
        this.acO = var1.getCurrentProgress();
        this.acP = var1.getTargetProgress();
        this.mState = var1.getState();
        this.field_4322 = var1.getEventId();
        byte[] var2 = var1.getCompletionRewardData();
        if(var2 == null) {
            this.acQ = null;
        } else {
            this.acQ = new byte[var2.length];
            System.arraycopy(var2, 0, this.acQ, 0, var2.length);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.games.quest.Milestone) int
    static int method_4903(Milestone var0) {
        Object[] var1 = new Object[] {var0.getMilestoneId(), Long.valueOf(var0.getCurrentProgress()), Long.valueOf(var0.getTargetProgress()), Integer.valueOf(var0.getState()), var0.getEventId()};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.games.quest.Milestone, java.lang.Object) boolean
    static boolean method_4904(Milestone var0, Object var1) {
        boolean var2 = true;
        if(!(var1 instanceof Milestone)) {
            var2 = false;
        } else if(var0 != var1) {
            Milestone var3 = (Milestone)var1;
            if(!class_1089.equal(var3.getMilestoneId(), var0.getMilestoneId()) || !class_1089.equal(Long.valueOf(var3.getCurrentProgress()), Long.valueOf(var0.getCurrentProgress())) || !class_1089.equal(Long.valueOf(var3.getTargetProgress()), Long.valueOf(var0.getTargetProgress())) || !class_1089.equal(Integer.valueOf(var3.getState()), Integer.valueOf(var0.getState())) || !class_1089.equal(var3.getEventId(), var0.getEventId())) {
                return false;
            }
        }

        return var2;
    }

    // $FF: renamed from: b (com.google.android.gms.games.quest.Milestone) java.lang.String
    static String method_4905(Milestone var0) {
        return class_1089.method_5673(var0).method_5425("MilestoneId", var0.getMilestoneId()).method_5425("CurrentProgress", Long.valueOf(var0.getCurrentProgress())).method_5425("TargetProgress", Long.valueOf(var0.getTargetProgress())).method_5425("State", Integer.valueOf(var0.getState())).method_5425("CompletionRewardData", var0.getCompletionRewardData()).method_5425("EventId", var0.getEventId()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return method_4904(this, var1);
    }

    public Milestone freeze() {
        return this;
    }

    public byte[] getCompletionRewardData() {
        return this.acQ;
    }

    public long getCurrentProgress() {
        return this.acO;
    }

    public String getEventId() {
        return this.field_4322;
    }

    public String getMilestoneId() {
        return this.field_4323;
    }

    public int getState() {
        return this.mState;
    }

    public long getTargetProgress() {
        return this.acP;
    }

    public int getVersionCode() {
        return this.field_4321;
    }

    public int hashCode() {
        return method_4903(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return method_4905(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        MilestoneEntityCreator.method_4377(this, var1, var2);
    }
}
