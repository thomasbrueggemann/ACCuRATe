package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.ki
public class class_850 {
    // $FF: renamed from: a (java.util.List, java.util.List) boolean
    public static <T> boolean method_4488(List<T> var0, List<T> var1) {
        if(var0.size() != var1.size()) {
            return false;
        } else {
            Iterator var2 = var0.iterator();

            do {
                if(!var2.hasNext()) {
                    return true;
                }
            } while(var1.contains(var2.next()));

            return false;
        }
    }
}
