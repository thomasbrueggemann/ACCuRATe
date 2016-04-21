package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_167;
import com.google.android.gms.internal.class_307;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.class_209;
import com.google.android.gms.tagmanager.class_608;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_618;
import com.google.android.gms.tagmanager.class_638;
import com.google.android.gms.tagmanager.class_68;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

// $FF: renamed from: com.google.android.gms.tagmanager.cq
class class_637 implements class_209.class_1400 {
    private final String aoc;
    private final ExecutorService aqA;
    private bg<class_167.class_1513> aqt;
    private final Context mContext;

    class_637(Context var1, String var2) {
        this.mContext = var1;
        this.aoc = var2;
        this.aqA = Executors.newSingleThreadExecutor();
    }

    // $FF: renamed from: a (java.io.ByteArrayOutputStream) com.google.android.gms.tagmanager.cr$c
    private class_638.class_1807 method_3582(ByteArrayOutputStream var1) {
        try {
            class_638.class_1807 var4 = class_608.method_3448(var1.toString("UTF-8"));
            return var4;
        } catch (UnsupportedEncodingException var5) {
            class_612.method_3455("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        } catch (JSONException var6) {
            class_612.method_3459("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn\'t contain a JSON container");
            return null;
        }
    }

    // $FF: renamed from: d (com.google.android.gms.internal.ol$a) void
    private void method_3583(class_167.class_1513 var1) throws IllegalArgumentException {
        if(var1.field_952 == null && var1.ass == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    // $FF: renamed from: k (byte[]) com.google.android.gms.tagmanager.cr$c
    private class_638.class_1807 method_3584(byte[] param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.bg) void
    public void method_220(bg<class_167.class_1513> var1) {
        this.aqt = var1;
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ol$a) void
    public void method_221(final class_167.class_1513 var1) {
        this.aqA.execute(new Runnable() {
            public void run() {
                class_637.this.method_3585(var1);
            }
        });
    }

    // $FF: renamed from: c (com.google.android.gms.internal.ol$a) boolean
    boolean method_3585(class_167.class_1513 var1) {
        File var2 = this.method_3587();

        FileOutputStream var3;
        try {
            var3 = new FileOutputStream(var2);
        } catch (FileNotFoundException var18) {
            class_612.method_3456("Error opening resource file for writing");
            return false;
        }

        try {
            var3.write(class_307.method_2111(var1));
            return true;
        } catch (IOException var19) {
            class_612.method_3459("Error writing resource to disk. Removing resource from disk.");
            var2.delete();
        } finally {
            try {
                var3.close();
            } catch (IOException var17) {
                class_612.method_3459("error closing stream for writing resource to disk");
            }

        }

        return false;
    }

    // $FF: renamed from: ff (int) com.google.android.gms.tagmanager.cr$c
    public class_638.class_1807 method_222(int param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: oR () void
    void method_3586() {
        if(this.aqt == null) {
            throw new IllegalStateException("Callback must be set before execute");
        } else {
            this.aqt.method_328();
            class_612.method_3458("Attempting to load resource from disk");
            if((class_618.method_3490().method_3492() == class_618.class_1772.aqi || class_618.method_3490().method_3492() == class_618.class_1772.aqj) && this.aoc.equals(class_618.method_3490().getContainerId())) {
                this.aqt.method_326(class_68.class_1174.apM);
            } else {
                FileInputStream var1;
                try {
                    var1 = new FileInputStream(this.method_3587());
                } catch (FileNotFoundException var24) {
                    class_612.method_3455("Failed to find the resource in the disk");
                    this.aqt.method_326(class_68.class_1174.apM);
                    return;
                }

                try {
                    ByteArrayOutputStream var2 = new ByteArrayOutputStream();
                    class_638.method_3593(var1, var2);
                    class_167.class_1513 var9 = class_167.class_1513.method_2124(var2.toByteArray());
                    this.method_3583(var9);
                    this.aqt.method_327(var9);
                } catch (IOException var21) {
                    this.aqt.method_326(class_68.class_1174.apN);
                    class_612.method_3459("Failed to read the resource from disk");
                } catch (IllegalArgumentException var22) {
                    this.aqt.method_326(class_68.class_1174.apN);
                    class_612.method_3459("Failed to read the resource from disk. The resource is inconsistent");
                } finally {
                    try {
                        var1.close();
                    } catch (IOException var20) {
                        class_612.method_3459("Error closing stream for reading resource from disk");
                    }

                }

                class_612.method_3458("The Disk resource was successfully read.");
            }
        }
    }

    // $FF: renamed from: oS () java.io.File
    File method_3587() {
        String var1 = "resource_" + this.aoc;
        return new File(this.mContext.getDir("google_tagmanager", 0), var1);
    }

    // $FF: renamed from: oc () void
    public void method_223() {
        this.aqA.execute(new Runnable() {
            public void run() {
                class_637.this.method_3586();
            }
        });
    }

    public void release() {
        synchronized(this) {}

        try {
            this.aqA.shutdown();
        } finally {
            ;
        }

    }
}
