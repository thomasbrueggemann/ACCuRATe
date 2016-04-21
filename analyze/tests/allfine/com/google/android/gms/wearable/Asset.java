package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.class_1047;

public class Asset implements SafeParcelable {
    public static final Creator<Asset> CREATOR = new class_1047();
    // $FF: renamed from: BR int
    final int field_5068;
    private byte[] acH;
    private String auQ;
    public ParcelFileDescriptor auR;
    public Uri uri;

    Asset(int var1, byte[] var2, String var3, ParcelFileDescriptor var4, Uri var5) {
        this.field_5068 = var1;
        this.acH = var2;
        this.auQ = var3;
        this.auR = var4;
        this.uri = var5;
    }

    public static Asset createFromBytes(byte[] var0) {
        if(var0 == null) {
            throw new IllegalArgumentException("Asset data cannot be null");
        } else {
            return new Asset(1, var0, (String)null, (ParcelFileDescriptor)null, (Uri)null);
        }
    }

    public static Asset createFromFd(ParcelFileDescriptor var0) {
        if(var0 == null) {
            throw new IllegalArgumentException("Asset fd cannot be null");
        } else {
            return new Asset(1, (byte[])null, (String)null, var0, (Uri)null);
        }
    }

    public static Asset createFromRef(String var0) {
        if(var0 == null) {
            throw new IllegalArgumentException("Asset digest cannot be null");
        } else {
            return new Asset(1, (byte[])null, var0, (ParcelFileDescriptor)null, (Uri)null);
        }
    }

    public static Asset createFromUri(Uri var0) {
        if(var0 == null) {
            throw new IllegalArgumentException("Asset uri cannot be null");
        } else {
            return new Asset(1, (byte[])null, (String)null, (ParcelFileDescriptor)null, var0);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(!(var1 instanceof Asset)) {
                return false;
            }

            Asset var2 = (Asset)var1;
            if(!class_1089.equal(this.acH, var2.acH) || !class_1089.equal(this.auQ, var2.auQ) || !class_1089.equal(this.auR, var2.auR) || !class_1089.equal(this.uri, var2.uri)) {
                return false;
            }
        }

        return true;
    }

    public byte[] getData() {
        return this.acH;
    }

    public String getDigest() {
        return this.auQ;
    }

    public ParcelFileDescriptor getFd() {
        return this.auR;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.acH, this.auQ, this.auR, this.uri};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("Asset[@");
        var1.append(Integer.toHexString(this.hashCode()));
        if(this.auQ == null) {
            var1.append(", nodigest");
        } else {
            var1.append(", ");
            var1.append(this.auQ);
        }

        if(this.acH != null) {
            var1.append(", size=");
            var1.append(this.acH.length);
        }

        if(this.auR != null) {
            var1.append(", fd=");
            var1.append(this.auR);
        }

        if(this.uri != null) {
            var1.append(", uri=");
            var1.append(this.uri);
        }

        var1.append("]");
        return var1.toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1047.method_5482(this, var1, var2 | 1);
    }
}
