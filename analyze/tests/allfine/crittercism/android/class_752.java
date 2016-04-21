package crittercism.android;

import crittercism.android.class_100;
import crittercism.android.class_106;
import crittercism.android.class_724;
import crittercism.android.class_726;
import crittercism.android.class_764;
import crittercism.android.class_803;
import crittercism.android.class_99;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.cs
public final class class_752 implements class_100 {
    // $FF: renamed from: a java.util.Map
    private Map field_3571 = new HashMap();

    // $FF: renamed from: a () org.json.JSONArray
    private JSONArray method_3998() {
        JSONArray var1 = new JSONArray();
        Iterator var2 = this.field_3571.entrySet().iterator();

        while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            JSONObject var4 = new JSONObject((Map)var3.getKey());
            class_752.class_1261 var5 = (class_752.class_1261)var3.getValue();

            try {
                var1.put((new JSONObject()).put("appLoads", var4).put("count", var5.field_5023).put("current", var5.field_5022));
            } catch (JSONException var7) {
                ;
            }
        }

        return var1;
    }

    // $FF: renamed from: a (crittercism.android.bs) crittercism.android.cw
    // $FF: synthetic method
    public final class_100 method_396(class_803 var1) {
        Iterator var2 = var1.method_4171().iterator();

        HashMap var3;
        HashMap var7;
        for(var3 = null; var2.hasNext(); var3 = var7) {
            class_724 var4 = (class_724)var2.next();
            HashMap var6;
            if(!(var4 instanceof class_726)) {
                var6 = null;
            } else {
                JSONObject var5 = (JSONObject)var4.method_3953();
                if(var5 == null) {
                    var6 = null;
                } else {
                    HashMap var10 = new HashMap(var5.length());
                    Iterator var11 = var5.keys();

                    while(var11.hasNext()) {
                        String var12 = (String)var11.next();
                        var10.put(var12, var5.opt(var12));
                    }

                    var6 = var10;
                }
            }

            if(var6 != null) {
                class_752.class_1261 var8 = (class_752.class_1261)this.field_3571.get(var6);
                if(var8 == null) {
                    var8 = new class_752.class_1261();
                    this.field_3571.put(var6, var8);
                }

                ++var8.field_5023;
                var7 = var6;
            } else {
                var7 = var3;
            }
        }

        if(var3 != null) {
            ((class_752.class_1261)this.field_3571.get(var3)).field_5022 = true;
        }

        return this;
    }

    // $FF: renamed from: a (java.io.OutputStream) void
    public final void method_397(OutputStream var1) {
        var1.write(this.method_3998().toString().getBytes("UTF8"));
    }

    public final String toString() {
        try {
            String var2 = this.method_3998().toString(4);
            return var2;
        } catch (JSONException var3) {
            class_764.method_4015();
            return null;
        }
    }

    static final class class_1261 {
        // $FF: renamed from: a boolean
        boolean field_5022;
        // $FF: renamed from: b int
        int field_5023;

        public class_1261() {
            this((byte)0);
        }

        private class_1261(byte var1) {
            this.field_5022 = false;
            this.field_5023 = 0;
            this.field_5022 = false;
            this.field_5023 = 0;
        }
    }

    public static final class class_1262 implements class_99 {
        // $FF: renamed from: a (crittercism.android.au) crittercism.android.cw
        // $FF: synthetic method
        public final class_100 method_395(class_106 var1) {
            return new class_752();
        }
    }
}
