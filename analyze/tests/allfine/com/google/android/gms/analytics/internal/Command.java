package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command implements Parcelable {
    public static final String APPEND_CACHE_BUSTER = "appendCacheBuster";
    public static final String APPEND_QUEUE_TIME = "appendQueueTime";
    public static final String APPEND_VERSION = "appendVersion";
    public static final Creator<Command> CREATOR = new Creator() {
        public Command createFromParcel(Parcel var1) {
            return new Command(var1);
        }

        public Command[] newArray(int var1) {
            return new Command[var1];
        }
    };
    // $FF: renamed from: id java.lang.String
    private String field_4376;
    private String urlParam;
    private String value;

    public Command() {
    }

    Command(Parcel var1) {
        this.readFromParcel(var1);
    }

    public Command(String var1, String var2, String var3) {
        this.field_4376 = var1;
        this.urlParam = var2;
        this.value = var3;
    }

    private void readFromParcel(Parcel var1) {
        this.field_4376 = var1.readString();
        this.urlParam = var1.readString();
        this.value = var1.readString();
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.field_4376;
    }

    public String getUrlParam() {
        return this.urlParam;
    }

    public String getValue() {
        return this.value;
    }

    public void writeToParcel(Parcel var1, int var2) {
        var1.writeString(this.field_4376);
        var1.writeString(this.urlParam);
        var1.writeString(this.value);
    }
}
