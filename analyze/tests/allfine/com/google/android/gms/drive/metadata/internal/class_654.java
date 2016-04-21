package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import com.google.android.gms.drive.metadata.internal.j;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.m
public class class_654 extends j<UserMetadata> {
    public class_654(String var1, int var2) {
        super(var1, method_3668(var1), Collections.emptyList(), var2);
    }

    // $FF: renamed from: bl (java.lang.String) java.lang.String
    private String method_3667(String var1) {
        return method_3669(this.getName(), var1);
    }

    // $FF: renamed from: bm (java.lang.String) java.util.Collection
    private static Collection<String> method_3668(String var0) {
        String[] var1 = new String[] {method_3669(var0, "permissionId"), method_3669(var0, "displayName"), method_3669(var0, "picture"), method_3669(var0, "isAuthenticatedUser"), method_3669(var0, "emailAddress")};
        return Arrays.asList(var1);
    }

    // $FF: renamed from: r (java.lang.String, java.lang.String) java.lang.String
    private static String method_3669(String var0, String var1) {
        return var0 + "." + var1;
    }

    // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) boolean
    protected boolean method_3644(DataHolder var1, int var2, int var3) {
        return !var1.method_5999(this.method_3667("permissionId"), var2, var3);
    }

    // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
    // $FF: synthetic method
    protected Object method_3645(DataHolder var1, int var2, int var3) {
        return this.method_3670(var1, var2, var3);
    }

    // $FF: renamed from: j (com.google.android.gms.common.data.DataHolder, int, int) com.google.android.gms.drive.UserMetadata
    protected UserMetadata method_3670(DataHolder var1, int var2, int var3) {
        String var4 = var1.method_5989(this.method_3667("permissionId"), var2, var3);
        if(var4 != null) {
            String var5 = var1.method_5989(this.method_3667("displayName"), var2, var3);
            String var6 = var1.method_5989(this.method_3667("picture"), var2, var3);
            Boolean var7 = Boolean.valueOf(var1.method_5990(this.method_3667("isAuthenticatedUser"), var2, var3));
            String var8 = var1.method_5989(this.method_3667("emailAddress"), var2, var3);
            return new UserMetadata(var4, var5, var6, var7.booleanValue(), var8);
        } else {
            return null;
        }
    }
}
