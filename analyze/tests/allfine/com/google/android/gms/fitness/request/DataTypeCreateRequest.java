package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.class_509;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest implements SafeParcelable {
    public static final Creator<DataTypeCreateRequest> CREATOR = new class_509();
    // $FF: renamed from: BR int
    private final int field_3293;
    // $FF: renamed from: SY java.util.List
    private final List<Field> field_3294;
    private final String mName;

    DataTypeCreateRequest(int var1, String var2, List<Field> var3) {
        this.field_3293 = var1;
        this.mName = var2;
        this.field_3294 = Collections.unmodifiableList(var3);
    }

    private DataTypeCreateRequest(DataTypeCreateRequest.Builder var1) {
        this.field_3293 = 1;
        this.mName = var1.mName;
        this.field_3294 = Collections.unmodifiableList(var1.field_5262);
    }

    // $FF: synthetic method
    DataTypeCreateRequest(DataTypeCreateRequest.Builder var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.request.DataTypeCreateRequest) boolean
    private boolean method_3757(DataTypeCreateRequest var1) {
        return class_1089.equal(this.mName, var1.mName) && class_1089.equal(this.field_3294, var1.field_3294);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return var1 == this || var1 instanceof DataTypeCreateRequest && this.method_3757((DataTypeCreateRequest)var1);
    }

    public List<Field> getFields() {
        return this.field_3294;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.field_3293;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.mName, this.field_3294};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("name", this.mName).method_5425("fields", this.field_3294).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_509.method_3117(this, var1, var2);
    }

    public static class Builder {
        // $FF: renamed from: SY java.util.List
        private List<Field> field_5262 = new ArrayList();
        private String mName;

        public DataTypeCreateRequest.Builder addField(Field var1) {
            if(!this.field_5262.contains(var1)) {
                this.field_5262.add(var1);
            }

            return this;
        }

        public DataTypeCreateRequest.Builder addField(String var1, int var2) {
            boolean var3;
            if(var1 == null && var1.isEmpty()) {
                var3 = false;
            } else {
                var3 = true;
            }

            class_1090.method_5683(var3, "Invalid name specified");
            return this.addField(new Field(var1, var2));
        }

        public DataTypeCreateRequest build() {
            boolean var1 = true;
            boolean var2;
            if(this.mName != null) {
                var2 = var1;
            } else {
                var2 = false;
            }

            class_1090.method_5676(var2, "Must set the name");
            if(this.field_5262.isEmpty()) {
                var1 = false;
            }

            class_1090.method_5676(var1, "Must specify the data fields");
            return new DataTypeCreateRequest(this);
        }

        public DataTypeCreateRequest.Builder setName(String var1) {
            this.mName = var1;
            return this;
        }
    }
}
