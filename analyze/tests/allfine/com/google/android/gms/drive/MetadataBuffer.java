package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.internal.class_287;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.class_647;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.class_963;
import com.google.android.gms.internal.class_855;
import java.util.Iterator;

public final class MetadataBuffer extends DataBuffer<Metadata> {
    // $FF: renamed from: Nq java.lang.String
    private final String field_1842;
    // $FF: renamed from: Nr com.google.android.gms.drive.MetadataBuffer$a
    private MetadataBuffer.class_1501 field_1843;

    public MetadataBuffer(DataHolder var1, String var2) {
        super(var1);
        this.field_1842 = var2;
        var1.method_5998().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int var1) {
        MetadataBuffer.class_1501 var2 = this.field_1843;
        if(var2 == null || var2.field_866 != var1) {
            var2 = new MetadataBuffer.class_1501(this.II, var1);
            this.field_1843 = var2;
        }

        return var2;
    }

    public String getNextPageToken() {
        return this.field_1842;
    }

    private static class class_1501 extends Metadata {
        // $FF: renamed from: II com.google.android.gms.common.data.DataHolder
        private final DataHolder field_864;
        // $FF: renamed from: JY int
        private final int field_865;
        // $FF: renamed from: Ns int
        private final int field_866;

        public class_1501(DataHolder var1, int var2) {
            this.field_864 = var1;
            this.field_866 = var2;
            this.field_865 = var1.method_5987(var2);
        }

        // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
        protected <T> T method_1783(MetadataField<T> var1) {
            return var1.method_187(this.field_864, this.field_866, this.field_865);
        }

        // $FF: synthetic method
        public Object freeze() {
            return this.method_1785();
        }

        // $FF: renamed from: hR () com.google.android.gms.drive.Metadata
        public Metadata method_1785() {
            MetadataBundle var1 = MetadataBundle.method_2099();
            Iterator var2 = class_963.method_5097().iterator();

            while(var2.hasNext()) {
                MetadataField var3 = (MetadataField)var2.next();
                if(!(var3 instanceof class_647) && var3 != class_855.field_4185) {
                    var3.method_188(this.field_864, var1, this.field_866, this.field_865);
                }
            }

            return new class_287(var1);
        }

        public boolean isDataValid() {
            return !this.field_864.isClosed();
        }
    }
}
