package com.google.android.gms.fitness;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.fitness.a
public final class class_1064 {
    // $FF: renamed from: bq (java.lang.String) java.lang.String
    public static String method_5562(String var0) {
        if(var0.equals("https://www.googleapis.com/auth/fitness.activity.read")) {
            var0 = "https://www.googleapis.com/auth/fitness.activity.write";
        } else {
            if(var0.equals("https://www.googleapis.com/auth/fitness.location.read")) {
                return "https://www.googleapis.com/auth/fitness.location.write";
            }

            if(var0.equals("https://www.googleapis.com/auth/fitness.body.read")) {
                return "https://www.googleapis.com/auth/fitness.body.write";
            }
        }

        return var0;
    }

    // $FF: renamed from: d (java.util.List) java.lang.String[]
    public static String[] method_5563(List<String> var0) {
        HashSet var1 = new HashSet(var0.size());
        Iterator var2 = var0.iterator();

        while(true) {
            String var3;
            String var4;
            do {
                if(!var2.hasNext()) {
                    return (String[])var1.toArray(new String[var1.size()]);
                }

                var3 = (String)var2.next();
                var4 = method_5562(var3);
            } while(!var4.equals(var3) && var0.contains(var4));

            var1.add(var3);
        }
    }
}
