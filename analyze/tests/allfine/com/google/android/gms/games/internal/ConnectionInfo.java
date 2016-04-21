package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.ConnectionInfoCreator;

public class ConnectionInfo implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
    // $FF: renamed from: BR int
    private final int field_2835;
    // $FF: renamed from: Wq java.lang.String
    private final String field_2836;
    // $FF: renamed from: Wr int
    private final int field_2837;

    public ConnectionInfo(int var1, String var2, int var3) {
        this.field_2835 = var1;
        this.field_2836 = var2;
        this.field_2837 = var3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_2835;
    }

    // $FF: renamed from: jX () java.lang.String
    public String method_3245() {
        return this.field_2836;
    }

    // $FF: renamed from: jY () int
    public int method_3246() {
        return this.field_2837;
    }

    public void writeToParcel(Parcel var1, int var2) {
        ConnectionInfoCreator.method_5839(this, var1, var2);
    }
}
