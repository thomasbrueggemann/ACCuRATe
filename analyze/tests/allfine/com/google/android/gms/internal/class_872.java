package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_874;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.ni
public class class_872 implements SafeParcelable {
    public static final class_874 CREATOR = new class_874();
    public final long akH;
    public final byte[] akI;
    public final Bundle akJ;
    public final String tag;
    public final int versionCode;

    class_872(int var1, long var2, String var4, byte[] var5, Bundle var6) {
        this.versionCode = var1;
        this.akH = var2;
        this.tag = var4;
        this.akI = var5;
        this.akJ = var6;
    }

    public class_872(long var1, String var3, byte[] var4, String... var5) {
        this.versionCode = 1;
        this.akH = var1;
        this.tag = var3;
        this.akI = var4;
        this.akJ = method_4533(var5);
    }

    // $FF: renamed from: f (java.lang.String[]) android.os.Bundle
    private static Bundle method_4533(String... var0) {
        Bundle var1 = null;
        if(var0 != null) {
            if(var0.length % 2 != 0) {
                throw new IllegalArgumentException("extras must have an even number of elements");
            }

            int var2 = var0.length / 2;
            var1 = null;
            if(var2 != 0) {
                var1 = new Bundle(var2);

                for(int var3 = 0; var3 < var2; ++var3) {
                    var1.putString(var0[var3 * 2], var0[1 + var3 * 2]);
                }
            }
        }

        return var1;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("tag=").append(this.tag).append(",");
        var1.append("eventTime=").append(this.akH).append(",");
        if(this.akJ != null && !this.akJ.isEmpty()) {
            var1.append("keyValues=");
            Iterator var5 = this.akJ.keySet().iterator();

            while(var5.hasNext()) {
                String var6 = (String)var5.next();
                var1.append("(").append(var6).append(",");
                var1.append(this.akJ.getString(var6)).append(")");
                var1.append(" ");
            }
        }

        return var1.toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_874.method_4538(this, var1, var2);
    }
}
