package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.internal.class_543;

// $FF: renamed from: com.google.android.gms.internal.k
public class class_548 {
    // $FF: renamed from: kR java.lang.String
    private String field_2915 = "googleads.g.doubleclick.net";
    // $FF: renamed from: kS java.lang.String
    private String field_2916 = "/pagead/ads";
    // $FF: renamed from: kT java.lang.String
    private String field_2917 = "ad.doubleclick.net";
    // $FF: renamed from: kU java.lang.String[]
    private String[] field_2918 = new String[] {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    // $FF: renamed from: kV com.google.android.gms.internal.g
    private class_52 field_2919;

    public class_548(class_52 var1) {
        this.field_2919 = var1;
    }

    // $FF: renamed from: a (android.net.Uri, android.content.Context, java.lang.String, boolean) android.net.Uri
    private Uri method_3350(Uri param1, Context param2, String param3, boolean param4) throws class_543 {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (android.net.Uri, java.lang.String, java.lang.String) android.net.Uri
    private Uri method_3351(Uri var1, String var2, String var3) throws UnsupportedOperationException {
        String var4 = var1.toString();
        int var5 = var4.indexOf("&adurl");
        if(var5 == -1) {
            var5 = var4.indexOf("?adurl");
        }

        return var5 != -1?Uri.parse(var4.substring(0, var5 + 1) + var2 + "=" + var3 + "&" + var4.substring(var5 + 1)):var1.buildUpon().appendQueryParameter(var2, var3).build();
    }

    // $FF: renamed from: b (android.net.Uri, java.lang.String, java.lang.String) android.net.Uri
    private Uri method_3352(Uri var1, String var2, String var3) {
        String var4 = var1.toString();
        int var5 = var4.indexOf(";adurl");
        if(var5 != -1) {
            return Uri.parse(var4.substring(0, var5 + 1) + var2 + "=" + var3 + ";" + var4.substring(var5 + 1));
        } else {
            String var6 = var1.getEncodedPath();
            int var7 = var4.indexOf(var6);
            return Uri.parse(var4.substring(0, var7 + var6.length()) + ";" + var2 + "=" + var3 + ";" + var4.substring(var7 + var6.length()));
        }
    }

    // $FF: renamed from: a (android.net.Uri, android.content.Context) android.net.Uri
    public Uri method_3353(Uri var1, Context var2) throws class_543 {
        try {
            Uri var4 = this.method_3350(var1, var2, var1.getQueryParameter("ai"), true);
            return var4;
        } catch (UnsupportedOperationException var5) {
            throw new class_543("Provided Uri is not in a valid state");
        }
    }

    // $FF: renamed from: a (android.view.MotionEvent) void
    public void method_3354(MotionEvent var1) {
        this.field_2919.method_230(var1);
    }

    // $FF: renamed from: a (android.net.Uri) boolean
    public boolean method_3355(Uri var1) {
        if(var1 == null) {
            throw new NullPointerException();
        } else {
            try {
                boolean var3 = var1.getHost().equals(this.field_2917);
                return var3;
            } catch (NullPointerException var4) {
                return false;
            }
        }
    }

    // $FF: renamed from: b (android.net.Uri) boolean
    public boolean method_3356(Uri param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: z () com.google.android.gms.internal.g
    public class_52 method_3357() {
        return this.field_2919;
    }
}
