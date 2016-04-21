package com.google.android.gms.internal;

import com.google.android.gms.internal.class_226;
import com.google.android.gms.internal.class_378;
import java.util.PriorityQueue;

// $FF: renamed from: com.google.android.gms.internal.as
public class class_224 {
    // $FF: renamed from: a (int, int, long, long, long) long
    static long method_1526(int var0, int var1, long var2, long var4, long var6) {
        long var8 = var4 * ((2147483647L + (long)var0) % 1073807359L) % 1073807359L;
        return (var6 * ((var2 + 1073807359L - var8) % 1073807359L) % 1073807359L + (2147483647L + (long)var1) % 1073807359L) % 1073807359L;
    }

    // $FF: renamed from: a (long, int) long
    static long method_1527(long var0, int var2) {
        if(var2 == 0) {
            var0 = 1L;
        } else if(var2 != 1) {
            if(var2 % 2 == 0) {
                return method_1527(var0 * var0 % 1073807359L, var2 / 2) % 1073807359L;
            }

            return var0 * (method_1527(var0 * var0 % 1073807359L, var2 / 2) % 1073807359L) % 1073807359L;
        }

        return var0;
    }

    // $FF: renamed from: a (java.lang.String[], int, int) java.lang.String
    static String method_1528(String[] var0, int var1, int var2) {
        if(var0.length < var1 + var2) {
            class_378.method_2458("Unable to construct shingle");
            return "";
        } else {
            StringBuffer var3 = new StringBuffer();

            for(int var4 = var1; var4 < -1 + var1 + var2; ++var4) {
                var3.append(var0[var4]);
                var3.append(' ');
            }

            var3.append(var0[-1 + var1 + var2]);
            return var3.toString();
        }
    }

    // $FF: renamed from: a (int, long, int, java.lang.String[], int, java.util.PriorityQueue) void
    private static void method_1529(int var0, long var1, int var3, String[] var4, int var5, PriorityQueue<class_224.class_1195> var6) {
        var6.add(new class_224.class_1195(var1, method_1528(var4, var3, var5)));
        if(var6.size() > var0) {
            var6.poll();
        }

    }

    // $FF: renamed from: a (java.lang.String[], int, int, java.util.PriorityQueue) void
    public static void method_1530(String[] var0, int var1, int var2, PriorityQueue<class_224.class_1195> var3) {
        long var4 = method_1531(var0, 0, var2);
        method_1529(var1, var4, 0, var0, var2, var3);
        long var6 = method_1527(16785407L, var2 - 1);
        int var8 = 1;

        long var11;
        for(long var9 = var4; var8 < 1 + (var0.length - var2); var9 = var11) {
            var11 = method_1526(class_226.method_1535(var0[var8 - 1]), class_226.method_1535(var0[-1 + var8 + var2]), var9, var6, 16785407L);
            method_1529(var1, var11, var8, var0, var2, var3);
            ++var8;
        }

    }

    // $FF: renamed from: b (java.lang.String[], int, int) long
    private static long method_1531(String[] var0, int var1, int var2) {
        long var3 = (2147483647L + (long)class_226.method_1535(var0[var1])) % 1073807359L;

        for(int var5 = var1 + 1; var5 < var1 + var2; ++var5) {
            var3 = (var3 * 16785407L % 1073807359L + (2147483647L + (long)class_226.method_1535(var0[var5])) % 1073807359L) % 1073807359L;
        }

        return var3;
    }

    public static class class_1195 {
        // $FF: renamed from: nQ java.lang.String
        final String field_1211;
        final long value;

        class_1195(long var1, String var3) {
            this.value = var1;
            this.field_1211 = var3;
        }
    }
}
