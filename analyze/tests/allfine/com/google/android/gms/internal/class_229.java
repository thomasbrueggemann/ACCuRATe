package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.internal.class_224;
import com.google.android.gms.internal.class_226;
import com.google.android.gms.internal.class_227;
import com.google.android.gms.internal.class_228;
import com.google.android.gms.internal.class_378;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

// $FF: renamed from: com.google.android.gms.internal.ap
public class class_229 {
    // $FF: renamed from: nJ int
    private final int field_565;
    // $FF: renamed from: nK int
    private final int field_566;
    // $FF: renamed from: nL com.google.android.gms.internal.ao
    private final class_227 field_567 = new class_228();
    // $FF: renamed from: nM android.util.Base64OutputStream
    private Base64OutputStream field_568;
    // $FF: renamed from: nN java.io.ByteArrayOutputStream
    private ByteArrayOutputStream field_569;

    public class_229(int var1) {
        this.field_566 = var1;
        this.field_565 = 6;
    }

    // $FF: renamed from: m (java.lang.String) java.lang.String
    private String method_1541(String var1) {
        String[] var2 = var1.split("\n");
        if(var2 != null && var2.length != 0) {
            this.field_569 = new ByteArrayOutputStream();
            this.field_568 = new Base64OutputStream(this.field_569, 10);
            Arrays.sort(var2, new Comparator() {
                public int compare(String var1, String var2) {
                    return var2.length() - var1.length();
                }
            });

            for(int var3 = 0; var3 < var2.length && var3 < this.field_566; ++var3) {
                if(var2[var3].trim().length() != 0) {
                    try {
                        this.field_568.write(this.field_567.method_1538(var2[var3]));
                    } catch (IOException var8) {
                        class_378.method_2463("Error while writing hash to byteStream", var8);
                    }
                }
            }

            try {
                this.field_568.flush();
                this.field_568.close();
                String var5 = this.field_569.toString();
                return var5;
            } catch (IOException var7) {
                class_378.method_2463("HashManager: Unable to convert to base 64", var7);
                return "";
            }
        } else {
            return "";
        }
    }

    // $FF: renamed from: a (java.util.ArrayList) java.lang.String
    public String method_1542(ArrayList<String> var1) {
        StringBuffer var2 = new StringBuffer();
        Iterator var3 = var1.iterator();

        while(var3.hasNext()) {
            var2.append(((String)var3.next()).toLowerCase());
            var2.append('\n');
        }

        switch(0) {
            case 0:
                return this.method_1543(var2.toString());
            case 1:
                return this.method_1541(var2.toString());
            default:
                return "";
        }
    }

    // $FF: renamed from: n (java.lang.String) java.lang.String
    String method_1543(String var1) {
        String[] var2 = var1.split("\n");
        if(var2 != null && var2.length != 0) {
            this.field_569 = new ByteArrayOutputStream();
            this.field_568 = new Base64OutputStream(this.field_569, 10);
            PriorityQueue var3 = new PriorityQueue(this.field_566, new Comparator() {
                // $FF: renamed from: a (com.google.android.gms.internal.as$a, com.google.android.gms.internal.as$a) int
                public int method_4407(class_224.class_1195 var1, class_224.class_1195 var2) {
                    return (int)(var1.value - var2.value);
                }

                // $FF: synthetic method
                public int compare(Object var1, Object var2) {
                    return this.method_4407((class_224.class_1195)var1, (class_224.class_1195)var2);
                }
            });

            for(int var4 = 0; var4 < var2.length; ++var4) {
                String[] var10 = class_226.method_1536(var2[var4]);
                if(var10.length >= this.field_565) {
                    class_224.method_1530(var10, this.field_566, this.field_565, var3);
                }
            }

            Iterator var5 = var3.iterator();

            while(var5.hasNext()) {
                class_224.class_1195 var8 = (class_224.class_1195)var5.next();

                try {
                    this.field_568.write(this.field_567.method_1538(var8.field_1211));
                } catch (IOException var12) {
                    class_378.method_2463("Error while writing hash to byteStream", var12);
                }
            }

            try {
                this.field_568.flush();
                this.field_568.close();
                String var7 = this.field_569.toString();
                return var7;
            } catch (IOException var11) {
                class_378.method_2463("HashManager: unable to convert to base 64", var11);
                return "";
            }
        } else {
            return "";
        }
    }
}
