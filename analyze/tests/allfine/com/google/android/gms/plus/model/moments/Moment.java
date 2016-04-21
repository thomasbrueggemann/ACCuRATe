package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.class_271;
import com.google.android.gms.internal.class_273;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable<Moment> {
    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();

    public static class Builder {
        // $FF: renamed from: BL java.lang.String
        private String field_4597;
        private String amP;
        private class_271 amX;
        private class_271 amY;
        private final Set<Integer> amc = new HashSet();
        // $FF: renamed from: uO java.lang.String
        private String field_4598;

        public Moment build() {
            return new class_273(this.amc, this.field_4597, this.amX, this.amP, this.amY, this.field_4598);
        }

        public Moment.Builder setId(String var1) {
            this.field_4597 = var1;
            this.amc.add(Integer.valueOf(2));
            return this;
        }

        public Moment.Builder setResult(ItemScope var1) {
            this.amX = (class_271)var1;
            this.amc.add(Integer.valueOf(4));
            return this;
        }

        public Moment.Builder setStartDate(String var1) {
            this.amP = var1;
            this.amc.add(Integer.valueOf(5));
            return this;
        }

        public Moment.Builder setTarget(ItemScope var1) {
            this.amY = (class_271)var1;
            this.amc.add(Integer.valueOf(6));
            return this;
        }

        public Moment.Builder setType(String var1) {
            this.field_4598 = var1;
            this.amc.add(Integer.valueOf(7));
            return this;
        }
    }
}
