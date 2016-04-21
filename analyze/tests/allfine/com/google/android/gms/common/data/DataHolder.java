package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.class_1055;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;

public final class DataHolder implements SafeParcelable {
    public static final class_1055 CREATOR = new class_1055();
    // $FF: renamed from: Kj com.google.android.gms.common.data.DataHolder$a
    private static final DataHolder.class_1502 field_5334 = new DataHolder.class_1502(new String[0], (String)null, null) {
    };
    // $FF: renamed from: BR int
    private final int field_5335;
    // $FF: renamed from: HF int
    private final int field_5336;
    // $FF: renamed from: Kb java.lang.String[]
    private final String[] field_5337;
    // $FF: renamed from: Kc android.os.Bundle
    Bundle field_5338;
    // $FF: renamed from: Kd android.database.CursorWindow[]
    private final CursorWindow[] field_5339;
    // $FF: renamed from: Ke android.os.Bundle
    private final Bundle field_5340;
    // $FF: renamed from: Kf int[]
    int[] field_5341;
    // $FF: renamed from: Kg int
    int field_5342;
    // $FF: renamed from: Kh java.lang.Object
    private Object field_5343;
    // $FF: renamed from: Ki boolean
    private boolean field_5344;
    boolean mClosed;

    DataHolder(int var1, String[] var2, CursorWindow[] var3, int var4, Bundle var5) {
        this.mClosed = false;
        this.field_5344 = true;
        this.field_5335 = var1;
        this.field_5337 = var2;
        this.field_5339 = var3;
        this.field_5336 = var4;
        this.field_5340 = var5;
    }

    private DataHolder(DataHolder.class_1502 var1, int var2, Bundle var3) {
        this(var1.field_2840, method_5981(var1, -1), var2, var3);
    }

    public DataHolder(String[] var1, CursorWindow[] var2, int var3, Bundle var4) {
        this.mClosed = false;
        this.field_5344 = true;
        this.field_5335 = 1;
        this.field_5337 = (String[])class_1090.method_5685(var1);
        this.field_5339 = (CursorWindow[])class_1090.method_5685(var2);
        this.field_5336 = var3;
        this.field_5340 = var4;
        this.method_5995();
    }

    // $FF: renamed from: a (int, android.os.Bundle) com.google.android.gms.common.data.DataHolder
    public static DataHolder method_5980(int var0, Bundle var1) {
        return new DataHolder(field_5334, var0, var1);
    }

    // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder$a, int) android.database.CursorWindow[]
    private static CursorWindow[] method_5981(DataHolder.class_1502 param0, int param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: as (int) com.google.android.gms.common.data.DataHolder
    public static DataHolder method_5982(int var0) {
        return method_5980(var0, (Bundle)null);
    }

    // $FF: renamed from: g (java.lang.String, int) void
    private void method_5983(String var1, int var2) {
        if(this.field_5338 != null && this.field_5338.containsKey(var1)) {
            if(this.isClosed()) {
                throw new IllegalArgumentException("Buffer is closed.");
            } else if(var2 < 0 || var2 >= this.field_5342) {
                throw new CursorIndexOutOfBoundsException(var2, this.field_5342);
            }
        } else {
            throw new IllegalArgumentException("No such column: " + var1);
        }
    }

    // $FF: renamed from: a (java.lang.String, int, int) long
    public long method_5984(String var1, int var2, int var3) {
        this.method_5983(var1, var2);
        return this.field_5339[var3].getLong(var2, this.field_5338.getInt(var1));
    }

    // $FF: renamed from: a (java.lang.String, int, int, android.database.CharArrayBuffer) void
    public void method_5985(String var1, int var2, int var3, CharArrayBuffer var4) {
        this.method_5983(var1, var2);
        this.field_5339[var3].copyStringToBuffer(var2, this.field_5338.getInt(var1), var4);
    }

    // $FF: renamed from: aQ (java.lang.String) boolean
    public boolean method_5986(String var1) {
        return this.field_5338.containsKey(var1);
    }

    // $FF: renamed from: ar (int) int
    public int method_5987(int var1) {
        int var2 = 0;
        boolean var3;
        if(var1 >= 0 && var1 < this.field_5342) {
            var3 = true;
        } else {
            var3 = false;
        }

        class_1090.method_5674(var3);

        while(var2 < this.field_5341.length) {
            if(var1 < this.field_5341[var2]) {
                --var2;
                break;
            }

            ++var2;
        }

        if(var2 == this.field_5341.length) {
            --var2;
        }

        return var2;
    }

    // $FF: renamed from: b (java.lang.String, int, int) int
    public int method_5988(String var1, int var2, int var3) {
        this.method_5983(var1, var2);
        return this.field_5339[var3].getInt(var2, this.field_5338.getInt(var1));
    }

    // $FF: renamed from: c (java.lang.String, int, int) java.lang.String
    public String method_5989(String var1, int var2, int var3) {
        this.method_5983(var1, var2);
        return this.field_5339[var3].getString(var2, this.field_5338.getInt(var1));
    }

    public void close() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: d (java.lang.String, int, int) boolean
    public boolean method_5990(String var1, int var2, int var3) {
        this.method_5983(var1, var2);
        return Long.valueOf(this.field_5339[var3].getLong(var2, this.field_5338.getInt(var1))).longValue() == 1L;
    }

    public int describeContents() {
        return 0;
    }

    // $FF: renamed from: e (java.lang.String, int, int) float
    public float method_5991(String var1, int var2, int var3) {
        this.method_5983(var1, var2);
        return this.field_5339[var3].getFloat(var2, this.field_5338.getInt(var1));
    }

    // $FF: renamed from: e (java.lang.Object) void
    public void method_5992(Object var1) {
        this.field_5343 = var1;
    }

    // $FF: renamed from: f (java.lang.String, int, int) byte[]
    public byte[] method_5993(String var1, int var2, int var3) {
        this.method_5983(var1, var2);
        return this.field_5339[var3].getBlob(var2, this.field_5338.getInt(var1));
    }

    protected void finalize() throws Throwable {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: g (java.lang.String, int, int) android.net.Uri
    public Uri method_5994(String var1, int var2, int var3) {
        String var4 = this.method_5989(var1, var2, var3);
        return var4 == null?null:Uri.parse(var4);
    }

    // $FF: renamed from: gA () void
    public void method_5995() {
        int var1 = 0;
        this.field_5338 = new Bundle();

        for(int var2 = 0; var2 < this.field_5337.length; ++var2) {
            this.field_5338.putInt(this.field_5337[var2], var2);
        }

        this.field_5341 = new int[this.field_5339.length];

        int var3;
        for(var3 = 0; var1 < this.field_5339.length; ++var1) {
            this.field_5341[var1] = var3;
            int var4 = var3 - this.field_5339[var1].getStartPosition();
            var3 += this.field_5339[var1].getNumRows() - var4;
        }

        this.field_5342 = var3;
    }

    // $FF: renamed from: gB () java.lang.String[]
    String[] method_5996() {
        return this.field_5337;
    }

    // $FF: renamed from: gC () android.database.CursorWindow[]
    CursorWindow[] method_5997() {
        return this.field_5339;
    }

    public int getCount() {
        return this.field_5342;
    }

    public int getStatusCode() {
        return this.field_5336;
    }

    int getVersionCode() {
        return this.field_5335;
    }

    // $FF: renamed from: gy () android.os.Bundle
    public Bundle method_5998() {
        return this.field_5340;
    }

    // $FF: renamed from: h (java.lang.String, int, int) boolean
    public boolean method_5999(String var1, int var2, int var3) {
        this.method_5983(var1, var2);
        return this.field_5339[var3].isNull(var2, this.field_5338.getInt(var1));
    }

    public boolean isClosed() {
        // $FF: Couldn't be decompiled
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1055.method_5519(this, var1, var2);
    }

    public static class class_1502 {
        // $FF: renamed from: Kb java.lang.String[]
        private final String[] field_2840;
        // $FF: renamed from: Kk java.util.ArrayList
        private final ArrayList<HashMap<String, Object>> field_2841;
        // $FF: renamed from: Kl java.lang.String
        private final String field_2842;
        // $FF: renamed from: Km java.util.HashMap
        private final HashMap<Object, Integer> field_2843;
        // $FF: renamed from: Kn boolean
        private boolean field_2844;
        // $FF: renamed from: Ko java.lang.String
        private String field_2845;

        private class_1502(String[] var1, String var2) {
            this.field_2840 = (String[])class_1090.method_5685(var1);
            this.field_2841 = new ArrayList();
            this.field_2842 = var2;
            this.field_2843 = new HashMap();
            this.field_2844 = false;
            this.field_2845 = null;
        }

        // $FF: synthetic method
        class_1502(String[] var1, String var2, Object var3) {
            this(var1, var2);
        }

        // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder$a) java.util.ArrayList
        // $FF: synthetic method
        static ArrayList method_3254(DataHolder.class_1502 var0) {
            return var0.field_2841;
        }
    }
}
