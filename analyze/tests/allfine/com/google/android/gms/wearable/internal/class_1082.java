package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.class_1083;

// $FF: renamed from: com.google.android.gms.wearable.internal.ah
public class class_1082 implements SafeParcelable, MessageEvent {
    public static final Creator<ah> CREATOR = new class_1083();
    // $FF: renamed from: BR int
    final int field_5106;
    private final byte[] acH;
    private final String avH;
    private final String avI;
    // $FF: renamed from: uQ int
    private final int field_5107;

    class_1082(int var1, int var2, String var3, byte[] var4, String var5) {
        this.field_5106 = var1;
        this.field_5107 = var2;
        this.avH = var3;
        this.acH = var4;
        this.avI = var5;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.acH;
    }

    public String getPath() {
        return this.avH;
    }

    public int getRequestId() {
        return this.field_5107;
    }

    public String getSourceNodeId() {
        return this.avI;
    }

    public String toString() {
        StringBuilder var1 = (new StringBuilder()).append("MessageEventParcelable[").append(this.field_5107).append(",").append(this.avH).append(", size=");
        Object var2;
        if(this.acH == null) {
            var2 = "null";
        } else {
            var2 = Integer.valueOf(this.acH.length);
        }

        return var1.append(var2).append("]").toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1083.method_5611(this, var1, var2);
    }
}
