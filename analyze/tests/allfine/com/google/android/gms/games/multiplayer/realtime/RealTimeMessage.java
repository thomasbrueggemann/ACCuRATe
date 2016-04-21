package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR = new Creator() {
        // $FF: renamed from: cn (android.os.Parcel) com.google.android.gms.games.multiplayer.realtime.RealTimeMessage
        public RealTimeMessage method_4995(Parcel var1) {
            return new RealTimeMessage(var1, null);
        }

        // $FF: synthetic method
        public Object createFromParcel(Parcel var1) {
            return this.method_4995(var1);
        }

        // $FF: renamed from: dU (int) com.google.android.gms.games.multiplayer.realtime.RealTimeMessage[]
        public RealTimeMessage[] method_4996(int var1) {
            return new RealTimeMessage[var1];
        }

        // $FF: synthetic method
        public Object[] newArray(int var1) {
            return this.method_4996(var1);
        }
    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE;
    private final String acl;
    private final byte[] acm;
    private final int acn;

    private RealTimeMessage(Parcel var1) {
        this(var1.readString(), var1.createByteArray(), var1.readInt());
    }

    // $FF: synthetic method
    RealTimeMessage(Parcel var1, Object var2) {
        this(var1);
    }

    public RealTimeMessage(String var1, byte[] var2, int var3) {
        this.acl = (String)class_1090.method_5685(var1);
        this.acm = (byte[])((byte[])class_1090.method_5685(var2)).clone();
        this.acn = var3;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.acm;
    }

    public String getSenderParticipantId() {
        return this.acl;
    }

    public boolean isReliable() {
        return this.acn == 1;
    }

    public void writeToParcel(Parcel var1, int var2) {
        var1.writeString(this.acl);
        var1.writeByteArray(this.acm);
        var1.writeInt(this.acn);
    }
}
