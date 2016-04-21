package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_640;
import com.google.android.gms.tagmanager.class_74;
import com.google.android.gms.tagmanager.class_75;
import com.google.android.gms.tagmanager.class_76;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// $FF: renamed from: com.google.android.gms.tagmanager.y
class class_720 implements class_74 {
    private static class_720 apb;
    // $FF: renamed from: xz java.lang.Object
    private static final Object field_3479 = new Object();
    private class_76 aos;
    private String apc;
    private String apd;
    private class_75 ape;

    private class_720(Context var1) {
        this(class_613.method_3463(var1), new class_640());
    }

    class_720(class_75 var1, class_76 var2) {
        this.ape = var1;
        this.aos = var2;
    }

    // $FF: renamed from: X (android.content.Context) com.google.android.gms.tagmanager.aq
    public static class_74 method_3949(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: cz (java.lang.String) boolean
    public boolean method_342(String var1) {
        if(!this.aos.method_345()) {
            class_612.method_3459("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        } else {
            if(this.apc != null && this.apd != null) {
                try {
                    var1 = this.apc + "?" + this.apd + "=" + URLEncoder.encode(var1, "UTF-8");
                    class_612.method_3458("Sending wrapped url hit: " + var1);
                } catch (UnsupportedEncodingException var3) {
                    class_612.method_3461("Error wrapping URL for testing.", var3);
                    return false;
                }
            }

            this.ape.method_344(var1);
            return true;
        }
    }
}
