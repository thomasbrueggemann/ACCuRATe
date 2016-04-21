package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.class_820;

public class ParcelableCollaborator implements SafeParcelable {
    public static final Creator<ParcelableCollaborator> CREATOR = new class_820();
    // $FF: renamed from: BR int
    final int field_4013;
    // $FF: renamed from: NH java.lang.String
    final String field_4014;
    // $FF: renamed from: Rk boolean
    final boolean field_4015;
    // $FF: renamed from: Rl boolean
    final boolean field_4016;
    // $FF: renamed from: Rm java.lang.String
    final String field_4017;
    // $FF: renamed from: Rn java.lang.String
    final String field_4018;
    // $FF: renamed from: Ro java.lang.String
    final String field_4019;
    // $FF: renamed from: vL java.lang.String
    final String field_4020;

    ParcelableCollaborator(int var1, boolean var2, boolean var3, String var4, String var5, String var6, String var7, String var8) {
        this.field_4013 = var1;
        this.field_4015 = var2;
        this.field_4016 = var3;
        this.field_4020 = var4;
        this.field_4017 = var5;
        this.field_4014 = var6;
        this.field_4018 = var7;
        this.field_4019 = var8;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(this == var1) {
            return true;
        } else if(!(var1 instanceof ParcelableCollaborator)) {
            return false;
        } else {
            ParcelableCollaborator var2 = (ParcelableCollaborator)var1;
            return this.field_4020.equals(var2.field_4020);
        }
    }

    public int hashCode() {
        return this.field_4020.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.field_4015 + ", isAnonymous=" + this.field_4016 + ", sessionId=" + this.field_4020 + ", userId=" + this.field_4017 + ", displayName=" + this.field_4014 + ", color=" + this.field_4018 + ", photoUrl=" + this.field_4019 + "]";
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_820.method_4255(this, var1, var2);
    }
}
