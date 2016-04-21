package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
    private static final String[] abs = new String[] {"requestId", "outcome"};
    // $FF: renamed from: HF int
    private final int field_2189;
    private final HashMap<String, Integer> abt;

    private RequestUpdateOutcomes(int var1, HashMap<String, Integer> var2) {
        this.field_2189 = var1;
        this.abt = var2;
    }

    // $FF: synthetic method
    RequestUpdateOutcomes(int var1, HashMap var2, Object var3) {
        this(var1, var2);
    }

    // $FF: renamed from: V (com.google.android.gms.common.data.DataHolder) com.google.android.gms.games.internal.request.RequestUpdateOutcomes
    public static RequestUpdateOutcomes method_3102(DataHolder var0) {
        RequestUpdateOutcomes.Builder var1 = new RequestUpdateOutcomes.Builder();
        var1.method_4203(var0.getStatusCode());
        int var3 = var0.getCount();

        for(int var4 = 0; var4 < var3; ++var4) {
            int var5 = var0.method_5987(var4);
            var1.method_4205(var0.method_5989("requestId", var4, var5), var0.method_5988("outcome", var4, var5));
        }

        return var1.method_4204();
    }

    public Set<String> getRequestIds() {
        return this.abt.keySet();
    }

    public int getRequestOutcome(String var1) {
        class_1090.method_5683(this.abt.containsKey(var1), "Request " + var1 + " was not part of the update operation!");
        return ((Integer)this.abt.get(var1)).intValue();
    }

    public static final class Builder {
        // $FF: renamed from: HF int
        private int field_3886 = 0;
        private HashMap<String, Integer> abt = new HashMap();

        // $FF: renamed from: dR (int) com.google.android.gms.games.internal.request.RequestUpdateOutcomes$Builder
        public RequestUpdateOutcomes.Builder method_4203(int var1) {
            this.field_3886 = var1;
            return this;
        }

        // $FF: renamed from: ly () com.google.android.gms.games.internal.request.RequestUpdateOutcomes
        public RequestUpdateOutcomes method_4204() {
            return new RequestUpdateOutcomes(this.field_3886, this.abt);
        }

        // $FF: renamed from: x (java.lang.String, int) com.google.android.gms.games.internal.request.RequestUpdateOutcomes$Builder
        public RequestUpdateOutcomes.Builder method_4205(String var1, int var2) {
            if(RequestUpdateResultOutcome.isValid(var2)) {
                this.abt.put(var1, Integer.valueOf(var2));
            }

            return this;
        }
    }
}
