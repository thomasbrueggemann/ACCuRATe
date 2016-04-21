package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import com.google.android.gms.drive.metadata.internal.class_961;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Creator<AppVisibleCustomProperties> CREATOR = new class_961();
    // $FF: renamed from: PG com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
    public static final AppVisibleCustomProperties field_2949 = (new AppVisibleCustomProperties.class_1375()).method_5629();
    // $FF: renamed from: BR int
    final int field_2950;
    // $FF: renamed from: PH java.util.List
    final List<CustomProperty> field_2951;

    AppVisibleCustomProperties(int var1, Collection<CustomProperty> var2) {
        this.field_2950 = var1;
        class_1090.method_5685(var2);
        this.field_2951 = new ArrayList(var2);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> var1) {
        this(1, var1);
    }

    // $FF: synthetic method
    AppVisibleCustomProperties(Collection var1, Object var2) {
        this(var1);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator<CustomProperty> iterator() {
        return this.field_2951.iterator();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_961.method_5089(this, var1, var2);
    }

    public static class class_1375 {
        // $FF: renamed from: PI java.util.Map
        private final Map<CustomPropertyKey, CustomProperty> field_5119 = new HashMap();

        // $FF: renamed from: im () com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
        public AppVisibleCustomProperties method_5629() {
            return new AppVisibleCustomProperties(this.field_5119.values());
        }
    }
}
