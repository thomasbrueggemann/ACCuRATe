package crittercism.android;

import android.content.Context;
import crittercism.android.class_731;
import crittercism.android.class_764;
import crittercism.android.class_804;
import crittercism.android.class_96;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

// $FF: renamed from: crittercism.android.bs
public final class class_803 {
    // $FF: renamed from: a java.io.File
    public final File field_3798;
    // $FF: renamed from: b java.lang.String
    public String field_3799;
    // $FF: renamed from: c java.util.List
    public List field_3800;
    // $FF: renamed from: d crittercism.android.cj
    private class_731 field_3801;
    // $FF: renamed from: e int
    private int field_3802;
    // $FF: renamed from: f int
    private int field_3803;
    // $FF: renamed from: g int
    private int field_3804;
    // $FF: renamed from: h crittercism.android.bs$a
    private class_803.class_1425 field_3805;
    // $FF: renamed from: i boolean
    private boolean field_3806;

    public class_803(Context var1, class_804 var2) {
        String var3 = var2.method_4172();
        this(new File(var1.getFilesDir().getAbsolutePath() + "//com.crittercism//" + var3), var2.method_4174(), var2.method_4175(), var2.method_4176(), var2.method_4173(), var2.method_4177());
    }

    private class_803(File var1, class_803.class_1425 var2, class_731 var3, int var4, int var5, String var6) {
        this.field_3806 = false;
        this.field_3805 = var2;
        this.field_3801 = var3;
        this.field_3804 = var4;
        this.field_3803 = var5;
        this.field_3799 = var6;
        this.field_3798 = var1;
        var1.mkdirs();
        this.method_4158();
        this.field_3802 = this.method_4162().length;
        this.field_3800 = new LinkedList();
    }

    // $FF: renamed from: c (crittercism.android.ch) boolean
    private boolean method_4157(class_96 var1) {
        File var2 = new File(this.field_3798, var1.method_392());

        BufferedOutputStream var4;
        label74: {
            BufferedOutputStream var3;
            try {
                var3 = new BufferedOutputStream(new FileOutputStream(var2));
            } catch (FileNotFoundException var24) {
                (new StringBuilder("Could not open output stream to : ")).append(var2);
                class_764.method_4015();
                var4 = null;
                break label74;
            }

            var4 = var3;
        }

        try {
            var1.method_391(var4);
            return true;
        } catch (IOException var22) {
            var2.delete();
            class_764.method_4018("Unable to write to " + var2.getAbsolutePath(), var22);
        } finally {
            try {
                var4.close();
            } catch (IOException var21) {
                var2.delete();
                class_764.method_4018("Unable to close " + var2.getAbsolutePath(), var21);
                return false;
            }
        }

        return false;
    }

    // $FF: renamed from: d () boolean
    private boolean method_4158() {
        if(!this.field_3798.isDirectory()) {
            this.field_3806 = true;
            String var1 = this.field_3798.getAbsolutePath();
            if(this.field_3798.exists()) {
                new IOException(var1 + " is not a directory");
            } else {
                new FileNotFoundException(var1 + " does not exist");
            }
        }

        return !this.field_3806;
    }

    // $FF: renamed from: e () void
    private void method_4159() {
        while(this.method_4169() > this.method_4163() && this.method_4160()) {
            ;
        }

    }

    // $FF: renamed from: f () boolean
    private boolean method_4160() {
        class_803.class_1425 var10000 = this.field_3805;
        if(this.field_3805 != null) {
            class_803.class_1425 var2 = this.field_3805;
            File[] var3 = this.method_4161();
            int var4 = var3.length;
            int var5 = var2.field_3889;
            File var6 = null;
            if(var4 > var5) {
                var6 = var3[var2.field_3889];
            }

            if(var6 != null && var6.delete()) {
                return true;
            }
        }

        return false;
    }

    // $FF: renamed from: g () java.io.File[]
    private File[] method_4161() {
        File[] var1 = this.method_4162();
        Arrays.sort(var1);
        return var1;
    }

    // $FF: renamed from: h () java.io.File[]
    private File[] method_4162() {
        File[] var1 = this.field_3798.listFiles();
        if(var1 == null) {
            var1 = new File[0];
        }

        return var1;
    }

    // $FF: renamed from: i () int
    private int method_4163() {
        synchronized(this) {}

        int var2;
        try {
            var2 = this.field_3803;
        } finally {
            ;
        }

        return var2;
    }

    // $FF: renamed from: a (android.content.Context) crittercism.android.bs
    public final class_803 method_4164(Context var1) {
        String var2 = this.field_3798.getName();
        String var3 = var2 + "_" + UUID.randomUUID().toString();
        return new class_803(new File(var1.getFilesDir().getAbsolutePath() + "//com.crittercism/pending/" + var3), this.field_3805, this.field_3801, this.field_3804, this.field_3803, this.field_3799);
    }

    // $FF: renamed from: a () void
    public final void method_4165() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (crittercism.android.bs) void
    public final void method_4166(class_803 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.lang.String) void
    public final void method_4167(String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (crittercism.android.ch) boolean
    public final boolean method_4168(class_96 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b () int
    public final int method_4169() {
        synchronized(this) {}

        int var2;
        try {
            var2 = this.method_4162().length;
        } finally {
            ;
        }

        return var2;
    }

    // $FF: renamed from: b (crittercism.android.ch) boolean
    public final boolean method_4170(class_96 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: c () java.util.List
    public final List method_4171() {
        // $FF: Couldn't be decompiled
    }

    public static final class class_1425 {
        // $FF: renamed from: a int
        int field_3889;

        public class_1425(int var1) {
            this.field_3889 = var1;
        }
    }
}
