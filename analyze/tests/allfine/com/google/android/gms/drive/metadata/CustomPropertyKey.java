package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.class_1086;
import java.util.regex.Pattern;

public class CustomPropertyKey implements SafeParcelable {
    public static final Creator<CustomPropertyKey> CREATOR = new class_1086();
    // $FF: renamed from: PF java.util.regex.Pattern
    private static final Pattern field_1833 = Pattern.compile("[\\w.!@$%^&*()/-]+");
    // $FF: renamed from: BR int
    final int field_1834;
    // $FF: renamed from: JO java.lang.String
    final String field_1835;
    final int mVisibility;

    CustomPropertyKey(int var1, String var2, int var3) {
        byte var4 = 1;
        super();
        class_1090.method_5681(var2, "key");
        class_1090.method_5683(field_1833.matcher(var2).matches(), "key name characters must be alphanumeric or one of .!@$%^&*()-_/");
        if(var3 != 0 && var3 != var4) {
            var4 = 0;
        }

        class_1090.method_5683((boolean)var4, "visibility must be either PUBLIC or PRIVATE");
        this.field_1834 = var1;
        this.field_1835 = var2;
        this.mVisibility = var3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        boolean var2 = true;
        if(var1 != null) {
            if(var1 == this) {
                return var2;
            }

            if(var1 instanceof CustomPropertyKey) {
                CustomPropertyKey var3 = (CustomPropertyKey)var1;
                if(!var3.getKey().equals(this.field_1835) || var3.getVisibility() != this.mVisibility) {
                    var2 = false;
                }

                return var2;
            }
        }

        return false;
    }

    public String getKey() {
        return this.field_1835;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int hashCode() {
        return (this.field_1835 + this.mVisibility).hashCode();
    }

    public String toString() {
        return "CustomPropertyKey(" + this.field_1835 + "," + this.mVisibility + ")";
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1086.method_5625(this, var1, var2);
    }
}
