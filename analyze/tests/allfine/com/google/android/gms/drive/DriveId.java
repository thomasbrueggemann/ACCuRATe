package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_727;
import com.google.android.gms.drive.internal.class_266;
import com.google.android.gms.drive.internal.class_309;
import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_899;

public class DriveId implements SafeParcelable {
    public static final Creator<DriveId> CREATOR = new class_727();
    // $FF: renamed from: BR int
    final int field_2223;
    // $FF: renamed from: Ni java.lang.String
    final String field_2224;
    // $FF: renamed from: Nj long
    final long field_2225;
    // $FF: renamed from: Nk long
    final long field_2226;
    // $FF: renamed from: Nl java.lang.String
    private volatile String field_2227;

    DriveId(int var1, String var2, long var3, long var5) {
        this.field_2227 = null;
        this.field_2223 = var1;
        this.field_2224 = var2;
        boolean var7;
        if(!"".equals(var2)) {
            var7 = true;
        } else {
            var7 = false;
        }

        boolean var8;
        label15: {
            class_1090.method_5675(var7);
            if(var2 == null) {
                long var10;
                int var9 = (var10 = var3 - -1L) == 0L?0:(var10 < 0L?-1:1);
                var8 = false;
                if(var9 == 0) {
                    break label15;
                }
            }

            var8 = true;
        }

        class_1090.method_5675(var8);
        this.field_2225 = var3;
        this.field_2226 = var5;
    }

    public DriveId(String var1, long var2, long var4) {
        this(1, var1, var2, var4);
    }

    // $FF: renamed from: bg (java.lang.String) com.google.android.gms.drive.DriveId
    public static DriveId method_3177(String var0) {
        class_1090.method_5685(var0);
        return new DriveId(var0, -1L, -1L);
    }

    public static DriveId decodeFromString(String var0) {
        class_1090.method_5683(var0.startsWith("DriveId:"), "Invalid DriveId: " + var0);
        return method_3178(Base64.decode(var0.substring("DriveId:".length()), 10));
    }

    // $FF: renamed from: f (byte[]) com.google.android.gms.drive.DriveId
    static DriveId method_3178(byte[] var0) {
        class_309 var2;
        try {
            var2 = class_309.method_2121(var0);
        } catch (class_899 var4) {
            throw new IllegalArgumentException();
        }

        String var3;
        if("".equals(var2.field_949)) {
            var3 = null;
        } else {
            var3 = var2.field_949;
        }

        return new DriveId(var2.versionCode, var3, var2.field_950, var2.field_951);
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if(this.field_2227 == null) {
            String var1 = Base64.encodeToString(this.method_3179(), 10);
            this.field_2227 = "DriveId:" + var1;
        }

        return this.field_2227;
    }

    public boolean equals(Object var1) {
        if(var1 instanceof DriveId) {
            DriveId var2 = (DriveId)var1;
            if(var2.field_2226 != this.field_2226) {
                class_266.method_1686("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
                return false;
            }

            if(var2.field_2225 == -1L && this.field_2225 == -1L) {
                return var2.field_2224.equals(this.field_2224);
            }

            if(var2.field_2225 == this.field_2225) {
                return true;
            }
        }

        return false;
    }

    public String getResourceId() {
        return this.field_2224;
    }

    // $FF: renamed from: hN () byte[]
    final byte[] method_3179() {
        class_309 var1 = new class_309();
        var1.versionCode = this.field_2223;
        String var2;
        if(this.field_2224 == null) {
            var2 = "";
        } else {
            var2 = this.field_2224;
        }

        var1.field_949 = var2;
        var1.field_950 = this.field_2225;
        var1.field_951 = this.field_2226;
        return class_307.method_2111(var1);
    }

    public int hashCode() {
        return this.field_2225 == -1L?this.field_2224.hashCode():(this.field_2226 + String.valueOf(this.field_2225)).hashCode();
    }

    public String toString() {
        return this.encodeToString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_727.method_3954(this, var1, var2);
    }
}
