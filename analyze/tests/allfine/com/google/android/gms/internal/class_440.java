package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.ez;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.fw
@ez
public final class class_440 {
    // $FF: renamed from: uS int
    public final int field_1648;
    // $FF: renamed from: uT boolean
    public final boolean field_1649;
    // $FF: renamed from: uU boolean
    public final boolean field_1650;
    // $FF: renamed from: uV java.lang.String
    public final String field_1651;
    // $FF: renamed from: uW java.lang.String
    public final String field_1652;
    // $FF: renamed from: uX boolean
    public final boolean field_1653;
    // $FF: renamed from: uY boolean
    public final boolean field_1654;
    // $FF: renamed from: uZ boolean
    public final boolean field_1655;
    // $FF: renamed from: va java.lang.String
    public final String field_1656;
    // $FF: renamed from: vb java.lang.String
    public final String field_1657;
    // $FF: renamed from: vc int
    public final int field_1658;
    // $FF: renamed from: vd int
    public final int field_1659;
    // $FF: renamed from: ve int
    public final int field_1660;
    // $FF: renamed from: vf int
    public final int field_1661;
    // $FF: renamed from: vg int
    public final int field_1662;
    // $FF: renamed from: vh int
    public final int field_1663;
    // $FF: renamed from: vi float
    public final float field_1664;
    // $FF: renamed from: vj int
    public final int field_1665;
    // $FF: renamed from: vk int
    public final int field_1666;
    // $FF: renamed from: vl double
    public final double field_1667;
    // $FF: renamed from: vm boolean
    public final boolean field_1668;
    // $FF: renamed from: vn boolean
    public final boolean field_1669;
    // $FF: renamed from: vo int
    public final int field_1670;

    public class_440(Context var1) {
        boolean var2 = true;
        super();
        AudioManager var3 = (AudioManager)var1.getSystemService("audio");
        ConnectivityManager var4 = (ConnectivityManager)var1.getSystemService("connectivity");
        DisplayMetrics var5 = var1.getResources().getDisplayMetrics();
        Locale var6 = Locale.getDefault();
        PackageManager var7 = var1.getPackageManager();
        TelephonyManager var8 = (TelephonyManager)var1.getSystemService("phone");
        Intent var9 = var1.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.field_1648 = var3.getMode();
        boolean var10;
        if(method_2777(var7, "geo:0,0?q=donuts") != null) {
            var10 = var2;
        } else {
            var10 = false;
        }

        this.field_1649 = var10;
        boolean var11;
        if(method_2777(var7, "http://www.google.com") != null) {
            var11 = var2;
        } else {
            var11 = false;
        }

        this.field_1650 = var11;
        this.field_1651 = var8.getNetworkOperator();
        this.field_1652 = var6.getCountry();
        this.field_1653 = class_377.method_2454();
        this.field_1654 = var3.isMusicActive();
        this.field_1655 = var3.isSpeakerphoneOn();
        this.field_1656 = var6.getLanguage();
        this.field_1657 = method_2778(var7);
        this.field_1658 = var3.getStreamVolume(3);
        this.field_1659 = method_2776(var1, var4, var7);
        this.field_1660 = var8.getNetworkType();
        this.field_1661 = var8.getPhoneType();
        this.field_1662 = var3.getRingerMode();
        this.field_1663 = var3.getStreamVolume(2);
        this.field_1664 = var5.density;
        this.field_1665 = var5.widthPixels;
        this.field_1666 = var5.heightPixels;
        if(var9 != null) {
            int var12 = var9.getIntExtra("status", -1);
            int var13 = var9.getIntExtra("level", -1);
            int var14 = var9.getIntExtra("scale", -1);
            this.field_1667 = (double)((float)var13 / (float)var14);
            if(var12 != 2 && var12 != 5) {
                var2 = false;
            }

            this.field_1668 = var2;
        } else {
            this.field_1667 = -1.0D;
            this.field_1668 = false;
        }

        if(VERSION.SDK_INT >= 16) {
            this.field_1669 = var4.isActiveNetworkMetered();
            if(var4.getActiveNetworkInfo() != null) {
                this.field_1670 = var4.getActiveNetworkInfo().getDetailedState().ordinal();
            } else {
                this.field_1670 = -1;
            }
        } else {
            this.field_1669 = false;
            this.field_1670 = -1;
        }
    }

    // $FF: renamed from: a (android.content.Context, android.net.ConnectivityManager, android.content.pm.PackageManager) int
    private static int method_2776(Context var0, ConnectivityManager var1, PackageManager var2) {
        int var3 = -2;
        if(class_383.method_2516(var2, var0.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo var4 = var1.getActiveNetworkInfo();
            if(var4 == null) {
                return -1;
            }

            var3 = var4.getType();
        }

        return var3;
    }

    // $FF: renamed from: a (android.content.pm.PackageManager, java.lang.String) android.content.pm.ResolveInfo
    private static ResolveInfo method_2777(PackageManager var0, String var1) {
        return var0.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1)), 65536);
    }

    // $FF: renamed from: a (android.content.pm.PackageManager) java.lang.String
    private static String method_2778(PackageManager param0) {
        // $FF: Couldn't be decompiled
    }
}
