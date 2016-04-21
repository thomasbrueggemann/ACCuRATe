package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.class_1063;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_334;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Creator<ApplicationMetadata> CREATOR = new class_1063();
    // $FF: renamed from: BR int
    private final int field_4434;
    // $FF: renamed from: EA java.util.List
    List<WebImage> field_4435;
    // $FF: renamed from: EB java.util.List
    List<String> field_4436;
    // $FF: renamed from: EC java.lang.String
    String field_4437;
    // $FF: renamed from: ED android.net.Uri
    Uri field_4438;
    // $FF: renamed from: Ez java.lang.String
    String field_4439;
    String mName;

    private ApplicationMetadata() {
        this.field_4434 = 1;
        this.field_4435 = new ArrayList();
        this.field_4436 = new ArrayList();
    }

    ApplicationMetadata(int var1, String var2, String var3, List<WebImage> var4, List<String> var5, String var6, Uri var7) {
        this.field_4434 = var1;
        this.field_4439 = var2;
        this.mName = var3;
        this.field_4435 = var4;
        this.field_4436 = var5;
        this.field_4437 = var6;
        this.field_4438 = var7;
    }

    public boolean areNamespacesSupported(List<String> var1) {
        return this.field_4436 != null && this.field_4436.containsAll(var1);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 != this) {
            if(!(var1 instanceof ApplicationMetadata)) {
                return false;
            }

            ApplicationMetadata var2 = (ApplicationMetadata)var1;
            if(!class_334.method_2300(this.field_4439, var2.field_4439) || !class_334.method_2300(this.field_4435, var2.field_4435) || !class_334.method_2300(this.mName, var2.mName) || !class_334.method_2300(this.field_4436, var2.field_4436) || !class_334.method_2300(this.field_4437, var2.field_4437) || !class_334.method_2300(this.field_4438, var2.field_4438)) {
                return false;
            }
        }

        return true;
    }

    // $FF: renamed from: fu () android.net.Uri
    public Uri method_4988() {
        return this.field_4438;
    }

    public String getApplicationId() {
        return this.field_4439;
    }

    public List<WebImage> getImages() {
        return this.field_4435;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.field_4437;
    }

    int getVersionCode() {
        return this.field_4434;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.field_4434), this.field_4439, this.mName, this.field_4435, this.field_4436, this.field_4437, this.field_4438};
        return class_1089.hashCode(var1);
    }

    public boolean isNamespaceSupported(String var1) {
        return this.field_4436 != null && this.field_4436.contains(var1);
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1063.method_5559(this, var1, var2);
    }
}
