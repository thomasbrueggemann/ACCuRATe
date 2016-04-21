package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// $FF: renamed from: com.google.android.gms.common.internal.safeparcel.c
public final class class_822 {
    // $FF: renamed from: a (android.content.Intent, java.lang.String, android.os.Parcelable.Creator) com.google.android.gms.common.internal.safeparcel.SafeParcelable
    public static <T extends SafeParcelable> T method_4294(Intent var0, String var1, Creator<T> var2) {
        byte[] var3 = var0.getByteArrayExtra(var1);
        return var3 == null?null:method_4295(var3, var2);
    }

    // $FF: renamed from: a (byte[], android.os.Parcelable.Creator) com.google.android.gms.common.internal.safeparcel.SafeParcelable
    public static <T extends SafeParcelable> T method_4295(byte[] var0, Creator<T> var1) {
        class_1090.method_5685(var1);
        Parcel var3 = Parcel.obtain();
        var3.unmarshall(var0, 0, var0.length);
        var3.setDataPosition(0);
        SafeParcelable var4 = (SafeParcelable)var1.createFromParcel(var3);
        var3.recycle();
        return var4;
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.safeparcel.SafeParcelable, android.content.Intent, java.lang.String) void
    public static <T extends SafeParcelable> void method_4296(T var0, Intent var1, String var2) {
        var1.putExtra(var2, method_4297(var0));
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.safeparcel.SafeParcelable) byte[]
    public static <T extends SafeParcelable> byte[] method_4297(T var0) {
        Parcel var1 = Parcel.obtain();
        var0.writeToParcel(var1, 0);
        byte[] var2 = var1.marshall();
        var1.recycle();
        return var2;
    }
}
