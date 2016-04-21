package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.constants.MatchResult;
import com.google.android.gms.games.multiplayer.ParticipantResultCreator;

public final class ParticipantResult implements SafeParcelable {
    public static final ParticipantResultCreator CREATOR = new ParticipantResultCreator();
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;
    // $FF: renamed from: BR int
    private final int field_5302;
    // $FF: renamed from: Xr java.lang.String
    private final String field_5303;
    private final int acj;
    private final int ack;

    public ParticipantResult(int var1, String var2, int var3, int var4) {
        this.field_5302 = var1;
        this.field_5303 = (String)class_1090.method_5685(var2);
        class_1090.method_5674(MatchResult.isValid(var3));
        this.acj = var3;
        this.ack = var4;
    }

    public ParticipantResult(String var1, int var2, int var3) {
        this(1, var1, var2, var3);
    }

    public int describeContents() {
        return 0;
    }

    public String getParticipantId() {
        return this.field_5303;
    }

    public int getPlacing() {
        return this.ack;
    }

    public int getResult() {
        return this.acj;
    }

    public int getVersionCode() {
        return this.field_5302;
    }

    public void writeToParcel(Parcel var1, int var2) {
        ParticipantResultCreator.method_2807(this, var1, var2);
    }
}
