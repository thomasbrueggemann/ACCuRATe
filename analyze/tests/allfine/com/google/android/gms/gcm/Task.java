package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class Task implements Parcelable {
    private final String adB = null;
    private final boolean adC = false;
    private final boolean adD = false;
    private final String mTag = null;

    public int describeContents() {
        return 0;
    }

    public String getServiceName() {
        return this.adB;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isPersisted() {
        return this.adD;
    }

    public boolean isUpdateCurrent() {
        return this.adC;
    }

    public void writeToParcel(Parcel var1, int var2) {
        byte var3 = 1;
        var1.writeString(this.adB);
        var1.writeString(this.mTag);
        byte var4;
        if(this.adC) {
            var4 = var3;
        } else {
            var4 = 0;
        }

        var1.writeInt(var4);
        if(!this.adD) {
            var3 = 0;
        }

        var1.writeInt(var3);
    }
}
